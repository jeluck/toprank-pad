package cc.toprank.byd.web.service.menu;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.ObjectUtil;
import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.component.DesignerComponent;
import cc.toprank.byd.component.TableComponent;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.component.OrderComponent;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.util.CollectionHelper;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.vo.menu.DesignerInfoVO;
import cc.toprank.byd.web.vo.product.*;
import cc.toprank.byd.web.vo.tablevo.TableMessageVO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Description： 商品信息Service
 *
 * @author LinYN
 * @date 2017-4-19
 */
@Service("productMessageService")
public class ProductMessageService {

    @Autowired
    private OrderComponent orderComponent;
    @Autowired
    private TableComponent tableComponent;
    @Autowired
    private DesignerComponent designerComponent;
    @Autowired
    private P_ProductVariantInfoDao productVariantInfoDao;
    @Autowired
    private P_CategoryAttributeInfoDao categoryAttributeInfoDao;
    @Autowired
    private P_SpecificationAttributeOptionInfoDao specificationAttributeOptionInfoDao;
    @Autowired
    private O_OrderDetailInfoDao orderDetailInfoDao;


    /**
     * 获取商品配置信息，包括规格、称重、口味做法、厨师、厨房状态等
     *
     * @param menuID 菜单编号
     * @return 商品配置信息
     *
     * @author LinYN
     * @date 2017-4-19
     */
    @Transactional(rollbackFor = Exception.class)
    public ProductMessageVo getProductMessage(Long menuID) throws Exception{
        List<ProductSpecificationVo> specifications = null;
        List<ProductAttributeVo> attributes = null;
        ProductMessageVo productMessageVo = new ProductMessageVo();
        productMessageVo.setMenuID(menuID);
        B_MerchantMenuInfoEntity menuInfoEntity = orderComponent.getMerchantMenuInfo(menuID);
        if (menuInfoEntity == null) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        Long variantID = menuInfoEntity.getVariantID();
        if (variantID == null) {
            Long productID = menuInfoEntity.getProductID();
            specifications = specificationAttributeOptionInfoDao.getCombosSpecification(productID);
            attributes = categoryAttributeInfoDao.getProductAttributeByProductID(productID);
        } else {
            productMessageVo.setVariant(productVariantInfoDao.getProductVariantInfoByID(variantID));
            specifications = specificationAttributeOptionInfoDao.getVariantSpecification(variantID);
            attributes = categoryAttributeInfoDao.getProductAttributeByVariantID(variantID);
        }
        BigDecimal price = menuInfoEntity.getPrice();
        for (ProductSpecificationVo specification : specifications) {
            specification.setPrice(NumberUtil.add(price, specification.getAddedPrice()));
        }
        productMessageVo.setSpecificationList(specifications);
        if (CollectionUtils.isNotEmpty(attributes)) {
            productMessageVo.setAttributeMap(CollectionHelper.group(attributes, attribute -> attribute.getCategoryName()));
        }
        List<DesignerInfoVO> designers = designerComponent.getCurrentDesignerByProduct(menuID);
        if (CollectionUtils.isNotEmpty(designers)) {
            productMessageVo.setDesigners(designers);
        }
        return productMessageVo;
    }


    /**
     * 批量更新商品称重信息
     *
     * @param requestVo 商品称重重量信息
     *
     * @author LinYN
     * @date 2017-5-3
     */
    @Transactional(rollbackFor = Exception.class)
    public void updateProductWeight(ProductWeightRequestVo requestVo) throws Exception{
        orderComponent.updateProductWeight(requestVo);
    }

