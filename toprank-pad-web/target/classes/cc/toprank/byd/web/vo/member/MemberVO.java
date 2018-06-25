package cc.toprank.byd.web.vo.member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Description：
 * @Author：HuTao
 * @Time: 2017-3-24 9:22
 * @Version 2.0.0
 */
public class MemberVO {
  private String memberName;    // 会员姓名
  private Long gender;           //  性别
  private String mobile;         //  手机号码
  private String email;             //  电子邮箱
  private String birthday;      //   生日
  private String payPassword;       //   密码
  private Long  countermanID;         //   业务员ID
  private String countermanName;      //   业务员名称
  private String memo;          //  备注
  private Long passportType;   //  证件类型
  private String IDCode;        // 证件号码

  private Long customerID;     //  会员ID
  private Long orgID;          //   组织ID
  private Long archiveID;      //   档案ID
  private String archiveName;    //   档案名称

  //    会员卡信息   F_MemberCardInfo
  private long cardID;     // 会员ID
  private String  cardSerialNo;  // 会员卡号   卡序列号= 实物卡号
  private Long cardType;          //  类型   电子卡， 实物卡  未知、磁条卡、芯片卡、磁条芯片复合卡、充值卡、未接触IC卡等
  private String cardCode;;       //  芯片号    芯片号 = 会员卡号

  private String  roleID;        //  会员卡等级   未知、普卡、银卡、金卡、钻石卡等
  private String cardLevelName;  //  等级
  private Long operatorID;
  //  会员展示信息


  public String getMemberName() {
    return memberName;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public Long getGender() {
    return gender;
  }

  public void setGender(Long gender) {
    this.gender = gender;
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

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getPayPassword() {
    return payPassword;
  }

  public void setPayPassword(String payPassword) {
    this.payPassword = payPassword;
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

  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  public Long getPassportType() {
    return passportType;
  }

  public void setPassportType(Long passportType) {
    this.passportType = passportType;
  }

  public String getIDCode() {
    return IDCode;
  }

  public void setIDCode(String IDCode) {
    this.IDCode = IDCode;
  }

  public Long getCustomerID() {
    return customerID;
  }

  public void setCustomerID(Long customerID) {
    this.customerID = customerID;
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

  public String getArchiveName() {
    return archiveName;
  }

  public void setArchiveName(String archiveName) {
    this.archiveName = archiveName;
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

  public Long getCardType() {
    return cardType;
  }

  public void setCardType(Long cardType) {
    this.cardType = cardType;
  }

  public String getCardCode() {
    return cardCode;
  }

  public void setCardCode(String cardCode) {
    this.cardCode = cardCode;
  }

  public String getRoleID() {
    return roleID;
  }

  public void setRoleID(String roleID) {
    this.roleID = roleID;
  }

  public String getCardLevelName() {
    return cardLevelName;
  }

  public void setCardLevelName(String cardLevelName) {
    this.cardLevelName = cardLevelName;
  }

  public Long getOperatorID() {
    return operatorID;
  }

  public void setOperatorID(Long operatorID) {
    this.operatorID = operatorID;
  }
}
