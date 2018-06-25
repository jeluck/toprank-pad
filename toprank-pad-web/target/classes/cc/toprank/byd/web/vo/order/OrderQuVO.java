package cc.toprank.byd.web.vo.order;

/**
 * Created by HuTao on 2017-5-3.
 */
public class OrderQuVO {
    private  Long orderStatus; //  消费中 已暂结  已结帐  反结帐  已取消
    private  int dateSign;     //  1 当前班次  2今天   3  昨天       4  历史日期
    private String mealName;   //  餐次
    private String tableName;  //  桌台
    private String orderCode;  // 订单号
    private String cashierName; //  收银员
    private String  postName;  //  收银机
    private String  startDate; //  开台日期
    private String  endDate;   //  结束日期

    public Long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getDateSign() {
        return dateSign;
    }

    public void setDateSign(int dateSign) {
        this.dateSign = dateSign;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
