package cc.toprank.byd.web.service.order;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.CustomerManageEnum;
import cc.toprank.byd.enums.FinancialManageEnum;
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
public class DiscountService {

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

    @Autowired
    private O_OrderInfoDao o_orderInfoDao;

    @Autowired
    private O_OrderRelationMappingDao o_orderRelationMappingDao;

    @Autowired
    private O_OrderDealInfoDao o_orderDealInfoDao;

    /**
     * 权限折
     * chenkangyi
     * 2017-5-22 13:41
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData authorityDiscount(Map<String, Object> map) throws Exception {
        ResultData resultData = new ResultData();
        Long loginID = (Long) map.get("loginID");
        Long archiveID = (Long)map.get("archiveID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        Float discountPercentage = (Float) map.get("discountPercentage");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        if (subOrderIDList == null || subOrderIDList.size() == 0){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        //检查折扣输入参数的合法性
        checkDiscountInput(loginID, discountPercentage);
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList,archiveID,loginID);
        //已收金额
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        //标志是否能打折
        boolean isCanDiscount = false;
        //所有子订单所有能打折的菜品的价格总额
        BigDecimal totalAmountCanDiscountAll = BigDecimal.ZERO;
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            //根据subOrderID查询能打折的菜品
            List<O_OrderDetailInfoEntity> allowDiscountOrderDetailInfoList = getAllowDiscountOrderDetailInfo(subOrderID);
            //获取子订单所有能打折的菜品的价格总额
            BigDecimal totalAmountCanDiscount = getSubOrderCanDiscountOrderDetail(allowDiscountOrderDetailInfoList);
            totalAmountCanDiscountAll = totalAmountCanDiscountAll.add(totalAmountCanDiscount);
            if (allowDiscountOrderDetailInfoList != null && allowDiscountOrderDetailInfoList.size() > 0) {
                isCanDiscount = true;
                map.put("dealDesc","权限折");
                updateSubOrderInfoAndOrderInfoAndOrderRelationMapping(o_subOrderInfo,totalAmountCanDiscount.subtract(totalAmountCanDiscount.multiply(new BigDecimal(discountPercentage/10))),amountSituationVO,map,false);
            } else { //订单所有菜品不能打折
                if (i == subOrderIDList.size() - 1 && isCanDiscount == false) {
                    throw new BizException(CodeMsgConstants.SELECT_OREDER_CANNOT_ALLOW_DISCOUNT_CODE, CodeMsgConstants.SELECT_OREDER_CANNOT_ALLOW_DISCOUNT_MSG);
                }
            }
        }
        if (totalAmountCanDiscountAll.compareTo(BigDecimal.ZERO) == 1) {
            String memo = "权限折"+discountPercentage+"折";
            //插入订单权限折扣信息，discountType为795
            insertOrUpdateOrderDiscountMapping(totalAmountCanDiscountAll, orderID, businessType, ProductManageEnum.DiscountType.PERMISSIONDISCOUNT.getValue(), true, discountPercentage, null, loginID, memo);
            updateDroptail(map);
        }else {
            throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
        }
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 更新子订单、订单或订单关联信息
     * chenkangyi
     * 2017-6-16 18:26
     */
    private void updateSubOrderInfoAndOrderInfoAndOrderRelationMapping(O_SubOrderInfoEntity o_subOrderInfo,BigDecimal discountAmountSubOrder,AmountSituationVO amountSituationVO, Map<String, Object> map, boolean isCancleDiscount){
        /*Long loginID = (Long) map.get("loginID");
        String dealDesc = (String) map.get("dealDesc");
        Long subOrderID = o_subOrderInfo.getSubOrderID();
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        O_SubOrderInfoEntity subOrderInfo = getSubOrderInfo(subOrderID);
        if (subOrderInfo == null){
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        //折扣金额
        BigDecimal discountAmount = subOrderInfo.getDiscountAmount();
        Map<String, Object> mapSub = new HashMap<>();
        mapSub.put("loginID",loginID);
        mapSub.put("subOrderID",subOrderID);
        mapSub.put("orderID",o_subOrderInfo.getOrderID());
        BigDecimal beforeAmount = discountAmount;
        mapSub.put("beforeAmount",beforeAmount);
        mapSub.put("dealDesc",dealDesc);
        if (discountAmount != null){
            if (!isCancleDiscount) {
                discountAmount = discountAmount.add(discountAmountSubOrder);
            }else {
                discountAmount = discountAmount.subtract(discountAmountSubOrder);
            }
            BigDecimal afterAmount = discountAmount;
            mapSub.put("afterAmount",afterAmount);
            if (discountAmount.compareTo(BigDecimal.ZERO) != -1) {
                subOrderInfo.setDiscountAmount(discountAmount);
                mapSub.put("changeAmount",afterAmount.subtract(beforeAmount));
                insertOrderDealInfo(mapSub);
            }
        }
        //实际金额
        BigDecimal actualAmount = subOrderInfo.getActualAmount();
        if (actualAmount != null){
            if (!isCancleDiscount) {
                actualAmount = actualAmount.subtract(discountAmountSubOrder);
            }else {
                actualAmount = actualAmount.add(discountAmountSubOrder);
            }
            if (actualAmount.compareTo(BigDecimal.ZERO) != -1){
                subOrderInfo.setActualAmount(actualAmount);
            }
        }
        //待付金额
        BigDecimal pendingAmount = subOrderInfo.getPendingAmount();
        if (pendingAmount != null){
            if (!isCancleDiscount) {
                pendingAmount = pendingAmount.subtract(discountAmountSubOrder);
            }else {
                pendingAmount = pendingAmount.add(discountAmountSubOrder);
            }
            if (pendingAmount.compareTo(BigDecimal.ZERO) != -1){
                subOrderInfo.setPendingAmount(pendingAmount);
            }
        }
        //更新子订单
        o_subOrderInfoDao.updateByPrimaryKeySelective(subOrderInfo);

        O_OrderInfoEntity o_orderInfoEntity = o_orderInfoDao.selectByPrimaryKey(o_subOrderInfo.getOrderID());
        if (o_orderInfoEntity == null){
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        //折扣金额
        BigDecimal discountAmountOrder = o_orderInfoEntity.getDiscountAmount();
        Map<String, Object> mapOrder = new HashMap<>();
        mapOrder.put("loginID",loginID);
        mapOrder.put("orderID",o_subOrderInfo.getOrderID());
        BigDecimal beforeAmountOrder = discountAmount;
        mapOrder.put("beforeAmount",beforeAmountOrder);
        mapOrder.put("dealDesc",dealDesc);
        if (discountAmountOrder != null){
            if (!isCancleDiscount) {
                discountAmountOrder = discountAmountOrder.add(discountAmountSubOrder);
            }else {
                discountAmountOrder = discountAmountOrder.subtract(discountAmountSubOrder);
            }
            BigDecimal afterAmountOrder = discountAmount;
            mapOrder.put("afterAmount",afterAmountOrder);
            if (discountAmountOrder.compareTo(BigDecimal.ZERO) != -1) {
                o_orderInfoEntity.setDiscountAmount(discountAmountOrder);
                mapOrder.put("changeAmount",afterAmountOrder.subtract(beforeAmountOrder));
                insertOrderDealInfo(mapOrder);
            }
        }
        //实际金额
        BigDecimal actualAmountOrder = o_orderInfoEntity.getActualAmount();
        if (actualAmountOrder != null){
            if (!isCancleDiscount) {
                actualAmountOrder = actualAmountOrder.subtract(discountAmountSubOrder);
            }else {
                actualAmountOrder = actualAmountOrder.add(discountAmountSubOrder);
            }
            if (actualAmountOrder.compareTo(BigDecimal.ZERO) != -1){
                o_orderInfoEntity.setActualAmount(actualAmountOrder);
            }
        }
        //待付金额
        BigDecimal pendingAmountOrder = o_orderInfoEntity.getPendingAmount();
        if (pendingAmountOrder != null){
            if (!isCancleDiscount) {
                pendingAmountOrder = pendingAmountOrder.subtract(discountAmountSubOrder);
            }else {
                pendingAmountOrder = pendingAmountOrder.add(discountAmountSubOrder);
            }
            if (pendingAmountOrder.compareTo(BigDecimal.ZERO) != -1){
                o_orderInfoEntity.setPendingAmount(pendingAmountOrder);
            }
        }
        //更新订单信息
        o_orderInfoDao.updateByPrimaryKeySelective(o_orderInfoEntity);

        if (businessType == FinancialManageEnum.FundChangeBusinessType.SUBORDERINFO.getValue()) {
            O_OrderRelationMappingEntity o_orderRelationMappingEntity = o_orderRelationMappingDao.selectByPrimaryKey(orderID);
            if (o_orderRelationMappingEntity == null){
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            //折扣金额
            BigDecimal discountAmountorderRelationMapping = o_orderRelationMappingEntity.getDiscountAmount();
            if (discountAmountorderRelationMapping != null){
                if (!isCancleDiscount) {
                    discountAmountorderRelationMapping = discountAmountorderRelationMapping.add(discountAmountSubOrder);
                }else {
                    discountAmountorderRelationMapping = discountAmountorderRelationMapping.subtract(discountAmountSubOrder);
                }
                if (discountAmountorderRelationMapping.compareTo(BigDecimal.ZERO) != -1) {
                    o_orderRelationMappingEntity.setDiscountAmount(discountAmountorderRelationMapping);
                }
            }
            //实际金额
            BigDecimal actualAmountorderRelationMapping = o_orderRelationMappingEntity.getActualAmount();
            if (actualAmountorderRelationMapping != null){
                if (!isCancleDiscount) {
                    actualAmountorderRelationMapping = actualAmountorderRelationMapping.subtract(discountAmountSubOrder);
                }else {
                    actualAmountorderRelationMapping = actualAmountorderRelationMapping.add(discountAmountSubOrder);
                }
                if (actualAmountorderRelationMapping.compareTo(BigDecimal.ZERO) != -1){
                    o_orderRelationMappingEntity.setActualAmount(actualAmountorderRelationMapping);
                }
            }
            //待付金额
            BigDecimal pendingAmountorderRelationMapping = o_orderRelationMappingEntity.getPendingAmount();
            if (pendingAmountorderRelationMapping != null){
                if (!isCancleDiscount) {
                    pendingAmountorderRelationMapping = pendingAmountorderRelationMapping.subtract(discountAmountSubOrder);
                }else {
                    pendingAmountorderRelationMapping = pendingAmountorderRelationMapping.add(discountAmountSubOrder);
                }
                if (pendingAmountorderRelationMapping.compareTo(BigDecimal.ZERO) != -1){
                    o_orderRelationMappingEntity.setPendingAmount(pendingAmountorderRelationMapping);
                }
            }
            //更新订单关联信息
            o_orderRelationMappingDao.updateByPrimaryKeySelective(o_orderRelationMappingEntity);
        }*/
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
        Long archiveID = (Long)map.get("archiveID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        Float discountPercentage = (Float) map.get("discountPercentage");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        //检查折扣输入参数的合法性
        checkDiscountInput(loginID, discountPercentage);
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList,archiveID,loginID);
        //已收金额
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        //所有子订单所有能打折的菜品的价格总额
        BigDecimal totalAmountCanDiscountAll = BigDecimal.ZERO;
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            //子订单商品总额
            BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
            if (totalAmount == null){
                totalAmount = BigDecimal.ZERO;
            }
            totalAmountCanDiscountAll = totalAmountCanDiscountAll.add(totalAmount);
            map.put("dealDesc","全单折");
            updateSubOrderInfoAndOrderInfoAndOrderRelationMapping(o_subOrderInfo,totalAmount.subtract(totalAmount.multiply(new BigDecimal(discountPercentage/10))),amountSituationVO,map,false);
        }
        if (totalAmountCanDiscountAll.compareTo(BigDecimal.ZERO) == 1) {
            String memo = "全单折" + discountPercentage + "折";
            insertOrUpdateOrderDiscountMapping(totalAmountCanDiscountAll, orderID, businessType, ProductManageEnum.DiscountType.FULLDISCOUNT.getValue(), true, discountPercentage, null, loginID, memo);
            updateDroptail(map);
        }else {
            throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
        }
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
        Long archiveID = (Long)map.get("archiveID");
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
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList, archiveID,loginID);
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        boolean isSettingMemberRuleInfo = false;
        if (roleID != null) {
            //根据roleID查询活动规则信息
            Map<String, Object> mapActivityRuleInfo = new HashMap<>();
            mapActivityRuleInfo.put("roleID", roleID);
            mapActivityRuleInfo.put("discountType", ProductManageEnum.DiscountType.MEMBERDISCOUNT.getValue());
            M_ActivityRuleInfoEntity m_activityRuleInfo = m_activityRuleInfoDao.selectByRoleID(mapActivityRuleInfo);
            if (m_activityRuleInfo != null) {
                Long ruleID = m_activityRuleInfo.getRuleID();
                if (ruleID != null) {
                    //根据ruleID查询活动折扣信息
                    Map<String, Object> mapActivityDiscountInfo = new HashMap<>();
                    mapActivityDiscountInfo.put("ruleID", ruleID);
                    mapActivityDiscountInfo.put("discounType", ProductManageEnum.DiscountType.MEMBERDISCOUNT.getValue());
                    M_ActivityDiscountInfoEntity m_activityDiscountInfo = m_activityDiscountInfoDao.selectByRuleID(mapActivityDiscountInfo);
                    if (m_activityDiscountInfo != null) {
                        isSettingMemberRuleInfo = true;
                        //discounType暂时取折扣比率和减免金额
                        Long discounType = m_activityDiscountInfo.getDiscounType();
                        //折扣比率
                        Float discountPercentage = m_activityDiscountInfo.getDiscountPercentage();
                        //减免金额
                        BigDecimal discountAmount = m_activityDiscountInfo.getDiscountAmount();
                        if (discountAmount == null) {
                            discountAmount = new BigDecimal(0);
                        }

                        BigDecimal totalAmountAll = getTotalAmountCanDiscountAll(subOrderIDList, paidAmount);
                        boolean isRatio = false;
                        if (discounType == FinancialManageEnum.RechargeAmountModel.RATIO_AMOUNT.getValue()) {  //折扣比率
                            isRatio = true;
                        } else if (discounType == FinancialManageEnum.RechargeAmountModel.FIXED_AMOUNT.getValue()) { //减免金额
                            isRatio = false;
                        } else {
                            isRatio = true;
                        }
                        boolean isCanDiscount = false;
                        //所有子订单所有能打折的菜品的价格总额
                        BigDecimal totalAmountCanDiscountAll = BigDecimal.ZERO;
                        //获取所有子订单下的所有能打折的菜品
                        List<O_OrderDetailInfoEntity> o_orderDetailInfoEntities = o_orderDetailInfoDao.selectAllowDiscountBySubOrderIDList(map);
                        //获取所有子订单所有能打折的菜品的价格总额
                        BigDecimal totalAmountCanDiscountSubOrderList = getSubOrderCanDiscountOrderDetail(o_orderDetailInfoEntities);
                        for (int i = 0; i < subOrderIDList.size(); i++) {
                            Long subOrderID = subOrderIDList.get(i);
                            //根据subOrderID检查子订单是否能打折
                            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
                            //根据subOrderID查询能打折的菜品
                            List<O_OrderDetailInfoEntity> allowDiscountOrderDetailInfoList = getAllowDiscountOrderDetailInfo(subOrderID);
                            //获取子订单所有能打折的菜品的价格总额
                            BigDecimal totalAmountCanDiscount = getSubOrderCanDiscountOrderDetail(allowDiscountOrderDetailInfoList);
                            BigDecimal totalAmountCanDiscountDivide = totalAmountCanDiscount.divide(totalAmountCanDiscountSubOrderList);
                            totalAmountCanDiscountAll = totalAmountCanDiscountAll.add(totalAmountCanDiscount);
                            if (allowDiscountOrderDetailInfoList != null && allowDiscountOrderDetailInfoList.size() > 0) {
                                isCanDiscount = true;
                                map.put("dealDesc","会员折");
                                if (isRatio) {
                                    //折扣比率
                                    updateSubOrderInfoAndOrderInfoAndOrderRelationMapping(o_subOrderInfo,totalAmountCanDiscount.subtract(totalAmountCanDiscount.multiply(new BigDecimal(discountPercentage/10))),amountSituationVO,map,false);
                                }else {
                                    //减免金额
                                    updateSubOrderInfoAndOrderInfoAndOrderRelationMapping(o_subOrderInfo,discountAmount.multiply(totalAmountCanDiscountDivide),amountSituationVO,map,false);
                                }

                            } else { //订单所有菜品不能打折
                                if (i == subOrderIDList.size() - 1 && isCanDiscount == false) {
                                    throw new BizException(CodeMsgConstants.SELECT_OREDER_CANNOT_ALLOW_DISCOUNT_CODE, CodeMsgConstants.SELECT_OREDER_CANNOT_ALLOW_DISCOUNT_MSG);
                                }
                            }
                        }
                        if (totalAmountCanDiscountAll.compareTo(BigDecimal.ZERO) == 1) {
                            String memo;
                            if (isRatio) {
                                memo = "会员折" + discountPercentage + "折";
                            }else {
                                memo = "会员折" + discountAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "元";
                            }
                            //插入订单会员折扣信息，discountType为1010
                            insertOrUpdateOrderDiscountMapping(totalAmountCanDiscountAll, orderID, businessType, ProductManageEnum.DiscountType.MEMBERDISCOUNT.getValue(), isRatio, discountPercentage, discountAmount.toString(), loginID, memo);
                            updateDroptail(map);
                        }else {
                            throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
                        }
                    }
                }
            }
        }
        //如果没有配置会员折扣信息，则取菜品会员价
        if (isSettingMemberRuleInfo == false){
            BigDecimal menuMemberPrice = getMenuMemberPrice(subOrderIDList);
            BigDecimal totalAmountCanDiscountAll = getTotalAmountCanDiscountAll(subOrderIDList,paidAmount);
            BigDecimal discountAmount = totalAmountCanDiscountAll.subtract(menuMemberPrice);
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
                BigDecimal totalAmountDivide = totalAmount.divide(totalAmountCanDiscountAll);
                map.put("dealDesc","会员折");
                updateSubOrderInfoAndOrderInfoAndOrderRelationMapping(o_subOrderInfo,discountAmount.multiply(totalAmountDivide),amountSituationVO,map,false);
            }
            if (discountAmount.compareTo(BigDecimal.ZERO) == 1) {
                String memo = "会员折" + discountAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "元";;
                //插入订单会员折扣信息，discountType为1010
                insertOrUpdateOrderDiscountMapping(null, orderID, businessType, ProductManageEnum.DiscountType.MEMBERDISCOUNT.getValue(), false, null, discountAmount.toString(), loginID, memo);
                updateDroptail(map);
            }else {
                throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
            }
        }
        //根据roleID获取用户角色信息
