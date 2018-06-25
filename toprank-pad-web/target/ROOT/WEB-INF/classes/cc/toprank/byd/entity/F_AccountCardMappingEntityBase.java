package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在F_AccountCardMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class F_AccountCardMappingEntityBase  extends Entity{

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
   *	CertificateID数据库列名
   */
  public final static java.lang.String CERTIFICATEID_FIELD =  "CertificateID";

  /**
   *	CertificateID字段中文名，用于视图展示
   */
  public final static java.lang.String CERTIFICATEID_LABLE = "证书编号";

  /**
   *	CertificateID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long certificateID;

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
   *	DealDesc数据库列名
   */
  public final static java.lang.String DEALDESC_FIELD =  "DealDesc";

  /**
   *	DealDesc字段中文名，用于视图展示
   */
  public final static java.lang.String DEALDESC_LABLE = "处理描述";

  /**
   *	DealDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String dealDesc;

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
   *	HasCertificate数据库列名
   */
  public final static java.lang.String HASCERTIFICATE_FIELD =  "HasCertificate";

  /**
   *	HasCertificate字段中文名，用于视图展示
   */
  public final static java.lang.String HASCERTIFICATE_LABLE = "有否证书";

  /**
   *	HasCertificate对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean hasCertificate;

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
   *	MappingID数据库列名
   */
  public final static java.lang.String MAPPINGID_FIELD =  "MappingID";

  /**
   *	MappingID字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGID_LABLE = "关联编号";

  /**
   *	MappingID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mappingID;

  /**
   *	MappingReason数据库列名
   */
  public final static java.lang.String MAPPINGREASON_FIELD =  "MappingReason";

  /**
   *	MappingReason字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGREASON_LABLE = "关联原因";

  /**
   *	MappingReason对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mappingReason;

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
   *	SignInfo数据库列名
   */
  public final static java.lang.String SIGNINFO_FIELD =  "SignInfo";

  /**
   *	SignInfo字段中文名，用于视图展示
   */
  public final static java.lang.String SIGNINFO_LABLE = "证书内容";

  /**
   *	SignInfo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String signInfo;

  /**
   *	SortNo数据库列名
   */
  public final static java.lang.String SORTNO_FIELD =  "SortNo";

  /**
   *	SortNo字段中文名，用于视图展示
   */
  public final static java.lang.String SORTNO_LABLE = "序号";

  /**
   *	SortNo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer sortNo;

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
   * 证书编号 getter
   */
  public java.lang.Long getCertificateID(){
    return certificateID;
  }
  /**
   * 证书编号 setter
   * @param CertificateID
   */
  public void setCertificateID(java.lang.Long certificateID){
    this.certificateID = certificateID;
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
   * 处理描述 getter
   */
  public java.lang.String getDealDesc(){
    return dealDesc;
  }
  /**
   * 处理描述 setter
   * @param DealDesc
   */
  public void setDealDesc(java.lang.String dealDesc){
    this.dealDesc = dealDesc;
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
   * 有否证书 getter
   */
  public java.lang.Boolean getHasCertificate(){
    return hasCertificate;
  }
  /**
   * 有否证书 setter
   * @param HasCertificate
   */
  public void setHasCertificate(java.lang.Boolean hasCertificate){
    this.hasCertificate = hasCertificate;
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
   * 关联编号 getter
   */
  public java.lang.Long getMappingID(){
    return mappingID;
  }
  /**
   * 关联编号 setter
   * @param MappingID
   */
  public void setMappingID(java.lang.Long mappingID){
    this.mappingID = mappingID;
  }

  /**
   * 关联原因 getter
   */
  public java.lang.Long getMappingReason(){
    return mappingReason;
  }
  /**
   * 关联原因 setter
   * @param MappingReason
   */
  public void setMappingReason(java.lang.Long mappingReason){
    this.mappingReason = mappingReason;
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
   * 证书内容 getter
   */
  public java.lang.String getSignInfo(){
    return signInfo;
  }
  /**
   * 证书内容 setter
   * @param SignInfo
   */
  public void setSignInfo(java.lang.String signInfo){
    this.signInfo = signInfo;
  }

  /**
   * 序号 getter
   */
  public java.lang.Integer getSortNo(){
    return sortNo;
  }
  /**
   * 序号 setter
   * @param SortNo
   */
  public void setSortNo(java.lang.Integer sortNo){
    this.sortNo = sortNo;
  }

}