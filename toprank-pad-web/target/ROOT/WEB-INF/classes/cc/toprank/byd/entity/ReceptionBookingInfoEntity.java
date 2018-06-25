package cc.toprank.byd.entity;

/*********************************************************************************************
 * .
 * 
 * 
 * <p>
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 * 
 * <p>
 * </p>
 *********************************************************************************************/


public class ReceptionBookingInfoEntity {
  private long bookingID;       // 预订id
  private long tableID;         // 桌子id
  private long segmentID;       // 餐段id
  private long mealsID;         // 餐次id
  private String tableCodes;    // 桌子编码
  private String bookingDesc;   // 预订描述信息
  private int peopleNum ;       // 就餐人数
  private long orderID;         // 订单id
  private long loginID;         // 预订人id

  public long getOrderID() {
    return orderID;
  }

  public void setOrderID(long orderID) {
    this.orderID = orderID;
  }

  public long getLoginID() {
    return loginID;
  }

  public void setLoginID(long loginID) {
    this.loginID = loginID;
  }

  public long getBookingID() {
    return bookingID;
  }

  public void setBookingID(long bookingID) {
    this.bookingID = bookingID;
  }

  public long getTableID() {
    return tableID;
  }

  public void setTableID(long tableID) {
    this.tableID = tableID;
  }

  public long getSegmentID() {
    return segmentID;
  }

  public void setSegmentID(long segmentID) {
    this.segmentID = segmentID;
  }

  public long getMealsID() {
    return mealsID;
  }

  public void setMealsID(long mealsID) {
    this.mealsID = mealsID;
  }

  public String getTableCodes() {
    return tableCodes;
  }

  public void setTableCodes(String tableCodes) {
    this.tableCodes = tableCodes;
  }

  public String getBookingDesc() {
    return bookingDesc;
  }

  public void setBookingDesc(String bookingDesc) {
    this.bookingDesc = bookingDesc;
  }

  public int getPeopleNum() {
    return peopleNum;
  }

  public void setPeopleNum(int peopleNum) {
    this.peopleNum = peopleNum;
  }

}
