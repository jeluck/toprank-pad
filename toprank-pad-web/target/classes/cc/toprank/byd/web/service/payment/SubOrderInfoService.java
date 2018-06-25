package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.component.PrintComponent;
import cc.toprank.byd.component.ProductComponent;
import cc.toprank.byd.component.TableComponent;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.CommonManageEnum;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.util.EnumUtil;
import cc.toprank.byd.vo.print.ProductDetailVO;
import cc.toprank.byd.vo.print.SettleInfoVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.service.table.B_DinningTableInfoService;
import cc.toprank.byd.web.vo.paymentvo.AmountSituationVO;
import cc.toprank.byd.web.vo.paymentvo.ValidateProductVO;
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
 * 子订单信息
 * Created by HuangCY on 2017-5-2.
 */
@Service("subOrderInfoService")
public class SubOrderInfoService {

    //子订单信息
    @Autowired
    private O_SubOrderInfoDao o_SubOrderInfoDao;
    //订单信息
    @Autowired
    private O_OrderInfoDao o_OrderInfoDao;
    //订单明细信息
    @Autowired
    private O_OrderDetailInfoDao o_OrderDetailInfoDao;
    //桌台组件
    @Autowired
    private TableComponent tableComponent;
    //桌台信息
    @Autowired
    private B_DinningTableInfoService b_DinningTableInfoService;
    //金额情况
    @Autowired
    private AmountSituationService amountSituationService;
    //商品规格
    @Autowired
    private P_VariantSpecificationMappingDao variantSpecificationMappingDao;
    //订单处理信息
    @Autowired
    private OrderDealInfoService orderDealInfoService;
    //打印组件
    @Autowired
    private PrintComponent printComponent;

    @Autowired
    private B_DinningTableInfoDao dinningTableInfoDao;

    @Autowired
    private B_ShopAreaInfoDao shopAreaInfoDao;

    @Autowired
    private B_MealsInfoDao mealsInfoDao;

    @Autowired
    private O_OrderDiscountMappingDao orderDiscountMappingDao;

