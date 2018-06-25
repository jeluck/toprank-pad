package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在SystemMaxID类中进行修改
 * 
 * ********************************************************************************************************************/
public class SystemMaxIDEntityBase extends Entity {

  /**
   *	Applier数据库列名
   */
  public final static java.lang.String APPLIER_FIELD =  "Applier";
  
  /**
   *	Applier字段中文名，用于视图展示
   */
  public final static java.lang.String APPLIER_LABLE = "Applier";
  
  /**
   *	Applier对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String applier;
  
  /**
   *	ApplyTime数据库列名
   */
  public final static java.lang.String APPLYTIME_FIELD =  "ApplyTime";
  
  /**
   *	ApplyTime字段中文名，用于视图展示
   */
  public final static java.lang.String APPLYTIME_LABLE = "ApplyTime";
  
  /**
   *	ApplyTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime applyTime;
  
  /**
   *	IDLen数据库列名
   */
  public final static java.lang.String IDLEN_FIELD =  "IDLen";
  
  /**
   *	IDLen字段中文名，用于视图展示
   */
  public final static java.lang.String IDLEN_LABLE = "IDLen";
  
  /**
   *	IDLen对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer iDLen;
  
  /**
   *	IDType数据库列名
   */
  public final static java.lang.String IDTYPE_FIELD =  "IDType";
  
  /**
   *	IDType字段中文名，用于视图展示
   */
  public final static java.lang.String IDTYPE_LABLE = "IDType";
  
  /**
   *	IDType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String iDType;
  
  /**
   *	MaxID数据库列名
   */
  public final static java.lang.String MAXID_FIELD =  "MaxID";
  
  /**
   *	MaxID字段中文名，用于视图展示
   */
  public final static java.lang.String MAXID_LABLE = "MaxID";
  
  /**
   *	MaxID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long maxID;
  
  /**
   *	PKField数据库列名
   */
  public final static java.lang.String PKFIELD_FIELD =  "PKField";
  
  /**
   *	PKField字段中文名，用于视图展示
   */
  public final static java.lang.String PKFIELD_LABLE = "PKField";
  
  /**
   *	PKField对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String pKField;
  
  /**
   *	SerialNo数据库列名
   */
  public final static java.lang.String SERIALNO_FIELD =  "SerialNo";
  
  /**
   *	SerialNo字段中文名，用于视图展示
   */
  public final static java.lang.String SERIALNO_LABLE = "SerialNo";
  
  /**
   *	SerialNo对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer serialNo;
  
  /**
   *	TableName数据库列名
   */
  public final static java.lang.String TABLENAME_FIELD =  "TableName";
  
  /**
   *	TableName字段中文名，用于视图展示
   */
  public final static java.lang.String TABLENAME_LABLE = "TableName";
  
  /**
   *	TableName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String tableName;
  
  /**
   * Applier getter
   */
  public java.lang.String getApplier(){
    return applier;
  }
  /**
   * Applier setter
   * @param Applier
   */  
  public void setApplier(java.lang.String applier){
    this.applier = applier;
  }
 
  /**
   * ApplyTime getter
   */
  public java.time.LocalDateTime getApplyTime(){
    return applyTime;
  }
  /**
   * ApplyTime setter
   * @param ApplyTime
   */  
  public void setApplyTime(java.time.LocalDateTime applyTime){
    this.applyTime = applyTime;
  }
 
  /**
   * IDLen getter
   */
  public java.lang.Integer getIDLen(){
    return iDLen;
  }
  /**
   * IDLen setter
   * @param IDLen
   */  
  public void setIDLen(java.lang.Integer iDLen){
    this.iDLen = iDLen;
  }
 
  /**
   * IDType getter
   */
  public java.lang.String getIDType(){
    return iDType;
  }
  /**
   * IDType setter
   * @param IDType
   */  
  public void setIDType(java.lang.String iDType){
    this.iDType = iDType;
  }
 
  /**
   * MaxID getter
   */
  public java.lang.Long getMaxID(){
    return maxID;
  }
  /**
   * MaxID setter
   * @param MaxID
   */  
  public void setMaxID(java.lang.Long maxID){
    this.maxID = maxID;
  }
 
  /**
   * PKField getter
   */
  public java.lang.String getPKField(){
    return pKField;
  }
  /**
   * PKField setter
   * @param PKField
   */  
  public void setPKField(java.lang.String pKField){
    this.pKField = pKField;
  }
 
  /**
   * SerialNo getter
   */
  public java.lang.Integer getSerialNo(){
    return serialNo;
  }
  /**
   * SerialNo setter
   * @param SerialNo
   */  
  public void setSerialNo(java.lang.Integer serialNo){
    this.serialNo = serialNo;
  }
 
  /**
   * TableName getter
   */
  public java.lang.String getTableName(){
    return tableName;
  }
  /**
   * TableName setter
   * @param TableName
   */  
  public void setTableName(java.lang.String tableName){
    this.tableName = tableName;
  }
 
}