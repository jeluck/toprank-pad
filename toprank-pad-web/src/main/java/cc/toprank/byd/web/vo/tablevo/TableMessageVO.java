package cc.toprank.byd.web.vo.tablevo;

/**
 * Created by HuTao on 2017-3-13.
 */
public class TableMessageVO {
    private Long  tableID ;		    //  桌号
    private String tableName ;		//  桌名
    private String shareTableName ;		//  并桌名
    private int  defaultPerson;	  //  缺省的人数
    private String nickName;		  //  客户名称
    private double actualAmount;            //  实际消费金额
    private Long    tableStatus;		  //  餐桌状态
    private String  combineName ; //  桌台的别名  联台（联系，联2，联3）
    private Long    areaID ;		  //  区域id
    private int  customerNumber ;        //  就餐人数
    private Long    bookingID;      //  预定id
    private Long    subOrderID;     //  子订单ID
    private Long    orderID;        //  订单ID
    private Long    loginID;	      //  预订人id
    private Long    mealsID;		  //  餐次ID
    private int    times;           //   就餐是时长  分钟
    private int    shareNumber;    //   拼桌数量
    private String areaName;      //   区域名称
    private Long areaType;      // 桌台区域类别
    private String areaTypeName;  //   桌台区域类别名称

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getShareTableName() {
        return shareTableName;
    }

    public void setShareTableName(String shareTableName) {
        this.shareTableName = shareTableName;
    }

    public int getDefaultPerson() {
        return defaultPerson;
    }

    public void setDefaultPerson(int defaultPerson) {
        this.defaultPerson = defaultPerson;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public Long getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Long tableStatus) {
        this.tableStatus = tableStatus;
    }

    public String getCombineName() {
        return combineName;
    }

    public void setCombineName(String combineName) {
        this.combineName = combineName;
    }

    public Long getAreaID() {
        return areaID;
    }

    public void setAreaID(Long areaID) {
        this.areaID = areaID;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Long getBookingID() {
        return bookingID;
    }

    public void setBookingID(Long bookingID) {
        this.bookingID = bookingID;
    }

    public Long getSubOrderID() {
        return subOrderID;
    }

    public void setSubOrderID(Long subOrderID) {
        this.subOrderID = subOrderID;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
    }

    public Long getMealsID() {
        return mealsID;
    }

    public void setMealsID(Long mealsID) {
        this.mealsID = mealsID;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(int shareNumber) {
        this.shareNumber = shareNumber;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getAreaType() {
        return areaType;
    }

    public void setAreaType(Long areaType) {
        this.areaType = areaType;
    }

    public String getAreaTypeName() {
        return areaTypeName;
    }

    public void setAreaTypeName(String areaTypeName) {
        this.areaTypeName = areaTypeName;
    }
}
