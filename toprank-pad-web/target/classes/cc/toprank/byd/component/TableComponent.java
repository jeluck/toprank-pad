package cc.toprank.byd.component;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.util.CollectionHelper;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.DinningTableInfoConstants;
import cc.toprank.byd.web.util.TableUtils;
import cc.toprank.byd.web.vo.tablevo.TableMessageVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.*;

/**
 * 桌台组件
 *
 * @author LinYN
 * @date 2017-5-13
 */
@Component
public class TableComponent implements ParamConstants.TableParam {

    @Autowired
    private B_DinningTableInfoDao dinningTableInfoDao;

    @Autowired
    private B_DinningTableUseInfoDao dinningTableUseInfoDao;

    @Autowired
    private O_OrderInfoDao orderInfoDao;

    @Autowired
    private O_SubOrderInfoDao subOrderInfoDao;





    @Autowired
    private U_LoginInfoDao loginInfoDao;

    /**
     * 获取桌台的名字，用于在异常信息中显示
     *
     * @author LinYN
     * @date 2017-3-24
     */
    public String getDisplayTableName(B_DinningTableInfoEntity tableInfo){
        String tableName = null;
        if (tableInfo == null) return "";
        tableName = tableInfo.getTableName();
        if (StringUtils.isNotEmpty(tableName))
            return tableName;
        tableName = tableInfo.getTableCode();
        if (StringUtils.isNotEmpty(tableName))
            return tableName;
        tableName = tableInfo.getTableID().toString();
        return  tableName;
    }

    /**
     * 桌台是否使用中：开台 或 己下单
     *
     * @param tableInfo 桌台信息
     *
     * @author LinYN
     * @date 2017-4-1
     */
    public void checkTableIsUsing(B_DinningTableInfoEntity tableInfo) {
        Long tableStatus = tableInfo.getTableStatus();
        if (!(MerchantManageEnum.TableStatus.PLACEORDER.getValue() == tableStatus || MerchantManageEnum.TableStatus.PLACEMAN.getValue()==tableStatus)) {
            throw new BizException(CodeMsgConstants.TABLE_UN_USED, CodeMsgConstants.TABLE_UN_USED_MSG, getDisplayTableName(tableInfo)); // 桌台不在使用中
        }
    }

    /**
     * 获取联台名称
     *
     * @author LinYN
     * @date 2017-3-30
     */
    public String getCombineTableName(B_DinningTableInfoEntity srcTableInfo) {
        String combineTableName = null;
        if (srcTableInfo != null) {
            combineTableName = srcTableInfo.getCombineName();
        }
        if (StringUtils.isEmpty(combineTableName)) {
            combineTableName = DinningTableInfoConstants.COMBINE_TABLENAME + TableUtils.getCombineTableSequence();
        }
        return combineTableName;
    }

    /**
     * 判断此桌台是否联台
     *
     * @param tableInfo 桌台信息
     * @return <true>联台</true>，<false>不是联台</false>
     *
     * @author LinYN
     * @date 2017-4-5
     */
    public boolean isCombineTable(B_DinningTableInfoEntity tableInfo) {
        return StringUtils.isNotEmpty(tableInfo.getCombineName()) || (NumberUtil.intValue(tableInfo.getCombineNumber()) > 1);
    }

    /**
     * 判断此桌台是否拼台
     *
     * @param tableInfo 桌台信息
     * @return <true>拼台</true>，<false>不是拼台</false>
     *
     * @author LinYN
     * @date 2017-4-1
     */
    public boolean isSharingTable(B_DinningTableInfoEntity tableInfo) {
        return NumberUtil.intValue(tableInfo.getShareNumber()) > 1;
    }


    /**
     * 获取所有关联桌台的ID
     *
     * @param srcTableInfo 桌台信息
     *
     * @author LinYN
     * @date 2017-4-6
     */
    public Set<Long> getCombinedTableIDs(B_DinningTableInfoEntity srcTableInfo) {
        List<TableMessageVO> combinedTableInfos = getCombinedTables(srcTableInfo.getTableID());
        return CollectionHelper.collect(combinedTableInfos, (combinedTableInfo) -> combinedTableInfo.getTableID());
    }

    /**
     * 通过某个联台的ID 查询与之关联的桌台
     *
     * @param combineTableId 某个联台的ID
     * @return 关联的桌台
     *
     * @author LinYN
     * @date 2017-3-22
     */
    public List<TableMessageVO> getCombinedTables(Long combineTableId){
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put(PARAM_TABLE_ID, combineTableId);
        return dinningTableInfoDao.getCanSplitTableInfos(queryParam);
    }

