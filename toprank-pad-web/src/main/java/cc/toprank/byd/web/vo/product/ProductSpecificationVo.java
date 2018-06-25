package cc.toprank.byd.web.vo.product;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.math.BigDecimal;

/**
 * 商品规格信息
 *
 * @author LinYN
 * @date 2017-4-19
 */
public class ProductSpecificationVo {

    private Long productID; // 商品编号

    private Long variantID; // 变体编号

    private Long specificationID; // 规格编号

    private String specificationName; // 规格名称

    private Long optionID; // 选项编号

    private String optionName; // 选项名称

    private BigDecimal addedPrice; // 加价

    private BigDecimal price; // 实际价格

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

    public Long getSpecificationID() {
        return specificationID;
    }

    public void setSpecificationID(Long specificationID) {
        this.specificationID = specificationID;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    public Long getOptionID() {
        return optionID;
    }

    public void setOptionID(Long optionID) {
        this.optionID = optionID;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public BigDecimal getAddedPrice() {
        return addedPrice;
    }

    public void setAddedPrice(BigDecimal addedPrice) {
        this.addedPrice = addedPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
