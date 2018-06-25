package cc.toprank.byd.entity;

import java.time.LocalDateTime;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在F_DepositInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class F_DepositInfoEntityBase extends Entity {

  /**
   *	AccountID数据库列名
   */
  public final static java.lang.String ACCOUNTID_FIELD =  "AccountID";

  /**
   *	AccountID字段中文名，用于视图展示
   */
  public final static java.lang.String ACCOUNTID_LABLE = "帐户编号";

  /**
   *	AccountID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long accountID;

  /**
   *	AccountType数据库列名
   */
  public final static java.lang.String ACCOUNTTYPE_FIELD =  "AccountType";

  /**
   *	AccountType字段中文名，用于视图展示
   */
  public final static java.lang.String ACCOUNTTYPE_LABLE = "帐户类别";

  /**
   *	AccountType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long accountType;

  /**
   *	ArchiveID数据库列名
   */
  public final static java.lang.String ARCHIVEID_FIELD =  "ArchiveID";

  /**
   *	ArchiveID字段中文名，用于视图展示
   */
  public final static java.lang.String ARCHIVEID_LABLE = "档案编号";

  /**
   *	ArchiveID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long archiveID;

  /**
   *	CardCode数据库列名
   */
  public final static java.lang.String CARDCODE_FIELD =  "CardCode";

  /**
   *	CardCode字段中文名，用于视图展示
   */
  public final static java.lang.String CARDCODE_LABLE = "会员卡号";

  /**
   *	CardCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String cardCode;

  /**
   *	CardID数据库列名
   */
  public final static java.lang.String CARDID_FIELD =  "CardID";

  /**
   *	CardID字段中文名，用于视图展示
   */
  public final static java.lang.String CARDID_LABLE = "卡编号";

  /**
   *	CardID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long cardID;

  /**
   *	Charge数据库列名
   */
  public final static java.lang.String CHARGE_FIELD =  "Charge";

  /**
   *	Charge字段中文名，用于视图展示
   */
  public final static java.lang.String CHARGE_LABLE = "名义手续费";

  /**
   *	Charge对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float charge;

  /**
   *	CreateTime数据库列名
   */
  public final static java.lang.String CREATETIME_FIELD =  "CreateTime";

  /**
   *	CreateTime字段中文名，用于视图展示
   */
  public final static java.lang.String CREATETIME_LABLE = "创建时间";

  /**
   *	CreateTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime createTime;

  /**
   *	CurrencyID数据库列名
   */
  public final static java.lang.String CURRENCYID_FIELD =  "CurrencyID";

  /**
   *	CurrencyID字段中文名，用于视图展示
   */
  public final static java.lang.String CURRENCYID_LABLE = "货币编号";

  /**
   *	CurrencyID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long currencyID;

  /**
   *	CustomerID数据库列名
   */
  public final static java.lang.String CUSTOMERID_FIELD =  "CustomerID";

  /**
   *	CustomerID字段中文名，用于视图展示
   */
  public final static java.lang.String CUSTOMERID_LABLE = "客户编号";

  /**
   *	CustomerID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long customerID;

  /**
   *	DepositCode数据库列名
   */
  public final static java.lang.String DEPOSITCODE_FIELD =  "DepositCode";

  /**
   *	DepositCode字段中文名，用于视图展示
   */
  public final static java.lang.String DEPOSITCODE_LABLE = "充值编码";

  /**
   *	DepositCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String depositCode;

  /**
   *	DepositDesc数据库列名
   */
  public final static java.lang.String DEPOSITDESC_FIELD =  "DepositDesc";

  /**
   *	DepositDesc字段中文名，用于视图展示
   */
  public final static java.lang.String DEPOSITDESC_LABLE = "充值描述";

  /**
   *	DepositDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String depositDesc;

  /**
   *	DepositID数据库列名
   */
  public final static java.lang.String DEPOSITID_FIELD =  "DepositID";

  /**
   *	DepositID字段中文名，用于视图展示
   */
  public final static java.lang.String DEPOSITID_LABLE = "充值编号";

  /**
   *	DepositID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long depositID;

  /**
   *	DepositMoney数据库列名
   */
  public final static java.lang.String DEPOSITMONEY_FIELD =  "DepositMoney";

  /**
   *	DepositMoney字段中文名，用于视图展示
   */
  public final static java.lang.String DEPOSITMONEY_LABLE = "充值金额";

  /**
   *	DepositMoney对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal depositMoney;

  /**
   *	DepositStatus数据库列名
   */
  public final static java.lang.String DEPOSITSTATUS_FIELD =  "DepositStatus";

  /**
   *	DepositStatus字段中文名，用于视图展示
   */
  public final static java.lang.String DEPOSITSTATUS_LABLE = "充值状态";

  /**
   *	DepositStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long depositStatus;

  /**
   *	DepositType数据库列名
   */
  public final static java.lang.String DEPOSITTYPE_FIELD =  "DepositType";

  /**
   *	DepositType字段中文名，用于视图展示
   */
  public final static java.lang.String DEPOSITTYPE_LABLE = "充值方式";

  /**
   *	DepositType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long depositType;

  /**
   *	FundID数据库列名
   */
  public final static java.lang.String FUNDID_FIELD =  "FundID";

  /**
   *	FundID字段中文名，用于视图展示
   */
  public final static java.lang.String FUNDID_LABLE = "资金编号";

  /**
   *	FundID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long fundID;

  /**
   *	IsQuickPay数据库列名
   */
  public final static java.lang.String ISQUICKPAY_FIELD =  "IsQuickPay";

  /**
   *	IsQuickPay字段中文名，用于视图展示
   */
  public final static java.lang.String ISQUICKPAY_LABLE = "是否快捷";

  /**
   *	IsQuickPay对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isQuickPay;

  /**
   *	IsSync数据库列名
   */
  public final static java.lang.String ISSYNC_FIELD =  "IsSync";

  /**
   *	IsSync字段中文名，用于视图展示
   */
  public final static java.lang.String ISSYNC_LABLE = "是否同步";

  /**
   *	IsSync对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isSync;

  /**
   *	LoginID数据库列名
   */
  public final static java.lang.String LOGINID_FIELD =  "LoginID";

  /**
   *	LoginID字段中文名，用于视图展示
   */
  public final static java.lang.String LOGINID_LABLE = "登录编号";

  /**
   *	LoginID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long loginID;

  /**
   *	Memo数据库列名
   */
  public final static java.lang.String MEMO_FIELD =  "Memo";

  /**
   *	Memo字段中文名，用于视图展示
   */
  public final static java.lang.String MEMO_LABLE = "备注";

  /**
   *	Memo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String memo;

  /**
   *	OperatorID数据库列名
   */
  public final static java.lang.String OPERATORID_FIELD =  "OperatorID";

  /**
   *	OperatorID字段中文名，用于视图展示
   */
  public final static java.lang.String OPERATORID_LABLE = "充值处理人员";

  /**
   *	OperatorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long operatorID;

  /**
   *	PayOrgID数据库列名
   */
  public final static java.lang.String PAYORGID_FIELD =  "PayOrgID";

  /**
   *	PayOrgID字段中文名，用于视图展示
   */
  public final static java.lang.String PAYORGID_LABLE = "支付机构编号";

  /**
   *	PayOrgID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long payOrgID;

  /**
   *	PayOrgSeqNo数据库列名
   */
  public final static java.lang.String PAYORGSEQNO_FIELD =  "PayOrgSeqNo";

  /**
   *	PayOrgSeqNo字段中文名，用于视图展示
   */
  public final static java.lang.String PAYORGSEQNO_LABLE = "支付机构订单号";

  /**
   *	PayOrgSeqNo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String payOrgSeqNo;

  /**
   *	PresentBonus数据库列名
   */
  public final static java.lang.String PRESENTBONUS_FIELD =  "PresentBonus";

  /**
   *	PresentBonus字段中文名，用于视图展示
   */
  public final static java.lang.String PRESENTBONUS_LABLE = "赠送积分";

  /**
   *	PresentBonus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer presentBonus;

  /**
   *	PresentMoney数据库列名
   */
  public final static java.lang.String PRESENTMONEY_FIELD =  "PresentMoney";

  /**
   *	PresentMoney字段中文名，用于视图展示
   */
  public final static java.lang.String PRESENTMONEY_LABLE = "赠送金额";

  /**
   *	PresentMoney对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal presentMoney;

  /**
   *	RealAmount数据库列名
   */
  public final static java.lang.String REALAMOUNT_FIELD =  "RealAmount";

  /**
   *	RealAmount字段中文名，用于视图展示
   */
  public final static java.lang.String REALAMOUNT_LABLE = "实际金额";

  /**
   *	RealAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal realAmount;

  /**
   *	RealName数据库列名
   */
  public final static java.lang.String REALNAME_FIELD =  "RealName";

  /**
   *	RealName字段中文名，用于视图展示
   */
  public final static java.lang.String REALNAME_LABLE = "真实姓名";

  /**
   *	RealName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String realName;

  /**
   *	RuleID数据库列名
   */
  public final static java.lang.String RULEID_FIELD =  "RuleID";

  /**
   *	RuleID字段中文名，用于视图展示
   */
  public final static java.lang.String RULEID_LABLE = "规则编号";

  /**
   *	RuleID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long ruleID;

  /**
   *	SettingID数据库列名
   */
  public final static java.lang.String SETTINGID_FIELD =  "SettingID";

  /**
   *	SettingID字段中文名，用于视图展示
   */
  public final static java.lang.String SETTINGID_LABLE = "取款卡编号";

  /**
   *	SettingID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long settingID;

  /**
   *	SubmitTime数据库列名
   */
  public final static java.lang.String SUBMITTIME_FIELD =  "SubmitTime";

  /**
   *	SubmitTime字段中文名，用于视图展示
   */
  public final static java.lang.String SUBMITTIME_LABLE = "提交时间";

  /**
   *	SubmitTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime submitTime;

  /**
   *	SupplyTime数据库列名
   */
  public final static java.lang.String SUPPLYTIME_FIELD =  "SupplyTime";

  /**
   *	SupplyTime字段中文名，用于视图展示
   */
  public final static java.lang.String SUPPLYTIME_LABLE = "实际充值时间";

  /**
   *	SupplyTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime supplyTime;

  /**
   *	ValidationCode数据库列名
   */
  public final static java.lang.String VALIDATIONCODE_FIELD =  "ValidationCode";

  /**
   *	ValidationCode字段中文名，用于视图展示
   */
  public final static java.lang.String VALIDATIONCODE_LABLE = "验证信息";

  /**
   *	ValidationCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String validationCode;

  /**
   * 帐户编号 getter
   */
  public java.lang.Long getAccountID(){
    return accountID;
  }
  /**
   * 帐户编号 setter
   * @param AccountID
   */
  public void setAccountID(java.lang.Long accountID){
    this.accountID = accountID;
  }

  /**
   * 帐户类别 getter
   */
  public java.lang.Long getAccountType(){
    return accountType;
  }
  /**
   * 帐户类别 setter
   * @param AccountType
   */
  public void setAccountType(java.lang.Long accountType){
    this.accountType = accountType;
  }

  /**
   * 档案编号 getter
   */
  public java.lang.Long getArchiveID(){
    return archiveID;
  }
  /**
   * 档案编号 setter
   * @param ArchiveID
   */
  public void setArchiveID(java.lang.Long archiveID){
    this.archiveID = archiveID;
  }

  /**
   * 会员卡号 getter
   */
  public java.lang.String getCardCode(){
    return cardCode;
  }
  /**
   * 会员卡号 setter
   * @param CardCode
   */
  public void setCardCode(java.lang.String cardCode){
    this.cardCode = cardCode;
  }

  /**
   * 卡编号 getter
   */
  public java.lang.Long getCardID(){
    return cardID;
  }
  /**
   * 卡编号 setter
   * @param CardID
   */
  public void setCardID(java.lang.Long cardID){
    this.cardID = cardID;
  }

  /**
   * 名义手续费 getter
   */
  public java.lang.Float getCharge(){
    return charge;
  }
  /**
   * 名义手续费 setter
   * @param Charge
   */
  public void setCharge(java.lang.Float charge){
    this.charge = charge;
  }

  /**
   * 创建时间 getter
   */
  public java.time.LocalDateTime getCreateTime(){
    return createTime;
  }
  /**
   * 创建时间 setter
   * @param CreateTime
   */
  public void setCreateTime(java.time.LocalDateTime createTime){
    this.createTime = createTime;
  }

  /**
   * 货币编号 getter
   */
  public java.lang.Long getCurrencyID(){
    return currencyID;
  }
  /**
   * 货币编号 setter
   * @param CurrencyID
   */
  public void setCurrencyID(java.lang.Long currencyID){
    this.currencyID = currencyID;
  }

  /**
   * 客户编号 getter
   */
  public java.lang.Long getCustomerID(){
    return customerID;
  }
  /**
   * 客户编号 setter
   * @param CustomerID
   */
  public void setCustomerID(java.lang.Long customerID){
    this.customerID = customerID;
  }

  /**
   * 充值编码 getter
   */
  public java.lang.String getDepositCode(){
    return depositCode;
  }
  /**
   * 充值编码 setter
   * @param DepositCode
   */
  public void setDepositCode(java.lang.String depositCode){
    this.depositCode = depositCode;
  }

  /**
   * 充值描述 getter
   */
  public java.lang.String getDepositDesc(){
    return depositDesc;
  }
  /**
   * 充值描述 setter
   * @param DepositDesc
   */
  public void setDepositDesc(java.lang.String depositDesc){
    this.depositDesc = depositDesc;
  }

  /**
   * 充值编号 getter
   */
  public java.lang.Long getDepositID(){
    return depositID;
  }
  /**
   * 充值编号 setter
   * @param DepositID
   */
  public void setDepositID(java.lang.Long depositID){
    this.depositID = depositID;
  }

  /**
   * 充值金额 getter
   */
  public java.math.BigDecimal getDepositMoney(){
    return depositMoney;
  }
  /**
   * 充值金额 setter
   * @param DepositMoney
   */
  public void setDepositMoney(java.math.BigDecimal depositMoney){
    this.depositMoney = depositMoney;
  }

  /**
   * 充值状态 getter
   */
  public java.lang.Long getDepositStatus(){
    return depositStatus;
  }
  /**
   * 充值状态 setter
   * @param DepositStatus
   */
  public void setDepositStatus(java.lang.Long depositStatus){
    this.depositStatus = depositStatus;
  }

  /**
   * 充值方式 getter
   */
  public java.lang.Long getDepositType(){
    return depositType;
  }
  /**
   * 充值方式 setter
   * @param DepositType
   */
  public void setDepositType(java.lang.Long depositType){
    this.depositType = depositType;
  }

  /**
   * 资金编号 getter
   */
  public java.lang.Long getFundID(){
    return fundID;
  }
  /**
   * 资金编号 setter
   * @param FundID
   */
  public void setFundID(java.lang.Long fundID){
    this.fundID = fundID;
  }

  /**
   * 是否快捷 getter
   */
  public java.lang.Boolean getIsQuickPay(){
    return isQuickPay;
  }
  /**
   * 是否快捷 setter
   * @param IsQuickPay
   */
  public void setIsQuickPay(java.lang.Boolean isQuickPay){
    this.isQuickPay = isQuickPay;
  }

  /**
   * 是否同步 getter
   */
  public java.lang.Boolean getIsSync(){
    return isSync;
  }
  /**
   * 是否同步 setter
   * @param IsSync
   */
  public void setIsSync(java.lang.Boolean isSync){
    this.isSync = isSync;
  }

  /**
   * 登录编号 getter
   */
  public java.lang.Long getLoginID(){
    return loginID;
  }
  /**
   * 登录编号 setter
   * @param LoginID
   */
  public void setLoginID(java.lang.Long loginID){
    this.loginID = loginID;
  }

  /**
   * 备注 getter
   */
  public java.lang.String getMemo(){
    return memo;
  }
  /**
   * 备注 setter
   * @param Memo
   */
  public void setMemo(java.lang.String memo){
    this.memo = memo;
  }

  /**
   * 充值处理人员 getter
   */
  public java.lang.Long getOperatorID(){
    return operatorID;
  }
  /**
   * 充值处理人员 setter
   * @param OperatorID
   */
  public void setOperatorID(java.lang.Long operatorID){
    this.operatorID = operatorID;
  }

  /**
   * 支付机构编号 getter
   */
  public java.lang.Long getPayOrgID(){
    return payOrgID;
  }
  /**
   * 支付机构编号 setter
   * @param PayOrgID
   */
  public void setPayOrgID(java.lang.Long payOrgID){
    this.payOrgID = payOrgID;
  }

  /**
   * 支付机构订单号 getter
   */
  public java.lang.String getPayOrgSeqNo(){
    return payOrgSeqNo;
  }
  /**
   * 支付机构订单号 setter
   * @param PayOrgSeqNo
   */
  public void setPayOrgSeqNo(java.lang.String payOrgSeqNo){
    this.payOrgSeqNo = payOrgSeqNo;
  }

  /**
   * 赠送积分 getter
   */
  public java.lang.Integer getPresentBonus(){
    return presentBonus;
  }
  /**
   * 赠送积分 setter
   * @param PresentBonus
   */
  public void setPresentBonus(java.lang.Integer presentBonus){
    this.presentBonus = presentBonus;
  }

  /**
   * 赠送金额 getter
   */
  public java.math.BigDecimal getPresentMoney(){
    return presentMoney;
  }
  /**
   * 赠送金额 setter
   * @param PresentMoney
   */
  public void setPresentMoney(java.math.BigDecimal presentMoney){
    this.presentMoney = presentMoney;
  }

  /**
   * 实际金额 getter
   */
  public java.math.BigDecimal getRealAmount(){
    return realAmount;
  }
  /**
   * 实际金额 setter
   * @param RealAmount
   */
  public void setRealAmount(java.math.BigDecimal realAmount){
    this.realAmount = realAmount;
  }

  /**
   * 真实姓名 getter
   */
  public java.lang.String getRealName(){
    return realName;
  }
  /**
   * 真实姓名 setter
   * @param RealName
   */
  public void setRealName(java.lang.String realName){
    this.realName = realName;
  }

  /**
   * 规则编号 getter
   */
  public java.lang.Long getRuleID(){
    return ruleID;
  }
  /**
   * 规则编号 setter
   * @param RuleID
   */
  public void setRuleID(java.lang.Long ruleID){
    this.ruleID = ruleID;
  }

  /**
   * 取款卡编号 getter
   */
  public java.lang.Long getSettingID(){
    return settingID;
  }
  /**
   * 取款卡编号 setter
   * @param SettingID
   */
  public void setSettingID(java.lang.Long settingID){
    this.settingID = settingID;
  }

  /**
   * 提交时间 getter
   */
  public java.time.LocalDateTime getSubmitTime(){
    return submitTime;
  }
  /**
   * 提交时间 setter
   * @param SubmitTime
   */
  public void setSubmitTime(java.time.LocalDateTime submitTime){
    this.submitTime = submitTime;
  }

  /**
   * 实际充值时间 getter
   */
  public java.time.LocalDateTime getSupplyTime(){
    return supplyTime;
  }
  /**
   * 实际充值时间 setter
   * @param SupplyTime
   */
  public void setSupplyTime(java.time.LocalDateTime supplyTime){
    this.supplyTime = supplyTime;
  }

  /**
   * 验证信息 getter
   */
  public java.lang.String getValidationCode(){
    return validationCode;
  }
  /**
   * 验证信息 setter
   * @param ValidationCode
   */
  public void setValidationCode(java.lang.String validationCode){
    this.validationCode = validationCode;
  }

}