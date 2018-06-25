package cc.toprank.byd.entity;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   继承自自动生成的实体，具体业务方法使用的实体类
 *   如果具体业务需要扩展字段，请扩展该类
 *
 * ********************************************************************************************************************/
public class P_ProductVariantInfoEntity extends P_ProductVariantInfoEntityBase {

    private Boolean needWeigh;          //需要称重

    private String dictionaryName;                //单位名称

    private double priceCopy;                     //价格

    private int quantity;               //数量

    private Long categoryID;
    private String categoryName;
    private String unitName;

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceCopy() {
        if (super.getPrice() != null) {
            priceCopy = super.getPrice().doubleValue();
        }
        return priceCopy;
    }

    public void setPriceCopy(double priceCopy) {
        this.priceCopy = priceCopy;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    public Boolean getNeedWeigh() {
        return needWeigh;
    }

    public void setNeedWeigh(Boolean needWeigh) {
        this.needWeigh = needWeigh;
    }


}