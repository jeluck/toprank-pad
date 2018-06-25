package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_PadTableMapping类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_PadTableMappingEntityBase extends Entity {

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
   *	MappingDesc数据库列名
   */
  public final static String MAPPINGDESC_FIELD =  "MappingDesc";
  
  /**
   *	MappingDesc字段中文名，用于视图展示
   */
  public final static String MAPPINGDESC_LABLE = "关联描述";
  
  /**
   *	MappingDesc对应的java字段名,业务操作使用这个字段。
   */
  private String mappingDesc;
  
  /**
   *	MappingID数据库列名
   */
  public final static String MAPPINGID_FIELD =  "MappingID";
  
  /**
   *	MappingID字段中文名，用于视图展示
   */
  public final static String MAPPINGID_LABLE = "关联编号";
  
  /**
   *	MappingID对应的java字段名,业务操作使用这个字段。
   */
  private Long mappingID;
  
  /**
   *	MappingStatus数据库列名
   */
  public final static String MAPPINGSTATUS_FIELD =  "MappingStatus";
  
  /**
   *	MappingStatus字段中文名，用于视图展示
   */
  public final static String MAPPINGSTATUS_LABLE = "关联状态";
  
  /**
   *	MappingStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long mappingStatus;
  
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
   *	PadID数据库列名
   */
  public final static String PADID_FIELD =  "PadID";
  
  /**
   *	PadID字段中文名，用于视图展示
   */
  public final static String PADID_LABLE = "水牌编号";
  
  /**
   *	PadID对应的java字段名,业务操作使用这个字段。
   */
  private Long padID;
  
  /**
   *	TableID数据库列名
   */
  public final static String TABLEID_FIELD =  "TableID";
  
  /**
   *	TableID字段中文名，用于视图展示
   */
  public final static String TABLEID_LABLE = "桌台编号";
  
  /**
   *	TableID对应的java字段名,业务操作使用这个字段。
   */
  private Long tableID;
  
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
   * 关联描述 getter
   */
  public String getMappingDesc(){
    return mappingDesc;
  }
  /**
   * 关联描述 setter
   * @param MappingDesc
   */  
  public void setMappingDesc(String mappingDesc){
    this.mappingDesc = mappingDesc;
  }
 
  /**
   * 关联编号 getter
   */
  public Long getMappingID(){
    return mappingID;
  }
  /**
   * 关联编号 setter
   * @param MappingID
   */  
  public void setMappingID(Long mappingID){
    this.mappingID = mappingID;
  }
 
  /**
   * 关联状态 getter
   */
  public Long getMappingStatus(){
    return mappingStatus;
  }
  /**
   * 关联状态 setter
   * @param MappingStatus
   */  
  public void setMappingStatus(Long mappingStatus){
    this.mappingStatus = mappingStatus;
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
   * 水牌编号 getter
   */
  public Long getPadID(){
    return padID;
  }
  /**
   * 水牌编号 setter
   * @param PadID
   */  
  public void setPadID(Long padID){
    this.padID = padID;
  }
 
  /**
   * 桌台编号 getter
   */
  public Long getTableID(){
    return tableID;
  }
  /**
   * 桌台编号 setter
   * @param TableID
   */  
  public void setTableID(Long tableID){
    this.tableID = tableID;
  }
 
}