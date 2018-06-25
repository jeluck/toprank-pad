package cc.toprank.byd.vo.print.ticket;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.vo.print.AmountInfoVO;
import cc.toprank.byd.vo.print.TransDetailVO;
import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 交班对账单 / 日结对账单
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class AmountTicketVO extends PrinterTicketVO {

    private AmountInfoVO amountInfo = new AmountInfoVO();

    private List<TransDetailVO> details; // 交接明细

    public void setAmountInfo(AmountInfoVO amountInfo) {
        this.amountInfo = amountInfo;
    }

    public List<TransDetailVO> getDetails() {
        return details;
    }

    public void setDetails(List<TransDetailVO> details) {
        this.details = details;
    }


    public LocalDate getBusinessDate() {
        return amountInfo.getBusinessDate();
    }

    
    public void setBusinessDate(LocalDate businessDate) {
        amountInfo.setBusinessDate(businessDate);
    }

    
    public String getCashRegister() {
        return amountInfo.getCashRegister();
    }

    
    public void setCashRegister(String cashRegister) {
        amountInfo.setCashRegister(cashRegister);
    }

    
    public String getMeals() {
        return amountInfo.getMeals();
    }

    
    public void setMeals(String meals) {
        amountInfo.setMeals(meals);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getJoinTime() {
        return amountInfo.getJoinTime();
    }

    
    public void setJoinTime(LocalDateTime joinTime) {
        amountInfo.setJoinTime(joinTime);
    }

    
    public String getJoinPeople() {
        return amountInfo.getJoinPeople();
    }

    
    public void setJoinPeople(String joinPeople) {
        amountInfo.setJoinPeople(joinPeople);
    }

    
    public Integer getTotalQuantity() {
        return amountInfo.getTotalQuantity();
    }

    
    public void setTotalQuantity(Integer totalQuantity) {
        amountInfo.setTotalQuantity(totalQuantity);
    }

    
    public BigDecimal getTotalAmount() {
        return amountInfo.getTotalAmount();
    }

    
    public void setTotalAmount(BigDecimal totalAmount) {
        amountInfo.setTotalAmount(totalAmount);
    }

    
    public BigDecimal getGiveAmount() {
        return amountInfo.getGiveAmount();
    }

    
    public void setGiveAmount(BigDecimal giveAmount) {
        amountInfo.setGiveAmount(giveAmount);
    }

    
    public BigDecimal getDiscountAmount() {
        return amountInfo.getDiscountAmount();
    }

    
    public void setDiscountAmount(BigDecimal discountAmount) {
        amountInfo.setDiscountAmount(discountAmount);
    }

    
    public BigDecimal getReduceAmount() {
        return amountInfo.getReduceAmount();
    }

    
    public void setReduceAmount(BigDecimal reduceAmount) {
        amountInfo.setReduceAmount(reduceAmount);
    }

    
    public BigDecimal getServiceAmount() {
        return amountInfo.getServiceAmount();
    }

    
    public void setServiceAmount(BigDecimal serviceAmount) {
        amountInfo.setServiceAmount(serviceAmount);
    }

    
    public BigDecimal getSmallAmount() {
        return amountInfo.getSmallAmount();
    }

    
    public void setSmallAmount(BigDecimal smallAmount) {
        amountInfo.setSmallAmount(smallAmount);
    }

    
    public BigDecimal getActualAmount() {
        return amountInfo.getActualAmount();
    }

    
    public void setActualAmount(BigDecimal actualAmount) {
        amountInfo.setActualAmount(actualAmount);
    }

    
    public BigDecimal getIncomeAmount() {
        return amountInfo.getIncomeAmount();
    }

    
    public void setIncomeAmount(BigDecimal incomeAmount) {
        amountInfo.setIncomeAmount(incomeAmount);
    }

    
    public BigDecimal getInvoiceAmount() {
        return amountInfo.getInvoiceAmount();
    }

    
    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        amountInfo.setInvoiceAmount(invoiceAmount);
    }

    
    public Integer getOrderCount() {
        return amountInfo.getOrderCount();
    }

    
    public void setOrderCount(Integer orderCount) {
        amountInfo.setOrderCount(orderCount);
    }

    
    public Integer getPeopleCount() {
        return amountInfo.getPeopleCount();
    }

    
    public void setPeopleCount(Integer peopleCount) {
        amountInfo.setPeopleCount(peopleCount);
    }

    
    public BigDecimal getAvgOrderAmount() {
        return amountInfo.getAvgOrderAmount();
    }

    
    public void setAvgOrderAmount(BigDecimal avgOrderAmount) {
        amountInfo.setAvgOrderAmount(avgOrderAmount);
    }

    
    public BigDecimal getAvgPeopleAmount() {
        return amountInfo.getAvgPeopleAmount();
    }

    
    public void setAvgPeopleAmount(BigDecimal avgPeopleAmount) {
        amountInfo.setAvgPeopleAmount(avgPeopleAmount);
    }

    public Float getTurnoverRate() {
        return amountInfo.getTurnoverRate();
    }

    public void setTurnoverRate(Float turnoverRate) {
        amountInfo.setTurnoverRate(turnoverRate);
    }

    public Float getTableRate() {
        return amountInfo.getTableRate();
    }

    public void setTableRate(Float tableRate) {
        amountInfo.setTableRate(tableRate);
    }
}
