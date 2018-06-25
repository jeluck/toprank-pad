package cc.toprank.byd.web.vo.order;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by HuTao on 2017-5-2.
 */
public class TableOrderInfoVO {
    private  int number;               //  序号
    private  String orderCode;          //  订单编号
    private Long    subOrderID;      //  子订单ID
    private Long    orderID;         //  订单ID
    private Long    tableID;         //   桌台ID
    private int  customerNumber ;     //  就餐人数
    private LocalDate bizDate;         //  营业日期
    private LocalDateTime  createTime; //  开台时间
    private  String tableName;         //  桌台名称
    private double actualAmount;       //  订单金额
    private  String orderChannelName;  //  订单来源
    private  String mealName;           //   餐次名称
    private  String creatorName;       //   开台人
    private  String serverName;        //   服务员
    private  String accountCode;       //   结帐单号
    private  LocalDateTime accountTime;  //  结账时间
    private  String cashier;             //  收银员
    private  String cashRegister;       //  收银机
    private  String cancelReason;       //   取消原因

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getSubOrderID() {
        return subOrderID;
    }

    public void setSubOrderID(Long subOrderID) {
        this.subOrderID = subOrderID;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public LocalDate getBizDate() {
        return bizDate;
    }

    public void setBizDate(LocalDate bizDate) {
        this.bizDate = bizDate;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getOrderChannelName() {
        return orderChannelName;
    }

    public void setOrderChannelName(String orderChannelName) {
        this.orderChannelName = orderChannelName;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public LocalDateTime getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(LocalDateTime accountTime) {
        this.accountTime = accountTime;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(String cashRegister) {
        this.cashRegister = cashRegister;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }
}
