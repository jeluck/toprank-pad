package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_MessageInfo类中进行修改
 *
 * ********************************************************************************************************************/
public class O_MessageInfoEntityBase extends Entity {

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
   *	BusinessStatus数据库列名
   */
  public final static java.lang.String BUSINESSSTATUS_FIELD =  "BusinessStatus";

  /**
   *	BusinessStatus字段中文名，用于视图展示
   */
  public final static java.lang.String BUSINESSSTATUS_LABLE = "业务状态";

  /**
   *	BusinessStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long businessStatus;

  /**
   *	BusinessType数据库列名
   */
  public final static java.lang.String BUSINESSTYPE_FIELD =  "BusinessType";

  /**
   *	BusinessType字段中文名，用于视图展示
   */
  public final static java.lang.String BUSINESSTYPE_LABLE = "业务类别";

  /**
   *	BusinessType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long businessType;

  /**
   *	CompletedDesc数据库列名
   */
  public final static java.lang.String COMPLETEDDESC_FIELD =  "CompletedDesc";

  /**
   *	CompletedDesc字段中文名，用于视图展示
   */
  public final static java.lang.String COMPLETEDDESC_LABLE = "完成描述";

  /**
   *	CompletedDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String completedDesc;

  /**
   *	CompletedTime数据库列名
   */
  public final static java.lang.String COMPLETEDTIME_FIELD =  "CompletedTime";

  /**
   *	CompletedTime字段中文名，用于视图展示
   */
  public final static java.lang.String COMPLETEDTIME_LABLE = "完成时间";

  /**
   *	CompletedTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime completedTime;

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
   *	GetwayAddress数据库列名
   */
  public final static java.lang.String GETWAYADDRESS_FIELD =  "GetwayAddress";

  /**
   *	GetwayAddress字段中文名，用于视图展示
   */
  public final static java.lang.String GETWAYADDRESS_LABLE = "网关地址";

  /**
   *	GetwayAddress对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String getwayAddress;

  /**
   *	IsSMS数据库列名
   */
  public final static java.lang.String ISSMS_FIELD =  "IsSMS";

  /**
   *	IsSMS字段中文名，用于视图展示
   */
  public final static java.lang.String ISSMS_LABLE = "是否短信";

  /**
   *	IsSMS对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isSMS;

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
   *	KeyVersion数据库列名
   */
  public final static java.lang.String KEYVERSION_FIELD =  "KeyVersion";

  /**
   *	KeyVersion字段中文名，用于视图展示
   */
  public final static java.lang.String KEYVERSION_LABLE = "密钥版本";

  /**
   *	KeyVersion对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String keyVersion;

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
   *	ReceiverCode数据库列名
   */
  public final static java.lang.String RECEIVERCODE_FIELD =  "ReceiverCode";

  /**
   *	ReceiverCode字段中文名，用于视图展示
   */
  public final static java.lang.String RECEIVERCODE_LABLE = "接收号码";

  /**
   *	ReceiverCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String receiverCode;

  /**
   *	RecipientID数据库列名
   */
  public final static java.lang.String RECIPIENTID_FIELD =  "RecipientID";

  /**
   *	RecipientID字段中文名，用于视图展示
   */
  public final static java.lang.String RECIPIENTID_LABLE = "接收人";

  /**
   *	RecipientID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long recipientID;

  /**
   *	RecipientType数据库列名
   */
  public final static java.lang.String RECIPIENTTYPE_FIELD =  "RecipientType";

  /**
   *	RecipientType字段中文名，用于视图展示
   */
  public final static java.lang.String RECIPIENTTYPE_LABLE = "接收人类别";

  /**
   *	RecipientType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long recipientType;

  /**
   *	SendCode数据库列名
   */
  public final static java.lang.String SENDCODE_FIELD =  "SendCode";

  /**
   *	SendCode字段中文名，用于视图展示
   */
  public final static java.lang.String SENDCODE_LABLE = "发送号码";

  /**
   *	SendCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String sendCode;

  /**
   *	SenderID数据库列名
   */
  public final static java.lang.String SENDERID_FIELD =  "SenderID";

  /**
   *	SenderID字段中文名，用于视图展示
   */
  public final static java.lang.String SENDERID_LABLE = "发送人";

  /**
   *	SenderID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long senderID;

  /**
   *	SenderType数据库列名
   */
  public final static java.lang.String SENDERTYPE_FIELD =  "SenderType";

  /**
   *	SenderType字段中文名，用于视图展示
   */
  public final static java.lang.String SENDERTYPE_LABLE = "发送人类别";

  /**
   *	SenderType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long senderType;

  /**
   *	SendStatus数据库列名
   */
  public final static java.lang.String SENDSTATUS_FIELD =  "SendStatus";

