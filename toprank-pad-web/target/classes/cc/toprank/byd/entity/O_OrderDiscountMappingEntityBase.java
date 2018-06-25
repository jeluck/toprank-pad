package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_OrderDiscountMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_OrderDiscountMappingEntityBase extends Entity {

  /**
   *	Authorizer数据库列名
   */
  public final static java.lang.String AUTHORIZER_FIELD =  "Authorizer";
  
  /**
   *	Authorizer字段中文名，用于视图展示
   */
  public final static java.lang.String AUTHORIZER_LABLE = "授权人";
  
  /**
   *	Authorizer对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long authorizer;
  
  /**
   *	AuthorizeTime数据库列名
   */
  public final static java.lang.String AUTHORIZETIME_FIELD =  "AuthorizeTime";
  
  /**
   *	AuthorizeTime字段中文名，用于视图展示
   */
  public final static java.lang.String AUTHORIZETIME_LABLE = "授权时间";
  
  /**
   *	AuthorizeTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime authorizeTime;
  
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
   *	CustomerMemo数据库列名
   */
  public final static java.lang.String CUSTOMERMEMO_FIELD =  "CustomerMemo";
  
  /**
   *	CustomerMemo字段中文名，用于视图展示
   */
  public final static java.lang.String CUSTOMERMEMO_LABLE = "客户备注";
  
  /**
   *	CustomerMemo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String customerMemo;
  
  /**
   *	DiscountAmount数据库列名
   */
  public final static java.lang.String DISCOUNTAMOUNT_FIELD =  "DiscountAmount";
  
  /**
   *	DiscountAmount字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTAMOUNT_LABLE = "减免金额";
  
  /**
   *	DiscountAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal discountAmount;
  
  /**
   *	DiscountID数据库列名
   */
  public final static java.lang.String DISCOUNTID_FIELD =  "DiscountID";
  
  /**
   *	DiscountID字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTID_LABLE = "折扣编号";
  
  /**
   *	DiscountID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long discountID;
  
  /**
   *	DiscountPercentage数据库列名
   */
  public final static java.lang.String DISCOUNTPERCENTAGE_FIELD =  "DiscountPercentage";
  
  /**
   *	DiscountPercentage字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTPERCENTAGE_LABLE = "折扣比率";
  
  /**
   *	DiscountPercentage对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float discountPercentage;
  
  /**
   *	DiscountType数据库列名
   */
  public final static java.lang.String DISCOUNTTYPE_FIELD =  "DiscountType";
  
  /**
   *	DiscountType字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTTYPE_LABLE = "折扣类别";
  
  /**
   *	DiscountType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long discountType;
  
  /**
   *	IsManualProcess数据库列名
   */
  public final static java.lang.String ISMANUALPROCESS_FIELD =  "IsManualProcess";
  
  /**
   *	IsManualProcess字段中文名，用于视图展示
   */
  public final static java.lang.String ISMANUALPROCESS_LABLE = "是否人工处理";
  
  /**
   *	IsManualProcess对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isManualProcess;
  
  /**
   *	IsRatio数据库列名
   */
  public final static java.lang.String ISRATIO_FIELD =  "IsRatio";
  
  /**
   *	IsRatio字段中文名，用于视图展示
   */
  public final static java.lang.String ISRATIO_LABLE = "是否比率";
  
  /**
   *	IsRatio对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isRatio;
  
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
   *	MappingDesc数据库列名
   */
  public final static java.lang.String MAPPINGDESC_FIELD =  "MappingDesc";
  
  /**
   *	MappingDesc字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGDESC_LABLE = "关联描述";
  
  /**
   *	MappingDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String mappingDesc;
  
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
   *	MappingOrderID数据库列名
   */
  public final static java.lang.String MAPPINGORDERID_FIELD =  "MappingOrderID";
  
  /**
   *	MappingOrderID字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGORDERID_LABLE = "MappingOrderID";
  
  /**
   *	MappingOrderID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mappingOrderID;
  
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
   *	OrderID数据库列名
   */
  public final static java.lang.String ORDERID_FIELD =  "OrderID";
  
  /**
   *	OrderID字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERID_LABLE = "订单编号";
  
  /**
   *	OrderID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orderID;
  
  /**
   *	PresentAmount数据库列名
   */
  public final static java.lang.String PRESENTAMOUNT_FIELD =  "PresentAmount";
  
  /**
   *	PresentAmount字段中文名，用于视图展示
   */
  public final static java.lang.String PRESENTAMOUNT_LABLE = "赠送金额";
  
  /**
   *	PresentAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal presentAmount;
  
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
   *	RecordID数据库列名
   */
  public final static java.lang.String RECORDID_FIELD =  "RecordID";
  
  /**
   *	RecordID字段中文名，用于视图展示
   */
  public final static java.lang.String RECORDID_LABLE = "记录编号";
  
  /**
   *	RecordID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long recordID;
  
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
  public final static java.lang.String SUBORDERID_LABLE = "子订单编号";
  
  /**
   *	SubOrderID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long subOrderID;
  
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
   * 授权人 getter
   */
  public java.lang.Long getAuthorizer(){
    return authorizer;
  }
  /**
   * 授权人 setter
   * @param Authorizer
   */  
  public void setAuthorizer(java.lang.Long authorizer){
    this.authorizer = authorizer;
  }
 
  /**
   * 授权时间 getter
   */
  public java.time.LocalDateTime getAuthorizeTime(){
    return authorizeTime;
  }
  /**
   * 授权时间 setter
   * @param AuthorizeTime
   */  
  public void setAuthorizeTime(java.time.LocalDateTime authorizeTime){
    this.authorizeTime = authorizeTime;
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
   * 客户备注 getter
   */
  public java.lang.String getCustomerMemo(){
    return customerMemo;
  }
  /**
   * 客户备注 setter
   * @param CustomerMemo
   */  
  public void setCustomerMemo(java.lang.String customerMemo){
    this.customerMemo = customerMemo;
  }
 
  /**
   * 减免金额 getter
   */
  public java.math.BigDecimal getDiscountAmount(){
    return discountAmount;
  }
  /**
   * 减免金额 setter
   * @param DiscountAmount
   */  
  public void setDiscountAmount(java.math.BigDecimal discountAmount){
    this.discountAmount = discountAmount;
  }
 
  /**
   * 折扣编号 getter
   */
  public java.lang.Long getDiscountID(){
    return discountID;
  }
  /**
   * 折扣编号 setter
   * @param DiscountID
   */  
  public void setDiscountID(java.lang.Long discountID){
    this.discountID = discountID;
  }
 
  /**
   * 折扣比率 getter
   */
  public java.lang.Float getDiscountPercentage(){
    return discountPercentage;
  }
  /**
   * 折扣比率 setter
   * @param DiscountPercentage
   */  
  public void setDiscountPercentage(java.lang.Float discountPercentage){
    this.discountPercentage = discountPercentage;
  }
 
  /**
   * 折扣类别 getter
   */
  public java.lang.Long getDiscountType(){
    return discountType;
  }
  /**
   * 折扣类别 setter
   * @param DiscountType
   */  
  public void setDiscountType(java.lang.Long discountType){
    this.discountType = discountType;
  }
 
  /**
   * 是否人工处理 getter
   */
  public java.lang.Boolean getIsManualProcess(){
    return isManualProcess;
  }
  /**
   * 是否人工处理 setter
   * @param IsManualProcess
   */  
  public void setIsManualProcess(java.lang.Boolean isManualProcess){
    this.isManualProcess = isManualProcess;
  }
 
  /**
   * 是否比率 getter
   */
  public java.lang.Boolean getIsRatio(){
    return isRatio;
  }
  /**
   * 是否比率 setter
   * @param IsRatio
   */  
  public void setIsRatio(java.lang.Boolean isRatio){
    this.isRatio = isRatio;
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
   * 关联描述 getter
   */
  public java.lang.String getMappingDesc(){
    return mappingDesc;
  }
  /**
   * 关联描述 setter
   * @param MappingDesc
   */  
  public void setMappingDesc(java.lang.String mappingDesc){
    this.mappingDesc = mappingDesc;
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
   * MappingOrderID getter
   */
  public java.lang.Long getMappingOrderID(){
    return mappingOrderID;
  }
  /**
   * MappingOrderID setter
   * @param MappingOrderID
   */  
  public void setMappingOrderID(java.lang.Long mappingOrderID){
    this.mappingOrderID = mappingOrderID;
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
   * 订单编号 getter
   */
  public java.lang.Long getOrderID(){
    return orderID;
  }
  /**
   * 订单编号 setter
   * @param OrderID
   */  
  public void setOrderID(java.lang.Long orderID){
    this.orderID = orderID;
  }
 
  /**
   * 赠送金额 getter
   */
  public java.math.BigDecimal getPresentAmount(){
    return presentAmount;
  }
  /**
   * 赠送金额 setter
   * @param PresentAmount
   */  
  public void setPresentAmount(java.math.BigDecimal presentAmount){
    this.presentAmount = presentAmount;
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
   * 记录编号 getter
   */
  public java.lang.Long getRecordID(){
    return recordID;
  }
  /**
   * 记录编号 setter
   * @param RecordID
   */  
  public void setRecordID(java.lang.Long recordID){
    this.recordID = recordID;
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
   * 子订单编号 getter
   */
  public java.lang.Long getSubOrderID(){
    return subOrderID;
  }
  /**
   * 子订单编号 setter
   * @param SubOrderID
   */  
  public void setSubOrderID(java.lang.Long subOrderID){
    this.subOrderID = subOrderID;
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