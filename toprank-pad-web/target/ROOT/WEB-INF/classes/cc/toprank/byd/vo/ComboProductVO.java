package cc.toprank.byd.vo;

import java.math.BigDecimal;

/**
 * 套餐分组商品信息
 *
 * @author LeeJun
 * @create 2017-05-23 18:25
 */
public class ComboProductVO {
    private Long productID;
    private Long variantID;
    // 变体名称
    private String variantName;
    // 原价
    private BigDecimal originalPrice;
    // 价格
    private BigDecimal price;
    // 数量
    private int quantity;
    private String productUnitName;
    // 分组ID
    private Long groupID;
    // 分组名称
    private String groupName;
    // 分组类型
    private Long groupType;
    // 可选数量
    private int allowQuantity;
    private String optionName;

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getProductUnitName() {
        return productUnitName;
    }

    public void setProductUnitName(String productUnitName) {
        this.productUnitName = productUnitName;
    }

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

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getGroupID() {
        return groupID;
    }

    public void setGroupID(Long groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Long getGroupType() {
        return groupType;
    }

    public void setGroupType(Long groupType) {
        this.groupType = groupType;
    }

    public int getAllowQuantity() {
        return allowQuantity;
    }

    public void setAllowQuantity(int allowQuantity) {
        this.allowQuantity = allowQuantity;
    }
}