//        E_RoleInfoEntity e_roleInfo = e_roleInfoDao.selectByPrimaryKey(roleID);
//        if (e_roleInfo == null) {
//            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
//        }

        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 获取所有子订单下的所有菜品的会员价的总额
     * chenkangyi
     * 2017-6-2 10:50
     */
    private BigDecimal getMenuMemberPrice(List<Long> subOrderIDList){
        Map<String, Object> map = new HashMap<>();
        map.put("subOrderIDList",subOrderIDList);
        BigDecimal subOrderlistAllDetailMemberPriceTotal = o_orderDetailInfoDao.getSubOrderlistAllDetailMemberPriceTotal(map);
        if (subOrderlistAllDetailMemberPriceTotal == null){
            subOrderlistAllDetailMemberPriceTotal = BigDecimal.ZERO;
        }
        return subOrderlistAllDetailMemberPriceTotal;
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
        Long archiveID = (Long)map.get("archiveID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList,archiveID,loginID);
        //已收金额
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        //获取所有子订单的总金额
        BigDecimal totalAmountAll = getTotalAmountCanDiscountAll(subOrderIDList, paidAmount);
        //所有子订单的服务费总额
        //BigDecimal serviceFeeAll = BigDecimal.ZERO;
        //所有子订单所有能打折的菜品的价格总额
        //BigDecimal totalAmountCanDiscountAll = BigDecimal.ZERO;
        //获取商家设置的服务费
        BigDecimal serviceFee = merchantFeeInfoService.getMerchantFee(archiveID, subOrderIDList);
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
            map.put("dealDesc","免服务费");
            updateSubOrderInfoAndOrderInfoAndOrderRelationMapping(o_subOrderInfo,serviceFee.multiply(totalAmountDivide),amountSituationVO,map,false);
            //totalAmountCanDiscountAll = totalAmountCanDiscountAll.add(totalAmount);
            //就餐人数
            //Integer peopleNum = o_subOrderInfo.getPeopleNum();

//            if (serviceFee == null) {
//                serviceFee = new BigDecimal(0);
//            }
//            serviceFeeAll = serviceFeeAll.add(serviceFee);
        }
        if (totalAmountAll.compareTo(BigDecimal.ZERO) == 1 && serviceFee.compareTo(BigDecimal.ZERO) == 1) {
            String memo = "免服务费"+serviceFee.setScale(2, BigDecimal.ROUND_HALF_UP).toString()+"元";
            insertOrUpdateOrderDiscountMapping(totalAmountAll, orderID, businessType, ProductManageEnum.DiscountType.FREE_SERVICE.getValue(), false, null, serviceFee.toString(), loginID, memo);
            //更新抹零
            updateDroptail(map);
        }else {
            throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
        }
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
        Long archiveID = (Long)map.get("archiveID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList,archiveID,loginID);
        //已收金额
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        map.put("orderID", orderID);
        map.put("businessType", businessType);
        //删除o_orderDiscountMapping的对应记录
        map.put("discountType", ProductManageEnum.DiscountType.FREE_SERVICE.getValue());
        //根据订单ID和折扣类别查询订单折扣信息
        O_OrderDiscountMappingEntity o_orderDiscountMappingEntities = o_orderDiscountMappingDao.queryDiscountInfoByOrderIDAndDiscountType(map);
        if (o_orderDiscountMappingEntities == null) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        //根据订单ID和折扣类别删除订单折扣信息
        o_orderDiscountMappingDao.deleteOrderDiscountMappingByOrderIDAndDiscountType(map);
        //获取所有子订单的总金额
        BigDecimal totalAmountAll = getTotalAmountCanDiscountAll(subOrderIDList, paidAmount);
        //获取商家设置的服务费
        BigDecimal serviceFee = merchantFeeInfoService.getMerchantFee(archiveID, subOrderIDList);
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
            map.put("dealDesc","收服务费");
            updateSubOrderInfoAndOrderInfoAndOrderRelationMapping(o_subOrderInfo,serviceFee.multiply(totalAmountDivide),amountSituationVO,map,true);
        }
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
        Long archiveID = (Long)map.get("archiveID");
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
        //获取订单金额情况，map需要参数subOrderIDList，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList,archiveID,loginID);
        //已收金额
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        //所有子订单所有能打折的菜品的价格总额
        //BigDecimal totalAmountCanDiscountAll = BigDecimal.ZERO;
        //获取所有子订单的总金额
        BigDecimal totalAmountAll = getTotalAmountCanDiscountAll(subOrderIDList, paidAmount);
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
            if (totalAmount == null){
                totalAmount = BigDecimal.ZERO;
            }
            //totalAmountCanDiscountAll = totalAmountCanDiscountAll.add(totalAmount);
            BigDecimal totalAmountDivide = totalAmount.divide(totalAmountAll);
            map.put("dealDesc","减免");
            updateSubOrderInfoAndOrderInfoAndOrderRelationMapping(o_subOrderInfo,discountAmount.multiply(totalAmountDivide),amountSituationVO,map,false);
        }
        if (totalAmountAll.compareTo(BigDecimal.ZERO) == 1) {
            String memo = "减免" + discountAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "元";
            insertOrUpdateOrderDiscountMapping(totalAmountAll, orderID, businessType, ProductManageEnum.DiscountType.STRAIGHTCUT.getValue(), false, null, discountAmount.toString(), loginID, memo);
            updateDroptail(map);
        }else {
            throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
        }
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
        Long archiveID = (Long)map.get("archiveID");
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
        //获取订单金额情况，map需要参数subOrderIDList，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList,archiveID,loginID);
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        //所有子订单所有能打折的菜品的价格总额
        //BigDecimal totalAmountCanDiscountAll = BigDecimal.ZERO;
        //获取所有子订单的总金额
        BigDecimal totalAmountAll = getTotalAmountCanDiscountAll(subOrderIDList, paidAmount);
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
            if (totalAmount == null){
                totalAmount = BigDecimal.ZERO;
            }
            //totalAmountCanDiscountAll = totalAmountCanDiscountAll.add(totalAmount);
            BigDecimal totalAmountDivide = totalAmount.divide(totalAmountAll);
            map.put("dealDesc","免单");
            updateSubOrderInfoAndOrderInfoAndOrderRelationMapping(o_subOrderInfo,orderCanFreeAmount.multiply(totalAmountDivide),amountSituationVO,map,true);
        }
        if (totalAmountAll.compareTo(BigDecimal.ZERO) == 1) {
            String memo = "免单" + orderCanFreeAmount.setScale(2, BigDecimal.ROUND_HALF_UP).toString() + "元";
            insertOrUpdateOrderDiscountMapping(totalAmountAll, orderID, businessType, ProductManageEnum.DiscountType.FREESINGLE.getValue(), false, null, orderCanFreeAmount.toString(), loginID, memo);
            updateDroptail(map);
        }else {
            throw new BizException(CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_CODE, CodeMsgConstants.ROLE_DISCOUNT_RATE_ERROR_MSG);
        }
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
        Long archiveID = (Long)map.get("archiveID");
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
        //获取订单金额情况，map需要参数subOrderIDList，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList, archiveID,loginID);
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        map.put("orderID", orderID);
        map.put("businessType", businessType);
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
        //已减免金额
        BigDecimal discountAmount = getHasReduceAmount(map);
        //抹零金额
        BigDecimal droptailAmount = amountSituationVO.getDroptailAmount();
        if (droptailAmount == null) {
            droptailAmount = new BigDecimal(0);
        }
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
    @Transactional(rollbackFor = Exception.class)
    public ResultData cancleDiscount(Map<String, Object> map) throws Exception {
        ResultData resultData = new ResultData();
        Long loginID = (Long) map.get("loginID");
        Long archiveID = (Long)map.get("archiveID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList,archiveID,loginID);
        BigDecimal paidAmount = amountSituationVO.getPaidAmount();
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        map.put("orderID", orderID);
        map.put("businessType", businessType);
        //根据子订单ID和折扣类别查询订单折扣信息
        O_OrderDiscountMappingEntity o_orderDiscountMapping = o_orderDiscountMappingDao.queryDiscountInfoByOrderIDAndDiscountType(map);
        if (o_orderDiscountMapping == null) {
            throw new BizException(CodeMsgConstants.CANCLE_DISCOUNT_ERROR_CODE, CodeMsgConstants.CANCLE_DISCOUNT_ERROR_MSG);
        }
        BigDecimal discountAmount = o_orderDiscountMapping.getDiscountAmount();
        Long discountType = o_orderDiscountMapping.getDiscountType();
        if (discountType == null){
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        //获取所有子订单的总金额
        BigDecimal totalAmountAll = getTotalAmountCanDiscountAll(subOrderIDList, paidAmount);
        //标志是否能打折
        boolean isCanDiscount = true;
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            //根据subOrderID检查子订单是否能打折
            O_SubOrderInfoEntity o_subOrderInfo = checkSubOrderCanDiscount(subOrderID, paidAmount);
            //如果是权限折
            if (discountType == ProductManageEnum.DiscountType.PERMISSIONDISCOUNT.getValue()){
                //根据subOrderID查询能打折的菜品
                List<O_OrderDetailInfoEntity> allowDiscountOrderDetailInfoList = getAllowDiscountOrderDetailInfo(subOrderID);
                if (allowDiscountOrderDetailInfoList != null && allowDiscountOrderDetailInfoList.size() > 0) {
                    isCanDiscount = true;
                }else {
                    isCanDiscount = false;
                }
            }
            if (isCanDiscount) {
                BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
                if (totalAmount == null) {
                    totalAmount = BigDecimal.ZERO;
                }
                BigDecimal totalAmountDivide = totalAmount.divide(totalAmountAll);
                if (discountAmount != null && discountAmount.compareTo(BigDecimal.ZERO) == 1) {
                    map.put("dealDesc", "取消手动打折");
                    updateSubOrderInfoAndOrderInfoAndOrderRelationMapping(o_subOrderInfo, discountAmount.multiply(totalAmountDivide), amountSituationVO, map, true);
                }
            }
        }
        //根据订单ID和折扣类别删除订单折扣信息
        o_orderDiscountMappingDao.deleteOrderDiscountMappingByOrderIDAndDiscountType(map);
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 更新折扣信息
     * chenkangyi
     * 2017-6-13 15:41
     */
    public ResultData updateDiscountInfo(Map<String, Object> map) throws Exception{
        ResultData resultData = new ResultData();
        Long loginID = (Long) map.get("loginID");
        Long archiveID = (Long)map.get("archiveID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        map.put("subOrderIDList", subOrderIDList);
        //获取订单金额情况，map需要参数subOrderIDList，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation(subOrderIDList,archiveID,loginID);
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        //根据子订单ID和折扣类别查询订单折扣信息
        map.put("orderID", orderID);
        map.put("businessType", businessType);
        O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingDao.queryDiscountInfoByOrderIDAndDiscountType(map);
        if (o_orderDiscountMappingEntity !=null){
            Long discountType = o_orderDiscountMappingEntity.getDiscountType();
            if (discountType == ProductManageEnum.DiscountType.FREE_SERVICE.getValue()){
                //更新服务费
                updateFreeService(map);
            }else if (discountType == ProductManageEnum.DiscountType.FULLDISCOUNT.getValue()){
                //更新全单折
                updateOrderDiscount(map);
            }else if (discountType == ProductManageEnum.DiscountType.STRAIGHTCUT.getValue()){
                //更新减免
                updateReduceAmount(map, ProductManageEnum.DiscountType.STRAIGHTCUT.getValue());
            }else if (discountType == ProductManageEnum.DiscountType.FREESINGLE.getValue()){
                //更新免单
                updateReduceAmount(map, ProductManageEnum.DiscountType.FREESINGLE.getValue());
            }else if (discountType == ProductManageEnum.DiscountType.MEMBERDISCOUNT.getValue()){
                //更新会员折
            }else if (discountType == ProductManageEnum.DiscountType.PERMISSIONDISCOUNT.getValue()){
                //更新权限折
                updateAuthorityDiscount(map);
            }
        }
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        return resultData;
    }

    /**
     * 更新权限折
     * chenkangyi
     * 2017-6-13 15:41
     */
    private void updateAuthorityDiscount(Map<String, Object> map){
        Long loginID = (Long) map.get("loginID");
        Long archiveID = (Long)map.get("archiveID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        //所有子订单所有能打折的菜品的价格总额
        BigDecimal totalAmountCanDiscountAll = BigDecimal.ZERO;
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);

            //根据subOrderID查询能打折的菜品
            List<O_OrderDetailInfoEntity> allowDiscountOrderDetailInfoList = getAllowDiscountOrderDetailInfo(subOrderID);
            //获取子订单所有能打折的菜品的价格总额
            BigDecimal totalAmountCanDiscount = getSubOrderCanDiscountOrderDetail(allowDiscountOrderDetailInfoList);
            totalAmountCanDiscountAll = totalAmountCanDiscountAll.add(totalAmountCanDiscount);

        }
        map.put("discountType", ProductManageEnum.DiscountType.PERMISSIONDISCOUNT.getValue());
        //根据子订单ID和折扣类别查询订单折扣信息
        O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingDao.queryDiscountInfoByOrderIDAndDiscountType(map);
        if (o_orderDiscountMappingEntity != null) {
            BigDecimal discountAmount = o_orderDiscountMappingEntity.getDiscountAmount();
            if (discountAmount == null) {
                discountAmount = BigDecimal.ZERO;
            }
            Float discountPercentage = o_orderDiscountMappingEntity.getDiscountPercentage();
            if (discountPercentage == null) {
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            BigDecimal discountAmountNew = totalAmountCanDiscountAll.subtract(totalAmountCanDiscountAll.multiply(new BigDecimal(discountPercentage)).setScale(2, BigDecimal.ROUND_HALF_UP));
            if (discountAmount.compareTo(discountAmountNew) != 0){
                o_orderDiscountMappingEntity.setDiscountAmount(discountAmountNew);
                o_orderDiscountMappingDao.updateByPrimaryKeySelective(o_orderDiscountMappingEntity);
            }
        }
    }

    /**
     * 更新全单折
     * chenkangyi
     * 2017-6-13 15:41
     */
    private void updateOrderDiscount(Map<String, Object> map){
        Long loginID = (Long) map.get("loginID");
        Long archiveID = (Long)map.get("archiveID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        //所有子订单的价格总额
        BigDecimal totalAmountAll = getTotalAmountAll(subOrderIDList);
        map.put("discountType", ProductManageEnum.DiscountType.FULLDISCOUNT.getValue());
        //根据子订单ID和折扣类别查询订单折扣信息
        O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingDao.queryDiscountInfoByOrderIDAndDiscountType(map);
        if (o_orderDiscountMappingEntity != null) {
            BigDecimal discountAmount = o_orderDiscountMappingEntity.getDiscountAmount();
            if (discountAmount == null){
                discountAmount = BigDecimal.ZERO;
            }
            Float discountPercentage = o_orderDiscountMappingEntity.getDiscountPercentage();
            if (discountPercentage == null){
                throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
            }
            BigDecimal discountAmountNew = totalAmountAll.subtract(totalAmountAll.multiply(new BigDecimal(discountPercentage)).setScale(2, BigDecimal.ROUND_HALF_UP));
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
    private void updateFreeService(Map<String, Object> map) throws Exception{
        Long loginID = (Long) map.get("loginID");
        Long archiveID = (Long)map.get("archiveID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        //所有子订单的服务费总额
        BigDecimal serviceFeeAll = BigDecimal.ZERO;
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            O_SubOrderInfoEntity o_subOrderInfo = getSubOrderInfo(subOrderID);
            if (o_subOrderInfo == null){
                throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
            }
            BigDecimal totalAmount = o_subOrderInfo.getTotalAmount();
            Integer peopleNum = o_subOrderInfo.getPeopleNum();
            //获取商家设置的服务费
            BigDecimal serviceFee = merchantFeeInfoService.getMerchantFee(archiveID, subOrderIDList);
            serviceFeeAll = serviceFeeAll.add(serviceFee);
        }
        map.put("discountType", ProductManageEnum.DiscountType.FREE_SERVICE.getValue());
        //根据子订单ID和折扣类别查询订单折扣信息
        O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingDao.queryDiscountInfoByOrderIDAndDiscountType(map);
        if (o_orderDiscountMappingEntity != null) {
            BigDecimal discountAmount = o_orderDiscountMappingEntity.getDiscountAmount();
            if (discountAmount == null){
                discountAmount = BigDecimal.ZERO;
            }
            if (discountAmount.compareTo(serviceFeeAll) != 0){
                o_orderDiscountMappingEntity.setDiscountAmount(serviceFeeAll);
                o_orderDiscountMappingDao.updateByPrimaryKeySelective(o_orderDiscountMappingEntity);
            }
        }
    }

    /**
     * 更新减免
     * chenkangyi
     * 2017-6-13 15:41
     */
    private void updateReduceAmount(Map<String, Object> map,Long discountType) throws Exception{
        Long loginID = (Long) map.get("loginID");
        Long archiveID = (Long)map.get("archiveID");
        String subOrderIDs = (String) map.get("subOrderIDs");
        if (subOrderIDs == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<Long> subOrderIDList = splitSubOrderID(subOrderIDs);
        //所有子订单的价格总额
        BigDecimal totalAmountAll = getTotalAmountAll(subOrderIDList);
        map.put("discountType", discountType);
        //根据订单ID和折扣类别查询订单折扣信息
        O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = o_orderDiscountMappingDao.queryDiscountInfoByOrderIDAndDiscountType(map);
        if (o_orderDiscountMappingEntity != null) {
            BigDecimal discountAmount = o_orderDiscountMappingEntity.getDiscountAmount();
            if (discountAmount == null) {
                discountAmount = BigDecimal.ZERO;
            }
            if (discountAmount.compareTo(totalAmountAll) == 1){
                //根据订单ID和折扣类别删除订单折扣信息
                o_orderDiscountMappingDao.deleteOrderDiscountMappingByOrderIDAndDiscountType(map);
            }
        }
    }

    /**
     * 获取已减免金额
     * chenkangyi
     * 2017-6-13 17:21
     */
    private BigDecimal getHasReduceAmount(Map<String, Object> map){
        BigDecimal discountAmount = BigDecimal.ZERO;
        O_OrderDiscountMappingEntity o_orderDiscountMapping = o_orderDiscountMappingDao.queryDiscountInfoByOrderIDAndDiscountType(map);
        if (o_orderDiscountMapping != null){
            discountAmount = o_orderDiscountMapping.getDiscountAmount();
        }
        /*for (int i = 0; i < subOrderIDList.size(); i++) {
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
        }*/
        return discountAmount;
    }

    /**
     * 插入或更新订单折扣信息
     * chenkangyi
     * 2017-5-21 18:21
     */
    private void insertOrUpdateOrderDiscountMapping(BigDecimal totalAmountAll, Long orderID, Long businessType, Long discountType, Boolean isRatio, Float discountPercentage, String discountAmount, Long loginID, String memo) {
        Map<String, Object> map = new HashMap<>();
        //map.put("discountType", discountType);
        map.put("orderID", orderID);
        map.put("businessType", businessType);
        //根据子订单ID和折扣类别查询订单折扣信息
        O_OrderDiscountMappingEntity o_orderDiscountMapping = o_orderDiscountMappingDao.queryDiscountInfoByOrderIDAndDiscountType(map);
            if (o_orderDiscountMapping == null) {
                insertOrderDiscountMapping(totalAmountAll, orderID,businessType, discountType, isRatio, discountPercentage, discountAmount, loginID, memo);
            } else {
                throw new BizException(CodeMsgConstants.DISCOUNT_EXIST_CODE, CodeMsgConstants.DISCOUNT_EXIST_MSG);
                //updateOrderDiscountMapping(totalAmountAll, o_orderDiscountMapping, orderID,businessType, discountType, isRatio, discountPercentage, discountAmount, loginID, memo);
            }
    }

    /**
     * 插入订单折扣信息
     * chenkangyi
     * 2017-6-6 14:21
     */
    private void insertOrderDiscountMapping(BigDecimal totalAmountAll, Long orderID, Long businessType, Long discountType, Boolean isRatio, Float discountPercentage, String discountAmount, Long loginID, String memo) {
        O_OrderDiscountMappingEntity o_orderDiscountMappingEntity = new O_OrderDiscountMappingEntity();
        Long mappingID = MaxIDUtils.getID(O_OrderDiscountMappingEntity.class);
        o_orderDiscountMappingEntity.setMappingID(mappingID);
        if(businessType == FinancialManageEnum.FundChangeBusinessType.ORDER.getValue()){
            o_orderDiscountMappingEntity.setOrderID(orderID);
        }else if (businessType == FinancialManageEnum.FundChangeBusinessType.SUBORDERINFO.getValue()){
            o_orderDiscountMappingEntity.setMappingOrderID(orderID);
        }else {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        o_orderDiscountMappingEntity.setIsRatio(isRatio);
        o_orderDiscountMappingEntity.setIsManualProcess(true);
        o_orderDiscountMappingEntity.setDiscountType(discountType);
        if (isRatio) {  //是否比率,true按折扣比率计算,false按减免金额计算
            o_orderDiscountMappingEntity.setDiscountPercentage(discountPercentage/10);
            o_orderDiscountMappingEntity.setDiscountAmount(totalAmountAll.subtract(totalAmountAll.multiply(new BigDecimal(discountPercentage / 10)).setScale(2, BigDecimal.ROUND_HALF_UP)));
        } else {
            o_orderDiscountMappingEntity.setDiscountAmount(new BigDecimal(discountAmount));
        }

        o_orderDiscountMappingEntity.setLoginID(loginID);
        o_orderDiscountMappingEntity.setMemo(memo);
        o_orderDiscountMappingEntity.setCreatorID(loginID);
        o_orderDiscountMappingEntity.setCreateTime(LocalDateTime.now());
        o_orderDiscountMappingDao.insertSelective(o_orderDiscountMappingEntity);
    }

    /**
     * 更新订单折扣信息
     * chenkangyi
     * 2017-6-6 14:21
     */
    private void updateOrderDiscountMapping(BigDecimal totalAmountAll, O_OrderDiscountMappingEntity o_orderDiscountMappingEntity, Long orderID, Long businessType, Long discountType, Boolean isRatio, Float discountPercentage, String discountAmount, Long loginID, String memo) {
        o_orderDiscountMappingEntity.setIsRatio(isRatio);
        o_orderDiscountMappingEntity.setIsManualProcess(true);
        o_orderDiscountMappingEntity.setDiscountType(discountType);
        if (isRatio) {  //是否比率,true按折扣比率计算,false按减免金额计算
            o_orderDiscountMappingEntity.setDiscountPercentage(discountPercentage/10);
            o_orderDiscountMappingEntity.setDiscountAmount(totalAmountAll.subtract(totalAmountAll.multiply(new BigDecimal(discountPercentage / 10)).setScale(2, BigDecimal.ROUND_HALF_UP)));
        } else {
            o_orderDiscountMappingEntity.setDiscountPercentage(null);
            o_orderDiscountMappingEntity.setDiscountAmount(new BigDecimal(discountAmount));
        }
        o_orderDiscountMappingEntity.setMemo(memo);
        o_orderDiscountMappingEntity.setLoginID(loginID);
        o_orderDiscountMappingEntity.setCreateTime(LocalDateTime.now());
        o_orderDiscountMappingDao.updateByPrimaryKey(o_orderDiscountMappingEntity);

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
        if (discountPercentage < highestRate || discountPercentage > 10f) {
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
     * @version 2.0.0
     * @description 获取所有子订单能打折的总金额
     * @time 2017-6-4 18:11
     */
    public BigDecimal getTotalAmountCanDiscountAll(List<Long> subOrderIDList, BigDecimal paidAmount) {
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
     * @description 获取所有子订单的总金额
     * @time 2017-6-15 110:11
     */
    public BigDecimal getTotalAmountAll(List<Long> subOrderIDList) {
        //获取所有子订单的总额
        BigDecimal totalAmountAll = new BigDecimal(0);
        for (int i = 0; i < subOrderIDList.size(); i++) {
            Long subOrderID = subOrderIDList.get(i);
            O_SubOrderInfoEntity o_subOrderInfo = getSubOrderInfo(subOrderID);
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
        //获取订单金额情况，map需要参数subOrderIDList，archiveID，loginID
        AmountSituationVO amountSituationVO = amountSituationService.amountSituation((List<Long>) map.get("subOrderIDList"), (Long)map.get("archiveID"),(Long)map.get("loginID"));
        Long orderID = amountSituationVO.getOrderID();
        Long businessType = amountSituationVO.getBusinessType();
        map.put("orderID", orderID);
        map.put("businessType", businessType);
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
        List<Long> subOrderIDList = (List<Long>) map.get("subOrderIDList");
        //已减免金额
        BigDecimal discountAmount = getHasReduceAmount(map);
        //抹零金额
        BigDecimal droptailAmount = amountSituationVO.getDroptailAmount();
        if (droptailAmount == null) {
            droptailAmount = new BigDecimal(0);
        }
        //计算应收金额+抹零 +本单已减免金额
        BigDecimal amountSum = payableAmount.add(droptailAmount).add(discountAmount);
        return amountSum;
    }

    /**
     * @author chenkangyi
     * @version 2.0.0
     * @description 插入订单处理信息
     * @time 2017-6-17 17:47
     */
    private void insertOrderDealInfo(Map<String, Object> map){
        O_OrderDealInfoEntity o_orderDealInfoEntity = new O_OrderDealInfoEntity();
        o_orderDealInfoEntity.setDealID(MaxIDUtils.getID(O_OrderDealInfoEntity.class));
        o_orderDealInfoEntity.setSubOrderID((Long)map.get("subOrderID"));
        o_orderDealInfoEntity.setOrderID((Long)map.get("orderID"));
        o_orderDealInfoEntity.setChangeAmount((BigDecimal)map.get("changeAmount"));
        o_orderDealInfoEntity.setBeforeAmount((BigDecimal)map.get("beforeAmount"));
        o_orderDealInfoEntity.setAfterAmount((BigDecimal)map.get("afterAmount"));
        o_orderDealInfoEntity.setCreatorID((Long) map.get("loginID"));
        o_orderDealInfoEntity.setCreateTime(LocalDateTime.now());
        o_orderDealInfoEntity.setDealDesc((String)map.get("dealDesc"));
        o_orderDealInfoDao.insertSelective(o_orderDealInfoEntity);
    }

}