  /**
   *	SendStatus字段中文名，用于视图展示
   */
  public final static java.lang.String SENDSTATUS_LABLE = "发送状态";

  /**
   *	SendStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long sendStatus;

  /**
   *	SettingID数据库列名
   */
  public final static java.lang.String SETTINGID_FIELD =  "SettingID";

  /**
   *	SettingID字段中文名，用于视图展示
   */
  public final static java.lang.String SETTINGID_LABLE = "设置编号";

  /**
   *	SettingID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long settingID;

  /**
   *	SignInfo数据库列名
   */
  public final static java.lang.String SIGNINFO_FIELD =  "SignInfo";

  /**
   *	SignInfo字段中文名，用于视图展示
   */
  public final static java.lang.String SIGNINFO_LABLE = "签名信息";

  /**
   *	SignInfo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String signInfo;

  /**
   *	SMSCode数据库列名
   */
  public final static java.lang.String SMSCODE_FIELD =  "SMSCode";

  /**
   *	SMSCode字段中文名，用于视图展示
   */
  public final static java.lang.String SMSCODE_LABLE = "短信编码";

  /**
   *	SMSCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String sMSCode;

  /**
   *	SMSContent数据库列名
   */
  public final static java.lang.String SMSCONTENT_FIELD =  "SMSContent";

  /**
   *	SMSContent字段中文名，用于视图展示
   */
  public final static java.lang.String SMSCONTENT_LABLE = "信息内容";

  /**
   *	SMSContent对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String sMSContent;

  /**
   *	SMSID数据库列名
   */
  public final static java.lang.String SMSID_FIELD =  "SMSID";

  /**
   *	SMSID字段中文名，用于视图展示
   */
  public final static java.lang.String SMSID_LABLE = "短信编号";

  /**
   *	SMSID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long sMSID;

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
   *	SubOrderID数据库列名
   */
  public final static java.lang.String SUBORDERID_FIELD =  "SubOrderID";

  /**
   *	SubOrderID字段中文名，用于视图展示
   */
  public final static java.lang.String SUBORDERID_LABLE = "SubOrderID";

  /**
   *	SubOrderID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long subOrderID;

  /**
   *	TableID数据库列名
   */
  public final static java.lang.String TABLEID_FIELD =  "TableID";

  /**
   *	TableID字段中文名，用于视图展示
   */
  public final static java.lang.String TABLEID_LABLE = "TableID";

  /**
   *	TableID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long tableID;

  /**
   *	TableName数据库列名
   */
  public final static java.lang.String TABLENAME_FIELD =  "TableName";

  /**
   *	TableName字段中文名，用于视图展示
   */
  public final static java.lang.String TABLENAME_LABLE = "TableName";

  /**
   *	TableName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String tableName;

  /**
   *	TemplateID数据库列名
   */
  public final static java.lang.String TEMPLATEID_FIELD =  "TemplateID";

  /**
   *	TemplateID字段中文名，用于视图展示
   */
  public final static java.lang.String TEMPLATEID_LABLE = "TemplateID";

  /**
   *	TemplateID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long templateID;

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
   * 业务状态 getter
   */
  public java.lang.Long getBusinessStatus(){
    return businessStatus;
  }
  /**
   * 业务状态 setter
   * @param BusinessStatus
   */
  public void setBusinessStatus(java.lang.Long businessStatus){
    this.businessStatus = businessStatus;
  }

  /**
   * 业务类别 getter
   */
  public java.lang.Long getBusinessType(){
    return businessType;
  }
  /**
   * 业务类别 setter
   * @param BusinessType
   */
  public void setBusinessType(java.lang.Long businessType){
    this.businessType = businessType;
  }

  /**
   * 完成描述 getter
   */
  public java.lang.String getCompletedDesc(){
    return completedDesc;
  }
  /**
   * 完成描述 setter
   * @param CompletedDesc
   */
  public void setCompletedDesc(java.lang.String completedDesc){
    this.completedDesc = completedDesc;
  }

