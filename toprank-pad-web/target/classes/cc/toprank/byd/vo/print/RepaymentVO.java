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
 * @author LinYN
 * @date 2017-6-5
 */
public class RepaymentVO extends BusinessVO {

    private LocalDate businessDate; // 营业日期
    private String meals; // 餐次
    private String orderNo; // 还款单号
    private String cashier; // 收银员
    private LocalDateTime repayTime; // 还款时间
    private String cashRegister; // 收银机
    private String repayProtocol; // 协议客户
    private String repayMethod; // 还款方式
    private String repayAmount; // 还款金额

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

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public LocalDateTime getRepayTime() {
        return repayTime;
    }

    public void setRepayTime(LocalDateTime repayTime) {
        this.repayTime = repayTime;
    }

    public String getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(String cashRegister) {
        this.cashRegister = cashRegister;
    }

    public String getRepayProtocol() {
        return repayProtocol;
    }

    public void setRepayProtocol(String repayProtocol) {
        this.repayProtocol = repayProtocol;
    }

    public String getRepayMethod() {
        return repayMethod;
    }

    public void setRepayMethod(String repayMethod) {
        this.repayMethod = repayMethod;
    }

    public String getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(String repayAmount) {
        this.repayAmount = repayAmount;
    }
}
