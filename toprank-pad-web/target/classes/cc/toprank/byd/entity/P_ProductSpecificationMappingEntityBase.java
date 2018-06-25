package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_ProductSpecificationMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_ProductSpecificationMappingEntityBase extends Entity {

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
   *	ExchangeRate数据库列名
   */
  public final static java.lang.String EXCHANGERATE_FIELD =  "ExchangeRate";
  
  /**
   *	ExchangeRate字段中文名，用于视图展示
   */
  public final static java.lang.String EXCHANGERATE_LABLE = "兑换比率";
  
  /**
   *	ExchangeRate对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float exchangeRate;
  
  /**
   *	Fare数据库列名
   */
  public final static java.lang.String FARE_FIELD =  "Fare";
  
  /**
   *	Fare字段中文名，用于视图展示
   */
  public final static java.lang.String FARE_LABLE = "加价";
  
  /**
   *	Fare对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal fare;
  
  /**
   *	HighestNum数据库列名
   */
  public final static java.lang.String HIGHESTNUM_FIELD =  "HighestNum";
  
  /**
   *	HighestNum字段中文名，用于视图展示
   */
  public final static java.lang.String HIGHESTNUM_LABLE = "最大数量";
  
  /**
   *	HighestNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer highestNum;
  
  /**
   *	LowestNum数据库列名
   */
  public final static java.lang.String LOWESTNUM_FIELD =  "LowestNum";
  
  /**
   *	LowestNum字段中文名，用于视图展示
   */
  public final static java.lang.String LOWESTNUM_LABLE = "最低数量";
  
  /**
   *	LowestNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer lowestNum;
  
  /**
   *	MappingDesc数据库列名
   */
  public final static java.lang.String MAPPINGDESC_FIELD =  "MappingDesc";
  
  /**
   *	MappingDesc字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGDESC_LABLE = "关联描述";
  
  /**
   *	MappingDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String mappingDesc;
  
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
   *	MappingStatus数据库列名
   */
  public final static java.lang.String MAPPINGSTATUS_FIELD =  "MappingStatus";
  
  /**
   *	MappingStatus字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGSTATUS_LABLE = "关联状态";
  
  /**
   *	MappingStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mappingStatus;
  
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
   *	OptionID数据库列名
   */
  public final static java.lang.String OPTIONID_FIELD =  "OptionID";
  
  /**
   *	OptionID字段中文名，用于视图展示
   */
  public final static java.lang.String OPTIONID_LABLE = "选项编号";
  
  /**
   *	OptionID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long optionID;
  
  /**
   *	OptionName数据库列名
   */
  public final static java.lang.String OPTIONNAME_FIELD =  "OptionName";
  
  /**
   *	OptionName字段中文名，用于视图展示
   */
  public final static java.lang.String OPTIONNAME_LABLE = "选项名称";
  
  /**
   *	OptionName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String optionName;
  
  /**
   *	ProductID数据库列名
   */
  public final static java.lang.String PRODUCTID_FIELD =  "ProductID";
  
  /**
   *	ProductID字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCTID_LABLE = "商品编号";
  
  /**
   *	ProductID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long productID;
  
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
   *	SpecificationName数据库列名
   */
  public final static java.lang.String SPECIFICATIONNAME_FIELD =  "SpecificationName";
  
  /**
   *	SpecificationName字段中文名，用于视图展示
   */
  public final static java.lang.String SPECIFICATIONNAME_LABLE = "规格名称";
  
  /**
   *	SpecificationName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String specificationName;
  
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
   * 兑换比率 getter
   */
  public java.lang.Float getExchangeRate(){
    return exchangeRate;
  }
  /**
   * 兑换比率 setter
   * @param ExchangeRate
   */  
  public void setExchangeRate(java.lang.Float exchangeRate){
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
  public java.lang.Integer getHighestNum(){
    return highestNum;
  }
  /**
   * 最大数量 setter
   * @param HighestNum
   */  
  public void setHighestNum(java.lang.Integer highestNum){
    this.highestNum = highestNum;
  }
 
  /**
   * 最低数量 getter
   */
  public java.lang.Integer getLowestNum(){
    return lowestNum;
  }
  /**
   * 最低数量 setter
   * @param LowestNum
   */  
  public void setLowestNum(java.lang.Integer lowestNum){
    this.lowestNum = lowestNum;
  }
 
  /**
   * 关联描述 getter
   */
  public java.lang.String getMappingDesc(){
    return mappingDesc;
  }
  /**
   * 关联描述 setter
   * @param MappingDesc
   */  
  public void setMappingDesc(java.lang.String mappingDesc){
    this.mappingDesc = mappingDesc;
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
   * 关联状态 getter
   */
  public java.lang.Long getMappingStatus(){
    return mappingStatus;
  }
  /**
   * 关联状态 setter
   * @param MappingStatus
   */  
  public void setMappingStatus(java.lang.Long mappingStatus){
    this.mappingStatus = mappingStatus;
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
   * 选项编号 getter
   */
  public java.lang.Long getOptionID(){
    return optionID;
  }
  /**
   * 选项编号 setter
   * @param OptionID
   */  
  public void setOptionID(java.lang.Long optionID){
    this.optionID = optionID;
  }
 
  /**
   * 选项名称 getter
   */
  public java.lang.String getOptionName(){
    return optionName;
  }
  /**
   * 选项名称 setter
   * @param OptionName
   */  
  public void setOptionName(java.lang.String optionName){
    this.optionName = optionName;
  }
 
  /**
   * 商品编号 getter
   */
  public java.lang.Long getProductID(){
    return productID;
  }
  /**
   * 商品编号 setter
   * @param ProductID
   */  
  public void setProductID(java.lang.Long productID){
    this.productID = productID;
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
   * 规格名称 getter
   */
  public java.lang.String getSpecificationName(){
    return specificationName;
  }
  /**
   * 规格名称 setter
   * @param SpecificationName
   */  
  public void setSpecificationName(java.lang.String specificationName){
    this.specificationName = specificationName;
  }
 
}