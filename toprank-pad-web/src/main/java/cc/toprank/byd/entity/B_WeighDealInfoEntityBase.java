package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_WeighDealInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_WeighDealInfoEntityBase extends Entity {

  /**
   *	AfterNum数据库列名
   */
  public final static String AFTERNUM_FIELD =  "AfterNum";
  
  /**
   *	AfterNum字段中文名，用于视图展示
   */
  public final static String AFTERNUM_LABLE = "处理后数量";
  
  /**
   *	AfterNum对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal afterNum;
  
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
   *	BeforeNum数据库列名
   */
  public final static String BEFORENUM_FIELD =  "BeforeNum";
  
  /**
   *	BeforeNum字段中文名，用于视图展示
   */
  public final static String BEFORENUM_LABLE = "处理前数量";
  
  /**
   *	BeforeNum对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal beforeNum;
  
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
   *	ChangeNum数据库列名
   */
  public final static String CHANGENUM_FIELD =  "ChangeNum";
  
  /**
   *	ChangeNum字段中文名，用于视图展示
   */
  public final static String CHANGENUM_LABLE = "变动数量";
  
  /**
   *	ChangeNum对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal changeNum;
  
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
   *	HisID数据库列名
   */
  public final static String HISID_FIELD =  "HisID";
  
  /**
   *	HisID字段中文名，用于视图展示
   */
  public final static String HISID_LABLE = "历史编号";
  
  /**
   *	HisID对应的java字段名,业务操作使用这个字段。
   */
  private Long hisID;
  
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
   * 处理后数量 getter
   */
  public java.math.BigDecimal getAfterNum(){
    return afterNum;
  }
  /**
   * 处理后数量 setter
   * @param AfterNum
   */  
  public void setAfterNum(java.math.BigDecimal afterNum){
    this.afterNum = afterNum;
  }
 
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
   * 处理前数量 getter
   */
  public java.math.BigDecimal getBeforeNum(){
    return beforeNum;
  }
  /**
   * 处理前数量 setter
   * @param BeforeNum
   */  
  public void setBeforeNum(java.math.BigDecimal beforeNum){
    this.beforeNum = beforeNum;
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
   * 变动数量 getter
   */
  public java.math.BigDecimal getChangeNum(){
    return changeNum;
  }
  /**
   * 变动数量 setter
   * @param ChangeNum
   */  
  public void setChangeNum(java.math.BigDecimal changeNum){
    this.changeNum = changeNum;
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
   * 历史编号 getter
   */
  public Long getHisID(){
    return hisID;
  }
  /**
   * 历史编号 setter
   * @param HisID
   */  
  public void setHisID(Long hisID){
    this.hisID = hisID;
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
 
}