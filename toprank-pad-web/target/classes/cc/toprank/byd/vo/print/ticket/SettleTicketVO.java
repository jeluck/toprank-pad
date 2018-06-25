package cc.toprank.byd.vo.print.ticket;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.vo.print.*;
import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 暂结单
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class SettleTicketVO extends PrinterTicketVO {

    private SettleInfoVO settleInfo = new SettleInfoVO(); // 结账单 / 暂结单

    private List<ProductDetailTicketVO> details; // 菜品明细

    public void setSettleInfo(SettleInfoVO settleInfo) {
        this.settleInfo = settleInfo;
    }

    public List<ProductDetailTicketVO> getDetails() {
        return details;
    }

    public void setDetails(List<ProductDetailTicketVO> details) {
        this.details = details;
    }

    public String getArea() {
        return settleInfo.getArea();
    }

    public void setArea(String area) {
        settleInfo.setArea(area);
    }

    public String getMeals() {
        return settleInfo.getMeals();
    }

    public void setMeals(String meals) {
        settleInfo.setMeals(meals);
    }

    public String getTable() {
        return settleInfo.getTable();
    }

    public void setTable(String table) {
        settleInfo.setTable(table);
    }

    public String getTargetTable() {
        return settleInfo.getTargetTable();
    }

    public void setTargetTable(String targetTable) {
        settleInfo.setTargetTable(targetTable);
    }

    public String getRelationTables() {
        return settleInfo.getRelationTables();
    }

    public void setRelationTables(String relationTables) {
        settleInfo.setRelationTables(relationTables);
    }

    public Integer getPeopleNum() {
        return settleInfo.getPeopleNum();
    }

    public void setPeopleNum(Integer peopleNum) {
        settleInfo.setPeopleNum(peopleNum);
    }

    public Integer getDuration() {
        return settleInfo.getDuration();
    }

    public void setDuration(Integer duration) {
        settleInfo.setDuration(duration);
    }

    public String getOrderNo() {
        return settleInfo.getOrderNo();
    }

    public void setOrderNo(String orderNo) {
        settleInfo.setOrderNo(orderNo);
    }

    public String getWaiter() {
        return settleInfo.getWaiter();
    }

    public void setWaiter(String waiter) {
        settleInfo.setWaiter(waiter);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getOperationTime() {
        return settleInfo.getOperationTime();
    }

    public void setOperationTime(LocalDateTime operationTime) {
        settleInfo.setOperationTime(operationTime);
    }

    public String getOperator() {
        return settleInfo.getOperator();
    }

    public void setOperator(String operator) {
        settleInfo.setOperator(operator);
    }

    public String getBarCode() {
        return settleInfo.getBarCode();
    }

    public void setBarCode(String barCode) {
        settleInfo.setBarCode(barCode);
    }

    public Integer getTotalQuantity() {
        return settleInfo.getTotalQuantity();
    }

    public void setTotalQuantity(Integer totalQuantity) {
        settleInfo.setTotalQuantity(totalQuantity);
    }

    public BigDecimal getTotalAmount() {
        return settleInfo.getTotalAmount();
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        settleInfo.setTotalAmount(totalAmount);
    }

    public BigDecimal getGiveAmount() {
        return settleInfo.getGiveAmount();
    }

    public void setGiveAmount(BigDecimal giveAmount) {
        settleInfo.setGiveAmount(giveAmount);
    }

    public BigDecimal getDiscountAmount() {
        return settleInfo.getDiscountAmount();
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        settleInfo.setDiscountAmount(discountAmount);
    }

    public String getDiscountAuthor() {
        return settleInfo.getDiscountAuthor();
    }

    public void setDiscountAuthor(String discountAuthor) {
        settleInfo.setDiscountAuthor(discountAuthor);
    }

    public BigDecimal getReduceAmount() {
        return settleInfo.getReduceAmount();
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        settleInfo.setReduceAmount(reduceAmount);
    }

    public String getReduceAuthor() {
        return settleInfo.getReduceAuthor();
    }

    public void setReduceAuthor(String reduceAuthor) {
        settleInfo.setReduceAuthor(reduceAuthor);
    }

    public BigDecimal getServiceAmount() {
        return settleInfo.getServiceAmount();
    }

    public void setServiceAmount(BigDecimal serviceAmount) {
        settleInfo.setServiceAmount(serviceAmount);
    }

    public BigDecimal getSmallAmount() {
        return settleInfo.getSmallAmount();
    }

    public void setSmallAmount(BigDecimal smallAmount) {
        settleInfo.setSmallAmount(smallAmount);
    }

    public BigDecimal getActualAmount() {
        return settleInfo.getActualAmount();
    }

    public void setActualAmount(BigDecimal actualAmount) {
        settleInfo.setActualAmount(actualAmount);
    }

    public String getPayStatus() {
        return settleInfo.getPayStatus();
    }

    public void setPayStatus(String payStatus) {
        settleInfo.setPayStatus(payStatus);
    }

    public String getRemark() {
        return settleInfo.getRemark();
    }

    public void setRemark(String remark) {
        settleInfo.setRemark(remark);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getStartTime() {
        return settleInfo.getStartTime();
    }

    public void setStartTime(LocalDateTime startTime) {
        settleInfo.setStartTime(startTime);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getOrderTime() {
        return settleInfo.getOrderTime();
    }

    public void setOrderTime(LocalDateTime orderTime) {
        settleInfo.setOrderTime(orderTime);
    }
}
