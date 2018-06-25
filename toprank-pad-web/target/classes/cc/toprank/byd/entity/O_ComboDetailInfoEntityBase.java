package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_ComboDetailInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_ComboDetailInfoEntityBase extends Entity {

  /**
   *	ComboID数据库列名
   */
  public final static java.lang.String COMBOID_FIELD =  "ComboID";
  
  /**
   *	ComboID字段中文名，用于视图展示
   */
  public final static java.lang.String COMBOID_LABLE = "套餐编号";
  
  /**
   *	ComboID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long comboID;
  
  /**
   *	ComboName数据库列名
   */
  public final static java.lang.String COMBONAME_FIELD =  "ComboName";
  
  /**
   *	ComboName字段中文名，用于视图展示
   */
  public final static java.lang.String COMBONAME_LABLE = "套餐名称";
  
  /**
   *	ComboName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String comboName;
  
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
   *	ImgPath数据库列名
   */
  public final static java.lang.String IMGPATH_FIELD =  "ImgPath";
  
  /**
   *	ImgPath字段中文名，用于视图展示
   */
  public final static java.lang.String IMGPATH_LABLE = "图片地址";
  
  /**
   *	ImgPath对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String imgPath;
  
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
  public final static java.lang.String PRICE_LABLE = "成交价";
  
  /**
   *	Price对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal price;
  
  /**
   *	ProduceStatus数据库列名
   */
  public final static java.lang.String PRODUCESTATUS_FIELD =  "ProduceStatus";
  
  /**
   *	ProduceStatus字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCESTATUS_LABLE = "制作状态";
  
  /**
   *	ProduceStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long produceStatus;
  
  /**
   *	ProduceTime数据库列名
   */
  public final static java.lang.String PRODUCETIME_FIELD =  "ProduceTime";
  
  /**
   *	ProduceTime字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCETIME_LABLE = "出品时间";
  
  /**
   *	ProduceTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime produceTime;
  
  /**
   *	ProductName数据库列名
   */
  public final static java.lang.String PRODUCTNAME_FIELD =  "ProductName";
  
  /**
   *	ProductName字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCTNAME_LABLE = "商品名称";
  
  /**
   *	ProductName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String productName;
  
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
   *	RecordID数据库列名
   */
  public final static java.lang.String RECORDID_FIELD =  "RecordID";
  
  /**
   *	RecordID字段中文名，用于视图展示
   */
  public final static java.lang.String RECORDID_LABLE = "记录编号";
  
  /**
   *	RecordID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long recordID;
  
  /**
   *	ServedNum数据库列名
   */
  public final static java.lang.String SERVEDNUM_FIELD =  "ServedNum";
  
  /**
   *	ServedNum字段中文名，用于视图展示
   */
  public final static java.lang.String SERVEDNUM_LABLE = "上菜数量";
  
  /**
   *	ServedNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer servedNum;
  
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
   *	ValueNames数据库列名
   */
  public final static java.lang.String VALUENAMES_FIELD =  "ValueNames";
  
  /**
   *	ValueNames字段中文名，用于视图展示
   */
  public final static java.lang.String VALUENAMES_LABLE = "属性名称";
  
  /**
   *	ValueNames对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String valueNames;
  
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
   * 套餐编号 getter
   */
  public java.lang.Long getComboID(){
    return comboID;
  }
  /**
   * 套餐编号 setter
   * @param ComboID
   */  
  public void setComboID(java.lang.Long comboID){
    this.comboID = comboID;
  }
 
  /**
   * 套餐名称 getter
   */
  public java.lang.String getComboName(){
    return comboName;
  }
  /**
   * 套餐名称 setter
   * @param ComboName
   */  
  public void setComboName(java.lang.String comboName){
    this.comboName = comboName;
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
   * 图片地址 getter
   */
  public java.lang.String getImgPath(){
    return imgPath;
  }
  /**
   * 图片地址 setter
   * @param ImgPath
   */  
  public void setImgPath(java.lang.String imgPath){
    this.imgPath = imgPath;
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
   * 制作状态 getter
   */
  public java.lang.Long getProduceStatus(){
    return produceStatus;
  }
  /**
   * 制作状态 setter
   * @param ProduceStatus
   */  
  public void setProduceStatus(java.lang.Long produceStatus){
    this.produceStatus = produceStatus;
  }
 
  /**
   * 出品时间 getter
   */
  public java.time.LocalDateTime getProduceTime(){
    return produceTime;
  }
  /**
   * 出品时间 setter
   * @param ProduceTime
   */  
  public void setProduceTime(java.time.LocalDateTime produceTime){
    this.produceTime = produceTime;
  }
 
  /**
   * 商品名称 getter
   */
  public java.lang.String getProductName(){
    return productName;
  }
  /**
   * 商品名称 setter
   * @param ProductName
   */  
  public void setProductName(java.lang.String productName){
    this.productName = productName;
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
   * 记录编号 getter
   */
  public java.lang.Long getRecordID(){
    return recordID;
  }
  /**
   * 记录编号 setter
   * @param RecordID
   */  
  public void setRecordID(java.lang.Long recordID){
    this.recordID = recordID;
  }
 
  /**
   * 上菜数量 getter
   */
  public java.lang.Integer getServedNum(){
    return servedNum;
  }
  /**
   * 上菜数量 setter
   * @param ServedNum
   */  
  public void setServedNum(java.lang.Integer servedNum){
    this.servedNum = servedNum;
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
   * 属性名称 getter
   */
  public java.lang.String getValueNames(){
    return valueNames;
  }
  /**
   * 属性名称 setter
   * @param ValueNames
   */  
  public void setValueNames(java.lang.String valueNames){
    this.valueNames = valueNames;
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