package cc.toprank.byd.web.vo.tablevo;

/**
 * 桌台负责人VO
 * Created by HuTao on 2017-5-16.
 */
public class DeskPersonInfoVO {
    private Long areaID;  // 区域ID
    private Long tableID;   //  桌台ID
    private String tableName; //  桌台名称
    private String  persons; //  负责人

    public Long getAreaID() {
        return areaID;
    }

    public void setAreaID(Long areaID) {
        this.areaID = areaID;
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

    public String getPersons() {
        return persons;
    }

    public void setPersons(String persons) {
        this.persons = persons;
    }
}
