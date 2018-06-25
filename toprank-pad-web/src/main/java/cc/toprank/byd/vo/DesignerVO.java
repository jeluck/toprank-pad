package cc.toprank.byd.vo;

import java.math.BigDecimal;

/**
 * 厨师信息
 *
 * @author LeeJun
 * @create 2017-05-23 14:06
 */
public class DesignerVO {
    private Long designerID;
    private String designerName;
    private String picture;
    private Long designerLevel;
    private BigDecimal produceCost;
    private int praiseNum;

    public Long getDesignerID() {
        return designerID;
    }

    public void setDesignerID(Long designerID) {
        this.designerID = designerID;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getDesignerLevel() {
        return designerLevel;
    }

    public void setDesignerLevel(Long designerLevel) {
        this.designerLevel = designerLevel;
    }

    public BigDecimal getProduceCost() {
        return produceCost;
    }

    public void setProduceCost(BigDecimal produceCost) {
        this.produceCost = produceCost;
    }

    public int getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(int praiseNum) {
        this.praiseNum = praiseNum;
    }
}
