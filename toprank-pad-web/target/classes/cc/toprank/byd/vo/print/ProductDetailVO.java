package cc.toprank.byd.vo.print;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.enums.PrintManageEnum;

import java.math.BigDecimal;

/**
 * @author LinYN
 * @date 2017-6-5
 */
public class ProductDetailVO extends BusinessVO {

    private Long detailID;   //明细ID
    private Long productID; // 商品编号
    private Long variantID; // 变体编号
    private Long categoryID; // 类别编号
    private String productName; // 菜名
    private String producePort; // 出品部
    private Float weight; // 重量
    private Integer quantity; // 数量
    private String unit; // 重量单位 OR 数量单位
    private Integer relationCount; // 席数
    private BigDecimal amount; // 金额
    private String attributes; // 口味做法
    private Boolean isCombo; // 是否套餐明细
    private String comboName; // 所属套餐
    private String productTags; // 标志
    private String designer; // 厨师
    private BigDecimal designerPrice; // 厨师费
    private String targetTable; // 目标桌台
    private Long aLaCarteMethod; // 点菜方式

    public Long getDetailID() {
        return detailID;
    }

    public void setDetailID(Long detailID) {
        this.detailID = detailID;
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

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducePort() {
        return producePort;
    }

    public void setProducePort(String producePort) {
        this.producePort = producePort;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getRelationCount() {
        return relationCount;
    }

    public void setRelationCount(Integer relationCount) {
        this.relationCount = relationCount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public Boolean getCombo() {
        return isCombo;
    }

    public void setCombo(Boolean combo) {
        isCombo = combo;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public String getProductTags() {
        return productTags;
    }

    public void setProductTags(String productTags) {
        this.productTags = productTags;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public BigDecimal getDesignerPrice() {
        return designerPrice;
    }

    public void setDesignerPrice(BigDecimal designerPrice) {
        this.designerPrice = designerPrice;
    }

    public String getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(String targetTable) {
        this.targetTable = targetTable;
    }

    public Long getaLaCarteMethod() {
        return aLaCarteMethod;
    }

    public void setaLaCarteMethod(Long aLaCarteMethod) {
        this.aLaCarteMethod = aLaCarteMethod;
    }

    public PrintManageEnum.TicketTypeEnum getTicketType() {
        PrintManageEnum.TicketTypeEnum ticketType = null;
        switch (NumberUtil.intValue(aLaCarteMethod)) {
            case 685 : ticketType = PrintManageEnum.TicketTypeEnum.RETURN; break; // 退菜
            case 686 : ticketType = PrintManageEnum.TicketTypeEnum.GIVE; break; // 赠菜
            case 687 : ticketType = PrintManageEnum.TicketTypeEnum.APPEND; break; // 加菜
            case 996 : ticketType = PrintManageEnum.TicketTypeEnum.TURN; break; // 转菜
            case 997 : ticketType = PrintManageEnum.TicketTypeEnum.CHANGE; break; // 换菜
            case 998 : ticketType = PrintManageEnum.TicketTypeEnum.TURN_GIVE; break; // 转赠
            default : ticketType =  PrintManageEnum.TicketTypeEnum.NORMAL; break; // 出品
        }
        return ticketType;
    }
}
