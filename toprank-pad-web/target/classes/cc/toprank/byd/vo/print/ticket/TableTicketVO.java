package cc.toprank.byd.vo.print.ticket;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.vo.print.TableInfoVO;
import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 总单 / 分单
 *
 * @author LinYN
 * @date 2017-6-5
 */
public class TableTicketVO extends PrinterTicketVO {

    private TableInfoVO tableInfo = new TableInfoVO(); // 总单 / 分单

    private List<ProductDetailTicketVO> details; // 菜品明细

    public void setTableInfo(TableInfoVO tableInfo) {
        this.tableInfo = tableInfo;
    }

    public List<ProductDetailTicketVO> getDetails() {
        return details;
    }

    public void setDetails(List<ProductDetailTicketVO> details) {
        this.details = details;
    }

    public String getArea() {
        return tableInfo.getArea();
    }

    public void setArea(String area) {
        tableInfo.setArea(area);
    }

    public String getTable() {
        return tableInfo.getTable();
    }

    public void setTable(String table) {
        tableInfo.setTable(table);
    }

    public String getRelationTables() {
        return tableInfo.getRelationTables();
    }

    public void setRelationTables(String relationTables) {
        tableInfo.setRelationTables(relationTables);
    }

    public Integer getPeopleNum() {
        return tableInfo.getPeopleNum();
    }

    public void setPeopleNum(Integer peopleNum) {
        tableInfo.setPeopleNum(peopleNum);
    }

    public String getOrderNo() {
        return tableInfo.getOrderNo();
    }

    public void setOrderNo(String orderNo) {
        tableInfo.setOrderNo(orderNo);
    }

    public String getWaiter() {
        return tableInfo.getWaiter();
    }

    public void setWaiter(String waiter) {
        tableInfo.setWaiter(waiter);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getOperationTime() {
        return tableInfo.getOperationTime();
    }

    public void setOperationTime(LocalDateTime operationTime) {
        tableInfo.setOperationTime(operationTime);
    }

    public String getOperator() {
        return tableInfo.getOperator();
    }

    public void setOperator(String operator) {
        tableInfo.setOperator(operator);
    }

    public Integer getTotalQuantity() {
        return tableInfo.getTotalQuantity();
    }

    public void setTotalQuantity(Integer totalQuantity) {
        tableInfo.setTotalQuantity(totalQuantity);
    }

    public BigDecimal getTotalAmount() {
        return tableInfo.getTotalAmount();
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        tableInfo.setTotalAmount(totalAmount);
    }

    public String getBarCode() {
        return tableInfo.getBarCode();
    }

    public void setBarCode(String barCode) {
        tableInfo.setBarCode(barCode);
    }

    public String getRemark() {
        return tableInfo.getRemark();
    }

    public void setRemark(String remark) {
        tableInfo.setRemark(remark);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getStartTime() {
        return tableInfo.getStartTime();
    }

    public void setStartTime(LocalDateTime startTime) {
        tableInfo.setStartTime(startTime);
    }

    public String getMeals() {
        return tableInfo.getMeals();
    }

    public void setMeals(String meals) {
        tableInfo.setMeals(meals);
    }

    public Integer getDuration() {
        return tableInfo.getDuration();
    }

    public void setDuration(Integer duration) {
        tableInfo.setDuration(duration);
    }
}
