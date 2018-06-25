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
 * 商品属性信息
 *
 * @author LinYN
 * @date 2017-4-19
 */
public class ProductAttributeVo {

    private Long productID; // 商品编号

    private Long variantID; // 变体编号

    private Long groupID; // 分组编号 取数据字典 AttributeType

    private Boolean isMethod; // 是否做法

    private Long attributeID; // 属性编号

    private String attributeName; // 属性名称

    private Long valueID; // 属性值编号

    private String attributeValue; // 属性值

    private String categoryName; // 属性分类名

    private BigDecimal addedPrice; // 加价

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

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    public Boolean getMethod() {
        return isMethod;
    }

    public void setMethod(Boolean method) {
        isMethod = method;
    }

    public Long getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(Long attributeID) {
        this.attributeID = attributeID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Long getValueID() {
        return valueID;
    }

    public void setValueID(Long valueID) {
        this.valueID = valueID;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getAddedPrice() {
        return addedPrice;
    }

    public void setAddedPrice(BigDecimal addedPrice) {
        this.addedPrice = addedPrice;
    }
}
