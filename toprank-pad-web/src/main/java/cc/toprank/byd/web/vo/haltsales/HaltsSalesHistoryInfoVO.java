package cc.toprank.byd.web.vo.haltsales;

import java.time.LocalDateTime;

/**
 * Created by ChenKY on 2017/5/12.
 */
public class HaltsSalesHistoryInfoVO {
    private String productName;       //菜品名称
    private Long menuID;              //菜单ID
    private String unit;              //单位
    private Long creatorID;           //创建人
    private String creatorName;      //创建人
    private LocalDateTime createTime;  //创建时间


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getMenuID() {
        return menuID;
    }

    public void setMenuID(Long menuID) {
        this.menuID = menuID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Long creatorID) {
        this.creatorID = creatorID;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
