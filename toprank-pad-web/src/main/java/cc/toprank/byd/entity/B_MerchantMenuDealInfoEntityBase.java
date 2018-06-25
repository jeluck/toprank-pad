package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_MerchantMenuDealInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_MerchantMenuDealInfoEntityBase extends Entity {

  /**
   *	AfterPrice数据库列名
   */
  public final static java.lang.String AFTERPRICE_FIELD =  "AfterPrice";
  
  /**
   *	AfterPrice字段中文名，用于视图展示
   */
  public final static java.lang.String AFTERPRICE_LABLE = "AfterPrice";
  
  /**
   *	AfterPrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal afterPrice;
  
  /**
   *	AfterStatus数据库列名
   */
  public final static java.lang.String AFTERSTATUS_FIELD =  "AfterStatus";
  
  /**
   *	AfterStatus字段中文名，用于视图展示
   */
  public final static java.lang.String AFTERSTATUS_LABLE = "处理后状态";
  
  /**
   *	AfterStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long afterStatus;
  
  /**
   *	AuditDesc数据库列名
   */
  public final static java.lang.String AUDITDESC_FIELD =  "AuditDesc";
  
  /**
   *	AuditDesc字段中文名，用于视图展示
   */
  public final static java.lang.String AUDITDESC_LABLE = "AuditDesc";
  
  /**
   *	AuditDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String auditDesc;
  
  /**
   *	AuditorID数据库列名
   */
  public final static java.lang.String AUDITORID_FIELD =  "AuditorID";
  
  /**
   *	AuditorID字段中文名，用于视图展示
   */
  public final static java.lang.String AUDITORID_LABLE = "AuditorID";
  
  /**
   *	AuditorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long auditorID;
  
  /**
   *	AuditTime数据库列名
   */
  public final static java.lang.String AUDITTIME_FIELD =  "AuditTime";
  
  /**
   *	AuditTime字段中文名，用于视图展示
   */
  public final static java.lang.String AUDITTIME_LABLE = "AuditTime";
  
  /**
   *	AuditTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime auditTime;
  
  /**
   *	BeforePrice数据库列名
   */
  public final static java.lang.String BEFOREPRICE_FIELD =  "BeforePrice";
  
  /**
   *	BeforePrice字段中文名，用于视图展示
   */
  public final static java.lang.String BEFOREPRICE_LABLE = "BeforePrice";
  
  /**
   *	BeforePrice对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal beforePrice;
  
  /**
   *	BeforeStatus数据库列名
   */
  public final static java.lang.String BEFORESTATUS_FIELD =  "BeforeStatus";
  
  /**
   *	BeforeStatus字段中文名，用于视图展示
   */
  public final static java.lang.String BEFORESTATUS_LABLE = "处理前状态";
  
  /**
   *	BeforeStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long beforeStatus;
  
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
   *	ChangeNum数据库列名
   */
  public final static java.lang.String CHANGENUM_FIELD =  "ChangeNum";
  
  /**
   *	ChangeNum字段中文名，用于视图展示
   */
  public final static java.lang.String CHANGENUM_LABLE = "ChangeNum";
  
  /**
   *	ChangeNum对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal changeNum;
  
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
   *	DealCode数据库列名
   */
  public final static java.lang.String DEALCODE_FIELD =  "DealCode";
  
  /**
   *	DealCode字段中文名，用于视图展示
   */
  public final static java.lang.String DEALCODE_LABLE = "处理编码";
  
  /**
   *	DealCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String dealCode;
  
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
   *	MenuID数据库列名
   */
  public final static java.lang.String MENUID_FIELD =  "MenuID";
  
  /**
   *	MenuID字段中文名，用于视图展示
   */
  public final static java.lang.String MENUID_LABLE = "菜单编号";
  
  /**
   *	MenuID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long menuID;
  
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
   * AfterPrice getter
   */
  public java.math.BigDecimal getAfterPrice(){
    return afterPrice;
  }
  /**
   * AfterPrice setter
   * @param AfterPrice
   */  
  public void setAfterPrice(java.math.BigDecimal afterPrice){
    this.afterPrice = afterPrice;
  }
 
  /**
   * 处理后状态 getter
   */
  public java.lang.Long getAfterStatus(){
    return afterStatus;
  }
  /**
   * 处理后状态 setter
   * @param AfterStatus
   */  
  public void setAfterStatus(java.lang.Long afterStatus){
    this.afterStatus = afterStatus;
  }
 
  /**
   * AuditDesc getter
   */
  public java.lang.String getAuditDesc(){
    return auditDesc;
  }
  /**
   * AuditDesc setter
   * @param AuditDesc
   */  
  public void setAuditDesc(java.lang.String auditDesc){
    this.auditDesc = auditDesc;
  }
 
  /**
   * AuditorID getter
   */
  public java.lang.Long getAuditorID(){
    return auditorID;
  }
  /**
   * AuditorID setter
   * @param AuditorID
   */  
  public void setAuditorID(java.lang.Long auditorID){
    this.auditorID = auditorID;
  }
 
  /**
   * AuditTime getter
   */
  public java.time.LocalDateTime getAuditTime(){
    return auditTime;
  }
  /**
   * AuditTime setter
   * @param AuditTime
   */  
  public void setAuditTime(java.time.LocalDateTime auditTime){
    this.auditTime = auditTime;
  }
 
  /**
   * BeforePrice getter
   */
  public java.math.BigDecimal getBeforePrice(){
    return beforePrice;
  }
  /**
   * BeforePrice setter
   * @param BeforePrice
   */  
  public void setBeforePrice(java.math.BigDecimal beforePrice){
    this.beforePrice = beforePrice;
  }
 
  /**
   * 处理前状态 getter
   */
  public java.lang.Long getBeforeStatus(){
    return beforeStatus;
  }
  /**
   * 处理前状态 setter
   * @param BeforeStatus
   */  
  public void setBeforeStatus(java.lang.Long beforeStatus){
    this.beforeStatus = beforeStatus;
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
   * ChangeNum getter
   */
  public java.math.BigDecimal getChangeNum(){
    return changeNum;
  }
  /**
   * ChangeNum setter
   * @param ChangeNum
   */  
  public void setChangeNum(java.math.BigDecimal changeNum){
    this.changeNum = changeNum;
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
   * 处理编码 getter
   */
  public java.lang.String getDealCode(){
    return dealCode;
  }
  /**
   * 处理编码 setter
   * @param DealCode
   */  
  public void setDealCode(java.lang.String dealCode){
    this.dealCode = dealCode;
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
   * 菜单编号 getter
   */
  public java.lang.Long getMenuID(){
    return menuID;
  }
  /**
   * 菜单编号 setter
   * @param MenuID
   */  
  public void setMenuID(java.lang.Long menuID){
    this.menuID = menuID;
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