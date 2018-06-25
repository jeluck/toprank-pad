package cc.toprank.byd.web.vo.tablevo;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.util.ArrayList;
import java.util.List;

/**
 * 桌台的请求参数VO
 *
 * @author LinYN
 * @since 2017-3-22
 */
public class TableRequestVo {

    private Long archiveID; // 机构编号

    private Long areaID; // 区域编号

    private Long tableID; // 当前桌台编号

    private Long targetTableID; // 目标桌台编号

    private List<Long> targetTableIDs = new ArrayList<Long>(); // 目标桌台编号（多选）

    private Boolean combine; // 拆分后的桌台是否再联台

    private Integer transferType; // 转台方式

    private Long subOrderID; // 当前桌台子订单编号

    private Long targetSubOrderID; // 目标桌台子订单编号

    private Integer customerNumber; // 人数

    private Long loginID; // 开台人ID

    private String memo; // 备注

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public Long getAreaID() {
        return areaID;
    }

    public void setAreaID(Long areaID) {
        this.areaID = areaID;
    }

    public Boolean getCombine() {
        return combine;
    }

    public void setCombine(Boolean combine) {
        this.combine = combine;
    }

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public Long getTargetTableID() {
        return targetTableID;
    }

    public void setTargetTableID(Long targetTableID) {
        this.targetTableID = targetTableID;
    }

    public List<Long> getTargetTableIDs() {
        return targetTableIDs;
    }

    public void setTargetTableIDs(List<Long> targetTableIDs) {
        this.targetTableIDs = targetTableIDs;
    }

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Long getSubOrderID() {
        return subOrderID;
    }

    public void setSubOrderID(Long subOrderID) {
        this.subOrderID = subOrderID;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
    }

    public Long getTargetSubOrderID() {
        return targetSubOrderID;
    }

    public void setTargetSubOrderID(Long targetSubOrderID) {
        this.targetSubOrderID = targetSubOrderID;
    }
}
