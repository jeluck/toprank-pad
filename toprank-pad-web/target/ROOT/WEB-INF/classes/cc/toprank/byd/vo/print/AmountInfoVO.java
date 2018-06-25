package cc.toprank.byd.vo.print;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 交班对账单 / 日结对账单
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class AmountInfoVO extends BusinessVO {

    private LocalDate businessDate; // 营业日期
    private String cashRegister; // 收银机
    private String meals; // 餐次
    private LocalDateTime joinTime; // 交班时间
    private String joinPeople; // 交班人
    private Integer totalQuantity; // 总数量
    private BigDecimal totalAmount; // 总金额
    private BigDecimal giveAmount; // 赠送金额
    private BigDecimal discountAmount; // 折扣金额
    private BigDecimal reduceAmount; // 减免金额
    private BigDecimal serviceAmount; // 服务费
    private BigDecimal smallAmount; // 抹零
    private BigDecimal actualAmount; // 应收金额
    private BigDecimal incomeAmount; // 收入金额
    private BigDecimal invoiceAmount; // 开票金额
    private Integer orderCount; // 订单数
    private Integer peopleCount; // 人数
    private BigDecimal avgOrderAmount; // 单均消费
    private BigDecimal avgPeopleAmount; // 人均消费
    private Float turnoverRate; // 翻台率
    private Float tableRate; // 上座率

    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public String getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(String cashRegister) {
        this.cashRegister = cashRegister;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public LocalDateTime getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(LocalDateTime joinTime) {
        this.joinTime = joinTime;
    }

    public String getJoinPeople() {
        return joinPeople;
    }

    public void setJoinPeople(String joinPeople) {
        this.joinPeople = joinPeople;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getGiveAmount() {
        return giveAmount;
    }

    public void setGiveAmount(BigDecimal giveAmount) {
        this.giveAmount = giveAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public BigDecimal getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(BigDecimal serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public BigDecimal getSmallAmount() {
        return smallAmount;
    }

    public void setSmallAmount(BigDecimal smallAmount) {
        this.smallAmount = smallAmount;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public BigDecimal getAvgOrderAmount() {
        return avgOrderAmount;
    }

    public void setAvgOrderAmount(BigDecimal avgOrderAmount) {
        this.avgOrderAmount = avgOrderAmount;
    }

    public BigDecimal getAvgPeopleAmount() {
        return avgPeopleAmount;
    }

    public void setAvgPeopleAmount(BigDecimal avgPeopleAmount) {
        this.avgPeopleAmount = avgPeopleAmount;
    }

    public Float getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Float turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Float getTableRate() {
        return tableRate;
    }

    public void setTableRate(Float tableRate) {
        this.tableRate = tableRate;
    }
}
