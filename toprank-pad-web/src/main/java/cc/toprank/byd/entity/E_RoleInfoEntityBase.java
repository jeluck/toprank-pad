package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在E_RoleInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class E_RoleInfoEntityBase extends Entity {

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
   *	ExpMode数据库列名
   */
  public final static java.lang.String EXPMODE_FIELD =  "ExpMode";
  
  /**
   *	ExpMode字段中文名，用于视图展示
   */
  public final static java.lang.String EXPMODE_LABLE = "计算方式";
  
  /**
   *	ExpMode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long expMode;
  
  /**
   *	ExpPoint数据库列名
   */
  public final static java.lang.String EXPPOINT_FIELD =  "ExpPoint";
  
  /**
   *	ExpPoint字段中文名，用于视图展示
   */
  public final static java.lang.String EXPPOINT_LABLE = "经验值";
  
  /**
   *	ExpPoint对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer expPoint;
  
  /**
   *	IsValid数据库列名
   */
  public final static java.lang.String ISVALID_FIELD =  "IsValid";
  
  /**
   *	IsValid字段中文名，用于视图展示
   */
  public final static java.lang.String ISVALID_LABLE = "有效性标志";
  
  /**
   *	IsValid对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isValid;
  
  /**
   *	Keyword数据库列名
   */
  public final static java.lang.String KEYWORD_FIELD =  "Keyword";
  
  /**
   *	Keyword字段中文名，用于视图展示
   */
  public final static java.lang.String KEYWORD_LABLE = "关键字";
  
  /**
   *	Keyword对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String keyword;
  
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
   *	NextExp数据库列名
   */
  public final static java.lang.String NEXTEXP_FIELD =  "NextExp";
  
  /**
   *	NextExp字段中文名，用于视图展示
   */
  public final static java.lang.String NEXTEXP_LABLE = "下级经验值";
  
  /**
   *	NextExp对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer nextExp;
  
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
   *	ParentID数据库列名
   */
  public final static java.lang.String PARENTID_FIELD =  "ParentID";
  
  /**
   *	ParentID字段中文名，用于视图展示
   */
  public final static java.lang.String PARENTID_LABLE = "上级编号";
  
  /**
   *	ParentID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long parentID;
  
  /**
   *	RoleCode数据库列名
   */
  public final static java.lang.String ROLECODE_FIELD =  "RoleCode";
  
  /**
   *	RoleCode字段中文名，用于视图展示
   */
  public final static java.lang.String ROLECODE_LABLE = "角色编码";
  
  /**
   *	RoleCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String roleCode;
  
  /**
   *	RoleDesc数据库列名
   */
  public final static java.lang.String ROLEDESC_FIELD =  "RoleDesc";
  
  /**
   *	RoleDesc字段中文名，用于视图展示
   */
  public final static java.lang.String ROLEDESC_LABLE = "角色描述";
  
  /**
   *	RoleDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String roleDesc;
  
  /**
   *	RoleID数据库列名
   */
  public final static java.lang.String ROLEID_FIELD =  "RoleID";
  
  /**
   *	RoleID字段中文名，用于视图展示
   */
  public final static java.lang.String ROLEID_LABLE = "角色编号";
  
  /**
   *	RoleID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long roleID;
  
  /**
   *	RoleLevel数据库列名
   */
  public final static java.lang.String ROLELEVEL_FIELD =  "RoleLevel";
  
  /**
   *	RoleLevel字段中文名，用于视图展示
   */
  public final static java.lang.String ROLELEVEL_LABLE = "角色级别";
  
  /**
   *	RoleLevel对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer roleLevel;
  
  /**
   *	RoleName数据库列名
   */
  public final static java.lang.String ROLENAME_FIELD =  "RoleName";
  
  /**
   *	RoleName字段中文名，用于视图展示
   */
  public final static java.lang.String ROLENAME_LABLE = "角色名称";
  
  /**
   *	RoleName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String roleName;
  
  /**
   *	RoleStatus数据库列名
   */
  public final static java.lang.String ROLESTATUS_FIELD =  "RoleStatus";
  
  /**
   *	RoleStatus字段中文名，用于视图展示
   */
  public final static java.lang.String ROLESTATUS_LABLE = "状态";
  
  /**
   *	RoleStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long roleStatus;
  
  /**
   *	RoleType数据库列名
   */
  public final static java.lang.String ROLETYPE_FIELD =  "RoleType";
  
  /**
   *	RoleType字段中文名，用于视图展示
   */
  public final static java.lang.String ROLETYPE_LABLE = "角色类型";
  
  /**
   *	RoleType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long roleType;
  
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
   *	TreeCode数据库列名
   */
  public final static java.lang.String TREECODE_FIELD =  "TreeCode";
  
  /**
   *	TreeCode字段中文名，用于视图展示
   */
  public final static java.lang.String TREECODE_LABLE = "级别编码";
  
  /**
   *	TreeCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String treeCode;
  
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
   * 计算方式 getter
   */
  public java.lang.Long getExpMode(){
    return expMode;
  }
  /**
   * 计算方式 setter
   * @param ExpMode
   */  
  public void setExpMode(java.lang.Long expMode){
    this.expMode = expMode;
  }
 
  /**
   * 经验值 getter
   */
  public java.lang.Integer getExpPoint(){
    return expPoint;
  }
  /**
   * 经验值 setter
   * @param ExpPoint
   */  
  public void setExpPoint(java.lang.Integer expPoint){
    this.expPoint = expPoint;
  }
 
  /**
   * 有效性标志 getter
   */
  public java.lang.Boolean getIsValid(){
    return isValid;
  }
  /**
   * 有效性标志 setter
   * @param IsValid
   */  
  public void setIsValid(java.lang.Boolean isValid){
    this.isValid = isValid;
  }
 
  /**
   * 关键字 getter
   */
  public java.lang.String getKeyword(){
    return keyword;
  }
  /**
   * 关键字 setter
   * @param Keyword
   */  
  public void setKeyword(java.lang.String keyword){
    this.keyword = keyword;
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
   * 下级经验值 getter
   */
  public java.lang.Integer getNextExp(){
    return nextExp;
  }
  /**
   * 下级经验值 setter
   * @param NextExp
   */  
  public void setNextExp(java.lang.Integer nextExp){
    this.nextExp = nextExp;
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
   * 上级编号 getter
   */
  public java.lang.Long getParentID(){
    return parentID;
  }
  /**
   * 上级编号 setter
   * @param ParentID
   */  
  public void setParentID(java.lang.Long parentID){
    this.parentID = parentID;
  }
 
  /**
   * 角色编码 getter
   */
  public java.lang.String getRoleCode(){
    return roleCode;
  }
  /**
   * 角色编码 setter
   * @param RoleCode
   */  
  public void setRoleCode(java.lang.String roleCode){
    this.roleCode = roleCode;
  }
 
  /**
   * 角色描述 getter
   */
  public java.lang.String getRoleDesc(){
    return roleDesc;
  }
  /**
   * 角色描述 setter
   * @param RoleDesc
   */  
  public void setRoleDesc(java.lang.String roleDesc){
    this.roleDesc = roleDesc;
  }
 
  /**
   * 角色编号 getter
   */
  public java.lang.Long getRoleID(){
    return roleID;
  }
  /**
   * 角色编号 setter
   * @param RoleID
   */  
  public void setRoleID(java.lang.Long roleID){
    this.roleID = roleID;
  }
 
  /**
   * 角色级别 getter
   */
  public java.lang.Integer getRoleLevel(){
    return roleLevel;
  }
  /**
   * 角色级别 setter
   * @param RoleLevel
   */  
  public void setRoleLevel(java.lang.Integer roleLevel){
    this.roleLevel = roleLevel;
  }
 
  /**
   * 角色名称 getter
   */
  public java.lang.String getRoleName(){
    return roleName;
  }
  /**
   * 角色名称 setter
   * @param RoleName
   */  
  public void setRoleName(java.lang.String roleName){
    this.roleName = roleName;
  }
 
  /**
   * 状态 getter
   */
  public java.lang.Long getRoleStatus(){
    return roleStatus;
  }
  /**
   * 状态 setter
   * @param RoleStatus
   */  
  public void setRoleStatus(java.lang.Long roleStatus){
    this.roleStatus = roleStatus;
  }
 
  /**
   * 角色类型 getter
   */
  public java.lang.Long getRoleType(){
    return roleType;
  }
  /**
   * 角色类型 setter
   * @param RoleType
   */  
  public void setRoleType(java.lang.Long roleType){
    this.roleType = roleType;
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
   * 级别编码 getter
   */
  public java.lang.String getTreeCode(){
    return treeCode;
  }
  /**
   * 级别编码 setter
   * @param TreeCode
   */  
  public void setTreeCode(java.lang.String treeCode){
    this.treeCode = treeCode;
  }
 
}