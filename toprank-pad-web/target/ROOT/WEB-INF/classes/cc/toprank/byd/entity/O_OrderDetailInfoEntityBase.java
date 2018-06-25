package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_OrderDetailInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_OrderDetailInfoEntityBase  extends Entity{

  /**
   *	AdjustAmount数据库列名
   */
  public final static String ADJUSTAMOUNT_FIELD =  "AdjustAmount";
  
  /**
   *	AdjustAmount字段中文名，用于视图展示
   */
  public final static String ADJUSTAMOUNT_LABLE = "调整金额";
  
  /**
   *	AdjustAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal adjustAmount;
  
  /**
   *	AdjustDesc数据库列名
   */
  public final static String ADJUSTDESC_FIELD =  "AdjustDesc";
  
  /**
   *	AdjustDesc字段中文名，用于视图展示
   */
  public final static String ADJUSTDESC_LABLE = "调价描述";
  
  /**
   *	AdjustDesc对应的java字段名,业务操作使用这个字段。
   */
  private String adjustDesc;
  
  /**
   *	AdjusterID数据库列名
   */
  public final static String ADJUSTERID_FIELD =  "AdjusterID";
  
  /**
   *	AdjusterID字段中文名，用于视图展示
   */
  public final static String ADJUSTERID_LABLE = "调价人";
  
  /**
   *	AdjusterID对应的java字段名,业务操作使用这个字段。
   */
  private Long adjusterID;
  
  /**
   *	AdjustType数据库列名
   */
  public final static String ADJUSTTYPE_FIELD =  "AdjustType";
  
  /**
   *	AdjustType字段中文名，用于视图展示
   */
  public final static String ADJUSTTYPE_LABLE = "调价方式";
  
  /**
   *	AdjustType对应的java字段名,业务操作使用这个字段。
   */
  private Long adjustType;
  
  /**
   *	ALaCarteMethod数据库列名
   */
  public final static String ALACARTEMETHOD_FIELD =  "ALaCarteMethod";
  
  /**
   *	ALaCarteMethod字段中文名，用于视图展示
   */
  public final static String ALACARTEMETHOD_LABLE = "点菜方式";
  
  /**
   *	ALaCarteMethod对应的java字段名,业务操作使用这个字段。
   */
  private Long aLaCarteMethod;
  
  /**
   *	ComboID数据库列名
   */
  public final static String COMBOID_FIELD =  "ComboID";
  
  /**
   *	ComboID字段中文名，用于视图展示
   */
  public final static String COMBOID_LABLE = "套餐编号";
  
  /**
   *	ComboID对应的java字段名,业务操作使用这个字段。
   */
  private Long comboID;
  
  /**
   *	ComboName数据库列名
   */
  public final static String COMBONAME_FIELD =  "ComboName";
  
  /**
   *	ComboName字段中文名，用于视图展示
   */
  public final static String COMBONAME_LABLE = "套餐名称";
  
  /**
   *	ComboName对应的java字段名,业务操作使用这个字段。
   */
  private String comboName;
  
  /**
   *	ComboPrice数据库列名
   */
  public final static String COMBOPRICE_FIELD =  "ComboPrice";
  
  /**
   *	ComboPrice字段中文名，用于视图展示
   */
  public final static String COMBOPRICE_LABLE = "套餐价";
  
  /**
   *	ComboPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal comboPrice;
  
  /**
   *	ComboProductNum数据库列名
   */
  public final static String COMBOPRODUCTNUM_FIELD =  "ComboProductNum";
  
  /**
   *	ComboProductNum字段中文名，用于视图展示
   */
  public final static String COMBOPRODUCTNUM_LABLE = "套餐内数量";
  
  /**
   *	ComboProductNum对应的java字段名,业务操作使用这个字段。
   */
  private Integer comboProductNum;
  
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
   *	CreatorType数据库列名
   */
  public final static String CREATORTYPE_FIELD =  "CreatorType";
  
  /**
   *	CreatorType字段中文名，用于视图展示
   */
  public final static String CREATORTYPE_LABLE = "创建人类别";
  
  /**
   *	CreatorType对应的java字段名,业务操作使用这个字段。
   */
  private Long creatorType;
  
  /**
   *	DesignerID数据库列名
   */
  public final static String DESIGNERID_FIELD =  "DesignerID";
  
  /**
   *	DesignerID字段中文名，用于视图展示
   */
  public final static String DESIGNERID_LABLE = "厨师编号";
  
  /**
   *	DesignerID对应的java字段名,业务操作使用这个字段。
   */
  private Long designerID;
  
  /**
   *	DesignerPrice数据库列名
   */
  public final static String DESIGNERPRICE_FIELD =  "DesignerPrice";
  
  /**
   *	DesignerPrice字段中文名，用于视图展示
   */
  public final static String DESIGNERPRICE_LABLE = "厨师费";
  
  /**
   *	DesignerPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal designerPrice;
  
  /**
   *	DetailCode数据库列名
   */
  public final static String DETAILCODE_FIELD =  "DetailCode";
  
  /**
   *	DetailCode字段中文名，用于视图展示
   */
  public final static String DETAILCODE_LABLE = "明细编码";
  
  /**
   *	DetailCode对应的java字段名,业务操作使用这个字段。
   */
  private String detailCode;
  
  /**
   *	DetailDesc数据库列名
   */
  public final static String DETAILDESC_FIELD =  "DetailDesc";
  
  /**
   *	DetailDesc字段中文名，用于视图展示
   */
  public final static String DETAILDESC_LABLE = "明细描述";
  
  /**
   *	DetailDesc对应的java字段名,业务操作使用这个字段。
   */
  private String detailDesc;
  
  /**
   *	DetailID数据库列名
   */
  public final static String DETAILID_FIELD =  "DetailID";
  
  /**
   *	DetailID字段中文名，用于视图展示
   */
  public final static String DETAILID_LABLE = "明细编号";
  
  /**
   *	DetailID对应的java字段名,业务操作使用这个字段。
   */
  private Long detailID;
  
  /**
   *	ExpectedWeight数据库列名
   */
  public final static String EXPECTEDWEIGHT_FIELD =  "ExpectedWeight";
  
  /**
   *	ExpectedWeight字段中文名，用于视图展示
   */
  public final static String EXPECTEDWEIGHT_LABLE = "期望重量";
  
  /**
   *	ExpectedWeight对应的java字段名,业务操作使用这个字段。
   */
  private Float expectedWeight;
  
  /**
   *	FloatQuantity数据库列名
   */
  public final static String FLOATQUANTITY_FIELD =  "FloatQuantity";
  
  /**
   *	FloatQuantity字段中文名，用于视图展示
   */
  public final static String FLOATQUANTITY_LABLE = "小数数量";
  
  /**
   *	FloatQuantity对应的java字段名,业务操作使用这个字段。
   */
  private Float floatQuantity;
  
  /**
   *	ImgPath数据库列名
   */
  public final static String IMGPATH_FIELD =  "ImgPath";
  
  /**
   *	ImgPath字段中文名，用于视图展示
   */
  public final static String IMGPATH_LABLE = "图片地址";
  
  /**
   *	ImgPath对应的java字段名,业务操作使用这个字段。
   */
  private String imgPath;
  
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
   *	LoginID数据库列名
   */
  public final static String LOGINID_FIELD =  "LoginID";
  
  /**
   *	LoginID字段中文名，用于视图展示
   */
  public final static String LOGINID_LABLE = "登录编号";
  
  /**
   *	LoginID对应的java字段名,业务操作使用这个字段。
   */
  private Long loginID;
  
  /**
   *	MappingDesc数据库列名
   */
  public final static String MAPPINGDESC_FIELD =  "MappingDesc";
  
  /**
   *	MappingDesc字段中文名，用于视图展示
   */
  public final static String MAPPINGDESC_LABLE = "MappingDesc";
  
  /**
   *	MappingDesc对应的java字段名,业务操作使用这个字段。
   */
  private String mappingDesc;
  
  /**
   *	MappingReason数据库列名
   */
  public final static String MAPPINGREASON_FIELD =  "MappingReason";
  
  /**
   *	MappingReason字段中文名，用于视图展示
   */
  public final static String MAPPINGREASON_LABLE = "MappingReason";
  
  /**
   *	MappingReason对应的java字段名,业务操作使用这个字段。
   */
  private Long mappingReason;
  
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
   *	OrderID数据库列名
   */
  public final static String ORDERID_FIELD =  "OrderID";
  
  /**
   *	OrderID字段中文名，用于视图展示
   */
  public final static String ORDERID_LABLE = "订单编号";
  
  /**
   *	OrderID对应的java字段名,业务操作使用这个字段。
   */
  private Long orderID;
  
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
   *	ParentID数据库列名
   */
  public final static String PARENTID_FIELD =  "ParentID";
  
  /**
   *	ParentID字段中文名，用于视图展示
   */
  public final static String PARENTID_LABLE = "ParentID";
  
  /**
   *	ParentID对应的java字段名,业务操作使用这个字段。
   */
  private Long parentID;
  
  /**
   *	Price数据库列名
   */
  public final static String PRICE_FIELD =  "Price";
  
  /**
   *	Price字段中文名，用于视图展示
   */
  public final static String PRICE_LABLE = "成交价";
  
  /**
   *	Price对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal price;
  
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
   *	ProduceStatus数据库列名
   */
  public final static String PRODUCESTATUS_FIELD =  "ProduceStatus";
  
  /**
   *	ProduceStatus字段中文名，用于视图展示
   */
  public final static String PRODUCESTATUS_LABLE = "制作状态";
  
  /**
   *	ProduceStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long produceStatus;
  
  /**
   *	ProduceTime数据库列名
   */
  public final static String PRODUCETIME_FIELD =  "ProduceTime";
  
  /**
   *	ProduceTime字段中文名，用于视图展示
   */
  public final static String PRODUCETIME_LABLE = "出品时间";
  
  /**
   *	ProduceTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime produceTime;
  
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
   *	ProductUnit数据库列名
   */
  public final static String PRODUCTUNIT_FIELD =  "ProductUnit";
  
  /**
   *	ProductUnit字段中文名，用于视图展示
   */
  public final static String PRODUCTUNIT_LABLE = "单位";
  
  /**
   *	ProductUnit对应的java字段名,业务操作使用这个字段。
   */
  private Long productUnit;
  
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
   *	SelectedMethod数据库列名
   */
  public final static String SELECTEDMETHOD_FIELD =  "SelectedMethod";
  
  /**
   *	SelectedMethod字段中文名，用于视图展示
   */
  public final static String SELECTEDMETHOD_LABLE = "选厨方式";
  
  /**
   *	SelectedMethod对应的java字段名,业务操作使用这个字段。
   */
  private Long selectedMethod;
  
  /**
   *	ServedNum数据库列名
   */
  public final static String SERVEDNUM_FIELD =  "ServedNum";
  
  /**
   *	ServedNum字段中文名，用于视图展示
   */
  public final static String SERVEDNUM_LABLE = "上菜数量";
  
  /**
   *	ServedNum对应的java字段名,业务操作使用这个字段。
   */
  private Integer servedNum;
  
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
   *	SubOrderID数据库列名
   */
  public final static String SUBORDERID_FIELD =  "SubOrderID";
  
  /**
   *	SubOrderID字段中文名，用于视图展示
   */
  public final static String SUBORDERID_LABLE = "子订单编号";
  
  /**
   *	SubOrderID对应的java字段名,业务操作使用这个字段。
   */
  private Long subOrderID;
  
  /**
   *	TableID数据库列名
   */
  public final static String TABLEID_FIELD =  "TableID";
  
  /**
   *	TableID字段中文名，用于视图展示
   */
  public final static String TABLEID_LABLE = "TableID";
  
  /**
   *	TableID对应的java字段名,业务操作使用这个字段。
   */
  private Long tableID;
  
  /**
   *	TableName数据库列名
   */
  public final static String TABLENAME_FIELD =  "TableName";
  
  /**
   *	TableName字段中文名，用于视图展示
   */
  public final static String TABLENAME_LABLE = "TableName";
  
  /**
   *	TableName对应的java字段名,业务操作使用这个字段。
   */
  private String tableName;
  
  /**
   *	TotalAmount数据库列名
   */
  public final static String TOTALAMOUNT_FIELD =  "TotalAmount";
  
  /**
   *	TotalAmount字段中文名，用于视图展示
   */
  public final static String TOTALAMOUNT_LABLE = "总价";
  
  /**
   *	TotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal totalAmount;
  
  /**
   *	ValueIDs数据库列名
   */
  public final static String VALUEIDS_FIELD =  "ValueIDs";
  
  /**
   *	ValueIDs字段中文名，用于视图展示
   */
  public final static String VALUEIDS_LABLE = "属性值";
  
  /**
   *	ValueIDs对应的java字段名,业务操作使用这个字段。
   */
  private String valueIDs;
  
  /**
   *	ValueNames数据库列名
   */
  public final static String VALUENAMES_FIELD =  "ValueNames";
  
  /**
   *	ValueNames字段中文名，用于视图展示
   */
  public final static String VALUENAMES_LABLE = "属性名称";
  
  /**
   *	ValueNames对应的java字段名,业务操作使用这个字段。
   */
  private String valueNames;
  
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
   * 调整金额 getter
   */
  public java.math.BigDecimal getAdjustAmount(){
    return adjustAmount;
  }
  /**
   * 调整金额 setter
   * @param adjustAmount
   */  
  public void setAdjustAmount(java.math.BigDecimal adjustAmount){
    this.adjustAmount = adjustAmount;
  }
 
  /**
   * 调价描述 getter
   */
  public String getAdjustDesc(){
    return adjustDesc;
  }
  /**
   * 调价描述 setter
   * @param adjustDesc
   */  
  public void setAdjustDesc(String adjustDesc){
    this.adjustDesc = adjustDesc;
  }
 
  /**
   * 调价人 getter
   */
  public Long getAdjusterID(){
    return adjusterID;
  }
  /**
   * 调价人 setter
   * @param adjusterID
   */  
  public void setAdjusterID(Long adjusterID){
    this.adjusterID = adjusterID;
  }
 
  /**
   * 调价方式 getter
   */
  public Long getAdjustType(){
    return adjustType;
  }
  /**
   * 调价方式 setter
   * @param adjustType
   */  
  public void setAdjustType(Long adjustType){
    this.adjustType = adjustType;
  }
 
  /**
   * 点菜方式 getter
   */
  public Long getALaCarteMethod(){
    return aLaCarteMethod;
  }
  /**
   * 点菜方式 setter
   * @param aLaCarteMethod
   */  
  public void setALaCarteMethod(Long aLaCarteMethod){
    this.aLaCarteMethod = aLaCarteMethod;
  }
 
  /**
   * 套餐编号 getter
   */
  public Long getComboID(){
    return comboID;
  }
  /**
   * 套餐编号 setter
   * @param comboID
   */  
  public void setComboID(Long comboID){
    this.comboID = comboID;
  }
 
  /**
   * 套餐名称 getter
   */
  public String getComboName(){
    return comboName;
  }
  /**
   * 套餐名称 setter
   * @param comboName
   */  
  public void setComboName(String comboName){
    this.comboName = comboName;
  }
 
  /**
   * 套餐价 getter
   */
  public java.math.BigDecimal getComboPrice(){
    return comboPrice;
  }
  /**
   * 套餐价 setter
   * @param comboPrice
   */  
  public void setComboPrice(java.math.BigDecimal comboPrice){
    this.comboPrice = comboPrice;
  }
 
  /**
   * 套餐内数量 getter
   */
  public Integer getComboProductNum(){
    return comboProductNum;
  }
  /**
   * 套餐内数量 setter
   * @param comboProductNum
   */  
  public void setComboProductNum(Integer comboProductNum){
    this.comboProductNum = comboProductNum;
  }
 
  /**
   * 创建时间 getter
   */
  public java.time.LocalDateTime getCreateTime(){
    return createTime;
  }
  /**
   * 创建时间 setter
   * @param createTime
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
   * @param creatorID
   */  
  public void setCreatorID(Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * 创建人类别 getter
   */
  public Long getCreatorType(){
    return creatorType;
  }
  /**
   * 创建人类别 setter
   * @param creatorType
   */  
  public void setCreatorType(Long creatorType){
    this.creatorType = creatorType;
  }
 
  /**
   * 厨师编号 getter
   */
  public Long getDesignerID(){
    return designerID;
  }
  /**
   * 厨师编号 setter
   * @param designerID
   */  
  public void setDesignerID(Long designerID){
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
   * @param designerPrice
   */  
  public void setDesignerPrice(java.math.BigDecimal designerPrice){
    this.designerPrice = designerPrice;
  }
 
  /**
   * 明细编码 getter
   */
  public String getDetailCode(){
    return detailCode;
  }
  /**
   * 明细编码 setter
   * @param detailCode
   */  
  public void setDetailCode(String detailCode){
    this.detailCode = detailCode;
  }
 
  /**
   * 明细描述 getter
   */
  public String getDetailDesc(){
    return detailDesc;
  }
  /**
   * 明细描述 setter
   * @param detailDesc
   */  
  public void setDetailDesc(String detailDesc){
    this.detailDesc = detailDesc;
  }
 
  /**
   * 明细编号 getter
   */
  public Long getDetailID(){
    return detailID;
  }
  /**
   * 明细编号 setter
   * @param detailID
   */  
  public void setDetailID(Long detailID){
    this.detailID = detailID;
  }
 
  /**
   * 期望重量 getter
   */
  public Float getExpectedWeight(){
    return expectedWeight;
  }
  /**
   * 期望重量 setter
   * @param expectedWeight
   */  
  public void setExpectedWeight(Float expectedWeight){
    this.expectedWeight = expectedWeight;
  }
 
  /**
   * 小数数量 getter
   */
  public Float getFloatQuantity(){
    return floatQuantity;
  }
  /**
   * 小数数量 setter
   * @param floatQuantity
   */  
  public void setFloatQuantity(Float floatQuantity){
    this.floatQuantity = floatQuantity;
  }
 
  /**
   * 图片地址 getter
   */
  public String getImgPath(){
    return imgPath;
  }
  /**
   * 图片地址 setter
   * @param imgPath
   */  
  public void setImgPath(String imgPath){
    this.imgPath = imgPath;
  }
 
  /**
   * 是否套餐 getter
   */
  public Boolean getIsCombo(){
    return isCombo;
  }
  /**
   * 是否套餐 setter
   * @param isCombo
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
   * @param isSync
   */  
  public void setIsSync(Boolean isSync){
    this.isSync = isSync;
  }
 
  /**
   * 登录编号 getter
   */
  public Long getLoginID(){
    return loginID;
  }
  /**
   * 登录编号 setter
   * @param loginID
   */  
  public void setLoginID(Long loginID){
    this.loginID = loginID;
  }
 
  /**
   * MappingDesc getter
   */
  public String getMappingDesc(){
    return mappingDesc;
  }
  /**
   * MappingDesc setter
   * @param mappingDesc
   */  
  public void setMappingDesc(String mappingDesc){
    this.mappingDesc = mappingDesc;
  }
 
  /**
   * MappingReason getter
   */
  public Long getMappingReason(){
    return mappingReason;
  }
  /**
   * MappingReason setter
   * @param mappingReason
   */  
  public void setMappingReason(Long mappingReason){
    this.mappingReason = mappingReason;
  }
 
  /**
   * 备注 getter
   */
  public String getMemo(){
    return memo;
  }
  /**
   * 备注 setter
   * @param memo
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
   * @param menuID
   */  
  public void setMenuID(Long menuID){
    this.menuID = menuID;
  }
 
  /**
   * 需要称重 getter
   */
  public Boolean getNeedWeigh(){
    return needWeigh;
  }
  /**
   * 需要称重 setter
   * @param needWeigh
   */  
  public void setNeedWeigh(Boolean needWeigh){
    this.needWeigh = needWeigh;
  }
 
  /**
   * 选项编号 getter
   */
  public Long getOptionID(){
    return optionID;
  }
  /**
   * 选项编号 setter
   * @param optionID
   */  
  public void setOptionID(Long optionID){
    this.optionID = optionID;
  }
 
  /**
   * 订单编号 getter
   */
  public Long getOrderID(){
    return orderID;
  }
  /**
   * 订单编号 setter
   * @param orderID
   */  
  public void setOrderID(Long orderID){
    this.orderID = orderID;
  }
 
  /**
   * 原价 getter
   */
  public java.math.BigDecimal getOriginalPrice(){
    return originalPrice;
  }
  /**
   * 原价 setter
   * @param originalPrice
   */  
  public void setOriginalPrice(java.math.BigDecimal originalPrice){
    this.originalPrice = originalPrice;
  }
 
  /**
   * ParentID getter
   */
  public Long getParentID(){
    return parentID;
  }
  /**
   * ParentID setter
   * @param parentID
   */  
  public void setParentID(Long parentID){
    this.parentID = parentID;
  }
 
  /**
   * 成交价 getter
   */
  public java.math.BigDecimal getPrice(){
    return price;
  }
  /**
   * 成交价 setter
   * @param price
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
   * @param produceCost
   */  
  public void setProduceCost(java.math.BigDecimal produceCost){
    this.produceCost = produceCost;
  }
 
  /**
   * 制作状态 getter
   */
  public Long getProduceStatus(){
    return produceStatus;
  }
  /**
   * 制作状态 setter
   * @param produceStatus
   */  
  public void setProduceStatus(Long produceStatus){
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
   * @param produceTime
   */  
  public void setProduceTime(java.time.LocalDateTime produceTime){
    this.produceTime = produceTime;
  }
 
  /**
   * 商品名称 getter
   */
  public String getProductName(){
    return productName;
  }
  /**
   * 商品名称 setter
   * @param productName
   */  
  public void setProductName(String productName){
    this.productName = productName;
  }
 
  /**
   * 单位 getter
   */
  public Long getProductUnit(){
    return productUnit;
  }
  /**
   * 单位 setter
   * @param productUnit
   */  
  public void setProductUnit(Long productUnit){
    this.productUnit = productUnit;
  }
 
  /**
   * 数量 getter
   */
  public Integer getQuantity(){
    return quantity;
  }
  /**
   * 数量 setter
   * @param quantity
   */  
  public void setQuantity(Integer quantity){
    this.quantity = quantity;
  }
 
  /**
   * 选厨方式 getter
   */
  public Long getSelectedMethod(){
    return selectedMethod;
  }
  /**
   * 选厨方式 setter
   * @param selectedMethod
   */  
  public void setSelectedMethod(Long selectedMethod){
    this.selectedMethod = selectedMethod;
  }
 
  /**
   * 上菜数量 getter
   */
  public Integer getServedNum(){
    return servedNum;
  }
  /**
   * 上菜数量 setter
   * @param servedNum
   */  
  public void setServedNum(Integer servedNum){
    this.servedNum = servedNum;
  }
 
  /**
   * 序号 getter
   */
  public Integer getSortNo(){
    return sortNo;
  }
  /**
   * 序号 setter
   * @param sortNo
   */  
  public void setSortNo(Integer sortNo){
    this.sortNo = sortNo;
  }
 
  /**
   * 子订单编号 getter
   */
  public Long getSubOrderID(){
    return subOrderID;
  }
  /**
   * 子订单编号 setter
   * @param subOrderID
   */  
  public void setSubOrderID(Long subOrderID){
    this.subOrderID = subOrderID;
  }
 
  /**
   * TableID getter
   */
  public Long getTableID(){
    return tableID;
  }
  /**
   * TableID setter
   * @param tableID
   */  
  public void setTableID(Long tableID){
    this.tableID = tableID;
  }
 
  /**
   * TableName getter
   */
  public String getTableName(){
    return tableName;
  }
  /**
   * TableName setter
   * @param tableName
   */  
  public void setTableName(String tableName){
    this.tableName = tableName;
  }
 
  /**
   * 总价 getter
   */
  public java.math.BigDecimal getTotalAmount(){
    return totalAmount;
  }
  /**
   * 总价 setter
   * @param totalAmount
   */  
  public void setTotalAmount(java.math.BigDecimal totalAmount){
    this.totalAmount = totalAmount;
  }
 
  /**
   * 属性值 getter
   */
  public String getValueIDs(){
    return valueIDs;
  }
  /**
   * 属性值 setter
   * @param valueIDs
   */  
  public void setValueIDs(String valueIDs){
    this.valueIDs = valueIDs;
  }
 
  /**
   * 属性名称 getter
   */
  public String getValueNames(){
    return valueNames;
  }
  /**
   * 属性名称 setter
   * @param valueNames
   */  
  public void setValueNames(String valueNames){
    this.valueNames = valueNames;
  }
 
  /**
   * 变体编号 getter
   */
  public Long getVariantID(){
    return variantID;
  }
  /**
   * 变体编号 setter
   * @param variantID
   */  
  public void setVariantID(Long variantID){
    this.variantID = variantID;
  }
 
}