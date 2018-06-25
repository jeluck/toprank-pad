package cc.toprank.byd.pad.pojo;

import java.math.BigDecimal;

/**
 * 菜品规格信息
 *
 * @author LeeJun
 * @create 2017-06-07 13:36
 */
public class SpecificationDTO {
    private Long productID;
    private Long variantID;
    private Long specificationID;
    private String specificationName;
    private Long optionID;
    private String optionName;
    private BigDecimal addedPrice;

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
}
