package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_OrderRelationDetailInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_OrderRelationDetailInfoEntityBase extends Entity {

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
   *	SyncTime数据库列名
   */
  public final static java.lang.String SYNCTIME_FIELD =  "SyncTime";
  
  /**
   *	SyncTime字段中文名，用于视图展示
   */
  public final static java.lang.String SYNCTIME_LABLE = "SyncTime";
  
  /**
   *	SyncTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTime;
  
  /**
   *	SyncTimeResult数据库列名
   */
  public final static java.lang.String SYNCTIMERESULT_FIELD =  "SyncTimeResult";
  
  /**
   *	SyncTimeResult字段中文名，用于视图展示
   */
  public final static java.lang.String SYNCTIMERESULT_LABLE = "SyncTimeResult";
  
  /**
   *	SyncTimeResult对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime syncTimeResult;
  
  /**
   *	TargetAmount数据库列名
   */
  public final static java.lang.String TARGETAMOUNT_FIELD =  "TargetAmount";
  
  /**
   *	TargetAmount字段中文名，用于视图展示
   */
  public final static java.lang.String TARGETAMOUNT_LABLE = "接受订单金额";
  
  /**
   *	TargetAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal targetAmount;
  
  /**
   *	TargetID数据库列名
   */
  public final static java.lang.String TARGETID_FIELD =  "TargetID";
  
  /**
   *	TargetID字段中文名，用于视图展示
   */
  public final static java.lang.String TARGETID_LABLE = "接受编号";
  
  /**
   *	TargetID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long targetID;
  
  /**
   *	TargetIsOrder数据库列名
   */
  public final static java.lang.String TARGETISORDER_FIELD =  "TargetIsOrder";
  
  /**
   *	TargetIsOrder字段中文名，用于视图展示
   */
  public final static java.lang.String TARGETISORDER_LABLE = "是否订单";
  
  /**
   *	TargetIsOrder对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Boolean targetIsOrder;
  
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
   * SyncTime getter
   */
  public java.time.LocalDateTime getSyncTime(){
    return syncTime;
  }
  /**
   * SyncTime setter
   * @param SyncTime
   */  
  public void setSyncTime(java.time.LocalDateTime syncTime){
    this.syncTime = syncTime;
  }
 
  /**
   * SyncTimeResult getter
   */
  public java.time.LocalDateTime getSyncTimeResult(){
    return syncTimeResult;
  }
  /**
   * SyncTimeResult setter
   * @param SyncTimeResult
   */  
  public void setSyncTimeResult(java.time.LocalDateTime syncTimeResult){
    this.syncTimeResult = syncTimeResult;
  }
 
  /**
   * 接受订单金额 getter
   */
  public java.math.BigDecimal getTargetAmount(){
    return targetAmount;
  }
  /**
   * 接受订单金额 setter
   * @param TargetAmount
   */  
  public void setTargetAmount(java.math.BigDecimal targetAmount){
    this.targetAmount = targetAmount;
  }
 
  /**
   * 接受编号 getter
   */
  public java.lang.Long getTargetID(){
    return targetID;
  }
  /**
   * 接受编号 setter
   * @param TargetID
   */  
  public void setTargetID(java.lang.Long targetID){
    this.targetID = targetID;
  }
 
  /**
   * 是否订单 getter
   */
  public java.lang.Boolean getTargetIsOrder(){
    return targetIsOrder;
  }
  /**
   * 是否订单 setter
   * @param TargetIsOrder
   */  
  public void setTargetIsOrder(java.lang.Boolean targetIsOrder){
    this.targetIsOrder = targetIsOrder;
  }
 
}