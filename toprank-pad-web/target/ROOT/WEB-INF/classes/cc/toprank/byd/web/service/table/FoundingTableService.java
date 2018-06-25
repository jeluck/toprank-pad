package cc.toprank.byd.web.service.table;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.BigDecimalUtil;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.ObjectUtil;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.component.*;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.enums.SystemManageEnum;
import cc.toprank.byd.pad.service.BookingService;
import cc.toprank.byd.pad.service.OpenTableService;
import cc.toprank.byd.pad.service.ShoppingCartService;
import cc.toprank.byd.service.MonitorService;
import cc.toprank.byd.service.StallWeighService;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.vo.print.ProductDetailVO;
import cc.toprank.byd.vo.print.TableInfoVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.DinningTableInfoConstants;
import cc.toprank.byd.web.service.menu.O_SubOrderInfoService;
import cc.toprank.byd.web.service.order.O_OrderDealInfoService;
import cc.toprank.byd.web.util.OrderUtil;
import cc.toprank.byd.web.util.TableUtils;
import cc.toprank.byd.web.vo.tablevo.TableHandleVO;
import cc.toprank.byd.web.vo.tablevo.TurnTableProductVO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static cc.toprank.byd.common.utils.number.NumberUtil.intValue;

/**
 * @Description： 开台, 加台
 * @Author：LanZY
 * @Time: 2017-4-5 10:02
 * @Version 2.0.0
 */
@Service
public class FoundingTableService extends TableServiceBase {


    @Autowired
    O_OrderInfoDao orderInfoDao;
    @Autowired
    B_DinningTableInfoDao dinningTableInfoDao;
    @Autowired
    O_SubOrderInfoService subOrderInfoService;
    @Autowired
    U_LoginInfoDao loginInfoDao;
    @Autowired
    B_MealTableMappingDao mealTableMappingDao;
    @Autowired
    B_MealTableMappingService mealTableMappingService;
    @Autowired
    MealComponent mealComponent;
    @Autowired
    TableComponent tableComponent;
    @Autowired
    BookingService bookingService;
    @Autowired
    O_OrderDetailInfoDao orderDetailInfoDao;
    @Autowired
    StallWeighService stallWeighService;
    @Autowired
    MonitorService monitorService;
    @Autowired
    OpenTableService openTableService;
    @Autowired
    ProductComponent productComponent;
    @Autowired
    PrintComponent printComponent;
    @Autowired
    OrderComponent orderComponent;
    @Autowired
    O_OrderDealInfoService orderDealInfoService;
    @Autowired
    B_ReservationTimeInfoService reservationTimeInfoService;
    @Autowired
    ShoppingCartService shoppingCartService;

