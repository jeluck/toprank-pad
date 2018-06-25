package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_CategoryAttributeInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_CategoryAttributeInfoEntityBase extends Entity {

  /**
   *	ArchiveID数据库列名
   */
  public final static java.lang.String ARCHIVEID_FIELD =  "ArchiveID";
  
  /**
   *	ArchiveID字段中文名，用于视图展示
   */
  public final static java.lang.String ARCHIVEID_LABLE = "ArchiveID";
  
  /**
   *	ArchiveID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long archiveID;
  
  /**
   *	AttributeCode数据库列名
   */
  public final static java.lang.String ATTRIBUTECODE_FIELD =  "AttributeCode";
  
  /**
   *	AttributeCode字段中文名，用于视图展示
   */
  public final static java.lang.String ATTRIBUTECODE_LABLE = "属性编码";
  
  /**
   *	AttributeCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String attributeCode;
  
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
   *	AttributeStatus数据库列名
   */
  public final static java.lang.String ATTRIBUTESTATUS_FIELD =  "AttributeStatus";
  
  /**
   *	AttributeStatus字段中文名，用于视图展示
   */
  public final static java.lang.String ATTRIBUTESTATUS_LABLE = "属性状态";
  
  /**
   *	AttributeStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long attributeStatus;
  
  /**
   *	CategoryID数据库列名
   */
  public final static java.lang.String CATEGORYID_FIELD =  "CategoryID";
  
  /**
   *	CategoryID字段中文名，用于视图展示
   */
  public final static java.lang.String CATEGORYID_LABLE = "类别编号";
  
  /**
   *	CategoryID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long categoryID;
  
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
   *	GroupID数据库列名
   */
  public final static java.lang.String GROUPID_FIELD =  "GroupID";
  
  /**
   *	GroupID字段中文名，用于视图展示
   */
  public final static java.lang.String GROUPID_LABLE = "分组编号";
  
  /**
   *	GroupID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long groupID;
  
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
   * ArchiveID getter
   */
  public java.lang.Long getArchiveID(){
    return archiveID;
  }
  /**
   * ArchiveID setter
   * @param ArchiveID
   */  
  public void setArchiveID(java.lang.Long archiveID){
    this.archiveID = archiveID;
  }
 
  /**
   * 属性编码 getter
   */
  public java.lang.String getAttributeCode(){
    return attributeCode;
  }
  /**
   * 属性编码 setter
   * @param AttributeCode
   */  
  public void setAttributeCode(java.lang.String attributeCode){
    this.attributeCode = attributeCode;
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
   * 属性状态 getter
   */
  public java.lang.Long getAttributeStatus(){
    return attributeStatus;
  }
  /**
   * 属性状态 setter
   * @param AttributeStatus
   */  
  public void setAttributeStatus(java.lang.Long attributeStatus){
    this.attributeStatus = attributeStatus;
  }
 
  /**
   * 类别编号 getter
   */
  public java.lang.Long getCategoryID(){
    return categoryID;
  }
  /**
   * 类别编号 setter
   * @param CategoryID
   */  
  public void setCategoryID(java.lang.Long categoryID){
    this.categoryID = categoryID;
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
   * 分组编号 getter
   */
  public java.lang.Long getGroupID(){
    return groupID;
  }
  /**
   * 分组编号 setter
   * @param GroupID
   */  
  public void setGroupID(java.lang.Long groupID){
    this.groupID = groupID;
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