package cc.toprank.byd.vo.print;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.math.BigDecimal;

/**
 * 付款情况
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class PaymentInfoVO {

    private String cashRegister; // 收银机
    private String cashier; // 收银员
    private BigDecimal cashPayAmount; // 现金
    private BigDecimal cardPayAmount; // 会员卡
    private String memberCard; // 会员卡号
    private BigDecimal creditAmount; // 挂账
    private String creditProtocol; // 协议
    private String signName; // 签单人
    private BigDecimal weixinPayAmount; // 微信
    private BigDecimal aliPayAmount; // 支付宝
    private BigDecimal bankPayAmount; // 银联支付
    private String bankCard; // 银行卡号
    private BigDecimal voucherPayAmount; // 代金券
    private BigDecimal kCoinPayAmount; // K币
    private BigDecimal chargeAmount; // 找零
    private BigDecimal invoiceAmount; // 开票金额
    private String invoiceNumber; // 发票编号

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

    public BigDecimal getCashPayAmount() {
        return cashPayAmount;
    }

    public void setCashPayAmount(BigDecimal cashPayAmount) {
        this.cashPayAmount = cashPayAmount;
    }

    public BigDecimal getCardPayAmount() {
        return cardPayAmount;
    }

    public void setCardPayAmount(BigDecimal cardPayAmount) {
        this.cardPayAmount = cardPayAmount;
    }

    public String getMemberCard() {
        return memberCard;
    }

    public void setMemberCard(String memberCard) {
        this.memberCard = memberCard;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getCreditProtocol() {
        return creditProtocol;
    }

    public void setCreditProtocol(String creditProtocol) {
        this.creditProtocol = creditProtocol;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public BigDecimal getWeixinPayAmount() {
        return weixinPayAmount;
    }

    public void setWeixinPayAmount(BigDecimal weixinPayAmount) {
        this.weixinPayAmount = weixinPayAmount;
    }

    public BigDecimal getAliPayAmount() {
        return aliPayAmount;
    }

    public void setAliPayAmount(BigDecimal aliPayAmount) {
        this.aliPayAmount = aliPayAmount;
    }

    public BigDecimal getBankPayAmount() {
        return bankPayAmount;
    }

    public void setBankPayAmount(BigDecimal bankPayAmount) {
        this.bankPayAmount = bankPayAmount;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public BigDecimal getVoucherPayAmount() {
        return voucherPayAmount;
    }

    public void setVoucherPayAmount(BigDecimal voucherPayAmount) {
        this.voucherPayAmount = voucherPayAmount;
    }

    public BigDecimal getkCoinPayAmount() {
        return kCoinPayAmount;
    }

    public void setkCoinPayAmount(BigDecimal kCoinPayAmount) {
        this.kCoinPayAmount = kCoinPayAmount;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
}
