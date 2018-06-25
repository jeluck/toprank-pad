package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在E_MerchantBonusInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class E_MerchantBonusInfoEntityBase  extends Entity{

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
   *	BonusID数据库列名
   */
  public final static java.lang.String BONUSID_FIELD =  "BonusID";

  /**
   *	BonusID字段中文名，用于视图展示
   */
  public final static java.lang.String BONUSID_LABLE = "积分编号";

  /**
   *	BonusID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long bonusID;

  /**
   *	CardCode数据库列名
   */
  public final static java.lang.String CARDCODE_FIELD =  "CardCode";

  /**
   *	CardCode字段中文名，用于视图展示
   */
  public final static java.lang.String CARDCODE_LABLE = "会员卡号";

  /**
   *	CardCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String cardCode;

  /**
   *	CardID数据库列名
   */
  public final static java.lang.String CARDID_FIELD =  "CardID";

  /**
   *	CardID字段中文名，用于视图展示
   */
  public final static java.lang.String CARDID_LABLE = "卡编号";

  /**
   *	CardID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long cardID;

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
   *	CurrentBonus数据库列名
   */
  public final static java.lang.String CURRENTBONUS_FIELD =  "CurrentBonus";

  /**
   *	CurrentBonus字段中文名，用于视图展示
   */
  public final static java.lang.String CURRENTBONUS_LABLE = "当前余额";

  /**
   *	CurrentBonus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer currentBonus;

  /**
   *	CustomerID数据库列名
   */
  public final static java.lang.String CUSTOMERID_FIELD =  "CustomerID";

  /**
   *	CustomerID字段中文名，用于视图展示
   */
  public final static java.lang.String CUSTOMERID_LABLE = "客户编号";

  /**
   *	CustomerID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long customerID;

  /**
   *	LatestChangeAmount数据库列名
   */
  public final static java.lang.String LATESTCHANGEAMOUNT_FIELD =  "LatestChangeAmount";

  /**
   *	LatestChangeAmount字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTCHANGEAMOUNT_LABLE = "最后变动数量";

  /**
   *	LatestChangeAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer latestChangeAmount;

  /**
   *	LatestChangeTime数据库列名
   */
  public final static java.lang.String LATESTCHANGETIME_FIELD =  "LatestChangeTime";

  /**
   *	LatestChangeTime字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTCHANGETIME_LABLE = "最后变动时间";

  /**
   *	LatestChangeTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime latestChangeTime;

  /**
   *	LatestChangeType数据库列名
   */
  public final static java.lang.String LATESTCHANGETYPE_FIELD =  "LatestChangeType";

  /**
   *	LatestChangeType字段中文名，用于视图展示
   */
  public final static java.lang.String LATESTCHANGETYPE_LABLE = "最后变动方式";

  /**
   *	LatestChangeType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long latestChangeType;

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
   *	TotalBonus数据库列名
   */
  public final static java.lang.String TOTALBONUS_FIELD =  "TotalBonus";

  /**
   *	TotalBonus字段中文名，用于视图展示
   */
  public final static java.lang.String TOTALBONUS_LABLE = "积分总额";

  /**
   *	TotalBonus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer totalBonus;

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
   * 积分编号 getter
   */
  public java.lang.Long getBonusID(){
    return bonusID;
  }
  /**
   * 积分编号 setter
   * @param BonusID
   */
  public void setBonusID(java.lang.Long bonusID){
    this.bonusID = bonusID;
  }

  /**
   * 会员卡号 getter
   */
  public java.lang.String getCardCode(){
    return cardCode;
  }
  /**
   * 会员卡号 setter
   * @param CardCode
   */
  public void setCardCode(java.lang.String cardCode){
    this.cardCode = cardCode;
  }

  /**
   * 卡编号 getter
   */
  public java.lang.Long getCardID(){
    return cardID;
  }
  /**
   * 卡编号 setter
   * @param CardID
   */
  public void setCardID(java.lang.Long cardID){
    this.cardID = cardID;
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
   * 当前余额 getter
   */
  public java.lang.Integer getCurrentBonus(){
    return currentBonus;
  }
  /**
   * 当前余额 setter
   * @param CurrentBonus
   */
  public void setCurrentBonus(java.lang.Integer currentBonus){
    this.currentBonus = currentBonus;
  }

  /**
   * 客户编号 getter
   */
  public java.lang.Long getCustomerID(){
    return customerID;
  }
  /**
   * 客户编号 setter
   * @param CustomerID
   */
  public void setCustomerID(java.lang.Long customerID){
    this.customerID = customerID;
  }

  /**
   * 最后变动数量 getter
   */
  public java.lang.Integer getLatestChangeAmount(){
    return latestChangeAmount;
  }
  /**
   * 最后变动数量 setter
   * @param LatestChangeAmount
   */
  public void setLatestChangeAmount(java.lang.Integer latestChangeAmount){
    this.latestChangeAmount = latestChangeAmount;
  }

  /**
   * 最后变动时间 getter
   */
  public java.time.LocalDateTime getLatestChangeTime(){
    return latestChangeTime;
  }
  /**
   * 最后变动时间 setter
   * @param LatestChangeTime
   */
  public void setLatestChangeTime(java.time.LocalDateTime latestChangeTime){
    this.latestChangeTime = latestChangeTime;
  }

  /**
   * 最后变动方式 getter
   */
  public java.lang.Long getLatestChangeType(){
    return latestChangeType;
  }
  /**
   * 最后变动方式 setter
   * @param LatestChangeType
   */
  public void setLatestChangeType(java.lang.Long latestChangeType){
    this.latestChangeType = latestChangeType;
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
   * 积分总额 getter
   */
  public java.lang.Integer getTotalBonus(){
    return totalBonus;
  }
  /**
   * 积分总额 setter
   * @param TotalBonus
   */
  public void setTotalBonus(java.lang.Integer totalBonus){
    this.totalBonus = totalBonus;
  }

}