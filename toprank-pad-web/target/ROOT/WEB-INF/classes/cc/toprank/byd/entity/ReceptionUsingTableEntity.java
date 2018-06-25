package cc.toprank.byd.entity;

/*********************************************************************************************.
 * 
 * 
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 * 
 * <p></p>
 *********************************************************************************************/

/**
 * 桌台处于使用状态的帮助类
 * @author XuJin
 *
 */
public class ReceptionUsingTableEntity extends Entity{
  private double actualAmount;//实际消费
  private int peopleNum;      //就餐人数
  private long OrderID;       //订单id
  private long SubOrderID;    //子订单id

  private int togetherNum;    //  拼桌数
  private int times;          //   时间长
  private String combineName;  //  联台
  
  public double getActualAmount() {
    return actualAmount;
  }
  public void setActualAmount(double actualAmount) {
    this.actualAmount = actualAmount;
  }
  public int getPeopleNum() {
    return peopleNum;
  }
  public void setPeopleNum(int peopleNum) {
    this.peopleNum = peopleNum;
  }
  public long getOrderID() {
    return OrderID;
  }
  public void setOrderID(long orderID) {
    OrderID = orderID;
  }
  public long getSubOrderID() {
    return SubOrderID;
  }
  public void setSubOrderID(long subOrderID) {
    SubOrderID = subOrderID;
  }

  public int getTogetherNum() {
    return togetherNum;
  }

  public void setTogetherNum(int togetherNum) {
    this.togetherNum = togetherNum;
  }

  public int getTimes() {
    return times;
  }

  public void setTimes(int times) {
    this.times = times;
  }

  public String getCombineName() {
    return combineName;
  }

  public void setCombineName(String combineName) {
    this.combineName = combineName;
  }
}
