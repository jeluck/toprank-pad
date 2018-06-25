package cc.toprank.byd.web.vo.menu;

/**
 * Created by LanZY on 2017-5-20.
 */
public class OrderDetailOperationVO {
    private Long detailID;
    private int quantity;
    private Long recordID;

    public Long getDetailID() {
        return detailID;
    }

    public void setDetailID(Long detailID) {
        this.detailID = detailID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getRecordID() {
        return recordID;
    }

    public void setRecordID(Long recordID) {
        this.recordID = recordID;
    }
}
