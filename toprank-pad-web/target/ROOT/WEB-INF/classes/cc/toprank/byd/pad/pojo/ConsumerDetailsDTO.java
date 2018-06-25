package cc.toprank.byd.pad.pojo;

import java.math.BigDecimal;

/**
 * 消费明细DTO
 *
 * @author LeeJun
 * @create 2017-05-18 9:26
 */
public class ConsumerDetailsDTO {

    // 明细ID
    private Long detailID;
    // 菜品名称
    private String productName;
    private float expectedWeight;
    // 数量
    private int quantity;
    // 份数
    private String productUnit;
    // 价格
    private BigDecimal price;
    // 加工费
    private BigDecimal produceCost;
    // 属性值（口味、做法等）
    private String attributeValue;
    // 规格
    private String optionName;
    // 点菜方式值 684（正常点菜）685（退菜） 686（赠菜） 687（加菜） 871（打包） 872（转赠）
    private long aLaCarteMethod;
    // 点菜方式名称
    private String aLaCarteName;
    // 制作状态值 692（未知） 693（制作中） 694（等叫） 695（催菜） 696（加急） 697（延时） 698（超时） 699（划单） 828（待确认） 829（已称重）830（待称重） 868（完成） 869（先做） 870（免做）
    private long produceStatus;
    // 制作状态名称
    private String produceStatusName;
    // 菜品备注
    private String memo;

    public float getExpectedWeight() {
        return expectedWeight;
    }

    public void setExpectedWeight(float expectedWeight) {
        this.expectedWeight = expectedWeight;
    }

    public Long getDetailID() {
        return detailID;
    }

    public void setDetailID(Long detailID) {
        this.detailID = detailID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProduceCost() {
        return produceCost;
    }

    public void setProduceCost(BigDecimal produceCost) {
        this.produceCost = produceCost;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public long getaLaCarteMethod() {
        return aLaCarteMethod;
    }

    public void setaLaCarteMethod(long aLaCarteMethod) {
        this.aLaCarteMethod = aLaCarteMethod;
    }

    public String getaLaCarteName() {
        return aLaCarteName;
    }

    public void setaLaCarteName(String aLaCarteName) {
        this.aLaCarteName = aLaCarteName;
    }

    public long getProduceStatus() {
        return produceStatus;
    }

    public void setProduceStatus(long produceStatus) {
        this.produceStatus = produceStatus;
    }

    public String getProduceStatusName() {
        return produceStatusName;
    }

    public void setProduceStatusName(String produceStatusName) {
        this.produceStatusName = produceStatusName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
