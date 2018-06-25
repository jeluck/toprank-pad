package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_SpecificationAttributeOptionInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_SpecificationAttributeOptionInfoEntityBase  extends Entity{

  /**
   *	AddedPrice数据库列名
   */
  public final static String ADDEDPRICE_FIELD =  "AddedPrice";
  
  /**
   *	AddedPrice字段中文名，用于视图展示
   */
  public final static String ADDEDPRICE_LABLE = "加价";
  
  /**
   *	AddedPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal addedPrice;
  
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
   *	OptionCode数据库列名
   */
  public final static String OPTIONCODE_FIELD =  "OptionCode";
  
  /**
   *	OptionCode字段中文名，用于视图展示
   */
  public final static String OPTIONCODE_LABLE = "选项编码";
  
  /**
   *	OptionCode对应的java字段名,业务操作使用这个字段。
   */
  private String optionCode;
  
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
   *	OptionStatus数据库列名
   */
  public final static String OPTIONSTATUS_FIELD =  "OptionStatus";
  
  /**
   *	OptionStatus字段中文名，用于视图展示
   */
  public final static String OPTIONSTATUS_LABLE = "选项状态";
  
  /**
   *	OptionStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long optionStatus;
  
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
   *	SpecificationID数据库列名
   */
  public final static String SPECIFICATIONID_FIELD =  "SpecificationID";
  
  /**
   *	SpecificationID字段中文名，用于视图展示
   */
  public final static String SPECIFICATIONID_LABLE = "规格编号";
  
  /**
   *	SpecificationID对应的java字段名,业务操作使用这个字段。
   */
  private Long specificationID;
  
  /**
   * 加价 getter
   */
  public java.math.BigDecimal getAddedPrice(){
    return addedPrice;
  }
  /**
   * 加价 setter
   * @param AddedPrice
   */  
  public void setAddedPrice(java.math.BigDecimal addedPrice){
    this.addedPrice = addedPrice;
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
   * 选项编码 getter
   */
  public String getOptionCode(){
    return optionCode;
  }
  /**
   * 选项编码 setter
   * @param OptionCode
   */  
  public void setOptionCode(String optionCode){
    this.optionCode = optionCode;
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
   * 选项状态 getter
   */
  public Long getOptionStatus(){
    return optionStatus;
  }
  /**
   * 选项状态 setter
   * @param OptionStatus
   */  
  public void setOptionStatus(Long optionStatus){
    this.optionStatus = optionStatus;
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
   * 规格编号 getter
   */
  public Long getSpecificationID(){
    return specificationID;
  }
  /**
   * 规格编号 setter
   * @param SpecificationID
   */  
  public void setSpecificationID(Long specificationID){
    this.specificationID = specificationID;
  }
 
}