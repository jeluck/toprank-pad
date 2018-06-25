package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.FinancialManageEnum;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.enums.SystemManageEnum;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.util.OkHttpClientUtils;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.dto.PayResult;
import cc.toprank.byd.web.dto.PaymentDTO;
import cc.toprank.byd.web.vo.paymentvo.AmountSituationVO;
import cc.toprank.byd.web.vo.paymentvo.PaymentInfoVO;
import cc.toprank.byd.web.vo.paymentvo.PaymentVos;
import cc.toprank.byd.web.vo.paymentvo.ThirdPartyPayParamVO;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支付
 * Created by HuangCY on 2017-4-13.
 */
@Service("paymentService")
public class PaymentService {

    //子订单信息
    @Autowired
    private O_SubOrderInfoDao o_SubOrderInfoDao;
    //订单信息
    @Autowired
    private O_OrderInfoDao o_OrderInfoDao;
    //订单处理信息
    @Autowired
    private OrderDealInfoService orderDealInfoService;
    //资金变动信息
    @Autowired
    private FundChangeInfoService fundChangeInfoService;
    //资金变动明细信息
    @Autowired
    private F_FundChangeDetailInfoDao f_FundChangeDetailInfoDao;
    //桌台使用信息
    @Autowired
    private B_DinningTableUseInfoDao b_DinningTableUseInfoDao;
    //桌台信息
    @Autowired
    private B_DinningTableInfoDao b_DinningTableInfoDao;
    //餐次桌台信息
    @Autowired
    private B_MealTableMappingDao b_MealTableMappingDao;
    //支付金额情况
    @Autowired
    private AmountSituationService amountSituationService;
    //商家基本参数信息
    @Autowired
    private BasicParamInfoService basicParamInfoService;
    //预订
    @Autowired
    private O_BookingInfoDao o_BookingInfoDao;
    //订单关联明细
    @Autowired
    private OrderRelationDetailInfoService orderRelationDetailInfoService;
    //订单关联信息
    @Autowired
    private O_OrderRelationMappingDao o_OrderRelationMappingDao;

