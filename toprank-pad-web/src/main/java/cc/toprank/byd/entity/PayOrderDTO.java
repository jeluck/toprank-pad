package cc.toprank.byd.entity;

import java.math.BigDecimal;

/**
 * 支付订单ID VO
 * Created by HuangCY on 2017-6-13.
 */
public class PayOrderDTO {
    //支付订单ID
    private Long orderID ;
    //订单总额
    private BigDecimal totalAmount;
    //业务类型
    private Long businessType ;

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Long businessType) {
        this.businessType = businessType;
    }
}
