package cc.toprank.byd.web.service.menu;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.BigDecimalUtil;
import cc.toprank.byd.common.utils.BooleanUtil;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.component.CurbSaleComponent;
import cc.toprank.byd.component.DictionaryComponent;
import cc.toprank.byd.component.PrintComponent;
import cc.toprank.byd.component.ProductComponent;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.*;
import cc.toprank.byd.util.CollectionHelper;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.vo.ReasonVO;
import cc.toprank.byd.vo.print.ProductDetailVO;
import cc.toprank.byd.vo.print.TableInfoVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.order.O_OrderDealInfoService;
import cc.toprank.byd.web.service.table.B_DinningTableInfoService;
import cc.toprank.byd.web.service.table.B_DinningTableUseInfoService;
import cc.toprank.byd.web.vo.menu.OrderDetailResultVO;
import cc.toprank.byd.web.vo.menu.OrderDetailResultVO.ComboDetailVO;
import cc.toprank.byd.web.vo.menu.OrderDetailVO;
import cc.toprank.byd.web.vo.menu.OrderDetailVO.OrderComboVO;
import cc.toprank.byd.web.vo.menu.UnderOrderDetailVO;
import cc.toprank.byd.web.vo.menu.UnderOrderVO;
import cc.toprank.byd.web.vo.printvo.OrderPrintVO;
import cc.toprank.byd.web.vo.product.ProductSpecificationVo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**********************************************************************************************************************
 *
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司 B_AttachmentInfoService 真实的业务实现类，允许修改
 *
 ********************************************************************************************************************/
@Service("o_OrderDetailInfoService")
public class O_OrderDetailInfoService {

    @Autowired
    O_OrderDetailInfoDao orderDetailInfoDao;
    @Autowired
    O_OrderInfoService orderInfoService;
    @Autowired
    O_SubOrderInfoService subOrderInfoService;
    @Autowired
    P_ProductInfoService productInfoService;
    @Autowired
    P_ProductVariantInfoService productVariantInfoService;
    @Autowired
    O_OrderDealInfoService orderDealInfoService;
    @Autowired
    B_MerchantInfoService merchantInfoService;
    @Autowired
    O_ComboDetailInfoDao comboDetailInfoDao;
    @Autowired
    B_DinningTableUseInfoService diningTableUseInfoService;
    @Autowired
    B_DinningTableInfoService dinningTableInfoService;
    @Autowired
    O_OrderDealInfoDao dealInfoDao;
    @Autowired
    B_MerchantMenuInfoDao merchantMenuInfoDao;
    @Autowired
    B_DinningTableInfoDao dinningTableInfoDao;
    @Autowired
    B_MealTableMappingDao mealTableMappingDao;
    @Autowired
    P_SpecificationAttributeOptionInfoDao specificationAttributeDao;
    @Autowired
    P_CategoryAttributeValueInfoDao categoryAttributeValueInfoDao;
    @Autowired
    P_ProductDesignerMappingDao productDesignerMappingDao;
    @Autowired
    P_ComboGroupProductMappingDao comboGroupProductMappingDao;
    @Autowired
    B_StallProduceMappingDao stallProduceMappingDao;
    @Autowired
    B_StallWeighInfoDao stallWeighInfoDao;
    @Autowired
    O_OrderDetailValueMappingDao orderDetailValueMappingDao;
    @Autowired
    P_ProductCategoryInfoDao productCategoryInfoDao;
    @Autowired
    B_MonitorProducePortMappingDao monitorProducePortMappingDao;
    @Autowired
    B_DesignerMonitorInfoDao designerMonitorInfoDao;
    @Autowired
    B_DesignerMonitorMappingDao designerMonitorMapping;
    @Autowired
    B_MonitorInfoDao monitorInfoDao;
    @Autowired
    P_ProductVariantInfoDao productVariantInfoDao;
    @Autowired
    O_ComboDetailValueMappingDao comboDetailValueMappingDao;
    @Autowired
    B_StallWeighDealInfoDao stallWeighDealInfoDao;
    @Autowired
    P_DesignerInfoDao designerInfoDao;
    @Autowired
    B_DesignerMonitorInfoDao b_DesignerMonitorInfoDao;
    @Autowired
    B_DesingerProduceDealInfoDao b_DesingerProduceDealInfoDao;
    @Autowired
    B_DesingerProduceDealInfoDao desingerProduceDealInfoDao;
    @Autowired
    P_VariantSpecificationMappingDao variantSpecificationMappingDao;
    @Autowired
    O_OrderDiscountMappingDao o_orderDiscountMappingDao;
    @Autowired
    P_CategoryAttributeInfoDao categoryAttributeInfoDao;
    @Autowired
    CurbSaleComponent curbSaleComponent;
    @Autowired
    P_ComboSettingInfoDao comboSettingInfoDao;
    @Autowired
    private O_ComboDetailInfoDao o_ComboDetailInfoDao;
    @Autowired
    private PrintComponent printComponent;
    @Autowired
    B_MerchantTagInfoDao merchantTagInfoDao;
    @Autowired
    ProductComponent productComponent;
    @Autowired
    ProductInfoDao productInfoDao;
    @Autowired
    private DictionaryComponent dictionaryComponent;

    // 日志处理
    private static final Logger logger = LoggerFactory.getLogger(B_DinningTableInfoService.class.getName());


    public O_OrderDetailInfoEntity get(O_OrderDetailInfoEntity orderDetailInfo) throws Exception {
        return orderDetailInfoDao.get(orderDetailInfo);
    }

    public List<O_OrderDetailInfoEntity> getAll() throws Exception {
        return orderDetailInfoDao.getAll();
    }

    public void update(O_OrderDetailInfoEntity orderDetailInfo) throws Exception {
        orderDetailInfoDao.update(orderDetailInfo);
    }

    public void delete(O_OrderDetailInfoEntity orderDetailInfo) throws Exception {
        orderDetailInfoDao.delete(orderDetailInfo);
    }

    public void save(O_OrderDetailInfoEntity orderDetailInfo) throws Exception {
        orderDetailInfoDao.save(orderDetailInfo);
    }


    /**
     * 根据订单详细ID查询订单详细
     */
    public O_OrderDetailInfoEntity getOrderDetailInfoById(Long detailID) throws Exception {
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setDetailID(detailID);
        return orderDetailInfoDao.get(orderDetailInfo);
    }


    /**
     * @param orderDetail
     * @param subOrder
     * @return
     * @throws Exception
     * @Description： 新增订单明细信息
     * @Author：LanZY
     * @Time: 2017-5-8 15:44
     * @Version 2.0.0
     */
    public OrderDetailResultVO addOrderDetailInfo(OrderDetailVO orderDetail, O_SubOrderInfoEntity subOrder, int i) throws Exception {
        /*拼菜 一鱼多味 情况未处理 */
        OrderDetailResultVO orderResultVO = new OrderDetailResultVO();
        //根据menuID查询菜单信息
        B_MerchantMenuInfoEntity menuInfo = productComponent.getMenuInfoByMenuID(orderDetail.getMenuID());
        if(menuInfo.getMenuStatus().equals(SystemManageEnum.EntityStatus.DISABLE.getValue())){
            throw new BizException(CodeMsgConstants.MERCHANT_DISABLE, CodeMsgConstants.MERCHANT_DISABLE_MSG,menuInfo.getProductName());
        }
        //如果类型为改价那么改变单价
        if (NumberUtil.intValue(orderDetail.getProductType())>0 && orderDetail.getProductType() == 4) {
            menuInfo.setPrice(new BigDecimal(orderDetail.getPrice()));
        }
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setDesignerID(orderDetail.getDesignerID());
        orderDetailInfo.setOptionID(orderDetail.getOptionID());
        orderDetailInfo.setValueIDs(orderDetail.getValueIDs());
        // 根据变体ID查询 变体信息
        P_ProductVariantInfoEntity variantInfoEntity = null;
        if(null != menuInfo.getVariantID()){
            variantInfoEntity = productComponent.getProductVariantByVariantID(menuInfo.getVariantID());
        }
        handleField(orderDetail, menuInfo, orderDetailInfo, variantInfoEntity);
        // 根据valueIDs查询属性值信息
        List<P_CategoryAttributeValueInfoEntity> orderDetailAttributeList = categoryAttributeValueInfoDao.getCategoryAttributeValuesByIDs(orderDetail.getValueIDs());
        orderDetailInfo.setServedNum(0);
        orderDetailInfo.setSubOrderID(subOrder.getSubOrderID());
        orderDetailInfo.setOrderID(subOrder.getOrderID());
        orderDetailInfo.setProductName(menuInfo.getProductName());
        orderDetailInfo.setALaCarteMethod(orderDetail.getaLaCarteMethod());
        orderDetailInfo.setProductUnit(menuInfo.getUnitID());
        orderDetailInfo.setOriginalPrice(menuInfo.getPrice());
        orderDetailInfo.setMenuID(menuInfo.getMenuID());
        orderDetailInfo.setSortNo(i);
        orderDetailInfo.setValueNames(getValueNames(orderDetailAttributeList));
        orderDetailInfo.setDetailDesc(orderDetail.getMemo());
        orderDetailInfo.setCreatorType(SystemManageEnum.UserType.SYSTEMUSER.getValue());
        orderDetailInfo.setCreatorID(subOrder.getCreatorID());
        orderDetailInfo.setCreateTime(LocalDateTime.now());
        orderDetailInfo.setIsSync(Boolean.FALSE);
        orderDetailInfo.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
        orderDetailInfoDao.insertSelective(orderDetailInfo);
        orderResultVO.setDetailID(orderDetailInfo.getDetailID());
        orderResultVO.setTagIDs(orderDetail.getTagIDs());
        if (menuInfo.getIsCombo()) {
            for (OrderComboVO combo : orderDetail.getComboList()) {
                //根据valueIDs查询属性值信息
                List<P_CategoryAttributeValueInfoEntity> comboAttributeList = categoryAttributeValueInfoDao.getCategoryAttributeValuesByIDs(combo.getValueIDs());
                P_ProductVariantInfoEntity productVariantInfo;
                O_ComboDetailInfoEntity oComboDetail = new O_ComboDetailInfoEntity();
                if (null != combo.getMappingID()) {
                    P_ComboGroupProductMappingEntity comboGroupProduct = productComponent.getComboGroupProductMappingByID(combo.getMappingID());
                    productVariantInfo = productComponent.getProductVariantByVariantID(combo.getVariantID());
                    oComboDetail.setVariantID(comboGroupProduct.getVariantID());
                    oComboDetail.setProductName(comboGroupProduct.getVariantName());
                    oComboDetail.setPrice(comboGroupProduct.getPrice());
                    oComboDetail.setOriginalPrice(comboGroupProduct.getOriginalPrice());
                    oComboDetail.setProductUnit(comboGroupProduct.getUnitID());
                } else {
                    productVariantInfo = productComponent.getProductVariantByVariantID(combo.getVariantID());
                    P_ComboSettingInfoEntity comboSettingInfo = productComponent.getComboSettingInfoByID(combo.getSettingID());
                    oComboDetail.setVariantID(comboSettingInfo.getVariantID());
                    oComboDetail.setProductName(comboSettingInfo.getVariantName());
                    oComboDetail.setPrice(comboSettingInfo.getPrice());
                    oComboDetail.setOriginalPrice(comboSettingInfo.getOriginalPrice());
                    oComboDetail.setProductUnit(comboSettingInfo.getProductUnit());
                }
                oComboDetail.setServedNum(0);
                oComboDetail.setDetailID(orderDetailInfo.getDetailID());
                oComboDetail.setComboID(menuInfo.getProductID());
                oComboDetail.setComboName(menuInfo.getProductName());
                oComboDetail.setProduceStatus(combo.getProduceStatus());
                oComboDetail.setQuantity(combo.getQuantity());
                //出品时间设置 (当前时间加上制作时间)
                oComboDetail.setProduceTime(DateUtils.addMinute(LocalDateTime.now(), productVariantInfo.getProduceMinute()));
                oComboDetail.setValueIDs(combo.getValueIDs());
                oComboDetail.setCreateTime(LocalDateTime.now());
                oComboDetail.setCategoryID(orderDetailInfo.getCreatorID());
                oComboDetail.setValueNames(getValueNames(comboAttributeList));
                oComboDetail.setRecordID(MaxIDUtils.getID(O_ComboDetailInfoEntity.class));
                comboDetailInfoDao.insertSelective(oComboDetail);
                //插入套餐订单明细属性值关联信息
                addComboDetailValueMappings(comboAttributeList, oComboDetail);

                if(!StringUtils.isEmpty(combo.getTagIDs())){
                    ComboDetailVO comboDetailVO = new ComboDetailVO();
                    comboDetailVO.setRecordID(oComboDetail.getRecordID());
                    comboDetailVO.setTagIDs(combo.getTagIDs());
                    orderResultVO.getComboDetailList().add(comboDetailVO);
                }
            }
        } else {
            //新增订单明细属性值关联信息
            addOrderDetailValueMappings(orderDetailAttributeList, orderDetailInfo, variantInfoEntity.getProduceMinute());
        }
        if(orderDetail.getaLaCarteMethod().equals(OrderManagerEnum.OrderMode.GIVEPRODUCT.getValue())){
            orderResultVO.setTotalAmount(BigDecimal.ZERO);
        }else{
            orderResultVO.setTotalAmount(orderDetailInfo.getTotalAmount());
        }
        return orderResultVO;
    }

