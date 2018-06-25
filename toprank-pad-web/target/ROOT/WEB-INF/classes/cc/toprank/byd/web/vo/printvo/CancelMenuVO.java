package cc.toprank.byd.web.vo.printvo;

/**
 * Created by HuTao on 2017-3-10.
 */
public class CancelMenuVO {
    private Long   variantID  ;     //  变体ID
    private String  productName;     //  菜品名称
    private int   quantity ;      //  菜品数量
    double  price       =4 ;      //  菜品单价
    private String    productUnit ;     //  菜品单位
    private Long    comboID   ;     //  套餐ID
    private String  cancelDesc ;     //  退菜原因
    private String  createTime ;     //  退菜时间

    public Long getVariantID() {
        return variantID;
    }

    public void setVariantID(Long variantID) {
        this.variantID = variantID;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Long getComboID() {
        return comboID;
    }

    public void setComboID(Long comboID) {
        this.comboID = comboID;
    }

    public String getCancelDesc() {
        return cancelDesc;
    }

    public void setCancelDesc(String cancelDesc) {
        this.cancelDesc = cancelDesc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
