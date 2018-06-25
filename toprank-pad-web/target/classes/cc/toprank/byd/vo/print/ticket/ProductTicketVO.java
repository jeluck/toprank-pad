package cc.toprank.byd.vo.print.ticket;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.vo.print.ProductDetailVO;
import cc.toprank.byd.vo.print.TableInfoVO;
import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 分单
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class ProductTicketVO extends PrinterTicketVO {

    private TableInfoVO tableInfo = new TableInfoVO(); // 总单 / 分单

    private ProductDetailVO productDetail = new ProductDetailVO(); // 菜品明细

    public void setTableInfo(TableInfoVO tableInfo) {
        this.tableInfo = tableInfo;
    }

    public void setProductDetail(ProductDetailVO productDetail) {
        this.productDetail = productDetail;
    }

    public String getProducePort() {
        return productDetail.getProducePort();
    }

    public void setProducePort(String producePort) {
        productDetail.setProducePort(producePort);
    }

    public String getArea() {
        return tableInfo.getArea();
    }

    public void setArea(String area) {
        tableInfo.setArea(area);
    }

    public String getTable() {
        return tableInfo.getTable();
    }

    public void setTable(String table) {
        tableInfo.setTable(table);
    }

    public String getTargetTable() {
        return productDetail.getTargetTable();
    }

    public void setTargetTable(String targetTable) {
        productDetail.setTargetTable(targetTable);
    }

    public String getRelationTables() {
        return tableInfo.getRelationTables();
    }

    public void setRelationTables(String relationTables) {
        tableInfo.setRelationTables(relationTables);
    }

    public Integer getPeopleNum() {
        return tableInfo.getPeopleNum();
    }

    public void setPeopleNum(Integer peopleNum) {
        tableInfo.setPeopleNum(peopleNum);
    }

    public String getOrderNo() {
        return tableInfo.getOrderNo();
    }

    public void setOrderNo(String orderNo) {
        tableInfo.setOrderNo(orderNo);
    }

    public String getWaiter() {
        return tableInfo.getWaiter();
    }

    public void setWaiter(String waiter) {
        tableInfo.setWaiter(waiter);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getOperationTime() {
        return tableInfo.getOperationTime();
    }

    public void setOperationTime(LocalDateTime operationTime) {
        tableInfo.setOperationTime(operationTime);
    }

    public String getOperator() {
        return tableInfo.getOperator();
    }

    public void setOperator(String operator) {
        tableInfo.setOperator(operator);
    }

    public String getBarCode() {
        return tableInfo.getBarCode();
    }

    public void setBarCode(String barCode) {
        tableInfo.setBarCode(barCode);
    }

    public String getRemark() {
        return tableInfo.getRemark();
    }

    public void setRemark(String remark) {
        tableInfo.setRemark(remark);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getStartTime() {
        return tableInfo.getStartTime();
    }

    public void setStartTime(LocalDateTime startTime) {
        tableInfo.setStartTime(startTime);
    }

    public String getProductName() {
        return productDetail.getProductName();
    }

    public void setProductName(String productName) {
        productDetail.setProductName(productName);
    }

    public Float getWeight() {
        return productDetail.getWeight();
    }

    public void setWeight(Float weight) {
        productDetail.setWeight(weight);
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

}
