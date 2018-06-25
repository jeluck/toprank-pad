package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_AttachmentMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_AttachmentMappingEntityBase extends Entity {

  /**
   *	AttachmentCode数据库列名
   */
  public final static java.lang.String ATTACHMENTCODE_FIELD =  "AttachmentCode";
  
  /**
   *	AttachmentCode字段中文名，用于视图展示
   */
  public final static java.lang.String ATTACHMENTCODE_LABLE = "编码";
  
  /**
   *	AttachmentCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String attachmentCode;
  
  /**
   *	AttachmentID数据库列名
   */
  public final static java.lang.String ATTACHMENTID_FIELD =  "AttachmentID";
  
  /**
   *	AttachmentID字段中文名，用于视图展示
   */
  public final static java.lang.String ATTACHMENTID_LABLE = "附件编号";
  
  /**
   *	AttachmentID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long attachmentID;
  
  /**
   *	AttachmentType数据库列名
   */
  public final static java.lang.String ATTACHMENTTYPE_FIELD =  "AttachmentType";
  
  /**
   *	AttachmentType字段中文名，用于视图展示
   */
  public final static java.lang.String ATTACHMENTTYPE_LABLE = "附件类别";
  
  /**
   *	AttachmentType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer attachmentType;
  
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
  public final static java.lang.String DURATION_LABLE = "时长";
  
  /**
   *	Duration对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer duration;
  
  /**
   *	ExtName数据库列名
   */
  public final static java.lang.String EXTNAME_FIELD =  "ExtName";
  
  /**
   *	ExtName字段中文名，用于视图展示
   */
  public final static java.lang.String EXTNAME_LABLE = "扩展名";
  
  /**
   *	ExtName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String extName;
  
  /**
   *	FileName数据库列名
   */
  public final static java.lang.String FILENAME_FIELD =  "FileName";
  
  /**
   *	FileName字段中文名，用于视图展示
   */
  public final static java.lang.String FILENAME_LABLE = "文件名";
  
  /**
   *	FileName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String fileName;
  
  /**
   *	FilePath数据库列名
   */
  public final static java.lang.String FILEPATH_FIELD =  "FilePath";
  
  /**
   *	FilePath字段中文名，用于视图展示
   */
  public final static java.lang.String FILEPATH_LABLE = "相对路径";
  
  /**
   *	FilePath对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String filePath;
  
  /**
   *	FileSize数据库列名
   */
  public final static java.lang.String FILESIZE_FIELD =  "FileSize";
  
  /**
   *	FileSize字段中文名，用于视图展示
   */
  public final static java.lang.String FILESIZE_LABLE = "文件大小";
  
  /**
   *	FileSize对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer fileSize;
  
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
   *	MappingID数据库列名
   */
  public final static java.lang.String MAPPINGID_FIELD =  "MappingID";
  
  /**
   *	MappingID字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGID_LABLE = "关联编号";
  
  /**
   *	MappingID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mappingID;
  
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
   *	TargetID数据库列名
   */
  public final static java.lang.String TARGETID_FIELD =  "TargetID";
  
  /**
   *	TargetID字段中文名，用于视图展示
   */
  public final static java.lang.String TARGETID_LABLE = "目标编号";
  
  /**
   *	TargetID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long targetID;
  
  /**
   *	TargetType数据库列名
   */
  public final static java.lang.String TARGETTYPE_FIELD =  "TargetType";
  
  /**
   *	TargetType字段中文名，用于视图展示
   */
  public final static java.lang.String TARGETTYPE_LABLE = "目标类型";
  
  /**
   *	TargetType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long targetType;
  
  /**
   *	UISize数据库列名
   */
  public final static java.lang.String UISIZE_FIELD =  "UISize";
  
  /**
   *	UISize字段中文名，用于视图展示
   */
  public final static java.lang.String UISIZE_LABLE = "界面尺寸";
  
  /**
   *	UISize对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String uISize;
  
  /**
   * 编码 getter
   */
  public java.lang.String getAttachmentCode(){
    return attachmentCode;
  }
  /**
   * 编码 setter
   * @param AttachmentCode
   */  
  public void setAttachmentCode(java.lang.String attachmentCode){
    this.attachmentCode = attachmentCode;
  }
 
  /**
   * 附件编号 getter
   */
  public java.lang.Long getAttachmentID(){
    return attachmentID;
  }
  /**
   * 附件编号 setter
   * @param AttachmentID
   */  
  public void setAttachmentID(java.lang.Long attachmentID){
    this.attachmentID = attachmentID;
  }
 
  /**
   * 附件类别 getter
   */
  public java.lang.Integer getAttachmentType(){
    return attachmentType;
  }
  /**
   * 附件类别 setter
   * @param AttachmentType
   */  
  public void setAttachmentType(java.lang.Integer attachmentType){
    this.attachmentType = attachmentType;
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
   * 时长 getter
   */
  public java.lang.Integer getDuration(){
    return duration;
  }
  /**
   * 时长 setter
   * @param Duration
   */  
  public void setDuration(java.lang.Integer duration){
    this.duration = duration;
  }
 
  /**
   * 扩展名 getter
   */
  public java.lang.String getExtName(){
    return extName;
  }
  /**
   * 扩展名 setter
   * @param ExtName
   */  
  public void setExtName(java.lang.String extName){
    this.extName = extName;
  }
 
  /**
   * 文件名 getter
   */
  public java.lang.String getFileName(){
    return fileName;
  }
  /**
   * 文件名 setter
   * @param FileName
   */  
  public void setFileName(java.lang.String fileName){
    this.fileName = fileName;
  }
 
  /**
   * 相对路径 getter
   */
  public java.lang.String getFilePath(){
    return filePath;
  }
  /**
   * 相对路径 setter
   * @param FilePath
   */  
  public void setFilePath(java.lang.String filePath){
    this.filePath = filePath;
  }
 
  /**
   * 文件大小 getter
   */
  public java.lang.Integer getFileSize(){
    return fileSize;
  }
  /**
   * 文件大小 setter
   * @param FileSize
   */  
  public void setFileSize(java.lang.Integer fileSize){
    this.fileSize = fileSize;
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
   * 关联编号 getter
   */
  public java.lang.Long getMappingID(){
    return mappingID;
  }
  /**
   * 关联编号 setter
   * @param MappingID
   */  
  public void setMappingID(java.lang.Long mappingID){
    this.mappingID = mappingID;
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
   * 目标编号 getter
   */
  public java.lang.Long getTargetID(){
    return targetID;
  }
  /**
   * 目标编号 setter
   * @param TargetID
   */  
  public void setTargetID(java.lang.Long targetID){
    this.targetID = targetID;
  }
 
  /**
   * 目标类型 getter
   */
  public java.lang.Long getTargetType(){
    return targetType;
  }
  /**
   * 目标类型 setter
   * @param TargetType
   */  
  public void setTargetType(java.lang.Long targetType){
    this.targetType = targetType;
  }
 
  /**
   * 界面尺寸 getter
   */
  public java.lang.String getUISize(){
    return uISize;
  }
  /**
   * 界面尺寸 setter
   * @param UISize
   */  
  public void setUISize(java.lang.String uISize){
    this.uISize = uISize;
  }
 
}