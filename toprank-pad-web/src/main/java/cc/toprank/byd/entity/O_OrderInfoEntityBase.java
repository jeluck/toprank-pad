package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_OrderInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_OrderInfoEntityBase extends Entity {

  /**
   *	ActualAmount数据库列名
   */
  public final static java.lang.String ACTUALAMOUNT_FIELD =  "ActualAmount";
  
  /**
   *	ActualAmount字段中文名，用于视图展示
   */
  public final static java.lang.String ACTUALAMOUNT_LABLE = "实际金额";
  
  /**
   *	ActualAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal actualAmount;
  
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
   *	ArchiveID数据库列名
   */
  public final static java.lang.String ARCHIVEID_FIELD =  "ArchiveID";
  
  /**
   *	ArchiveID字段中文名，用于视图展示
   */
  public final static java.lang.String ARCHIVEID_LABLE = "档案编号";
  
  /**
   *	ArchiveID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long archiveID;
  
  /**
   *	Commission数据库列名
   */
  public final static java.lang.String COMMISSION_FIELD =  "Commission";
  
  /**
   *	Commission字段中文名，用于视图展示
   */
  public final static java.lang.String COMMISSION_LABLE = "佣金";
  
  /**
   *	Commission对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal commission;
  
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
   *	CreatorType数据库列名
   */
  public final static java.lang.String CREATORTYPE_FIELD =  "CreatorType";
  
  /**
   *	CreatorType字段中文名，用于视图展示
   */
  public final static java.lang.String CREATORTYPE_LABLE = "创建人类别";
  
  /**
   *	CreatorType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long creatorType;
  
  /**
   *	CurrencyID数据库列名
   */
  public final static java.lang.String CURRENCYID_FIELD =  "CurrencyID";
  
  /**
   *	CurrencyID字段中文名，用于视图展示
   */
  public final static java.lang.String CURRENCYID_LABLE = "货币编号";
  
  /**
   *	CurrencyID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long currencyID;
  
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
   *	CustomerServiceStatus数据库列名
   */
  public final static java.lang.String CUSTOMERSERVICESTATUS_FIELD =  "CustomerServiceStatus";
  
  /**
   *	CustomerServiceStatus字段中文名，用于视图展示
   */
  public final static java.lang.String CUSTOMERSERVICESTATUS_LABLE = "客服状态";
  
  /**
   *	CustomerServiceStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long customerServiceStatus;
  
  /**
   *	DiscountAmount数据库列名
   */
  public final static java.lang.String DISCOUNTAMOUNT_FIELD =  "DiscountAmount";
  
  /**
   *	DiscountAmount字段中文名，用于视图展示
   */
  public final static java.lang.String DISCOUNTAMOUNT_LABLE = "折扣金额";
  
  /**
   *	DiscountAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal discountAmount;
  
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
   *	LoginID数据库列名
   */
  public final static java.lang.String LOGINID_FIELD =  "LoginID";
  
  /**
   *	LoginID字段中文名，用于视图展示
   */
  public final static java.lang.String LOGINID_LABLE = "登录编号";
  
  /**
   *	LoginID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long loginID;
  
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
   *	NickName数据库列名
   */
  public final static java.lang.String NICKNAME_FIELD =  "NickName";
  
  /**
   *	NickName字段中文名，用于视图展示
   */
  public final static java.lang.String NICKNAME_LABLE = "客户昵称";
  
  /**
   *	NickName对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String nickName;
  
  /**
   *	OrderChannel数据库列名
   */
  public final static java.lang.String ORDERCHANNEL_FIELD =  "OrderChannel";
  
  /**
   *	OrderChannel字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERCHANNEL_LABLE = "下单渠道";
  
  /**
   *	OrderChannel对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orderChannel;
  
  /**
   *	OrderCode数据库列名
   */
  public final static java.lang.String ORDERCODE_FIELD =  "OrderCode";
  
  /**
   *	OrderCode字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERCODE_LABLE = "订单编码";
  
  /**
   *	OrderCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String orderCode;
  
  /**
   *	OrderDesc数据库列名
   */
  public final static java.lang.String ORDERDESC_FIELD =  "OrderDesc";
  
  /**
   *	OrderDesc字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERDESC_LABLE = "订单描述";
  
  /**
   *	OrderDesc对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String orderDesc;
  
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
   *	OrderStatus数据库列名
   */
  public final static java.lang.String ORDERSTATUS_FIELD =  "OrderStatus";
  
  /**
   *	OrderStatus字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERSTATUS_LABLE = "订单状态";
  
  /**
   *	OrderStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long orderStatus;
  
  /**
   *	OrderWeight数据库列名
   */
  public final static java.lang.String ORDERWEIGHT_FIELD =  "OrderWeight";
  
  /**
   *	OrderWeight字段中文名，用于视图展示
   */
  public final static java.lang.String ORDERWEIGHT_LABLE = "订单重量";
  
  /**
   *	OrderWeight对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Float orderWeight;
  
  /**
   *	PaidTime数据库列名
   */
  public final static java.lang.String PAIDTIME_FIELD =  "PaidTime";
  
  /**
   *	PaidTime字段中文名，用于视图展示
   */
  public final static java.lang.String PAIDTIME_LABLE = "付款时间";
  
  /**
   *	PaidTime对应的java字段名,业务操作使用这个字段。
   */
  private java.time.LocalDateTime paidTime;
  
  /**
   *	PaymentMethodID数据库列名
   */
  public final static java.lang.String PAYMENTMETHODID_FIELD =  "PaymentMethodID";
  
  /**
   *	PaymentMethodID字段中文名，用于视图展示
   */
  public final static java.lang.String PAYMENTMETHODID_LABLE = "支付方式";
  
  /**
   *	PaymentMethodID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long paymentMethodID;
  
  /**
   *	PayStatus数据库列名
   */
  public final static java.lang.String PAYSTATUS_FIELD =  "PayStatus";
  
  /**
   *	PayStatus字段中文名，用于视图展示
   */
  public final static java.lang.String PAYSTATUS_LABLE = "支付状态";
  
  /**
   *	PayStatus对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long payStatus;
  
  /**
   *	PendingAmount数据库列名
   */
  public final static java.lang.String PENDINGAMOUNT_FIELD =  "PendingAmount";
  
  /**
   *	PendingAmount字段中文名，用于视图展示
   */
  public final static java.lang.String PENDINGAMOUNT_LABLE = "待付金额";
  
  /**
   *	PendingAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal pendingAmount;
  
  /**
   *	PeopleNum数据库列名
   */
  public final static java.lang.String PEOPLENUM_FIELD =  "PeopleNum";
  
  /**
   *	PeopleNum字段中文名，用于视图展示
   */
  public final static java.lang.String PEOPLENUM_LABLE = "就餐人数";
  
  /**
   *	PeopleNum对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer peopleNum;
  
  /**
   *	Phone数据库列名
   */
  public final static java.lang.String PHONE_FIELD =  "Phone";
  
  /**
   *	Phone字段中文名，用于视图展示
   */
  public final static java.lang.String PHONE_LABLE = "联系电话";
  
  /**
   *	Phone对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String phone;
  
  /**
   *	PrintBarCode数据库列名
   */
  public final static java.lang.String PRINTBARCODE_FIELD =  "PrintBarCode";
  
  /**
   *	PrintBarCode字段中文名，用于视图展示
   */
  public final static java.lang.String PRINTBARCODE_LABLE = "二维码";
  
  /**
   *	PrintBarCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String printBarCode;
  
  /**
   *	Quantity数据库列名
   */
  public final static java.lang.String QUANTITY_FIELD =  "Quantity";
  
  /**
   *	Quantity字段中文名，用于视图展示
   */
  public final static java.lang.String QUANTITY_LABLE = "商品数量";
  
  /**
   *	Quantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer quantity;
  
  /**
   *	ShippingCode数据库列名
   */
  public final static java.lang.String SHIPPINGCODE_FIELD =  "ShippingCode";
  
  /**
   *	ShippingCode字段中文名，用于视图展示
   */
  public final static java.lang.String SHIPPINGCODE_LABLE = "物流单号";
  
  /**
   *	ShippingCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String shippingCode;
  
  /**
   *	ShippingCorpID数据库列名
   */
  public final static java.lang.String SHIPPINGCORPID_FIELD =  "ShippingCorpID";
  
  /**
   *	ShippingCorpID字段中文名，用于视图展示
   */
  public final static java.lang.String SHIPPINGCORPID_LABLE = "物流公司";
  
  /**
   *	ShippingCorpID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long shippingCorpID;
  
  /**
   *	ShippingType数据库列名
   */
  public final static java.lang.String SHIPPINGTYPE_FIELD =  "ShippingType";
  
  /**
   *	ShippingType字段中文名，用于视图展示
   */
  public final static java.lang.String SHIPPINGTYPE_LABLE = "发货方式";
  
  /**
   *	ShippingType对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long shippingType;
  
  /**
   *	TotalAmount数据库列名
   */
  public final static java.lang.String TOTALAMOUNT_FIELD =  "TotalAmount";
  
  /**
   *	TotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String TOTALAMOUNT_LABLE = "商品总额";
  
  /**
   *	TotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal totalAmount;
  
  /**
   *	ValidationCode数据库列名
   */
  public final static java.lang.String VALIDATIONCODE_FIELD =  "ValidationCode";
  
  /**
   *	ValidationCode字段中文名，用于视图展示
   */
  public final static java.lang.String VALIDATIONCODE_LABLE = "验证码";
  
  /**
   *	ValidationCode对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.String validationCode;
  
  /**
   *	VendorID数据库列名
   */
  public final static java.lang.String VENDORID_FIELD =  "VendorID";
  
  /**
   *	VendorID字段中文名，用于视图展示
   */
  public final static java.lang.String VENDORID_LABLE = "供应商";
  
  /**
   *	VendorID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long vendorID;
  
  /**
   *	WeightID数据库列名
   */
  public final static java.lang.String WEIGHTID_FIELD =  "WeightID";
  
  /**
   *	WeightID字段中文名，用于视图展示
   */
  public final static java.lang.String WEIGHTID_LABLE = "重量单位";
  
  /**
   *	WeightID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long weightID;
  
  /**
   * 实际金额 getter
   */
  public java.math.BigDecimal getActualAmount(){
    return actualAmount;
  }
  /**
   * 实际金额 setter
   * @param ActualAmount
   */  
  public void setActualAmount(java.math.BigDecimal actualAmount){
    this.actualAmount = actualAmount;
  }
 
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
   * 档案编号 getter
   */
  public java.lang.Long getArchiveID(){
    return archiveID;
  }
  /**
   * 档案编号 setter
   * @param ArchiveID
   */  
  public void setArchiveID(java.lang.Long archiveID){
    this.archiveID = archiveID;
  }
 
  /**
   * 佣金 getter
   */
  public java.math.BigDecimal getCommission(){
    return commission;
  }
  /**
   * 佣金 setter
   * @param Commission
   */  
  public void setCommission(java.math.BigDecimal commission){
    this.commission = commission;
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
   * 创建人类别 getter
   */
  public java.lang.Long getCreatorType(){
    return creatorType;
  }
  /**
   * 创建人类别 setter
   * @param CreatorType
   */  
  public void setCreatorType(java.lang.Long creatorType){
    this.creatorType = creatorType;
  }
 
  /**
   * 货币编号 getter
   */
  public java.lang.Long getCurrencyID(){
    return currencyID;
  }
  /**
   * 货币编号 setter
   * @param CurrencyID
   */  
  public void setCurrencyID(java.lang.Long currencyID){
    this.currencyID = currencyID;
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
   * 客服状态 getter
   */
  public java.lang.Long getCustomerServiceStatus(){
    return customerServiceStatus;
  }
  /**
   * 客服状态 setter
   * @param CustomerServiceStatus
   */  
  public void setCustomerServiceStatus(java.lang.Long customerServiceStatus){
    this.customerServiceStatus = customerServiceStatus;
  }
 
  /**
   * 折扣金额 getter
   */
  public java.math.BigDecimal getDiscountAmount(){
    return discountAmount;
  }
  /**
   * 折扣金额 setter
   * @param DiscountAmount
   */  
  public void setDiscountAmount(java.math.BigDecimal discountAmount){
    this.discountAmount = discountAmount;
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
   * 登录编号 getter
   */
  public java.lang.Long getLoginID(){
    return loginID;
  }
  /**
   * 登录编号 setter
   * @param LoginID
   */  
  public void setLoginID(java.lang.Long loginID){
    this.loginID = loginID;
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
   * 客户昵称 getter
   */
  public java.lang.String getNickName(){
    return nickName;
  }
  /**
   * 客户昵称 setter
   * @param NickName
   */  
  public void setNickName(java.lang.String nickName){
    this.nickName = nickName;
  }
 
  /**
   * 下单渠道 getter
   */
  public java.lang.Long getOrderChannel(){
    return orderChannel;
  }
  /**
   * 下单渠道 setter
   * @param OrderChannel
   */  
  public void setOrderChannel(java.lang.Long orderChannel){
    this.orderChannel = orderChannel;
  }
 
  /**
   * 订单编码 getter
   */
  public java.lang.String getOrderCode(){
    return orderCode;
  }
  /**
   * 订单编码 setter
   * @param OrderCode
   */  
  public void setOrderCode(java.lang.String orderCode){
    this.orderCode = orderCode;
  }
 
  /**
   * 订单描述 getter
   */
  public java.lang.String getOrderDesc(){
    return orderDesc;
  }
  /**
   * 订单描述 setter
   * @param OrderDesc
   */  
  public void setOrderDesc(java.lang.String orderDesc){
    this.orderDesc = orderDesc;
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
   * 订单状态 getter
   */
  public java.lang.Long getOrderStatus(){
    return orderStatus;
  }
  /**
   * 订单状态 setter
   * @param OrderStatus
   */  
  public void setOrderStatus(java.lang.Long orderStatus){
    this.orderStatus = orderStatus;
  }
 
  /**
   * 订单重量 getter
   */
  public java.lang.Float getOrderWeight(){
    return orderWeight;
  }
  /**
   * 订单重量 setter
   * @param OrderWeight
   */  
  public void setOrderWeight(java.lang.Float orderWeight){
    this.orderWeight = orderWeight;
  }
 
  /**
   * 付款时间 getter
   */
  public java.time.LocalDateTime getPaidTime(){
    return paidTime;
  }
  /**
   * 付款时间 setter
   * @param PaidTime
   */  
  public void setPaidTime(java.time.LocalDateTime paidTime){
    this.paidTime = paidTime;
  }
 
  /**
   * 支付方式 getter
   */
  public java.lang.Long getPaymentMethodID(){
    return paymentMethodID;
  }
  /**
   * 支付方式 setter
   * @param PaymentMethodID
   */  
  public void setPaymentMethodID(java.lang.Long paymentMethodID){
    this.paymentMethodID = paymentMethodID;
  }
 
  /**
   * 支付状态 getter
   */
  public java.lang.Long getPayStatus(){
    return payStatus;
  }
  /**
   * 支付状态 setter
   * @param PayStatus
   */  
  public void setPayStatus(java.lang.Long payStatus){
    this.payStatus = payStatus;
  }
 
  /**
   * 待付金额 getter
   */
  public java.math.BigDecimal getPendingAmount(){
    return pendingAmount;
  }
  /**
   * 待付金额 setter
   * @param PendingAmount
   */  
  public void setPendingAmount(java.math.BigDecimal pendingAmount){
    this.pendingAmount = pendingAmount;
  }
 
  /**
   * 就餐人数 getter
   */
  public java.lang.Integer getPeopleNum(){
    return peopleNum;
  }
  /**
   * 就餐人数 setter
   * @param PeopleNum
   */  
  public void setPeopleNum(java.lang.Integer peopleNum){
    this.peopleNum = peopleNum;
  }
 
  /**
   * 联系电话 getter
   */
  public java.lang.String getPhone(){
    return phone;
  }
  /**
   * 联系电话 setter
   * @param Phone
   */  
  public void setPhone(java.lang.String phone){
    this.phone = phone;
  }
 
  /**
   * 二维码 getter
   */
  public java.lang.String getPrintBarCode(){
    return printBarCode;
  }
  /**
   * 二维码 setter
   * @param PrintBarCode
   */  
  public void setPrintBarCode(java.lang.String printBarCode){
    this.printBarCode = printBarCode;
  }
 
  /**
   * 商品数量 getter
   */
  public java.lang.Integer getQuantity(){
    return quantity;
  }
  /**
   * 商品数量 setter
   * @param Quantity
   */  
  public void setQuantity(java.lang.Integer quantity){
    this.quantity = quantity;
  }
 
  /**
   * 物流单号 getter
   */
  public java.lang.String getShippingCode(){
    return shippingCode;
  }
  /**
   * 物流单号 setter
   * @param ShippingCode
   */  
  public void setShippingCode(java.lang.String shippingCode){
    this.shippingCode = shippingCode;
  }
 
  /**
   * 物流公司 getter
   */
  public java.lang.Long getShippingCorpID(){
    return shippingCorpID;
  }
  /**
   * 物流公司 setter
   * @param ShippingCorpID
   */  
  public void setShippingCorpID(java.lang.Long shippingCorpID){
    this.shippingCorpID = shippingCorpID;
  }
 
  /**
   * 发货方式 getter
   */
  public java.lang.Long getShippingType(){
    return shippingType;
  }
  /**
   * 发货方式 setter
   * @param ShippingType
   */  
  public void setShippingType(java.lang.Long shippingType){
    this.shippingType = shippingType;
  }
 
  /**
   * 商品总额 getter
   */
  public java.math.BigDecimal getTotalAmount(){
    return totalAmount;
  }
  /**
   * 商品总额 setter
   * @param TotalAmount
   */  
  public void setTotalAmount(java.math.BigDecimal totalAmount){
    this.totalAmount = totalAmount;
  }
 
  /**
   * 验证码 getter
   */
  public java.lang.String getValidationCode(){
    return validationCode;
  }
  /**
   * 验证码 setter
   * @param ValidationCode
   */  
  public void setValidationCode(java.lang.String validationCode){
    this.validationCode = validationCode;
  }
 
  /**
   * 供应商 getter
   */
  public java.lang.Long getVendorID(){
    return vendorID;
  }
  /**
   * 供应商 setter
   * @param VendorID
   */  
  public void setVendorID(java.lang.Long vendorID){
    this.vendorID = vendorID;
  }
 
  /**
   * 重量单位 getter
   */
  public java.lang.Long getWeightID(){
    return weightID;
  }
  /**
   * 重量单位 setter
   * @param WeightID
   */  
  public void setWeightID(java.lang.Long weightID){
    this.weightID = weightID;
  }
 
}