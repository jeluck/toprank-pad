package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_ReservationTimeInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_ReservationTimeInfoEntityBase extends Entity {

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
   *	BookingType数据库列名
   */
  public final static java.lang.String BOOKINGTYPE_FIELD =  "BookingType";
  
  /**
   *	BookingType字段中文名，用于视图展示
   */
  public final static java.lang.String BOOKINGTYPE_LABLE = "预订类型";
  
  /**
   *	BookingType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long bookingType;
  
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
   *	ExtensionMinute数据库列名
   */
  public final static java.lang.String EXTENSIONMINUTE_FIELD =  "ExtensionMinute";
  
  /**
   *	ExtensionMinute字段中文名，用于视图展示
   */
  public final static java.lang.String EXTENSIONMINUTE_LABLE = "延期时长";
  
  /**
   *	ExtensionMinute对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer extensionMinute;
  
  /**
   *	ExtensionNum数据库列名
   */
  public final static java.lang.String EXTENSIONNUM_FIELD =  "ExtensionNum";
  
  /**
   *	ExtensionNum字段中文名，用于视图展示
   */
  public final static java.lang.String EXTENSIONNUM_LABLE = "延期次数";
  
  /**
   *	ExtensionNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer extensionNum;
  
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
   *	LateMinute数据库列名
   */
  public final static java.lang.String LATEMINUTE_FIELD =  "LateMinute";
  
  /**
   *	LateMinute字段中文名，用于视图展示
   */
  public final static java.lang.String LATEMINUTE_LABLE = "逾期时长";
  
  /**
   *	LateMinute对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer lateMinute;
  
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
   *	ReceiveDiscount数据库列名
   */
  public final static java.lang.String RECEIVEDISCOUNT_FIELD =  "ReceiveDiscount";
  
  /**
   *	ReceiveDiscount字段中文名，用于视图展示
   */
  public final static java.lang.String RECEIVEDISCOUNT_LABLE = "享受折扣";
  
  /**
   *	ReceiveDiscount对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean receiveDiscount;
  
  /**
   *	SettingDesc数据库列名
   */
  public final static java.lang.String SETTINGDESC_FIELD =  "SettingDesc";
  
  /**
   *	SettingDesc字段中文名，用于视图展示
   */
  public final static java.lang.String SETTINGDESC_LABLE = "配置描述";
  
  /**
   *	SettingDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String settingDesc;
  
  /**
   *	SettingID数据库列名
   */
  public final static java.lang.String SETTINGID_FIELD =  "SettingID";
  
  /**
   *	SettingID字段中文名，用于视图展示
   */
  public final static java.lang.String SETTINGID_LABLE = "配置编号";
  
  /**
   *	SettingID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long settingID;
  
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
   * 预订类型 getter
   */
  public java.lang.Long getBookingType(){
    return bookingType;
  }
  /**
   * 预订类型 setter
   * @param BookingType
   */  
  public void setBookingType(java.lang.Long bookingType){
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
   * 延期时长 getter
   */
  public java.lang.Integer getExtensionMinute(){
    return extensionMinute;
  }
  /**
   * 延期时长 setter
   * @param ExtensionMinute
   */  
  public void setExtensionMinute(java.lang.Integer extensionMinute){
    this.extensionMinute = extensionMinute;
  }
 
  /**
   * 延期次数 getter
   */
  public java.lang.Integer getExtensionNum(){
    return extensionNum;
  }
  /**
   * 延期次数 setter
   * @param ExtensionNum
   */  
  public void setExtensionNum(java.lang.Integer extensionNum){
    this.extensionNum = extensionNum;
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
   * 逾期时长 getter
   */
  public java.lang.Integer getLateMinute(){
    return lateMinute;
  }
  /**
   * 逾期时长 setter
   * @param LateMinute
   */  
  public void setLateMinute(java.lang.Integer lateMinute){
    this.lateMinute = lateMinute;
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
   * 享受折扣 getter
   */
  public java.lang.Boolean getReceiveDiscount(){
    return receiveDiscount;
  }
  /**
   * 享受折扣 setter
   * @param ReceiveDiscount
   */  
  public void setReceiveDiscount(java.lang.Boolean receiveDiscount){
    this.receiveDiscount = receiveDiscount;
  }
 
  /**
   * 配置描述 getter
   */
  public java.lang.String getSettingDesc(){
    return settingDesc;
  }
  /**
   * 配置描述 setter
   * @param SettingDesc
   */  
  public void setSettingDesc(java.lang.String settingDesc){
    this.settingDesc = settingDesc;
  }
 
  /**
   * 配置编号 getter
   */
  public java.lang.Long getSettingID(){
    return settingID;
  }
  /**
   * 配置编号 setter
   * @param SettingID
   */  
  public void setSettingID(java.lang.Long settingID){
    this.settingID = settingID;
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
 
}