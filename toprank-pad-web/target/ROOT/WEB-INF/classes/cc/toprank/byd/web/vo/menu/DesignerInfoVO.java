package cc.toprank.byd.web.vo.menu;

import java.math.BigDecimal;

/**
 * 厨师信息DTO
 * Created by HuangCY on 2017-4-20.
 */
public class DesignerInfoVO {
    //商品厨师关联ID
    private Long mappingID;
    //厨师星级
    private Long designerLevel;
    //加工费
    private BigDecimal produceCost;
    //厨师名称
    private String designerName;
    //厨师ID
    private Long designerID;
    //头像
    private String picture;
    //好评数、点赞数
    private Integer praiseNum;

    public Long getMappingID() {
        return mappingID;
    }

    public void setMappingID(Long mappingID) {
        this.mappingID = mappingID;
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

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public Long getDesignerID() {
        return designerID;
    }

    public void setDesignerID(Long designerID) {
        this.designerID = designerID;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }
}
