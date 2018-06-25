package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_PeriodConfigInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_PeriodConfigInfoEntityBase  extends Entity {

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
   *	AreaID数据库列名
   */
  public final static String AREAID_FIELD =  "AreaID";

  /**
   *	AreaID字段中文名，用于视图展示
   */
  public final static String AREAID_LABLE = "区域编号";

  /**
   *	AreaID对应的java字段名,业务操作使用这个字段。
   */
  private Long areaID;

  /**
   *	BookingType数据库列名
   */
  public final static String BOOKINGTYPE_FIELD =  "BookingType";

  /**
   *	BookingType字段中文名，用于视图展示
   */
  public final static String BOOKINGTYPE_LABLE = "期限类型";

  /**
   *	BookingType对应的java字段名,业务操作使用这个字段。
   */
  private Long bookingType;

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
   *	Duration数据库列名
   */
  public final static String DURATION_FIELD =  "Duration";

  /**
   *	Duration字段中文名，用于视图展示
   */
  public final static String DURATION_LABLE = "时长";

  /**
   *	Duration对应的java字段名,业务操作使用这个字段。
   */
  private Integer duration;

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
   *	PeriodDesc数据库列名
   */
  public final static String PERIODDESC_FIELD =  "PeriodDesc";

  /**
   *	PeriodDesc字段中文名，用于视图展示
   */
  public final static String PERIODDESC_LABLE = "期限描述";

  /**
   *	PeriodDesc对应的java字段名,业务操作使用这个字段。
   */
  private String periodDesc;

  /**
   *	PeriodID数据库列名
   */
  public final static String PERIODID_FIELD =  "PeriodID";

  /**
   *	PeriodID字段中文名，用于视图展示
   */
  public final static String PERIODID_LABLE = "配置编号";

  /**
   *	PeriodID对应的java字段名,业务操作使用这个字段。
   */
  private Long periodID;

  /**
   *	PeriodName数据库列名
   */
  public final static String PERIODNAME_FIELD =  "PeriodName";

  /**
   *	PeriodName字段中文名，用于视图展示
   */
  public final static String PERIODNAME_LABLE = "期限名称";

  /**
   *	PeriodName对应的java字段名,业务操作使用这个字段。
   */
  private String periodName;

  /**
   *	RefundRate数据库列名
   */
  public final static String REFUNDRATE_FIELD =  "RefundRate";

  /**
   *	RefundRate字段中文名，用于视图展示
   */
  public final static String REFUNDRATE_LABLE = "退款比例";

  /**
   *	RefundRate对应的java字段名,业务操作使用这个字段。
   */
  private Float refundRate;

  /**
   *	TimeUnit数据库列名
   */
  public final static String TIMEUNIT_FIELD =  "TimeUnit";

  /**
   *	TimeUnit字段中文名，用于视图展示
   */
  public final static String TIMEUNIT_LABLE = "时间单位";

  /**
   *	TimeUnit对应的java字段名,业务操作使用这个字段。
   */
  private Long timeUnit;

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
   * 区域编号 getter
   */
  public Long getAreaID(){
    return areaID;
  }
  /**
   * 区域编号 setter
   * @param AreaID
   */
  public void setAreaID(Long areaID){
    this.areaID = areaID;
  }

  /**
   * 期限类型 getter
   */
  public Long getBookingType(){
    return bookingType;
  }
  /**
   * 期限类型 setter
   * @param BookingType
   */
  public void setBookingType(Long bookingType){
    this.bookingType = bookingType;
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
   * 时长 getter
   */
  public Integer getDuration(){
    return duration;
  }
  /**
   * 时长 setter
   * @param Duration
   */
  public void setDuration(Integer duration){
    this.duration = duration;
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
   * 期限描述 getter
   */
  public String getPeriodDesc(){
    return periodDesc;
  }
  /**
   * 期限描述 setter
   * @param PeriodDesc
   */
  public void setPeriodDesc(String periodDesc){
    this.periodDesc = periodDesc;
  }

  /**
   * 配置编号 getter
   */
  public Long getPeriodID(){
    return periodID;
  }
  /**
   * 配置编号 setter
   * @param PeriodID
   */
  public void setPeriodID(Long periodID){
    this.periodID = periodID;
  }

  /**
   * 期限名称 getter
   */
  public String getPeriodName(){
    return periodName;
  }
  /**
   * 期限名称 setter
   * @param PeriodName
   */
  public void setPeriodName(String periodName){
    this.periodName = periodName;
  }

  /**
   * 退款比例 getter
   */
  public Float getRefundRate(){
    return refundRate;
  }
  /**
   * 退款比例 setter
   * @param RefundRate
   */
  public void setRefundRate(Float refundRate){
    this.refundRate = refundRate;
  }

  /**
   * 时间单位 getter
   */
  public Long getTimeUnit(){
    return timeUnit;
  }
  /**
   * 时间单位 setter
   * @param TimeUnit
   */
  public void setTimeUnit(Long timeUnit){
    this.timeUnit = timeUnit;
  }
 
}