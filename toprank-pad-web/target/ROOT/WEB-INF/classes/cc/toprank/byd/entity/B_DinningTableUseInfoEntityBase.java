package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_DinningTableUseInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_DinningTableUseInfoEntityBase extends Entity {

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
   *	CashierLoginID数据库列名
   */
  public final static java.lang.String CASHIERLOGINID_FIELD =  "CashierLoginID";
  
  /**
   *	CashierLoginID字段中文名，用于视图展示
   */
  public final static java.lang.String CASHIERLOGINID_LABLE = "收银员";
  
  /**
   *	CashierLoginID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long cashierLoginID;
  
  /**
   *	CombineName数据库列名
   */
  public final static java.lang.String COMBINENAME_FIELD =  "CombineName";
  
  /**
   *	CombineName字段中文名，用于视图展示
   */
  public final static java.lang.String COMBINENAME_LABLE = "合台名称";
  
  /**
   *	CombineName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String combineName;
  
  /**
   *	CombineNumber数据库列名
   */
  public final static java.lang.String COMBINENUMBER_FIELD =  "CombineNumber";
  
  /**
   *	CombineNumber字段中文名，用于视图展示
   */
  public final static java.lang.String COMBINENUMBER_LABLE = "合台数量";
  
  /**
   *	CombineNumber对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer combineNumber;
  
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
   *	CustomerNumber数据库列名
   */
  public final static java.lang.String CUSTOMERNUMBER_FIELD =  "CustomerNumber";
  
  /**
   *	CustomerNumber字段中文名，用于视图展示
   */
  public final static java.lang.String CUSTOMERNUMBER_LABLE = "消费人数";
  
  /**
   *	CustomerNumber对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer customerNumber;
  
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
   *	EndTime数据库列名
   */
  public final static java.lang.String ENDTIME_FIELD =  "EndTime";
  
  /**
   *	EndTime字段中文名，用于视图展示
   */
  public final static java.lang.String ENDTIME_LABLE = "结束时间";
  
  /**
   *	EndTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime endTime;
  
  /**
   *	HisID数据库列名
   */
  public final static java.lang.String HISID_FIELD =  "HisID";
  
  /**
   *	HisID字段中文名，用于视图展示
   */
  public final static java.lang.String HISID_LABLE = "记录编号";
  
  /**
   *	HisID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long hisID;
  
  /**
   *	IsBooking数据库列名
   */
  public final static java.lang.String ISBOOKING_FIELD =  "IsBooking";
  
  /**
   *	IsBooking字段中文名，用于视图展示
   */
  public final static java.lang.String ISBOOKING_LABLE = "是否预订";
  
  /**
   *	IsBooking对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isBooking;
  
  /**
   *	IsCombine数据库列名
   */
  public final static java.lang.String ISCOMBINE_FIELD =  "IsCombine";
  
  /**
   *	IsCombine字段中文名，用于视图展示
   */
  public final static java.lang.String ISCOMBINE_LABLE = "是否合台";
  
  /**
   *	IsCombine对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isCombine;
  
  /**
   *	IsSharing数据库列名
   */
  public final static java.lang.String ISSHARING_FIELD =  "IsSharing";
  
  /**
   *	IsSharing字段中文名，用于视图展示
   */
  public final static java.lang.String ISSHARING_LABLE = "是否拼桌";
  
  /**
   *	IsSharing对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isSharing;
  
  /**
   *	IsSplit数据库列名
   */
  public final static java.lang.String ISSPLIT_FIELD =  "IsSplit";
  
  /**
   *	IsSplit字段中文名，用于视图展示
   */
  public final static java.lang.String ISSPLIT_LABLE = "是否拆台";
  
  /**
   *	IsSplit对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isSplit;
  
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
   *	RecommendBookingTime数据库列名
   */
  public final static java.lang.String RECOMMENDBOOKINGTIME_FIELD =  "RecommendBookingTime";
  
  /**
   *	RecommendBookingTime字段中文名，用于视图展示
   */
  public final static java.lang.String RECOMMENDBOOKINGTIME_LABLE = "建议预订时间";
  
  /**
   *	RecommendBookingTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime recommendBookingTime;
  
  /**
   *	RelationTable数据库列名
   */
  public final static java.lang.String RELATIONTABLE_FIELD =  "RelationTable";
  
  /**
   *	RelationTable字段中文名，用于视图展示
   */
  public final static java.lang.String RELATIONTABLE_LABLE = "关联桌台";
  
  /**
   *	RelationTable对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String relationTable;
  
  /**
   *	ShareNumber数据库列名
   */
  public final static java.lang.String SHARENUMBER_FIELD =  "ShareNumber";
  
  /**
   *	ShareNumber字段中文名，用于视图展示
   */
  public final static java.lang.String SHARENUMBER_LABLE = "拼桌数量";
  
  /**
   *	ShareNumber对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer shareNumber;
  
  /**
   *	SplitNumber数据库列名
   */
  public final static java.lang.String SPLITNUMBER_FIELD =  "SplitNumber";
  
  /**
   *	SplitNumber字段中文名，用于视图展示
   */
  public final static java.lang.String SPLITNUMBER_LABLE = "拆台数量";
  
  /**
   *	SplitNumber对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer splitNumber;
  
  /**
   *	StartTime数据库列名
   */
  public final static java.lang.String STARTTIME_FIELD =  "StartTime";
  
  /**
   *	StartTime字段中文名，用于视图展示
   */
  public final static java.lang.String STARTTIME_LABLE = "开始时间";
  
  /**
   *	StartTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime startTime;
  
  /**
   *	TableID数据库列名
   */
  public final static java.lang.String TABLEID_FIELD =  "TableID";
  
  /**
   *	TableID字段中文名，用于视图展示
   */
  public final static java.lang.String TABLEID_LABLE = "桌台编号";
  
  /**
   *	TableID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long tableID;
  
  /**
   *	TotalAmount数据库列名
   */
  public final static java.lang.String TOTALAMOUNT_FIELD =  "TotalAmount";
  
  /**
   *	TotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String TOTALAMOUNT_LABLE = "消费金额";
  
  /**
   *	TotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal totalAmount;
  
  /**
   *	UseMethod数据库列名
   */
  public final static java.lang.String USEMETHOD_FIELD =  "UseMethod";
  
  /**
   *	UseMethod字段中文名，用于视图展示
   */
  public final static java.lang.String USEMETHOD_LABLE = "使用方式";
  
  /**
   *	UseMethod对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long useMethod;
  
  /**
   *	UseTime数据库列名
   */
  public final static java.lang.String USETIME_FIELD =  "UseTime";
  
  /**
   *	UseTime字段中文名，用于视图展示
   */
  public final static java.lang.String USETIME_LABLE = "使用时长";
  
  /**
   *	UseTime对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer useTime;
  
  /**
   *	WaiterLoginID数据库列名
   */
  public final static java.lang.String WAITERLOGINID_FIELD =  "WaiterLoginID";
  
  /**
   *	WaiterLoginID字段中文名，用于视图展示
   */
  public final static java.lang.String WAITERLOGINID_LABLE = "服务员";
  
  /**
   *	WaiterLoginID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long waiterLoginID;
  
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
   * 收银员 getter
   */
  public java.lang.Long getCashierLoginID(){
    return cashierLoginID;
  }
  /**
   * 收银员 setter
   * @param CashierLoginID
   */  
  public void setCashierLoginID(java.lang.Long cashierLoginID){
    this.cashierLoginID = cashierLoginID;
  }
 
  /**
   * 合台名称 getter
   */
  public java.lang.String getCombineName(){
    return combineName;
  }
  /**
   * 合台名称 setter
   * @param CombineName
   */  
  public void setCombineName(java.lang.String combineName){
    this.combineName = combineName;
  }
 
  /**
   * 合台数量 getter
   */
  public java.lang.Integer getCombineNumber(){
    return combineNumber;
  }
  /**
   * 合台数量 setter
   * @param CombineNumber
   */  
  public void setCombineNumber(java.lang.Integer combineNumber){
    this.combineNumber = combineNumber;
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
   * 消费人数 getter
   */
  public java.lang.Integer getCustomerNumber(){
    return customerNumber;
  }
  /**
   * 消费人数 setter
   * @param CustomerNumber
   */  
  public void setCustomerNumber(java.lang.Integer customerNumber){
    this.customerNumber = customerNumber;
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
   * 结束时间 getter
   */
  public java.time.LocalDateTime getEndTime(){
    return endTime;
  }
  /**
   * 结束时间 setter
   * @param EndTime
   */  
  public void setEndTime(java.time.LocalDateTime endTime){
    this.endTime = endTime;
  }
 
  /**
   * 记录编号 getter
   */
  public java.lang.Long getHisID(){
    return hisID;
  }
  /**
   * 记录编号 setter
   * @param HisID
   */  
  public void setHisID(java.lang.Long hisID){
    this.hisID = hisID;
  }
 
  /**
   * 是否预订 getter
   */
  public java.lang.Boolean getIsBooking(){
    return isBooking;
  }
  /**
   * 是否预订 setter
   * @param IsBooking
   */  
  public void setIsBooking(java.lang.Boolean isBooking){
    this.isBooking = isBooking;
  }
 
  /**
   * 是否合台 getter
   */
  public java.lang.Boolean getIsCombine(){
    return isCombine;
  }
  /**
   * 是否合台 setter
   * @param IsCombine
   */  
  public void setIsCombine(java.lang.Boolean isCombine){
    this.isCombine = isCombine;
  }
 
  /**
   * 是否拼桌 getter
   */
  public java.lang.Boolean getIsSharing(){
    return isSharing;
  }
  /**
   * 是否拼桌 setter
   * @param IsSharing
   */  
  public void setIsSharing(java.lang.Boolean isSharing){
    this.isSharing = isSharing;
  }
 
  /**
   * 是否拆台 getter
   */
  public java.lang.Boolean getIsSplit(){
    return isSplit;
  }
  /**
   * 是否拆台 setter
   * @param IsSplit
   */  
  public void setIsSplit(java.lang.Boolean isSplit){
    this.isSplit = isSplit;
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
   * 建议预订时间 getter
   */
  public java.time.LocalDateTime getRecommendBookingTime(){
    return recommendBookingTime;
  }
  /**
   * 建议预订时间 setter
   * @param RecommendBookingTime
   */  
  public void setRecommendBookingTime(java.time.LocalDateTime recommendBookingTime){
    this.recommendBookingTime = recommendBookingTime;
  }
 
  /**
   * 关联桌台 getter
   */
  public java.lang.String getRelationTable(){
    return relationTable;
  }
  /**
   * 关联桌台 setter
   * @param RelationTable
   */  
  public void setRelationTable(java.lang.String relationTable){
    this.relationTable = relationTable;
  }
 
  /**
   * 拼桌数量 getter
   */
  public java.lang.Integer getShareNumber(){
    return shareNumber;
  }
  /**
   * 拼桌数量 setter
   * @param ShareNumber
   */  
  public void setShareNumber(java.lang.Integer shareNumber){
    this.shareNumber = shareNumber;
  }
 
  /**
   * 拆台数量 getter
   */
  public java.lang.Integer getSplitNumber(){
    return splitNumber;
  }
  /**
   * 拆台数量 setter
   * @param SplitNumber
   */  
  public void setSplitNumber(java.lang.Integer splitNumber){
    this.splitNumber = splitNumber;
  }
 
  /**
   * 开始时间 getter
   */
  public java.time.LocalDateTime getStartTime(){
    return startTime;
  }
  /**
   * 开始时间 setter
   * @param StartTime
   */  
  public void setStartTime(java.time.LocalDateTime startTime){
    this.startTime = startTime;
  }
 
  /**
   * 桌台编号 getter
   */
  public java.lang.Long getTableID(){
    return tableID;
  }
  /**
   * 桌台编号 setter
   * @param TableID
   */  
  public void setTableID(java.lang.Long tableID){
    this.tableID = tableID;
  }
 
  /**
   * 消费金额 getter
   */
  public java.math.BigDecimal getTotalAmount(){
    return totalAmount;
  }
  /**
   * 消费金额 setter
   * @param TotalAmount
   */  
  public void setTotalAmount(java.math.BigDecimal totalAmount){
    this.totalAmount = totalAmount;
  }
 
  /**
   * 使用方式 getter
   */
  public java.lang.Long getUseMethod(){
    return useMethod;
  }
  /**
   * 使用方式 setter
   * @param UseMethod
   */  
  public void setUseMethod(java.lang.Long useMethod){
    this.useMethod = useMethod;
  }
 
  /**
   * 使用时长 getter
   */
  public java.lang.Integer getUseTime(){
    return useTime;
  }
  /**
   * 使用时长 setter
   * @param UseTime
   */  
  public void setUseTime(java.lang.Integer useTime){
    this.useTime = useTime;
  }
 
  /**
   * 服务员 getter
   */
  public java.lang.Long getWaiterLoginID(){
    return waiterLoginID;
  }
  /**
   * 服务员 setter
   * @param WaiterLoginID
   */  
  public void setWaiterLoginID(java.lang.Long waiterLoginID){
    this.waiterLoginID = waiterLoginID;
  }
 
}