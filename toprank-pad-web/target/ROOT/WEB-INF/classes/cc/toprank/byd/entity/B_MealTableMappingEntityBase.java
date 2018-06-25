package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_MealTableMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_MealTableMappingEntityBase extends Entity {

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
   *	CustomerNumber数据库列名
   */
  public final static java.lang.String CUSTOMERNUMBER_FIELD =  "CustomerNumber";
  
  /**
   *	CustomerNumber字段中文名，用于视图展示
   */
  public final static java.lang.String CUSTOMERNUMBER_LABLE = "消费人数";
  
  /**
   *	CustomerNumber对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer customerNumber;
  
  /**
   *	IsBooking数据库列名
   */
  public final static java.lang.String ISBOOKING_FIELD =  "IsBooking";
  
  /**
   *	IsBooking字段中文名，用于视图展示
   */
  public final static java.lang.String ISBOOKING_LABLE = "是否预订";
  
  /**
   *	IsBooking对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isBooking;
  
  /**
   *	IsCombine数据库列名
   */
  public final static java.lang.String ISCOMBINE_FIELD =  "IsCombine";
  
  /**
   *	IsCombine字段中文名，用于视图展示
   */
  public final static java.lang.String ISCOMBINE_LABLE = "是否合台";
  
  /**
   *	IsCombine对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isCombine;
  
  /**
   *	IsSharing数据库列名
   */
  public final static java.lang.String ISSHARING_FIELD =  "IsSharing";
  
  /**
   *	IsSharing字段中文名，用于视图展示
   */
  public final static java.lang.String ISSHARING_LABLE = "是否拼桌";
  
  /**
   *	IsSharing对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isSharing;
  
  /**
   *	IsSplit数据库列名
   */
  public final static java.lang.String ISSPLIT_FIELD =  "IsSplit";
  
  /**
   *	IsSplit字段中文名，用于视图展示
   */
  public final static java.lang.String ISSPLIT_LABLE = "是否拆台";
  
  /**
   *	IsSplit对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean isSplit;
  
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
   *	MealsID数据库列名
   */
  public final static java.lang.String MEALSID_FIELD =  "MealsID";
  
  /**
   *	MealsID字段中文名，用于视图展示
   */
  public final static java.lang.String MEALSID_LABLE = "餐次编号";
  
  /**
   *	MealsID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mealsID;
  
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
   *	RecommendBookingTime数据库列名
   */
  public final static java.lang.String RECOMMENDBOOKINGTIME_FIELD =  "RecommendBookingTime";
  
  /**
   *	RecommendBookingTime字段中文名，用于视图展示
   */
  public final static java.lang.String RECOMMENDBOOKINGTIME_LABLE = "建议预订时间";
  
  /**
   *	RecommendBookingTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime recommendBookingTime;
  
  /**
   *	RelationTable数据库列名
   */
  public final static java.lang.String RELATIONTABLE_FIELD =  "RelationTable";
  
  /**
   *	RelationTable字段中文名，用于视图展示
   */
  public final static java.lang.String RELATIONTABLE_LABLE = "关联桌台";
  
  /**
   *	RelationTable对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String relationTable;
  
  /**
   *	SegmentID数据库列名
   */
  public final static java.lang.String SEGMENTID_FIELD =  "SegmentID";
  
  /**
   *	SegmentID字段中文名，用于视图展示
   */
  public final static java.lang.String SEGMENTID_LABLE = "关联编号";
  
  /**
   *	SegmentID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long segmentID;
  
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
   *	StartTime数据库列名
   */
  public final static java.lang.String STARTTIME_FIELD =  "StartTime";
  
  /**
   *	StartTime字段中文名，用于视图展示
   */
  public final static java.lang.String STARTTIME_LABLE = "开始时间";
  
  /**
   *	StartTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime startTime;
  
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
   * 消费人数 getter
   */
  public java.lang.Integer getCustomerNumber(){
    return customerNumber;
  }
  /**
   * 消费人数 setter
   * @param CustomerNumber
   */  
  public void setCustomerNumber(java.lang.Integer customerNumber){
    this.customerNumber = customerNumber;
  }
 
  /**
   * 是否预订 getter
   */
  public java.lang.Boolean getIsBooking(){
    return isBooking;
  }
  /**
   * 是否预订 setter
   * @param IsBooking
   */  
  public void setIsBooking(java.lang.Boolean isBooking){
    this.isBooking = isBooking;
  }
 
  /**
   * 是否合台 getter
   */
  public java.lang.Boolean getIsCombine(){
    return isCombine;
  }
  /**
   * 是否合台 setter
   * @param IsCombine
   */  
  public void setIsCombine(java.lang.Boolean isCombine){
    this.isCombine = isCombine;
  }
 
  /**
   * 是否拼桌 getter
   */
  public java.lang.Boolean getIsSharing(){
    return isSharing;
  }
  /**
   * 是否拼桌 setter
   * @param IsSharing
   */  
  public void setIsSharing(java.lang.Boolean isSharing){
    this.isSharing = isSharing;
  }
 
  /**
   * 是否拆台 getter
   */
  public java.lang.Boolean getIsSplit(){
    return isSplit;
  }
  /**
   * 是否拆台 setter
   * @param IsSplit
   */  
  public void setIsSplit(java.lang.Boolean isSplit){
    this.isSplit = isSplit;
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
   * 餐次编号 getter
   */
  public java.lang.Long getMealsID(){
    return mealsID;
  }
  /**
   * 餐次编号 setter
   * @param MealsID
   */  
  public void setMealsID(java.lang.Long mealsID){
    this.mealsID = mealsID;
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
   * 建议预订时间 getter
   */
  public java.time.LocalDateTime getRecommendBookingTime(){
    return recommendBookingTime;
  }
  /**
   * 建议预订时间 setter
   * @param RecommendBookingTime
   */  
  public void setRecommendBookingTime(java.time.LocalDateTime recommendBookingTime){
    this.recommendBookingTime = recommendBookingTime;
  }
 
  /**
   * 关联桌台 getter
   */
  public java.lang.String getRelationTable(){
    return relationTable;
  }
  /**
   * 关联桌台 setter
   * @param RelationTable
   */  
  public void setRelationTable(java.lang.String relationTable){
    this.relationTable = relationTable;
  }
 
  /**
   * 关联编号 getter
   */
  public java.lang.Long getSegmentID(){
    return segmentID;
  }
  /**
   * 关联编号 setter
   * @param SegmentID
   */  
  public void setSegmentID(java.lang.Long segmentID){
    this.segmentID = segmentID;
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
   * 开始时间 getter
   */
  public java.time.LocalDateTime getStartTime(){
    return startTime;
  }
  /**
   * 开始时间 setter
   * @param StartTime
   */  
  public void setStartTime(java.time.LocalDateTime startTime){
    this.startTime = startTime;
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
 
}