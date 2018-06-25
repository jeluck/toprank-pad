package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在F_AccountInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class F_AccountInfoEntityBase extends Entity {

  /**
   *	AccountCode数据库列名
   */
  public final static java.lang.String ACCOUNTCODE_FIELD =  "AccountCode";
  
  /**
   *	AccountCode字段中文名，用于视图展示
   */
  public final static java.lang.String ACCOUNTCODE_LABLE = "编码";
  
  /**
   *	AccountCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String accountCode;
  
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
   *	BorrowFundAmount数据库列名
   */
  public final static java.lang.String BORROWFUNDAMOUNT_FIELD =  "BorrowFundAmount";
  
  /**
   *	BorrowFundAmount字段中文名，用于视图展示
   */
  public final static java.lang.String BORROWFUNDAMOUNT_LABLE = "基金借款";
  
  /**
   *	BorrowFundAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal borrowFundAmount;
  
  /**
   *	CanCashAmount数据库列名
   */
  public final static java.lang.String CANCASHAMOUNT_FIELD =  "CanCashAmount";
  
  /**
   *	CanCashAmount字段中文名，用于视图展示
   */
  public final static java.lang.String CANCASHAMOUNT_LABLE = "可提现金额";
  
  /**
   *	CanCashAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal canCashAmount;
  
  /**
   *	CanDrawal数据库列名
   */
  public final static java.lang.String CANDRAWAL_FIELD =  "CanDrawal";
  
  /**
   *	CanDrawal字段中文名，用于视图展示
   */
  public final static java.lang.String CANDRAWAL_LABLE = "是否开通取款";
  
  /**
   *	CanDrawal对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean canDrawal;
  
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
   *	CustomerType数据库列名
   */
  public final static java.lang.String CUSTOMERTYPE_FIELD =  "CustomerType";
  
  /**
   *	CustomerType字段中文名，用于视图展示
   */
  public final static java.lang.String CUSTOMERTYPE_LABLE = "客户类别";
  
  /**
   *	CustomerType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long customerType;
  
  /**
   *	DepositBalance数据库列名
   */
  public final static java.lang.String DEPOSITBALANCE_FIELD =  "DepositBalance";
  
  /**
   *	DepositBalance字段中文名，用于视图展示
   */
  public final static java.lang.String DEPOSITBALANCE_LABLE = "押金余额";
  
  /**
   *	DepositBalance对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal depositBalance;
  
  /**
   *	DueAmount数据库列名
   */
  public final static java.lang.String DUEAMOUNT_FIELD =  "DueAmount";
  
  /**
   *	DueAmount字段中文名，用于视图展示
   */
  public final static java.lang.String DUEAMOUNT_LABLE = "待付金额";
  
  /**
   *	DueAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal dueAmount;
  
  /**
   *	FrozenAmont数据库列名
   */
  public final static java.lang.String FROZENAMONT_FIELD =  "FrozenAmont";
  
  /**
   *	FrozenAmont字段中文名，用于视图展示
   */
  public final static java.lang.String FROZENAMONT_LABLE = "冻结金额";
  
  /**
   *	FrozenAmont对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal frozenAmount;
  
  /**
   *	FundAmount数据库列名
   */
  public final static java.lang.String FUNDAMOUNT_FIELD =  "FundAmount";
  
  /**
   *	FundAmount字段中文名，用于视图展示
   */
  public final static java.lang.String FUNDAMOUNT_LABLE = "资金金额";
  
  /**
   *	FundAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal fundAmount;
  
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
   *	LatestChangeAmount数据库列名
   */
  public final static java.lang.String LATESTCHANGEAMOUNT_FIELD =  "LatestChangeAmount";
  
  /**
   *	LatestChangeAmount字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTCHANGEAMOUNT_LABLE = "最后变动数额";
  
  /**
   *	LatestChangeAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal latestChangeAmount;
  
  /**
   *	LatestChangeMode数据库列名
   */
  public final static java.lang.String LATESTCHANGEMODE_FIELD =  "LatestChangeMode";
  
  /**
   *	LatestChangeMode字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTCHANGEMODE_LABLE = "最后变动类型";
  
  /**
   *	LatestChangeMode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long latestChangeMode;
  
  /**
   *	LatestChangeTime数据库列名
   */
  public final static java.lang.String LATESTCHANGETIME_FIELD =  "LatestChangeTime";
  
  /**
   *	LatestChangeTime字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTCHANGETIME_LABLE = "最后变动时间";
  
  /**
   *	LatestChangeTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime latestChangeTime;
  
  /**
   *	LatestChangeType数据库列名
   */
  public final static java.lang.String LATESTCHANGETYPE_FIELD =  "LatestChangeType";
  
  /**
   *	LatestChangeType字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTCHANGETYPE_LABLE = "最后变动类别";
  
  /**
   *	LatestChangeType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long latestChangeType;
  
  /**
   *	LatestOperatorID数据库列名
   */
  public final static java.lang.String LATESTOPERATORID_FIELD =  "LatestOperatorID";
  
  /**
   *	LatestOperatorID字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTOPERATORID_LABLE = "最后变动操作人";
  
  /**
   *	LatestOperatorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long latestOperatorID;
  
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
   *	PrepaymentBalance数据库列名
   */
  public final static java.lang.String PREPAYMENTBALANCE_FIELD =  "PrepaymentBalance";
  
  /**
   *	PrepaymentBalance字段中文名，用于视图展示
   */
  public final static java.lang.String PREPAYMENTBALANCE_LABLE = "预付余额";
  
  /**
   *	PrepaymentBalance对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal prepaymentBalance;
  
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
   *	ReceivableAmount数据库列名
   */
  public final static java.lang.String RECEIVABLEAMOUNT_FIELD =  "ReceivableAmount";
  
  /**
   *	ReceivableAmount字段中文名，用于视图展示
   */
  public final static java.lang.String RECEIVABLEAMOUNT_LABLE = "待收金额";
  
  /**
   *	ReceivableAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal receivableAmount;
  
  /**
   *	StandbyAmount数据库列名
   */
  public final static java.lang.String STANDBYAMOUNT_FIELD =  "StandbyAmount";
  
  /**
   *	StandbyAmount字段中文名，用于视图展示
   */
  public final static java.lang.String STANDBYAMOUNT_LABLE = "备付金";
  
  /**
   *	StandbyAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal standbyAmount;
  
  /**
   * 编码 getter
   */
  public java.lang.String getAccountCode(){
    return accountCode;
  }
  /**
   * 编码 setter
   * @param AccountCode
   */  
  public void setAccountCode(java.lang.String accountCode){
    this.accountCode = accountCode;
  }
 
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
   * 基金借款 getter
   */
  public java.math.BigDecimal getBorrowFundAmount(){
    return borrowFundAmount;
  }
  /**
   * 基金借款 setter
   * @param BorrowFundAmount
   */  
  public void setBorrowFundAmount(java.math.BigDecimal borrowFundAmount){
    this.borrowFundAmount = borrowFundAmount;
  }
 
  /**
   * 可提现金额 getter
   */
  public java.math.BigDecimal getCanCashAmount(){
    return canCashAmount;
  }
  /**
   * 可提现金额 setter
   * @param CanCashAmount
   */  
  public void setCanCashAmount(java.math.BigDecimal canCashAmount){
    this.canCashAmount = canCashAmount;
  }
 
  /**
   * 是否开通取款 getter
   */
  public java.lang.Boolean getCanDrawal(){
    return canDrawal;
  }
  /**
   * 是否开通取款 setter
   * @param CanDrawal
   */  
  public void setCanDrawal(java.lang.Boolean canDrawal){
    this.canDrawal = canDrawal;
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
   * 客户类别 getter
   */
  public java.lang.Long getCustomerType(){
    return customerType;
  }
  /**
   * 客户类别 setter
   * @param CustomerType
   */  
  public void setCustomerType(java.lang.Long customerType){
    this.customerType = customerType;
  }
 
  /**
   * 押金余额 getter
   */
  public java.math.BigDecimal getDepositBalance(){
    return depositBalance;
  }
  /**
   * 押金余额 setter
   * @param DepositBalance
   */  
  public void setDepositBalance(java.math.BigDecimal depositBalance){
    this.depositBalance = depositBalance;
  }
 
  /**
   * 待付金额 getter
   */
  public java.math.BigDecimal getDueAmount(){
    return dueAmount;
  }
  /**
   * 待付金额 setter
   * @param DueAmount
   */  
  public void setDueAmount(java.math.BigDecimal dueAmount){
    this.dueAmount = dueAmount;
  }
 
  /**
   * 冻结金额 getter
   */
  public java.math.BigDecimal getFrozenAmount(){
    return frozenAmount;
  }
  /**
   * 冻结金额 setter
   * @param FrozenAmont
   */
  public void setFrozenAmount(java.math.BigDecimal frozenAmount){
    this.frozenAmount = frozenAmount;
  }
 
  /**
   * 资金金额 getter
   */
  public java.math.BigDecimal getFundAmount(){
    return fundAmount;
  }
  /**
   * 资金金额 setter
   * @param FundAmount
   */  
  public void setFundAmount(java.math.BigDecimal fundAmount){
    this.fundAmount = fundAmount;
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
   * 最后变动数额 getter
   */
  public java.math.BigDecimal getLatestChangeAmount(){
    return latestChangeAmount;
  }
  /**
   * 最后变动数额 setter
   * @param LatestChangeAmount
   */  
  public void setLatestChangeAmount(java.math.BigDecimal latestChangeAmount){
    this.latestChangeAmount = latestChangeAmount;
  }
 
  /**
   * 最后变动类型 getter
   */
  public java.lang.Long getLatestChangeMode(){
    return latestChangeMode;
  }
  /**
   * 最后变动类型 setter
   * @param LatestChangeMode
   */  
  public void setLatestChangeMode(java.lang.Long latestChangeMode){
    this.latestChangeMode = latestChangeMode;
  }
 
  /**
   * 最后变动时间 getter
   */
  public java.time.LocalDateTime getLatestChangeTime(){
    return latestChangeTime;
  }
  /**
   * 最后变动时间 setter
   * @param LatestChangeTime
   */  
  public void setLatestChangeTime(java.time.LocalDateTime latestChangeTime){
    this.latestChangeTime = latestChangeTime;
  }
 
  /**
   * 最后变动类别 getter
   */
  public java.lang.Long getLatestChangeType(){
    return latestChangeType;
  }
  /**
   * 最后变动类别 setter
   * @param LatestChangeType
   */  
  public void setLatestChangeType(java.lang.Long latestChangeType){
    this.latestChangeType = latestChangeType;
  }
 
  /**
   * 最后变动操作人 getter
   */
  public java.lang.Long getLatestOperatorID(){
    return latestOperatorID;
  }
  /**
   * 最后变动操作人 setter
   * @param LatestOperatorID
   */  
  public void setLatestOperatorID(java.lang.Long latestOperatorID){
    this.latestOperatorID = latestOperatorID;
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
   * 预付余额 getter
   */
  public java.math.BigDecimal getPrepaymentBalance(){
    return prepaymentBalance;
  }
  /**
   * 预付余额 setter
   * @param PrepaymentBalance
   */  
  public void setPrepaymentBalance(java.math.BigDecimal prepaymentBalance){
    this.prepaymentBalance = prepaymentBalance;
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
   * 待收金额 getter
   */
  public java.math.BigDecimal getReceivableAmount(){
    return receivableAmount;
  }
  /**
   * 待收金额 setter
   * @param ReceivableAmount
   */  
  public void setReceivableAmount(java.math.BigDecimal receivableAmount){
    this.receivableAmount = receivableAmount;
  }
 
  /**
   * 备付金 getter
   */
  public java.math.BigDecimal getStandbyAmount(){
    return standbyAmount;
  }
  /**
   * 备付金 setter
   * @param StandbyAmount
   */  
  public void setStandbyAmount(java.math.BigDecimal standbyAmount){
    this.standbyAmount = standbyAmount;
  }
 
}