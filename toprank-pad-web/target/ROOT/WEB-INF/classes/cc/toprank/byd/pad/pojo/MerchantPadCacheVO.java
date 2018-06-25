package cc.toprank.byd.pad.pojo;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-2-28 13:54
 */
public class MerchantPadCacheVO {

    // 商家ID
    private Long archiveID;
    private Long orgID;
    // pad对应桌台ID
    private Long tableID;
    private String tableName;
    private Long areaID;

    private Long tableManagerID;

    public Long getAreaID() {
        return areaID;
    }

    public void setAreaID(Long areaID) {
        this.areaID = areaID;
    }

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
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

    public Long getTableManagerID() {
        return tableManagerID;
    }

    public void setTableManagerID(Long tableManagerID) {
        this.tableManagerID = tableManagerID;
    }

    public Long getOrgID() {
        return orgID;
    }

    public void setOrgID(Long orgID) {
        this.orgID = orgID;
    }
}
