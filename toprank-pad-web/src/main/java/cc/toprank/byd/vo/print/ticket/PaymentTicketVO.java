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
 * 结账单
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class PaymentTicketVO extends MemberCardTicketVO {

    private SettleInfoVO settleInfo = new SettleInfoVO(); // 结账单 / 暂结单

    private List<ProductDetailTicketVO> details; // 菜品明细

    private PaymentInfoVO payment = new PaymentInfoVO(); // 付款情况

    public void setSettleInfo(SettleInfoVO settleInfo) {
        this.settleInfo = settleInfo;
    }

    public List<ProductDetailTicketVO> getDetails() {
        return details;
    }

    public void setDetails(List<ProductDetailTicketVO> details) {
        this.details = details;
    }

    public void setPayment(PaymentInfoVO payment) {
        this.payment = payment;
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

    public String getCashRegister() {
        return payment.getCashRegister();
    }

    public void setCashRegister(String cashRegister) {
        payment.setCashRegister(cashRegister);
    }

    public String getCashier() {
        return payment.getCashier();
    }

    public void setCashier(String cashier) {
        payment.setCashier(cashier);
    }

    public BigDecimal getCashPayAmount() {
        return payment.getCashPayAmount();
    }

    public void setCashPayAmount(BigDecimal cashPayAmount) {
        payment.setCashPayAmount(cashPayAmount);
    }

    public BigDecimal getCreditAmount() {
        return payment.getCreditAmount();
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        payment.setCreditAmount(creditAmount);
    }

    public String getCreditProtocol() {
        return payment.getCreditProtocol();
    }

    public void setCreditProtocol(String creditProtocol) {
        payment.setCreditProtocol(creditProtocol);
    }

    public String getSignName() {
        return payment.getSignName();
    }

    public void setSignName(String signName) {
        payment.setSignName(signName);
    }

    public BigDecimal getWeixinPayAmount() {
        return payment.getWeixinPayAmount();
    }

    public void setWeixinPayAmount(BigDecimal weixinPayAmount) {
        payment.setWeixinPayAmount(weixinPayAmount);
    }

    public BigDecimal getAliPayAmount() {
        return payment.getAliPayAmount();
    }

    public void setAliPayAmount(BigDecimal aliPayAmount) {
        payment.setAliPayAmount(aliPayAmount);
    }

    public BigDecimal getBankPayAmount() {
        return payment.getBankPayAmount();
    }

    public void setBankPayAmount(BigDecimal bankPayAmount) {
        payment.setBankPayAmount(bankPayAmount);
    }

    public String getBankCard() {
        return payment.getBankCard();
    }

    public void setBankCard(String bankCard) {
        payment.setBankCard(bankCard);
    }

    public BigDecimal getVoucherPayAmount() {
        return payment.getVoucherPayAmount();
    }

    public void setVoucherPayAmount(BigDecimal voucherPayAmount) {
        payment.setVoucherPayAmount(voucherPayAmount);
    }

    public BigDecimal getkCoinPayAmount() {
        return payment.getkCoinPayAmount();
    }

    public void setkCoinPayAmount(BigDecimal kCoinPayAmount) {
        payment.setkCoinPayAmount(kCoinPayAmount);
    }

    public BigDecimal getChargeAmount() {
        return payment.getChargeAmount();
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        payment.setChargeAmount(chargeAmount);
    }

    public BigDecimal getInvoiceAmount() {
        return payment.getInvoiceAmount();
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        payment.setInvoiceAmount(invoiceAmount);
    }

    public String getInvoiceNumber() {
        return payment.getInvoiceNumber();
    }

    public void setInvoiceNumber(String invoiceNumber) {
        payment.setInvoiceNumber(invoiceNumber);
    }
}
