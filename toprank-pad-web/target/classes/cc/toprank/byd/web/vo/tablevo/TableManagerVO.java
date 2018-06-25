package cc.toprank.byd.web.vo.tablevo;

import java.util.List;

/**
 * Created by LiuXJ on 2017-6-7.
 */
public class TableManagerVO {

    private Long tableID;
    private Long archiveID;
    private String tableCode;
    private String tableName;
    private List<TableManagerSettingVO> dutyVOList;

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

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<TableManagerSettingVO> getDutyVOList() {
        return dutyVOList;
    }

    public void setDutyVOList(List<TableManagerSettingVO> dutyVOList) {
        this.dutyVOList = dutyVOList;
    }
}
