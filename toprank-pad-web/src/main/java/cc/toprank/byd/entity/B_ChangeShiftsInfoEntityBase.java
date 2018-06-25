package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_ChangeShiftsInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_ChangeShiftsInfoEntityBase extends Entity {

  /**
   *	AfterLoginID数据库列名
   */
  public final static String AFTERLOGINID_FIELD =  "AfterLoginID";
  
  /**
   *	AfterLoginID字段中文名，用于视图展示
   */
  public final static String AFTERLOGINID_LABLE = "调班后人";
  
  /**
   *	AfterLoginID对应的java字段名,业务操作使用这个字段。
   */
  private Long afterLoginID;
  
  /**
   *	Approver数据库列名
   */
  public final static String APPROVER_FIELD =  "Approver";
  
  /**
   *	Approver字段中文名，用于视图展示
   */
  public final static String APPROVER_LABLE = "审批人";
  
  /**
   *	Approver对应的java字段名,业务操作使用这个字段。
   */
  private Long approver;
  
  /**
   *	ApproveTime数据库列名
   */
  public final static String APPROVETIME_FIELD =  "ApproveTime";
  
  /**
   *	ApproveTime字段中文名，用于视图展示
   */
  public final static String APPROVETIME_LABLE = "审批时间";
  
  /**
   *	ApproveTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime approveTime;
  
  /**
   *	BeforeLoginID数据库列名
   */
  public final static String BEFORELOGINID_FIELD =  "BeforeLoginID";
  
  /**
   *	BeforeLoginID字段中文名，用于视图展示
   */
  public final static String BEFORELOGINID_LABLE = "调班前人";
  
  /**
   *	BeforeLoginID对应的java字段名,业务操作使用这个字段。
   */
  private Long beforeLoginID;
  
  /**
   *	ChangeCode数据库列名
   */
  public final static String CHANGECODE_FIELD =  "ChangeCode";
  
  /**
   *	ChangeCode字段中文名，用于视图展示
   */
  public final static String CHANGECODE_LABLE = "调班编码";
  
  /**
   *	ChangeCode对应的java字段名,业务操作使用这个字段。
   */
  private String changeCode;
  
  /**
   *	ChangeID数据库列名
   */
  public final static String CHANGEID_FIELD =  "ChangeID";
  
  /**
   *	ChangeID字段中文名，用于视图展示
   */
  public final static String CHANGEID_LABLE = "调班编号";
  
  /**
   *	ChangeID对应的java字段名,业务操作使用这个字段。
   */
  private Long changeID;
  
  /**
   *	ChangeReason数据库列名
   */
  public final static String CHANGEREASON_FIELD =  "ChangeReason";
  
  /**
   *	ChangeReason字段中文名，用于视图展示
   */
  public final static String CHANGEREASON_LABLE = "调班原因";
  
  /**
   *	ChangeReason对应的java字段名,业务操作使用这个字段。
   */
  private Long changeReason;
  
  /**
   *	ConfigID数据库列名
   */
  public final static String CONFIGID_FIELD =  "ConfigID";
  
  /**
   *	ConfigID字段中文名，用于视图展示
   */
  public final static String CONFIGID_LABLE = "配置编号";
  
  /**
   *	ConfigID对应的java字段名,业务操作使用这个字段。
   */
  private Long configID;
  
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
   *	DealDesc数据库列名
   */
  public final static String DEALDESC_FIELD =  "DealDesc";
  
  /**
   *	DealDesc字段中文名，用于视图展示
   */
  public final static String DEALDESC_LABLE = "调班描述";
  
  /**
   *	DealDesc对应的java字段名,业务操作使用这个字段。
   */
  private String dealDesc;
  
  /**
   *	DutyID数据库列名
   */
  public final static String DUTYID_FIELD =  "DutyID";
  
  /**
   *	DutyID字段中文名，用于视图展示
   */
  public final static String DUTYID_LABLE = "排班编号";
  
  /**
   *	DutyID对应的java字段名,业务操作使用这个字段。
   */
  private Long dutyID;
  
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
   * 调班后人 getter
   */
  public Long getAfterLoginID(){
    return afterLoginID;
  }
  /**
   * 调班后人 setter
   * @param AfterLoginID
   */  
  public void setAfterLoginID(Long afterLoginID){
    this.afterLoginID = afterLoginID;
  }
 
  /**
   * 审批人 getter
   */
  public Long getApprover(){
    return approver;
  }
  /**
   * 审批人 setter
   * @param Approver
   */  
  public void setApprover(Long approver){
    this.approver = approver;
  }
 
  /**
   * 审批时间 getter
   */
  public java.time.LocalDateTime getApproveTime(){
    return approveTime;
  }
  /**
   * 审批时间 setter
   * @param ApproveTime
   */  
  public void setApproveTime(java.time.LocalDateTime approveTime){
    this.approveTime = approveTime;
  }
 
  /**
   * 调班前人 getter
   */
  public Long getBeforeLoginID(){
    return beforeLoginID;
  }
  /**
   * 调班前人 setter
   * @param BeforeLoginID
   */  
  public void setBeforeLoginID(Long beforeLoginID){
    this.beforeLoginID = beforeLoginID;
  }
 
  /**
   * 调班编码 getter
   */
  public String getChangeCode(){
    return changeCode;
  }
  /**
   * 调班编码 setter
   * @param ChangeCode
   */  
  public void setChangeCode(String changeCode){
    this.changeCode = changeCode;
  }
 
  /**
   * 调班编号 getter
   */
  public Long getChangeID(){
    return changeID;
  }
  /**
   * 调班编号 setter
   * @param ChangeID
   */  
  public void setChangeID(Long changeID){
    this.changeID = changeID;
  }
 
  /**
   * 调班原因 getter
   */
  public Long getChangeReason(){
    return changeReason;
  }
  /**
   * 调班原因 setter
   * @param ChangeReason
   */  
  public void setChangeReason(Long changeReason){
    this.changeReason = changeReason;
  }
 
  /**
   * 配置编号 getter
   */
  public Long getConfigID(){
    return configID;
  }
  /**
   * 配置编号 setter
   * @param ConfigID
   */  
  public void setConfigID(Long configID){
    this.configID = configID;
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
  public Long getCreatorID(){
    return creatorID;
  }
  /**
   * 创建人 setter
   * @param CreatorID
   */  
  public void setCreatorID(Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * 调班描述 getter
   */
  public String getDealDesc(){
    return dealDesc;
  }
  /**
   * 调班描述 setter
   * @param DealDesc
   */  
  public void setDealDesc(String dealDesc){
    this.dealDesc = dealDesc;
  }
 
  /**
   * 排班编号 getter
   */
  public Long getDutyID(){
    return dutyID;
  }
  /**
   * 排班编号 setter
   * @param DutyID
   */  
  public void setDutyID(Long dutyID){
    this.dutyID = dutyID;
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
 
}