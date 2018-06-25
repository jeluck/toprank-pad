package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_DinningTableInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_DinningTableInfoEntityBase extends Entity {

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
   *	AreaID数据库列名
   */
  public final static java.lang.String AREAID_FIELD =  "AreaID";
  
  /**
   *	AreaID字段中文名，用于视图展示
   */
  public final static java.lang.String AREAID_LABLE = "区域编号";
  
  /**
   *	AreaID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long areaID;
  
  /**
   *	CanBooking数据库列名
   */
  public final static java.lang.String CANBOOKING_FIELD =  "CanBooking";
  
  /**
   *	CanBooking字段中文名，用于视图展示
   */
  public final static java.lang.String CANBOOKING_LABLE = "可否预订";
  
  /**
   *	CanBooking对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean canBooking;
  
  /**
   *	CanCombine数据库列名
   */
  public final static java.lang.String CANCOMBINE_FIELD =  "CanCombine";
  
  /**
   *	CanCombine字段中文名，用于视图展示
   */
  public final static java.lang.String CANCOMBINE_LABLE = "可否合台";
  
  /**
   *	CanCombine对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean canCombine;
  
  /**
   *	CanSharing数据库列名
   */
  public final static java.lang.String CANSHARING_FIELD =  "CanSharing";
  
  /**
   *	CanSharing字段中文名，用于视图展示
   */
  public final static java.lang.String CANSHARING_LABLE = "可否拼桌";
  
  /**
   *	CanSharing对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean canSharing;
  
  /**
   *	CanSplit数据库列名
   */
  public final static java.lang.String CANSPLIT_FIELD =  "CanSplit";
  
  /**
   *	CanSplit字段中文名，用于视图展示
   */
  public final static java.lang.String CANSPLIT_LABLE = "可否拆台";
  
  /**
   *	CanSplit对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean canSplit;
  
  /**
   *	CombineCode数据库列名
   */
  public final static java.lang.String COMBINECODE_FIELD =  "CombineCode";
  
  /**
   *	CombineCode字段中文名，用于视图展示
   */
  public final static java.lang.String COMBINECODE_LABLE = "合台编码";
  
  /**
   *	CombineCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String combineCode;
  
  /**
   *	CombineName数据库列名
   */
  public final static java.lang.String COMBINENAME_FIELD =  "CombineName";
  
  /**
   *	CombineName字段中文名，用于视图展示
   */
  public final static java.lang.String COMBINENAME_LABLE = "合台名称";
  
  /**
   *	CombineName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String combineName;
  
  /**
   *	CombineNumber数据库列名
   */
  public final static java.lang.String COMBINENUMBER_FIELD =  "CombineNumber";
  
  /**
   *	CombineNumber字段中文名，用于视图展示
   */
  public final static java.lang.String COMBINENUMBER_LABLE = "合台数量";
  
  /**
   *	CombineNumber对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer combineNumber;
  
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
   *	DefaultPerson数据库列名
   */
  public final static java.lang.String DEFAULTPERSON_FIELD =  "DefaultPerson";
  
  /**
   *	DefaultPerson字段中文名，用于视图展示
   */
  public final static java.lang.String DEFAULTPERSON_LABLE = "桌台人数";
  
  /**
   *	DefaultPerson对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer defaultPerson;
  
  /**
   *	HighestConsumption数据库列名
   */
  public final static java.lang.String HIGHESTCONSUMPTION_FIELD =  "HighestConsumption";
  
  /**
   *	HighestConsumption字段中文名，用于视图展示
   */
  public final static java.lang.String HIGHESTCONSUMPTION_LABLE = "最高消费";
  
  /**
   *	HighestConsumption对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal highestConsumption;
  
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
   *	MaxPerson数据库列名
   */
  public final static java.lang.String MAXPERSON_FIELD =  "MaxPerson";
  
  /**
   *	MaxPerson字段中文名，用于视图展示
   */
  public final static java.lang.String MAXPERSON_LABLE = "最大人数";
  
  /**
   *	MaxPerson对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer maxPerson;
  
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
   *	MinConsumption数据库列名
   */
  public final static java.lang.String MINCONSUMPTION_FIELD =  "MinConsumption";
  
  /**
   *	MinConsumption字段中文名，用于视图展示
   */
  public final static java.lang.String MINCONSUMPTION_LABLE = "最低消费";
  
  /**
   *	MinConsumption对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal minConsumption;
  
  /**
   *	MinPerson数据库列名
   */
  public final static java.lang.String MINPERSON_FIELD =  "MinPerson";
  
  /**
   *	MinPerson字段中文名，用于视图展示
   */
  public final static java.lang.String MINPERSON_LABLE = "最小人数";
  
  /**
   *	MinPerson对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer minPerson;
  
  /**
   *	QRCode数据库列名
   */
  public final static java.lang.String QRCODE_FIELD =  "QRCode";
  
  /**
   *	QRCode字段中文名，用于视图展示
   */
  public final static java.lang.String QRCODE_LABLE = "二维码";
  
  /**
   *	QRCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String qRCode;
  
  /**
   *	ShareCode数据库列名
   */
  public final static java.lang.String SHARECODE_FIELD =  "ShareCode";
  
  /**
   *	ShareCode字段中文名，用于视图展示
   */
  public final static java.lang.String SHARECODE_LABLE = "拼桌编码";
  
  /**
   *	ShareCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String shareCode;
  
  /**
   *	ShareNumber数据库列名
   */
  public final static java.lang.String SHARENUMBER_FIELD =  "ShareNumber";
  
  /**
   *	ShareNumber字段中文名，用于视图展示
   */
  public final static java.lang.String SHARENUMBER_LABLE = "拼桌数量";
  
  /**
   *	ShareNumber对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer shareNumber;
  
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
   *	SplitCode数据库列名
   */
  public final static java.lang.String SPLITCODE_FIELD =  "SplitCode";
  
  /**
   *	SplitCode字段中文名，用于视图展示
   */
  public final static java.lang.String SPLITCODE_LABLE = "拆台编码";
  
  /**
   *	SplitCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String splitCode;
  
  /**
   *	SplitNumber数据库列名
   */
  public final static java.lang.String SPLITNUMBER_FIELD =  "SplitNumber";
  
  /**
   *	SplitNumber字段中文名，用于视图展示
   */
  public final static java.lang.String SPLITNUMBER_LABLE = "拆台数量";
  
  /**
   *	SplitNumber对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer splitNumber;
  
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
   *	TableDesc数据库列名
   */
  public final static java.lang.String TABLEDESC_FIELD =  "TableDesc";
  
  /**
   *	TableDesc字段中文名，用于视图展示
   */
  public final static java.lang.String TABLEDESC_LABLE = "桌台描述";
  
  /**
   *	TableDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String tableDesc;
  
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
   *	TableStatus数据库列名
   */
  public final static java.lang.String TABLESTATUS_FIELD =  "TableStatus";
  
  /**
   *	TableStatus字段中文名，用于视图展示
   */
  public final static java.lang.String TABLESTATUS_LABLE = "桌台状态";
  
  /**
   *	TableStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long tableStatus;
  
  /**
   *	TypeID数据库列名
   */
  public final static java.lang.String TYPEID_FIELD =  "TypeID";
  
  /**
   *	TypeID字段中文名，用于视图展示
   */
  public final static java.lang.String TYPEID_LABLE = "类型编号";
  
  /**
   *	TypeID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long typeID;
  
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
   * 区域编号 getter
   */
  public java.lang.Long getAreaID(){
    return areaID;
  }
  /**
   * 区域编号 setter
   * @param AreaID
   */  
  public void setAreaID(java.lang.Long areaID){
    this.areaID = areaID;
  }
 
  /**
   * 可否预订 getter
   */
  public java.lang.Boolean getCanBooking(){
    return canBooking;
  }
  /**
   * 可否预订 setter
   * @param CanBooking
   */  
  public void setCanBooking(java.lang.Boolean canBooking){
    this.canBooking = canBooking;
  }
 
  /**
   * 可否合台 getter
   */
  public java.lang.Boolean getCanCombine(){
    return canCombine;
  }
  /**
   * 可否合台 setter
   * @param CanCombine
   */  
  public void setCanCombine(java.lang.Boolean canCombine){
    this.canCombine = canCombine;
  }
 
  /**
   * 可否拼桌 getter
   */
  public java.lang.Boolean getCanSharing(){
    return canSharing;
  }
  /**
   * 可否拼桌 setter
   * @param CanSharing
   */  
  public void setCanSharing(java.lang.Boolean canSharing){
    this.canSharing = canSharing;
  }
 
  /**
   * 可否拆台 getter
   */
  public java.lang.Boolean getCanSplit(){
    return canSplit;
  }
  /**
   * 可否拆台 setter
   * @param CanSplit
   */  
  public void setCanSplit(java.lang.Boolean canSplit){
    this.canSplit = canSplit;
  }
 
  /**
   * 合台编码 getter
   */
  public java.lang.String getCombineCode(){
    return combineCode;
  }
  /**
   * 合台编码 setter
   * @param CombineCode
   */  
  public void setCombineCode(java.lang.String combineCode){
    this.combineCode = combineCode;
  }
 
  /**
   * 合台名称 getter
   */
  public java.lang.String getCombineName(){
    return combineName;
  }
  /**
   * 合台名称 setter
   * @param CombineName
   */  
  public void setCombineName(java.lang.String combineName){
    this.combineName = combineName;
  }
 
  /**
   * 合台数量 getter
   */
  public java.lang.Integer getCombineNumber(){
    return combineNumber;
  }
  /**
   * 合台数量 setter
   * @param CombineNumber
   */  
  public void setCombineNumber(java.lang.Integer combineNumber){
    this.combineNumber = combineNumber;
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
   * 桌台人数 getter
   */
  public java.lang.Integer getDefaultPerson(){
    return defaultPerson;
  }
  /**
   * 桌台人数 setter
   * @param DefaultPerson
   */  
  public void setDefaultPerson(java.lang.Integer defaultPerson){
    this.defaultPerson = defaultPerson;
  }
 
  /**
   * 最高消费 getter
   */
  public java.math.BigDecimal getHighestConsumption(){
    return highestConsumption;
  }
  /**
   * 最高消费 setter
   * @param HighestConsumption
   */  
  public void setHighestConsumption(java.math.BigDecimal highestConsumption){
    this.highestConsumption = highestConsumption;
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
   * 最大人数 getter
   */
  public java.lang.Integer getMaxPerson(){
    return maxPerson;
  }
  /**
   * 最大人数 setter
   * @param MaxPerson
   */  
  public void setMaxPerson(java.lang.Integer maxPerson){
    this.maxPerson = maxPerson;
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
   * 最低消费 getter
   */
  public java.math.BigDecimal getMinConsumption(){
    return minConsumption;
  }
  /**
   * 最低消费 setter
   * @param MinConsumption
   */  
  public void setMinConsumption(java.math.BigDecimal minConsumption){
    this.minConsumption = minConsumption;
  }
 
  /**
   * 最小人数 getter
   */
  public java.lang.Integer getMinPerson(){
    return minPerson;
  }
  /**
   * 最小人数 setter
   * @param MinPerson
   */  
  public void setMinPerson(java.lang.Integer minPerson){
    this.minPerson = minPerson;
  }
 
  /**
   * 二维码 getter
   */
  public java.lang.String getQRCode(){
    return qRCode;
  }
  /**
   * 二维码 setter
   * @param QRCode
   */  
  public void setQRCode(java.lang.String qRCode){
    this.qRCode = qRCode;
  }
 
  /**
   * 拼桌编码 getter
   */
  public java.lang.String getShareCode(){
    return shareCode;
  }
  /**
   * 拼桌编码 setter
   * @param ShareCode
   */  
  public void setShareCode(java.lang.String shareCode){
    this.shareCode = shareCode;
  }
 
  /**
   * 拼桌数量 getter
   */
  public java.lang.Integer getShareNumber(){
    return shareNumber;
  }
  /**
   * 拼桌数量 setter
   * @param ShareNumber
   */  
  public void setShareNumber(java.lang.Integer shareNumber){
    this.shareNumber = shareNumber;
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
   * 拆台编码 getter
   */
  public java.lang.String getSplitCode(){
    return splitCode;
  }
  /**
   * 拆台编码 setter
   * @param SplitCode
   */  
  public void setSplitCode(java.lang.String splitCode){
    this.splitCode = splitCode;
  }
 
  /**
   * 拆台数量 getter
   */
  public java.lang.Integer getSplitNumber(){
    return splitNumber;
  }
  /**
   * 拆台数量 setter
   * @param SplitNumber
   */  
  public void setSplitNumber(java.lang.Integer splitNumber){
    this.splitNumber = splitNumber;
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
   * 桌台描述 getter
   */
  public java.lang.String getTableDesc(){
    return tableDesc;
  }
  /**
   * 桌台描述 setter
   * @param TableDesc
   */  
  public void setTableDesc(java.lang.String tableDesc){
    this.tableDesc = tableDesc;
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
   * 桌台状态 getter
   */
  public java.lang.Long getTableStatus(){
    return tableStatus;
  }
  /**
   * 桌台状态 setter
   * @param TableStatus
   */  
  public void setTableStatus(java.lang.Long tableStatus){
    this.tableStatus = tableStatus;
  }
 
  /**
   * 类型编号 getter
   */
  public java.lang.Long getTypeID(){
    return typeID;
  }
  /**
   * 类型编号 setter
   * @param TypeID
   */  
  public void setTypeID(java.lang.Long typeID){
    this.typeID = typeID;
  }
 
}