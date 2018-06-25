package cc.toprank.byd.web.vo.member;
import java.time.LocalDate;


/**
 * Created by HuTao on 2017-3-30.
 */
public class MemberInfoVO {
    private Long customerID;      //  会员ID
    private String memberName;    //  会员姓名
    private long cardID;          //  会员ID
    private String cardSerialNo;  //  会员序列号
    private String cardCode;      //  会员卡号
    private String mobile;        //  手机号码
    private String cardLevelName;      //   等级
    private double accountBalance;        //  帐户余额

    private double cumulateConsume;      //   累积消费
    private double cumulateRecharge;     //   累计充值
    private LocalDate createDate;         //    注册时间
    private String sourceName;            //    客户来源
    private Long cardStatus;              //    会员卡状态

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

    public long getCardID() {
        return cardID;
    }

    public void setCardID(long cardID) {
        this.cardID = cardID;
    }

    public String getCardSerialNo() {
        return cardSerialNo;
    }

    public void setCardSerialNo(String cardSerialNo) {
        this.cardSerialNo = cardSerialNo;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCardLevelName() {
        return cardLevelName;
    }

    public void setCardLevelName(String cardLevelName) {
        this.cardLevelName = cardLevelName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getCumulateConsume() {
        return cumulateConsume;
    }

    public void setCumulateConsume(double cumulateConsume) {
        this.cumulateConsume = cumulateConsume;
    }

    public double getCumulateRecharge() {
        return cumulateRecharge;
    }

    public void setCumulateRecharge(double cumulateRecharge) {
        this.cumulateRecharge = cumulateRecharge;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Long getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(Long cardStatus) {
        this.cardStatus = cardStatus;
    }
}