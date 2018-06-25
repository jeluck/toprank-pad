package cc.toprank.byd.entity;

import cc.toprank.byd.entity.Entity;
/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在O_ShoppingCartInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class O_ShoppingCartInfoEntityBase extends Entity {

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
   *	BookingID数据库列名
   */
  public final static java.lang.String BOOKINGID_FIELD =  "BookingID";
  
  /**
   *	BookingID字段中文名，用于视图展示
   */
  public final static java.lang.String BOOKINGID_LABLE = "预订编号";
  
  /**
   *	BookingID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long bookingID;
  
  /**
   *	CartID数据库列名
   */
  public final static java.lang.String CARTID_FIELD =  "CartID";
  
  /**
   *	CartID字段中文名，用于视图展示
   */
  public final static java.lang.String CARTID_LABLE = "购物车编号";
  
  /**
   *	CartID对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Long cartID;
  
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
   *	Quantity数据库列名
   */
  public final static java.lang.String QUANTITY_FIELD =  "Quantity";
  
  /**
   *	Quantity字段中文名，用于视图展示
   */
  public final static java.lang.String QUANTITY_LABLE = "数量";
  
  /**
   *	Quantity对应的java字段名,业务操作使用这个字段。
   */
  private java.lang.Integer quantity;
  
  /**
   *	TotalAmount数据库列名
   */
  public final static java.lang.String TOTALAMOUNT_FIELD =  "TotalAmount";
  
  /**
   *	TotalAmount字段中文名，用于视图展示
   */
  public final static java.lang.String TOTALAMOUNT_LABLE = "总价";
  
  /**
   *	TotalAmount对应的java字段名,业务操作使用这个字段。
   */
  private java.math.BigDecimal totalAmount;
  
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
   * 预订编号 getter
   */
  public java.lang.Long getBookingID(){
    return bookingID;
  }
  /**
   * 预订编号 setter
   * @param BookingID
   */  
  public void setBookingID(java.lang.Long bookingID){
    this.bookingID = bookingID;
  }
 
  /**
   * 购物车编号 getter
   */
  public java.lang.Long getCartID(){
    return cartID;
  }
  /**
   * 购物车编号 setter
   * @param CartID
   */  
  public void setCartID(java.lang.Long cartID){
    this.cartID = cartID;
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
   * 数量 getter
   */
  public java.lang.Integer getQuantity(){
    return quantity;
  }
  /**
   * 数量 setter
   * @param Quantity
   */  
  public void setQuantity(java.lang.Integer quantity){
    this.quantity = quantity;
  }
 
  /**
   * 总价 getter
   */
  public java.math.BigDecimal getTotalAmount(){
    return totalAmount;
  }
  /**
   * 总价 setter
   * @param TotalAmount
   */  
  public void setTotalAmount(java.math.BigDecimal totalAmount){
    this.totalAmount = totalAmount;
  }
 
}