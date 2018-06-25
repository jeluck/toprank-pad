package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_MealsInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_MealsInfoEntityBase extends Entity {

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
   *	AreaID数据库列名
   */
  public final static java.lang.String AREAID_FIELD =  "AreaID";
  
  /**
   *	AreaID字段中文名，用于视图展示
   */
  public final static java.lang.String AREAID_LABLE = "区域编号";
  
  /**
   *	AreaID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long areaID;
  
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
   *	EndTime数据库列名
   */
  public final static java.lang.String ENDTIME_FIELD =  "EndTime";
  
  /**
   *	EndTime字段中文名，用于视图展示
   */
  public final static java.lang.String ENDTIME_LABLE = "截止时间";
  
  /**
   *	EndTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime endTime;
  
  /**
   *	IsDefault数据库列名
   */
  public final static java.lang.String ISDEFAULT_FIELD =  "IsDefault";
  
  /**
   *	IsDefault字段中文名，用于视图展示
   */
  public final static java.lang.String ISDEFAULT_LABLE = "是否默认";
  
  /**
   *	IsDefault对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long isDefault;
  
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
   *	MealCode数据库列名
   */
  public final static java.lang.String MEALCODE_FIELD =  "MealCode";
  
  /**
   *	MealCode字段中文名，用于视图展示
   */
  public final static java.lang.String MEALCODE_LABLE = "餐次编码";
  
  /**
   *	MealCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String mealCode;
  
  /**
   *	MealName数据库列名
   */
  public final static java.lang.String MEALNAME_FIELD =  "MealName";
  
  /**
   *	MealName字段中文名，用于视图展示
   */
  public final static java.lang.String MEALNAME_LABLE = "餐次名称";
  
  /**
   *	MealName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String mealName;
  
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
   *	MealStatus数据库列名
   */
  public final static java.lang.String MEALSTATUS_FIELD =  "MealStatus";
  
  /**
   *	MealStatus字段中文名，用于视图展示
   */
  public final static java.lang.String MEALSTATUS_LABLE = "餐次状态";
  
  /**
   *	MealStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mealStatus;
  
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
   *	MinLength数据库列名
   */
  public final static java.lang.String MINLENGTH_FIELD =  "MinLength";
  
  /**
   *	MinLength字段中文名，用于视图展示
   */
  public final static java.lang.String MINLENGTH_LABLE = "最短时长(分钟)";
  
  /**
   *	MinLength对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer minLength;
  
  /**
   *	OrgID数据库列名
   */
  public final static java.lang.String ORGID_FIELD =  "OrgID";
  
  /**
   *	OrgID字段中文名，用于视图展示
   */
  public final static java.lang.String ORGID_LABLE = "机构编号";
  
  /**
   *	OrgID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orgID;
  
  /**
   *	ParentID数据库列名
   */
  public final static java.lang.String PARENTID_FIELD =  "ParentID";
  
  /**
   *	ParentID字段中文名，用于视图展示
   */
  public final static java.lang.String PARENTID_LABLE = "上级编号";
  
  /**
   *	ParentID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long parentID;
  
  /**
   *	SegmentLength数据库列名
   */
  public final static java.lang.String SEGMENTLENGTH_FIELD =  "SegmentLength";
  
  /**
   *	SegmentLength字段中文名，用于视图展示
   */
  public final static java.lang.String SEGMENTLENGTH_LABLE = "餐段时长(分钟)";
  
  /**
   *	SegmentLength对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer segmentLength;
  
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
   * 区域编号 getter
   */
  public java.lang.Long getAreaID(){
    return areaID;
  }
  /**
   * 区域编号 setter
   * @param AreaID
   */  
  public void setAreaID(java.lang.Long areaID){
    this.areaID = areaID;
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
   * 截止时间 getter
   */
  public java.time.LocalDateTime getEndTime(){
    return endTime;
  }
  /**
   * 截止时间 setter
   * @param EndTime
   */  
  public void setEndTime(java.time.LocalDateTime endTime){
    this.endTime = endTime;
  }
 
  /**
   * 是否默认 getter
   */
  public java.lang.Long getIsDefault(){
    return isDefault;
  }
  /**
   * 是否默认 setter
   * @param IsDefault
   */  
  public void setIsDefault(java.lang.Long isDefault){
    this.isDefault = isDefault;
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
   * 餐次编码 getter
   */
  public java.lang.String getMealCode(){
    return mealCode;
  }
  /**
   * 餐次编码 setter
   * @param MealCode
   */  
  public void setMealCode(java.lang.String mealCode){
    this.mealCode = mealCode;
  }
 
  /**
   * 餐次名称 getter
   */
  public java.lang.String getMealName(){
    return mealName;
  }
  /**
   * 餐次名称 setter
   * @param MealName
   */  
  public void setMealName(java.lang.String mealName){
    this.mealName = mealName;
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
   * 餐次状态 getter
   */
  public java.lang.Long getMealStatus(){
    return mealStatus;
  }
  /**
   * 餐次状态 setter
   * @param MealStatus
   */  
  public void setMealStatus(java.lang.Long mealStatus){
    this.mealStatus = mealStatus;
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
   * 最短时长(分钟) getter
   */
  public java.lang.Integer getMinLength(){
    return minLength;
  }
  /**
   * 最短时长(分钟) setter
   * @param MinLength
   */  
  public void setMinLength(java.lang.Integer minLength){
    this.minLength = minLength;
  }
 
  /**
   * 机构编号 getter
   */
  public java.lang.Long getOrgID(){
    return orgID;
  }
  /**
   * 机构编号 setter
   * @param OrgID
   */  
  public void setOrgID(java.lang.Long orgID){
    this.orgID = orgID;
  }
 
  /**
   * 上级编号 getter
   */
  public java.lang.Long getParentID(){
    return parentID;
  }
  /**
   * 上级编号 setter
   * @param ParentID
   */  
  public void setParentID(java.lang.Long parentID){
    this.parentID = parentID;
  }
 
  /**
   * 餐段时长(分钟) getter
   */
  public java.lang.Integer getSegmentLength(){
    return segmentLength;
  }
  /**
   * 餐段时长(分钟) setter
   * @param SegmentLength
   */  
  public void setSegmentLength(java.lang.Integer segmentLength){
    this.segmentLength = segmentLength;
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
 
}