package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;

import java.math.BigDecimal;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_BookingInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_BookingInfoEntityBase extends Entity {

  /**
   *	ArchiveID数据库列名
   */
  public final static String ARCHIVEID_FIELD =  "ArchiveID";
  
  /**
   *	ArchiveID字段中文名，用于视图展示
   */
  public final static String ARCHIVEID_LABLE = "档案编号";
  
  /**
   *	ArchiveID对应的java字段名,业务操作使用这个字段。
   */
  private Long archiveID;

  private BigDecimal pendingAmount;

  /**
   *	ArrivalTime数据库列名
   */
  public final static String ARRIVALTIME_FIELD =  "ArrivalTime";
  
  /**
   *	ArrivalTime字段中文名，用于视图展示
   */
  public final static String ARRIVALTIME_LABLE = "到店时间";
  
  /**
   *	ArrivalTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime arrivalTime;
  
  /**
   *	BookingAmount数据库列名
   */
  public final static String BOOKINGAMOUNT_FIELD =  "BookingAmount";
  
  /**
   *	BookingAmount字段中文名，用于视图展示
   */
  public final static String BOOKINGAMOUNT_LABLE = "支付金额";
  
  /**
   *	BookingAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal bookingAmount;
  
  /**
   *	BookingChannel数据库列名
   */
  public final static String BOOKINGCHANNEL_FIELD =  "BookingChannel";
  
  /**
   *	BookingChannel字段中文名，用于视图展示
   */
  public final static String BOOKINGCHANNEL_LABLE = "预订来源";
  
  /**
   *	BookingChannel对应的java字段名,业务操作使用这个字段。
   */
  private Long bookingChannel;
  
  /**
   *	BookingCode数据库列名
   */
  public final static String BOOKINGCODE_FIELD =  "BookingCode";
  
  /**
   *	BookingCode字段中文名，用于视图展示
   */
  public final static String BOOKINGCODE_LABLE = "预订编码";
  
  /**
   *	BookingCode对应的java字段名,业务操作使用这个字段。
   */
  private String bookingCode;
  
  /**
   *	BookingDesc数据库列名
   */
  public final static String BOOKINGDESC_FIELD =  "BookingDesc";
  
  /**
   *	BookingDesc字段中文名，用于视图展示
   */
  public final static String BOOKINGDESC_LABLE = "预订说明";
  
  /**
   *	BookingDesc对应的java字段名,业务操作使用这个字段。
   */
  private String bookingDesc;
  
  /**
   *	BookingID数据库列名
   */
  public final static String BOOKINGID_FIELD =  "BookingID";
  
  /**
   *	BookingID字段中文名，用于视图展示
   */
  public final static String BOOKINGID_LABLE = "预订编号";
  
  /**
   *	BookingID对应的java字段名,业务操作使用这个字段。
   */
  private Long bookingID;
  
  /**
   *	BookingStatus数据库列名
   */
  public final static String BOOKINGSTATUS_FIELD =  "BookingStatus";
  
  /**
   *	BookingStatus字段中文名，用于视图展示
   */
  public final static String BOOKINGSTATUS_LABLE = "预订状态";
  
  /**
   *	BookingStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long bookingStatus;
  
  /**
   *	BookingTime数据库列名
   */
  public final static String BOOKINGTIME_FIELD =  "BookingTime";
  
  /**
   *	BookingTime字段中文名，用于视图展示
   */
  public final static String BOOKINGTIME_LABLE = "预约时间";
  
  /**
   *	BookingTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime bookingTime;
  
  /**
   *	BookingType数据库列名
   */
  public final static String BOOKINGTYPE_FIELD =  "BookingType";
  
  /**
   *	BookingType字段中文名，用于视图展示
   */
  public final static String BOOKINGTYPE_LABLE = "预订类型";
  
  /**
   *	BookingType对应的java字段名,业务操作使用这个字段。
   */
  private Long bookingType;
  
  /**
   *	Contact数据库列名
   */
  public final static String CONTACT_FIELD =  "Contact";
  
  /**
   *	Contact字段中文名，用于视图展示
   */
  public final static String CONTACT_LABLE = "联系人";
  
  /**
   *	Contact对应的java字段名,业务操作使用这个字段。
   */
  private String contact;
  
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
   *	CreatorType数据库列名
   */
  public final static String CREATORTYPE_FIELD =  "CreatorType";
  
  /**
   *	CreatorType字段中文名，用于视图展示
   */
  public final static String CREATORTYPE_LABLE = "创建人类别";
  
  /**
   *	CreatorType对应的java字段名,业务操作使用这个字段。
   */
  private Long creatorType;
  
  /**
   *	Duration数据库列名
   */
  public final static String DURATION_FIELD =  "Duration";
  
  /**
   *	Duration字段中文名，用于视图展示
   */
  public final static String DURATION_LABLE = "预订时长";
  
  /**
   *	Duration对应的java字段名,业务操作使用这个字段。
   */
  private Integer duration;
  
  /**
   *	ExtraMinute数据库列名
   */
  public final static String EXTRAMINUTE_FIELD =  "ExtraMinute";
  
  /**
   *	ExtraMinute字段中文名，用于视图展示
   */
  public final static String EXTRAMINUTE_LABLE = "加时时长";
  
  /**
   *	ExtraMinute对应的java字段名,业务操作使用这个字段。
   */
  private Integer extraMinute;
  
  /**
   *	IsSync数据库列名
   */
  public final static String ISSYNC_FIELD =  "IsSync";
  
  /**
   *	IsSync字段中文名，用于视图展示
   */
  public final static String ISSYNC_LABLE = "是否同步";
  
  /**
   *	IsSync对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isSync;
  
  /**
   *	LoginID数据库列名
   */
  public final static String LOGINID_FIELD =  "LoginID";
  
  /**
   *	LoginID字段中文名，用于视图展示
   */
  public final static String LOGINID_LABLE = "登录编号";
  
  /**
   *	LoginID对应的java字段名,业务操作使用这个字段。
   */
  private Long loginID;
  
  /**
   *	MealsID数据库列名
   */
  public final static String MEALSID_FIELD =  "MealsID";
  
  /**
   *	MealsID字段中文名，用于视图展示
   */
  public final static String MEALSID_LABLE = "餐次编号";
  
  /**
   *	MealsID对应的java字段名,业务操作使用这个字段。
   */
  private Long mealsID;
  
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
   *	OrderID数据库列名
   */
  public final static String ORDERID_FIELD =  "OrderID";
  
  /**
   *	OrderID字段中文名，用于视图展示
   */
  public final static String ORDERID_LABLE = "订单编号";
  
  /**
   *	OrderID对应的java字段名,业务操作使用这个字段。
   */
  private Long orderID;
  
  /**
   *	PaymentMethodID数据库列名
   */
  public final static String PAYMENTMETHODID_FIELD =  "PaymentMethodID";
  
  /**
   *	PaymentMethodID字段中文名，用于视图展示
   */
  public final static String PAYMENTMETHODID_LABLE = "支付方式";
  
  /**
   *	PaymentMethodID对应的java字段名,业务操作使用这个字段。
   */
  private Long paymentMethodID;
  
  /**
   *	PayStatus数据库列名
   */
  public final static String PAYSTATUS_FIELD =  "PayStatus";
  
  /**
   *	PayStatus字段中文名，用于视图展示
   */
  public final static String PAYSTATUS_LABLE = "支付状态";
  
  /**
   *	PayStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long payStatus;
  
  /**
   *	PeopleNum数据库列名
   */
  public final static String PEOPLENUM_FIELD =  "PeopleNum";
  
  /**
   *	PeopleNum字段中文名，用于视图展示
   */
  public final static String PEOPLENUM_LABLE = "就餐人数";
  
  /**
   *	PeopleNum对应的java字段名,业务操作使用这个字段。
   */
  private Integer peopleNum;
  
  /**
   *	Phone数据库列名
   */
  public final static String PHONE_FIELD =  "Phone";
  
  /**
   *	Phone字段中文名，用于视图展示
   */
  public final static String PHONE_LABLE = "联系电话";
  
  /**
   *	Phone对应的java字段名,业务操作使用这个字段。
   */
  private String phone;
  
  /**
   *	RefundAmount数据库列名
   */
  public final static String REFUNDAMOUNT_FIELD =  "RefundAmount";
  
  /**
   *	RefundAmount字段中文名，用于视图展示
   */
  public final static String REFUNDAMOUNT_LABLE = "退款金额";
  
  /**
   *	RefundAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal refundAmount;
  
  /**
   *	RefundMethod数据库列名
   */
  public final static String REFUNDMETHOD_FIELD =  "RefundMethod";
  
  /**
   *	RefundMethod字段中文名，用于视图展示
   */
  public final static String REFUNDMETHOD_LABLE = "退款方式";
  
  /**
   *	RefundMethod对应的java字段名,业务操作使用这个字段。
   */
  private Long refundMethod;
  
  /**
   *	RefundStatus数据库列名
   */
  public final static String REFUNDSTATUS_FIELD =  "RefundStatus";
  
  /**
   *	RefundStatus字段中文名，用于视图展示
   */
  public final static String REFUNDSTATUS_LABLE = "退款状态";
  
  /**
   *	RefundStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long refundStatus;
  
  /**
   *	SegmentID数据库列名
   */
  public final static String SEGMENTID_FIELD =  "SegmentID";
  
  /**
   *	SegmentID字段中文名，用于视图展示
   */
  public final static String SEGMENTID_LABLE = "桌台餐段编号";
  
  /**
   *	SegmentID对应的java字段名,业务操作使用这个字段。
   */
  private Long segmentID;
  
  /**
   *	TableCodes数据库列名
   */
  public final static String TABLECODES_FIELD =  "TableCodes";
  
  /**
   *	TableCodes字段中文名，用于视图展示
   */
  public final static String TABLECODES_LABLE = "桌台编码";
  
  /**
   *	TableCodes对应的java字段名,业务操作使用这个字段。
   */
  private String tableCodes;
  
  /**
   *	TableID数据库列名
   */
  public final static String TABLEID_FIELD =  "TableID";
  
  /**
   *	TableID字段中文名，用于视图展示
   */
  public final static String TABLEID_LABLE = "桌台编号";
  
  /**
   *	TableID对应的java字段名,业务操作使用这个字段。
   */
  private Long tableID;
  
  /**
   *	TableNum数据库列名
   */
  public final static String TABLENUM_FIELD =  "TableNum";
  
  /**
   *	TableNum字段中文名，用于视图展示
   */
  public final static String TABLENUM_LABLE = "桌台数";
  
  /**
   *	TableNum对应的java字段名,业务操作使用这个字段。
   */
  private Integer tableNum;
  
  /**
   *	VerificationCode数据库列名
   */
  public final static String VERIFICATIONCODE_FIELD =  "VerificationCode";
  
  /**
   *	VerificationCode字段中文名，用于视图展示
   */
  public final static String VERIFICATIONCODE_LABLE = "验证码";
  
  /**
   *	VerificationCode对应的java字段名,业务操作使用这个字段。
   */
  private String verificationCode;
  
  /**
   * 档案编号 getter
   */
  public Long getArchiveID(){
    return archiveID;
  }
  /**
   * 档案编号 setter
   * @param ArchiveID
   */  
  public void setArchiveID(Long archiveID){
    this.archiveID = archiveID;
  }
 
  /**
   * 到店时间 getter
   */
  public java.time.LocalDateTime getArrivalTime(){
    return arrivalTime;
  }
  /**
   * 到店时间 setter
   * @param ArrivalTime
   */  
  public void setArrivalTime(java.time.LocalDateTime arrivalTime){
    this.arrivalTime = arrivalTime;
  }
 
  /**
   * 支付金额 getter
   */
  public java.math.BigDecimal getBookingAmount(){
    return bookingAmount;
  }
  /**
   * 支付金额 setter
   * @param BookingAmount
   */  
  public void setBookingAmount(java.math.BigDecimal bookingAmount){
    this.bookingAmount = bookingAmount;
  }
 
  /**
   * 预订来源 getter
   */
  public Long getBookingChannel(){
    return bookingChannel;
  }
  /**
   * 预订来源 setter
   * @param BookingChannel
   */  
  public void setBookingChannel(Long bookingChannel){
    this.bookingChannel = bookingChannel;
  }
 
  /**
   * 预订编码 getter
   */
  public String getBookingCode(){
    return bookingCode;
  }
  /**
   * 预订编码 setter
   * @param BookingCode
   */  
  public void setBookingCode(String bookingCode){
    this.bookingCode = bookingCode;
  }
 
  /**
   * 预订说明 getter
   */
  public String getBookingDesc(){
    return bookingDesc;
  }
  /**
   * 预订说明 setter
   * @param BookingDesc
   */  
  public void setBookingDesc(String bookingDesc){
    this.bookingDesc = bookingDesc;
  }
 
  /**
   * 预订编号 getter
   */
  public Long getBookingID(){
    return bookingID;
  }
  /**
   * 预订编号 setter
   * @param BookingID
   */  
  public void setBookingID(Long bookingID){
    this.bookingID = bookingID;
  }
 
  /**
   * 预订状态 getter
   */
  public Long getBookingStatus(){
    return bookingStatus;
  }
  /**
   * 预订状态 setter
   * @param BookingStatus
   */  
  public void setBookingStatus(Long bookingStatus){
    this.bookingStatus = bookingStatus;
  }
 
  /**
   * 预约时间 getter
   */
  public java.time.LocalDateTime getBookingTime(){
    return bookingTime;
  }
  /**
   * 预约时间 setter
   * @param BookingTime
   */  
  public void setBookingTime(java.time.LocalDateTime bookingTime){
    this.bookingTime = bookingTime;
  }
 
  /**
   * 预订类型 getter
   */
  public Long getBookingType(){
    return bookingType;
  }
  /**
   * 预订类型 setter
   * @param BookingType
   */  
  public void setBookingType(Long bookingType){
    this.bookingType = bookingType;
  }
 
  /**
   * 联系人 getter
   */
  public String getContact(){
    return contact;
  }
  /**
   * 联系人 setter
   * @param Contact
   */  
  public void setContact(String contact){
    this.contact = contact;
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
   * 创建人类别 getter
   */
  public Long getCreatorType(){
    return creatorType;
  }
  /**
   * 创建人类别 setter
   * @param CreatorType
   */  
  public void setCreatorType(Long creatorType){
    this.creatorType = creatorType;
  }
 
  /**
   * 预订时长 getter
   */
  public Integer getDuration(){
    return duration;
  }
  /**
   * 预订时长 setter
   * @param Duration
   */  
  public void setDuration(Integer duration){
    this.duration = duration;
  }
 
  /**
   * 加时时长 getter
   */
  public Integer getExtraMinute(){
    return extraMinute;
  }
  /**
   * 加时时长 setter
   * @param ExtraMinute
   */  
  public void setExtraMinute(Integer extraMinute){
    this.extraMinute = extraMinute;
  }
 
  /**
   * 是否同步 getter
   */
  public Boolean getIsSync(){
    return isSync;
  }
  /**
   * 是否同步 setter
   * @param IsSync
   */  
  public void setIsSync(Boolean isSync){
    this.isSync = isSync;
  }
 
  /**
   * 登录编号 getter
   */
  public Long getLoginID(){
    return loginID;
  }
  /**
   * 登录编号 setter
   * @param LoginID
   */  
  public void setLoginID(Long loginID){
    this.loginID = loginID;
  }
 
  /**
   * 餐次编号 getter
   */
  public Long getMealsID(){
    return mealsID;
  }
  /**
   * 餐次编号 setter
   * @param MealsID
   */  
  public void setMealsID(Long mealsID){
    this.mealsID = mealsID;
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
 
  /**
   * 订单编号 getter
   */
  public Long getOrderID(){
    return orderID;
  }
  /**
   * 订单编号 setter
   * @param OrderID
   */  
  public void setOrderID(Long orderID){
    this.orderID = orderID;
  }
 
  /**
   * 支付方式 getter
   */
  public Long getPaymentMethodID(){
    return paymentMethodID;
  }
  /**
   * 支付方式 setter
   * @param PaymentMethodID
   */  
  public void setPaymentMethodID(Long paymentMethodID){
    this.paymentMethodID = paymentMethodID;
  }
 
  /**
   * 支付状态 getter
   */
  public Long getPayStatus(){
    return payStatus;
  }
  /**
   * 支付状态 setter
   * @param PayStatus
   */  
  public void setPayStatus(Long payStatus){
    this.payStatus = payStatus;
  }
 
  /**
   * 就餐人数 getter
   */
  public Integer getPeopleNum(){
    return peopleNum;
  }
  /**
   * 就餐人数 setter
   * @param PeopleNum
   */  
  public void setPeopleNum(Integer peopleNum){
    this.peopleNum = peopleNum;
  }
 
  /**
   * 联系电话 getter
   */
  public String getPhone(){
    return phone;
  }
  /**
   * 联系电话 setter
   * @param Phone
   */  
  public void setPhone(String phone){
    this.phone = phone;
  }
 
  /**
   * 退款金额 getter
   */
  public java.math.BigDecimal getRefundAmount(){
    return refundAmount;
  }
  /**
   * 退款金额 setter
   * @param RefundAmount
   */  
  public void setRefundAmount(java.math.BigDecimal refundAmount){
    this.refundAmount = refundAmount;
  }
 
  /**
   * 退款方式 getter
   */
  public Long getRefundMethod(){
    return refundMethod;
  }
  /**
   * 退款方式 setter
   * @param RefundMethod
   */  
  public void setRefundMethod(Long refundMethod){
    this.refundMethod = refundMethod;
  }
 
  /**
   * 退款状态 getter
   */
  public Long getRefundStatus(){
    return refundStatus;
  }
  /**
   * 退款状态 setter
   * @param RefundStatus
   */  
  public void setRefundStatus(Long refundStatus){
    this.refundStatus = refundStatus;
  }
 
  /**
   * 桌台餐段编号 getter
   */
  public Long getSegmentID(){
    return segmentID;
  }
  /**
   * 桌台餐段编号 setter
   * @param SegmentID
   */  
  public void setSegmentID(Long segmentID){
    this.segmentID = segmentID;
  }
 
  /**
   * 桌台编码 getter
   */
  public String getTableCodes(){
    return tableCodes;
  }
  /**
   * 桌台编码 setter
   * @param TableCodes
   */  
  public void setTableCodes(String tableCodes){
    this.tableCodes = tableCodes;
  }
 
  /**
   * 桌台编号 getter
   */
  public Long getTableID(){
    return tableID;
  }
  /**
   * 桌台编号 setter
   * @param TableID
   */  
  public void setTableID(Long tableID){
    this.tableID = tableID;
  }
 
  /**
   * 桌台数 getter
   */
  public Integer getTableNum(){
    return tableNum;
  }
  /**
   * 桌台数 setter
   * @param TableNum
   */  
  public void setTableNum(Integer tableNum){
    this.tableNum = tableNum;
  }
 
  /**
   * 验证码 getter
   */
  public String getVerificationCode(){
    return verificationCode;
  }
  /**
   * 验证码 setter
   * @param VerificationCode
   */  
  public void setVerificationCode(String verificationCode){
    this.verificationCode = verificationCode;
  }

  public BigDecimal getPendingAmount() {
    return pendingAmount;
  }

  public void setPendingAmount(BigDecimal pendingAmount) {
    this.pendingAmount = pendingAmount;
  }
}