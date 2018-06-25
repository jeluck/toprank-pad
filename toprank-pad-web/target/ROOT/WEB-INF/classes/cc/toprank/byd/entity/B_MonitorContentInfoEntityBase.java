package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_MonitorContentInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_MonitorContentInfoEntityBase extends Entity {

  /**
   *	ContentID数据库列名
   */
  public final static java.lang.String CONTENTID_FIELD =  "ContentID";
  
  /**
   *	ContentID字段中文名，用于视图展示
   */
  public final static java.lang.String CONTENTID_LABLE = "内容编号";
  
  /**
   *	ContentID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long contentID;
  
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
   *	IsFiexd数据库列名
   */
  public final static java.lang.String ISFIEXD_FIELD =  "IsFiexd";
  
  /**
   *	IsFiexd字段中文名，用于视图展示
   */
  public final static java.lang.String ISFIEXD_LABLE = "固定显示";
  
  /**
   *	IsFiexd对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isFiexd;
  
  /**
   *	IsShow数据库列名
   */
  public final static java.lang.String ISSHOW_FIELD =  "IsShow";
  
  /**
   *	IsShow字段中文名，用于视图展示
   */
  public final static java.lang.String ISSHOW_LABLE = "是否显示";
  
  /**
   *	IsShow对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isShow;
  
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
   *	TitleField数据库列名
   */
  public final static java.lang.String TITLEFIELD_FIELD =  "TitleField";
  
  /**
   *	TitleField字段中文名，用于视图展示
   */
  public final static java.lang.String TITLEFIELD_LABLE = "标题字段";
  
  /**
   *	TitleField对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String titleField;
  
  /**
   *	TitleName数据库列名
   */
  public final static java.lang.String TITLENAME_FIELD =  "TitleName";
  
  /**
   *	TitleName字段中文名，用于视图展示
   */
  public final static java.lang.String TITLENAME_LABLE = "标题名称";
  
  /**
   *	TitleName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String titleName;
  
  /**
   * 内容编号 getter
   */
  public java.lang.Long getContentID(){
    return contentID;
  }
  /**
   * 内容编号 setter
   * @param ContentID
   */  
  public void setContentID(java.lang.Long contentID){
    this.contentID = contentID;
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
   * 固定显示 getter
   */
  public java.lang.Boolean getIsFiexd(){
    return isFiexd;
  }
  /**
   * 固定显示 setter
   * @param IsFiexd
   */  
  public void setIsFiexd(java.lang.Boolean isFiexd){
    this.isFiexd = isFiexd;
  }
 
  /**
   * 是否显示 getter
   */
  public java.lang.Boolean getIsShow(){
    return isShow;
  }
  /**
   * 是否显示 setter
   * @param IsShow
   */  
  public void setIsShow(java.lang.Boolean isShow){
    this.isShow = isShow;
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
   * 标题字段 getter
   */
  public java.lang.String getTitleField(){
    return titleField;
  }
  /**
   * 标题字段 setter
   * @param TitleField
   */  
  public void setTitleField(java.lang.String titleField){
    this.titleField = titleField;
  }
 
  /**
   * 标题名称 getter
   */
  public java.lang.String getTitleName(){
    return titleName;
  }
  /**
   * 标题名称 setter
   * @param TitleName
   */  
  public void setTitleName(java.lang.String titleName){
    this.titleName = titleName;
  }
 
}