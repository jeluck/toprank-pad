package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.dao.B_BasicParamInfoDao;
import cc.toprank.byd.dao.O_OrderDiscountMappingDao;
import cc.toprank.byd.entity.B_BasicParamInfoEntity;
import cc.toprank.byd.entity.O_OrderDiscountMappingEntity;
import cc.toprank.byd.entity.PayOrderDTO;
import cc.toprank.byd.enums.FinancialManageEnum;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.ProductManageEnum;
import cc.toprank.byd.util.MaxIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商家基本参数信息
 * Created by HuangCY on 2017-4-27.
 */
@Service("basicParamInfoService")
public class BasicParamInfoService {

    //商户基本参数信息
    @Autowired
    private B_BasicParamInfoDao b_BasicParamInfoDao;
    //订单折扣信息
    @Autowired
    private O_OrderDiscountMappingDao o_OrderDiscountMappingDao;
    //支付
    @Autowired
    private PaymentService paymentService;

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据商家参数配置获取服务费
     * @time 2017-4-28 9:37
     */
    public BigDecimal getServiceFeeByArchiveID(Long archiveID, BigDecimal totalAmount, Integer peopleNum, Integer tableNum) {
        //服务费
        BigDecimal serviceFee = new BigDecimal("0");

        //根据档案编号查询商户基本参数信息
        B_BasicParamInfoEntity basicParamInfo = b_BasicParamInfoDao.queryBasicParamByArchiveID(archiveID);

        //如果商家设置了收取服务费，那么就要获取服务费
        if (null != basicParamInfo && null != basicParamInfo.getIsServiceFee() && basicParamInfo.getIsServiceFee()) {

            //按单固定金额
            if (basicParamInfo.getServiceFeeType().equals(MerchantManageEnum.ServiceFeeType.FIXAMOUNT.getValue())) {
                if (basicParamInfo.getServiceFee() > 0) {
                    serviceFee = BigDecimal.valueOf(basicParamInfo.getServiceFee());
                } else {
                    serviceFee = new BigDecimal("0");
                }
            }
            //按单固定比例
            else if (basicParamInfo.getServiceFeeType().equals(MerchantManageEnum.ServiceFeeType.FIXRATE.getValue())) {
                if (basicParamInfo.getServiceFee() > 0) {
                    serviceFee = totalAmount.multiply(BigDecimal.valueOf(basicParamInfo.getServiceFee() / 100));
                } else {
                    serviceFee = new BigDecimal("0");
                }
            }
            //按人固定金额
            else if (basicParamInfo.getServiceFeeType().equals(MerchantManageEnum.ServiceFeeType.FIXAMOUNT.getValue())) {
                if (basicParamInfo.getServiceFee() > 0) {
                    serviceFee = BigDecimal.valueOf(peopleNum * basicParamInfo.getServiceFee());
                } else {
                    serviceFee = new BigDecimal("0");
                }
            }
            //按桌固定金额
            else if (basicParamInfo.getServiceFeeType().equals(MerchantManageEnum.ServiceFeeType.FIXAMOUNT.getValue())) {
                if (basicParamInfo.getServiceFee() > 0) {
                    serviceFee = BigDecimal.valueOf(tableNum * basicParamInfo.getServiceFee());
                } else {
                    serviceFee = new BigDecimal("0");
                }
            }
            //按桌固定比例
            else if (basicParamInfo.getServiceFeeType().equals(MerchantManageEnum.ServiceFeeType.FIXRATE.getValue())) {
                if (basicParamInfo.getServiceFee() > 0) {
                    serviceFee = totalAmount.multiply(BigDecimal.valueOf(basicParamInfo.getServiceFee()));
                } else {
                    serviceFee = new BigDecimal("0");
                }
            } else {
                serviceFee = new BigDecimal("0");
            }
        }

        return serviceFee;
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 抹零
     * @time 2017-4-10 15:15
     */
    @Transactional
    public BigDecimal droptailMethod(Long archiveID , Long loginID , List<Long> subOrderIDList , BigDecimal amount) throws Exception {
        Long orderID = null;

        Long subOrderID = null;

        PayOrderDTO payOrderDTO = paymentService.getOrderID(subOrderIDList, loginID);

        //获取商户的基本参数信息
        B_BasicParamInfoEntity basicParamInfoEntity = b_BasicParamInfoDao.queryBasicParamByArchiveID(archiveID);

        //整型金额
        Integer intOfAmount;

        //抹零后的金额
        BigDecimal resultAmount = new BigDecimal(0);

        //抹零扣除的金额
        BigDecimal discountAmount = new BigDecimal(0);

        //商家是否设置了抹零方式
        if (null != basicParamInfoEntity && null != basicParamInfoEntity.getDroptailMethod() && amount.compareTo(BigDecimal.ZERO) == 1) {
            Long droptailMethod = basicParamInfoEntity.getDroptailMethod();

             if (droptailMethod.equals(MerchantManageEnum.DroptailMethod.REMOVEYUAN.getValue())) {   //舍位到元
                //先把小数位去掉
                intOfAmount = amount.intValue();
                resultAmount = BigDecimal.valueOf(intOfAmount);
            } else if (droptailMethod.equals(MerchantManageEnum.DroptailMethod.REMOVETENTH.getValue())) {  //舍位到10元
                //先把小数位去掉
                intOfAmount = amount.intValue();
                //把个位抹零
                resultAmount = BigDecimal.valueOf(intOfAmount - intOfAmount % 10);
            } else if (droptailMethod.equals(MerchantManageEnum.DroptailMethod.REMOVEHUNDRED.getValue())) {  //舍位到100元
                //消费金额大于100才适用
                if(amount.compareTo(BigDecimal.valueOf(100)) == 1){
                    //先把小数位去掉
                    intOfAmount = amount.intValue();
                    //把十位抹零
                    resultAmount = BigDecimal.valueOf(intOfAmount - intOfAmount % 100);
                }
            } else if (droptailMethod.equals(MerchantManageEnum.DroptailMethod.ROUNDINGJIAO.getValue())) {   //四舍五入到角
                //保留一位小数
                BigDecimal bg = amount.setScale(1, BigDecimal.ROUND_DOWN);

                resultAmount = bg;
            } else if (droptailMethod.equals(MerchantManageEnum.DroptailMethod.ROUNDINGYUAN.getValue())) {   //四舍五入到元
                //小数位第一位四舍五入
                BigDecimal bg = amount.setScale(0, BigDecimal.ROUND_HALF_UP);

                resultAmount = bg;
            } else if (droptailMethod.equals(MerchantManageEnum.DroptailMethod.UPJIAO.getValue())) {   //进位到角
                //小数位第二位进位
                BigDecimal bg = amount.setScale(1 , RoundingMode.UP);

                resultAmount = bg;
            } else if (droptailMethod.equals(MerchantManageEnum.DroptailMethod.UPYUAN.getValue())) {   //进位到元
                //小数位第一位进位
                BigDecimal bg = amount.setScale(0 , RoundingMode.UP);

                resultAmount = bg;
            } else if (droptailMethod.equals(MerchantManageEnum.DroptailMethod.UPTENTH.getValue())) {   //进位到十元
                //先把小数位去掉
                intOfAmount = amount.intValue();

                amount = BigDecimal.valueOf((double)intOfAmount / 10);

                //小数位第一位进位
                BigDecimal bg = amount.setScale(0 , RoundingMode.UP);

                bg = bg.multiply(BigDecimal.TEN);

                resultAmount = bg;
            }

            //如果抹零了就要新增订单折扣信息
            if (resultAmount.compareTo(BigDecimal.ZERO) == 1) {
                //抹零扣除的金额 = 订单金额 - 抹零后的金额
                discountAmount = amount.subtract(resultAmount);
                Map<String, Object> map = new HashMap<>();
                map.put("subOrderID", subOrderID);
                map.put("discountType", ProductManageEnum.DiscountType.ZERO.getValue());
                List<O_OrderDiscountMappingEntity> o_orderDiscountMappingEntities = o_OrderDiscountMappingDao.queryDiscountInfoBySubOrderIDAndDiscountType(map);
                //如果在O_OrderDiscountMapping已经存在该抹零记录就不要再插入，存在则更新
                if(o_orderDiscountMappingEntities == null || o_orderDiscountMappingEntities.size() < 1) {
                    O_OrderDiscountMappingEntity orderDiscountMapping = new O_OrderDiscountMappingEntity();

                    orderDiscountMapping.setMappingID(MaxIDUtils.getID(O_OrderDiscountMappingEntity.class));
                    orderDiscountMapping.setCreateTime(LocalDateTime.now());
                    orderDiscountMapping.setLoginID(loginID);
                    if(payOrderDTO.getBusinessType().equals(FinancialManageEnum.FundChangeBusinessType.ORDER.getValue())){
                        orderDiscountMapping.setMappingOrderID(payOrderDTO.getOrderID());
                    }
                    if(payOrderDTO.getBusinessType().equals(FinancialManageEnum.FundChangeBusinessType.SUBORDERINFO.getValue())){
                        orderDiscountMapping.setOrderID(payOrderDTO.getOrderID());
                    }
                    orderDiscountMapping.setCreatorID(loginID);
                    orderDiscountMapping.setIsRatio(false);
                    orderDiscountMapping.setDiscountType(ProductManageEnum.DiscountType.ZERO.getValue());
                    orderDiscountMapping.setDiscountAmount(discountAmount);
                    orderDiscountMapping.setIsManualProcess(false);

                    //新增订单折扣信息
                    o_OrderDiscountMappingDao.insertSelective(orderDiscountMapping);
                }else{
                    O_OrderDiscountMappingEntity orderDiscountMapping = new O_OrderDiscountMappingEntity();

                    if(payOrderDTO.getBusinessType().equals(FinancialManageEnum.FundChangeBusinessType.ORDER.getValue())){
                        orderDiscountMapping.setMappingOrderID(payOrderDTO.getOrderID());
                    }
                    if(payOrderDTO.getBusinessType().equals(FinancialManageEnum.FundChangeBusinessType.SUBORDERINFO.getValue())){
                        orderDiscountMapping.setOrderID(payOrderDTO.getOrderID());
                    }

                    orderDiscountMapping.setDiscountAmount(discountAmount);

                    //根据支付订单ID改变订单折扣信息的金额
                    o_OrderDiscountMappingDao.updateDiscountAmountByOrderID(orderDiscountMapping);
                }
            }
        }

        return discountAmount;
    }

//    /**
//     * @author chenkangyi
//     * @version 2.0.0
//     * @description
//     * @time 2017-6-9 15:49
//     */
//    public BigDecimal getDroptailAmount(Long archiveID, BigDecimal amount){
//        //获取商户的基本参数信息
//        B_BasicParamInfoEntity basicParamInfoEntity = b_BasicParamInfoDao.queryBasicParamByArchiveID(archiveID);
//        //整型金额
//        Integer intOfAmount;
//
//        //抹零后的金额
//        BigDecimal resultAmount = new BigDecimal(0);
//
//        //抹零扣除的金额
//        BigDecimal discountAmount = new BigDecimal(0);;
//        //商家是否设置了抹零方式
//        if (null != basicParamInfoEntity && null != basicParamInfoEntity.getDroptailMethod() && amount.compareTo(BigDecimal.ZERO) == 1) {
//            long droptailMethod = basicParamInfoEntity.getDroptailMethod();
//            if (droptailMethod == MerchantManageEnum.DroptailMethod.ROUNDINGJIAO.getValue()) {   //舍位到角
//                //保留一位小数
//                BigDecimal bg = amount.setScale(1, BigDecimal.ROUND_DOWN);
//
//                resultAmount = bg;
//            } else if (droptailMethod == MerchantManageEnum.DroptailMethod.REMOVEYUAN.getValue()) {   //舍位到元
//                //先把小数位去掉
//                intOfAmount = amount.intValue();
//                resultAmount = BigDecimal.valueOf(intOfAmount);
//            } else if (droptailMethod == MerchantManageEnum.DroptailMethod.REMOVETENTH.getValue()) {  //舍位到10元
//                //先把小数位去掉
//                intOfAmount = amount.intValue();
//                //把个位抹零
//                resultAmount = BigDecimal.valueOf(intOfAmount - intOfAmount % 10);
//            } else if (droptailMethod == MerchantManageEnum.DroptailMethod.REMOVEHUNDRED.getValue()) {  //舍位到100元
//                //消费金额大于100才适用
//                if(amount.compareTo(BigDecimal.valueOf(100)) == 1){
//                    //先把小数位去掉
//                    intOfAmount = amount.intValue();
//                    //把十位抹零
//                    resultAmount = BigDecimal.valueOf(intOfAmount - intOfAmount % 100);
//                }
//            } else if (droptailMethod == MerchantManageEnum.DroptailMethod.UPJIAO.getValue()) {   //四舍五入到角
//                //保留一位小数
//                BigDecimal bg = amount.setScale(1, BigDecimal.ROUND_DOWN);
//
//                resultAmount = bg;
//            } else if (droptailMethod == 1) {   //四舍五入到元
//                //小数位第一位四舍五入
//                BigDecimal bg = amount.setScale(0, BigDecimal.ROUND_HALF_UP);
//
//                resultAmount = bg;
//            } else if (droptailMethod == 1) {   //进位到角
//                //小数位第二位进位
//                BigDecimal bg = amount.setScale(1 , RoundingMode.UP);
//
//                resultAmount = bg;
//            } else if (droptailMethod == 1) {   //进位到元
//                //小数位第一位进位
//                BigDecimal bg = amount.setScale(0 , RoundingMode.UP);
//
//                resultAmount = bg;
//            } else if (droptailMethod == 1) {   //进位到十元
//                //先把小数位去掉
//                intOfAmount = amount.intValue();
//
//                amount = BigDecimal.valueOf((double)intOfAmount / 10);
//
//                //小数位第一位进位
//                BigDecimal bg = amount.setScale(0 , RoundingMode.UP);
//
//                bg = bg.multiply(BigDecimal.TEN);
//
//                resultAmount = bg;
//            }
//            //抹零扣除的金额 = 订单金额 - 抹零后的金额
//            discountAmount = amount.subtract(resultAmount);
//        }
//        return discountAmount;
//    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据档案编号查询商户基本参数信息
     * @time 2017-5-26 13:57
     */
    public B_BasicParamInfoEntity getBasicParamInfoByArchiveID(Long archiveID) {
        return b_BasicParamInfoDao.queryBasicParamByArchiveID(archiveID);
    }
    /**
     * @author Zhaolingchen
     * @version 1.0.0
     * @description 计算留位费
     * @time 2017-5-26 13:57
     */
    public Integer getReservationFee(Long archiveID, Integer peopleNum, Integer tableNum) {
        int reservationFee = 0;
        B_BasicParamInfoEntity basicParamInfoEntity = b_BasicParamInfoDao.queryBasicParamByArchiveID(archiveID);

        if(basicParamInfoEntity == null){
            return reservationFee;
        }

        if (MerchantManageEnum.ReservationType.BYPERSON.getValue() == basicParamInfoEntity.getReservationType()) {
            if(peopleNum != null && peopleNum > 0){
                reservationFee = basicParamInfoEntity.getReservationFee() * peopleNum;
            }
        } else if (MerchantManageEnum.ReservationType.BYTABLE.getValue() == basicParamInfoEntity.getReservationType()) {
            if(tableNum != null && tableNum > 0){
                reservationFee = basicParamInfoEntity.getReservationFee() * tableNum;
            }
        } else if (MerchantManageEnum.ReservationType.BYORDER.getValue() == basicParamInfoEntity.getReservationType()) {
            reservationFee = basicParamInfoEntity.getReservationFee();
        }
        return reservationFee;
    }

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("199.2");



        //先把小数位去掉
        int a  = amount.intValue();
        System.out.print("看这里a："+a);
        System.out.print("看这里a/10："+a % 100);
        //把个位抹零
        amount = BigDecimal.valueOf(a - a % 100);

        System.out.print("看这里："+amount);
    }
}
