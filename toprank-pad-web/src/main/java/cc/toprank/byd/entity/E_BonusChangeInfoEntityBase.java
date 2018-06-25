package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在E_BonusChangeInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class E_BonusChangeInfoEntityBase extends Entity {

  /**
   *	AfterAmount数据库列名
   */
  public final static String AFTERAMOUNT_FIELD =  "AfterAmount";
  
  /**
   *	AfterAmount字段中文名，用于视图展示
   */
  public final static String AFTERAMOUNT_LABLE = "变动后数量";
  
  /**
   *	AfterAmount对应的java字段名,业务操作使用这个字段。
   */
  private Integer afterAmount;
  
  /**
   *	BeforeAmount数据库列名
   */
  public final static String BEFOREAMOUNT_FIELD =  "BeforeAmount";
  
  /**
   *	BeforeAmount字段中文名，用于视图展示
   */
  public final static String BEFOREAMOUNT_LABLE = "变动前数量";
  
  /**
   *	BeforeAmount对应的java字段名,业务操作使用这个字段。
   */
  private Integer beforeAmount;
  
  /**
   *	BonusID数据库列名
   */
  public final static String BONUSID_FIELD =  "BonusID";
  
  /**
   *	BonusID字段中文名，用于视图展示
   */
  public final static String BONUSID_LABLE = "积分编号";
  
  /**
   *	BonusID对应的java字段名,业务操作使用这个字段。
   */
  private Long bonusID;
  
  /**
   *	BonusRate数据库列名
   */
  public final static String BONUSRATE_FIELD =  "BonusRate";
  
  /**
   *	BonusRate字段中文名，用于视图展示
   */
  public final static String BONUSRATE_LABLE = "积分比例";
  
  /**
   *	BonusRate对应的java字段名,业务操作使用这个字段。
   */
  private Float bonusRate;
  
  /**
   *	BusinessID数据库列名
   */
  public final static String BUSINESSID_FIELD =  "BusinessID";
  
  /**
   *	BusinessID字段中文名，用于视图展示
   */
  public final static String BUSINESSID_LABLE = "业务编号";
  
  /**
   *	BusinessID对应的java字段名,业务操作使用这个字段。
   */
  private Long businessID;
  
  /**
   *	BusinessType数据库列名
   */
  public final static String BUSINESSTYPE_FIELD =  "BusinessType";
  
  /**
   *	BusinessType字段中文名，用于视图展示
   */
  public final static String BUSINESSTYPE_LABLE = "业务类型";
  
  /**
   *	BusinessType对应的java字段名,业务操作使用这个字段。
   */
  private Long businessType;
  
  /**
   *	ChangeAmount数据库列名
   */
  public final static String CHANGEAMOUNT_FIELD =  "ChangeAmount";
  
  /**
   *	ChangeAmount字段中文名，用于视图展示
   */
  public final static String CHANGEAMOUNT_LABLE = "变动数量";
  
  /**
   *	ChangeAmount对应的java字段名,业务操作使用这个字段。
   */
  private Integer changeAmount;
  
  /**
   *	ChangeCode数据库列名
   */
  public final static String CHANGECODE_FIELD =  "ChangeCode";
  
  /**
   *	ChangeCode字段中文名，用于视图展示
   */
  public final static String CHANGECODE_LABLE = "变动编码";
  
  /**
   *	ChangeCode对应的java字段名,业务操作使用这个字段。
   */
  private String changeCode;
  
  /**
   *	ChangeID数据库列名
   */
  public final static String CHANGEID_FIELD =  "ChangeID";
  
  /**
   *	ChangeID字段中文名，用于视图展示
   */
  public final static String CHANGEID_LABLE = "变动编号";
  
  /**
   *	ChangeID对应的java字段名,业务操作使用这个字段。
   */
  private Long changeID;
  
  /**
   *	ChangeReason数据库列名
   */
  public final static String CHANGEREASON_FIELD =  "ChangeReason";
  
  /**
   *	ChangeReason字段中文名，用于视图展示
   */
  public final static String CHANGEREASON_LABLE = "变动原因";
  
  /**
   *	ChangeReason对应的java字段名,业务操作使用这个字段。
   */
  private String changeReason;
  
  /**
   *	ChangeType数据库列名
   */
  public final static String CHANGETYPE_FIELD =  "ChangeType";
  
  /**
   *	ChangeType字段中文名，用于视图展示
   */
  public final static String CHANGETYPE_LABLE = "变动方式";
  
  /**
   *	ChangeType对应的java字段名,业务操作使用这个字段。
   */
  private Long changeType;
  
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
   *	CustomerID数据库列名
   */
  public final static String CUSTOMERID_FIELD =  "CustomerID";
  
  /**
   *	CustomerID字段中文名，用于视图展示
   */
  public final static String CUSTOMERID_LABLE = "客户编号";
  
  /**
   *	CustomerID对应的java字段名,业务操作使用这个字段。
   */
  private Long customerID;
  
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
   * 变动后数量 getter
   */
  public Integer getAfterAmount(){
    return afterAmount;
  }
  /**
   * 变动后数量 setter
   * @param AfterAmount
   */  
  public void setAfterAmount(Integer afterAmount){
    this.afterAmount = afterAmount;
  }
 
  /**
   * 变动前数量 getter
   */
  public Integer getBeforeAmount(){
    return beforeAmount;
  }
  /**
   * 变动前数量 setter
   * @param BeforeAmount
   */  
  public void setBeforeAmount(Integer beforeAmount){
    this.beforeAmount = beforeAmount;
  }
 
  /**
   * 积分编号 getter
   */
  public Long getBonusID(){
    return bonusID;
  }
  /**
   * 积分编号 setter
   * @param BonusID
   */  
  public void setBonusID(Long bonusID){
    this.bonusID = bonusID;
  }
 
  /**
   * 积分比例 getter
   */
  public Float getBonusRate(){
    return bonusRate;
  }
  /**
   * 积分比例 setter
   * @param BonusRate
   */  
  public void setBonusRate(Float bonusRate){
    this.bonusRate = bonusRate;
  }
 
  /**
   * 业务编号 getter
   */
  public Long getBusinessID(){
    return businessID;
  }
  /**
   * 业务编号 setter
   * @param BusinessID
   */  
  public void setBusinessID(Long businessID){
    this.businessID = businessID;
  }
 
  /**
   * 业务类型 getter
   */
  public Long getBusinessType(){
    return businessType;
  }
  /**
   * 业务类型 setter
   * @param BusinessType
   */  
  public void setBusinessType(Long businessType){
    this.businessType = businessType;
  }
 
  /**
   * 变动数量 getter
   */
  public Integer getChangeAmount(){
    return changeAmount;
  }
  /**
   * 变动数量 setter
   * @param ChangeAmount
   */  
  public void setChangeAmount(Integer changeAmount){
    this.changeAmount = changeAmount;
  }
 
  /**
   * 变动编码 getter
   */
  public String getChangeCode(){
    return changeCode;
  }
  /**
   * 变动编码 setter
   * @param ChangeCode
   */  
  public void setChangeCode(String changeCode){
    this.changeCode = changeCode;
  }
 
  /**
   * 变动编号 getter
   */
  public Long getChangeID(){
    return changeID;
  }
  /**
   * 变动编号 setter
   * @param ChangeID
   */  
  public void setChangeID(Long changeID){
    this.changeID = changeID;
  }
 
  /**
   * 变动原因 getter
   */
  public String getChangeReason(){
    return changeReason;
  }
  /**
   * 变动原因 setter
   * @param ChangeReason
   */  
  public void setChangeReason(String changeReason){
    this.changeReason = changeReason;
  }
 
  /**
   * 变动方式 getter
   */
  public Long getChangeType(){
    return changeType;
  }
  /**
   * 变动方式 setter
   * @param ChangeType
   */  
  public void setChangeType(Long changeType){
    this.changeType = changeType;
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
   * 客户编号 getter
   */
  public Long getCustomerID(){
    return customerID;
  }
  /**
   * 客户编号 setter
   * @param CustomerID
   */  
  public void setCustomerID(Long customerID){
    this.customerID = customerID;
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
 
}