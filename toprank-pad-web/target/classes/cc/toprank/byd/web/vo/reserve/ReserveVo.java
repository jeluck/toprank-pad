package cc.toprank.byd.web.vo.reserve;

import cc.toprank.byd.entity.Entity;

/**
 * @author 赵凌晨
 * @version 2.0.0
 * @description 预定Vo类
 * @time 2017-03-28
 */
public class ReserveVo extends Entity{
    private Long loginID;
    private Long orgID;
    private Long archiveID;
    private Long customerID;
    private Long areaID;
    private Integer quantity;//份数
    private Long mealsID;
    private String startTime;
    private String contact;//姓名
    private Long gender;//性别
    private String phone;
    private Integer peopleNum;//人数
    private String tableIDs;
    private String bookingTime;//预订时
    private Long bookingType;//预订方式
    private Integer duration;//就餐时长
    private String memo;
    private Long bookingChannel;
    private Double bookingAmount;
    private String subOrderIDs;
    private String shoppingCarts;

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getAreaID() {
        return areaID;
    }

    public void setAreaID(Long areaID) {
        this.areaID = areaID;
    }

    public Long getMealsID() {
        return mealsID;
    }

    public void setMealsID(Long mealsID) {
        this.mealsID = mealsID;
    }

    public Integer getQuantity() { return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public String getStartTime() {return startTime;}

    public void setStartTime(String startTime) {this.startTime = startTime;}

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

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public String getTableIDs() {
        return tableIDs;
    }

    public void setTableIDs(String tableIDs) {
        this.tableIDs = tableIDs;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
    }

    public Long getBookingType() {
        return bookingType;
    }

    public void setBookingType(Long bookingType) {
        this.bookingType = bookingType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Long getGender() {
        return gender;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public Long getBookingChannel() {
        return bookingChannel;
    }

    public void setBookingChannel(Long bookingChannel) {
        this.bookingChannel = bookingChannel;
    }

    public Double getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(Double bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public String getSubOrderIDs() {
        return subOrderIDs;
    }

    public void setSubOrderIDs(String subOrderIDs) {
        this.subOrderIDs = subOrderIDs;
    }

    public String getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(String shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }
}
