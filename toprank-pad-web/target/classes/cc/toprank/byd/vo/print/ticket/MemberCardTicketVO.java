package cc.toprank.byd.vo.print.ticket;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.vo.print.MemberCardInfoVO;

import java.math.BigDecimal;

/**
 * @author LinYN
 * @date 2017-6-6
 */
public class MemberCardTicketVO extends PrinterTicketVO {

    private MemberCardInfoVO memberCardInfo = new MemberCardInfoVO(); // 会员付款情况（ 有会员付款才显示）

    public void setMemberCardInfo(MemberCardInfoVO memberCardInfo) {
        this.memberCardInfo = memberCardInfo;
    }

    public String getMemberCard() {
        return memberCardInfo.getMemberCard();
    }

    public void setMemberCard(String memberCard) {
        memberCardInfo.setMemberCard(memberCard);
    }

    public String getCardLevel() {
        return memberCardInfo.getCardLevel();
    }

    public void setCardLevel(String cardLevel) {
        memberCardInfo.setCardLevel(cardLevel);
    }

    public String getMemberCode() {
        return memberCardInfo.getMemberCode();
    }

    public void setMemberCode(String memberCode) {
        memberCardInfo.setMemberCode(memberCode);
    }

    public String getMemberName() {
        return memberCardInfo.getMemberName();
    }

    public void setMemberName(String memberName) {
        memberCardInfo.setMemberName(memberName);
    }

    public String getMobileNumber() {
        return memberCardInfo.getMobileNumber();
    }

    public void setMobileNumber(String mobileNumber) {
        memberCardInfo.setMobileNumber(mobileNumber);
    }

    public String getPhoneNumber() {
        return memberCardInfo.getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber) {
        memberCardInfo.setPhoneNumber(phoneNumber);
    }

    public BigDecimal getBeforeBalance() {
        return memberCardInfo.getBeforeBalance();
    }

    public void setBeforeBalance(BigDecimal beforeBalance) {
        memberCardInfo.setBeforeBalance(beforeBalance);
    }

    public BigDecimal getBeforeVirtualBalance() {
        return memberCardInfo.getBeforeVirtualBalance();
    }

    public void setBeforeVirtualBalance(BigDecimal beforeVirtualBalance) {
        memberCardInfo.setBeforeVirtualBalance(beforeVirtualBalance);
    }

    public BigDecimal getBeforeGiveVirtualBalance() {
        return memberCardInfo.getBeforeGiveVirtualBalance();
    }

    public void setBeforeGiveVirtualBalance(BigDecimal beforeGiveVirtualBalance) {
        memberCardInfo.setBeforeGiveVirtualBalance(beforeGiveVirtualBalance);
    }

    public BigDecimal getVirtualPayAmount() {
        return memberCardInfo.getVirtualPayAmount();
    }

    public void setVirtualPayAmount(BigDecimal virtualPayAmount) {
        memberCardInfo.setVirtualPayAmount(virtualPayAmount);
    }

    public BigDecimal getGiveVirtualPayAmount() {
        return memberCardInfo.getGiveVirtualPayAmount();
    }

    public void setGiveVirtualPayAmount(BigDecimal giveVirtualPayAmount) {
        memberCardInfo.setGiveVirtualPayAmount(giveVirtualPayAmount);
    }

    public BigDecimal getCardPayAmount() {
        return memberCardInfo.getCardPayAmount();
    }

    public void setCardPayAmount(BigDecimal cardPayAmount) {
        memberCardInfo.setCardPayAmount(cardPayAmount);
    }

    public Long getGivePoints() {
        return memberCardInfo.getGivePoints();
    }

    public void setGivePoints(Long givePoints) {
        memberCardInfo.setGivePoints(givePoints);
    }

    public Long getGrowthValue() {
        return memberCardInfo.getGrowthValue();
    }

    public void setGrowthValue(Long growthValue) {
        memberCardInfo.setGrowthValue(growthValue);
    }

    public BigDecimal getAfterVirtualBalance() {
        return memberCardInfo.getAfterVirtualBalance();
    }

    public void setAfterVirtualBalance(BigDecimal afterVirtualBalance) {
        memberCardInfo.setAfterVirtualBalance(afterVirtualBalance);
    }

    public BigDecimal getAfterGiveVirtualBalance() {
        return memberCardInfo.getAfterGiveVirtualBalance();
    }

    public void setAfterGiveVirtualBalance(BigDecimal afterGiveVirtualBalance) {
        memberCardInfo.setAfterGiveVirtualBalance(afterGiveVirtualBalance);
    }

    public BigDecimal getAfterBalance() {
        return memberCardInfo.getAfterBalance();
    }

    public void setAfterBalance(BigDecimal afterBalance) {
        memberCardInfo.setAfterBalance(afterBalance);
    }

    public Long getAfterGrowthValue() {
        return memberCardInfo.getAfterGrowthValue();
    }

    public void setAfterGrowthValue(Long afterGrowthValue) {
        memberCardInfo.setAfterGrowthValue(afterGrowthValue);
    }

    public Long getBeforePoints() {
        return memberCardInfo.getBeforePoints();
    }

    public void setBeforePoints(Long beforePoints) {
        memberCardInfo.setBeforePoints(beforePoints);
    }

    public Long getAfterPoints() {
        return memberCardInfo.getAfterPoints();
    }

    public void setAfterPoints(Long afterPoints) {
        memberCardInfo.setAfterPoints(afterPoints);
    }
}
