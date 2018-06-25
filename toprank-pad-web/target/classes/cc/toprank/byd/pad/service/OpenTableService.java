package cc.toprank.byd.pad.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.service.MonitorService;
import cc.toprank.byd.service.StallWeighService;
import cc.toprank.byd.util.EnumUtil;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.util.OrderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开台
 *
 * @author LeeJun
 * @create 2017-05-18 15:57
 */
@Service
public class OpenTableService {

    protected final static Logger LOGGER = LoggerFactory.getLogger(OpenTableService.class);
    @Autowired
    private B_DinningTableInfoDao tableInfoDAO;
    @Autowired
    private O_BookingInfoDao bookingDAO;
    @Autowired
    private B_MealTableMappingDao mealTableDAO;
    @Autowired
    private O_OrderInfoDao orderInfoDao;
    @Autowired
    private O_SubOrderInfoDao subOrderInfoMapper;
    @Autowired
    private BookingService bookingService;
    @Autowired
    private O_OrderDetailInfoDao orderDetailInfoDao;
    @Autowired
    private StallWeighService stallWeighService;
    @Autowired
    private MonitorService monitorService;
    @Autowired
    private B_DinningTableInfoDao tableInfoDao;
    @Autowired
    private B_DinningTableUseInfoDao tableUseInfoDao;
    @Autowired
    private ShoppingCartService shoppingCartService;


    /**
     * 普通开台
     *
     * @author LeeJun
     * @time 2017-5-18 16:12
     * @version 2.0.0
     */
    @Transactional
    public Map<String, Object> openTable(Long tableID, int personNumber, String memo) {
        // 清空当前桌台购物车信息
        shoppingCartService.cleanShoppingCart(tableID, false);
        // 获得桌台信息
        B_DinningTableInfoEntity table = tableInfoDAO.selectByPrimaryKey(tableID);
        // 获得当前餐次
        B_MealsInfoEntity mealsInfo = CommonMapper.getCurrentMealsInfo();
        // 验证当前用餐人数
        this.checkTablePerson(personNumber, table);
        // 检查是否可开台
        this.checkMealTableStatus(table.getTableID(), mealsInfo);
        // 添加桌台使用信息并修改桌台信息
        this.addTableUseInfo(table, personNumber, mealsInfo.getMealsID(), memo);
        // 添加订单子订单信息
        return addOrderInfo(tableID, mealsInfo);

    }

    /**
     * 预定开台 修改预定信息 到店时间 修改桌台信息 和 保存 桌台使用信息表
     *
     * @author LeeJun
     * @time 2017-5-19 11:47
     * @version 2.0.0
     */
    @Transactional
    public Map<String, Object> bookingOpenTable(Long bookingID, Long tableID, int personNumber, String memo) {
        B_DinningTableInfoEntity table = tableInfoDAO.selectByPrimaryKey(tableID);
        O_BookingInfoEntity bookingInfo = bookingDAO.getByID(bookingID);
        B_MealsInfoEntity mealsInfo = CommonMapper.getCurrentMealsInfo();
        // 清空当前桌台购物车信息
        shoppingCartService.cleanShoppingCart(tableID, false);
        // 验证当前用餐人数
        this.checkTablePerson(personNumber, table);
        // 是否可预定开台
        boolean isOpen = bookingService.checkBookingCanOpenTable(bookingInfo, table.getTableStatus(), mealsInfo.getMinLength());
        if (!isOpen) {
            throw new BizException("当前预定单不在开台时间范围内！");
        }
        // 检查当前餐次桌台状态
        this.checkBookingMealTableStatus(tableID, bookingInfo);
        // 添加桌台使用信息
        this.addTableUseInfo(table, personNumber, mealsInfo.getMealsID(), memo);
        // 修改预定单的到店时间
        bookingService.updateArrivalTime(bookingID);
        // 查询预定点菜信息
        List<Long> detailIDList = orderDetailInfoDao.getDetailIDByOrderID(bookingInfo.getOrderID());
        if (!detailIDList.isEmpty()) {
            // 如有称重菜,记录待称重菜品信息
            stallWeighService.addStallWeighInfo(detailIDList);
            // 添加菜品信息到厨师看板中
            monitorService.addWaitMakeProduct2DesignerMonitorInfo(detailIDList);
        }
        // 改订单及子订单状态、就餐人数及备注
        this.updateOrderStatus(bookingInfo.getOrderID(), bookingInfo.getSubOrderID(), personNumber, memo);
        Map<String, Object> result = new HashMap<>();
        O_SubOrderInfoEntity subOrderInfo = subOrderInfoMapper.selectByPrimaryKey(bookingInfo.getSubOrderID());
        result.put("orderCode", subOrderInfo.getOrderCode());
        result.put("orderID", bookingInfo.getOrderID());
        result.put("subOrderID", bookingInfo.getSubOrderID());
        return result;
    }


