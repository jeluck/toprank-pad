package cc.toprank.byd.component;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.BooleanUtil;
import cc.toprank.byd.common.utils.ObjectUtil;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.util.CollectionHelper;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.vo.print.ProductDetailVO;
import cc.toprank.byd.vo.print.TableInfoVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.vo.product.ProductWeightRequestVo;
import cc.toprank.byd.web.vo.product.ProductWeightVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * 订单组件
 *
 * @author LinYN
 * @date 2017-5-6
 */
@Component
public class OrderComponent implements ParamConstants.OrderParam {

    // 日志打印
    private static final Logger logger = LoggerFactory.getLogger(OrderComponent.class);

    @Autowired
    private B_MerchantMenuInfoDao merchantMenuInfoDao;
    @Autowired
    private P_CategoryAttributeValueInfoDao categoryAttributeValueInfoDao;
    @Autowired
    private P_ProductDesignerMappingDao productDesignerMappingDao;
    @Autowired
    private O_OrderInfoDao orderInfoDao;
    @Autowired
    private O_SubOrderInfoDao subOrderInfoDao;
    @Autowired
    private O_OrderDetailInfoDao orderDetailInfoDao;
    @Autowired
    private O_OrderDealInfoDao orderDealInfoDao;
    @Autowired
    private P_VariantSpecificationMappingDao variantSpecificationMappingDao;
    @Autowired
    private B_DesignerMonitorInfoDao designerMonitorInfoDao;
    @Autowired
    private TableComponent tableComponent;
    @Autowired
    private ProductInfoDao productInfoDao;
    @Autowired
    private PrintComponent printComponent;
    @Autowired
    private O_BookingInfoDao bookingDao;

