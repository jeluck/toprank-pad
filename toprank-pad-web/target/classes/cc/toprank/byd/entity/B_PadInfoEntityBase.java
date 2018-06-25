package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_PadInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_PadInfoEntityBase extends Entity {

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
   *	IMEICode数据库列名
   */
  public final static String IMEICODE_FIELD =  "IMEICode";
  
  /**
   *	IMEICode字段中文名，用于视图展示
   */
  public final static String IMEICODE_LABLE = "串号";
  
  /**
   *	IMEICode对应的java字段名,业务操作使用这个字段。
   */
  private String iMEICode;
  
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
   *	PadCode数据库列名
   */
  public final static String PADCODE_FIELD =  "PadCode";
  
  /**
   *	PadCode字段中文名，用于视图展示
   */
  public final static String PADCODE_LABLE = "水牌编码";
  
  /**
   *	PadCode对应的java字段名,业务操作使用这个字段。
   */
  private String padCode;
  
  /**
   *	PadDesc数据库列名
   */
  public final static String PADDESC_FIELD =  "PadDesc";
  
  /**
   *	PadDesc字段中文名，用于视图展示
   */
  public final static String PADDESC_LABLE = "水牌描述";
  
  /**
   *	PadDesc对应的java字段名,业务操作使用这个字段。
   */
  private String padDesc;
  
  /**
   *	PadID数据库列名
   */
  public final static String PADID_FIELD =  "PadID";
  
  /**
   *	PadID字段中文名，用于视图展示
   */
  public final static String PADID_LABLE = "水牌编号";
  
  /**
   *	PadID对应的java字段名,业务操作使用这个字段。
   */
  private Long padID;
  
  /**
   *	PadIP数据库列名
   */
  public final static String PADIP_FIELD =  "PadIP";
  
  /**
   *	PadIP字段中文名，用于视图展示
   */
  public final static String PADIP_LABLE = "水牌IP";
  
  /**
   *	PadIP对应的java字段名,业务操作使用这个字段。
   */
  private String padIP;
  
  /**
   *	PadName数据库列名
   */
  public final static String PADNAME_FIELD =  "PadName";
  
  /**
   *	PadName字段中文名，用于视图展示
   */
  public final static String PADNAME_LABLE = "水牌名称";
  
  /**
   *	PadName对应的java字段名,业务操作使用这个字段。
   */
  private String padName;
  
  /**
   *	PadStatus数据库列名
   */
  public final static String PADSTATUS_FIELD =  "PadStatus";
  
  /**
   *	PadStatus字段中文名，用于视图展示
   */
  public final static String PADSTATUS_LABLE = "水牌状态";
  
  /**
   *	PadStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long padStatus;
  
  /**
   *	ServerIP数据库列名
   */
  public final static String SERVERIP_FIELD =  "ServerIP";
  
  /**
   *	ServerIP字段中文名，用于视图展示
   */
  public final static String SERVERIP_LABLE = "服务IP";
  
  /**
   *	ServerIP对应的java字段名,业务操作使用这个字段。
   */
  private String serverIP;
  
  /**
   *	ServerPort数据库列名
   */
  public final static String SERVERPORT_FIELD =  "ServerPort";
  
  /**
   *	ServerPort字段中文名，用于视图展示
   */
  public final static String SERVERPORT_LABLE = "服务端口";
  
  /**
   *	ServerPort对应的java字段名,业务操作使用这个字段。
   */
  private Integer serverPort;
  
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
   * 串号 getter
   */
  public String getIMEICode(){
    return iMEICode;
  }
  /**
   * 串号 setter
   * @param IMEICode
   */  
  public void setIMEICode(String iMEICode){
    this.iMEICode = iMEICode;
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
   * 水牌编码 getter
   */
  public String getPadCode(){
    return padCode;
  }
  /**
   * 水牌编码 setter
   * @param PadCode
   */  
  public void setPadCode(String padCode){
    this.padCode = padCode;
  }
 
  /**
   * 水牌描述 getter
   */
  public String getPadDesc(){
    return padDesc;
  }
  /**
   * 水牌描述 setter
   * @param PadDesc
   */  
  public void setPadDesc(String padDesc){
    this.padDesc = padDesc;
  }
 
  /**
   * 水牌编号 getter
   */
  public Long getPadID(){
    return padID;
  }
  /**
   * 水牌编号 setter
   * @param PadID
   */  
  public void setPadID(Long padID){
    this.padID = padID;
  }
 
  /**
   * 水牌IP getter
   */
  public String getPadIP(){
    return padIP;
  }
  /**
   * 水牌IP setter
   * @param PadIP
   */  
  public void setPadIP(String padIP){
    this.padIP = padIP;
  }
 
  /**
   * 水牌名称 getter
   */
  public String getPadName(){
    return padName;
  }
  /**
   * 水牌名称 setter
   * @param PadName
   */  
  public void setPadName(String padName){
    this.padName = padName;
  }
 
  /**
   * 水牌状态 getter
   */
  public Long getPadStatus(){
    return padStatus;
  }
  /**
   * 水牌状态 setter
   * @param PadStatus
   */  
  public void setPadStatus(Long padStatus){
    this.padStatus = padStatus;
  }
 
  /**
   * 服务IP getter
   */
  public String getServerIP(){
    return serverIP;
  }
  /**
   * 服务IP setter
   * @param ServerIP
   */  
  public void setServerIP(String serverIP){
    this.serverIP = serverIP;
  }
 
  /**
   * 服务端口 getter
   */
  public Integer getServerPort(){
    return serverPort;
  }
  /**
   * 服务端口 setter
   * @param ServerPort
   */  
  public void setServerPort(Integer serverPort){
    this.serverPort = serverPort;
  }
 
}