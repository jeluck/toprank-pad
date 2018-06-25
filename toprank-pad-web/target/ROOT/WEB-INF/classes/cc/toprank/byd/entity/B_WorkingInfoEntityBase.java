package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_WorkingInfo类中进行修改
 *
 * ********************************************************************************************************************/
public class B_WorkingInfoEntityBase extends Entity {

  /**
   *	ArchiveID数据库列名
   */
  public final static java.lang.String ARCHIVEID_FIELD =  "ArchiveID";

  /**
   *	ArchiveID字段中文名，用于视图展示
   */
  public final static java.lang.String ARCHIVEID_LABLE = "ArchiveID";

  /**
   *	ArchiveID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long archiveID;

  /**
   *	BeforeID数据库列名
   */
  public final static java.lang.String BEFOREID_FIELD =  "BeforeID";

  /**
   *	BeforeID字段中文名，用于视图展示
   */
  public final static java.lang.String BEFOREID_LABLE = "上一班次";

  /**
   *	BeforeID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long beforeID;

  /**
   *	BookingCashAmount数据库列名
   */
  public final static java.lang.String BOOKINGCASHAMOUNT_FIELD =  "BookingCashAmount";

  /**
   *	BookingCashAmount字段中文名，用于视图展示
   */
  public final static java.lang.String BOOKINGCASHAMOUNT_LABLE = "BookingCashAmount";

  /**
   *	BookingCashAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal bookingCashAmount;

  /**
   *	BookingNum数据库列名
   */
  public final static java.lang.String BOOKINGNUM_FIELD =  "BookingNum";

  /**
   *	BookingNum字段中文名，用于视图展示
   */
  public final static java.lang.String BOOKINGNUM_LABLE = "预订单数";

  /**
   *	BookingNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer bookingNum;

  /**
   *	BookingTotalAmount数据库列名
   */
  public final static java.lang.String BOOKINGTOTALAMOUNT_FIELD =  "BookingTotalAmount";

  /**
   *	BookingTotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String BOOKINGTOTALAMOUNT_LABLE = "BookingTotalAmount";

  /**
   *	BookingTotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal bookingTotalAmount;

  /**
   *	CashTotalAmount数据库列名
   */
  public final static java.lang.String CASHTOTALAMOUNT_FIELD =  "CashTotalAmount";

  /**
   *	CashTotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String CASHTOTALAMOUNT_LABLE = "现金总额";

  /**
   *	CashTotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal cashTotalAmount;

  /**
   *	CreateTime数据库列名
   */
  public final static java.lang.String CREATETIME_FIELD =  "CreateTime";

  /**
   *	CreateTime字段中文名，用于视图展示
   */
  public final static java.lang.String CREATETIME_LABLE = "CreateTime";

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
   *	CreatorName数据库列名
   */
  public final static java.lang.String CREATORNAME_FIELD =  "CreatorName";

  /**
   *	CreatorName字段中文名，用于视图展示
   */
  public final static java.lang.String CREATORNAME_LABLE = "CreatorName";

  /**
   *	CreatorName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String creatorName;

  /**
   *	DeviceCode数据库列名
   */
  public final static java.lang.String DEVICECODE_FIELD =  "DeviceCode";

  /**
   *	DeviceCode字段中文名，用于视图展示
   */
  public final static java.lang.String DEVICECODE_LABLE = "设备号";

  /**
   *	DeviceCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String deviceCode;

  /**
   *	DeviceID数据库列名
   */
  public final static java.lang.String DEVICEID_FIELD =  "DeviceID";

  /**
   *	DeviceID字段中文名，用于视图展示
   */
  public final static java.lang.String DEVICEID_LABLE = "DeviceID";

  /**
   *	DeviceID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long deviceID;

  /**
   *	DeviceType数据库列名
   */
  public final static java.lang.String DEVICETYPE_FIELD =  "DeviceType";

  /**
   *	DeviceType字段中文名，用于视图展示
   */
  public final static java.lang.String DEVICETYPE_LABLE = "设备类型";

  /**
   *	DeviceType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long deviceType;

  /**
   *	IncomeCashAmount数据库列名
   */
  public final static java.lang.String INCOMECASHAMOUNT_FIELD =  "IncomeCashAmount";

