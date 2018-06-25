package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在F_FundChangeDetailInfo类中进行修改
 *
 * ********************************************************************************************************************/
public class F_FundChangeDetailInfoEntityBase extends Entity {

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
   *	AfterAmount数据库列名
   */
  public final static java.lang.String AFTERAMOUNT_FIELD =  "AfterAmount";

  /**
   *	AfterAmount字段中文名，用于视图展示
   */
  public final static java.lang.String AFTERAMOUNT_LABLE = "变动后金额";

  /**
   *	AfterAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal afterAmount;

  /**
   *	BeforeAmount数据库列名
   */
  public final static java.lang.String BEFOREAMOUNT_FIELD =  "BeforeAmount";

  /**
   *	BeforeAmount字段中文名，用于视图展示
   */
  public final static java.lang.String BEFOREAMOUNT_LABLE = "变动前金额";

  /**
   *	BeforeAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal beforeAmount;

  /**
   *	ChangeAmount数据库列名
   */
  public final static java.lang.String CHANGEAMOUNT_FIELD =  "ChangeAmount";

  /**
   *	ChangeAmount字段中文名，用于视图展示
   */
  public final static java.lang.String CHANGEAMOUNT_LABLE = "变动数量";

  /**
   *	ChangeAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal changeAmount;

  /**
   *	ChangeDetail数据库列名
   */
  public final static java.lang.String CHANGEDETAIL_FIELD =  "ChangeDetail";

  /**
   *	ChangeDetail字段中文名，用于视图展示
   */
  public final static java.lang.String CHANGEDETAIL_LABLE = "变动描述";

  /**
   *	ChangeDetail对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String changeDetail;

  /**
   *	ChangeID数据库列名
   */
  public final static java.lang.String CHANGEID_FIELD =  "ChangeID";

  /**
   *	ChangeID字段中文名，用于视图展示
   */
  public final static java.lang.String CHANGEID_LABLE = "变动编号";

  /**
   *	ChangeID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long changeID;

  /**
   *	ChangeReason数据库列名
   */
  public final static java.lang.String CHANGEREASON_FIELD =  "ChangeReason";

  /**
   *	ChangeReason字段中文名，用于视图展示
   */
  public final static java.lang.String CHANGEREASON_LABLE = "变动原因";

  /**
   *	ChangeReason对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String changeReason;

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
   *	CreatorID数据库列名
   */
  public final static java.lang.String CREATORID_FIELD =  "CreatorID";

  /**
   *	CreatorID字段中文名，用于视图展示
   */
  public final static java.lang.String CREATORID_LABLE = "创建人";

  /**
   *	CreatorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long creatorID;

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
   *	DetailCode数据库列名
   */
  public final static java.lang.String DETAILCODE_FIELD =  "DetailCode";

  /**
   *	DetailCode字段中文名，用于视图展示
   */
  public final static java.lang.String DETAILCODE_LABLE = "明细编码";

  /**
   *	DetailCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String detailCode;

  /**
   *	DetailID数据库列名
   */
  public final static java.lang.String DETAILID_FIELD =  "DetailID";

  /**
   *	DetailID字段中文名，用于视图展示
   */
  public final static java.lang.String DETAILID_LABLE = "明细编号";

  /**
   *	DetailID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long detailID;

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
   *	PaymentMethodID数据库列名
   */
  public final static java.lang.String PAYMENTMETHODID_FIELD =  "PaymentMethodID";

  /**
   *	PaymentMethodID字段中文名，用于视图展示
   */
  public final static java.lang.String PAYMENTMETHODID_LABLE = "支付方式编号";

  /**
   *	PaymentMethodID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long paymentMethodID;

  /**
   *	Proportion数据库列名
   */
  public final static java.lang.String PROPORTION_FIELD =  "Proportion";

  /**
   *	Proportion字段中文名，用于视图展示
   */
  public final static java.lang.String PROPORTION_LABLE = "所占比例";

  /**
   *	Proportion对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float proportion;

  /**
   *	SourceAccountID数据库列名
   */
  public final static java.lang.String SOURCEACCOUNTID_FIELD =  "SourceAccountID";

  /**
   *	SourceAccountID字段中文名，用于视图展示
   */
  public final static java.lang.String SOURCEACCOUNTID_LABLE = "来源帐户";

  /**
   *	SourceAccountID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long sourceAccountID;

  /**
   *	SyncTime数据库列名
   */
  public final static java.lang.String SYNCTIME_FIELD =  "SyncTime";

  /**
   *	SyncTime字段中文名，用于视图展示
   */
  public final static java.lang.String SYNCTIME_LABLE = "SyncTime";

