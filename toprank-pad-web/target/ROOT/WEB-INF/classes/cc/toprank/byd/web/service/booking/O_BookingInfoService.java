package cc.toprank.byd.web.service.booking;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.RandomHelper;
import cc.toprank.byd.component.MealComponent;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.*;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.dto.UserInfoVo;
import cc.toprank.byd.web.service.payment.BasicParamInfoService;
import cc.toprank.byd.web.util.OrderUtil;
import cc.toprank.byd.web.vo.member.MemberVO;
import cc.toprank.byd.web.vo.reserve.ReserveVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   B_AttachmentInfoService 真实的业务实现类，允许修改
 *
 * ********************************************************************************************************************/
@Service("o_BookingInfoService")
public class O_BookingInfoService {

    @Autowired
    private O_BookingInfoDao bookingInfoDao;

    @Autowired
    private B_DinningTableInfoDao dinningTableInfoDao;

    @Autowired
    private O_OrderInfoDao orderInfoDao;

    @Autowired
    private O_SubOrderInfoDao subOrderInfoDao;

    @Autowired
    private B_MealTableMappingDao mealTableMappingDao;

    @Autowired
    private B_MealsInfoDao mealsInfoDao;

    @Autowired
    private O_OrderDealInfoDao o_OrderDealInfoDao;
    @Autowired
    protected O_BookingInfoDao o_BookingInfoDao;

    @Autowired
    private O_BookingDealInfoDao bookingDealInfoDao;

    @Autowired
    protected B_PeriodConfigInfoDao b_PeriodConfigInfoDao;

    @Autowired
    protected E_CustomerInfoDao customerInfoDao;

    @Autowired
    protected E_LoginInfoDao loginInfoDao;

    @Autowired
    protected B_MerchantInfoDao merchantInfoDao;

    @Autowired
    protected F_FundChangeInfoDao fundChangeInfoDao;

    @Autowired
    protected F_AccountInfoDao accountInfoDao;

    @Autowired
    private MealComponent mealComponent;

    @Autowired
    private BasicParamInfoService basicParamInfoService;


    public O_BookingInfoEntity get(O_BookingInfoEntity bookingInfo) throws Exception {
        return bookingInfoDao.get(bookingInfo);
    }

    public O_BookingInfoEntity getByID(Long bookingID){
        return bookingInfoDao.selectByPrimaryKey(bookingID);
    }

    public List<O_BookingInfoEntity> getAll() throws Exception {
        return bookingInfoDao.getAll();
    }

    public void update(O_BookingInfoEntity bookingInfo) throws Exception {
        bookingInfoDao.update(bookingInfo);
    }

    public O_BookingInfoEntity selectByPrimaryKey(Long bookingid) {
        return bookingInfoDao.selectByPrimaryKey(bookingid);
    }

    public void delete(O_BookingInfoEntity bookingInfo) throws Exception {
        bookingInfoDao.delete(bookingInfo);
    }

    public void save(O_BookingInfoEntity bookingInfo) throws Exception {
        bookingInfoDao.save(bookingInfo);
    }

    /**
     * @description 根据条件查询预订单信息
     * @author Zhaolingchen
     * @time 2017-5-17 10:12
     * @version 2.0.0
     */
    public List<O_BookingInfoEntity> getBookingInfoByWhere(Map<String, Object> param) {
        return bookingInfoDao.getBookingInfoByWhere(param);
    }

    /**
     * @description 根据查询指时间内的预订单信息
     * @author Zhaolingchen
     * @time 2017-5-17 10:12
     * @version 2.0.0
     */
    public List<O_BookingInfoEntity> getBookingInfoListByBookingTime(Map<String, Object> param) {
        return bookingInfoDao.getBookingInfoByWhere(param);
    }

    /**
     * @description 根据预订ID 查询预订详情
     * @author Zhaolingchen
     * @time 2017-5-17 10:12
     * @version 2.0.0
     */
    public O_BookingInfoEntity getBookingDetailInfo(Long bookingID) {
        return bookingInfoDao.getBookingDetailInfo(bookingID);
    }

    /**
     * @description 根据预订ID, 查询已付预订金额
     * @author Zhaolingchen
     * @time 2017-6-7 10:12
     * @version 2.0.0
     */
    public F_FundChangeInfoEntity getBookingFundChangeInfo(Long bookingID) {
        F_FundChangeInfoEntity fundChangeInfo = new F_FundChangeInfoEntity();
        fundChangeInfo.setBusinessID(bookingID);
        fundChangeInfo.setBusinessType(CommonManageEnum.BusinessType.SUBSCRIPTION.getValue());
        return fundChangeInfoDao.queryByBusinessIDAndBusinessType(fundChangeInfo);
    }

