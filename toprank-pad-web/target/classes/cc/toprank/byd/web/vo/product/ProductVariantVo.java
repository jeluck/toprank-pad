package cc.toprank.byd.web.vo.product;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


/**
 * 在订单中的商品信息
 *
 * @author LinYN
 * @date 2017-4-19
 */
public class ProductVariantVo {

    private Long productID; // 商品编号

    private Long variantID; // 变体编号

    private String variantName; // 变体名称

    private Long unitID; // 商品单位

    private String unitName; // 商品单位名称

    private Float weight; // 称重重量

    private Long weightID; // 称重单位编号

    private String weightName; // 称重单位名称

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getVariantID() {
        return variantID;
    }

    public void setVariantID(Long variantID) {
        this.variantID = variantID;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Long getWeightID() {
        return weightID;
    }

    public void setWeightID(Long weightID) {
        this.weightID = weightID;
    }

    public String getWeightName() {
        return weightName;
    }

    public void setWeightName(String weightName) {
        this.weightName = weightName;
    }

    public Long getUnitID() {
        return unitID;
    }

    public void setUnitID(Long unitID) {
        this.unitID = unitID;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
