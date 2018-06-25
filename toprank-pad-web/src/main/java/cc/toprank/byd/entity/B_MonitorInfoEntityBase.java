package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_MonitorInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_MonitorInfoEntityBase extends Entity {

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
   *	ColumnNum数据库列名
   */
  public final static java.lang.String COLUMNNUM_FIELD =  "ColumnNum";
  
  /**
   *	ColumnNum字段中文名，用于视图展示
   */
  public final static java.lang.String COLUMNNUM_LABLE = "显示列数";
  
  /**
   *	ColumnNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer columnNum;
  
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
   *	DelayColor数据库列名
   */
  public final static java.lang.String DELAYCOLOR_FIELD =  "DelayColor";
  
  /**
   *	DelayColor字段中文名，用于视图展示
   */
  public final static java.lang.String DELAYCOLOR_LABLE = "超时颜色";
  
  /**
   *	DelayColor对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String delayColor;
  
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
   *	MACAddress数据库列名
   */
  public final static java.lang.String MACADDRESS_FIELD =  "MACAddress";
  
  /**
   *	MACAddress字段中文名，用于视图展示
   */
  public final static java.lang.String MACADDRESS_LABLE = "MAC地址";
  
  /**
   *	MACAddress对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String mACAddress;
  
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
   *	MonitorCode数据库列名
   */
  public final static java.lang.String MONITORCODE_FIELD =  "MonitorCode";
  
  /**
   *	MonitorCode字段中文名，用于视图展示
   */
  public final static java.lang.String MONITORCODE_LABLE = "看板编码";
  
  /**
   *	MonitorCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String monitorCode;
  
  /**
   *	MonitorDesc数据库列名
   */
  public final static java.lang.String MONITORDESC_FIELD =  "MonitorDesc";
  
  /**
   *	MonitorDesc字段中文名，用于视图展示
   */
  public final static java.lang.String MONITORDESC_LABLE = "看板描述";
  
  /**
   *	MonitorDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String monitorDesc;
  
  /**
   *	MonitorID数据库列名
   */
  public final static java.lang.String MONITORID_FIELD =  "MonitorID";
  
  /**
   *	MonitorID字段中文名，用于视图展示
   */
  public final static java.lang.String MONITORID_LABLE = "看板编号";
  
  /**
   *	MonitorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long monitorID;
  
  /**
   *	MonitorIP数据库列名
   */
  public final static java.lang.String MONITORIP_FIELD =  "MonitorIP";
  
  /**
   *	MonitorIP字段中文名，用于视图展示
   */
  public final static java.lang.String MONITORIP_LABLE = "看板IP";
  
  /**
   *	MonitorIP对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String monitorIP;
  
  /**
   *	MonitorName数据库列名
   */
  public final static java.lang.String MONITORNAME_FIELD =  "MonitorName";
  
  /**
   *	MonitorName字段中文名，用于视图展示
   */
  public final static java.lang.String MONITORNAME_LABLE = "看板名称";
  
  /**
   *	MonitorName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String monitorName;
  
  /**
   *	MonitorStatus数据库列名
   */
  public final static java.lang.String MONITORSTATUS_FIELD =  "MonitorStatus";
  
  /**
   *	MonitorStatus字段中文名，用于视图展示
   */
  public final static java.lang.String MONITORSTATUS_LABLE = "看板状态";
  
  /**
   *	MonitorStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long monitorStatus;
  
  /**
   *	NormalColor数据库列名
   */
  public final static java.lang.String NORMALCOLOR_FIELD =  "NormalColor";
  
  /**
   *	NormalColor字段中文名，用于视图展示
   */
  public final static java.lang.String NORMALCOLOR_LABLE = "正常颜色";
  
  /**
   *	NormalColor对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String normalColor;
  
  /**
   *	RefreshSecond数据库列名
   */
  public final static java.lang.String REFRESHSECOND_FIELD =  "RefreshSecond";
  
  /**
   *	RefreshSecond字段中文名，用于视图展示
   */
  public final static java.lang.String REFRESHSECOND_LABLE = "刷新时长";
  
  /**
   *	RefreshSecond对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer refreshSecond;
  
  /**
   *	ServerIP数据库列名
   */
  public final static java.lang.String SERVERIP_FIELD =  "ServerIP";
  
  /**
   *	ServerIP字段中文名，用于视图展示
   */
  public final static java.lang.String SERVERIP_LABLE = "服务IP";
  
  /**
   *	ServerIP对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String serverIP;
  
  /**
   *	ServerPort数据库列名
   */
  public final static java.lang.String SERVERPORT_FIELD =  "ServerPort";
  
  /**
   *	ServerPort字段中文名，用于视图展示
   */
  public final static java.lang.String SERVERPORT_LABLE = "服务端口";
  
  /**
   *	ServerPort对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer serverPort;
  
  /**
   *	ShowContentID数据库列名
   */
  public final static java.lang.String SHOWCONTENTID_FIELD =  "ShowContentID";
  
  /**
   *	ShowContentID字段中文名，用于视图展示
   */
  public final static java.lang.String SHOWCONTENTID_LABLE = "显示内容";
  
  /**
   *	ShowContentID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String showContentID;
  
  /**
   *	ShowTimer数据库列名
   */
  public final static java.lang.String SHOWTIMER_FIELD =  "ShowTimer";
  
  /**
   *	ShowTimer字段中文名，用于视图展示
   */
  public final static java.lang.String SHOWTIMER_LABLE = "显示计时";
  
  /**
   *	ShowTimer对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean showTimer;
  
  /**
   *	ShowType数据库列名
   */
  public final static java.lang.String SHOWTYPE_FIELD =  "ShowType";
  
  /**
   *	ShowType字段中文名，用于视图展示
   */
  public final static java.lang.String SHOWTYPE_LABLE = "显示方式";
  
  /**
   *	ShowType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long showType;
  
  /**
   *	SkinType数据库列名
   */
  public final static java.lang.String SKINTYPE_FIELD =  "SkinType";
  
  /**
   *	SkinType字段中文名，用于视图展示
   */
  public final static java.lang.String SKINTYPE_LABLE = "外观类型";
  
  /**
   *	SkinType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long skinType;
  
  /**
   *	SuspensionColor数据库列名
   */
  public final static java.lang.String SUSPENSIONCOLOR_FIELD =  "SuspensionColor";
  
  /**
   *	SuspensionColor字段中文名，用于视图展示
   */
  public final static java.lang.String SUSPENSIONCOLOR_LABLE = "暂缓颜色";
  
  /**
   *	SuspensionColor对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String suspensionColor;
  
  /**
   *	SwitchSecond数据库列名
   */
  public final static java.lang.String SWITCHSECOND_FIELD =  "SwitchSecond";
  
  /**
   *	SwitchSecond字段中文名，用于视图展示
   */
  public final static java.lang.String SWITCHSECOND_LABLE = "切屏时长";
  
  /**
   *	SwitchSecond对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer switchSecond;
  
  /**
   *	UrgentColor数据库列名
   */
  public final static java.lang.String URGENTCOLOR_FIELD =  "UrgentColor";
  
  /**
   *	UrgentColor字段中文名，用于视图展示
   */
  public final static java.lang.String URGENTCOLOR_LABLE = "加急颜色";
  
  /**
   *	UrgentColor对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String urgentColor;
  
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
   * 显示列数 getter
   */
  public java.lang.Integer getColumnNum(){
    return columnNum;
  }
  /**
   * 显示列数 setter
   * @param ColumnNum
   */  
  public void setColumnNum(java.lang.Integer columnNum){
    this.columnNum = columnNum;
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
   * 超时颜色 getter
   */
  public java.lang.String getDelayColor(){
    return delayColor;
  }
  /**
   * 超时颜色 setter
   * @param DelayColor
   */  
  public void setDelayColor(java.lang.String delayColor){
    this.delayColor = delayColor;
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
   * MAC地址 getter
   */
  public java.lang.String getMACAddress(){
    return mACAddress;
  }
  /**
   * MAC地址 setter
   * @param MACAddress
   */  
  public void setMACAddress(java.lang.String mACAddress){
    this.mACAddress = mACAddress;
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
   * 看板编码 getter
   */
  public java.lang.String getMonitorCode(){
    return monitorCode;
  }
  /**
   * 看板编码 setter
   * @param MonitorCode
   */  
  public void setMonitorCode(java.lang.String monitorCode){
    this.monitorCode = monitorCode;
  }
 
  /**
   * 看板描述 getter
   */
  public java.lang.String getMonitorDesc(){
    return monitorDesc;
  }
  /**
   * 看板描述 setter
   * @param MonitorDesc
   */  
  public void setMonitorDesc(java.lang.String monitorDesc){
    this.monitorDesc = monitorDesc;
  }
 
  /**
   * 看板编号 getter
   */
  public java.lang.Long getMonitorID(){
    return monitorID;
  }
  /**
   * 看板编号 setter
   * @param MonitorID
   */  
  public void setMonitorID(java.lang.Long monitorID){
    this.monitorID = monitorID;
  }
 
  /**
   * 看板IP getter
   */
  public java.lang.String getMonitorIP(){
    return monitorIP;
  }
  /**
   * 看板IP setter
   * @param MonitorIP
   */  
  public void setMonitorIP(java.lang.String monitorIP){
    this.monitorIP = monitorIP;
  }
 
  /**
   * 看板名称 getter
   */
  public java.lang.String getMonitorName(){
    return monitorName;
  }
  /**
   * 看板名称 setter
   * @param MonitorName
   */  
  public void setMonitorName(java.lang.String monitorName){
    this.monitorName = monitorName;
  }
 
  /**
   * 看板状态 getter
   */
  public java.lang.Long getMonitorStatus(){
    return monitorStatus;
  }
  /**
   * 看板状态 setter
   * @param MonitorStatus
   */  
  public void setMonitorStatus(java.lang.Long monitorStatus){
    this.monitorStatus = monitorStatus;
  }
 
  /**
   * 正常颜色 getter
   */
  public java.lang.String getNormalColor(){
    return normalColor;
  }
  /**
   * 正常颜色 setter
   * @param NormalColor
   */  
  public void setNormalColor(java.lang.String normalColor){
    this.normalColor = normalColor;
  }
 
  /**
   * 刷新时长 getter
   */
  public java.lang.Integer getRefreshSecond(){
    return refreshSecond;
  }
  /**
   * 刷新时长 setter
   * @param RefreshSecond
   */  
  public void setRefreshSecond(java.lang.Integer refreshSecond){
    this.refreshSecond = refreshSecond;
  }
 
  /**
   * 服务IP getter
   */
  public java.lang.String getServerIP(){
    return serverIP;
  }
  /**
   * 服务IP setter
   * @param ServerIP
   */  
  public void setServerIP(java.lang.String serverIP){
    this.serverIP = serverIP;
  }
 
  /**
   * 服务端口 getter
   */
  public java.lang.Integer getServerPort(){
    return serverPort;
  }
  /**
   * 服务端口 setter
   * @param ServerPort
   */  
  public void setServerPort(java.lang.Integer serverPort){
    this.serverPort = serverPort;
  }
 
  /**
   * 显示内容 getter
   */
  public java.lang.String getShowContentID(){
    return showContentID;
  }
  /**
   * 显示内容 setter
   * @param ShowContentID
   */  
  public void setShowContentID(java.lang.String showContentID){
    this.showContentID = showContentID;
  }
 
  /**
   * 显示计时 getter
   */
  public java.lang.Boolean getShowTimer(){
    return showTimer;
  }
  /**
   * 显示计时 setter
   * @param ShowTimer
   */  
  public void setShowTimer(java.lang.Boolean showTimer){
    this.showTimer = showTimer;
  }
 
  /**
   * 显示方式 getter
   */
  public java.lang.Long getShowType(){
    return showType;
  }
  /**
   * 显示方式 setter
   * @param ShowType
   */  
  public void setShowType(java.lang.Long showType){
    this.showType = showType;
  }
 
  /**
   * 外观类型 getter
   */
  public java.lang.Long getSkinType(){
    return skinType;
  }
  /**
   * 外观类型 setter
   * @param SkinType
   */  
  public void setSkinType(java.lang.Long skinType){
    this.skinType = skinType;
  }
 
  /**
   * 暂缓颜色 getter
   */
  public java.lang.String getSuspensionColor(){
    return suspensionColor;
  }
  /**
   * 暂缓颜色 setter
   * @param SuspensionColor
   */  
  public void setSuspensionColor(java.lang.String suspensionColor){
    this.suspensionColor = suspensionColor;
  }
 
  /**
   * 切屏时长 getter
   */
  public java.lang.Integer getSwitchSecond(){
    return switchSecond;
  }
  /**
   * 切屏时长 setter
   * @param SwitchSecond
   */  
  public void setSwitchSecond(java.lang.Integer switchSecond){
    this.switchSecond = switchSecond;
  }
 
  /**
   * 加急颜色 getter
   */
  public java.lang.String getUrgentColor(){
    return urgentColor;
  }
  /**
   * 加急颜色 setter
   * @param UrgentColor
   */  
  public void setUrgentColor(java.lang.String urgentColor){
    this.urgentColor = urgentColor;
  }
 
}