    /**
     * @param subOrderID   子订单ID
     * @param orderID      订单ID
     * @param changeAmount 改变金额
     * @param BeforeAmount 改变前金额
     * @param AfterAmount  改变后金额
     * @param dealDesc     描述
     * @throws Exception
     * @Description： 新增订单处理信息
     * @Author：LanZY
     * @Time: 2017-4-6 15:15
     * @Version 2.0.0
     */
    public void saveOrderDealInfo(Long subOrderID, Long orderID, BigDecimal changeAmount,
                                  BigDecimal BeforeAmount, BigDecimal AfterAmount, String dealDesc) throws Exception {
        O_OrderDealInfoEntity orderDealInfo = new O_OrderDealInfoEntity();
        orderDealInfo.setSubOrderID(subOrderID);
        orderDealInfo.setOrderID(orderID);
        orderDealInfo.setChangeAmount(changeAmount);
        orderDealInfo.setBeforeAmount(BeforeAmount);
        orderDealInfo.setAfterAmount(AfterAmount);
        orderDealInfo.setDealDesc(dealDesc);
        orderDealInfo.setIsSync(false);
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 预定保存
     * @time 2017-05-17
     */
    @Transactional(rollbackFor = Exception.class)
    public O_BookingInfoEntity addBookingInfo(ReserveVo reserveVo) throws Exception {
        return addBooking(reserveVo);
    }

    public O_BookingInfoEntity addBooking(ReserveVo reserveVo) throws Exception {
        Integer duration = reserveVo.getDuration();
        LocalDateTime startTime = DateUtils.parseLocalDateTime(reserveVo.getBookingTime());//预订开始时间
        LocalDateTime endTime = startTime.plusMinutes(duration);//预订结束时间

        Map<String, Object> param = new HashMap();
        param.put("archiveID", reserveVo.getArchiveID());
        param.put("areaID", reserveVo.getAreaID());
        param.put("startTime", startTime);
        param.put("endTime", endTime);

        String tableIDs = reserveVo.getTableIDs();//预定的桌台ID
        String[] tableIDList = tableIDs.split(",");
        Long mainTableID = Long.valueOf(tableIDList[0]);

        boolean isSameDate = DateUtils.isSameDate(startTime, LocalDateTime.now());
        //预定时间为当天,根据餐次桌台表判断未预定的桌台
        boolean isBooking = false;
        if (isSameDate) {
            B_MealTableMappingEntity mealTableMappingParam = new B_MealTableMappingEntity();
            mealTableMappingParam.setMinute(duration);
            mealTableMappingParam.setStartTime(startTime);
            //判断预订的桌台是否被预定
            isBooking = isBookingByTableInfo(mealTableMappingParam, tableIDList);
        } else {
            //预定时间非当天,根据预定单来判断未预订的桌台
            List<O_BookingInfoEntity> bookingInfoList = bookingInfoDao.getBookingInfoListByBookingTime(param);//查询预订信息

            isBooking = isBookingByBookingInfo(bookingInfoList, tableIDList);
        }

        if (isBooking) {
            throw new BizException(CodeMsgConstants.TABLE_OCCUPY_ERROR_KEY_CODE, CodeMsgConstants.TABLE_OCCUPY_ERROR_KEY_MSG);
        }

        E_LoginInfoEntity loginInfo = loginInfoDao.getLoginInfoByMobile(reserveVo.getPhone());
        if (loginInfo == null) {//非会员第一次预订,保存用户信息
            //预订成功,添加保存预订人信息
            MemberVO memberVO = new MemberVO();
            memberVO.setArchiveID(reserveVo.getArchiveID());
            memberVO.setOrgID(reserveVo.getOrgID());
            memberVO.setMobile(reserveVo.getPhone());
            memberVO.setCountermanName(reserveVo.getContact());
            memberVO.setGender(reserveVo.getGender());
            memberVO.setOperatorID(reserveVo.getLoginID());
            loginInfo = addMemberByBooking(memberVO);
        }

        //插入预订单,订单,子订单,订单处理,预定处理信息
        //插入订单信息
        O_OrderInfoEntity orderInfo = new O_OrderInfoEntity();
        orderInfo.setOrderID(MaxIDUtils.getID(O_OrderInfoEntity.class));
        orderInfo.setOrderCode(OrderUtil.getOrderCode());
        orderInfo.setArchiveID(reserveVo.getArchiveID());
        orderInfo.setPeopleNum(reserveVo.getPeopleNum());
        orderInfo.setOrderChannel(MerchantManageEnum.OrderChannel.CASHREGISTER.getValue());
        Integer reservationFee = 0;//留位金
        if(MerchantManageEnum.BookingType.NORMAL.getValue() == reserveVo.getBookingType()){
            orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.BOOKING.getValue());
        }else if(MerchantManageEnum.BookingType.RESERVEDSEAT.getValue() == reserveVo.getBookingType()){
            reservationFee = basicParamInfoService.getReservationFee(reserveVo.getArchiveID(), reserveVo.getPeopleNum(),tableIDList.length);
            orderInfo.setPendingAmount(new BigDecimal(reservationFee));
            orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.BOOKING.getValue());
        }else{
            orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.WAITINGPAY.getValue());
            orderInfo.setPayStatus(OrderManageEnum.PayStatus.WAITINGPAY.getValue());
        }
        orderInfo.setDiscountAmount(new BigDecimal(0));
        orderInfo.setTotalAmount(new BigDecimal(0));
        orderInfo.setActualAmount(new BigDecimal(0));
        orderInfo.setQuantity(0);
        orderInfo.setOrderDesc(reserveVo.getMemo());
        orderInfo.setMemo(reserveVo.getMemo());
        orderInfo.setCreateTime(LocalDateTime.now());
        orderInfo.setCreatorID(reserveVo.getLoginID());
        orderInfo.setCustomerID(loginInfo.getCustomerID());
        orderInfoDao.insertSelective(orderInfo);

        //插入主订单处理信息
        O_OrderDealInfoEntity orderDealInfo = new O_OrderDealInfoEntity();
        orderDealInfo.setDealID(MaxIDUtils.getID(O_OrderDealInfoEntity.class));
        orderDealInfo.setOrderID(orderInfo.getOrderID());
        orderDealInfo.setBeforeStatus(orderInfo.getOrderStatus());
        orderDealInfo.setAfterStatus(orderInfo.getOrderStatus());
        orderDealInfo.setDealDesc("预订新增订单");
        o_OrderDealInfoDao.insertSelective(orderDealInfo);

        StringBuffer tableCodeBuff = new StringBuffer();//拼桌tableCode
        B_MealsInfoEntity mealsInfoEntity = null;//餐次信息
        //子订单ID集合
        List<Long> subOrderIDs = new ArrayList<>();
        B_DinningTableInfoEntity dinningTableInfoEntity = dinningTableInfoDao.selectByPrimaryKey(mainTableID);
        for (String tableID : tableIDList) {//插入子订单信息
            B_DinningTableInfoEntity dinningTableInfo = dinningTableInfoDao.selectByPrimaryKey(Long.valueOf(tableID));
            tableCodeBuff.append(dinningTableInfo.getTableName()).append(",");//拼桌tableCode

            Map<String, Object> mealsInfoParam = new HashMap<>();
            mealsInfoParam.put("archiveID", dinningTableInfo.getArchiveID());
            mealsInfoParam.put("areaID", dinningTableInfo.getAreaID());
            mealsInfoParam.put("time", reserveVo.getBookingTime());
            //获取预定的餐次
            mealsInfoEntity = mealComponent.getMealsInfo(mealsInfoParam);

            if (mealsInfoEntity == null) {
                throw new BizException(CodeMsgConstants.NOT_FIND_MEAL_CODE, CodeMsgConstants.NOT_FIND_MEAL_MSG);
            }

            if (isSameDate) {//如果预订时间为当天,则修改餐次桌台表
                List<B_MealTableMappingEntity> mealTableMappingList = mealTableMappingDao.getBetweenMealsTableMapping(Long.valueOf(tableID), startTime, duration);

                if (mealTableMappingList == null || mealTableMappingList.size() == 0) {
                    throw new BizException(CodeMsgConstants.NOT_FIND_MEAL_CODE, CodeMsgConstants.NOT_FIND_MEAL_MSG, tableID);
                }

                for (B_MealTableMappingEntity mealTableMapping : mealTableMappingList) {//更改餐次桌台表为预定状态
                    mealTableMapping.setIsBooking(true);
                    mealTableMapping.setTableStatus(MerchantManageEnum.TableStatus.PREDETERMINE.getValue());
                    mealTableMappingDao.updateByPrimaryKeySelective(mealTableMapping);
                }
            }

            //插入子订单信息
            // 新增子订单
            O_SubOrderInfoEntity subOrderInfo = new O_SubOrderInfoEntity();
            subOrderInfo.setSubOrderID(MaxIDUtils.getID(O_SubOrderInfoEntity.class));
            subOrderInfo.setOrderID(orderInfo.getOrderID());
            subOrderInfo.setTableID(Long.valueOf(tableID));
            subOrderInfo.setMealsID(mealsInfoEntity.getMealsID());
            subOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.BOOKING.getValue());
            subOrderInfo.setTableName(dinningTableInfo.getTableCode());
            subOrderInfo.setDiscountAmount(new BigDecimal(0));
            subOrderInfo.setActualAmount(new BigDecimal(0));
            subOrderInfo.setTotalAmount(new BigDecimal(0));
            subOrderInfo.setQuantity(0);
            subOrderInfo.setMemo(orderInfo.getMemo());
            subOrderInfo.setCreateTime(LocalDateTime.now());
            subOrderInfo.setCreatorID(reserveVo.getLoginID());//绑定用户
            subOrderInfo.setIsSync(true);
            subOrderInfo.setCreatorType(SystemManageEnum.UserType.SYSTEMUSER.getValue());
            subOrderInfoDao.insertSelective(subOrderInfo);
            subOrderIDs.add(subOrderInfo.getSubOrderID());
        }
        reserveVo.setSubOrderIDs(StringUtils.join(subOrderIDs.toArray(), ","));

        if (tableCodeBuff.length() > 0) {//去除最有一个逗号
            tableCodeBuff.deleteCharAt(tableCodeBuff.length() - 1);
        }

        //插入预订单信息
        O_BookingInfoEntity bookingInfo = new O_BookingInfoEntity();
        bookingInfo.setBookingID(MaxIDUtils.getID(O_BookingInfoEntity.class));
        bookingInfo.setArchiveID(reserveVo.getArchiveID());
        bookingInfo.setBookingCode(orderInfo.getOrderCode());
        bookingInfo.setVerificationCode(RandomHelper.createRandom(true, 4));
        bookingInfo.setOrderID(orderInfo.getOrderID());
        bookingInfo.setLoginID(loginInfo.getLoginID());
        bookingInfo.setTableID(mainTableID);
        bookingInfo.setTableCodes(tableCodeBuff.toString());
        bookingInfo.setMealsID(mealsInfoEntity.getMealsID());//预定的餐次
        bookingInfo.setBookingTime(startTime);//预定时间
        bookingInfo.setDuration(mealsInfoEntity.getMinLength());//预订时长为餐次最短就餐时长
        Integer extraMinute = duration - mealsInfoEntity.getMinLength(); //加时时长=预订时长-餐次最短就餐时长
        bookingInfo.setExtraMinute(extraMinute);
        bookingInfo.setPeopleNum(reserveVo.getPeopleNum());
        bookingInfo.setContact(reserveVo.getContact());
        bookingInfo.setPhone(reserveVo.getPhone());
        bookingInfo.setBookingChannel(MerchantManageEnum.BookingChannel.CASHREGISTER.getValue());
        if (MerchantManageEnum.BookingType.NORMAL.getValue() == reserveVo.getBookingType()) {
            bookingInfo.setBookingStatus(MerchantManageEnum.ReservaManage.SUCCESS.getValue());
        } else {
            bookingInfo.setBookingStatus(MerchantManageEnum.ReservaManage.PENDINGPAYMENT.getValue());
        }
        bookingInfo.setBookingType(reserveVo.getBookingType());
        bookingInfo.setTableNum(tableIDList.length);
        bookingInfo.setMemo(reserveVo.getMemo());
        bookingInfo.setCreatorID(reserveVo.getLoginID());
        bookingInfo.setCreateTime(LocalDateTime.now());

        //判断是否需要支付
        if (MerchantManageEnum.BookingType.RESERVEDSEAT.getValue() == reserveVo.getBookingType()) {
            //待支付留位金
            BigDecimal bookingAmount = new BigDecimal(reservationFee);
            bookingInfo.setBookingAmount(bookingAmount);
        }
        o_BookingInfoDao.insertSelective(bookingInfo);

        //插入预定处理信息
        O_BookingDealInfoEntity bookingDealInfo = new O_BookingDealInfoEntity();
        bookingDealInfo.setDealID(MaxIDUtils.getID(O_BookingDealInfoEntity.class));
        bookingDealInfo.setAfterStatus(MerchantManageEnum.ReservaManage.SUCCESS.getValue());
        bookingDealInfo.setBookingID(bookingInfo.getBookingID());
        bookingDealInfo.setChangeContent("创建预订");
        bookingDealInfo.setDealDesc("创建预订");
        bookingDealInfo.setMemo(bookingInfo.getMemo());
        bookingDealInfoDao.insertSelective(bookingDealInfo);

        return bookingInfo;
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 退定金;对已取消的订单进行退定金,退款金额不能大于已支付定金
     * @time 2017-06-05
     */
    @Transactional(rollbackFor = Exception.class)
    public void refundBookingAmount(Long bookingID, Double amount) throws Exception {
        if (amount == null || amount <= 0) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }

        O_BookingInfoEntity bookingInfoEntity = o_BookingInfoDao.getByID(bookingID);
        if (bookingInfoEntity == null) {
            throw new BizException(CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_CODE, CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_MSG);
        }
        if (bookingInfoEntity.getBookingStatus() != OrderManageEnum.OrderStatus.CUSTOMERCANCEL.getValue() && bookingInfoEntity.getBookingStatus() != OrderManageEnum.OrderStatus.SYSTEMCANCEL.getValue() && bookingInfoEntity.getBookingStatus() != OrderManageEnum.OrderStatus.MANUALCANCEL.getValue()) {
            throw new BizException(CodeMsgConstants.NOT_REFUND_AMOUNT_CODE, CodeMsgConstants.NOT_REFUND_AMOUNT_MSG);
        }
        //退款金额不能大于已支付定金
        if (bookingInfoEntity.getBookingAmount().compareTo(bookingInfoEntity.getRefundAmount().add(new BigDecimal(amount))) == -1) {//-1 小于,0 等于,1 大于
            throw new BizException(CodeMsgConstants.NOT_GREATER_AMOUNT_CODE, CodeMsgConstants.NOT_GREATER_AMOUNT_MSG);
        }
        //插入预订处理信息
        O_BookingDealInfoEntity bookingDealInfo = new O_BookingDealInfoEntity();
        bookingDealInfo.setDealID(MaxIDUtils.getID(O_BookingDealInfoEntity.class));
        bookingDealInfo.setAfterStatus(MerchantManageEnum.ReservaManage.SUCCESS.getValue());
        bookingDealInfo.setBookingID(bookingInfoEntity.getBookingID());
        bookingDealInfo.setChangeContent("退定金");
        bookingDealInfo.setDealDesc("退定金");
        bookingDealInfo.setMemo(bookingInfoEntity.getMemo());
        bookingDealInfoDao.insertSelective(bookingDealInfo);

        //修改预订单信息
        bookingInfoEntity.setRefundAmount(bookingInfoEntity.getRefundAmount().add(new BigDecimal(amount)));
        o_BookingInfoDao.update(bookingInfoEntity);

        //---B端退款退现金,商户资金减少---
        //获取商家资金账户
        addFundChangeInfoForMerchant(bookingInfoEntity, FinancialManageEnum.FundChangeType.ADD.getValue());
        //插入用户资金流水
        addFundChangeInfoForUser(bookingInfoEntity, FinancialManageEnum.FundChangeType.ADD.getValue());

    }

    /**
     * @author Zhaolingchen
     * @version 2.0.0
     * @description 根据可预订桌台 判断这些桌台是否已被预订
     * @time 2017-05-17
     */
    private boolean isBookingByTableInfo(B_MealTableMappingEntity mealTableMappingParam, String[] tableIDList) {
        for (String tableID : tableIDList) {
            List<B_MealTableMappingEntity> mealTableList = mealTableMappingDao.getBetweenMealsTableMapping(Long.valueOf(tableID), mealTableMappingParam.getStartTime(), mealTableMappingParam.getMinute());

            if (mealTableList == null || mealTableList.isEmpty()) {
                continue;
            }
            for (B_MealTableMappingEntity mealTable : mealTableList) {
                if (MerchantManageEnum.TableStatus.EMPTYTABLE.getValue() != mealTable.getTableStatus().longValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @author Zhaolingchen
     * @version 2.0.0
     * @description 根据可预订单信息 判断这些桌台是否已被预订
     * @time 2017-05-17
     */
    private boolean isBookingByBookingInfo(List<O_BookingInfoEntity> bookingInfoList, String[] tableIDs) throws Exception {
//        List tableIDList = Arrays.asList(tableIDs);
        //获取已预订的桌台
        for (O_BookingInfoEntity bookingInfo : bookingInfoList) {
            List<O_SubOrderInfoEntity> subOrderInfoList = subOrderInfoDao.queryByOrderID(bookingInfo.getOrderID());
            for (O_SubOrderInfoEntity subOrderInfo : subOrderInfoList) {
                for(String tableID : tableIDs){
                    if (subOrderInfo.getTableID().equals(Long.valueOf(tableID))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param memberVO
     * @return
     * @Description：非会员预订,新增会员信息(没有登陆功能)
     * @Author：Zhaolingchen
     * @Time: 2017-5-19 14:00
     * @Version 2.0.0
     */
    private E_LoginInfoEntity addMemberByBooking(MemberVO memberVO) {
        //添加客户信息
        E_CustomerInfoEntity customerInfo = new E_CustomerInfoEntity();
        customerInfo.setArchiveID(memberVO.getArchiveID());   //  档案I
        customerInfo.setCustomerName(memberVO.getCountermanName());  //  会员姓名
        customerInfo.setGender(memberVO.getGender());     //  会员性别
        customerInfo.setOrgID(memberVO.getOrgID());       //  组织ID
        customerInfo.setMobile(memberVO.getMobile());     //  手机号码
        customerInfo.setCreateTime(LocalDateTime.now());  //  新建时间
        customerInfo.setLoginID(memberVO.getOperatorID());  //  操作员ID
        customerInfo.setSourceType(SystemManageEnum.OrgType.RESTAURANT.getValue());      //  客户来源
        customerInfoDao.save(customerInfo);

        //添加客户登录信息
        E_LoginInfoEntity loginInfo = new E_LoginInfoEntity();
        loginInfo.setCustomerID(customerInfo.getCustomerID());
        loginInfo.setLoginName(memberVO.getMobile());
        loginInfo.setIsForceChange(true);
        loginInfo.setNickName(memberVO.getCountermanName());
        loginInfo.setTotalLoginNumber(0);
        loginInfo.setCreateTime(LocalDateTime.now());
        loginInfo.setMemo(memberVO.getMemo());
        loginInfo.setLoginStatus(CustomerManageEnum.CustomerStatus.LOCKED.getValue());
        loginInfoDao.save(loginInfo);

        //添加账户信息
        F_AccountInfoEntity account = new F_AccountInfoEntity();
        BigDecimal defaultAmount = new BigDecimal(0.00);
        account.setCustomerID(customerInfo.getCustomerID());
        account.setRealName(customerInfo.getCustomerName());
        account.setCustomerType(CustomerManageEnum.CustomerType.DINER.getValue()); // 食客
        account.setFundAmount(defaultAmount);
        account.setFrozenAmount(defaultAmount);
        account.setReceivableAmount(defaultAmount);
        account.setDueAmount(defaultAmount);
        account.setStandbyAmount(defaultAmount);
        account.setCanCashAmount(defaultAmount);
        account.setDepositBalance(defaultAmount);
        account.setPrepaymentBalance(defaultAmount);
        account.setBorrowFundAmount(defaultAmount);
        account.setCreateTime(LocalDateTime.now());
        account.setLatestOperatorID(customerInfo.getOperatorID());
        account.setIsSync(false);
        accountInfoDao.save(account);

        return loginInfo;
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 修改预订
     * @time 2017-05-19
     */
    @Transactional(rollbackFor = Exception.class)
    public O_BookingInfoEntity updateBookingInfo(Long bookingID, Integer peopleNum, String memo) throws Exception {
        O_BookingInfoEntity bookingInfoEntity = o_BookingInfoDao.selectByPrimaryKey(bookingID);
        if (bookingInfoEntity == null) {
            throw new BizException(CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_CODE, CodeMsgConstants.ORDER_NOT_EXIST_ERROR_KEY_MSG);
        }
        if (bookingInfoEntity.getBookingStatus() != MerchantManageEnum.ReservaManage.SUCCESS.getValue() && bookingInfoEntity.getBookingStatus() != MerchantManageEnum.ReservaManage.PENDINGPAYMENT.getValue()) {
            throw new BizException(CodeMsgConstants.ORDER_NOT_UPDATE_ERROR_KEY_CODE, CodeMsgConstants.ORDER_NOT_UPDATE_ERROR_KEY_MSG);
        }
        bookingInfoEntity.setPeopleNum(peopleNum);
        bookingInfoEntity.setMemo(memo);
        o_BookingInfoDao.updateByPrimaryKeySelective(bookingInfoEntity);

        O_OrderInfoEntity orderInfoEntity = orderInfoDao.selectByPrimaryKey(bookingInfoEntity.getOrderID());
        orderInfoEntity.setPeopleNum(peopleNum);
        orderInfoDao.updateByPrimaryKeySelective(orderInfoEntity);

        return bookingInfoEntity;
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 取消预订
     * @time 2017-05-19
     */
    @Transactional(rollbackFor = Exception.class)
    public Long cancelBooking(Long bookingID, String memo, UserInfoVo loginInfo) throws Exception {
        O_BookingInfoEntity bookingInfoEntity = o_BookingInfoDao.selectByPrimaryKey(bookingID);

        //判断订单是否可以取消
        if (bookingInfoEntity.getBookingStatus() == null || (bookingInfoEntity.getBookingStatus() != MerchantManageEnum.ReservaManage.SUCCESS.getValue() && bookingInfoEntity.getBookingStatus() != MerchantManageEnum.ReservaManage.PENDINGPAYMENT.getValue())) {
            throw new BizException(CodeMsgConstants.ORDER_NOT_CANCEL_ERROR_KEY_CODE, CodeMsgConstants.ORDER_NOT_CANCEL_ERROR_KEY_MSG);
        }

        //更改订单状态,插入订单处理信息
        O_OrderInfoEntity orderInfoEntityQuery = new O_OrderInfoEntity();
        orderInfoEntityQuery.setOrderID(bookingInfoEntity.getOrderID());
        O_OrderInfoEntity orderInfoEntity = orderInfoDao.get(orderInfoEntityQuery);
        orderInfoEntity.setOrderStatus(OrderManageEnum.OrderStatus.CUSTOMERCANCEL.getValue());
        orderInfoDao.update(orderInfoEntity);

        //插入主订单处理信息
        O_OrderDealInfoEntity orderDealInfo = new O_OrderDealInfoEntity();
        orderDealInfo.setOrderID(orderInfoEntity.getOrderID());
        orderDealInfo.setBeforeStatus(orderInfoEntity.getOrderStatus());
        orderDealInfo.setAfterStatus(OrderManageEnum.OrderStatus.CUSTOMERCANCEL.getValue());
        orderDealInfo.setDealDesc("取消预订");
        orderDealInfo.setIsSync(true);
        o_OrderDealInfoDao.save(orderDealInfo);

        boolean isSameDate = DateUtils.isSameDate(bookingInfoEntity.getBookingTime(), LocalDateTime.now());//取消的订单是否为当天

        Integer duration = bookingInfoEntity.getDuration() == null ? 0 : bookingInfoEntity.getDuration();//预订结束时间
        if (bookingInfoEntity.getExtraMinute() != null && bookingInfoEntity.getExtraMinute() > 0) {
            duration += bookingInfoEntity.getExtraMinute();
        }

        //修改子订单状态,修改餐次桌台信息
        List<O_SubOrderInfoEntity> subOrderInfoList = subOrderInfoDao.getSubOrderInfoByOrderID(bookingInfoEntity.getOrderID());
        for (O_SubOrderInfoEntity subOrderInfo : subOrderInfoList) {
            //修改子订单状态
            subOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.CUSTOMERCANCEL.getValue());
            subOrderInfoDao.update(subOrderInfo);

            //如果为当天则修改餐次桌台信息
            if (isSameDate) {
                B_DinningTableInfoEntity dinningTableInfoQuery = new B_DinningTableInfoEntity();
                dinningTableInfoQuery.setTableID(subOrderInfo.getTableID());
                B_DinningTableInfoEntity dinningTableInfoEntity = dinningTableInfoDao.get(dinningTableInfoQuery);


                List<B_MealTableMappingEntity> mealTableMappingList = mealTableMappingDao.getBetweenMealsTableMapping(subOrderInfo.getTableID(),bookingInfoEntity.getBookingTime(),duration);
                if (mealTableMappingList == null || mealTableMappingList.size() == 0) {
                    continue;
                }
                for (B_MealTableMappingEntity mealTableMapping : mealTableMappingList) {//更改餐次桌台表为空闲状态
                    mealTableMapping.setIsBooking(false);
                    mealTableMapping.setTableStatus(MerchantManageEnum.TableStatus.EMPTYTABLE.getValue());
                    mealTableMappingDao.update(mealTableMapping);
                }
            }
        }

        //判断是否需要退款
        if (bookingInfoEntity.getBookingAmount() != null && bookingInfoEntity.getBookingAmount().doubleValue() > 0 && OrderManageEnum.PayStatus.HASPAID.equals(bookingInfoEntity.getPayStatus()) && bookingInfoEntity.getBookingStatus() == MerchantManageEnum.ReservaManage.PENDINGPAYMENT.getValue()) {
            float refundRate = this.getRefundRate(bookingInfoEntity);//获取退款比例

            //计算退款金额
            BigDecimal refundAmount = bookingInfoEntity.getBookingAmount().multiply(new BigDecimal(refundRate));

            //设置预订退款信息
            bookingInfoEntity.setRefundAmount(refundAmount);

            //获取商家资金账户
            addFundChangeInfoForMerchant(bookingInfoEntity, FinancialManageEnum.FundChangeType.REDUCE.getValue());
            //获取商家资金账户
//            //插入用户资金流水
            addFundChangeInfoForUser(bookingInfoEntity, FinancialManageEnum.FundChangeType.ADD.getValue());
        }

        //插入预定处理信息
        O_BookingDealInfoEntity o_BookingDealInfoEntity = new O_BookingDealInfoEntity();
        o_BookingDealInfoEntity.setBookingID(bookingInfoEntity.getBookingID());
        o_BookingDealInfoEntity.setBeforeStatus(bookingInfoEntity.getBookingStatus());
        o_BookingDealInfoEntity.setAfterStatus(MerchantManageEnum.ReservaManage.CANCELED.getValue());
        o_BookingDealInfoEntity.setChangeContent(memo);
        o_BookingDealInfoEntity.setDealDesc("取消预订,预订状态改为已取消（729）");
        o_BookingDealInfoEntity.setCreateTime(LocalDateTime.now());
        o_BookingDealInfoEntity.setIsSync(true);
        bookingDealInfoDao.save(o_BookingDealInfoEntity);

        //更改预订单状态
        bookingInfoEntity.setBookingStatus(MerchantManageEnum.ReservaManage.CANCELED.getValue());
        bookingInfoEntity.setRefundStatus(OrderManagerEnum.RefundStatus.REFUNDSUCCESS.getValue());//退款状态
        bookingInfoEntity.setRefundMethod(FinancialManageEnum.PayMethod.VIRTUALCURRENCY.getValue());//退款方式
        bookingInfoEntity.setMemo(memo);
        o_BookingInfoDao.updateByPrimaryKeySelective(bookingInfoEntity);

        return bookingID;
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 根据预订信息，获取退款比例
     * @time 2017-05-10 11:00:00
     */
    private Float getRefundRate(O_BookingInfoEntity o_bookinginfo) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mealsID", o_bookinginfo.getMealsID());
        map.put("bookingType", o_bookinginfo.getBookingType());
        map.put("archiveID", o_bookinginfo.getArchiveID());
        //退款比例未配置，就默认为1;
        List<B_PeriodConfigInfoEntity> periodConfigInfoList = b_PeriodConfigInfoDao.getPeriodConfigInfoByCondition(map);
        if (periodConfigInfoList == null || periodConfigInfoList.size() == 0) {
            return 1F;
        }

        this.sortPeriodConfigInfoList(periodConfigInfoList);

        //计算预订与当前时间差
        long minute = DateUtils.getMinutesBetween(o_bookinginfo.getBookingTime(), LocalDateTime.now());

        //查出多个退款比例信息时，根据预订时间跟当前时间匹配退款比例；
        for (int i = 0, l = periodConfigInfoList.size(); i < l; i++) {
            if (conversionMinute(periodConfigInfoList.get(i).getTimeUnit(), periodConfigInfoList.get(i).getDuration()) > minute) {
                return periodConfigInfoList.get(i).getRefundRate();
            }
        }
        return 1F;
    }

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 根据预订信息，获取退款规则
     * @time 2017-05-10 11:00:00
     */
    public B_PeriodConfigInfoEntity getRefundRule(O_BookingInfoEntity o_bookinginfo) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mealsID", o_bookinginfo.getMealsID());
        map.put("bookingType", o_bookinginfo.getBookingType());
        map.put("archiveID", o_bookinginfo.getArchiveID());
        //退款比例未配置，就默认为1;
        List<B_PeriodConfigInfoEntity> periodConfigInfoList = b_PeriodConfigInfoDao.getPeriodConfigInfoByCondition(map);
        if (periodConfigInfoList == null || periodConfigInfoList.size() == 0) {
            return null;
        }

        this.sortPeriodConfigInfoList(periodConfigInfoList);

        //计算预订与当前时间差
        long minute = DateUtils.getMinutesBetween(o_bookinginfo.getBookingTime(), LocalDateTime.now());

        //查出多个退款比例信息时，根据预订时间跟当前时间匹配退款比例；
        for (int i = 0, l = periodConfigInfoList.size(); i < l; i++) {
            if (conversionMinute(periodConfigInfoList.get(i).getTimeUnit(), periodConfigInfoList.get(i).getDuration()) > minute) {
                return periodConfigInfoList.get(i);
            }
        }
        return null;
    }

    private List<B_PeriodConfigInfoEntity> sortPeriodConfigInfoList(List<B_PeriodConfigInfoEntity> periodConfigInfoList) {
        //根据查询出来的时间排序
        B_PeriodConfigInfoEntity periodConfigInfoTem = null;
        int index = 0;
        for (int i = 0, l = periodConfigInfoList.size(); i < l - 1; i++) {
            index = i;
            for (int j = i + 1; j < l; j++) {
                if (conversionMinute(periodConfigInfoList.get(index).getTimeUnit(), periodConfigInfoList.get(index).getDuration()) > conversionMinute(periodConfigInfoList.get(j).getTimeUnit(), periodConfigInfoList.get(j).getDuration())) {
                    index = j;
                }
            }
            periodConfigInfoTem = periodConfigInfoList.get(index);
            periodConfigInfoList.set(index, periodConfigInfoList.get(i));
            periodConfigInfoList.set(i, periodConfigInfoTem);
        }
        return periodConfigInfoList;
    }

    /**
     * 把年，天，小时等时间转为分钟
     *
     * @return
     */
    private int conversionMinute(long type, int date) {
        if (type == CommonManageEnum.DurationType.DAY.getValue()) {
            return 60 * 24 * date;
        } else if (type == CommonManageEnum.DurationType.HOUR.getValue()) {
            return 60 * date;
        } else if (type == CommonManageEnum.DurationType.MINUTE.getValue()) {
            return date;
        }
        return 0;
    }

    /**
     * 添加商家资金变动信息
     *
     * @param changeType
     * @return
     * @throws Exception
     * @author LiuH
     */
    public Long addFundChangeInfoForMerchant(O_BookingInfoEntity bookingInfo, Long changeType) throws Exception {
        //插入商家资金流水
        B_MerchantInfoEntity merchantInfo = merchantInfoDao.getMerchantInfoByArchiveID(bookingInfo.getArchiveID());
        F_AccountInfoEntity accountInfoEntity = new F_AccountInfoEntity();
        accountInfoEntity.setCustomerID(merchantInfo.getOrgID()); //设置当前登录客户机构orgID
        accountInfoEntity.setCustomerType(CustomerManageEnum.CustomerType.MERCHANT.getValue());

        F_AccountInfoEntity accountInfoForMerchant = accountInfoDao.checkingAccount(accountInfoEntity);

        //--新增资金变动信息--
        F_FundChangeInfoEntity fundChangeInfoEntity = new F_FundChangeInfoEntity();
        fundChangeInfoEntity.setAccountType(FinancialManageEnum.AccountType.VIRTUALACCOUNT.getValue());// 账户类别 125为真实账户
        fundChangeInfoEntity.setBusinessType(FinancialManageEnum.FundChangeBusinessType.BOOKING.getValue()); // 资金业务类型
        fundChangeInfoEntity.setBusinessID(bookingInfo.getOrderID()); // 业务编号
        fundChangeInfoEntity.setChangeAmount(bookingInfo.getBookingAmount()); // 变动数量
        fundChangeInfoEntity.setIsSync(true);

        //变动后金额
        BigDecimal afterAmount = new BigDecimal(0);
        if (null != accountInfoForMerchant) {
            //账户编号
            fundChangeInfoEntity.setAccountID(accountInfoForMerchant.getAccountID());
        }
        fundChangeInfoEntity.setChangeID(MaxIDUtils.getID(F_FundChangeInfoEntity.class));
        //客户编号
        fundChangeInfoEntity.setCustomerID(null);
        //资金变动方式
        fundChangeInfoEntity.setChangeType(changeType);
        //变动前金额
        fundChangeInfoEntity.setBeforeAmount(accountInfoEntity.getReceivableAmount());
        //变动后金额
        fundChangeInfoEntity.setAfterAmount(accountInfoEntity.getReceivableAmount());
        //是否同步
        fundChangeInfoEntity.setIsSync(false);
        fundChangeInfoDao.save(fundChangeInfoEntity);

        return fundChangeInfoEntity.getChangeID();
    }

    /**
     * 添加用户资金变动信息
     *
     * @param changeType
     * @throws Exception
     * @author LiuH
     */
    public Long addFundChangeInfoForUser(O_BookingInfoEntity bookingInfo, Long changeType) throws Exception {
        //插入商家资金流水
        E_LoginInfoEntity loginInfoEntity = new E_LoginInfoEntity();
        loginInfoEntity.setLoginID(bookingInfo.getLoginID());
        loginInfoEntity = loginInfoDao.get(loginInfoEntity);
        F_AccountInfoEntity accountInfoEntity = new F_AccountInfoEntity();
        accountInfoEntity.setCustomerID(loginInfoEntity.getCustomerID()); //设置当前登录客户机构orgID
        accountInfoEntity.setCustomerType(CustomerManageEnum.CustomerType.DINER.getValue());

        F_AccountInfoEntity accountInfoForMerchant = accountInfoDao.checkingAccount(accountInfoEntity);

        //--新增资金变动信息--
        F_FundChangeInfoEntity fundChangeInfoEntity = new F_FundChangeInfoEntity();
        fundChangeInfoEntity.setAccountType(FinancialManageEnum.AccountType.VIRTUALACCOUNT.getValue());// 账户类别 125为真实账户
        fundChangeInfoEntity.setBusinessType(FinancialManageEnum.FundChangeBusinessType.BOOKING.getValue()); // 资金业务类型
        fundChangeInfoEntity.setBusinessID(bookingInfo.getOrderID()); // 业务编号
        fundChangeInfoEntity.setChangeAmount(bookingInfo.getBookingAmount()); // 变动数量
        fundChangeInfoEntity.setIsSync(true);

        //变动后金额
        if (null != accountInfoForMerchant) {
            //账户编号
            fundChangeInfoEntity.setAccountID(accountInfoForMerchant.getAccountID());
        }
        fundChangeInfoEntity.setChangeID(MaxIDUtils.getID(F_FundChangeInfoEntity.class));
        //客户编号
        fundChangeInfoEntity.setCustomerID(null);
        //资金变动方式
        fundChangeInfoEntity.setChangeType(changeType);
        //变动前金额
        fundChangeInfoEntity.setBeforeAmount(accountInfoEntity.getReceivableAmount());
        //变动后金额
        fundChangeInfoEntity.setAfterAmount(accountInfoEntity.getReceivableAmount());
        fundChangeInfoDao.save(fundChangeInfoEntity);

        return fundChangeInfoEntity.getChangeID();
    }

    /**
     * @description 查询用户预订记录信息
     * @author Zhaolingchen
     * @time 2017-5-23 10:12
     * @version 2.0.0
     */
    public List<O_BookingInfoEntity> getMemberBookingRecordInfo(Map<String, Object> param) {
        return o_BookingInfoDao.getMemberBookingRecordInfo(param);
    }

    /**
     * @description 查询用户预订记录信息
     * @author Zhaolingchen
     * @time 2017-5-23 10:12
     * @version 2.0.0
     */
    public List<Map<String, Object>> getOrderDishesRecordInfo(Map<String, Object> param) {
        return orderInfoDao.getOrderDishesRecordInfo(param);
    }

 /**
     * @description 查询用户口味偏好
     * @author Zhaolingchen
     * @time 2017-6-23 10:12
     * @version 2.0.0
     */
    public List<Map<String, Object>> getOrderTasteRecordInfo(Map<String, Object> param) {
        return orderInfoDao.getOrderTasteRecordInfo(param);
    }

    /**
     * @description 根据桌台ID,当前时间的预订单
     * @author Zhaolingchen
     * @time 2017-6-14 14:12
     * @version 2.0.0
     */
    public O_BookingInfoEntity getBookingInfoByTableID(Long TableID,LocalDateTime time) {
        O_BookingInfoEntity bookingInfoEntity = new O_BookingInfoEntity();
        bookingInfoEntity.setBookingTime(time);
        bookingInfoEntity.setTableID(TableID);

        return o_BookingInfoDao.getBookingInfoByTableID(bookingInfoEntity);
    }
}