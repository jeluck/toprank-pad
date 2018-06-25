package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_TableManagerInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_TableManagerInfoEntityBase extends Entity {

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
   *	ConfigID数据库列名
   */
  public final static String CONFIGID_FIELD =  "ConfigID";
  
  /**
   *	ConfigID字段中文名，用于视图展示
   */
  public final static String CONFIGID_LABLE = "配置编号";
  
  /**
   *	ConfigID对应的java字段名,业务操作使用这个字段。
   */
  private Long configID;
  
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
   *	DutyID数据库列名
   */
  public final static String DUTYID_FIELD =  "DutyID";
  
  /**
   *	DutyID字段中文名，用于视图展示
   */
  public final static String DUTYID_LABLE = "排班编号";
  
  /**
   *	DutyID对应的java字段名,业务操作使用这个字段。
   */
  private Long dutyID;
  
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
   *	ManageDesc数据库列名
   */
  public final static String MANAGEDESC_FIELD =  "ManageDesc";
  
  /**
   *	ManageDesc字段中文名，用于视图展示
   */
  public final static String MANAGEDESC_LABLE = "职责描述";
  
  /**
   *	ManageDesc对应的java字段名,业务操作使用这个字段。
   */
  private String manageDesc;
  
  /**
   *	ManageType数据库列名
   */
  public final static String MANAGETYPE_FIELD =  "ManageType";
  
  /**
   *	ManageType字段中文名，用于视图展示
   */
  public final static String MANAGETYPE_LABLE = "负责类别";
  
  /**
   *	ManageType对应的java字段名,业务操作使用这个字段。
   */
  private Long manageType;
  
  /**
   *	MappingStatus数据库列名
   */
  public final static String MAPPINGSTATUS_FIELD =  "MappingStatus";
  
  /**
   *	MappingStatus字段中文名，用于视图展示
   */
  public final static String MAPPINGSTATUS_LABLE = "关联状态";
  
  /**
   *	MappingStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long mappingStatus;
  
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
   *	ServiceAnswerType数据库列名
   */
  public final static String SERVICEANSWERTYPE_FIELD =  "ServiceAnswerType";
  
  /**
   *	ServiceAnswerType字段中文名，用于视图展示
   */
  public final static String SERVICEANSWERTYPE_LABLE = "响应类别";
  
  /**
   *	ServiceAnswerType对应的java字段名,业务操作使用这个字段。
   */
  private Long serviceAnswerType;
  
  /**
   *	SettingID数据库列名
   */
  public final static String SETTINGID_FIELD =  "SettingID";
  
  /**
   *	SettingID字段中文名，用于视图展示
   */
  public final static String SETTINGID_LABLE = "设置编号";
  
  /**
   *	SettingID对应的java字段名,业务操作使用这个字段。
   */
  private Long settingID;
  
  /**
   *	TableCode数据库列名
   */
  public final static String TABLECODE_FIELD =  "TableCode";
  
  /**
   *	TableCode字段中文名，用于视图展示
   */
  public final static String TABLECODE_LABLE = "桌台编码";
  
  /**
   *	TableCode对应的java字段名,业务操作使用这个字段。
   */
  private String tableCode;
  
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
   *	TableName数据库列名
   */
  public final static String TABLENAME_FIELD =  "TableName";
  
  /**
   *	TableName字段中文名，用于视图展示
   */
  public final static String TABLENAME_LABLE = "桌台名称";
  
  /**
   *	TableName对应的java字段名,业务操作使用这个字段。
   */
  private String tableName;
  
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
   * 配置编号 getter
   */
  public Long getConfigID(){
    return configID;
  }
  /**
   * 配置编号 setter
   * @param ConfigID
   */  
  public void setConfigID(Long configID){
    this.configID = configID;
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
   * 排班编号 getter
   */
  public Long getDutyID(){
    return dutyID;
  }
  /**
   * 排班编号 setter
   * @param DutyID
   */  
  public void setDutyID(Long dutyID){
    this.dutyID = dutyID;
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
   * 职责描述 getter
   */
  public String getManageDesc(){
    return manageDesc;
  }
  /**
   * 职责描述 setter
   * @param ManageDesc
   */  
  public void setManageDesc(String manageDesc){
    this.manageDesc = manageDesc;
  }
 
  /**
   * 负责类别 getter
   */
  public Long getManageType(){
    return manageType;
  }
  /**
   * 负责类别 setter
   * @param ManageType
   */  
  public void setManageType(Long manageType){
    this.manageType = manageType;
  }
 
  /**
   * 关联状态 getter
   */
  public Long getMappingStatus(){
    return mappingStatus;
  }
  /**
   * 关联状态 setter
   * @param MappingStatus
   */  
  public void setMappingStatus(Long mappingStatus){
    this.mappingStatus = mappingStatus;
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
   * 响应类别 getter
   */
  public Long getServiceAnswerType(){
    return serviceAnswerType;
  }
  /**
   * 响应类别 setter
   * @param ServiceAnswerType
   */  
  public void setServiceAnswerType(Long serviceAnswerType){
    this.serviceAnswerType = serviceAnswerType;
  }
 
  /**
   * 设置编号 getter
   */
  public Long getSettingID(){
    return settingID;
  }
  /**
   * 设置编号 setter
   * @param SettingID
   */  
  public void setSettingID(Long settingID){
    this.settingID = settingID;
  }
 
  /**
   * 桌台编码 getter
   */
  public String getTableCode(){
    return tableCode;
  }
  /**
   * 桌台编码 setter
   * @param TableCode
   */  
  public void setTableCode(String tableCode){
    this.tableCode = tableCode;
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
   * 桌台名称 getter
   */
  public String getTableName(){
    return tableName;
  }
  /**
   * 桌台名称 setter
   * @param TableName
   */  
  public void setTableName(String tableName){
    this.tableName = tableName;
  }
 
}