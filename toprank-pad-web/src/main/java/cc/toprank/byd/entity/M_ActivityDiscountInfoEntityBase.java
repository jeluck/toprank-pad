package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在M_ActivityDiscountInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class M_ActivityDiscountInfoEntityBase extends Entity {

  /**
   *	BaseAmount数据库列名
   */
  public final static java.lang.String BASEAMOUNT_FIELD =  "BaseAmount";
  
  /**
   *	BaseAmount字段中文名，用于视图展示
   */
  public final static java.lang.String BASEAMOUNT_LABLE = "基础额度";
  
  /**
   *	BaseAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal baseAmount;
  
  /**
   *	BonusMultiply数据库列名
   */
  public final static java.lang.String BONUSMULTIPLY_FIELD =  "BonusMultiply";
  
  /**
   *	BonusMultiply字段中文名，用于视图展示
   */
  public final static java.lang.String BONUSMULTIPLY_LABLE = "积分倍数";
  
  /**
   *	BonusMultiply对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float bonusMultiply;
  
  /**
   *	CanAccumulative数据库列名
   */
  public final static java.lang.String CANACCUMULATIVE_FIELD =  "CanAccumulative";
  
  /**
   *	CanAccumulative字段中文名，用于视图展示
   */
  public final static java.lang.String CANACCUMULATIVE_LABLE = "可否累计";
  
  /**
   *	CanAccumulative对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean canAccumulative;
  
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
   *	DiscountAmount数据库列名
   */
  public final static java.lang.String DISCOUNTAMOUNT_FIELD =  "DiscountAmount";
  
  /**
   *	DiscountAmount字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTAMOUNT_LABLE = "减免金额";
  
  /**
   *	DiscountAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal discountAmount;
  
  /**
   *	DiscountID数据库列名
   */
  public final static java.lang.String DISCOUNTID_FIELD =  "DiscountID";
  
  /**
   *	DiscountID字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTID_LABLE = "折扣编号";
  
  /**
   *	DiscountID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long discountID;
  
  /**
   *	DiscountName数据库列名
   */
  public final static java.lang.String DISCOUNTNAME_FIELD =  "DiscountName";
  
  /**
   *	DiscountName字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTNAME_LABLE = "名称";
  
  /**
   *	DiscountName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String discountName;
  
  /**
   *	DiscountPercentage数据库列名
   */
  public final static java.lang.String DISCOUNTPERCENTAGE_FIELD =  "DiscountPercentage";
  
  /**
   *	DiscountPercentage字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTPERCENTAGE_LABLE = "折扣比率";
  
  /**
   *	DiscountPercentage对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float discountPercentage;
  
  /**
   *	DiscountStatus数据库列名
   */
  public final static java.lang.String DISCOUNTSTATUS_FIELD =  "DiscountStatus";
  
  /**
   *	DiscountStatus字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTSTATUS_LABLE = "折扣状态";
  
  /**
   *	DiscountStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long discountStatus;
  
  /**
   *	DiscounType数据库列名
   */
  public final static java.lang.String DISCOUNTYPE_FIELD =  "DiscounType";
  
  /**
   *	DiscounType字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTYPE_LABLE = "折扣方式";
  
  /**
   *	DiscounType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long discounType;
  
  /**
   *	HighPrice数据库列名
   */
  public final static java.lang.String HIGHPRICE_FIELD =  "HighPrice";
  
  /**
   *	HighPrice字段中文名，用于视图展示
   */
  public final static java.lang.String HIGHPRICE_LABLE = "最高价";
  
  /**
   *	HighPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal highPrice;
  
  /**
   *	LowPrice数据库列名
   */
  public final static java.lang.String LOWPRICE_FIELD =  "LowPrice";
  
  /**
   *	LowPrice字段中文名，用于视图展示
   */
  public final static java.lang.String LOWPRICE_LABLE = "最低价";
  
  /**
   *	LowPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal lowPrice;
  
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
   *	PresentAmount数据库列名
   */
  public final static java.lang.String PRESENTAMOUNT_FIELD =  "PresentAmount";
  
  /**
   *	PresentAmount字段中文名，用于视图展示
   */
  public final static java.lang.String PRESENTAMOUNT_LABLE = "赠送金额";
  
  /**
   *	PresentAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal presentAmount;
  
  /**
   *	PresentBonus数据库列名
   */
  public final static java.lang.String PRESENTBONUS_FIELD =  "PresentBonus";
  
  /**
   *	PresentBonus字段中文名，用于视图展示
   */
  public final static java.lang.String PRESENTBONUS_LABLE = "赠送积分";
  
  /**
   *	PresentBonus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer presentBonus;
  
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
   * 基础额度 getter
   */
  public java.math.BigDecimal getBaseAmount(){
    return baseAmount;
  }
  /**
   * 基础额度 setter
   * @param BaseAmount
   */  
  public void setBaseAmount(java.math.BigDecimal baseAmount){
    this.baseAmount = baseAmount;
  }
 
  /**
   * 积分倍数 getter
   */
  public java.lang.Float getBonusMultiply(){
    return bonusMultiply;
  }
  /**
   * 积分倍数 setter
   * @param BonusMultiply
   */  
  public void setBonusMultiply(java.lang.Float bonusMultiply){
    this.bonusMultiply = bonusMultiply;
  }
 
  /**
   * 可否累计 getter
   */
  public java.lang.Boolean getCanAccumulative(){
    return canAccumulative;
  }
  /**
   * 可否累计 setter
   * @param CanAccumulative
   */  
  public void setCanAccumulative(java.lang.Boolean canAccumulative){
    this.canAccumulative = canAccumulative;
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
   * 减免金额 getter
   */
  public java.math.BigDecimal getDiscountAmount(){
    return discountAmount;
  }
  /**
   * 减免金额 setter
   * @param DiscountAmount
   */  
  public void setDiscountAmount(java.math.BigDecimal discountAmount){
    this.discountAmount = discountAmount;
  }
 
  /**
   * 折扣编号 getter
   */
  public java.lang.Long getDiscountID(){
    return discountID;
  }
  /**
   * 折扣编号 setter
   * @param DiscountID
   */  
  public void setDiscountID(java.lang.Long discountID){
    this.discountID = discountID;
  }
 
  /**
   * 名称 getter
   */
  public java.lang.String getDiscountName(){
    return discountName;
  }
  /**
   * 名称 setter
   * @param DiscountName
   */  
  public void setDiscountName(java.lang.String discountName){
    this.discountName = discountName;
  }
 
  /**
   * 折扣比率 getter
   */
  public java.lang.Float getDiscountPercentage(){
    return discountPercentage;
  }
  /**
   * 折扣比率 setter
   * @param DiscountPercentage
   */  
  public void setDiscountPercentage(java.lang.Float discountPercentage){
    this.discountPercentage = discountPercentage;
  }
 
  /**
   * 折扣状态 getter
   */
  public java.lang.Long getDiscountStatus(){
    return discountStatus;
  }
  /**
   * 折扣状态 setter
   * @param DiscountStatus
   */  
  public void setDiscountStatus(java.lang.Long discountStatus){
    this.discountStatus = discountStatus;
  }
 
  /**
   * 折扣方式 getter
   */
  public java.lang.Long getDiscounType(){
    return discounType;
  }
  /**
   * 折扣方式 setter
   * @param DiscounType
   */  
  public void setDiscounType(java.lang.Long discounType){
    this.discounType = discounType;
  }
 
  /**
   * 最高价 getter
   */
  public java.math.BigDecimal getHighPrice(){
    return highPrice;
  }
  /**
   * 最高价 setter
   * @param HighPrice
   */  
  public void setHighPrice(java.math.BigDecimal highPrice){
    this.highPrice = highPrice;
  }
 
  /**
   * 最低价 getter
   */
  public java.math.BigDecimal getLowPrice(){
    return lowPrice;
  }
  /**
   * 最低价 setter
   * @param LowPrice
   */  
  public void setLowPrice(java.math.BigDecimal lowPrice){
    this.lowPrice = lowPrice;
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
   * 赠送金额 getter
   */
  public java.math.BigDecimal getPresentAmount(){
    return presentAmount;
  }
  /**
   * 赠送金额 setter
   * @param PresentAmount
   */  
  public void setPresentAmount(java.math.BigDecimal presentAmount){
    this.presentAmount = presentAmount;
  }
 
  /**
   * 赠送积分 getter
   */
  public java.lang.Integer getPresentBonus(){
    return presentBonus;
  }
  /**
   * 赠送积分 setter
   * @param PresentBonus
   */  
  public void setPresentBonus(java.lang.Integer presentBonus){
    this.presentBonus = presentBonus;
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