    @Autowired
    private ProductComponent productComponent;
    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据子订单编号改变子订单折扣金额和实际金额
     * @time 2017-4-10 14:31
     */
    @Transactional
    public void updateAmountByID(long subOrderID, long orderID, double discountAmount, double totalAmount) throws Exception {
        //折扣金额
        BigDecimal discountAmount2 = new BigDecimal(0);

        //改变子订单金额
        if (subOrderID > 0) {
            O_SubOrderInfoEntity entity = new O_SubOrderInfoEntity();
            //子订单编号
            entity.setSubOrderID(subOrderID);

            //根据子订单编号查询子订单信息
            O_SubOrderInfoEntity entity2 = o_SubOrderInfoDao.querySubOrderInfoBySubOrderID(subOrderID);

            discountAmount2 = entity2.getDiscountAmount();

            //此单已经有过折扣
            if (null != discountAmount2 && discountAmount2.compareTo(BigDecimal.ZERO) == 1) {
                //计算后的折扣金额
                discountAmount2 = entity2.getDiscountAmount().add(BigDecimal.valueOf(discountAmount));
                //折扣金额
                entity.setDiscountAmount(discountAmount2);

                //如果总额减去折扣金额大于0才相减求出实际金额，否则直接置为0
                if (totalAmount - discountAmount2.doubleValue() > 0) {
                    //实际金额 = 总额 - 折扣金额
                    entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(discountAmount2));
                } else {
                    entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(BigDecimal.valueOf(totalAmount)));
                }
            } else {
                discountAmount2 = BigDecimal.valueOf(discountAmount);
                //折扣金额
                entity.setDiscountAmount(discountAmount2);

                //如果总额减去折扣金额大于0才相减求出实际金额，否则直接置为0
                if (totalAmount - discountAmount2.doubleValue() > 0) {
                    //实际金额 = 总额 - 折扣金额
                    entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(discountAmount2));
                } else {
                    entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(BigDecimal.valueOf(totalAmount)));
                }
            }

            o_SubOrderInfoDao.updateAmountByID(entity);
        }

        //改变订单金额
        if (orderID > 0) {
            O_OrderInfoEntity entity = new O_OrderInfoEntity();
            //设置订单编号
            entity.setOrderID(orderID);

            //根据订单编号查询
            O_OrderInfoEntity entity2 = o_OrderInfoDao.queryOrderInfoByOrderID(orderID);

            discountAmount2 = entity2.getDiscountAmount();

            //此单已经有过折扣
            if (null != discountAmount2) {
                //计算后的折扣金额
                discountAmount2 = entity2.getDiscountAmount().add(BigDecimal.valueOf(discountAmount));
                //折扣金额
                entity.setDiscountAmount(discountAmount2);

                //如果总额减去折扣金额大于0才相减求出实际金额，否则直接置为0
                if (totalAmount - discountAmount2.doubleValue() > 0) {
                    //实际金额 = 总额 - 折扣金额
                    entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(discountAmount2));
                } else {
                    entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(BigDecimal.valueOf(totalAmount)));
                }
            } else {
                discountAmount2 = BigDecimal.valueOf(discountAmount);
                //折扣金额
                entity.setDiscountAmount(discountAmount2);

                //如果总额减去折扣金额大于0才相减求出实际金额，否则直接置为0
                if (totalAmount - discountAmount2.doubleValue() > 0) {
                    //实际金额 = 总额 - 折扣金额
                    entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(discountAmount2));
                } else {
                    entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(BigDecimal.valueOf(totalAmount)));
                }
            }

            o_OrderInfoDao.updateAmountByOrderID(entity);
        }
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 暂结/取消暂结
     * @time 2017-5-2 11:22
     */
    @Transactional
    public void temporarily(List<Long> subOrderIDList) throws Exception {
        for (int i = 0; i < subOrderIDList.size(); i++) {
            //桌台状态
            Long tableStatus = null;

            //根据子订单ID查询子订单信息
            O_SubOrderInfoEntity befSubOrderInfoEntity = o_SubOrderInfoDao.querySubOrderInfoBySubOrderID(subOrderIDList.get(i));

            // 设置子订单处理前状态
            Long befOrderStatus = befSubOrderInfoEntity.getOrderStatus();

            O_SubOrderInfoEntity subOrderSetParamsEntity = new O_SubOrderInfoEntity();

            subOrderSetParamsEntity.setSubOrderID(subOrderIDList.get(i));

            //订单状态为待结账，说明订单已经暂结，则执行取消暂结
            if (null != befSubOrderInfoEntity && befSubOrderInfoEntity.getOrderStatus() == OrderManageEnum.OrderStatus.TOBECHECKED.getValue()) {
                subOrderSetParamsEntity.setOrderStatus(OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
                subOrderSetParamsEntity.setPayStatus(OrderManageEnum.PayStatus.WAITINGPAY.getValue());
                tableStatus = MerchantManageEnum.TableStatus.PLACEMAN.getValue();
            }
            //订单状态不为待结账，说明订单还未暂结，则执行暂结
            if (null != befSubOrderInfoEntity && befSubOrderInfoEntity.getOrderStatus() != OrderManageEnum.OrderStatus.TOBECHECKED.getValue()) {
                subOrderSetParamsEntity.setOrderStatus(OrderManageEnum.OrderStatus.TOBECHECKED.getValue());
                tableStatus = MerchantManageEnum.TableStatus.STOPTABLE.getValue();

                //暂结打印暂结单
                try {
                    printSettleTicket(befSubOrderInfoEntity);
                }catch (Exception e){
                    //打印暂结单失败,不影响暂结操作
                }
            }

            B_DinningTableInfoEntity dinningTableSetParamsEntity = new B_DinningTableInfoEntity();

            dinningTableSetParamsEntity.setTableID(befSubOrderInfoEntity.getTableID());
            dinningTableSetParamsEntity.setTableStatus(tableStatus);

            //根据桌台ID改变桌台状态
            b_DinningTableInfoService.updateTableStatusByTableID(dinningTableSetParamsEntity);

//            B_DinningTableInfoEntity dinningTableInfoEntity = new B_DinningTableInfoEntity();
//
//            dinningTableInfoEntity.setTableID(befSubOrderInfoEntity.getTableID());
//
//            //根据桌台ID找到与其联台的其他桌子ID
//            Set<Long> tableIDs = tableComponent.getCombinedTableIDs(dinningTableInfoEntity);
//            if (tableIDs.size() > 0) {
//                Iterator<Long> it = tableIDs.iterator();
//                while (it.hasNext()) {
//                    Long tableID = it.next();
//
//                    B_DinningTableInfoEntity dinningTableSetParamsEntity2 = new B_DinningTableInfoEntity();
//
//                    dinningTableSetParamsEntity2.setTableID(tableID);
//                    dinningTableSetParamsEntity2.setTableStatus(tableStatus);
//
//                    //根据桌台ID改变桌台状态
//                    b_DinningTableInfoService.updateTableStatusByTableID(dinningTableSetParamsEntity2);
//                }
//            }

            o_SubOrderInfoDao.updateStatusBySubOrderID(subOrderSetParamsEntity);

            Map subOrderMap = new HashMap();
            subOrderMap.put("subOrderID", subOrderIDList.get(i));
            subOrderMap.put("befSubOrderStatus", befOrderStatus);

            // 新增子订单处理信息
            orderDealInfoService.addOrderDealInfo(subOrderMap);

            // 根据订单编号查询子订单信息
            List<O_SubOrderInfoEntity> subOrderInfoEntityList = o_SubOrderInfoDao.queryByOrderID(befSubOrderInfoEntity.getOrderID());

            boolean isComplete = true;
            for (int k = 0; k < subOrderInfoEntityList.size(); k++) {
                // 如果同一个订单的子订单的订单状态不为待结账，那么就不改变订单信息
                if (null == subOrderInfoEntityList.get(k).getOrderStatus() || subOrderInfoEntityList.get(k).getOrderStatus() != OrderManageEnum.OrderStatus.TOBECHECKED.getValue()) {
                    isComplete = false;
                }
            }

            // 子订单全部为待结账
            if (isComplete) {
                // 根据订单编号查询订单信息
                O_OrderInfoEntity orderInfoEntity = o_OrderInfoDao.queryOrderInfoByOrderID(befSubOrderInfoEntity.getOrderID());

                // 订单处理前状态
                Long beforeOrderStatus = orderInfoEntity.getOrderStatus();

                O_OrderInfoEntity orderParamsEntity = new O_OrderInfoEntity();

                orderParamsEntity.setOrderID(orderInfoEntity.getOrderID());
                orderParamsEntity.setOrderStatus(OrderManageEnum.OrderStatus.TOBECHECKED.getValue());

                //根据订单编号改变订单状态
                o_OrderInfoDao.updateOrderInfoStatus(orderParamsEntity);

                Map orderMap = new HashMap();
                orderMap.put("orderID", befSubOrderInfoEntity.getOrderID());
                orderMap.put("befOrderStatus", beforeOrderStatus);

                // 新增订单处理信息
                orderDealInfoService.addOrderDealInfo(orderMap);
            }
        }
    }

    /**
     * @author ZhaoLingchen
     * @version 1.0.0
     * @description 打印暂结单
     * @time 2017-6-9 10:00
     */
    public void printSettleTicket(O_SubOrderInfoEntity subOrderInfoEntity) throws Exception{
        // 根据订单编号查询订单信息
        O_OrderInfoEntity orderInfoEntity = o_OrderInfoDao.selectByPrimaryKey(subOrderInfoEntity.getOrderID());
        //查询桌台信息
        B_DinningTableInfoEntity dinningTableInfoEntity = dinningTableInfoDao.selectByPrimaryKey(subOrderInfoEntity.getTableID());
        //查询区域信息
        B_ShopAreaInfoEntity shopAreaInfoEntity = shopAreaInfoDao.selectByPrimaryKey(dinningTableInfoEntity.getAreaID());
        //查询餐次信息
        B_MealsInfoEntity mealsInfoEntity = mealsInfoDao.selectByPrimaryKey(subOrderInfoEntity.getMealsID());

        // 查询赠送金额,查询抹零,查询减免,查询服务费
        Map<String,List<Long>> subOrderIDMap = new HashMap<>();
        List<Long> subOrderIDList = new ArrayList<>();
        subOrderIDMap.put("subOrderIDList",subOrderIDList);
        AmountSituationVO amountSituation = amountSituationService.amountSituation(subOrderIDList , null , null);

        SettleInfoVO settleInfo = new SettleInfoVO();
        settleInfo.setBusinessID(subOrderInfoEntity.getSubOrderID());
        settleInfo.setBusinessType(CommonManageEnum.BusinessType.SUBORDER.getValue());
//        settleInfo.setOperatorID();// 操作ID
        settleInfo.setArchiveID(subOrderInfoEntity.getArchiveID());
        settleInfo.setArea(shopAreaInfoEntity.getAreaName());//区域名称
        settleInfo.setMeals(mealsInfoEntity.getMealName());
        settleInfo.setTable(subOrderInfoEntity.getTableName());
//        settleInfo.setTargetTable();// 目标桌台
//        settleInfo.setrelationTables(); // 相关餐台
        settleInfo.setPeopleNum(subOrderInfoEntity.getPeopleNum());
        settleInfo.setOrderNo(orderInfoEntity.getOrderCode());
//        settleInfo.setwaiter();
        settleInfo.setOperationTime(LocalDateTime.now());
//        settleInfo.setoperator();// 操作人
//        settleInfo.setbarCode(); // 条形码
        settleInfo.setTotalQuantity(subOrderInfoEntity.getQuantity());

        if (subOrderInfoEntity.getPayStatus() != null && subOrderInfoEntity.getPayStatus() > 0){
            settleInfo.setPayStatus(EnumUtil.getEnumNmae(OrderManageEnum.PayStatus.class,subOrderInfoEntity.getPayStatus()));
        }
        settleInfo.setTotalAmount(amountSituation.getTotalAmount());//消费金额
        settleInfo.setGiveAmount(amountSituation.getGiveProductAmount());//赠送金额
        settleInfo.setDiscountAmount(amountSituation.getDiscountAmount());//折扣金额

//        settleInfo.setDiscountAuthor();//折扣人
        settleInfo.setDiscountAmount(amountSituation.getDiscountAmount());;//折扣金额
        settleInfo.setReduceAmount(amountSituation.getReductionAmount());// 减免金额
        settleInfo.setReduceAuthor(amountSituation.getReductionPerson());// 减免人
        settleInfo.setServiceAmount(amountSituation.getServiceFee());//服务费
        settleInfo.setSmallAmount(amountSituation.getDroptailAmount());// 抹零
        settleInfo.setActualAmount(amountSituation.getPayableAmount());//应收金额

        settleInfo.setRemark(subOrderInfoEntity.getMemo());
        settleInfo.setStartTime(subOrderInfoEntity.getCreateTime());
        settleInfo.setOrderTime(subOrderInfoEntity.getCreateTime());

        List<Long> detailIDs = o_OrderDetailInfoDao.getDetailIDBySubOrderID(subOrderInfoEntity.getSubOrderID());

        List<ProductDetailVO> details = productComponent.getPrintProductDetailList(detailIDs);

        printComponent.printSettleTicket(settleInfo,details);
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 结账前验证 是否存在等叫商品和未称重商品
     * @time 2017-5-2 14:48
     */
    public ValidateProductVO validateProduct(List<Long> subOrderList) throws Exception {
        //根据子订单ID集合查询子订单信息集合
        List<O_SubOrderInfoEntity> subOrderInfoList = o_SubOrderInfoDao.querySubOrderInfoByIDs(subOrderList);

        ValidateProductVO result = new ValidateProductVO();

        boolean isPaid = true;

        //验证订单状态和支付状态是否为已结账
        for(int i = 0 ; i < subOrderInfoList.size() ; i++){
            if(!subOrderInfoList.get(i).getOrderStatus().equals(OrderManageEnum.OrderStatus.COMPLETED.getValue()) || !subOrderInfoList.get(i).getPayStatus().equals(OrderManageEnum.PayStatus.HASPAID.getValue())){
                isPaid = false;
            }
        }

        //未结账才可以进入结账
        if(!isPaid){
            List<O_OrderDetailInfoEntity> resultList = new ArrayList<>();

            boolean flag = true;

            for (int i = 0; i < subOrderList.size(); i++) {
                if (flag) {
                    O_OrderDetailInfoEntity orderDetailSetParamsEntity = new O_OrderDetailInfoEntity();

                    orderDetailSetParamsEntity.setSubOrderID(subOrderList.get(i));
                    orderDetailSetParamsEntity.setProduceStatus(OrderManagerEnum.ProductionStatus.PENDINGWEIGH.getValue());

                    List<O_OrderDetailInfoEntity> orderDetailInfoEntity = o_OrderDetailInfoDao.queryBySubOrderIDAndProduceStatus(orderDetailSetParamsEntity);

                    //不为空，说明有未称重商品
                    if (null != orderDetailInfoEntity && orderDetailInfoEntity.size() > 0) {
                        //追加规格名称
                        orderDetailInfoEntity = appendOptionName(orderDetailInfoEntity);

                        result.setCode(CodeMsgConstants.VALIDATE_PRODUCT_PENDINGWEIGH);
                        result.setMessage(CodeMsgConstants.VALIDATE_PRODUCT_PENDINGWEIGH_MSG);
                        resultList.addAll(orderDetailInfoEntity);
                    }
                }

                //循环结束，还没有找到未称重商品，那么就开始找等叫商品
                if (i == subOrderList.size() - 1 || flag == false) {
                    if (resultList.size() == 0) {
                        //重新循环
                        if (i == subOrderList.size() - 1) {
                            i = 0;
                        }

                        flag = false;

                        O_OrderDetailInfoEntity orderDetailSetParamsEntity = new O_OrderDetailInfoEntity();

                        orderDetailSetParamsEntity.setSubOrderID(subOrderList.get(i));
                        orderDetailSetParamsEntity.setProduceStatus(OrderManagerEnum.ProductionStatus.SOCALLED.getValue());

                        List<O_OrderDetailInfoEntity> orderDetailInfoEntity = o_OrderDetailInfoDao.queryBySubOrderIDAndProduceStatus(orderDetailSetParamsEntity);

                        //不为空，说明有等叫商品
                        if (null != orderDetailInfoEntity && orderDetailInfoEntity.size() > 0) {
                            //追加规格名称
                            orderDetailInfoEntity = appendOptionName(orderDetailInfoEntity);

                            result.setCode(CodeMsgConstants.VALIDATE_PRODUCT_SOCALLED);
                            result.setMessage(CodeMsgConstants.VALIDATE_PRODUCT_SOCALLED_MSG);
                            resultList.addAll(orderDetailInfoEntity);
                        }
                    }
                }
            }

            //不存在等叫和未称重商品，验证通过
            if (null == result.getMessage() && result.getCode() == 0) {
                result.setCode(CodeMsgConstants.SUCCESS);
                result.setMessage(CodeMsgConstants.SUCCESS_MSG);
            }

            //去掉重复的商品记录
            if(!resultList.isEmpty() && resultList.size() > 0){
                for(int i = 1 ; i < resultList.size() ; i++){
                    for(int j = 0 ; j < resultList.size() - i ; j++){
                        if(null != resultList.get(j).getOptionName()){
                            //变体ID相同、规格相同、商品名称相同则判定为重复的商品记录
                            if(resultList.get(j).getVariantID().equals(resultList.get(j + 1).getVariantID()) &&
                                    resultList.get(j).getOptionName().equals(resultList.get(j + 1).getOptionName()) &&
                                    resultList.get(j).getProductName().equals(resultList.get(j + 1).getProductName())){
                                //移除重复的菜品
                                resultList.remove(j);
                                j--;
                            }
                        }else{
                            //变体ID相同、商品名称相同则判定为重复的商品记录
                            if(resultList.get(j).getVariantID().equals(resultList.get(j + 1).getVariantID()) &&
                                    resultList.get(j).getProductName().equals(resultList.get(j + 1).getProductName())){
                                //移除重复的菜品
                                resultList.remove(j);
                                j--;
                            }
                        }
                    }
                }
            }

            result.setResultList(resultList);
        }else {
            throw new BizException(CodeMsgConstants.ORDER_IS_PAID,CodeMsgConstants.ORDER_IS_PAID_MSG);
        }



        return result;
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 追加商品规格
     * @time 2017-5-19 17:55
     */
    private List<O_OrderDetailInfoEntity> appendOptionName(List<O_OrderDetailInfoEntity> orderDetailInfoEntity) {
        for (O_OrderDetailInfoEntity orderDetail : orderDetailInfoEntity) {
            if (null != orderDetail.getVariantID() && null != orderDetail.getOptionID()) {
                P_VariantSpecificationMappingEntity variantSpecificationParam = new P_VariantSpecificationMappingEntity();

                variantSpecificationParam.setVariantID(orderDetail.getVariantID());
                variantSpecificationParam.setOptionID(orderDetail.getOptionID());

                //根据选项ID、变体ID查询规格信息
                P_VariantSpecificationMappingEntity variantSpecificationMapping = variantSpecificationMappingDao.getVariantSpecificationMappingByVariantIDAndOptionID(variantSpecificationParam);

                //规格名称
                orderDetail.setOptionName(variantSpecificationMapping.getOptionName());
            }
        }

        return orderDetailInfoEntity;
    }
}
