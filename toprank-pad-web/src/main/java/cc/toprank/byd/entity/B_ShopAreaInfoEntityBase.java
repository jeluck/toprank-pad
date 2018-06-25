package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_ShopAreaInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_ShopAreaInfoEntityBase extends Entity {

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
   *	AreaCode数据库列名
   */
  public final static String AREACODE_FIELD =  "AreaCode";
  
  /**
   *	AreaCode字段中文名，用于视图展示
   */
  public final static String AREACODE_LABLE = "区域编码";
  
  /**
   *	AreaCode对应的java字段名,业务操作使用这个字段。
   */
  private String areaCode;
  
  /**
   *	AreaDesc数据库列名
   */
  public final static String AREADESC_FIELD =  "AreaDesc";
  
  /**
   *	AreaDesc字段中文名，用于视图展示
   */
  public final static String AREADESC_LABLE = "区域描述";
  
  /**
   *	AreaDesc对应的java字段名,业务操作使用这个字段。
   */
  private String areaDesc;
  
  /**
   *	AreaID数据库列名
   */
  public final static String AREAID_FIELD =  "AreaID";
  
  /**
   *	AreaID字段中文名，用于视图展示
   */
  public final static String AREAID_LABLE = "区域编号";
  
  /**
   *	AreaID对应的java字段名,业务操作使用这个字段。
   */
  private Long areaID;
  
  /**
   *	AreaName数据库列名
   */
  public final static String AREANAME_FIELD =  "AreaName";
  
  /**
   *	AreaName字段中文名，用于视图展示
   */
  public final static String AREANAME_LABLE = "区域名称";
  
  /**
   *	AreaName对应的java字段名,业务操作使用这个字段。
   */
  private String areaName;
  
  /**
   *	AreaStatus数据库列名
   */
  public final static String AREASTATUS_FIELD =  "AreaStatus";
  
  /**
   *	AreaStatus字段中文名，用于视图展示
   */
  public final static String AREASTATUS_LABLE = "区域状态";
  
  /**
   *	AreaStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long areaStatus;
  
  /**
   *	AreaType数据库列名
   */
  public final static String AREATYPE_FIELD =  "AreaType";
  
  /**
   *	AreaType字段中文名，用于视图展示
   */
  public final static String AREATYPE_LABLE = "区域类型";
  
  /**
   *	AreaType对应的java字段名,业务操作使用这个字段。
   */
  private Long areaType;
  
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
   *	IsBooking数据库列名
   */
  public final static String ISBOOKING_FIELD =  "IsBooking";
  
  /**
   *	IsBooking字段中文名，用于视图展示
   */
  public final static String ISBOOKING_LABLE = "可否预订";
  
  /**
   *	IsBooking对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isBooking;
  
  /**
   *	IsDefault数据库列名
   */
  public final static String ISDEFAULT_FIELD =  "IsDefault";
  
  /**
   *	IsDefault字段中文名，用于视图展示
   */
  public final static String ISDEFAULT_LABLE = "是否默认";
  
  /**
   *	IsDefault对应的java字段名,业务操作使用这个字段。
   */
  private Long isDefault;
  
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
   *	LocationCode数据库列名
   */
  public final static String LOCATIONCODE_FIELD =  "LocationCode";
  
  /**
   *	LocationCode字段中文名，用于视图展示
   */
  public final static String LOCATIONCODE_LABLE = "定位编码";
  
  /**
   *	LocationCode对应的java字段名,业务操作使用这个字段。
   */
  private String locationCode;
  
  /**
   *	LocationDesc数据库列名
   */
  public final static String LOCATIONDESC_FIELD =  "LocationDesc";
  
  /**
   *	LocationDesc字段中文名，用于视图展示
   */
  public final static String LOCATIONDESC_LABLE = "位置描述";
  
  /**
   *	LocationDesc对应的java字段名,业务操作使用这个字段。
   */
  private String locationDesc;
  
  /**
   *	ManagerID数据库列名
   */
  public final static String MANAGERID_FIELD =  "ManagerID";
  
  /**
   *	ManagerID字段中文名，用于视图展示
   */
  public final static String MANAGERID_LABLE = "负责人编号";
  
  /**
   *	ManagerID对应的java字段名,业务操作使用这个字段。
   */
  private Long managerID;
  
  /**
   *	ManagerName数据库列名
   */
  public final static String MANAGERNAME_FIELD =  "ManagerName";
  
  /**
   *	ManagerName字段中文名，用于视图展示
   */
  public final static String MANAGERNAME_LABLE = "负责人名称";
  
  /**
   *	ManagerName对应的java字段名,业务操作使用这个字段。
   */
  private String managerName;
  
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
   *	OrgID数据库列名
   */
  public final static String ORGID_FIELD =  "OrgID";
  
  /**
   *	OrgID字段中文名，用于视图展示
   */
  public final static String ORGID_LABLE = "机构编号";
  
  /**
   *	OrgID对应的java字段名,业务操作使用这个字段。
   */
  private Long orgID;
  
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
   *	SortNo数据库列名
   */
  public final static String SORTNO_FIELD =  "SortNo";
  
  /**
   *	SortNo字段中文名，用于视图展示
   */
  public final static String SORTNO_LABLE = "序号";
  
  /**
   *	SortNo对应的java字段名,业务操作使用这个字段。
   */
  private Integer sortNo;
  
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
   * @param ArchiveID
   */  
  public void setArchiveID(Long archiveID){
    this.archiveID = archiveID;
  }
 
  /**
   * 区域编码 getter
   */
  public String getAreaCode(){
    return areaCode;
  }
  /**
   * 区域编码 setter
   * @param AreaCode
   */  
  public void setAreaCode(String areaCode){
    this.areaCode = areaCode;
  }
 
  /**
   * 区域描述 getter
   */
  public String getAreaDesc(){
    return areaDesc;
  }
  /**
   * 区域描述 setter
   * @param AreaDesc
   */  
  public void setAreaDesc(String areaDesc){
    this.areaDesc = areaDesc;
  }
 
  /**
   * 区域编号 getter
   */
  public Long getAreaID(){
    return areaID;
  }
  /**
   * 区域编号 setter
   * @param AreaID
   */  
  public void setAreaID(Long areaID){
    this.areaID = areaID;
  }
 
  /**
   * 区域名称 getter
   */
  public String getAreaName(){
    return areaName;
  }
  /**
   * 区域名称 setter
   * @param AreaName
   */  
  public void setAreaName(String areaName){
    this.areaName = areaName;
  }
 
  /**
   * 区域状态 getter
   */
  public Long getAreaStatus(){
    return areaStatus;
  }
  /**
   * 区域状态 setter
   * @param AreaStatus
   */  
  public void setAreaStatus(Long areaStatus){
    this.areaStatus = areaStatus;
  }
 
  /**
   * 区域类型 getter
   */
  public Long getAreaType(){
    return areaType;
  }
  /**
   * 区域类型 setter
   * @param AreaType
   */  
  public void setAreaType(Long areaType){
    this.areaType = areaType;
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
  public Long getCreatorID(){
    return creatorID;
  }
  /**
   * 创建人 setter
   * @param CreatorID
   */  
  public void setCreatorID(Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * 可否预订 getter
   */
  public Boolean getIsBooking(){
    return isBooking;
  }
  /**
   * 可否预订 setter
   * @param IsBooking
   */  
  public void setIsBooking(Boolean isBooking){
    this.isBooking = isBooking;
  }
 
  /**
   * 是否默认 getter
   */
  public Long getIsDefault(){
    return isDefault;
  }
  /**
   * 是否默认 setter
   * @param IsDefault
   */  
  public void setIsDefault(Long isDefault){
    this.isDefault = isDefault;
  }
 
  /**
   * 是否同步 getter
   */
  public Boolean getIsSync(){
    return isSync;
  }
  /**
   * 是否同步 setter
   * @param IsSync
   */  
  public void setIsSync(Boolean isSync){
    this.isSync = isSync;
  }
 
  /**
   * 定位编码 getter
   */
  public String getLocationCode(){
    return locationCode;
  }
  /**
   * 定位编码 setter
   * @param LocationCode
   */  
  public void setLocationCode(String locationCode){
    this.locationCode = locationCode;
  }
 
  /**
   * 位置描述 getter
   */
  public String getLocationDesc(){
    return locationDesc;
  }
  /**
   * 位置描述 setter
   * @param LocationDesc
   */  
  public void setLocationDesc(String locationDesc){
    this.locationDesc = locationDesc;
  }
 
  /**
   * 负责人编号 getter
   */
  public Long getManagerID(){
    return managerID;
  }
  /**
   * 负责人编号 setter
   * @param ManagerID
   */  
  public void setManagerID(Long managerID){
    this.managerID = managerID;
  }
 
  /**
   * 负责人名称 getter
   */
  public String getManagerName(){
    return managerName;
  }
  /**
   * 负责人名称 setter
   * @param ManagerName
   */  
  public void setManagerName(String managerName){
    this.managerName = managerName;
  }
 
  /**
   * 备注 getter
   */
  public String getMemo(){
    return memo;
  }
  /**
   * 备注 setter
   * @param Memo
   */  
  public void setMemo(String memo){
    this.memo = memo;
  }
 
  /**
   * 机构编号 getter
   */
  public Long getOrgID(){
    return orgID;
  }
  /**
   * 机构编号 setter
   * @param OrgID
   */  
  public void setOrgID(Long orgID){
    this.orgID = orgID;
  }
 
  /**
   * 上级编号 getter
   */
  public Long getParentID(){
    return parentID;
  }
  /**
   * 上级编号 setter
   * @param ParentID
   */  
  public void setParentID(Long parentID){
    this.parentID = parentID;
  }
 
  /**
   * 序号 getter
   */
  public Integer getSortNo(){
    return sortNo;
  }
  /**
   * 序号 setter
   * @param SortNo
   */  
  public void setSortNo(Integer sortNo){
    this.sortNo = sortNo;
  }
 
  /**
   * 树结构编号 getter
   */
  public String getTreeID(){
    return treeID;
  }
  /**
   * 树结构编号 setter
   * @param TreeID
   */  
  public void setTreeID(String treeID){
    this.treeID = treeID;
  }
 
}