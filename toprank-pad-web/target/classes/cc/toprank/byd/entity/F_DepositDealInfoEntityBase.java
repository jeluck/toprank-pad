package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在F_DepositDealInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class F_DepositDealInfoEntityBase extends Entity {

  /**
   *	AfterStatus数据库列名
   */
  public final static String AFTERSTATUS_FIELD =  "AfterStatus";
  
  /**
   *	AfterStatus字段中文名，用于视图展示
   */
  public final static String AFTERSTATUS_LABLE = "处理后状态";
  
  /**
   *	AfterStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long afterStatus;
  
  /**
   *	BeforeStatus数据库列名
   */
  public final static String BEFORESTATUS_FIELD =  "BeforeStatus";
  
  /**
   *	BeforeStatus字段中文名，用于视图展示
   */
  public final static String BEFORESTATUS_LABLE = "处理前状态";
  
  /**
   *	BeforeStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long beforeStatus;
  
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
  public final static String CREATORID_LABLE = "处理人编号";
  
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
  public final static String CREATORTYPE_LABLE = "处理人类别";
  
  /**
   *	CreatorType对应的java字段名,业务操作使用这个字段。
   */
  private Long creatorType;
  
  /**
   *	DealCode数据库列名
   */
  public final static String DEALCODE_FIELD =  "DealCode";
  
  /**
   *	DealCode字段中文名，用于视图展示
   */
  public final static String DEALCODE_LABLE = "处理编码";
  
  /**
   *	DealCode对应的java字段名,业务操作使用这个字段。
   */
  private String dealCode;
  
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
   *	DepositID数据库列名
   */
  public final static String DEPOSITID_FIELD =  "DepositID";
  
  /**
   *	DepositID字段中文名，用于视图展示
   */
  public final static String DEPOSITID_LABLE = "充值编号";
  
  /**
   *	DepositID对应的java字段名,业务操作使用这个字段。
   */
  private Long depositID;
  
  /**
   *	IsRelationPlatform数据库列名
   */
  public final static String ISRELATIONPLATFORM_FIELD =  "IsRelationPlatform";
  
  /**
   *	IsRelationPlatform字段中文名，用于视图展示
   */
  public final static String ISRELATIONPLATFORM_LABLE = "关联托管平台";
  
  /**
   *	IsRelationPlatform对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isRelationPlatform;
  
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
   *	PlatformID数据库列名
   */
  public final static String PLATFORMID_FIELD =  "PlatformID";
  
  /**
   *	PlatformID字段中文名，用于视图展示
   */
  public final static String PLATFORMID_LABLE = "托管平台编号";
  
  /**
   *	PlatformID对应的java字段名,业务操作使用这个字段。
   */
  private Long platformID;
  
  /**
   *	PlatformStatus数据库列名
   */
  public final static String PLATFORMSTATUS_FIELD =  "PlatformStatus";
  
  /**
   *	PlatformStatus字段中文名，用于视图展示
   */
  public final static String PLATFORMSTATUS_LABLE = "平台返回状态";
  
  /**
   *	PlatformStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long platformStatus;
  
  /**
   *	PlatformTypeID数据库列名
   */
  public final static String PLATFORMTYPEID_FIELD =  "PlatformTypeID";
  
  /**
   *	PlatformTypeID字段中文名，用于视图展示
   */
  public final static String PLATFORMTYPEID_LABLE = "托管平台类别";
  
  /**
   *	PlatformTypeID对应的java字段名,业务操作使用这个字段。
   */
  private Long platformTypeID;
  
  /**
   *	RequestData数据库列名
   */
  public final static String REQUESTDATA_FIELD =  "RequestData";
  
  /**
   *	RequestData字段中文名，用于视图展示
   */
  public final static String REQUESTDATA_LABLE = "平台请求数据";
  
  /**
   *	RequestData对应的java字段名,业务操作使用这个字段。
   */
  private String requestData;
  
  /**
   *	ResponseData数据库列名
   */
  public final static String RESPONSEDATA_FIELD =  "ResponseData";
  
  /**
   *	ResponseData字段中文名，用于视图展示
   */
  public final static String RESPONSEDATA_LABLE = "平台返馈数据";
  
  /**
   *	ResponseData对应的java字段名,业务操作使用这个字段。
   */
  private String responseData;
  
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
   * 处理后状态 getter
   */
  public Long getAfterStatus(){
    return afterStatus;
  }
  /**
   * 处理后状态 setter
   * @param AfterStatus
   */  
  public void setAfterStatus(Long afterStatus){
    this.afterStatus = afterStatus;
  }
 
  /**
   * 处理前状态 getter
   */
  public Long getBeforeStatus(){
    return beforeStatus;
  }
  /**
   * 处理前状态 setter
   * @param BeforeStatus
   */  
  public void setBeforeStatus(Long beforeStatus){
    this.beforeStatus = beforeStatus;
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
   * 处理人编号 getter
   */
  public Long getCreatorID(){
    return creatorID;
  }
  /**
   * 处理人编号 setter
   * @param CreatorID
   */  
  public void setCreatorID(Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * 处理人类别 getter
   */
  public Long getCreatorType(){
    return creatorType;
  }
  /**
   * 处理人类别 setter
   * @param CreatorType
   */  
  public void setCreatorType(Long creatorType){
    this.creatorType = creatorType;
  }
 
  /**
   * 处理编码 getter
   */
  public String getDealCode(){
    return dealCode;
  }
  /**
   * 处理编码 setter
   * @param DealCode
   */  
  public void setDealCode(String dealCode){
    this.dealCode = dealCode;
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
   * 充值编号 getter
   */
  public Long getDepositID(){
    return depositID;
  }
  /**
   * 充值编号 setter
   * @param DepositID
   */  
  public void setDepositID(Long depositID){
    this.depositID = depositID;
  }
 
  /**
   * 关联托管平台 getter
   */
  public Boolean getIsRelationPlatform(){
    return isRelationPlatform;
  }
  /**
   * 关联托管平台 setter
   * @param IsRelationPlatform
   */  
  public void setIsRelationPlatform(Boolean isRelationPlatform){
    this.isRelationPlatform = isRelationPlatform;
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
   * 托管平台编号 getter
   */
  public Long getPlatformID(){
    return platformID;
  }
  /**
   * 托管平台编号 setter
   * @param PlatformID
   */  
  public void setPlatformID(Long platformID){
    this.platformID = platformID;
  }
 
  /**
   * 平台返回状态 getter
   */
  public Long getPlatformStatus(){
    return platformStatus;
  }
  /**
   * 平台返回状态 setter
   * @param PlatformStatus
   */  
  public void setPlatformStatus(Long platformStatus){
    this.platformStatus = platformStatus;
  }
 
  /**
   * 托管平台类别 getter
   */
  public Long getPlatformTypeID(){
    return platformTypeID;
  }
  /**
   * 托管平台类别 setter
   * @param PlatformTypeID
   */  
  public void setPlatformTypeID(Long platformTypeID){
    this.platformTypeID = platformTypeID;
  }
 
  /**
   * 平台请求数据 getter
   */
  public String getRequestData(){
    return requestData;
  }
  /**
   * 平台请求数据 setter
   * @param RequestData
   */  
  public void setRequestData(String requestData){
    this.requestData = requestData;
  }
 
  /**
   * 平台返馈数据 getter
   */
  public String getResponseData(){
    return responseData;
  }
  /**
   * 平台返馈数据 setter
   * @param ResponseData
   */  
  public void setResponseData(String responseData){
    this.responseData = responseData;
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