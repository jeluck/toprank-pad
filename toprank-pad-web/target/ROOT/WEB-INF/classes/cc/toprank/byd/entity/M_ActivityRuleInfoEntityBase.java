package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在M_ActivityRuleInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class M_ActivityRuleInfoEntityBase extends Entity {

  /**
   *	ActiviryRuleStatus数据库列名
   */
  public final static java.lang.String ACTIVIRYRULESTATUS_FIELD =  "ActiviryRuleStatus";
  
  /**
   *	ActiviryRuleStatus字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVIRYRULESTATUS_LABLE = "规则状态";
  
  /**
   *	ActiviryRuleStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long activiryRuleStatus;
  
  /**
   *	ActivityID数据库列名
   */
  public final static java.lang.String ACTIVITYID_FIELD =  "ActivityID";
  
  /**
   *	ActivityID字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVITYID_LABLE = "活动编号";
  
  /**
   *	ActivityID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long activityID;
  
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
   *	DiscountType数据库列名
   */
  public final static java.lang.String DISCOUNTTYPE_FIELD =  "DiscountType";
  
  /**
   *	DiscountType字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTTYPE_LABLE = "折扣方式";
  
  /**
   *	DiscountType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long discountType;
  
  /**
   *	IsAmount数据库列名
   */
  public final static java.lang.String ISAMOUNT_FIELD =  "IsAmount";
  
  /**
   *	IsAmount字段中文名，用于视图展示
   */
  public final static java.lang.String ISAMOUNT_LABLE = "使用金额";
  
  /**
   *	IsAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isAmount;
  
  /**
   *	LogoUrl数据库列名
   */
  public final static java.lang.String LOGOURL_FIELD =  "LogoUrl";
  
  /**
   *	LogoUrl字段中文名，用于视图展示
   */
  public final static java.lang.String LOGOURL_LABLE = "图标";
  
  /**
   *	LogoUrl对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String logoUrl;
  
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
   *	Priority数据库列名
   */
  public final static java.lang.String PRIORITY_FIELD =  "Priority";
  
  /**
   *	Priority字段中文名，用于视图展示
   */
  public final static java.lang.String PRIORITY_LABLE = "优先级";
  
  /**
   *	Priority对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer priority;
  
  /**
   *	ProductQuantity数据库列名
   */
  public final static java.lang.String PRODUCTQUANTITY_FIELD =  "ProductQuantity";
  
  /**
   *	ProductQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCTQUANTITY_LABLE = "购买数量";
  
  /**
   *	ProductQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer productQuantity;
  
  /**
   *	RemainQuqntity数据库列名
   */
  public final static java.lang.String REMAINQUQNTITY_FIELD =  "RemainQuqntity";
  
  /**
   *	RemainQuqntity字段中文名，用于视图展示
   */
  public final static java.lang.String REMAINQUQNTITY_LABLE = "剩余数量";
  
  /**
   *	RemainQuqntity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer remainQuqntity;
  
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
   *	RuleID数据库列名
   */
  public final static java.lang.String RULEID_FIELD =  "RuleID";
  
  /**
   *	RuleID字段中文名，用于视图展示
   */
  public final static java.lang.String RULEID_LABLE = "规则编号";
  
  /**
   *	RuleID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long ruleID;
  
  /**
   *	RuleName数据库列名
   */
  public final static java.lang.String RULENAME_FIELD =  "RuleName";
  
  /**
   *	RuleName字段中文名，用于视图展示
   */
  public final static java.lang.String RULENAME_LABLE = "规则名称";
  
  /**
   *	RuleName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String ruleName;
  
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
   *	SpentAmount数据库列名
   */
  public final static java.lang.String SPENTAMOUNT_FIELD =  "SpentAmount";
  
  /**
   *	SpentAmount字段中文名，用于视图展示
   */
  public final static java.lang.String SPENTAMOUNT_LABLE = "花费金额";
  
  /**
   *	SpentAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal spentAmount;
  
  /**
   *	TotalQuantity数据库列名
   */
  public final static java.lang.String TOTALQUANTITY_FIELD =  "TotalQuantity";
  
  /**
   *	TotalQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String TOTALQUANTITY_LABLE = "赠品数量";
  
  /**
   *	TotalQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer totalQuantity;
  
  /**
   * 规则状态 getter
   */
  public java.lang.Long getActiviryRuleStatus(){
    return activiryRuleStatus;
  }
  /**
   * 规则状态 setter
   * @param ActiviryRuleStatus
   */  
  public void setActiviryRuleStatus(java.lang.Long activiryRuleStatus){
    this.activiryRuleStatus = activiryRuleStatus;
  }
 
  /**
   * 活动编号 getter
   */
  public java.lang.Long getActivityID(){
    return activityID;
  }
  /**
   * 活动编号 setter
   * @param ActivityID
   */  
  public void setActivityID(java.lang.Long activityID){
    this.activityID = activityID;
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
   * 折扣方式 getter
   */
  public java.lang.Long getDiscountType(){
    return discountType;
  }
  /**
   * 折扣方式 setter
   * @param DiscountType
   */  
  public void setDiscountType(java.lang.Long discountType){
    this.discountType = discountType;
  }
 
  /**
   * 使用金额 getter
   */
  public java.lang.Boolean getIsAmount(){
    return isAmount;
  }
  /**
   * 使用金额 setter
   * @param IsAmount
   */  
  public void setIsAmount(java.lang.Boolean isAmount){
    this.isAmount = isAmount;
  }
 
  /**
   * 图标 getter
   */
  public java.lang.String getLogoUrl(){
    return logoUrl;
  }
  /**
   * 图标 setter
   * @param LogoUrl
   */  
  public void setLogoUrl(java.lang.String logoUrl){
    this.logoUrl = logoUrl;
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
   * 优先级 getter
   */
  public java.lang.Integer getPriority(){
    return priority;
  }
  /**
   * 优先级 setter
   * @param Priority
   */  
  public void setPriority(java.lang.Integer priority){
    this.priority = priority;
  }
 
  /**
   * 购买数量 getter
   */
  public java.lang.Integer getProductQuantity(){
    return productQuantity;
  }
  /**
   * 购买数量 setter
   * @param ProductQuantity
   */  
  public void setProductQuantity(java.lang.Integer productQuantity){
    this.productQuantity = productQuantity;
  }
 
  /**
   * 剩余数量 getter
   */
  public java.lang.Integer getRemainQuqntity(){
    return remainQuqntity;
  }
  /**
   * 剩余数量 setter
   * @param RemainQuqntity
   */  
  public void setRemainQuqntity(java.lang.Integer remainQuqntity){
    this.remainQuqntity = remainQuqntity;
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
   * 规则编号 getter
   */
  public java.lang.Long getRuleID(){
    return ruleID;
  }
  /**
   * 规则编号 setter
   * @param RuleID
   */  
  public void setRuleID(java.lang.Long ruleID){
    this.ruleID = ruleID;
  }
 
  /**
   * 规则名称 getter
   */
  public java.lang.String getRuleName(){
    return ruleName;
  }
  /**
   * 规则名称 setter
   * @param RuleName
   */  
  public void setRuleName(java.lang.String ruleName){
    this.ruleName = ruleName;
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
   * 花费金额 getter
   */
  public java.math.BigDecimal getSpentAmount(){
    return spentAmount;
  }
  /**
   * 花费金额 setter
   * @param SpentAmount
   */  
  public void setSpentAmount(java.math.BigDecimal spentAmount){
    this.spentAmount = spentAmount;
  }
 
  /**
   * 赠品数量 getter
   */
  public java.lang.Integer getTotalQuantity(){
    return totalQuantity;
  }
  /**
   * 赠品数量 setter
   * @param TotalQuantity
   */  
  public void setTotalQuantity(java.lang.Integer totalQuantity){
    this.totalQuantity = totalQuantity;
  }
 
}