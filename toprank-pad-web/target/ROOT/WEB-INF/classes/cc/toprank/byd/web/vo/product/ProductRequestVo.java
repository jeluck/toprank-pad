package cc.toprank.byd.web.vo.product;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.util.List;
import java.util.Map;

/**
 * 下单时商品的配置信息，包括规格、称重、口味做法等
 *
 * @author LinYN
 * @date 2017-4-21
 */
public class ProductRequestVo {

    private Long orderDetailID; // 订单明细编号

    private Integer quantity; // 商品数量

    private Long unitID; // 商品单位

    private Float weight; // 称重重量

    private Long weightID; // 称重单位编号

    private Long optionID; // 选项编号

    private List<Long> attributes; // 商品的口味做法

    private Long designerID; // 厨师编号

    private Long produceStatus; // 制作状态

    public Long getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(Long orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getUnitID() {
        return unitID;
    }

    public void setUnitID(Long unitID) {
        this.unitID = unitID;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Long getWeightID() {
        return weightID;
    }

    public void setWeightID(Long weightID) {
        this.weightID = weightID;
    }

    public Long getOptionID() {
        return optionID;
    }

    public void setOptionID(Long optionID) {
        this.optionID = optionID;
    }

    public List<Long> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Long> attributes) {
        this.attributes = attributes;
    }

    public Long getDesignerID() {
        return designerID;
    }

    public void setDesignerID(Long designerID) {
        this.designerID = designerID;
    }

    public Long getProduceStatus() {
        return produceStatus;
    }

    public void setProduceStatus(Long produceStatus) {
        this.produceStatus = produceStatus;
    }
}
