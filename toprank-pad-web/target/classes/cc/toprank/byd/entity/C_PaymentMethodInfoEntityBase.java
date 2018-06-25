package cc.toprank.byd.entity;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在C_PaymentMethodInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class C_PaymentMethodInfoEntityBase  extends Entity{

  /**
   *	ConfigureArgs数据库列名
   */
  public final static String CONFIGUREARGS_FIELD =  "ConfigureArgs";
  
  /**
   *	ConfigureArgs字段中文名，用于视图展示
   */
  public final static String CONFIGUREARGS_LABLE = "关联参数";
  
  /**
   *	ConfigureArgs对应的java字段名,业务操作使用这个字段。
   */
  private String configureArgs;
  
  /**
   *	ConfigurePath数据库列名
   */
  public final static String CONFIGUREPATH_FIELD =  "ConfigurePath";
  
  /**
   *	ConfigurePath字段中文名，用于视图展示
   */
  public final static String CONFIGUREPATH_LABLE = "关联路径";
  
  /**
   *	ConfigurePath对应的java字段名,业务操作使用这个字段。
   */
  private String configurePath;
  
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
   *	EncryptionParameter数据库列名
   */
  public final static String ENCRYPTIONPARAMETER_FIELD =  "EncryptionParameter";
  
  /**
   *	EncryptionParameter字段中文名，用于视图展示
   */
  public final static String ENCRYPTIONPARAMETER_LABLE = "加密参数";
  
  /**
   *	EncryptionParameter对应的java字段名,业务操作使用这个字段。
   */
  private String encryptionParameter;
  
  /**
   *	IsOnline数据库列名
   */
  public final static String ISONLINE_FIELD =  "IsOnline";
  
  /**
   *	IsOnline字段中文名，用于视图展示
   */
  public final static String ISONLINE_LABLE = "是否线上";
  
  /**
   *	IsOnline对应的java字段名,业务操作使用这个字段。
   */
  private Boolean isOnline;
  
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
   *	MethodStatus数据库列名
   */
  public final static String METHODSTATUS_FIELD =  "MethodStatus";
  
  /**
   *	MethodStatus字段中文名，用于视图展示
   */
  public final static String METHODSTATUS_LABLE = "使用状态";
  
  /**
   *	MethodStatus对应的java字段名,业务操作使用这个字段。
   */
  private Long methodStatus;
  
  /**
   *	PaymentDescription数据库列名
   */
  public final static String PAYMENTDESCRIPTION_FIELD =  "PaymentDescription";
  
  /**
   *	PaymentDescription字段中文名，用于视图展示
   */
  public final static String PAYMENTDESCRIPTION_LABLE = "描述";
  
  /**
   *	PaymentDescription对应的java字段名,业务操作使用这个字段。
   */
  private String paymentDescription;
  
  /**
   *	PaymentMethodCode数据库列名
   */
  public final static String PAYMENTMETHODCODE_FIELD =  "PaymentMethodCode";
  
  /**
   *	PaymentMethodCode字段中文名，用于视图展示
   */
  public final static String PAYMENTMETHODCODE_LABLE = "支付方式编码";
  
  /**
   *	PaymentMethodCode对应的java字段名,业务操作使用这个字段。
   */
  private String paymentMethodCode;
  
  /**
   *	PaymentMethodID数据库列名
   */
  public final static String PAYMENTMETHODID_FIELD =  "PaymentMethodID";
  
  /**
   *	PaymentMethodID字段中文名，用于视图展示
   */
  public final static String PAYMENTMETHODID_LABLE = "支付方式编号";
  
  /**
   *	PaymentMethodID对应的java字段名,业务操作使用这个字段。
   */
  private Long paymentMethodID;
  
  /**
   *	PaymentName数据库列名
   */
  public final static String PAYMENTNAME_FIELD =  "PaymentName";
  
  /**
   *	PaymentName字段中文名，用于视图展示
   */
  public final static String PAYMENTNAME_LABLE = "支付方式名称";
  
  /**
   *	PaymentName对应的java字段名,业务操作使用这个字段。
   */
  private String paymentName;
  
  /**
   *	PayOrgID数据库列名
   */
  public final static String PAYORGID_FIELD =  "PayOrgID";
  
  /**
   *	PayOrgID字段中文名，用于视图展示
   */
  public final static String PAYORGID_LABLE = "支付机构编号";
  
  /**
   *	PayOrgID对应的java字段名,业务操作使用这个字段。
   */
  private Long payOrgID;
  
  /**
   *	ReturnPath数据库列名
   */
  public final static String RETURNPATH_FIELD =  "ReturnPath";
  
  /**
   *	ReturnPath字段中文名，用于视图展示
   */
  public final static String RETURNPATH_LABLE = "返回路径";
  
  /**
   *	ReturnPath对应的java字段名,业务操作使用这个字段。
   */
  private String returnPath;
  
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
   *	VisibleName数据库列名
   */
  public final static String VISIBLENAME_FIELD =  "VisibleName";
  
  /**
   *	VisibleName字段中文名，用于视图展示
   */
  public final static String VISIBLENAME_LABLE = "显示名称";
  
  /**
   *	VisibleName对应的java字段名,业务操作使用这个字段。
   */
  private String visibleName;
  
  /**
   * 关联参数 getter
   */
  public String getConfigureArgs(){
    return configureArgs;
  }
  /**
   * 关联参数 setter
   * @param ConfigureArgs
   */  
  public void setConfigureArgs(String configureArgs){
    this.configureArgs = configureArgs;
  }
 
  /**
   * 关联路径 getter
   */
  public String getConfigurePath(){
    return configurePath;
  }
  /**
   * 关联路径 setter
   * @param ConfigurePath
   */  
  public void setConfigurePath(String configurePath){
    this.configurePath = configurePath;
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
   * 加密参数 getter
   */
  public String getEncryptionParameter(){
    return encryptionParameter;
  }
  /**
   * 加密参数 setter
   * @param EncryptionParameter
   */  
  public void setEncryptionParameter(String encryptionParameter){
    this.encryptionParameter = encryptionParameter;
  }
 
  /**
   * 是否线上 getter
   */
  public Boolean getIsOnline(){
    return isOnline;
  }
  /**
   * 是否线上 setter
   * @param IsOnline
   */  
  public void setIsOnline(Boolean isOnline){
    this.isOnline = isOnline;
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
   * 使用状态 getter
   */
  public Long getMethodStatus(){
    return methodStatus;
  }
  /**
   * 使用状态 setter
   * @param MethodStatus
   */  
  public void setMethodStatus(Long methodStatus){
    this.methodStatus = methodStatus;
  }
 
  /**
   * 描述 getter
   */
  public String getPaymentDescription(){
    return paymentDescription;
  }
  /**
   * 描述 setter
   * @param PaymentDescription
   */  
  public void setPaymentDescription(String paymentDescription){
    this.paymentDescription = paymentDescription;
  }
 
  /**
   * 支付方式编码 getter
   */
  public String getPaymentMethodCode(){
    return paymentMethodCode;
  }
  /**
   * 支付方式编码 setter
   * @param PaymentMethodCode
   */  
  public void setPaymentMethodCode(String paymentMethodCode){
    this.paymentMethodCode = paymentMethodCode;
  }
 
  /**
   * 支付方式编号 getter
   */
  public Long getPaymentMethodID(){
    return paymentMethodID;
  }
  /**
   * 支付方式编号 setter
   * @param PaymentMethodID
   */  
  public void setPaymentMethodID(Long paymentMethodID){
    this.paymentMethodID = paymentMethodID;
  }
 
  /**
   * 支付方式名称 getter
   */
  public String getPaymentName(){
    return paymentName;
  }
  /**
   * 支付方式名称 setter
   * @param PaymentName
   */  
  public void setPaymentName(String paymentName){
    this.paymentName = paymentName;
  }
 
  /**
   * 支付机构编号 getter
   */
  public Long getPayOrgID(){
    return payOrgID;
  }
  /**
   * 支付机构编号 setter
   * @param PayOrgID
   */  
  public void setPayOrgID(Long payOrgID){
    this.payOrgID = payOrgID;
  }
 
  /**
   * 返回路径 getter
   */
  public String getReturnPath(){
    return returnPath;
  }
  /**
   * 返回路径 setter
   * @param ReturnPath
   */  
  public void setReturnPath(String returnPath){
    this.returnPath = returnPath;
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
   * 显示名称 getter
   */
  public String getVisibleName(){
    return visibleName;
  }
  /**
   * 显示名称 setter
   * @param VisibleName
   */  
  public void setVisibleName(String visibleName){
    this.visibleName = visibleName;
  }
 
}