    /**
     * 获取商户菜单信息
     *
     * @param menuID 菜单编号
     * @return 商户菜单信息
     * @author LinYN
     * @date 2017-4-19
     */
    public B_MerchantMenuInfoEntity getMerchantMenuInfo(Long menuID) {
        if (menuID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        B_MerchantMenuInfoEntity menuInfoQueryParam = new B_MerchantMenuInfoEntity();
        menuInfoQueryParam.setMenuID(menuID);
        B_MerchantMenuInfoEntity menuInfoEntity = merchantMenuInfoDao.get(menuInfoQueryParam);
        if (menuInfoEntity == null) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        return menuInfoEntity;
    }

    /**
     * 根据订单编号获取主订单
     *
     * @param orderID 订单编号
     * @return 主订单
     * @author LinYN
     * @date 2017-5-6
     */
    public O_OrderInfoEntity getOrderInfoByOrderID(Long orderID) {
        if (orderID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        O_OrderInfoEntity orderParam = new O_OrderInfoEntity();
        orderParam.setOrderID(orderID);
        O_OrderInfoEntity order = orderInfoDao.get(orderParam);
        if (order == null) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        return order;
    }

    /**
     * 根据订单明细编号获取订单明细信息
     *
     * @param orderDetailID 订单明细编号
     * @return 订单明细信息
     * @author LinYN
     * @date 2017-5-6
     */
    public O_OrderDetailInfoEntity getOrderDetailInfoByID(Long orderDetailID) {
        if (orderDetailID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        O_OrderDetailInfoEntity orderDetailParam = new O_OrderDetailInfoEntity();
        orderDetailParam.setDetailID(orderDetailID);
        O_OrderDetailInfoEntity orderDetailInfoEntity = orderDetailInfoDao.get(orderDetailParam);
        if (orderDetailInfoEntity == null) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        return orderDetailInfoEntity;
    }

    /**
     * 获取订单明细中菜品的做法加价
     *
     * @param orderDetailInfo 订单明细信息
     * @return 订单明细中菜品的做法加价
     * @author LinYN
     * @date 2017-5-6
     */
    public BigDecimal getAttributeAddedPrice(O_OrderDetailInfoEntity orderDetailInfo) {
        BigDecimal addedPrice = new BigDecimal(0);
        Long variantID = orderDetailInfo.getVariantID();
        if (variantID == null) {
            return addedPrice;
        }
        //做法和口味附加价
        String valueIDs = orderDetailInfo.getValueIDs();
        if (StringUtils.isNotEmpty(valueIDs)) {
            List<P_CategoryAttributeValueInfoEntity> categoryAttributeValues = categoryAttributeValueInfoDao.getCategoryAttributeValuesByIDs(valueIDs);
            addedPrice = CollectionHelper.sum(categoryAttributeValues, attributeValue -> attributeValue.getAddedPrice());
        }
        return addedPrice;
    }

    /**
     * 获取订单明细中菜品的规格加价
     *
     * @param orderDetailInfo 订单明细信息
     * @return 订单明细中菜品的规格加价
     * @author LinYN
     * @date 2017-5-6
     */
    public BigDecimal getSpecificationAddedPrice(O_OrderDetailInfoEntity orderDetailInfo) {
        BigDecimal addedPrice = new BigDecimal(0);
        Long variantID = orderDetailInfo.getVariantID();
        if (variantID == null) {
            return addedPrice;
        }
        //规格加价
        Long optionID = orderDetailInfo.getOptionID();
        if (optionID != null) {
            P_VariantSpecificationMappingEntity variantSpecificationParam = new P_VariantSpecificationMappingEntity();
            variantSpecificationParam.setVariantID(variantID);
            variantSpecificationParam.setOptionID(optionID);
            P_VariantSpecificationMappingEntity variantSpecificationMapping = variantSpecificationMappingDao.getVariantSpecificationMappingByVariantIDAndOptionID(variantSpecificationParam);
            if (variantSpecificationMapping != null) {
                addedPrice = variantSpecificationMapping.getFare();
            }
        }
        return addedPrice;
    }

    /**
     * 获取订单明细中菜品的厨师加工费
     *
     * @param orderDetailInfo 订单明细信息
     * @return 订单明细中菜品的厨师加工费
     * @author LinYN
     * @date 2017-5-6
     */
    public BigDecimal getProductDesignerCost(O_OrderDetailInfoEntity orderDetailInfo) {
        //厨师附加价累加
        Long designerID = orderDetailInfo.getDesignerID();
        if (designerID == null) {
            return new BigDecimal(0);
        }
        P_ProductDesignerMappingEntity productDesignerMapping = new P_ProductDesignerMappingEntity();
        productDesignerMapping.setDesignerID(designerID);
        productDesignerMapping.setVariantID(orderDetailInfo.getVariantID());
        productDesignerMapping = productDesignerMappingDao.getDesignerInfoByVariantIDAndDesignerID(productDesignerMapping);
        if (productDesignerMapping == null) {
            return new BigDecimal(0);
        } else {
            return productDesignerMapping.getProduceCost();
        }
    }

    /**
     * @param subOrderID   子订单ID
     * @param orderID      订单ID
     * @param changeAmount 改变金额
     * @param beforeAmount 改变前金额
     * @param afterAmount  改变后金额
     * @param dealDesc     描述
     * @throws Exception
     * @Description： 新增订单处理信息
     * @Author：LanZY
     * @Time: 2017-4-6
     */
    public void saveOrderDealInfo(Long subOrderID, Long orderID, BigDecimal changeAmount,
                                  BigDecimal beforeAmount, BigDecimal afterAmount, String dealDesc) {
        O_OrderDealInfoEntity orderDealInfo = new O_OrderDealInfoEntity();
        orderDealInfo.setSubOrderID(subOrderID);
        orderDealInfo.setOrderID(orderID);
        orderDealInfo.setChangeAmount(changeAmount);
        orderDealInfo.setBeforeAmount(beforeAmount);
        orderDealInfo.setAfterAmount(afterAmount);
        orderDealInfo.setDealDesc(dealDesc);
        orderDealInfo.setIsSync(false);
        orderDealInfo.setDealID(MaxIDUtils.getID(O_OrderDealInfoEntity.class));
        orderDealInfoDao.insertSelective(orderDealInfo);
    }


    /**
     * 批量更新商品称重信息
     *
     * @param requestVo 商品称重重量信息
     * @author LinYN
     * @date 2017-5-3
     */
    public void updateProductWeight(ProductWeightRequestVo requestVo) {
        List<ProductWeightVo> productWeights = requestVo.getProductWeights();
        if (CollectionUtils.isEmpty(productWeights)) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        Set<Long> orderDetailIDs = CollectionHelper.collect(productWeights, product -> product.getOrderDetailID());
        List<O_OrderDetailInfoEntity> orderDetails = getOrderDetailInfoByIDs(requestVo.getArchiveID(), orderDetailIDs);
        if (CollectionUtils.isEmpty(orderDetails)) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        int orderCount = CollectionHelper.collect(orderDetails, (orderDetail) -> orderDetail.getOrderID()).size();
        if (orderCount > 1) {
            throw new BizException(CodeMsgConstants.MULTI_ORDER_ERROR, CodeMsgConstants.MULTI_ORDER_ERROR_MSG);
        }
        Long orderID = orderDetails.get(0).getOrderID();
        O_OrderInfoEntity order = getOrderInfoByOrderID(orderID);
        if (!ObjectUtil.equals(order.getArchiveID(), requestVo.getArchiveID())) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        List<O_SubOrderInfoEntity> subOrderInfos = subOrderInfoDao.getSubOrderInfoByOrderID(orderID);
        if (CollectionUtils.isEmpty(subOrderInfos)) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        Map<Long, O_OrderDetailInfoEntity> orderDetailMap = CollectionHelper.asMap(orderDetails, orderDetail -> orderDetail.getDetailID());
        for (ProductWeightVo productWeight : productWeights) {
            O_OrderDetailInfoEntity orderDetailInfo = orderDetailMap.get(productWeight.getOrderDetailID());
            updateOrderDetailInfoWeight(orderDetailInfo, productWeight);
        }
        // 订单ID ：订单明细列表
        Map<Long, List<O_OrderDetailInfoEntity>> orderDetailGroup = CollectionHelper.group(orderDetails, orderDetail -> orderDetail.getSubOrderID());
        for (O_SubOrderInfoEntity subOrderInfo : subOrderInfos) {
            Long subOrderID = subOrderInfo.getSubOrderID();
            BigDecimal afterAmount = CollectionHelper.sum(orderDetailGroup.get(subOrderID), orderDetail -> orderDetail.getTotalAmount());
            BigDecimal beforeAmount = subOrderInfo.getTotalAmount();
            BigDecimal addedAmount = NumberUtil.subtract(afterAmount, beforeAmount); // 可以是负数
            subOrderInfo.setTotalAmount(afterAmount);
            subOrderInfoDao.update(subOrderInfo);
            // 添加订单变更记录
            saveOrderDealInfo(subOrderID, subOrderInfo.getOrderID(), addedAmount, beforeAmount, afterAmount, "Update weight");
        }
        BigDecimal afterTotalAmount = CollectionHelper.sum(subOrderInfos, subOrder -> subOrder.getTotalAmount());
        BigDecimal beforeTotalAmount = order.getTotalAmount();
        BigDecimal addedTotalAmount = NumberUtil.subtract(afterTotalAmount, beforeTotalAmount);  // 可以是负数
        order.setTotalAmount(afterTotalAmount);
        orderInfoDao.update(order);
        // 添加订单变更记录
        saveOrderDealInfo(null, order.getOrderID(), addedTotalAmount, beforeTotalAmount, afterTotalAmount, "Update weight");
        // 打印称重单
        for (Map.Entry<Long, List<O_OrderDetailInfoEntity>> detailEntry : orderDetailGroup.entrySet()) {
            printProductWeightTicket(detailEntry.getKey(), detailEntry.getValue());
        }
    }

    private void printProductWeightTicket(Long subOrderID, List<O_OrderDetailInfoEntity> orderDetails) {
        try {
            TableInfoVO tableInfo = productInfoDao.getPrintTableBasic(subOrderID);
            List<Long> detailIDs = CollectionHelper.map(orderDetails, detail -> detail.getDetailID());
            List<ProductDetailVO> productDetails = productInfoDao.getPrintProductDetailBasic(detailIDs);
            printComponent.printProductWeightTicket(tableInfo, productDetails);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 修改单个订单明细的称重
     *
     * @param orderDetailInfo 订单明细
     * @param weightRequest       称重
     * @author LinYN
     * @date 2017-5-6
     */
    public void updateOrderDetailInfoWeight(O_OrderDetailInfoEntity orderDetailInfo, ProductWeightVo weightRequest) {
        if (orderDetailInfo == null) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        if (!OrderManagerEnum.ProductionStatus.PENDINGWEIGH.getValue().equals(orderDetailInfo.getProduceStatus())) {
            throw new BizException(CodeMsgConstants.NOT_ALLOWED_UPDATE_WEIGHT_ERROR, CodeMsgConstants.NOT_ALLOWED_UPDATE_WEIGHT_ERROR_MSG);
        }
        if (!setOrderDetailInfoByWeight(orderDetailInfo, weightRequest)) return;
        orderDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
        orderDetailInfoDao.update(orderDetailInfo);
        updateDesignerMonitorInfoByDetail(orderDetailInfo);
    }

    /**
     * 修改看板的称重、价格、制作状态
     *
     * @param orderDetailInfo 订单明细
     * @author LinYN
     * @date 2017-5-19
     */
    public void updateDesignerMonitorInfoByDetail(O_OrderDetailInfoEntity orderDetailInfo) {
        if (orderDetailInfo == null) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        Map<String, Object> updateParam = new HashMap<>();
        updateParam.put(PARAM_DETAIL_ID, orderDetailInfo.getDetailID());
        updateParam.put(PARAM_QUANTITY, orderDetailInfo.getQuantity());
        updateParam.put(PARAM_FLOAT_QUANTITY, orderDetailInfo.getFloatQuantity());
        updateParam.put(PARAM_PRICE, orderDetailInfo.getTotalAmount());
        updateParam.put(PARAM_PRODUCE_STATUS, orderDetailInfo.getProduceStatus());
        updateParam.put(PARAM_MEMO, orderDetailInfo.getMemo());
        designerMonitorInfoDao.updateDesignerMonitorInfoByDetailID(updateParam);
    }

    /**
     * 修改订单明细的称重
     *
     * @param orderDetailInfo 订单明细
     * @param weightRequest       新的称重值
     * @return true 有修改，false 未修改
     */
    public boolean setOrderDetailInfoByWeight(O_OrderDetailInfoEntity orderDetailInfo, ProductWeightVo weightRequest) {
        Float newWeight = weightRequest.getWeight();
        // 如果不是称重菜则不处理
        if (orderDetailInfo.getVariantID() == null || BooleanUtil.isFalse(orderDetailInfo.getNeedWeigh())) {
            return false;
        }
        // 如果称重值没有修改则不处理
        if (newWeight == null) {
            return false;
        }
        // 称重商品的数量
        int quantity = NumberUtil.intValue(weightRequest.getQuantity());
        if (quantity < 1) {
            return false;
        }
        Float totalNewWeight = NumberUtil.multiply(newWeight, NumberUtil.floatValue(weightRequest.getQuantity()));
        // 明细总价 = （（单价 * 重量） + 加工费 + 厨师费）* 数量 , 加工费 = 菜单中的加工费 + 属性加价 + 规格加价
        BigDecimal totalAmount = NumberUtil.multiply(orderDetailInfo.getPrice(), new BigDecimal(NumberUtil.doubleValue(totalNewWeight)));
        BigDecimal addAmount = NumberUtil.add(orderDetailInfo.getProduceCost(), orderDetailInfo.getDesignerPrice());
        addAmount = NumberUtil.multiply(addAmount, new BigDecimal(quantity));
        totalAmount = NumberUtil.add(totalAmount, addAmount);
        // 修改订单明细
        orderDetailInfo.setFloatQuantity(totalNewWeight);
        orderDetailInfo.setQuantity(quantity);
        orderDetailInfo.setTotalAmount(totalAmount);
        return true;
    }

    /**
     * 修改订单明细的数量
     *
     * @param orderDetailInfo 订单明细
     * @param quantity        新的数量
     * @return true 有修改，false 未修改
     */
    public boolean setOrderDetailInfoByQuantity(O_OrderDetailInfoEntity orderDetailInfo, Integer quantity) {
        // 如果数量值没有修改则不处理
        if (quantity == null || ObjectUtil.equals(quantity, orderDetailInfo.getQuantity())) {
            return false;
        }
        // 明细总价 = (单价 + 加工费 + 厨师费）* 数量 , 加工费 = 菜单中的加工费 + 属性加价 + 规格加价
        BigDecimal price = NumberUtil.add(orderDetailInfo.getPrice(), orderDetailInfo.getProduceCost());
        price = NumberUtil.add(price, orderDetailInfo.getDesignerPrice());
        BigDecimal totalAmount = NumberUtil.multiply(price, new BigDecimal(NumberUtil.intValue(quantity)));
        // 修改订单明细
        orderDetailInfo.setQuantity(quantity);
        orderDetailInfo.setTotalAmount(totalAmount);
        return true;
    }

    /**
     * @param archiveID      机构编号
     * @param orderDetailIDs 订单明细编号（多个）
     * @return 订单明细信息列表
     * @description 根据机构编号和订单明细编号查询订单明细信息
     * @author LinYN
     * @time 2017-5-16
     */
    public List<O_OrderDetailInfoEntity> getOrderDetailInfoByIDs(Long archiveID, Set<Long> orderDetailIDs) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put(PARAM_ARCHIVE_ID, archiveID);
        paramMap.put(PARAM_ORDER_DETAIL_IDS, StringUtils.join(orderDetailIDs, ParamConstants.GlobalParam.PARAM_SEPARATOR));
        return orderDetailInfoDao.getOrderDetailInfoByIDsAndArchiveID(paramMap);
    }

    /**
     * 根据桌台编号查询订单状态为进行中的子订单信息
     *
     * @param tableId 桌台ID
     * @return 子订单信息
     * @author LinYN
     * @date 2017-4-7
     */
    public List<O_SubOrderInfoEntity> getSubOrderInfoByTableId(Long tableId) {
        if (tableId == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<O_SubOrderInfoEntity> subOrderStatusInfo = subOrderInfoDao.getSubOrderStatusInfoByTableID(tableId);
        if (null == subOrderStatusInfo) {
            throw new BizException(CodeMsgConstants.SUBORDER_NOT_EXISTENCE, CodeMsgConstants.SUBORDER_NOT_EXISTENCE_MSG);
        }
        return subOrderStatusInfo;
    }

    /**
     * 根据桌台编号查询进行中或未下单、待支付、己支付（脏台）状态的子订单信息
     *
     * @param tableId 桌台ID
     * @return 子订单信息
     * @author LinYN
     * @date 2017-5-26
     */
    public List<O_SubOrderInfoEntity> getRelationSubOrderInfoByTableID(Long tableId) {
        if (tableId == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        return subOrderInfoDao.getRelationSubOrderInfoByTableID(tableId);
    }


    /**
     * 根据桌台ID 查询桌台的所有子订单
     *
     * @param tableIDs 桌台信息（桌台ID）
     * @return 桌台的所有子订单
     * @author LinYN
     * @date 2017-3-23
     */
    public List<O_SubOrderInfoEntity> getSubOrderInfosByTableIDs(Set<Long> tableIDs) {
        return subOrderInfoDao.getUsingSubOrderInfoByTableIDs(StringUtils.join(tableIDs, ParamConstants.GlobalParam.PARAM_SEPARATOR));
    }

    /**
     * 根据桌台编号查询订单状态为进行中的子订单信息
     *
     * @param tableInfo#tableID 桌台ID
     * @return 子订单信息
     * @author LinYN
     * @date 2017-4-1
     */
    public List<O_SubOrderInfoEntity> getSubOrderInfoByTableInfo(B_DinningTableInfoEntity tableInfo) {
        return getSubOrderInfoByTableId(tableInfo.getTableID());
    }

    /**
     * 主订单金额人数和新增的子订单金额人数相加
     *
     * @author LinYN
     * @date 2017-3-31
     */
    public O_SubOrderInfoEntity addSubOrderInfoSummary4OrderInfo(O_OrderInfoEntity orderInfo, O_SubOrderInfoEntity subOrderInfoSummary) {
        O_SubOrderInfoEntity orderInfoSummary = new O_SubOrderInfoEntity();
        orderInfoSummary.setPeopleNum(NumberUtil.add(orderInfo.getPeopleNum(), subOrderInfoSummary.getPeopleNum()));//就餐人数
        orderInfoSummary.setQuantity(NumberUtil.add(orderInfo.getQuantity(), subOrderInfoSummary.getQuantity()));
        orderInfoSummary.setTotalAmount(NumberUtil.add(orderInfo.getTotalAmount(), subOrderInfoSummary.getTotalAmount()));
        orderInfoSummary.setDiscountAmount(NumberUtil.add(orderInfo.getDiscountAmount(), subOrderInfoSummary.getDiscountAmount()));
        orderInfoSummary.setPendingAmount(NumberUtil.add(orderInfo.getPendingAmount(), subOrderInfoSummary.getPendingAmount()));
        orderInfoSummary.setActualAmount(NumberUtil.add(orderInfo.getActualAmount(), subOrderInfoSummary.getActualAmount()));
        return orderInfoSummary;
    }


    /**
     * 统计桌台的子订单信息： 金额、人数
     *
     * @author LinYN
     * @date 2017-3-22
     */
    public O_SubOrderInfoEntity calculateSubOrderInfo(List<O_SubOrderInfoEntity> tableSubOrderInfos) {
        // 统计子订单信息：金额、人数
        O_SubOrderInfoEntity subOrderInfoSummary = new O_SubOrderInfoEntity();
        Integer peopleNum = 0;
        Integer quantity = 0;
        BigDecimal totalAmount = new BigDecimal(0);
        BigDecimal discountAmount = new BigDecimal(0);
        BigDecimal pendingAmount = new BigDecimal(0);
        BigDecimal actualAmount = new BigDecimal(0);
        // 将目标桌台的子订单合并到当前桌台的主订单中， 修改主订单ID、金额、人数等
        for (O_SubOrderInfoEntity subOrderInfo : tableSubOrderInfos) {
            peopleNum = NumberUtil.add(peopleNum, subOrderInfo.getPeopleNum());
            quantity = NumberUtil.add(quantity, subOrderInfo.getQuantity());
            totalAmount = NumberUtil.add(totalAmount, subOrderInfo.getTotalAmount());
            discountAmount = NumberUtil.add(discountAmount, subOrderInfo.getDiscountAmount());
            pendingAmount = NumberUtil.add(pendingAmount, subOrderInfo.getPendingAmount());
            actualAmount = NumberUtil.add(actualAmount, subOrderInfo.getActualAmount());
        }
        subOrderInfoSummary.setPeopleNum(peopleNum);
        subOrderInfoSummary.setQuantity(quantity);
        subOrderInfoSummary.setTotalAmount(totalAmount);
        subOrderInfoSummary.setDiscountAmount(discountAmount);
        subOrderInfoSummary.setPendingAmount(pendingAmount);
        subOrderInfoSummary.setActualAmount(actualAmount);
        return subOrderInfoSummary;
    }

    /**
     * 根据桌台信息获取子订单
     *
     * @param targetTableInfo 桌台信息
     * @param throwException  没找到子订单是否抛出异常
     * @return 子订单
     * @throws Exception 没有找到子订单
     * @author LinYN
     * @date 2017-3-31
     */
    public O_SubOrderInfoEntity getFirstSubOrderInfoByTableInfo(B_DinningTableInfoEntity targetTableInfo, boolean throwException) {
        O_SubOrderInfoEntity subOrderInfoEntity = null;
        List<O_SubOrderInfoEntity> targetSubOrderInfoEntities = getSubOrderInfoByTableInfo(targetTableInfo);
        if (CollectionUtils.isNotEmpty(targetSubOrderInfoEntities)) {
            subOrderInfoEntity = targetSubOrderInfoEntities.get(0);
        }
        if (throwException && (subOrderInfoEntity == null)) {
            throw new BizException(CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST, CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST_MSG, tableComponent.getDisplayTableName(targetTableInfo));
        }
        return subOrderInfoEntity;
    }

    /**
     * 根据桌台信息获取子订单
     *
     * @param targetTableInfo 桌台信息
     * @return 子订单
     * @throws Exception 没有找到子订单
     * @author LinYN
     * @date 2017-3-31
     */
    public O_SubOrderInfoEntity getFirstSubOrderInfoByTableInfo(B_DinningTableInfoEntity targetTableInfo) {
        return getFirstSubOrderInfoByTableInfo(targetTableInfo, true);
    }

    /**
     * 获取桌台的子订单
     *
     * @param tableInfo      桌台信息
     * @param subOrderInfoID 子订单编号，拼桌需要传入
     * @author LinYN
     * @date 2017-5-10
     **/
    public O_SubOrderInfoEntity getCurrentSubOrderInfo(B_DinningTableInfoEntity tableInfo, Long subOrderInfoID) {
        O_SubOrderInfoEntity currentSubOrderInfo = null;
        List<O_SubOrderInfoEntity> subOrderInfos = getSubOrderInfoByTableInfo(tableInfo);
        if (CollectionUtils.isNotEmpty(subOrderInfos)) {
            if (subOrderInfoID == null) {
                currentSubOrderInfo = subOrderInfos.get(0);
            } else {
                currentSubOrderInfo = CollectionHelper.find(subOrderInfos, subOrderInfo -> Objects.equals(subOrderInfo.getSubOrderID(), subOrderInfoID));
            }
        }
        if (currentSubOrderInfo == null) {
            throw new BizException(CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST, CodeMsgConstants.TABLE_SUBORDER_NOT_EXIST_MSG, tableComponent.getDisplayTableName(tableInfo));
        }
        return currentSubOrderInfo;
    }

    /**
     * 插入或更新桌台的主订单信息： 金额、人数、订单状态
     *
     * @param orderInfo        主订单
     * @param orderInfoSummary 子订单统计信息
     * @return 主订单ID
     * @author LinYN
     * @date 2017-3-22
     */
    public Long saveOrUpdateOrderInfo(O_OrderInfoEntity orderInfo, O_SubOrderInfoEntity orderInfoSummary) {
        orderInfo.setPeopleNum(orderInfoSummary.getPeopleNum());//就餐人数
        orderInfo.setQuantity(orderInfoSummary.getQuantity());
        orderInfo.setTotalAmount(orderInfoSummary.getTotalAmount());
        orderInfo.setDiscountAmount(orderInfoSummary.getDiscountAmount());
        orderInfo.setPendingAmount(orderInfoSummary.getPendingAmount());
        orderInfo.setActualAmount(orderInfoSummary.getActualAmount());
        Long orderID = orderInfo.getOrderID();
        if (orderID == null) {
            orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.NOORDER.getValue());//订单状态
            orderInfoDao.saveOrderInfoEntity(orderInfo);
            orderID = orderInfo.getOrderID();
        } else {
            orderInfoDao.update(orderInfo);
        }
        return orderID;
    }

    /**
     * 同时对子订单和主订单增加金额
     * 修改订单中的总金额和实际金额，并添加订单变动信息
     *
     * @param subOrderInfo 子订单
     * @param addedAmount  增加金额, 不能为0;
     * @param desc         订单变动信息中的描述
     * @author LinYN
     * @date 2017-5-16
     */
    public void addAmountForSubOrderInfo(O_SubOrderInfoEntity subOrderInfo, BigDecimal addedAmount, String desc) {
        if (ObjectUtil.equals(BigDecimal.ZERO, addedAmount)) {
            return;
        }
        BigDecimal oldTotalAmount = subOrderInfo.getTotalAmount();
        BigDecimal newTotalAmount = NumberUtil.add(oldTotalAmount, addedAmount);
        subOrderInfo.setTotalAmount(newTotalAmount);
        subOrderInfo.setActualAmount(NumberUtil.add(subOrderInfo.getActualAmount(), addedAmount));
        subOrderInfoDao.update(subOrderInfo);
        // 添加订单变动信息
        saveOrderDealInfo(subOrderInfo.getSubOrderID(), subOrderInfo.getOrderID(), addedAmount, oldTotalAmount, newTotalAmount, desc);
        O_OrderInfoEntity orderInfo = getOrderInfoByOrderID(subOrderInfo.getOrderID());
        BigDecimal oldOrderTotalAmount = orderInfo.getTotalAmount();
        BigDecimal newOrderTotalAmount = NumberUtil.add(oldOrderTotalAmount, addedAmount);
        orderInfo.setTotalAmount(newOrderTotalAmount);
        orderInfo.setActualAmount(NumberUtil.add(orderInfo.getActualAmount(), addedAmount));
        orderInfoDao.update(orderInfo);
        // 添加订单变动信息
        saveOrderDealInfo(null, orderInfo.getOrderID(), addedAmount, oldOrderTotalAmount, newOrderTotalAmount, desc);
    }

    /**
     * 根据子订单ID查询信息
     *
     * @param subOrderID
     * @return
     */
    public O_SubOrderInfoEntity getSubOrderInfoBySubOrderID(Long subOrderID) {
        if (subOrderID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        O_SubOrderInfoEntity subOrderInfo = subOrderInfoDao.selectByPrimaryKey(subOrderID);
        if (null == subOrderInfo) {
            throw new BizException(CodeMsgConstants.ORDER_NOT_EXISTENCE, CodeMsgConstants.ORDER_NOT_EXISTENCE_MSG);
        }
        return subOrderInfo;
    }

    /**
     * 根据预定ID查询预定单信息
     *
     * @param bookingID
     * @return
     */
    public O_BookingInfoEntity getBookingInfoByID(Long bookingID) {
        if (bookingID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        O_BookingInfoEntity booking = bookingDao.getByID(bookingID);
        if (null == booking) {
            throw new BizException(CodeMsgConstants.BOOKING_ORDER_NOT_EXISTENCE, CodeMsgConstants.BOOKING_ORDER_NOT_EXISTENCE_MSG);
        }
        return booking;
    }

    /**
     * 根据订单ID和桌台ID查询预定子订单
     *
     * @param orderID
     * @param tableID
     * @return
     */
    public O_SubOrderInfoEntity getBookingSubOrderInfo(Long orderID, Long tableID) {
        if (orderID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if (tableID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        O_SubOrderInfoEntity bookingSubOrderInfo = subOrderInfoDao.getBookingSubOrderInfo(orderID, tableID);
        if (null == bookingSubOrderInfo) {
            throw new BizException(CodeMsgConstants.ORDER_NOT_EXISTENCE, CodeMsgConstants.ORDER_NOT_EXISTENCE_MSG);
        }
        return bookingSubOrderInfo;
    }


}
