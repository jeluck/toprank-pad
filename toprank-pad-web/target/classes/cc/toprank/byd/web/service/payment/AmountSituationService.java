package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.dao.O_BookingInfoDao;
import cc.toprank.byd.dao.O_OrderDiscountMappingDao;
import cc.toprank.byd.entity.O_BookingInfoEntity;
import cc.toprank.byd.entity.O_OrderDiscountMappingEntity;
import cc.toprank.byd.entity.PayOrderDTO;
import cc.toprank.byd.enums.FinancialManageEnum;
import cc.toprank.byd.enums.ProductManageEnum;
import cc.toprank.byd.web.vo.paymentvo.AmountSituationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 金额情况
 * Created by HuangCY on 2017-4-27.
 */
@Service("amountSituationService")
public class AmountSituationService {

    //商家收费信息
    @Autowired
    private MerchantFeeInfoService merchantFeeInfoService;
    //订单折扣信息
    @Autowired
    private O_OrderDiscountMappingDao o_OrderDiscountMappingDao;
    //商家基本参数信息
    @Autowired
    private BasicParamInfoService basicParamInfoService;
    //支付
    @Autowired
    private PaymentService paymentService;
    //预订信息
    @Autowired
    private O_BookingInfoDao o_BookingInfoDao;

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 订单金额情况
     * @time 2017-4-27 11:58
     */
    public AmountSituationVO amountSituation(List<Long> subOrderIDList , Long archiveID , Long loginID) throws Exception {
        //商品总额
        BigDecimal totalAmount = new BigDecimal(0);
        //折扣总额
        BigDecimal discountAmount = new BigDecimal(0);
        //已付金额
        BigDecimal paidAmount = new BigDecimal(0);
        //赠送金额
        BigDecimal giveProductAmount = new BigDecimal(0);
        //减免金额
        BigDecimal reductionAmount = new BigDecimal(0);
        //减免人
        String reductionPerson = "";
        //抹零金额
        BigDecimal droptailAmount = new BigDecimal(0);
        //订金
        BigDecimal bookingAmount = new BigDecimal(0);
        //服务费
        BigDecimal serviceFee ;
        //待收金额
        BigDecimal waitCollectAmount;
        //应收金额
        BigDecimal payableAmount;
        //是否免服务费
        boolean amountIsFee = false;
        //是否已经手动打折
        boolean isHasDiscount = false;
        //手动打折信息
        String discountMsg = null;

        //获取支付的订单号
        PayOrderDTO payOrderDTO = paymentService.getOrderID(subOrderIDList , loginID);

        //设置商品总额
        totalAmount = payOrderDTO.getTotalAmount();

        //全单付款才有预订金额
        if(payOrderDTO.getBusinessType().equals(FinancialManageEnum.FundChangeBusinessType.ORDER.getValue())){
            O_BookingInfoEntity bookingInfoEntity = o_BookingInfoDao.queryByOrderID(payOrderDTO.getOrderID());

            if(null != bookingInfoEntity && null != bookingInfoEntity.getBookingAmount()){
                bookingAmount = bookingInfoEntity.getBookingAmount();
            }
        }

        //获取订单折扣信息
        List<O_OrderDiscountMappingEntity> discountList = o_OrderDiscountMappingDao.queryDiscountInfoByOrderID(payOrderDTO);

        if (!discountList.isEmpty() && discountList.size() > 0) {
            for (int j = 0; j < discountList.size(); j++) {
                O_OrderDiscountMappingEntity discountMappingEntity = discountList.get(j);

                //折扣类别
                Long discountType = discountMappingEntity.getDiscountType();
                //是否人工处理
                Boolean isManualProcess = discountMappingEntity.getIsManualProcess();
                if (isManualProcess != null && isManualProcess == true){
                    isHasDiscount = true;
                    discountMsg = discountMappingEntity.getMemo();
                }

                //累加权限折金额
                if (discountType.equals(ProductManageEnum.DiscountType.PERMISSIONDISCOUNT.getValue())){
                    discountAmount = discountAmount.add(discountMappingEntity.getDiscountAmount());
                    //累加全单折金额
                }else if (discountType.equals(ProductManageEnum.DiscountType.FULLDISCOUNT.getValue())){
                    discountAmount = discountAmount.add(discountMappingEntity.getDiscountAmount());
                }
//                if (discountType.equals(ProductManageEnum.DiscountType.DISCOUNT.getValue())) {
//                    discountAmount = discountAmount.add(discountMappingEntity.getDiscountAmount());
//                    //累加免单金额
//                }
                else if (discountType.equals(ProductManageEnum.DiscountType.FREESINGLE.getValue())) {
                    discountAmount = discountAmount.add(discountMappingEntity.getDiscountAmount());
                    //累加减免金额
                } else if (discountType.equals(ProductManageEnum.DiscountType.STRAIGHTCUT.getValue())) {
                    reductionAmount = reductionAmount.add(discountMappingEntity.getDiscountAmount());
                    //累加赠送金额
                } else if (discountType.equals(ProductManageEnum.DiscountType.GIVE.getValue())) {
                    giveProductAmount = giveProductAmount.add(discountMappingEntity.getDiscountAmount());
                    //累加免服务费金额
                } else if (discountType.equals(ProductManageEnum.DiscountType.FREE_SERVICE.getValue())) {
                    amountIsFee = true;
                    //累加抹零金额
                }else if (discountType.equals(ProductManageEnum.DiscountType.ZERO.getValue())) {
                    //抹零
                    droptailAmount = droptailAmount.add(discountMappingEntity.getDiscountAmount());
                }

                //累加抹零金额
                if (droptailAmount.compareTo(BigDecimal.ZERO) == 0) {
                    //抹零
                    droptailAmount = basicParamInfoService.droptailMethod(archiveID, loginID,
                            subOrderIDList , totalAmount);
                }
            }
        } else {
            //抹零
            droptailAmount = basicParamInfoService.droptailMethod(archiveID, loginID,
                    subOrderIDList , totalAmount);
        }

        //获取服务费
        serviceFee = merchantFeeInfoService.getMerchantFee(archiveID , subOrderIDList);

        //应收金额 = 消费金额　－　赠送　－ 减免  - 抹零 -　折扣 - 订金　＋　服务费
        if (!amountIsFee) {
            payableAmount = totalAmount.subtract(giveProductAmount).subtract(reductionAmount).subtract(droptailAmount).subtract(discountAmount).subtract(bookingAmount).add(serviceFee);
        }else {
            payableAmount = totalAmount.subtract(giveProductAmount).subtract(reductionAmount).subtract(droptailAmount).subtract(discountAmount).subtract(bookingAmount);
        }

        //待收金额 = 应收金额 - 已收金额
        waitCollectAmount = payableAmount.subtract(paidAmount);

        AmountSituationVO amountSituationVO = new AmountSituationVO();

        amountSituationVO.setTotalAmount(totalAmount);
        amountSituationVO.setDiscountAmount(discountAmount);
        amountSituationVO.setGiveProductAmount(giveProductAmount);
        amountSituationVO.setReductionAmount(reductionAmount);
        amountSituationVO.setReductionPerson(reductionPerson);
        amountSituationVO.setDroptailAmount(droptailAmount);
        amountSituationVO.setBookingAmount(bookingAmount);
        amountSituationVO.setAmountIsFee(amountIsFee);
        amountSituationVO.setOrderID(payOrderDTO.getOrderID());
        amountSituationVO.setBusinessType(payOrderDTO.getBusinessType());
        amountSituationVO.setHasDiscount(isHasDiscount);
        amountSituationVO.setDiscountMsg(discountMsg);

        if (null != payableAmount && payableAmount.compareTo(BigDecimal.ZERO) == 1) {
            amountSituationVO.setPayableAmount(payableAmount);
        }
        if (null != waitCollectAmount && waitCollectAmount.compareTo(BigDecimal.ZERO) == 1) {
            amountSituationVO.setWaitCollectAmount(waitCollectAmount);
        }
        if (null != serviceFee && serviceFee.compareTo(BigDecimal.ZERO) == 1) {
            amountSituationVO.setServiceFee(serviceFee);
        }

        return amountSituationVO;
    }
}
