package cc.toprank.byd.dto.message;

import java.time.LocalDateTime;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-6-14 11:10
 */
public class MessageDTO {
    private Long messageID;
    private LocalDateTime createTime;
    private Long catalogID;
    private String settingDesc;
    private Long tableID;
    private String tableName;
    private Long subOrderID;
    private String sMSContent;
    private String nickName;
    private String statusDesc;
    private Long dictionaryID;

    public Long getMessageID() {
        return messageID;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getCatalogID() {
        return catalogID;
    }

    public void setCatalogID(Long catalogID) {
        this.catalogID = catalogID;
    }

    public String getSettingDesc() {
        return settingDesc;
    }

    public void setSettingDesc(String settingDesc) {
        this.settingDesc = settingDesc;
    }

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Long getSubOrderID() {
        return subOrderID;
    }

    public void setSubOrderID(Long subOrderID) {
        this.subOrderID = subOrderID;
    }

    public String getsMSContent() {
        return sMSContent;
    }

    public void setsMSContent(String sMSContent) {
        this.sMSContent = sMSContent;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public Long getDictionaryID() {
        return dictionaryID;
    }

    public void setDictionaryID(Long dictionaryID) {
        this.dictionaryID = dictionaryID;
    }

}
