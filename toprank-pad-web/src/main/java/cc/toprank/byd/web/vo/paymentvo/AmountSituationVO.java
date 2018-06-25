package cc.toprank.byd.web.vo.paymentvo;

import java.math.BigDecimal;

/**
 * 收款情况
 * Created by HuangCY on 2017-4-28.
 */
public class AmountSituationVO {
    // 结果码
    private int code;
    // 返回消息
    private String msg;
    //消费金额
    private BigDecimal totalAmount;
    //折扣金额
    private BigDecimal discountAmount;
    //已收金额
    private BigDecimal paidAmount;
    //赠送金额
    private BigDecimal giveProductAmount;
    //减免金额
    private BigDecimal reductionAmount;
    //减免人
    private String reductionPerson;
    //抹零金额
    private BigDecimal droptailAmount;
    //订金
    private BigDecimal bookingAmount;
    //应收金额
    private BigDecimal payableAmount;
    //待收金额
    private BigDecimal waitCollectAmount;
    //服务费
    private BigDecimal serviceFee;
    //是否免服务费
    private boolean amountIsFee;
    //支付订单ID
    private Long orderID ;
    //业务类型
    private Long BusinessType ;
    //否已经手动打折
    private boolean isHasDiscount;
    //手动打折信息
    private String discountMsg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getGiveProductAmount() {
        return giveProductAmount;
    }

    public void setGiveProductAmount(BigDecimal giveProductAmount) {
        this.giveProductAmount = giveProductAmount;
    }

    public BigDecimal getReductionAmount() {
        return reductionAmount;
    }

    public void setReductionAmount(BigDecimal reductionAmount) {
        this.reductionAmount = reductionAmount;
    }

    public String getReductionPerson() {
        return reductionPerson;
    }

    public void setReductionPerson(String reductionPerson) {
        this.reductionPerson = reductionPerson;
    }

    public BigDecimal getDroptailAmount() {
        return droptailAmount;
    }

    public void setDroptailAmount(BigDecimal droptailAmount) {
        this.droptailAmount = droptailAmount;
    }

    public BigDecimal getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(BigDecimal bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public BigDecimal getWaitCollectAmount() {
        return waitCollectAmount;
    }

    public void setWaitCollectAmount(BigDecimal waitCollectAmount) {
        this.waitCollectAmount = waitCollectAmount;
    }

    public boolean isAmountIsFee() {
        return amountIsFee;
    }

    public void setAmountIsFee(boolean amountIsFee) {
        this.amountIsFee = amountIsFee;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getBusinessType() {
        return BusinessType;
    }

    public void setBusinessType(Long businessType) {
        BusinessType = businessType;
    }

    public boolean isHasDiscount() {
        return isHasDiscount;
    }

    public void setHasDiscount(boolean hasDiscount) {
        isHasDiscount = hasDiscount;
    }

    public String getDiscountMsg() {
        return discountMsg;
    }

    public void setDiscountMsg(String discountMsg) {
        this.discountMsg = discountMsg;
    }
}
