package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_DictionaryCatalogInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_DictionaryCatalogInfoEntityBase  extends Entity{

  /**
   *	ArchiveID数据库列名
   */
  public final static String ARCHIVEID_FIELD =  "ArchiveID";
  
  /**
   *	ArchiveID字段中文名，用于视图展示
   */
  public final static String ARCHIVEID_LABLE = "档案编号";
  
  /**
   *	ArchiveID对应的java字段名,业务操作使用这个字段。
   */
  private Long archiveID;
  
  /**
   *	CatalogCode数据库列名
   */
  public final static String CATALOGCODE_FIELD =  "CatalogCode";
  
  /**
   *	CatalogCode字段中文名，用于视图展示
   */
  public final static String CATALOGCODE_LABLE = "目录编码";
  
  /**
   *	CatalogCode对应的java字段名,业务操作使用这个字段。
   */
  private String catalogCode;
  
  /**
   *	CatalogDesc数据库列名
   */
  public final static String CATALOGDESC_FIELD =  "CatalogDesc";
  
  /**
   *	CatalogDesc字段中文名，用于视图展示
   */
  public final static String CATALOGDESC_LABLE = "描述";
  
  /**
   *	CatalogDesc对应的java字段名,业务操作使用这个字段。
   */
  private String catalogDesc;
  
  /**
   *	CatalogID数据库列名
   */
  public final static String CATALOGID_FIELD =  "CatalogID";
  
  /**
   *	CatalogID字段中文名，用于视图展示
   */
  public final static String CATALOGID_LABLE = "目录编号";
  
  /**
   *	CatalogID对应的java字段名,业务操作使用这个字段。
   */
  private Long catalogID;
  
  /**
   *	CatalogName数据库列名
   */
  public final static String CATALOGNAME_FIELD =  "CatalogName";
  
  /**
   *	CatalogName字段中文名，用于视图展示
   */
  public final static String CATALOGNAME_LABLE = "名称";
  
  /**
   *	CatalogName对应的java字段名,业务操作使用这个字段。
   */
  private String catalogName;
  
  /**
   *	CatalogStatus数据库列名
   */
  public final static String CATALOGSTATUS_FIELD =  "CatalogStatus";
  
  /**
   *	CatalogStatus字段中文名，用于视图展示
   */
  public final static String CATALOGSTATUS_LABLE = "状态";
  
  /**
   *	CatalogStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long catalogStatus;
  
  /**
   *	CreateTime数据库列名
   */
  public final static String CREATETIME_FIELD =  "CreateTime";
  
  /**
   *	CreateTime字段中文名，用于视图展示
   */
  public final static String CREATETIME_LABLE = "创建时间";
  
  /**
   *	CreateTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime createTime;
  
  /**
   *	CreatorID数据库列名
   */
  public final static String CREATORID_FIELD =  "CreatorID";
  
  /**
   *	CreatorID字段中文名，用于视图展示
   */
  public final static String CREATORID_LABLE = "创建人";
  
  /**
   *	CreatorID对应的java字段名,业务操作使用这个字段。
   */
  private Long creatorID;
  
  /**
   *	IsSync数据库列名
   */
  public final static String ISSYNC_FIELD =  "IsSync";
  
  /**
   *	IsSync字段中文名，用于视图展示
   */
  public final static String ISSYNC_LABLE = "是否同步";
  
  /**
   *	IsSync对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isSync;
  
  /**
   *	Memo数据库列名
   */
  public final static String MEMO_FIELD =  "Memo";
  
  /**
   *	Memo字段中文名，用于视图展示
   */
  public final static String MEMO_LABLE = "备注";
  
  /**
   *	Memo对应的java字段名,业务操作使用这个字段。
   */
  private String memo;
  
  /**
   *	ParentID数据库列名
   */
  public final static String PARENTID_FIELD =  "ParentID";
  
  /**
   *	ParentID字段中文名，用于视图展示
   */
  public final static String PARENTID_LABLE = "上级编号";
  
  /**
   *	ParentID对应的java字段名,业务操作使用这个字段。
   */
  private Long parentID;
  
  /**
   *	RelationInfo数据库列名
   */
  public final static String RELATIONINFO_FIELD =  "RelationInfo";
  
  /**
   *	RelationInfo字段中文名，用于视图展示
   */
  public final static String RELATIONINFO_LABLE = "关联信息";
  
  /**
   *	RelationInfo对应的java字段名,业务操作使用这个字段。
   */
  private String relationInfo;
  
  /**
   *	ShortName数据库列名
   */
  public final static String SHORTNAME_FIELD =  "ShortName";
  
  /**
   *	ShortName字段中文名，用于视图展示
   */
  public final static String SHORTNAME_LABLE = "简称";
  
  /**
   *	ShortName对应的java字段名,业务操作使用这个字段。
   */
  private String shortName;
  
  /**
   *	TreeID数据库列名
   */
  public final static String TREEID_FIELD =  "TreeID";
  
  /**
   *	TreeID字段中文名，用于视图展示
   */
  public final static String TREEID_LABLE = "树结构编号";
  
  /**
   *	TreeID对应的java字段名,业务操作使用这个字段。
   */
  private String treeID;
  
  /**
   * 档案编号 getter
   */
  public Long getArchiveID(){
    return archiveID;
  }
  /**
   * 档案编号 setter
   * @param archiveID
   */  
  public void setArchiveID(Long archiveID){
    this.archiveID = archiveID;
  }
 
  /**
   * 目录编码 getter
   */
  public String getCatalogCode(){
    return catalogCode;
  }
  /**
   * 目录编码 setter
   * @param catalogCode
   */  
  public void setCatalogCode(String catalogCode){
    this.catalogCode = catalogCode;
  }
 
  /**
   * 描述 getter
   */
  public String getCatalogDesc(){
    return catalogDesc;
  }
  /**
   * 描述 setter
   * @param catalogDesc
   */  
  public void setCatalogDesc(String catalogDesc){
    this.catalogDesc = catalogDesc;
  }
 
  /**
   * 目录编号 getter
   */
  public Long getCatalogID(){
    return catalogID;
  }
  /**
   * 目录编号 setter
   * @param catalogID
   */  
  public void setCatalogID(Long catalogID){
    this.catalogID = catalogID;
  }
 
  /**
   * 名称 getter
   */
  public String getCatalogName(){
    return catalogName;
  }
  /**
   * 名称 setter
   * @param catalogName
   */  
  public void setCatalogName(String catalogName){
    this.catalogName = catalogName;
  }
 
  /**
   * 状态 getter
   */
  public Long getCatalogStatus(){
    return catalogStatus;
  }
  /**
   * 状态 setter
   * @param catalogStatus
   */  
  public void setCatalogStatus(Long catalogStatus){
    this.catalogStatus = catalogStatus;
  }
 
  /**
   * 创建时间 getter
   */
  public java.time.LocalDateTime getCreateTime(){
    return createTime;
  }
  /**
   * 创建时间 setter
   * @param createTime
   */  
  public void setCreateTime(java.time.LocalDateTime createTime){
    this.createTime = createTime;
  }
 
  /**
   * 创建人 getter
   */
  public Long getCreatorID(){
    return creatorID;
  }
  /**
   * 创建人 setter
   * @param creatorID
   */  
  public void setCreatorID(Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * 是否同步 getter
   */
  public Boolean getIsSync(){
    return isSync;
  }
  /**
   * 是否同步 setter
   * @param isSync
   */  
  public void setIsSync(Boolean isSync){
    this.isSync = isSync;
  }
 
  /**
   * 备注 getter
   */
  public String getMemo(){
    return memo;
  }
  /**
   * 备注 setter
   * @param memo
   */  
  public void setMemo(String memo){
    this.memo = memo;
  }
 
  /**
   * 上级编号 getter
   */
  public Long getParentID(){
    return parentID;
  }
  /**
   * 上级编号 setter
   * @param parentID
   */  
  public void setParentID(Long parentID){
    this.parentID = parentID;
  }
 
  /**
   * 关联信息 getter
   */
  public String getRelationInfo(){
    return relationInfo;
  }
  /**
   * 关联信息 setter
   * @param relationInfo
   */  
  public void setRelationInfo(String relationInfo){
    this.relationInfo = relationInfo;
  }
 
  /**
   * 简称 getter
   */
  public String getShortName(){
    return shortName;
  }
  /**
   * 简称 setter
   * @param shortName
   */  
  public void setShortName(String shortName){
    this.shortName = shortName;
  }
 
  /**
   * 树结构编号 getter
   */
  public String getTreeID(){
    return treeID;
  }
  /**
   * 树结构编号 setter
   * @param treeID
   */  
  public void setTreeID(String treeID){
    this.treeID = treeID;
  }
 
}