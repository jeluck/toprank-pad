package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_DutyInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_DutyInfoEntityBase extends Entity {

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
   *	DutyCode数据库列名
   */
  public final static String DUTYCODE_FIELD =  "DutyCode";
  
  /**
   *	DutyCode字段中文名，用于视图展示
   */
  public final static String DUTYCODE_LABLE = "排班编码";
  
  /**
   *	DutyCode对应的java字段名,业务操作使用这个字段。
   */
  private String dutyCode;
  
  /**
   *	DutyDay数据库列名
   */
  public final static String DUTYDAY_FIELD =  "DutyDay";
  
  /**
   *	DutyDay字段中文名，用于视图展示
   */
  public final static String DUTYDAY_LABLE = "值班日期";
  
  /**
   *	DutyDay对应的java字段名,业务操作使用这个字段。
   */
  private String dutyDay;
  
  /**
   *	DutyID数据库列名
   */
  public final static String DUTYID_FIELD =  "DutyID";
  
  /**
   *	DutyID字段中文名，用于视图展示
   */
  public final static String DUTYID_LABLE = "排班编号";
  
  /**
   *	DutyID对应的java字段名,业务操作使用这个字段。
   */
  private Long dutyID;
  
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
   *	LoginID数据库列名
   */
  public final static String LOGINID_FIELD =  "LoginID";
  
  /**
   *	LoginID字段中文名，用于视图展示
   */
  public final static String LOGINID_LABLE = "登录编号";
  
  /**
   *	LoginID对应的java字段名,业务操作使用这个字段。
   */
  private Long loginID;
  
  /**
   *	ManageType数据库列名
   */
  public final static String MANAGETYPE_FIELD =  "ManageType";
  
  /**
   *	ManageType字段中文名，用于视图展示
   */
  public final static String MANAGETYPE_LABLE = "负责类别";
  
  /**
   *	ManageType对应的java字段名,业务操作使用这个字段。
   */
  private Long manageType;
  
  /**
   *	MealsID数据库列名
   */
  public final static String MEALSID_FIELD =  "MealsID";
  
  /**
   *	MealsID字段中文名，用于视图展示
   */
  public final static String MEALSID_LABLE = "餐次编号";
  
  /**
   *	MealsID对应的java字段名,业务操作使用这个字段。
   */
  private Long mealsID;
  
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
   *	RoleDesc数据库列名
   */
  public final static String ROLEDESC_FIELD =  "RoleDesc";
  
  /**
   *	RoleDesc字段中文名，用于视图展示
   */
  public final static String ROLEDESC_LABLE = "职责描述";
  
  /**
   *	RoleDesc对应的java字段名,业务操作使用这个字段。
   */
  private String roleDesc;
  
  /**
   *	RoleID数据库列名
   */
  public final static String ROLEID_FIELD =  "RoleID";
  
  /**
   *	RoleID字段中文名，用于视图展示
   */
  public final static String ROLEID_LABLE = "岗位编号";
  
  /**
   *	RoleID对应的java字段名,业务操作使用这个字段。
   */
  private Long roleID;
  
  /**
   *	RoleName数据库列名
   */
  public final static String ROLENAME_FIELD =  "RoleName";
  
  /**
   *	RoleName字段中文名，用于视图展示
   */
  public final static String ROLENAME_LABLE = "岗位名称";
  
  /**
   *	RoleName对应的java字段名,业务操作使用这个字段。
   */
  private String roleName;
  
  /**
   *	ServiceAnswerType数据库列名
   */
  public final static String SERVICEANSWERTYPE_FIELD =  "ServiceAnswerType";
  
  /**
   *	ServiceAnswerType字段中文名，用于视图展示
   */
  public final static String SERVICEANSWERTYPE_LABLE = "响应类别";
  
  /**
   *	ServiceAnswerType对应的java字段名,业务操作使用这个字段。
   */
  private Long serviceAnswerType;
  
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
   * 排班编码 getter
   */
  public String getDutyCode(){
    return dutyCode;
  }
  /**
   * 排班编码 setter
   * @param DutyCode
   */  
  public void setDutyCode(String dutyCode){
    this.dutyCode = dutyCode;
  }
 
  /**
   * 值班日期 getter
   */
  public String getDutyDay(){
    return dutyDay;
  }
  /**
   * 值班日期 setter
   * @param DutyDay
   */  
  public void setDutyDay(String dutyDay){
    this.dutyDay = dutyDay;
  }
 
  /**
   * 排班编号 getter
   */
  public Long getDutyID(){
    return dutyID;
  }
  /**
   * 排班编号 setter
   * @param DutyID
   */  
  public void setDutyID(Long dutyID){
    this.dutyID = dutyID;
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
   * 登录编号 getter
   */
  public Long getLoginID(){
    return loginID;
  }
  /**
   * 登录编号 setter
   * @param LoginID
   */  
  public void setLoginID(Long loginID){
    this.loginID = loginID;
  }
 
  /**
   * 负责类别 getter
   */
  public Long getManageType(){
    return manageType;
  }
  /**
   * 负责类别 setter
   * @param ManageType
   */  
  public void setManageType(Long manageType){
    this.manageType = manageType;
  }
 
  /**
   * 餐次编号 getter
   */
  public Long getMealsID(){
    return mealsID;
  }
  /**
   * 餐次编号 setter
   * @param MealsID
   */  
  public void setMealsID(Long mealsID){
    this.mealsID = mealsID;
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
   * 职责描述 getter
   */
  public String getRoleDesc(){
    return roleDesc;
  }
  /**
   * 职责描述 setter
   * @param RoleDesc
   */  
  public void setRoleDesc(String roleDesc){
    this.roleDesc = roleDesc;
  }
 
  /**
   * 岗位编号 getter
   */
  public Long getRoleID(){
    return roleID;
  }
  /**
   * 岗位编号 setter
   * @param RoleID
   */  
  public void setRoleID(Long roleID){
    this.roleID = roleID;
  }
 
  /**
   * 岗位名称 getter
   */
  public String getRoleName(){
    return roleName;
  }
  /**
   * 岗位名称 setter
   * @param RoleName
   */  
  public void setRoleName(String roleName){
    this.roleName = roleName;
  }
 
  /**
   * 响应类别 getter
   */
  public Long getServiceAnswerType(){
    return serviceAnswerType;
  }
  /**
   * 响应类别 setter
   * @param ServiceAnswerType
   */  
  public void setServiceAnswerType(Long serviceAnswerType){
    this.serviceAnswerType = serviceAnswerType;
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
 
}