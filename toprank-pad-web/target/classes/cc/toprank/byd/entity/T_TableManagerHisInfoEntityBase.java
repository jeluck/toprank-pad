package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在T_TableManagerHisInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class T_TableManagerHisInfoEntityBase extends Entity {

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
   *	AreaName数据库列名
   */
  public final static java.lang.String AREANAME_FIELD =  "AreaName";
  
  /**
   *	AreaName字段中文名，用于视图展示
   */
  public final static java.lang.String AREANAME_LABLE = "区域名称";
  
  /**
   *	AreaName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String areaName;
  
  /**
   *	ComplaintNum数据库列名
   */
  public final static java.lang.String COMPLAINTNUM_FIELD =  "ComplaintNum";
  
  /**
   *	ComplaintNum字段中文名，用于视图展示
   */
  public final static java.lang.String COMPLAINTNUM_LABLE = "投诉次数";
  
  /**
   *	ComplaintNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer complaintNum;
  
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
   *	DutyDate数据库列名
   */
  public final static java.lang.String DUTYDATE_FIELD =  "DutyDate";
  
  /**
   *	DutyDate字段中文名，用于视图展示
   */
  public final static java.lang.String DUTYDATE_LABLE = "值班日期";
  
  /**
   *	DutyDate对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime dutyDate;
  
  /**
   *	DutyDuration数据库列名
   */
  public final static java.lang.String DUTYDURATION_FIELD =  "DutyDuration";
  
  /**
   *	DutyDuration字段中文名，用于视图展示
   */
  public final static java.lang.String DUTYDURATION_LABLE = "值班时长";
  
  /**
   *	DutyDuration对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer dutyDuration;
  
  /**
   *	EvaluateTime数据库列名
   */
  public final static java.lang.String EVALUATETIME_FIELD =  "EvaluateTime";
  
  /**
   *	EvaluateTime字段中文名，用于视图展示
   */
  public final static java.lang.String EVALUATETIME_LABLE = "评价时间";
  
  /**
   *	EvaluateTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime evaluateTime;
  
  /**
   *	Evaluator数据库列名
   */
  public final static java.lang.String EVALUATOR_FIELD =  "Evaluator";
  
  /**
   *	Evaluator字段中文名，用于视图展示
   */
  public final static java.lang.String EVALUATOR_LABLE = "评价人";
  
  /**
   *	Evaluator对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long evaluator;
  
  /**
   *	HisID数据库列名
   */
  public final static java.lang.String HISID_FIELD =  "HisID";
  
  /**
   *	HisID字段中文名，用于视图展示
   */
  public final static java.lang.String HISID_LABLE = "历史编号";
  
  /**
   *	HisID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long hisID;
  
  /**
   *	LoginID数据库列名
   */
  public final static java.lang.String LOGINID_FIELD =  "LoginID";
  
  /**
   *	LoginID字段中文名，用于视图展示
   */
  public final static java.lang.String LOGINID_LABLE = "登录编号";
  
  /**
   *	LoginID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long loginID;
  
  /**
   *	ManageDesc数据库列名
   */
  public final static java.lang.String MANAGEDESC_FIELD =  "ManageDesc";
  
  /**
   *	ManageDesc字段中文名，用于视图展示
   */
  public final static java.lang.String MANAGEDESC_LABLE = "职责描述";
  
  /**
   *	ManageDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String manageDesc;
  
  /**
   *	ManageType数据库列名
   */
  public final static java.lang.String MANAGETYPE_FIELD =  "ManageType";
  
  /**
   *	ManageType字段中文名，用于视图展示
   */
  public final static java.lang.String MANAGETYPE_LABLE = "负责类别";
  
  /**
   *	ManageType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long manageType;
  
  /**
   *	ManagTypeName数据库列名
   */
  public final static java.lang.String MANAGTYPENAME_FIELD =  "ManagTypeName";
  
  /**
   *	ManagTypeName字段中文名，用于视图展示
   */
  public final static java.lang.String MANAGTYPENAME_LABLE = "负责名称";
  
  /**
   *	ManagTypeName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String managTypeName;
  
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
   *	NickName数据库列名
   */
  public final static java.lang.String NICKNAME_FIELD =  "NickName";
  
  /**
   *	NickName字段中文名，用于视图展示
   */
  public final static java.lang.String NICKNAME_LABLE = "昵称";
  
  /**
   *	NickName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String nickName;
  
  /**
   *	Score数据库列名
   */
  public final static java.lang.String SCORE_FIELD =  "Score";
  
  /**
   *	Score字段中文名，用于视图展示
   */
  public final static java.lang.String SCORE_LABLE = "综合评价";
  
  /**
   *	Score对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer score;
  
  /**
   *	ServiceAnswerType数据库列名
   */
  public final static java.lang.String SERVICEANSWERTYPE_FIELD =  "ServiceAnswerType";
  
  /**
   *	ServiceAnswerType字段中文名，用于视图展示
   */
  public final static java.lang.String SERVICEANSWERTYPE_LABLE = "响应类别";
  
  /**
   *	ServiceAnswerType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long serviceAnswerType;
  
  /**
   *	ServiceAnswerTypeName数据库列名
   */
  public final static java.lang.String SERVICEANSWERTYPENAME_FIELD =  "ServiceAnswerTypeName";
  
  /**
   *	ServiceAnswerTypeName字段中文名，用于视图展示
   */
  public final static java.lang.String SERVICEANSWERTYPENAME_LABLE = "响应名称";
  
  /**
   *	ServiceAnswerTypeName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String serviceAnswerTypeName;
  
  /**
   *	ServiceNum数据库列名
   */
  public final static java.lang.String SERVICENUM_FIELD =  "ServiceNum";
  
  /**
   *	ServiceNum字段中文名，用于视图展示
   */
  public final static java.lang.String SERVICENUM_LABLE = "服务次数";
  
  /**
   *	ServiceNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer serviceNum;
  
  /**
   *	Severity数据库列名
   */
  public final static java.lang.String SEVERITY_FIELD =  "Severity";
  
  /**
   *	Severity字段中文名，用于视图展示
   */
  public final static java.lang.String SEVERITY_LABLE = "严重程度";
  
  /**
   *	Severity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long severity;
  
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
   *	TableCode数据库列名
   */
  public final static java.lang.String TABLECODE_FIELD =  "TableCode";
  
  /**
   *	TableCode字段中文名，用于视图展示
   */
  public final static java.lang.String TABLECODE_LABLE = "桌台编码";
  
  /**
   *	TableCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String tableCode;
  
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
   *	TableName数据库列名
   */
  public final static java.lang.String TABLENAME_FIELD =  "TableName";
  
  /**
   *	TableName字段中文名，用于视图展示
   */
  public final static java.lang.String TABLENAME_LABLE = "桌台名称";
  
  /**
   *	TableName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String tableName;
  
  /**
   *	UserName数据库列名
   */
  public final static java.lang.String USERNAME_FIELD =  "UserName";
  
  /**
   *	UserName字段中文名，用于视图展示
   */
  public final static java.lang.String USERNAME_LABLE = "姓名";
  
  /**
   *	UserName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String userName;
  
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
   * 区域名称 getter
   */
  public java.lang.String getAreaName(){
    return areaName;
  }
  /**
   * 区域名称 setter
   * @param AreaName
   */  
  public void setAreaName(java.lang.String areaName){
    this.areaName = areaName;
  }
 
  /**
   * 投诉次数 getter
   */
  public java.lang.Integer getComplaintNum(){
    return complaintNum;
  }
  /**
   * 投诉次数 setter
   * @param ComplaintNum
   */  
  public void setComplaintNum(java.lang.Integer complaintNum){
    this.complaintNum = complaintNum;
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
   * 值班日期 getter
   */
  public java.time.LocalDateTime getDutyDate(){
    return dutyDate;
  }
  /**
   * 值班日期 setter
   * @param DutyDate
   */  
  public void setDutyDate(java.time.LocalDateTime dutyDate){
    this.dutyDate = dutyDate;
  }
 
  /**
   * 值班时长 getter
   */
  public java.lang.Integer getDutyDuration(){
    return dutyDuration;
  }
  /**
   * 值班时长 setter
   * @param DutyDuration
   */  
  public void setDutyDuration(java.lang.Integer dutyDuration){
    this.dutyDuration = dutyDuration;
  }
 
  /**
   * 评价时间 getter
   */
  public java.time.LocalDateTime getEvaluateTime(){
    return evaluateTime;
  }
  /**
   * 评价时间 setter
   * @param EvaluateTime
   */  
  public void setEvaluateTime(java.time.LocalDateTime evaluateTime){
    this.evaluateTime = evaluateTime;
  }
 
  /**
   * 评价人 getter
   */
  public java.lang.Long getEvaluator(){
    return evaluator;
  }
  /**
   * 评价人 setter
   * @param Evaluator
   */  
  public void setEvaluator(java.lang.Long evaluator){
    this.evaluator = evaluator;
  }
 
  /**
   * 历史编号 getter
   */
  public java.lang.Long getHisID(){
    return hisID;
  }
  /**
   * 历史编号 setter
   * @param HisID
   */  
  public void setHisID(java.lang.Long hisID){
    this.hisID = hisID;
  }
 
  /**
   * 登录编号 getter
   */
  public java.lang.Long getLoginID(){
    return loginID;
  }
  /**
   * 登录编号 setter
   * @param LoginID
   */  
  public void setLoginID(java.lang.Long loginID){
    this.loginID = loginID;
  }
 
  /**
   * 职责描述 getter
   */
  public java.lang.String getManageDesc(){
    return manageDesc;
  }
  /**
   * 职责描述 setter
   * @param ManageDesc
   */  
  public void setManageDesc(java.lang.String manageDesc){
    this.manageDesc = manageDesc;
  }
 
  /**
   * 负责类别 getter
   */
  public java.lang.Long getManageType(){
    return manageType;
  }
  /**
   * 负责类别 setter
   * @param ManageType
   */  
  public void setManageType(java.lang.Long manageType){
    this.manageType = manageType;
  }
 
  /**
   * 负责名称 getter
   */
  public java.lang.String getManagTypeName(){
    return managTypeName;
  }
  /**
   * 负责名称 setter
   * @param ManagTypeName
   */  
  public void setManagTypeName(java.lang.String managTypeName){
    this.managTypeName = managTypeName;
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
   * 昵称 getter
   */
  public java.lang.String getNickName(){
    return nickName;
  }
  /**
   * 昵称 setter
   * @param NickName
   */  
  public void setNickName(java.lang.String nickName){
    this.nickName = nickName;
  }
 
  /**
   * 综合评价 getter
   */
  public java.lang.Integer getScore(){
    return score;
  }
  /**
   * 综合评价 setter
   * @param Score
   */  
  public void setScore(java.lang.Integer score){
    this.score = score;
  }
 
  /**
   * 响应类别 getter
   */
  public java.lang.Long getServiceAnswerType(){
    return serviceAnswerType;
  }
  /**
   * 响应类别 setter
   * @param ServiceAnswerType
   */  
  public void setServiceAnswerType(java.lang.Long serviceAnswerType){
    this.serviceAnswerType = serviceAnswerType;
  }
 
  /**
   * 响应名称 getter
   */
  public java.lang.String getServiceAnswerTypeName(){
    return serviceAnswerTypeName;
  }
  /**
   * 响应名称 setter
   * @param ServiceAnswerTypeName
   */  
  public void setServiceAnswerTypeName(java.lang.String serviceAnswerTypeName){
    this.serviceAnswerTypeName = serviceAnswerTypeName;
  }
 
  /**
   * 服务次数 getter
   */
  public java.lang.Integer getServiceNum(){
    return serviceNum;
  }
  /**
   * 服务次数 setter
   * @param ServiceNum
   */  
  public void setServiceNum(java.lang.Integer serviceNum){
    this.serviceNum = serviceNum;
  }
 
  /**
   * 严重程度 getter
   */
  public java.lang.Long getSeverity(){
    return severity;
  }
  /**
   * 严重程度 setter
   * @param Severity
   */  
  public void setSeverity(java.lang.Long severity){
    this.severity = severity;
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
   * 桌台编码 getter
   */
  public java.lang.String getTableCode(){
    return tableCode;
  }
  /**
   * 桌台编码 setter
   * @param TableCode
   */  
  public void setTableCode(java.lang.String tableCode){
    this.tableCode = tableCode;
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
   * 桌台名称 getter
   */
  public java.lang.String getTableName(){
    return tableName;
  }
  /**
   * 桌台名称 setter
   * @param TableName
   */  
  public void setTableName(java.lang.String tableName){
    this.tableName = tableName;
  }
 
  /**
   * 姓名 getter
   */
  public java.lang.String getUserName(){
    return userName;
  }
  /**
   * 姓名 setter
   * @param UserName
   */  
  public void setUserName(java.lang.String userName){
    this.userName = userName;
  }
 
}