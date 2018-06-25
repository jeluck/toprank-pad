package cc.toprank.byd.pad.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单详情dto
 *
 * @author LeeJun
 * @create 2017-05-17 11:22
 */
public class OrderDetailsDTO {
    // 订单号
    private String orderCode;
    // 开台时间
    private LocalDateTime openTableTime;
    // 就餐时间(当前时间-开台时间)
    private long duration;
    // 就餐人数
    private int peopleNum;
    // 开台人
    private String openTablePeople;
    // 服务员
    private String waiter;
    // 订单备注
    private String memo;
    // 桌台号
    private String tableCode;
    // 桌台名称
    private String tableName;
    // 桌台状态
    private Long tableStatus;
    // 桌台状态名称
    private String tableStatusName;
    // 订单总额
    private BigDecimal totalAmount = new BigDecimal(0);
    // 实际金额（消费金额）
    private BigDecimal actualAmount = new BigDecimal(0);
    // 待付金额
    private BigDecimal pendingAmount = new BigDecimal(0);
    // 预定金额
    private BigDecimal bookingAmount = new BigDecimal(0);
    // 折扣金额
    private BigDecimal discountAmount = new BigDecimal(0);
    // 减免金额
    private BigDecimal cutAmount = new BigDecimal(0);
    // 抹零金额
    private BigDecimal zeroAmount = new BigDecimal(0);
    // 赠送金额
    private BigDecimal giveAmount = new BigDecimal(0);
    // 应付金额
    private BigDecimal payableAmount = new BigDecimal(0);
    // 已付金额
    private BigDecimal paidAmount = new BigDecimal(0);
    // 服务费
    private BigDecimal serviceAmount = new BigDecimal(0);

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public BigDecimal getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(BigDecimal serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public String getTableStatusName() {
        return tableStatusName;
    }

    public void setTableStatusName(String tableStatusName) {
        this.tableStatusName = tableStatusName;
    }

    public Long getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Long tableStatus) {
        this.tableStatus = tableStatus;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public LocalDateTime getOpenTableTime() {
        return openTableTime;
    }

    public void setOpenTableTime(LocalDateTime openTableTime) {
        this.openTableTime = openTableTime;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getOpenTablePeople() {
        return openTablePeople;
    }

    public void setOpenTablePeople(String openTablePeople) {
        this.openTablePeople = openTablePeople;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    public BigDecimal getPendingAmount() {
        return pendingAmount;
    }

    public void setPendingAmount(BigDecimal pendingAmount) {
        this.pendingAmount = pendingAmount;
    }

    public BigDecimal getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(BigDecimal bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getCutAmount() {
        return cutAmount;
    }

    public void setCutAmount(BigDecimal cutAmount) {
        this.cutAmount = cutAmount;
    }

    public BigDecimal getZeroAmount() {
        return zeroAmount;
    }

    public void setZeroAmount(BigDecimal zeroAmount) {
        this.zeroAmount = zeroAmount;
    }

    public BigDecimal getGiveAmount() {
        return giveAmount;
    }

    public void setGiveAmount(BigDecimal giveAmount) {
        this.giveAmount = giveAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

}
