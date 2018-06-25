package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.format.annotation.DateTimeFormat;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_StallWeighInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_StallWeighInfoEntityBase extends Entity {

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
   *	AuditorID数据库列名
   */
  public final static String AUDITORID_FIELD =  "AuditorID";
  
  /**
   *	AuditorID字段中文名，用于视图展示
   */
  public final static String AUDITORID_LABLE = "审核人";
  
  /**
   *	AuditorID对应的java字段名,业务操作使用这个字段。
   */
  private Long auditorID;
  
  /**
   *	AuditTime数据库列名
   */
  public final static String AUDITTIME_FIELD =  "AuditTime";
  
  /**
   *	AuditTime字段中文名，用于视图展示
   */
  public final static String AUDITTIME_LABLE = "审核时间";
  
  /**
   *	AuditTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime auditTime;
  
  /**
   *	ConfirmorID数据库列名
   */
  public final static String CONFIRMORID_FIELD =  "ConfirmorID";
  
  /**
   *	ConfirmorID字段中文名，用于视图展示
   */
  public final static String CONFIRMORID_LABLE = "确认人";
  
  /**
   *	ConfirmorID对应的java字段名,业务操作使用这个字段。
   */
  private Long confirmorID;
  
  /**
   *	ConfirmorType数据库列名
   */
  public final static String CONFIRMORTYPE_FIELD =  "ConfirmorType";
  
  /**
   *	ConfirmorType字段中文名，用于视图展示
   */
  public final static String CONFIRMORTYPE_LABLE = "确认人类别";
  
  /**
   *	ConfirmorType对应的java字段名,业务操作使用这个字段。
   */
  private Long confirmorType;
  
  /**
   *	ConfirmTime数据库列名
   */
  public final static String CONFIRMTIME_FIELD =  "ConfirmTime";
  
  /**
   *	ConfirmTime字段中文名，用于视图展示
   */
  public final static String CONFIRMTIME_LABLE = "确认时间";
  
  /**
   *	ConfirmTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime confirmTime;
  
  /**
   *	CreateTime数据库列名
   */
  public final static String CREATETIME_FIELD =  "CreateTime";
  
  /**
   *	CreateTime字段中文名，用于视图展示
   */
  public final static String CREATETIME_LABLE = "CreateTime";
  
  /**
   *	CreateTime对应的java字段名,业务操作使用这个字段。
   */
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private java.time.LocalDateTime createTime;
  
  /**
   *	Creator数据库列名
   */
  public final static String CREATOR_FIELD =  "Creator";
  
  /**
   *	Creator字段中文名，用于视图展示
   */
  public final static String CREATOR_LABLE = "Creator";
  
  /**
   *	Creator对应的java字段名,业务操作使用这个字段。
   */
  private String creator;
  
  /**
   *	CreatorID数据库列名
   */
  public final static String CREATORID_FIELD =  "CreatorID";
  
  /**
   *	CreatorID字段中文名，用于视图展示
   */
  public final static String CREATORID_LABLE = "CreatorID";
  
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
  public final static String CREATORTYPE_LABLE = "CreatorType";
  
  /**
   *	CreatorType对应的java字段名,业务操作使用这个字段。
   */
  private Long creatorType;
  
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
   *	FirstLetter数据库列名
   */
  public final static String FIRSTLETTER_FIELD =  "FirstLetter";
  
  /**
   *	FirstLetter字段中文名，用于视图展示
   */
  public final static String FIRSTLETTER_LABLE = "FirstLetter";
  
  /**
   *	FirstLetter对应的java字段名,业务操作使用这个字段。
   */
  private String firstLetter;
  
  /**
   *	Gtin数据库列名
   */
  public final static String GTIN_FIELD =  "Gtin";
  
  /**
   *	Gtin字段中文名，用于视图展示
   */
  public final static String GTIN_LABLE = "商品编码";
  
  /**
   *	Gtin对应的java字段名,业务操作使用这个字段。
   */
  private String gtin;
  
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
   *	NeedConfirm数据库列名
   */
  public final static String NEEDCONFIRM_FIELD =  "NeedConfirm";
  
  /**
   *	NeedConfirm字段中文名，用于视图展示
   */
  public final static String NEEDCONFIRM_LABLE = "需要确认";
  
  /**
   *	NeedConfirm对应的java字段名,业务操作使用这个字段。
   */
  private Boolean needConfirm;
  
  /**
   *	OptionID数据库列名
   */
  public final static String OPTIONID_FIELD =  "OptionID";
  
  /**
   *	OptionID字段中文名，用于视图展示
   */
  public final static String OPTIONID_LABLE = "做法编号";
  
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
  public final static String OPTIONNAME_LABLE = "做法名称";
  
  /**
   *	OptionName对应的java字段名,业务操作使用这个字段。
   */
  private String optionName;
  
  /**
   *	OrderCode数据库列名
   */
  public final static String ORDERCODE_FIELD =  "OrderCode";
  
  /**
   *	OrderCode字段中文名，用于视图展示
   */
  public final static String ORDERCODE_LABLE = "订单编码";
  
  /**
   *	OrderCode对应的java字段名,业务操作使用这个字段。
   */
  private String orderCode;
  
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
   *	PeopleNum数据库列名
   */
  public final static String PEOPLENUM_FIELD =  "PeopleNum";
  
  /**
   *	PeopleNum字段中文名，用于视图展示
   */
  public final static String PEOPLENUM_LABLE = "就餐人数";
  
  /**
   *	PeopleNum对应的java字段名,业务操作使用这个字段。
   */
  private Integer peopleNum;
  
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
   *	RealWeight数据库列名
   */
  public final static String REALWEIGHT_FIELD =  "RealWeight";
  
  /**
   *	RealWeight字段中文名，用于视图展示
   */
  public final static String REALWEIGHT_LABLE = "实际重量";
  
  /**
   *	RealWeight对应的java字段名,业务操作使用这个字段。
   */
  private Float realWeight;
  
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
   *	StallID数据库列名
   */
  public final static String STALLID_FIELD =  "StallID";
  
  /**
   *	StallID字段中文名，用于视图展示
   */
  public final static String STALLID_LABLE = "档口编号";
  
  /**
   *	StallID对应的java字段名,业务操作使用这个字段。
   */
  private Long stallID;
  
  /**
   *	SubNumber数据库列名
   */
  public final static String SUBNUMBER_FIELD =  "SubNumber";
  
  /**
   *	SubNumber字段中文名，用于视图展示
   */
  public final static String SUBNUMBER_LABLE = "桌数";
  
  /**
   *	SubNumber对应的java字段名,业务操作使用这个字段。
   */
  private Integer subNumber;
  
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
   *	TableCode数据库列名
   */
  public final static String TABLECODE_FIELD =  "TableCode";
  
  /**
   *	TableCode字段中文名，用于视图展示
   */
  public final static String TABLECODE_LABLE = "桌台编码";
  
  /**
   *	TableCode对应的java字段名,业务操作使用这个字段。
   */
  private String tableCode;
  
  /**
   *	TableID数据库列名
   */
  public final static String TABLEID_FIELD =  "TableID";
  
  /**
   *	TableID字段中文名，用于视图展示
   */
  public final static String TABLEID_LABLE = "桌台编号";
  
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
  public final static String TABLENAME_LABLE = "桌台名称";
  
  /**
   *	TableName对应的java字段名,业务操作使用这个字段。
   */
  private String tableName;
  
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
   *	UnitName数据库列名
   */
  public final static String UNITNAME_FIELD =  "UnitName";
  
  /**
   *	UnitName字段中文名，用于视图展示
   */
  public final static String UNITNAME_LABLE = "单位";
  
  /**
   *	UnitName对应的java字段名,业务操作使用这个字段。
   */
  private String unitName;
  
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
   *	Weigher数据库列名
   */
  public final static String WEIGHER_FIELD =  "Weigher";
  
  /**
   *	Weigher字段中文名，用于视图展示
   */
  public final static String WEIGHER_LABLE = "Weigher";
  
  /**
   *	Weigher对应的java字段名,业务操作使用这个字段。
   */
  private String weigher;
  
  /**
   *	WeigherID数据库列名
   */
  public final static String WEIGHERID_FIELD =  "WeigherID";
  
  /**
   *	WeigherID字段中文名，用于视图展示
   */
  public final static String WEIGHERID_LABLE = "称重人";
  
  /**
   *	WeigherID对应的java字段名,业务操作使用这个字段。
   */
  private Long weigherID;
  
  /**
   *	WeighID数据库列名
   */
  public final static String WEIGHID_FIELD =  "WeighID";
  
  /**
   *	WeighID字段中文名，用于视图展示
   */
  public final static String WEIGHID_LABLE = "称重编号";
  
  /**
   *	WeighID对应的java字段名,业务操作使用这个字段。
   */
  private Long weighID;
  
  /**
   *	WeighTime数据库列名
   */
  public final static String WEIGHTIME_FIELD =  "WeighTime";
  
  /**
   *	WeighTime字段中文名，用于视图展示
   */
  public final static String WEIGHTIME_LABLE = "称重时间";
  
  /**
   *	WeighTime对应的java字段名,业务操作使用这个字段。
   */
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  private java.time.LocalDateTime weighTime;
  
  /**
   *	WeightStatus数据库列名
   */
  public final static String WEIGHTSTATUS_FIELD =  "WeightStatus";
  
  /**
   *	WeightStatus字段中文名，用于视图展示
   */
  public final static String WEIGHTSTATUS_LABLE = "称重状态";
  
  /**
   *	WeightStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long weightStatus;
  
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
   * 审核人 getter
   */
  public Long getAuditorID(){
    return auditorID;
  }
  /**
   * 审核人 setter
   * @param AuditorID
   */  
  public void setAuditorID(Long auditorID){
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
   * 确认人 getter
   */
  public Long getConfirmorID(){
    return confirmorID;
  }
  /**
   * 确认人 setter
   * @param ConfirmorID
   */  
  public void setConfirmorID(Long confirmorID){
    this.confirmorID = confirmorID;
  }
 
  /**
   * 确认人类别 getter
   */
  public Long getConfirmorType(){
    return confirmorType;
  }
  /**
   * 确认人类别 setter
   * @param ConfirmorType
   */  
  public void setConfirmorType(Long confirmorType){
    this.confirmorType = confirmorType;
  }
 
  /**
   * 确认时间 getter
   */
  public java.time.LocalDateTime getConfirmTime(){
    return confirmTime;
  }
  /**
   * 确认时间 setter
   * @param ConfirmTime
   */  
  public void setConfirmTime(java.time.LocalDateTime confirmTime){
    this.confirmTime = confirmTime;
  }
 
  /**
   * CreateTime getter
   */
  public java.time.LocalDateTime getCreateTime(){
    return createTime;
  }
  /**
   * CreateTime setter
   * @param CreateTime
   */  
  public void setCreateTime(java.time.LocalDateTime createTime){
    this.createTime = createTime;
  }
 
  /**
   * Creator getter
   */
  public String getCreator(){
    return creator;
  }
  /**
   * Creator setter
   * @param Creator
   */  
  public void setCreator(String creator){
    this.creator = creator;
  }
 
  /**
   * CreatorID getter
   */
  public Long getCreatorID(){
    return creatorID;
  }
  /**
   * CreatorID setter
   * @param CreatorID
   */  
  public void setCreatorID(Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * CreatorType getter
   */
  public Long getCreatorType(){
    return creatorType;
  }
  /**
   * CreatorType setter
   * @param CreatorType
   */  
  public void setCreatorType(Long creatorType){
    this.creatorType = creatorType;
  }
 
  /**
   * 明细描述 getter
   */
  public String getDetailDesc(){
    return detailDesc;
  }
  /**
   * 明细描述 setter
   * @param DetailDesc
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
   * @param DetailID
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
   * @param ExpectedWeight
   */  
  public void setExpectedWeight(Float expectedWeight){
    this.expectedWeight = expectedWeight;
  }
 
  /**
   * FirstLetter getter
   */
  public String getFirstLetter(){
    return firstLetter;
  }
  /**
   * FirstLetter setter
   * @param FirstLetter
   */  
  public void setFirstLetter(String firstLetter){
    this.firstLetter = firstLetter;
  }
 
  /**
   * 商品编码 getter
   */
  public String getGtin(){
    return gtin;
  }
  /**
   * 商品编码 setter
   * @param Gtin
   */  
  public void setGtin(String gtin){
    this.gtin = gtin;
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
   * 需要确认 getter
   */
  public Boolean getNeedConfirm(){
    return needConfirm;
  }
  /**
   * 需要确认 setter
   * @param NeedConfirm
   */  
  public void setNeedConfirm(Boolean needConfirm){
    this.needConfirm = needConfirm;
  }
 
  /**
   * 做法编号 getter
   */
  public Long getOptionID(){
    return optionID;
  }
  /**
   * 做法编号 setter
   * @param OptionID
   */  
  public void setOptionID(Long optionID){
    this.optionID = optionID;
  }
 
  /**
   * 做法名称 getter
   */
  public String getOptionName(){
    return optionName;
  }
  /**
   * 做法名称 setter
   * @param OptionName
   */  
  public void setOptionName(String optionName){
    this.optionName = optionName;
  }
 
  /**
   * 订单编码 getter
   */
  public String getOrderCode(){
    return orderCode;
  }
  /**
   * 订单编码 setter
   * @param OrderCode
   */  
  public void setOrderCode(String orderCode){
    this.orderCode = orderCode;
  }
 
  /**
   * 订单编号 getter
   */
  public Long getOrderID(){
    return orderID;
  }
  /**
   * 订单编号 setter
   * @param OrderID
   */  
  public void setOrderID(Long orderID){
    this.orderID = orderID;
  }
 
  /**
   * 就餐人数 getter
   */
  public Integer getPeopleNum(){
    return peopleNum;
  }
  /**
   * 就餐人数 setter
   * @param PeopleNum
   */  
  public void setPeopleNum(Integer peopleNum){
    this.peopleNum = peopleNum;
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
   * 商品名称 getter
   */
  public String getProductName(){
    return productName;
  }
  /**
   * 商品名称 setter
   * @param ProductName
   */  
  public void setProductName(String productName){
    this.productName = productName;
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
   * 实际重量 getter
   */
  public Float getRealWeight(){
    return realWeight;
  }
  /**
   * 实际重量 setter
   * @param RealWeight
   */  
  public void setRealWeight(Float realWeight){
    this.realWeight = realWeight;
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
   * 档口编号 getter
   */
  public Long getStallID(){
    return stallID;
  }
  /**
   * 档口编号 setter
   * @param StallID
   */  
  public void setStallID(Long stallID){
    this.stallID = stallID;
  }
 
  /**
   * 桌数 getter
   */
  public Integer getSubNumber(){
    return subNumber;
  }
  /**
   * 桌数 setter
   * @param SubNumber
   */  
  public void setSubNumber(Integer subNumber){
    this.subNumber = subNumber;
  }
 
  /**
   * 子订单编号 getter
   */
  public Long getSubOrderID(){
    return subOrderID;
  }
  /**
   * 子订单编号 setter
   * @param SubOrderID
   */  
  public void setSubOrderID(Long subOrderID){
    this.subOrderID = subOrderID;
  }
 
  /**
   * 桌台编码 getter
   */
  public String getTableCode(){
    return tableCode;
  }
  /**
   * 桌台编码 setter
   * @param TableCode
   */  
  public void setTableCode(String tableCode){
    this.tableCode = tableCode;
  }
 
  /**
   * 桌台编号 getter
   */
  public Long getTableID(){
    return tableID;
  }
  /**
   * 桌台编号 setter
   * @param TableID
   */  
  public void setTableID(Long tableID){
    this.tableID = tableID;
  }
 
  /**
   * 桌台名称 getter
   */
  public String getTableName(){
    return tableName;
  }
  /**
   * 桌台名称 setter
   * @param TableName
   */  
  public void setTableName(String tableName){
    this.tableName = tableName;
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
   * 单位 getter
   */
  public String getUnitName(){
    return unitName;
  }
  /**
   * 单位 setter
   * @param UnitName
   */  
  public void setUnitName(String unitName){
    this.unitName = unitName;
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
 
  /**
   * Weigher getter
   */
  public String getWeigher(){
    return weigher;
  }
  /**
   * Weigher setter
   * @param Weigher
   */  
  public void setWeigher(String weigher){
    this.weigher = weigher;
  }
 
  /**
   * 称重人 getter
   */
  public Long getWeigherID(){
    return weigherID;
  }
  /**
   * 称重人 setter
   * @param WeigherID
   */  
  public void setWeigherID(Long weigherID){
    this.weigherID = weigherID;
  }
 
  /**
   * 称重编号 getter
   */
  public Long getWeighID(){
    return weighID;
  }
  /**
   * 称重编号 setter
   * @param WeighID
   */  
  public void setWeighID(Long weighID){
    this.weighID = weighID;
  }
 
  /**
   * 称重时间 getter
   */
  public java.time.LocalDateTime getWeighTime(){
    return weighTime;
  }
  /**
   * 称重时间 setter
   * @param WeighTime
   */  
  public void setWeighTime(java.time.LocalDateTime weighTime){
    this.weighTime = weighTime;
  }
 
  /**
   * 称重状态 getter
   */
  public Long getWeightStatus(){
    return weightStatus;
  }
  /**
   * 称重状态 setter
   * @param WeightStatus
   */  
  public void setWeightStatus(Long weightStatus){
    this.weightStatus = weightStatus;
  }
 
}