    /**
     * 根据桌台ID 查询桌台信息
     *
     * @param tableId 桌台ID
     * @return 桌台信息
     *
     * @author LinYN
     * @date 2017-3-27
     */
    public B_DinningTableInfoEntity getTableInfoById(Long tableId) {
        if (tableId == null) throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        B_DinningTableInfoEntity dinningTableInfoParam = new B_DinningTableInfoEntity();
        dinningTableInfoParam.setTableID(tableId);
        B_DinningTableInfoEntity  tableInfo = dinningTableInfoDao.get(dinningTableInfoParam);
        if (tableInfo == null) {
            throw new BizException(CodeMsgConstants.TABLE_INFO_NOT_EXIST, CodeMsgConstants.TABLE_INFO_NOT_EXIST_MSG);  // 找不到桌台
        }
        return tableInfo;
    }

    /**
     * 根据桌台ID和机构编号查询桌台的使用信息
     *
     * @param tableInfo 当前桌台
     * @throws Exception 找不到桌台的使用信息
     *
     * @author LinYN
     * @since 2017-3-24
     */
    public B_DinningTableUseInfoEntity getTableUseInfoByTableId(B_DinningTableInfoEntity tableInfo) {
        Map<String, Object> useMap = new HashMap<>();
        useMap.put(PARAM_TABLE_ID, tableInfo.getTableID());
        useMap.put(PARAM_ARCHIVE_ID, tableInfo.getArchiveID());
        B_DinningTableUseInfoEntity tableUseInfo =  dinningTableUseInfoDao.getDinningTableUseInfoEntityByTableIDAndTableStatus(useMap);
        if (tableUseInfo == null) {
            throw new BizException(CodeMsgConstants.NO_TABLE_USE_DATA, CodeMsgConstants.NO_TABLE_USE_DATA_MSG, getDisplayTableName(tableInfo));
        }
        return tableUseInfo;
    }

    /**
     * 根据桌台ID 查询桌台信息
     *
     * @param tableIds 桌台ID
     * @return 桌台信息
     *
     * @author LinYN
     * @date 2017-3-23
     */
    public List<B_DinningTableInfoEntity> getTableInfosByIds(List<Long> tableIds) {
        if (CollectionUtils.isEmpty(tableIds)) {
            return new ArrayList<>(0);
        }
        return dinningTableInfoDao.getTablesByTableIds(StringUtils.join(tableIds, ParamConstants.GlobalParam.PARAM_SEPARATOR));
    }

    /**
     * 根据机构编号和桌台名称模糊查询桌台信息
     *
     * @param archiveID 机构编号
     * @param tableName 桌台名称
     * @return 桌台信息
     *
     * @author LinYN
     * @date 2017-4-21
     */
    public List<TableMessageVO> getUsingTableInfos(String tableName, Long archiveID){
        if (archiveID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put(PARAM_TABLE_NAME, tableName);
        queryParam.put(PARAM_ARCHIVE_ID, archiveID);
        return dinningTableInfoDao.getUsingTableInfosByTableName(queryParam);
    }

    /**
     * 根据桌台ID查询当前使用信息
     * @param tableID 桌台ID
     * @return 桌台使用信息
     * @author Lzy
     * @date 2017-4-21
     */
    public B_DinningTableUseInfoEntity getCurrentTableUseInfoByTableID(Long tableID){
        if (tableID == null) throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        B_DinningTableUseInfoEntity dinningTableUseInfo = dinningTableUseInfoDao.getDinningTableUseInfoByTableIDAndEndTime(tableID);
        if(null == dinningTableUseInfo){
            throw new BizException(CodeMsgConstants.NO_TABLE_USE_DATA, CodeMsgConstants.NO_TABLE_USE_DATA_MSG,tableID);
        }
        return  dinningTableUseInfo;
    }

    /**
     * 检查桌台当前使用信息是否异常
     * @param table 桌台信息
     * @author Lzy
     * @date 2017-4-21
     */
    public void checkDinningTableUseInfoIsError(B_DinningTableInfoEntity table){
        //查询桌台使用信息
        B_DinningTableUseInfoEntity dinningTableUseInfo = dinningTableUseInfoDao.getDinningTableUseInfoByTableIDAndEndTime(table.getTableID());
        if(null != dinningTableUseInfo){
            throw new BizException(CodeMsgConstants.EXIS_TABLE_USE_ERROR_DATA, CodeMsgConstants.EXIS_TABLE_USE_ERROR_DATA_MSG,table.getTableName());
        }
    }
}
