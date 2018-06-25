package cc.toprank.byd.web.service.order;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.CustomerManageEnum;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.enums.ProductManageEnum;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.payment.AmountSituationService;
import cc.toprank.byd.web.service.payment.BasicParamInfoService;
import cc.toprank.byd.web.service.payment.MerchantFeeInfoService;
import cc.toprank.byd.web.vo.paymentvo.AmountSituationVO;
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
 * Created by ChenKY on 2017-5-19.
 */
@Service
public class DiscountServiceBackup {

    @Autowired
    private O_RoleDiscountInfoDao o_roleDiscountInfoDao;

    @Autowired
    private O_OrderDiscountMappingDao o_orderDiscountMappingDao;

    @Autowired
    private O_OrderDetailInfoDao o_orderDetailInfoDao;

    @Autowired
    private O_SubOrderInfoDao o_subOrderInfoDao;

    @Autowired
    private F_MemberCardInfoDao f_memberCardInfoDao;

    @Autowired
    private E_RoleInfoDao e_roleInfoDao;

    @Autowired
    private M_ActivityRuleInfoDao m_activityRuleInfoDao;

    @Autowired
    private M_ActivityDiscountInfoDao m_activityDiscountInfoDao;

    //商家收费信息
    @Autowired
    private MerchantFeeInfoService merchantFeeInfoService;

    @Autowired
    private AmountSituationService amountSituationService;

    @Autowired
    private BasicParamInfoService basicParamInfoService;


