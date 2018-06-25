package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_TicketPrintInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_TicketPrintInfoEntityBase  extends Entity{

  /**
   *	ArchiveID数据库列名
   */
  public final static String ARCHIVEID_FIELD =  "ArchiveID";
  
  /**
   *	ArchiveID字段中文名，用于视图展示
   */
  public final static String ARCHIVEID_LABLE = "ArchiveID";
  
  /**
   *	ArchiveID对应的java字段名,业务操作使用这个字段。
   */
  private Long archiveID;
  
  /**
   *	BusinessID数据库列名
   */
  public final static String BUSINESSID_FIELD =  "BusinessID";
  
  /**
   *	BusinessID字段中文名，用于视图展示
   */
  public final static String BUSINESSID_LABLE = "业务编号";
  
  /**
   *	BusinessID对应的java字段名,业务操作使用这个字段。
   */
  private Long businessID;
  
  /**
   *	BusinessType数据库列名
   */
  public final static String BUSINESSTYPE_FIELD =  "BusinessType";
  
  /**
   *	BusinessType字段中文名，用于视图展示
   */
  public final static String BUSINESSTYPE_LABLE = "业务类别";
  
  /**
   *	BusinessType对应的java字段名,业务操作使用这个字段。
   */
  private Long businessType;
  
  /**
   *	ComboDetailID数据库列名
   */
  public final static String COMBODETAILID_FIELD =  "ComboDetailID";
  
  /**
   *	ComboDetailID字段中文名，用于视图展示
   */
  public final static String COMBODETAILID_LABLE = "套餐明细";
  
  /**
   *	ComboDetailID对应的java字段名,业务操作使用这个字段。
   */
  private Long comboDetailID;
  
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
   *	DataType数据库列名
   */
  public final static String DATATYPE_FIELD =  "DataType";
  
  /**
   *	DataType字段中文名，用于视图展示
   */
  public final static String DATATYPE_LABLE = "数据类型";
  
  /**
   *	DataType对应的java字段名,业务操作使用这个字段。
   */
  private Integer dataType;
  
  /**
   *	DetailID数据库列名
   */
  public final static String DETAILID_FIELD =  "DetailID";
  
  /**
   *	DetailID字段中文名，用于视图展示
   */
  public final static String DETAILID_LABLE = "明细编号";
  
  /**
   *	DetailID对应的java字段名,业务操作使用这个字段。
   */
  private Long detailID;
  
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
   *	LongContent数据库列名
   */
  public final static String LONGCONTENT_FIELD =  "LongContent";
  
  /**
   *	LongContent字段中文名，用于视图展示
   */
  public final static String LONGCONTENT_LABLE = "长文本";
  
  /**
   *	LongContent对应的java字段名,业务操作使用这个字段。
   */
  private String longContent;
  
  /**
   *	MappingID数据库列名
   */
  public final static String MAPPINGID_FIELD =  "MappingID";
  
  /**
   *	MappingID字段中文名，用于视图展示
   */
  public final static String MAPPINGID_LABLE = "关联编号";
  
  /**
   *	MappingID对应的java字段名,业务操作使用这个字段。
   */
  private Long mappingID;
  
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
   *	PortID数据库列名
   */
  public final static String PORTID_FIELD =  "PortID";
  
  /**
   *	PortID字段中文名，用于视图展示
   */
  public final static String PORTID_LABLE = "PortID";
  
  /**
   *	PortID对应的java字段名,业务操作使用这个字段。
   */
  private Long portID;
  
  /**
   *	PrintContent数据库列名
   */
  public final static String PRINTCONTENT_FIELD =  "PrintContent";
  
  /**
   *	PrintContent字段中文名，用于视图展示
   */
  public final static String PRINTCONTENT_LABLE = "打印内容";
  
  /**
   *	PrintContent对应的java字段名,业务操作使用这个字段。
   */
  private String printContent;
  
  /**
   *	PrintNumber数据库列名
   */
  public final static String PRINTNUMBER_FIELD =  "PrintNumber";
  
  /**
   *	PrintNumber字段中文名，用于视图展示
   */
  public final static String PRINTNUMBER_LABLE = "打印次数";
  
  /**
   *	PrintNumber对应的java字段名,业务操作使用这个字段。
   */
  private Integer printNumber;
  
  /**
   *	PrintStatus数据库列名
   */
  public final static String PRINTSTATUS_FIELD =  "PrintStatus";
  
  /**
   *	PrintStatus字段中文名，用于视图展示
   */
  public final static String PRINTSTATUS_LABLE = "打印状态";
  
  /**
   *	PrintStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long printStatus;
  
  /**
   *	RecordID数据库列名
   */
  public final static String RECORDID_FIELD =  "RecordID";
  
  /**
   *	RecordID字段中文名，用于视图展示
   */
  public final static String RECORDID_LABLE = "记录编号";
  
  /**
   *	RecordID对应的java字段名,业务操作使用这个字段。
   */
  private Long recordID;
  
  /**
   *	SyncTime数据库列名
   */
  public final static String SYNCTIME_FIELD =  "SyncTime";
  
  /**
   *	SyncTime字段中文名，用于视图展示
   */
  public final static String SYNCTIME_LABLE = "SyncTime";
  
  /**
   *	SyncTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTime;
  
  /**
   *	SyncTimeResult数据库列名
   */
  public final static String SYNCTIMERESULT_FIELD =  "SyncTimeResult";
  
  /**
   *	SyncTimeResult字段中文名，用于视图展示
   */
  public final static String SYNCTIMERESULT_LABLE = "SyncTimeResult";
  
  /**
   *	SyncTimeResult对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTimeResult;
  
  /**
   *	TicketName数据库列名
   */
  public final static String TICKETNAME_FIELD =  "TicketName";
  
  /**
   *	TicketName字段中文名，用于视图展示
   */
  public final static String TICKETNAME_LABLE = "票据名称";
  
  /**
   *	TicketName对应的java字段名,业务操作使用这个字段。
   */
  private String ticketName;
  
  /**
   * ArchiveID getter
   */
  public Long getArchiveID(){
    return archiveID;
  }
  /**
   * ArchiveID setter
   * @param archiveID
   */  
  public void setArchiveID(Long archiveID){
    this.archiveID = archiveID;
  }
 
  /**
   * 业务编号 getter
   */
  public Long getBusinessID(){
    return businessID;
  }
  /**
   * 业务编号 setter
   * @param businessID
   */  
  public void setBusinessID(Long businessID){
    this.businessID = businessID;
  }
 
  /**
   * 业务类别 getter
   */
  public Long getBusinessType(){
    return businessType;
  }
  /**
   * 业务类别 setter
   * @param businessType
   */  
  public void setBusinessType(Long businessType){
    this.businessType = businessType;
  }
 
  /**
   * 套餐明细 getter
   */
  public Long getComboDetailID(){
    return comboDetailID;
  }
  /**
   * 套餐明细 setter
   * @param comboDetailID
   */  
  public void setComboDetailID(Long comboDetailID){
    this.comboDetailID = comboDetailID;
  }
 
  /**
   * 创建时间 getter
   */
  public java.time.LocalDateTime getCreateTime(){
    return createTime;
  }
  /**
   * 创建时间 setter
   * @param createTime
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
   * @param creatorID
   */  
  public void setCreatorID(Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * 数据类型 getter
   */
  public Integer getDataType(){
    return dataType;
  }
  /**
   * 数据类型 setter
   * @param dataType
   */  
  public void setDataType(Integer dataType){
    this.dataType = dataType;
  }
 
  /**
   * 明细编号 getter
   */
  public Long getDetailID(){
    return detailID;
  }
  /**
   * 明细编号 setter
   * @param detailID
   */  
  public void setDetailID(Long detailID){
    this.detailID = detailID;
  }
 
  /**
   * 是否同步 getter
   */
  public Boolean getIsSync(){
    return isSync;
  }
  /**
   * 是否同步 setter
   * @param isSync
   */  
  public void setIsSync(Boolean isSync){
    this.isSync = isSync;
  }
 
  /**
   * 长文本 getter
   */
  public String getLongContent(){
    return longContent;
  }
  /**
   * 长文本 setter
   * @param longContent
   */  
  public void setLongContent(String longContent){
    this.longContent = longContent;
  }
 
  /**
   * 关联编号 getter
   */
  public Long getMappingID(){
    return mappingID;
  }
  /**
   * 关联编号 setter
   * @param mappingID
   */  
  public void setMappingID(Long mappingID){
    this.mappingID = mappingID;
  }
 
  /**
   * 备注 getter
   */
  public String getMemo(){
    return memo;
  }
  /**
   * 备注 setter
   * @param memo
   */  
  public void setMemo(String memo){
    this.memo = memo;
  }
 
  /**
   * PortID getter
   */
  public Long getPortID(){
    return portID;
  }
  /**
   * PortID setter
   * @param portID
   */  
  public void setPortID(Long portID){
    this.portID = portID;
  }
 
  /**
   * 打印内容 getter
   */
  public String getPrintContent(){
    return printContent;
  }
  /**
   * 打印内容 setter
   * @param printContent
   */  
  public void setPrintContent(String printContent){
    this.printContent = printContent;
  }
 
  /**
   * 打印次数 getter
   */
  public Integer getPrintNumber(){
    return printNumber;
  }
  /**
   * 打印次数 setter
   * @param printNumber
   */  
  public void setPrintNumber(Integer printNumber){
    this.printNumber = printNumber;
  }
 
  /**
   * 打印状态 getter
   */
  public Long getPrintStatus(){
    return printStatus;
  }
  /**
   * 打印状态 setter
   * @param printStatus
   */  
  public void setPrintStatus(Long printStatus){
    this.printStatus = printStatus;
  }
 
  /**
   * 记录编号 getter
   */
  public Long getRecordID(){
    return recordID;
  }
  /**
   * 记录编号 setter
   * @param recordID
   */  
  public void setRecordID(Long recordID){
    this.recordID = recordID;
  }
 
  /**
   * SyncTime getter
   */
  public java.time.LocalDateTime getSyncTime(){
    return syncTime;
  }
  /**
   * SyncTime setter
   * @param syncTime
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
   * @param syncTimeResult
   */  
  public void setSyncTimeResult(java.time.LocalDateTime syncTimeResult){
    this.syncTimeResult = syncTimeResult;
  }
 
  /**
   * 票据名称 getter
   */
  public String getTicketName(){
    return ticketName;
  }
  /**
   * 票据名称 setter
   * @param ticketName
   */  
  public void setTicketName(String ticketName){
    this.ticketName = ticketName;
  }
 
}