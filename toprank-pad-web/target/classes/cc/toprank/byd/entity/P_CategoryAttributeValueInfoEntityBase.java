package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_CategoryAttributeValueInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_CategoryAttributeValueInfoEntityBase extends Entity {

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
   *	AttributeDesc数据库列名
   */
  public final static java.lang.String ATTRIBUTEDESC_FIELD =  "AttributeDesc";
  
  /**
   *	AttributeDesc字段中文名，用于视图展示
   */
  public final static java.lang.String ATTRIBUTEDESC_LABLE = "属性描述";
  
  /**
   *	AttributeDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String attributeDesc;
  
  /**
   *	AttributeID数据库列名
   */
  public final static java.lang.String ATTRIBUTEID_FIELD =  "AttributeID";
  
  /**
   *	AttributeID字段中文名，用于视图展示
   */
  public final static java.lang.String ATTRIBUTEID_LABLE = "属性编号";
  
  /**
   *	AttributeID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long attributeID;
  
  /**
   *	AttributeName数据库列名
   */
  public final static java.lang.String ATTRIBUTENAME_FIELD =  "AttributeName";
  
  /**
   *	AttributeName字段中文名，用于视图展示
   */
  public final static java.lang.String ATTRIBUTENAME_LABLE = "属性名称";
  
  /**
   *	AttributeName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String attributeName;
  
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
   *	AttributeValueStatus数据库列名
   */
  public final static java.lang.String ATTRIBUTEVALUESTATUS_FIELD =  "AttributeValueStatus";
  
  /**
   *	AttributeValueStatus字段中文名，用于视图展示
   */
  public final static java.lang.String ATTRIBUTEVALUESTATUS_LABLE = "属性值状态";
  
  /**
   *	AttributeValueStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long attributeValueStatus;
  
  /**
   *	CanMulti数据库列名
   */
  public final static java.lang.String CANMULTI_FIELD =  "CanMulti";
  
  /**
   *	CanMulti字段中文名，用于视图展示
   */
  public final static java.lang.String CANMULTI_LABLE = "可否多选";
  
  /**
   *	CanMulti对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean canMulti;
  
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
   *	ValueCode数据库列名
   */
  public final static java.lang.String VALUECODE_FIELD =  "ValueCode";
  
  /**
   *	ValueCode字段中文名，用于视图展示
   */
  public final static java.lang.String VALUECODE_LABLE = "属性值编码";
  
  /**
   *	ValueCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String valueCode;
  
  /**
   *	ValueDesc数据库列名
   */
  public final static java.lang.String VALUEDESC_FIELD =  "ValueDesc";
  
  /**
   *	ValueDesc字段中文名，用于视图展示
   */
  public final static java.lang.String VALUEDESC_LABLE = "属性值描述";
  
  /**
   *	ValueDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String valueDesc;
  
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
   * 属性描述 getter
   */
  public java.lang.String getAttributeDesc(){
    return attributeDesc;
  }
  /**
   * 属性描述 setter
   * @param AttributeDesc
   */  
  public void setAttributeDesc(java.lang.String attributeDesc){
    this.attributeDesc = attributeDesc;
  }
 
  /**
   * 属性编号 getter
   */
  public java.lang.Long getAttributeID(){
    return attributeID;
  }
  /**
   * 属性编号 setter
   * @param AttributeID
   */  
  public void setAttributeID(java.lang.Long attributeID){
    this.attributeID = attributeID;
  }
 
  /**
   * 属性名称 getter
   */
  public java.lang.String getAttributeName(){
    return attributeName;
  }
  /**
   * 属性名称 setter
   * @param AttributeName
   */  
  public void setAttributeName(java.lang.String attributeName){
    this.attributeName = attributeName;
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
   * 属性值状态 getter
   */
  public java.lang.Long getAttributeValueStatus(){
    return attributeValueStatus;
  }
  /**
   * 属性值状态 setter
   * @param AttributeValueStatus
   */  
  public void setAttributeValueStatus(java.lang.Long attributeValueStatus){
    this.attributeValueStatus = attributeValueStatus;
  }
 
  /**
   * 可否多选 getter
   */
  public java.lang.Boolean getCanMulti(){
    return canMulti;
  }
  /**
   * 可否多选 setter
   * @param CanMulti
   */  
  public void setCanMulti(java.lang.Boolean canMulti){
    this.canMulti = canMulti;
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
   * 属性值编码 getter
   */
  public java.lang.String getValueCode(){
    return valueCode;
  }
  /**
   * 属性值编码 setter
   * @param ValueCode
   */  
  public void setValueCode(java.lang.String valueCode){
    this.valueCode = valueCode;
  }
 
  /**
   * 属性值描述 getter
   */
  public java.lang.String getValueDesc(){
    return valueDesc;
  }
  /**
   * 属性值描述 setter
   * @param ValueDesc
   */  
  public void setValueDesc(java.lang.String valueDesc){
    this.valueDesc = valueDesc;
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