package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在F_InvoiceInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class F_InvoiceInfoEntityBase extends Entity {

  /**
   *	AddressID数据库列名
   */
  public final static java.lang.String ADDRESSID_FIELD =  "AddressID";
  
  /**
   *	AddressID字段中文名，用于视图展示
   */
  public final static java.lang.String ADDRESSID_LABLE = "地址编号";
  
  /**
   *	AddressID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long addressID;
  
  /**
   *	BankAccount数据库列名
   */
  public final static java.lang.String BANKACCOUNT_FIELD =  "BankAccount";
  
  /**
   *	BankAccount字段中文名，用于视图展示
   */
  public final static java.lang.String BANKACCOUNT_LABLE = "银行帐户";
  
  /**
   *	BankAccount对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String bankAccount;
  
  /**
   *	BankName数据库列名
   */
  public final static java.lang.String BANKNAME_FIELD =  "BankName";
  
  /**
   *	BankName字段中文名，用于视图展示
   */
  public final static java.lang.String BANKNAME_LABLE = "开户银行";
  
  /**
   *	BankName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String bankName;
  
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
   *	CustomerID数据库列名
   */
  public final static java.lang.String CUSTOMERID_FIELD =  "CustomerID";
  
  /**
   *	CustomerID字段中文名，用于视图展示
   */
  public final static java.lang.String CUSTOMERID_LABLE = "客户编号";
  
  /**
   *	CustomerID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long customerID;
  
  /**
   *	DepartName数据库列名
   */
  public final static java.lang.String DEPARTNAME_FIELD =  "DepartName";
  
  /**
   *	DepartName字段中文名，用于视图展示
   */
  public final static java.lang.String DEPARTNAME_LABLE = "单位名称";
  
  /**
   *	DepartName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String departName;
  
  /**
   *	IDCode数据库列名
   */
  public final static java.lang.String IDCODE_FIELD =  "IDCode";
  
  /**
   *	IDCode字段中文名，用于视图展示
   */
  public final static java.lang.String IDCODE_LABLE = "纳税人识别号";
  
  /**
   *	IDCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String iDCode;
  
  /**
   *	InvoiceCode数据库列名
   */
  public final static java.lang.String INVOICECODE_FIELD =  "InvoiceCode";
  
  /**
   *	InvoiceCode字段中文名，用于视图展示
   */
  public final static java.lang.String INVOICECODE_LABLE = "发票编码";
  
  /**
   *	InvoiceCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String invoiceCode;
  
  /**
   *	InvoiceContent数据库列名
   */
  public final static java.lang.String INVOICECONTENT_FIELD =  "InvoiceContent";
  
  /**
   *	InvoiceContent字段中文名，用于视图展示
   */
  public final static java.lang.String INVOICECONTENT_LABLE = "发票内容";
  
  /**
   *	InvoiceContent对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String invoiceContent;
  
  /**
   *	InvoiceDesc数据库列名
   */
  public final static java.lang.String INVOICEDESC_FIELD =  "InvoiceDesc";
  
  /**
   *	InvoiceDesc字段中文名，用于视图展示
   */
  public final static java.lang.String INVOICEDESC_LABLE = "发票描述";
  
  /**
   *	InvoiceDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String invoiceDesc;
  
  /**
   *	InvoiceID数据库列名
   */
  public final static java.lang.String INVOICEID_FIELD =  "InvoiceID";
  
  /**
   *	InvoiceID字段中文名，用于视图展示
   */
  public final static java.lang.String INVOICEID_LABLE = "发票编号";
  
  /**
   *	InvoiceID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long invoiceID;
  
  /**
   *	InvoiceMode数据库列名
   */
  public final static java.lang.String INVOICEMODE_FIELD =  "InvoiceMode";
  
  /**
   *	InvoiceMode字段中文名，用于视图展示
   */
  public final static java.lang.String INVOICEMODE_LABLE = "发票类型";
  
  /**
   *	InvoiceMode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long invoiceMode;
  
  /**
   *	InvoiceStatus数据库列名
   */
  public final static java.lang.String INVOICESTATUS_FIELD =  "InvoiceStatus";
  
  /**
   *	InvoiceStatus字段中文名，用于视图展示
   */
  public final static java.lang.String INVOICESTATUS_LABLE = "发票状态";
  
  /**
   *	InvoiceStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long invoiceStatus;
  
  /**
   *	InvoiceTitle数据库列名
   */
  public final static java.lang.String INVOICETITLE_FIELD =  "InvoiceTitle";
  
  /**
   *	InvoiceTitle字段中文名，用于视图展示
   */
  public final static java.lang.String INVOICETITLE_LABLE = "发票抬头";
  
  /**
   *	InvoiceTitle对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String invoiceTitle;
  
  /**
   *	InvoiceType数据库列名
   */
  public final static java.lang.String INVOICETYPE_FIELD =  "InvoiceType";
  
  /**
   *	InvoiceType字段中文名，用于视图展示
   */
  public final static java.lang.String INVOICETYPE_LABLE = "发票类别";
  
  /**
   *	InvoiceType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long invoiceType;
  
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
   *	ItemID数据库列名
   */
  public final static java.lang.String ITEMID_FIELD =  "ItemID";
  
  /**
   *	ItemID字段中文名，用于视图展示
   */
  public final static java.lang.String ITEMID_LABLE = "项目编号";
  
  /**
   *	ItemID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long itemID;
  
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
   *	OderAmount数据库列名
   */
  public final static java.lang.String ODERAMOUNT_FIELD =  "OderAmount";
  
  /**
   *	OderAmount字段中文名，用于视图展示
   */
  public final static java.lang.String ODERAMOUNT_LABLE = "发票金额";
  
  /**
   *	OderAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal oderAmount;
  
  /**
   *	OrderID数据库列名
   */
  public final static java.lang.String ORDERID_FIELD =  "OrderID";
  
  /**
   *	OrderID字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERID_LABLE = "订单编号";
  
  /**
   *	OrderID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orderID;
  
  /**
   *	OrderType数据库列名
   */
  public final static java.lang.String ORDERTYPE_FIELD =  "OrderType";
  
  /**
   *	OrderType字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERTYPE_LABLE = "订单类别";
  
  /**
   *	OrderType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orderType;
  
  /**
   *	RegisterAddress数据库列名
   */
  public final static java.lang.String REGISTERADDRESS_FIELD =  "RegisterAddress";
  
  /**
   *	RegisterAddress字段中文名，用于视图展示
   */
  public final static java.lang.String REGISTERADDRESS_LABLE = "注册地址";
  
  /**
   *	RegisterAddress对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String registerAddress;
  
  /**
   *	RegisterPhone数据库列名
   */
  public final static java.lang.String REGISTERPHONE_FIELD =  "RegisterPhone";
  
  /**
   *	RegisterPhone字段中文名，用于视图展示
   */
  public final static java.lang.String REGISTERPHONE_LABLE = "注册电话";
  
  /**
   *	RegisterPhone对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String registerPhone;
  
  /**
   * 地址编号 getter
   */
  public java.lang.Long getAddressID(){
    return addressID;
  }
  /**
   * 地址编号 setter
   * @param AddressID
   */  
  public void setAddressID(java.lang.Long addressID){
    this.addressID = addressID;
  }
 
  /**
   * 银行帐户 getter
   */
  public java.lang.String getBankAccount(){
    return bankAccount;
  }
  /**
   * 银行帐户 setter
   * @param BankAccount
   */  
  public void setBankAccount(java.lang.String bankAccount){
    this.bankAccount = bankAccount;
  }
 
  /**
   * 开户银行 getter
   */
  public java.lang.String getBankName(){
    return bankName;
  }
  /**
   * 开户银行 setter
   * @param BankName
   */  
  public void setBankName(java.lang.String bankName){
    this.bankName = bankName;
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
   * 客户编号 getter
   */
  public java.lang.Long getCustomerID(){
    return customerID;
  }
  /**
   * 客户编号 setter
   * @param CustomerID
   */  
  public void setCustomerID(java.lang.Long customerID){
    this.customerID = customerID;
  }
 
  /**
   * 单位名称 getter
   */
  public java.lang.String getDepartName(){
    return departName;
  }
  /**
   * 单位名称 setter
   * @param DepartName
   */  
  public void setDepartName(java.lang.String departName){
    this.departName = departName;
  }
 
  /**
   * 纳税人识别号 getter
   */
  public java.lang.String getIDCode(){
    return iDCode;
  }
  /**
   * 纳税人识别号 setter
   * @param IDCode
   */  
  public void setIDCode(java.lang.String iDCode){
    this.iDCode = iDCode;
  }
 
  /**
   * 发票编码 getter
   */
  public java.lang.String getInvoiceCode(){
    return invoiceCode;
  }
  /**
   * 发票编码 setter
   * @param InvoiceCode
   */  
  public void setInvoiceCode(java.lang.String invoiceCode){
    this.invoiceCode = invoiceCode;
  }
 
  /**
   * 发票内容 getter
   */
  public java.lang.String getInvoiceContent(){
    return invoiceContent;
  }
  /**
   * 发票内容 setter
   * @param InvoiceContent
   */  
  public void setInvoiceContent(java.lang.String invoiceContent){
    this.invoiceContent = invoiceContent;
  }
 
  /**
   * 发票描述 getter
   */
  public java.lang.String getInvoiceDesc(){
    return invoiceDesc;
  }
  /**
   * 发票描述 setter
   * @param InvoiceDesc
   */  
  public void setInvoiceDesc(java.lang.String invoiceDesc){
    this.invoiceDesc = invoiceDesc;
  }
 
  /**
   * 发票编号 getter
   */
  public java.lang.Long getInvoiceID(){
    return invoiceID;
  }
  /**
   * 发票编号 setter
   * @param InvoiceID
   */  
  public void setInvoiceID(java.lang.Long invoiceID){
    this.invoiceID = invoiceID;
  }
 
  /**
   * 发票类型 getter
   */
  public java.lang.Long getInvoiceMode(){
    return invoiceMode;
  }
  /**
   * 发票类型 setter
   * @param InvoiceMode
   */  
  public void setInvoiceMode(java.lang.Long invoiceMode){
    this.invoiceMode = invoiceMode;
  }
 
  /**
   * 发票状态 getter
   */
  public java.lang.Long getInvoiceStatus(){
    return invoiceStatus;
  }
  /**
   * 发票状态 setter
   * @param InvoiceStatus
   */  
  public void setInvoiceStatus(java.lang.Long invoiceStatus){
    this.invoiceStatus = invoiceStatus;
  }
 
  /**
   * 发票抬头 getter
   */
  public java.lang.String getInvoiceTitle(){
    return invoiceTitle;
  }
  /**
   * 发票抬头 setter
   * @param InvoiceTitle
   */  
  public void setInvoiceTitle(java.lang.String invoiceTitle){
    this.invoiceTitle = invoiceTitle;
  }
 
  /**
   * 发票类别 getter
   */
  public java.lang.Long getInvoiceType(){
    return invoiceType;
  }
  /**
   * 发票类别 setter
   * @param InvoiceType
   */  
  public void setInvoiceType(java.lang.Long invoiceType){
    this.invoiceType = invoiceType;
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
   * 项目编号 getter
   */
  public java.lang.Long getItemID(){
    return itemID;
  }
  /**
   * 项目编号 setter
   * @param ItemID
   */  
  public void setItemID(java.lang.Long itemID){
    this.itemID = itemID;
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
   * 发票金额 getter
   */
  public java.math.BigDecimal getOderAmount(){
    return oderAmount;
  }
  /**
   * 发票金额 setter
   * @param OderAmount
   */  
  public void setOderAmount(java.math.BigDecimal oderAmount){
    this.oderAmount = oderAmount;
  }
 
  /**
   * 订单编号 getter
   */
  public java.lang.Long getOrderID(){
    return orderID;
  }
  /**
   * 订单编号 setter
   * @param OrderID
   */  
  public void setOrderID(java.lang.Long orderID){
    this.orderID = orderID;
  }
 
  /**
   * 订单类别 getter
   */
  public java.lang.Long getOrderType(){
    return orderType;
  }
  /**
   * 订单类别 setter
   * @param OrderType
   */  
  public void setOrderType(java.lang.Long orderType){
    this.orderType = orderType;
  }
 
  /**
   * 注册地址 getter
   */
  public java.lang.String getRegisterAddress(){
    return registerAddress;
  }
  /**
   * 注册地址 setter
   * @param RegisterAddress
   */  
  public void setRegisterAddress(java.lang.String registerAddress){
    this.registerAddress = registerAddress;
  }
 
  /**
   * 注册电话 getter
   */
  public java.lang.String getRegisterPhone(){
    return registerPhone;
  }
  /**
   * 注册电话 setter
   * @param RegisterPhone
   */  
  public void setRegisterPhone(java.lang.String registerPhone){
    this.registerPhone = registerPhone;
  }
 
}