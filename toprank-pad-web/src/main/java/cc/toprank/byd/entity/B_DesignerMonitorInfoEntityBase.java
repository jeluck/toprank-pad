package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_DesignerMonitorInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_DesignerMonitorInfoEntityBase extends Entity {

  /**
   *	ArchiveID数据库列名
   */
  public final static java.lang.String ARCHIVEID_FIELD =  "ArchiveID";
  
  /**
   *	ArchiveID字段中文名，用于视图展示
   */
  public final static java.lang.String ARCHIVEID_LABLE = "档案编号";
  
  /**
   *	ArchiveID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long archiveID;
  
  /**
   *	AttributeValues数据库列名
   */
  public final static java.lang.String ATTRIBUTEVALUES_FIELD =  "AttributeValues";
  
  /**
   *	AttributeValues字段中文名，用于视图展示
   */
  public final static java.lang.String ATTRIBUTEVALUES_LABLE = "属性值名称";
  
  /**
   *	AttributeValues对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String attributeValues;
  
  /**
   *	AuditorID数据库列名
   */
  public final static java.lang.String AUDITORID_FIELD =  "AuditorID";
  
  /**
   *	AuditorID字段中文名，用于视图展示
   */
  public final static java.lang.String AUDITORID_LABLE = "审核人";
  
  /**
   *	AuditorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long auditorID;
  
  /**
   *	AuditTime数据库列名
   */
  public final static java.lang.String AUDITTIME_FIELD =  "AuditTime";
  
  /**
   *	AuditTime字段中文名，用于视图展示
   */
  public final static java.lang.String AUDITTIME_LABLE = "审核时间";
  
  /**
   *	AuditTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime auditTime;
  
  /**
   *	CategoryID数据库列名
   */
  public final static java.lang.String CATEGORYID_FIELD =  "CategoryID";
  
  /**
   *	CategoryID字段中文名，用于视图展示
   */
  public final static java.lang.String CATEGORYID_LABLE = "类别编号";
  
  /**
   *	CategoryID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long categoryID;
  
  /**
   *	CategoryName数据库列名
   */
  public final static java.lang.String CATEGORYNAME_FIELD =  "CategoryName";
  
  /**
   *	CategoryName字段中文名，用于视图展示
   */
  public final static java.lang.String CATEGORYNAME_LABLE = "类别名称";
  
  /**
   *	CategoryName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String categoryName;
  
  /**
   *	ClerkID数据库列名
   */
  public final static java.lang.String CLERKID_FIELD =  "ClerkID";
  
  /**
   *	ClerkID字段中文名，用于视图展示
   */
  public final static java.lang.String CLERKID_LABLE = "点单员";
  
  /**
   *	ClerkID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long clerkID;
  
  /**
   *	ClerkName数据库列名
   */
  public final static java.lang.String CLERKNAME_FIELD =  "ClerkName";
  
  /**
   *	ClerkName字段中文名，用于视图展示
   */
  public final static java.lang.String CLERKNAME_LABLE = "点单员名称";
  
  /**
   *	ClerkName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String clerkName;
  
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
  public final static java.lang.String DESIGNERID_LABLE = "设计师编号";
  
  /**
   *	DesignerID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long designerID;
  
  /**
   *	DesignerName数据库列名
   */
  public final static java.lang.String DESIGNERNAME_FIELD =  "DesignerName";
  
  /**
   *	DesignerName字段中文名，用于视图展示
   */
  public final static java.lang.String DESIGNERNAME_LABLE = "设计师名称";
  
  /**
   *	DesignerName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String designerName;
  
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
   *	MonitorID数据库列名
   */
  public final static java.lang.String MONITORID_FIELD =  "MonitorID";
  
  /**
   *	MonitorID字段中文名，用于视图展示
   */
  public final static java.lang.String MONITORID_LABLE = "看板编号";
  
  /**
   *	MonitorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long monitorID;
  
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
   *	OrderID数据库列名
   */
  public final static java.lang.String ORDERID_FIELD =  "OrderID";
  
  /**
   *	OrderID字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERID_LABLE = "订单编号";
  
  /**
   *	OrderID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orderID;
  
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
   *	ProduceID数据库列名
   */
  public final static java.lang.String PRODUCEID_FIELD =  "ProduceID";
  
  /**
   *	ProduceID字段中文名，用于视图展示
   */
  public final static java.lang.String PRODUCEID_LABLE = "制作编号";
  
  /**
   *	ProduceID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long produceID;
  
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
   *	SubOrderID数据库列名
   */
  public final static java.lang.String SUBORDERID_FIELD =  "SubOrderID";
  
  /**
   *	SubOrderID字段中文名，用于视图展示
   */
  public final static java.lang.String SUBORDERID_LABLE = "子订单编号";
  
  /**
   *	SubOrderID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long subOrderID;
  
  /**
   *	TableCode数据库列名
   */
  public final static java.lang.String TABLECODE_FIELD =  "TableCode";
  
  /**
   *	TableCode字段中文名，用于视图展示
   */
  public final static java.lang.String TABLECODE_LABLE = "桌台编码";
  
  /**
   *	TableCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String tableCode;
  
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
   *	TableName数据库列名
   */
  public final static java.lang.String TABLENAME_FIELD =  "TableName";
  
  /**
   *	TableName字段中文名，用于视图展示
   */
  public final static java.lang.String TABLENAME_LABLE = "桌台名称";
  
  /**
   *	TableName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String tableName;
  
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
   *	UnitName数据库列名
   */
  public final static java.lang.String UNITNAME_FIELD =  "UnitName";
  
  /**
   *	UnitName字段中文名，用于视图展示
   */
  public final static java.lang.String UNITNAME_LABLE = "单位";
  
  /**
   *	UnitName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String unitName;
  
  /**
   *	ValueIDs数据库列名
   */
  public final static java.lang.String VALUEIDS_FIELD =  "ValueIDs";
  
  /**
   *	ValueIDs字段中文名，用于视图展示
   */
  public final static java.lang.String VALUEIDS_LABLE = "属性值编号";
  
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
   * 档案编号 getter
   */
  public java.lang.Long getArchiveID(){
    return archiveID;
  }
  /**
   * 档案编号 setter
   * @param ArchiveID
   */  
  public void setArchiveID(java.lang.Long archiveID){
    this.archiveID = archiveID;
  }
 
  /**
   * 属性值名称 getter
   */
  public java.lang.String getAttributeValues(){
    return attributeValues;
  }
  /**
   * 属性值名称 setter
   * @param AttributeValues
   */  
  public void setAttributeValues(java.lang.String attributeValues){
    this.attributeValues = attributeValues;
  }
 
  /**
   * 审核人 getter
   */
  public java.lang.Long getAuditorID(){
    return auditorID;
  }
  /**
   * 审核人 setter
   * @param AuditorID
   */  
  public void setAuditorID(java.lang.Long auditorID){
    this.auditorID = auditorID;
  }
 
  /**
   * 审核时间 getter
   */
  public java.time.LocalDateTime getAuditTime(){
    return auditTime;
  }
  /**
   * 审核时间 setter
   * @param AuditTime
   */  
  public void setAuditTime(java.time.LocalDateTime auditTime){
    this.auditTime = auditTime;
  }
 
  /**
   * 类别编号 getter
   */
  public java.lang.Long getCategoryID(){
    return categoryID;
  }
  /**
   * 类别编号 setter
   * @param CategoryID
   */  
  public void setCategoryID(java.lang.Long categoryID){
    this.categoryID = categoryID;
  }
 
  /**
   * 类别名称 getter
   */
  public java.lang.String getCategoryName(){
    return categoryName;
  }
  /**
   * 类别名称 setter
   * @param CategoryName
   */  
  public void setCategoryName(java.lang.String categoryName){
    this.categoryName = categoryName;
  }
 
  /**
   * 点单员 getter
   */
  public java.lang.Long getClerkID(){
    return clerkID;
  }
  /**
   * 点单员 setter
   * @param ClerkID
   */  
  public void setClerkID(java.lang.Long clerkID){
    this.clerkID = clerkID;
  }
 
  /**
   * 点单员名称 getter
   */
  public java.lang.String getClerkName(){
    return clerkName;
  }
  /**
   * 点单员名称 setter
   * @param ClerkName
   */  
  public void setClerkName(java.lang.String clerkName){
    this.clerkName = clerkName;
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
   * 设计师编号 getter
   */
  public java.lang.Long getDesignerID(){
    return designerID;
  }
  /**
   * 设计师编号 setter
   * @param DesignerID
   */  
  public void setDesignerID(java.lang.Long designerID){
    this.designerID = designerID;
  }
 
  /**
   * 设计师名称 getter
   */
  public java.lang.String getDesignerName(){
    return designerName;
  }
  /**
   * 设计师名称 setter
   * @param DesignerName
   */  
  public void setDesignerName(java.lang.String designerName){
    this.designerName = designerName;
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
   * 看板编号 getter
   */
  public java.lang.Long getMonitorID(){
    return monitorID;
  }
  /**
   * 看板编号 setter
   * @param MonitorID
   */  
  public void setMonitorID(java.lang.Long monitorID){
    this.monitorID = monitorID;
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
   * 订单编号 getter
   */
  public java.lang.Long getOrderID(){
    return orderID;
  }
  /**
   * 订单编号 setter
   * @param OrderID
   */  
  public void setOrderID(java.lang.Long orderID){
    this.orderID = orderID;
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
   * 制作编号 getter
   */
  public java.lang.Long getProduceID(){
    return produceID;
  }
  /**
   * 制作编号 setter
   * @param ProduceID
   */  
  public void setProduceID(java.lang.Long produceID){
    this.produceID = produceID;
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
   * 子订单编号 getter
   */
  public java.lang.Long getSubOrderID(){
    return subOrderID;
  }
  /**
   * 子订单编号 setter
   * @param SubOrderID
   */  
  public void setSubOrderID(java.lang.Long subOrderID){
    this.subOrderID = subOrderID;
  }
 
  /**
   * 桌台编码 getter
   */
  public java.lang.String getTableCode(){
    return tableCode;
  }
  /**
   * 桌台编码 setter
   * @param TableCode
   */  
  public void setTableCode(java.lang.String tableCode){
    this.tableCode = tableCode;
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
   * 桌台名称 getter
   */
  public java.lang.String getTableName(){
    return tableName;
  }
  /**
   * 桌台名称 setter
   * @param TableName
   */  
  public void setTableName(java.lang.String tableName){
    this.tableName = tableName;
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
   * 单位 getter
   */
  public java.lang.String getUnitName(){
    return unitName;
  }
  /**
   * 单位 setter
   * @param UnitName
   */  
  public void setUnitName(java.lang.String unitName){
    this.unitName = unitName;
  }
 
  /**
   * 属性值编号 getter
   */
  public java.lang.String getValueIDs(){
    return valueIDs;
  }
  /**
   * 属性值编号 setter
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