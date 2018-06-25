package cc.toprank.byd.web.vo.tablevo;

import java.time.LocalDateTime;

/**
 *
 * Created by HuTao on 2017-5-17.
 */
public class DeskChangeVO {
    private Long  changeID;       //   调整ID
    private String changeReason;  //  调整原因
    private String beforeName;   //   调整之前
    private String afterName;   //    调整之后
    private String creatorName;     //  操作人
    private LocalDateTime createTime;  //  操作时间

    public Long getChangeID() {
        return changeID;
    }

    public void setChangeID(Long changeID) {
        this.changeID = changeID;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public String getBeforeName() {
        return beforeName;
    }

    public void setBeforeName(String beforeName) {
        this.beforeName = beforeName;
    }

    public String getAfterName() {
        return afterName;
    }

    public void setAfterName(String afterName) {
        this.afterName = afterName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
