package cc.toprank.byd.vo.print;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 结账单 / 暂结单
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class SettleInfoVO extends BusinessVO {

    private String area; // 区域
    private String meals; // 餐次
    private String table; // 桌台
    private String targetTable; // 目标桌台
    private String relationTables; // 相关餐台
    private Integer peopleNum; // 人数
    private Integer duration; // 就餐时长
    private String orderNo; // 订单号
    private String waiter; // 服务员
    private LocalDateTime operationTime; // 操作时间
    private String operator; // 操作人
    private String barCode; // 条形码
    private Integer totalQuantity; // 总数量
    private BigDecimal totalAmount; // 总金额
    private BigDecimal giveAmount; // 赠送金额
    private BigDecimal discountAmount; // 折扣金额
    private String discountAuthor; // 折扣人
    private BigDecimal reduceAmount; // 减免金额
    private String reduceAuthor; // 减免人
    private BigDecimal serviceAmount; // 服务费
    private BigDecimal smallAmount; // 抹零
    private BigDecimal actualAmount; // 应收金额
    private String payStatus; // 支付状态
    private String remark; // 开台备注
    private LocalDateTime startTime; // 开台时间
    private LocalDateTime orderTime; // 下单时间

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMeals() {
        return meals;
    }

    public void setMeals(String meals) {
        this.meals = meals;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(String targetTable) {
        this.targetTable = targetTable;
    }

    public String getRelationTables() {
        return relationTables;
    }

    public void setRelationTables(String relationTables) {
        this.relationTables = relationTables;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public LocalDateTime getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDateTime operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getGiveAmount() {
        return giveAmount;
    }

    public void setGiveAmount(BigDecimal giveAmount) {
        this.giveAmount = giveAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountAuthor() {
        return discountAuthor;
    }

    public void setDiscountAuthor(String discountAuthor) {
        this.discountAuthor = discountAuthor;
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public String getReduceAuthor() {
        return reduceAuthor;
    }

    public void setReduceAuthor(String reduceAuthor) {
        this.reduceAuthor = reduceAuthor;
    }

    public BigDecimal getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(BigDecimal serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public BigDecimal getSmallAmount() {
        return smallAmount;
    }

    public void setSmallAmount(BigDecimal smallAmount) {
        this.smallAmount = smallAmount;
    }

    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
}
