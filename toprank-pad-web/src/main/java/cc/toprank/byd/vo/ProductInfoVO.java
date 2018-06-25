package cc.toprank.byd.vo;

/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * <p></p>
 * @author LanZY
 *********************************************************************************************/


public class ProductInfoVO {
    private Long productID;            //菜品编号
    private String productName;       //菜品名称
    private double originalPrice;     //菜品原价
    private double price;             //价格
    private String barCode;           //菜品条码
    private int productType;          //菜品类型 1套餐 2一品一菜 3一品多菜
    private double produceCost;       //加工费
    private Long areaID;              //区域编号
    private Long mealsID;             //餐次编号
    private boolean needWeigh;        //需要称重   1.是 0.
    private Long menuID;              //菜单ID
    private long variantID;           // 变体id
    private String unit;              //单位
    private String tagIDs;            //标签ID以逗号分隔
    private int remainingQuantity;    //剩余数量
    private double RemainingFloatQuantity; //剩余小数
    private boolean curbSale;         //是否沽清 0.否 1.是
    private Long menuStatus;          //846 停售

    public Long getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(Long menuStatus) {
        this.menuStatus = menuStatus;
    }

    public int getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(int remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public double getRemainingFloatQuantity() {
        return RemainingFloatQuantity;
    }

    public void setRemainingFloatQuantity(double remainingFloatQuantity) {
        RemainingFloatQuantity = remainingFloatQuantity;
    }

    public boolean isCurbSale() {
        return curbSale;
    }

    public void setCurbSale(boolean curbSale) {
        this.curbSale = curbSale;
    }

    public String getTagIDs() {
        return tagIDs;
    }

    public void setTagIDs(String tagIDs) {
        this.tagIDs = tagIDs;
    }

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

    public boolean isNeedWeigh() {
        return needWeigh;
    }

    public void setNeedWeigh(boolean needWeigh) {
        this.needWeigh = needWeigh;
    }

    public Long getAreaID() {
        return areaID;
    }

    public void setAreaID(Long areaID) {
        this.areaID = areaID;
    }

    public Long getMealsID() {
        return mealsID;
    }

    public void setMealsID(Long mealsID) {
        this.mealsID = mealsID;
    }

    public long getVariantID() {
        return variantID;
    }

    public void setVariantID(long variantID) {
        this.variantID = variantID;
    }

    public double getProduceCost() {
        return produceCost;
    }

    public void setProduceCost(double produceCost) {
        this.produceCost = produceCost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }


}
