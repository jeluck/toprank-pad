package cc.toprank.byd.entity;

import java.math.BigDecimal;

/**********************************************************************************************************************
 * 
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * 继承自自动生成的实体，具体业务方法使用的实体类 如果具体业务需要扩展字段，请扩展该类
 * 
 ********************************************************************************************************************/
public class F_AccountInfoEntity extends F_AccountInfoEntityBase {
  private Long FundID;

  private Long LoginID;

  private Long AccountType;
    public BigDecimal getFundAmount;

    public Long getFundID() {
    return FundID;
  }

  public void setFundID(Long fundID) {
    FundID = fundID;
  }

  public Long getLoginID() {
    return LoginID;
  }

  public void setLoginID(Long loginID) {
    LoginID = loginID;
  }

  public Long getAccountType() {
    return AccountType;
  }

  public void setAccountType(Long accountType) {
    AccountType = accountType;
  }



}