    /**
     * 权限折
     * chenkangyi
     * 2017-5-22 13:41
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData authorityDiscount(Map<String, Object> map) throws Exception {
        ResultData resultData = new ResultData();
        Long loginID = (Long) map.get("loginID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        Float discountPercentage = (Float) map.get("discountPercentage");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        //检查折扣输入参数的合法性
        checkDiscountInput(loginID, discountPercentage);
        //BigDecimal totalAmountAll = getTotalAmountAll(subOrderIDList);
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，orgID，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList, (Long)map.get("archiveID"),loginID);
        //已收金额
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        //标志是否能打折
        boolean isCanDiscount = false;
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            //根据subOrderID查询能打折的菜品
            List<O_OrderDetailInfoEntity> allowDiscountOrderDetailInfoList = getAllowDiscountOrderDetailInfo(subOrderID);
            //获取子订单所有能打折的菜品的价格总额
            BigDecimal totalAmountCanDiscount = getSubOrderCanDiscountOrderDetail(allowDiscountOrderDetailInfoList);
            if (allowDiscountOrderDetailInfoList != null && allowDiscountOrderDetailInfoList.size() > 0) {
                Long orderID = o_subOrderInfo.getOrderID();
                if (orderID == null) {
                    throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
                }
                isCanDiscount = true;
                //插入订单权限折扣信息，discountType为795
                insertOrUpdateOrderDiscountMapping(totalAmountCanDiscount, orderID, subOrderID, ProductManageEnum.DiscountType.DISCOUNT.getValue(), true, discountPercentage, null, loginID);
            } else { //订单所有菜品不能打折
                if (i == subOrderIDList.size() - 1 && isCanDiscount == false) {
                    throw new BizException(CodeMsgConstants.SELECT_OREDER_CANNOT_ALLOW_DISCOUNT_CODE, CodeMsgConstants.SELECT_OREDER_CANNOT_ALLOW_DISCOUNT_MSG);
                }
            }
        }
        updateDroptail(map);
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 全单折
     * chenkangyi
     * 2017-5-22 13:41
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData orderDiscount(Map<String, Object> map) throws Exception {
        ResultData resultData = new ResultData();
        Long loginID = (Long) map.get("loginID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        Float discountPercentage = (Float) map.get("discountPercentage");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        //检查折扣输入参数的合法性
        checkDiscountInput(loginID, discountPercentage);
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，orgID，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList, (Long)map.get("archiveID"),loginID);
        //已收金额
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            Long orderID = o_subOrderInfo.getOrderID();
            if (orderID == null) {
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            //子订单商品总额
            BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
            insertOrUpdateOrderDiscountMapping(totalAmount, orderID, subOrderID, ProductManageEnum.DiscountType.DISCOUNT.getValue(), true, discountPercentage, null, loginID);
        }
        updateDroptail(map);
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 会员折
     * chenkangyi
     * 2017-5-24 13:51
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData memberDiscount(Map<String, Object> map) throws Exception {
        ResultData resultData = new ResultData();
        Long loginID = (Long) map.get("loginID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        //memberCodeType为1代表手机号，2代表会员卡号，3代表刷卡
        Integer memberCodeType = (Integer) map.get("memberCodeType");
        String memberCode = (String) map.get("memberCode");
        if (loginID == null || subOrderIDs == null || memberCodeType == null || memberCode == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if (memberCode == "") {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if (memberCodeType > 3 || memberCodeType < 1) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        //根据输入的会员手机或会员卡号或刷卡查询会员信息
        F_MemberCardInfoEntity f_memberCardInfo = f_memberCardInfoDao.selectMemberCardInfoBymemberCode(map);
        if (f_memberCardInfo == null) {
            throw new BizException(CodeMsgConstants.ROLE_IS_NOT_MEMBER_DISCOUNT_CODE, CodeMsgConstants.ROLE_IS_NOT_MEMBER_DISCOUNT_MSG);
        }
        //卡状态
        Long cardStatus = f_memberCardInfo.getCardStatus();
        if (cardStatus == null || cardStatus.longValue() == CustomerManageEnum.CardStatus.UNKNOWN.getValue()) {
            throw new BizException(CodeMsgConstants.CARD_UNABLE_CODE, CodeMsgConstants.CARD_UNABLE_MSG, CustomerManageEnum.CardStatus.UNKNOWN.getName());
        }
        if (cardStatus.longValue() == CustomerManageEnum.CardStatus.DISABLE.getValue()) {
            throw new BizException(CodeMsgConstants.CARD_UNABLE_CODE, CodeMsgConstants.CARD_UNABLE_MSG, CustomerManageEnum.CardStatus.DISABLE.getName());
        }
        if (cardStatus.longValue() == CustomerManageEnum.CardStatus.EXPIRED.getValue()) {
            throw new BizException(CodeMsgConstants.CARD_UNABLE_CODE, CodeMsgConstants.CARD_UNABLE_MSG, CustomerManageEnum.CardStatus.EXPIRED.getName());
        }
        if (cardStatus.longValue() == CustomerManageEnum.CardStatus.FROZEN.getValue()) {
            throw new BizException(CodeMsgConstants.CARD_UNABLE_CODE, CodeMsgConstants.CARD_UNABLE_MSG, CustomerManageEnum.CardStatus.FROZEN.getName());
        }
        if (cardStatus.longValue() == CustomerManageEnum.CardStatus.LOCKING.getValue()) {
            throw new BizException(CodeMsgConstants.CARD_UNABLE_CODE, CodeMsgConstants.CARD_UNABLE_MSG, CustomerManageEnum.CardStatus.LOCKING.getName());
        }
        if (cardStatus.longValue() == CustomerManageEnum.CardStatus.NOTCERTIFIED.getValue()) {
            throw new BizException(CodeMsgConstants.CARD_UNABLE_CODE, CodeMsgConstants.CARD_UNABLE_MSG, CustomerManageEnum.CardStatus.NOTCERTIFIED.getName());
        }
        if (cardStatus.longValue() != CustomerManageEnum.CardStatus.NORMAL.getValue()) {
            throw new BizException(CodeMsgConstants.CARD_UNABLE_CODE, CodeMsgConstants.CARD_UNABLE_MSG, CustomerManageEnum.CardStatus.UNKNOWN.getName());
        }
        Long roleID = f_memberCardInfo.getRoleID();
        if (roleID == null) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        //根据roleID获取用户角色信息
        E_RoleInfoEntity e_roleInfo = e_roleInfoDao.selectByPrimaryKey(roleID);
        if (e_roleInfo == null) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        //根据roleID查询活动规则信息
        Map<String, Object> mapActivityRuleInfo = new HashMap<>();
        mapActivityRuleInfo.put("roleID", roleID);
        mapActivityRuleInfo.put("discountType", ProductManageEnum.DiscountType.MEMBERDISCOUNT.getValue());
        M_ActivityRuleInfoEntity m_activityRuleInfo = m_activityRuleInfoDao.selectByRoleID(mapActivityRuleInfo);
        if (m_activityRuleInfo == null) {
            throw new BizException(CodeMsgConstants.ROLE_IS_NOT_MEMBER_DISCOUNT_CODE, CodeMsgConstants.ROLE_IS_NOT_MEMBER_DISCOUNT_MSG);
        }
        Long ruleID = m_activityRuleInfo.getRuleID();
        if (ruleID == null) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        //根据ruleID查询活动折扣信息
        Map<String, Object> mapActivityDiscountInfo = new HashMap<>();
        mapActivityDiscountInfo.put("ruleID", ruleID);
        mapActivityDiscountInfo.put("discounType", ProductManageEnum.DiscountType.MEMBERDISCOUNT.getValue());
        M_ActivityDiscountInfoEntity m_activityDiscountInfo = m_activityDiscountInfoDao.selectByRuleID(mapActivityDiscountInfo);
        if (m_activityDiscountInfo == null) {
            throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
        }
        //discounType暂时取折扣比率和减免金额
        Long discounType = m_activityDiscountInfo.getDiscounType();
        //折扣比率
        Float discountPercentage = m_activityDiscountInfo.getDiscountPercentage();
        //减免金额
        BigDecimal discountAmount = m_activityDiscountInfo.getDiscountAmount();
        BigDecimal discountAmountSubOrder = new BigDecimal(0);
        if (discountAmount == null) {
            discountAmount = new BigDecimal(0);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        map.put("subOrderIDList", subOrderIDList);
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList, (Long)map.get("archiveID"),loginID);
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        BigDecimal totalAmountAll = getTotalAmountAll(subOrderIDList, paidAmount);
        boolean isCanDiscount = false;
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
            if (totalAmount == null) {
                totalAmount = new BigDecimal(0);
            }
            BigDecimal totalAmountDivide = totalAmount.divide(totalAmountAll);
            //根据subOrderID查询能打折的菜品
            List<O_OrderDetailInfoEntity> allowDiscountOrderDetailInfoList = getAllowDiscountOrderDetailInfo(subOrderID);
            //获取子订单所有能打折的菜品的价格总额
            BigDecimal totalAmountCanDiscount = getSubOrderCanDiscountOrderDetail(allowDiscountOrderDetailInfoList);
            if (allowDiscountOrderDetailInfoList != null && allowDiscountOrderDetailInfoList.size() > 0) {
                Long orderID = o_subOrderInfo.getOrderID();
                if (orderID == null) {
                    throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
                }
                boolean isRatio = false;
                if (discounType == 1L) {  //折扣比率
                    isRatio = true;
                } else if (discounType == 2L) { //减免金额
                    isRatio = false;
                    discountAmountSubOrder = discountAmount.multiply(totalAmountDivide).setScale(2, BigDecimal.ROUND_HALF_UP);
                } else {
                    isRatio = true;
                }
                isCanDiscount = true;
                //插入订单会员折扣信息，discountType为1010
                insertOrUpdateOrderDiscountMapping(totalAmountCanDiscount, orderID, subOrderID, ProductManageEnum.DiscountType.MEMBERDISCOUNT.getValue(), isRatio, discountPercentage, discountAmountSubOrder.toString(), loginID);
            } else { //订单所有菜品不能打折
                if (i == subOrderIDList.size() - 1 && isCanDiscount == false) {
                    throw new BizException(CodeMsgConstants.SELECT_OREDER_CANNOT_ALLOW_DISCOUNT_CODE, CodeMsgConstants.SELECT_OREDER_CANNOT_ALLOW_DISCOUNT_MSG);
                }
            }

        }
        updateDroptail(map);
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 免服务费
     * chenkangyi
     * 2017-6-2 10:50
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData freeServiceCharge(Map<String, Object> map) throws Exception {
        ResultData resultData = new ResultData();
        Long loginID = (Long) map.get("loginID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，orgID，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList, (Long)map.get("archiveID"),loginID);
        //已收金额
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        //获取所有子订单的总金额
        BigDecimal totalAmountAll = getTotalAmountAll(subOrderIDList, paidAmount);
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            //子订单商品总额
            BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
            if (totalAmount == null) {
                totalAmount = new BigDecimal(0);
            }
            //子订单金额占所有子订单总额的比例
            BigDecimal totalAmountDivide = totalAmount.divide(totalAmountAll);
            Long orderID = o_subOrderInfo.getOrderID();
            if (orderID == null) {
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            //就餐人数
            Integer peopleNum = o_subOrderInfo.getPeopleNum();
            //获取商家设置的服务费
//            BigDecimal serviceFee = merchantFeeInfoService.getMerchantFee(Long.valueOf(map.get("archiveID").toString()), totalAmount, 1, peopleNum);
//            if (serviceFee == null) {
//                serviceFee = new BigDecimal(0);
//            }
//            insertOrUpdateOrderDiscountMapping(totalAmount, orderID, subOrderID, ProductManageEnum.DiscountType.FREE_SERVICE.getValue(), false, null, serviceFee.multiply(totalAmountDivide).setScale(2, BigDecimal.ROUND_HALF_UP).toString(), loginID);
        }
        //更新抹零
        updateDroptail(map);
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 收服务费
     * chenkangyi
     * 2017-6-7 15:15
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData serviceCharge(Map<String, Object> map) throws Exception {
        ResultData resultData = new ResultData();
        Long loginID = (Long) map.get("loginID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，orgID，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList, (Long)map.get("archiveID"),loginID);
        //已收金额
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //删除o_orderDiscountMapping的对应记录
            map.put("subOrderID", subOrderID);
            map.put("discountType", ProductManageEnum.DiscountType.FREE_SERVICE.getValue());
            //根据子订单ID和折扣类别查询订单折扣信息
            List<O_OrderDiscountMappingEntity> o_orderDiscountMappingEntities = o_orderDiscountMappingDao.queryDiscountInfoBySubOrderIDAndDiscountType(map);
            if (o_orderDiscountMappingEntities == null || o_orderDiscountMappingEntities.size() == 0 || o_orderDiscountMappingEntities.size() > 1) {
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
        }
        //根据子订单ID和折扣类别删除订单折扣信息
        o_orderDiscountMappingDao.deleteOrderDiscountMappingBySubOrderIDListAndDiscountType(map);
        //更新抹零
        updateDroptail(map);
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 减免
     * chenkangyi
     * 2017-6-2 14:38
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData reduceAmount(Map<String, Object> map) throws Exception {
        ResultData resultData = new ResultData();
        Long loginID = (Long) map.get("loginID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        BigDecimal discountAmount = (BigDecimal) map.get("discountAmount");
        if (discountAmount == null) {
            discountAmount = new BigDecimal(0);
        }
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        //员工可减免金额
        BigDecimal canReduceAmount = employeeCanReduceAmount(map);
        if (canReduceAmount == null) {
            canReduceAmount = new BigDecimal(0);
        }
        if (discountAmount.compareTo(BigDecimal.ZERO) == 0) {
            throw new BizException(CodeMsgConstants.REDUCEAMOUNT_CAN_NOT_IS_ZERO_CODE, CodeMsgConstants.RREDUCEAMOUNT_CAN_NOT_IS_ZERO_MSG);
        }
        if (discountAmount.compareTo(BigDecimal.ZERO) == -1) {
            throw new BizException(CodeMsgConstants.REDUCEAMOUNT_CAN_NOT_LESS_THAN_ZERO_CODE, CodeMsgConstants.REDUCEAMOUNT_CAN_NOT_LESS_THAN_ZERO_MSG);
        }
        //输入减免金额大于可减免金额
        if (discountAmount.compareTo(canReduceAmount) == 1) {
            throw new BizException(CodeMsgConstants.REDUCEAMOUNT_MORE_THAN_LIMIT_CODE, CodeMsgConstants.REDUCEAMOUNT_MORE_THAN_LIMIT_MSG, canReduceAmount);
        }
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，orgID，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList, (Long)map.get("archiveID"),loginID);
        //已收金额
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        //获取所有子订单的总额
        BigDecimal totalAmountAll = getTotalAmountAll(subOrderIDList, paidAmount);
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
            BigDecimal totalAmountDivide = totalAmount.divide(totalAmountAll);
            Long orderID = o_subOrderInfo.getOrderID();
            if (orderID == null) {
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            insertOrUpdateOrderDiscountMapping(totalAmount, orderID, subOrderID, ProductManageEnum.DiscountType.STRAIGHTCUT.getValue(), false, null, discountAmount.multiply(totalAmountDivide).setScale(2, BigDecimal.ROUND_HALF_UP).toString(), loginID);
        }
        //更新角色折扣信息
        //updateO_RoleDiscountInfo(loginID, discountAmount, false);
        updateDroptail(map);
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 免单
     * chenkangyi
     * 2017-6-7 17:38
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData orderFree(Map<String, Object> map) throws Exception {
        ResultData resultData = new ResultData();
        Long loginID = (Long) map.get("loginID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        //员工可减免金额
        BigDecimal canReduceAmount = employeeCanReduceAmount(map);
        if (canReduceAmount == null) {
            canReduceAmount = new BigDecimal(0);
        }
        if (canReduceAmount.compareTo(BigDecimal.ZERO) == 0) {
            throw new BizException(CodeMsgConstants.ROLE_MOREST_REDUCE_AMOUNT_CAN_NOT_BE_ZERO_CODE, CodeMsgConstants.ROLE_MOREST_REDUCE_AMOUNT_CAN_NOT_BE_ZERO_MSG);
        }
        map.put("subOrderIDList", subOrderIDList);
        //获取本单可免单的金额
        BigDecimal orderCanFreeAmount = getOrderCanFreeAmount(map);
        if (canReduceAmount.compareTo(orderCanFreeAmount) == -1) {
            throw new BizException(CodeMsgConstants.ROLE_MOREST_REDUCE_AMOUNT_GREATE_THAN_ZERO_CODE, CodeMsgConstants.ROLE_MOREST_REDUCE_AMOUNT_GREATE_THAN_ZERO_MSG, canReduceAmount.toString());
        }
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList, (Long)map.get("archiveID"),loginID);
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        //获取所有子订单的总额
        BigDecimal totalAmountAll = getTotalAmountAll(subOrderIDList, paidAmount);
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
            BigDecimal totalAmountDivide = totalAmount.divide(totalAmountAll);
            Long orderID = o_subOrderInfo.getOrderID();
            if (orderID == null) {
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            insertOrUpdateOrderDiscountMapping(totalAmount, orderID, subOrderID, ProductManageEnum.DiscountType.FREESINGLE.getValue(), false, null, orderCanFreeAmount.multiply(totalAmountDivide).setScale(2, BigDecimal.ROUND_HALF_UP).toString(), loginID);
        }
        //更新角色折扣信息
        //updateO_RoleDiscountInfo(loginID, orderCanFreeAmount, false);
        updateDroptail(map);
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 员工可减免金额
     * chenkangyi
     * 2017-6-2 17:38
     */
    public BigDecimal employeeCanReduceAmount(Map<String, Object> map) throws Exception {
        Long loginID = (Long) map.get("loginID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        //根据登录ID查询角色折扣信息
        O_RoleDiscountInfoEntity roleDiscountInfo = getRoleDiscountInfo(loginID);
        if (roleDiscountInfo == null) {
            throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
        }
        //最高折扣金额
        BigDecimal highestAmount = roleDiscountInfo.getHighestAmount();
        //最高折扣比率
        Float highestRate = roleDiscountInfo.getHighestRate();
        //BigDecimal getAmountOrRate = new BigDecimal(0);  //获取最高折扣金额和最高折扣比例算出来的金额的最小值
        if (highestRate == null) {
            highestRate = 0f;
        }
        if (highestAmount == null) {
            highestAmount = new BigDecimal(0);
        }
        map.put("subOrderIDList", subOrderIDList);
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList, (Long)map.get("archiveID"),loginID);
        //商品总额
        BigDecimal totalAmount = amountSituationVO.getTotalAmount();
        if (totalAmount == null) {
            totalAmount = new BigDecimal(0);
        }
        //查询应收金额
        BigDecimal payableAmount = amountSituationVO.getPayableAmount();
        if (payableAmount == null) {
            payableAmount = new BigDecimal(0);
        }
        //折扣总额
//        BigDecimal discountAmount = amountSituationVO.getDiscountAmount();
//        if (discountAmount == null) {
//            discountAmount = new BigDecimal(0);
//        }
        //已减免金额
        BigDecimal discountAmount = getHasReduceAmount(map,subOrderIDList);
        //抹零金额
        BigDecimal droptailAmount = amountSituationVO.getDroptailAmount();
        if (droptailAmount == null) {
            droptailAmount = new BigDecimal(0);
        }
        //最高折扣比率算出来的金额
        //BigDecimal highestRateAmount = totalAmount.multiply(BigDecimal.valueOf(highestRate)).setScale(2, BigDecimal.ROUND_HALF_UP);
//        if(highestRateAmount.compareTo(highestAmount) == -1){
//            getAmountOrRate = highestRateAmount;
//        }else {
//            getAmountOrRate = highestAmount;
//        }
        //计算应收金额+抹零 +本单已减免金额
        BigDecimal amountSum = payableAmount.add(droptailAmount).add(discountAmount);
        int compareB = highestAmount.compareTo(amountSum);
        if (compareB == -1) {
            return highestAmount;
        }
        return amountSum;
    }

