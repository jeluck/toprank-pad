package cc.toprank.byd.web.vo.reserve;

import com.wordnik.swagger.annotations.ApiModel;

/**
 * @author Zhaolingchen
 * @version 2.0.0
 * @description  搜索预订列表信息VO类
 * @time 2017-05-17 11:00:00
 */
public class QueryReserveVO {
    private Long archiveID;
    private String startTime;
    private String endTime;
    private Long bookingStatus;
    private Long bookingChannel;
    private Long bookingType;
    private Long mealsID;
    private String segment;

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Long bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Long getBookingChannel() {
        return bookingChannel;
    }

    public void setBookingChannel(Long bookingChannel) {
        this.bookingChannel = bookingChannel;
    }

    public Long getBookingType() {
        return bookingType;
    }

    public void setBookingType(Long bookingType) {
        this.bookingType = bookingType;
    }

    public Long getMealsID() {
        return mealsID;
    }

    public void setMealsID(Long mealsID) {
        this.mealsID = mealsID;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }
}
