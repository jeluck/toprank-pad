package cc.toprank.byd.web.vo.menu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LanZY on 2017-5-17.
 */
public class OrderDetailResultVO {

    private BigDecimal totalAmount;
    private Long detailID;
    private String tagIDs;
    private List<ComboDetailVO> comboDetailList = new ArrayList<>();


    private BigDecimal subTotalAmount;
    private int subNum;
    private List<Long> detailIDs = new ArrayList<>();

    public List<Long> getDetailIDs() {
        return detailIDs;
    }

    public void setDetailIDs(List<Long> detailIDs) {
        this.detailIDs = detailIDs;
    }

    public BigDecimal getSubTotalAmount() {
        return subTotalAmount;
    }

    public void setSubTotalAmount(BigDecimal subTotalAmount) {
        this.subTotalAmount = subTotalAmount;
    }

    public int getSubNum() {
        return subNum;
    }

    public void setSubNum(int subNum) {
        this.subNum = subNum;
    }

    public List<ComboDetailVO> getComboDetailList() {
        return comboDetailList;
    }

    public void setComboDetailList(List<ComboDetailVO> comboDetailList) {
        this.comboDetailList = comboDetailList;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getDetailID() {
        return detailID;
    }

    public void setDetailID(Long detailID) {
        this.detailID = detailID;
    }

    public String getTagIDs() {
        return tagIDs;
    }

    public void setTagIDs(String tagIDs) {
        this.tagIDs = tagIDs;
    }

    public static class ComboDetailVO {
        private Long recordID;
        private String tagIDs;                  //标签  免做,先做,打包,催菜

        public Long getRecordID() {
            return recordID;
        }

        public void setRecordID(Long recordID) {
            this.recordID = recordID;
        }

        public String getTagIDs() {
            return tagIDs;
        }

        public void setTagIDs(String tagIDs) {
            this.tagIDs = tagIDs;
        }
    }
}