    /**
     * @param tableIDs        桌台ID集合
     * @param customerNumbers 人数
     * @param archiveID       档案ID
     * @param loginID         开台人ID
     * @throws Exception
     * @Description： 开台
     * @Author：LanZY
     * @Time: 2017-4-1 10:28
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void addGeneralTable(List<Long> tableIDs, List<Integer> customerNumbers, Long archiveID, Long loginID, Long mealsID) throws Exception {
        //判断开台人数
        for (Integer num : customerNumbers) {
            if (intValue(num) < 1) {
                throw new BizException(CodeMsgConstants.OPEN_TABLE_CUSTOMER_NUMBER_ERROR, CodeMsgConstants.OPEN_TABLE_CUSTOMER_NUMBER_ERROR_MSG);
            }
        }
        //判断桌台状态是否为空闲
        for (int i = 0; i < tableIDs.size(); i++) {
            B_DinningTableInfoEntity tableInfo = tableComponent.getTableInfoById(tableIDs.get(i));
            if (!tableInfo.getTableStatus().equals(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue())) {
                throw new BizException(CodeMsgConstants.TABLE_IS_NOT_EMPTY, CodeMsgConstants.TABLE_IS_NOT_EMPTY_MSG, tableInfo.getTableName());
            }
        }
        if(tableIDs.size() != customerNumbers.size()){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if(intValue(loginID) < 1){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }

        // 新增订单信息
        O_OrderInfoEntity orderInfo = new O_OrderInfoEntity();
        orderInfo.setArchiveID(archiveID);
        orderInfo.setPeopleNum(customerNumbers.stream().mapToInt(Integer::intValue).sum());
        orderInfo.setCreatorID(loginID);
        orderInfo.setCreatorType(SystemManageEnum.UserType.SYSTEMUSER.getValue());
        orderInfo.setActualAmount(BigDecimal.ZERO);//子订单实际金额
        orderInfo.setTotalAmount(BigDecimal.ZERO);//子订单的总金额
        orderInfo.setQuantity(0);//子订单的数量
        orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.NOORDER.getValue());
        orderInfo.setOrderCode(OrderUtil.getOrderCode());
        orderInfo.setOrderID(MaxIDUtils.getID(O_OrderInfoEntity.class));
        orderInfoDao.insertSelective(orderInfo);
        //联台名称
        String combineTableName = "";
        if (tableIDs.size() > 1) {
            combineTableName = DinningTableInfoConstants.COMBINE_TABLENAME + TableUtils.getCombineTableSequence();
        }
        //处理桌台关联信息
        TableHandleVO tableHandle = new TableHandleVO();
        tableHandle.setLoginID(loginID);
        tableHandle.setCombineName(combineTableName);
        tableHandle.setCombineNumber(tableIDs.size());
        tableHandle.setOrderID(orderInfo.getOrderID());
        tableHandle.setCombine(tableIDs.size() > 1 ? Boolean.TRUE : Boolean.FALSE);
        tableHandle.setMealsID(mealsID);
        handleTableMappingInfo(tableHandle, tableIDs, customerNumbers);
    }

    /**
     * @Description： 预定开台
     * @Author：LanZY
     * @Time: 2017-6-13 17:43
     * @Version 2.0.0
     * @param bookingID         预定单ID
     * @param tableIDs          桌台ID
     * @param customerNumbers   人数
     * @param loginID
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public void bookingOpenTable(Long bookingID,List<Long> tableIDs, List<Integer> customerNumbers,Long loginID) throws Exception {
        if(CollectionUtils.isEmpty(tableIDs)){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if(CollectionUtils.isEmpty(customerNumbers)){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if(tableIDs.size() != customerNumbers.size()){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        //查询预定单
        O_BookingInfoEntity bookingInfo = orderComponent.getBookingInfoByID(bookingID);
        //查询相关的子订单信息
        List<O_SubOrderInfoEntity> subOrderList = subOrderInfoDao.getBookingSubOrderListByOrderID(bookingInfo.getOrderID());
        if(CollectionUtils.isEmpty(subOrderList)){
            throw new BizException(CodeMsgConstants.SUBORDER_NOT_EXISTENCE, CodeMsgConstants.SUBORDER_NOT_EXISTENCE_MSG);
        }
        //需要取消的订单
        List<Long> cancelSubOrders = new ArrayList<>();
        List<Long> cancelTableIDs = new ArrayList<>();
        for (O_SubOrderInfoEntity subOrderInfo : subOrderList) {
            if(!tableIDs.contains(subOrderInfo.getTableID())){
                cancelSubOrders.add(subOrderInfo.getSubOrderID());
                cancelTableIDs.add(subOrderInfo.getTableID());
            }
        }
        //联台名称
        String combineTableName = "";
        if (tableIDs.size() > 1) {
            combineTableName = DinningTableInfoConstants.COMBINE_TABLENAME + TableUtils.getCombineTableSequence();
        }
        for (int i = 0; i < tableIDs.size(); i++) {
            if (customerNumbers.get(i) == null) {
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
            }
            //查询桌台
            B_DinningTableInfoEntity tableInfo = tableComponent.getTableInfoById(tableIDs.get(i));
            if (!tableInfo.getTableStatus().equals(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue())) {
                throw new BizException(CodeMsgConstants.TABLE_IS_NOT_EMPTY, CodeMsgConstants.TABLE_IS_NOT_EMPTY_MSG, tableInfo.getTableName());
            }
            //清空购物车
            shoppingCartService.cleanShoppingCart(tableIDs.get(i),Boolean.FALSE);
            //查询餐次
            B_MealsInfoEntity mealsInfo = mealComponent.getCurrentMealsInfo(tableInfo);
            //查询保留时长
            Integer extensionMinute = 0;
            List<B_ReservationTimeInfoEntity> reservationTimeInfoByWhere = new ArrayList<>();
            if(i == 0){
                B_ReservationTimeInfoEntity reservationTimeParam = new B_ReservationTimeInfoEntity();
                reservationTimeParam.setArchiveID(tableInfo.getArchiveID());
                reservationTimeParam.setMealsID(mealsInfo.getMealsID());
                reservationTimeParam.setAreaID(tableInfo.getAreaID());
                reservationTimeParam.setBookingType(bookingInfo.getBookingType());
                reservationTimeInfoByWhere = reservationTimeInfoService.getReservationTimeInfoByWhere(reservationTimeParam);
            }
            if(CollectionUtils.isNotEmpty(reservationTimeInfoByWhere)){
                if(NumberUtil.intValue(reservationTimeInfoByWhere.get(i).getExtensionMinute())>0){
                    extensionMinute = reservationTimeInfoByWhere.get(i).getExtensionMinute();
                }
            }
            //检查是否可以预定开台
            // 预订时间-最短就餐时长 < 当前时间 < 预订时间+保留时长
//            if(!DateUtils.isBetween(LocalDateTime.now(),bookingInfo.getBookingTime().minusMinutes(mealsInfo.getMinLength()),bookingInfo.getBookingTime().plusMinutes(extensionMinute))){
//                throw new BizException("当前预定单不在开台时间范围内！");
//            }
            //查询预定子订单
            O_SubOrderInfoEntity bookingSubOrderInfo = orderComponent.getBookingSubOrderInfo(bookingInfo.getOrderID(), tableInfo.getTableID());
            //检查预定桌台的餐次桌台关联数据
            checkMealBookTable(tableInfo,bookingInfo);
            // 修改预定单的到店时间
            bookingService.updateArrivalTime(bookingID);
            // 查询预定点菜信息
            List<Long> detailIDList = orderDetailInfoDao.getDetailIDByOrderID(bookingInfo.getOrderID());
            if (!detailIDList.isEmpty()) {
                // 如有称重菜,记录待称重菜品信息
                stallWeighService.addStallWeighInfo(detailIDList);
                // 添加菜品信息到厨师看板中
                monitorService.addWaitMakeProduct2DesignerMonitorInfo(detailIDList);
                //打印
                List<ProductDetailVO> printProductDetailList = productComponent.getPrintProductDetailList(detailIDList);
                TableInfoVO printTable = productComponent.getPrintTable(bookingSubOrderInfo.getSubOrderID());
                try {
                    printComponent.printTableTicket(printTable,printProductDetailList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //检查桌台当前使用信息是否异常
            tableComponent.checkDinningTableUseInfoIsError(tableInfo);
            //修改桌台状态
            tableInfo.setPeopleNum(customerNumbers.get(i));
            Long tableStatus = MerchantManageEnum.TableStatus.PLACEORDER.getValue();
            if(!detailIDList.isEmpty()){
                tableStatus = MerchantManageEnum.TableStatus.PLACEMAN.getValue();
            }
            tableInfo.setTableStatus(tableStatus);
            tableInfo.setCombineName(combineTableName);
            tableInfo.setCombineNumber(customerNumbers.size());
            dinningTableInfoDao.updateByPrimaryKeySelective(tableInfo);
            // 添加桌台使用信息
            B_DinningTableUseInfoEntity newTableUserInfo = new B_DinningTableUseInfoEntity();
            newTableUserInfo.setTableID(tableIDs.get(i));
            newTableUserInfo.setCombineNumber(customerNumbers.size());
            newTableUserInfo.setWaiterLoginID(loginID);
            newTableUserInfo.setCashierLoginID(loginID);
            newTableUserInfo.setMealsID(mealsInfo.getMealsID());
            newTableUserInfo.setStartTime(LocalDateTime.now());
            newTableUserInfo.setCreateTime(LocalDateTime.now());
            newTableUserInfo.setCustomerNumber(customerNumbers.get(i));
            newTableUserInfo.setCombineName(combineTableName);
            newTableUserInfo.setIsSync(Boolean.FALSE);
            newTableUserInfo.setIsCombine(tableIDs.size() > 1 ? Boolean.TRUE : Boolean.FALSE);
            newTableUserInfo.setArchiveID(tableInfo.getArchiveID());
            newTableUserInfo.setHisID(MaxIDUtils.getID(B_DinningTableUseInfoEntity.class));
            dinningTableUseInfoDao.insertSelective(newTableUserInfo);
            //修改子订单信息
            O_SubOrderInfoEntity subOrderInfo = new O_SubOrderInfoEntity();
            subOrderInfo.setSubOrderID(bookingSubOrderInfo.getSubOrderID());
            Long orderStatus = OrderManageEnum.OrderStatus.NOORDER.getValue();
            if(!detailIDList.isEmpty()){
                orderStatus = OrderManageEnum.OrderStatus.HAVEINHAND.getValue();
            }
            subOrderInfo.setOrderStatus(orderStatus);
            subOrderInfo.setPeopleNum(customerNumbers.get(i));
            subOrderInfoDao.updateByPrimaryKeySelective(subOrderInfo);
            //新增子订单处理信息
            orderDealInfoService.saveOrderDealInfo(subOrderInfo.getSubOrderID(),bookingInfo.getOrderID(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,OrderManageEnum.OrderStatus.BOOKING.getValue(),orderStatus,"");

        }
        //取消的总价格
        BigDecimal cancelTotalPrice = BigDecimal.ZERO;
        //取消的总数量
        Integer cancelTotalNum = 0;
        if(CollectionUtils.isNotEmpty(cancelSubOrders)){
            for(int i = 0; i < cancelSubOrders.size(); i++){
                cancelMealTable(bookingInfo, cancelTableIDs.get(i),MerchantManageEnum.TableStatus.EMPTYTABLE.getValue());
                O_SubOrderInfoEntity subOrderInfo = subOrderInfoDao.selectByPrimaryKey(cancelSubOrders.get(i));
                cancelTotalPrice = BigDecimalUtil.add(cancelTotalPrice,subOrderInfo.getTotalAmount());
                cancelTotalNum = NumberUtil.add(cancelTotalNum,subOrderInfo.getQuantity());
                //修改为客户取消状态
                subOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.MANUALCANCEL.getValue());
                subOrderInfoDao.updateByPrimaryKeySelective(subOrderInfo);
                //新增子订单处理信息
                orderDealInfoService.saveOrderDealInfo(subOrderInfo.getSubOrderID(),bookingInfo.getOrderID(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,OrderManageEnum.OrderStatus.BOOKING.getValue(),OrderManageEnum.OrderStatus.MANUALCANCEL.getValue(),"");
            }
            //修改订单记录
            O_OrderInfoEntity orderInfo = orderInfoDao.selectByPrimaryKey(bookingInfo.getOrderID());
            //新增订单处理信息
            orderDealInfoService.saveOrderDealInfo(null,bookingInfo.getOrderID(), cancelTotalPrice,orderInfo.getTotalAmount(), BigDecimalUtil.sub(orderInfo.getTotalAmount(), cancelTotalPrice),OrderManageEnum.OrderStatus.BOOKING.getValue(),OrderManageEnum.OrderStatus.HAVEINHAND.getValue(),"");
            orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
            orderInfo.setQuantity(NumberUtil.subtract(cancelTotalNum,orderInfo.getQuantity()));
            orderInfo.setPeopleNum(customerNumbers.stream().mapToInt(Integer::intValue).sum());
            orderInfo.setTotalAmount(BigDecimalUtil.sub(orderInfo.getTotalAmount(), cancelTotalPrice));
            orderInfo.setActualAmount(BigDecimalUtil.sub(orderInfo.getActualAmount(), cancelTotalPrice));
            orderInfo.setPendingAmount(BigDecimalUtil.sub(orderInfo.getPendingAmount(), cancelTotalPrice));
            orderInfoDao.updateByPrimaryKeySelective(orderInfo);
        }else{
            //修改订单记录
            O_OrderInfoEntity orderInfo = orderInfoDao.selectByPrimaryKey(bookingInfo.getOrderID());
            //新增订单处理信息
            orderDealInfoService.saveOrderDealInfo(null,bookingInfo.getOrderID(),  BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,OrderManageEnum.OrderStatus.BOOKING.getValue(),OrderManageEnum.OrderStatus.NOORDER.getValue(),"");
            orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
            orderInfo.setPeopleNum(customerNumbers.stream().mapToInt(Integer::intValue).sum());
            orderInfoDao.updateByPrimaryKeySelective(orderInfo);
        }
    }

    private void cancelMealTable(O_BookingInfoEntity bookingInfo, Long tableID,Long tableStatus) {
        //修改原桌台的餐次桌台关联数据
        B_DinningTableInfoEntity tableInfo = tableComponent.getTableInfoById(tableID);
        List<B_MealTableMappingEntity> mainMealTableList = mealTableMappingDao.getBetweenMealsTableMapping(tableInfo.getTableID(), bookingInfo.getBookingTime(), NumberUtil.add(bookingInfo.getDuration(),bookingInfo.getExtraMinute()));
        if (CollectionUtils.isEmpty(mainMealTableList)) {
            throw new BizException(CodeMsgConstants.NO_TABLE_MEALS_MAPPING_DATA, CodeMsgConstants.NO_TABLE_MEALS_MAPPING_DATA_MSG, tableInfo.getTableName());
        }
        for(B_MealTableMappingEntity mealTable: mainMealTableList){
            mealTable.setTableStatus(tableStatus);
            mealTableMappingDao.updateByPrimaryKeySelective(mealTable);
        }
    }


    /**
     * @Description： 转台
     * @Author：LanZY
     * @Time: 2017-6-13 17:42
     * @Version 2.0.0
     * @param bookingID
     * @param mainTableIDs   主桌台ID（转出台ID）
     * @param viceTableIDs   副桌台ID（被转出台ID）
     */
    @Transactional(rollbackFor = Exception.class)
    public void turnTable(Long bookingID,List<Long> mainTableIDs,List<Long> viceTableIDs,Long loginID) throws Exception{
        if(CollectionUtils.isEmpty(mainTableIDs)){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if(CollectionUtils.isEmpty(viceTableIDs)){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if(mainTableIDs.size() != viceTableIDs.size()){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        //取消的总价格
        BigDecimal cancelTotalPrice = BigDecimal.ZERO;
        //取消的总数量
        Integer cancelTotalNum = 0;
        //查询预定单
        O_BookingInfoEntity bookingInfo = orderComponent.getBookingInfoByID(bookingID);
        for (int i = 0; i < mainTableIDs.size(); i++) {
            //修改原桌台的餐次桌台关联数据
            cancelMealTable(bookingInfo, mainTableIDs.get(i),MerchantManageEnum.TableStatus.EMPTYTABLE.getValue());
            //查询主桌台的预定子订单
            O_SubOrderInfoEntity mainBookingSubOrderInfo =  orderComponent.getBookingSubOrderInfo(bookingInfo.getOrderID(), mainTableIDs.get(i));
            //1表示为取消的预订单 不等于1表示转台
            if(NumberUtil.intValue(viceTableIDs.get(i)) == -1){
                cancelTotalPrice = BigDecimalUtil.add(cancelTotalPrice,mainBookingSubOrderInfo.getTotalAmount());
                cancelTotalNum = NumberUtil.add(cancelTotalNum,mainBookingSubOrderInfo.getQuantity());
                //修改为客户取消状态
                mainBookingSubOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.MANUALCANCEL.getValue());
                subOrderInfoDao.updateByPrimaryKeySelective(mainBookingSubOrderInfo);
                //新增子订单处理信息
                orderDealInfoService.saveOrderDealInfo(mainBookingSubOrderInfo.getSubOrderID(),bookingInfo.getOrderID(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,OrderManageEnum.OrderStatus.BOOKING.getValue(),OrderManageEnum.OrderStatus.MANUALCANCEL.getValue(),"");
            }else{
                //查询被转的桌台子订单
                O_SubOrderInfoEntity viceBookingSubOrderInfo = subOrderInfoDao.getBookingSubOrderInfo(bookingInfo.getOrderID(), viceTableIDs.get(i));
                if(null == viceBookingSubOrderInfo){
                    //修改原桌台子订单桌台ID
                    mainBookingSubOrderInfo.setTableID(viceTableIDs.get(i));
                    subOrderInfoDao.updateByPrimaryKeySelective(mainBookingSubOrderInfo);
                    //修改被转桌台的餐次桌台关联数据
                    cancelMealTable(bookingInfo, viceTableIDs.get(i),MerchantManageEnum.TableStatus.PREDETERMINE.getValue());
                } else {
                    //修改原桌台子订单状态为客户取消状态
                    mainBookingSubOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.MANUALCANCEL.getValue());
                    subOrderInfoDao.updateByPrimaryKeySelective(mainBookingSubOrderInfo);
                    //新增子订单处理信息
                    orderDealInfoService.saveOrderDealInfo(mainBookingSubOrderInfo.getSubOrderID(),bookingInfo.getOrderID(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,OrderManageEnum.OrderStatus.BOOKING.getValue(),OrderManageEnum.OrderStatus.MANUALCANCEL.getValue(),"");
                    //新增子订单处理信息
                    orderDealInfoService.saveOrderDealInfo(viceBookingSubOrderInfo.getSubOrderID(),bookingInfo.getOrderID(), mainBookingSubOrderInfo.getTotalAmount(), viceBookingSubOrderInfo.getTotalAmount(), BigDecimalUtil.add(mainBookingSubOrderInfo.getTotalAmount(), viceBookingSubOrderInfo.getTotalAmount()),null,null,"");
                    //修改被转桌台子订单
                    viceBookingSubOrderInfo.setQuantity(NumberUtil.add(mainBookingSubOrderInfo.getQuantity(),viceBookingSubOrderInfo.getQuantity()));
                    viceBookingSubOrderInfo.setTotalAmount(BigDecimalUtil.add(mainBookingSubOrderInfo.getTotalAmount(), viceBookingSubOrderInfo.getTotalAmount()));
                    viceBookingSubOrderInfo.setActualAmount(BigDecimalUtil.add(mainBookingSubOrderInfo.getActualAmount(), viceBookingSubOrderInfo.getActualAmount()));
                    viceBookingSubOrderInfo.setPendingAmount(BigDecimalUtil.add(mainBookingSubOrderInfo.getPendingAmount(), viceBookingSubOrderInfo.getPendingAmount()));
                    subOrderInfoDao.updateByPrimaryKeySelective(viceBookingSubOrderInfo);
                    //查询转出台的订单明细再改变桌台ID为被转的台
                    List<O_OrderDetailInfoEntity> orderDetailInfoList = orderDetailInfoDao.getOrderDetailInfoListBySubOrderID(mainBookingSubOrderInfo.getSubOrderID());
                    for (O_OrderDetailInfoEntity orderDetailInfo : orderDetailInfoList){
                        orderDetailInfo.setTableID(viceTableIDs.get(i));
                        orderDetailInfoDao.updateByPrimaryKeySelective(orderDetailInfo);
                    }
                }
            }
        }
        //修改订单记录
        if(cancelTotalNum > 0){
            O_OrderInfoEntity orderInfo = orderInfoDao.selectByPrimaryKey(bookingInfo.getOrderID());
            //新增子订单处理信息
            orderDealInfoService.saveOrderDealInfo(null,bookingInfo.getOrderID(), cancelTotalPrice, orderInfo.getTotalAmount(), BigDecimalUtil.sub(orderInfo.getTotalAmount(), cancelTotalPrice),null,null,"");
            orderInfo.setQuantity(NumberUtil.subtract(cancelTotalNum,orderInfo.getQuantity()));
            orderInfo.setTotalAmount(BigDecimalUtil.sub(orderInfo.getTotalAmount(), cancelTotalPrice));
            orderInfo.setActualAmount(BigDecimalUtil.sub(orderInfo.getActualAmount(), cancelTotalPrice));
            orderInfo.setPendingAmount(BigDecimalUtil.sub(orderInfo.getPendingAmount(), cancelTotalPrice));
            orderInfoDao.updateByPrimaryKeySelective(orderInfo);
        }
    }

    /**
     * @param tableHandle
     * @param tableIDs
     * @param numbers
     * @throws Exception
     * @Description： 桌台处理
     * @Author：LanZY
     * @Time: 2017-5-22 16:40
     * @Version 2.0.0
     */
    public void handleTableMappingInfo(TableHandleVO tableHandle, List<Long> tableIDs, List<Integer> numbers) throws Exception {
        for (int i = 0; i < tableIDs.size(); i++) {
            //查询桌台信息
            B_DinningTableInfoEntity tableInfo = tableComponent.getTableInfoById(tableIDs.get(i));
            //检查桌台当前使用信息是否异常
            tableComponent.checkDinningTableUseInfoIsError(tableInfo);
            //清空购物车
            shoppingCartService.cleanShoppingCart(tableIDs.get(i),Boolean.FALSE);
            //餐次ID
            Long mealsID;
            B_MealsInfoEntity mealsInfo;
            // 不等于0表示根据前厅传过来的餐次ID开台
            if (tableHandle.getMealsID() != 0) {
                mealsID = tableHandle.getMealsID();
                mealsInfo = mealComponent.getMealsInfoByMealsID(mealsID);
            } else {
                //根据档案ID,区域ID查询餐次
                mealsInfo = mealComponent.getCurrentMealsInfo(tableInfo);
                mealsID = mealsInfo.getMealsID();
            }
            //是否预定桌台的处理
            checkMealTable(tableInfo, mealsInfo);
            //修改桌台信息
            tableInfo.setPeopleNum(numbers.get(i));
            tableInfo.setTableStatus(MerchantManageEnum.TableStatus.PLACEORDER.getValue());
            tableInfo.setCombineName(tableHandle.getCombineName());
            tableInfo.setCombineNumber(tableHandle.getCombineNumber());
            tableInfo.setShareNumber(1);
            dinningTableInfoDao.updateByPrimaryKeySelective(tableInfo);
            //增加桌台使用信息
            B_DinningTableUseInfoEntity newTableUserInfo = new B_DinningTableUseInfoEntity();
            newTableUserInfo.setTableID(tableIDs.get(i));
            newTableUserInfo.setCombineNumber(numbers.size());
            newTableUserInfo.setWaiterLoginID(tableHandle.getLoginID());
            newTableUserInfo.setCashierLoginID(tableHandle.getLoginID());
            newTableUserInfo.setMealsID(mealsID);
            newTableUserInfo.setStartTime(LocalDateTime.now());
            newTableUserInfo.setCreateTime(LocalDateTime.now());
            newTableUserInfo.setCustomerNumber(numbers.get(i));
            newTableUserInfo.setCombineName(tableHandle.getCombineName());
            newTableUserInfo.setIsSync(Boolean.FALSE);
            newTableUserInfo.setIsCombine(tableHandle.isCombine());
            newTableUserInfo.setArchiveID(tableInfo.getArchiveID());
            newTableUserInfo.setHisID(MaxIDUtils.getID(B_DinningTableUseInfoEntity.class));
            newTableUserInfo.setMemo("LZY");
            dinningTableUseInfoDao.insertSelective(newTableUserInfo);
            // 新增子订单
            O_SubOrderInfoEntity subOrderInfo = new O_SubOrderInfoEntity();
            subOrderInfo.setTableName(tableInfo.getTableName());
            subOrderInfo.setOrderID(tableHandle.getOrderID());
            subOrderInfo.setPeopleNum(numbers.get(i));
            subOrderInfo.setCreatorID(tableHandle.getLoginID());
            subOrderInfo.setMealsID(mealsID);
            subOrderInfo.setTableID(tableIDs.get(i));
            subOrderInfo.setCreatorType(SystemManageEnum.UserType.SYSTEMUSER.getValue());
            subOrderInfo.setActualAmount(BigDecimal.ZERO);//子订单实际金额
            subOrderInfo.setTotalAmount(BigDecimal.ZERO);//子订单的总金额
            subOrderInfo.setQuantity(0);//子订单的数量
            subOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.NOORDER.getValue());
            subOrderInfo.setSubOrderID(MaxIDUtils.getID(O_SubOrderInfoEntity.class));
            subOrderInfo.setCreateTime(LocalDateTime.now());
            subOrderInfoDao.insertSelective(subOrderInfo);
        }
    }

    /**
     * 普通开台检查餐次桌台关联信息
     *
     * @param tableInfo   桌台信息
     * @param mealsInfo   餐次信息
     * @throws Exception
     */
    private void checkMealTable(B_DinningTableInfoEntity tableInfo, B_MealsInfoEntity mealsInfo) throws Exception {
        //是否预订
        if (tableInfo.getCanBooking()) {
            List<B_MealTableMappingEntity> mealTableList = mealTableMappingDao.getBetweenMealsTableMapping(tableInfo.getTableID(), LocalDateTime.now(), mealsInfo.getSegmentLength());
            if (CollectionUtils.isNotEmpty(mealTableList)) {
                for (B_MealTableMappingEntity meal : mealTableList) {
                    if (meal.getTableStatus().equals(MerchantManageEnum.TableStatus.PREDETERMINE.getValue())) {
                        throw new BizException(CodeMsgConstants.TABLE_IS_RESERVE, CodeMsgConstants.TABLE_IS_RESERVE_MSG, tableInfo.getTableName());
                    }
                }
                mealTableMappingService.updateMealTableMappingTableStatus(mealTableList);
            }
        }
    }

    /**
     * 检查预定桌台的餐次桌台关联信息
     *
     * @param tableInfo
     * @param booking
     * @throws Exception
     */
    private void checkMealBookTable(B_DinningTableInfoEntity tableInfo,O_BookingInfoEntity booking) throws Exception{
        List<B_MealTableMappingEntity> mealTableList = mealTableMappingDao.getBetweenMealsTableMapping(tableInfo.getTableID(),booking.getBookingTime(), NumberUtil.add(booking.getDuration(),booking.getExtraMinute()));
        if (CollectionUtils.isEmpty(mealTableList)) {
            throw new BizException(CodeMsgConstants.NO_TABLE_MEALS_MAPPING_DATA, CodeMsgConstants.NO_TABLE_MEALS_MAPPING_DATA_MSG, tableInfo.getTableName());
        }
        for (B_MealTableMappingEntity meal : mealTableList) {
            if (!meal.getTableStatus().equals(MerchantManageEnum.TableStatus.PREDETERMINE.getValue())) {
                throw new BizException(CodeMsgConstants.MEALS_MAPPING_DATA_ERROR, CodeMsgConstants.MEALS_MAPPING_DATA_ERROR_MSG, tableInfo.getTableName());
            }
        }
        mealTableMappingService.updateMealTableMappingTableStatus(mealTableList);
    }


    /**
     * @throws Exception
     * @Description： 桌台处理 加台
     * @Author：LanZY
     * @Time: 2017-4-1 10:31
     * @Version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public void addTable(Long mainTableID, List<Long> viceTableIDs,List<Integer> customerNumbers, Long mealsID, Long loginID) throws Exception {
        if(CollectionUtils.isEmpty(viceTableIDs)){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if(CollectionUtils.isEmpty(customerNumbers)){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if(viceTableIDs.size() != customerNumbers.size()){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        //联台名称
        String combineTableName = DinningTableInfoConstants.COMBINE_TABLENAME + TableUtils.getCombineTableSequence();
        //有多个餐次桌台id一起传入使用逗号分隔
        int numbers = customerNumbers.stream().mapToInt(Integer::intValue).sum(); //总人数
        if(intValue(loginID) < 1){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        //根据桌台编号查询正在进行或未下单的子订单
        List<O_SubOrderInfoEntity> subOrderList =  orderComponent.getSubOrderInfoByTableId(mainTableID);
        O_OrderInfoEntity order = new O_OrderInfoEntity();
        if (!CollectionUtils.isEmpty(subOrderList)) {
            //查询订单，修改实际的就餐人数
            order.setOrderID(subOrderList.get(0).getOrderID());
            order.setActualAmount(BigDecimal.ZERO);//订单实际金额
            order.setTotalAmount(BigDecimal.ZERO);//订单的总金额
            order.setQuantity(0);
            order = orderInfoDao.get(order);
            order.setPeopleNum(order.getPeopleNum() + numbers);
            orderInfoDao.updateByPrimaryKeySelective(order);
        } else {
            throw new BizException(CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST, CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST_MSG, mainTableID);
        }
        //主桌台加台处理信息
        Map<String, Object> resultMap = addTableMainTableHandle(mainTableID, combineTableName, viceTableIDs);
        //处理副桌台关联信息
        TableHandleVO tableHandle = new TableHandleVO();
        tableHandle.setLoginID(loginID);
        tableHandle.setCombineName(ObjectUtil.objectToString(resultMap.get("combineTableName")));
        tableHandle.setCombineNumber(ObjectUtil.objectToInteger(resultMap.get("combineNumber")));
        tableHandle.setOrderID(order.getOrderID());
        tableHandle.setMealsID(mealsID);
        tableHandle.setCombine(Boolean.TRUE);
        handleTableMappingInfo(tableHandle, viceTableIDs, customerNumbers);
    }


    /**
     * @param mainTableId      主桌台ID
     * @param combineTableName 联台名称
     * @param viceTableIds     副桌台ID （用于设置关联桌台字段）
     * @return map             combineTableName:联台名称  relationTable:关联桌台名称 combineNumber:联台数量 tableStatus:状态
     * @throws Exception
     * @Description： 主桌台加台处理信息
     * @Author：LanZY
     * @Time: 2017-4-5 14:01
     * @Version 2.0.0
     */
    public Map<String, Object> addTableMainTableHandle(Long mainTableId, String combineTableName, List<Long> viceTableIds) throws Exception {
        //主桌台信息表的更改 修改联台名称
        B_DinningTableInfoEntity mainTable = new B_DinningTableInfoEntity();
        mainTable.setTableID(mainTableId);
        mainTable = dinningTableInfoDao.getDinningTableInfoEntityByTableId(mainTable);
        if (null != mainTable) {
            if (StringUtils.isEmpty(mainTable.getCombineName())) {
                mainTable.setCombineName(combineTableName);
            }
            mainTable.setCombineNumber(mainTable.getCombineNumber() + viceTableIds.size());
            dinningTableInfoDao.updateByPrimaryKeySelective(mainTable);
        }
        combineTableName = mainTable.getCombineName();

        //全部关联桌台集合(用于设置关联桌台字段)
        List<Long> tableIds = new ArrayList<>();
        tableIds.addAll(viceTableIds);

        Set<Long> combinedTableIDs = getCombinedTableIDs(mainTable);
        if (CollectionUtils.isNotEmpty(combinedTableIDs)) {
            for (Long tableId : combinedTableIDs) {
                //排除主桌台（上面已经修改过）
                if (!tableId.equals(mainTableId)) {
                    //查询关联桌台信息表 修改联台名称
                    B_DinningTableInfoEntity table = tableComponent.getTableInfoById(tableId);
                    table.setCombineName(combineTableName);
                    table.setCombineNumber(mainTable.getCombineNumber() + viceTableIds.size());
                    dinningTableInfoDao.updateByPrimaryKeySelective(table);
                }
            }
        } else {
            tableIds.add(mainTableId);
        }
        Map<String, Object> resultMap = new HashedMap();
        resultMap.put("combineTableName", combineTableName);
        resultMap.put("relationTable", StringUtils.join(tableIds.toArray(), ","));
        resultMap.put("combineNumber", mainTable.getCombineNumber() + viceTableIds.size());
        resultMap.put("tableStatus", mainTable.getTableStatus());
        return resultMap;
    }

    /**
     * @Description： 查询占用桌台的菜品数量
     * @Author：LanZY
     * @Time: 2017-6-14 15:56
     * @Version 2.0.0
     * @param bookingID
     * @param tableIDs
     * @return
     */
    public List<TurnTableProductVO> turnTableProductList(Long bookingID, List<Long> tableIDs){
        List<TurnTableProductVO> turnTableList = new ArrayList<>();
        //查询预定单
        O_BookingInfoEntity bookingInfo = orderComponent.getBookingInfoByID(bookingID);
        for(Long tableID : tableIDs){
            //查询占用桌台子订单
            O_SubOrderInfoEntity bookingSubOrderInfo = orderComponent.getBookingSubOrderInfo(bookingInfo.getOrderID(), tableID);
            List<O_OrderDetailInfoEntity> orderDetailInfoLis = orderDetailInfoDao.getOrderDetailInfoListBySubOrderID(bookingSubOrderInfo.getSubOrderID());
            Integer quantity = 0;
            if(CollectionUtils.isNotEmpty(orderDetailInfoLis)){
                quantity = orderDetailInfoLis.size();
            }
            TurnTableProductVO turnTableProduct = new TurnTableProductVO();
            turnTableProduct.setQuantity(quantity);
            turnTableProduct.setTableID(tableID);
            turnTableProduct.setTableName(bookingSubOrderInfo.getTableName());
            turnTableList.add(turnTableProduct);
        }
        return turnTableList;
    }

    /**
     * @param map nameOrId  名称或者编号 job 岗位
     * @return 开台人列表
     * @Description： 根据名称或编号和岗位查询开台人列表
     * @Author：LanZY
     * @Time: 2017-3-23 15:27
     * @Version 2.0.0
     */
    public List<Map<String, Object>> getOriginalList(Map<String, Object> map) {
        return loginInfoDao.getOriginalList(map);
    }


    /**
     * @param mealsInfo
     * @return
     * @Description： 根据档案ID和区域ID查询当前时间区间的餐次列表
     * @Author：LanZY
     * @Time: 2017-5-31 10:49
     * @Version 2.0.0
     */
    public List<B_MealsInfoEntity> getMealsBetween(B_MealsInfoEntity mealsInfo) {
        return mealsInfoDao.getMealsBetween(mealsInfo);
    }


}
