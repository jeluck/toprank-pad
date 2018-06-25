package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_DesignerMonitorMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_DesignerMonitorMappingEntityBase extends Entity {

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
   *	MappingDesc数据库列名
   */
  public final static java.lang.String MAPPINGDESC_FIELD =  "MappingDesc";
  
  /**
   *	MappingDesc字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGDESC_LABLE = "关联描述";
  
  /**
   *	MappingDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String mappingDesc;
  
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
   *	MappingStatus数据库列名
   */
  public final static java.lang.String MAPPINGSTATUS_FIELD =  "MappingStatus";
  
  /**
   *	MappingStatus字段中文名，用于视图展示
   */
  public final static java.lang.String MAPPINGSTATUS_LABLE = "关联状态";
  
  /**
   *	MappingStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long mappingStatus;
  
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
   *	MonitorID数据库列名
   */
  public final static java.lang.String MONITORID_FIELD =  "MonitorID";
  
  /**
   *	MonitorID字段中文名，用于视图展示
   */
  public final static java.lang.String MONITORID_LABLE = "看板编号";
  
  /**
   *	MonitorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long monitorID;
  
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
   * 关联描述 getter
   */
  public java.lang.String getMappingDesc(){
    return mappingDesc;
  }
  /**
   * 关联描述 setter
   * @param MappingDesc
   */  
  public void setMappingDesc(java.lang.String mappingDesc){
    this.mappingDesc = mappingDesc;
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
   * 关联状态 getter
   */
  public java.lang.Long getMappingStatus(){
    return mappingStatus;
  }
  /**
   * 关联状态 setter
   * @param MappingStatus
   */  
  public void setMappingStatus(java.lang.Long mappingStatus){
    this.mappingStatus = mappingStatus;
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
   * 看板编号 getter
   */
  public java.lang.Long getMonitorID(){
    return monitorID;
  }
  /**
   * 看板编号 setter
   * @param MonitorID
   */  
  public void setMonitorID(java.lang.Long monitorID){
    this.monitorID = monitorID;
  }
 
}