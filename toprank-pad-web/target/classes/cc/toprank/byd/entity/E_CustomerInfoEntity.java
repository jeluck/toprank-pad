package cc.toprank.byd.entity;

import java.time.LocalDateTime;

/**********************************************************************************************************************
 * 
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * 继承自自动生成的实体，具体业务方法使用的实体类 如果具体业务需要扩展字段，请扩展该类
 * 
 ********************************************************************************************************************/
public class E_CustomerInfoEntity extends E_CustomerInfoEntityBase {

  private double longitudeCopy;

  private double latitudeCopy;

  private String idCodeCopy;

  private String provinceName;

  private String cityName;

  private String districtName;

  private String streetName;

  private String countryCode;

  private Long orgID;

  private Long archiveID;
  private String archiveName;    //  餐厅名称

  private Long cardID; // 会员卡ID
  private String cardCode;;       //  芯片号    芯片号 = 会员卡号
  private Long roleID;        // 会员卡等级
  private String roleName;   // 会员卡等级名称
  private String  cardSerialNo;  // 会员卡号   卡序列号= 实物卡号
  private Long cardType;          //  类型   电子卡， 实物卡  未知、磁条卡、芯片卡、磁条芯片复合卡、充值卡、未接触IC卡等
  private Long countermanID;   //  业务员ID
  private  String countermanName;   //  业务员名称

  private double realAmount; // 当前余额

  private int currentBonus; // 当前积分

  private LocalDateTime lastDepositTime;

  private double lastDepositAmount;

  private double lastConsumeAmount;

  private LocalDateTime lastConsumeTime;

  private double tatolAmount;

  private double accountBalance;  //  帐户余额
  private double cumulateConsume;  //  累积消费
  private double cumulateRecharge; //  累计充值

  private Long operatorID; // 操作人ID
  private Long loginID;
  private  String sourceName;  //  客户来源
  private  Long  cardStatus;   //  会员状态


  public double getLongitudeCopy() {
    return longitudeCopy;
  }

  public void setLongitudeCopy(double longitudeCopy) {
    this.longitudeCopy = longitudeCopy;
  }

  public double getLatitudeCopy() {
    return latitudeCopy;
  }

  public void setLatitudeCopy(double latitudeCopy) {
    this.latitudeCopy = latitudeCopy;
  }

  public String getIdCodeCopy() {
    return idCodeCopy;
  }

  public void setIdCodeCopy(String idCodeCopy) {
    this.idCodeCopy = idCodeCopy;
  }

  public String getProvinceName() {
    return provinceName;
  }

  public void setProvinceName(String provinceName) {
    this.provinceName = provinceName;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getDistrictName() {
    return districtName;
  }

  public void setDistrictName(String districtName) {
    this.districtName = districtName;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
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

  public Long getRoleID() {
    return roleID;
  }

  public void setRoleID(Long roleID) {
    this.roleID = roleID;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
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

  public double getRealAmount() {
    return realAmount;
  }

  public void setRealAmount(double realAmount) {
    this.realAmount = realAmount;
  }

  public int getCurrentBonus() {
    return currentBonus;
  }

  public void setCurrentBonus(int currentBonus) {
    this.currentBonus = currentBonus;
  }

  public LocalDateTime getLastDepositTime() {
    return lastDepositTime;
  }

  public void setLastDepositTime(LocalDateTime lastDepositTime) {
    this.lastDepositTime = lastDepositTime;
  }

  public double getLastDepositAmount() {
    return lastDepositAmount;
  }

  public void setLastDepositAmount(double lastDepositAmount) {
    this.lastDepositAmount = lastDepositAmount;
  }

  public double getLastConsumeAmount() {
    return lastConsumeAmount;
  }

  public void setLastConsumeAmount(double lastConsumeAmount) {
    this.lastConsumeAmount = lastConsumeAmount;
  }

  public LocalDateTime getLastConsumeTime() {
    return lastConsumeTime;
  }

  public void setLastConsumeTime(LocalDateTime lastConsumeTime) {
    this.lastConsumeTime = lastConsumeTime;
  }

  public double getTatolAmount() {
    return tatolAmount;
  }

  public void setTatolAmount(double tatolAmount) {
    this.tatolAmount = tatolAmount;
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

  public Long getOperatorID() {
    return operatorID;
  }

  public void setOperatorID(Long operatorID) {
    this.operatorID = operatorID;
  }

  public Long getLoginID() {
    return loginID;
  }

  public void setLoginID(Long loginID) {
    this.loginID = loginID;
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
