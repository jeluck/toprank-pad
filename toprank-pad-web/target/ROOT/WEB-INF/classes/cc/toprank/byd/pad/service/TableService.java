package cc.toprank.byd.pad.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.CommonUtils;
import cc.toprank.byd.common.utils.MapHelper;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.MerchantManageEnum.TableStatus;
import cc.toprank.byd.enums.MerchantManageEnum.UseWay;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import cc.toprank.byd.web.util.OrderUtil;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private B_DinningTableInfoDao tableInfoDAO;
    @Autowired
    private O_OrderInfoDao orderDAO;
    @Autowired
    private B_MealsInfoDao mealsDAO;
    @Autowired
    private O_BookingInfoDao bookingDAO;
    @Autowired
    private B_DinningTableUseInfoDao tableUserDAO;
    @Autowired
    private B_MealTableMappingDao mealTableDAO;
    @Autowired
    private B_ShopAreaInfoDao shopAreaInfoDAO;
    @Autowired
    private O_OrderInfoDao orderInfoMapper;
    @Autowired
    private O_SubOrderInfoDao subOrderInfoMapper;
    @Autowired
    private BookingService bookingService;

    private final static String SHARE_PREFIX = "拼-";

    /**
     * 1.根据tableID 查询桌台基本信息
     * 2.查询当前餐次
     * 3.查询桌台使用中订单列表
     * 4.查询桌台预订单列表
     *
     * @author LiSH @date 2017年1月19日
     * @description: 查询桌台基本信息  test tableID 2209
     */
    public Map<String, Object> getTableDetailByTableID(Long tableID) {
        Map<String, Object> result = MapHelper.newMap();
        //桌台详情
        Map<String, Object> tableDetail = null;
        try {
            tableDetail = tableInfoDAO.getTableBaseDetailByTableID(tableID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //当前餐次
        B_MealsInfoEntity currentMealsInfo = null;
        try {
            currentMealsInfo = CommonMapper.getCurrentMealsInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //订单列表
        Map<String, Object> ordersByTableID = getOrdersByTableID(tableID);

        result.putAll(ordersByTableID);
        result.put("tableDetail", tableDetail);
        result.put("mealsInfo", currentMealsInfo);
        return result;
    }

    /**
     * 1.查询使用中订单列表
     * 2.查询预定中订单列表
     *
     * @author LiSH @date 2017年1月19日
     * @Description: 根据tableID 查询 使用中订单 预订单列表
     */
    public Map<String, Object> getOrdersByTableID(Long tableID) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 使用中订单列表
            result.put("getUsingOrderList", getUsingOrderList(tableID));
        } catch (Exception e) {
            logger.info("getUsingOrderList is error" + e);
        }
        try {
            //获得预订列表
            result.put("bookingOrderList", getBookingOrderList(tableID));
        } catch (Exception e) {
            logger.info("getBookingOrderList is error" + e);
        }
        return result;
    }

    /**
     * @description 根据桌台ID获得当前的使用中订单列表
     * @author LiSH
     * @time 2017-3-9 16:46
     * @version 2.0.0
     */
    public List<Map<String, Object>> getUsingOrderList(Long tableID) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("tableID", tableID);
        map.put("orderStatus", OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
        return orderDAO.getUsingOrderList(map);
    }

    /**
     * @description 根据当前时间获得桌台的预订单列表
     * @author LiSH
     * @time 2017-3-9 16:43
     * @version 2.0.0
     */
    private List<O_BookingInfoEntity> getBookingOrderList(Long tableID) {
        B_MealsInfoEntity mealsInfo = CommonMapper.getCurrentMealsInfo();
        B_DinningTableInfoEntity currentTable = CommonMapper.getCurrentTable();
        LocalDate now = LocalDate.now();
        List<O_BookingInfoEntity> bookingList = orderDAO.getBookingOrderListByTableIDAndMealsID(tableID, mealsInfo.getMealsID(), now);
        int i = 0;
        for (O_BookingInfoEntity booking : bookingList) {
            String bookingDesc = CommonUtils.getNameByValue(MerchantManageEnum.BookingChannel.class, booking.getBookingChannel());
            booking.setBookingDesc(bookingDesc);
            boolean isOpen = bookingService.isOpenTable(booking, currentTable.getTableStatus());
            booking.setCanOpen(isOpen);
            if(i ==  0){
                booking.setCanOpen(true);
            }
            i++;
        }
        return bookingList;
    }


    /**
     * @author LiSH @date 2017年1月17日
     * @Description: 非预定开台 根据tableID 就餐人数 说明信息 进行开台
     */
    @Transactional
    public Map<String, Object> openTable(Long tableID, Integer personNumber, String desc, Long personID) {
        List<Map<String, Object>> usingOrderList = getUsingOrderList(tableID);
        if (usingOrderList.size() > 0) {
            //拼桌开台
            Map<String, Object> result = shareOpenTable(tableID, personNumber, desc, personID);
            return result;
        }
        LocalDateTime now = LocalDateTime.now();
        // 获得桌台信息
        B_DinningTableInfoEntity table = tableInfoDAO.selectByPrimaryKey(tableID);
        // 获得当前餐次
        B_MealsInfoEntity mealsInfo = CommonMapper.getCurrentMealsInfo();
        // 修改桌台餐段信息(包含开台前置逻辑判断)
        openTableCheck(table, mealsInfo, personNumber, now);
        // 开台 >>修改桌台信息 和 保存 桌台使用信息表
        Map<String, Object> result = openTable(personNumber, personID, table, mealsInfo, desc);
        return result;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 拼桌开台
     * @time 2017-4-20 13:10
     */
    private Map<String, Object> shareOpenTable(Long tableID, Integer personNumber, String desc, Long personID) {
        LocalDateTime now = LocalDateTime.now();
        // 获得桌台信息
        B_DinningTableInfoEntity table = tableInfoDAO.selectByPrimaryKey(tableID);
        // 获得当前餐次
        B_MealsInfoEntity mealsInfo = CommonMapper.getCurrentMealsInfo();
        // 修改桌台餐段信息(包含开台前置逻辑判断)
        openTableCheck(table, mealsInfo, personNumber, now);
        //拼桌开台逻辑处理
        return shareOpenTableService(table, mealsInfo);
    }

    /**
     * @author LiSH @date 2017年1月18日
     * @Description: 预定开台 预订单ID 桌台ID tableID 人数 描述
     */
    @Transactional
    public Map<String, Object> bookingOpenTable(Long bookingID, Long tableID, Integer personNumber, String desc, Long personID) {
        LocalDateTime now = LocalDateTime.now();
        B_DinningTableInfoEntity table = tableInfoDAO.selectByPrimaryKey(tableID);
        O_BookingInfoEntity booking = bookingDAO.selectByPrimaryKey(bookingID);
        // 查询当前时间对应餐次
        B_MealsInfoEntity mealsInfo = CommonMapper.getCurrentMealsInfo();
        // 预定开台前置>>修改桌台餐段信息(包含开台前置逻辑判断)
        bookingOpenTableCheck(booking, table, mealsInfo, personNumber, now);
        // 预定开台 >>修改桌台信息 和 保存 桌台使用信息表
        Map<String, Object> result = bookingOpenTable(booking, personNumber, personID, table, mealsInfo, desc);
        return result;
    }

    /**
     * @author LiSH @date 2017年1月18日
     * @Description: 修改当前时间下的餐段信息状态(当前时间最近的改为使用中 占用时间内改成已占用)
     */
    private void openTableCheck(B_DinningTableInfoEntity table, B_MealsInfoEntity mealsInfo, Integer personNumber, LocalDateTime now) {
        openTableCheck(table, mealsInfo, personNumber, now, mealsInfo.getMinLength());
    }

    /**
     * @description 修改当前时间下的餐段信息状态 (当前时间最近的改成使用中 餐次最短占用时间段内 改成已占用) minutes:分钟
     * 当前时间到 当前时间+minutes之间占用餐段需锁定
     * @author LiSH
     * @time 2017-3-9 17:12
     * @version 2.0.0
     */
    private void openTableCheck(B_DinningTableInfoEntity table, B_MealsInfoEntity mealsInfo, Integer personNumber, LocalDateTime now, Integer minutes) {
        if (mealsInfo == null) {
            BizException.error("该餐次没有数据");
        }
        //验证当前用餐人数
        checkTablePerson(personNumber);
        //修改餐段信息
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = startTime.plusMinutes(minutes);
        List<B_MealTableMappingEntity> mealTableList = mealTableDAO.getMealTableInfoByMealsIDAndStartDateAndEndDate(table.getTableID(), mealsInfo.getMealsID(),
                startTime, endTime);
        for (int i = 0; i < mealTableList.size(); i++) {
            B_MealTableMappingEntity mapping = mealTableList.get(i);
            if (i == 0) {
                mapping.setTableStatus(TableStatus.PLACEORDER.getValue());
                mealTableDAO.updateByPrimaryKeySelective(mapping);
            } else {
                mapping.setTableStatus(TableStatus.LOCK.getValue());
                mealTableDAO.updateByPrimaryKeySelective(mapping);
            }
        }
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 验证消费人数是否有效
     * @time 2017-4-12 17:24
     */
    public void checkTablePerson(Integer personNumber) {
        Map<String, Object> tableDetail1 = CommonMapper.getTableDetail();
        long customerNumber = MapUtils.getLongValue(tableDetail1, "customerNumber");
        if (personNumber + customerNumber > MapUtils.getLongValue(tableDetail1, "maxPerson")) {
            BizException.error("人数超出桌台可容纳最大人数");
        }
//        if (personNumber+customerNumber < MapUtils.getLongValue(tableDetail1,"minPerson")) {
//            BizException.error("人数小于桌台最小人数");
//        }
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 拼桌开台
     * @time 2017-4-21 9:28
     */
    private Map<String, Object> shareOpenTableService(B_DinningTableInfoEntity table, B_MealsInfoEntity mealsInfo) {
        List<Map<String, Object>> usingOrderList = getUsingOrderList(table.getTableID());
        // 修改桌台状态
        table.setTableStatus(TableStatus.PLACEORDER.getValue());
        table.setShareNumber((table.getShareNumber() == null ? 0 : table.getShareNumber()) + 1);
        tableInfoDAO.updateByPrimaryKey(table);

        Map<String, Object> result = addOrderInfo(mealsInfo, usingOrderList);
        return result;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 开台产生订单
     * @time 2017-4-20 13:36
     */
    private Map<String, Object> addOrderInfo(B_MealsInfoEntity mealsInfo, List<Map<String, Object>> usingOrderList) {
        // 添加订单信息
        BigDecimal zero = new BigDecimal(0.0);
        Long orderID = MaxIDUtils.getID(O_OrderInfoEntity.class);
        Long subOrderID = MaxIDUtils.getID(O_SubOrderInfoEntity.class);
        O_OrderInfoEntity orderInfo = new O_OrderInfoEntity();
        orderInfo.setOrderID(orderID);
        orderInfo.setArchiveID(MerchantCacheUtils.getMerchantCache().getArchiveID());
        orderInfo.setPeopleNum(0);
        orderInfo.setCommission(zero);
        orderInfo.setOrderChannel(MerchantManageEnum.OrderChannel.LICENSE.getValue());
        orderInfo.setTotalAmount(zero);
        orderInfo.setDiscountAmount(zero);
        orderInfo.setActualAmount(zero);
        orderInfo.setPendingAmount(zero);
        orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
        orderInfo.setPayStatus(OrderManageEnum.PayStatus.WAITINGPAY.getValue());
        orderInfo.setCreateTime(LocalDateTime.now());
        orderInfo.setOrderCode(OrderUtil.getOrderCode());
        orderInfoMapper.insertSelective(orderInfo);
        if (usingOrderList == null) {
            // 添加子订单信息
            O_SubOrderInfoEntity subOrderInfo = new O_SubOrderInfoEntity();
            BeanUtils.copyProperties(orderInfo, subOrderInfo);
            subOrderInfo.setMealsID(mealsInfo.getMealsID());
            subOrderInfo.setSubOrderID(subOrderID);
            subOrderInfo.setTableID(MerchantCacheUtils.getCurrentTableID());
            subOrderInfo.setTableName(MerchantCacheUtils.getCurrentTableName());
            subOrderInfoMapper.insertSelective(subOrderInfo);
        } else if (usingOrderList.size() == 1) {
            //首次拼桌
            Map<String, Object> orderDetail = usingOrderList.get(0);
            long oldSubOrderID = MapUtils.getLongValue(orderDetail, "subOrderID");
            O_SubOrderInfoEntity subOrderInfo = new O_SubOrderInfoEntity();
            subOrderInfo.setSubOrderID(oldSubOrderID);
            subOrderInfo.setTableName(SHARE_PREFIX + "1");
            subOrderInfoMapper.updateByPrimaryKeySelective(subOrderInfo);

            BeanUtils.copyProperties(orderInfo, subOrderInfo);
            subOrderInfo.setOrderID(orderID);
            subOrderInfo.setMealsID(mealsInfo.getMealsID());
            subOrderInfo.setSubOrderID(subOrderID);
            subOrderInfo.setTableID(MerchantCacheUtils.getCurrentTableID());
            subOrderInfo.setTableName(SHARE_PREFIX + "2");
            subOrderInfoMapper.insertSelective(subOrderInfo);
        } else if (usingOrderList.size() > 1) {
            //多次拼桌
            Map<String, Object> orderDetail = usingOrderList.get(0);
            O_SubOrderInfoEntity subOrderInfo = new O_SubOrderInfoEntity();
            BeanUtils.copyProperties(orderInfo, subOrderInfo);
            subOrderInfo.setMealsID(mealsInfo.getMealsID());
            subOrderInfo.setSubOrderID(subOrderID);
            subOrderInfo.setTableID(MerchantCacheUtils.getCurrentTableID());
            try {
                String subTableName = MapUtils.getString(orderDetail, "subTableName");
                if (subTableName.contains(SHARE_PREFIX)) {
                    String[] tableNameStrArr = subTableName.split(SHARE_PREFIX);
                    if (tableNameStrArr.length == 2) {
                        String suffix = tableNameStrArr[1];
                        Integer suffixInt = Integer.valueOf(suffix);
                        subOrderInfo.setTableName(SHARE_PREFIX + (suffixInt + 1));
                    }
                }
            } catch (Exception e) {
                logger.error("addOrderInfo 多次拼桌处理异常.", e);
            }
            subOrderInfoMapper.insertSelective(subOrderInfo);
        }


        Map<String, Object> result = MapHelper.newMap();
        result.put("orderID", orderID);
        result.put("subOrderID", subOrderID);
        return result;
    }

    /**
     * @description 1.修改桌台信息 2.保存桌台使用信息表 3.插入订单信息
     * @author LiSH
     * @time 2017-3-9 17:13
     * @version 2.0.0
     */
    private Map<String, Object> openTable(Integer personNumber, Long personID, B_DinningTableInfoEntity table, B_MealsInfoEntity mealsInfo, String desc) {
        LocalDateTime now = LocalDateTime.now();
        // 修改桌台状态
        table.setTableStatus(TableStatus.PLACEORDER.getValue());
        table.setShareNumber(1);
        table.setCombineNumber(1);
        tableInfoDAO.updateByPrimaryKey(table);
        // 新增桌台使用记录状态
        B_DinningTableUseInfoEntity tableUser = new B_DinningTableUseInfoEntity();
        tableUser.setHisID(MaxIDUtils.getID(tableUser));
        tableUser.setTableID(table.getTableID());
        tableUser.setArchiveID(table.getArchiveID());
        tableUser.setWaiterLoginID(personID);
        tableUser.setMealsID(mealsInfo.getMealsID());
        tableUser.setStartTime(now);
        tableUser.setCreateTime(now);
        tableUser.setCustomerNumber(personNumber);
        tableUser.setMemo(desc);
        tableUser.setUseMethod(UseWay.LICENSE.getValue());
        tableUserDAO.insertSelective(tableUser);

        Map<String, Object> result = addOrderInfo(mealsInfo);
        return result;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 开台产生订单信息
     * @time 2017-4-20 13:19
     */
    public Map<String, Object> addOrderInfo(B_MealsInfoEntity mealsInfo) {
        return addOrderInfo(mealsInfo, null);
    }

    /**
     * @author LiSH @date 2017年1月18日
     * @Description: 预定开台 修改预定信息 到店时间 修改桌台信息 和 保存 桌台使用信息表
     */
    private Map<String, Object> bookingOpenTable(O_BookingInfoEntity booking, Integer personNumber, Long personID, B_DinningTableInfoEntity table, B_MealsInfoEntity mealsInfo,
                                                 String desc) {
        // 普通开台修改信息
        Map<String, Object> param = openTable(personNumber, personID, table, mealsInfo, desc);
        // 修改预定信息
        booking.setArrivalTime(LocalDateTime.now());
        bookingDAO.updateByPrimaryKeySelective(booking);
        return param;
    }

    /**
     * @author LiSH @date 2017年1月18日
     * @Description: 预定开台前置>>修改桌台餐段信息(包含预定开台前置逻辑判断)
     */
    private void bookingOpenTableCheck(O_BookingInfoEntity booking, B_DinningTableInfoEntity table, B_MealsInfoEntity mealsInfo, Integer personNumber, LocalDateTime now) {
        if (booking == null) {
            BizException.error("找不到对应预定信息");
        }
        openTableCheck(table, mealsInfo, personNumber, now, booking.getDuration());
    }

    /**
     * @author LiSH @date 2017年1月18日
     * @Description: 根据areaID获得对应的桌台列表
     */
    public List<Map<String, String>> getTableListByAreaID(Long areaID) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("archiveID", MerchantCacheUtils.getCurrentArchiveID());
        map.put("areaID", areaID);
        map.put("padTableMappingStatus", null);
        return tableInfoDAO.getListByAreaID(map);
    }

    /**
     * @return
     * @author LiSH
     * archiveID 根据餐厅ID查询所有区域
     */
    public List<B_ShopAreaInfoEntity> getAreasByArchiveID() {
        return shopAreaInfoDAO.getListByArchiveID(MerchantCacheUtils.getCurrentArchiveID());
    }


    /**
     * @description 查看当前时间餐段是否被预定
     * @author LiSH
     * @time 2017-3-2 10:08
     * @version 2.0.0
     */
    public Map<String, Object> checkIsBooking(Long currentTableID) {
        HashMap<String, Object> result = new HashMap<>();
        HashMap<String, Object> params = new HashMap<>();
        B_MealsInfoEntity mealsInfo = CommonMapper.getCurrentMealsInfo();
        if (null == mealsInfo) {
            BizException.error("不存在对应餐次信息");
        }
        //最短就餐时长
        Integer minTime = mealsInfo.getMinLength();

        params.put("now", LocalDateTime.now());
        params.put("minTime", minTime);
        params.put("tableID", currentTableID);
        List<O_BookingInfoEntity> bookingList = bookingDAO.getEntityByParams(params);

        if (bookingList.size() > 0) {
            result.put("isBooking", true);
        } else {
            result.put("isBooking", false);
        }
        result.put("bookingList", bookingList);
        return result;
    }

    /**
     * 是否可开台
     *
     * @author LeeJun
     * @time 2017-5-17 18:08
     * @version 2.0.0
     */
    public boolean isOpenTable(Long tableID) {
        HashMap<String, Object> params = new HashMap<>();
        B_MealsInfoEntity mealsInfo = CommonMapper.getCurrentMealsInfo();
        //最短就餐时长
        Integer minTime = mealsInfo.getMinLength();
        params.put("now", LocalDateTime.now());
        params.put("minTime", minTime);
        params.put("tableID", tableID);
        List<O_BookingInfoEntity> bookingList = bookingDAO.getEntityByParams(params);
        if (bookingList.size() > 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 根据桌台ID查询桌台区域信息
     *
     * @author LeeJun
     * @time 2017-5-17 18:09
     * @version 2.0.0
     */
    public B_ShopAreaInfoEntity checkAreaInfoByTableID(long tableID) {
        return shopAreaInfoDAO.getAreaInfoByTableID(tableID);
    }

    @Transactional
    public Object addBooking(Long tableID) {
        B_DinningTableInfoEntity table = tableInfoDAO.selectByPrimaryKey(tableID);
        B_MealsInfoEntity mealsInfo = CommonMapper.getCurrentMealsInfo();
        LocalDate now = LocalDate.now();
        LocalDateTime nowTime = LocalDateTime.now();
        //添加一条空主订单

        O_OrderInfoEntity order = new O_OrderInfoEntity();
        order.setIsSync(true);
        order.setOrderID(MaxIDUtils.getID(order));
        order.setOrderStatus(OrderManageEnum.OrderStatus.BOOKING.getValue());
        order.setCreateTime(LocalDateTime.now());
        order.setMemo("水牌自动添加测试数据--lsh");
        orderDAO.insert(order);

        O_SubOrderInfoEntity subOrder = new O_SubOrderInfoEntity();
        subOrder.setSubOrderID(MaxIDUtils.getID(subOrder));
        subOrder.setOrderID(order.getOrderID());
        subOrder.setOrderStatus(OrderManageEnum.OrderStatus.BOOKING.getValue());
        subOrder.setTableID(MerchantCacheUtils.getCurrentTableID());
        subOrder.setMealsID(CommonMapper.getCurrentMealsInfo().getMealsID());
        subOrder.setCreateTime(LocalDateTime.now());
        subOrder.setMemo("水牌自动添加测试数据--lsh");
        subOrderInfoMapper.insertSelective(subOrder);

        O_BookingInfoEntity booking = new O_BookingInfoEntity();
        booking.setBookingID(MaxIDUtils.getID(booking));
        booking.setArchiveID(MerchantCacheUtils.getCurrentArchiveID());
        booking.setOrderID(order.getOrderID());
        booking.setTableID(tableID);
        booking.setMealsID(mealsInfo.getMealsID());
//        booking.setPaymentmethodid();
        booking.setBookingCode("lshTest:" + System.currentTimeMillis());
        booking.setVerificationCode("1234");
        booking.setBookingTime(nowTime);
        booking.setDuration(60);
        booking.setPeopleNum(5);
        booking.setContact("李小龙测试先生");
        booking.setPhone("15902772751");
        booking.setBookingChannel(738L);
//        booking.setBookingstatus();
        booking.setBookingType(MerchantManageEnum.BookingType.NORMAL.getValue());
        booking.setBookingAmount(new BigDecimal("500"));
        booking.setBookingDesc("lsh测试数据--预定描述");
        booking.setIsSync(true);
        booking.setCreateTime(nowTime);
        booking.setMemo("水牌自动添加测试数据--lsh");
        bookingDAO.insert(booking);
        return booking;
    }

    @Transactional
    public Object addMealTableMapping(Long tableID) {
        B_DinningTableInfoEntity table = tableInfoDAO.selectByPrimaryKey(tableID);
        B_MealsInfoEntity currentMealsInfo = CommonMapper.getCurrentMealsInfo();

        HashMap<String, Object> param = Maps.newHashMap();
        param.put("tableID", tableID);
        if (currentMealsInfo != null) {
            param.put("mealsID", currentMealsInfo.getMealsID());
        }
        List<B_MealTableMappingEntity> list = mealTableDAO.getListByParam(param);
        if (list.size() > 0) {
            BizException.error("mealTable is exist");
        }
        LocalDateTime starttime = currentMealsInfo.getStartTime();
        LocalDateTime endtime = currentMealsInfo.getEndTime();

        LocalDateTime var1 = starttime;
        while (var1.plusMinutes(15).isBefore(endtime)) {
            B_MealTableMappingEntity mapping = new B_MealTableMappingEntity();
            mapping.setSegmentID(MaxIDUtils.getID(mapping));
            mapping.setArchiveID(MerchantCacheUtils.getCurrentArchiveID());
            mapping.setTableID(tableID);
            mapping.setTableCode(table.getTableCode());
            mapping.setTableName(table.getTableName());
            mapping.setMealsID(currentMealsInfo.getMealsID());
            mapping.setAreaID(table.getAreaID());
            mapping.setTableStatus(TableStatus.EMPTYTABLE.getValue());
            mapping.setStartTime(var1);
            var1 = var1.plusMinutes(15);
            mapping.setRecommendBookingTime(var1);
            mapping.setIsBooking(false);
            mapping.setIsSharing(true);
            mapping.setShareNumber(2);
            mapping.setCustomerNumber(0);
            mapping.setCreateTime(LocalDateTime.now());
            mapping.setMemo("水牌为测试生成数据--lsh");
            // mapping.setIssync(true);
            mealTableDAO.insert(mapping);
        }
        return var1;
    }

    /**
     * @description 根据桌台添加餐次数据 一天分4餐段 6小时一个
     * @author LiSH
     * @time 2017-3-15 16:15
     * @version 2.0.0
     */
    public Object addMealData(Long currentTableID) {
        List<B_MealsInfoEntity> mealsList = new ArrayList<>();
        B_MealsInfoEntity currentMealsInfo = CommonMapper.getCurrentMealsInfo();
        if (currentMealsInfo != null) {
            BizException.error("当前时间有餐次数据");
        }
        B_DinningTableInfoEntity tableInfo = tableInfoDAO.selectByPrimaryKey(currentTableID);
        String[] nameStr = {"凌晨", "早餐", "午餐", "晚餐"};
        LocalDateTime now = LocalDateTime.now();
        now = now.withHour(0).withMinute(0).withSecond(0);
        int hour = 6;
        for (int i = 0; i < 4; i++) {
            LocalDateTime start = now.plusHours(hour * i);
            LocalDateTime end;
            if (i == 3) {
                end = now.plusHours(hour * (i + 1)).minusSeconds(1);
            } else {
                end = now.plusHours(hour * (i + 1));
            }
            B_MealsInfoEntity mealsInfo = new B_MealsInfoEntity();
            mealsInfo.setMealsID(MaxIDUtils.getID(mealsInfo));
            mealsInfo.setArchiveID(MerchantCacheUtils.getCurrentArchiveID());
            mealsInfo.setOrgID(MerchantCacheUtils.getCurrentOrgID());
            mealsInfo.setAreaID(tableInfo.getAreaID());
            mealsInfo.setMealCode("lsh test");
            mealsInfo.setMealName(nameStr[i]);
            mealsInfo.setIsDefault(0L);
            mealsInfo.setStartTime(start);
            mealsInfo.setEndTime(end);
            mealsInfo.setSegmentLength(15);
            mealsInfo.setMinLength(30);
            mealsInfo.setMemo("lsh测试自增数据");
            mealsInfo.setCreatorID(1L);
            mealsInfo.setMealStatus(MerchantManageEnum.MealStatus.PREDETERMINE.getValue());
            mealsInfo.setCreateTime(LocalDateTime.now());
            mealsDAO.insert(mealsInfo);
            mealsList.add(mealsInfo);
        }
        return mealsList;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 清除桌台当前使用订单
     * @time 2017-4-20 16:53
     */
    public Map<String, Object> cleanTableUsingOrderList(Long tableID) {
        Map<String, Object> param = MapHelper.newMap();
        param.put("tableID", tableID);
        return CommonMapper.updateSql(B_DinningTableInfoDao.class, "cleanTableUsingOrderList", param);
    }
}
