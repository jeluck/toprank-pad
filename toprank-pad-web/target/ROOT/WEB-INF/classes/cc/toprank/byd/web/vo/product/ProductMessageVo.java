package cc.toprank.byd.web.vo.product;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.web.vo.menu.DesignerInfoVO;

import java.util.List;
import java.util.Map;

/**
 * 下单时获取的商品配置信息，包括规格、称重、口味做法、厨师、厨房状态等
 *
 * @author LinYN
 * @date 2017-4-19
 */
public class ProductMessageVo {

    private Long menuID;

    private ProductVariantVo variant; // 称重

    private List<ProductSpecificationVo> specificationList; // 商品规格

    private Map<String, List<ProductAttributeVo>> attributeMap; // 商品的口味做法

    private List<DesignerInfoVO> designers; // 可选厨师

    public Long getMenuID() {
        return menuID;
    }

    public void setMenuID(Long menuID) {
        this.menuID = menuID;
    }

    public ProductVariantVo getVariant() {
        return variant;
    }

    public void setVariant(ProductVariantVo variant) {
        this.variant = variant;
    }

    public Map<String, List<ProductAttributeVo>> getAttributeMap() {
        return attributeMap;
    }

    public void setAttributeMap(Map<String, List<ProductAttributeVo>> attributeMap) {
        this.attributeMap = attributeMap;
    }

    public List<ProductSpecificationVo> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<ProductSpecificationVo> specificationList) {
        this.specificationList = specificationList;
    }

    public List<DesignerInfoVO> getDesigners() {
        return designers;
    }

    public void setDesigners(List<DesignerInfoVO> designers) {
        this.designers = designers;
    }
}
