package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_ComboDetailValueMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_ComboDetailValueMappingEntityBase extends Entity {

  /**
   *	AddedPrice数据库列名
   */
  public final static java.lang.String ADDEDPRICE_FIELD =  "AddedPrice";
  
  /**
   *	AddedPrice字段中文名，用于视图展示
   */
  public final static java.lang.String ADDEDPRICE_LABLE = "加价";
  
  /**
   *	AddedPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal addedPrice;
  
  /**
   *	AttributeValue数据库列名
   */
  public final static java.lang.String ATTRIBUTEVALUE_FIELD =  "AttributeValue";
  
  /**
   *	AttributeValue字段中文名，用于视图展示
   */
  public final static java.lang.String ATTRIBUTEVALUE_LABLE = "属性值";
  
  /**
   *	AttributeValue对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String attributeValue;
  
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
   *	MappingStatus数据库列名
   */
  public final static java.lang.String MAPPINGSTATUS_FIELD =  "MappingStatus";
  
  /**
   *	MappingStatus字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGSTATUS_LABLE = "关联状态";
  
  /**
   *	MappingStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mappingStatus;
  
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
   *	ProduceMinute数据库列名
   */
  public final static java.lang.String PRODUCEMINUTE_FIELD =  "ProduceMinute";
  
  /**
   *	ProduceMinute字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCEMINUTE_LABLE = "制作时长";
  
  /**
   *	ProduceMinute对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer produceMinute;
  
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
   *	ValueID数据库列名
   */
  public final static java.lang.String VALUEID_FIELD =  "ValueID";
  
  /**
   *	ValueID字段中文名，用于视图展示
   */
  public final static java.lang.String VALUEID_LABLE = "属性值编号";
  
  /**
   *	ValueID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long valueID;
  
  /**
   * 加价 getter
   */
  public java.math.BigDecimal getAddedPrice(){
    return addedPrice;
  }
  /**
   * 加价 setter
   * @param AddedPrice
   */  
  public void setAddedPrice(java.math.BigDecimal addedPrice){
    this.addedPrice = addedPrice;
  }
 
  /**
   * 属性值 getter
   */
  public java.lang.String getAttributeValue(){
    return attributeValue;
  }
  /**
   * 属性值 setter
   * @param AttributeValue
   */  
  public void setAttributeValue(java.lang.String attributeValue){
    this.attributeValue = attributeValue;
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
   * 关联状态 getter
   */
  public java.lang.Long getMappingStatus(){
    return mappingStatus;
  }
  /**
   * 关联状态 setter
   * @param MappingStatus
   */  
  public void setMappingStatus(java.lang.Long mappingStatus){
    this.mappingStatus = mappingStatus;
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
   * 制作时长 getter
   */
  public java.lang.Integer getProduceMinute(){
    return produceMinute;
  }
  /**
   * 制作时长 setter
   * @param ProduceMinute
   */  
  public void setProduceMinute(java.lang.Integer produceMinute){
    this.produceMinute = produceMinute;
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
 
  /**
   * 属性值编号 getter
   */
  public java.lang.Long getValueID(){
    return valueID;
  }
  /**
   * 属性值编号 setter
   * @param ValueID
   */  
  public void setValueID(java.lang.Long valueID){
    this.valueID = valueID;
  }
 
}