    /**
     * @author chenkangyi
     * @version 2.0.0
     * @description 取消折扣
     * @time 2017-6-8 10:41
     */
    public ResultData cancleDiscount(Map<String, Object> map) {
        ResultData resultData = new ResultData();
        Long loginID = (Long) map.get("loginID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        //discountType 1代表权限折，2代表全单折，3会员折，4代表减免，5代表免单
        Long discountType = (Long) map.get("discountType");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if (discountType == null || discountType > 6 || discountType < 1) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        map.put("subOrderIDList", subOrderIDList);
        switch (discountType.intValue()) {
            case 1:
            case 2:
                map.put("discountType", ProductManageEnum.DiscountType.DISCOUNT.getValue());
                break;
            case 3:
                map.put("discountType", ProductManageEnum.DiscountType.MEMBERDISCOUNT.getValue());
                break;
            case 4:
                map.put("discountType", ProductManageEnum.DiscountType.STRAIGHTCUT.getValue());
                break;
            case 5:
                map.put("discountType", ProductManageEnum.DiscountType.FREESINGLE.getValue());
                break;
        }
        //根据子订单ID和折扣类别查询订单折扣信息
        List<O_OrderDiscountMappingEntity> o_orderDiscountMappingList = o_orderDiscountMappingDao.selectOrderDiscountMappingBySubOrderIDListAndDiscountType(map);
        if (o_orderDiscountMappingList == null || o_orderDiscountMappingList.size() == 0) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        BigDecimal changeAmount = BigDecimal.ZERO;
        for (O_OrderDiscountMappingEntity o_orderDiscountMappingEntity : o_orderDiscountMappingList) {
            if (o_orderDiscountMappingEntity == null) {
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            BigDecimal discountAmount = o_orderDiscountMappingEntity.getDiscountAmount();
            if (discountAmount == null) {
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            changeAmount = changeAmount.add(discountAmount);
        }
        //根据子订单ID列表和折扣类别删除订单折扣信息
        o_orderDiscountMappingDao.deleteOrderDiscountMappingBySubOrderIDListAndDiscountType(map);
        //更新角色折扣信息
        //updateO_RoleDiscountInfo(loginID, changeAmount, true);
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 更新所有折扣信息
     * chenkangyi
     * 2017-6-13 15:41
     */
    public void updateDiscountInfo(Map<String, Object> map) throws Exception{
        Long loginID = (Long) map.get("loginID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            O_SubOrderInfoEntity o_subOrderInfo = getSubOrderInfo(subOrderID);
            if (o_subOrderInfo == null){
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
            }
            BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
            Integer peopleNum = o_subOrderInfo.getPeopleNum();
            //更新服务费
            updateFreeService(map, subOrderID, o_subOrderInfo);
            //更新全单折
            updateOrderDiscount(map, subOrderID, o_subOrderInfo);
            //更新权限折

            //更新减免

            //更新免单

            //更新会员折



        }
    }
    /**
     * 更新全单折
     * chenkangyi
     * 2017-6-13 15:41
     */
    private void updateOrderDiscount(Map<String, Object> map, Long subOrderID, O_SubOrderInfoEntity o_subOrderInfo){
        BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
        map.put("subOrderID", subOrderID);
        map.put("discountType", ProductManageEnum.DiscountType.DISCOUNT.getValue());
        //根据子订单ID和折扣类别查询订单折扣信息
        List<O_OrderDiscountMappingEntity> o_orderDiscountMappingEntities = o_orderDiscountMappingDao.queryDiscountInfoBySubOrderIDAndDiscountType(map);
        if (o_orderDiscountMappingEntities != null && o_orderDiscountMappingEntities.size() == 1) {
            O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingEntities.get(0);
            BigDecimal discountAmount = o_orderDiscountMappingEntity.getDiscountAmount();
            if (discountAmount == null){
                discountAmount = BigDecimal.ZERO;
            }
            Float discountPercentage = o_orderDiscountMappingEntity.getDiscountPercentage();
            if (discountPercentage == null){
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            BigDecimal discountAmountNew = totalAmount.subtract(totalAmount.multiply(new BigDecimal(discountPercentage / 10)).setScale(2, BigDecimal.ROUND_HALF_UP));
            if (discountAmount.compareTo(discountAmountNew) != 0){
                o_orderDiscountMappingEntity.setDiscountAmount(discountAmountNew);
                o_orderDiscountMappingDao.updateByPrimaryKeySelective(o_orderDiscountMappingEntity);
            }
        }
    }

    /**
     * 更新免服务费
     * chenkangyi
     * 2017-6-13 15:41
     */
    private void updateFreeService(Map<String, Object> map, Long subOrderID, O_SubOrderInfoEntity o_subOrderInfo) throws Exception{
        BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
        Integer peopleNum = o_subOrderInfo.getPeopleNum();
        map.put("subOrderID", subOrderID);
        map.put("discountType", ProductManageEnum.DiscountType.FREE_SERVICE.getValue());
        //根据子订单ID和折扣类别查询订单折扣信息
        List<O_OrderDiscountMappingEntity> o_orderDiscountMappingEntities = o_orderDiscountMappingDao.queryDiscountInfoBySubOrderIDAndDiscountType(map);
        if (o_orderDiscountMappingEntities != null && o_orderDiscountMappingEntities.size() == 1) {
            O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingEntities.get(0);
            BigDecimal discountAmount = o_orderDiscountMappingEntity.getDiscountAmount();
            if (discountAmount == null){
                discountAmount = BigDecimal.ZERO;
            }
            //获取商家设置的服务费
//            BigDecimal serviceFee = merchantFeeInfoService.getMerchantFee(Long.valueOf(map.get("archiveID").toString()), totalAmount, 1, peopleNum);
//            if (discountAmount.compareTo(serviceFee) != 0){
//                o_orderDiscountMappingEntity.setDiscountAmount(serviceFee);
//                o_orderDiscountMappingDao.updateByPrimaryKeySelective(o_orderDiscountMappingEntity);
//            }
        }
    }

    /**
     * 获取已减免金额
     * chenkangyi
     * 2017-6-13 17:21
     */
    private BigDecimal getHasReduceAmount(Map<String, Object> map, List<Long> subOrderIDList){
        BigDecimal discountAmount = BigDecimal.ZERO;
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            map.put("subOrderID", subOrderID);
            map.put("discountType", ProductManageEnum.DiscountType.STRAIGHTCUT.getValue());
            //根据子订单ID和折扣类别查询订单折扣信息
            List<O_OrderDiscountMappingEntity> o_orderDiscountMappingEntities = o_orderDiscountMappingDao.queryDiscountInfoBySubOrderIDAndDiscountType(map);
            if (o_orderDiscountMappingEntities != null && o_orderDiscountMappingEntities.size() == 1) {
                O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingEntities.get(0);
                discountAmount = o_orderDiscountMappingEntity.getDiscountAmount();
            } else {
                map.put("discountType", ProductManageEnum.DiscountType.FREESINGLE.getValue());
                //根据子订单ID和折扣类别查询订单折扣信息
                List<O_OrderDiscountMappingEntity> o_orderDiscountMappingEntitiesFree = o_orderDiscountMappingDao.queryDiscountInfoBySubOrderIDAndDiscountType(map);
                if (o_orderDiscountMappingEntitiesFree != null && o_orderDiscountMappingEntitiesFree.size() == 1) {
                    O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingEntitiesFree.get(0);
                    discountAmount = o_orderDiscountMappingEntity.getDiscountAmount();
                }
            }
        }
        return discountAmount;
    }


    /**
     * 插入或更新订单折扣信息
     * chenkangyi
     * 2017-5-21 18:21
     */
    private void insertOrUpdateOrderDiscountMapping(BigDecimal totalAmountAll, Long orderID, Long subOrderID, Long discountType, Boolean isRatio, Float discountPercentage, String discountAmount, Long loginID) {
        Map<String, Object> map = new HashMap<>();
        map.put("subOrderID", subOrderID);
        map.put("discountType", discountType);
        //根据子订单ID和折扣类别查询订单折扣信息
        List<O_OrderDiscountMappingEntity> o_orderDiscountMappingList = o_orderDiscountMappingDao.queryDiscountInfoBySubOrderIDAndDiscountType(map);
        if (discountType == ProductManageEnum.DiscountType.DISCOUNT.getValue() || discountType == ProductManageEnum.DiscountType.MEMBERDISCOUNT.getValue() || discountType == ProductManageEnum.DiscountType.FREE_SERVICE.getValue()) {
            if (o_orderDiscountMappingList == null || o_orderDiscountMappingList.size() == 0) {
                insertOrderDiscountMapping(totalAmountAll, orderID, subOrderID, discountType, isRatio, discountPercentage, discountAmount, loginID);
            } else {
                if (o_orderDiscountMappingList.size() > 1) {
                    throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
                }
                O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingList.get(0);
                if (o_orderDiscountMappingEntity == null) {
                    throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
                }
                updateOrderDiscountMapping(totalAmountAll, o_orderDiscountMappingEntity, orderID, subOrderID, discountType, isRatio, discountPercentage, discountAmount, loginID);
            }
        } else if (discountType == ProductManageEnum.DiscountType.STRAIGHTCUT.getValue() || discountType == ProductManageEnum.DiscountType.FREESINGLE.getValue()) {
            Map<String, Object> mapFreesingle = new HashMap<>();
            mapFreesingle.put("subOrderID", subOrderID);
            if (discountType == ProductManageEnum.DiscountType.STRAIGHTCUT.getValue()) {
                mapFreesingle.put("discountType", ProductManageEnum.DiscountType.FREESINGLE.getValue());
            } else if (discountType == ProductManageEnum.DiscountType.FREESINGLE.getValue()) {
                mapFreesingle.put("discountType", ProductManageEnum.DiscountType.STRAIGHTCUT.getValue());
            }
            List<O_OrderDiscountMappingEntity> o_orderDiscountMappingFreesingleList = o_orderDiscountMappingDao.queryDiscountInfoBySubOrderIDAndDiscountType(mapFreesingle);
            if (o_orderDiscountMappingFreesingleList == null || o_orderDiscountMappingFreesingleList.size() == 0) {
                if (o_orderDiscountMappingList == null || o_orderDiscountMappingList.size() == 0) {
                    insertOrderDiscountMapping(totalAmountAll, orderID, subOrderID, discountType, isRatio, discountPercentage, discountAmount, loginID);
                } else {
                    if (o_orderDiscountMappingList.size() > 1) {
                        throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
                    }
                    O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingList.get(0);
                    if (o_orderDiscountMappingEntity == null) {
                        throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
                    }
                    updateOrderDiscountMapping(totalAmountAll, o_orderDiscountMappingEntity, orderID, subOrderID, discountType, isRatio, discountPercentage, discountAmount, loginID);
                }
            } else {
                if (o_orderDiscountMappingFreesingleList.size() > 1) {
                    throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
                }
                O_OrderDiscountMappingEntity o_orderDiscountMappingFreesingleEntity = o_orderDiscountMappingFreesingleList.get(0);
                if (o_orderDiscountMappingFreesingleEntity == null) {
                    throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
                }
                updateOrderDiscountMapping(totalAmountAll, o_orderDiscountMappingFreesingleEntity, orderID, subOrderID, discountType, isRatio, discountPercentage, discountAmount, loginID);
            }
        }

    }

    /**
     * 插入订单折扣信息
     * chenkangyi
     * 2017-6-6 14:21
     */
    private void insertOrderDiscountMapping(BigDecimal totalAmountAll, Long orderID, Long subOrderID, Long discountType, Boolean isRatio, Float discountPercentage, String discountAmount, Long loginID) {
        O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = new O_OrderDiscountMappingEntity();
        Long mappingID = MaxIDUtils.getID(O_OrderDiscountMappingEntity.class);
        o_orderDiscountMappingEntity.setMappingID(mappingID);
        o_orderDiscountMappingEntity.setOrderID(orderID);
        o_orderDiscountMappingEntity.setSubOrderID(subOrderID);
        o_orderDiscountMappingEntity.setIsRatio(isRatio);
        o_orderDiscountMappingEntity.setIsManualProcess(true);
        o_orderDiscountMappingEntity.setDiscountType(discountType);
        if (isRatio) {  //是否比率,true按折扣比率计算,false按减免金额计算
            o_orderDiscountMappingEntity.setDiscountPercentage(discountPercentage);
            o_orderDiscountMappingEntity.setDiscountAmount(totalAmountAll.subtract(totalAmountAll.multiply(new BigDecimal(discountPercentage / 10)).setScale(2, BigDecimal.ROUND_HALF_UP)));
        } else {
            o_orderDiscountMappingEntity.setDiscountAmount(new BigDecimal(discountAmount));
        }
        o_orderDiscountMappingEntity.setMappingOrderID(orderID);
        o_orderDiscountMappingEntity.setLoginID(loginID);
        o_orderDiscountMappingEntity.setCreatorID(loginID);
        o_orderDiscountMappingEntity.setCreateTime(LocalDateTime.now());
        o_orderDiscountMappingDao.insertSelective(o_orderDiscountMappingEntity);
    }

    /**
     * 更新订单折扣信息
     * chenkangyi
     * 2017-6-6 14:21
     */
    private void updateOrderDiscountMapping(BigDecimal totalAmountAll, O_OrderDiscountMappingEntity o_orderDiscountMappingEntity, Long orderID, Long subOrderID, Long discountType, Boolean isRatio, Float discountPercentage, String discountAmount, Long loginID) {
        o_orderDiscountMappingEntity.setIsRatio(isRatio);
        o_orderDiscountMappingEntity.setIsManualProcess(true);
        o_orderDiscountMappingEntity.setDiscountType(discountType);
        if (isRatio) {  //是否比率,true按折扣比率计算,false按减免金额计算
            o_orderDiscountMappingEntity.setDiscountPercentage(discountPercentage);
            o_orderDiscountMappingEntity.setDiscountAmount(totalAmountAll.subtract(totalAmountAll.multiply(new BigDecimal(discountPercentage / 10)).setScale(2, BigDecimal.ROUND_HALF_UP)));
        } else {
            o_orderDiscountMappingEntity.setDiscountPercentage(null);
            o_orderDiscountMappingEntity.setDiscountAmount(new BigDecimal(discountAmount));
        }
        o_orderDiscountMappingEntity.setLoginID(loginID);
        o_orderDiscountMappingEntity.setCreateTime(LocalDateTime.now());
        o_orderDiscountMappingDao.updateByPrimaryKeySelective(o_orderDiscountMappingEntity);

    }


    /**
     * 根据登录ID查询角色折扣信息
     * chenkangyi
     * 2017-5-19 14:49
     */
    public O_RoleDiscountInfoEntity getRoleDiscountInfo(Long loginID) {
        O_RoleDiscountInfoEntity o_roleDiscountInfo = o_roleDiscountInfoDao.getRoleDiscountInfoByLoginID(loginID);
        return o_roleDiscountInfo;
    }

    /**
     * 根据subOrderID查询能打折的菜品
     * chenkangyi
     * 2017-5-21 17:12
     */
    public List<O_OrderDetailInfoEntity> getAllowDiscountOrderDetailInfo(Long subOrderID) {
        List<O_OrderDetailInfoEntity> o_orderDetailInfoList = o_orderDetailInfoDao.selectAllowDiscountBySubOrderID(subOrderID);
        return o_orderDetailInfoList;
    }

    /**
     * 根据subOrderID查询子订单信息
     * chenkangyi
     * 2017-5-31 16:48
     */
    public O_SubOrderInfoEntity getSubOrderInfo(Long subOrderID) {
        O_SubOrderInfoEntity o_subOrderInfo = o_subOrderInfoDao.selectByPrimaryKey(subOrderID);
        return o_subOrderInfo;
    }

    /**
     * 更新角色折扣信息
     * chenkangyi
     * 2017-5-31 19:18
     */
    public void updateO_RoleDiscountInfo(Long loginID, BigDecimal changeAmount, boolean isIncrease) {
        //根据登录ID查询角色折扣信息
        O_RoleDiscountInfoEntity roleDiscountInfo = getRoleDiscountInfo(loginID);
        BigDecimal highestAmount = roleDiscountInfo.getHighestAmount();
        if (highestAmount == null) {
            highestAmount = new BigDecimal(0);
        }
        if (isIncrease) {
            highestAmount = highestAmount.add(changeAmount);
        } else {
            highestAmount = highestAmount.subtract(changeAmount);
        }
        roleDiscountInfo.setHighestAmount(highestAmount);
        o_roleDiscountInfoDao.updateByPrimaryKeySelective(roleDiscountInfo);
    }

    /**
     * 根据subOrderID检查子订单是否能打折
     * chenkangyi
     * 2017-5-31 16:48
     */
    public O_SubOrderInfoEntity checkSubOrderCanDiscount(Long subOrderID, BigDecimal paidAmount) {
        if (subOrderID == null) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        O_SubOrderInfoEntity subOrderInfo = getSubOrderInfo(subOrderID);
        if (subOrderInfo == null) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        Long orderStatus = subOrderInfo.getOrderStatus();
        if (orderStatus == null) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        //订单状态为进行中才能打折
        if (orderStatus.longValue() != OrderManageEnum.OrderStatus.HAVEINHAND.getValue()) {
            throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
        }
        if (paidAmount == null) {
            paidAmount = BigDecimal.ZERO;
        }
        //已经支付过就不能再打折
        if (paidAmount.compareTo(BigDecimal.ZERO) == 1) {
            throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
        }
        return subOrderInfo;
    }

    /**
     * 检查打折时输入参数的合法性
     * chenkangyi
     * 2017-5-31 16:48
     */
    public void checkDiscountInput(Long loginID, Float discountPercentage) {
        //根据登录ID查询角色折扣信息
        O_RoleDiscountInfoEntity roleDiscountInfo = getRoleDiscountInfo(loginID);
        if (roleDiscountInfo == null) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        //最高折扣比率
        Float highestRate = roleDiscountInfo.getHighestRate();
        if (highestRate == null || highestRate < 0f) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        if (highestRate == 10f) {
            throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
        }
        if (discountPercentage < highestRate || highestRate > 10f) {
            throw new BizException(CodeMsgConstants.INPUT_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.INPUT_DISCOUNT_RATE_ERROR_MSG, highestRate);
        }
    }

    /**
     * @author chenkangyi
     * @version 1.0.0
     * @description 分割子订单字符串
     * @time 2017-5-31 16:00
     */
    private List<Long> splitSubOrderID(String subOrderID) {
        //分割子订单ID字符串
        String[] subOrderIDs = subOrderID.split(",");

        //子订单ID集合
        List<Long> subOrderIDList = new ArrayList<>();

        for (int i = 0; i < subOrderIDs.length; i++) {
            subOrderIDList.add(Long.valueOf(subOrderIDs[i]));
        }

        return subOrderIDList;
    }

    /**
     * @author chenkangyi
     * @version 1.0.0
     * @description 获取所有子订单的总金额
     * @time 2017-6-4 18:11
     */
    public BigDecimal getTotalAmountAll(List<Long> subOrderIDList, BigDecimal paidAmount) {
        //获取所有子订单的总额
        BigDecimal totalAmountAll = new BigDecimal(0);
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
            if (totalAmount != null) {
                totalAmountAll = totalAmountAll.add(totalAmount);
            }
        }
        return totalAmountAll;
    }

    /**
     * @author chenkangyi
     * @version 2.0.0
     * @description 更新抹零
     * @time 2017-6-6 18:08
     */
    private void updateDroptail(Map<String, Object> map) throws Exception {
        /*AmountSituationVO amountSituation = amountSituationService.amountSituation(map);
        BigDecimal payableAmount = amountSituation.getPayableAmount();
        BigDecimal droptailAmount = amountSituation.getDroptailAmount();
        BigDecimal droptailAmountNew = basicParamInfoService.getDroptailAmount((Long)map.get("archiveID") , payableAmount.add(droptailAmount));
        //更新订单折扣信息的抹零记录
        //Map<String, Object> map = new HashMap<>();
        //map.put("subOrderID", subOrderID);
        map.put("discountType", ProductManageEnum.DiscountType.ZERO.getValue());
        List<O_OrderDiscountMappingEntity> o_orderDiscountMappingEntities = o_orderDiscountMappingDao.selectOrderDiscountMappingBySubOrderIDListAndDiscountType(map);
        if (o_orderDiscountMappingEntities == null || o_orderDiscountMappingEntities.size() > 0){
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }else {
            O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingEntities.get(0);
            if (o_orderDiscountMappingEntity == null){
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            o_orderDiscountMappingEntity.setDiscountAmount(droptailAmountNew);
            o_orderDiscountMappingDao.updateByPrimaryKeySelective(o_orderDiscountMappingEntity);
        }*/

    }

    /**
     * @author chenkangyi
     * @version 2.0.0
     * @description 获取子订单所有能打折的菜品的价格总额
     * @time 2017-6-7 13:26
     */
    private BigDecimal getSubOrderCanDiscountOrderDetail(List<O_OrderDetailInfoEntity> allowDiscountOrderDetailInfoList) {
        //获取子订单里所有能打折的菜品的价格总额
        BigDecimal totalAmountAll = new BigDecimal(0);
        BigDecimal totalAmountZero = new BigDecimal(0);
        for (O_OrderDetailInfoEntity o_orderDetailInfoEntity : allowDiscountOrderDetailInfoList) {
            totalAmountAll = totalAmountAll.add((o_orderDetailInfoEntity.getTotalAmount() == null ? totalAmountZero : o_orderDetailInfoEntity.getTotalAmount()));
        }
        return totalAmountAll;
    }

    /**
     * @author chenkangyi
     * @version 2.0.0
     * @description 本单可免单的金额
     * @time 2017-6-7 18:26
     */
    private BigDecimal getOrderCanFreeAmount(Map<String, Object> map) throws Exception {
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation((List<Long>) map.get("subOrderIDList"), (Long)map.get("archiveID"),(Long)map.get("loginID"));
        //商品总额
        BigDecimal totalAmount = amountSituationVO.getTotalAmount();
        if (totalAmount == null) {
            totalAmount = new BigDecimal(0);
        }
        //查询应收金额
        BigDecimal payableAmount = amountSituationVO.getPayableAmount();
        if (payableAmount == null) {
            payableAmount = new BigDecimal(0);
        }
//        //折扣总额
//        BigDecimal discountAmount = amountSituationVO.getDiscountAmount();
//        if (discountAmount == null) {
//            discountAmount = new BigDecimal(0);
//        }
        List<Long> subOrderIDList = (List<Long>) map.get("subOrderIDList");
        //已减免金额
        BigDecimal discountAmount = getHasReduceAmount(map,subOrderIDList);
        //抹零金额
        BigDecimal droptailAmount = amountSituationVO.getDroptailAmount();
        if (droptailAmount == null) {
            droptailAmount = new BigDecimal(0);
        }
        //计算应收金额+抹零 +本单已减免金额
        BigDecimal amountSum = payableAmount.add(droptailAmount).add(discountAmount);
        return amountSum;
    }

}
