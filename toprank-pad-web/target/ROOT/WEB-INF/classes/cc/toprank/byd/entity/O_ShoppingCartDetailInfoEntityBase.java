package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_ShoppingCartDetailInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_ShoppingCartDetailInfoEntityBase extends Entity {

  /**
   *	CartID数据库列名
   */
  public final static java.lang.String CARTID_FIELD =  "CartID";
  
  /**
   *	CartID字段中文名，用于视图展示
   */
  public final static java.lang.String CARTID_LABLE = "购物车编号";
  
  /**
   *	CartID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long cartID;
  
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
   *	CreatorType数据库列名
   */
  public final static java.lang.String CREATORTYPE_FIELD =  "CreatorType";
  
  /**
   *	CreatorType字段中文名，用于视图展示
   */
  public final static java.lang.String CREATORTYPE_LABLE = "创建人类别";
  
  /**
   *	CreatorType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long creatorType;
  
  /**
   *	DesignerID数据库列名
   */
  public final static java.lang.String DESIGNERID_FIELD =  "DesignerID";
  
  /**
   *	DesignerID字段中文名，用于视图展示
   */
  public final static java.lang.String DESIGNERID_LABLE = "厨师编号";
  
  /**
   *	DesignerID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long designerID;
  
  /**
   *	DesignerPrice数据库列名
   */
  public final static java.lang.String DESIGNERPRICE_FIELD =  "DesignerPrice";
  
  /**
   *	DesignerPrice字段中文名，用于视图展示
   */
  public final static java.lang.String DESIGNERPRICE_LABLE = "厨师费";
  
  /**
   *	DesignerPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal designerPrice;
  
  /**
   *	DetailDesc数据库列名
   */
  public final static java.lang.String DETAILDESC_FIELD =  "DetailDesc";
  
  /**
   *	DetailDesc字段中文名，用于视图展示
   */
  public final static java.lang.String DETAILDESC_LABLE = "明细描述";
  
  /**
   *	DetailDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String detailDesc;
  
  /**
   *	DetailID数据库列名
   */
  public final static java.lang.String DETAILID_FIELD =  "DetailID";
  
  /**
   *	DetailID字段中文名，用于视图展示
   */
  public final static java.lang.String DETAILID_LABLE = "明细编号";
  
  /**
   *	DetailID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long detailID;
  
  /**
   *	ExpectedWeight数据库列名
   */
  public final static java.lang.String EXPECTEDWEIGHT_FIELD =  "ExpectedWeight";
  
  /**
   *	ExpectedWeight字段中文名，用于视图展示
   */
  public final static java.lang.String EXPECTEDWEIGHT_LABLE = "期望重量";
  
  /**
   *	ExpectedWeight对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float expectedWeight;
  
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
   *	IsCombo数据库列名
   */
  public final static java.lang.String ISCOMBO_FIELD =  "IsCombo";
  
  /**
   *	IsCombo字段中文名，用于视图展示
   */
  public final static java.lang.String ISCOMBO_LABLE = "是否套餐";
  
  /**
   *	IsCombo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isCombo;
  
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
   *	MenuID数据库列名
   */
  public final static java.lang.String MENUID_FIELD =  "MenuID";
  
  /**
   *	MenuID字段中文名，用于视图展示
   */
  public final static java.lang.String MENUID_LABLE = "菜单编号";
  
  /**
   *	MenuID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long menuID;
  
  /**
   *	NeedWeigh数据库列名
   */
  public final static java.lang.String NEEDWEIGH_FIELD =  "NeedWeigh";
  
  /**
   *	NeedWeigh字段中文名，用于视图展示
   */
  public final static java.lang.String NEEDWEIGH_LABLE = "需要称重";
  
  /**
   *	NeedWeigh对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean needWeigh;
  
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
   *	Price数据库列名
   */
  public final static java.lang.String PRICE_FIELD =  "Price";
  
  /**
   *	Price字段中文名，用于视图展示
   */
  public final static java.lang.String PRICE_LABLE = "成交价";
  
  /**
   *	Price对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal price;
  
  /**
   *	ProduceCost数据库列名
   */
  public final static java.lang.String PRODUCECOST_FIELD =  "ProduceCost";
  
  /**
   *	ProduceCost字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCECOST_LABLE = "加工费";
  
  /**
   *	ProduceCost对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal produceCost;
  
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
   *	TableID数据库列名
   */
  public final static java.lang.String TABLEID_FIELD =  "TableID";
  
  /**
   *	TableID字段中文名，用于视图展示
   */
  public final static java.lang.String TABLEID_LABLE = "桌台编号";
  
  /**
   *	TableID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long tableID;
  
  /**
   *	TotalAmount数据库列名
   */
  public final static java.lang.String TOTALAMOUNT_FIELD =  "TotalAmount";
  
  /**
   *	TotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String TOTALAMOUNT_LABLE = "总价";
  
  /**
   *	TotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal totalAmount;
  
  /**
   *	ValueIDs数据库列名
   */
  public final static java.lang.String VALUEIDS_FIELD =  "ValueIDs";
  
  /**
   *	ValueIDs字段中文名，用于视图展示
   */
  public final static java.lang.String VALUEIDS_LABLE = "属性值";
  
  /**
   *	ValueIDs对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String valueIDs;
  
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
   * 购物车编号 getter
   */
  public java.lang.Long getCartID(){
    return cartID;
  }
  /**
   * 购物车编号 setter
   * @param CartID
   */  
  public void setCartID(java.lang.Long cartID){
    this.cartID = cartID;
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
   * 创建人类别 getter
   */
  public java.lang.Long getCreatorType(){
    return creatorType;
  }
  /**
   * 创建人类别 setter
   * @param CreatorType
   */  
  public void setCreatorType(java.lang.Long creatorType){
    this.creatorType = creatorType;
  }
 
  /**
   * 厨师编号 getter
   */
  public java.lang.Long getDesignerID(){
    return designerID;
  }
  /**
   * 厨师编号 setter
   * @param DesignerID
   */  
  public void setDesignerID(java.lang.Long designerID){
    this.designerID = designerID;
  }
 
  /**
   * 厨师费 getter
   */
  public java.math.BigDecimal getDesignerPrice(){
    return designerPrice;
  }
  /**
   * 厨师费 setter
   * @param DesignerPrice
   */  
  public void setDesignerPrice(java.math.BigDecimal designerPrice){
    this.designerPrice = designerPrice;
  }
 
  /**
   * 明细描述 getter
   */
  public java.lang.String getDetailDesc(){
    return detailDesc;
  }
  /**
   * 明细描述 setter
   * @param DetailDesc
   */  
  public void setDetailDesc(java.lang.String detailDesc){
    this.detailDesc = detailDesc;
  }
 
  /**
   * 明细编号 getter
   */
  public java.lang.Long getDetailID(){
    return detailID;
  }
  /**
   * 明细编号 setter
   * @param DetailID
   */  
  public void setDetailID(java.lang.Long detailID){
    this.detailID = detailID;
  }
 
  /**
   * 期望重量 getter
   */
  public java.lang.Float getExpectedWeight(){
    return expectedWeight;
  }
  /**
   * 期望重量 setter
   * @param ExpectedWeight
   */  
  public void setExpectedWeight(java.lang.Float expectedWeight){
    this.expectedWeight = expectedWeight;
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
   * 是否套餐 getter
   */
  public java.lang.Boolean getIsCombo(){
    return isCombo;
  }
  /**
   * 是否套餐 setter
   * @param IsCombo
   */  
  public void setIsCombo(java.lang.Boolean isCombo){
    this.isCombo = isCombo;
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
   * 菜单编号 getter
   */
  public java.lang.Long getMenuID(){
    return menuID;
  }
  /**
   * 菜单编号 setter
   * @param MenuID
   */  
  public void setMenuID(java.lang.Long menuID){
    this.menuID = menuID;
  }
 
  /**
   * 需要称重 getter
   */
  public java.lang.Boolean getNeedWeigh(){
    return needWeigh;
  }
  /**
   * 需要称重 setter
   * @param NeedWeigh
   */  
  public void setNeedWeigh(java.lang.Boolean needWeigh){
    this.needWeigh = needWeigh;
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
   * 成交价 getter
   */
  public java.math.BigDecimal getPrice(){
    return price;
  }
  /**
   * 成交价 setter
   * @param Price
   */  
  public void setPrice(java.math.BigDecimal price){
    this.price = price;
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
   * 桌台编号 getter
   */
  public java.lang.Long getTableID(){
    return tableID;
  }
  /**
   * 桌台编号 setter
   * @param TableID
   */  
  public void setTableID(java.lang.Long tableID){
    this.tableID = tableID;
  }
 
  /**
   * 总价 getter
   */
  public java.math.BigDecimal getTotalAmount(){
    return totalAmount;
  }
  /**
   * 总价 setter
   * @param TotalAmount
   */  
  public void setTotalAmount(java.math.BigDecimal totalAmount){
    this.totalAmount = totalAmount;
  }
 
  /**
   * 属性值 getter
   */
  public java.lang.String getValueIDs(){
    return valueIDs;
  }
  /**
   * 属性值 setter
   * @param ValueIDs
   */  
  public void setValueIDs(java.lang.String valueIDs){
    this.valueIDs = valueIDs;
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
 
}