  /**
   *	IncomeCashAmount字段中文名，用于视图展示
   */
  public final static java.lang.String INCOMECASHAMOUNT_LABLE = "IncomeCashAmount";

  /**
   *	IncomeCashAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal incomeCashAmount;

  /**
   *	IncomeTotalAmount数据库列名
   */
  public final static java.lang.String INCOMETOTALAMOUNT_FIELD =  "IncomeTotalAmount";

  /**
   *	IncomeTotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String INCOMETOTALAMOUNT_LABLE = "收入总额";

  /**
   *	IncomeTotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal incomeTotalAmount;

  /**
   *	IsMappingDeivce数据库列名
   */
  public final static java.lang.String ISMAPPINGDEIVCE_FIELD =  "IsMappingDeivce";

  /**
   *	IsMappingDeivce字段中文名，用于视图展示
   */
  public final static java.lang.String ISMAPPINGDEIVCE_LABLE = "IsMappingDeivce";

  /**
   *	IsMappingDeivce对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isMappingDeivce;

  /**
   *	IsNormalWorking数据库列名
   */
  public final static java.lang.String ISNORMALWORKING_FIELD =  "IsNormalWorking";

  /**
   *	IsNormalWorking字段中文名，用于视图展示
   */
  public final static java.lang.String ISNORMALWORKING_LABLE = "正常开班";

  /**
   *	IsNormalWorking对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isNormalWorking;

  /**
   *	IsSync数据库列名
   */
  public final static java.lang.String ISSYNC_FIELD =  "IsSync";

  /**
   *	IsSync字段中文名，用于视图展示
   */
  public final static java.lang.String ISSYNC_LABLE = "IsSync";

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
   *	MoneyAmount数据库列名
   */
  public final static java.lang.String MONEYAMOUNT_FIELD =  "MoneyAmount";

  /**
   *	MoneyAmount字段中文名，用于视图展示
   */
  public final static java.lang.String MONEYAMOUNT_LABLE = "MoneyAmount";

  /**
   *	MoneyAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal moneyAmount;

  /**
   *	NeedMoney数据库列名
   */
  public final static java.lang.String NEEDMONEY_FIELD =  "NeedMoney";

  /**
   *	NeedMoney字段中文名，用于视图展示
   */
  public final static java.lang.String NEEDMONEY_LABLE = "需要资金";

  /**
   *	NeedMoney对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean needMoney;

  /**
   *	OrderCashAmount数据库列名
   */
  public final static java.lang.String ORDERCASHAMOUNT_FIELD =  "OrderCashAmount";

  /**
   *	OrderCashAmount字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERCASHAMOUNT_LABLE = "OrderCashAmount";

  /**
   *	OrderCashAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal orderCashAmount;

  /**
   *	OrderNum数据库列名
   */
  public final static java.lang.String ORDERNUM_FIELD =  "OrderNum";

  /**
   *	OrderNum字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERNUM_LABLE = "订单数";

  /**
   *	OrderNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer orderNum;

  /**
   *	OrderTotalAmount数据库列名
   */
  public final static java.lang.String ORDERTOTALAMOUNT_FIELD =  "OrderTotalAmount";

  /**
   *	OrderTotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERTOTALAMOUNT_LABLE = "OrderTotalAmount";

  /**
   *	OrderTotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal orderTotalAmount;

  /**
   *	RechargeCashAmount数据库列名
   */
  public final static java.lang.String RECHARGECASHAMOUNT_FIELD =  "RechargeCashAmount";

  /**
   *	RechargeCashAmount字段中文名，用于视图展示
   */
  public final static java.lang.String RECHARGECASHAMOUNT_LABLE = "充值现金";

  /**
   *	RechargeCashAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal rechargeCashAmount;

  /**
   *	RechargeNum数据库列名
   */
  public final static java.lang.String RECHARGENUM_FIELD =  "RechargeNum";

  /**
   *	RechargeNum字段中文名，用于视图展示
   */
  public final static java.lang.String RECHARGENUM_LABLE = "RechargeNum";

  /**
   *	RechargeNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer rechargeNum;

  /**
   *	RechargeTotalAmount数据库列名
   */
  public final static java.lang.String RECHARGETOTALAMOUNT_FIELD =  "RechargeTotalAmount";

