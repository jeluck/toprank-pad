package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_DictionaryInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_DictionaryInfoEntityBase  extends Entity{

  /**
   *	CatalogID数据库列名
   */
  public final static java.lang.String CATALOGID_FIELD =  "CatalogID";
  
  /**
   *	CatalogID字段中文名，用于视图展示
   */
  public final static java.lang.String CATALOGID_LABLE = "目录编号";
  
  /**
   *	CatalogID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long catalogID;
  
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
   *	DictionaryCode数据库列名
   */
  public final static java.lang.String DICTIONARYCODE_FIELD =  "DictionaryCode";
  
  /**
   *	DictionaryCode字段中文名，用于视图展示
   */
  public final static java.lang.String DICTIONARYCODE_LABLE = "字典编码";
  
  /**
   *	DictionaryCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String dictionaryCode;
  
  /**
   *	DictionaryDesc数据库列名
   */
  public final static java.lang.String DICTIONARYDESC_FIELD =  "DictionaryDesc";
  
  /**
   *	DictionaryDesc字段中文名，用于视图展示
   */
  public final static java.lang.String DICTIONARYDESC_LABLE = "描述";
  
  /**
   *	DictionaryDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String dictionaryDesc;
  
  /**
   *	DictionaryID数据库列名
   */
  public final static java.lang.String DICTIONARYID_FIELD =  "DictionaryID";
  
  /**
   *	DictionaryID字段中文名，用于视图展示
   */
  public final static java.lang.String DICTIONARYID_LABLE = "字典编号";
  
  /**
   *	DictionaryID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long dictionaryID;
  
  /**
   *	DictionaryName数据库列名
   */
  public final static java.lang.String DICTIONARYNAME_FIELD =  "DictionaryName";
  
  /**
   *	DictionaryName字段中文名，用于视图展示
   */
  public final static java.lang.String DICTIONARYNAME_LABLE = "名称";
  
  /**
   *	DictionaryName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String dictionaryName;
  
  /**
   *	DictionaryStatus数据库列名
   */
  public final static java.lang.String DICTIONARYSTATUS_FIELD =  "DictionaryStatus";
  
  /**
   *	DictionaryStatus字段中文名，用于视图展示
   */
  public final static java.lang.String DICTIONARYSTATUS_LABLE = "状态";
  
  /**
   *	DictionaryStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long dictionaryStatus;
  
  /**
   *	DictionaryValue数据库列名
   */
  public final static java.lang.String DICTIONARYVALUE_FIELD =  "DictionaryValue";
  
  /**
   *	DictionaryValue字段中文名，用于视图展示
   */
  public final static java.lang.String DICTIONARYVALUE_LABLE = "字典值";
  
  /**
   *	DictionaryValue对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String dictionaryValue;
  
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
   *	RelationInfo数据库列名
   */
  public final static java.lang.String RELATIONINFO_FIELD =  "RelationInfo";
  
  /**
   *	RelationInfo字段中文名，用于视图展示
   */
  public final static java.lang.String RELATIONINFO_LABLE = "关联信息";
  
  /**
   *	RelationInfo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String relationInfo;
  
  /**
   *	ShortName数据库列名
   */
  public final static java.lang.String SHORTNAME_FIELD =  "ShortName";
  
  /**
   *	ShortName字段中文名，用于视图展示
   */
  public final static java.lang.String SHORTNAME_LABLE = "简称";
  
  /**
   *	ShortName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String shortName;
  
  /**
   * 目录编号 getter
   */
  public java.lang.Long getCatalogID(){
    return catalogID;
  }
  /**
   * 目录编号 setter
   * @param catalogID
   */  
  public void setCatalogID(java.lang.Long catalogID){
    this.catalogID = catalogID;
  }
 
  /**
   * 创建时间 getter
   */
  public java.time.LocalDateTime getCreateTime(){
    return createTime;
  }
  /**
   * 创建时间 setter
   * @param createTime
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
   * @param creatorID
   */  
  public void setCreatorID(java.lang.Long creatorID){
    this.creatorID = creatorID;
  }
 
  /**
   * 字典编码 getter
   */
  public java.lang.String getDictionaryCode(){
    return dictionaryCode;
  }
  /**
   * 字典编码 setter
   * @param dictionaryCode
   */  
  public void setDictionaryCode(java.lang.String dictionaryCode){
    this.dictionaryCode = dictionaryCode;
  }
 
  /**
   * 描述 getter
   */
  public java.lang.String getDictionaryDesc(){
    return dictionaryDesc;
  }
  /**
   * 描述 setter
   * @param dictionaryDesc
   */  
  public void setDictionaryDesc(java.lang.String dictionaryDesc){
    this.dictionaryDesc = dictionaryDesc;
  }
 
  /**
   * 字典编号 getter
   */
  public java.lang.Long getDictionaryID(){
    return dictionaryID;
  }
  /**
   * 字典编号 setter
   * @param dictionaryID
   */  
  public void setDictionaryID(java.lang.Long dictionaryID){
    this.dictionaryID = dictionaryID;
  }
 
  /**
   * 名称 getter
   */
  public java.lang.String getDictionaryName(){
    return dictionaryName;
  }
  /**
   * 名称 setter
   * @param dictionaryName
   */  
  public void setDictionaryName(java.lang.String dictionaryName){
    this.dictionaryName = dictionaryName;
  }
 
  /**
   * 状态 getter
   */
  public java.lang.Long getDictionaryStatus(){
    return dictionaryStatus;
  }
  /**
   * 状态 setter
   * @param dictionaryStatus
   */  
  public void setDictionaryStatus(java.lang.Long dictionaryStatus){
    this.dictionaryStatus = dictionaryStatus;
  }
 
  /**
   * 字典值 getter
   */
  public java.lang.String getDictionaryValue(){
    return dictionaryValue;
  }
  /**
   * 字典值 setter
   * @param dictionaryValue
   */  
  public void setDictionaryValue(java.lang.String dictionaryValue){
    this.dictionaryValue = dictionaryValue;
  }
 
  /**
   * 是否同步 getter
   */
  public java.lang.Boolean getIsSync(){
    return isSync;
  }
  /**
   * 是否同步 setter
   * @param isSync
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
   * @param memo
   */  
  public void setMemo(java.lang.String memo){
    this.memo = memo;
  }
 
  /**
   * 关联信息 getter
   */
  public java.lang.String getRelationInfo(){
    return relationInfo;
  }
  /**
   * 关联信息 setter
   * @param relationInfo
   */  
  public void setRelationInfo(java.lang.String relationInfo){
    this.relationInfo = relationInfo;
  }
 
  /**
   * 简称 getter
   */
  public java.lang.String getShortName(){
    return shortName;
  }
  /**
   * 简称 setter
   * @param shortName
   */  
  public void setShortName(java.lang.String shortName){
    this.shortName = shortName;
  }
 
}