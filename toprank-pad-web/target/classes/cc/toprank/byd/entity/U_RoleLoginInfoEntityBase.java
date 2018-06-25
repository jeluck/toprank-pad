package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在U_RoleLoginInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class U_RoleLoginInfoEntityBase extends Entity {

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
   *	EffectiveTime数据库列名
   */
  public final static java.lang.String EFFECTIVETIME_FIELD =  "EffectiveTime";
  
  /**
   *	EffectiveTime字段中文名，用于视图展示
   */
  public final static java.lang.String EFFECTIVETIME_LABLE = "生效时间";
  
  /**
   *	EffectiveTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime effectiveTime;
  
  /**
   *	ExpireTime数据库列名
   */
  public final static java.lang.String EXPIRETIME_FIELD =  "ExpireTime";
  
  /**
   *	ExpireTime字段中文名，用于视图展示
   */
  public final static java.lang.String EXPIRETIME_LABLE = "失效时间";
  
  /**
   *	ExpireTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime expireTime;
  
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
   * 生效时间 getter
   */
  public java.time.LocalDateTime getEffectiveTime(){
    return effectiveTime;
  }
  /**
   * 生效时间 setter
   * @param EffectiveTime
   */  
  public void setEffectiveTime(java.time.LocalDateTime effectiveTime){
    this.effectiveTime = effectiveTime;
  }
 
  /**
   * 失效时间 getter
   */
  public java.time.LocalDateTime getExpireTime(){
    return expireTime;
  }
  /**
   * 失效时间 setter
   * @param ExpireTime
   */  
  public void setExpireTime(java.time.LocalDateTime expireTime){
    this.expireTime = expireTime;
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