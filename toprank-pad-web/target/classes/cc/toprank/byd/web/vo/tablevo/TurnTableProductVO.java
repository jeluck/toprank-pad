package cc.toprank.byd.web.vo.tablevo;

/**
 * Created by LanZY on 2017-6-14.
 */
public class TurnTableProductVO {

    private Long tableID;
    private String tableName;
    private Integer quantity;

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
