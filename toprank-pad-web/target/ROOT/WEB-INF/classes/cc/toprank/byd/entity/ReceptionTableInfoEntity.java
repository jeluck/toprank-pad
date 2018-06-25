package cc.toprank.byd.entity;

/*********************************************************************************************.
 * 
 * 
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 * 
 * <p></p>
 *********************************************************************************************/


public class ReceptionTableInfoEntity extends Entity{
  private long subOrderID;      //子订单ID
  private long orderID;         //订单ID
  private String tableNickName; //桌台名称
  private int peopleNum;        //就餐人数
  private double actualAmount;  //实际金额
  
  public long getSubOrderID() {
    return subOrderID;
  }
  public void setSubOrderID(long subOrderID) {
    this.subOrderID = subOrderID;
  }
  public long getOrderID() {
    return orderID;
  }
  public void setOrderID(long orderID) {
    this.orderID = orderID;
  }
  public String getTableNickName() {
    return tableNickName;
  }
  public void setTableNickName(String tableNickName) {
    this.tableNickName = tableNickName;
  }
  public int getPeopleNum() {
    return peopleNum;
  }
  public void setPeopleNum(int peopleNum) {
    this.peopleNum = peopleNum;
  }
  public double getActualAmount() {
    return actualAmount;
  }
  public void setActualAmount(double actualAmount) {
    this.actualAmount = actualAmount;
  }
  
}
