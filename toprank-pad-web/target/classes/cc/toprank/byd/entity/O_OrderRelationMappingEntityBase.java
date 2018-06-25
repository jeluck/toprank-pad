package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_OrderRelationMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_OrderRelationMappingEntityBase extends Entity {

  /**
   *	ActualAmount数据库列名
   */
  public final static java.lang.String ACTUALAMOUNT_FIELD =  "ActualAmount";
  
  /**
   *	ActualAmount字段中文名，用于视图展示
   */
  public final static java.lang.String ACTUALAMOUNT_LABLE = "实际金额";
  
  /**
   *	ActualAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal actualAmount;
  
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
  public final static java.lang.String DISCOUNTAMOUNT_LABLE = "折扣金额";
  
  /**
   *	DiscountAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal discountAmount;
  
  /**
   *	IsOrder数据库列名
   */
  public final static java.lang.String ISORDER_FIELD =  "IsOrder";
  
  /**
   *	IsOrder字段中文名，用于视图展示
   */
  public final static java.lang.String ISORDER_LABLE = "是否订单";
  
  /**
   *	IsOrder对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isOrder;
  
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
   *	MappingDesc数据库列名
   */
  public final static java.lang.String MAPPINGDESC_FIELD =  "MappingDesc";
  
  /**
   *	MappingDesc字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGDESC_LABLE = "关联描述";
  
  /**
   *	MappingDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String mappingDesc;
  
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
   *	MappingStatus数据库列名
   */
  public final static java.lang.String MAPPINGSTATUS_FIELD =  "MappingStatus";
  
  /**
   *	MappingStatus字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGSTATUS_LABLE = "关联状态";
  
  /**
   *	MappingStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mappingStatus;
  
  /**
   *	MappingType数据库列名
   */
  public final static java.lang.String MAPPINGTYPE_FIELD =  "MappingType";
  
  /**
   *	MappingType字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGTYPE_LABLE = "关联类别";
  
  /**
   *	MappingType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mappingType;
  
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
   *	OrderAmount数据库列名
   */
  public final static java.lang.String ORDERAMOUNT_FIELD =  "OrderAmount";
  
  /**
   *	OrderAmount字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERAMOUNT_LABLE = "订单金额";
  
  /**
   *	OrderAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal orderAmount;
  
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
   *	PaidTime数据库列名
   */
  public final static java.lang.String PAIDTIME_FIELD =  "PaidTime";
  
  /**
   *	PaidTime字段中文名，用于视图展示
   */
  public final static java.lang.String PAIDTIME_LABLE = "付款时间";
  
  /**
   *	PaidTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime paidTime;
  
  /**
   *	PaymentMethodID数据库列名
   */
  public final static java.lang.String PAYMENTMETHODID_FIELD =  "PaymentMethodID";
  
  /**
   *	PaymentMethodID字段中文名，用于视图展示
   */
  public final static java.lang.String PAYMENTMETHODID_LABLE = "支付方式";
  
  /**
   *	PaymentMethodID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long paymentMethodID;
  
  /**
   *	PayStatus数据库列名
   */
  public final static java.lang.String PAYSTATUS_FIELD =  "PayStatus";
  
  /**
   *	PayStatus字段中文名，用于视图展示
   */
  public final static java.lang.String PAYSTATUS_LABLE = "支付状态";
  
  /**
   *	PayStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long payStatus;
  
  /**
   *	PendingAmount数据库列名
   */
  public final static java.lang.String PENDINGAMOUNT_FIELD =  "PendingAmount";
  
  /**
   *	PendingAmount字段中文名，用于视图展示
   */
  public final static java.lang.String PENDINGAMOUNT_LABLE = "待付金额";
  
  /**
   *	PendingAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal pendingAmount;
  
  /**
   *	Quantity数据库列名
   */
  public final static java.lang.String QUANTITY_FIELD =  "Quantity";
  
  /**
   *	Quantity字段中文名，用于视图展示
   */
  public final static java.lang.String QUANTITY_LABLE = "商品数量";
  
  /**
   *	Quantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer quantity;
  
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
   *	SyncTime数据库列名
   */
  public final static java.lang.String SYNCTIME_FIELD =  "SyncTime";
  
  /**
   *	SyncTime字段中文名，用于视图展示
   */
  public final static java.lang.String SYNCTIME_LABLE = "SyncTime";
  
  /**
   *	SyncTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTime;
  
  /**
   *	SyncTimeResult数据库列名
   */
  public final static java.lang.String SYNCTIMERESULT_FIELD =  "SyncTimeResult";
  
  /**
   *	SyncTimeResult字段中文名，用于视图展示
   */
  public final static java.lang.String SYNCTIMERESULT_LABLE = "SyncTimeResult";
  
  /**
   *	SyncTimeResult对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTimeResult;
  
  /**
   *	TotalAmount数据库列名
   */
  public final static java.lang.String TOTALAMOUNT_FIELD =  "TotalAmount";
  
  /**
   *	TotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String TOTALAMOUNT_LABLE = "订单总额";
  
  /**
   *	TotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal totalAmount;
  
  /**
   * 实际金额 getter
   */
  public java.math.BigDecimal getActualAmount(){
    return actualAmount;
  }
  /**
   * 实际金额 setter
   * @param ActualAmount
   */  
  public void setActualAmount(java.math.BigDecimal actualAmount){
    this.actualAmount = actualAmount;
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
   * 折扣金额 getter
   */
  public java.math.BigDecimal getDiscountAmount(){
    return discountAmount;
  }
  /**
   * 折扣金额 setter
   * @param DiscountAmount
   */  
  public void setDiscountAmount(java.math.BigDecimal discountAmount){
    this.discountAmount = discountAmount;
  }
 
  /**
   * 是否订单 getter
   */
  public java.lang.Boolean getIsOrder(){
    return isOrder;
  }
  /**
   * 是否订单 setter
   * @param IsOrder
   */  
  public void setIsOrder(java.lang.Boolean isOrder){
    this.isOrder = isOrder;
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
   * 关联描述 getter
   */
  public java.lang.String getMappingDesc(){
    return mappingDesc;
  }
  /**
   * 关联描述 setter
   * @param MappingDesc
   */  
  public void setMappingDesc(java.lang.String mappingDesc){
    this.mappingDesc = mappingDesc;
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
   * 关联状态 getter
   */
  public java.lang.Long getMappingStatus(){
    return mappingStatus;
  }
  /**
   * 关联状态 setter
   * @param MappingStatus
   */  
  public void setMappingStatus(java.lang.Long mappingStatus){
    this.mappingStatus = mappingStatus;
  }
 
  /**
   * 关联类别 getter
   */
  public java.lang.Long getMappingType(){
    return mappingType;
  }
  /**
   * 关联类别 setter
   * @param MappingType
   */  
  public void setMappingType(java.lang.Long mappingType){
    this.mappingType = mappingType;
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
   * 订单金额 getter
   */
  public java.math.BigDecimal getOrderAmount(){
    return orderAmount;
  }
  /**
   * 订单金额 setter
   * @param OrderAmount
   */  
  public void setOrderAmount(java.math.BigDecimal orderAmount){
    this.orderAmount = orderAmount;
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
   * 付款时间 getter
   */
  public java.time.LocalDateTime getPaidTime(){
    return paidTime;
  }
  /**
   * 付款时间 setter
   * @param PaidTime
   */  
  public void setPaidTime(java.time.LocalDateTime paidTime){
    this.paidTime = paidTime;
  }
 
  /**
   * 支付方式 getter
   */
  public java.lang.Long getPaymentMethodID(){
    return paymentMethodID;
  }
  /**
   * 支付方式 setter
   * @param PaymentMethodID
   */  
  public void setPaymentMethodID(java.lang.Long paymentMethodID){
    this.paymentMethodID = paymentMethodID;
  }
 
  /**
   * 支付状态 getter
   */
  public java.lang.Long getPayStatus(){
    return payStatus;
  }
  /**
   * 支付状态 setter
   * @param PayStatus
   */  
  public void setPayStatus(java.lang.Long payStatus){
    this.payStatus = payStatus;
  }
 
  /**
   * 待付金额 getter
   */
  public java.math.BigDecimal getPendingAmount(){
    return pendingAmount;
  }
  /**
   * 待付金额 setter
   * @param PendingAmount
   */  
  public void setPendingAmount(java.math.BigDecimal pendingAmount){
    this.pendingAmount = pendingAmount;
  }
 
  /**
   * 商品数量 getter
   */
  public java.lang.Integer getQuantity(){
    return quantity;
  }
  /**
   * 商品数量 setter
   * @param Quantity
   */  
  public void setQuantity(java.lang.Integer quantity){
    this.quantity = quantity;
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
   * SyncTime getter
   */
  public java.time.LocalDateTime getSyncTime(){
    return syncTime;
  }
  /**
   * SyncTime setter
   * @param SyncTime
   */  
  public void setSyncTime(java.time.LocalDateTime syncTime){
    this.syncTime = syncTime;
  }
 
  /**
   * SyncTimeResult getter
   */
  public java.time.LocalDateTime getSyncTimeResult(){
    return syncTimeResult;
  }
  /**
   * SyncTimeResult setter
   * @param SyncTimeResult
   */  
  public void setSyncTimeResult(java.time.LocalDateTime syncTimeResult){
    this.syncTimeResult = syncTimeResult;
  }
 
  /**
   * 订单总额 getter
   */
  public java.math.BigDecimal getTotalAmount(){
    return totalAmount;
  }
  /**
   * 订单总额 setter
   * @param TotalAmount
   */  
  public void setTotalAmount(java.math.BigDecimal totalAmount){
    this.totalAmount = totalAmount;
  }
 
}