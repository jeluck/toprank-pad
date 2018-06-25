package cc.toprank.byd.web.service.table;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.ObjectUtil;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.dao.O_BookingInfoDao;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.DinningTableInfoConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.dto.SubOrderInfoVo;
import cc.toprank.byd.web.service.booking.O_BookingInfoService;
import cc.toprank.byd.web.vo.tablevo.DinningTableInfoVO;
import cc.toprank.byd.web.vo.tablevo.TableMessageVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   B_AttachmentInfoService 真实的业务实现类，允许修改
 *@author ZhouWei
 * @version 2.0.0
 * ********************************************************************************************************************/
@Service("b_DinningTableInfoService")
public class B_DinningTableInfoService extends TableServiceBase{
    @Autowired
    private O_BookingInfoDao bookingInfoDao;
    @Autowired
    private O_BookingInfoService bookingInfoService;

    //日志处理
    private static final Logger logger = Logger.getLogger(B_DinningTableInfoService.class.getName());


    public B_DinningTableInfoEntity get(B_DinningTableInfoEntity b_dinningtableinfo) throws Exception{
        return dinningTableInfoDao.get(b_dinningtableinfo);
    }

    public List<B_DinningTableInfoEntity> getAll() throws Exception{
        return dinningTableInfoDao.getAll();
    }

    public void update(B_DinningTableInfoEntity b_dinningtableinfo) throws Exception{
        dinningTableInfoDao.update(b_dinningtableinfo);
    }

    public void delete(B_DinningTableInfoEntity b_dinningtableinfo) throws Exception{
        dinningTableInfoDao.delete(b_dinningtableinfo);
    }

    public void save(B_DinningTableInfoEntity b_dinningtableinfo) throws Exception{
        dinningTableInfoDao.save(b_dinningtableinfo);
    }


