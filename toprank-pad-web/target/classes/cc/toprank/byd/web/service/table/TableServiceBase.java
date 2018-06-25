package cc.toprank.byd.web.service.table;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.component.MealComponent;
import cc.toprank.byd.component.OrderComponent;
import cc.toprank.byd.component.TableComponent;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.web.vo.tablevo.TableMessageVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 桌台操作基类，提供了一些公共方法
 *
 * @author LinYN
 * @date 2017-4-13
 */
public abstract class TableServiceBase implements ParamConstants.TableParam {

    @Autowired
    private OrderComponent orderComponent;

    @Autowired
    private TableComponent tableComponent;

    @Autowired
    private MealComponent mealComponent;

    @Autowired
    protected B_DinningTableInfoDao dinningTableInfoDao;

    @Autowired
    protected B_DinningTableUseInfoDao dinningTableUseInfoDao;

    @Autowired
    protected O_OrderInfoDao orderInfoDao;

    @Autowired
    protected O_SubOrderInfoDao subOrderInfoDao;

    @Autowired
    protected B_MealTableMappingDao mealTableMappingDao;

    @Autowired
    protected B_MealsInfoDao mealsInfoDao;

    @Autowired
    protected U_LoginInfoDao loginInfoDao;
    /*
     * 获取桌台的名字，用于在异常信息中显示
     *
     * @author LinYN
     * @date 2017-3-24
     */
    protected String getDisplayTableName(B_DinningTableInfoEntity tableInfo){
        return tableComponent.getDisplayTableName(tableInfo);
    }

    /*
     * 桌台是否使用中：开台 或 己下单
     *
     * @param tableInfo 桌台信息
     *
     * @author LinYN
     * @date 2017-4-1
     */
    protected void checkTableIsUsing(B_DinningTableInfoEntity tableInfo) {
        tableComponent.checkTableIsUsing(tableInfo);
    }




    /*
     * 主订单金额人数和新增的子订单金额人数相加
     *
     * @author LinYN
     * @date 2017-3-31
     */
    protected O_SubOrderInfoEntity addSubOrderInfoSummary4OrderInfo(O_OrderInfoEntity orderInfo, O_SubOrderInfoEntity subOrderInfoSummary) {
        return orderComponent.addSubOrderInfoSummary4OrderInfo(orderInfo, subOrderInfoSummary);
    }

    /*
     * 获取联台名称
     *
     * @author LinYN
     * @date 2017-3-30
     */
    protected String getCombineTableName(B_DinningTableInfoEntity srcTableInfo) {
        return tableComponent.getCombineTableName(srcTableInfo);
    }

    /*
     * 判断此桌台是否联台
     *
     * @param tableInfo 桌台信息
     * @return <true>联台</true>，<false>不是联台</false>
     *
     * @author LinYN
     * @date 2017-4-5
     */
    protected boolean isCombineTable(B_DinningTableInfoEntity tableInfo) {
        return tableComponent.isCombineTable(tableInfo);
    }

    /*
     * 判断此桌台是否拼台
     *
     * @param tableInfo 桌台信息
     * @return <true>拼台</true>，<false>不是拼台</false>
     *
     * @author LinYN
     * @date 2017-4-1
     */
    protected boolean isSharingTable(B_DinningTableInfoEntity tableInfo) {
        return tableComponent.isSharingTable(tableInfo);
    }

    /*
     * 插入或更新桌台的主订单信息： 金额、人数、订单状态
     *
     * @param orderInfo 主订单
     * @param orderInfoSummary 子订单统计信息
     * @return 主订单ID
     *
     * @author LinYN
     * @date 2017-3-22
     */
    protected Long saveOrUpdateOrderInfo(O_OrderInfoEntity orderInfo, O_SubOrderInfoEntity orderInfoSummary) {
        return orderComponent.saveOrUpdateOrderInfo(orderInfo, orderInfoSummary);
    }

    /*
     * 统计桌台的子订单信息： 金额、人数
     *
     * @author LinYN
     * @date 2017-3-22
     */
    protected O_SubOrderInfoEntity calculateSubOrderInfo(List<O_SubOrderInfoEntity> tableSubOrderInfos){
        return orderComponent.calculateSubOrderInfo(tableSubOrderInfos);
    }

    /*
     * 获取所有关联桌台的ID
     *
     * @param tableInfo 桌台信息
     *
     * @author LinYN
     * @date 2017-4-6
     */
    protected Set<Long> getCombinedTableIDs(B_DinningTableInfoEntity tableInfo) {
        return tableComponent.getCombinedTableIDs(tableInfo);
    }

    /*
     * 通过某个联台的ID 查询与之关联的桌台
     *
     * @param combineTableId 某个联台的ID
     * @return 关联的桌台
     *
     * @author LinYN
     * @date 2017-3-22
     */
    protected List<TableMessageVO> getCombinedTables(Long combineTableId){
        return tableComponent.getCombinedTables(combineTableId);
    }

