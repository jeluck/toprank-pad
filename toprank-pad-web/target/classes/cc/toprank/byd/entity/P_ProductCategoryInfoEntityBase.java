package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_ProductCategoryInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_ProductCategoryInfoEntityBase extends Entity {

  /**
   *	CategoryCode数据库列名
   */
  public final static java.lang.String CATEGORYCODE_FIELD =  "CategoryCode";
  
  /**
   *	CategoryCode字段中文名，用于视图展示
   */
  public final static java.lang.String CATEGORYCODE_LABLE = "类别编码";
  
  /**
   *	CategoryCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String categoryCode;
  
  /**
   *	CategoryDesc数据库列名
   */
  public final static java.lang.String CATEGORYDESC_FIELD =  "CategoryDesc";
  
  /**
   *	CategoryDesc字段中文名，用于视图展示
   */
  public final static java.lang.String CATEGORYDESC_LABLE = "类别描述";
  
  /**
   *	CategoryDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String categoryDesc;
  
  /**
   *	CategoryID数据库列名
   */
  public final static java.lang.String CATEGORYID_FIELD =  "CategoryID";
  
  /**
   *	CategoryID字段中文名，用于视图展示
   */
  public final static java.lang.String CATEGORYID_LABLE = "类别编号";
  
  /**
   *	CategoryID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long categoryID;
  
  /**
   *	CategoryName数据库列名
   */
  public final static java.lang.String CATEGORYNAME_FIELD =  "CategoryName";
  
  /**
   *	CategoryName字段中文名，用于视图展示
   */
  public final static java.lang.String CATEGORYNAME_LABLE = "类别名称";
  
  /**
   *	CategoryName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String categoryName;
  
  /**
   *	CategoryStatus数据库列名
   */
  public final static java.lang.String CATEGORYSTATUS_FIELD =  "CategoryStatus";
  
  /**
   *	CategoryStatus字段中文名，用于视图展示
   */
  public final static java.lang.String CATEGORYSTATUS_LABLE = "类别状态";
  
  /**
   *	CategoryStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long categoryStatus;
  
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
   *	HighestPrice数据库列名
   */
  public final static java.lang.String HIGHESTPRICE_FIELD =  "HighestPrice";
  
  /**
   *	HighestPrice字段中文名，用于视图展示
   */
  public final static java.lang.String HIGHESTPRICE_LABLE = "最高价";
  
  /**
   *	HighestPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal highestPrice;
  
  /**
   *	IsMain数据库列名
   */
  public final static java.lang.String ISMAIN_FIELD =  "IsMain";
  
  /**
   *	IsMain字段中文名，用于视图展示
   */
  public final static java.lang.String ISMAIN_LABLE = "主类别";
  
  /**
   *	IsMain对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isMain;
  
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
   *	LowestPrice数据库列名
   */
  public final static java.lang.String LOWESTPRICE_FIELD =  "LowestPrice";
  
  /**
   *	LowestPrice字段中文名，用于视图展示
   */
  public final static java.lang.String LOWESTPRICE_LABLE = "最低价";
  
  /**
   *	LowestPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal lowestPrice;
  
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
   *	OrgID数据库列名
   */
  public final static java.lang.String ORGID_FIELD =  "OrgID";
  
  /**
   *	OrgID字段中文名，用于视图展示
   */
  public final static java.lang.String ORGID_LABLE = "机构编号";
  
  /**
   *	OrgID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orgID;
  
  /**
   *	ParentID数据库列名
   */
  public final static java.lang.String PARENTID_FIELD =  "ParentID";
  
  /**
   *	ParentID字段中文名，用于视图展示
   */
  public final static java.lang.String PARENTID_LABLE = "上级编号";
  
  /**
   *	ParentID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long parentID;
  
  /**
   *	PictureID数据库列名
   */
  public final static java.lang.String PICTUREID_FIELD =  "PictureID";
  
  /**
   *	PictureID字段中文名，用于视图展示
   */
  public final static java.lang.String PICTUREID_LABLE = "图像编号";
  
  /**
   *	PictureID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long pictureID;
  
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
   *	TreeID数据库列名
   */
  public final static java.lang.String TREEID_FIELD =  "TreeID";
  
  /**
   *	TreeID字段中文名，用于视图展示
   */
  public final static java.lang.String TREEID_LABLE = "树结构编号";
  
  /**
   *	TreeID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String treeID;
  
  /**
   * 类别编码 getter
   */
  public java.lang.String getCategoryCode(){
    return categoryCode;
  }
  /**
   * 类别编码 setter
   * @param CategoryCode
   */  
  public void setCategoryCode(java.lang.String categoryCode){
    this.categoryCode = categoryCode;
  }
 
  /**
   * 类别描述 getter
   */
  public java.lang.String getCategoryDesc(){
    return categoryDesc;
  }
  /**
   * 类别描述 setter
   * @param CategoryDesc
   */  
  public void setCategoryDesc(java.lang.String categoryDesc){
    this.categoryDesc = categoryDesc;
  }
 
  /**
   * 类别编号 getter
   */
  public java.lang.Long getCategoryID(){
    return categoryID;
  }
  /**
   * 类别编号 setter
   * @param CategoryID
   */  
  public void setCategoryID(java.lang.Long categoryID){
    this.categoryID = categoryID;
  }
 
  /**
   * 类别名称 getter
   */
  public java.lang.String getCategoryName(){
    return categoryName;
  }
  /**
   * 类别名称 setter
   * @param CategoryName
   */  
  public void setCategoryName(java.lang.String categoryName){
    this.categoryName = categoryName;
  }
 
  /**
   * 类别状态 getter
   */
  public java.lang.Long getCategoryStatus(){
    return categoryStatus;
  }
  /**
   * 类别状态 setter
   * @param CategoryStatus
   */  
  public void setCategoryStatus(java.lang.Long categoryStatus){
    this.categoryStatus = categoryStatus;
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
   * 最高价 getter
   */
  public java.math.BigDecimal getHighestPrice(){
    return highestPrice;
  }
  /**
   * 最高价 setter
   * @param HighestPrice
   */  
  public void setHighestPrice(java.math.BigDecimal highestPrice){
    this.highestPrice = highestPrice;
  }
 
  /**
   * 主类别 getter
   */
  public java.lang.Boolean getIsMain(){
    return isMain;
  }
  /**
   * 主类别 setter
   * @param IsMain
   */  
  public void setIsMain(java.lang.Boolean isMain){
    this.isMain = isMain;
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
   * 最低价 getter
   */
  public java.math.BigDecimal getLowestPrice(){
    return lowestPrice;
  }
  /**
   * 最低价 setter
   * @param LowestPrice
   */  
  public void setLowestPrice(java.math.BigDecimal lowestPrice){
    this.lowestPrice = lowestPrice;
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
   * 机构编号 getter
   */
  public java.lang.Long getOrgID(){
    return orgID;
  }
  /**
   * 机构编号 setter
   * @param OrgID
   */  
  public void setOrgID(java.lang.Long orgID){
    this.orgID = orgID;
  }
 
  /**
   * 上级编号 getter
   */
  public java.lang.Long getParentID(){
    return parentID;
  }
  /**
   * 上级编号 setter
   * @param ParentID
   */  
  public void setParentID(java.lang.Long parentID){
    this.parentID = parentID;
  }
 
  /**
   * 图像编号 getter
   */
  public java.lang.Long getPictureID(){
    return pictureID;
  }
  /**
   * 图像编号 setter
   * @param PictureID
   */  
  public void setPictureID(java.lang.Long pictureID){
    this.pictureID = pictureID;
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
 
  /**
   * 树结构编号 getter
   */
  public java.lang.String getTreeID(){
    return treeID;
  }
  /**
   * 树结构编号 setter
   * @param TreeID
   */  
  public void setTreeID(java.lang.String treeID){
    this.treeID = treeID;
  }
 
}