    /**
     *@Description 桌台处理 消台
     * @param paramMap
     * @return
     * @throws Exception
     * @author zhouwei
     * @version 2.0.0
     * @time 2017-04-01
     */
    @Transactional(rollbackFor=Exception.class)
    public ResultData eliminateTable(Map<String,Object> paramMap) throws Exception{
        Map map = new HashMap<>();
        Map hashMap = new HashMap<>();
        Map relationMap = new HashMap();
        ResultData resultData = new ResultData();
        List<O_SubOrderInfoEntity> subOrderEntityList = new ArrayList<O_SubOrderInfoEntity>();
        map.put("tableID",paramMap.get("tableID"));
        map.put("orderStatus",OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
        String subOrderIDs = (String)paramMap.get("subOrderIDs");
        String tableIDs = (String)paramMap.get("tableIDs");
        Long tableID = ObjectUtil.objectToLong(paramMap.get("tableID"));
        String memo = (String)paramMap.get("memo");

        relationMap.put("tableID",tableID);
        relationMap.put("archiveID",paramMap.get("archiveID"));
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("tableID", tableID);
        //联桌集合
        List<TableMessageVO> tableMessageVoList = dinningTableInfoDao.getCanUnionTables(queryParam);

        //拼桌数量
        List<SubOrderInfoVo> subOrderInfoVoList = subOrderInfoDao.getSubOrderInfoVOByTableIDAndOrderStatus((Long)paramMap.get("tableID"));
        B_DinningTableInfoEntity dinningTable = getTableInfoById(tableID);
        //参数判断
        if(dinningTable.getCombineNumber()>1){
            if (tableIDs == null || tableIDs.isEmpty()) {
                throw new BizException(CodeMsgConstants.TABLE_IS_NOT_COMBINNING, CodeMsgConstants.TABLE_IS_NOT_COMBINNING_MSG,tableID);
            }
        }
        if (!dinningTable.getTableStatus().equals(MerchantManageEnum.TableStatus.PLACEMAN.getValue()) && !dinningTable.getTableStatus().equals(MerchantManageEnum.TableStatus.PLACEORDER.getValue())){
            throw new BizException(CodeMsgConstants.ELIMINATE_TABLE_FAIL, CodeMsgConstants.ELIMINATE_TABLE_FAIL_DATA_MSG);
        }
        getCombinedTableIDs(dinningTable);
        if(isSharingTable(dinningTable) && StringUtil.isEmpty(subOrderIDs)){//拼桌才有
            throw new BizException(CodeMsgConstants.TABLE_IS_NOT_SHARING, CodeMsgConstants.TABLE_IS_NOT_SHARING_MSG,tableID);
        }
        map.put("subOrderIDs",subOrderIDs);

        if(StringUtils.isNotEmpty(tableIDs)){//联桌才有
            hashMap.put("tableIDs",tableIDs);
            hashMap.put("orderStatus",OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
            //查询关联桌的所有子订单
            subOrderEntityList= subOrderInfoDao.Get_ReceptionO_SubOrderInfoEntityByTableIDsAndTableName(hashMap);
        }else{
            hashMap.put("tableIDs","");
        }
        //查询正在进行的子订单表
        List<O_SubOrderInfoEntity> subOrderEntity = subOrderInfoDao.Get_ReceptionO_SubOrderInfoEntityByTableIDAndTableName(map);
        if(CollectionUtils.isEmpty(tableMessageVoList) && CollectionUtils.isEmpty(subOrderEntity)){
            //没有子订单，单纯的开台（桌台信息表、桌台使用信息表、餐次桌台标）
            //修改桌台信息表
            dinningTable.setTableStatus(MerchantManageEnum.TableStatus.DIRTYTABLE.getValue());
            dinningTable.setCombineName(null);
            dinningTable.setCombineNumber(0);
            dinningTable.setShareNumber(0);
            dinningTableInfoDao.update(dinningTable);
            //有餐次桌台信息就修改餐次桌台信息
            updateMealTableMappingByTableInfo(dinningTable);
            //修改桌台使用信息表
            B_DinningTableUseInfoEntity useTable = getTableUseInfoByTableId(dinningTable);
            useTable.setEndTime(LocalDateTime.now());
            dinningTableUseInfoDao.updateByTableID(useTable);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            return resultData;
        }else if ((CollectionUtils.isEmpty(tableMessageVoList)) && (CollectionUtils.isNotEmpty(subOrderInfoVoList) && subOrderInfoVoList.size()>1)  && (StringUtil.isNotEmpty(subOrderIDs))){
            //拼桌、有子订单、订单金额为0
            //子订单移除(订单状态为已完成)
            Integer PeopleNum = 0;
            for (O_SubOrderInfoEntity entity:subOrderEntity) {
                entity.setOrderStatus(OrderManageEnum.OrderStatus.ALREADYPAID.getValue());
                entity.setIsSync(true);
                if (entity.getSubOrderDesc() == null || ("").equals(entity.getSubOrderDesc())){
                    entity.setSubOrderDesc(" 消台原因:"+memo);
                }else {
                    entity.setSubOrderDesc(entity.getSubOrderDesc()+" 消台原因:"+memo);
                }
                PeopleNum +=entity.getPeopleNum();
                entity.setPeopleNum(0);
//                if (entity.getbTableName() == null || !entity.getbTableName().startsWith(DinningTableInfoConstants.FIGHTTABLENAME)){
//                    dinningTable.setTableStatus(MerchantManageEnum.TableStatus.DIRTYTABLE.getValue());
//                }
                subOrderInfoDao.update(entity);
                //更新主订单状态
                O_OrderInfoEntity orderInfoEntity = new O_OrderInfoEntity();
                orderInfoEntity.setOrderID(entity.getOrderID());
                orderInfoEntity = orderInfoDao.get(orderInfoEntity);
                orderInfoEntity.setOrderStatus(OrderManageEnum.OrderStatus.ALREADYPAID.getValue());
                if (orderInfoEntity.getPeopleNum() == null || orderInfoEntity.getPeopleNum() - PeopleNum <0){
                    orderInfoEntity.setPeopleNum(0);
                }else{
                    orderInfoEntity.setPeopleNum(orderInfoEntity.getPeopleNum() - PeopleNum);
                }
                orderInfoDao.update(orderInfoEntity);
            }
            //桌台信息表拼桌数量-1
            dinningTable.setShareNumber(dinningTable.getShareNumber()-subOrderEntity.size());
            dinningTable.setCombineName(null);
            dinningTable.setCombineNumber(0);
            dinningTableInfoDao.update(dinningTable);
            //桌台使用信息表人数的更改
            B_DinningTableUseInfoEntity useTable = getTableUseInfoByTableId(dinningTable);
            if(CollectionUtils.isNotEmpty(subOrderInfoVoList) && subOrderInfoVoList.size() >1){
                if (useTable!=null && useTable.getCustomerNumber()!=null && useTable.getCustomerNumber()-PeopleNum>=0){
                    useTable.setCustomerNumber(useTable.getCustomerNumber()-PeopleNum);
                }else{
                    useTable.setCustomerNumber(0);
                }
            }else{
                useTable.setEndTime(LocalDateTime.now());
            }
            dinningTableUseInfoDao.updateByTableID(useTable);
            //餐次桌台表拼桌数量-1  有餐次桌台信息就修改餐次桌台信息
            updateMealTableMappingByTableInfo(dinningTable);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            return resultData;
        }else if((CollectionUtils.isEmpty(tableMessageVoList)) && (CollectionUtils.isNotEmpty(subOrderInfoVoList) && subOrderInfoVoList.size() == 1) && (subOrderEntity.get(0).getActualAmount() == null || subOrderEntity.get(0).getActualAmount().doubleValue() == 0)){
            //加台、有子订单、订单金额为0
            //子订单移除(订单状态为已完成)
            for (O_SubOrderInfoEntity o_subOrderInfoEntity: subOrderEntity) {
                o_subOrderInfoEntity.setOrderStatus(OrderManageEnum.OrderStatus.ALREADYPAID.getValue());
                o_subOrderInfoEntity.setIsSync(true);
                o_subOrderInfoEntity.setPeopleNum(0);
                o_subOrderInfoEntity.setSubOrderDesc(o_subOrderInfoEntity.getSubOrderDesc()+" 消台原因:"+memo);
                subOrderInfoDao.update(o_subOrderInfoEntity);
                //更新主订单状态
                O_OrderInfoEntity orderInfoEntity = new O_OrderInfoEntity();
                orderInfoEntity.setOrderID(o_subOrderInfoEntity.getOrderID());
                orderInfoEntity = orderInfoDao.get(orderInfoEntity);
                orderInfoEntity.setPeopleNum(0);
                orderInfoEntity.setOrderStatus(OrderManageEnum.OrderStatus.ALREADYPAID.getValue());
                orderInfoDao.update(orderInfoEntity);
            }
            //修改桌台信息表
            dinningTable.setTableStatus(MerchantManageEnum.TableStatus.DIRTYTABLE.getValue());
            dinningTable.setCombineName(null);
            dinningTable.setCombineNumber(0);
            dinningTable.setShareNumber(0);
            dinningTableInfoDao.update(dinningTable);
            //有餐次桌台信息就修改餐次桌台信息
            updateMealTableMappingByTableInfo(dinningTable);
            //修改桌台使用信息表
            B_DinningTableUseInfoEntity useTable = getTableUseInfoByTableId(dinningTable);
            useTable.setEndTime(LocalDateTime.now());
            dinningTableUseInfoDao.updateByTableID(useTable);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            return resultData;
        }else if((CollectionUtils.isNotEmpty(tableMessageVoList)) && (StringUtils.isNotEmpty(tableIDs)) && (CollectionUtils.isNotEmpty(subOrderEntityList))) {
            //联桌、有子订单、订单金额为0
            //子订单移除(订单状态为已完成)
            //所选联桌是否存在已下单
            for (O_SubOrderInfoEntity entity : subOrderEntityList) {
                if (entity.getActualAmount() != null && entity.getActualAmount().doubleValue() != 0) {
                    resultData.setCode(CodeMsgConstants.ORDER_ISEXIST);
                    resultData.setMessage(CodeMsgConstants.ORDER_ISEXIST_DATA_MSG);
                    return resultData;
                }
            }
            StringBuffer buffer = new StringBuffer();
            List<Long> shareTableIdList = new ArrayList<Long>();
            for (O_SubOrderInfoEntity subOrder : subOrderEntityList) {
                if (subOrderEntity != null && subOrderEntity.get(0).getOrderID().equals(subOrder.getOrderID())) {
                    buffer.append(subOrder.getSubOrderID()).append(",");
                    subOrder.setOrderStatus(OrderManageEnum.OrderStatus.ALREADYPAID.getValue());
                    subOrder.setIsSync(true);
                    if (subOrder.getSubOrderDesc() == null || ("").equals(subOrder.getSubOrderDesc())){
                        subOrder.setSubOrderDesc(" 消台原因:"+memo);
                    }else{
                        subOrder.setSubOrderDesc(subOrder.getSubOrderDesc()+" 消台原因:"+memo);
                    }
                    //更新主订单状态
                    if (tableMessageVoList.size() - tableIDs.split(",").length == 0) {
                        O_OrderInfoEntity orderInfoEntity = new O_OrderInfoEntity();
                        orderInfoEntity.setOrderID(subOrder.getOrderID());
                        orderInfoEntity = orderInfoDao.get(orderInfoEntity);
                        orderInfoEntity.setPeopleNum(orderInfoEntity.getPeopleNum() - subOrder.getPeopleNum());
                        orderInfoEntity.setOrderStatus(OrderManageEnum.OrderStatus.ALREADYPAID.getValue());
                        orderInfoDao.update(orderInfoEntity);
                    }
                    subOrder.setPeopleNum(0);
                    subOrderInfoDao.update(subOrder);
                } else {
                    shareTableIdList.add(subOrder.getTableID());
                }
            }
            List<String> tableIDArray = Arrays.asList(tableIDs.split(","));
            if (CollectionUtils.isNotEmpty(shareTableIdList)) {
                //如果是拼桌的话，桌台信息表拼桌数量-1
                for (Long shareTableId : shareTableIdList) {
                    B_DinningTableInfoEntity shareDinningTable = new B_DinningTableInfoEntity();
                    shareDinningTable.setTableID(shareTableId);
                    shareDinningTable = dinningTableInfoDao.get(shareDinningTable);
                    shareDinningTable.setShareNumber(shareDinningTable.getShareNumber() - 1);
                    shareDinningTable.setCombineName(null);
                    shareDinningTable.setCombineNumber(0);
                    dinningTableInfoDao.update(shareDinningTable);
                    if (String.valueOf(shareTableId).contains(tableIDs)) {
                        tableIDArray.remove(shareTableId);
                    }
                }
                StringBuffer strBuffer = new StringBuffer();
                if (tableIDArray != null && !tableIDArray.isEmpty()) {
                    for (String str : tableIDArray) {
                        strBuffer.append(str).append(",");
                    }
                    String tablesBuffer = strBuffer.substring(0, strBuffer.length() - 1);
                    Map<String, Object> tableInfoMap = new HashMap<>();
                    tableInfoMap.put("tableID", tableID);
                    //联桌集合
                    //批量更新需要消台的桌台信息
                    updateUnionCombineNumber(tableMessageVoList, tablesBuffer);
                }

            }else {
                    //联桌集合
                    //批量更新需要消台的桌台信息
                    updateUnionCombineNumber(tableMessageVoList, tableIDs);

                }
                //餐次桌台表拼桌数量-1  有餐次桌台信息就修改餐次桌台信息
                List<B_MealTableMappingEntity> mealTableList = new ArrayList<B_MealTableMappingEntity>();
                for (int i = 0; i < tableIDs.split(",").length; i++) {
                    Map mealMap = new HashMap();
                    Map useMap = new HashMap<>();
                    useMap.put("tableID", tableIDs.split(",")[i]);
                    useMap.put("archiveID", (Long) paramMap.get("archiveID"));
                    mealMap.put("tableID", tableIDs.split(",")[i]);
                    mealTableList.addAll(mealTableMappingDao.getMealTableMappingByTableIDAndStatus(mealMap));
                }
                if (CollectionUtils.isNotEmpty(mealTableList)) {
                    for (B_MealTableMappingEntity mealTable : mealTableList) {
                        StringBuffer tableBuffer = new StringBuffer();
                        String relationTables = mealTable.getRelationTable();
                        if (StringUtils.isNotEmpty(relationTables)) {
                            for (String str : relationTables.split(",")) {
                                if (!str.contains(tableIDs)) {
                                    tableBuffer.append(str).append(",");
                                }
                            }
                            mealTable.setRelationTable(tableBuffer.substring(0, tableBuffer.length() - 1));
                        } else {
                            mealTable.setRelationTable(null);
                        }

                        //如果有拼桌的话，拼桌减一
                        if (CollectionUtils.isNotEmpty(shareTableIdList)) {
                            for (O_SubOrderInfoEntity subOrder : subOrderEntityList) {
                                if (subOrder.getTableID().equals(mealTable.getTableID()) && subOrder.getOrderID().equals(subOrderEntity.get(0).getOrderID())) {
                                    if (mealTable.getShareNumber() != null && mealTable.getShareNumber() > 0) {
                                        mealTable.setShareNumber(mealTable.getShareNumber() - 1);
                                    }
                                }
                            }
                        } else {
                            mealTable.setCombineNumber(0);
                            mealTable.setIsCombine(true);
                            mealTable.setShareNumber(0);
                            mealTable.setCustomerNumber(0);
                            mealTable.setTableStatus(DinningTableInfoConstants.TABLESTATUSCLEAR);
                        }
                        mealTableMappingDao.updateMealTableMappingEntityTableStatus(mealTable);
                    }
                }
                //批量更新桌台使用表
                List<B_DinningTableUseInfoEntity> useTableList = new ArrayList<B_DinningTableUseInfoEntity>();
                Map useMap = new HashMap<>();
                StringBuffer stringBuffer = new StringBuffer();
                useMap.put("tableIDs", tableIDs);
                useMap.put("archiveID", (Long) paramMap.get("archiveID"));
                useTableList = dinningTableUseInfoDao.getDinningTableUseInfoEntityByTableIDs(useMap);
                for (B_DinningTableUseInfoEntity entity : useTableList) {
                    StringBuffer stringBuffer1 = new StringBuffer();
                    Map userInfoMap = new HashMap<>();
                    if (entity.getRelationTable() != null) {
                        for (String str : entity.getRelationTable().split(",")) {
                            if (!str.contains(tableIDs)) {
                                stringBuffer1.append(str).append(",");
                            }
                        }
                    }
                    userInfoMap.put("endTime", LocalDateTime.now());
                    if (stringBuffer1.length() > 0) {
                        userInfoMap.put("relationTable", stringBuffer1.substring(0, stringBuffer1.length() - 1));
                    } else {
                        userInfoMap.put("relationTable", null);
                    }
                    userInfoMap.put("hisID", entity.getHisID());
                    //如果有拼桌的话,扣除拼桌的人数
                    if (CollectionUtils.isNotEmpty(shareTableIdList)) {
                    } else {
                        for (O_SubOrderInfoEntity subOrder : subOrderEntityList) {
                            if (subOrder.getTableID().equals(entity.getTableID()) && subOrder.getOrderID().equals(subOrderEntity.get(0).getOrderID())) {
                                userInfoMap.put("customerNumber", entity.getCustomerNumber() - subOrder.getPeopleNum());
                            }
                        }
                        userInfoMap.put("customerNumber", 0);
                    }
                    dinningTableUseInfoDao.updateBatch(userInfoMap);
                }
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                return resultData;
            } else {
                //该桌台正在使用状态，不能进行消台
                resultData.setCode(CodeMsgConstants.ELIMINATE_TABLE_FAIL);
                resultData.setMessage(CodeMsgConstants.ELIMINATE_TABLE_FAIL_DATA_MSG);
                return resultData;
            }
    }
    /**
     * @Description更新处理联桌情况下的联桌数目
     * @author ZhouWei
     * @time 2017-05-16
     */
    public void updateUnionCombineNumber(List<TableMessageVO> tableMessageVoList,String tableIDs){
        Map tableMap = new HashMap();
        tableMap.put("tableStatus",DinningTableInfoConstants.TABLESTATUSCLEAR);
        tableMap.put("tableIDs",tableIDs);
        tableMap.put("shareNumber",0);
        tableMap.put("combineName",null);
        tableMap.put("combineNumber",0);
        dinningTableInfoDao.updateTablesBatch(tableMap);
        for (TableMessageVO tableMessageVO:tableMessageVoList){
            if (tableIDs.contains(tableMessageVO.getTableID().toString()) == false){
                //批量更新不需要消台的桌台信息
                List<B_DinningTableInfoEntity> entityList = dinningTableInfoDao.getTablesByTableIds(tableMessageVO.getTableID().toString());
                if (tableMessageVoList.size() - tableIDs.split(",").length <=1){
                    entityList.get(0).setCombineName(null);
                }
                entityList.get(0).setCombineNumber(tableMessageVoList.size() - tableIDs.split(",").length);
                dinningTableInfoDao.update(entityList.get(0));
            }
        }
    }

    /**
     * @Description 进行清台处理 0处理异常，1处理成功 2，处理失败
     * @param dinning 参数
     * @return void
     * @author zhouwei
     * @version 2.0.0
     * @time 2017-04-01
     **/
    @Transactional(rollbackFor=Exception.class)
    public ResultData clearTable(B_DinningTableInfoEntity dinning) {
        ResultData resultData = new ResultData();
        try {
            //查询桌台信息
            B_DinningTableInfoEntity dinningTableInfoParam = new B_DinningTableInfoEntity();
            dinningTableInfoParam.setTableID(dinning.getTableID());
            logger.info("dinning.getTableID() :  " + dinning.getTableID());
            B_DinningTableInfoEntity  dinningTableInfo = dinningTableInfoDao.get(dinningTableInfoParam);
            logger.info("dinningTableInfo.getTableStatus() :  "+dinningTableInfo.getTableStatus());
            //如果桌台状态为待清（609）则可以 清台 （桌台状态改为空台 607），否则不可清台
            if (MerchantManageEnum.TableStatus.DIRTYTABLE.getValue() == dinningTableInfo.getTableStatus().longValue()) {
                dinningTableInfo.setTableStatus(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue());
                dinningTableInfoDao.update(dinningTableInfo);
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            } else {
                resultData.setCode(CodeMsgConstants.FAIL);
                resultData.setMessage(CodeMsgConstants.FAIL_MSG);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return resultData;
    }
    /**
     * 批量进行清台处理 0处理异常，1处理成功 2，处理失败
     * @param  tableIDs 参数
     * @return void
     * @author zhouwei
     * @param  tableIDs
     * @return
     * @time 2017-04-01
     **/
    @Transactional(rollbackFor=Exception.class)
    public ResultData clearTableBatch(String tableIDs) {
        ResultData resultData = new ResultData();
            //查询桌台信息
            logger.info("dinning.getTableID() :  " + tableIDs);
            List<B_DinningTableInfoEntity>  dinningTableInfoList = dinningTableInfoDao.getTablesByTableIds(tableIDs);
            StringBuffer buffer =new StringBuffer();
            String[] tableIdList = tableIDs.split(",");
            //验证查询出的数据与给出的桌台编号数是否一致，不一致说明给出的桌台编号有误，不予清台
            if(dinningTableInfoList.size()!=tableIdList.length){
                for (String str : tableIdList){
                    Integer temp = 0;
                    for (B_DinningTableInfoEntity entity : dinningTableInfoList){
                        if(str.equals(String.valueOf(entity.getTableID()))){
                            temp = 1;
                            break;
                        }
                    }
                    if (temp != 1){
                        buffer.append(str + " ");
                    }
                }
               throw new BizException(CodeMsgConstants.NO_TABLE_EXIST,CodeMsgConstants.NO_TABLE_EXIST_DATA_MSG,buffer);
            }
            //如果桌台状态为待清（609）则可以 清台 （桌台状态改为空台 607），否则不可清台
            for (B_DinningTableInfoEntity dinningTableInfo:dinningTableInfoList) {
                if (MerchantManageEnum.TableStatus.DIRTYTABLE.getValue() != dinningTableInfo.getTableStatus().longValue()) {
                    buffer.append(dinningTableInfo.getTableID() + " ");
                }
            }
        Map tableIdsMap = new HashMap();
        tableIdsMap.put("tableIDs",tableIDs);
        for (String str:tableIdList) {
            Map map =new HashMap();
            map.put("tableID",str);
            List<TableMessageVO> tableMessageVO = dinningTableInfoDao.getCanUnionTables(map);
            if (CollectionUtils.isNotEmpty(tableMessageVO)){
                continue;
            }else{
                List<O_SubOrderInfoEntity> subOrderInfoEntityList = subOrderInfoDao.getO_SubOrderInfoEntityByTableIDs(map);
                if (CollectionUtils.isNotEmpty(subOrderInfoEntityList)){
                    //子订单不是875和652的时候清理总订单
                    for (O_SubOrderInfoEntity subOrderInfoEntity:subOrderInfoEntityList) {
                        O_OrderInfoEntity orderInfoEntity = new O_OrderInfoEntity();
                        orderInfoEntity.setOrderID(subOrderInfoEntity.getOrderID());
                        orderInfoEntity.setOrderStatus(OrderManageEnum.OrderStatus.COMPLETED.getValue());
                        orderInfoDao.update(orderInfoEntity);
                    }
                }
            }
        }
        int ret = subOrderInfoDao.update_ReceptionO_SubOrderInfoEntityByTableIDs(tableIdsMap);
        mealTableMappingDao.updateMealTableMappingByTableIDAndTableStatus(tableIdsMap);
        if (buffer.length()<=0){
            Map<String,Object> map = new HashMap<String ,Object>();
            map.put("tableStatus",MerchantManageEnum.TableStatus.EMPTYTABLE.getValue());
            map.put("tableIDs",tableIDs);
            dinningTableInfoDao.updateTablesBatch(map);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        }else{
            if (ret>0){
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            }else{
                throw new BizException(CodeMsgConstants.NOT_DIRTY_TABLE,CodeMsgConstants.NOT_DIRTY_TABLE_DATA_MSG,buffer);
            }
        }
        return resultData;
    }

    /**
     *@Description 根据tableIds获取联桌集合
     * @author zhouwei
     * @time 2017-04-01
     * @param map
     * @version 2.0.0
     * @return
     */
    public ResultData getRelationTableList(Map map){
        List<B_DinningTableInfoEntity>  dinningTableInfoList = new ArrayList<B_DinningTableInfoEntity>();
        ResultData resultData = new ResultData();
        try{
            B_DinningTableUseInfoEntity useTable = new B_DinningTableUseInfoEntity();
            String tableIDs = "";
            List<TableMessageVO> tableMessageVoList = dinningTableInfoDao.getCanSplitTableInfos(map);
            if(CollectionUtils.isNotEmpty(tableMessageVoList)){
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                resultData.setData(tableMessageVoList);
            }else{
                resultData.setCode(CodeMsgConstants.NOT_RELATION_TABLE);
                resultData.setMessage(CodeMsgConstants.NOT_RELATION_TABLE_MSG);
            }
        }catch (Exception e){
            logger.info(e.getMessage());
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return resultData;
    }

    /**@Description 根据桌台编号和状态获取右侧展示信息
     * @author zhouwei
     * @Time 2017-04-07
     * @version 2.0.0
     * @param tableID
     * @return
     */
    public ResultData getTableShowMessage(Long tableID,Long subOrderID){
        ResultData resultData = new ResultData();
        B_DinningTableInfoEntity dinningTableInfoEntity = getTableInfoById(tableID);
        DinningTableInfoVO dinningTableInfoVO = new DinningTableInfoVO();
        Map<String,Object> map = new HashMap();
        Long tableStatus = dinningTableInfoEntity.getTableStatus();
        if (tableStatus.equals(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue())){
            O_BookingInfoEntity bookingInfoEntity =  bookingInfoService.getBookingInfoByTableID(tableID, LocalDateTime.now());
            List<O_SubOrderInfoEntity> subOrderInfoList = null;
            if (bookingInfoEntity != null){
                tableStatus = MerchantManageEnum.TableStatus.PREDETERMINE.getValue();
                subOrderInfoList= subOrderInfoDao.queryByOrderID(bookingInfoEntity.getOrderID());
                if (CollectionUtils.isNotEmpty(subOrderInfoList)){
                    for (O_SubOrderInfoEntity subOrderInfoEntity:subOrderInfoList) {
                        if ((tableID).equals(subOrderInfoEntity.getTableID())){
                            subOrderID = subOrderInfoEntity.getSubOrderID();
                        }
                    }
                }
//            dinningTableInfoVO.setOrderID(bookingInfoEntity.getOrderID());
//            dinningTableInfoVO.setSubOrderID(subOrderID);
//            dinningTableInfoVO.setTableStatus(MerchantManageEnum.TableStatus.PREDETERMINE.getValue());
            }
        }
        map.put("tableID",tableID);
        map.put("tableStatus",tableStatus);
        map.put("subOrderID",subOrderID);
        map.put("archiveID",dinningTableInfoEntity.getArchiveID());
        dinningTableInfoVO= dinningTableInfoDao.getTableShowMessage(map);
        if(dinningTableInfoVO == null){
            throw new BizException(CodeMsgConstants.NODATA,CodeMsgConstants.NODATA_MSG);
        }
        dinningTableInfoVO.setTableName(dinningTableInfoVO.getTableName());
        //在用或者开台情况下
        if((MerchantManageEnum.TableStatus.PLACEMAN.getValue()==tableStatus || MerchantManageEnum.TableStatus.PLACEORDER.getValue()==tableStatus || MerchantManageEnum.TableStatus.DIRTYTABLE.getValue()==tableStatus || MerchantManageEnum.TableStatus.PREDETERMINE.getValue()==tableStatus)){
            List<TableMessageVO> tableMessageVoList = getCombinedTables(tableID);
            //查询订单信息
            Integer customers = 0;
            Long creatorID = null;
            List<SubOrderInfoVo> dinningShareTableInfoList = subOrderInfoDao.getSubOrderInfoVOByTableIDAndStatus(tableID);
            if(CollectionUtils.isNotEmpty(dinningShareTableInfoList)){
                SubOrderInfoVo selectSubOrder = null;
                    if(subOrderID != null) {
                        for (SubOrderInfoVo subOrder : dinningShareTableInfoList) {
                            if (subOrder.getSubOrderID().equals(subOrderID)) {
                                selectSubOrder = subOrder;
                                dinningShareTableInfoList.clear();
                                dinningShareTableInfoList.add(subOrder);
                                break;
                            }
                        }
                        if (selectSubOrder != null) {
                            dinningTableInfoVO.setShareTableName(selectSubOrder.getTableName());
                            customers = selectSubOrder.getPeopleNum();
                            dinningTableInfoVO.setSubOrderID(selectSubOrder.getSubOrderID());
                            dinningTableInfoVO.setOrderID(selectSubOrder.getOrderID());
                            dinningTableInfoVO.setSubOrderStatus(selectSubOrder.getOrderStatus());
                            if (selectSubOrder.getOrderStatus().equals(OrderManageEnum.OrderStatus.ALREADYPAID.getValue())){
                                dinningTableInfoVO.setTableStatus(MerchantManageEnum.TableStatus.DIRTYTABLE.getValue());
                            }else if (selectSubOrder.getOrderStatus().equals(OrderManageEnum.OrderStatus.NOORDER.getValue())){
                                dinningTableInfoVO.setTableStatus(MerchantManageEnum.TableStatus.PLACEORDER.getValue());
                            }else if (selectSubOrder.getOrderStatus().equals(OrderManageEnum.OrderStatus.COMPLETED.getValue())){
                                dinningTableInfoVO.setTableStatus(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue());
                            }else if (selectSubOrder.getOrderStatus().equals(OrderManageEnum.OrderStatus.HAVEINHAND.getValue())){
                                dinningTableInfoVO.setTableStatus(MerchantManageEnum.TableStatus.PLACEMAN.getValue());
                            }else if (selectSubOrder.getOrderStatus().equals(OrderManageEnum.OrderStatus.BOOKING.getValue())){
                                dinningTableInfoVO.setTableStatus(MerchantManageEnum.TableStatus.PREDETERMINE.getValue());
                            }else if (selectSubOrder.getOrderStatus().equals(OrderManageEnum.OrderStatus.WAITINGPAY.getValue())){
                                dinningTableInfoVO.setTableStatus(MerchantManageEnum.TableStatus.STOPTABLE.getValue());
                            }
                            creatorID = selectSubOrder.getCreatorID();
                        }
                    }
            }
            dinningTableInfoVO.setCustomerNumber(customers);
            dinningTableInfoVO.setShareTableInfoList(dinningShareTableInfoList);
            dinningTableInfoVO.setCombineTableInfoList(tableMessageVoList);
            List<SubOrderInfoVo> subOrderInfoEntityList = new ArrayList();
            U_LoginInfoEntity loginInfoEntity = new U_LoginInfoEntity();
            loginInfoEntity.setLoginID(creatorID);
            U_LoginInfoEntity u_loginInfoEntity = loginInfoDao.get(loginInfoEntity);
            if (u_loginInfoEntity != null){
                dinningTableInfoVO.setNickName(u_loginInfoEntity.getNickName());
            }
            //关连桌
            if(isCombineTable(dinningTableInfoEntity)){
                StringBuffer tableNameBuffer = new StringBuffer();
                Long servedNum = 0L;
                Long unServedNum = 0L;
                for (TableMessageVO entity : tableMessageVoList) {
                    tableNameBuffer.append(entity.getTableName()).append(",");
                    Map hashMap = new HashMap();
                    hashMap.put("tableID",entity.getTableID());
                    hashMap.put("tableStatus",entity.getTableStatus());
                    hashMap.put("subOrderID",entity.getSubOrderID());
                    DinningTableInfoVO dinningTableInfo = dinningTableInfoDao.getTableShowMessage(hashMap);
                    entity.setAreaName(dinningTableInfo.getAreaName());
                    B_DinningTableInfoEntity dinningEntity = getTableInfoById(entity.getTableID());
                    subOrderInfoEntityList = subOrderInfoDao.getSubOrderInfoVOByTableIDAndStatus(entity.getTableID());
                    U_LoginInfoEntity loginEntity =new U_LoginInfoEntity();
                    loginEntity.setLoginID(subOrderInfoEntityList.get(0).getCreatorID());
                    U_LoginInfoEntity u_loginEntity = loginInfoDao.get(loginEntity);
                    if (u_loginEntity != null){
                        entity.setNickName(u_loginEntity.getNickName());
                    }
                    if(dinningTableInfo !=null){
                        if(dinningTableInfo.getSubServedNum() != null){
                            servedNum = NumberUtil.add(servedNum, dinningTableInfo.getSubServedNum()) ;
                        }
                        if(dinningTableInfo.getSubUnServedNum() != null){
                            unServedNum = NumberUtil.add(unServedNum, dinningTableInfo.getSubUnServedNum()) ;
                        }
                    }
                }
                if(tableNameBuffer !=null && tableNameBuffer.length()>0){
                    dinningTableInfoVO.setTableNames(tableNameBuffer.substring(0,tableNameBuffer.length()-1));
                }
                dinningTableInfoVO.setServedNum(servedNum);
                dinningTableInfoVO.setUnServedNum(unServedNum);
            }
        }
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        resultData.setData(dinningTableInfoVO);
        return resultData;

    }

    /**
     * @Description： 修改桌台状态和餐次桌台状态
     * @Author：LanZY
     * @Time: 2017-4-6 10:11
     * @Version 2.0.0
     * @param tableID       桌台ID
     * @return              餐次ID
     */
    public B_DinningTableInfoEntity updateTableStatus(Long tableID){
        if (tableID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        //查询桌台 修改桌台状态为在用
        B_DinningTableInfoEntity table =  dinningTableInfoDao.selectByPrimaryKey(tableID);
        if(null == table){
            throw new BizException(CodeMsgConstants.TABLE_INFO_NOT_EXIST, CodeMsgConstants.TABLE_INFO_NOT_EXIST_MSG,tableID);  //
        }
        if (!table.getTableStatus().equals(MerchantManageEnum.TableStatus.PLACEMAN.getValue())) {
            table.setTableStatus(MerchantManageEnum.TableStatus.PLACEMAN.getValue());
            dinningTableInfoDao.updateByPrimaryKeySelective(table);
        }
        return table;
    }

    /**
     * @author Zhaolingchen
     * @version 2.0.0
     * @description 获取可预定的桌台
     * @time 2017-05-17 16:00:00
     */
    public List<B_DinningTableInfoEntity> getDinningTableInfoListByBooking(Map param) throws Exception {
        Integer duration = (Integer)param.get("duration");
        LocalDateTime startTime = (LocalDateTime)param.get("reserveTime");//预订开始时间
        LocalDateTime endTime = startTime.plusMinutes(duration);//预订结束时间

        param.put("startTime", startTime);
        param.put("endTime", endTime);
        //所有桌台信息
        List<B_DinningTableInfoEntity> dinningAllTableList = dinningTableInfoDao.queryDinningTableInfoByCondition(param);

        //预定时间为当天,根据餐次桌台表判断未预定的桌台
        if (DateUtils.isSameDate(startTime, LocalDateTime.now())) {
            //通过餐次桌台表信息,过滤掉不可预订的桌台
            dinningAllTableList = filtrNotMayTalbe(startTime,duration, dinningAllTableList);
        } else {
            //预定时间非当天,根据预定单来判断未预订的桌台
            List<O_BookingInfoEntity> bookingInfoList = bookingInfoDao.getBookingInfoListByBookingTime(param);//查询预订信息

            //通过预定单信息,过滤掉已经预定的桌台
            dinningAllTableList = filtrBookingTalbe(bookingInfoList, dinningAllTableList);
        }
        return dinningAllTableList;
    }

    /*
    * @author 赵凌晨
    * @version 2.0.0
    * @description  通过餐次桌台表信息,过滤掉不可预订的桌台
    * @time 2017-06-8 17:00:00
    */
    private List<B_DinningTableInfoEntity> filtrNotMayTalbe(LocalDateTime startTime,Integer duration, List<B_DinningTableInfoEntity> dinningAllTableList) {
        List<B_DinningTableInfoEntity> result = new ArrayList<>();
        for (int i = 0; i < dinningAllTableList.size(); i++) {
            boolean isMayBooking = true;
            B_DinningTableInfoEntity dinningTableInfoEntity = dinningAllTableList.get(i);
            List<B_MealTableMappingEntity> mealTableList = mealTableMappingDao.getBetweenMealsTableMapping(dinningTableInfoEntity.getTableID(),startTime,duration);
            if(mealTableList == null || mealTableList.isEmpty()){
                continue;
            }
            for(B_MealTableMappingEntity mealTable : mealTableList){
                if(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue() != mealTable.getTableStatus()){
                    isMayBooking = false;
                    break;
                }
            }
            if(isMayBooking){
                result.add(dinningTableInfoEntity);
            }
        }
        return result;
    }


    /*
     * @author 赵凌晨
     * @version 2.0.0
     * @description  过滤已预订的桌台
     * @time 2017-04-19 17:00:00
     */
    private List<B_DinningTableInfoEntity> filtrBookingTalbe(List<O_BookingInfoEntity> bookingInfoList, List<B_DinningTableInfoEntity> dinningAllTableList) {
        Set<String> tableIDSet = new HashSet<>();//已预订桌台ID列表
        for (O_BookingInfoEntity bookingInfo : bookingInfoList) {
            List<O_SubOrderInfoEntity> subOrderInfoList = subOrderInfoDao.queryByOrderID(bookingInfo.getOrderID());
            for (O_SubOrderInfoEntity subOrderInfo : subOrderInfoList) {
                tableIDSet.add(String.valueOf(subOrderInfo.getTableID()));
            }
        }

        List<B_DinningTableInfoEntity> result = new ArrayList<>();
        for(B_DinningTableInfoEntity dinningTableInfoEntity : dinningAllTableList){
            if(!tableIDSet.contains(String.valueOf(dinningTableInfoEntity.getTableID()))){
                result.add(dinningTableInfoEntity);
            }
        }
        return result;
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据桌台ID改变桌台状态
     * @time 2017-5-19 14:05
     */
    public void updateTableStatusByTableID (B_DinningTableInfoEntity entity) throws Exception{
        dinningTableInfoDao.updateTableStatusByTableID(entity);
    }

    /**
     * @author Zhaolingchen
     * @version 2.0.0
     * @description 获取桌台预订信息状态信息
     * @time 2017-05-20 16:00:00
     */
    public  List<Map<String,Object>>  getBookingTableStatus(Map param) throws Exception {
        return dinningTableInfoDao.getDinningTableBookingInfo(param);
    }

    /**
     * @author Zhaolingchen
     * @version 2.0.0
     * @description 查询用户喜好桌
     * @time 2017-05-20 16:00:00
     */
    public List<B_DinningTableInfoEntity> getPreferenceDinningTableInfo(Map param) throws Exception {
        return dinningTableInfoDao.getPreferenceDinningTableInfo(param);
    }
}