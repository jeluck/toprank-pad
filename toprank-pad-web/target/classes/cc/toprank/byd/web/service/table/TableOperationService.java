package cc.toprank.byd.web.service.table;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.BooleanUtil;
import cc.toprank.byd.common.utils.ObjectUtil;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.constant.TableOperation;
import cc.toprank.byd.entity.B_DinningTableInfoEntity;
import cc.toprank.byd.entity.B_DinningTableUseInfoEntity;
import cc.toprank.byd.entity.O_OrderInfoEntity;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.util.CollectionHelper;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.DinningTableInfoConstants;
import cc.toprank.byd.web.dto.SubOrderInfoVo;
import cc.toprank.byd.web.util.OrderUtil;
import cc.toprank.byd.web.vo.tablevo.TableMessageVO;
import cc.toprank.byd.web.vo.tablevo.TableRequestVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @version 2.0.0
 * @description： 操作桌台：联台、拼台、转台、拆台等
 * @author：LinYN
 * @date: 2017-3-24
 */
@Service("tableOperationService")
public class TableOperationService extends TableServiceBase implements TableOperation.Transfer, ParamConstants.OrderParam {

    // 日志打印
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());


    /**
     * 根据桌台编号和区域编号获取可以联合的桌台
     *
     * @param tableID 当前桌台编号
     * @return 可以联合的桌台
     * @author LinYN
     * @date 2017-3-22
     */
    public List<TableMessageVO> getCanCombineTables(Long tableID) {
        if (tableID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        B_DinningTableInfoEntity table = getTableInfoById(tableID);
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put(PARAM_TABLE_ID, tableID);
        queryParam.put(PARAM_ARCHIVE_ID, table.getArchiveID());
        return dinningTableInfoDao.getCanCombineTableInfos(queryParam);
    }

    /**
     * 联台：当前桌台与目标桌台（排除其他关联属性的桌台）都必须在使用状态，即均有主订单、子订单、餐次信息
     *
     * @param tableRequestVo#srcTableId     当前桌台ID
     * @param tableRequestVo#targetTableIds 目标桌台ID 列表，支持多选
     * @throws Exception 如果当前桌台不存在则抛异常，如果所有目标桌台都不存在则抛异常
     * @author LinYN
     * @date 2017-3-17
     */
    @Transactional(rollbackFor = Exception.class)
    public void combineTables(TableRequestVo tableRequestVo) throws Exception {
        Long srcTableId = tableRequestVo.getTableID();
        if (srcTableId == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> targetTableIds = tableRequestVo.getTargetTableIDs();
        if (CollectionUtils.isNotEmpty(targetTableIds))
            targetTableIds.remove(srcTableId);
        if (CollectionUtils.isEmpty(targetTableIds)) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        // 查询当前桌台，如果不存在则抛异常
        B_DinningTableInfoEntity srcTableInfo = getTableInfoById(srcTableId);
        List<B_DinningTableInfoEntity> targetTableInfos = getTableInfosByIds(targetTableIds); // 查询目标桌台列表
        if (CollectionUtils.isEmpty(targetTableInfos)) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        internalCombineTables(srcTableInfo, targetTableInfos);
    }

    /*
     * 联台：当前桌台与目标桌台（排除其他关联属性的桌台）都必须在使用状态，即均有主订单、子订单、餐次信息
     *
     * @param srcTableInfo     当前桌台
     * @param targetTableInfos 目标桌台列表
     * @throws Exception 如果当前桌台不存在则抛异常，如果所有目标桌台都不存在则抛异常
     * @author LinYN
     * @date 2017-3-17
     */
    private void internalCombineTables(B_DinningTableInfoEntity srcTableInfo, List<B_DinningTableInfoEntity> targetTableInfos) throws Exception {
        // 桌台是否使用中
        checkTableIsUsing(srcTableInfo);
        if (isSharingTable(srcTableInfo)) {
            throw new BizException(CodeMsgConstants.SHARING_TABLE_NOT_ALLOW_COMBINE, CodeMsgConstants.SHARING_TABLE_NOT_ALLOW_COMBINE_MSG, getDisplayTableName(srcTableInfo));
        }
        for (B_DinningTableInfoEntity targetTableInfo : targetTableInfos) {
            checkTableIsUsing(targetTableInfo);
            if (isCombineTable(targetTableInfo)) {
                throw new BizException(CodeMsgConstants.TABLE_IS_COMBINNING, CodeMsgConstants.TABLE_IS_COMBINNING_MSG, getDisplayTableName(targetTableInfo));
            }
            if (BooleanUtil.isFalse(targetTableInfo.getCanCombine())) {
                throw new BizException(CodeMsgConstants.TABLE_CAN_NOT_COMBINNING, CodeMsgConstants.TABLE_CAN_NOT_COMBINNING_MSG, getDisplayTableName(targetTableInfo));
            }
            if (isSharingTable(targetTableInfo)) {
                throw new BizException(CodeMsgConstants.SHARING_TABLE_NOT_ALLOW_COMBINE, CodeMsgConstants.SHARING_TABLE_NOT_ALLOW_COMBINE_MSG, getDisplayTableName(targetTableInfo));
            }
        }
        Set<Long> targetTableIDs = CollectionHelper.collect(targetTableInfos, (targetTableInfo) -> targetTableInfo.getTableID());
        List<O_SubOrderInfoEntity> targetTableSubOrderInfos = getSubOrderInfosByTableIDs(targetTableIDs);
        // 关联桌台的ID
        Set<Long> combinedTableIDs = getCombinedTableIDs(srcTableInfo);
        combinedTableIDs.add(srcTableInfo.getTableID());
        combinedTableIDs.addAll(targetTableIDs);
        String tableIDsParam = StringUtils.join(combinedTableIDs, ParamConstants.GlobalParam.PARAM_SEPARATOR);
        // --------------------  处理订单 -------------------- //
        if (CollectionUtils.isNotEmpty(targetTableSubOrderInfos)) {
            Long newOrderID = combineOrderInfo2SrcTable(srcTableInfo, targetTableSubOrderInfos);
            // 修改目标桌台主订单状态为完成，子订单关联新的主订单ID
            Map<String, Object> updateSubOrderParam = new HashedMap(2);
            updateSubOrderParam.put(PARAM_TABLE_IDS, tableIDsParam);
            updateSubOrderParam.put(PARAM_NEW_ORDER_ID, newOrderID);
            subOrderInfoDao.combineSubOrder2NewOrder(updateSubOrderParam);
        }
        // --------------------  处理订单 END -------------------- //
        String combineTableName = getCombineTableName(srcTableInfo);
        int srcCombineNumber = NumberUtil.intValue(srcTableInfo.getCombineNumber());
        srcCombineNumber = (srcCombineNumber == 0 ? 1 : srcCombineNumber);
        int combineNumber = srcCombineNumber + targetTableInfos.size();

        Map<String, Object> updateCombineInfoParam = new HashedMap();
        updateCombineInfoParam.put(PARAM_COMBINE_NAME, combineTableName);
        updateCombineInfoParam.put(PARAM_COMBINE_NUMBER, combineNumber);
        updateCombineInfoParam.put(PARAM_TABLE_IDS, tableIDsParam);
        dinningTableInfoDao.updateCombineInfoByTableIDs(updateCombineInfoParam);
        // 查询当前桌台和目标桌台的餐次桌台信息，修改桌台名称，状态，并标上联合属性
        updateCombineInfoParam.put(PARAM_IS_COMBINE, true);
        updateCombineInfoParam.put(PARAM_COMBINE_NUMBER, combineNumber);
        mealTableMappingDao.updateCombineInfoByTableIDs(updateCombineInfoParam);
    }

    /*
     * 处理联台的订单
     *
     * @param srcTableInfo 桌台信息
     * @param targetTableSubOrderInfos 目标桌台的子订单信息
     *
     * @author LinYN
     * @date 2017-4-7
     */
    private Long combineOrderInfo2SrcTable(B_DinningTableInfoEntity srcTableInfo, List<O_SubOrderInfoEntity> targetTableSubOrderInfos) throws IllegalAccessException, InvocationTargetException {
        Long newOrderID = null;
        O_SubOrderInfoEntity srcTableSubOrderInfo = getFirstSubOrderInfoByTableInfo(srcTableInfo);
        O_OrderInfoEntity orderInfoQueryParam = new O_OrderInfoEntity();
        orderInfoQueryParam.setOrderID(srcTableSubOrderInfo.getOrderID());
        O_OrderInfoEntity orderInfo = orderInfoDao.get(orderInfoQueryParam);
        if (orderInfo == null) {
            throw new BizException(CodeMsgConstants.TABLE_ORDER_DISABLED, CodeMsgConstants.TABLE_ORDER_DISABLED_MSG);
        }
        if (!(OrderManageEnum.OrderStatus.HAVEINHAND.getValue() ==orderInfo.getOrderStatus() || OrderManageEnum.OrderStatus.NOORDER.getValue()==orderInfo.getOrderStatus())) {
            throw new BizException(CodeMsgConstants.TABLE_ORDER_DISABLED, CodeMsgConstants.TABLE_ORDER_DISABLED_MSG, getDisplayTableName(srcTableInfo));
        }
        // 统计子订单信息：金额、人数、商品数量
        O_SubOrderInfoEntity subOrderInfoSummary = calculateSubOrderInfo(targetTableSubOrderInfos);
        O_SubOrderInfoEntity orderInfoSummary = addSubOrderInfoSummary4OrderInfo(orderInfo, subOrderInfoSummary);
        // 判断当前桌台是否联台
        if (isCombineTable(srcTableInfo)) {
            // 当前桌台的主订单修改人数、金额
            newOrderID = saveOrUpdateOrderInfo(orderInfo, orderInfoSummary);
        } else {
            // 如果当前桌台不是联台，则生成一个新的主订单
            O_OrderInfoEntity newOrderInfo = new O_OrderInfoEntity();
            BeanUtils.copyProperties(newOrderInfo, orderInfo);
            newOrderInfo.setOrderID(null);
            // 修改并保存主订单，新的主订单状态改成使用中
            newOrderID = saveOrUpdateOrderInfo(newOrderInfo, orderInfoSummary);
            // 将当前桌台的主订单状态改成完结
            orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.COMPLETED.getValue());//订单状态
            orderInfoDao.update(orderInfo);
        }
        return newOrderID;
    }


    /**
     * 通过某个联台的ID 查询与之关联的桌台
     *
     * @param combineTableId 某个联台的ID
     * @return 关联的桌台
     * @author LinYN
     * @date 2017-3-22
     */
    public List<TableMessageVO> getCanSplitTables(Long combineTableId) {
        return getCombinedTables(combineTableId);
    }

    /**
     * 拆台：当前桌台必须是联台，拆台后取消桌台之间的关联关系
     *
     * @param tableRequestVo#targetTableIds 需要拆台的桌台ID
     * @param tableRequestVo#combine        拆出来的桌台是否再次联合 <code>true</code>：联合，<code>false</code>：不联合
     * @throws Exception 如果当前桌台不存在或不是联台则抛异常
     * @author LinYN
     * @date 2017-3-22
     */
    @Transactional(rollbackFor = Exception.class)
    public void splitTables(TableRequestVo tableRequestVo) throws Exception {
        List<Long> targetTableIds = tableRequestVo.getTargetTableIDs();
        if (CollectionUtils.isEmpty(targetTableIds)) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<B_DinningTableInfoEntity> targetTableInfos = getTableInfosByIds(targetTableIds);
        if (CollectionUtils.isEmpty(targetTableInfos)) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        for (B_DinningTableInfoEntity targetTableInfo : targetTableInfos) {
            internalSplitTable(targetTableInfo, targetTableIds);
        }
        boolean useCombine = BooleanUtil.valueOf(tableRequestVo.getCombine());
        if (useCombine && targetTableInfos.size() > 1) {
            B_DinningTableInfoEntity srcTableInfo = targetTableInfos.remove(0);
            internalCombineTables(srcTableInfo, targetTableInfos);
        }
    }

    private void internalSplitTable(B_DinningTableInfoEntity targetTableInfo, List<Long> targetTableIds) throws Exception {
        if (!isCombineTable(targetTableInfo)) {
            throw new BizException(CodeMsgConstants.TABLE_IS_NOT_COMBINNING, CodeMsgConstants.TABLE_IS_NOT_COMBINNING_MSG, getDisplayTableName(targetTableInfo));
        }
        // -------------------- 修改拆分桌台的信息 --------------------
        targetTableInfo.setCombineName(null);
        targetTableInfo.setCombineCode(null);
        targetTableInfo.setCombineNumber(1);
        dinningTableInfoDao.update(targetTableInfo);
        // -------------------- 修改拆分桌台的子订单 --------------------
        splitSubOrderInfoOfTable(targetTableInfo.getTableID());
        // -------------------- 修改拆分桌台的餐次信息 --------------------
        updateMealTableMappingByTableInfo(targetTableInfo);
        updateRemainedTableAfterSplit(targetTableInfo, targetTableIds);

    }

    /*
    * 修改拆台后剩余桌台的信息和订单信息
    *
    * @param tableInfo 桌台
    * @param tableID 桌台ID
    *
    * @author LinYN
    * @date 2017-5-22
    */
    private void updateRemainedTableAfterSplit(B_DinningTableInfoEntity tableInfo, List<Long> splitTableIDs) throws Exception {
        // 通过某个联台的ID 查询与之关联的桌台
        List<TableMessageVO> tableMessages = getCanSplitTables(tableInfo.getTableID());
        // 没有被选择的桌台ID
        List<Long> remainTableIds = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(tableMessages)) {
            for (TableMessageVO tableMessage : tableMessages) {
                Long tableID = tableMessage.getTableID();
                if (!splitTableIDs.contains(tableID))
                    remainTableIds.add(tableID);
            }
        }
        if (remainTableIds.size() == 0) {
            return; // 选择了所有桌台
        }
        // -------------------- 修改未选择桌台的信息 --------------------
        if (remainTableIds.size() == 1) {
            Long remainTableId = remainTableIds.get(0);
            B_DinningTableInfoEntity remainTableInfo = getTableInfoById(remainTableId);
            if (!isCombineTable(remainTableInfo)) // 不是联台则不处理
                return;
            // 拆分后如果联台中只剩下一个桌台，那么还要取消此桌台的联合属性
            remainTableInfo.setCombineName(null);
            remainTableInfo.setCombineCode(null);
            remainTableInfo.setCombineNumber(1);
            dinningTableInfoDao.update(remainTableInfo);
            // 修改拆分桌台的餐次信息中的联台名称、关联属性
            updateMealTableMappingByTableInfo(remainTableInfo);
            // -------------------- 修改拆分桌台的主订单 --------------------
            O_OrderInfoEntity srcOrderInfo = splitSubOrderInfoOfTable(remainTableId);
            if (srcOrderInfo == null) return; // 此桌台未下单
            if (OrderManageEnum.OrderStatus.COMPLETED.getValue() != srcOrderInfo.getOrderStatus()) {
                srcOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.COMPLETED.getValue());
                orderInfoDao.update(srcOrderInfo);
            }
        } else {
            // 还有两个以上桌台未选择拆分，则需要修改主订单的数据：金额，人数
            List<B_DinningTableInfoEntity> remainTableInfos = getTableInfosByIds(remainTableIds);
            if (CollectionUtils.isEmpty(remainTableInfos)) {
                throw new BizException(CodeMsgConstants.TABLE_INFO_NOT_EXIST, CodeMsgConstants.TABLE_INFO_NOT_EXIST_MSG);
            }
            List<O_SubOrderInfoEntity> remainTableSubOrderInfos = getSubOrderInfosByTableIDs(CollectionHelper.collect(remainTableIds, (remainTableId) -> remainTableId));
            if (CollectionUtils.isEmpty(remainTableSubOrderInfos)) return;
            O_SubOrderInfoEntity remainSubOrderSummary = calculateSubOrderInfo(remainTableSubOrderInfos);
            // 查询当前桌台的主订单
            O_OrderInfoEntity orderInfoQueryParam = new O_OrderInfoEntity();
            orderInfoQueryParam.setOrderID(remainTableSubOrderInfos.get(0).getOrderID());
            O_OrderInfoEntity orderInfo = orderInfoDao.get(orderInfoQueryParam);
            if (orderInfo == null) {
                throw new BizException(CodeMsgConstants.TABLE_ORDER_DISABLED, CodeMsgConstants.TABLE_ORDER_DISABLED_MSG);
            }
            saveOrUpdateOrderInfo(orderInfo, remainSubOrderSummary);
            // -------------------- 修改未选择桌台的信息：联台数量 --------------------
            String combineTableName = getCombineTableName(remainTableInfos.get(0));
            int remainCombineNumber = remainTableInfos.size();
            Map<String, Object> updateCombineInfoParam = new HashedMap();
            updateCombineInfoParam.put(PARAM_COMBINE_NAME, combineTableName);
            updateCombineInfoParam.put(PARAM_COMBINE_NUMBER, remainCombineNumber);
            updateCombineInfoParam.put(PARAM_TABLE_IDS, StringUtils.join(remainTableIds, ParamConstants.GlobalParam.PARAM_SEPARATOR));
            dinningTableInfoDao.updateCombineInfoByTableIDs(updateCombineInfoParam);
            // 查询当前桌台和目标桌台的餐次桌台信息，修改联合属性
            updateCombineInfoParam.put(PARAM_IS_COMBINE, true);
            updateCombineInfoParam.put(PARAM_CUSTOMER_NUMBER, remainSubOrderSummary.getPeopleNum());
            mealTableMappingDao.updateCombineInfoByTableIDs(updateCombineInfoParam);

        }
    }

    /*
     * 根据桌台ID 拆分桌台的所有子订单， 返回主订单
     *
     * @param tableID 桌台ID
     * @return 主订单
     *
     * @author LinYN
     * @date 2017-3-23
     */
    private O_OrderInfoEntity splitSubOrderInfoOfTable(Long tableId) throws Exception {
        List<O_SubOrderInfoEntity> tableSubOrderInfos = getSubOrderInfoByTableId(tableId);
        if (CollectionUtils.isEmpty(tableSubOrderInfos)) return null;
        // 查询当前桌台的主订单
        O_OrderInfoEntity orderInfoQueryParam = new O_OrderInfoEntity();
        orderInfoQueryParam.setOrderID(tableSubOrderInfos.get(0).getOrderID());
        O_OrderInfoEntity orderInfo = orderInfoDao.get(orderInfoQueryParam);
        if (orderInfo == null) {
            logger.error("找不到主订单：{0}，所在桌台ID：{1}", tableSubOrderInfos.get(0).getOrderID(), tableId);
            throw new BizException(CodeMsgConstants.TABLE_ORDER_DISABLED, CodeMsgConstants.TABLE_ORDER_DISABLED_MSG);
        }
        for (O_SubOrderInfoEntity tableSubOrderInfo : tableSubOrderInfos) {
            // 生成一个新的主订单
            Long newOrderId = createNewOrderInfo(orderInfo, tableSubOrderInfo);
            tableSubOrderInfo.setOrderID(newOrderId);
            subOrderInfoDao.update(tableSubOrderInfo);
        }
        return orderInfo;
    }


    /*
     * 根据原主订单和子订单创建新的主订单
     *
     * @param orderInfo 原主订单
     * @param subOrderInfoSummary 订单统计信息 （人数、金额、商品数量）
     * @return 新的主订单ID
     * @throws Exception
     *
     * @author LinYN
     * @date 2017-3-23
     */
    private Long createNewOrderInfo(O_OrderInfoEntity orderInfo, O_SubOrderInfoEntity subOrderInfoSummary) throws Exception {
        O_OrderInfoEntity newOrderInfo = new O_OrderInfoEntity();
        BeanUtils.copyProperties(newOrderInfo, orderInfo);
        newOrderInfo.setOrderID(null);
        newOrderInfo.setOrderCode(OrderUtil.getOrderCode());
        // 修改并保存主订单，新的主订单状态改成使用中
        Long newOrderId = saveOrUpdateOrderInfo(newOrderInfo, subOrderInfoSummary);
        if (newOrderId == null) {
            throw new BizException(CodeMsgConstants.CREATE_TABLE_ORDER_ERROR, CodeMsgConstants.CREATE_TABLE_ORDER_ERROR_MSG);
        }
        return newOrderId;
    }

    /**
     * 根据机构编号获取可以转台的桌台
     *
     * @param tableID 桌台编号
     * @return 可以联合的桌台
     * @author LinYN
     * @date 2017-3-22
     */
    public List<TableMessageVO> getCanTransferTables(Long tableID) {
        if (tableID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        B_DinningTableInfoEntity table = getTableInfoById(tableID);
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put(PARAM_TABLE_ID, tableID);
        queryParam.put(PARAM_ARCHIVE_ID, table.getArchiveID());
        queryParam.put(PARAM_IS_SHARING, isSharingTable(table));
        return dinningTableInfoDao.getCanTransferTableInfos(queryParam);
    }

    /**
     * 根据桌台编号获取订单状态为进行中的子订单信息
     *
     * @param tableId 桌台编号
     * @return 订单状态为进行中的子订单信息
     * @author LinYN
     * @date 2017-3-28
     */
    public List<SubOrderInfoVo> getSubOrderByTableId(Long tableId) {
        return subOrderInfoDao.getSubOrderInfoVOByTableIDAndOrderStatus(tableId);
    }

    /**
     * 转台
     *
     * @param tableRequestVo#srcTableId     需要转的桌台（源桌台），转了之后是脏台
     * @param tableRequestVo#targetTableId  目标桌台：空台、使用中，
     * @param tableRequestVo#way            转台方式：1-空台、2-拼台、3-联台
     * @param tableRequestVo#subOrderInfoId 转台方式选择 3-合台 时用到此参数，存放拼台的子订单ID
     */
    @Transactional(rollbackFor = Exception.class)
    public void transferTable(TableRequestVo tableRequestVo) throws Exception {
        Long srcTableId = tableRequestVo.getTableID();
        Long targetTableId = tableRequestVo.getTargetTableID();
        B_DinningTableInfoEntity srcTableInfo = getTableInfoById(srcTableId);
        B_DinningTableInfoEntity targetTableInfo = getTableInfoById(targetTableId);
        // 判断当前桌台是否开台或下单
        checkTableIsUsing(srcTableInfo);
        Long subOrderInfoID = tableRequestVo.getSubOrderID();
        Long targetSubOrderInfoID = tableRequestVo.getTargetSubOrderID();
        int way = NumberUtil.intValue(tableRequestVo.getTransferType());
        switch (way) {
            case EMPTY_WAY:
                transferToEmptyTable(srcTableInfo, subOrderInfoID, targetTableInfo);
                break;
            case SHARE_WAY:
                transferToShareTable(srcTableInfo, subOrderInfoID, targetTableInfo);
                break;
            case COMBINE_WAY:
                transferToCombineTable(srcTableInfo, subOrderInfoID, targetTableInfo, targetSubOrderInfoID);
                break;
            default:
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
    }

    /*
     * 将当前桌台转到空台
     *
     * @param srcTableInfo 当前桌台
     * @param targetTableInfo 目标桌台：空台
     * @throws Exception
     *
     * @author LinYN
     * @date 2017-3-24
     */
    private void transferToEmptyTable(B_DinningTableInfoEntity srcTableInfo, Long subOrderInfoID, B_DinningTableInfoEntity targetTableInfo) throws Exception {
        Long targetTableStatus = targetTableInfo.getTableStatus();
        if (MerchantManageEnum.TableStatus.EMPTYTABLE.getValue() != targetTableStatus) {
            throw new BizException(CodeMsgConstants.TABLE_IS_NOT_EMPTY, CodeMsgConstants.TABLE_IS_NOT_EMPTY_MSG, getDisplayTableName(targetTableInfo));// 不是空台，参数错误
        }
        if (isSharingTable(targetTableInfo)) {
            throw new BizException(CodeMsgConstants.TABLE_IS_SHARING, CodeMsgConstants.TABLE_IS_SHARING_MSG, getDisplayTableName(targetTableInfo));
        }
        if (isCombineTable(targetTableInfo)) {
            throw new BizException(CodeMsgConstants.TABLE_IS_COMBINNING, CodeMsgConstants.TABLE_IS_COMBINNING_MSG, getDisplayTableName(targetTableInfo));
        }
        O_SubOrderInfoEntity subOrderInfo = getCurrentSubOrderInfo(srcTableInfo, subOrderInfoID);
        // 将当前桌台的子订单变成目标桌台的子订单
        subOrderInfo.setTableID(targetTableInfo.getTableID());
        subOrderInfo.setTableName(targetTableInfo.getTableName());
        subOrderInfoDao.update(subOrderInfo);
        // 目标桌台变为当前桌台状态
        targetTableInfo.setTableStatus(srcTableInfo.getTableStatus());
        targetTableInfo.setCombineName(srcTableInfo.getCombineName());
        targetTableInfo.setCombineNumber(srcTableInfo.getCombineNumber());
        targetTableInfo.setShareNumber(1);
        dinningTableInfoDao.update(targetTableInfo);
        //增加桌台使用信息
        B_DinningTableUseInfoEntity srcTableUseInfo = getTableUseInfoByTableId(srcTableInfo);
        B_DinningTableUseInfoEntity targetTableUserInfo = new B_DinningTableUseInfoEntity();
        BeanUtils.copyProperties(targetTableUserInfo, srcTableUseInfo);
        targetTableUserInfo.setTableID(targetTableInfo.getTableID());
        targetTableUserInfo.setHisID(MaxIDUtils.getID(B_DinningTableUseInfoEntity.class));
        dinningTableUseInfoDao.insertSelective(targetTableUserInfo);
        // 处理餐次桌台表信息记录
        updateMealTableMappingByTableInfo(targetTableInfo);
        // 修改当前桌台拼桌数量
        updateTableStatusAfterTransfer(srcTableInfo);
    }


    /*
     * 转台 + 转台方式：拼台
     *
     * @param srcTableInfo 当前桌台
     * @param targetTableInfo 目标桌台：拼台
     * @throws Exception
     *
     * @author LinYN
     * @date 2017-3-24
     */
    private void transferToShareTable(B_DinningTableInfoEntity srcTableInfo, Long subOrderInfoID, B_DinningTableInfoEntity targetTableInfo) throws Exception {
        if (isCombineTable(srcTableInfo)) {
            throw new BizException(CodeMsgConstants.COMBINED_TABLE_NOT_ALLOW_SHARING, CodeMsgConstants.COMBINED_TABLE_NOT_ALLOW_SHARING_MSG, getDisplayTableName(srcTableInfo));
        }
        if (isCombineTable(targetTableInfo)) {
            throw new BizException(CodeMsgConstants.COMBINED_TABLE_NOT_ALLOW_SHARING, CodeMsgConstants.COMBINED_TABLE_NOT_ALLOW_SHARING_MSG, getDisplayTableName(targetTableInfo));
        }
        checkTableIsUsing(targetTableInfo);
        //将当前桌台子订单表记录变为目标桌台的子订单表记录, 主订单不变
        // 修改子订单桌台名称　拼 + <序号>
        List<O_SubOrderInfoEntity> targetSubOrderInfos = getSubOrderInfoByTableInfo(targetTableInfo);
        if (CollectionUtils.isEmpty(targetSubOrderInfos)) {
            throw new BizException(CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST, CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST_MSG, getDisplayTableName(targetTableInfo));
        }
        int shareTableLastIndex = getShareTableNextIndex(targetTableInfo); // 最后一个拼桌序号加一
        O_SubOrderInfoEntity subOrderInfo = getCurrentSubOrderInfo(srcTableInfo, subOrderInfoID);
        // 在目标桌台创建一个与当前桌台的子订单相同的子订单
        O_SubOrderInfoEntity newTargetSubOrderInfo = new O_SubOrderInfoEntity();
        BeanUtils.copyProperties(newTargetSubOrderInfo, subOrderInfo);
        newTargetSubOrderInfo.setSubOrderID(null);
        newTargetSubOrderInfo.setTableID(targetTableInfo.getTableID());
        newTargetSubOrderInfo.setTableName(DinningTableInfoConstants.FIGHTTABLENAME + shareTableLastIndex);
        subOrderInfoDao.save(newTargetSubOrderInfo);
        // 修改订单明细
        changeOrderDetailSubOrderID(subOrderInfo.getSubOrderID(), newTargetSubOrderInfo.getSubOrderID());
        // 将当前桌台的子订单状态设为己支付
        subOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.ALREADYPAID.getValue());
        subOrderInfoDao.update(subOrderInfo);
        // 修改目标桌台表拼桌数量
        targetTableInfo.setShareNumber(NumberUtil.add(targetTableInfo.getShareNumber(), 1));
        dinningTableInfoDao.update(targetTableInfo);
        updateMealTableMappingByTableInfo(targetTableInfo);
        // 修改当前桌台拼桌数量
        updateTableStatusAfterTransfer(srcTableInfo);


    }

    /*
     * 合并当前桌台的子订单到目标子订单中，当前桌台的子订单完成
     *
     * @param tableInfo 当前桌台
     * @param targetSubOrderInfo 目标桌台子订单
     *
     * @author LinYN
     * @date 2017-3-31
     */
    private O_SubOrderInfoEntity combineSubOrderInfos2TargetTable(O_SubOrderInfoEntity srcSubOrderInfo, O_SubOrderInfoEntity targetSubOrderInfo) {
        // 全并两个子订单到一个子订单中：人数、金额、商品数量
        List<O_SubOrderInfoEntity> targetSubOrderInfoList = new ArrayList<>(2);
        targetSubOrderInfoList.add(targetSubOrderInfo);
        targetSubOrderInfoList.add(srcSubOrderInfo);
        O_SubOrderInfoEntity targetSubOrderInfoSummary = calculateSubOrderInfo(targetSubOrderInfoList);
        // 更新目标子订单数据
        targetSubOrderInfo.setPeopleNum(targetSubOrderInfoSummary.getPeopleNum());//就餐人数
        targetSubOrderInfo.setQuantity(targetSubOrderInfoSummary.getQuantity());
        targetSubOrderInfo.setTotalAmount(targetSubOrderInfoSummary.getTotalAmount());
        targetSubOrderInfo.setDiscountAmount(targetSubOrderInfoSummary.getDiscountAmount());
        targetSubOrderInfo.setPendingAmount(targetSubOrderInfoSummary.getPendingAmount());
        targetSubOrderInfo.setActualAmount(targetSubOrderInfoSummary.getActualAmount());
        if (targetSubOrderInfo.getSubOrderID() == null) {
            subOrderInfoDao.save(targetSubOrderInfo);
        } else {
            subOrderInfoDao.update(targetSubOrderInfo);
        }
        return targetSubOrderInfo;
    }


    /*
     * 转台 + 转台方式：合台
     *
     * @param srcTableInfo 当前桌台
     * @param targetTableInfo 目标桌台：联台
     * @throws Exception
     *
     * @author LinYN
     * @date 2017-3-24
     */
    private void transferToCombineTable(B_DinningTableInfoEntity srcTableInfo, Long subOrderInfoID, B_DinningTableInfoEntity targetTableInfo, Long targetSubOrderInfoID) throws Exception {
        checkTableIsUsing(targetTableInfo);
        if (isSharingTable(srcTableInfo) && isCombineTable(targetTableInfo)) {
            throw new BizException(CodeMsgConstants.TABLE_IS_COMBINNING, CodeMsgConstants.TABLE_IS_COMBINNING_MSG, getDisplayTableName(targetTableInfo));
        }
        O_SubOrderInfoEntity targetSubOrderInfo = getCurrentSubOrderInfo(targetTableInfo, targetSubOrderInfoID);
        if (ObjectUtil.equals(OrderManageEnum.OrderStatus.WAITINGPAY.getValue(), targetSubOrderInfo.getOrderStatus())
                || ObjectUtil.equals(OrderManageEnum.OrderStatus.TOBECHECKED.getValue(), targetSubOrderInfo.getOrderStatus())) {
            throw new BizException(CodeMsgConstants.TABLE_IS_STOPPED, CodeMsgConstants.TABLE_IS_STOPPED_MSG, getDisplayTableName(targetTableInfo));
        }
        // 获取当前桌台的子订单
        O_SubOrderInfoEntity srcSubOrderInfo = getCurrentSubOrderInfo(srcTableInfo, subOrderInfoID);
        if (srcSubOrderInfo.getOrderID().equals(targetSubOrderInfo.getOrderID())) {
            throw new BizException(CodeMsgConstants.TABLES_ARE_COMBINED_ERROR, CodeMsgConstants.TABLES_ARE_COMBINED_ERROR_MSG);
        }
        if (ObjectUtil.equals(OrderManageEnum.OrderStatus.WAITINGPAY.getValue(), srcSubOrderInfo.getOrderStatus())
                || ObjectUtil.equals(OrderManageEnum.OrderStatus.TOBECHECKED.getValue(), srcSubOrderInfo.getOrderStatus())) {
            throw new BizException(CodeMsgConstants.TABLE_IS_STOPPED, CodeMsgConstants.TABLE_IS_STOPPED_MSG, getDisplayTableName(srcTableInfo));
        }
        // 创建一个新的子订单
        O_SubOrderInfoEntity newTargetSubOrderInfo = new O_SubOrderInfoEntity();
        BeanUtils.copyProperties(newTargetSubOrderInfo, targetSubOrderInfo);
        newTargetSubOrderInfo.setSubOrderID(null);
        if (ObjectUtil.equals(OrderManageEnum.OrderStatus.HAVEINHAND.getValue(), srcSubOrderInfo.getOrderStatus())) {
            newTargetSubOrderInfo.setOrderStatus(srcSubOrderInfo.getOrderStatus());
        }
        // 全并两桌台的子订单，并将当前桌台的子订单状态改成己支付（脏台）
        newTargetSubOrderInfo = combineSubOrderInfos2TargetTable(srcSubOrderInfo, newTargetSubOrderInfo);
        Long newSubOrderID = newTargetSubOrderInfo.getSubOrderID();
        // 修改订单明细
        changeOrderDetailSubOrderID(srcSubOrderInfo.getSubOrderID(), newSubOrderID);
        changeOrderDetailSubOrderID(targetSubOrderInfo.getSubOrderID(), newSubOrderID);
        // 将原子订单完成
        targetSubOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.COMPLETED.getValue());
        subOrderInfoDao.update(targetSubOrderInfo);
        // 获取目标桌台的主订单，并更新：人数、金额、商品数量
        O_OrderInfoEntity orderInfoQueryParam = new O_OrderInfoEntity();
        orderInfoQueryParam.setOrderID(targetSubOrderInfo.getOrderID());
        O_OrderInfoEntity targetOrderInfo = orderInfoDao.get(orderInfoQueryParam);
        O_SubOrderInfoEntity orderInfoSummary = addSubOrderInfoSummary4OrderInfo(targetOrderInfo, srcSubOrderInfo);
        saveOrUpdateOrderInfo(targetOrderInfo, orderInfoSummary);
        // 修改主订单
        if (isCombineTable(srcTableInfo)) {
            // 如果是联台则需要修改剩余桌台的关联信息
            List<Long> splitTableIDs = new ArrayList<>();
            splitTableIDs.add(srcTableInfo.getTableID());
            updateRemainedTableAfterSplit(srcTableInfo, splitTableIDs);
        } else {
            // 处理当前桌台的主订单
            orderInfoQueryParam.setOrderID(srcSubOrderInfo.getOrderID());
            O_OrderInfoEntity srcOrderInfo = orderInfoDao.get(orderInfoQueryParam);
            // 将当前桌台的主订单状态改成完成
            srcOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.ALREADYPAID.getValue());
            orderInfoDao.update(srcOrderInfo);
        }
        srcSubOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.ALREADYPAID.getValue());
        subOrderInfoDao.update(srcSubOrderInfo);
        // 目标桌台变为当前桌台状态
        if (!isCombineTable(targetTableInfo)) {
            targetTableInfo.setCombineName(srcTableInfo.getCombineName());
            targetTableInfo.setCombineNumber(srcTableInfo.getCombineNumber());
        }
        if (ObjectUtil.equals(MerchantManageEnum.TableStatus.PLACEMAN.getValue(), srcTableInfo.getTableStatus())) {
            targetTableInfo.setTableStatus(srcTableInfo.getTableStatus());
        }
        dinningTableInfoDao.update(targetTableInfo);
        // 之前选中的桌台变为脏台
        updateTableStatusAfterTransfer(srcTableInfo);
        // 处理餐次桌台表信息记录
        updateMealTableMappingByTableInfo(srcTableInfo);
        updateMealTableMappingByTableInfo(targetTableInfo);
    }

    private void changeOrderDetailSubOrderID(Long subOrderID, Long newSubOrderID) {
        Map<String, Object> map = new HashMap<>();
        map.put(PARAM_SUB_ORDER_ID, subOrderID);
        map.put(PARAM_NEW_SUB_ORDER_ID, newSubOrderID);
        subOrderInfoDao.changeOrderDetailSubOrderID(map);
    }

    /*
     * 修改转台后源桌台的状态及拼桌数量，如果不是拼桌则将桌台改成脏台
     *
     * @param srcTableInfo 桌台
     *
     * @author LinYN
     * @date 2017-5-11
     **/
    private void updateTableStatusAfterTransfer(B_DinningTableInfoEntity srcTableInfo) throws Exception {
        srcTableInfo.setCombineName(null);
        srcTableInfo.setCombineNumber(1);
        int shareNumber = NumberUtil.intValue(srcTableInfo.getShareNumber()) - 1;
        if (shareNumber <= 0) {
            // 当前桌台变为脏台
            srcTableInfo.setTableStatus(MerchantManageEnum.TableStatus.DIRTYTABLE.getValue());
            B_DinningTableUseInfoEntity tableUseInfo = getTableUseInfoByTableId(srcTableInfo);
            tableUseInfo.setEndTime(LocalDateTime.now());
            dinningTableUseInfoDao.updateByPrimaryKeySelective(tableUseInfo);
        } else {
            srcTableInfo.setShareNumber(shareNumber);
        }
        dinningTableInfoDao.update(srcTableInfo);
        // 处理餐次桌台表信息记录
        updateMealTableMappingByTableInfo(srcTableInfo);
    }


    /**
     * 拼台 选中一个桌台新增拼桌桌台，不限制人数
     *
     * @param tableRequestVo#tableId     新增拼桌桌台（ID）
     * @param tableRequestVo#personCount 新增拼桌桌台（人数）
     * @param tableRequestVo#memo        新增拼桌桌台（备注）
     * @author LinYN
     * @date 2017-3-27
     **/
    @Transactional(rollbackFor = Exception.class)
    public void shareTable(TableRequestVo tableRequestVo) throws Exception {
        Integer customerNumber = tableRequestVo.getCustomerNumber();
        if (NumberUtil.intValue(customerNumber) < 1) {
            throw new BizException(CodeMsgConstants.OPEN_TABLE_CUSTOMER_NUMBER_ERROR, CodeMsgConstants.OPEN_TABLE_CUSTOMER_NUMBER_ERROR_MSG);
        }
        B_DinningTableInfoEntity tableInfo = getTableInfoById(tableRequestVo.getTableID());
        //判断该桌台可否拼桌
        if (BooleanUtil.isFalse(tableInfo.getCanSharing())) {
            throw new BizException(CodeMsgConstants.TABLE_CAN_NOT_SHARING, CodeMsgConstants.TABLE_CAN_NOT_SHARING_MSG, getDisplayTableName(tableInfo));
        }
        // 联台不允许拼台
        if (isCombineTable(tableInfo)) {
            throw new BizException(CodeMsgConstants.COMBINED_TABLE_NOT_ALLOW_SHARING, CodeMsgConstants.COMBINED_TABLE_NOT_ALLOW_SHARING_MSG, getDisplayTableName(tableInfo));
        }
        checkTableIsUsing(tableInfo);
        //查询主订单中是否存在子订单
        List<O_SubOrderInfoEntity> subOrderList = getSubOrderInfoByTableInfo(tableInfo);
        if (CollectionUtils.isEmpty(subOrderList)) {
            throw new BizException(CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST, CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST_MSG, getDisplayTableName(tableInfo));
        }
        //修改桌台信息
        tableInfo.setShareNumber(NumberUtil.add(tableInfo.getShareNumber(), 1));
        tableInfo.setPeopleNum(NumberUtil.add(tableInfo.getPeopleNum(), tableRequestVo.getCustomerNumber()));
        dinningTableInfoDao.update(tableInfo);
        //插入主订单
        tableRequestVo.setArchiveID(tableInfo.getArchiveID());
        O_OrderInfoEntity orderInfo = saveOrderInfoOfSharingTable(tableRequestVo);
        // 修改子订单中桌台的名称：拼 + <序号>
        updateSubOrderOfSharingTable(subOrderList, orderInfo, tableInfo);
        //修改餐次桌台为拼台
        updateMealTableMappingByTableInfo(tableInfo);
    }

    /*
    * 创建主订单
    *
    * @param tableRequestVo 请求参数（档案ID、人数、备注）
    * @param orderInfo 主订单，每个拼桌对应一个主订单
    *
    * @author LinYN
    * @date 2017-3-27
    */
    private O_OrderInfoEntity saveOrderInfoOfSharingTable(TableRequestVo tableRequestVo) {
        O_OrderInfoEntity orderInfo = new O_OrderInfoEntity();
        orderInfo.setArchiveID(tableRequestVo.getArchiveID());//档案ID
        orderInfo.setOrderChannel(MerchantManageEnum.OrderChannel.CASHREGISTER.getValue());//下单渠道(收银机)
        orderInfo.setPeopleNum(tableRequestVo.getCustomerNumber());//就餐人数
        orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.NOORDER.getValue());//订单状态
        String memo = tableRequestVo.getMemo();
        if (StringUtils.isNotBlank(memo)) {
            orderInfo.setOrderDesc(memo);//订单描述
            orderInfo.setMemo(memo);//备注
        }
        orderInfo.setActualAmount(new BigDecimal(0));
        orderInfo.setTotalAmount(new BigDecimal(0));
        orderInfo.setQuantity(0);
        orderInfo.setCreatorID(tableRequestVo.getLoginID());
        orderInfoDao.saveOrderInfoEntity(orderInfo);
        return orderInfo;
    }


    /*
    * 修改子订单中桌台的名称：拼 + <序号>
    *
    * @param subOrderList 子订单列表
    * @param orderInfo 主订单，每个拼桌对应一个主订单
    * @param tableInfo 桌台
    * @throws Exception 更新子订单失败
    *
    * @author LinYN
    * @date 2017-3-27
    */
    private void updateSubOrderOfSharingTable(List<O_SubOrderInfoEntity> subOrderList, O_OrderInfoEntity orderInfo, B_DinningTableInfoEntity tableInfo) {
        //当前拼桌次数
        int shareTableLastIndex = getShareTableNextIndex(tableInfo);
        //插入子订单
        O_SubOrderInfoEntity subOrderInfo = new O_SubOrderInfoEntity();
        subOrderInfo.setOrderID(orderInfo.getOrderID());//订单id
        subOrderInfo.setPeopleNum(orderInfo.getPeopleNum());//就餐人数
        subOrderInfo.setMemo(orderInfo.getMemo());//备注
        subOrderInfo.setMealsID(getCurrentMealsInfoOfTable(tableInfo).getMealsID());//餐次id
        subOrderInfo.setTableID(tableInfo.getTableID());//桌台id
        subOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.NOORDER.getValue());
        subOrderInfo.setTableName(DinningTableInfoConstants.FIGHTTABLENAME + shareTableLastIndex);//桌台名称
        subOrderInfo.setActualAmount(new BigDecimal(0));
        subOrderInfo.setTotalAmount(new BigDecimal(0));
        subOrderInfo.setCreatorID(orderInfo.getCreatorID());
        subOrderInfo.setQuantity(0);
        subOrderInfoDao.saveSubOrderInfo(subOrderInfo);//新拼的桌台插入子订单
    }

    /*
     * 获取拼桌序号
     *
     * @param subOrderList 子订单列表
     * @throws Exception 更新子订单失败
     *
     * @author LinYN
     * @date 2017-5-26
     */
    private int getShareTableNextIndex(B_DinningTableInfoEntity tableInfo) {
        return getShareTableNextIndex(getRelationSubOrderInfoByTableID(tableInfo.getTableID()));
    }

    /*
     * 获取拼桌序号
     *
     * @param subOrderList 子订单列表
     * @throws Exception 更新子订单失败
     *
     * @author LinYN
     * @date 2017-4-7
     */
    private int getShareTableNextIndex(List<O_SubOrderInfoEntity> subOrderList) {
        //当前拼桌次数
        int shareTableNextIndex = 1;
        //第一次拼台需要修改第一个子订单桌台名称,不是第一次拼桌就获取当前是第几次拼桌
        int subOrderCount = subOrderList.size();
        if (subOrderCount > 1) {
            //根据取出最后一个子订单拼桌后的桌台名称，获取拼桌次数
            String shareTableName= subOrderList.get(subOrderCount - 1).getTableName();
            if (StringUtils.isNotEmpty(shareTableName) && shareTableName.startsWith(DinningTableInfoConstants.FIGHTTABLENAME)) {
                shareTableNextIndex = ObjectUtil.objectToInteger(shareTableName.substring(DinningTableInfoConstants.FIGHTTABLENAME.length()), subOrderCount) + 1;
            } else {
                shareTableNextIndex = subOrderCount;
            }
        }
        return shareTableNextIndex;
    }
}
