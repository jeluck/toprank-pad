package cc.toprank.byd.web.vo.discount;/**
 * Created by ZhouWei on 2017-5-22.
 */

import cc.toprank.byd.entity.M_ActivityInfoEntity;
import cc.toprank.byd.enums.MerchantManageEnum;

import java.math.BigDecimal;

/**
 * @param
 * @author zhouwei
 * @version 2.0.0
 * @description 活动促销信息
 * @time 2017-05-22-14:46
 * @return
 */
public class ActivityInfoVO extends M_ActivityInfoEntity{
    private Long discountType;
    private String ruleName;
    private Long activiryRuleStatus;
    private BigDecimal spentAmount;
    private Integer productQuantity;
    private Integer isAmount;
    private Integer totalQuantity;
    private Integer remainQuqntity;
    private String discountName;
    private BigDecimal baseAmount;
    private BigDecimal lowPrice;
    private BigDecimal highPrice;
    private Float discountPercentage;
    private BigDecimal discountAmount;
    private BigDecimal presentAmount;
    private Integer presentBonus;
    private Float bonusMultiply;
    private Boolean canAccumulative;
    private Long discountID;

    public Long getDiscountID() {
        return discountID;
    }

    public void setDiscountID(Long discountID) {
        this.discountID = discountID;
    }

    public Long getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Long discountType) {
        this.discountType = discountType;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Long getActiviryRuleStatus() {
        return activiryRuleStatus;
    }

    public void setActiviryRuleStatus(Long activiryRuleStatus) {
        this.activiryRuleStatus = activiryRuleStatus;
    }

    public BigDecimal getSpentAmount() {
        return spentAmount;
    }

    public void setSpentAmount(BigDecimal spentAmount) {
        this.spentAmount = spentAmount;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getIsAmount() {
        return isAmount;
    }

    public void setIsAmount(Integer isAmount) {
        this.isAmount = isAmount;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public Integer getRemainQuqntity() {
        return remainQuqntity;
    }

    public void setRemainQuqntity(Integer remainQuqntity) {
        this.remainQuqntity = remainQuqntity;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public Float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getPresentAmount() {
        return presentAmount;
    }

    public void setPresentAmount(BigDecimal presentAmount) {
        this.presentAmount = presentAmount;
    }

    public Integer getPresentBonus() {
        return presentBonus;
    }

    public void setPresentBonus(Integer presentBonus) {
        this.presentBonus = presentBonus;
    }

    public Float getBonusMultiply() {
        return bonusMultiply;
    }

    public void setBonusMultiply(Float bonusMultiply) {
        this.bonusMultiply = bonusMultiply;
    }

    public Boolean getCanAccumulative() {
        return canAccumulative;
    }

    public void setCanAccumulative(Boolean canAccumulative) {
        this.canAccumulative = canAccumulative;
    }
}
