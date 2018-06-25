package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_BasicParamInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_BasicParamInfoEntityBase  extends Entity{

  /**
   *	AheadMinute数据库列名
   */
  public final static String AHEADMINUTE_FIELD =  "AheadMinute";
  
  /**
   *	AheadMinute字段中文名，用于视图展示
   */
  public final static String AHEADMINUTE_LABLE = "提前时长";
  
  /**
   *	AheadMinute对应的java字段名,业务操作使用这个字段。
   */
  private Integer aheadMinute;
  
  /**
   *	AlertAmount数据库列名
   */
  public final static String ALERTAMOUNT_FIELD =  "AlertAmount";
  
  /**
   *	AlertAmount字段中文名，用于视图展示
   */
  public final static String ALERTAMOUNT_LABLE = "预警额度";
  
  /**
   *	AlertAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal alertAmount;
  
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
  
  /**
   *	CanBookingDay数据库列名
   */
  public final static String CANBOOKINGDAY_FIELD =  "CanBookingDay";
  
  /**
   *	CanBookingDay字段中文名，用于视图展示
   */
  public final static String CANBOOKINGDAY_LABLE = "预订天数";
  
  /**
   *	CanBookingDay对应的java字段名,业务操作使用这个字段。
   */
  private Integer canBookingDay;
  
  /**
   *	CloseTime数据库列名
   */
  public final static String CLOSETIME_FIELD =  "CloseTime";
  
  /**
   *	CloseTime字段中文名，用于视图展示
   */
  public final static String CLOSETIME_LABLE = "闭店时间";
  
  /**
   *	CloseTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime closeTime;
  
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
   *	DayType数据库列名
   */
  public final static String DAYTYPE_FIELD =  "DayType";
  
  /**
   *	DayType字段中文名，用于视图展示
   */
  public final static String DAYTYPE_LABLE = "日期方式";
  
  /**
   *	DayType对应的java字段名,业务操作使用这个字段。
   */
  private Long dayType;
  
  /**
   *	DroptailMethod数据库列名
   */
  public final static String DROPTAILMETHOD_FIELD =  "DroptailMethod";
  
  /**
   *	DroptailMethod字段中文名，用于视图展示
   */
  public final static String DROPTAILMETHOD_LABLE = "抹零方式";
  
  /**
   *	DroptailMethod对应的java字段名,业务操作使用这个字段。
   */
  private Long droptailMethod;
  
  /**
   *	EnablePending数据库列名
   */
  public final static String ENABLEPENDING_FIELD =  "EnablePending";
  
  /**
   *	EnablePending字段中文名，用于视图展示
   */
  public final static String ENABLEPENDING_LABLE = "启用待清";
  
  /**
   *	EnablePending对应的java字段名,业务操作使用这个字段。
   */
  private Boolean enablePending;
  
  /**
   *	IsGregorian数据库列名
   */
  public final static String ISGREGORIAN_FIELD =  "IsGregorian";
  
  /**
   *	IsGregorian字段中文名，用于视图展示
   */
  public final static String ISGREGORIAN_LABLE = "是否公历";
  
  /**
   *	IsGregorian对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isGregorian;
  
  /**
   *	IsServiceFee数据库列名
   */
  public final static String ISSERVICEFEE_FIELD =  "IsServiceFee";
  
  /**
   *	IsServiceFee字段中文名，用于视图展示
   */
  public final static String ISSERVICEFEE_LABLE = "收取服务费";
  
  /**
   *	IsServiceFee对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isServiceFee;
  
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
   *	LateMinute数据库列名
   */
  public final static String LATEMINUTE_FIELD =  "LateMinute";
  
  /**
   *	LateMinute字段中文名，用于视图展示
   */
  public final static String LATEMINUTE_LABLE = "逾期时长";
  
  /**
   *	LateMinute对应的java字段名,业务操作使用这个字段。
   */
  private Integer lateMinute;
  
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
   *	MonthDay数据库列名
   */
  public final static String MONTHDAY_FIELD =  "MonthDay";
  
  /**
   *	MonthDay字段中文名，用于视图展示
   */
  public final static String MONTHDAY_LABLE = "月营业日";
  
  /**
   *	MonthDay对应的java字段名,业务操作使用这个字段。
   */
  private String monthDay;
  
  /**
   *	OpenTime数据库列名
   */
  public final static String OPENTIME_FIELD =  "OpenTime";
  
  /**
   *	OpenTime字段中文名，用于视图展示
   */
  public final static String OPENTIME_LABLE = "开始时间";
  
  /**
   *	OpenTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime openTime;
  
  /**
   *	OrgID数据库列名
   */
  public final static String ORGID_FIELD =  "OrgID";
  
  /**
   *	OrgID字段中文名，用于视图展示
   */
  public final static String ORGID_LABLE = "机构编号";
  
  /**
   *	OrgID对应的java字段名,业务操作使用这个字段。
   */
  private Long orgID;
  
  /**
   *	ParamID数据库列名
   */
  public final static String PARAMID_FIELD =  "ParamID";
  
  /**
   *	ParamID字段中文名，用于视图展示
   */
  public final static String PARAMID_LABLE = "参数编号";
  
  /**
   *	ParamID对应的java字段名,业务操作使用这个字段。
   */
  private Long paramID;
  
  /**
   *	PrePayPending数据库列名
   */
  public final static String PREPAYPENDING_FIELD =  "PrePayPending";
  
  /**
   *	PrePayPending字段中文名，用于视图展示
   */
  public final static String PREPAYPENDING_LABLE = "预结待清";
  
  /**
   *	PrePayPending对应的java字段名,业务操作使用这个字段。
   */
  private Boolean prePayPending;
  
  /**
   *	ReservationFee数据库列名
   */
  public final static String RESERVATIONFEE_FIELD =  "ReservationFee";
  
  /**
   *	ReservationFee字段中文名，用于视图展示
   */
  public final static String RESERVATIONFEE_LABLE = "订金金额";
  
  /**
   *	ReservationFee对应的java字段名,业务操作使用这个字段。
   */
  private Integer reservationFee;
  
  /**
   *	ReservationType数据库列名
   */
  public final static String RESERVATIONTYPE_FIELD =  "ReservationType";
  
  /**
   *	ReservationType字段中文名，用于视图展示
   */
  public final static String RESERVATIONTYPE_LABLE = "订金方式";
  
  /**
   *	ReservationType对应的java字段名,业务操作使用这个字段。
   */
  private Long reservationType;
  
  /**
   *	ServiceFee数据库列名
   */
  public final static String SERVICEFEE_FIELD =  "ServiceFee";
  
  /**
   *	ServiceFee字段中文名，用于视图展示
   */
  public final static String SERVICEFEE_LABLE = "服务费";
  
  /**
   *	ServiceFee对应的java字段名,业务操作使用这个字段。
   */
  private Integer serviceFee;
  
  /**
   *	ServiceFeeType数据库列名
   */
  public final static String SERVICEFEETYPE_FIELD =  "ServiceFeeType";
  
  /**
   *	ServiceFeeType字段中文名，用于视图展示
   */
  public final static String SERVICEFEETYPE_LABLE = "收取方式";
  
  /**
   *	ServiceFeeType对应的java字段名,业务操作使用这个字段。
   */
  private Long serviceFeeType;
  
  /**
   *	SpecificDay数据库列名
   */
  public final static String SPECIFICDAY_FIELD =  "SpecificDay";
  
  /**
   *	SpecificDay字段中文名，用于视图展示
   */
  public final static String SPECIFICDAY_LABLE = "特定日期";
  
  /**
   *	SpecificDay对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime specificDay;
  
  /**
   *	WeekDay数据库列名
   */
  public final static String WEEKDAY_FIELD =  "WeekDay";
  
  /**
   *	WeekDay字段中文名，用于视图展示
   */
  public final static String WEEKDAY_LABLE = "周营业日";
  
  /**
   *	WeekDay对应的java字段名,业务操作使用这个字段。
   */
  private String weekDay;
  
  /**
   *	YearDay数据库列名
   */
  public final static String YEARDAY_FIELD =  "YearDay";
  
  /**
   *	YearDay字段中文名，用于视图展示
   */
  public final static String YEARDAY_LABLE = "年营业日";
  
  /**
   *	YearDay对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime yearDay;
  
  /**
   * 提前时长 getter
   */
  public Integer getAheadMinute(){
    return aheadMinute;
  }
  /**
   * 提前时长 setter
   * @param AheadMinute
   */  
  public void setAheadMinute(Integer aheadMinute){
    this.aheadMinute = aheadMinute;
  }
 
  /**
   * 预警额度 getter
   */
  public java.math.BigDecimal getAlertAmount(){
    return alertAmount;
  }
  /**
   * 预警额度 setter
   * @param AlertAmount
   */  
  public void setAlertAmount(java.math.BigDecimal alertAmount){
    this.alertAmount = alertAmount;
  }
 
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
   * 预订天数 getter
   */
  public Integer getCanBookingDay(){
    return canBookingDay;
  }
  /**
   * 预订天数 setter
   * @param CanBookingDay
   */  
  public void setCanBookingDay(Integer canBookingDay){
    this.canBookingDay = canBookingDay;
  }
 
  /**
   * 闭店时间 getter
   */
  public java.time.LocalDateTime getCloseTime(){
    return closeTime;
  }
  /**
   * 闭店时间 setter
   * @param CloseTime
   */  
  public void setCloseTime(java.time.LocalDateTime closeTime){
    this.closeTime = closeTime;
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
   * 日期方式 getter
   */
  public Long getDayType(){
    return dayType;
  }
  /**
   * 日期方式 setter
   * @param DayType
   */  
  public void setDayType(Long dayType){
    this.dayType = dayType;
  }
 
  /**
   * 抹零方式 getter
   */
  public Long getDroptailMethod(){
    return droptailMethod;
  }
  /**
   * 抹零方式 setter
   * @param DroptailMethod
   */  
  public void setDroptailMethod(Long droptailMethod){
    this.droptailMethod = droptailMethod;
  }
 
  /**
   * 启用待清 getter
   */
  public Boolean getEnablePending(){
    return enablePending;
  }
  /**
   * 启用待清 setter
   * @param EnablePending
   */  
  public void setEnablePending(Boolean enablePending){
    this.enablePending = enablePending;
  }
 
  /**
   * 是否公历 getter
   */
  public Boolean getIsGregorian(){
    return isGregorian;
  }
  /**
   * 是否公历 setter
   * @param IsGregorian
   */  
  public void setIsGregorian(Boolean isGregorian){
    this.isGregorian = isGregorian;
  }
 
  /**
   * 收取服务费 getter
   */
  public Boolean getIsServiceFee(){
    return isServiceFee;
  }
  /**
   * 收取服务费 setter
   * @param IsServiceFee
   */  
  public void setIsServiceFee(Boolean isServiceFee){
    this.isServiceFee = isServiceFee;
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
   * 逾期时长 getter
   */
  public Integer getLateMinute(){
    return lateMinute;
  }
  /**
   * 逾期时长 setter
   * @param LateMinute
   */  
  public void setLateMinute(Integer lateMinute){
    this.lateMinute = lateMinute;
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
   * 月营业日 getter
   */
  public String getMonthDay(){
    return monthDay;
  }
  /**
   * 月营业日 setter
   * @param MonthDay
   */  
  public void setMonthDay(String monthDay){
    this.monthDay = monthDay;
  }
 
  /**
   * 开始时间 getter
   */
  public java.time.LocalDateTime getOpenTime(){
    return openTime;
  }
  /**
   * 开始时间 setter
   * @param OpenTime
   */  
  public void setOpenTime(java.time.LocalDateTime openTime){
    this.openTime = openTime;
  }
 
  /**
   * 机构编号 getter
   */
  public Long getOrgID(){
    return orgID;
  }
  /**
   * 机构编号 setter
   * @param OrgID
   */  
  public void setOrgID(Long orgID){
    this.orgID = orgID;
  }
 
  /**
   * 参数编号 getter
   */
  public Long getParamID(){
    return paramID;
  }
  /**
   * 参数编号 setter
   * @param ParamID
   */  
  public void setParamID(Long paramID){
    this.paramID = paramID;
  }
 
  /**
   * 预结待清 getter
   */
  public Boolean getPrePayPending(){
    return prePayPending;
  }
  /**
   * 预结待清 setter
   * @param PrePayPending
   */  
  public void setPrePayPending(Boolean prePayPending){
    this.prePayPending = prePayPending;
  }
 
  /**
   * 订金金额 getter
   */
  public Integer getReservationFee(){
    return reservationFee;
  }
  /**
   * 订金金额 setter
   * @param ReservationFee
   */  
  public void setReservationFee(Integer reservationFee){
    this.reservationFee = reservationFee;
  }
 
  /**
   * 订金方式 getter
   */
  public Long getReservationType(){
    return reservationType;
  }
  /**
   * 订金方式 setter
   * @param ReservationType
   */  
  public void setReservationType(Long reservationType){
    this.reservationType = reservationType;
  }
 
  /**
   * 服务费 getter
   */
  public Integer getServiceFee(){
    return serviceFee;
  }
  /**
   * 服务费 setter
   * @param ServiceFee
   */  
  public void setServiceFee(Integer serviceFee){
    this.serviceFee = serviceFee;
  }
 
  /**
   * 收取方式 getter
   */
  public Long getServiceFeeType(){
    return serviceFeeType;
  }
  /**
   * 收取方式 setter
   * @param ServiceFeeType
   */  
  public void setServiceFeeType(Long serviceFeeType){
    this.serviceFeeType = serviceFeeType;
  }
 
  /**
   * 特定日期 getter
   */
  public java.time.LocalDateTime getSpecificDay(){
    return specificDay;
  }
  /**
   * 特定日期 setter
   * @param SpecificDay
   */  
  public void setSpecificDay(java.time.LocalDateTime specificDay){
    this.specificDay = specificDay;
  }
 
  /**
   * 周营业日 getter
   */
  public String getWeekDay(){
    return weekDay;
  }
  /**
   * 周营业日 setter
   * @param WeekDay
   */  
  public void setWeekDay(String weekDay){
    this.weekDay = weekDay;
  }
 
  /**
   * 年营业日 getter
   */
  public java.time.LocalDateTime getYearDay(){
    return yearDay;
  }
  /**
   * 年营业日 setter
   * @param YearDay
   */  
  public void setYearDay(java.time.LocalDateTime yearDay){
    this.yearDay = yearDay;
  }
 
}