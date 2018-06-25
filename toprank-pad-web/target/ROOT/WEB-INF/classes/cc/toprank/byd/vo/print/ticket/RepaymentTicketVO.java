package cc.toprank.byd.vo.print.ticket;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.vo.print.RepaymentVO;
import com.alibaba.fastjson.annotation.JSONField;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 还款单
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class RepaymentTicketVO extends PrinterTicketVO {

    private RepaymentVO repayment = new RepaymentVO();

    public void setRepayment(RepaymentVO repayment) {
        this.repayment = repayment;
    }

    public LocalDate getBusinessDate() {
        return repayment.getBusinessDate();
    }

    public void setBusinessDate(LocalDate businessDate) {
        repayment.setBusinessDate(businessDate);
    }

    public String getMeals() {
        return repayment.getMeals();
    }

    public void setMeals(String meals) {
        repayment.setMeals(meals);
    }

    public String getOrderNo() {
        return repayment.getOrderNo();
    }

    public void setOrderNo(String orderNo) {
        repayment.setOrderNo(orderNo);
    }

    public String getCashier() {
        return repayment.getCashier();
    }

    public void setCashier(String cashier) {
        repayment.setCashier(cashier);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getRepayTime() {
        return repayment.getRepayTime();
    }

    public void setRepayTime(LocalDateTime repayTime) {
        repayment.setRepayTime(repayTime);
    }

    public String getCashRegister() {
        return repayment.getCashRegister();
    }

    public void setCashRegister(String cashRegister) {
        repayment.setCashRegister(cashRegister);
    }

    public String getRepayProtocol() {
        return repayment.getRepayProtocol();
    }

    public void setRepayProtocol(String repayProtocol) {
        repayment.setRepayProtocol(repayProtocol);
    }

    public String getRepayMethod() {
        return repayment.getRepayMethod();
    }

    public void setRepayMethod(String repayMethod) {
        repayment.setRepayMethod(repayMethod);
    }

    public String getRepayAmount() {
        return repayment.getRepayAmount();
    }

    public void setRepayAmount(String repayAmount) {
        repayment.setRepayAmount(repayAmount);
    }
}
