package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_ComboGroupInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_ComboGroupInfoEntityBase  extends Entity{

  /**
   *	AllowFloatQuantity数据库列名
   */
  public final static String ALLOWFLOATQUANTITY_FIELD =  "AllowFloatQuantity";
  
  /**
   *	AllowFloatQuantity字段中文名，用于视图展示
   */
  public final static String ALLOWFLOATQUANTITY_LABLE = "可选小数";
  
  /**
   *	AllowFloatQuantity对应的java字段名,业务操作使用这个字段。
   */
  private Float allowFloatQuantity;
  
  /**
   *	AllowQuantity数据库列名
   */
  public final static String ALLOWQUANTITY_FIELD =  "AllowQuantity";
  
  /**
   *	AllowQuantity字段中文名，用于视图展示
   */
  public final static String ALLOWQUANTITY_LABLE = "可选数量";
  
  /**
   *	AllowQuantity对应的java字段名,业务操作使用这个字段。
   */
  private Integer allowQuantity;
  
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
   *	FirstLetter数据库列名
   */
  public final static String FIRSTLETTER_FIELD =  "FirstLetter";
  
  /**
   *	FirstLetter字段中文名，用于视图展示
   */
  public final static String FIRSTLETTER_LABLE = "首拼";
  
  /**
   *	FirstLetter对应的java字段名,业务操作使用这个字段。
   */
  private String firstLetter;
  
  /**
   *	FloatQuantity数据库列名
   */
  public final static String FLOATQUANTITY_FIELD =  "FloatQuantity";
  
  /**
   *	FloatQuantity字段中文名，用于视图展示
   */
  public final static String FLOATQUANTITY_LABLE = "小数数量";
  
  /**
   *	FloatQuantity对应的java字段名,业务操作使用这个字段。
   */
  private Float floatQuantity;
  
  /**
   *	GroupCode数据库列名
   */
  public final static String GROUPCODE_FIELD =  "GroupCode";
  
  /**
   *	GroupCode字段中文名，用于视图展示
   */
  public final static String GROUPCODE_LABLE = "组编码";
  
  /**
   *	GroupCode对应的java字段名,业务操作使用这个字段。
   */
  private String groupCode;
  
  /**
   *	GroupID数据库列名
   */
  public final static String GROUPID_FIELD =  "GroupID";
  
  /**
   *	GroupID字段中文名，用于视图展示
   */
  public final static String GROUPID_LABLE = "组编号";
  
  /**
   *	GroupID对应的java字段名,业务操作使用这个字段。
   */
  private Long groupID;
  
  /**
   *	GroupName数据库列名
   */
  public final static String GROUPNAME_FIELD =  "GroupName";
  
  /**
   *	GroupName字段中文名，用于视图展示
   */
  public final static String GROUPNAME_LABLE = "组名称";
  
  /**
   *	GroupName对应的java字段名,业务操作使用这个字段。
   */
  private String groupName;
  
  /**
   *	GroupType数据库列名
   */
  public final static String GROUPTYPE_FIELD =  "GroupType";
  
  /**
   *	GroupType字段中文名，用于视图展示
   */
  public final static String GROUPTYPE_LABLE = "分组类型";
  
  /**
   *	GroupType对应的java字段名,业务操作使用这个字段。
   */
  private Long groupType;
  
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
   *	ProductQuantity数据库列名
   */
  public final static String PRODUCTQUANTITY_FIELD =  "ProductQuantity";
  
  /**
   *	ProductQuantity字段中文名，用于视图展示
   */
  public final static String PRODUCTQUANTITY_LABLE = "商品数量";
  
  /**
   *	ProductQuantity对应的java字段名,业务操作使用这个字段。
   */
  private Integer productQuantity;
  
  /**
   *	ShortName数据库列名
   */
  public final static String SHORTNAME_FIELD =  "ShortName";
  
  /**
   *	ShortName字段中文名，用于视图展示
   */
  public final static String SHORTNAME_LABLE = "简称";
  
  /**
   *	ShortName对应的java字段名,业务操作使用这个字段。
   */
  private String shortName;
  
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
   * 可选小数 getter
   */
  public Float getAllowFloatQuantity(){
    return allowFloatQuantity;
  }
  /**
   * 可选小数 setter
   * @param AllowFloatQuantity
   */  
  public void setAllowFloatQuantity(Float allowFloatQuantity){
    this.allowFloatQuantity = allowFloatQuantity;
  }
 
  /**
   * 可选数量 getter
   */
  public Integer getAllowQuantity(){
    return allowQuantity;
  }
  /**
   * 可选数量 setter
   * @param AllowQuantity
   */  
  public void setAllowQuantity(Integer allowQuantity){
    this.allowQuantity = allowQuantity;
  }
 
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
   * 首拼 getter
   */
  public String getFirstLetter(){
    return firstLetter;
  }
  /**
   * 首拼 setter
   * @param FirstLetter
   */  
  public void setFirstLetter(String firstLetter){
    this.firstLetter = firstLetter;
  }
 
  /**
   * 小数数量 getter
   */
  public Float getFloatQuantity(){
    return floatQuantity;
  }
  /**
   * 小数数量 setter
   * @param FloatQuantity
   */  
  public void setFloatQuantity(Float floatQuantity){
    this.floatQuantity = floatQuantity;
  }
 
  /**
   * 组编码 getter
   */
  public String getGroupCode(){
    return groupCode;
  }
  /**
   * 组编码 setter
   * @param GroupCode
   */  
  public void setGroupCode(String groupCode){
    this.groupCode = groupCode;
  }
 
  /**
   * 组编号 getter
   */
  public Long getGroupID(){
    return groupID;
  }
  /**
   * 组编号 setter
   * @param GroupID
   */  
  public void setGroupID(Long groupID){
    this.groupID = groupID;
  }
 
  /**
   * 组名称 getter
   */
  public String getGroupName(){
    return groupName;
  }
  /**
   * 组名称 setter
   * @param GroupName
   */  
  public void setGroupName(String groupName){
    this.groupName = groupName;
  }
 
  /**
   * 分组类型 getter
   */
  public Long getGroupType(){
    return groupType;
  }
  /**
   * 分组类型 setter
   * @param GroupType
   */  
  public void setGroupType(Long groupType){
    this.groupType = groupType;
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
   * 商品数量 getter
   */
  public Integer getProductQuantity(){
    return productQuantity;
  }
  /**
   * 商品数量 setter
   * @param ProductQuantity
   */  
  public void setProductQuantity(Integer productQuantity){
    this.productQuantity = productQuantity;
  }
 
  /**
   * 简称 getter
   */
  public String getShortName(){
    return shortName;
  }
  /**
   * 简称 setter
   * @param ShortName
   */  
  public void setShortName(String shortName){
    this.shortName = shortName;
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
 
}