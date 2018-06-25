package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_MerchantFeeInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_MerchantFeeInfoEntityBase extends Entity {

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
   *	AreaID数据库列名
   */
  public final static java.lang.String AREAID_FIELD =  "AreaID";
  
  /**
   *	AreaID字段中文名，用于视图展示
   */
  public final static java.lang.String AREAID_LABLE = "区域编号";
  
  /**
   *	AreaID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long areaID;
  
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
   *	FeeAmount数据库列名
   */
  public final static java.lang.String FEEAMOUNT_FIELD =  "FeeAmount";
  
  /**
   *	FeeAmount字段中文名，用于视图展示
   */
  public final static java.lang.String FEEAMOUNT_LABLE = "费用";
  
  /**
   *	FeeAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal feeAmount;
  
  /**
   *	FeeMode数据库列名
   */
  public final static java.lang.String FEEMODE_FIELD =  "FeeMode";
  
  /**
   *	FeeMode字段中文名，用于视图展示
   */
  public final static java.lang.String FEEMODE_LABLE = "收费模式";
  
  /**
   *	FeeMode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long feeMode;
  
  /**
   *	FeeType数据库列名
   */
  public final static java.lang.String FEETYPE_FIELD =  "FeeType";
  
  /**
   *	FeeType字段中文名，用于视图展示
   */
  public final static java.lang.String FEETYPE_LABLE = "收取方式";
  
  /**
   *	FeeType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long feeType;
  
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
   *	ItemCode数据库列名
   */
  public final static java.lang.String ITEMCODE_FIELD =  "ItemCode";
  
  /**
   *	ItemCode字段中文名，用于视图展示
   */
  public final static java.lang.String ITEMCODE_LABLE = "项目编码";
  
  /**
   *	ItemCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String itemCode;
  
  /**
   *	ItemID数据库列名
   */
  public final static java.lang.String ITEMID_FIELD =  "ItemID";
  
  /**
   *	ItemID字段中文名，用于视图展示
   */
  public final static java.lang.String ITEMID_LABLE = "项目编号";
  
  /**
   *	ItemID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long itemID;
  
  /**
   *	ItemName数据库列名
   */
  public final static java.lang.String ITEMNAME_FIELD =  "ItemName";
  
  /**
   *	ItemName字段中文名，用于视图展示
   */
  public final static java.lang.String ITEMNAME_LABLE = "项目名称";
  
  /**
   *	ItemName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String itemName;
  
  /**
   *	MealsID数据库列名
   */
  public final static java.lang.String MEALSID_FIELD =  "MealsID";
  
  /**
   *	MealsID字段中文名，用于视图展示
   */
  public final static java.lang.String MEALSID_LABLE = "餐次编号";
  
  /**
   *	MealsID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mealsID;
  
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
   *	Proportion数据库列名
   */
  public final static java.lang.String PROPORTION_FIELD =  "Proportion";
  
  /**
   *	Proportion字段中文名，用于视图展示
   */
  public final static java.lang.String PROPORTION_LABLE = "比例";
  
  /**
   *	Proportion对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float proportion;
  
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
   * 区域编号 getter
   */
  public java.lang.Long getAreaID(){
    return areaID;
  }
  /**
   * 区域编号 setter
   * @param AreaID
   */  
  public void setAreaID(java.lang.Long areaID){
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
   * 费用 getter
   */
  public java.math.BigDecimal getFeeAmount(){
    return feeAmount;
  }
  /**
   * 费用 setter
   * @param FeeAmount
   */  
  public void setFeeAmount(java.math.BigDecimal feeAmount){
    this.feeAmount = feeAmount;
  }
 
  /**
   * 收费模式 getter
   */
  public java.lang.Long getFeeMode(){
    return feeMode;
  }
  /**
   * 收费模式 setter
   * @param FeeMode
   */  
  public void setFeeMode(java.lang.Long feeMode){
    this.feeMode = feeMode;
  }
 
  /**
   * 收取方式 getter
   */
  public java.lang.Long getFeeType(){
    return feeType;
  }
  /**
   * 收取方式 setter
   * @param FeeType
   */  
  public void setFeeType(java.lang.Long feeType){
    this.feeType = feeType;
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
   * 项目编码 getter
   */
  public java.lang.String getItemCode(){
    return itemCode;
  }
  /**
   * 项目编码 setter
   * @param ItemCode
   */  
  public void setItemCode(java.lang.String itemCode){
    this.itemCode = itemCode;
  }
 
  /**
   * 项目编号 getter
   */
  public java.lang.Long getItemID(){
    return itemID;
  }
  /**
   * 项目编号 setter
   * @param ItemID
   */  
  public void setItemID(java.lang.Long itemID){
    this.itemID = itemID;
  }
 
  /**
   * 项目名称 getter
   */
  public java.lang.String getItemName(){
    return itemName;
  }
  /**
   * 项目名称 setter
   * @param ItemName
   */  
  public void setItemName(java.lang.String itemName){
    this.itemName = itemName;
  }
 
  /**
   * 餐次编号 getter
   */
  public java.lang.Long getMealsID(){
    return mealsID;
  }
  /**
   * 餐次编号 setter
   * @param MealsID
   */  
  public void setMealsID(java.lang.Long mealsID){
    this.mealsID = mealsID;
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
   * 比例 getter
   */
  public java.lang.Float getProportion(){
    return proportion;
  }
  /**
   * 比例 setter
   * @param Proportion
   */  
  public void setProportion(java.lang.Float proportion){
    this.proportion = proportion;
  }
 
}