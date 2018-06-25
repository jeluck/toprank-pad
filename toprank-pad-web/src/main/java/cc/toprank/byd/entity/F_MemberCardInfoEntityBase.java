package cc.toprank.byd.entity;

import java.time.LocalDateTime;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在F_MemberCardInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class F_MemberCardInfoEntityBase extends Entity {

  /**
   *	ActivationCode数据库列名
   */
  public final static java.lang.String ACTIVATIONCODE_FIELD =  "ActivationCode";

  /**
   *	ActivationCode字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVATIONCODE_LABLE = "激活码";

  /**
   *	ActivationCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String activationCode;

  /**
   *	ActivationCodeID数据库列名
   */
  public final static java.lang.String ACTIVATIONCODEID_FIELD =  "ActivationCodeID";

  /**
   *	ActivationCodeID字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVATIONCODEID_LABLE = "激活码编号";

  /**
   *	ActivationCodeID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long activationCodeID;

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
   *	BatchNo数据库列名
   */
  public final static java.lang.String BATCHNO_FIELD =  "BatchNo";

  /**
   *	BatchNo字段中文名，用于视图展示
   */
  public final static java.lang.String BATCHNO_LABLE = "批次";

  /**
   *	BatchNo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String batchNo;

  /**
   *	CardCode数据库列名
   */
  public final static java.lang.String CARDCODE_FIELD =  "CardCode";

  /**
   *	CardCode字段中文名，用于视图展示
   */
  public final static java.lang.String CARDCODE_LABLE = "卡号";

  /**
   *	CardCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String cardCode;

  /**
   *	CardDesc数据库列名
   */
  public final static java.lang.String CARDDESC_FIELD =  "CardDesc";

  /**
   *	CardDesc字段中文名，用于视图展示
   */
  public final static java.lang.String CARDDESC_LABLE = "会员卡描述";

  /**
   *	CardDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String cardDesc;

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
   *	CardLevel数据库列名
   */
  public final static java.lang.String CARDLEVEL_FIELD =  "CardLevel";

  /**
   *	CardLevel字段中文名，用于视图展示
   */
  public final static java.lang.String CARDLEVEL_LABLE = "卡级别";

  /**
   *	CardLevel对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long cardLevel;

  /**
   *	CardSerialNo数据库列名
   */
  public final static java.lang.String CARDSERIALNO_FIELD =  "CardSerialNo";

  /**
   *	CardSerialNo字段中文名，用于视图展示
   */
  public final static java.lang.String CARDSERIALNO_LABLE = "卡序列号";

  /**
   *	CardSerialNo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String cardSerialNo;

  /**
   *	CardStatus数据库列名
   */
  public final static java.lang.String CARDSTATUS_FIELD =  "CardStatus";

  /**
   *	CardStatus字段中文名，用于视图展示
   */
  public final static java.lang.String CARDSTATUS_LABLE = "卡状态";

  /**
   *	CardStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long cardStatus;

  /**
   *	CardType数据库列名
   */
  public final static java.lang.String CARDTYPE_FIELD =  "CardType";

  /**
   *	CardType字段中文名，用于视图展示
   */
  public final static java.lang.String CARDTYPE_LABLE = "卡类别";

  /**
   *	CardType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long cardType;

  /**
   *	Cobranded数据库列名
   */
  public final static java.lang.String COBRANDED_FIELD =  "Cobranded";

  /**
   *	Cobranded字段中文名，用于视图展示
   */
  public final static java.lang.String COBRANDED_LABLE = "联名单位";

  /**
   *	Cobranded对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long cobranded;

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
   *	CreatorType数据库列名
   */
  public final static java.lang.String CREATORTYPE_FIELD =  "CreatorType";

  /**
   *	CreatorType字段中文名，用于视图展示
   */
  public final static java.lang.String CREATORTYPE_LABLE = "创建人类别";

  /**
   *	CreatorType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long creatorType;

  /**
   *	DesignVersion数据库列名
   */
  public final static java.lang.String DESIGNVERSION_FIELD =  "DesignVersion";

  /**
   *	DesignVersion字段中文名，用于视图展示
   */
  public final static java.lang.String DESIGNVERSION_LABLE = "设计版式";

  /**
   *	DesignVersion对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long designVersion;

  /**
   *	ExpirationDate数据库列名
   */
  public final static java.lang.String EXPIRATIONDATE_FIELD =  "ExpirationDate";

  /**
   *	ExpirationDate字段中文名，用于视图展示
   */
  public final static java.lang.String EXPIRATIONDATE_LABLE = "有效期";

  /**
   *	ExpirationDate对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime expirationDate;

  /**
   *	FunctionCategory数据库列名
   */
  public final static java.lang.String FUNCTIONCATEGORY_FIELD =  "FunctionCategory";

  /**
   *	FunctionCategory字段中文名，用于视图展示
   */
  public final static java.lang.String FUNCTIONCATEGORY_LABLE = "功能属性";

  /**
   *	FunctionCategory对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long functionCategory;

  /**
   *	IssuerID数据库列名
   */
  public final static java.lang.String ISSUERID_FIELD =  "IssuerID";

  /**
   *	IssuerID字段中文名，用于视图展示
   */
  public final static java.lang.String ISSUERID_LABLE = "发卡人";

  /**
   *	IssuerID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long issuerID;

  /**
   *	IssueTime数据库列名
   */
  public final static java.lang.String ISSUETIME_FIELD =  "IssueTime";

  /**
   *	IssueTime字段中文名，用于视图展示
   */
  public final static java.lang.String ISSUETIME_LABLE = "发卡时间";

  /**
   *	IssueTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime issueTime;

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
   *	MemberMobile数据库列名
   */
  public final static java.lang.String MEMBERMOBILE_FIELD =  "MemberMobile";

  /**
   *	MemberMobile字段中文名，用于视图展示
   */
  public final static java.lang.String MEMBERMOBILE_LABLE = "会员手机";

  /**
   *	MemberMobile对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String memberMobile;

  /**
   *	MemberName数据库列名
   */
  public final static java.lang.String MEMBERNAME_FIELD =  "MemberName";

  /**
   *	MemberName字段中文名，用于视图展示
   */
  public final static java.lang.String MEMBERNAME_LABLE = "会员名称";

  /**
   *	MemberName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String memberName;

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
   *	OrgID数据库列名
   */
  public final static java.lang.String ORGID_FIELD =  "OrgID";

  /**
   *	OrgID字段中文名，用于视图展示
   */
  public final static java.lang.String ORGID_LABLE = "机构编号";

  /**
   *	OrgID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orgID;

  /**
   *	PayPassword数据库列名
   */
  public final static java.lang.String PAYPASSWORD_FIELD =  "PayPassword";

  /**
   *	PayPassword字段中文名，用于视图展示
   */
  public final static java.lang.String PAYPASSWORD_LABLE = "支付密码";

  /**
   *	PayPassword对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String payPassword;

  /**
   *	QueryPassword数据库列名
   */
  public final static java.lang.String QUERYPASSWORD_FIELD =  "QueryPassword";

  /**
   *	QueryPassword字段中文名，用于视图展示
   */
  public final static java.lang.String QUERYPASSWORD_LABLE = "查询密码";

  /**
   *	QueryPassword对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String queryPassword;

  /**
   *	ReleaseYear数据库列名
   */
  public final static java.lang.String RELEASEYEAR_FIELD =  "ReleaseYear";

  /**
   *	ReleaseYear字段中文名，用于视图展示
   */
  public final static java.lang.String RELEASEYEAR_LABLE = "发行年份";

  /**
   *	ReleaseYear对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long releaseYear;

  /**
   *	RoleID数据库列名
   */
  public final static java.lang.String ROLEID_FIELD =  "RoleID";

  /**
   *	RoleID字段中文名，用于视图展示
   */
  public final static java.lang.String ROLEID_LABLE = "RoleID";

  /**
   *	RoleID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long roleID;

  /**
   *	SerialNo数据库列名
   */
  public final static java.lang.String SERIALNO_FIELD =  "SerialNo";

  /**
   *	SerialNo字段中文名，用于视图展示
   */
  public final static java.lang.String SERIALNO_LABLE = "序号";

  /**
   *	SerialNo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer serialNo;

  /**
   * 激活码 getter
   */
  public java.lang.String getActivationCode(){
    return activationCode;
  }
  /**
   * 激活码 setter
   * @param ActivationCode
   */
  public void setActivationCode(java.lang.String activationCode){
    this.activationCode = activationCode;
  }

  /**
   * 激活码编号 getter
   */
  public java.lang.Long getActivationCodeID(){
    return activationCodeID;
  }
  /**
   * 激活码编号 setter
   * @param ActivationCodeID
   */
  public void setActivationCodeID(java.lang.Long activationCodeID){
    this.activationCodeID = activationCodeID;
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
   * 批次 getter
   */
  public java.lang.String getBatchNo(){
    return batchNo;
  }
  /**
   * 批次 setter
   * @param BatchNo
   */
  public void setBatchNo(java.lang.String batchNo){
    this.batchNo = batchNo;
  }

  /**
   * 卡号 getter
   */
  public java.lang.String getCardCode(){
    return cardCode;
  }
  /**
   * 卡号 setter
   * @param CardCode
   */
  public void setCardCode(java.lang.String cardCode){
    this.cardCode = cardCode;
  }

  /**
   * 会员卡描述 getter
   */
  public java.lang.String getCardDesc(){
    return cardDesc;
  }
  /**
   * 会员卡描述 setter
   * @param CardDesc
   */
  public void setCardDesc(java.lang.String cardDesc){
    this.cardDesc = cardDesc;
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
   * 卡级别 getter
   */
  public java.lang.Long getCardLevel(){
    return cardLevel;
  }
  /**
   * 卡级别 setter
   * @param CardLevel
   */
  public void setCardLevel(java.lang.Long cardLevel){
    this.cardLevel = cardLevel;
  }

  /**
   * 卡序列号 getter
   */
  public java.lang.String getCardSerialNo(){
    return cardSerialNo;
  }
  /**
   * 卡序列号 setter
   * @param CardSerialNo
   */
  public void setCardSerialNo(java.lang.String cardSerialNo){
    this.cardSerialNo = cardSerialNo;
  }

  /**
   * 卡状态 getter
   */
  public java.lang.Long getCardStatus(){
    return cardStatus;
  }
  /**
   * 卡状态 setter
   * @param CardStatus
   */
  public void setCardStatus(java.lang.Long cardStatus){
    this.cardStatus = cardStatus;
  }

  /**
   * 卡类别 getter
   */
  public java.lang.Long getCardType(){
    return cardType;
  }
  /**
   * 卡类别 setter
   * @param CardType
   */
  public void setCardType(java.lang.Long cardType){
    this.cardType = cardType;
  }

  /**
   * 联名单位 getter
   */
  public java.lang.Long getCobranded(){
    return cobranded;
  }
  /**
   * 联名单位 setter
   * @param Cobranded
   */
  public void setCobranded(java.lang.Long cobranded){
    this.cobranded = cobranded;
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
   * 创建人类别 getter
   */
  public java.lang.Long getCreatorType(){
    return creatorType;
  }
  /**
   * 创建人类别 setter
   * @param CreatorType
   */
  public void setCreatorType(java.lang.Long creatorType){
    this.creatorType = creatorType;
  }

  /**
   * 设计版式 getter
   */
  public java.lang.Long getDesignVersion(){
    return designVersion;
  }
  /**
   * 设计版式 setter
   * @param DesignVersion
   */
  public void setDesignVersion(java.lang.Long designVersion){
    this.designVersion = designVersion;
  }

  /**
   * 有效期 getter
   */
  public java.time.LocalDateTime getExpirationDate(){
    return expirationDate;
  }
  /**
   * 有效期 setter
   * @param ExpirationDate
   */
  public void setExpirationDate(java.time.LocalDateTime expirationDate){
    this.expirationDate = expirationDate;
  }

  /**
   * 功能属性 getter
   */
  public java.lang.Long getFunctionCategory(){
    return functionCategory;
  }
  /**
   * 功能属性 setter
   * @param FunctionCategory
   */
  public void setFunctionCategory(java.lang.Long functionCategory){
    this.functionCategory = functionCategory;
  }

  /**
   * 发卡人 getter
   */
  public java.lang.Long getIssuerID(){
    return issuerID;
  }
  /**
   * 发卡人 setter
   * @param IssuerID
   */
  public void setIssuerID(java.lang.Long issuerID){
    this.issuerID = issuerID;
  }

  /**
   * 发卡时间 getter
   */
  public java.time.LocalDateTime getIssueTime(){
    return issueTime;
  }
  /**
   * 发卡时间 setter
   * @param IssueTime
   */
  public void setIssueTime(java.time.LocalDateTime issueTime){
    this.issueTime = issueTime;
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
   * 会员手机 getter
   */
  public java.lang.String getMemberMobile(){
    return memberMobile;
  }
  /**
   * 会员手机 setter
   * @param MemberMobile
   */
  public void setMemberMobile(java.lang.String memberMobile){
    this.memberMobile = memberMobile;
  }

  /**
   * 会员名称 getter
   */
  public java.lang.String getMemberName(){
    return memberName;
  }
  /**
   * 会员名称 setter
   * @param MemberName
   */
  public void setMemberName(java.lang.String memberName){
    this.memberName = memberName;
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
   * 机构编号 getter
   */
  public java.lang.Long getOrgID(){
    return orgID;
  }
  /**
   * 机构编号 setter
   * @param OrgID
   */
  public void setOrgID(java.lang.Long orgID){
    this.orgID = orgID;
  }

  /**
   * 支付密码 getter
   */
  public java.lang.String getPayPassword(){
    return payPassword;
  }
  /**
   * 支付密码 setter
   * @param PayPassword
   */
  public void setPayPassword(java.lang.String payPassword){
    this.payPassword = payPassword;
  }

  /**
   * 查询密码 getter
   */
  public java.lang.String getQueryPassword(){
    return queryPassword;
  }
  /**
   * 查询密码 setter
   * @param QueryPassword
   */
  public void setQueryPassword(java.lang.String queryPassword){
    this.queryPassword = queryPassword;
  }

  /**
   * 发行年份 getter
   */
  public java.lang.Long getReleaseYear(){
    return releaseYear;
  }
  /**
   * 发行年份 setter
   * @param ReleaseYear
   */
  public void setReleaseYear(java.lang.Long releaseYear){
    this.releaseYear = releaseYear;
  }

  /**
   * RoleID getter
   */
  public java.lang.Long getRoleID(){
    return roleID;
  }
  /**
   * RoleID setter
   * @param RoleID
   */
  public void setRoleID(java.lang.Long roleID){
    this.roleID = roleID;
  }

  /**
   * 序号 getter
   */
  public java.lang.Integer getSerialNo(){
    return serialNo;
  }
  /**
   * 序号 setter
   * @param SerialNo
   */
  public void setSerialNo(java.lang.Integer serialNo){
    this.serialNo = serialNo;
  }

}