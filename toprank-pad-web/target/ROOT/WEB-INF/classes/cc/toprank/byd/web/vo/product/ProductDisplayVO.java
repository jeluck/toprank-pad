package cc.toprank.byd.web.vo.product;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/



/**
 * @author LinYN
 * @date 2017-6-15
 */
public class ProductDisplayVO {

    private Long detailID; // 明细编号
    private Long subOrderID; // 子订单编号
    private String productName; // 菜名
    private Integer quantity; // 数量
    private Float weight; // 重量
    private String unit; // 单位
    private Boolean isCombo; // 是否套餐

    public Long getDetailID() {
        return detailID;
    }

    public void setDetailID(Long detailID) {
        this.detailID = detailID;
    }

    public Long getSubOrderID() {
        return subOrderID;
    }

    public void setSubOrderID(Long subOrderID) {
        this.subOrderID = subOrderID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getCombo() {
        return isCombo;
    }

    public void setCombo(Boolean combo) {
        isCombo = combo;
    }
}
