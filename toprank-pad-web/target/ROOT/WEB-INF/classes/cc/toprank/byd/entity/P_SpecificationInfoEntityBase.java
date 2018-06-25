package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在P_SpecificationInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class P_SpecificationInfoEntityBase  extends Entity{

  /**
   *	ArchiveID数据库列名
   */
  public final static String ARCHIVEID_FIELD =  "ArchiveID";
  
  /**
   *	ArchiveID字段中文名，用于视图展示
   */
  public final static String ARCHIVEID_LABLE = "档案编号";
  
  /**
   *	ArchiveID对应的java字段名,业务操作使用这个字段。
   */
  private Long archiveID;
  
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
   *	DisplayOrder数据库列名
   */
  public final static String DISPLAYORDER_FIELD =  "DisplayOrder";
  
  /**
   *	DisplayOrder字段中文名，用于视图展示
   */
  public final static String DISPLAYORDER_LABLE = "显示顺序";
  
  /**
   *	DisplayOrder对应的java字段名,业务操作使用这个字段。
   */
  private Integer displayOrder;
  
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
   *	OrgID数据库列名
   */
  public final static String ORGID_FIELD =  "OrgID";
  
  /**
   *	OrgID字段中文名，用于视图展示
   */
  public final static String ORGID_LABLE = "机构编号";
  
  /**
   *	OrgID对应的java字段名,业务操作使用这个字段。
   */
  private Long orgID;
  
  /**
   *	SpecificationCode数据库列名
   */
  public final static String SPECIFICATIONCODE_FIELD =  "SpecificationCode";
  
  /**
   *	SpecificationCode字段中文名，用于视图展示
   */
  public final static String SPECIFICATIONCODE_LABLE = "规格编码";
  
  /**
   *	SpecificationCode对应的java字段名,业务操作使用这个字段。
   */
  private String specificationCode;
  
  /**
   *	SpecificationDesc数据库列名
   */
  public final static String SPECIFICATIONDESC_FIELD =  "SpecificationDesc";
  
  /**
   *	SpecificationDesc字段中文名，用于视图展示
   */
  public final static String SPECIFICATIONDESC_LABLE = "描述";
  
  /**
   *	SpecificationDesc对应的java字段名,业务操作使用这个字段。
   */
  private String specificationDesc;
  
  /**
   *	SpecificationID数据库列名
   */
  public final static String SPECIFICATIONID_FIELD =  "SpecificationID";
  
  /**
   *	SpecificationID字段中文名，用于视图展示
   */
  public final static String SPECIFICATIONID_LABLE = "规格编号";
  
  /**
   *	SpecificationID对应的java字段名,业务操作使用这个字段。
   */
  private Long specificationID;
  
  /**
   *	SpecificationName数据库列名
   */
  public final static String SPECIFICATIONNAME_FIELD =  "SpecificationName";
  
  /**
   *	SpecificationName字段中文名，用于视图展示
   */
  public final static String SPECIFICATIONNAME_LABLE = "规格名称";
  
  /**
   *	SpecificationName对应的java字段名,业务操作使用这个字段。
   */
  private String specificationName;
  
  /**
   *	SpecificationStatus数据库列名
   */
  public final static String SPECIFICATIONSTATUS_FIELD =  "SpecificationStatus";
  
  /**
   *	SpecificationStatus字段中文名，用于视图展示
   */
  public final static String SPECIFICATIONSTATUS_LABLE = "规格状态";
  
  /**
   *	SpecificationStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long specificationStatus;
  
  /**
   * 档案编号 getter
   */
  public Long getArchiveID(){
    return archiveID;
  }
  /**
   * 档案编号 setter
   * @param ArchiveID
   */  
  public void setArchiveID(Long archiveID){
    this.archiveID = archiveID;
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
   * 显示顺序 getter
   */
  public Integer getDisplayOrder(){
    return displayOrder;
  }
  /**
   * 显示顺序 setter
   * @param DisplayOrder
   */  
  public void setDisplayOrder(Integer displayOrder){
    this.displayOrder = displayOrder;
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
   * 机构编号 getter
   */
  public Long getOrgID(){
    return orgID;
  }
  /**
   * 机构编号 setter
   * @param OrgID
   */  
  public void setOrgID(Long orgID){
    this.orgID = orgID;
  }
 
  /**
   * 规格编码 getter
   */
  public String getSpecificationCode(){
    return specificationCode;
  }
  /**
   * 规格编码 setter
   * @param SpecificationCode
   */  
  public void setSpecificationCode(String specificationCode){
    this.specificationCode = specificationCode;
  }
 
  /**
   * 描述 getter
   */
  public String getSpecificationDesc(){
    return specificationDesc;
  }
  /**
   * 描述 setter
   * @param SpecificationDesc
   */  
  public void setSpecificationDesc(String specificationDesc){
    this.specificationDesc = specificationDesc;
  }
 
  /**
   * 规格编号 getter
   */
  public Long getSpecificationID(){
    return specificationID;
  }
  /**
   * 规格编号 setter
   * @param SpecificationID
   */  
  public void setSpecificationID(Long specificationID){
    this.specificationID = specificationID;
  }
 
  /**
   * 规格名称 getter
   */
  public String getSpecificationName(){
    return specificationName;
  }
  /**
   * 规格名称 setter
   * @param SpecificationName
   */  
  public void setSpecificationName(String specificationName){
    this.specificationName = specificationName;
  }
 
  /**
   * 规格状态 getter
   */
  public Long getSpecificationStatus(){
    return specificationStatus;
  }
  /**
   * 规格状态 setter
   * @param SpecificationStatus
   */  
  public void setSpecificationStatus(Long specificationStatus){
    this.specificationStatus = specificationStatus;
  }
 
}