  /**
   *	SyncTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTime;

  /**
   *	SyncTimeResult数据库列名
   */
  public final static java.lang.String SYNCTIMERESULT_FIELD =  "SyncTimeResult";

  /**
   *	SyncTimeResult字段中文名，用于视图展示
   */
  public final static java.lang.String SYNCTIMERESULT_LABLE = "SyncTimeResult";

  /**
   *	SyncTimeResult对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTimeResult;

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
   * 变动后金额 getter
   */
  public java.math.BigDecimal getAfterAmount(){
    return afterAmount;
  }
  /**
   * 变动后金额 setter
   * @param AfterAmount
   */
  public void setAfterAmount(java.math.BigDecimal afterAmount){
    this.afterAmount = afterAmount;
  }

  /**
   * 变动前金额 getter
   */
  public java.math.BigDecimal getBeforeAmount(){
    return beforeAmount;
  }
  /**
   * 变动前金额 setter
   * @param BeforeAmount
   */
  public void setBeforeAmount(java.math.BigDecimal beforeAmount){
    this.beforeAmount = beforeAmount;
  }

  /**
   * 变动数量 getter
   */
  public java.math.BigDecimal getChangeAmount(){
    return changeAmount;
  }
  /**
   * 变动数量 setter
   * @param ChangeAmount
   */
  public void setChangeAmount(java.math.BigDecimal changeAmount){
    this.changeAmount = changeAmount;
  }

  /**
   * 变动描述 getter
   */
  public java.lang.String getChangeDetail(){
    return changeDetail;
  }
  /**
   * 变动描述 setter
   * @param ChangeDetail
   */
  public void setChangeDetail(java.lang.String changeDetail){
    this.changeDetail = changeDetail;
  }

  /**
   * 变动编号 getter
   */
  public java.lang.Long getChangeID(){
    return changeID;
  }
  /**
   * 变动编号 setter
   * @param ChangeID
   */
  public void setChangeID(java.lang.Long changeID){
    this.changeID = changeID;
  }

  /**
   * 变动原因 getter
   */
  public java.lang.String getChangeReason(){
    return changeReason;
  }
  /**
   * 变动原因 setter
   * @param ChangeReason
   */
  public void setChangeReason(java.lang.String changeReason){
    this.changeReason = changeReason;
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
   * 创建人 getter
   */
  public java.lang.Long getCreatorID(){
    return creatorID;
  }
  /**
   * 创建人 setter
   * @param CreatorID
   */
  public void setCreatorID(java.lang.Long creatorID){
    this.creatorID = creatorID;
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
   * 明细编码 getter
   */
  public java.lang.String getDetailCode(){
    return detailCode;
  }
  /**
   * 明细编码 setter
   * @param DetailCode
   */
  public void setDetailCode(java.lang.String detailCode){
    this.detailCode = detailCode;
  }

  /**
   * 明细编号 getter
   */
  public java.lang.Long getDetailID(){
    return detailID;
  }
  /**
   * 明细编号 setter
   * @param DetailID
   */
  public void setDetailID(java.lang.Long detailID){
    this.detailID = detailID;
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
   * 支付方式编号 getter
   */
  public java.lang.Long getPaymentMethodID(){
    return paymentMethodID;
  }
  /**
   * 支付方式编号 setter
   * @param PaymentMethodID
   */
  public void setPaymentMethodID(java.lang.Long paymentMethodID){
    this.paymentMethodID = paymentMethodID;
  }

  /**
   * 所占比例 getter
   */
  public java.lang.Float getProportion(){
    return proportion;
  }
  /**
   * 所占比例 setter
   * @param Proportion
   */
  public void setProportion(java.lang.Float proportion){
    this.proportion = proportion;
  }

  /**
   * 来源帐户 getter
   */
  public java.lang.Long getSourceAccountID(){
    return sourceAccountID;
  }
  /**
   * 来源帐户 setter
   * @param SourceAccountID
   */
  public void setSourceAccountID(java.lang.Long sourceAccountID){
    this.sourceAccountID = sourceAccountID;
  }

  /**
   * SyncTime getter
   */
  public java.time.LocalDateTime getSyncTime(){
    return syncTime;
  }
  /**
   * SyncTime setter
   * @param SyncTime
   */
  public void setSyncTime(java.time.LocalDateTime syncTime){
    this.syncTime = syncTime;
  }

  /**
   * SyncTimeResult getter
   */
  public java.time.LocalDateTime getSyncTimeResult(){
    return syncTimeResult;
  }
  /**
   * SyncTimeResult setter
   * @param SyncTimeResult
   */
  public void setSyncTimeResult(java.time.LocalDateTime syncTimeResult){
    this.syncTimeResult = syncTimeResult;
  }

}