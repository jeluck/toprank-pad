package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在M_ActivityInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class M_ActivityInfoEntityBase extends Entity {

  /**
   *	ActivityBody数据库列名
   */
  public final static java.lang.String ACTIVITYBODY_FIELD =  "ActivityBody";
  
  /**
   *	ActivityBody字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVITYBODY_LABLE = "活动内容";
  
  /**
   *	ActivityBody对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String activityBody;
  
  /**
   *	ActivityCode数据库列名
   */
  public final static java.lang.String ACTIVITYCODE_FIELD =  "ActivityCode";
  
  /**
   *	ActivityCode字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVITYCODE_LABLE = "活动编码";
  
  /**
   *	ActivityCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String activityCode;
  
  /**
   *	ActivityDesc数据库列名
   */
  public final static java.lang.String ACTIVITYDESC_FIELD =  "ActivityDesc";
  
  /**
   *	ActivityDesc字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVITYDESC_LABLE = "活动描述";
  
  /**
   *	ActivityDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String activityDesc;
  
  /**
   *	ActivityID数据库列名
   */
  public final static java.lang.String ACTIVITYID_FIELD =  "ActivityID";
  
  /**
   *	ActivityID字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVITYID_LABLE = "活动编号";
  
  /**
   *	ActivityID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long activityID;
  
  /**
   *	ActivityName数据库列名
   */
  public final static java.lang.String ACTIVITYNAME_FIELD =  "ActivityName";
  
  /**
   *	ActivityName字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVITYNAME_LABLE = "活动名称";
  
  /**
   *	ActivityName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String activityName;
  
  /**
   *	ActivityPriority数据库列名
   */
  public final static java.lang.String ACTIVITYPRIORITY_FIELD =  "ActivityPriority";
  
  /**
   *	ActivityPriority字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVITYPRIORITY_LABLE = "ActivityPriority";
  
  /**
   *	ActivityPriority对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer activityPriority;
  
  /**
   *	ActivityStatus数据库列名
   */
  public final static java.lang.String ACTIVITYSTATUS_FIELD =  "ActivityStatus";
  
  /**
   *	ActivityStatus字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVITYSTATUS_LABLE = "活动状态";
  
  /**
   *	ActivityStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long activityStatus;
  
  /**
   *	ActivitySubject数据库列名
   */
  public final static java.lang.String ACTIVITYSUBJECT_FIELD =  "ActivitySubject";
  
  /**
   *	ActivitySubject字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVITYSUBJECT_LABLE = "活动主题";
  
  /**
   *	ActivitySubject对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String activitySubject;
  
  /**
   *	ActivityType数据库列名
   */
  public final static java.lang.String ACTIVITYTYPE_FIELD =  "ActivityType";
  
  /**
   *	ActivityType字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVITYTYPE_LABLE = "ActivityType";
  
  /**
   *	ActivityType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long activityType;
  
  /**
   *	ActivityUrl数据库列名
   */
  public final static java.lang.String ACTIVITYURL_FIELD =  "ActivityUrl";
  
  /**
   *	ActivityUrl字段中文名，用于视图展示
   */
  public final static java.lang.String ACTIVITYURL_LABLE = "关联链接";
  
  /**
   *	ActivityUrl对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String activityUrl;
  
  /**
   *	ActualCost数据库列名
   */
  public final static java.lang.String ACTUALCOST_FIELD =  "ActualCost";
  
  /**
   *	ActualCost字段中文名，用于视图展示
   */
  public final static java.lang.String ACTUALCOST_LABLE = "实际费用";
  
  /**
   *	ActualCost对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal actualCost;
  
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
   *	Duration数据库列名
   */
  public final static java.lang.String DURATION_FIELD =  "Duration";
  
  /**
   *	Duration字段中文名，用于视图展示
   */
  public final static java.lang.String DURATION_LABLE = "周期";
  
  /**
   *	Duration对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long duration;
  
  /**
   *	EndDate数据库列名
   */
  public final static java.lang.String ENDDATE_FIELD =  "EndDate";
  
  /**
   *	EndDate字段中文名，用于视图展示
   */
  public final static java.lang.String ENDDATE_LABLE = "结束日期";
  
  /**
   *	EndDate对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime endDate;
  
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
   *	EstimatedCost数据库列名
   */
  public final static java.lang.String ESTIMATEDCOST_FIELD =  "EstimatedCost";
  
  /**
   *	EstimatedCost字段中文名，用于视图展示
   */
  public final static java.lang.String ESTIMATEDCOST_LABLE = "预算费用";
  
  /**
   *	EstimatedCost对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal estimatedCost;
  
  /**
   *	IsMutuallyExclusive数据库列名
   */
  public final static java.lang.String ISMUTUALLYEXCLUSIVE_FIELD =  "IsMutuallyExclusive";
  
  /**
   *	IsMutuallyExclusive字段中文名，用于视图展示
   */
  public final static java.lang.String ISMUTUALLYEXCLUSIVE_LABLE = "IsMutuallyExclusive";
  
  /**
   *	IsMutuallyExclusive对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isMutuallyExclusive;
  
  /**
   *	LogoUrl数据库列名
   */
  public final static java.lang.String LOGOURL_FIELD =  "LogoUrl";
  
  /**
   *	LogoUrl字段中文名，用于视图展示
   */
  public final static java.lang.String LOGOURL_LABLE = "图标";
  
  /**
   *	LogoUrl对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String logoUrl;
  
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
   *	OrgID数据库列名
   */
  public final static java.lang.String ORGID_FIELD =  "OrgID";
  
  /**
   *	OrgID字段中文名，用于视图展示
   */
  public final static java.lang.String ORGID_LABLE = "OrgID";
  
  /**
   *	OrgID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orgID;
  
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
   *	StartDate数据库列名
   */
  public final static java.lang.String STARTDATE_FIELD =  "StartDate";
  
  /**
   *	StartDate字段中文名，用于视图展示
   */
  public final static java.lang.String STARTDATE_LABLE = "开始日期";
  
  /**
   *	StartDate对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime startDate;
  
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
   *	TimePoints数据库列名
   */
  public final static java.lang.String TIMEPOINTS_FIELD =  "TimePoints";
  
  /**
   *	TimePoints字段中文名，用于视图展示
   */
  public final static java.lang.String TIMEPOINTS_LABLE = "时间点";
  
  /**
   *	TimePoints对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String timePoints;
  
  /**
   * 活动内容 getter
   */
  public java.lang.String getActivityBody(){
    return activityBody;
  }
  /**
   * 活动内容 setter
   * @param ActivityBody
   */  
  public void setActivityBody(java.lang.String activityBody){
    this.activityBody = activityBody;
  }
 
  /**
   * 活动编码 getter
   */
  public java.lang.String getActivityCode(){
    return activityCode;
  }
  /**
   * 活动编码 setter
   * @param ActivityCode
   */  
  public void setActivityCode(java.lang.String activityCode){
    this.activityCode = activityCode;
  }
 
  /**
   * 活动描述 getter
   */
  public java.lang.String getActivityDesc(){
    return activityDesc;
  }
  /**
   * 活动描述 setter
   * @param ActivityDesc
   */  
  public void setActivityDesc(java.lang.String activityDesc){
    this.activityDesc = activityDesc;
  }
 
  /**
   * 活动编号 getter
   */
  public java.lang.Long getActivityID(){
    return activityID;
  }
  /**
   * 活动编号 setter
   * @param ActivityID
   */  
  public void setActivityID(java.lang.Long activityID){
    this.activityID = activityID;
  }
 
  /**
   * 活动名称 getter
   */
  public java.lang.String getActivityName(){
    return activityName;
  }
  /**
   * 活动名称 setter
   * @param ActivityName
   */  
  public void setActivityName(java.lang.String activityName){
    this.activityName = activityName;
  }
 
  /**
   * ActivityPriority getter
   */
  public java.lang.Integer getActivityPriority(){
    return activityPriority;
  }
  /**
   * ActivityPriority setter
   * @param ActivityPriority
   */  
  public void setActivityPriority(java.lang.Integer activityPriority){
    this.activityPriority = activityPriority;
  }
 
  /**
   * 活动状态 getter
   */
  public java.lang.Long getActivityStatus(){
    return activityStatus;
  }
  /**
   * 活动状态 setter
   * @param ActivityStatus
   */  
  public void setActivityStatus(java.lang.Long activityStatus){
    this.activityStatus = activityStatus;
  }
 
  /**
   * 活动主题 getter
   */
  public java.lang.String getActivitySubject(){
    return activitySubject;
  }
  /**
   * 活动主题 setter
   * @param ActivitySubject
   */  
  public void setActivitySubject(java.lang.String activitySubject){
    this.activitySubject = activitySubject;
  }
 
  /**
   * ActivityType getter
   */
  public java.lang.Long getActivityType(){
    return activityType;
  }
  /**
   * ActivityType setter
   * @param ActivityType
   */  
  public void setActivityType(java.lang.Long activityType){
    this.activityType = activityType;
  }
 
  /**
   * 关联链接 getter
   */
  public java.lang.String getActivityUrl(){
    return activityUrl;
  }
  /**
   * 关联链接 setter
   * @param ActivityUrl
   */  
  public void setActivityUrl(java.lang.String activityUrl){
    this.activityUrl = activityUrl;
  }
 
  /**
   * 实际费用 getter
   */
  public java.math.BigDecimal getActualCost(){
    return actualCost;
  }
  /**
   * 实际费用 setter
   * @param ActualCost
   */  
  public void setActualCost(java.math.BigDecimal actualCost){
    this.actualCost = actualCost;
  }
 
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
   * 周期 getter
   */
  public java.lang.Long getDuration(){
    return duration;
  }
  /**
   * 周期 setter
   * @param Duration
   */  
  public void setDuration(java.lang.Long duration){
    this.duration = duration;
  }
 
  /**
   * 结束日期 getter
   */
  public java.time.LocalDateTime getEndDate(){
    return endDate;
  }
  /**
   * 结束日期 setter
   * @param EndDate
   */  
  public void setEndDate(java.time.LocalDateTime endDate){
    this.endDate = endDate;
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
   * 预算费用 getter
   */
  public java.math.BigDecimal getEstimatedCost(){
    return estimatedCost;
  }
  /**
   * 预算费用 setter
   * @param EstimatedCost
   */  
  public void setEstimatedCost(java.math.BigDecimal estimatedCost){
    this.estimatedCost = estimatedCost;
  }
 
  /**
   * IsMutuallyExclusive getter
   */
  public java.lang.Boolean getIsMutuallyExclusive(){
    return isMutuallyExclusive;
  }
  /**
   * IsMutuallyExclusive setter
   * @param IsMutuallyExclusive
   */  
  public void setIsMutuallyExclusive(java.lang.Boolean isMutuallyExclusive){
    this.isMutuallyExclusive = isMutuallyExclusive;
  }
 
  /**
   * 图标 getter
   */
  public java.lang.String getLogoUrl(){
    return logoUrl;
  }
  /**
   * 图标 setter
   * @param LogoUrl
   */  
  public void setLogoUrl(java.lang.String logoUrl){
    this.logoUrl = logoUrl;
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
   * OrgID getter
   */
  public java.lang.Long getOrgID(){
    return orgID;
  }
  /**
   * OrgID setter
   * @param OrgID
   */  
  public void setOrgID(java.lang.Long orgID){
    this.orgID = orgID;
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
   * 开始日期 getter
   */
  public java.time.LocalDateTime getStartDate(){
    return startDate;
  }
  /**
   * 开始日期 setter
   * @param StartDate
   */  
  public void setStartDate(java.time.LocalDateTime startDate){
    this.startDate = startDate;
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
   * 时间点 getter
   */
  public java.lang.String getTimePoints(){
    return timePoints;
  }
  /**
   * 时间点 setter
   * @param TimePoints
   */  
  public void setTimePoints(java.lang.String timePoints){
    this.timePoints = timePoints;
  }
 
}