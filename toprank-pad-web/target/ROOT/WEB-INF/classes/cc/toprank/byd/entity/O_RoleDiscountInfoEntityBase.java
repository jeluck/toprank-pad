package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_RoleDiscountInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_RoleDiscountInfoEntityBase extends Entity {

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
   *	DiscountDesc数据库列名
   */
  public final static java.lang.String DISCOUNTDESC_FIELD =  "DiscountDesc";
  
  /**
   *	DiscountDesc字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTDESC_LABLE = "折扣描述";
  
  /**
   *	DiscountDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String discountDesc;
  
  /**
   *	DiscountItem数据库列名
   */
  public final static java.lang.String DISCOUNTITEM_FIELD =  "DiscountItem";
  
  /**
   *	DiscountItem字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTITEM_LABLE = "折扣项目";
  
  /**
   *	DiscountItem对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String discountItem;
  
  /**
   *	HighestAmount数据库列名
   */
  public final static java.lang.String HIGHESTAMOUNT_FIELD =  "HighestAmount";
  
  /**
   *	HighestAmount字段中文名，用于视图展示
   */
  public final static java.lang.String HIGHESTAMOUNT_LABLE = "最高折扣金额";
  
  /**
   *	HighestAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal highestAmount;
  
  /**
   *	HighestRate数据库列名
   */
  public final static java.lang.String HIGHESTRATE_FIELD =  "HighestRate";
  
  /**
   *	HighestRate字段中文名，用于视图展示
   */
  public final static java.lang.String HIGHESTRATE_LABLE = "最高折扣比率";
  
  /**
   *	HighestRate对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float highestRate;
  
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
   *	OrtherDesc数据库列名
   */
  public final static java.lang.String ORTHERDESC_FIELD =  "OrtherDesc";
  
  /**
   *	OrtherDesc字段中文名，用于视图展示
   */
  public final static java.lang.String ORTHERDESC_LABLE = "其他注释";
  
  /**
   *	OrtherDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String ortherDesc;
  
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
   * 折扣描述 getter
   */
  public java.lang.String getDiscountDesc(){
    return discountDesc;
  }
  /**
   * 折扣描述 setter
   * @param DiscountDesc
   */  
  public void setDiscountDesc(java.lang.String discountDesc){
    this.discountDesc = discountDesc;
  }
 
  /**
   * 折扣项目 getter
   */
  public java.lang.String getDiscountItem(){
    return discountItem;
  }
  /**
   * 折扣项目 setter
   * @param DiscountItem
   */  
  public void setDiscountItem(java.lang.String discountItem){
    this.discountItem = discountItem;
  }
 
  /**
   * 最高折扣金额 getter
   */
  public java.math.BigDecimal getHighestAmount(){
    return highestAmount;
  }
  /**
   * 最高折扣金额 setter
   * @param HighestAmount
   */  
  public void setHighestAmount(java.math.BigDecimal highestAmount){
    this.highestAmount = highestAmount;
  }
 
  /**
   * 最高折扣比率 getter
   */
  public java.lang.Float getHighestRate(){
    return highestRate;
  }
  /**
   * 最高折扣比率 setter
   * @param HighestRate
   */  
  public void setHighestRate(java.lang.Float highestRate){
    this.highestRate = highestRate;
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
   * 其他注释 getter
   */
  public java.lang.String getOrtherDesc(){
    return ortherDesc;
  }
  /**
   * 其他注释 setter
   * @param OrtherDesc
   */  
  public void setOrtherDesc(java.lang.String ortherDesc){
    this.ortherDesc = ortherDesc;
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
 
}