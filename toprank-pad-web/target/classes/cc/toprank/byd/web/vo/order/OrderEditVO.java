package cc.toprank.byd.web.vo.order;

import java.time.LocalDateTime;

/**
 *
 * Created by HuTao on 2017-4-20.
 *
 */
public class OrderEditVO {
    private Long orderID;       //  订单ID
    private Long subOrderID;    //  子订单ID
    private Long tableID;       //   桌台ID
    private String orderCode;   //   订单编号
    private String tableName;   //   桌台名称
    private int peopleNum;     //    人数
    private Long waiterLoginID; //    服务员登入ID
    private String  waiterName;  //   服务员名
    private String memo;          //     备注
    private String comTableCode;  //    关联桌台
    private LocalDateTime newCreateTime;
    private String  createTime;     //    开台时间

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getSubOrderID() {
        return subOrderID;
    }

    public void setSubOrderID(Long subOrderID) {
        this.subOrderID = subOrderID;
    }

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(int peopleNum) {
        this.peopleNum = peopleNum;
    }

    public Long getWaiterLoginID() {
        return waiterLoginID;
    }

    public void setWaiterLoginID(Long waiterLoginID) {
        this.waiterLoginID = waiterLoginID;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getComTableCode() {
        return comTableCode;
    }

    public void setComTableCode(String comTableCode) {
        this.comTableCode = comTableCode;
    }

    public LocalDateTime getNewCreateTime() {
        return newCreateTime;
    }

    public void setNewCreateTime(LocalDateTime newCreateTime) {
        this.newCreateTime = newCreateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
