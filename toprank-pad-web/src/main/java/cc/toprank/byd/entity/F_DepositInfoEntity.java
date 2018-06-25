package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * 继承自自动生成的实体，具体业务方法使用的实体类 如果具体业务需要扩展字段，请扩展该类
 * 
 ********************************************************************************************************************/
public class F_DepositInfoEntity extends F_DepositInfoEntityBase {

  private String depositTypeName;

  private String payCode;

  private Long orgID;

  private double present;
  private double deposit;

  public double getPresent() {
    return present;
  }

  public void setPresent(double present) {
    this.present = present;
  }

  public double getDeposit() {
    return deposit;
  }

  public void setDeposit(double deposit) {
    this.deposit = deposit;
  }

  public String getPayCode() {
    return payCode;
  }

  public void setPayCode(String payCode) {
    this.payCode = payCode;
  }

  public Long getOrgID() {
    return orgID;
  }

  public void setOrgID(Long orgID) {
    this.orgID = orgID;
  }

  public String getDepositTypeName() {
    return depositTypeName;
  }

  public void setDepositTypeName(String depositTypeName) {
    this.depositTypeName = depositTypeName;
  }



}
