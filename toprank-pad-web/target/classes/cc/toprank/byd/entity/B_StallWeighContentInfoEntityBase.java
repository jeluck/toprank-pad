package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_StallWeighContentInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_StallWeighContentInfoEntityBase extends Entity {

  /**
   *	ContentID数据库列名
   */
  public final static String CONTENTID_FIELD =  "ContentID";
  
  /**
   *	ContentID字段中文名，用于视图展示
   */
  public final static String CONTENTID_LABLE = "内容编号";
  
  /**
   *	ContentID对应的java字段名,业务操作使用这个字段。
   */
  private Long contentID;
  
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
   *	IsFixed数据库列名
   */
  public final static String ISFIXED_FIELD =  "IsFixed";
  
  /**
   *	IsFixed字段中文名，用于视图展示
   */
  public final static String ISFIXED_LABLE = "固定显示";
  
  /**
   *	IsFixed对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isFixed;
  
  /**
   *	IsShow数据库列名
   */
  public final static String ISSHOW_FIELD =  "IsShow";
  
  /**
   *	IsShow字段中文名，用于视图展示
   */
  public final static String ISSHOW_LABLE = "是否显示";
  
  /**
   *	IsShow对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isShow;
  
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
   *	SortNo数据库列名
   */
  public final static String SORTNO_FIELD =  "SortNo";
  
  /**
   *	SortNo字段中文名，用于视图展示
   */
  public final static String SORTNO_LABLE = "序号";
  
  /**
   *	SortNo对应的java字段名,业务操作使用这个字段。
   */
  private Integer sortNo;
  
  /**
   *	StallID数据库列名
   */
  public final static String STALLID_FIELD =  "StallID";
  
  /**
   *	StallID字段中文名，用于视图展示
   */
  public final static String STALLID_LABLE = "档口编号";
  
  /**
   *	StallID对应的java字段名,业务操作使用这个字段。
   */
  private Long stallID;
  
  /**
   *	TitleField数据库列名
   */
  public final static String TITLEFIELD_FIELD =  "TitleField";
  
  /**
   *	TitleField字段中文名，用于视图展示
   */
  public final static String TITLEFIELD_LABLE = "标题字段";
  
  /**
   *	TitleField对应的java字段名,业务操作使用这个字段。
   */
  private String titleField;
  
  /**
   *	TitleName数据库列名
   */
  public final static String TITLENAME_FIELD =  "TitleName";
  
  /**
   *	TitleName字段中文名，用于视图展示
   */
  public final static String TITLENAME_LABLE = "标题名称";
  
  /**
   *	TitleName对应的java字段名,业务操作使用这个字段。
   */
  private String titleName;
  
  /**
   * 内容编号 getter
   */
  public Long getContentID(){
    return contentID;
  }
  /**
   * 内容编号 setter
   * @param ContentID
   */  
  public void setContentID(Long contentID){
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
   * 固定显示 getter
   */
  public Boolean getIsFixed(){
    return isFixed;
  }
  /**
   * 固定显示 setter
   * @param IsFixed
   */  
  public void setIsFixed(Boolean isFixed){
    this.isFixed = isFixed;
  }
 
  /**
   * 是否显示 getter
   */
  public Boolean getIsShow(){
    return isShow;
  }
  /**
   * 是否显示 setter
   * @param IsShow
   */  
  public void setIsShow(Boolean isShow){
    this.isShow = isShow;
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
   * 序号 getter
   */
  public Integer getSortNo(){
    return sortNo;
  }
  /**
   * 序号 setter
   * @param SortNo
   */  
  public void setSortNo(Integer sortNo){
    this.sortNo = sortNo;
  }
 
  /**
   * 档口编号 getter
   */
  public Long getStallID(){
    return stallID;
  }
  /**
   * 档口编号 setter
   * @param StallID
   */  
  public void setStallID(Long stallID){
    this.stallID = stallID;
  }
 
  /**
   * 标题字段 getter
   */
  public String getTitleField(){
    return titleField;
  }
  /**
   * 标题字段 setter
   * @param TitleField
   */  
  public void setTitleField(String titleField){
    this.titleField = titleField;
  }
 
  /**
   * 标题名称 getter
   */
  public String getTitleName(){
    return titleName;
  }
  /**
   * 标题名称 setter
   * @param TitleName
   */  
  public void setTitleName(String titleName){
    this.titleName = titleName;
  }
 
}