  /**
   *	RechargeTotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String RECHARGETOTALAMOUNT_LABLE = "充值总额";

  /**
   *	RechargeTotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal rechargeTotalAmount;

  /**
   *	RefundCashAmount数据库列名
   */
  public final static java.lang.String REFUNDCASHAMOUNT_FIELD =  "RefundCashAmount";

  /**
   *	RefundCashAmount字段中文名，用于视图展示
   */
  public final static java.lang.String REFUNDCASHAMOUNT_LABLE = "RefundCashAmount";

  /**
   *	RefundCashAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal refundCashAmount;

  /**
   *	RefundNum数据库列名
   */
  public final static java.lang.String REFUNDNUM_FIELD =  "RefundNum";

  /**
   *	RefundNum字段中文名，用于视图展示
   */
  public final static java.lang.String REFUNDNUM_LABLE = "退款单数";

  /**
   *	RefundNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer refundNum;

  /**
   *	RefundTotalAmount数据库列名
   */
  public final static java.lang.String REFUNDTOTALAMOUNT_FIELD =  "RefundTotalAmount";

  /**
   *	RefundTotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String REFUNDTOTALAMOUNT_LABLE = "RefundTotalAmount";

  /**
   *	RefundTotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal refundTotalAmount;

  /**
   *	RepaymentCashAmount数据库列名
   */
  public final static java.lang.String REPAYMENTCASHAMOUNT_FIELD =  "RepaymentCashAmount";

  /**
   *	RepaymentCashAmount字段中文名，用于视图展示
   */
  public final static java.lang.String REPAYMENTCASHAMOUNT_LABLE = "回款现金";

  /**
   *	RepaymentCashAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal repaymentCashAmount;

  /**
   *	RepaymentNum数据库列名
   */
  public final static java.lang.String REPAYMENTNUM_FIELD =  "RepaymentNum";

  /**
   *	RepaymentNum字段中文名，用于视图展示
   */
  public final static java.lang.String REPAYMENTNUM_LABLE = "RepaymentNum";

  /**
   *	RepaymentNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer repaymentNum;

  /**
   *	RepaymentTotalAmount数据库列名
   */
  public final static java.lang.String REPAYMENTTOTALAMOUNT_FIELD =  "RepaymentTotalAmount";

  /**
   *	RepaymentTotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String REPAYMENTTOTALAMOUNT_LABLE = "回款总额";

  /**
   *	RepaymentTotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal repaymentTotalAmount;

  /**
   *	SettlementMethod数据库列名
   */
  public final static java.lang.String SETTLEMENTMETHOD_FIELD =  "SettlementMethod";

  /**
   *	SettlementMethod字段中文名，用于视图展示
   */
  public final static java.lang.String SETTLEMENTMETHOD_LABLE = "SettlementMethod";

  /**
   *	SettlementMethod对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long settlementMethod;

  /**
   *	SettlementType数据库列名
   */
  public final static java.lang.String SETTLEMENTTYPE_FIELD =  "SettlementType";

  /**
   *	SettlementType字段中文名，用于视图展示
   */
  public final static java.lang.String SETTLEMENTTYPE_LABLE = "SettlementType";

  /**
   *	SettlementType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long settlementType;

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
   *	WorkingDesc数据库列名
   */
  public final static java.lang.String WORKINGDESC_FIELD =  "WorkingDesc";

  /**
   *	WorkingDesc字段中文名，用于视图展示
   */
  public final static java.lang.String WORKINGDESC_LABLE = "WorkingDesc";

  /**
   *	WorkingDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String workingDesc;

  /**
   *	WorkingID数据库列名
   */
  public final static java.lang.String WORKINGID_FIELD =  "WorkingID";

  /**
   *	WorkingID字段中文名，用于视图展示
   */
  public final static java.lang.String WORKINGID_LABLE = "开班编号";

  /**
   *	WorkingID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long workingID;

  /**
   *	WorkingStatus数据库列名
   */
  public final static java.lang.String WORKINGSTATUS_FIELD =  "WorkingStatus";

  /**
   *	WorkingStatus字段中文名，用于视图展示
   */
  public final static java.lang.String WORKINGSTATUS_LABLE = "WorkingStatus";

