package cc.toprank.byd.vo.print.ticket;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.vo.print.MemberRechargeVO;
import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 会员充值单
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class MemberRechargeTicketVO extends MemberCardTicketVO{

    private MemberRechargeVO memberRecharge = new MemberRechargeVO();

    public void setMemberRecharge(MemberRechargeVO memberRecharge) {
        this.memberRecharge = memberRecharge;
    }

    public LocalDate getBusinessDate() {
        return memberRecharge.getBusinessDate();
    }

    public void setBusinessDate(LocalDate businessDate) {
        memberRecharge.setBusinessDate(businessDate);
    }

    public String getSalesMan() {
        return memberRecharge.getSalesMan();
    }

    public void setSalesMan(String salesMan) {
        memberRecharge.setSalesMan(salesMan);
    }

    public String getCashier() {
        return memberRecharge.getCashier();
    }

    public void setCashier(String cashier) {
        memberRecharge.setCashier(cashier);
    }

    public String getCashRegister() {
        return memberRecharge.getCashRegister();
    }

    public void setCashRegister(String cashRegister) {
        memberRecharge.setCashRegister(cashRegister);
    }

    public String getPayMethod() {
        return memberRecharge.getPayMethod();
    }

    public void setPayMethod(String payMethod) {
        memberRecharge.setPayMethod(payMethod);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getRechargeTime() {
        return memberRecharge.getRechargeTime();
    }

    public void setRechargeTime(LocalDateTime rechargeTime) {
        memberRecharge.setRechargeTime(rechargeTime);
    }

    public Long getBusinessID() {
        return memberRecharge.getBusinessID();
    }

    public void setBusinessID(Long businessID) {
        memberRecharge.setBusinessID(businessID);
    }

    public BigDecimal getRechargeAmount() {
        return memberRecharge.getRechargeAmount();
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        memberRecharge.setRechargeAmount(rechargeAmount);
    }

    public BigDecimal getGiveAmount() {
        return memberRecharge.getGiveAmount();
    }

    public void setGiveAmount(BigDecimal giveAmount) {
        memberRecharge.setGiveAmount(giveAmount);
    }
}

