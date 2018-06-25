package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_ComboSettingInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_ComboSettingInfoEntityBase extends Entity {

  /**
   *	AliasName数据库列名
   */
  public final static java.lang.String ALIASNAME_FIELD =  "AliasName";
  
  /**
   *	AliasName字段中文名，用于视图展示
   */
  public final static java.lang.String ALIASNAME_LABLE = "AliasName";
  
  /**
   *	AliasName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String aliasName;
  
  /**
   *	BarCode数据库列名
   */
  public final static java.lang.String BARCODE_FIELD =  "BarCode";
  
  /**
   *	BarCode字段中文名，用于视图展示
   */
  public final static java.lang.String BARCODE_LABLE = "商品条码";
  
  /**
   *	BarCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String barCode;
  
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
   *	FirstLetter数据库列名
   */
  public final static java.lang.String FIRSTLETTER_FIELD =  "FirstLetter";
  
  /**
   *	FirstLetter字段中文名，用于视图展示
   */
  public final static java.lang.String FIRSTLETTER_LABLE = "首拼";
  
  /**
   *	FirstLetter对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String firstLetter;
  
  /**
   *	FloatQuantity数据库列名
   */
  public final static java.lang.String FLOATQUANTITY_FIELD =  "FloatQuantity";
  
  /**
   *	FloatQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String FLOATQUANTITY_LABLE = "小数数量";
  
  /**
   *	FloatQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float floatQuantity;
  
  /**
   *	GroupID数据库列名
   */
  public final static java.lang.String GROUPID_FIELD =  "GroupID";
  
  /**
   *	GroupID字段中文名，用于视图展示
   */
  public final static java.lang.String GROUPID_LABLE = "组编号";
  
  /**
   *	GroupID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long groupID;
  
  /**
   *	Gtin数据库列名
   */
  public final static java.lang.String GTIN_FIELD =  "Gtin";
  
  /**
   *	Gtin字段中文名，用于视图展示
   */
  public final static java.lang.String GTIN_LABLE = "商品编码";
  
  /**
   *	Gtin对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String gtin;
  
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
   *	OriginalPrice数据库列名
   */
  public final static java.lang.String ORIGINALPRICE_FIELD =  "OriginalPrice";
  
  /**
   *	OriginalPrice字段中文名，用于视图展示
   */
  public final static java.lang.String ORIGINALPRICE_LABLE = "原价";
  
  /**
   *	OriginalPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal originalPrice;
  
  /**
   *	Price数据库列名
   */
  public final static java.lang.String PRICE_FIELD =  "Price";
  
  /**
   *	Price字段中文名，用于视图展示
   */
  public final static java.lang.String PRICE_LABLE = "价格";
  
  /**
   *	Price对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal price;
  
  /**
   *	ProduceMinute数据库列名
   */
  public final static java.lang.String PRODUCEMINUTE_FIELD =  "ProduceMinute";
  
  /**
   *	ProduceMinute字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCEMINUTE_LABLE = "制作时间";
  
  /**
   *	ProduceMinute对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer produceMinute;
  
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
   *	ProductUnit数据库列名
   */
  public final static java.lang.String PRODUCTUNIT_FIELD =  "ProductUnit";
  
  /**
   *	ProductUnit字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCTUNIT_LABLE = "单位";
  
  /**
   *	ProductUnit对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long productUnit;
  
  /**
   *	Quantity数据库列名
   */
  public final static java.lang.String QUANTITY_FIELD =  "Quantity";
  
  /**
   *	Quantity字段中文名，用于视图展示
   */
  public final static java.lang.String QUANTITY_LABLE = "数量";
  
  /**
   *	Quantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer quantity;
  
  /**
   *	SettingID数据库列名
   */
  public final static java.lang.String SETTINGID_FIELD =  "SettingID";
  
  /**
   *	SettingID字段中文名，用于视图展示
   */
  public final static java.lang.String SETTINGID_LABLE = "配置编号";
  
  /**
   *	SettingID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long settingID;
  
  /**
   *	ShortName数据库列名
   */
  public final static java.lang.String SHORTNAME_FIELD =  "ShortName";
  
  /**
   *	ShortName字段中文名，用于视图展示
   */
  public final static java.lang.String SHORTNAME_LABLE = "变体简称";
  
  /**
   *	ShortName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String shortName;
  
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
   *	VariantDesc数据库列名
   */
  public final static java.lang.String VARIANTDESC_FIELD =  "VariantDesc";
  
  /**
   *	VariantDesc字段中文名，用于视图展示
   */
  public final static java.lang.String VARIANTDESC_LABLE = "变体描述";
  
  /**
   *	VariantDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String variantDesc;
  
  /**
   *	VariantID数据库列名
   */
  public final static java.lang.String VARIANTID_FIELD =  "VariantID";
  
  /**
   *	VariantID字段中文名，用于视图展示
   */
  public final static java.lang.String VARIANTID_LABLE = "变体编号";
  
  /**
   *	VariantID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long variantID;
  
  /**
   *	VariantName数据库列名
   */
  public final static java.lang.String VARIANTNAME_FIELD =  "VariantName";
  
  /**
   *	VariantName字段中文名，用于视图展示
   */
  public final static java.lang.String VARIANTNAME_LABLE = "变体名称";
  
  /**
   *	VariantName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String variantName;
  
  /**
   *	VariantStatus数据库列名
   */
  public final static java.lang.String VARIANTSTATUS_FIELD =  "VariantStatus";
  
  /**
   *	VariantStatus字段中文名，用于视图展示
   */
  public final static java.lang.String VARIANTSTATUS_LABLE = "变体状态";
  
  /**
   *	VariantStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long variantStatus;
  
  /**
   * AliasName getter
   */
  public java.lang.String getAliasName(){
    return aliasName;
  }
  /**
   * AliasName setter
   * @param AliasName
   */  
  public void setAliasName(java.lang.String aliasName){
    this.aliasName = aliasName;
  }
 
  /**
   * 商品条码 getter
   */
  public java.lang.String getBarCode(){
    return barCode;
  }
  /**
   * 商品条码 setter
   * @param BarCode
   */  
  public void setBarCode(java.lang.String barCode){
    this.barCode = barCode;
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
   * 首拼 getter
   */
  public java.lang.String getFirstLetter(){
    return firstLetter;
  }
  /**
   * 首拼 setter
   * @param FirstLetter
   */  
  public void setFirstLetter(java.lang.String firstLetter){
    this.firstLetter = firstLetter;
  }
 
  /**
   * 小数数量 getter
   */
  public java.lang.Float getFloatQuantity(){
    return floatQuantity;
  }
  /**
   * 小数数量 setter
   * @param FloatQuantity
   */  
  public void setFloatQuantity(java.lang.Float floatQuantity){
    this.floatQuantity = floatQuantity;
  }
 
  /**
   * 组编号 getter
   */
  public java.lang.Long getGroupID(){
    return groupID;
  }
  /**
   * 组编号 setter
   * @param GroupID
   */  
  public void setGroupID(java.lang.Long groupID){
    this.groupID = groupID;
  }
 
  /**
   * 商品编码 getter
   */
  public java.lang.String getGtin(){
    return gtin;
  }
  /**
   * 商品编码 setter
   * @param Gtin
   */  
  public void setGtin(java.lang.String gtin){
    this.gtin = gtin;
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
   * 原价 getter
   */
  public java.math.BigDecimal getOriginalPrice(){
    return originalPrice;
  }
  /**
   * 原价 setter
   * @param OriginalPrice
   */  
  public void setOriginalPrice(java.math.BigDecimal originalPrice){
    this.originalPrice = originalPrice;
  }
 
  /**
   * 价格 getter
   */
  public java.math.BigDecimal getPrice(){
    return price;
  }
  /**
   * 价格 setter
   * @param Price
   */  
  public void setPrice(java.math.BigDecimal price){
    this.price = price;
  }
 
  /**
   * 制作时间 getter
   */
  public java.lang.Integer getProduceMinute(){
    return produceMinute;
  }
  /**
   * 制作时间 setter
   * @param ProduceMinute
   */  
  public void setProduceMinute(java.lang.Integer produceMinute){
    this.produceMinute = produceMinute;
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
   * 单位 getter
   */
  public java.lang.Long getProductUnit(){
    return productUnit;
  }
  /**
   * 单位 setter
   * @param ProductUnit
   */  
  public void setProductUnit(java.lang.Long productUnit){
    this.productUnit = productUnit;
  }
 
  /**
   * 数量 getter
   */
  public java.lang.Integer getQuantity(){
    return quantity;
  }
  /**
   * 数量 setter
   * @param Quantity
   */  
  public void setQuantity(java.lang.Integer quantity){
    this.quantity = quantity;
  }
 
  /**
   * 配置编号 getter
   */
  public java.lang.Long getSettingID(){
    return settingID;
  }
  /**
   * 配置编号 setter
   * @param SettingID
   */  
  public void setSettingID(java.lang.Long settingID){
    this.settingID = settingID;
  }
 
  /**
   * 变体简称 getter
   */
  public java.lang.String getShortName(){
    return shortName;
  }
  /**
   * 变体简称 setter
   * @param ShortName
   */  
  public void setShortName(java.lang.String shortName){
    this.shortName = shortName;
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
   * 变体描述 getter
   */
  public java.lang.String getVariantDesc(){
    return variantDesc;
  }
  /**
   * 变体描述 setter
   * @param VariantDesc
   */  
  public void setVariantDesc(java.lang.String variantDesc){
    this.variantDesc = variantDesc;
  }
 
  /**
   * 变体编号 getter
   */
  public java.lang.Long getVariantID(){
    return variantID;
  }
  /**
   * 变体编号 setter
   * @param VariantID
   */  
  public void setVariantID(java.lang.Long variantID){
    this.variantID = variantID;
  }
 
  /**
   * 变体名称 getter
   */
  public java.lang.String getVariantName(){
    return variantName;
  }
  /**
   * 变体名称 setter
   * @param VariantName
   */  
  public void setVariantName(java.lang.String variantName){
    this.variantName = variantName;
  }
 
  /**
   * 变体状态 getter
   */
  public java.lang.Long getVariantStatus(){
    return variantStatus;
  }
  /**
   * 变体状态 setter
   * @param VariantStatus
   */  
  public void setVariantStatus(java.lang.Long variantStatus){
    this.variantStatus = variantStatus;
  }
 
}