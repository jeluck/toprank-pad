package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_StallWeighDealInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_StallWeighDealInfoEntityBase extends Entity {

  /**
   *	AfterStatus数据库列名
   */
  public final static String AFTERSTATUS_FIELD =  "AfterStatus";
  
  /**
   *	AfterStatus字段中文名，用于视图展示
   */
  public final static String AFTERSTATUS_LABLE = "变动后状态";
  
  /**
   *	AfterStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long afterStatus;
  
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
   *	BeforeStatus数据库列名
   */
  public final static String BEFORESTATUS_FIELD =  "BeforeStatus";
  
  /**
   *	BeforeStatus字段中文名，用于视图展示
   */
  public final static String BEFORESTATUS_LABLE = "变动前状态";
  
  /**
   *	BeforeStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long beforeStatus;
  
  /**
   *	CerateTime数据库列名
   */
  public final static String CERATETIME_FIELD =  "CerateTime";
  
  /**
   *	CerateTime字段中文名，用于视图展示
   */
  public final static String CERATETIME_LABLE = "处理时间";
  
  /**
   *	CerateTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime cerateTime;
  
  /**
   *	ChangeDetail数据库列名
   */
  public final static String CHANGEDETAIL_FIELD =  "ChangeDetail";
  
  /**
   *	ChangeDetail字段中文名，用于视图展示
   */
  public final static String CHANGEDETAIL_LABLE = "变动内容";
  
  /**
   *	ChangeDetail对应的java字段名,业务操作使用这个字段。
   */
  private String changeDetail;
  
  /**
   *	CreatorID数据库列名
   */
  public final static String CREATORID_FIELD =  "CreatorID";
  
  /**
   *	CreatorID字段中文名，用于视图展示
   */
  public final static String CREATORID_LABLE = "处理人";
  
  /**
   *	CreatorID对应的java字段名,业务操作使用这个字段。
   */
  private Long creatorID;
  
  /**
   *	DealDesc数据库列名
   */
  public final static String DEALDESC_FIELD =  "DealDesc";
  
  /**
   *	DealDesc字段中文名，用于视图展示
   */
  public final static String DEALDESC_LABLE = "处理描述";
  
  /**
   *	DealDesc对应的java字段名,业务操作使用这个字段。
   */
  private String dealDesc;
  
  /**
   *	DealID数据库列名
   */
  public final static String DEALID_FIELD =  "DealID";
  
  /**
   *	DealID字段中文名，用于视图展示
   */
  public final static String DEALID_LABLE = "处理编号";
  
  /**
   *	DealID对应的java字段名,业务操作使用这个字段。
   */
  private Long dealID;
  
  /**
   *	DealType数据库列名
   */
  public final static String DEALTYPE_FIELD =  "DealType";
  
  /**
   *	DealType字段中文名，用于视图展示
   */
  public final static String DEALTYPE_LABLE = "处理类型";
  
  /**
   *	DealType对应的java字段名,业务操作使用这个字段。
   */
  private Long dealType;
  
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
   * 变动后状态 getter
   */
  public Long getAfterStatus(){
    return afterStatus;
  }
  /**
   * 变动后状态 setter
   * @param AfterStatus
   */  
  public void setAfterStatus(Long afterStatus){
    this.afterStatus = afterStatus;
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
   * 变动前状态 getter
   */
  public Long getBeforeStatus(){
    return beforeStatus;
  }
  /**
   * 变动前状态 setter
   * @param BeforeStatus
   */  
  public void setBeforeStatus(Long beforeStatus){
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
  public String getChangeDetail(){
    return changeDetail;
  }
  /**
   * 变动内容 setter
   * @param ChangeDetail
   */  
  public void setChangeDetail(String changeDetail){
    this.changeDetail = changeDetail;
  }
 
  /**
   * 处理人 getter
   */
  public Long getCreatorID(){
    return creatorID;
  }
  /**
   * 处理人 setter
   * @param CreatorID
   */  
  public void setCreatorID(Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * 处理描述 getter
   */
  public String getDealDesc(){
    return dealDesc;
  }
  /**
   * 处理描述 setter
   * @param DealDesc
   */  
  public void setDealDesc(String dealDesc){
    this.dealDesc = dealDesc;
  }
 
  /**
   * 处理编号 getter
   */
  public Long getDealID(){
    return dealID;
  }
  /**
   * 处理编号 setter
   * @param DealID
   */  
  public void setDealID(Long dealID){
    this.dealID = dealID;
  }
 
  /**
   * 处理类型 getter
   */
  public Long getDealType(){
    return dealType;
  }
  /**
   * 处理类型 setter
   * @param DealType
   */  
  public void setDealType(Long dealType){
    this.dealType = dealType;
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
 
}