    // 日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 支付流程
     * @time 2017-5-5 17:29
     */
    @Transactional
    public void paymentProcess(PaymentDTO paymentDTO, List<PaymentInfoVO> paymentInfoVOList) throws Exception {
        boolean onlinePay = false;

        for(PaymentInfoVO pay : paymentInfoVOList){
            //存在线上支付，那么就要调用财务系统的接口
            if(pay.isOnline()){
                onlinePay = true;
            }
        }

        List<Long> subOrderIDList = paymentDTO.getSubOrderIDList();

        //获取支付订单ID和待付金额
        PayOrderDTO payOrderDTO = getOrderID(subOrderIDList, paymentDTO.getOperatorID());

        //存在线上支付，那么就要调用财务系统的接口
        if(onlinePay){
            List<PaymentVos> paymentVosList = new ArrayList<>();

            BigDecimal totalAmount = BigDecimal.ZERO;

            for(int j = 0 ; j < paymentInfoVOList.size() ; j++){
                if(!paymentInfoVOList.get(j).isOnline()){
                    PaymentVos paymentVos = new PaymentVos();

                    paymentVos.setPaymentMethodID(paymentInfoVOList.get(j).getPaymentMethodID());

                    //处理支付金额(把元转成分)
                    BigDecimal paymentAmount = paymentInfoVOList.get(j).getPaymentAmount().multiply(BigDecimal.valueOf(100));

                    totalAmount = totalAmount.add(paymentAmount);

                    //去掉小数位
                    Integer castPaymentAmount = paymentAmount.intValue();
                    paymentVos.setPaymentMoney(castPaymentAmount);

                    paymentVosList.add(paymentVos);
                }
            }

            //存在支付金额才调用第三方支付接口
            if(totalAmount.compareTo(BigDecimal.ZERO) == 1){
                ThirdPartyPayParamVO thirdPartyPayParamVO = new ThirdPartyPayParamVO();

                thirdPartyPayParamVO.setArchiveID(paymentDTO.getArchiveID());
                thirdPartyPayParamVO.setPaymentAmount(totalAmount);
                thirdPartyPayParamVO.setSubOrderIDList(paymentDTO.getSubOrderIDList());
                thirdPartyPayParamVO.setLoginID(paymentDTO.getOperatorID());

                //线上支付
                paymentProcessForOnline(thirdPartyPayParamVO , paymentVosList);
            }
        }else{
            //订单状态
            Long orderStatus = null;

            paymentDTO.setPaymentAmount(payOrderDTO.getTotalAmount());

            //全单结账时查询订单状态，为了验证是否是预订的二次结账
            if (payOrderDTO.getBusinessType().equals(FinancialManageEnum.FundChangeBusinessType.ORDER.getValue())) {
                O_OrderInfoEntity orderInfoEntity = o_OrderInfoDao.queryOrderInfoByOrderID(payOrderDTO.getOrderID());
                orderStatus = orderInfoEntity.getOrderStatus();
            }

            //订单状态不为已完成，为正常结账；反之则是预订的二次结账
            if (!orderStatus.equals(OrderManageEnum.OrderStatus.COMPLETED.getValue())) {
                //添加资金变动信息
                addFundChangeInfo(paymentDTO, paymentInfoVOList);
                //改变订单状态&新增订单处理信息
                handleOrderInfo(subOrderIDList, payOrderDTO);
            }

            //改变桌台信息
            changeTableInfo(paymentDTO);
        }
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 预订支付流程
     * @time 2017-6-7 16:02
     */
    @Transactional
    public void paymentProcessForBooking(PaymentDTO paymentDTO, List<PaymentInfoVO> paymentInfoVOList) throws Exception {
        //根据预订ID查询预订信息
        O_BookingInfoEntity bookingInfoEntity = o_BookingInfoDao.selectByPrimaryKey(paymentDTO.getBookingID());

        //验证预订信息
        if (null != bookingInfoEntity) {
            //根据订单ID查询订单信息
            O_OrderInfoEntity orderInfoEntity = o_OrderInfoDao.queryOrderInfoByOrderID(bookingInfoEntity.getOrderID());

            //预订类型
            Long bookingType;

            List<Long> subOrderIDList = new ArrayList<>();

            PayOrderDTO payOrderDTO = new PayOrderDTO();

            //订单总额
            BigDecimal totalAmount;

            //如果预订的订单金额不为空，说明是全额付款；反之则是支付留位金
            if (null != orderInfoEntity && null != orderInfoEntity.getTotalAmount()) {
                totalAmount = orderInfoEntity.getTotalAmount();

                List<O_SubOrderInfoEntity> subOrderInfoList = o_SubOrderInfoDao.queryByOrderID(orderInfoEntity.getOrderID());

                for(int i = 0 ; i < subOrderInfoList.size() ; i++){
                    subOrderIDList.add(subOrderInfoList.get(i).getSubOrderID());
                }

                paymentDTO.setSubOrderIDList(subOrderIDList);

                bookingType = MerchantManageEnum.BookingType.FULLPAYMENT.getValue();

                payOrderDTO = getOrderID(subOrderIDList, paymentDTO.getOperatorID());

                paymentDTO.setPaymentAmount(payOrderDTO.getTotalAmount());
            } else {
                //预订金额
                totalAmount = bookingInfoEntity.getPendingAmount();

                bookingType = MerchantManageEnum.BookingType.RESERVEDSEAT.getValue();

                paymentDTO.setPaymentAmount(totalAmount);

                paymentDTO.setBusinessType(FinancialManageEnum.FundChangeBusinessType.BOOKING.getValue());
            }

            //添加资金变动信息
            addFundChangeInfo(paymentDTO, paymentInfoVOList);

            O_BookingInfoEntity bookingSetParamsEntity = new O_BookingInfoEntity();

            bookingSetParamsEntity.setBookingID(paymentDTO.getBookingID());
            bookingSetParamsEntity.setPayStatus(OrderManageEnum.PayStatus.HASPAID.getValue());
            bookingSetParamsEntity.setBookingStatus(MerchantManageEnum.ReservaManage.SUCCESS.getValue());
            bookingSetParamsEntity.setBookingType(bookingType);

            if(totalAmount.compareTo(BigDecimal.ZERO) == 1){
                bookingSetParamsEntity.setBookingAmount(totalAmount);
            }

            //根据预订ID更新预订信息
            o_BookingInfoDao.updateByBookingID(bookingSetParamsEntity);

            //全额付款
            if (bookingType.equals(MerchantManageEnum.BookingType.FULLPAYMENT.getValue())) {
                //改变订单状态&新增订单处理信息
                handleOrderInfo(subOrderIDList, payOrderDTO);
            }
        } else {
            throw new BizException(CodeMsgConstants.BOOKING_INFO_NOT_EXIST,CodeMsgConstants.BOOKING_INFO_NOT_EXIST_MSG);
        }
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 线上支付
     * @time 2017-6-16 11:32
     */
    @Transactional
    public PayResult paymentProcessForOnline(ThirdPartyPayParamVO thirdPartyPayParamVO , List<PaymentVos> paymentVosList) throws Exception {
        //获取支付订单ID
        PayOrderDTO payOrderDTO = getOrderID(thirdPartyPayParamVO.getSubOrderIDList(), thirdPartyPayParamVO.getLoginID());

        PayResult resultData = new PayResult();

        Map payMap = new HashMap();

        //整单支付 获取订单描述
        if(payOrderDTO.getBusinessType().equals(FinancialManageEnum.FundChangeBusinessType.ORDER.getValue())){
            O_OrderInfoEntity orderInfoEntity = o_OrderInfoDao.queryOrderInfoByOrderID(payOrderDTO.getOrderID());

            payMap.put("orderDesc", orderInfoEntity.getOrderDesc());
        }

        //处理支付金额(把元转成分)
        BigDecimal paymentAmount = thirdPartyPayParamVO.getPaymentAmount().multiply(BigDecimal.valueOf(100));
        //去掉小数位
        Integer castPaymentAmount = paymentAmount.intValue();

        payMap.put("orderNumber", payOrderDTO.getOrderID().toString());
        payMap.put("orderMoney", castPaymentAmount.toString());
        payMap.put("businessType", payOrderDTO.getBusinessType().toString());
        payMap.put("archiveID", thirdPartyPayParamVO.getArchiveID().toString());
        payMap.put("orderName", "订单支付");
        payMap.put("paymentVos", paymentVosList);

        if(null != thirdPartyPayParamVO.getCustomerID()){
            payMap.put("customerID", thirdPartyPayParamVO.getCustomerID());
        }

        //请求支付网关地址
        JSONObject payResultJson = OkHttpClientUtils.payRequest(payMap);

        if (null != payResultJson) {
            //把返回的数据转为map
            Map map = JSONObject.parseObject(payResultJson.toString(), new TypeReference<Map>() {
            });

            //返回的状态 0为成功 1为失败
            int status = Integer.valueOf(map.get("status").toString());

            if(status == 0){
                if(null != map.get("data")){
                    List<Map> resultList;

                    resultList = JSONObject.parseArray(map.get("data").toString(), Map.class);

                    for (Map map1 : resultList) {
                        String payStatus = map1.get("status").toString();

                        //支付成功
                        if(payStatus.equals("SUCCESS")){
                            resultData.setCode(CodeMsgConstants.THIRD_PARTY_PAY_SUCCESS);
                            resultData.setMessage(CodeMsgConstants.THIRD_PARTY_PAY_SUCCESS_MSG);
                        }
                        //第三方未即时返回成功消息，还为支付中状态
                        if(payStatus.equals("PAYING")){
                            resultData.setCode(CodeMsgConstants.THIRD_PARTY_SUCCESS);
                            resultData.setMessage(CodeMsgConstants.THIRD_PARTY_SUCCESS_MSG);
                        }
                        //支付失败
                        if(payStatus.equals("ERROR") || payStatus.equals("FAIL") ){
                            logger.info("调用支付接口错误信息：" + map1.get("requestData").toString());
                            throw new BizException(CodeMsgConstants.THIRD_PARTY_ERROR,CodeMsgConstants.THIRD_PARTY_ERROR_MSG);
                        }
                    }
                }
            }else{
                throw new BizException(Integer.valueOf(map.get("code").toString()),map.get("msg").toString());
            }
        } else {
            throw new BizException(CodeMsgConstants.THIRD_PARTY_ERROR,CodeMsgConstants.THIRD_PARTY_ERROR_MSG);
        }

        return resultData;
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 修改订单折扣金额
     * @time 2017-6-13 17:28
     */
    @Transactional
    private void updateOrderDiscountAmount(PaymentDTO paymentDTO, PayOrderDTO payOrderDTO) throws Exception {
        //获取订单折扣信息
        //List<O_OrderKDiscountMappingEntity> discountList = o_OrderDiscountMappingDao.queryDiscountInfoByOrderID(payOrderDTO);

        //获取订单金额情况
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(paymentDTO.getSubOrderIDList(), paymentDTO.getArchiveID(), paymentDTO.getOperatorID());

        BigDecimal discountAmount = new BigDecimal(0);

        if (null != amountSituationVO.getDiscountAmount()) {
            discountAmount = discountAmount.add(amountSituationVO.getDiscountAmount());
        } else if (null != amountSituationVO.getReductionAmount()) {
            discountAmount = discountAmount.add(amountSituationVO.getReductionAmount());
        } else if (null != amountSituationVO.getGiveProductAmount()) {
            discountAmount = discountAmount.add(amountSituationVO.getGiveProductAmount());
        } else if (null != amountSituationVO.getDroptailAmount()) {
            discountAmount = discountAmount.add(amountSituationVO.getDroptailAmount());
        }
        if (null != amountSituationVO.getServiceFee()) {
            discountAmount = discountAmount.subtract(amountSituationVO.getServiceFee());
        }
        //折扣金额为0，则不改动订单的折扣金额
        if(discountAmount.compareTo(BigDecimal.ZERO) != 0){
            //把所有的折扣金额存入到订单的折扣金额中去
            if (payOrderDTO.getBusinessType().equals(FinancialManageEnum.FundChangeBusinessType.ORDER.getValue())) {
                O_OrderInfoEntity orderInfoEntity = new O_OrderInfoEntity();

                orderInfoEntity.setOrderID(payOrderDTO.getOrderID());
                orderInfoEntity.setDiscountAmount(discountAmount);

                o_OrderInfoDao.updateDiscountAmountByOrderID(orderInfoEntity);
            }
            if (payOrderDTO.getBusinessType().equals(FinancialManageEnum.FundChangeBusinessType.SUBORDERINFO.getValue())) {
                O_OrderRelationMappingEntity orderRelationMappingEntity = new O_OrderRelationMappingEntity();

                orderRelationMappingEntity.setMappingID(payOrderDTO.getOrderID());
                orderRelationMappingEntity.setDiscountAmount(discountAmount);

                o_OrderRelationMappingDao.updateDiscountAmountByMappingOrderID(orderRelationMappingEntity);
            }
        }
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 获取支付订单号
     * @time 2017-6-12 17:03
     */
    @Transactional
    public PayOrderDTO getOrderID(List<Long> subOrderIDList, Long loginID) throws Exception {
        PayOrderDTO payOrderDTO = new PayOrderDTO();

        //数量
        Integer quantity = 0;
        //订单总额
        BigDecimal totalAmount = new BigDecimal(0);
        //订单折扣金额
        BigDecimal discountAmount = new BigDecimal(0);
        //实际金额
        BigDecimal actualAmount = new BigDecimal(0);

        //根据子订单ID集合查询子订单信息集合
        List<O_SubOrderInfoEntity> subOrderInfoList = o_SubOrderInfoDao.querySubOrderInfoByIDs(subOrderIDList);

        boolean sameOrderID = true;

        for (int i = 0; i < subOrderInfoList.size(); i++) {
            //累加商品数量
            quantity = quantity + subOrderInfoList.get(i).getQuantity();

            totalAmount = totalAmount.add(subOrderInfoList.get(i).getPendingAmount());
            discountAmount = discountAmount.add(subOrderInfoList.get(i).getDiscountAmount());
            actualAmount = actualAmount.add(subOrderInfoList.get(i).getActualAmount());

            for (int j = 0; j < subOrderInfoList.size() - i && i > 0; j++) {
                //如果有不一样订单ID的子订单信息，标识则为false
                if (!subOrderInfoList.get(j).getOrderID().equals(subOrderInfoList.get(j + 1).getOrderID())) {
                    sameOrderID = false;
                }
            }
        }

        payOrderDTO.setTotalAmount(totalAmount);

        //主订单ID一样则是全单支付,反之则为组合支付
        if (sameOrderID) {
            payOrderDTO.setOrderID(subOrderInfoList.get(0).getOrderID());

            payOrderDTO.setBusinessType(FinancialManageEnum.FundChangeBusinessType.ORDER.getValue());
        } else {
            O_OrderRelationDetailInfoEntity orderRelationDetailInfoEntity = orderRelationDetailInfoService.queryOrderRelationBySubOrderID(subOrderInfoList.get(0).getSubOrderID());

            //已经添加了订单关联信息，直接取MappingID
            if(null == orderRelationDetailInfoEntity){
                payOrderDTO.setBusinessType(FinancialManageEnum.FundChangeBusinessType.SUBORDERINFO.getValue());

                O_OrderRelationMappingEntity orderRelationMappingEntity = new O_OrderRelationMappingEntity();

                orderRelationMappingEntity.setQuantity(quantity);
                orderRelationMappingEntity.setCreatorID(loginID);
                orderRelationMappingEntity.setIsOrder(false);
                orderRelationMappingEntity.setOrderID(subOrderInfoList.get(0).getOrderID());
                orderRelationMappingEntity.setCreateTime(LocalDateTime.now());
                orderRelationMappingEntity.setActualAmount(actualAmount);
                orderRelationMappingEntity.setDiscountAmount(discountAmount);
                orderRelationMappingEntity.setTotalAmount(totalAmount);
                orderRelationMappingEntity.setMappingType(SystemManageEnum.EntityStatus.NORMAL.getValue());
                orderRelationMappingEntity.setMappingStatus(1L);
                orderRelationMappingEntity.setPayStatus(subOrderInfoList.get(0).getPayStatus());
                orderRelationMappingEntity.setMappingID(MaxIDUtils.getID(O_OrderRelationMappingEntity.class));

                o_OrderRelationMappingDao.saveOrderRelationMapping(orderRelationMappingEntity);

                payOrderDTO.setOrderID(orderRelationMappingEntity.getMappingID());

                for (int i = 0; i < subOrderInfoList.size(); i++) {
                    orderRelationDetailInfoService.saveOrderRelationDetailInfo(orderRelationMappingEntity.getMappingID(), subOrderInfoList.get(i).getSubOrderID(),
                            subOrderInfoList.get(i).getActualAmount(), loginID);
                }
            }else{
                payOrderDTO.setOrderID(orderRelationDetailInfoEntity.getMappingID());
            }
        }

        return payOrderDTO;
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 添加资金变动信息 & 资金变动明细
     * @time 2017-4-10 16:51
     */
    @Transactional
    private void addFundChangeInfo(PaymentDTO paymentDTO, List<PaymentInfoVO> paymentInfoVOList) throws Exception {
        //支付金额
        BigDecimal paymentAmount = paymentDTO.getPaymentAmount();

        F_FundChangeInfoEntity fundChangeSetParamsEntity = new F_FundChangeInfoEntity();

        fundChangeSetParamsEntity.setChangeID(MaxIDUtils.getID(F_FundChangeInfoEntity.class));
        fundChangeSetParamsEntity.setChangeType(FinancialManageEnum.FundChangeType.ADD.getValue());
        fundChangeSetParamsEntity.setArchiveID(paymentDTO.getArchiveID());
        fundChangeSetParamsEntity.setBusinessType(paymentDTO.getBusinessType());
        fundChangeSetParamsEntity.setBusinessID(paymentDTO.getOrderID());
        fundChangeSetParamsEntity.setCreatorID(paymentDTO.getOperatorID());
        fundChangeSetParamsEntity.setCreateTime(LocalDateTime.now());
        fundChangeSetParamsEntity.setChangeAmount(paymentAmount);

        // 添加资金变动信息并返回主键
        Long changeID = fundChangeInfoService.addFundChangeInfo(fundChangeSetParamsEntity);

        for (int i = 0; i < paymentInfoVOList.size(); i++) {
            F_FundChangeDetailInfoEntity fundChangeDetailSetParamsEntity = new F_FundChangeDetailInfoEntity();

            fundChangeDetailSetParamsEntity.setDetailID(MaxIDUtils.getID(F_FundChangeDetailInfoEntity.class));
            fundChangeDetailSetParamsEntity.setPaymentMethodID(paymentInfoVOList.get(i).getPaymentMethodID());
            fundChangeDetailSetParamsEntity.setChangeAmount(paymentInfoVOList.get(i).getPaymentAmount());
            fundChangeDetailSetParamsEntity.setChangeID(changeID);
            fundChangeDetailSetParamsEntity.setCreateTime(LocalDateTime.now());

            f_FundChangeDetailInfoDao.saveFundChangeDetailInfo(fundChangeDetailSetParamsEntity);
        }
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 支付成功后处理订单信息：1.改变订单状态信息,2.添加订单处理信息
     * @time 2017-4-11 14:58
     */
    @Transactional
    private void handleOrderInfo(List<Long> subOrderIDList, PayOrderDTO payOrderDTO) throws Exception {
        //支付成功的待付金额
        BigDecimal pendingAmount = new BigDecimal(0);

        for (int i = 0; i < subOrderIDList.size(); i++) {
            // 根据子订单编号查询子订单信息
            O_SubOrderInfoEntity beforeSubOrderEntity = o_SubOrderInfoDao.querySubOrderInfoBySubOrderID(subOrderIDList.get(i));

            //验证子订单
            if (null != beforeSubOrderEntity) {
                // 设置子订单处理前状态
                Long beforeStatus = beforeSubOrderEntity.getOrderStatus();
                //处理前金额
                BigDecimal beforeAmount = beforeSubOrderEntity.getPendingAmount();
                //累加子订单的待付金额
                pendingAmount = pendingAmount.add(beforeSubOrderEntity.getPendingAmount());

                O_SubOrderInfoEntity entity = new O_SubOrderInfoEntity();

                //设置订单状态
                entity.setOrderStatus(OrderManageEnum.OrderStatus.COMPLETED.getValue());
                //设置支付状态
                entity.setPayStatus(OrderManageEnum.PayStatus.HASPAID.getValue());
                //支付成功待付金额为0
                entity.setPendingAmount(BigDecimal.ZERO);
                //设置子订单编号
                entity.setSubOrderID(subOrderIDList.get(i));
                entity.setPaidTime(LocalDateTime.now());

                // 根据子订单编号改变子订单状态
                o_SubOrderInfoDao.updateByID(entity);

                Map subOrderMap = new HashMap();
                subOrderMap.put("subOrderID", subOrderIDList.get(i));
                subOrderMap.put("befSubOrderStatus", beforeStatus);
                if(null != beforeAmount && beforeAmount.compareTo(BigDecimal.ZERO) == 1){
                    subOrderMap.put("befSubOrderPendingAmount", beforeAmount);
                }

                // 新增子订单处理信息
                orderDealInfoService.addOrderDealInfo(subOrderMap);

                boolean isComplete = true;

                //组合支付
                if (payOrderDTO.getBusinessType().equals(FinancialManageEnum.FundChangeBusinessType.SUBORDERINFO.getValue())) {
                    O_OrderRelationMappingEntity orderRelationMappingEntity = new O_OrderRelationMappingEntity();

                    orderRelationMappingEntity.setPaidTime(LocalDateTime.now());
                    orderRelationMappingEntity.setPayStatus(OrderManageEnum.PayStatus.HASPAID.getValue());
                    orderRelationMappingEntity.setMappingID(payOrderDTO.getOrderID());

                    o_OrderRelationMappingDao.updatePayStatusByMappingID(orderRelationMappingEntity);

                    // 根据订单编号查询子订单信息
                    List<O_SubOrderInfoEntity> subOrderInfoEntityList = o_SubOrderInfoDao.queryByOrderID(beforeSubOrderEntity.getOrderID());

                    for (int k = 0; k < subOrderInfoEntityList.size(); k++) {
                        // 如果同一个订单的子订单的支付状态还不为已支付，那么就不改变主订单状态
                        if (null == subOrderInfoEntityList.get(k).getPayStatus() || subOrderInfoEntityList.get(k).getPayStatus() != OrderManageEnum.PayStatus.HASPAID.getValue()) {
                            isComplete = false;
                        }
                    }
                }

                // 根据订单编号查询订单信息
                O_OrderInfoEntity orderInfoEntity = o_OrderInfoDao.queryOrderInfoByOrderID(beforeSubOrderEntity.getOrderID());

                // 订单处理前状态
                Long beforeOrderStatus = orderInfoEntity.getOrderStatus();
                //处理前金额
                BigDecimal beforeOrderAmount = orderInfoEntity.getPendingAmount();

                O_OrderInfoEntity orderParamsEntity = new O_OrderInfoEntity();

                orderParamsEntity.setOrderID(orderInfoEntity.getOrderID());

                //子订单全部支付完毕才改主订单的状态
                if (isComplete) {
                    orderParamsEntity.setOrderStatus(OrderManageEnum.OrderStatus.COMPLETED.getValue());
                    orderParamsEntity.setPayStatus(OrderManageEnum.PayStatus.HASPAID.getValue());
                }

                orderParamsEntity.setPaidTime(LocalDateTime.now());
                orderParamsEntity.setPendingAmount(pendingAmount);

                //根据订单编号改变订单状态
                o_OrderInfoDao.updateOrderInfoStatus(orderParamsEntity);

                Map orderMap = new HashMap();

                orderMap.put("orderID", beforeSubOrderEntity.getOrderID());

                if (isComplete) {
                    orderMap.put("befOrderStatus", beforeOrderStatus);
                }
                if(null != beforeOrderAmount && beforeOrderAmount.compareTo(BigDecimal.ZERO) == 1) {
                    orderMap.put("befOrderPendingAmount", beforeOrderAmount);
                }

                // 新增订单处理信息
                orderDealInfoService.addOrderDealInfo(orderMap);
            } else {
                throw new BizException(CodeMsgConstants.PAYMENT_SUBORDERID_NOT_EXIST,CodeMsgConstants.PAYMENT_SUBORDERID_NOT_EXIST_MSG);
            }
        }
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 第三方支付前改订单状态
     * @time 2017-6-14 16:08
     */
    @Transactional
    private void updateOrderStatusBeforePay(List<Long> subOrderIDList) throws Exception {
        for (int i = 0; i < subOrderIDList.size(); i++) {
            // 根据子订单编号查询子订单信息
            O_SubOrderInfoEntity beforeSubOrderEntity = o_SubOrderInfoDao.querySubOrderInfoBySubOrderID(subOrderIDList.get(i));
            // 设置子订单处理前状态
            Long beforeStatus = beforeSubOrderEntity.getOrderStatus();

            O_SubOrderInfoEntity entity = new O_SubOrderInfoEntity();

            //设置订单状态
            entity.setOrderStatus(OrderManageEnum.OrderStatus.WAITINGPAY.getValue());
            //设置支付状态
            entity.setPayStatus(OrderManageEnum.PayStatus.PAYING.getValue());
            //设置子订单编号
            entity.setSubOrderID(subOrderIDList.get(i));
            entity.setPaidTime(LocalDateTime.now());

            // 根据子订单编号改变子订单状态
            o_SubOrderInfoDao.updateByID(entity);

            Map subOrderMap = new HashMap();
            subOrderMap.put("subOrderID", subOrderIDList.get(i));
            subOrderMap.put("befSubOrderStatus", beforeStatus);

            // 新增子订单处理信息
            orderDealInfoService.addOrderDealInfo(subOrderMap);

            // 根据订单编号查询子订单信息
            List<O_SubOrderInfoEntity> subOrderInfoEntityList = o_SubOrderInfoDao.queryByOrderID(beforeSubOrderEntity.getOrderID());

            boolean isComplete = true;

            for (int k = 0; k < subOrderInfoEntityList.size(); k++) {
                // 如果同一个订单的子订单的支付状态还不为支付中，那么就不改变主订单状态
                if (null == subOrderInfoEntityList.get(k).getPayStatus() || subOrderInfoEntityList.get(k).getPayStatus() != OrderManageEnum.PayStatus.PAYING.getValue()) {
                    isComplete = false;
                }
            }
            if (isComplete) {
                // 根据订单编号查询订单信息
                O_OrderInfoEntity orderInfoEntity = o_OrderInfoDao.queryOrderInfoByOrderID(beforeSubOrderEntity.getOrderID());

                // 订单处理前状态
                Long beforeOrderStatus = orderInfoEntity.getOrderStatus();

                O_OrderInfoEntity orderParamsEntity = new O_OrderInfoEntity();

                orderParamsEntity.setOrderID(orderInfoEntity.getOrderID());
                orderParamsEntity.setOrderStatus(OrderManageEnum.OrderStatus.WAITINGPAY.getValue());
                orderParamsEntity.setPayStatus(OrderManageEnum.PayStatus.PAYING.getValue());
                orderParamsEntity.setPaidTime(LocalDateTime.now());

                //根据订单编号改变订单状态
                o_OrderInfoDao.updateOrderInfoStatus(orderParamsEntity);

                Map orderMap = new HashMap();

                orderMap.put("orderID", beforeSubOrderEntity.getOrderID());
                orderMap.put("befOrderStatus", beforeOrderStatus);

                // 新增订单处理信息
                orderDealInfoService.addOrderDealInfo(orderMap);
            }
        }
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 改变桌台状态
     * @time 2017-4-11 17:15
     */
    @Transactional
    private void changeTableInfo(PaymentDTO paymentDTO) throws Exception {
        for (int i = 0; i < paymentDTO.getSubOrderIDList().size(); i++) {
            // 根据子订单编号查询子订单信息
            O_SubOrderInfoEntity subOrderInfoEntity = o_SubOrderInfoDao.querySubOrderInfoBySubOrderID(paymentDTO.getSubOrderIDList().get(i));

            //验证子订单
            if (null != subOrderInfoEntity) {
                B_DinningTableUseInfoEntity dinningTableUseInfoEntity = new B_DinningTableUseInfoEntity();
                //桌台ID
                dinningTableUseInfoEntity.setTableID(subOrderInfoEntity.getTableID());
                //餐次ID
                dinningTableUseInfoEntity.setMealsID(subOrderInfoEntity.getMealsID());
                //档案ID
                dinningTableUseInfoEntity.setArchiveID(paymentDTO.getArchiveID());

                //查询桌台使用信息
                B_DinningTableUseInfoEntity dinningTableUseInfo = b_DinningTableUseInfoDao.Get_ReceptionB_DinningTableUseInfoEntityByTableID(dinningTableUseInfoEntity);

                //验证桌台使用信息
                if (null != dinningTableUseInfo) {
                    B_DinningTableInfoEntity dinningTableSetParamsEntity = new B_DinningTableInfoEntity();

                    //桌台ID
                    dinningTableSetParamsEntity.setTableID(dinningTableUseInfo.getTableID());

                    //根据桌台ID查询桌台信息
                    B_DinningTableInfoEntity dinningTableInfo = b_DinningTableInfoDao.get(dinningTableSetParamsEntity);

                    if (null != dinningTableInfo) {
                        //拼桌数
                        int shareNumber = 0;

                        //如果为拼桌结账，不能直接改桌台状态，要把拼的桌子数全部结完才改
                        if (null != dinningTableInfo.getShareNumber() && dinningTableInfo.getShareNumber() > 0) {
                            //减少拼桌数
                            shareNumber = dinningTableInfo.getShareNumber() - 1;

                            if (null != dinningTableUseInfo.getCustomerNumber() && dinningTableUseInfo.getCustomerNumber() > 0) {
                                //桌子的总用餐人数
                                int peopleNum = dinningTableUseInfo.getCustomerNumber();

                                peopleNum = peopleNum - subOrderInfoEntity.getPeopleNum();

                                //设置桌子的消费人数
                                dinningTableUseInfo.setCustomerNumber(peopleNum);
                            }

                            //设置拼桌数
                            dinningTableInfo.setShareNumber(shareNumber);
                            //修改桌台信息的卓台数
                            b_DinningTableInfoDao.update(dinningTableInfo);

                            //设置拼桌数
                            dinningTableUseInfo.setShareNumber(shareNumber);
                            //修改桌台使用信息的卓台数
                            b_DinningTableUseInfoDao.update(dinningTableUseInfo);
                        }

                        //不是拼桌结账或拼桌全部结账完成则改桌台餐次和使用信息
                        if (shareNumber == 0) {
                            //桌台状态
                            Long tableStatus;

                            //根据档案编号查询商户基本参数信息
                            B_BasicParamInfoEntity basicParamInfoEntity = basicParamInfoService.getBasicParamInfoByArchiveID(paymentDTO.getArchiveID());

                            //是否启用桌台待清，为true则结账后桌台状态为脏台，反之则为空台
                            if (null != basicParamInfoEntity && null != basicParamInfoEntity.getEnablePending()) {
                                tableStatus = MerchantManageEnum.TableStatus.DIRTYTABLE.getValue();
                            } else {
                                tableStatus = MerchantManageEnum.TableStatus.EMPTYTABLE.getValue();
                            }

                            //桌台状态
                            dinningTableInfo.setTableStatus(tableStatus);
                            //拼桌数量
                            dinningTableInfo.setShareNumber(0);
                            //拼桌编码
                            dinningTableInfo.setShareCode(null);
                            //合台数量
                            dinningTableInfo.setCombineNumber(0);
                            //合台编码
                            dinningTableInfo.setCombineName(null);
                            //合台编码
                            dinningTableInfo.setCombineCode(null);
                            //拆台编码
                            dinningTableInfo.setSplitCode(null);

                            //修改桌台信息的状态
                            b_DinningTableInfoDao.update(dinningTableInfo);

                            //餐次ID为空，说明该桌子不在餐次范围，不用修改餐次桌台信息
                            if (null != dinningTableUseInfo.getMealsID()) {
                                B_MealTableMappingEntity mealTableSetParamsEntity = new B_MealTableMappingEntity();

                                //区域ID
                                mealTableSetParamsEntity.setAreaID(dinningTableInfo.getAreaID());
                                //餐次ID
                                mealTableSetParamsEntity.setMealsID(dinningTableUseInfo.getMealsID());
                                //桌台ID
                                mealTableSetParamsEntity.setTableID(dinningTableUseInfo.getTableID());
                                //档案ID
                                mealTableSetParamsEntity.setArchiveID(paymentDTO.getArchiveID());

                                //查询餐次桌台信息
                                B_MealTableMappingEntity mealTableMappingEntity = b_MealTableMappingDao.GetB_MealTableMappingEntityByTableIDAndGtDate(mealTableSetParamsEntity);

                                if (null != mealTableMappingEntity) {
                                    //桌台状态
                                    mealTableMappingEntity.setTableStatus(tableStatus);
                                    //是否预订
                                    mealTableMappingEntity.setIsBooking(false);
                                    //是否拼桌
                                    mealTableMappingEntity.setIsSharing(false);
                                    //拼桌数量
                                    mealTableMappingEntity.setShareNumber(0);
                                    //拼桌编码
                                    mealTableMappingEntity.setShareCode(null);
                                    //是否合台
                                    mealTableMappingEntity.setIsCombine(false);
                                    //合台编码
                                    mealTableMappingEntity.setCombineCode(null);
                                    //合台名称
                                    mealTableMappingEntity.setCombineName(null);
                                    //合台数量
                                    mealTableMappingEntity.setCombineNumber(0);
                                    //是否拆台
                                    mealTableMappingEntity.setIsSplit(false);
                                    //拆台数量
                                    mealTableMappingEntity.setSplitNumber(0);
                                    //拆台编码
                                    mealTableMappingEntity.setSplitCode(null);
                                    //关联桌台
                                    mealTableMappingEntity.setRelationTable(null);
                                    //消费人数
                                    mealTableMappingEntity.setCustomerNumber(0);

                                    //修改在用餐次桌台信息
                                    b_MealTableMappingDao.update(mealTableMappingEntity);

                                    //修改某个餐次的桌台信息
                                    b_MealTableMappingDao.UpdateB_MealTableMappingEntityByStatusAndNotEqSegmentID(mealTableMappingEntity);
                                }
                            }

                            //结束时间
                            dinningTableUseInfo.setEndTime(LocalDateTime.now());
                            //收银员
                            dinningTableUseInfo.setCashierLoginID(paymentDTO.getOperatorID());
                            //消费金额
                            dinningTableUseInfo.setTotalAmount(subOrderInfoEntity.getTotalAmount());
                            //折扣金额
                            dinningTableUseInfo.setDiscountAmount(subOrderInfoEntity.getDiscountAmount());
                            //实际金额
                            dinningTableUseInfo.setActualAmount(subOrderInfoEntity.getActualAmount());

                            if (null != dinningTableUseInfo.getStartTime()) {
                                Long minute = DateUtils.getMinutesBetween(dinningTableUseInfo.getStartTime(), LocalDateTime.now());

                                //使用时长
                                dinningTableUseInfo.setUseTime(minute.intValue());
                            }

                            //修改桌台使用信息
                            b_DinningTableUseInfoDao.update(dinningTableUseInfo);
                        }
                    } else {
                        throw new BizException(CodeMsgConstants.TABLE_INFO_NOT_EXIST,CodeMsgConstants.TABLE_INFO_NOT_EXIST_MSG);
                    }
                } else {
                    throw new BizException(CodeMsgConstants.TABLEUSE_INFO_NOT_EXIST,CodeMsgConstants.TABLEUSE_INFO_NOT_EXIST_MSG);
                }
            } else {
                throw new BizException(CodeMsgConstants.PAYMENT_SUBORDERID_NOT_EXIST,CodeMsgConstants.PAYMENT_SUBORDERID_NOT_EXIST_MSG);
            }
        }

    }

}
