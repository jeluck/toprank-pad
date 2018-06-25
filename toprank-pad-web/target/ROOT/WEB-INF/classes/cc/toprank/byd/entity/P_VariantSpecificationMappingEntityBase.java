package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_VariantSpecificationMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_VariantSpecificationMappingEntityBase  extends Entity{

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
   *	ExchangeRate数据库列名
   */
  public final static String EXCHANGERATE_FIELD =  "ExchangeRate";
  
  /**
   *	ExchangeRate字段中文名，用于视图展示
   */
  public final static String EXCHANGERATE_LABLE = "兑换比率";
  
  /**
   *	ExchangeRate对应的java字段名,业务操作使用这个字段。
   */
  private Float exchangeRate;
  
  /**
   *	Fare数据库列名
   */
  public final static String FARE_FIELD =  "Fare";
  
  /**
   *	Fare字段中文名，用于视图展示
   */
  public final static String FARE_LABLE = "加价";
  
  /**
   *	Fare对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal fare;
  
  /**
   *	HighestNum数据库列名
   */
  public final static String HIGHESTNUM_FIELD =  "HighestNum";
  
  /**
   *	HighestNum字段中文名，用于视图展示
   */
  public final static String HIGHESTNUM_LABLE = "最大数量";
  
  /**
   *	HighestNum对应的java字段名,业务操作使用这个字段。
   */
  private Integer highestNum;
  
  /**
   *	LowestNum数据库列名
   */
  public final static String LOWESTNUM_FIELD =  "LowestNum";
  
  /**
   *	LowestNum字段中文名，用于视图展示
   */
  public final static String LOWESTNUM_LABLE = "最低数量";
  
  /**
   *	LowestNum对应的java字段名,业务操作使用这个字段。
   */
  private Integer lowestNum;
  
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
   *	OptionID数据库列名
   */
  public final static String OPTIONID_FIELD =  "OptionID";
  
  /**
   *	OptionID字段中文名，用于视图展示
   */
  public final static String OPTIONID_LABLE = "选项编号";
  
  /**
   *	OptionID对应的java字段名,业务操作使用这个字段。
   */
  private Long optionID;
  
  /**
   *	OptionName数据库列名
   */
  public final static String OPTIONNAME_FIELD =  "OptionName";
  
  /**
   *	OptionName字段中文名，用于视图展示
   */
  public final static String OPTIONNAME_LABLE = "选项名称";
  
  /**
   *	OptionName对应的java字段名,业务操作使用这个字段。
   */
  private String optionName;
  
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
   *	SpecificationName数据库列名
   */
  public final static String SPECIFICATIONNAME_FIELD =  "SpecificationName";
  
  /**
   *	SpecificationName字段中文名，用于视图展示
   */
  public final static String SPECIFICATIONNAME_LABLE = "规格名称";
  
  /**
   *	SpecificationName对应的java字段名,业务操作使用这个字段。
   */
  private String specificationName;
  
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
   * 兑换比率 getter
   */
  public Float getExchangeRate(){
    return exchangeRate;
  }
  /**
   * 兑换比率 setter
   * @param ExchangeRate
   */  
  public void setExchangeRate(Float exchangeRate){
    this.exchangeRate = exchangeRate;
  }
 
  /**
   * 加价 getter
   */
  public java.math.BigDecimal getFare(){
    return fare;
  }
  /**
   * 加价 setter
   * @param Fare
   */  
  public void setFare(java.math.BigDecimal fare){
    this.fare = fare;
  }
 
  /**
   * 最大数量 getter
   */
  public Integer getHighestNum(){
    return highestNum;
  }
  /**
   * 最大数量 setter
   * @param HighestNum
   */  
  public void setHighestNum(Integer highestNum){
    this.highestNum = highestNum;
  }
 
  /**
   * 最低数量 getter
   */
  public Integer getLowestNum(){
    return lowestNum;
  }
  /**
   * 最低数量 setter
   * @param LowestNum
   */  
  public void setLowestNum(Integer lowestNum){
    this.lowestNum = lowestNum;
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
   * 选项编号 getter
   */
  public Long getOptionID(){
    return optionID;
  }
  /**
   * 选项编号 setter
   * @param OptionID
   */  
  public void setOptionID(Long optionID){
    this.optionID = optionID;
  }
 
  /**
   * 选项名称 getter
   */
  public String getOptionName(){
    return optionName;
  }
  /**
   * 选项名称 setter
   * @param OptionName
   */  
  public void setOptionName(String optionName){
    this.optionName = optionName;
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
   * 规格名称 getter
   */
  public String getSpecificationName(){
    return specificationName;
  }
  /**
   * 规格名称 setter
   * @param SpecificationName
   */  
  public void setSpecificationName(String specificationName){
    this.specificationName = specificationName;
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