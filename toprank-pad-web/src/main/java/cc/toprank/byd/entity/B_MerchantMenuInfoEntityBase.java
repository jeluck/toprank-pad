package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_MerchantMenuInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_MerchantMenuInfoEntityBase  extends Entity{

  /**
   *	AllowDiscount数据库列名
   */
  public final static String ALLOWDISCOUNT_FIELD =  "AllowDiscount";
  
  /**
   *	AllowDiscount字段中文名，用于视图展示
   */
  public final static String ALLOWDISCOUNT_LABLE = "允许折扣";
  
  /**
   *	AllowDiscount对应的java字段名,业务操作使用这个字段。
   */
  private Boolean allowDiscount;
  
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
   *	AreaID数据库列名
   */
  public final static String AREAID_FIELD =  "AreaID";
  
  /**
   *	AreaID字段中文名，用于视图展示
   */
  public final static String AREAID_LABLE = "区域编号";
  
  /**
   *	AreaID对应的java字段名,业务操作使用这个字段。
   */
  private Long areaID;
  
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
   *	CurrencyID数据库列名
   */
  public final static String CURRENCYID_FIELD =  "CurrencyID";
  
  /**
   *	CurrencyID字段中文名，用于视图展示
   */
  public final static String CURRENCYID_LABLE = "货币编号";
  
  /**
   *	CurrencyID对应的java字段名,业务操作使用这个字段。
   */
  private Long currencyID;
  
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
   *	IsCombo数据库列名
   */
  public final static String ISCOMBO_FIELD =  "IsCombo";
  
  /**
   *	IsCombo字段中文名，用于视图展示
   */
  public final static String ISCOMBO_LABLE = "是否套餐";
  
  /**
   *	IsCombo对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isCombo;
  
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
   *	MealsID数据库列名
   */
  public final static String MEALSID_FIELD =  "MealsID";
  
  /**
   *	MealsID字段中文名，用于视图展示
   */
  public final static String MEALSID_LABLE = "餐次编号";
  
  /**
   *	MealsID对应的java字段名,业务操作使用这个字段。
   */
  private Long mealsID;
  
  /**
   *	MemberPrice数据库列名
   */
  public final static String MEMBERPRICE_FIELD =  "MemberPrice";
  
  /**
   *	MemberPrice字段中文名，用于视图展示
   */
  public final static String MEMBERPRICE_LABLE = "会员价";
  
  /**
   *	MemberPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal memberPrice;
  
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
   *	MenuID数据库列名
   */
  public final static String MENUID_FIELD =  "MenuID";
  
  /**
   *	MenuID字段中文名，用于视图展示
   */
  public final static String MENUID_LABLE = "菜单编号";
  
  /**
   *	MenuID对应的java字段名,业务操作使用这个字段。
   */
  private Long menuID;
  
  /**
   *	MenuStatus数据库列名
   */
  public final static String MENUSTATUS_FIELD =  "MenuStatus";
  
  /**
   *	MenuStatus字段中文名，用于视图展示
   */
  public final static String MENUSTATUS_LABLE = "菜单状态";
  
  /**
   *	MenuStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long menuStatus;
  
  /**
   *	NeedWeigh数据库列名
   */
  public final static String NEEDWEIGH_FIELD =  "NeedWeigh";
  
  /**
   *	NeedWeigh字段中文名，用于视图展示
   */
  public final static String NEEDWEIGH_LABLE = "需要称重";
  
  /**
   *	NeedWeigh对应的java字段名,业务操作使用这个字段。
   */
  private Boolean needWeigh;
  
  /**
   *	OriginalPrice数据库列名
   */
  public final static String ORIGINALPRICE_FIELD =  "OriginalPrice";
  
  /**
   *	OriginalPrice字段中文名，用于视图展示
   */
  public final static String ORIGINALPRICE_LABLE = "原价";
  
  /**
   *	OriginalPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal originalPrice;
  
  /**
   *	Price数据库列名
   */
  public final static String PRICE_FIELD =  "Price";
  
  /**
   *	Price字段中文名，用于视图展示
   */
  public final static String PRICE_LABLE = "价格";
  
  /**
   *	Price对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal price;
  
  /**
   *	PriceType数据库列名
   */
  public final static String PRICETYPE_FIELD =  "PriceType";
  
  /**
   *	PriceType字段中文名，用于视图展示
   */
  public final static String PRICETYPE_LABLE = "PriceType";
  
  /**
   *	PriceType对应的java字段名,业务操作使用这个字段。
   */
  private Long priceType;
  
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
   *	ProductCode数据库列名
   */
  public final static String PRODUCTCODE_FIELD =  "ProductCode";
  
  /**
   *	ProductCode字段中文名，用于视图展示
   */
  public final static String PRODUCTCODE_LABLE = "菜品编码";
  
  /**
   *	ProductCode对应的java字段名,业务操作使用这个字段。
   */
  private String productCode;
  
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
  public final static String PRODUCTNAME_LABLE = "菜品名称";
  
  /**
   *	ProductName对应的java字段名,业务操作使用这个字段。
   */
  private String productName;
  
  /**
   *	ProductNum数据库列名
   */
  public final static String PRODUCTNUM_FIELD =  "ProductNum";
  
  /**
   *	ProductNum字段中文名，用于视图展示
   */
  public final static String PRODUCTNUM_LABLE = "商品数量";
  
  /**
   *	ProductNum对应的java字段名,业务操作使用这个字段。
   */
  private Integer productNum;
  
  /**
   *	Quantity数据库列名
   */
  public final static String QUANTITY_FIELD =  "Quantity";
  
  /**
   *	Quantity字段中文名，用于视图展示
   */
  public final static String QUANTITY_LABLE = "数量";
  
  /**
   *	Quantity对应的java字段名,业务操作使用这个字段。
   */
  private Integer quantity;
  
  /**
   *	StockQuantity数据库列名
   */
  public final static String STOCKQUANTITY_FIELD =  "StockQuantity";
  
  /**
   *	StockQuantity字段中文名，用于视图展示
   */
  public final static String STOCKQUANTITY_LABLE = "库存数量";
  
  /**
   *	StockQuantity对应的java字段名,业务操作使用这个字段。
   */
  private Integer stockQuantity;
  
  /**
   *	TypeID数据库列名
   */
  public final static String TYPEID_FIELD =  "TypeID";
  
  /**
   *	TypeID字段中文名，用于视图展示
   */
  public final static String TYPEID_LABLE = "TypeID";
  
  /**
   *	TypeID对应的java字段名,业务操作使用这个字段。
   */
  private Long typeID;
  
  /**
   *	UnitID数据库列名
   */
  public final static String UNITID_FIELD =  "UnitID";
  
  /**
   *	UnitID字段中文名，用于视图展示
   */
  public final static String UNITID_LABLE = "单位编号";
  
  /**
   *	UnitID对应的java字段名,业务操作使用这个字段。
   */
  private Long unitID;
  
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
   * 允许折扣 getter
   */
  public Boolean getAllowDiscount(){
    return allowDiscount;
  }
  /**
   * 允许折扣 setter
   * @param AllowDiscount
   */  
  public void setAllowDiscount(Boolean allowDiscount){
    this.allowDiscount = allowDiscount;
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
   * 区域编号 getter
   */
  public Long getAreaID(){
    return areaID;
  }
  /**
   * 区域编号 setter
   * @param AreaID
   */  
  public void setAreaID(Long areaID){
    this.areaID = areaID;
  }
 
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
   * 货币编号 getter
   */
  public Long getCurrencyID(){
    return currencyID;
  }
  /**
   * 货币编号 setter
   * @param CurrencyID
   */  
  public void setCurrencyID(Long currencyID){
    this.currencyID = currencyID;
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
   * 是否套餐 getter
   */
  public Boolean getIsCombo(){
    return isCombo;
  }
  /**
   * 是否套餐 setter
   * @param IsCombo
   */  
  public void setIsCombo(Boolean isCombo){
    this.isCombo = isCombo;
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
   * 餐次编号 getter
   */
  public Long getMealsID(){
    return mealsID;
  }
  /**
   * 餐次编号 setter
   * @param MealsID
   */  
  public void setMealsID(Long mealsID){
    this.mealsID = mealsID;
  }
 
  /**
   * 会员价 getter
   */
  public java.math.BigDecimal getMemberPrice(){
    return memberPrice;
  }
  /**
   * 会员价 setter
   * @param MemberPrice
   */  
  public void setMemberPrice(java.math.BigDecimal memberPrice){
    this.memberPrice = memberPrice;
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
   * 菜单编号 getter
   */
  public Long getMenuID(){
    return menuID;
  }
  /**
   * 菜单编号 setter
   * @param MenuID
   */  
  public void setMenuID(Long menuID){
    this.menuID = menuID;
  }
 
  /**
   * 菜单状态 getter
   */
  public Long getMenuStatus(){
    return menuStatus;
  }
  /**
   * 菜单状态 setter
   * @param MenuStatus
   */  
  public void setMenuStatus(Long menuStatus){
    this.menuStatus = menuStatus;
  }
 
  /**
   * 需要称重 getter
   */
  public Boolean getNeedWeigh(){
    return needWeigh;
  }
  /**
   * 需要称重 setter
   * @param NeedWeigh
   */  
  public void setNeedWeigh(Boolean needWeigh){
    this.needWeigh = needWeigh;
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
   * PriceType getter
   */
  public Long getPriceType(){
    return priceType;
  }
  /**
   * PriceType setter
   * @param PriceType
   */  
  public void setPriceType(Long priceType){
    this.priceType = priceType;
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
   * 菜品编码 getter
   */
  public String getProductCode(){
    return productCode;
  }
  /**
   * 菜品编码 setter
   * @param ProductCode
   */  
  public void setProductCode(String productCode){
    this.productCode = productCode;
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
   * 菜品名称 getter
   */
  public String getProductName(){
    return productName;
  }
  /**
   * 菜品名称 setter
   * @param ProductName
   */  
  public void setProductName(String productName){
    this.productName = productName;
  }
 
  /**
   * 商品数量 getter
   */
  public Integer getProductNum(){
    return productNum;
  }
  /**
   * 商品数量 setter
   * @param ProductNum
   */  
  public void setProductNum(Integer productNum){
    this.productNum = productNum;
  }
 
  /**
   * 数量 getter
   */
  public Integer getQuantity(){
    return quantity;
  }
  /**
   * 数量 setter
   * @param Quantity
   */  
  public void setQuantity(Integer quantity){
    this.quantity = quantity;
  }
 
  /**
   * 库存数量 getter
   */
  public Integer getStockQuantity(){
    return stockQuantity;
  }
  /**
   * 库存数量 setter
   * @param StockQuantity
   */  
  public void setStockQuantity(Integer stockQuantity){
    this.stockQuantity = stockQuantity;
  }
 
  /**
   * TypeID getter
   */
  public Long getTypeID(){
    return typeID;
  }
  /**
   * TypeID setter
   * @param TypeID
   */  
  public void setTypeID(Long typeID){
    this.typeID = typeID;
  }
 
  /**
   * 单位编号 getter
   */
  public Long getUnitID(){
    return unitID;
  }
  /**
   * 单位编号 setter
   * @param UnitID
   */  
  public void setUnitID(Long unitID){
    this.unitID = unitID;
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