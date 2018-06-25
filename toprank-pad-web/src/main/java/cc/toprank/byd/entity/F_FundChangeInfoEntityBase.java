package cc.toprank.byd.entity;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在F_FundChangeInfo类中进行修改
 *
 * ********************************************************************************************************************/
public class F_FundChangeInfoEntityBase  extends Entity{

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
   *	BusinessID数据库列名
   */
  public final static java.lang.String BUSINESSID_FIELD =  "BusinessID";

  /**
   *	BusinessID字段中文名，用于视图展示
   */
  public final static java.lang.String BUSINESSID_LABLE = "业务编号";

  /**
   *	BusinessID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long businessID;

  /**
   *	BusinessType数据库列名
   */
  public final static java.lang.String BUSINESSTYPE_FIELD =  "BusinessType";

  /**
   *	BusinessType字段中文名，用于视图展示
   */
  public final static java.lang.String BUSINESSTYPE_LABLE = "业务类型";

  /**
   *	BusinessType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long businessType;

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
   *	ChangeCode数据库列名
   */
  public final static java.lang.String CHANGECODE_FIELD =  "ChangeCode";

  /**
   *	ChangeCode字段中文名，用于视图展示
   */
  public final static java.lang.String CHANGECODE_LABLE = "变动编码";

  /**
   *	ChangeCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String changeCode;

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
   *	ChangeType数据库列名
   */
  public final static java.lang.String CHANGETYPE_FIELD =  "ChangeType";

  /**
   *	ChangeType字段中文名，用于视图展示
   */
  public final static java.lang.String CHANGETYPE_LABLE = "变动方式";

  /**
   *	ChangeType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long changeType;

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
   *	IsInitiator数据库列名
   */
  public final static java.lang.String ISINITIATOR_FIELD =  "IsInitiator";

  /**
   *	IsInitiator字段中文名，用于视图展示
   */
  public final static java.lang.String ISINITIATOR_LABLE = "是否发起人";

  /**
   *	IsInitiator对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isInitiator;

  /**
   *	IsRelationPlatform数据库列名
   */
  public final static java.lang.String ISRELATIONPLATFORM_FIELD =  "IsRelationPlatform";

  /**
   *	IsRelationPlatform字段中文名，用于视图展示
   */
  public final static java.lang.String ISRELATIONPLATFORM_LABLE = "关联托管平台";

  /**
   *	IsRelationPlatform对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isRelationPlatform;

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
   *	PlatformID数据库列名
   */
  public final static java.lang.String PLATFORMID_FIELD =  "PlatformID";

  /**
   *	PlatformID字段中文名，用于视图展示
   */
  public final static java.lang.String PLATFORMID_LABLE = "托管平台编号";

  /**
   *	PlatformID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long platformID;

  /**
   *	PlatformStatus数据库列名
   */
  public final static java.lang.String PLATFORMSTATUS_FIELD =  "PlatformStatus";

  /**
   *	PlatformStatus字段中文名，用于视图展示
   */
  public final static java.lang.String PLATFORMSTATUS_LABLE = "平台返回状态";

  /**
   *	PlatformStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long platformStatus;

  /**
   *	PlatformTypeID数据库列名
   */
  public final static java.lang.String PLATFORMTYPEID_FIELD =  "PlatformTypeID";

  /**
   *	PlatformTypeID字段中文名，用于视图展示
   */
  public final static java.lang.String PLATFORMTYPEID_LABLE = "托管平台类别";

  /**
   *	PlatformTypeID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long platformTypeID;

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
   *	RequestData数据库列名
   */
  public final static java.lang.String REQUESTDATA_FIELD =  "RequestData";

  /**
   *	RequestData字段中文名，用于视图展示
   */
  public final static java.lang.String REQUESTDATA_LABLE = "平台请求数据";

  /**
   *	RequestData对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String requestData;

  /**
   *	ResponseData数据库列名
   */
  public final static java.lang.String RESPONSEDATA_FIELD =  "ResponseData";

  /**
   *	ResponseData字段中文名，用于视图展示
   */
  public final static java.lang.String RESPONSEDATA_LABLE = "平台返馈数据";

  /**
   *	ResponseData对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String responseData;

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
   * 业务编号 getter
   */
  public java.lang.Long getBusinessID(){
    return businessID;
  }
  /**
   * 业务编号 setter
   * @param BusinessID
   */
  public void setBusinessID(java.lang.Long businessID){
    this.businessID = businessID;
  }

  /**
   * 业务类型 getter
   */
  public java.lang.Long getBusinessType(){
    return businessType;
  }
  /**
   * 业务类型 setter
   * @param BusinessType
   */
  public void setBusinessType(java.lang.Long businessType){
    this.businessType = businessType;
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
   * 变动编码 getter
   */
  public java.lang.String getChangeCode(){
    return changeCode;
  }
  /**
   * 变动编码 setter
   * @param ChangeCode
   */
  public void setChangeCode(java.lang.String changeCode){
    this.changeCode = changeCode;
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
   * 变动方式 getter
   */
  public java.lang.Long getChangeType(){
    return changeType;
  }
  /**
   * 变动方式 setter
   * @param ChangeType
   */
  public void setChangeType(java.lang.Long changeType){
    this.changeType = changeType;
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
   * 是否发起人 getter
   */
  public java.lang.Boolean getIsInitiator(){
    return isInitiator;
  }
  /**
   * 是否发起人 setter
   * @param IsInitiator
   */
  public void setIsInitiator(java.lang.Boolean isInitiator){
    this.isInitiator = isInitiator;
  }

  /**
   * 关联托管平台 getter
   */
  public java.lang.Boolean getIsRelationPlatform(){
    return isRelationPlatform;
  }
  /**
   * 关联托管平台 setter
   * @param IsRelationPlatform
   */
  public void setIsRelationPlatform(java.lang.Boolean isRelationPlatform){
    this.isRelationPlatform = isRelationPlatform;
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
   * 托管平台编号 getter
   */
  public java.lang.Long getPlatformID(){
    return platformID;
  }
  /**
   * 托管平台编号 setter
   * @param PlatformID
   */
  public void setPlatformID(java.lang.Long platformID){
    this.platformID = platformID;
  }

  /**
   * 平台返回状态 getter
   */
  public java.lang.Long getPlatformStatus(){
    return platformStatus;
  }
  /**
   * 平台返回状态 setter
   * @param PlatformStatus
   */
  public void setPlatformStatus(java.lang.Long platformStatus){
    this.platformStatus = platformStatus;
  }

  /**
   * 托管平台类别 getter
   */
  public java.lang.Long getPlatformTypeID(){
    return platformTypeID;
  }
  /**
   * 托管平台类别 setter
   * @param PlatformTypeID
   */
  public void setPlatformTypeID(java.lang.Long platformTypeID){
    this.platformTypeID = platformTypeID;
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
   * 平台请求数据 getter
   */
  public java.lang.String getRequestData(){
    return requestData;
  }
  /**
   * 平台请求数据 setter
   * @param RequestData
   */
  public void setRequestData(java.lang.String requestData){
    this.requestData = requestData;
  }

  /**
   * 平台返馈数据 getter
   */
  public java.lang.String getResponseData(){
    return responseData;
  }
  /**
   * 平台返馈数据 setter
   * @param ResponseData
   */
  public void setResponseData(java.lang.String responseData){
    this.responseData = responseData;
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

}