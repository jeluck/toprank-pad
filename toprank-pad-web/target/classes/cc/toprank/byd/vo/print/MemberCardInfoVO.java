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
 * 会员付款情况
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class MemberCardInfoVO {

    private String memberCard; // 会员卡号
    private String cardLevel; // 等级
    private String memberCode; // 会员编号
    private String memberName; // 会员名称
    private String mobileNumber; // 手机号码
    private String phoneNumber; // 电话号码
    private BigDecimal beforeBalance; // (付款|充值)前余额
    private BigDecimal beforeVirtualBalance; // (付款|充值)前本金
    private BigDecimal beforeGiveVirtualBalance; // (付款|充值)前赠金
    private Long beforePoints; // (付款|充值)前积分
    private BigDecimal virtualPayAmount; // 本金消费
    private BigDecimal giveVirtualPayAmount; // 赠金消费
    private BigDecimal cardPayAmount; // 本次消费
    private Long givePoints; // 赠送积分
    private Long growthValue; // 成长值
    private BigDecimal afterVirtualBalance; // (付款|充值)后本金
    private BigDecimal afterGiveVirtualBalance; // (付款|充值)后赠金
    private BigDecimal afterBalance; // (付款|充值)后余额
    private Long afterPoints; // (付款|充值)后积分
    private Long afterGrowthValue; // (付款|充值)后成长值

    public String getMemberCard() {
        return memberCard;
    }

    public void setMemberCard(String memberCard) {
        this.memberCard = memberCard;
    }

    public String getCardLevel() {
        return cardLevel;
    }

    public void setCardLevel(String cardLevel) {
        this.cardLevel = cardLevel;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getBeforeBalance() {
        return beforeBalance;
    }

    public void setBeforeBalance(BigDecimal beforeBalance) {
        this.beforeBalance = beforeBalance;
    }

    public BigDecimal getBeforeVirtualBalance() {
        return beforeVirtualBalance;
    }

    public void setBeforeVirtualBalance(BigDecimal beforeVirtualBalance) {
        this.beforeVirtualBalance = beforeVirtualBalance;
    }

    public BigDecimal getBeforeGiveVirtualBalance() {
        return beforeGiveVirtualBalance;
    }

    public void setBeforeGiveVirtualBalance(BigDecimal beforeGiveVirtualBalance) {
        this.beforeGiveVirtualBalance = beforeGiveVirtualBalance;
    }

    public BigDecimal getVirtualPayAmount() {
        return virtualPayAmount;
    }

    public void setVirtualPayAmount(BigDecimal virtualPayAmount) {
        this.virtualPayAmount = virtualPayAmount;
    }

    public BigDecimal getGiveVirtualPayAmount() {
        return giveVirtualPayAmount;
    }

    public void setGiveVirtualPayAmount(BigDecimal giveVirtualPayAmount) {
        this.giveVirtualPayAmount = giveVirtualPayAmount;
    }

    public BigDecimal getCardPayAmount() {
        return cardPayAmount;
    }

    public void setCardPayAmount(BigDecimal cardPayAmount) {
        this.cardPayAmount = cardPayAmount;
    }

    public Long getGivePoints() {
        return givePoints;
    }

    public void setGivePoints(Long givePoints) {
        this.givePoints = givePoints;
    }

    public Long getGrowthValue() {
        return growthValue;
    }

    public void setGrowthValue(Long growthValue) {
        this.growthValue = growthValue;
    }

    public BigDecimal getAfterVirtualBalance() {
        return afterVirtualBalance;
    }

    public void setAfterVirtualBalance(BigDecimal afterVirtualBalance) {
        this.afterVirtualBalance = afterVirtualBalance;
    }

    public BigDecimal getAfterGiveVirtualBalance() {
        return afterGiveVirtualBalance;
    }

    public void setAfterGiveVirtualBalance(BigDecimal afterGiveVirtualBalance) {
        this.afterGiveVirtualBalance = afterGiveVirtualBalance;
    }

    public BigDecimal getAfterBalance() {
        return afterBalance;
    }

    public void setAfterBalance(BigDecimal afterBalance) {
        this.afterBalance = afterBalance;
    }

    public Long getAfterGrowthValue() {
        return afterGrowthValue;
    }

    public void setAfterGrowthValue(Long afterGrowthValue) {
        this.afterGrowthValue = afterGrowthValue;
    }

    public Long getBeforePoints() {
        return beforePoints;
    }

    public void setBeforePoints(Long beforePoints) {
        this.beforePoints = beforePoints;
    }

    public Long getAfterPoints() {
        return afterPoints;
    }

    public void setAfterPoints(Long afterPoints) {
        this.afterPoints = afterPoints;
    }
}
