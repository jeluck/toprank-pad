package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_ProducePortInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_ProducePortInfoEntityBase extends Entity {

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
   *	PortCode数据库列名
   */
  public final static java.lang.String PORTCODE_FIELD =  "PortCode";
  
  /**
   *	PortCode字段中文名，用于视图展示
   */
  public final static java.lang.String PORTCODE_LABLE = "出品口编码";
  
  /**
   *	PortCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String portCode;
  
  /**
   *	PortDesc数据库列名
   */
  public final static java.lang.String PORTDESC_FIELD =  "PortDesc";
  
  /**
   *	PortDesc字段中文名，用于视图展示
   */
  public final static java.lang.String PORTDESC_LABLE = "出品品描述";
  
  /**
   *	PortDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String portDesc;
  
  /**
   *	PortID数据库列名
   */
  public final static java.lang.String PORTID_FIELD =  "PortID";
  
  /**
   *	PortID字段中文名，用于视图展示
   */
  public final static java.lang.String PORTID_LABLE = "出品口编号";
  
  /**
   *	PortID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long portID;
  
  /**
   *	PortName数据库列名
   */
  public final static java.lang.String PORTNAME_FIELD =  "PortName";
  
  /**
   *	PortName字段中文名，用于视图展示
   */
  public final static java.lang.String PORTNAME_LABLE = "出品口名称";
  
  /**
   *	PortName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String portName;
  
  /**
   *	PortStatus数据库列名
   */
  public final static java.lang.String PORTSTATUS_FIELD =  "PortStatus";
  
  /**
   *	PortStatus字段中文名，用于视图展示
   */
  public final static java.lang.String PORTSTATUS_LABLE = "出品口状态";
  
  /**
   *	PortStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long portStatus;
  
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
   * 出品口编码 getter
   */
  public java.lang.String getPortCode(){
    return portCode;
  }
  /**
   * 出品口编码 setter
   * @param PortCode
   */  
  public void setPortCode(java.lang.String portCode){
    this.portCode = portCode;
  }
 
  /**
   * 出品品描述 getter
   */
  public java.lang.String getPortDesc(){
    return portDesc;
  }
  /**
   * 出品品描述 setter
   * @param PortDesc
   */  
  public void setPortDesc(java.lang.String portDesc){
    this.portDesc = portDesc;
  }
 
  /**
   * 出品口编号 getter
   */
  public java.lang.Long getPortID(){
    return portID;
  }
  /**
   * 出品口编号 setter
   * @param PortID
   */  
  public void setPortID(java.lang.Long portID){
    this.portID = portID;
  }
 
  /**
   * 出品口名称 getter
   */
  public java.lang.String getPortName(){
    return portName;
  }
  /**
   * 出品口名称 setter
   * @param PortName
   */  
  public void setPortName(java.lang.String portName){
    this.portName = portName;
  }
 
  /**
   * 出品口状态 getter
   */
  public java.lang.Long getPortStatus(){
    return portStatus;
  }
  /**
   * 出品口状态 setter
   * @param PortStatus
   */  
  public void setPortStatus(java.lang.Long portStatus){
    this.portStatus = portStatus;
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
 
}