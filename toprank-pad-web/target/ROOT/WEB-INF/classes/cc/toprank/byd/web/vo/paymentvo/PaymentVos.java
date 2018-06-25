package cc.toprank.byd.web.vo.paymentvo;

/**
 * 线上支付VO
 * Created by HuangCY on 2017-6-18.
 */
public class PaymentVos {
    //支付方式
    private Long paymentMethodID;
    //支付金额
    private Integer paymentMoney;
    //扫码授权code
    private String authCode;
    //卡编号
    private Long cardID;

    public Long getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(Long paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
    }

    public Integer getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(Integer paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Long getCardID() {
        return cardID;
    }

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }
}