    /**
     * 检查当前餐次桌台状态是否有非空台和非预定（当前时间至当前时间+最短就餐时长这段时间内是否存在非空台和非预定状态的餐次桌台数据）
     * 无则开台，修改当前时间下的餐段信息状态为开台
     *
     * @author LeeJun
     * @time 2017-5-19 11:16
     * @version 2.0.0
     */
    public void checkBookingMealTableStatus(Long tableID, O_BookingInfoEntity booking) {
        Integer minLength = NumberUtil.add(booking.getDuration(), booking.getExtraMinute());
        // 修改餐段信息
        List<B_MealTableMappingEntity> mealTableList = mealTableDAO.getBetweenMealsTableMapping(tableID, booking.getBookingTime(), minLength);
        if (mealTableList.isEmpty()) {
            throw new BizException("餐次桌台关联不能为空！");
        }
        String segmentIDs = "";
        for (B_MealTableMappingEntity mapping : mealTableList) {
            // 判断桌台状态是否为可用
            if (!mapping.getTableStatus().equals(MerchantManageEnum.TableStatus.PREDETERMINE.getValue())) {
                throw new BizException("当前餐次桌台状态为不可用！");
            }
            segmentIDs += mapping.getSegmentID() + ",";
        }
        segmentIDs = StringUtil.cutoffLastExcision(segmentIDs, ",");
        if (!StringUtils.isEmpty(segmentIDs)) {
            // 修改就餐时间段内的餐次桌台状态为开台
            mealTableDAO.updateStatusBatchByID(MerchantManageEnum.TableStatus.PLACEORDER.getValue(), segmentIDs);
        }
    }

    /**
     * 检查当前餐次桌台状态是否有非空台（当前时间至当前时间+最短就餐时长这段时间内是否存在非空闲状态的餐次桌台数据）
     * 无则开台，修改当前时间下的餐段信息状态为开台
     *
     * @author LeeJun
     * @time 2017-5-18 18:18
     * @version 2.0.0
     */
    protected void checkMealTableStatus(Long tableID, B_MealsInfoEntity mealsInfo) {
        // 修改餐段信息
        List<B_MealTableMappingEntity> mealTableList = mealTableDAO.getBetweenMealsTableMapping(tableID, LocalDateTime.now(), mealsInfo.getSegmentLength());
        String segmentIDs = "";
        for (B_MealTableMappingEntity mapping : mealTableList) {
            // 判断桌台状态是否为可用
            if (!mapping.getTableStatus().equals(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue())) {
                throw new BizException("当前餐次桌台状态为不可用！");
            }
            segmentIDs += mapping.getSegmentID() + ",";
        }
        segmentIDs = StringUtil.cutoffLastExcision(segmentIDs, ",");
        if (!StringUtils.isEmpty(segmentIDs)) {
            // 修改就餐时间段内的餐次桌台状态为开台
            mealTableDAO.updateStatusBatchByID(MerchantManageEnum.TableStatus.PLACEORDER.getValue(), segmentIDs);
        }
    }


    /**
     * 验证开台人数是否有效
     *
     * @author LeeJun
     * @time 2017-5-18 16:29
     * @version 2.0.0
     */
    protected void checkTablePerson(int personNumber, B_DinningTableInfoEntity tableInfo) {
        if (personNumber > tableInfo.getMaxPerson()) {
            BizException.error("人数超出桌台可容纳最大人数");
        }
        if (personNumber < tableInfo.getMinPerson()) {
            BizException.error("人数小于桌台最小人数");
        }
    }

