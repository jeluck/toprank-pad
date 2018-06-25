package cc.toprank.byd.component;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.vo.print.ProductDetailVO;
import cc.toprank.byd.vo.print.TableInfoVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LanZY on 2017-6-13.
 */
@Component
public class ProductComponent {

    @Autowired
    ProductInfoDao copeProductInfoDao;
    @Autowired
    TableComponent tableComponent;
    @Autowired
    B_MerchantMenuInfoDao merchantMenuInfoDao;
    @Autowired
    P_ProductInfoDao productInfoDao;
    @Autowired
    P_ProductVariantInfoDao productVariantInfoDao;
    @Autowired
    P_ComboGroupProductMappingDao comboGroupProductMappingDao;
    @Autowired
    P_ComboSettingInfoDao comboSettingInfoDao;

    /**
     * 根据订单明细ID查询打印数据
     *
     * @param detailIDs 订单明细
     * @return
     */
    public List<ProductDetailVO> getPrintProductDetailList(List<Long> detailIDs) {
        if (CollectionUtils.isEmpty(detailIDs)) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<ProductDetailVO> productDetailList = new ArrayList<>();
        List<ProductDetailVO> printComboProductDetailBasic = copeProductInfoDao.getPrintComboProductDetailBasic(detailIDs);
        List<ProductDetailVO> printProductDetailBasic = copeProductInfoDao.getPrintProductDetailBasic(detailIDs);
        for (ProductDetailVO printProductDetail : printProductDetailBasic) {
            productDetailList.add(printProductDetail);
            for (ProductDetailVO comboProductDetail : printComboProductDetailBasic) {
                if (printProductDetail.getDetailID().equals(comboProductDetail.getDetailID())) {
                    productDetailList.add(comboProductDetail);
                }
            }
        }
        return productDetailList;
    }

    /**
     * 根据子订单ID查询打印桌台数据
     *
     * @param subOrderID
     * @return
     */
    public TableInfoVO getPrintTable(Long subOrderID) {
        checkParam(subOrderID);
        return copeProductInfoDao.getPrintTableBasic(subOrderID);
    }

    /**
     * 根据菜单ID查询菜单信息
     *
     * @param menuID
     * @return
     */
    public B_MerchantMenuInfoEntity getMenuInfoByMenuID(Long menuID) {
        checkParam(menuID);
        B_MerchantMenuInfoEntity merchantMenuInfo = merchantMenuInfoDao.selectByPrimaryKey(menuID);
        if(null == merchantMenuInfo){
            throw new BizException(CodeMsgConstants.NOT_MERCHANT_ERROR, CodeMsgConstants.NOT_MERCHANT_MSG);
        }
        return merchantMenuInfo;
    }

    /**
     * 根据菜品ID查询菜品信息
     *
     * @param productID
     * @return
     */
    public P_ProductInfoEntity getProductInfoByProductID(Long productID) {
        checkParam(productID);
        P_ProductInfoEntity p_productInfo = productInfoDao.selectByPrimaryKey(productID);
        if(null == p_productInfo){
            throw new BizException(CodeMsgConstants.NOT_PRODUCT_ERROR, CodeMsgConstants.NOT_PRODUCT_MSG);
        }
        return p_productInfo;
    }

    /**
     * 根据变体ID查询变体信息
     *
     * @param variantID
     * @return
     */
    public P_ProductVariantInfoEntity getProductVariantByVariantID(Long variantID) {
        checkParam(variantID);
        P_ProductVariantInfoEntity variantInfo = productVariantInfoDao.getVariantInfo(variantID);
        if(null == variantInfo){
            throw new BizException(CodeMsgConstants.NOT_PRODUCT_VARIANT_ERROR, CodeMsgConstants.NOT_PRODUCT_VARIANT_MSG);
        }
        return variantInfo;
    }

    /**
     * 根据关联ID查询套餐分组菜品关联信息
     *
     * @param mappingID
     * @return
     */
    public P_ComboGroupProductMappingEntity getComboGroupProductMappingByID(Long mappingID){
        checkParam(mappingID);
        P_ComboGroupProductMappingEntity comboGroupProduct = new P_ComboGroupProductMappingEntity();
        comboGroupProduct.setMappingID(mappingID);
        comboGroupProduct = comboGroupProductMappingDao.get(comboGroupProduct);
        if(null == comboGroupProduct){
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        return comboGroupProduct;
    }

    /**
     * 根据配置ID查询套餐配置信息
     *
     * @param settingID
     * @return
     */
    public P_ComboSettingInfoEntity getComboSettingInfoByID(Long settingID){
        checkParam(settingID);
        P_ComboSettingInfoEntity comboSettingInfo = comboSettingInfoDao.selectByPrimaryKey(settingID);
        if(null == comboSettingInfo){
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        return comboSettingInfo;
    }

    public void checkParam(Long param) {
        if (param == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
    }

}
