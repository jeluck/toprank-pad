package cc.toprank.byd.vo.print;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 会员付款单
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class MemberPaymentVO extends BusinessVO {

    private LocalDate businessDate; // 营业日期
    private String meals; // 餐次
    private String orderNo; // 订单号
    private String table; // 桌台
    private String relationTables; // 相关餐台
    private Integer peopleNum; // 人数
    private LocalDateTime operationTime; // 付款时间
    private String salesMan; // 营销员
    private String cashRegister; // 收银机
    private String cashier; // 收银员

    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getRelationTables() {
        return relationTables;
    }

    public void setRelationTables(String relationTables) {
        this.relationTables = relationTables;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    public String getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(String cashRegister) {
        this.cashRegister = cashRegister;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }
}
