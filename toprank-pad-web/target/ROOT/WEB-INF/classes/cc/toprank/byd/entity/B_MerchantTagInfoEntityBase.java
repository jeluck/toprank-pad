package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_MerchantTagInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_MerchantTagInfoEntityBase extends Entity {

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
   *	IsPlatform数据库列名
   */
  public final static java.lang.String ISPLATFORM_FIELD =  "IsPlatform";
  
  /**
   *	IsPlatform字段中文名，用于视图展示
   */
  public final static java.lang.String ISPLATFORM_LABLE = "平台标签";
  
  /**
   *	IsPlatform对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isPlatform;
  
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
   *	TagCode数据库列名
   */
  public final static java.lang.String TAGCODE_FIELD =  "TagCode";
  
  /**
   *	TagCode字段中文名，用于视图展示
   */
  public final static java.lang.String TAGCODE_LABLE = "标签编码";
  
  /**
   *	TagCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String tagCode;
  
  /**
   *	TagDesc数据库列名
   */
  public final static java.lang.String TAGDESC_FIELD =  "TagDesc";
  
  /**
   *	TagDesc字段中文名，用于视图展示
   */
  public final static java.lang.String TAGDESC_LABLE = "标签描述";
  
  /**
   *	TagDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String tagDesc;
  
  /**
   *	TagID数据库列名
   */
  public final static java.lang.String TAGID_FIELD =  "TagID";
  
  /**
   *	TagID字段中文名，用于视图展示
   */
  public final static java.lang.String TAGID_LABLE = "标签编号";
  
  /**
   *	TagID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long tagID;
  
  /**
   *	TagName数据库列名
   */
  public final static java.lang.String TAGNAME_FIELD =  "TagName";
  
  /**
   *	TagName字段中文名，用于视图展示
   */
  public final static java.lang.String TAGNAME_LABLE = "标签名称";
  
  /**
   *	TagName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String tagName;
  
  /**
   *	TagStatus数据库列名
   */
  public final static java.lang.String TAGSTATUS_FIELD =  "TagStatus";
  
  /**
   *	TagStatus字段中文名，用于视图展示
   */
  public final static java.lang.String TAGSTATUS_LABLE = "标签状态";
  
  /**
   *	TagStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long tagStatus;
  
  /**
   *	TagType数据库列名
   */
  public final static java.lang.String TAGTYPE_FIELD =  "TagType";
  
  /**
   *	TagType字段中文名，用于视图展示
   */
  public final static java.lang.String TAGTYPE_LABLE = "标签类型";
  
  /**
   *	TagType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long tagType;
  
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
   * 平台标签 getter
   */
  public java.lang.Boolean getIsPlatform(){
    return isPlatform;
  }
  /**
   * 平台标签 setter
   * @param IsPlatform
   */  
  public void setIsPlatform(java.lang.Boolean isPlatform){
    this.isPlatform = isPlatform;
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
 
  /**
   * 标签编码 getter
   */
  public java.lang.String getTagCode(){
    return tagCode;
  }
  /**
   * 标签编码 setter
   * @param TagCode
   */  
  public void setTagCode(java.lang.String tagCode){
    this.tagCode = tagCode;
  }
 
  /**
   * 标签描述 getter
   */
  public java.lang.String getTagDesc(){
    return tagDesc;
  }
  /**
   * 标签描述 setter
   * @param TagDesc
   */  
  public void setTagDesc(java.lang.String tagDesc){
    this.tagDesc = tagDesc;
  }
 
  /**
   * 标签编号 getter
   */
  public java.lang.Long getTagID(){
    return tagID;
  }
  /**
   * 标签编号 setter
   * @param TagID
   */  
  public void setTagID(java.lang.Long tagID){
    this.tagID = tagID;
  }
 
  /**
   * 标签名称 getter
   */
  public java.lang.String getTagName(){
    return tagName;
  }
  /**
   * 标签名称 setter
   * @param TagName
   */  
  public void setTagName(java.lang.String tagName){
    this.tagName = tagName;
  }
 
  /**
   * 标签状态 getter
   */
  public java.lang.Long getTagStatus(){
    return tagStatus;
  }
  /**
   * 标签状态 setter
   * @param TagStatus
   */  
  public void setTagStatus(java.lang.Long tagStatus){
    this.tagStatus = tagStatus;
  }
 
  /**
   * 标签类型 getter
   */
  public java.lang.Long getTagType(){
    return tagType;
  }
  /**
   * 标签类型 setter
   * @param TagType
   */  
  public void setTagType(java.lang.Long tagType){
    this.tagType = tagType;
  }
 
}