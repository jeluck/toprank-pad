package cc.toprank.byd.web.vo.member;

import java.util.List;

/**  会员充值VO
 * Created by HuTao on 2017-4-21.
 */
public class MemberDepositVO {
    private Long customerID;     //  客户ID
    private Long cardID;          //  会员ID
    private double deposit;      //   充值金额
    private double present;      //   充值赠送金额
    private int  fraction;       //   充值赠送积分
    private Long depositType;    //    充值方式ID
    private String  depositName;   //   充值方式名称
    private String authCode;      //    线上支付  扫码
    private long countermanID;        //    业务员ID
    private String countermanName;    //    业务员名称
    private Long  ruleID;              //     充值赚送 规则编号
    private Long orgID;
    private Long archiveID;
    private Long operatorID;
    private String memo;
    private String cardCode;
    private Long signInvoice;     //  是否开票标识

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getCardID() {
        return cardID;
    }

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getPresent() {
        return present;
    }

    public void setPresent(double present) {
        this.present = present;
    }

    public int getFraction() {
        return fraction;
    }

    public void setFraction(int fraction) {
        this.fraction = fraction;
    }

    public Long getDepositType() {
        return depositType;
    }

    public void setDepositType(Long depositType) {
        this.depositType = depositType;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public long getCountermanID() {
        return countermanID;
    }

    public void setCountermanID(long countermanID) {
        this.countermanID = countermanID;
    }

    public String getCountermanName() {
        return countermanName;
    }

    public void setCountermanName(String countermanName) {
        this.countermanName = countermanName;
    }

    public Long getRuleID() {
        return ruleID;
    }

    public void setRuleID(Long ruleID) {
        this.ruleID = ruleID;
    }

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public Long getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(Long operatorID) {
        this.operatorID = operatorID;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public Long getSignInvoice() {
        return signInvoice;
    }

    public void setSignInvoice(Long signInvoice) {
        this.signInvoice = signInvoice;
    }
}