    /**
     * 添加桌台使用信息并修改桌台信息
     *
     * @author LeeJun
     * @time 2017-5-18 18:34
     * @version 2.0.0
     */
    protected void addTableUseInfo(B_DinningTableInfoEntity table, int personNumber, Long mealsID, String memo) {
        LocalDateTime now = LocalDateTime.now();
        // 修改桌台状态
        table.setTableStatus(MerchantManageEnum.TableStatus.PLACEORDER.getValue());
        table.setShareNumber(1);
        table.setCombineNumber(1);
        table.setPeopleNum(personNumber);
        table.setMemo(memo);
        tableInfoDAO.updateByPrimaryKeySelective(table);
        // 新增桌台使用记录状态
        B_DinningTableUseInfoEntity dinningTableUseInfo = tableUseInfoDao.getDinningTableUseInfoByTableIDAndEndTime(table.getTableID());
        if (dinningTableUseInfo == null) {
            B_DinningTableUseInfoEntity tableUse = new B_DinningTableUseInfoEntity();
            tableUse.setHisID(MaxIDUtils.getID(B_DinningTableUseInfoEntity.class));
            tableUse.setTableID(table.getTableID());
            tableUse.setArchiveID(table.getArchiveID());
//        B_TableManagerInfoEntity currentManager = CommonMapper.getTableCurrentManager();
//        if (currentManager != null) {
//            tableUse.setWaiterLoginID(currentManager.getLoginID());
//        }
            tableUse.setMealsID(mealsID);
            tableUse.setStartTime(now);
            tableUse.setCreateTime(now);
            tableUse.setCustomerNumber(personNumber);
            tableUse.setMemo("水牌开台");
            tableUse.setUseMethod(MerchantManageEnum.UseWay.LICENSE.getValue());
            tableUseInfoDao.insertSelective(tableUse);
        }
    }

    /**
     * 生成订单子订单信息
     *
     * @author LeeJun
     * @time 2017-5-18 19:07
     * @version 2.0.0
     */
    protected Map<String, Object> addOrderInfo(Long tableID, B_MealsInfoEntity mealsInfo) {
        B_DinningTableInfoEntity tableInfo = tableInfoDao.selectByPrimaryKey(tableID);
        // 添加订单信息
        BigDecimal zero = new BigDecimal(0.0);
        Long orderID = MaxIDUtils.getID(O_OrderInfoEntity.class);
        Long subOrderID = MaxIDUtils.getID(O_SubOrderInfoEntity.class);
        String orderCode = OrderUtil.getOrderCode();
        O_OrderInfoEntity orderInfo = new O_OrderInfoEntity();
        orderInfo.setOrderID(orderID);
        orderInfo.setArchiveID(mealsInfo.getArchiveID());
        orderInfo.setPeopleNum(tableInfo.getDefaultPerson());
        orderInfo.setCommission(zero);
        orderInfo.setOrderChannel(MerchantManageEnum.OrderChannel.LICENSE.getValue());
        orderInfo.setTotalAmount(zero);
        orderInfo.setOrderCode(orderCode);
        orderInfo.setDiscountAmount(zero);
        orderInfo.setActualAmount(zero);
        orderInfo.setPendingAmount(zero);
        orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.NOORDER.getValue());
        orderInfo.setPayStatus(OrderManageEnum.PayStatus.WAITINGPAY.getValue());
        orderInfo.setCreateTime(LocalDateTime.now());
        orderInfoDao.insertSelective(orderInfo);
        // 添加子订单信息
        O_SubOrderInfoEntity subOrderInfo = new O_SubOrderInfoEntity();
        BeanUtils.copyProperties(orderInfo, subOrderInfo);
        subOrderInfo.setMealsID(mealsInfo.getMealsID());
        subOrderInfo.setSubOrderID(subOrderID);
        subOrderInfo.setTableID(tableID);
        subOrderInfo.setTableName(tableInfo.getTableName());
        subOrderInfoMapper.insertSelective(subOrderInfo);
        Map<String, Object> result = new HashMap<>();
        result.put("orderCode", orderCode);
        result.put("orderID", orderID);
        result.put("subOrderID", subOrderID);
        return result;
    }

    /**
     * 修改订单及子订单状态、就餐人数及备注
     *
     * @author LeeJun
     * @time 2017-6-1 13:47
     * @version 2.0.0
     */
    public void updateOrderStatus(Long orderID, Long subOrderID, int personNumber, String memo) {
        O_OrderInfoEntity orderInfo = new O_OrderInfoEntity();
        orderInfo.setOrderID(orderID);
        orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
        orderInfo.setPeopleNum(personNumber);
        orderInfo.setMemo(memo);
        orderInfoDao.updateByPrimaryKeySelective(orderInfo);
        O_SubOrderInfoEntity subOrderInfo = new O_SubOrderInfoEntity();
        subOrderInfo.setSubOrderID(subOrderID);
        subOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
        subOrderInfo.setPeopleNum(personNumber);
        subOrderInfo.setMemo(memo);
        subOrderInfoMapper.updateByPrimaryKeySelective(subOrderInfo);
    }
}