    /*
     * 根据桌台编号查询订单状态为进行中的子订单信息
     *
     * @param tableId 桌台ID
     * @return 子订单信息
     *
     * @author LinYN
     * @date 2017-4-7
     */
    protected List<O_SubOrderInfoEntity> getSubOrderInfoByTableId(Long tableId) {
        return orderComponent.getSubOrderInfoByTableId(tableId);
    }

    /*
     * 根据桌台编号查询进行中或未下单、待支付、己支付（脏台）状态的子订单信息
     *
     * @param tableId 桌台ID
     * @return 子订单信息
     *
     * @author LinYN
     * @date 2017-5-26
     */
    protected List<O_SubOrderInfoEntity> getRelationSubOrderInfoByTableID(Long tableId) {
        return orderComponent.getRelationSubOrderInfoByTableID(tableId);
    }


    /*
     * 根据桌台ID 查询桌台的所有子订单
     *
     * @param tableInfos 桌台信息（桌台ID）
     * @return 桌台的所有子订单
     *
     * @author LinYN
     * @date 2017-3-23
     */
    protected List<O_SubOrderInfoEntity> getSubOrderInfosByTableIDs(Set<Long> tableIDs) {
        return orderComponent.getSubOrderInfosByTableIDs(tableIDs);
    }

    /*
     * 根据桌台编号查询订单状态为进行中的子订单信息
     *
     * @param tableId 桌台ID
     * @return 子订单信息
     *
     * @author LinYN
     * @date 2017-4-1
     */
    protected List<O_SubOrderInfoEntity> getSubOrderInfoByTableInfo(B_DinningTableInfoEntity tableInfo) {
        return getSubOrderInfoByTableId(tableInfo.getTableID());
    }

    /*
     * 根据桌台ID 查询桌台信息
     *
     * @param tableId 桌台ID
     * @return 桌台信息
     *
     * @author LinYN
     * @date 2017-3-27
     */
    protected B_DinningTableInfoEntity getTableInfoById(Long tableId) {
        return tableComponent.getTableInfoById(tableId);
    }

    /*
     * 根据桌台ID和机构编号查询桌台的使用信息
     *
     * @param tableInfo 当前桌台
     * @throws Exception 找不到桌台的使用信息
     *
     * @author LinYN
     * @since 2017-3-24
     */
    protected B_DinningTableUseInfoEntity getTableUseInfoByTableId(B_DinningTableInfoEntity tableInfo) {
        return tableComponent.getTableUseInfoByTableId(tableInfo);
    }

    /*
     * 根据桌台ID 查询桌台信息
     *
     * @param tableIds 桌台ID
     * @return 桌台信息
     *
     * @author LinYN
     * @date 2017-3-23
     */
    protected List<B_DinningTableInfoEntity> getTableInfosByIds(List<Long> tableIds) {
        return tableComponent.getTableInfosByIds(tableIds);
    }


    /*
     * 获取餐次桌台表信息记录
     *
     * @param tableInfo 桌台
     *
     * @author LinYN
     * @date 2017-4-7
     */
    protected List<B_MealTableMappingEntity> getMealTableMappingInfo(B_DinningTableInfoEntity tableInfo) {
        return mealComponent.getMealTableMappingInfo(tableInfo);
    }

    /*
     * 处理餐次桌台表信息记录
     *
     * @param tableInfo 桌台使用信息
     * @throws Exception
     *
     * @author LinYN
     * @date 2017-3-27
     */
    protected void updateMealTableMappingByTableInfo(B_DinningTableInfoEntity tableInfo) throws Exception {
        mealComponent.updateMealTableMappingByTableInfo(tableInfo);
    }

    /*
    * 根据桌台信息获取子订单
    *
    * @param targetTableInfo 桌台信息
    * @return 子订单
    *
    * @throws Exception 没有找到子订单
    *
    * @author LinYN
    * @date 2017-3-31
    */
    protected O_SubOrderInfoEntity getFirstSubOrderInfoByTableInfo(B_DinningTableInfoEntity targetTableInfo, boolean throwException) {
        return orderComponent.getFirstSubOrderInfoByTableInfo(targetTableInfo, throwException);
    }

    protected O_SubOrderInfoEntity getFirstSubOrderInfoByTableInfo(B_DinningTableInfoEntity targetTableInfo) {
        return getFirstSubOrderInfoByTableInfo(targetTableInfo, true);
    }

    /*
    * 获取桌台的当前餐次
    *
    * @param tableInfo 桌台信息
    * @throws Exception 没有餐次信息
    *
    * @author LinYN
    * @date 2017-3-27
    */
    protected B_MealsInfoEntity getCurrentMealsInfoOfTable(B_DinningTableInfoEntity tableInfo) {
        return mealComponent.getCurrentMealsInfoOfTable(tableInfo);
    }

    /*
     * 获取桌台的子订单
     * @param tableInfo 桌台信息
     * @param subOrderInfoID 子订单编号，拼桌需要传入
     *
     * @author LinYN
     * @date 2017-5-10
     **/
    protected O_SubOrderInfoEntity getCurrentSubOrderInfo(B_DinningTableInfoEntity tableInfo, Long subOrderInfoID) {
        return orderComponent.getCurrentSubOrderInfo(tableInfo, subOrderInfoID);
    }
}
