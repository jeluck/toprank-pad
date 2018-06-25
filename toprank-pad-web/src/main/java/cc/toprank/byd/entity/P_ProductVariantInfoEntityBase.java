package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_ProductVariantInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_ProductVariantInfoEntityBase extends Entity {

  /**
   *	AdminComment数据库列名
   */
  public final static java.lang.String ADMINCOMMENT_FIELD =  "AdminComment";
  
  /**
   *	AdminComment字段中文名，用于视图展示
   */
  public final static java.lang.String ADMINCOMMENT_LABLE = "推荐信息";
  
  /**
   *	AdminComment对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String adminComment;
  
  /**
   *	AllowBackInStockSubscription数据库列名
   */
  public final static java.lang.String ALLOWBACKINSTOCKSUBSCRIPTION_FIELD =  "AllowBackInStockSubscription";
  
  /**
   *	AllowBackInStockSubscription字段中文名，用于视图展示
   */
  public final static java.lang.String ALLOWBACKINSTOCKSUBSCRIPTION_LABLE = "允许到货通知";
  
  /**
   *	AllowBackInStockSubscription对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean allowBackInStockSubscription;
  
  /**
   *	AttachmentNum数据库列名
   */
  public final static java.lang.String ATTACHMENTNUM_FIELD =  "AttachmentNum";
  
  /**
   *	AttachmentNum字段中文名，用于视图展示
   */
  public final static java.lang.String ATTACHMENTNUM_LABLE = "附件数量";
  
  /**
   *	AttachmentNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer attachmentNum;
  
  /**
   *	AvailableForPreOrder数据库列名
   */
  public final static java.lang.String AVAILABLEFORPREORDER_FIELD =  "AvailableForPreOrder";
  
  /**
   *	AvailableForPreOrder字段中文名，用于视图展示
   */
  public final static java.lang.String AVAILABLEFORPREORDER_LABLE = "允许预订";
  
  /**
   *	AvailableForPreOrder对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean availableForPreOrder;
  
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
   *	CurrencyID数据库列名
   */
  public final static java.lang.String CURRENCYID_FIELD =  "CurrencyID";
  
  /**
   *	CurrencyID字段中文名，用于视图展示
   */
  public final static java.lang.String CURRENCYID_LABLE = "货币编号";
  
  /**
   *	CurrencyID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long currencyID;
  
  /**
   *	DimensionID数据库列名
   */
  public final static java.lang.String DIMENSIONID_FIELD =  "DimensionID";
  
  /**
   *	DimensionID字段中文名，用于视图展示
   */
  public final static java.lang.String DIMENSIONID_LABLE = "长度单位";
  
  /**
   *	DimensionID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long dimensionID;
  
  /**
   *	DisplayStockAvailability数据库列名
   */
  public final static java.lang.String DISPLAYSTOCKAVAILABILITY_FIELD =  "DisplayStockAvailability";
  
  /**
   *	DisplayStockAvailability字段中文名，用于视图展示
   */
  public final static java.lang.String DISPLAYSTOCKAVAILABILITY_LABLE = "是否显示库存";
  
  /**
   *	DisplayStockAvailability对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean displayStockAvailability;
  
  /**
   *	DisplayStockQuantity数据库列名
   */
  public final static java.lang.String DISPLAYSTOCKQUANTITY_FIELD =  "DisplayStockQuantity";
  
  /**
   *	DisplayStockQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String DISPLAYSTOCKQUANTITY_LABLE = "是否显示库存数量";
  
  /**
   *	DisplayStockQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean displayStockQuantity;
  
  /**
   *	EffectiveTime数据库列名
   */
  public final static java.lang.String EFFECTIVETIME_FIELD =  "EffectiveTime";
  
  /**
   *	EffectiveTime字段中文名，用于视图展示
   */
  public final static java.lang.String EFFECTIVETIME_LABLE = "生效时间";
  
  /**
   *	EffectiveTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime effectiveTime;
  
  /**
   *	ExpireTime数据库列名
   */
  public final static java.lang.String EXPIRETIME_FIELD =  "ExpireTime";
  
  /**
   *	ExpireTime字段中文名，用于视图展示
   */
  public final static java.lang.String EXPIRETIME_LABLE = "过期时间";
  
  /**
   *	ExpireTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime expireTime;
  
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
   *	HasTierPrices数据库列名
   */
  public final static java.lang.String HASTIERPRICES_FIELD =  "HasTierPrices";
  
  /**
   *	HasTierPrices字段中文名，用于视图展示
   */
  public final static java.lang.String HASTIERPRICES_LABLE = "是否有阶梯价格";
  
  /**
   *	HasTierPrices对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean hasTierPrices;
  
  /**
   *	Height数据库列名
   */
  public final static java.lang.String HEIGHT_FIELD =  "Height";
  
  /**
   *	Height字段中文名，用于视图展示
   */
  public final static java.lang.String HEIGHT_LABLE = "高度";
  
  /**
   *	Height对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float height;
  
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
   *	Length数据库列名
   */
  public final static java.lang.String LENGTH_FIELD =  "Length";
  
  /**
   *	Length字段中文名，用于视图展示
   */
  public final static java.lang.String LENGTH_LABLE = "长度";
  
  /**
   *	Length对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float length;
  
  /**
   *	MarketPrice数据库列名
   */
  public final static java.lang.String MARKETPRICE_FIELD =  "MarketPrice";
  
  /**
   *	MarketPrice字段中文名，用于视图展示
   */
  public final static java.lang.String MARKETPRICE_LABLE = "市场参考价";
  
  /**
   *	MarketPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal marketPrice;
  
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
   *	OrderMaximumQuantity数据库列名
   */
  public final static java.lang.String ORDERMAXIMUMQUANTITY_FIELD =  "OrderMaximumQuantity";
  
  /**
   *	OrderMaximumQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERMAXIMUMQUANTITY_LABLE = "最大购买数量";
  
  /**
   *	OrderMaximumQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer orderMaximumQuantity;
  
  /**
   *	OrderMinimumQuantity数据库列名
   */
  public final static java.lang.String ORDERMINIMUMQUANTITY_FIELD =  "OrderMinimumQuantity";
  
  /**
   *	OrderMinimumQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERMINIMUMQUANTITY_LABLE = "最小购买数量";
  
  /**
   *	OrderMinimumQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer orderMinimumQuantity;
  
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
   *	StarLevel数据库列名
   */
  public final static java.lang.String STARLEVEL_FIELD =  "StarLevel";
  
  /**
   *	StarLevel字段中文名，用于视图展示
   */
  public final static java.lang.String STARLEVEL_LABLE = "评价星级";
  
  /**
   *	StarLevel对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer starLevel;
  
  /**
   *	StockQuantity数据库列名
   */
  public final static java.lang.String STOCKQUANTITY_FIELD =  "StockQuantity";
  
  /**
   *	StockQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String STOCKQUANTITY_LABLE = "库存数量";
  
  /**
   *	StockQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer stockQuantity;
  
  /**
   *	UnitID数据库列名
   */
  public final static java.lang.String UNITID_FIELD =  "UnitID";
  
  /**
   *	UnitID字段中文名，用于视图展示
   */
  public final static java.lang.String UNITID_LABLE = "单位编号";
  
  /**
   *	UnitID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long unitID;
  
  /**
   *	UpdateTime数据库列名
   */
  public final static java.lang.String UPDATETIME_FIELD =  "UpdateTime";
  
  /**
   *	UpdateTime字段中文名，用于视图展示
   */
  public final static java.lang.String UPDATETIME_LABLE = "更新时间";
  
  /**
   *	UpdateTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime updateTime;
  
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
   *	Weight数据库列名
   */
  public final static java.lang.String WEIGHT_FIELD =  "Weight";
  
  /**
   *	Weight字段中文名，用于视图展示
   */
  public final static java.lang.String WEIGHT_LABLE = "重量";
  
  /**
   *	Weight对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float weight;
  
  /**
   *	WeightID数据库列名
   */
  public final static java.lang.String WEIGHTID_FIELD =  "WeightID";
  
  /**
   *	WeightID字段中文名，用于视图展示
   */
  public final static java.lang.String WEIGHTID_LABLE = "单位编号";
  
  /**
   *	WeightID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long weightID;
  
  /**
   *	Width数据库列名
   */
  public final static java.lang.String WIDTH_FIELD =  "Width";
  
  /**
   *	Width字段中文名，用于视图展示
   */
  public final static java.lang.String WIDTH_LABLE = "宽度";
  
  /**
   *	Width对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float width;
  
  /**
   * 推荐信息 getter
   */
  public java.lang.String getAdminComment(){
    return adminComment;
  }
  /**
   * 推荐信息 setter
   * @param AdminComment
   */  
  public void setAdminComment(java.lang.String adminComment){
    this.adminComment = adminComment;
  }
 
  /**
   * 允许到货通知 getter
   */
  public java.lang.Boolean getAllowBackInStockSubscription(){
    return allowBackInStockSubscription;
  }
  /**
   * 允许到货通知 setter
   * @param AllowBackInStockSubscription
   */  
  public void setAllowBackInStockSubscription(java.lang.Boolean allowBackInStockSubscription){
    this.allowBackInStockSubscription = allowBackInStockSubscription;
  }
 
  /**
   * 附件数量 getter
   */
  public java.lang.Integer getAttachmentNum(){
    return attachmentNum;
  }
  /**
   * 附件数量 setter
   * @param AttachmentNum
   */  
  public void setAttachmentNum(java.lang.Integer attachmentNum){
    this.attachmentNum = attachmentNum;
  }
 
  /**
   * 允许预订 getter
   */
  public java.lang.Boolean getAvailableForPreOrder(){
    return availableForPreOrder;
  }
  /**
   * 允许预订 setter
   * @param AvailableForPreOrder
   */  
  public void setAvailableForPreOrder(java.lang.Boolean availableForPreOrder){
    this.availableForPreOrder = availableForPreOrder;
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
   * 货币编号 getter
   */
  public java.lang.Long getCurrencyID(){
    return currencyID;
  }
  /**
   * 货币编号 setter
   * @param CurrencyID
   */  
  public void setCurrencyID(java.lang.Long currencyID){
    this.currencyID = currencyID;
  }
 
  /**
   * 长度单位 getter
   */
  public java.lang.Long getDimensionID(){
    return dimensionID;
  }
  /**
   * 长度单位 setter
   * @param DimensionID
   */  
  public void setDimensionID(java.lang.Long dimensionID){
    this.dimensionID = dimensionID;
  }
 
  /**
   * 是否显示库存 getter
   */
  public java.lang.Boolean getDisplayStockAvailability(){
    return displayStockAvailability;
  }
  /**
   * 是否显示库存 setter
   * @param DisplayStockAvailability
   */  
  public void setDisplayStockAvailability(java.lang.Boolean displayStockAvailability){
    this.displayStockAvailability = displayStockAvailability;
  }
 
  /**
   * 是否显示库存数量 getter
   */
  public java.lang.Boolean getDisplayStockQuantity(){
    return displayStockQuantity;
  }
  /**
   * 是否显示库存数量 setter
   * @param DisplayStockQuantity
   */  
  public void setDisplayStockQuantity(java.lang.Boolean displayStockQuantity){
    this.displayStockQuantity = displayStockQuantity;
  }
 
  /**
   * 生效时间 getter
   */
  public java.time.LocalDateTime getEffectiveTime(){
    return effectiveTime;
  }
  /**
   * 生效时间 setter
   * @param EffectiveTime
   */  
  public void setEffectiveTime(java.time.LocalDateTime effectiveTime){
    this.effectiveTime = effectiveTime;
  }
 
  /**
   * 过期时间 getter
   */
  public java.time.LocalDateTime getExpireTime(){
    return expireTime;
  }
  /**
   * 过期时间 setter
   * @param ExpireTime
   */  
  public void setExpireTime(java.time.LocalDateTime expireTime){
    this.expireTime = expireTime;
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
   * 是否有阶梯价格 getter
   */
  public java.lang.Boolean getHasTierPrices(){
    return hasTierPrices;
  }
  /**
   * 是否有阶梯价格 setter
   * @param HasTierPrices
   */  
  public void setHasTierPrices(java.lang.Boolean hasTierPrices){
    this.hasTierPrices = hasTierPrices;
  }
 
  /**
   * 高度 getter
   */
  public java.lang.Float getHeight(){
    return height;
  }
  /**
   * 高度 setter
   * @param Height
   */  
  public void setHeight(java.lang.Float height){
    this.height = height;
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
   * 长度 getter
   */
  public java.lang.Float getLength(){
    return length;
  }
  /**
   * 长度 setter
   * @param Length
   */  
  public void setLength(java.lang.Float length){
    this.length = length;
  }
 
  /**
   * 市场参考价 getter
   */
  public java.math.BigDecimal getMarketPrice(){
    return marketPrice;
  }
  /**
   * 市场参考价 setter
   * @param MarketPrice
   */  
  public void setMarketPrice(java.math.BigDecimal marketPrice){
    this.marketPrice = marketPrice;
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
   * 最大购买数量 getter
   */
  public java.lang.Integer getOrderMaximumQuantity(){
    return orderMaximumQuantity;
  }
  /**
   * 最大购买数量 setter
   * @param OrderMaximumQuantity
   */  
  public void setOrderMaximumQuantity(java.lang.Integer orderMaximumQuantity){
    this.orderMaximumQuantity = orderMaximumQuantity;
  }
 
  /**
   * 最小购买数量 getter
   */
  public java.lang.Integer getOrderMinimumQuantity(){
    return orderMinimumQuantity;
  }
  /**
   * 最小购买数量 setter
   * @param OrderMinimumQuantity
   */  
  public void setOrderMinimumQuantity(java.lang.Integer orderMinimumQuantity){
    this.orderMinimumQuantity = orderMinimumQuantity;
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
   * 评价星级 getter
   */
  public java.lang.Integer getStarLevel(){
    return starLevel;
  }
  /**
   * 评价星级 setter
   * @param StarLevel
   */  
  public void setStarLevel(java.lang.Integer starLevel){
    this.starLevel = starLevel;
  }
 
  /**
   * 库存数量 getter
   */
  public java.lang.Integer getStockQuantity(){
    return stockQuantity;
  }
  /**
   * 库存数量 setter
   * @param StockQuantity
   */  
  public void setStockQuantity(java.lang.Integer stockQuantity){
    this.stockQuantity = stockQuantity;
  }
 
  /**
   * 单位编号 getter
   */
  public java.lang.Long getUnitID(){
    return unitID;
  }
  /**
   * 单位编号 setter
   * @param UnitID
   */  
  public void setUnitID(java.lang.Long unitID){
    this.unitID = unitID;
  }
 
  /**
   * 更新时间 getter
   */
  public java.time.LocalDateTime getUpdateTime(){
    return updateTime;
  }
  /**
   * 更新时间 setter
   * @param UpdateTime
   */  
  public void setUpdateTime(java.time.LocalDateTime updateTime){
    this.updateTime = updateTime;
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
 
  /**
   * 重量 getter
   */
  public java.lang.Float getWeight(){
    return weight;
  }
  /**
   * 重量 setter
   * @param Weight
   */  
  public void setWeight(java.lang.Float weight){
    this.weight = weight;
  }
 
  /**
   * 单位编号 getter
   */
  public java.lang.Long getWeightID(){
    return weightID;
  }
  /**
   * 单位编号 setter
   * @param WeightID
   */  
  public void setWeightID(java.lang.Long weightID){
    this.weightID = weightID;
  }
 
  /**
   * 宽度 getter
   */
  public java.lang.Float getWidth(){
    return width;
  }
  /**
   * 宽度 setter
   * @param Width
   */  
  public void setWidth(java.lang.Float width){
    this.width = width;
  }
 
}