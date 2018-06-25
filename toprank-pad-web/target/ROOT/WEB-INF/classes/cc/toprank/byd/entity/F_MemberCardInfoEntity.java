package cc.toprank.byd.entity;

import java.time.LocalDate;

/**********************************************************************************************************************
 * 
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * 继承自自动生成的实体，具体业务方法使用的实体类 如果具体业务需要扩展字段，请扩展该类
 * 
 ********************************************************************************************************************/
public class F_MemberCardInfoEntity extends F_MemberCardInfoEntityBase {
  private Long customerID;         //  会员ID
  private LocalDate birthday;      //   生日日期
  private String mobile;            //  手机号码
  private String sourceName;               //   客户来源
  private double accountBalance;          //   帐户余额
  private String archiveName;              //   发卡门店
  private int cardCurrentBonus;           //   积分余额
  private String  cardLevelName;           //   等级
  private String cardStatusName ;          //   状态
  private String email;                     //   电子邮件
  private Long  countermanID;         //   业务员ID
  private String countermanName;      //   业务员名称
  private String realName;

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
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

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
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

    public String getCardStatusName() {
        return cardStatusName;
    }

    public void setCardStatusName(String cardStatusName) {
        this.cardStatusName = cardStatusName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
