package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_DesingerProduceDealInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_DesingerProduceDealInfoEntityBase extends Entity {

  /**
   *	AfterStatus数据库列名
   */
  public final static java.lang.String AFTERSTATUS_FIELD =  "AfterStatus";
  
  /**
   *	AfterStatus字段中文名，用于视图展示
   */
  public final static java.lang.String AFTERSTATUS_LABLE = "变动后状态";
  
  /**
   *	AfterStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long afterStatus;
  
  /**
   *	BeforeStatus数据库列名
   */
  public final static java.lang.String BEFORESTATUS_FIELD =  "BeforeStatus";
  
  /**
   *	BeforeStatus字段中文名，用于视图展示
   */
  public final static java.lang.String BEFORESTATUS_LABLE = "变动前状态";
  
  /**
   *	BeforeStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long beforeStatus;
  
  /**
   *	CerateTime数据库列名
   */
  public final static java.lang.String CERATETIME_FIELD =  "CerateTime";
  
  /**
   *	CerateTime字段中文名，用于视图展示
   */
  public final static java.lang.String CERATETIME_LABLE = "处理时间";
  
  /**
   *	CerateTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime cerateTime;
  
  /**
   *	ChangeDetail数据库列名
   */
  public final static java.lang.String CHANGEDETAIL_FIELD =  "ChangeDetail";
  
  /**
   *	ChangeDetail字段中文名，用于视图展示
   */
  public final static java.lang.String CHANGEDETAIL_LABLE = "变动内容";
  
  /**
   *	ChangeDetail对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String changeDetail;
  
  /**
   *	CreatorID数据库列名
   */
  public final static java.lang.String CREATORID_FIELD =  "CreatorID";
  
  /**
   *	CreatorID字段中文名，用于视图展示
   */
  public final static java.lang.String CREATORID_LABLE = "处理人";
  
  /**
   *	CreatorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long creatorID;
  
  /**
   *	DealDesc数据库列名
   */
  public final static java.lang.String DEALDESC_FIELD =  "DealDesc";
  
  /**
   *	DealDesc字段中文名，用于视图展示
   */
  public final static java.lang.String DEALDESC_LABLE = "处理描述";
  
  /**
   *	DealDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String dealDesc;
  
  /**
   *	DealID数据库列名
   */
  public final static java.lang.String DEALID_FIELD =  "DealID";
  
  /**
   *	DealID字段中文名，用于视图展示
   */
  public final static java.lang.String DEALID_LABLE = "处理编号";
  
  /**
   *	DealID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long dealID;
  
  /**
   *	DealType数据库列名
   */
  public final static java.lang.String DEALTYPE_FIELD =  "DealType";
  
  /**
   *	DealType字段中文名，用于视图展示
   */
  public final static java.lang.String DEALTYPE_LABLE = "处理类型";
  
  /**
   *	DealType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long dealType;
  
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
   * 变动后状态 getter
   */
  public java.lang.Long getAfterStatus(){
    return afterStatus;
  }
  /**
   * 变动后状态 setter
   * @param AfterStatus
   */  
  public void setAfterStatus(java.lang.Long afterStatus){
    this.afterStatus = afterStatus;
  }
 
  /**
   * 变动前状态 getter
   */
  public java.lang.Long getBeforeStatus(){
    return beforeStatus;
  }
  /**
   * 变动前状态 setter
   * @param BeforeStatus
   */  
  public void setBeforeStatus(java.lang.Long beforeStatus){
    this.beforeStatus = beforeStatus;
  }
 
  /**
   * 处理时间 getter
   */
  public java.time.LocalDateTime getCerateTime(){
    return cerateTime;
  }
  /**
   * 处理时间 setter
   * @param CerateTime
   */  
  public void setCerateTime(java.time.LocalDateTime cerateTime){
    this.cerateTime = cerateTime;
  }
 
  /**
   * 变动内容 getter
   */
  public java.lang.String getChangeDetail(){
    return changeDetail;
  }
  /**
   * 变动内容 setter
   * @param ChangeDetail
   */  
  public void setChangeDetail(java.lang.String changeDetail){
    this.changeDetail = changeDetail;
  }
 
  /**
   * 处理人 getter
   */
  public java.lang.Long getCreatorID(){
    return creatorID;
  }
  /**
   * 处理人 setter
   * @param CreatorID
   */  
  public void setCreatorID(java.lang.Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * 处理描述 getter
   */
  public java.lang.String getDealDesc(){
    return dealDesc;
  }
  /**
   * 处理描述 setter
   * @param DealDesc
   */  
  public void setDealDesc(java.lang.String dealDesc){
    this.dealDesc = dealDesc;
  }
 
  /**
   * 处理编号 getter
   */
  public java.lang.Long getDealID(){
    return dealID;
  }
  /**
   * 处理编号 setter
   * @param DealID
   */  
  public void setDealID(java.lang.Long dealID){
    this.dealID = dealID;
  }
 
  /**
   * 处理类型 getter
   */
  public java.lang.Long getDealType(){
    return dealType;
  }
  /**
   * 处理类型 setter
   * @param DealType
   */  
  public void setDealType(java.lang.Long dealType){
    this.dealType = dealType;
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
 
}