    private void handleField(OrderDetailVO orderDetail, B_MerchantMenuInfoEntity menuInfo, O_OrderDetailInfoEntity orderDetailInfo, P_ProductVariantInfoEntity variantInfoEntity) {
        BigDecimal addPrice; //加价 规格,厨师,口味做法,菜单加价
        if (!menuInfo.getIsCombo()) {
            orderDetailInfo.setVariantID(menuInfo.getVariantID());
            orderDetailInfo.setNeedWeigh(menuInfo.getNeedWeigh());
            orderDetailInfo.setQuantity(orderDetail.getQuantity());
            //总价计算
            BigDecimal totalAmount = BigDecimal.ZERO;
            BigDecimal price;
            if (BooleanUtil.valueOf(menuInfo.getNeedWeigh())) {
                orderDetailInfo.setFloatQuantity(NumberUtil.multiply(orderDetail.getExpectedWeight(),Float.valueOf(orderDetail.getQuantity())));
                orderDetailInfo.setExpectedWeight(NumberUtil.multiply(orderDetail.getExpectedWeight(),Float.valueOf(orderDetail.getQuantity())));
                price = BigDecimalUtil.mul(new BigDecimal(orderDetail.getExpectedWeight()), menuInfo.getPrice());
            } else {
                price = BigDecimalUtil.mul(new BigDecimal(orderDetail.getQuantity()), menuInfo.getPrice());
            }
            //口味做法 规格 厨师 加价
            addPrice = addPrice(orderDetailInfo, menuInfo.getProduceCost());
            //加价乘数量
            addPrice = BigDecimalUtil.mul(addPrice, new BigDecimal(orderDetail.getQuantity()));
            //价格加金额
            totalAmount = BigDecimalUtil.add(price, totalAmount);
            //加价加金额
            totalAmount = BigDecimalUtil.add(addPrice, totalAmount);
            orderDetailInfo.setTotalAmount(totalAmount);
        } else {
            //套餐总价计算
            BigDecimal totalAmount = BigDecimalUtil.mul(menuInfo.getPrice(),new BigDecimal(orderDetail.getQuantity()));
            for (OrderComboVO combo : orderDetail.getComboList()) {
                BigDecimal totalPrice;
                if (null != combo.getMappingID()) {
                    P_ComboGroupProductMappingEntity comboGroupProduct = productComponent.getComboGroupProductMappingByID(combo.getMappingID());
                    totalPrice = BigDecimalUtil.mul(comboGroupProduct.getPrice(), new BigDecimal(combo.getQuantity()));
                }else{
                    P_ComboSettingInfoEntity comboSettingInfo = productComponent.getComboSettingInfoByID(combo.getSettingID());
                    totalPrice = BigDecimalUtil.mul(comboSettingInfo.getPrice(), new BigDecimal(combo.getQuantity()));
                }
                totalAmount = BigDecimalUtil.add(totalAmount, totalPrice);
            }
            orderDetailInfo.setComboProductNum(orderDetail.getComboList().size());
            orderDetailInfo.setQuantity(orderDetail.getQuantity());
            orderDetailInfo.setTotalAmount(totalAmount);
        }
        //设置状态
        if (BooleanUtil.valueOf(menuInfo.getNeedWeigh())) {
            //查询在称重档口是否设置此菜的称重信息 如果有则设置为称重档口的字典值
            B_StallProduceMappingEntity stallProduceMappingInfo = stallProduceMappingDao.getStallProduceMappingInfoByVariantID(menuInfo.getVariantID());
            if (null == stallProduceMappingInfo || orderDetail.getProduceStatus().equals(OrderManagerEnum.ProductionStatus.SOCALLED.getValue())) {
                orderDetailInfo.setProduceStatus(orderDetail.getProduceStatus());
            } else {
                orderDetailInfo.setProduceStatus(OrderManagerEnum.WeighingStatus.PENDINGWEIGHING.getValue());
            }
        }else{
            orderDetailInfo.setProduceStatus(orderDetail.getProduceStatus());
        }
        //转赠菜需要设置目标的桌台ID
        if(orderDetail.getaLaCarteMethod().equals(OrderManagerEnum.OrderMode.TURNGIVE.getValue())){
            orderDetailInfo.setTableID(orderDetail.getTableID());
            orderDetailInfo.setTableName(orderDetail.getTableName());
        }
        if (menuInfo.getIsCombo()) {
            //套餐设置字段
            orderDetailInfo.setComboID(menuInfo.getProductID());
            orderDetailInfo.setComboName(menuInfo.getProductName());
            orderDetailInfo.setComboPrice(menuInfo.getPrice());
            orderDetailInfo.setIsCombo(Boolean.TRUE);
        } else {
            //变体设置字段
            orderDetailInfo.setPrice(menuInfo.getPrice());
            orderDetailInfo.setIsCombo(Boolean.FALSE);
            //出品时间设置 (当前时间加上制作时间)
            orderDetailInfo.setProduceTime(DateUtils.addMinute(LocalDateTime.now(), variantInfoEntity.getProduceMinute()));
        }
    }

