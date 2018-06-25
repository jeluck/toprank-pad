package cc.toprank.byd.vo.print.ticket;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.vo.print.MemberPaymentVO;
import com.alibaba.fastjson.annotation.JSONField;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 会员付款单
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class MemberPaymentTicketVO extends MemberCardTicketVO {

    private MemberPaymentVO memberPayment = new MemberPaymentVO();

    public void setMemberPayment(MemberPaymentVO memberPayment) {
        this.memberPayment = memberPayment;
    }

    public LocalDate getBusinessDate() {
        return memberPayment.getBusinessDate();
    }

    public void setBusinessDate(LocalDate businessDate) {
        memberPayment.setBusinessDate(businessDate);
    }

    public String getMeals() {
        return memberPayment.getMeals();
    }

    public void setMeals(String meals) {
        memberPayment.setMeals(meals);
    }

    public String getOrderNo() {
        return memberPayment.getOrderNo();
    }

    public void setOrderNo(String orderNo) {
        memberPayment.setOrderNo(orderNo);
    }

    public String getTable() {
        return memberPayment.getTable();
    }

    public void setTable(String table) {
        memberPayment.setTable(table);
    }

    public String getRelationTables() {
        return memberPayment.getRelationTables();
    }

    public void setRelationTables(String relationTables) {
        memberPayment.setRelationTables(relationTables);
    }

    public Integer getPeopleNum() {
        return memberPayment.getPeopleNum();
    }

    public void setPeopleNum(Integer peopleNum) {
        memberPayment.setPeopleNum(peopleNum);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getOperationTime() {
        return memberPayment.getOperationTime();
    }

    public void setOperationTime(LocalDateTime operationTime) {
        memberPayment.setOperationTime(operationTime);
    }

    public String getSalesMan() {
        return memberPayment.getSalesMan();
    }

    public void setSalesMan(String salesMan) {
        memberPayment.setSalesMan(salesMan);
    }

    public String getCashRegister() {
        return memberPayment.getCashRegister();
    }

    public void setCashRegister(String cashRegister) {
        memberPayment.setCashRegister(cashRegister);
    }

    public String getCashier() {
        return memberPayment.getCashier();
    }

    public void setCashier(String cashier) {
        memberPayment.setCashier(cashier);
    }
}