    /**
     * 复制菜：查询当前桌台可以复制的菜品
     *
     * @param requestVo#subOrderID 子订单编号
     *
     * @author LinYN
     * @date 2017-6-15
     */
    @Transactional(rollbackFor = Exception.class)
    public List<ProductDisplayVO> getCanCopyProducts(ProductCopyRequestVo requestVo) throws Exception{
        if (requestVo == null || requestVo.getSubOrderID() == null || requestVo.getArchiveID() == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put(ParamConstants.OrderParam.PARAM_SUB_ORDER_ID, requestVo.getSubOrderID());
        queryParam.put(ParamConstants.OrderParam.PARAM_ARCHIVE_ID, requestVo.getArchiveID());
        return orderDetailInfoDao.getOrderDetailInfoForCopy(queryParam);
    }

    /**
     * 复制菜：将在当前桌台选择的菜品复制到另一个目标桌台中
     *
     * @param requestVo 选择的需要复制的商品信息
     *
     * @author LinYN
     * @date 2017-5-3
     */
    @Transactional(rollbackFor = Exception.class)
    public void copyProducts(ProductCopyRequestVo requestVo) throws Exception{
        Long archiveID = requestVo.getArchiveID();
        Long subOrderID = requestVo.getSubOrderID();
        List<ProductQuantityVo> productQuantities = requestVo.getCopyProducts();
        Set<Long> orderDetailIDs = CollectionHelper.collect(productQuantities, product -> product.getOrderDetailID());
        if (archiveID == null || subOrderID == null || CollectionUtils.isEmpty(orderDetailIDs)) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        // 获取当前订单选择的需要复制的订单明细
        List<O_OrderDetailInfoEntity> orderDetailInfos = orderComponent.getOrderDetailInfoByIDs(archiveID, orderDetailIDs);
        if (CollectionUtils.isEmpty(orderDetailInfos)) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        B_DinningTableInfoEntity targetTableInfo = tableComponent.getTableInfoById(requestVo.getTargetTableID());
        // 目标桌台必须在使用中
        tableComponent.checkTableIsUsing(targetTableInfo);
        O_SubOrderInfoEntity targetSubOrderInfo = orderComponent.getCurrentSubOrderInfo(targetTableInfo, requestVo.getTargetSubOrderID());
        Long targetSubOrderID = targetSubOrderInfo.getSubOrderID();
        Map<Long, ProductQuantityVo> productQuantityMap = CollectionHelper.asMap(productQuantities, product -> product.getOrderDetailID());
        List<O_OrderDetailInfoEntity> newOrderDetailInfoList = new ArrayList<>(); // 用于计算订单金额
        for (O_OrderDetailInfoEntity orderDetailInfo : orderDetailInfos) {
            // 退菜不可以复制
            if (ObjectUtil.equals(OrderManagerEnum.OrderMode.RETURNPRODUCT.getValue(), orderDetailInfo.getALaCarteMethod())) {
                throw new BizException(CodeMsgConstants.RETURNPRODUCT_NOT_ALLOWED_COPY_ERROR, CodeMsgConstants.RETURNPRODUCT_NOT_ALLOWED_COPY_ERROR_MSG);
            }
            // 新增目标桌台的订单明细
            O_OrderDetailInfoEntity newOrderDetailInfo = new O_OrderDetailInfoEntity();
            BeanUtils.copyProperties(newOrderDetailInfo, orderDetailInfo);
            newOrderDetailInfo.setSubOrderID(targetSubOrderID);
            ProductQuantityVo productQuantity = productQuantityMap.get(orderDetailInfo.getDetailID());
            if (productQuantity == null) continue;
            Integer newQuantity = productQuantity.getQuantity();
            if (NumberUtil.intValue(newQuantity) > 0) {
                orderComponent.setOrderDetailInfoByQuantity(newOrderDetailInfo, newQuantity);
            }
            orderDetailInfoDao.update(newOrderDetailInfo);
            newOrderDetailInfoList.add(newOrderDetailInfo);
        }
        if (CollectionUtils.isEmpty(newOrderDetailInfoList)) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        // 计算订单增加金额
        BigDecimal addedAmount = CollectionHelper.sum(newOrderDetailInfoList, newOrderDetail -> newOrderDetail.getTotalAmount());
        // 修改订单中的总金额和实际金额，并添加订单变动信息
        orderComponent.addAmountForSubOrderInfo(targetSubOrderInfo, addedAmount, "Copy Product");
    }


    /**
     * 根据桌台名称和机构编号获取正在使用中的桌台
     *
     * @param tableName 桌台名称
     * @param archiveID 机构编号
     * @return 正在使用中的桌台
     *
     * @author LinYN
     * @date 2017-4-21
     */
    @Transactional(rollbackFor = Exception.class)
    public List<TableMessageVO> getUsingTableInfos(String tableName, Long archiveID) throws Exception{
        return tableComponent.getUsingTableInfos(tableName, archiveID);
    }
}
