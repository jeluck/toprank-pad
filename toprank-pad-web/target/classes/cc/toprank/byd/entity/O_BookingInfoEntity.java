package cc.toprank.byd.entity;

import cc.toprank.byd.entity.O_BookingInfoEntityBase;

import java.math.BigDecimal;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_BookingInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_BookingInfoEntity extends O_BookingInfoEntityBase {
    private String mobile;//预订人手机号
    private String customerName;//预订人名称

    private String merchantName;//商户名称

    private String managerPhone;//商户电话

    private String postalAddress;//商户通讯地址

    private Long subOrderID;

    // 是否可开台
    private boolean canOpen;

    private BigDecimal paidAmount;//已付金额

    private BigDecimal actualAmount;//消费金额

    public boolean isCanOpen() {
        return canOpen;
    }

    public void setCanOpen(boolean canOpen) {
        this.canOpen = canOpen;
    }

    public Long getSubOrderID() {
        return subOrderID;
    }

    public void setSubOrderID(Long subOrderID) {
        this.subOrderID = subOrderID;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }
}