  /**
   *	WorkingStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long workingStatus;

  /**
   *	WorkingType数据库列名
   */
  public final static java.lang.String WORKINGTYPE_FIELD =  "WorkingType";

  /**
   *	WorkingType字段中文名，用于视图展示
   */
  public final static java.lang.String WORKINGTYPE_LABLE = "工作类型";

  /**
   *	WorkingType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long workingType;

  /**
   *	WorkOffTime数据库列名
   */
  public final static java.lang.String WORKOFFTIME_FIELD =  "WorkOffTime";

  /**
   *	WorkOffTime字段中文名，用于视图展示
   */
  public final static java.lang.String WORKOFFTIME_LABLE = "交班时间";

  /**
   *	WorkOffTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime workOffTime;

  /**
   * ArchiveID getter
   */
  public java.lang.Long getArchiveID(){
    return archiveID;
  }
  /**
   * ArchiveID setter
   * @param ArchiveID
   */
  public void setArchiveID(java.lang.Long archiveID){
    this.archiveID = archiveID;
  }

  /**
   * 上一班次 getter
   */
  public java.lang.Long getBeforeID(){
    return beforeID;
  }
  /**
   * 上一班次 setter
   * @param BeforeID
   */
  public void setBeforeID(java.lang.Long beforeID){
    this.beforeID = beforeID;
  }

  /**
   * BookingCashAmount getter
   */
  public java.math.BigDecimal getBookingCashAmount(){
    return bookingCashAmount;
  }
  /**
   * BookingCashAmount setter
   * @param BookingCashAmount
   */
  public void setBookingCashAmount(java.math.BigDecimal bookingCashAmount){
    this.bookingCashAmount = bookingCashAmount;
  }

  /**
   * 预订单数 getter
   */
  public java.lang.Integer getBookingNum(){
    return bookingNum;
  }
  /**
   * 预订单数 setter
   * @param BookingNum
   */
  public void setBookingNum(java.lang.Integer bookingNum){
    this.bookingNum = bookingNum;
  }

  /**
   * BookingTotalAmount getter
   */
  public java.math.BigDecimal getBookingTotalAmount(){
    return bookingTotalAmount;
  }
  /**
   * BookingTotalAmount setter
   * @param BookingTotalAmount
   */
  public void setBookingTotalAmount(java.math.BigDecimal bookingTotalAmount){
    this.bookingTotalAmount = bookingTotalAmount;
  }

  /**
   * 现金总额 getter
   */
  public java.math.BigDecimal getCashTotalAmount(){
    return cashTotalAmount;
  }
  /**
   * 现金总额 setter
   * @param CashTotalAmount
   */
  public void setCashTotalAmount(java.math.BigDecimal cashTotalAmount){
    this.cashTotalAmount = cashTotalAmount;
  }

  /**
   * CreateTime getter
   */
  public java.time.LocalDateTime getCreateTime(){
    return createTime;
  }
  /**
   * CreateTime setter
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
   * CreatorName getter
   */
  public java.lang.String getCreatorName(){
    return creatorName;
  }
  /**
   * CreatorName setter
   * @param CreatorName
   */
  public void setCreatorName(java.lang.String creatorName){
    this.creatorName = creatorName;
  }

  /**
   * 设备号 getter
   */
  public java.lang.String getDeviceCode(){
    return deviceCode;
  }
  /**
   * 设备号 setter
   * @param DeviceCode
   */
  public void setDeviceCode(java.lang.String deviceCode){
    this.deviceCode = deviceCode;
  }

  /**
   * DeviceID getter
   */
  public java.lang.Long getDeviceID(){
    return deviceID;
  }
  /**
   * DeviceID setter
   * @param DeviceID
   */
  public void setDeviceID(java.lang.Long deviceID){
    this.deviceID = deviceID;
  }

  /**
   * 设备类型 getter
   */
  public java.lang.Long getDeviceType(){
    return deviceType;
  }
  /**
   * 设备类型 setter
   * @param DeviceType
   */
  public void setDeviceType(java.lang.Long deviceType){
    this.deviceType = deviceType;
  }

  /**
   * IncomeCashAmount getter
   */
  public java.math.BigDecimal getIncomeCashAmount(){
    return incomeCashAmount;
  }
  /**
   * IncomeCashAmount setter
   * @param IncomeCashAmount
   */
  public void setIncomeCashAmount(java.math.BigDecimal incomeCashAmount){
    this.incomeCashAmount = incomeCashAmount;
  }

