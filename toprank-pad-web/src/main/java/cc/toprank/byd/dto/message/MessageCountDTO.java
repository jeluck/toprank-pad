package cc.toprank.byd.dto.message;

import java.math.BigDecimal;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-6-14 11:10
 */
public class MessageCountDTO {
    private Long settingID;
    private String settingDesc;
    private BigDecimal num;

    public MessageCountDTO(Long settingID, String settingDesc, BigDecimal num) {
        this.settingID = settingID;
        this.settingDesc = settingDesc;
        this.num = num;
    }

    public Long getSettingID() {
        return settingID;
    }

    public void setSettingID(Long settingID) {
        this.settingID = settingID;
    }

    public String getSettingDesc() {
        return settingDesc;
    }

    public void setSettingDesc(String settingDesc) {
        this.settingDesc = settingDesc;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }
}
