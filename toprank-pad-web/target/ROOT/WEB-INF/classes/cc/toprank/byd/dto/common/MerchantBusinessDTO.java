package cc.toprank.byd.dto.common;

import java.time.LocalDateTime;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-6-16 15:25
 */
public class MerchantBusinessDTO {
    private Long archiveID;
    private String weekDay;
    private LocalDateTime openTime;
    private LocalDateTime closeTime;


    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalDateTime openTime) {
        this.openTime = openTime;
    }

    public LocalDateTime getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(LocalDateTime closeTime) {
        this.closeTime = closeTime;
    }
}
