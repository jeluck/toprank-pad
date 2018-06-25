package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_OrderDealInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_OrderDealInfoEntityBase extends Entity {

  /**
   *	AfterAmount数据库列名
   */
  public final static java.lang.String AFTERAMOUNT_FIELD =  "AfterAmount";
  
  /**
   *	AfterAmount字段中文名，用于视图展示
   */
  public final static java.lang.String AFTERAMOUNT_LABLE = "处理后金额";
  
  /**
   *	AfterAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal afterAmount;
  
  /**
   *	AfterStatus数据库列名
   */
  public final static java.lang.String AFTERSTATUS_FIELD =  "AfterStatus";
  
  /**
   *	AfterStatus字段中文名，用于视图展示
   */
  public final static java.lang.String AFTERSTATUS_LABLE = "处理后状态";
  
  /**
   *	AfterStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long afterStatus;
  
  /**
   *	BeforeAmount数据库列名
   */
  public final static java.lang.String BEFOREAMOUNT_FIELD =  "BeforeAmount";
  
  /**
   *	BeforeAmount字段中文名，用于视图展示
   */
  public final static java.lang.String BEFOREAMOUNT_LABLE = "处理前金额";
  
  /**
   *	BeforeAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal beforeAmount;
  
  /**
   *	BeforeStatus数据库列名
   */
  public final static java.lang.String BEFORESTATUS_FIELD =  "BeforeStatus";
  
  /**
   *	BeforeStatus字段中文名，用于视图展示
   */
  public final static java.lang.String BEFORESTATUS_LABLE = "处理前状态";
  
  /**
   *	BeforeStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long beforeStatus;
  
  /**
   *	ChangeAmount数据库列名
   */
  public final static java.lang.String CHANGEAMOUNT_FIELD =  "ChangeAmount";
  
  /**
   *	ChangeAmount字段中文名，用于视图展示
   */
  public final static java.lang.String CHANGEAMOUNT_LABLE = "变动金额";
  
  /**
   *	ChangeAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal changeAmount;
  
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
  public final static java.lang.String CREATORID_LABLE = "处理人编号";
  
  /**
   *	CreatorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long creatorID;
  
  /**
   *	CreatorType数据库列名
   */
  public final static java.lang.String CREATORTYPE_FIELD =  "CreatorType";
  
  /**
   *	CreatorType字段中文名，用于视图展示
   */
  public final static java.lang.String CREATORTYPE_LABLE = "处理人类别";
  
  /**
   *	CreatorType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long creatorType;
  
  /**
   *	DealCode数据库列名
   */
  public final static java.lang.String DEALCODE_FIELD =  "DealCode";
  
  /**
   *	DealCode字段中文名，用于视图展示
   */
  public final static java.lang.String DEALCODE_LABLE = "处理编码";
  
  /**
   *	DealCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String dealCode;
  
  /**
   *	DealDesc数据库列名
   */
  public final static java.lang.String DEALDESC_FIELD =  "DealDesc";
  
  /**
   *	DealDesc字段中文名，用于视图展示
   */
  public final static java.lang.String DEALDESC_LABLE = "处理描述";
  
  /**
   *	DealDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String dealDesc;
  
  /**
   *	DealID数据库列名
   */
  public final static java.lang.String DEALID_FIELD =  "DealID";
  
  /**
   *	DealID字段中文名，用于视图展示
   */
  public final static java.lang.String DEALID_LABLE = "处理编号";
  
  /**
   *	DealID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long dealID;
  
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
   *	OrderID数据库列名
   */
  public final static java.lang.String ORDERID_FIELD =  "OrderID";
  
  /**
   *	OrderID字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERID_LABLE = "订单编号";
  
  /**
   *	OrderID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orderID;
  
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
   *	SubOrderID数据库列名
   */
  public final static java.lang.String SUBORDERID_FIELD =  "SubOrderID";
  
  /**
   *	SubOrderID字段中文名，用于视图展示
   */
  public final static java.lang.String SUBORDERID_LABLE = "子订单编号";
  
  /**
   *	SubOrderID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long subOrderID;
  
  /**
   * 处理后金额 getter
   */
  public java.math.BigDecimal getAfterAmount(){
    return afterAmount;
  }
  /**
   * 处理后金额 setter
   * @param AfterAmount
   */  
  public void setAfterAmount(java.math.BigDecimal afterAmount){
    this.afterAmount = afterAmount;
  }
 
  /**
   * 处理后状态 getter
   */
  public java.lang.Long getAfterStatus(){
    return afterStatus;
  }
  /**
   * 处理后状态 setter
   * @param AfterStatus
   */  
  public void setAfterStatus(java.lang.Long afterStatus){
    this.afterStatus = afterStatus;
  }
 
  /**
   * 处理前金额 getter
   */
  public java.math.BigDecimal getBeforeAmount(){
    return beforeAmount;
  }
  /**
   * 处理前金额 setter
   * @param BeforeAmount
   */  
  public void setBeforeAmount(java.math.BigDecimal beforeAmount){
    this.beforeAmount = beforeAmount;
  }
 
  /**
   * 处理前状态 getter
   */
  public java.lang.Long getBeforeStatus(){
    return beforeStatus;
  }
  /**
   * 处理前状态 setter
   * @param BeforeStatus
   */  
  public void setBeforeStatus(java.lang.Long beforeStatus){
    this.beforeStatus = beforeStatus;
  }
 
  /**
   * 变动金额 getter
   */
  public java.math.BigDecimal getChangeAmount(){
    return changeAmount;
  }
  /**
   * 变动金额 setter
   * @param ChangeAmount
   */  
  public void setChangeAmount(java.math.BigDecimal changeAmount){
    this.changeAmount = changeAmount;
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
   * 处理人编号 getter
   */
  public java.lang.Long getCreatorID(){
    return creatorID;
  }
  /**
   * 处理人编号 setter
   * @param CreatorID
   */  
  public void setCreatorID(java.lang.Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * 处理人类别 getter
   */
  public java.lang.Long getCreatorType(){
    return creatorType;
  }
  /**
   * 处理人类别 setter
   * @param CreatorType
   */  
  public void setCreatorType(java.lang.Long creatorType){
    this.creatorType = creatorType;
  }
 
  /**
   * 处理编码 getter
   */
  public java.lang.String getDealCode(){
    return dealCode;
  }
  /**
   * 处理编码 setter
   * @param DealCode
   */  
  public void setDealCode(java.lang.String dealCode){
    this.dealCode = dealCode;
  }
 
  /**
   * 处理描述 getter
   */
  public java.lang.String getDealDesc(){
    return dealDesc;
  }
  /**
   * 处理描述 setter
   * @param DealDesc
   */  
  public void setDealDesc(java.lang.String dealDesc){
    this.dealDesc = dealDesc;
  }
 
  /**
   * 处理编号 getter
   */
  public java.lang.Long getDealID(){
    return dealID;
  }
  /**
   * 处理编号 setter
   * @param DealID
   */  
  public void setDealID(java.lang.Long dealID){
    this.dealID = dealID;
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
   * 订单编号 getter
   */
  public java.lang.Long getOrderID(){
    return orderID;
  }
  /**
   * 订单编号 setter
   * @param OrderID
   */  
  public void setOrderID(java.lang.Long orderID){
    this.orderID = orderID;
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
   * 子订单编号 getter
   */
  public java.lang.Long getSubOrderID(){
    return subOrderID;
  }
  /**
   * 子订单编号 setter
   * @param SubOrderID
   */  
  public void setSubOrderID(java.lang.Long subOrderID){
    this.subOrderID = subOrderID;
  }
 
}