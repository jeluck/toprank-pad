package cc.toprank.byd.web.vo.paymentvo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 会员卡信息
 * Created by HuangCY on 2017-6-16.
 */
public class ThirdPartyPayParamVO {
    //会员卡号
    private Long cardID;
    //客户编号
    private Long customerID;
    //档案编号
    private Long archiveID;
    //登录编号
    private Long loginID;
    //支付金额
    private BigDecimal paymentAmount;
    //子订单ID集合
    private List<Long> subOrderIDList;
    //付款码
    private String authCode;
    //支付方式
    private Long paymentMethodID;
    //预订编号
    private Long bookingID;

    public Long getBookingID() {
        return bookingID;
    }

    public void setBookingID(Long bookingID) {
        this.bookingID = bookingID;
    }

    public Long getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(Long paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
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

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public List<Long> getSubOrderIDList() {
        return subOrderIDList;
    }

    public void setSubOrderIDList(List<Long> subOrderIDList) {
        this.subOrderIDList = subOrderIDList;
    }
}
