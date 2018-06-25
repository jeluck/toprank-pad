package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在W_ProductHisMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class W_ProductHisMappingEntityBase extends Entity {

  /**
   *	AvailableFloatQuantity数据库列名
   */
  public final static java.lang.String AVAILABLEFLOATQUANTITY_FIELD =  "AvailableFloatQuantity";
  
  /**
   *	AvailableFloatQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String AVAILABLEFLOATQUANTITY_LABLE = "小数可用";
  
  /**
   *	AvailableFloatQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float availableFloatQuantity;
  
  /**
   *	AvailableQuantity数据库列名
   */
  public final static java.lang.String AVAILABLEQUANTITY_FIELD =  "AvailableQuantity";
  
  /**
   *	AvailableQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String AVAILABLEQUANTITY_LABLE = "可用数量";
  
  /**
   *	AvailableQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer availableQuantity;
  
  /**
   *	ChangeInitFloatQuantity数据库列名
   */
  public final static java.lang.String CHANGEINITFLOATQUANTITY_FIELD =  "ChangeInitFloatQuantity";
  
  /**
   *	ChangeInitFloatQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String CHANGEINITFLOATQUANTITY_LABLE = "调整小数";
  
  /**
   *	ChangeInitFloatQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float changeInitFloatQuantity;
  
  /**
   *	ChangeInitQuantity数据库列名
   */
  public final static java.lang.String CHANGEINITQUANTITY_FIELD =  "ChangeInitQuantity";
  
  /**
   *	ChangeInitQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String CHANGEINITQUANTITY_LABLE = "调整数量";
  
  /**
   *	ChangeInitQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer changeInitQuantity;
  
  /**
   *	ConfigReason数据库列名
   */
  public final static java.lang.String CONFIGREASON_FIELD =  "ConfigReason";
  
  /**
   *	ConfigReason字段中文名，用于视图展示
   */
  public final static java.lang.String CONFIGREASON_LABLE = "配置原因";
  
  /**
   *	ConfigReason对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long configReason;
  
  /**
   *	ContainerID数据库列名
   */
  public final static java.lang.String CONTAINERID_FIELD =  "ContainerID";
  
  /**
   *	ContainerID字段中文名，用于视图展示
   */
  public final static java.lang.String CONTAINERID_LABLE = "货柜编号";
  
  /**
   *	ContainerID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long containerID;
  
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
   *	HisID数据库列名
   */
  public final static java.lang.String HISID_FIELD =  "HisID";
  
  /**
   *	HisID字段中文名，用于视图展示
   */
  public final static java.lang.String HISID_LABLE = "历史编号";
  
  /**
   *	HisID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long hisID;
  
  /**
   *	InitFloatQuantity数据库列名
   */
  public final static java.lang.String INITFLOATQUANTITY_FIELD =  "InitFloatQuantity";
  
  /**
   *	InitFloatQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String INITFLOATQUANTITY_LABLE = "小数数量";
  
  /**
   *	InitFloatQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float initFloatQuantity;
  
  /**
   *	InitQuantity数据库列名
   */
  public final static java.lang.String INITQUANTITY_FIELD =  "InitQuantity";
  
  /**
   *	InitQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String INITQUANTITY_LABLE = "初始数量";
  
  /**
   *	InitQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer initQuantity;
  
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
   *	isTotal数据库列名
   */
  public final static java.lang.String ISTOTAL_FIELD =  "isTotal";
  
  /**
   *	isTotal字段中文名，用于视图展示
   */
  public final static java.lang.String ISTOTAL_LABLE = "是否总量";
  
  /**
   *	isTotal对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isTotal;
  
  /**
   *	LockFloatQuantity数据库列名
   */
  public final static java.lang.String LOCKFLOATQUANTITY_FIELD =  "LockFloatQuantity";
  
  /**
   *	LockFloatQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String LOCKFLOATQUANTITY_LABLE = "小数锁定";
  
  /**
   *	LockFloatQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float lockFloatQuantity;
  
  /**
   *	LockQuantity数据库列名
   */
  public final static java.lang.String LOCKQUANTITY_FIELD =  "LockQuantity";
  
  /**
   *	LockQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String LOCKQUANTITY_LABLE = "锁定数量";
  
  /**
   *	LockQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer lockQuantity;
  
  /**
   *	LossFloatQuantity数据库列名
   */
  public final static java.lang.String LOSSFLOATQUANTITY_FIELD =  "LossFloatQuantity";
  
  /**
   *	LossFloatQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String LOSSFLOATQUANTITY_LABLE = "小数损耗";
  
  /**
   *	LossFloatQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float lossFloatQuantity;
  
  /**
   *	LossQuantity数据库列名
   */
  public final static java.lang.String LOSSQUANTITY_FIELD =  "LossQuantity";
  
  /**
   *	LossQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String LOSSQUANTITY_LABLE = "损耗数量";
  
  /**
   *	LossQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer lossQuantity;
  
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
   *	ReceiptID数据库列名
   */
  public final static java.lang.String RECEIPTID_FIELD =  "ReceiptID";
  
  /**
   *	ReceiptID字段中文名，用于视图展示
   */
  public final static java.lang.String RECEIPTID_LABLE = "单据编号";
  
  /**
   *	ReceiptID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long receiptID;
  
  /**
   *	RemainingFloatQuantity数据库列名
   */
  public final static java.lang.String REMAININGFLOATQUANTITY_FIELD =  "RemainingFloatQuantity";
  
  /**
   *	RemainingFloatQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String REMAININGFLOATQUANTITY_LABLE = "剩余小数";
  
  /**
   *	RemainingFloatQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float remainingFloatQuantity;
  
  /**
   *	RemainingQuantity数据库列名
   */
  public final static java.lang.String REMAININGQUANTITY_FIELD =  "RemainingQuantity";
  
  /**
   *	RemainingQuantity字段中文名，用于视图展示
   */
  public final static java.lang.String REMAININGQUANTITY_LABLE = "剩余数量";
  
  /**
   *	RemainingQuantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer remainingQuantity;
  
  /**
   *	ShelfID数据库列名
   */
  public final static java.lang.String SHELFID_FIELD =  "ShelfID";
  
  /**
   *	ShelfID字段中文名，用于视图展示
   */
  public final static java.lang.String SHELFID_LABLE = "货架编号";
  
  /**
   *	ShelfID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long shelfID;
  
  /**
   *	StoreDay数据库列名
   */
  public final static java.lang.String STOREDAY_FIELD =  "StoreDay";
  
  /**
   *	StoreDay字段中文名，用于视图展示
   */
  public final static java.lang.String STOREDAY_LABLE = "沽清日期";
  
  /**
   *	StoreDay对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime storeDay;
  
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
   *	WarehouseID数据库列名
   */
  public final static java.lang.String WAREHOUSEID_FIELD =  "WarehouseID";
  
  /**
   *	WarehouseID字段中文名，用于视图展示
   */
  public final static java.lang.String WAREHOUSEID_LABLE = "仓库编号";
  
  /**
   *	WarehouseID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long warehouseID;
  
  /**
   * 小数可用 getter
   */
  public java.lang.Float getAvailableFloatQuantity(){
    return availableFloatQuantity;
  }
  /**
   * 小数可用 setter
   * @param AvailableFloatQuantity
   */  
  public void setAvailableFloatQuantity(java.lang.Float availableFloatQuantity){
    this.availableFloatQuantity = availableFloatQuantity;
  }
 
  /**
   * 可用数量 getter
   */
  public java.lang.Integer getAvailableQuantity(){
    return availableQuantity;
  }
  /**
   * 可用数量 setter
   * @param AvailableQuantity
   */  
  public void setAvailableQuantity(java.lang.Integer availableQuantity){
    this.availableQuantity = availableQuantity;
  }
 
  /**
   * 调整小数 getter
   */
  public java.lang.Float getChangeInitFloatQuantity(){
    return changeInitFloatQuantity;
  }
  /**
   * 调整小数 setter
   * @param ChangeInitFloatQuantity
   */  
  public void setChangeInitFloatQuantity(java.lang.Float changeInitFloatQuantity){
    this.changeInitFloatQuantity = changeInitFloatQuantity;
  }
 
  /**
   * 调整数量 getter
   */
  public java.lang.Integer getChangeInitQuantity(){
    return changeInitQuantity;
  }
  /**
   * 调整数量 setter
   * @param ChangeInitQuantity
   */  
  public void setChangeInitQuantity(java.lang.Integer changeInitQuantity){
    this.changeInitQuantity = changeInitQuantity;
  }
 
  /**
   * 配置原因 getter
   */
  public java.lang.Long getConfigReason(){
    return configReason;
  }
  /**
   * 配置原因 setter
   * @param ConfigReason
   */  
  public void setConfigReason(java.lang.Long configReason){
    this.configReason = configReason;
  }
 
  /**
   * 货柜编号 getter
   */
  public java.lang.Long getContainerID(){
    return containerID;
  }
  /**
   * 货柜编号 setter
   * @param ContainerID
   */  
  public void setContainerID(java.lang.Long containerID){
    this.containerID = containerID;
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
   * 历史编号 getter
   */
  public java.lang.Long getHisID(){
    return hisID;
  }
  /**
   * 历史编号 setter
   * @param HisID
   */  
  public void setHisID(java.lang.Long hisID){
    this.hisID = hisID;
  }
 
  /**
   * 小数数量 getter
   */
  public java.lang.Float getInitFloatQuantity(){
    return initFloatQuantity;
  }
  /**
   * 小数数量 setter
   * @param InitFloatQuantity
   */  
  public void setInitFloatQuantity(java.lang.Float initFloatQuantity){
    this.initFloatQuantity = initFloatQuantity;
  }
 
  /**
   * 初始数量 getter
   */
  public java.lang.Integer getInitQuantity(){
    return initQuantity;
  }
  /**
   * 初始数量 setter
   * @param InitQuantity
   */  
  public void setInitQuantity(java.lang.Integer initQuantity){
    this.initQuantity = initQuantity;
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
   * 是否总量 getter
   */
  public java.lang.Boolean getIsTotal(){
    return isTotal;
  }
  /**
   * 是否总量 setter
   * @param isTotal
   */  
  public void setIsTotal(java.lang.Boolean isTotal){
    this.isTotal = isTotal;
  }
 
  /**
   * 小数锁定 getter
   */
  public java.lang.Float getLockFloatQuantity(){
    return lockFloatQuantity;
  }
  /**
   * 小数锁定 setter
   * @param LockFloatQuantity
   */  
  public void setLockFloatQuantity(java.lang.Float lockFloatQuantity){
    this.lockFloatQuantity = lockFloatQuantity;
  }
 
  /**
   * 锁定数量 getter
   */
  public java.lang.Integer getLockQuantity(){
    return lockQuantity;
  }
  /**
   * 锁定数量 setter
   * @param LockQuantity
   */  
  public void setLockQuantity(java.lang.Integer lockQuantity){
    this.lockQuantity = lockQuantity;
  }
 
  /**
   * 小数损耗 getter
   */
  public java.lang.Float getLossFloatQuantity(){
    return lossFloatQuantity;
  }
  /**
   * 小数损耗 setter
   * @param LossFloatQuantity
   */  
  public void setLossFloatQuantity(java.lang.Float lossFloatQuantity){
    this.lossFloatQuantity = lossFloatQuantity;
  }
 
  /**
   * 损耗数量 getter
   */
  public java.lang.Integer getLossQuantity(){
    return lossQuantity;
  }
  /**
   * 损耗数量 setter
   * @param LossQuantity
   */  
  public void setLossQuantity(java.lang.Integer lossQuantity){
    this.lossQuantity = lossQuantity;
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
   * 单据编号 getter
   */
  public java.lang.Long getReceiptID(){
    return receiptID;
  }
  /**
   * 单据编号 setter
   * @param ReceiptID
   */  
  public void setReceiptID(java.lang.Long receiptID){
    this.receiptID = receiptID;
  }
 
  /**
   * 剩余小数 getter
   */
  public java.lang.Float getRemainingFloatQuantity(){
    return remainingFloatQuantity;
  }
  /**
   * 剩余小数 setter
   * @param RemainingFloatQuantity
   */  
  public void setRemainingFloatQuantity(java.lang.Float remainingFloatQuantity){
    this.remainingFloatQuantity = remainingFloatQuantity;
  }
 
  /**
   * 剩余数量 getter
   */
  public java.lang.Integer getRemainingQuantity(){
    return remainingQuantity;
  }
  /**
   * 剩余数量 setter
   * @param RemainingQuantity
   */  
  public void setRemainingQuantity(java.lang.Integer remainingQuantity){
    this.remainingQuantity = remainingQuantity;
  }
 
  /**
   * 货架编号 getter
   */
  public java.lang.Long getShelfID(){
    return shelfID;
  }
  /**
   * 货架编号 setter
   * @param ShelfID
   */  
  public void setShelfID(java.lang.Long shelfID){
    this.shelfID = shelfID;
  }
 
  /**
   * 沽清日期 getter
   */
  public java.time.LocalDateTime getStoreDay(){
    return storeDay;
  }
  /**
   * 沽清日期 setter
   * @param StoreDay
   */  
  public void setStoreDay(java.time.LocalDateTime storeDay){
    this.storeDay = storeDay;
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
   * 仓库编号 getter
   */
  public java.lang.Long getWarehouseID(){
    return warehouseID;
  }
  /**
   * 仓库编号 setter
   * @param WarehouseID
   */  
  public void setWarehouseID(java.lang.Long warehouseID){
    this.warehouseID = warehouseID;
  }
 
}