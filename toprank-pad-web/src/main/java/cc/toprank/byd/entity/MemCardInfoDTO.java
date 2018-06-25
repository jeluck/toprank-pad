package cc.toprank.byd.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 会员卡信息
 * Created by HuangCY on 2017-6-8.
 */
public class MemCardInfoDTO {
    //会员名称
    private String memberName;
    //角色等级
    private String roleName;
    //会员卡ID
    private Long cardID;
    //会员卡编号
    private String cardCode;
    //会员卡余额
    private BigDecimal fundAmount;
    //会员积分
    private Integer totalBonus;
    //失效时间
    private LocalDateTime expirationDate;
    //会员卡状态
    private Long cardStatus;
    //客户编号
    private Long customerID;

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getCardID() {
        return cardID;
    }

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public BigDecimal getFundAmount() {
        return fundAmount;
    }

    public void setFundAmount(BigDecimal fundAmount) {
        this.fundAmount = fundAmount;
    }

    public Integer getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(Integer totalBonus) {
        this.totalBonus = totalBonus;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(Long cardStatus) {
        this.cardStatus = cardStatus;
    }
}
