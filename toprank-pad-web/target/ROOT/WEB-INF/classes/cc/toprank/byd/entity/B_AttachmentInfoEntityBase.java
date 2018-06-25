package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_AttachmentInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_AttachmentInfoEntityBase extends Entity {

  /**
   *	AttachmentCode数据库列名
   */
  public final static java.lang.String ATTACHMENTCODE_FIELD =  "AttachmentCode";
  
  /**
   *	AttachmentCode字段中文名，用于视图展示
   */
  public final static java.lang.String ATTACHMENTCODE_LABLE = "附件编码";
  
  /**
   *	AttachmentCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String attachmentCode;
  
  /**
   *	AttachmentDesc数据库列名
   */
  public final static java.lang.String ATTACHMENTDESC_FIELD =  "AttachmentDesc";
  
  /**
   *	AttachmentDesc字段中文名，用于视图展示
   */
  public final static java.lang.String ATTACHMENTDESC_LABLE = "附件描述";
  
  /**
   *	AttachmentDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String attachmentDesc;
  
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
   *	AttachmentName数据库列名
   */
  public final static java.lang.String ATTACHMENTNAME_FIELD =  "AttachmentName";
  
  /**
   *	AttachmentName字段中文名，用于视图展示
   */
  public final static java.lang.String ATTACHMENTNAME_LABLE = "附件名称";
  
  /**
   *	AttachmentName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String attachmentName;
  
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
   *	FileCategoryID数据库列名
   */
  public final static java.lang.String FILECATEGORYID_FIELD =  "FileCategoryID";
  
  /**
   *	FileCategoryID字段中文名，用于视图展示
   */
  public final static java.lang.String FILECATEGORYID_LABLE = "文件类型";
  
  /**
   *	FileCategoryID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long fileCategoryID;
  
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
   *	IsText数据库列名
   */
  public final static java.lang.String ISTEXT_FIELD =  "IsText";
  
  /**
   *	IsText字段中文名，用于视图展示
   */
  public final static java.lang.String ISTEXT_LABLE = "是否文本";
  
  /**
   *	IsText对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isText;
  
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
   *	TextDetail数据库列名
   */
  public final static java.lang.String TEXTDETAIL_FIELD =  "TextDetail";
  
  /**
   *	TextDetail字段中文名，用于视图展示
   */
  public final static java.lang.String TEXTDETAIL_LABLE = "文本内容";
  
  /**
   *	TextDetail对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String textDetail;
  
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
   * 附件编码 getter
   */
  public java.lang.String getAttachmentCode(){
    return attachmentCode;
  }
  /**
   * 附件编码 setter
   * @param AttachmentCode
   */  
  public void setAttachmentCode(java.lang.String attachmentCode){
    this.attachmentCode = attachmentCode;
  }
 
  /**
   * 附件描述 getter
   */
  public java.lang.String getAttachmentDesc(){
    return attachmentDesc;
  }
  /**
   * 附件描述 setter
   * @param AttachmentDesc
   */  
  public void setAttachmentDesc(java.lang.String attachmentDesc){
    this.attachmentDesc = attachmentDesc;
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
   * 附件名称 getter
   */
  public java.lang.String getAttachmentName(){
    return attachmentName;
  }
  /**
   * 附件名称 setter
   * @param AttachmentName
   */  
  public void setAttachmentName(java.lang.String attachmentName){
    this.attachmentName = attachmentName;
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
   * 文件类型 getter
   */
  public java.lang.Long getFileCategoryID(){
    return fileCategoryID;
  }
  /**
   * 文件类型 setter
   * @param FileCategoryID
   */  
  public void setFileCategoryID(java.lang.Long fileCategoryID){
    this.fileCategoryID = fileCategoryID;
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
   * 是否文本 getter
   */
  public java.lang.Boolean getIsText(){
    return isText;
  }
  /**
   * 是否文本 setter
   * @param IsText
   */  
  public void setIsText(java.lang.Boolean isText){
    this.isText = isText;
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
   * 文本内容 getter
   */
  public java.lang.String getTextDetail(){
    return textDetail;
  }
  /**
   * 文本内容 setter
   * @param TextDetail
   */  
  public void setTextDetail(java.lang.String textDetail){
    this.textDetail = textDetail;
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