  /**
   * 完成时间 getter
   */
  public java.time.LocalDateTime getCompletedTime(){
    return completedTime;
  }
  /**
   * 完成时间 setter
   * @param CompletedTime
   */
  public void setCompletedTime(java.time.LocalDateTime completedTime){
    this.completedTime = completedTime;
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
   * 网关地址 getter
   */
  public java.lang.String getGetwayAddress(){
    return getwayAddress;
  }
  /**
   * 网关地址 setter
   * @param GetwayAddress
   */
  public void setGetwayAddress(java.lang.String getwayAddress){
    this.getwayAddress = getwayAddress;
  }

  /**
   * 是否短信 getter
   */
  public java.lang.Boolean getIsSMS(){
    return isSMS;
  }
  /**
   * 是否短信 setter
   * @param IsSMS
   */
  public void setIsSMS(java.lang.Boolean isSMS){
    this.isSMS = isSMS;
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
   * 密钥版本 getter
   */
  public java.lang.String getKeyVersion(){
    return keyVersion;
  }
  /**
   * 密钥版本 setter
   * @param KeyVersion
   */
  public void setKeyVersion(java.lang.String keyVersion){
    this.keyVersion = keyVersion;
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
   * 接收号码 getter
   */
  public java.lang.String getReceiverCode(){
    return receiverCode;
  }
  /**
   * 接收号码 setter
   * @param ReceiverCode
   */
  public void setReceiverCode(java.lang.String receiverCode){
    this.receiverCode = receiverCode;
  }

  /**
   * 接收人 getter
   */
  public java.lang.Long getRecipientID(){
    return recipientID;
  }
  /**
   * 接收人 setter
   * @param RecipientID
   */
  public void setRecipientID(java.lang.Long recipientID){
    this.recipientID = recipientID;
  }

  /**
   * 接收人类别 getter
   */
  public java.lang.Long getRecipientType(){
    return recipientType;
  }
  /**
   * 接收人类别 setter
   * @param RecipientType
   */
  public void setRecipientType(java.lang.Long recipientType){
    this.recipientType = recipientType;
  }

  /**
   * 发送号码 getter
   */
  public java.lang.String getSendCode(){
    return sendCode;
  }
  /**
   * 发送号码 setter
   * @param SendCode
   */
  public void setSendCode(java.lang.String sendCode){
    this.sendCode = sendCode;
  }

  /**
   * 发送人 getter
   */
  public java.lang.Long getSenderID(){
    return senderID;
  }
  /**
   * 发送人 setter
   * @param SenderID
   */
  public void setSenderID(java.lang.Long senderID){
    this.senderID = senderID;
  }

  /**
   * 发送人类别 getter
   */
  public java.lang.Long getSenderType(){
    return senderType;
  }
  /**
   * 发送人类别 setter
   * @param SenderType
   */
  public void setSenderType(java.lang.Long senderType){
    this.senderType = senderType;
  }

  /**
   * 发送状态 getter
   */
  public java.lang.Long getSendStatus(){
    return sendStatus;
  }
  /**
   * 发送状态 setter
   * @param SendStatus
   */
  public void setSendStatus(java.lang.Long sendStatus){
    this.sendStatus = sendStatus;
  }

  /**
   * 设置编号 getter
   */
  public java.lang.Long getSettingID(){
    return settingID;
  }
  /**
   * 设置编号 setter
   * @param SettingID
   */
  public void setSettingID(java.lang.Long settingID){
    this.settingID = settingID;
  }

  /**
   * 签名信息 getter
   */
  public java.lang.String getSignInfo(){
    return signInfo;
  }
  /**
   * 签名信息 setter
   * @param SignInfo
   */
  public void setSignInfo(java.lang.String signInfo){
    this.signInfo = signInfo;
  }

  /**
   * 短信编码 getter
   */
  public java.lang.String getSMSCode(){
    return sMSCode;
  }
  /**
   * 短信编码 setter
   * @param SMSCode
   */
  public void setSMSCode(java.lang.String sMSCode){
    this.sMSCode = sMSCode;
  }

  /**
   * 信息内容 getter
   */
  public java.lang.String getSMSContent(){
    return sMSContent;
  }
  /**
   * 信息内容 setter
   * @param SMSContent
   */
  public void setSMSContent(java.lang.String sMSContent){
    this.sMSContent = sMSContent;
  }

  /**
   * 短信编号 getter
   */
  public java.lang.Long getSMSID(){
    return sMSID;
  }
  /**
   * 短信编号 setter
   * @param SMSID
   */
  public void setSMSID(java.lang.Long sMSID){
    this.sMSID = sMSID;
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

  /**
   * SubOrderID getter
   */
  public java.lang.Long getSubOrderID(){
    return subOrderID;
  }
  /**
   * SubOrderID setter
   * @param SubOrderID
   */
  public void setSubOrderID(java.lang.Long subOrderID){
    this.subOrderID = subOrderID;
  }

  /**
   * TableID getter
   */
  public java.lang.Long getTableID(){
    return tableID;
  }
  /**
   * TableID setter
   * @param TableID
   */
  public void setTableID(java.lang.Long tableID){
    this.tableID = tableID;
  }

  /**
   * TableName getter
   */
  public java.lang.String getTableName(){
    return tableName;
  }
  /**
   * TableName setter
   * @param TableName
   */
  public void setTableName(java.lang.String tableName){
    this.tableName = tableName;
  }

  /**
   * TemplateID getter
   */
  public java.lang.Long getTemplateID(){
    return templateID;
  }
  /**
   * TemplateID setter
   * @param TemplateID
   */
  public void setTemplateID(java.lang.Long templateID){
    this.templateID = templateID;
  }

}