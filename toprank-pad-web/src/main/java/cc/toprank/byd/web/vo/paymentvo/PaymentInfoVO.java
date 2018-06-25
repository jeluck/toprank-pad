package cc.toprank.byd.web.vo.paymentvo;

import java.math.BigDecimal;

/**
 * 支付信息VO
 * Created by HuangCY on 2017-4-7.
 */
public class PaymentInfoVO {
    //支付方式编号
    private Long paymentMethodID;
    //支付金额
    private BigDecimal paymentAmount;
    //是否线上支付
    private boolean isOnline;

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public Long getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(Long paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
