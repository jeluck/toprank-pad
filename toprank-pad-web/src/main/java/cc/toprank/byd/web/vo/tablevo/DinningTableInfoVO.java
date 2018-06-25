package cc.toprank.byd.web.vo.tablevo;

import cc.toprank.byd.web.dto.SubOrderInfoVo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by ZhouWei on 2017-3-29.
 */
public class DinningTableInfoVO {
    private Long tableID;

    private Long archiveID;

    private Long areaID;

    private String tableCode;

    private String qRCode;

    private String tableName;

    private Integer defaultPerson;

    private Integer maxPerson;

    private Integer minPerson;

    private Long tableStatus;

    private BigDecimal minConsumption;

    private BigDecimal highestConsumption;

    private Boolean canBooking;

    private Boolean canSharing;

    private Boolean canCombine;

    private Boolean canSplit;

    private Integer shareNumber;

    private String shareCode;

    private Integer combineNumber;

    private String combineName;

    private String combineCode;

    private Integer splitNumber;

    private String splitCode;

    private String tableDesc;

    private Integer sortNo;

    private Boolean isSync;

    private Long creatorID;

    private LocalDateTime createTime;

    private Long waiterLoginId; //服务员
    private String bookingCode; //预定编码
    private Long bookingID;
    private Long bookingStatus; //预定状态
    private Long bookingType;//预定方式
    private LocalDateTime bookingTime; //预定时间
    private Long PaymentMethodID;//支付方式
    private LocalDateTime arrivalTime;//就餐时间
    private BigDecimal bookingAmount;//预定金额
    private String contact;//联系人
    private String phone;//联系电话
    private String memo;//备注

    private Long subOrderID ;//子订单编号
    private Long subOrderStatus; //订单状态
    private BigDecimal subTotalAmount;//订单总额
    private Long unServedNum;//未上菜数量
    private Long servedNum;//上菜数量
    private Long subUnServedNum;//子订单未上菜数量
    private Long subServedNum;//子订单上菜数量
    private String subNickName;//昵称
    private Integer subPeopleNum;//就餐人数
    private Integer customerNumber;//消费人数
    private List<TableMessageVO> combineTableInfoList; //联桌集合
    private List<SubOrderInfoVo> shareTableInfoList; //拼桌信息

    private String tableNames;//联桌桌台
    private Long orderID; //总订单号
    private BigDecimal TotalAmount ;//总订单金额
    private String nickName;//总订单昵称
    private Long orderStatus;//总订单状态
    private Integer peopleNum;//总订单就餐人数
    private String shareTableName;
    private String orderCode;//订单编号

    public Long getBookingID() {
        return bookingID;
    }

    public void setBookingID(Long bookingID) {
        this.bookingID = bookingID;
    }

    public Long getBookingType() {
        return bookingType;
    }

