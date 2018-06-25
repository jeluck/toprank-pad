package cc.toprank.byd.web.vo.member;

import java.time.LocalDate;

/**
 * Created by HuTao on 2017-4-12.
 */
public class CardMemberVO {
    private Long customerID;         //  会员ID
    private String memberName;       // 会员姓名
    private LocalDate birthday;      //   生日日期
    private String mobile;            //  手机号码
    private String email;             //  电子邮箱
    private double cumulateConsume;      //  累积消费
    private double cumulateRecharge;     //  累计充值
    private LocalDate createDate;          //  注册时间
    private  int  consumeCount;          //   消费次数
    private  String  sourceName;              //   客户来源
    private  int bookingCount;             //   预定次数

    private long cardID;              // 会员ID
    private String cardSerialNo;      // 会员卡序列号
    private double accountBalance;                  // 帐户余额
    private LocalDate cardCreateTime;            //   发卡日期
    private LocalDate validDate ;                 //   有效日期
    private String archiveName;                             //   发卡门店
    private int cardCurrentBonus;                          //   积分余额
    private String  cardLevelName;                          //   等级
    private Long    cardStatus;                            //    状态ID
    private String cardStatusName ;                        //   状态
    private Long  countermanID;                            //   业务员ID
    private String countermanName;                         //   业务员名称

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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getConsumeCount() {
        return consumeCount;
    }

    public void setConsumeCount(int consumeCount) {
        this.consumeCount = consumeCount;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public int getBookingCount() {
        return bookingCount;
    }

    public void setBookingCount(int bookingCount) {
        this.bookingCount = bookingCount;
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

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public LocalDate getCardCreateTime() {
        return cardCreateTime;
    }

    public void setCardCreateTime(LocalDate cardCreateTime) {
        this.cardCreateTime = cardCreateTime;
    }

    public LocalDate getValidDate() {
        return validDate;
    }

    public void setValidDate(LocalDate validDate) {
        this.validDate = validDate;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public int getCardCurrentBonus() {
        return cardCurrentBonus;
    }

    public void setCardCurrentBonus(int cardCurrentBonus) {
        this.cardCurrentBonus = cardCurrentBonus;
    }

    public String getCardLevelName() {
        return cardLevelName;
    }

    public void setCardLevelName(String cardLevelName) {
        this.cardLevelName = cardLevelName;
    }

    public Long getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(Long cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getCardStatusName() {
        return cardStatusName;
    }

    public void setCardStatusName(String cardStatusName) {
        this.cardStatusName = cardStatusName;
    }

    public Long getCountermanID() {
        return countermanID;
    }

    public void setCountermanID(Long countermanID) {
        this.countermanID = countermanID;
    }

    public String getCountermanName() {
        return countermanName;
    }

    public void setCountermanName(String countermanName) {
        this.countermanName = countermanName;
    }
}
