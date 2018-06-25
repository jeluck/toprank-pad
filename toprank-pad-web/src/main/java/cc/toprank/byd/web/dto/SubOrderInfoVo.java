package cc.toprank.byd.web.dto;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 返回给前台的子订单VO
 *
 * @author LinYN
 * @since 2017-3-28
 */
public class SubOrderInfoVo {

    private Long subOrderID; // 子订单编号

    private Long orderID; // 订单编号

    private Long tableID; // 桌台编号

    private String tableName; // 桌台名称

    private Long mealsID; // 餐次编号

    private Long orderStatus; // 订单状态

    private Integer peopleNum; // 就餐人数

    private BigDecimal totalAmount; // 商品总额

    private BigDecimal actualAmount; // 实际金额

    private BigDecimal discountAmount; // 折扣金额

    private Integer quantity; // 商品数量

    private Integer servedNum; // 己上菜数量

    private String memo; // 备注

    private String SubOrderDesc; // 订单描述

    private LocalDateTime createTime; // 创建时间

    private Long creatorID;//创建者ID

    public Long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Long creatorID) {
        this.creatorID = creatorID;
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

    public Long getMealsID() {
        return mealsID;
    }

    public void setMealsID(Long mealsID) {
        this.mealsID = mealsID;
    }

    public Long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getServedNum() {
        return servedNum;
    }

    public void setServedNum(Integer servedNum) {
        this.servedNum = servedNum;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getSubOrderDesc() {
        return SubOrderDesc;
    }

    public void setSubOrderDesc(String subOrderDesc) {
        SubOrderDesc = subOrderDesc;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