  /**
   * 收入总额 getter
   */
  public java.math.BigDecimal getIncomeTotalAmount(){
    return incomeTotalAmount;
  }
  /**
   * 收入总额 setter
   * @param IncomeTotalAmount
   */
  public void setIncomeTotalAmount(java.math.BigDecimal incomeTotalAmount){
    this.incomeTotalAmount = incomeTotalAmount;
  }

  /**
   * IsMappingDeivce getter
   */
  public java.lang.Boolean getIsMappingDeivce(){
    return isMappingDeivce;
  }
  /**
   * IsMappingDeivce setter
   * @param IsMappingDeivce
   */
  public void setIsMappingDeivce(java.lang.Boolean isMappingDeivce){
    this.isMappingDeivce = isMappingDeivce;
  }

  /**
   * 正常开班 getter
   */
  public java.lang.Boolean getIsNormalWorking(){
    return isNormalWorking;
  }
  /**
   * 正常开班 setter
   * @param IsNormalWorking
   */
  public void setIsNormalWorking(java.lang.Boolean isNormalWorking){
    this.isNormalWorking = isNormalWorking;
  }

  /**
   * IsSync getter
   */
  public java.lang.Boolean getIsSync(){
    return isSync;
  }
  /**
   * IsSync setter
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
   * MoneyAmount getter
   */
  public java.math.BigDecimal getMoneyAmount(){
    return moneyAmount;
  }
  /**
   * MoneyAmount setter
   * @param MoneyAmount
   */
  public void setMoneyAmount(java.math.BigDecimal moneyAmount){
    this.moneyAmount = moneyAmount;
  }

  /**
   * 需要资金 getter
   */
  public java.lang.Boolean getNeedMoney(){
    return needMoney;
  }
  /**
   * 需要资金 setter
   * @param NeedMoney
   */
  public void setNeedMoney(java.lang.Boolean needMoney){
    this.needMoney = needMoney;
  }

  /**
   * OrderCashAmount getter
   */
  public java.math.BigDecimal getOrderCashAmount(){
    return orderCashAmount;
  }
  /**
   * OrderCashAmount setter
   * @param OrderCashAmount
   */
  public void setOrderCashAmount(java.math.BigDecimal orderCashAmount){
    this.orderCashAmount = orderCashAmount;
  }

  /**
   * 订单数 getter
   */
  public java.lang.Integer getOrderNum(){
    return orderNum;
  }
  /**
   * 订单数 setter
   * @param OrderNum
   */
  public void setOrderNum(java.lang.Integer orderNum){
    this.orderNum = orderNum;
  }

  /**
   * OrderTotalAmount getter
   */
  public java.math.BigDecimal getOrderTotalAmount(){
    return orderTotalAmount;
  }
  /**
   * OrderTotalAmount setter
   * @param OrderTotalAmount
   */
  public void setOrderTotalAmount(java.math.BigDecimal orderTotalAmount){
    this.orderTotalAmount = orderTotalAmount;
  }

  /**
   * 充值现金 getter
   */
  public java.math.BigDecimal getRechargeCashAmount(){
    return rechargeCashAmount;
  }
  /**
   * 充值现金 setter
   * @param RechargeCashAmount
   */
  public void setRechargeCashAmount(java.math.BigDecimal rechargeCashAmount){
    this.rechargeCashAmount = rechargeCashAmount;
  }

  /**
   * RechargeNum getter
   */
  public java.lang.Integer getRechargeNum(){
    return rechargeNum;
  }
  /**
   * RechargeNum setter
   * @param RechargeNum
   */
  public void setRechargeNum(java.lang.Integer rechargeNum){
    this.rechargeNum = rechargeNum;
  }

  /**
   * 充值总额 getter
   */
  public java.math.BigDecimal getRechargeTotalAmount(){
    return rechargeTotalAmount;
  }
  /**
   * 充值总额 setter
   * @param RechargeTotalAmount
   */
  public void setRechargeTotalAmount(java.math.BigDecimal rechargeTotalAmount){
    this.rechargeTotalAmount = rechargeTotalAmount;
  }