    public void setBookingType(Long bookingType) {
        this.bookingType = bookingType;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getShareTableName() {
        return shareTableName;
    }

    public void setShareTableName(String shareTableName) {
        this.shareTableName = shareTableName;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

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

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getqRCode() {
        return qRCode;
    }

    public void setqRCode(String qRCode) {
        this.qRCode = qRCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getDefaultPerson() {
        return defaultPerson;
    }

    public void setDefaultPerson(Integer defaultPerson) {
        this.defaultPerson = defaultPerson;
    }

    public Integer getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(Integer maxPerson) {
        this.maxPerson = maxPerson;
    }

    public Integer getMinPerson() {
        return minPerson;
    }

    public void setMinPerson(Integer minPerson) {
        this.minPerson = minPerson;
    }

    public Long getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Long tableStatus) {
        this.tableStatus = tableStatus;
    }

    public BigDecimal getMinConsumption() {
        return minConsumption;
    }

    public void setMinConsumption(BigDecimal minConsumption) {
        this.minConsumption = minConsumption;
    }

    public BigDecimal getHighestConsumption() {
        return highestConsumption;
    }

    public void setHighestConsumption(BigDecimal highestConsumption) {
        this.highestConsumption = highestConsumption;
    }

    public Boolean getCanBooking() {
        return canBooking;
    }

    public void setCanBooking(Boolean canBooking) {
        this.canBooking = canBooking;
    }

    public Boolean getCanSharing() {
        return canSharing;
    }

    public void setCanSharing(Boolean canSharing) {
        this.canSharing = canSharing;
    }

    public Boolean getCanCombine() {
        return canCombine;
    }

    public void setCanCombine(Boolean canCombine) {
        this.canCombine = canCombine;
    }

    public Boolean getCanSplit() {
        return canSplit;
    }

    public void setCanSplit(Boolean canSplit) {
        this.canSplit = canSplit;
    }

    public Integer getShareNumber() {
        return shareNumber;
    }

    public void setShareNumber(Integer shareNumber) {
        this.shareNumber = shareNumber;
    }

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode;
    }

    public Integer getCombineNumber() {
        return combineNumber;
    }

    public void setCombineNumber(Integer combineNumber) {
        this.combineNumber = combineNumber;
    }

    public String getCombineName() {
        return combineName;
    }

    public void setCombineName(String combineName) {
        this.combineName = combineName;
    }

    public String getCombineCode() {
        return combineCode;
    }

    public void setCombineCode(String combineCode) {
        this.combineCode = combineCode;
    }

    public Integer getSplitNumber() {
        return splitNumber;
    }

    public void setSplitNumber(Integer splitNumber) {
        this.splitNumber = splitNumber;
    }

    public String getSplitCode() {
        return splitCode;
    }

    public void setSplitCode(String splitCode) {
        this.splitCode = splitCode;
    }

    public String getTableDesc() {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Boolean getSync() {
        return isSync;
    }

    public void setSync(Boolean sync) {
        isSync = sync;
    }

    public Long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Long creatorID) {
        this.creatorID = creatorID;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    private String areaName;//区域名称

    public Long getSubOrderStatus() {
        return subOrderStatus;
    }

    public Long getSubUnServedNum() {
        return subUnServedNum;
    }

    public void setSubUnServedNum(Long subUnServedNum) {
        this.subUnServedNum = subUnServedNum;
    }

    public Long getSubServedNum() {
        return subServedNum;
    }

    public void setSubServedNum(Long subServedNum) {
        this.subServedNum = subServedNum;
    }

    public void setSubOrderStatus(Long subOrderStatus) {
        this.subOrderStatus = subOrderStatus;
    }

    public BigDecimal getSubTotalAmount() {
        return subTotalAmount;
    }

    public void setSubTotalAmount(BigDecimal subTotalAmount) {
        this.subTotalAmount = subTotalAmount;
    }

    public String getSubNickName() {
        return subNickName;
    }

    public void setSubNickName(String subNickName) {
        this.subNickName = subNickName;
    }

    public Integer getSubPeopleNum() {
        return subPeopleNum;
    }

    public void setSubPeopleNum(Integer subPeopleNum) {
        this.subPeopleNum = subPeopleNum;
    }

    public BigDecimal getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        TotalAmount = totalAmount;
    }

    public Long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTableNames() {
        return tableNames;
    }

    public void setTableNames(String tableNames) {
        this.tableNames = tableNames;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getWaiterLoginId() {
        return waiterLoginId;
    }

    public void setWaiterLoginId(Long waiterLoginId) {
        this.waiterLoginId = waiterLoginId;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public Long getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Long bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Long getPaymentMethodID() {
        return PaymentMethodID;
    }

    public void setPaymentMethodID(Long paymentMethodID) {
        PaymentMethodID = paymentMethodID;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public BigDecimal getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(BigDecimal bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getSubOrderID() {
        return subOrderID;
    }

    public void setSubOrderID(Long subOrderID) {
        this.subOrderID = subOrderID;
    }


    public Long getUnServedNum() {
        return unServedNum;
    }

    public void setUnServedNum(Long unServedNum) {
        this.unServedNum = unServedNum;
    }

    public Long getServedNum() {
        return servedNum;
    }

    public void setServedNum(Long servedNum) {
        this.servedNum = servedNum;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public List<TableMessageVO> getCombineTableInfoList() {
        return combineTableInfoList;
    }

    public void setCombineTableInfoList(List<TableMessageVO> combineTableInfoList) {
        this.combineTableInfoList = combineTableInfoList;
    }

    public List<SubOrderInfoVo> getShareTableInfoList() {
        return shareTableInfoList;
    }

    public void setShareTableInfoList(List<SubOrderInfoVo> shareTableInfoList) {
        this.shareTableInfoList = shareTableInfoList;
    }
}
