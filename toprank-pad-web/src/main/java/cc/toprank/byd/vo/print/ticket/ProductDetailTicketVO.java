package cc.toprank.byd.vo.print.ticket;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.vo.print.ProductDetailVO;

import java.math.BigDecimal;

/**
 * @author LinYN
 * @date 2017-6-8
 */
public class ProductDetailTicketVO {

    private ProductDetailVO productDetail = new ProductDetailVO();

    public ProductDetailTicketVO(){}

    public ProductDetailTicketVO(ProductDetailVO productDetail) {
        this.productDetail = productDetail;
    }

    public void setProductDetail(ProductDetailVO productDetail) {
        this.productDetail = productDetail;
    }

    public String getProductName() {
        return productDetail.getProductName();
    }

    public void setProductName(String productName) {
        productDetail.setProductName(productName);
    }

    public Integer getQuantity() {
        return productDetail.getQuantity();
    }

    public void setQuantity(Integer quantity) {
        productDetail.setQuantity(quantity);
    }

    public String getUnit() {
        return productDetail.getUnit();
    }

    public void setUnit(String unit) {
        productDetail.setUnit(unit);
    }

    public Integer getRelationCount() {
        return productDetail.getRelationCount();
    }

    public void setRelationCount(Integer relationCount) {
        productDetail.setRelationCount(relationCount);
    }

    public BigDecimal getAmount() {
        return productDetail.getAmount();
    }

    public void setAmount(BigDecimal amount) {
        productDetail.setAmount(amount);
    }

    public String getAttributes() {
        return productDetail.getAttributes();
    }

    public void setAttributes(String attributes) {
        productDetail.setAttributes(attributes);
    }

    public Boolean getCombo() {
        return productDetail.getCombo();
    }

    public void setCombo(Boolean combo) {
        productDetail.setCombo(combo);
    }

    public String getComboName() {
        return productDetail.getComboName();
    }

    public void setComboName(String comboName) {
        productDetail.setComboName(comboName);
    }

    public String getProductTags() {
        return productDetail.getProductTags();
    }

    public void setProductTags(String productTags) {
        productDetail.setProductTags(productTags);
    }

    public String getDesigner() {
        return productDetail.getDesigner();
    }

    public void setDesigner(String designer) {
        productDetail.setDesigner(designer);
    }

    public BigDecimal getDesignerPrice() {
        return productDetail.getDesignerPrice();
    }

    public void setDesignerPrice(BigDecimal designerPrice) {
        productDetail.setDesignerPrice(designerPrice);
    }

    public String getTargetTable() {
        return productDetail.getTargetTable();
    }

    public void setTargetTable(String targetTable) {
        productDetail.setTargetTable(targetTable);
    }

    public String getProducePort() {
        return productDetail.getProducePort();
    }

    public void setProducePort(String producePort) {
        productDetail.setProducePort(producePort);
    }

    public Float getWeight() {
        return productDetail.getWeight();
    }

    public void setWeight(Float weight) {
        productDetail.setWeight(weight);
    }
}
