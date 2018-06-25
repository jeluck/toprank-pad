package cc.toprank.byd.web.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * 支付参数DTO
 * Created by HuangCY on 2017-4-11.
 */
public class PaymentDTO {
    //应付总金额
    private BigDecimal payableTotalAmount;
    //支付金额
    private BigDecimal paymentAmount;
    //机构ID
    private Long orgID;
    //操作人ID
    private Long operatorID;
    //档案ID
    private Long archiveID;
    //子订单ID集合
    private List<Long> subOrderIDList;
    //支付方式编号
    private Long paymentMethodID;
    //预订ID
    private Long bookingID;
    //支付订单ID
    private Long orderID;
    //业务类型
    private Long businessType;

    public Long getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Long businessType) {
        this.businessType = businessType;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

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

    public BigDecimal getPayableTotalAmount() {
        return payableTotalAmount;
    }

    public void setPayableTotalAmount(BigDecimal payableTotalAmount) {
        this.payableTotalAmount = payableTotalAmount;
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

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }

    public Long getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(Long operatorID) {
        this.operatorID = operatorID;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }


}
