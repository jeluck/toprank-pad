package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_ProductDesignerMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_ProductDesignerMappingEntityBase  extends Entity{

  /**
   *	CategoryID数据库列名
   */
  public final static String CATEGORYID_FIELD =  "CategoryID";
  
  /**
   *	CategoryID字段中文名，用于视图展示
   */
  public final static String CATEGORYID_LABLE = "类别编号";
  
  /**
   *	CategoryID对应的java字段名,业务操作使用这个字段。
   */
  private Long categoryID;
  
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
   *	DesignerID数据库列名
   */
  public final static String DESIGNERID_FIELD =  "DesignerID";
  
  /**
   *	DesignerID字段中文名，用于视图展示
   */
  public final static String DESIGNERID_LABLE = "设计师编号";
  
  /**
   *	DesignerID对应的java字段名,业务操作使用这个字段。
   */
  private Long designerID;
  
  /**
   *	Gtin数据库列名
   */
  public final static String GTIN_FIELD =  "Gtin";
  
  /**
   *	Gtin字段中文名，用于视图展示
   */
  public final static String GTIN_LABLE = "商品编码";
  
  /**
   *	Gtin对应的java字段名,业务操作使用这个字段。
   */
  private String gtin;
  
  /**
   *	IsGoodat数据库列名
   */
  public final static String ISGOODAT_FIELD =  "IsGoodat";
  
  /**
   *	IsGoodat字段中文名，用于视图展示
   */
  public final static String ISGOODAT_LABLE = "是否擅长";
  
  /**
   *	IsGoodat对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isGoodat;
  
  /**
   *	MappingDesc数据库列名
   */
  public final static String MAPPINGDESC_FIELD =  "MappingDesc";
  
  /**
   *	MappingDesc字段中文名，用于视图展示
   */
  public final static String MAPPINGDESC_LABLE = "关联描述";
  
  /**
   *	MappingDesc对应的java字段名,业务操作使用这个字段。
   */
  private String mappingDesc;
  
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
   *	MappingStatus数据库列名
   */
  public final static String MAPPINGSTATUS_FIELD =  "MappingStatus";
  
  /**
   *	MappingStatus字段中文名，用于视图展示
   */
  public final static String MAPPINGSTATUS_LABLE = "关联状态";
  
  /**
   *	MappingStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long mappingStatus;
  
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
   *	ProduceCost数据库列名
   */
  public final static String PRODUCECOST_FIELD =  "ProduceCost";
  
  /**
   *	ProduceCost字段中文名，用于视图展示
   */
  public final static String PRODUCECOST_LABLE = "加工费";
  
  /**
   *	ProduceCost对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal produceCost;
  
  /**
   *	ProduceLevel数据库列名
   */
  public final static String PRODUCELEVEL_FIELD =  "ProduceLevel";
  
  /**
   *	ProduceLevel字段中文名，用于视图展示
   */
  public final static String PRODUCELEVEL_LABLE = "制作星级";
  
  /**
   *	ProduceLevel对应的java字段名,业务操作使用这个字段。
   */
  private Long produceLevel;
  
  /**
   *	ProduceMinute数据库列名
   */
  public final static String PRODUCEMINUTE_FIELD =  "ProduceMinute";
  
  /**
   *	ProduceMinute字段中文名，用于视图展示
   */
  public final static String PRODUCEMINUTE_LABLE = "制作时间";
  
  /**
   *	ProduceMinute对应的java字段名,业务操作使用这个字段。
   */
  private Integer produceMinute;
  
  /**
   *	ProductID数据库列名
   */
  public final static String PRODUCTID_FIELD =  "ProductID";
  
  /**
   *	ProductID字段中文名，用于视图展示
   */
  public final static String PRODUCTID_LABLE = "商品编号";
  
  /**
   *	ProductID对应的java字段名,业务操作使用这个字段。
   */
  private Long productID;
  
  /**
   *	ProductName数据库列名
   */
  public final static String PRODUCTNAME_FIELD =  "ProductName";
  
  /**
   *	ProductName字段中文名，用于视图展示
   */
  public final static String PRODUCTNAME_LABLE = "商品名称";
  
  /**
   *	ProductName对应的java字段名,业务操作使用这个字段。
   */
  private String productName;
  
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
   *	VariantID数据库列名
   */
  public final static String VARIANTID_FIELD =  "VariantID";
  
  /**
   *	VariantID字段中文名，用于视图展示
   */
  public final static String VARIANTID_LABLE = "变体编号";
  
  /**
   *	VariantID对应的java字段名,业务操作使用这个字段。
   */
  private Long variantID;
  
  /**
   * 类别编号 getter
   */
  public Long getCategoryID(){
    return categoryID;
  }
  /**
   * 类别编号 setter
   * @param CategoryID
   */  
  public void setCategoryID(Long categoryID){
    this.categoryID = categoryID;
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
   * 设计师编号 getter
   */
  public Long getDesignerID(){
    return designerID;
  }
  /**
   * 设计师编号 setter
   * @param DesignerID
   */  
  public void setDesignerID(Long designerID){
    this.designerID = designerID;
  }
 
  /**
   * 商品编码 getter
   */
  public String getGtin(){
    return gtin;
  }
  /**
   * 商品编码 setter
   * @param Gtin
   */  
  public void setGtin(String gtin){
    this.gtin = gtin;
  }
 
  /**
   * 是否擅长 getter
   */
  public Boolean getIsGoodat(){
    return isGoodat;
  }
  /**
   * 是否擅长 setter
   * @param IsGoodat
   */  
  public void setIsGoodat(Boolean isGoodat){
    this.isGoodat = isGoodat;
  }
 
  /**
   * 关联描述 getter
   */
  public String getMappingDesc(){
    return mappingDesc;
  }
  /**
   * 关联描述 setter
   * @param MappingDesc
   */  
  public void setMappingDesc(String mappingDesc){
    this.mappingDesc = mappingDesc;
  }
 
  /**
   * 关联编号 getter
   */
  public Long getMappingID(){
    return mappingID;
  }
  /**
   * 关联编号 setter
   * @param MappingID
   */  
  public void setMappingID(Long mappingID){
    this.mappingID = mappingID;
  }
 
  /**
   * 关联状态 getter
   */
  public Long getMappingStatus(){
    return mappingStatus;
  }
  /**
   * 关联状态 setter
   * @param MappingStatus
   */  
  public void setMappingStatus(Long mappingStatus){
    this.mappingStatus = mappingStatus;
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
   * 加工费 getter
   */
  public java.math.BigDecimal getProduceCost(){
    return produceCost;
  }
  /**
   * 加工费 setter
   * @param ProduceCost
   */  
  public void setProduceCost(java.math.BigDecimal produceCost){
    this.produceCost = produceCost;
  }
 
  /**
   * 制作星级 getter
   */
  public Long getProduceLevel(){
    return produceLevel;
  }
  /**
   * 制作星级 setter
   * @param ProduceLevel
   */  
  public void setProduceLevel(Long produceLevel){
    this.produceLevel = produceLevel;
  }
 
  /**
   * 制作时间 getter
   */
  public Integer getProduceMinute(){
    return produceMinute;
  }
  /**
   * 制作时间 setter
   * @param ProduceMinute
   */  
  public void setProduceMinute(Integer produceMinute){
    this.produceMinute = produceMinute;
  }
 
  /**
   * 商品编号 getter
   */
  public Long getProductID(){
    return productID;
  }
  /**
   * 商品编号 setter
   * @param ProductID
   */  
  public void setProductID(Long productID){
    this.productID = productID;
  }
 
  /**
   * 商品名称 getter
   */
  public String getProductName(){
    return productName;
  }
  /**
   * 商品名称 setter
   * @param ProductName
   */  
  public void setProductName(String productName){
    this.productName = productName;
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
   * 变体编号 getter
   */
  public Long getVariantID(){
    return variantID;
  }
  /**
   * 变体编号 setter
   * @param VariantID
   */  
  public void setVariantID(Long variantID){
    this.variantID = variantID;
  }
 
}