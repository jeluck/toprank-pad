package cc.toprank.byd.web.vo.order;

import cc.toprank.byd.enums.OrderManagerEnum;

import java.io.Serializable;

/**
 * Created by LiuHM on 2017-6-6.
 */
public class RefundQueryVO implements Serializable {

    private Long archiveID;
    private Integer dateFlag = 0;
    private String bookingCode;
    private String dealUer;
    private String refundDateStart;
    private String refundDateEnd;
    private Long refundStatus = OrderManagerEnum.RefundStatus.REFUNDSUCCESS.getValue();
    public Integer getDateFlag() {
        return dateFlag;
    }

    public void setDateFlag(Integer dateFlag) {
        this.dateFlag = dateFlag;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getDealUer() {
        return dealUer;
    }

    public void setDealUer(String dealUer) {
        this.dealUer = dealUer;
    }

    public String getRefundDateStart() {
        return refundDateStart;
    }

    public void setRefundDateStart(String refundDateStart) {
        this.refundDateStart = refundDateStart;
    }

    public String getRefundDateEnd() {
        return refundDateEnd;
    }

    public void setRefundDateEnd(String refundDateEnd) {
        this.refundDateEnd = refundDateEnd;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public Long getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Long refundStatus) {
        this.refundStatus = refundStatus;
    }
}