  /**
   * RefundCashAmount getter
   */
  public java.math.BigDecimal getRefundCashAmount(){
    return refundCashAmount;
  }
  /**
   * RefundCashAmount setter
   * @param RefundCashAmount
   */
  public void setRefundCashAmount(java.math.BigDecimal refundCashAmount){
    this.refundCashAmount = refundCashAmount;
  }

  /**
   * 退款单数 getter
   */
  public java.lang.Integer getRefundNum(){
    return refundNum;
  }
  /**
   * 退款单数 setter
   * @param RefundNum
   */
  public void setRefundNum(java.lang.Integer refundNum){
    this.refundNum = refundNum;
  }

  /**
   * RefundTotalAmount getter
   */
  public java.math.BigDecimal getRefundTotalAmount(){
    return refundTotalAmount;
  }
  /**
   * RefundTotalAmount setter
   * @param RefundTotalAmount
   */
  public void setRefundTotalAmount(java.math.BigDecimal refundTotalAmount){
    this.refundTotalAmount = refundTotalAmount;
  }

  /**
   * 回款现金 getter
   */
  public java.math.BigDecimal getRepaymentCashAmount(){
    return repaymentCashAmount;
  }
  /**
   * 回款现金 setter
   * @param RepaymentCashAmount
   */
  public void setRepaymentCashAmount(java.math.BigDecimal repaymentCashAmount){
    this.repaymentCashAmount = repaymentCashAmount;
  }

  /**
   * RepaymentNum getter
   */
  public java.lang.Integer getRepaymentNum(){
    return repaymentNum;
  }
  /**
   * RepaymentNum setter
   * @param RepaymentNum
   */
  public void setRepaymentNum(java.lang.Integer repaymentNum){
    this.repaymentNum = repaymentNum;
  }

  /**
   * 回款总额 getter
   */
  public java.math.BigDecimal getRepaymentTotalAmount(){
    return repaymentTotalAmount;
  }
  /**
   * 回款总额 setter
   * @param RepaymentTotalAmount
   */
  public void setRepaymentTotalAmount(java.math.BigDecimal repaymentTotalAmount){
    this.repaymentTotalAmount = repaymentTotalAmount;
  }

  /**
   * SettlementMethod getter
   */
  public java.lang.Long getSettlementMethod(){
    return settlementMethod;
  }
  /**
   * SettlementMethod setter
   * @param SettlementMethod
   */
  public void setSettlementMethod(java.lang.Long settlementMethod){
    this.settlementMethod = settlementMethod;
  }

  /**
   * SettlementType getter
   */
  public java.lang.Long getSettlementType(){
    return settlementType;
  }
  /**
   * SettlementType setter
   * @param SettlementType
   */
  public void setSettlementType(java.lang.Long settlementType){
    this.settlementType = settlementType;
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
   * WorkingDesc getter
   */
  public java.lang.String getWorkingDesc(){
    return workingDesc;
  }
  /**
   * WorkingDesc setter
   * @param WorkingDesc
   */
  public void setWorkingDesc(java.lang.String workingDesc){
    this.workingDesc = workingDesc;
  }

  /**
   * 开班编号 getter
   */
  public java.lang.Long getWorkingID(){
    return workingID;
  }
  /**
   * 开班编号 setter
   * @param WorkingID
   */
  public void setWorkingID(java.lang.Long workingID){
    this.workingID = workingID;
  }

  /**
   * WorkingStatus getter
   */
  public java.lang.Long getWorkingStatus(){
    return workingStatus;
  }
  /**
   * WorkingStatus setter
   * @param WorkingStatus
   */
  public void setWorkingStatus(java.lang.Long workingStatus){
    this.workingStatus = workingStatus;
  }

  /**
   * 工作类型 getter
   */
  public java.lang.Long getWorkingType(){
    return workingType;
  }
  /**
   * 工作类型 setter
   * @param WorkingType
   */
  public void setWorkingType(java.lang.Long workingType){
    this.workingType = workingType;
  }

  /**
   * 交班时间 getter
   */
  public java.time.LocalDateTime getWorkOffTime(){
    return workOffTime;
  }
  /**
   * 交班时间 setter
   * @param WorkOffTime
   */
  public void setWorkOffTime(java.time.LocalDateTime workOffTime){
    this.workOffTime = workOffTime;
  }

}