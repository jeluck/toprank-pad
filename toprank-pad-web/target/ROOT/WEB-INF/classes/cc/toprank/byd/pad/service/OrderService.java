package cc.toprank.byd.pad.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.constant.MerchantTagCodeConstants;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.enums.OrderManageEnum;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.enums.SystemManageEnum;
import cc.toprank.byd.pad.pojo.ConsumerDetailsDTO;
import cc.toprank.byd.pad.pojo.OrderDetailsDTO;
import cc.toprank.byd.pad.pojo.OrderDishesDTO;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import cc.toprank.byd.service.GuQingService;
import cc.toprank.byd.service.MerchantTagService;
import cc.toprank.byd.service.MonitorService;
import cc.toprank.byd.service.StallWeighService;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.util.ResultHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.*;

import static cc.toprank.byd.pad.pojo.OrderDishesDTO.Dishes;

/**
 * 订单service
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-2-20 17:09
 */
@Service
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private O_OrderInfoDao orderInfoDao;
    @Autowired
    private O_SubOrderInfoDao subOrderInfoDao;
    @Autowired
    private O_OrderDealInfoDao orderDealInfoDao;
    @Autowired
    private O_OrderDetailInfoDao orderDetailInfoDao;
    @Autowired
    private P_ComboSettingInfoDao comboSettingInfoDao;
    @Autowired
    private O_ComboDetailInfoDao comboDetailInfoDao;
    @Autowired
    private B_MerchantMenuInfoDao merchantMenuInfoDao;
    @Autowired
    private B_DinningTableInfoDao dinningTableInfoDao;
    @Autowired
    private B_MealTableMappingDao mealTableMappingDao;
    @Autowired
    private MonitorService monitorService;
    @Autowired
    private O_OrderDetailValueMappingDao detailValueMappingDao;
    @Autowired
    private O_ComboDetailValueMappingDao comboDetailValueMappingDao;
    @Autowired
    private B_DesignerMonitorInfoDao designerMonitorInfoDao;
    @Autowired
    private MerchantTagService merchantTagService;
    @Autowired
    private P_CategoryAttributeValueInfoDao attributeValueInfoDao;
    @Autowired
    private GuQingService guQingService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private StallWeighService stallWeighService;

    /**
     * 下单
     *
     * @author LeeJun
     * @time 2017-2-20 16:29
     * @version 2.0.0
     */
    @Transactional
    public Map<String, Object> placeOrder(OrderDishesDTO orderDishes) {
        Map<String, Object> returnParam = new HashMap<>();
        // 检查下单菜品中是否存在已估清的菜品
        List<Long> detailIDs = this.checkGuQing(orderDishes.getDishes());
        if (!detailIDs.isEmpty()) {
            returnParam.put("isOk", false);
            returnParam.put("guQingIDs", detailIDs);
            returnParam.put("saleStopIDs", new ArrayList<Long>());
            return returnParam;
        }
        BigDecimal actualAmount = orderDishes.getTotalAmount();
        if (orderDishes.getDiscountAmount() != null) {
            actualAmount = actualAmount.subtract(orderDishes.getDiscountAmount());
        }
        B_DinningTableInfoEntity tableInfo = dinningTableInfoDao.selectByPrimaryKey(MerchantCacheUtils.getCurrentTableID());
        if (actualAmount.compareTo(tableInfo.getMinConsumption()) == -1) {
            throw new BizException("不满足当前桌台最低消费金额,请修改后从新下单");
        }
        Long produceStatus = OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue();
        if (orderDishes.isPostpone()) {
            produceStatus = OrderManagerEnum.ProductionStatus.SOCALLED.getValue();
        }
        O_SubOrderInfoEntity subOrderInfo = subOrderInfoDao.selectByPrimaryKey(orderDishes.getSubOrderID());
        // 添加订单明细
        List<Long> detailIDList = this.addOrderDetailInfo(orderDishes, produceStatus);
        // 修改订单状态、金额及就餐人数信息
        this.updateOrderInfo(orderDishes, actualAmount);
        // 修改子订单状态、金额及就餐人数信息
        this.updateSubOrderInfo(subOrderInfo, orderDishes, actualAmount);
        // 修改桌台状态
        tableInfo = new B_DinningTableInfoEntity();
        tableInfo.setTableID(MerchantCacheUtils.getCurrentTableID());
        tableInfo.setTableStatus(MerchantManageEnum.TableStatus.PLACEMAN.getValue());
        dinningTableInfoDao.updateByPrimaryKeySelective(tableInfo);
        // 修改餐次桌台人数及状态
        this.updateMealTable(subOrderInfo.getMealsID(), orderDishes.getPeopleNum());
        try {
            // 添加待制作菜品信息到厨师看板中
            monitorService.addWaitMakeProduct2DesignerMonitorInfo(detailIDList);
            // 如有称重菜,记录待称重菜品信息
            stallWeighService.addStallWeighInfo(detailIDList);
        } catch (Exception e) {
            LOGGER.error("添加称重菜品异常，detailIDList: " + detailIDList, e);
        }
        // 下单成功后清空购物车
        shoppingCartService.cleanShoppingCart(subOrderInfo.getTableID(), true);
        returnParam.put("guQingIDs", null);
        returnParam.put("saleStopIDs", null);
        returnParam.put("isOk", true);
        return returnParam;
    }

    /**
     * 修改子订单状态、金额及就餐人数信息
     *
     * @author LeeJun
     * @time 2017-6-5 11:04
     * @version 2.0.0
     */
    public void updateSubOrderInfo(O_SubOrderInfoEntity subOrderInfo, OrderDishesDTO orderDishes, BigDecimal actualAmount) {
        if (subOrderInfo.getTotalAmount() != null) {
            subOrderInfo.setTotalAmount(subOrderInfo.getTotalAmount().add(actualAmount));
        } else {
            subOrderInfo.setTotalAmount(actualAmount);
        }
        if (subOrderInfo.getActualAmount() != null) {
            subOrderInfo.setActualAmount(subOrderInfo.getActualAmount().add(actualAmount));
        } else {
            subOrderInfo.setActualAmount(actualAmount);
        }
        if (subOrderInfo.getDiscountAmount() != null) {
            subOrderInfo.setDiscountAmount(subOrderInfo.getDiscountAmount().add(orderDishes.getDiscountAmount()));
        } else {
            subOrderInfo.setDiscountAmount(orderDishes.getDiscountAmount());
        }
        if (subOrderInfo.getPendingAmount() != null) {
            subOrderInfo.setPendingAmount(subOrderInfo.getPendingAmount().add(actualAmount));
        } else {
            subOrderInfo.setPendingAmount(actualAmount);
        }
        int quantity = 0;
        for (Dishes dishes : orderDishes.getDishes()) {
            quantity += dishes.getQuantity();
        }
        if (subOrderInfo.getQuantity() != null) {
            subOrderInfo.setQuantity(subOrderInfo.getQuantity() + quantity);
        } else {
            subOrderInfo.setQuantity(quantity);
        }
        subOrderInfo.setPeopleNum(orderDishes.getPeopleNum());
        subOrderInfo.setOrderStatus(OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
        subOrderInfo.setSubOrderDesc(orderDishes.getMemo());
        subOrderInfo.setMemo(orderDishes.getMemo());
        subOrderInfoDao.updateByPrimaryKeySelective(subOrderInfo);
    }

    /**
     * 修改订单状态、金额及就餐人数信息
     *
     * @author LeeJun
     * @time 2017-6-5 11:04
     * @version 2.0.0
     */
    public void updateOrderInfo(OrderDishesDTO orderDishes, BigDecimal actualAmount) {
        O_OrderInfoEntity orderInfo = orderInfoDao.selectByPrimaryKey(orderDishes.getOrderID());
        Long beforeStatus = orderInfo.getOrderStatus();
        BigDecimal beforeAmount = orderInfo.getTotalAmount();
        orderInfo.setPeopleNum(orderDishes.getPeopleNum());
        orderInfo.setOrderStatus(OrderManageEnum.OrderStatus.HAVEINHAND.getValue());
        if (orderInfo.getTotalAmount() != null) {
            orderInfo.setTotalAmount(orderInfo.getTotalAmount().add(actualAmount));
        } else {
            orderInfo.setTotalAmount(actualAmount);
        }
        if (orderInfo.getActualAmount() != null) {
            orderInfo.setActualAmount(orderInfo.getActualAmount().add(actualAmount));
        } else {
            orderInfo.setActualAmount(actualAmount);
        }
        if (orderInfo.getDiscountAmount() != null) {
            orderInfo.setDiscountAmount(orderInfo.getDiscountAmount().add(orderDishes.getDiscountAmount()));
        } else {
            orderInfo.setDiscountAmount(orderDishes.getDiscountAmount());
        }
        if (orderInfo.getPendingAmount() != null) {
            orderInfo.setPendingAmount(orderInfo.getPendingAmount().add(actualAmount));
        } else {
            orderInfo.setPendingAmount(actualAmount);
        }
        int quantity = 0;
        for (Dishes dishes : orderDishes.getDishes()) {
            quantity += dishes.getQuantity();
        }
        if (orderInfo.getQuantity() != null) {
            orderInfo.setQuantity(orderInfo.getQuantity() + quantity);
        } else {
            orderInfo.setQuantity(quantity);
        }
        orderInfo.setMemo(orderDishes.getMemo());
        orderInfoDao.updateByPrimaryKeySelective(orderInfo);

        // 添加订单处理信息
        O_OrderDealInfoEntity orderDealInfo = new O_OrderDealInfoEntity();
        orderDealInfo.setDealID(MaxIDUtils.getID(O_OrderDealInfoEntity.class));
        orderDealInfo.setOrderID(orderDishes.getOrderID());
        orderDealInfo.setSubOrderID(orderDishes.getSubOrderID());
        orderDealInfo.setBeforeStatus(beforeStatus);
        orderDealInfo.setAfterStatus(orderInfo.getOrderStatus());
        orderDealInfo.setChangeAmount(actualAmount);
        orderDealInfo.setBeforeAmount(beforeAmount);
        orderDealInfo.setAfterAmount(orderInfo.getTotalAmount().add(actualAmount));
        orderDealInfo.setCreateTime(LocalDateTime.now());
        orderDealInfoDao.insertSelective(orderDealInfo);
    }

    /**
     * 检查下单菜品中是否存在已估清的菜品
     *
     * @author LeeJun
     * @time 2017-5-26 17:26
     * @version 2.0.0
     */
    public List<Long> checkGuQing(List<Dishes> dishesList) {
        List<Long> list = new ArrayList<>();
        for (Dishes dishes : dishesList) {
            if (guQingService.checkIsGuQing(dishes)) {
                list.add(dishes.getDetailID());
            }
        }
        return list;
    }

    /**
     * 添加订单明细信息
     *
     * @author LeeJun
     * @time 2017-5-24 14:07
     * @version 2.0.0
     */
    public List<Long> addOrderDetailInfo(OrderDishesDTO dishes, Long produceStatus) {
        List<Long> detailIDList = new ArrayList<>();
        LocalDateTime servingTime = null;
        if (!StringUtils.isEmpty(dishes.getServingTime())) {
            try {
                servingTime = DateUtils.parseLocalDateTime(dishes.getServingTime());
                if (DateUtils.getSecondsBetween(LocalDateTime.now(), servingTime) <= 0) {
                    throw new BizException("约定上菜时间不能少于当前时间！");
                }
            } catch (ParseException e) {
                LOGGER.error("解析上菜时间出错：" + dishes.getServingTime(), e);
            }
        }
        for (Dishes varDishes : dishes.getDishes()) {
            Long detailID;
            if (varDishes.isCombos()) {
                // 添加套餐订单详细信息
                detailID = addComboDetail(dishes.getOrderID(), dishes.getSubOrderID(), servingTime, produceStatus, varDishes, dishes.getCarteMethod());
            } else {
                // 添加菜品订单详细信息
                detailID = addOrderDetailInfo(dishes.getOrderID(), dishes.getSubOrderID(), servingTime, produceStatus, varDishes, dishes.getCarteMethod());
            }
            detailIDList.add(detailID);
        }
        return detailIDList;
    }

    /**
     * 修改餐次桌台人数及状态
     *
     * @author LeeJun
     * @time 2017-5-9 16:26
     * @version 2.0.0
     */
    public void updateMealTable(Long mealsID, int peopleNum) {
        Map<String, Object> param = new HashMap<>();
        param.put("tableID", MerchantCacheUtils.getCurrentTableID());
        param.put("mealsID", mealsID);
        // param.put("tableName", subOrderInfo.getTableName());
        param.put("tableStatus", MerchantManageEnum.TableStatus.PLACEORDER.getValue());
        B_MealTableMappingEntity mealTableMapping = mealTableMappingDao.getByParam(param);
        if (mealTableMapping != null) {
            mealTableMapping.setTableStatus(MerchantManageEnum.TableStatus.PLACEMAN.getValue());
            mealTableMapping.setCustomerNumber(peopleNum);
            mealTableMappingDao.updateByPrimaryKeySelective(mealTableMapping);
        }
    }

    /**
     * 添加套餐明细
     *
     * @author LeeJun
     * @time 2017-5-9 15:23
     * @version 2.0.0
     */
    public Long addComboDetail(Long orderID, Long subOrderID, LocalDateTime servingTime, Long produceStatus, Dishes dishes, Long carteMethod) {
        O_ComboDetailInfoEntity comboDetailInfo;
        List<P_ComboSettingInfoEntity> comboList = comboSettingInfoDao.getByProductID(dishes.getProductID());
        Long detailID = addOrderDetailInfo(orderID, subOrderID, servingTime, produceStatus, dishes, carteMethod);
        for (P_ComboSettingInfoEntity combo : comboList) {
            Long recordID = MaxIDUtils.getID(O_ComboDetailInfoEntity.class);
            // 添加套餐明细信息
            comboDetailInfo = new O_ComboDetailInfoEntity();
            comboDetailInfo.setRecordID(recordID);
            comboDetailInfo.setDetailID(detailID);
            comboDetailInfo.setVariantID(combo.getVariantID());
            comboDetailInfo.setProductName(combo.getVariantName());
            comboDetailInfo.setComboID(combo.getProductID());
            comboDetailInfo.setComboName(combo.getProductName());
            comboDetailInfo.setImgPath(combo.getFilePath());
            comboDetailInfo.setOriginalPrice(combo.getOriginalPrice());
            comboDetailInfo.setPrice(combo.getPrice());
            comboDetailInfo.setQuantity(combo.getQuantity() * dishes.getQuantity());
            comboDetailInfo.setProductUnit(combo.getProductUnit());
            comboDetailInfo.setProduceStatus(produceStatus);
//            long produceMinute = 10;
//            if (combo.getProduceMinute() != null) {
//                produceMinute = combo.getProduceMinute();
//            }
            if (servingTime != null) {
                comboDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.SOCALLED.getValue());
                comboDetailInfo.setProduceTime(servingTime);
            } else {
                comboDetailInfo.setProduceTime(LocalDateTime.now());
            }
            // 如果是称重菜，制作状态则为待称重
            if (combo.getNeedWeigh() != null && combo.getNeedWeigh()) {
                produceStatus = OrderManagerEnum.ProductionStatus.PENDINGWEIGH.getValue();
            }
            comboDetailInfo.setServedNum(0);
            comboDetailInfo.setCreateTime(LocalDateTime.now());
            // comboDetailInfo.setMemo();
            comboDetailInfoDao.insertSelective(comboDetailInfo);
            this.addComboDetailValueMapping(recordID, dishes.getValueIDs());
        }
        return detailID;
    }

    /**
     * 添加订单详细信息
     *
     * @author LeeJun
     * @time 2017-2-20 17:11.
     * @version 2.0.0
     */
    public Long addOrderDetailInfo(Long orderID, Long suborderID, LocalDateTime servingTime, Long produceStatus, Dishes dishes, Long carteMethod) {
        B_MerchantMenuInfoEntity merchantMenuInfo = merchantMenuInfoDao.getByMenuID(dishes.getMenuID(), dishes.isCombos());
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        Long detailID = MaxIDUtils.getID(O_OrderDetailInfoEntity.class);
        orderDetailInfo.setDetailID(detailID);
        orderDetailInfo.setSubOrderID(suborderID);
        orderDetailInfo.setOrderID(orderID);
        orderDetailInfo.setTableID(MerchantCacheUtils.getCurrentTableID());
        if (dishes.getOptionID() != 0) {
            orderDetailInfo.setOptionID(dishes.getOptionID());
        }
        // 处理valueIDs后面的分隔符','
        String valueIDs = StringUtil.cutoffLastExcision(dishes.getValueIDs(), ",");
        dishes.setValueIDs(valueIDs);
        orderDetailInfo.setValueIDs(valueIDs);
        orderDetailInfo.setValueNames(attributeValueInfoDao.getAttributeByValueIDs(valueIDs));
        orderDetailInfo.setALaCarteMethod(carteMethod);
        orderDetailInfo.setMenuID(dishes.getMenuID());
        Long designerID = orderDetailInfo.getDesignerID();
        BigDecimal designerPrice = new BigDecimal(0);
        if (designerID != null) {
            orderDetailInfo.setDesignerID(designerID);
            orderDetailInfo.setSelectedMethod(OrderManagerEnum.SelectedDesigner.CUSTOMER_SPECIFIED.getValue());
            designerPrice = dishes.getDesignerPrice();
            orderDetailInfo.setDesignerPrice(designerPrice);
        }
        orderDetailInfo.setProductName(merchantMenuInfo.getProductName());
        orderDetailInfo.setImgPath(merchantMenuInfo.getFilePath());
        orderDetailInfo.setALaCarteMethod(OrderManagerEnum.OrderMode.NORMALORDERPRODUCT.getValue());
        orderDetailInfo.setNeedWeigh(merchantMenuInfo.getNeedWeigh());
        orderDetailInfo.setOriginalPrice(merchantMenuInfo.getOriginalPrice());
        BigDecimal price = merchantMenuInfo.getPrice();
        if (dishes.getExpectedWeight() != 0) {
            price.multiply(new BigDecimal(dishes.getExpectedWeight()));
        }
        orderDetailInfo.setPrice(price);
        // orderDetailInfo.setFloatquantity();
        boolean isCombos = dishes.isCombos();
        if (isCombos) {
            orderDetailInfo.setIsCombo(isCombos);
            orderDetailInfo.setComboID(merchantMenuInfo.getProductID());
            orderDetailInfo.setComboName(merchantMenuInfo.getProductName());
            orderDetailInfo.setComboPrice(merchantMenuInfo.getPrice());
        } else {
            orderDetailInfo.setIsCombo(false);
            orderDetailInfo.setVariantID(merchantMenuInfo.getVariantID());
        }
        orderDetailInfo.setProductUnit(merchantMenuInfo.getUnitID());
        orderDetailInfo.setQuantity(dishes.getQuantity());
        BigDecimal produceCost = shoppingCartService.calcProduceCost(dishes, merchantMenuInfo.getProduceCost());
        orderDetailInfo.setProduceCost(produceCost);
        // (成交价+加工费+厨师费)*数量
        orderDetailInfo.setTotalAmount(merchantMenuInfo.getPrice().add(produceCost).add(designerPrice)
                .multiply(new BigDecimal(dishes.getQuantity())));
        orderDetailInfo.setProduceStatus(produceStatus);
        if (servingTime != null) {
            produceStatus = OrderManagerEnum.ProductionStatus.SOCALLED.getValue();
//            // 如约定时间上菜-制作时长小于当前时间，就将制作时间设为当前时间
//            servingTime = servingTime.minusMinutes(produceMinute);
//            if (DateUtils.getSecondsBetween(LocalDateTime.now(), servingTime) <= 0) {
//                produceStatus = OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue();
//                servingTime = LocalDateTime.now();
//            }
            orderDetailInfo.setProduceTime(servingTime);
            orderDetailInfo.setProduceStatus(produceStatus);
        } else {
            orderDetailInfo.setProduceTime(LocalDateTime.now());
        }
        // 称重菜品制件状态为待称重
        if (merchantMenuInfo.getNeedWeigh()) {
            orderDetailInfo.setProduceStatus(OrderManagerEnum.ProductionStatus.PENDINGWEIGH.getValue());
            orderDetailInfo.setExpectedWeight(dishes.getExpectedWeight() * dishes.getQuantity());
        }
        orderDetailInfo.setServedNum(0);
        orderDetailInfo.setCreateTime(LocalDateTime.now());
        orderDetailInfo.setMemo(dishes.getMemo());
        orderDetailInfoDao.insertSelective(orderDetailInfo);
        // 添加订单明细属性值关联信息
        this.addOrderDetailValueMapping(detailID, valueIDs);
        return detailID;
    }

    /**
     * 添加订单明细属性值关联信息
     *
     * @author LeeJun
     * @time 2017-5-22 9:58
     * @version 2.0.0
     */
    public void addOrderDetailValueMapping(Long detailID, String valueIDs) {
        // valueIDs = StringUtil.cutoffLastExcision(valueIDs, ",");
        if (!StringUtils.isEmpty(valueIDs)) {
            String idArray[] = valueIDs.split(",");
            for (String id : idArray) {
                O_OrderDetailValueMappingEntity mapping = new O_OrderDetailValueMappingEntity();
                mapping.setMappingID(MaxIDUtils.getID(O_OrderDetailValueMappingEntity.class));
                mapping.setDetailID(detailID);
                mapping.setValueID(Long.valueOf(id));
                mapping.setMappingStatus(SystemManageEnum.EntityStatus.NORMAL.getValue());
                mapping.setCreatorID(1L);
                mapping.setCreateTime(LocalDateTime.now());
                detailValueMappingDao.insertSelective(mapping);
            }
        }
    }

    /**
     * 添加订单明细属性值关联信息
     *
     * @author LeeJun
     * @time 2017-5-22 9:58
     * @version 2.0.0
     */
    public void addComboDetailValueMapping(Long recordID, String valueIDs) {
        valueIDs = StringUtil.cutoffLastExcision(valueIDs, ",");
        if (!StringUtils.isEmpty(valueIDs)) {
            String idArray[] = valueIDs.split(",");
            for (String id : idArray) {
                O_ComboDetailValueMappingEntity mapping = new O_ComboDetailValueMappingEntity();
                // mapping.setMappingID(MaxIDUtils.getID(O_OrderDetailValueMappingEntity.class));
                mapping.setRecordID(recordID);
                mapping.setValueID(Long.valueOf(id));
                mapping.setMappingStatus(SystemManageEnum.EntityStatus.NORMAL.getValue());
                mapping.setCreatorID(1L);
                mapping.setCreateTime(LocalDateTime.now());
                comboDetailValueMappingDao.insertSelective(mapping);
            }
        }
    }

    /**
     * 获取订单详细信息
     *
     * @author LeeJun
     * @time 2017-5-17 16:28
     * @version 2.0.0
     */
    public OrderDetailsDTO getOrderDetails(Long subOrderID) {
        OrderDetailsDTO orderDetails = orderDetailInfoDao.getOrderDetailsBySubOrderID(subOrderID, CommonMapper.getCurrentMealsID());
        if (orderDetails != null) {
            // 计算就餐时长
            long duration = DateUtils.getMinutesBetween(orderDetails.getOpenTableTime(), LocalDateTime.now());
            orderDetails.setDuration(duration);
            BigDecimal payableAmount = orderDetails.getActualAmount().subtract(orderDetails.getBookingAmount())
                    .subtract(orderDetails.getPaidAmount());
            orderDetails.setPayableAmount(payableAmount);
        }
        return orderDetails;
    }

    /**
     * 获取订单消费明细
     *
     * @author LeeJun
     * @time 2017-5-31 17:01
     * @version 2.0.0
     */
    public List<ConsumerDetailsDTO> getConsumerDetails(Long subOrderID) {
        List<ConsumerDetailsDTO> detailList = orderDetailInfoDao.getDetailListBySubOrderID(subOrderID);
        for (ConsumerDetailsDTO details : detailList) {
            if (details.getMemo() == null) {
                details.setMemo("");
            }
            if (details.getOptionName() == null) {
                details.setOptionName("");
            }
            if (details.getAttributeValue() == null) {
                details.setAttributeValue("");
            }
        }
        return detailList;
    }

    @Transactional
    public boolean serviceOperating(int type, String detailIDs) {
        detailIDs = StringUtil.cutoffLastExcision(detailIDs, ",");
        boolean isOk = false;
        if (type == 1) {
            isOk = this.waitsOrderDetail(detailIDs);
        } else if (type == 2) {
            isOk = this.rouseOrderDetail(detailIDs);
        } else if (type == 3) {
            isOk = this.urgeDishes(detailIDs);
        } else if (type == 4) {
            isOk = this.commendDishes(detailIDs);
        } else if (type == 5) {
            List<Dishes> dishesList = orderDetailInfoDao.getDishesListByDetailIDs(detailIDs);
            shoppingCartService.batchAddShoppingCart(dishesList);
            isOk = true;
        }
        return isOk;
    }

    /**
     * 催菜
     *
     * @author LeeJun
     * @time 2017-5-22 18:08
     * @version 2.0.0
     */
    public boolean urgeDishes(String orderDetailIDs) {
        return merchantTagService.addOrderDetailTag(orderDetailIDs, MerchantCacheUtils.getCurrentArchiveID(), MerchantTagCodeConstants.PUSH_FOOD);
    }

    /**
     * 推荐菜品
     *
     * @author LeeJun
     * @time 2017-5-22 18:08
     * @version 2.0.0
     */
    public boolean commendDishes(String orderDetailIDs) {
        return merchantTagService.addOrderDetailTag(orderDetailIDs, MerchantCacheUtils.getCurrentArchiveID(), MerchantTagCodeConstants.COMMEND);
    }

    /**
     * 等叫
     *
     * @author LeeJun
     * @time 2017-5-22 14:57
     * @version 2.0.0
     */
    public boolean waitsOrderDetail(String orderDetailIDs) {
        return this.updateProduceStatusByDetailIDs(orderDetailIDs, OrderManagerEnum.ProductionStatus.SOCALLED.getValue());
    }

    /**
     * 叫起
     *
     * @author LeeJun
     * @time 2017-5-22 14:57
     * @version 2.0.0
     */
    public boolean rouseOrderDetail(String orderDetailIDs) {
        return this.updateProduceStatusByDetailIDs(orderDetailIDs, OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue());
    }

    /**
     * 修改订单明细的制作状态，包括订单明细、订单套餐明细、厨师看板信息
     *
     * @author LeeJun
     * @time 2017-5-22 14:58
     * @version 2.0.0
     */
    @Transactional
    public boolean updateProduceStatusByDetailIDs(String orderDetailIDs, Long produceStatus) {
        LocalDateTime now = null;
        if (OrderManagerEnum.ProductionStatus.INPRODUCTION.getValue().equals(produceStatus)) {
            now = LocalDateTime.now();
        }
        orderDetailInfoDao.batchUpdateStatusByDetailIDs(orderDetailIDs, produceStatus, now);
        comboDetailInfoDao.batchStatusByDetailIDs(orderDetailIDs, produceStatus, now);
        int row = designerMonitorInfoDao.batchStatusByDetailIDs(orderDetailIDs, produceStatus, now);
        return ResultHelper.retBool(row);
    }

}