    /**
     * 根据分类属性返回口味做法拼接名称
     *
     * @param categoryAttributeValuesByIDs
     * @return
     */
    public String getValueNames(List<P_CategoryAttributeValueInfoEntity> categoryAttributeValuesByIDs) {
        List<String> valueNames = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(categoryAttributeValuesByIDs)) {
            for (P_CategoryAttributeValueInfoEntity attributeValue : categoryAttributeValuesByIDs) {
                valueNames.add(attributeValue.getAttributeName());
            }
        }
        return CollectionUtils.isNotEmpty(valueNames) ? StringUtils.join(valueNames.toArray(), ",") : null;
    }

    /**
     * @param categoryAttributeValuesByIDs
     * @param comboDetail
     * @Description： 新增套餐明细关联属性信息
     * @Author：LanZY
     * @Time: 2017-5-8 15:51
     * @Version 2.0.0
     */
    public void addComboDetailValueMappings(List<P_CategoryAttributeValueInfoEntity> categoryAttributeValuesByIDs, O_ComboDetailInfoEntity comboDetail) {
        //插入关联信息
        if (CollectionUtils.isNotEmpty(categoryAttributeValuesByIDs)) {
            for (P_CategoryAttributeValueInfoEntity attributeValue : categoryAttributeValuesByIDs) {
                O_ComboDetailValueMappingEntity comboDetailValue = new O_ComboDetailValueMappingEntity();
                comboDetailValue.setProduceMinute(comboDetail.getProduceMinute());
                comboDetailValue.setAddedPrice(attributeValue.getAddedPrice());
                comboDetailValue.setAttributeValue(attributeValue.getAttributeValue());
                comboDetailValue.setCreatorID(comboDetail.getCategoryID());
                comboDetailValue.setCreateTime(LocalDateTime.now());
                comboDetailValue.setValueID(attributeValue.getValueID());
                comboDetailValue.setMappingStatus(SystemManageEnum.EntityStatus.NORMAL.getValue());
                comboDetailValue.setRecordID(comboDetail.getRecordID());
                comboDetailValue.setMappingID(MaxIDUtils.getID(O_ComboDetailValueMappingEntity.class));
                comboDetailValueMappingDao.insertSelective(comboDetailValue);
            }
        }
    }

    /**
     * @param categoryAttributeValuesByIDs
     * @param orderDetailInfo
     * @param minute
     * @Description： 新增明细属性关联信息
     * @Author：LanZY
     * @Time: 2017-5-8 15:51
     * @Version 2.0.0
     */
    public void addOrderDetailValueMappings(List<P_CategoryAttributeValueInfoEntity> categoryAttributeValuesByIDs, O_OrderDetailInfoEntity orderDetailInfo, Integer minute) {
        //插入关联信息
        if (CollectionUtils.isNotEmpty(categoryAttributeValuesByIDs)) {
            for (P_CategoryAttributeValueInfoEntity attributeValue : categoryAttributeValuesByIDs) {
                O_OrderDetailValueMappingEntity OrderDetailValue = new O_OrderDetailValueMappingEntity();
                OrderDetailValue.setDetailID(orderDetailInfo.getDetailID());
                OrderDetailValue.setValueID(attributeValue.getValueID());
                OrderDetailValue.setAttributeValue(attributeValue.getAttributeValue());
                OrderDetailValue.setAddedPrice(attributeValue.getAddedPrice());
                OrderDetailValue.setProduceMinute(minute);
                OrderDetailValue.setMappingStatus(SystemManageEnum.EntityStatus.NORMAL.getValue());
                OrderDetailValue.setCreatorID(orderDetailInfo.getCreatorID());
                OrderDetailValue.setMappingID(MaxIDUtils.getID(O_OrderDetailValueMappingEntity.class));
                OrderDetailValue.setCreateTime(LocalDateTime.now());
                orderDetailValueMappingDao.insertSelective(OrderDetailValue);
            }
        }
    }


    /**
     * @Description：规格,厨师,口味做法价格累加
     * @Author：LanZY
     * @Time: 2017-4-20 17:17
     * @Version 2.0.0
     */
    public BigDecimal addPrice(O_OrderDetailInfoEntity orderDetail,BigDecimal produceCost) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        //规格加价
        if (NumberUtil.longValue(orderDetail.getOptionID()) > 0) {
            P_VariantSpecificationMappingEntity variantSpecificationMapping = new P_VariantSpecificationMappingEntity();
            variantSpecificationMapping.setVariantID(orderDetail.getVariantID());
            variantSpecificationMapping.setOptionID(orderDetail.getOptionID());
            variantSpecificationMapping = variantSpecificationMappingDao.getVariantSpecificationMappingByVariantIDAndOptionID(variantSpecificationMapping);
            BigDecimal optionAddedPrice = BigDecimal.ZERO;
            if (null != variantSpecificationMapping) {
                optionAddedPrice = variantSpecificationMapping.getFare();
            }
            totalAmount = BigDecimalUtil.add(totalAmount, optionAddedPrice);
        }

        //做法和口味附加价
        if (StringUtils.isNotEmpty(orderDetail.getValueIDs())) {
            List<P_CategoryAttributeValueInfoEntity> categoryAttributeValues = categoryAttributeValueInfoDao.getCategoryAttributeValuesByIDs(orderDetail.getValueIDs());
            BigDecimal valueAddedPrice = CollectionHelper.sum(categoryAttributeValues, attributeValue -> attributeValue.getAddedPrice());
            totalAmount = BigDecimalUtil.add(totalAmount, valueAddedPrice);
        }
        //设置加价包括(口味做法,规格,菜单加价)
        orderDetail.setProduceCost(BigDecimalUtil.add(produceCost,totalAmount));
        //厨师附加价累加
        if (NumberUtil.longValue(orderDetail.getDesignerID()) > 0) {
            P_ProductDesignerMappingEntity productDesignerMapping = new P_ProductDesignerMappingEntity();
            productDesignerMapping.setDesignerID(orderDetail.getDesignerID());
            productDesignerMapping.setVariantID(orderDetail.getVariantID());
            productDesignerMapping = productDesignerMappingDao.getDesignerInfoByVariantIDAndDesignerID(productDesignerMapping);
            BigDecimal designer = BigDecimal.ZERO;
            if (null != productDesignerMapping) {
                designer = productDesignerMapping.getProduceCost();
                orderDetail.setDesignerPrice(productDesignerMapping.getProduceCost());
                orderDetail.setDesignerName(productDesignerMapping.getDesignerName());
            }
            totalAmount = BigDecimalUtil.add(totalAmount, designer);
        }
        totalAmount = BigDecimalUtil.add(totalAmount, produceCost);
        return totalAmount;
    }


    /**
     * @param subOrderID 子订单ID
     * @return
     * @Description： 根据子订单ID查询已下单的订单明细
     * @Author：LanZY
     * @Time: 2017-4-11 11:23
     * @Version 2.0.0
     */
    public UnderOrderVO getUnderOrderList(Long subOrderID){
        UnderOrderVO underOrderVO = new UnderOrderVO();
        List<UnderOrderDetailVO> orderDetailList =  orderDetailInfoDao.getUnderOrderDetailListBySubOrderID(subOrderID);
        List<UnderOrderDetailVO> comboDetailList = orderDetailInfoDao.getUnderComboDetailListBySubOrderID(subOrderID);
        for (UnderOrderDetailVO orderDetail : orderDetailList) {
            for (UnderOrderDetailVO comboDetail : comboDetailList) {
                if(orderDetail.getDetailID().equals(comboDetail.getDetailID())){
                    comboDetail.setDetailID(null);
                    orderDetail.getChilds().add(comboDetail);
                }
            }
        }
        Collections.sort(orderDetailList, Comparator.reverseOrder());
        if (CollectionUtils.isNotEmpty(orderDetailList)) {
            underOrderVO.setSubTotalAmount(orderDetailList.get(0).getSubTotalAmount());
            underOrderVO.setSubTotalNumber(orderDetailList.get(0).getSubTotalNumber());
            underOrderVO.setOrderProductList(orderDetailList);
        }
        return underOrderVO;
    }


    /**
     * @param menuID,floatQuantity ,detailID菜单编号
     * @return
     * @Description 根据菜单编号修改称重信息
     * @author ZhouWei
     * @version 2.0.0
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData updateOrderDetailInfoByVariantID(Long menuID, Float floatQuantity, Long detailID) throws Exception {
        ResultData resultData = new ResultData();
        Map<String, Object> map = new HashMap();
        map.put("floatQuantity", floatQuantity);
        map.put("menuID", menuID);
        map.put("detailID", detailID);
        int ret = orderDetailInfoDao.updateOrderDetailInfoByVariantID(map);
        if (ret > 0) {
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } else {
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return resultData;
    }

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据订单明细ID或套餐ID更新制作状态
     * @time 2017-4-19 10:43
     */
    @Transactional
    public void updateProduceStatusByDetailID(Map map) throws Exception {
        //修改前制作状态集合
        List<Long> befProduceStatusList = new ArrayList<>();
        //修改后制作状态集合
        List<Long> aftProduceStatusList = new ArrayList<>();
        //记录ID集合
        List<Long> recordIDList;
        //厨师ID集合
        List<Long> designerIDList = new ArrayList<>();
        //修改前厨师看板信息
        List<B_DesignerMonitorInfoEntity> beforeDesignerMonitorInfo = new ArrayList<>();
        //修改后厨师看板信息
        List<B_DesignerMonitorInfoEntity> afterDesignerMonitorInfo = new ArrayList<>();

        B_DesignerMonitorInfoEntity setParamsEntity = new B_DesignerMonitorInfoEntity();

        //普通菜品或套餐
        if (null != map.get("detailID")) {
            setParamsEntity.setDetailID(Long.valueOf(map.get("detailID").toString()));

            //根据订单明细ID查询厨师看板信息
            beforeDesignerMonitorInfo = b_DesignerMonitorInfoDao.getDesignerMonitorInfoByDetailID(setParamsEntity);

            for (int i = 0; i < beforeDesignerMonitorInfo.size(); i++) {
                //修改前制作状态
                befProduceStatusList.add(beforeDesignerMonitorInfo.get(i).getProduceStatus());
                designerIDList.add(beforeDesignerMonitorInfo.get(i).getDesignerID());
            }

            //根据订单明细ID更新订单明细制作状态
            orderDetailInfoDao.updateProduceStatusByDetailID(map);

            if (!beforeDesignerMonitorInfo.isEmpty() && beforeDesignerMonitorInfo.size() > 0) {
                //根据订单明细ID更新厨师看板制作状态
                b_DesignerMonitorInfoDao.updateDesignerMonitorInfoByDetailID(map);

                //根据订单明细ID查询厨师看板信息
                afterDesignerMonitorInfo = b_DesignerMonitorInfoDao.getDesignerMonitorInfoByDetailID(setParamsEntity);

                for (int i = 0; i < afterDesignerMonitorInfo.size(); i++) {
                    //修改后制作状态
                    aftProduceStatusList.add(afterDesignerMonitorInfo.get(i).getProduceStatus());
                }
            }
        }

        //套餐明细
        if (null != map.get("recordIDList")) {
            recordIDList = (List) map.get("recordIDList");

            //用来标识套餐明细是否全部等叫或者叫起
            boolean flag = true;

            for (int j = 0; j < recordIDList.size(); j++) {
                setParamsEntity.setRecordID(recordIDList.get(j));
                //根据套餐明细集合ID查询厨师看板信息
                beforeDesignerMonitorInfo = b_DesignerMonitorInfoDao.getDesignerMonitorInfoByRecordID(setParamsEntity);

                for (int i = 0; i < beforeDesignerMonitorInfo.size(); i++) {
                    //修改前制作状态
                    befProduceStatusList.add(beforeDesignerMonitorInfo.get(i).getProduceStatus());
                    designerIDList.add(beforeDesignerMonitorInfo.get(i).getDesignerID());
                }

                O_ComboDetailInfoEntity comboSetParamsEntity = new O_ComboDetailInfoEntity();

                comboSetParamsEntity.setRecordID(recordIDList.get(j));
                comboSetParamsEntity.setProduceStatus(Long.valueOf(map.get("produceStatus").toString()));

                if(null != map.get("produceTime")){
                    comboSetParamsEntity.setProduceTime(DateUtils.parseLocalDateTime(map.get("produceTime").toString()));
                }else {
                    comboSetParamsEntity.setProduceTime(null);
                }

                //根据记录ID更新套餐明细
                o_ComboDetailInfoDao.updateComboByRecordID(comboSetParamsEntity);

                O_ComboDetailInfoEntity comboDetailSetParamsEntity = new O_ComboDetailInfoEntity();

                comboDetailSetParamsEntity.setRecordID(recordIDList.get(j));

                //根据记录ID查询套餐明细信息
                O_ComboDetailInfoEntity comboDetailInfoEntity = o_ComboDetailInfoDao.get(comboDetailSetParamsEntity);

                //套餐下的所有明细制作状态存在不为叫起或者等叫，那么就不用改订单明细中的制作状态，反之则改
                if (!comboDetailInfoEntity.getProduceStatus().equals(Long.valueOf(map.get("produceStatus").toString()))) {
                    flag = false;
                }

                //最后一次循环并且标识为true，那么需要修改订单明细中的制作状态
                if (j == recordIDList.size() - 1 && flag) {
                    map.put("detailID", comboDetailInfoEntity.getDetailID());

                    //根据订单明细ID更新订单明细制作状态
                    orderDetailInfoDao.updateProduceStatusByDetailID(map);
                }

                if (!beforeDesignerMonitorInfo.isEmpty() && beforeDesignerMonitorInfo.size() > 0) {
                    B_DesignerMonitorInfoEntity designerSetParamsEntity = new B_DesignerMonitorInfoEntity();

                    designerSetParamsEntity.setRecordID(recordIDList.get(j));
                    designerSetParamsEntity.setProduceStatus(Long.valueOf(map.get("produceStatus").toString()));

                    //根据记录ID修改制作状态
                    b_DesignerMonitorInfoDao.updateDesignerByRecordID(designerSetParamsEntity);

                    //根据套餐明细集合ID查询厨师看板信息
                    afterDesignerMonitorInfo = b_DesignerMonitorInfoDao.getDesignerMonitorInfoByRecordID(setParamsEntity);

                    for (int i = 0; i < afterDesignerMonitorInfo.size(); i++) {
                        //修改后制作状态
                        aftProduceStatusList.add(afterDesignerMonitorInfo.get(i).getProduceStatus());
                    }
                }
            }
        }

        for (int i = 0; i < befProduceStatusList.size(); i++) {
            B_DesingerProduceDealInfoEntity entity = new B_DesingerProduceDealInfoEntity();

            entity.setDealID(MaxIDUtils.getID(B_DesingerProduceDealInfoEntity.class));
            entity.setBeforeStatus(befProduceStatusList.get(i));
            entity.setAfterStatus(aftProduceStatusList.get(i));
            entity.setCerateTime(LocalDateTime.now());
            entity.setDealType(OrderManagerEnum.DealType.CHANGESTATUS.getValue());
            entity.setDesignerID(designerIDList.get(i));

            //新增厨师制作变动信息
            b_DesingerProduceDealInfoDao.saveDesingerProduceDealInfo(entity);
        }
    }

    /**
     * @Description修改子订单信息
     * @version 2.0.0
     * @time 2017-5-9
     * @author ZhouWei
     */
    public void updateSubOrderMessage(O_OrderDetailInfoEntity o_orderDetailInfoEntity, O_OrderDetailInfoEntity orderDetailInfo) throws Exception {
        //新增订单处理信息
        O_OrderDealInfoEntity orderDealInfo = new O_OrderDealInfoEntity();
        orderDealInfo.setSubOrderID(o_orderDetailInfoEntity.getSubOrderID());
        orderDealInfo.setOrderID(o_orderDetailInfoEntity.getOrderID());
        orderDealInfo.setBeforeStatus(o_orderDetailInfoEntity.getALaCarteMethod());
        orderDealInfo.setAfterStatus(orderDetailInfoDao.get(orderDetailInfo).getALaCarteMethod());
        orderDealInfo.setBeforeAmount(o_orderDetailInfoEntity.getTotalAmount());
        orderDealInfo.setAfterAmount(orderDetailInfoDao.get(orderDetailInfo).getTotalAmount());
        orderDealInfo.setChangeAmount((o_orderDetailInfoEntity.getTotalAmount().subtract(orderDetailInfoDao.get(orderDetailInfo).getTotalAmount())).abs());
        orderDealInfo.setCreatorID(o_orderDetailInfoEntity.getCreatorID());
        orderDealInfo.setCreatorType(o_orderDetailInfoEntity.getCreatorType());
        orderDealInfo.setCreateTime(LocalDateTime.now());
        orderDealInfoService.save(orderDealInfo);
    }

    /**
     * @Description根据点菜方式和menuID查询是否存在订单详情
     * @version 2.0.0
     * @time 2017-5-12
     * @author ZhouWei
     */
    public O_OrderDetailInfoEntity getOrderDetailInfo(Long aLaCarteMethod, Long menuID) {
        Map map = new HashMap();
        map.put("aLaCarteMethod",aLaCarteMethod);
        map.put("menuID",menuID);
        return orderDetailInfoDao.getOrderDetailInfo(map);
    }

    /**
     * @Description是否有可操作的菜
     * @version 2.0.0
     * @time 2017-5-12
     * @author ZhouWei
     */
    public Object getIsOperationFood(O_OrderDetailInfoEntity o_orderDetailInfoEntity, Long aLaCarteMethod) {
        Map<String,Object> map = new HashMap();
        map.put("parentID",o_orderDetailInfoEntity.getParentID());
        map.put("aLaCarteMethod",aLaCarteMethod);
        map.put("needWeigh",o_orderDetailInfoEntity.getNeedWeigh());
        return orderDetailInfoDao.getIsOperationFood(map);
    }

    /**
     * @Description是否有可操作的菜（赠菜）
     * @version 2.0.0
     * @time 2017-5-12
     * @author ZhouWei
     */
    public Object getIsOperationPresentFood(O_OrderDetailInfoEntity o_orderDetailInfoEntity, Long aLaCarteMethod) {
        Map<String,Object> map = new HashMap();
        map.put("parentID",o_orderDetailInfoEntity.getDetailID());
        map.put("aLaCarteMethod",aLaCarteMethod);
        map.put("needWeigh",o_orderDetailInfoEntity.getNeedWeigh());
        return orderDetailInfoDao.getIsOperationFood(map);
    }


    /**
     * @Description 已下单退菜
     * @version 2.0.0
     * @time 2017-4-20
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData revocationFood(Integer quantity, Long detailID, String memo, Long archiveID,Long revocationType) throws Exception {
        ResultData resultData = new ResultData();
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setDetailID(detailID);
        BigDecimal unitPrice = null;
        BigDecimal unitProduceCost = null;
        BigDecimal unitDesignerPrice = null;
        List<O_ComboDetailInfoEntity> comboDetailInfoEntityList = null;
        List<ProductDetailVO> productDetailVOList = new ArrayList<ProductDetailVO>();
        Object ret = null;
        //获得订单明细信息
        O_OrderDetailInfoEntity o_orderDetailInfoEntity = orderDetailInfoDao.get(orderDetailInfo);
        if (o_orderDetailInfoEntity != null) {
            B_MerchantMenuInfoEntity merchantMenuInfo = new B_MerchantMenuInfoEntity();
            merchantMenuInfo.setMenuID(o_orderDetailInfoEntity.getMenuID());
            //获取商品菜单信息
            B_MerchantMenuInfoEntity merchantMenu = merchantMenuInfoDao.get(merchantMenuInfo);
            if (merchantMenu != null) {
                unitPrice = merchantMenu.getPrice() == null ? new BigDecimal(0) : merchantMenu.getPrice();
                unitProduceCost = merchantMenu.getProduceCost() == null ? new BigDecimal(0) : merchantMenu.getProduceCost();
                unitDesignerPrice = o_orderDetailInfoEntity.getDesignerPrice() == null ? new BigDecimal(0) : merchantMenu.getProduceCost();
            }
            o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue());
            //获取子订单信息
            O_SubOrderInfoEntity subOrderInfoEntity = new O_SubOrderInfoEntity();
            subOrderInfoEntity.setSubOrderID(o_orderDetailInfoEntity.getSubOrderID());
            O_SubOrderInfoEntity o_subOrderInfoEntity = subOrderInfoService.get(subOrderInfoEntity);
            //获取订单信息
            O_OrderInfoEntity oOrderInfoEntity = new O_OrderInfoEntity();
            oOrderInfoEntity.setOrderID(o_subOrderInfoEntity.getOrderID());
            O_OrderInfoEntity orderInfoEntity = orderInfoService.get(oOrderInfoEntity);
            ProductDetailVO productDetailVO = new ProductDetailVO();
            if (o_subOrderInfoEntity != null) {
                //新增订单详情,如果订单详情不包含该商品的订单详情信息就新增，否则修改
//                O_OrderDetailInfoEntity orderDetailInfoEntity = getOrderDetailInfo(OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue(), menuID);
                //获取当前订单详情是否还能退菜
                ret = getIsOperationPresentFood(o_orderDetailInfoEntity, OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue());
                if (ret == null){
                    ret = 0;
                }
//                BigDecimal orderTotal = (new BigDecimal(quantity).multiply(unitPrice)).multiply((new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitPrice)).add(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitProduceCost)).add(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitDesignerPrice)));
                BigDecimal returnOrderTotal = (o_orderDetailInfoEntity.getTotalAmount().divide(new BigDecimal(o_orderDetailInfoEntity.getQuantity()))).multiply(new BigDecimal(quantity));
                o_orderDetailInfoEntity.setCreateTime(LocalDateTime.now());
                o_orderDetailInfoEntity.setDetailDesc(memo);
                o_orderDetailInfoEntity.setTotalAmount(returnOrderTotal);
                if (o_orderDetailInfoEntity.getNeedWeigh() != null && o_orderDetailInfoEntity.getNeedWeigh()) {
                    if(Integer.valueOf(ret.toString()) + o_orderDetailInfoEntity.getQuantity() <=0){
                        throw new BizException(CodeMsgConstants.REVOCATION_FOOD_ERROR,CodeMsgConstants.REVOCATION_FOOD_MSG);
                    }
                    //清除档口信息
                    stallWeighInfoDao.deleteByDetailID(o_orderDetailInfoEntity.getDetailID());
                    //清除看板信息
                    designerMonitorInfoDao.deleteByDetailID(o_orderDetailInfoEntity.getDetailID());

                    if (o_subOrderInfoEntity.getOrderWeight() != null && o_orderDetailInfoEntity.getFloatQuantity() != null && o_subOrderInfoEntity.getOrderWeight() >= o_orderDetailInfoEntity.getFloatQuantity()) {
                        o_subOrderInfoEntity.setOrderWeight(o_subOrderInfoEntity.getOrderWeight() - (o_orderDetailInfoEntity.getFloatQuantity()*quantity));
                        o_subOrderInfoEntity.setQuantity(o_subOrderInfoEntity.getQuantity() - quantity);
                    }
                    if (o_subOrderInfoEntity.getTotalAmount() != null && o_orderDetailInfoEntity.getTotalAmount() != null && o_subOrderInfoEntity.getTotalAmount().compareTo(o_orderDetailInfoEntity.getTotalAmount()) >= 0) {
                        o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().subtract(returnOrderTotal));
                    }
                    if (orderInfoEntity.getTotalAmount() != null && o_orderDetailInfoEntity.getTotalAmount() != null && orderInfoEntity.getTotalAmount().compareTo(o_orderDetailInfoEntity.getTotalAmount()) >= 0) {
                        orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().subtract(returnOrderTotal));
                    }
                    if (orderInfoEntity.getOrderWeight() != null && o_orderDetailInfoEntity.getFloatQuantity() != null && orderInfoEntity.getOrderWeight() >= o_orderDetailInfoEntity.getFloatQuantity()) {
                        orderInfoEntity.setOrderWeight(orderInfoEntity.getOrderWeight() - (o_orderDetailInfoEntity.getFloatQuantity()*quantity));
                        orderInfoEntity.setQuantity(orderInfoEntity.getQuantity() - quantity);
                    }
//                    if (orderDetailInfoEntity != null) {
//                        if(orderDetailInfoEntity.getFloatQuantity()>=o_orderDetailInfoEntity.getFloatQuantity()){
//                            new BizException(CodeMsgConstants.REVOCATION_FOOD_ERROR,CodeMsgConstants.REVOCATION_FOOD_MSG);
//                        }
//                        if (orderDetailInfoEntity.getFloatQuantity() != null && o_orderDetailInfoEntity.getFloatQuantity() != null) {
//                            orderDetailInfoEntity.setFloatQuantity(orderDetailInfoEntity.getFloatQuantity() + o_orderDetailInfoEntity.getFloatQuantity());
//                        }
//                        if (orderDetailInfoEntity.getProduceCost() != null && o_orderDetailInfoEntity.getProduceCost() != null) {
//                            orderDetailInfoEntity.setProduceCost(orderDetailInfoEntity.getProduceCost().add(o_orderDetailInfoEntity.getProduceCost()));
//                        }
//                        orderDetailInfoEntity.setOriginalPrice(o_orderDetailInfoEntity.getOriginalPrice());
//                        if (orderDetailInfoEntity.getTotalAmount() != null && o_orderDetailInfoEntity.getTotalAmount() != null) {
//                            orderDetailInfoEntity.setTotalAmount(orderDetailInfoEntity.getTotalAmount().add(o_orderDetailInfoEntity.getTotalAmount()));
//                        }
//                        orderDetailInfoDao.update(orderDetailInfoEntity);
//                    } else {
                        o_orderDetailInfoEntity.setParentID(o_orderDetailInfoEntity.getDetailID());
                        o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                        o_orderDetailInfoEntity.setCreateTime(LocalDateTime.now());
//                        o_orderDetailInfoEntity.setFloatQuantity(NumberUtil.negate(o_orderDetailInfoEntity.getFloatQuantity()));
                        o_orderDetailInfoEntity.setQuantity(NumberUtil.negate(quantity));
                        orderDetailInfoDao.insert(o_orderDetailInfoEntity);
//                    }
                } else {
                    if(Integer.valueOf(ret.toString()) + o_orderDetailInfoEntity.getQuantity() <=0){
                        throw new BizException(CodeMsgConstants.REVOCATION_FOOD_ERROR,CodeMsgConstants.REVOCATION_FOOD_MSG);
                    }
                    if(Integer.valueOf(ret.toString()) + o_orderDetailInfoEntity.getQuantity() < quantity){
                        throw new BizException(CodeMsgConstants.REVOCATION_FOOD_ERROR,CodeMsgConstants.REVOCATION_FOOD_MSG);
                    }
                    if (o_subOrderInfoEntity.getQuantity() != null && quantity != null && o_subOrderInfoEntity.getQuantity() >= quantity) {
                        o_subOrderInfoEntity.setQuantity(o_subOrderInfoEntity.getQuantity() - quantity);
                    }
//                    BigDecimal returnFoodTotal = unitPrice.multiply(new BigDecimal(quantity)).add(unitProduceCost.multiply(new BigDecimal(quantity))).add(unitDesignerPrice.multiply(new BigDecimal(quantity)));
//                    BigDecimal returnFoodTotal = (o_orderDetailInfoEntity.getTotalAmount().divide(new BigDecimal(o_orderDetailInfoEntity.getQuantity()))).multiply(new BigDecimal(quantity));
                    if (o_subOrderInfoEntity.getTotalAmount() != null && returnOrderTotal != null && o_subOrderInfoEntity.getTotalAmount().compareTo(returnOrderTotal) >= 0) {
                        o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().subtract(returnOrderTotal));
                    }
                    if (orderInfoEntity.getTotalAmount() != null && returnOrderTotal != null && orderInfoEntity.getTotalAmount().compareTo(returnOrderTotal) >= 0) {
                        orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().subtract(returnOrderTotal));
                    }
                    if (orderInfoEntity.getQuantity() != null && quantity != null && orderInfoEntity.getQuantity() >= quantity) {
                        orderInfoEntity.setQuantity(orderInfoEntity.getQuantity() - quantity);
                    }
//                    orderInfoEntity.setOrderDesc(memo);
//                    if (orderDetailInfoEntity != null) {
//                        if (o_orderDetailInfoEntity.getQuantity() != null && quantity != null) {
//                            if(orderDetailInfoEntity.getQuantity()>=quantity){
//                                new BizException(CodeMsgConstants.REVOCATION_FOOD_ERROR,CodeMsgConstants.REVOCATION_FOOD_MSG);
//                            }
//                            orderDetailInfoEntity.setQuantity(o_orderDetailInfoEntity.getQuantity() + quantity);
//                            orderDetailInfoEntity.setProduceCost(unitProduceCost.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity() + quantity)));
//                            orderDetailInfoEntity.setOriginalPrice(unitPrice);
//                            orderDetailInfoEntity.setTotalAmount(unitPrice.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity() + quantity)).add(unitProduceCost.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity() + quantity))));
//                            orderDetailInfoDao.update(orderDetailInfoEntity);
//                        }
//                    } else {
                        if (quantity != null) {
                            o_orderDetailInfoEntity.setParentID(o_orderDetailInfoEntity.getDetailID());
                            o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                            o_orderDetailInfoEntity.setQuantity(NumberUtil.negate(quantity));
                            o_orderDetailInfoEntity.setProduceCost(unitProduceCost.multiply(new BigDecimal(quantity)));
//                            o_orderDetailInfoEntity.setOriginalPrice(unitPrice);
//                            o_orderDetailInfoEntity.setTotalAmount(unitPrice.multiply(new BigDecimal(quantity)).add(unitProduceCost.multiply(new BigDecimal(quantity))).add(unitDesignerPrice.multiply(new BigDecimal(quantity))));
                            o_orderDetailInfoEntity.setTotalAmount(returnOrderTotal);
                            o_orderDetailInfoEntity.setCreateTime(LocalDateTime.now());
                            orderDetailInfoDao.insert(o_orderDetailInfoEntity);
                        }
//                    }
                }
                if (!("1").equals(revocationType)){
                    //沽清退菜(非报损退菜)
                    curbSaleComponent.returnProduct(Arrays.asList(o_orderDetailInfoEntity.getDetailID()), archiveID);
                }else{
                    //报损退菜
                    curbSaleComponent.returnLossProduct(Arrays.asList(detailID),archiveID);
                }
                //修改子订单信息
                subOrderInfoService.update(o_subOrderInfoEntity);
                //修改订单信息
                orderInfoService.update(orderInfoEntity);
                //新增订单处理信息
//                updateSubOrderMessage(o_orderDetailInfoEntity, orderDetailInfo);
//                Map map = new HashMap();
                //看板更新记录信息
//                map.put("produceStatus", OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue());
//                map.put("detailID", detailID);
//                updateProduceStatusByDetailID(map);
                if (o_orderDetailInfoEntity.getIsCombo()){
                    productDetailVOList= productInfoDao.getPrintComboProductDetailBasic(Arrays.asList(o_orderDetailInfoEntity.getDetailID()));
                }else{
                    productDetailVO = productComponent.getPrintProductDetailList(Arrays.asList(o_orderDetailInfoEntity.getDetailID())).get(0);
                }
                TableInfoVO tableInfoVO = productComponent.getPrintTable(o_subOrderInfoEntity.getSubOrderID());
                OrderPrintVO orderPrintVO = new OrderPrintVO();
                orderPrintVO.setTableInfo(tableInfoVO);
                orderPrintVO.setProductDetailVO(productDetailVO);
                orderPrintVO.setProductDetailVOList(productDetailVOList);
                resultData.setData(orderPrintVO);
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            }
        }
        return resultData;
    }

    /**
     * @Description 已下单加菜
     * @version 2.0.0
     * @time 2017-4-20
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData addFood(Long detailID,Long recordID,Long archiveID) throws Exception {
        ResultData resultData = new ResultData();
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setDetailID(detailID);
//        BigDecimal unitPrice = null;
//        BigDecimal unitProduceCost = null;
//        BigDecimal unitOriginalPricePrice = null;
        //获得订单明细信息
        O_OrderDetailInfoEntity o_orderDetailInfoEntity = orderDetailInfoDao.get(orderDetailInfo);
        //沽清加菜
        curbSaleComponent.addProduct(Arrays.asList(o_orderDetailInfoEntity.getDetailID()),archiveID);
        if (o_orderDetailInfoEntity.getIsCombo()){
            if (recordID == null) {
                throw new BizException(CodeMsgConstants.PARAM_ERROR,CodeMsgConstants.PARAM_ERROR_MSG);
            }
            O_ComboDetailInfoEntity comboDetailInfoEntity = new O_ComboDetailInfoEntity();
            comboDetailInfoEntity.setRecordID(recordID);
            comboDetailInfoEntity = comboDetailInfoDao.get(comboDetailInfoEntity);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            resultData.setData(comboDetailInfoEntity);
            return resultData;
        }
//        if (o_orderDetailInfoEntity != null) {
//            B_MerchantMenuInfoEntity merchantMenuInfo = new B_MerchantMenuInfoEntity();
//            merchantMenuInfo.setMenuID(menuID);
//            //获取商品菜单信息
//            B_MerchantMenuInfoEntity merchantMenu = merchantMenuInfoDao.get(merchantMenuInfo);
//            if (merchantMenu != null) {
//                unitPrice = merchantMenu.getPrice();
//                unitProduceCost = merchantMenu.getProduceCost();
//                unitOriginalPricePrice = merchantMenu.getOriginalPrice();
//            }
//            o_orderDetailInfoEntity.setDetailID(detailID);
//            if (o_orderDetailInfoEntity.getQuantity() != null && o_orderDetailInfoEntity.getQuantity() >= quantity) {
//                o_orderDetailInfoEntity.setQuantity(o_orderDetailInfoEntity.getQuantity() + quantity);
//            }
//            o_orderDetailInfoEntity.setMenuID(menuID);
//            if (!o_orderDetailInfoEntity.getProduceCost().equals(null)) {
//                o_orderDetailInfoEntity.setProduceCost(o_orderDetailInfoEntity.getProduceCost().add(unitProduceCost.multiply(new BigDecimal(quantity))));
//            }
//            o_orderDetailInfoEntity.setOriginalPrice(o_orderDetailInfoEntity.getOriginalPrice().add(unitOriginalPricePrice.multiply(new BigDecimal(quantity))).add(unitProduceCost.multiply(new BigDecimal(quantity))));
//            o_orderDetailInfoEntity.setTotalAmounts(o_orderDetailInfoEntity.getTotalAmounts() + unitPrice.multiply(new BigDecimal(quantity)).doubleValue() + unitProduceCost.multiply(new BigDecimal(quantity)).doubleValue());
//            o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.ADDPRODUCT.getValue());
//            //修改订单详情
//            orderDetailInfoDao.update(o_orderDetailInfoEntity);

                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                resultData.setData(o_orderDetailInfoEntity);
//            //获取子订单信息,修改子订单信息
//            O_SubOrderInfoEntity o_subOrderInfoEntity = subOrderInfoService.getById(o_orderDetailInfoEntity.getSubOrderID());
//            if (o_subOrderInfoEntity != null) {
//                o_subOrderInfoEntity.setQuantity(o_subOrderInfoEntity.getQuantity() + quantity);
//                o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().add(unitPrice.multiply(new BigDecimal(quantity))).add(unitProduceCost.multiply(new BigDecimal(quantity))));
//                subOrderInfoService.update(o_subOrderInfoEntity);
//                //修改订单信息
//                O_OrderInfoEntity orderInfoEntity = orderInfoService.getById(o_subOrderInfoEntity.getOrderID());
//                orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().add(unitPrice.multiply(new BigDecimal(quantity))).add(unitProduceCost.multiply(new BigDecimal(quantity))));
//                orderInfoEntity.setQuantity(orderInfoEntity.getQuantity() + quantity);
//                orderInfoService.update(orderInfoEntity);
//                //新增订单处理信息
//                updateSubOrderMessage(o_orderDetailInfoEntity, orderDetailInfo);
//                Map map = new HashMap();
//                map.put("produceStatus", OrderManagerEnum.OrderMode.ADDPRODUCT.getValue());
//                map.put("detailID", detailID);
//                updateProduceStatusByDetailID(map);
//                resultData.setCode(CodeMsgConstants.SUCCESS);
//                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
//            }
//        }
        return resultData;
    }

    /**
     * @param subOrderID
     * @return
     * @Description 根据子订单ID获取订单信息详情
     * @author ZhouWei
     * @version 2.0.0
     * @time 2017-04-21
     */
    public List<O_OrderDetailInfoEntity> getUnderOrderDetailInfoList(Long subOrderID) {
        return orderDetailInfoDao.getOrderDetailInfoList(subOrderID);
    }

    /**
     * @Description 已下单批量退菜打印
     * @version 2.0.0
     * @time 2017-4-20
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData revocationFoodBatch(Integer[] quantitys,Long[] detailIDs,String memo, Long archiveID,Long revocationType) throws Exception {
        ResultData resultData = new ResultData();
        List<ProductDetailVO> productDetailVOList = new ArrayList<ProductDetailVO>();
        OrderPrintVO orderPrintVO = new OrderPrintVO();
        for (int i = 0; i < detailIDs.length; i++) {
            Long detailID = (Long) detailIDs[i];
            Integer quantity = (Integer) quantitys[i];
            resultData = revocationFood(quantity, detailID, memo, archiveID, revocationType);
            orderPrintVO = (OrderPrintVO) resultData.getData();
            productDetailVOList.add(orderPrintVO.getProductDetailVO());
        }
        try {
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            printComponent.printTableTicket(orderPrintVO.getTableInfo(), productDetailVOList);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return resultData;
    }

    /**
     * @Description 已下单退菜打印
     * @version 2.0.0
     * @time 2017-4-20
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData revocationFoodAndPrint(Integer quantity,Long detailID,String memo, Long archiveID,Long revocationType) throws Exception {
        ResultData resultData = new ResultData();
        resultData = revocationFood(quantity, detailID, memo, archiveID, revocationType);
        try {
            OrderPrintVO orderPrintVO = (OrderPrintVO) resultData.getData();
            if (CollectionUtils.isNotEmpty(orderPrintVO.getProductDetailVOList()) && orderPrintVO.getProductDetailVOList().size() > 0) {
                printComponent.printTableTicket(orderPrintVO.getTableInfo(), orderPrintVO.getProductDetailVOList());
            } else {
                printComponent.printProductTicket(orderPrintVO.getTableInfo(), orderPrintVO.getProductDetailVO());
            }
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultData;
    }

    /**
     * @Description 已下单退菜,赠菜原因
     * @version 2.0.0
     * @time 2017-4-20
     * @author ZhouWei
     */

    public List<ReasonVO>  getFoodReason(DictionaryCatalogEnum reasonCode,Long archiveID) throws Exception {
        List<ReasonVO> dictionaryReason =  dictionaryComponent.getReasonByCatalogCode(reasonCode,archiveID);
        return dictionaryReason;
    }

    /**
     * @Description 已下单转菜打印
     * @version 2.0.0
     * @time 2017-4-20
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData changeFoodTableAndPrint(Long detailID, Integer quantity, Long subOrderID,Long archiveID) throws Exception {
        ResultData resultData = new ResultData();
        resultData = changeFoodTable(detailID, quantity, subOrderID,archiveID);
        try {
            OrderPrintVO orderPrintVO =(OrderPrintVO) resultData.getData();
            printComponent.printProductTicket(orderPrintVO.getTableInfo(),orderPrintVO.getProductDetailVO());
        }catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return resultData;
    }

    /**
     * @Description 已下单赠菜
     * @version 2.0.0
     * @time 2017-4-20
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData presentFood(Integer quantity, Long detailID, String memo, Float floatQuantity) throws Exception {
        ResultData resultData = new ResultData();
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setDetailID(detailID);
        BigDecimal unitPrice = null;
        BigDecimal unitProduceCost = null;
        BigDecimal unitDesignerPrice = null;
        Object ret = null;
        //获得订单明细信息
        O_OrderDetailInfoEntity orderDetailInfoEntity = orderDetailInfoDao.get(orderDetailInfo);
        if (orderDetailInfoEntity != null) {
            B_MerchantMenuInfoEntity merchantMenuInfo = new B_MerchantMenuInfoEntity();
            merchantMenuInfo.setMenuID(orderDetailInfoEntity.getMenuID());
            //获取商品菜单信息
            B_MerchantMenuInfoEntity merchantMenu = merchantMenuInfoDao.get(merchantMenuInfo);
            if (merchantMenu != null) {
                unitPrice = merchantMenu.getPrice() == null ? new BigDecimal(0) : merchantMenu.getPrice();
                unitProduceCost = merchantMenu.getProduceCost() == null ? new BigDecimal(0):merchantMenu.getProduceCost();
                unitDesignerPrice = orderDetailInfoEntity.getDesignerPrice() == null?new BigDecimal(0):orderDetailInfoEntity.getDesignerPrice();
            }
            //获取子订单信息,修改子订单信息
            O_SubOrderInfoEntity subOrderInfoEntity = new O_SubOrderInfoEntity();
            subOrderInfoEntity.setSubOrderID(orderDetailInfoEntity.getSubOrderID());
            O_SubOrderInfoEntity o_subOrderInfoEntity = subOrderInfoService.get(subOrderInfoEntity);
            //获取订单信息
            O_OrderInfoEntity orderInfo = new O_OrderInfoEntity();
            orderInfo.setOrderID(o_subOrderInfoEntity.getOrderID());
            O_OrderInfoEntity orderInfoEntity = orderInfoService.get(orderInfo);
            O_OrderDiscountMappingEntity orderDiscountMapping = new O_OrderDiscountMappingEntity();
            ret = getIsOperationPresentFood(orderDetailInfoEntity, OrderManagerEnum.OrderMode.GIVEPRODUCT.getValue());
            if (ret == null){
                ret = 0;
            }
            Object TempRet = null;
            TempRet = getIsOperationPresentFood(orderDetailInfoEntity, OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue());
            if (TempRet == null){
                TempRet = 0;
            }
            O_OrderDetailInfoEntity o_orderDetailInfoEntity =  new O_OrderDetailInfoEntity();
            BeanUtils.copyProperties(o_orderDetailInfoEntity,orderDetailInfoEntity);
//            orderDiscountMapping.setMappingOrderID(orderDetailInfoEntity.getOrderID());
            if (o_subOrderInfoEntity != null) {
                //新增订单详情,如果订单详情不包含该商品的订单详情信息就新增，否则修改
//                O_OrderDetailInfoEntity orderDetailInfoEntity = getOrderDetailInfo(OrderManagerEnum.OrderMode.GIVEPRODUCT.getValue(), menuID);
                o_orderDetailInfoEntity.setDetailDesc(memo);
                BigDecimal orderTotal = (orderDetailInfoEntity.getTotalAmount().divide(new BigDecimal(orderDetailInfoEntity.getQuantity()))).multiply(new BigDecimal(quantity));
                if(o_orderDetailInfoEntity.getQuantity() + Integer.valueOf(TempRet.toString())<=0){
                    throw new BizException(CodeMsgConstants.PRESENT_FOOD_ERROR,CodeMsgConstants.PRESENT_FOOD_MSG);
                }
                if(o_orderDetailInfoEntity.getQuantity() + Integer.valueOf(TempRet.toString())  < quantity){
                    throw new BizException(CodeMsgConstants.PRESENT_FOOD_ERROR,CodeMsgConstants.PRESENT_FOOD_MSG);
                }
                if (o_orderDetailInfoEntity.getNeedWeigh() != null && o_orderDetailInfoEntity.getNeedWeigh()) {
//                    BigDecimal orderTotal = (new BigDecimal(quantity).multiply(unitPrice)).multiply((new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitPrice)).add(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitProduceCost)).add(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitDesignerPrice)));
                    if (orderDetailInfoEntity.getQuantity().equals(quantity - Integer.valueOf(TempRet.toString()))){
                      o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.GIVEPRODUCT.getValue());
                      o_orderDetailInfoEntity.setParentID(o_orderDetailInfoEntity.getDetailID());
                    }else {
//                      o_orderDetailInfoEntity.setFloatQuantity(o_orderDetailInfoEntity.getFloatQuantity() - floatQuantity);
                      o_orderDetailInfoEntity.setQuantity(orderDetailInfoEntity.getQuantity() - quantity);
                      o_orderDetailInfoEntity.setTotalAmount(orderDetailInfoEntity.getTotalAmount().subtract(orderTotal));
                    }
                    orderDetailInfoDao.update(o_orderDetailInfoEntity);
                    o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().subtract(orderTotal));
                    orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().subtract(orderTotal));
                    orderDiscountMapping.setDiscountAmount(orderTotal);
                    if (!orderDetailInfoEntity.getQuantity().equals(quantity - Integer.valueOf(TempRet.toString())) ) {
                        //称重商品赠菜
//                    if (orderDetailInfoEntity != null) {
//                        orderDetailInfoEntity.setFloatQuantity(orderDetailInfoEntity.getFloatQuantity() + floatQuantity);
//                        orderDetailInfoEntity.setTotalAmount(orderDetailInfoEntity.getTotalAmount().add(orderTotal));
//                        orderDetailInfoDao.update(orderDetailInfoEntity);
//                    } else {
                        o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.GIVEPRODUCT.getValue());
                        o_orderDetailInfoEntity.setParentID(orderDetailInfoEntity.getDetailID());
                        o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
//                        o_orderDetailInfoEntity.setFloatQuantity(floatQuantity);
                        o_orderDetailInfoEntity.setTotalAmount(orderTotal);
                        o_orderDetailInfoEntity.setQuantity(orderDetailInfoEntity.getQuantity() - quantity);
                        o_orderDetailInfoEntity.setCreateTime(LocalDateTime.now());
                        orderDetailInfoDao.insert(o_orderDetailInfoEntity);
//                    }
                    }
                } else {
                    if (orderDetailInfoEntity.getQuantity() != null && orderDetailInfoEntity.getQuantity() >= quantity) {
//                        BigDecimal orderTotal = (new BigDecimal(quantity).multiply(unitPrice)).add(new BigDecimal(quantity).multiply(unitProduceCost)).add(new BigDecimal(quantity).multiply(unitDesignerPrice));
                        if (o_orderDetailInfoEntity.getQuantity().equals(quantity - Integer.valueOf(TempRet.toString())) ){
                            o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.GIVEPRODUCT.getValue());
                            o_orderDetailInfoEntity.setParentID(o_orderDetailInfoEntity.getDetailID());
                        }else {
                            o_orderDetailInfoEntity.setQuantity(o_orderDetailInfoEntity.getQuantity() - quantity);
                            o_orderDetailInfoEntity.setTotalAmount(o_orderDetailInfoEntity.getTotalAmount().subtract(orderTotal));
                        }
                        orderDetailInfoDao.update(o_orderDetailInfoEntity);
                        o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().subtract(orderTotal));
                        orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().subtract(orderTotal));
                        orderDiscountMapping.setDiscountAmount(orderTotal);
                        if (!orderDetailInfoEntity.getQuantity().equals(quantity - Integer.valueOf(TempRet.toString())) ){
//                        if (orderDetailInfoEntity != null) {
//                            if (orderDetailInfoEntity.getQuantity() != null){
//                                orderDetailInfoEntity.setQuantity(orderDetailInfoEntity.getQuantity() + quantity);
//                            }
//                            if (orderDetailInfoEntity.getTotalAmount() != null){
//                                orderDetailInfoEntity.setTotalAmount(orderDetailInfoEntity.getTotalAmount().add(orderTotal));
//                            }
//                            orderDetailInfoDao.update(orderDetailInfoEntity);
//                        }
//                        else {
                            o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.GIVEPRODUCT.getValue());
                            o_orderDetailInfoEntity.setParentID(orderDetailInfoEntity.getDetailID());
                            o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                            o_orderDetailInfoEntity.setQuantity(quantity);
                            o_orderDetailInfoEntity.setTotalAmount(orderTotal);
                            o_orderDetailInfoEntity.setCreateTime(LocalDateTime.now());
                            orderDetailInfoDao.insert(o_orderDetailInfoEntity);
//                        }
                        }
                    }
                }
                //修改子订单信息
                subOrderInfoService.update(o_subOrderInfoEntity);
                //修改订单信息
                orderInfoService.update(orderInfoEntity);
//                //新增订单处理信息
//                updateSubOrderMessage(o_orderDetailInfoEntity, orderDetailInfo);
//                Map map = new HashMap();
//                map.put("produceStatus", OrderManagerEnum.OrderMode.GIVEPRODUCT.getValue());
//                map.put("detailID", detailID);
//                updateProduceStatusByDetailID(map);
                //修改折扣信息
                orderDiscountMapping.setOrderID(o_orderDetailInfoEntity.getOrderID());
                orderDiscountMapping.setLoginID(o_orderDetailInfoEntity.getLoginID());
                orderDiscountMapping.setSubOrderID(o_orderDetailInfoEntity.getSubOrderID());
                orderDiscountMapping.setIsRatio(false);
                orderDiscountMapping.setDiscountType(ProductManageEnum.DiscountType.DISCOUNT.getValue());
                orderDiscountMapping.setIsManualProcess(true);
                orderDiscountMapping.setCreatorID(o_orderDetailInfoEntity.getCreatorID());
                orderDiscountMapping.setCreatorType(o_orderDetailInfoEntity.getCreatorType());
                orderDiscountMapping.setCreateTime(LocalDateTime.now());
                orderDiscountMapping.setIsSync(false);
                orderDiscountMapping.setMappingID(MaxIDUtils.getID(O_OrderDiscountMappingEntity.class));
                o_orderDiscountMappingDao.insert(orderDiscountMapping);
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            }
        }
        return resultData;
    }

    /**
     * @Description 已下单取消赠菜
     * @version 2.0.0
     * @time 2017-4-25
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData unPresentFood(Integer quantity, Long detailID, Float floatQuantity) throws Exception {
        ResultData resultData = new ResultData();
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setDetailID(detailID);
        BigDecimal unitPrice = null;
        BigDecimal unitProduceCost = null;
        BigDecimal unitDesignerPrice = null;
        //获得订单明细信息
        O_OrderDetailInfoEntity o_orderDetailInfoEntity = orderDetailInfoDao.get(orderDetailInfo);
        if (o_orderDetailInfoEntity != null) {
            B_MerchantMenuInfoEntity merchantMenuInfo = new B_MerchantMenuInfoEntity();
            merchantMenuInfo.setMenuID(o_orderDetailInfoEntity.getMenuID());
            //获取商品菜单信息
            B_MerchantMenuInfoEntity merchantMenu = merchantMenuInfoDao.get(merchantMenuInfo);
            if (merchantMenu != null) {
                unitPrice = merchantMenu.getPrice() == null ? new BigDecimal(0) : merchantMenu.getPrice();
                unitProduceCost = merchantMenu.getProduceCost() == null ? new BigDecimal(0):merchantMenu.getProduceCost();
                unitDesignerPrice = o_orderDetailInfoEntity.getDesignerPrice() == null?new BigDecimal(0):o_orderDetailInfoEntity.getDesignerPrice();
            }
            //获取子订单信息,修改子订单信息
            O_SubOrderInfoEntity subOrderInfoEntity = new O_SubOrderInfoEntity();
            subOrderInfoEntity.setSubOrderID(o_orderDetailInfoEntity.getSubOrderID());
            O_SubOrderInfoEntity o_subOrderInfoEntity = subOrderInfoService.get(subOrderInfoEntity);
            //获取订单信息
            O_OrderInfoEntity oOrderInfoEntity = new O_OrderInfoEntity();
            oOrderInfoEntity.setOrderID(o_subOrderInfoEntity.getOrderID());
            O_OrderInfoEntity orderInfoEntity = orderInfoService.get(oOrderInfoEntity);
            O_OrderDiscountMappingEntity orderDiscountMapping = new O_OrderDiscountMappingEntity();
            if (o_subOrderInfoEntity != null) {
                //新增订单详情,如果订单详情不包含该商品的订单详情信息就新增，否则修改
//                O_OrderDetailInfoEntity orderDetailInfoEntity = getOrderDetailInfo(OrderManagerEnum.OrderMode.GIVEPRODUCT.getValue(), menuID);
                //获取当前订单详情是否还能退菜
                Object ret = null;
                ret = getIsOperationFood(o_orderDetailInfoEntity, OrderManagerEnum.OrderMode.GIVEPRODUCT.getValue());
                if (ret == null){
                    ret = 0;
                }
                if (Integer.valueOf(ret.toString()) - quantity <0){
                    throw new BizException(CodeMsgConstants.UNPRESENT_FOOD_ERROR,CodeMsgConstants.UNPRESENT_FOOD_MSG);
                }
                BigDecimal orderTotal = (o_orderDetailInfoEntity.getTotalAmount().divide(new BigDecimal(o_orderDetailInfoEntity.getQuantity()))).multiply(new BigDecimal(quantity));
                if (o_orderDetailInfoEntity.getNeedWeigh() != null && o_orderDetailInfoEntity.getNeedWeigh()) {
//                    BigDecimal orderTotal = (new BigDecimal(quantity).multiply(unitPrice)).multiply((new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitPrice)).add(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitProduceCost)).add(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitDesignerPrice)));
                    //称重商品取消赠菜
                    o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().add(orderTotal));
                    orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().add(orderTotal));
//                    BigDecimal orderTotal = (new BigDecimal(floatQuantity).multiply(unitPrice)).add(new BigDecimal(floatQuantity).multiply(unitProduceCost)).add(new BigDecimal(floatQuantity).multiply(unitDesignerPrice));
                    orderDiscountMapping.setDiscountAmount(orderTotal);
//                    if (orderDetailInfoEntity != null) {
//                        orderDetailInfoEntity.setFloatQuantity(orderDetailInfoEntity.getFloatQuantity() - floatQuantity);
//                        orderDetailInfoEntity.setTotalAmount(orderDetailInfoEntity.getTotalAmount().subtract(orderTotal));
//                        orderDetailInfoDao.update(orderDetailInfoEntity);
//                    } else {
//                        throw new BizException(CodeMsgConstants.NOT_PRESENTFOOD_ERROR, CodeMsgConstants.NOT_PRESENTFOOD_MSG);
//                    }

                } else {
//                    BigDecimal orderTotal = (new BigDecimal(quantity).multiply(unitPrice)).add(new BigDecimal(quantity).multiply(unitProduceCost)).add(new BigDecimal(quantity).multiply(unitDesignerPrice));
                    o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().add(orderTotal));
                    orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().add(orderTotal));
                    orderDiscountMapping.setDiscountAmount(orderTotal);
//                    if (orderDetailInfoEntity != null) {
//                        if (orderDetailInfoEntity.getQuantity() != null && orderDetailInfoEntity.getQuantity() >= quantity) {
//                            orderDetailInfoEntity.setQuantity(orderDetailInfoEntity.getQuantity() - quantity);
//                            orderDetailInfoEntity.setTotalAmount(orderDetailInfoEntity.getTotalAmount().subtract(orderTotal));
//                            orderDetailInfoDao.update(orderDetailInfoEntity);
//                        }
//                    } else {
//                        throw new BizException(CodeMsgConstants.NOT_PRESENTFOOD_ERROR, CodeMsgConstants.NOT_PRESENTFOOD_MSG);
//                    }
                }
                o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.NORMALORDERPRODUCT.getValue());
                orderDetailInfoDao.update(o_orderDetailInfoEntity);
                subOrderInfoService.update(o_subOrderInfoEntity);
                //修改订单信息
                orderInfoService.update(orderInfoEntity);
                //新增订单处理信息
//                updateSubOrderMessage(o_orderDetailInfoEntity, orderDetailInfo);
//                Map map = new HashMap();
//                map.put("produceStatus", OrderManagerEnum.OrderMode.GIVEPRODUCT.getValue());
//                map.put("detailID", detailID);
//                updateProduceStatusByDetailID(map);
                //修改折扣信息
                orderDiscountMapping.setOrderID(o_orderDetailInfoEntity.getOrderID());
                orderDiscountMapping.setLoginID(o_orderDetailInfoEntity.getLoginID());
                orderDiscountMapping.setSubOrderID(o_orderDetailInfoEntity.getSubOrderID());
                orderDiscountMapping.setIsRatio(false);
                orderDiscountMapping.setDiscountType(ProductManageEnum.DiscountType.DISCOUNT.getValue());
                orderDiscountMapping.setIsManualProcess(true);
                orderDiscountMapping.setCreatorID(o_orderDetailInfoEntity.getCreatorID());
                orderDiscountMapping.setCreatorType(o_orderDetailInfoEntity.getCreatorType());
                orderDiscountMapping.setCreateTime(LocalDateTime.now());
                o_orderDiscountMappingDao.delete(orderDiscountMapping);
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            }
        }
        return resultData;
    }


    /**
     * @Description 已下单同价换菜
     * @version 2.0.0
     * @time 2017-4-25
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData changeFood(Long detailID, Long changeMenuID) throws Exception {
        ResultData resultData = new ResultData();
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setDetailID(detailID);
        //获得订单明细信息
        O_OrderDetailInfoEntity o_orderDetailInfoEntity = orderDetailInfoDao.get(orderDetailInfo);
        //新增订单详情,如果订单详情不包含该商品的订单详情信息就新增，否则修改
//        O_OrderDetailInfoEntity orderDetailInfoEntity = getOrderDetailInfo(OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue(), menuID);
        //获取原菜单信息
        B_MerchantMenuInfoEntity oldMerchantMenuInfo = new B_MerchantMenuInfoEntity();
        oldMerchantMenuInfo.setMenuID(o_orderDetailInfoEntity.getMenuID());
//        B_MerchantMenuInfoEntity old_MerchantMenuInfo = merchantMenuInfoDao.get(oldMerchantMenuInfo);
        //获取需要换菜的菜单信息
        if (changeMenuID != null) {
            B_MerchantMenuInfoEntity newMerchantMenuInfo = new B_MerchantMenuInfoEntity();
            newMerchantMenuInfo.setMenuID(changeMenuID);
            //获取当前商品菜单信息
            //获取商品菜单信息
            B_MerchantMenuInfoEntity changeMerchantMenuInfo = merchantMenuInfoDao.get(newMerchantMenuInfo);
            if (changeMerchantMenuInfo == null){
                throw new BizException(CodeMsgConstants.NOT_MERCHANT_ERROR,CodeMsgConstants.NOT_MERCHANT_MSG);
            }
            if (o_orderDetailInfoEntity != null) {
                o_orderDetailInfoEntity.setParentID(o_orderDetailInfoEntity.getDetailID());
                o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                o_orderDetailInfoEntity.setQuantity(NumberUtil.negate(o_orderDetailInfoEntity.getQuantity()));
                o_orderDetailInfoEntity.setFloatQuantity(NumberUtil.negate(o_orderDetailInfoEntity.getFloatQuantity()));
                o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue());
               //correctOrderDetailInfo(o_orderDetailInfoEntity);
                //新增退菜订单详情
                orderDetailInfoDao.insert(o_orderDetailInfoEntity);
                //新增换菜详情
                o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                o_orderDetailInfoEntity.setProductName(changeMerchantMenuInfo.getProductName());
                o_orderDetailInfoEntity.setVariantID(changeMerchantMenuInfo.getVariantID());
                o_orderDetailInfoEntity.setMenuID(changeMerchantMenuInfo.getMenuID());
                o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.CHANGEPRODUCT.getValue());
                orderDetailInfoDao.insert(o_orderDetailInfoEntity);
                //获取子订单信息,修改子订单信息
                O_SubOrderInfoEntity subOrderInfoEntity = new O_SubOrderInfoEntity();
                subOrderInfoEntity.setSubOrderID(o_orderDetailInfoEntity.getSubOrderID());
                O_SubOrderInfoEntity o_subOrderInfoEntity = subOrderInfoService.get(subOrderInfoEntity);
                if (o_subOrderInfoEntity != null) {
                    subOrderInfoService.update(o_subOrderInfoEntity);
                    //修改订单信息
                    O_OrderInfoEntity oOrderInfoEntity = new O_OrderInfoEntity();
                    oOrderInfoEntity.setOrderID(o_subOrderInfoEntity.getOrderID());
                    O_OrderInfoEntity orderInfoEntity = orderInfoService.get(oOrderInfoEntity);
                    orderInfoService.update(orderInfoEntity);
                    //新增订单处理信息
//                    updateSubOrderMessage(o_orderDetailInfoEntity, orderDetailInfo);
                    resultData.setCode(CodeMsgConstants.SUCCESS);
                    resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                }
            }
        }
        return resultData;
    }

    /**
     * @Description 换菜时减去退菜的数量和价格
     * @author ZhouWei
     * @time 2.0.0
     * @version 2.0.0
     */
    public void correctOrderDetailInfo(O_OrderDetailInfoEntity orderDetailInfoEntity, O_OrderDetailInfoEntity o_orderDetailInfoEntity) {
        if (orderDetailInfoEntity != null) {
            if (o_orderDetailInfoEntity.getNeedWeigh() != null && o_orderDetailInfoEntity.getNeedWeigh()) {
                o_orderDetailInfoEntity.setFloatQuantity(o_orderDetailInfoEntity.getFloatQuantity() - orderDetailInfoEntity.getFloatQuantity());
            } else {
                o_orderDetailInfoEntity.setQuantity(o_orderDetailInfoEntity.getQuantity() - orderDetailInfoEntity.getQuantity());
            }
            o_orderDetailInfoEntity.setTotalAmount(o_orderDetailInfoEntity.getTotalAmount().subtract(orderDetailInfoEntity.getTotalAmount()));
        }
    }

    /**
     * @Description 已下单不同价按同价换菜
     * @version 2.0.0
     * @time 2017-4-25
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData changeSamePriceFood(Long detailID, Long changeMenuID) throws Exception {
        ResultData resultData = new ResultData();
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setDetailID(detailID);
        BigDecimal unitOriginalPricePrice = null;
        BigDecimal unitPrice = null;
        BigDecimal unitProduceCost = null;
        BigDecimal unitDesignerPrice = null;
        BigDecimal changeUnitPrice = null;
        BigDecimal changeUnitProduceCost = null;
        BigDecimal changeUnitDesignerPrice = null;
        //获得订单明细信息
        O_OrderDetailInfoEntity o_orderDetailInfoEntity = orderDetailInfoDao.get(orderDetailInfo);
        //新增订单详情,如果订单详情不包含该商品的订单详情信息就新增，否则修改
//        O_OrderDetailInfoEntity orderDetailInfoEntity = getOrderDetailInfo(OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue(), menuID);
        //获取需要换菜的菜单信息
        if (changeMenuID != null) {
            B_MerchantMenuInfoEntity changeMerchantMenuInfo = new B_MerchantMenuInfoEntity();
            changeMerchantMenuInfo.setMenuID(changeMenuID);
            B_MerchantMenuInfoEntity changeMerchantMenu = merchantMenuInfoDao.get(changeMerchantMenuInfo);
            if (changeMerchantMenu == null){
                throw new BizException(CodeMsgConstants.NOT_MERCHANT_ERROR,CodeMsgConstants.NOT_MERCHANT_MSG);
            }
            if (changeMerchantMenu != null) {
                changeUnitPrice = changeMerchantMenu.getPrice();
                changeUnitProduceCost = changeMerchantMenu.getProduceCost();
            }
            //获取当前商品菜单信息
            if (o_orderDetailInfoEntity != null) {
                B_MerchantMenuInfoEntity merchantMenuInfo = new B_MerchantMenuInfoEntity();
                merchantMenuInfo.setMenuID(o_orderDetailInfoEntity.getMenuID());
                B_MerchantMenuInfoEntity merchantMenu = merchantMenuInfoDao.get(merchantMenuInfo);
                if (merchantMenu != null) {
                    unitOriginalPricePrice = merchantMenu.getOriginalPrice();
                    unitPrice = merchantMenu.getPrice() == null ? new BigDecimal(0) : merchantMenu.getPrice();
                    unitProduceCost = merchantMenu.getProduceCost() == null ? new BigDecimal(0):merchantMenu.getProduceCost();
                    unitDesignerPrice = o_orderDetailInfoEntity.getDesignerPrice() == null?new BigDecimal(0):o_orderDetailInfoEntity.getDesignerPrice();
                }
//                o_orderDetailInfoEntity.setDetailID(detailID);
//                o_orderDetailInfoEntity.setMenuID(changeMenuID);
//                o_orderDetailInfoEntity.setOriginalPrice(o_orderDetailInfoEntity.getOriginalPrice().subtract(unitOriginalPricePrice).subtract(unitProduceCost).add(changeUnitPrice).add(changeUnitProduceCost));
//                o_orderDetailInfoEntity.setProductName(changeMerchantMenuInfo.getProductName());
//                o_orderDetailInfoEntity.setVariantID(changeMerchantMenuInfo.getVariantID());
//                o_orderDetailInfoEntity.setTotalAmount(o_orderDetailInfoEntity.getTotalAmount().subtract(unitPrice).subtract(unitProduceCost).add(changeUnitPrice).add(changeUnitProduceCost));
////                correctOrderDetailInfo(orderDetailInfoEntity, o_orderDetailInfoEntity);
                o_orderDetailInfoEntity.setParentID(o_orderDetailInfoEntity.getDetailID());
                o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                o_orderDetailInfoEntity.setQuantity(NumberUtil.negate(o_orderDetailInfoEntity.getQuantity()));
                o_orderDetailInfoEntity.setFloatQuantity(NumberUtil.negate(o_orderDetailInfoEntity.getFloatQuantity()));
                o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue());
                //correctOrderDetailInfo(o_orderDetailInfoEntity);
                //新增退菜订单详情
                orderDetailInfoDao.insert(o_orderDetailInfoEntity);
                //新增换菜详情
                o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                o_orderDetailInfoEntity.setProductName(changeMerchantMenuInfo.getProductName());
                o_orderDetailInfoEntity.setVariantID(changeMerchantMenuInfo.getVariantID());
                o_orderDetailInfoEntity.setMenuID(changeMerchantMenuInfo.getMenuID());
                o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.CHANGEPRODUCT.getValue());
                //修改订单详情
                orderDetailInfoDao.insert(o_orderDetailInfoEntity);
                //获取子订单信息,修改子订单信息
                O_SubOrderInfoEntity subOrderInfoEntity = new O_SubOrderInfoEntity();
                subOrderInfoEntity.setSubOrderID(o_orderDetailInfoEntity.getSubOrderID());
                O_SubOrderInfoEntity o_subOrderInfoEntity = subOrderInfoService.get(subOrderInfoEntity);
                if (o_subOrderInfoEntity != null) {
                    o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().subtract(unitPrice).subtract(unitProduceCost).add(changeUnitPrice).add(changeUnitProduceCost));
                    subOrderInfoService.update(o_subOrderInfoEntity);
                    //修改订单信息
                    O_OrderInfoEntity oOrderInfoEntity = new O_OrderInfoEntity();
                    oOrderInfoEntity.setOrderID(o_subOrderInfoEntity.getOrderID());
                    O_OrderInfoEntity orderInfoEntity = orderInfoService.get(oOrderInfoEntity);
                    orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().subtract(unitPrice).subtract(unitProduceCost).add(changeUnitPrice).add(changeUnitProduceCost));
                    orderInfoService.update(orderInfoEntity);
                    //新增订单处理信息
//                    updateSubOrderMessage(o_orderDetailInfoEntity, orderDetailInfo);
                    resultData.setCode(CodeMsgConstants.SUCCESS);
                    resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                }
            }
        }
        return resultData;
    }

    /**
     * @Description 已下单不同价按新价换菜
     * @version 2.0.0
     * @time 2017-4-25
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData changeNotSamePriceFood( Long detailID, Long changeMenuID,Float floatQuantity) throws Exception {
        ResultData resultData = new ResultData();
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setDetailID(detailID);
        BigDecimal unitOriginalPricePrice = null;
        BigDecimal unitPrice = null;
        BigDecimal unitProduceCost = null;
        BigDecimal changeUnitOriginalPricePrice = null;
        BigDecimal changeUnitPrice = null;
        BigDecimal changeUnitProduceCost = null;
        //获得订单明细信息
        O_OrderDetailInfoEntity o_orderDetailInfoEntity = orderDetailInfoDao.get(orderDetailInfo);
        //新增订单详情,如果订单详情不包含该商品的订单详情信息就新增，否则修改
//        O_OrderDetailInfoEntity orderDetailInfoEntity = getOrderDetailInfo(OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue(), menuID);
        //获取需要换菜的菜单信息
        if (changeMenuID != null) {
            B_MerchantMenuInfoEntity changeMerchantMenuInfo = new B_MerchantMenuInfoEntity();
            changeMerchantMenuInfo.setMenuID(changeMenuID);
            B_MerchantMenuInfoEntity changeMerchantMenu = merchantMenuInfoDao.get(changeMerchantMenuInfo);
            if (changeMerchantMenu == null){
                throw new BizException(CodeMsgConstants.NOT_MERCHANT_ERROR,CodeMsgConstants.NOT_MERCHANT_MSG);
            }
            if (changeMerchantMenu != null) {
                changeUnitPrice = changeMerchantMenu.getPrice();
                changeUnitOriginalPricePrice = changeMerchantMenu.getOriginalPrice();
                changeUnitProduceCost = changeMerchantMenu.getProduceCost();
            }
            //获取当前商品菜单信息
            if (o_orderDetailInfoEntity != null) {
                B_MerchantMenuInfoEntity merchantMenuInfo = new B_MerchantMenuInfoEntity();
                merchantMenuInfo.setMenuID(o_orderDetailInfoEntity.getMenuID());
                B_MerchantMenuInfoEntity merchantMenu = merchantMenuInfoDao.get(merchantMenuInfo);
                if (merchantMenu != null) {
                    unitPrice = merchantMenu.getPrice();
                    unitProduceCost = merchantMenu.getProduceCost();
                }
                o_orderDetailInfoEntity.setParentID(o_orderDetailInfoEntity.getDetailID());
                o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                o_orderDetailInfoEntity.setQuantity(NumberUtil.negate(o_orderDetailInfoEntity.getQuantity()));
                o_orderDetailInfoEntity.setFloatQuantity(NumberUtil.negate(o_orderDetailInfoEntity.getFloatQuantity()));
                o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue());
                //退原订单详情
                orderDetailInfoDao.insert(o_orderDetailInfoEntity);

                o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                o_orderDetailInfoEntity.setMenuID(changeMenuID);
                if (floatQuantity != null && changeMerchantMenu.getNeedWeigh()){
                    o_orderDetailInfoEntity.setOriginalPrice(changeUnitOriginalPricePrice.multiply(new BigDecimal(floatQuantity)).add(changeUnitProduceCost.multiply(new BigDecimal(floatQuantity))));
                    o_orderDetailInfoEntity.setPrice(changeUnitPrice.multiply(new BigDecimal(floatQuantity)).add(changeUnitProduceCost.multiply(new BigDecimal(floatQuantity))));
                    o_orderDetailInfoEntity.setTotalAmount(changeUnitPrice.multiply(new BigDecimal(floatQuantity)).add(changeUnitProduceCost.multiply(new BigDecimal(floatQuantity))));
                }else {
                    o_orderDetailInfoEntity.setOriginalPrice(changeUnitOriginalPricePrice.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity())).add(changeUnitProduceCost.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity()))));
                    o_orderDetailInfoEntity.setPrice(changeUnitPrice.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity())).add(changeUnitProduceCost.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity()))));
                    o_orderDetailInfoEntity.setTotalAmount(changeUnitPrice.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity())).add(changeUnitProduceCost.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity()))));
                }

                o_orderDetailInfoEntity.setProductName(changeMerchantMenuInfo.getProductName());
                o_orderDetailInfoEntity.setVariantID(changeMerchantMenuInfo.getVariantID());
                o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.CHANGEPRODUCT.getValue());

              //  correctOrderDetailInfo(orderDetailInfoEntity, o_orderDetailInfoEntity);
                //换订单详情
                orderDetailInfoDao.insert(o_orderDetailInfoEntity);
                //获取子订单信息,修改子订单信息
                O_SubOrderInfoEntity subOrderInfoEntity = new O_SubOrderInfoEntity();
                subOrderInfoEntity.setSubOrderID(o_orderDetailInfoEntity.getSubOrderID());
                O_SubOrderInfoEntity o_subOrderInfoEntity = subOrderInfoService.get(subOrderInfoEntity);
                if (o_subOrderInfoEntity != null) {
                    o_subOrderInfoEntity.setQuantity(o_subOrderInfoEntity.getQuantity());
                    o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().subtract(unitPrice).subtract(unitProduceCost).add(changeUnitPrice).add(changeUnitProduceCost));
                    o_subOrderInfoEntity.setActualAmount(o_subOrderInfoEntity.getActualAmount().subtract(unitPrice).subtract(unitProduceCost).add(changeUnitPrice).add(changeUnitProduceCost));
                    subOrderInfoService.update(o_subOrderInfoEntity);
                    //修改订单信息
                    O_OrderInfoEntity oOrderInfoEntity = new O_OrderInfoEntity();
                    oOrderInfoEntity.setOrderID(o_subOrderInfoEntity.getOrderID());
                    O_OrderInfoEntity orderInfoEntity = orderInfoService.get(oOrderInfoEntity);
                    orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().subtract(unitPrice).subtract(unitProduceCost).add(changeUnitPrice).add(changeUnitProduceCost));
                    orderInfoEntity.setQuantity(orderInfoEntity.getQuantity());
                    orderInfoEntity.setActualAmount(orderInfoEntity.getActualAmount().subtract(unitPrice).subtract(unitProduceCost).add(changeUnitPrice).add(changeUnitProduceCost));
                    orderInfoService.update(orderInfoEntity);
                    //新增订单处理信息
//                    updateSubOrderMessage(o_orderDetailInfoEntity, orderDetailInfo);
                    resultData.setCode(CodeMsgConstants.SUCCESS);
                    resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                }
            }
        }
        return resultData;
    }

    /**
     * @Description 已下单按不同规格换菜
     * @version 2.0.0
     * @time 2017-4-25
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData changeNotStandardFood(Long detailID, Long specificationID, List<ProductSpecificationVo> productSpecificationVoList) throws Exception {
        ResultData resultData = new ResultData();
        BigDecimal changeUnitOriginalPricePrice = null;
        BigDecimal changeUnitPrice = null;
        BigDecimal changeUnitProduceCost = null;
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setDetailID(detailID);
        //获得订单明细信息
        O_OrderDetailInfoEntity o_orderDetailInfoEntity = orderDetailInfoDao.get(orderDetailInfo);
        //新增订单详情,如果订单详情不包含该商品的订单详情信息就新增，否则修改
//        O_OrderDetailInfoEntity orderDetailInfoEntity = getOrderDetailInfo(OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue(), menuID);
        //获取需要换菜的规格
        ProductSpecificationVo newSpecificationVo = new ProductSpecificationVo();
        ProductSpecificationVo oldSpecificationVo = new ProductSpecificationVo();
        if (specificationID != null) {
            for (ProductSpecificationVo productSpecificationVo : productSpecificationVoList) {
                if (specificationID.equals(productSpecificationVo.getSpecificationID())) {
                    newSpecificationVo = productSpecificationVo;
                }
                if (o_orderDetailInfoEntity.getOptionID().equals(productSpecificationVo.getOptionID())) {
                    oldSpecificationVo = productSpecificationVo;
                }
            }
            B_MerchantMenuInfoEntity changeMerchantMenuInfo = new B_MerchantMenuInfoEntity();
            changeMerchantMenuInfo.setMenuID(o_orderDetailInfoEntity.getMenuID());
            B_MerchantMenuInfoEntity changeMerchantMenu = merchantMenuInfoDao.get(changeMerchantMenuInfo);
            if (changeMerchantMenu != null) {
                changeUnitPrice = changeMerchantMenu.getPrice();
                changeUnitOriginalPricePrice = changeMerchantMenu.getOriginalPrice();
                changeUnitProduceCost = changeMerchantMenu.getProduceCost();
            }
            //获取当前商品菜单信息
            if (o_orderDetailInfoEntity != null) {
                B_MerchantMenuInfoEntity merchantMenuInfo = new B_MerchantMenuInfoEntity();
                merchantMenuInfo.setMenuID(o_orderDetailInfoEntity.getMenuID());
                o_orderDetailInfoEntity.setParentID(o_orderDetailInfoEntity.getDetailID());
                o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                o_orderDetailInfoEntity.setQuantity(NumberUtil.negate(o_orderDetailInfoEntity.getQuantity()));
                o_orderDetailInfoEntity.setFloatQuantity(NumberUtil.negate(o_orderDetailInfoEntity.getFloatQuantity()));
                o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue());
                o_orderDetailInfoEntity.setOptionID(oldSpecificationVo.getOptionID());
                //退订单详情
                orderDetailInfoDao.insert(o_orderDetailInfoEntity);
                //新增换菜详情
                o_orderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                o_orderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.CHANGEPRODUCT.getValue());
                o_orderDetailInfoEntity.setOptionID(newSpecificationVo.getOptionID());
                if (o_orderDetailInfoEntity.getNeedWeigh() != null && o_orderDetailInfoEntity.getNeedWeigh()){
                    o_orderDetailInfoEntity.setOriginalPrice(changeUnitOriginalPricePrice.multiply(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity())).add(changeUnitProduceCost.multiply(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()))));
                    o_orderDetailInfoEntity.setPrice(changeUnitPrice.multiply(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity())).add(changeUnitProduceCost.multiply(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()))));
                    o_orderDetailInfoEntity.setTotalAmount(changeUnitPrice.multiply(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity())).add(changeUnitProduceCost.multiply(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()))));
                }else {
                    o_orderDetailInfoEntity.setOriginalPrice(changeUnitOriginalPricePrice.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity())).add(changeUnitProduceCost.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity()))));
                    o_orderDetailInfoEntity.setPrice(changeUnitPrice.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity())).add(changeUnitProduceCost.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity()))));
                    o_orderDetailInfoEntity.setTotalAmount(changeUnitPrice.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity())).add(changeUnitProduceCost.multiply(new BigDecimal(o_orderDetailInfoEntity.getQuantity()))));
                }
//                correctOrderDetailInfo(orderDetailInfoEntity, o_orderDetailInfoEntity);
                //修改订单详情
                orderDetailInfoDao.insert(o_orderDetailInfoEntity);
                //获取子订单信息,修改子订单信息
                O_SubOrderInfoEntity subOrderInfoEntity = new O_SubOrderInfoEntity();
                subOrderInfoEntity.setSubOrderID(o_orderDetailInfoEntity.getSubOrderID());
                O_SubOrderInfoEntity o_subOrderInfoEntity = subOrderInfoService.get(subOrderInfoEntity);
                if (o_subOrderInfoEntity != null) {
                    o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().subtract(oldSpecificationVo.getPrice()).add(newSpecificationVo.getAddedPrice()));
                    o_subOrderInfoEntity.setActualAmount(o_subOrderInfoEntity.getActualAmount().subtract(oldSpecificationVo.getPrice()).add(newSpecificationVo.getAddedPrice()));
                    subOrderInfoService.update(o_subOrderInfoEntity);
                    //修改订单信息
                    O_OrderInfoEntity oOrderInfoEntity = new O_OrderInfoEntity();
                    oOrderInfoEntity.setOrderID(o_subOrderInfoEntity.getOrderID());
                    O_OrderInfoEntity orderInfoEntity = orderInfoService.get(oOrderInfoEntity);
                    orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().subtract(oldSpecificationVo.getPrice()).add(newSpecificationVo.getAddedPrice()));
                    orderInfoEntity.setActualAmount(orderInfoEntity.getActualAmount().subtract(oldSpecificationVo.getPrice()).add(newSpecificationVo.getAddedPrice()));
                    orderInfoService.update(orderInfoEntity);
                    //新增订单处理信息
//                    updateSubOrderMessage(o_orderDetailInfoEntity, orderDetailInfo);
                    resultData.setCode(CodeMsgConstants.SUCCESS);
                    resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                }
            }
        }
        return resultData;
    }


    /**
     * @Description 已下单转菜
     * @version 2.0.0
     * @time 2017-4-25
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData changeFoodTable(Long detailID, Integer quantity, Long subOrderID,Long archiveID) throws Exception {
        ResultData resultData = new ResultData();
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setDetailID(detailID);
        BigDecimal unitOriginalPricePrice = null;
        BigDecimal unitPrice = null;
        BigDecimal unitProduceCost = null;
        BigDecimal unitDesignerPrice = null;
        //获得订单明细信息
        O_OrderDetailInfoEntity o_orderDetailInfoEntity = orderDetailInfoDao.get(orderDetailInfo);
        Object TempRet = null;
        TempRet = getIsOperationPresentFood(o_orderDetailInfoEntity, OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue());
        if (TempRet == null){
            TempRet = 0;
        }
        if (o_orderDetailInfoEntity.getQuantity()<(quantity - Integer.valueOf(TempRet.toString()))){
            throw new BizException(CodeMsgConstants.CHANGE_FOOD_ERROR,CodeMsgConstants.CHANGE_FOOD_MSG);
        }
        Long menuID = o_orderDetailInfoEntity.getMenuID();
        //获取需要换菜的菜单信息
        if (menuID != null) {
            //获取新的子订单信息
            O_SubOrderInfoEntity osubOrderInfoEntity = new O_SubOrderInfoEntity();
            osubOrderInfoEntity.setSubOrderID(subOrderID);
            O_SubOrderInfoEntity newSubOrderInfoEntity = subOrderInfoService.get(osubOrderInfoEntity);
            //获取当前商品菜单信息
            if (o_orderDetailInfoEntity != null) {
                B_MerchantMenuInfoEntity merchantMenuInfo = new B_MerchantMenuInfoEntity();
                merchantMenuInfo.setMenuID(menuID);
                B_MerchantMenuInfoEntity merchantMenu = merchantMenuInfoDao.get(merchantMenuInfo);
                if (merchantMenu != null) {
                    unitOriginalPricePrice = merchantMenu.getOriginalPrice() == null ? new BigDecimal(0) : merchantMenu.getOriginalPrice();
                    unitPrice = merchantMenu.getPrice() == null ? new BigDecimal(0) : merchantMenu.getPrice();
                    unitProduceCost = merchantMenu.getProduceCost() == null ? new BigDecimal(0):merchantMenu.getProduceCost();
                    unitDesignerPrice = o_orderDetailInfoEntity.getDesignerPrice() == null?new BigDecimal(0):o_orderDetailInfoEntity.getDesignerPrice();
                }
                //获取原子订单信息,修改原子订单信息
                O_SubOrderInfoEntity subOrderInfoEntity = new O_SubOrderInfoEntity();
                subOrderInfoEntity.setSubOrderID(o_orderDetailInfoEntity.getSubOrderID());
                O_SubOrderInfoEntity o_subOrderInfoEntity = subOrderInfoService.get(subOrderInfoEntity);
                //获取新子订单信息,修改新子订单信息
                O_SubOrderInfoEntity new_SubOrderInfoEntity = new O_SubOrderInfoEntity();
                new_SubOrderInfoEntity.setSubOrderID(newSubOrderInfoEntity.getSubOrderID());
                O_SubOrderInfoEntity newO_subOrderInfoEntity = subOrderInfoService.get(new_SubOrderInfoEntity);
                //获取原订单信息
                O_OrderInfoEntity oOrderInfoEntity = new O_OrderInfoEntity();
                oOrderInfoEntity.setOrderID(o_subOrderInfoEntity.getOrderID());
                O_OrderInfoEntity orderInfoEntity = orderInfoService.get(oOrderInfoEntity);
                //获取新订单信息
                O_OrderInfoEntity infoEntity =new O_OrderInfoEntity();
                infoEntity.setOrderID(newSubOrderInfoEntity.getOrderID());
                O_OrderInfoEntity newOrderInfoEntity = orderInfoService.get(infoEntity);
                O_OrderDetailInfoEntity newOrderDetailInfoEntity = new O_OrderDetailInfoEntity();
                BeanUtils.copyProperties(newOrderDetailInfoEntity,o_orderDetailInfoEntity);
                ProductDetailVO productDetailVO = new ProductDetailVO();
                BigDecimal orderTotal = (o_orderDetailInfoEntity.getTotalAmount().divide(new BigDecimal(o_orderDetailInfoEntity.getQuantity()))).multiply(new BigDecimal(quantity));
                if (o_subOrderInfoEntity != null) {
                    if (o_orderDetailInfoEntity.getNeedWeigh() != null && o_orderDetailInfoEntity.getNeedWeigh()) {
//                        BigDecimal orderTotal = (new BigDecimal(quantity).multiply(unitPrice)).multiply((new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitPrice)).add(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitProduceCost)).add(new BigDecimal(o_orderDetailInfoEntity.getFloatQuantity()).multiply(unitDesignerPrice)));
                        //设置新的称重商品订单详情
                        newOrderDetailInfoEntity.setQuantity(quantity);
                        //设置旧的订单详情
//                        o_orderDetailInfoEntity.setOriginalPrice(null);
//                        o_orderDetailInfoEntity.setPrice(null);
                        o_orderDetailInfoEntity.setQuantity(o_orderDetailInfoEntity.getQuantity() - quantity);
//                        o_orderDetailInfoEntity.setFloatQuantity(null);
//                        o_orderDetailInfoEntity.setProduceCost(null);
                        o_orderDetailInfoEntity.setTotalAmount(o_orderDetailInfoEntity.getTotalAmount().subtract(orderTotal));
                        //设置旧的子订单信息
                        o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().subtract(orderTotal));
                        o_subOrderInfoEntity.setActualAmount(o_subOrderInfoEntity.getActualAmount().subtract(orderTotal));
                        o_subOrderInfoEntity.setQuantity(o_subOrderInfoEntity.getQuantity() - quantity);
                        //设置新的子订单信息
                        newO_subOrderInfoEntity.setTotalAmount(newO_subOrderInfoEntity.getTotalAmount().add(orderTotal));
                        newO_subOrderInfoEntity.setActualAmount(newO_subOrderInfoEntity.getActualAmount().add(orderTotal));
                        o_subOrderInfoEntity.setQuantity(o_subOrderInfoEntity.getQuantity() + quantity);
                        //设置原订单信息
                        orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().subtract(orderTotal));
                        orderInfoEntity.setActualAmount(orderInfoEntity.getActualAmount().subtract(orderTotal));
                        orderInfoEntity.setQuantity(orderInfoEntity.getQuantity() - quantity);
                        //设置新订单信息
                        newOrderInfoEntity.setTotalAmount(newOrderInfoEntity.getTotalAmount().add(orderTotal));
                        newOrderInfoEntity.setActualAmount(newOrderInfoEntity.getActualAmount().add(orderTotal));
                        newOrderInfoEntity.setQuantity(newOrderInfoEntity.getQuantity() + quantity);
                    } else {
                        //设置新的订单详情
                        newOrderDetailInfoEntity.setOriginalPrice(unitOriginalPricePrice.multiply(new BigDecimal(quantity)));
//                        newOrderDetailInfoEntity.setPrice(unitPrice.multiply(new BigDecimal(quantity)));
                        newOrderDetailInfoEntity.setQuantity(quantity);
                        newOrderDetailInfoEntity.setProduceCost(unitProduceCost.multiply(new BigDecimal(quantity)));
                        newOrderDetailInfoEntity.setTotalAmount(orderTotal);
                        //设置旧的订单详情
                        o_orderDetailInfoEntity.setOriginalPrice(o_orderDetailInfoEntity.getOriginalPrice().subtract(unitOriginalPricePrice.multiply(new BigDecimal(quantity))));
//                        o_orderDetailInfoEntity.setPrice(o_orderDetailInfoEntity.getPrice().subtract(unitPrice.multiply(new BigDecimal(quantity))));
                        o_orderDetailInfoEntity.setQuantity(o_orderDetailInfoEntity.getQuantity() - quantity);
                        o_orderDetailInfoEntity.setProduceCost(o_orderDetailInfoEntity.getProduceCost().subtract(unitProduceCost.multiply(new BigDecimal(quantity))));
                        if (o_orderDetailInfoEntity.getTotalAmount() != null && o_orderDetailInfoEntity.getTotalAmount() != new BigDecimal(0)){
                            o_orderDetailInfoEntity.setTotalAmount(o_orderDetailInfoEntity.getTotalAmount().subtract(orderTotal));
                        }
                        //设置旧的子订单信息
                        o_subOrderInfoEntity.setQuantity(o_subOrderInfoEntity.getQuantity() - quantity);
                        o_subOrderInfoEntity.setTotalAmount(o_subOrderInfoEntity.getTotalAmount().subtract(orderTotal));
                        o_subOrderInfoEntity.setActualAmount(o_subOrderInfoEntity.getActualAmount().subtract(orderTotal));
                        //设置新的子订单信息
                        newO_subOrderInfoEntity.setQuantity(newO_subOrderInfoEntity.getQuantity() + quantity);
                        newO_subOrderInfoEntity.setTotalAmount(newO_subOrderInfoEntity.getTotalAmount().add(orderTotal));
                        newO_subOrderInfoEntity.setActualAmount(newO_subOrderInfoEntity.getActualAmount().add(orderTotal));
                        //设置原订单信息
                        orderInfoEntity.setTotalAmount(orderInfoEntity.getTotalAmount().subtract(orderTotal));
                        orderInfoEntity.setQuantity(orderInfoEntity.getQuantity() - quantity);
                        orderInfoEntity.setActualAmount(orderInfoEntity.getActualAmount().subtract(orderTotal));
                        //设置新订单信息
                        newOrderInfoEntity.setTotalAmount(newOrderInfoEntity.getTotalAmount().add(orderTotal));
                        newOrderInfoEntity.setQuantity(newOrderInfoEntity.getQuantity() + quantity);
                        newOrderInfoEntity.setActualAmount(newOrderInfoEntity.getActualAmount().add(orderTotal));
                    }
                    newOrderDetailInfoEntity.setSubOrderID(newSubOrderInfoEntity.getSubOrderID());
                    newOrderDetailInfoEntity.setOrderID(newSubOrderInfoEntity.getOrderID());
                    newOrderDetailInfoEntity.setCreateTime(LocalDateTime.now());
                    newOrderDetailInfoEntity.setDetailID(MaxIDUtils.getID(O_OrderDetailInfoEntity.class));
                    newOrderDetailInfoEntity.setALaCarteMethod(OrderManagerEnum.OrderMode.TURNPRODUCT.getValue());
                    o_orderDetailInfoEntity.setCreateTime(LocalDateTime.now());
                    productDetailVO.setBusinessID(newOrderDetailInfoEntity.getDetailID());

                    //插入新的订单详情
                    orderDetailInfoDao.insert(newOrderDetailInfoEntity);
                    //修改旧的订单详情
                    orderDetailInfoDao.update(o_orderDetailInfoEntity);
                    //修改旧的子订单信息
                    subOrderInfoService.update(o_subOrderInfoEntity);
                    //修改新的子订单信息
                    subOrderInfoService.update(newO_subOrderInfoEntity);
                    //修改原订单信息
                    orderInfoService.update(orderInfoEntity);
                    //修改新的子订单信息
                    orderInfoService.update(newOrderInfoEntity);
                    //新增订单处理信息
//                    updateSubOrderMessage(o_orderDetailInfoEntity, orderDetailInfo);
                    productDetailVO = productComponent.getPrintProductDetailList(Arrays.asList(newOrderDetailInfoEntity.getDetailID())).get(0);
                    TableInfoVO tableInfoVO = productComponent.getPrintTable(newO_subOrderInfoEntity.getSubOrderID());
                    OrderPrintVO orderPrintVO = new OrderPrintVO();
                    orderPrintVO.setTableInfo(tableInfoVO);
                    orderPrintVO.setProductDetailVO(productDetailVO);
                    resultData.setData(orderPrintVO);
                    resultData.setCode(CodeMsgConstants.SUCCESS);
                    resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                }
            }
        }
        return resultData;
    }


    /**
     * @Description 已下单批量转菜
     * @version 2.0.0
     * @time 2017-4-25
     * @author ZhouWei
     */
    @Transactional(rollbackFor = Exception.class)
    public ResultData changeFoodTableBatch(Long[] detailIDs,Integer[] quantitys,Long subOrderID,Long archiveID) throws Exception {
        ResultData resultData = new ResultData();
        List<ProductDetailVO>  productDetailVOList = new ArrayList<ProductDetailVO>();
        OrderPrintVO orderPrintVO = new OrderPrintVO();
        for (int i =0 ;i<detailIDs.length;i++) {
            Long detailID = (Long) detailIDs[i]; //订单明细编号
//            Long menuID = (Long) menuIDs[i];   //菜单编号
            Integer quantity = (Integer) quantitys[i];  //换菜的数量
//            Long subOrderID = (Long) subOrderIDs[i];  //换菜的目标桌台子订单ID
            resultData = changeFoodTable(detailID, quantity, subOrderID,archiveID);
            orderPrintVO = (OrderPrintVO) resultData.getData();
            productDetailVOList.add(orderPrintVO.getProductDetailVO());
        }
        resultData.setCode(CodeMsgConstants.SUCCESS);
        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        printComponent.printTableTicket(orderPrintVO.getTableInfo(),productDetailVOList);
        return resultData;
    }

    public List<O_OrderDetailInfoEntity> queryOrderDetailBySubOrderID(Long subOrderID) throws Exception {
        O_OrderDetailInfoEntity orderDetailInfo = new O_OrderDetailInfoEntity();
        orderDetailInfo.setSubOrderID(subOrderID);
        return orderDetailInfoDao.queryOrderDetailByCondition(orderDetailInfo);
    }

    public List<Map<String, Object>> getProductBySubOrderAndTag(CommonManageEnum.GoalsType targetType, String tagCode, Long subOrderId) {
        return orderDetailInfoDao.getProductBySubOrderAndTag(targetType.getValue(), tagCode, subOrderId);
    }

    public List<Map<String, Object>> getProductBySubOrderAndProStatus(Long status, Long subOrderId) {
        return orderDetailInfoDao.getProductBySubOrderAndProStatus(subOrderId, status);
    }

    /**
     *k可以退菜的菜品
     * @param subOrderId
     * @return
     */
   public List<Map<String, Object>> getProductBack(Long subOrderId) {
        return orderDetailInfoDao.getProductBack(subOrderId);
    }

    /**
     * 可以转菜的菜品
     * @param subOrderId
     * @return
     */
    public List<Map<String, Object>> getProductTransfer(Long subOrderId) {
        return orderDetailInfoDao.getProductTransfer(subOrderId);
    }

    /**
     * 可以划单的菜品
     * @param subOrderId
     * @return
     */
    public List<Map<String, Object>> getProductCancel(Long subOrderId) {
        return orderDetailInfoDao.getProductCancel(subOrderId);
    }

}
