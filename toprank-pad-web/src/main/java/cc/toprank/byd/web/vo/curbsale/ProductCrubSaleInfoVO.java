package cc.toprank.byd.web.vo.curbsale;

/**
 * Created by ChenKY on 2017/5/12.
 */
public class ProductCrubSaleInfoVO {
    private Long productID;            //菜品编号
    private String productName;       //菜品名称
    private double originalPrice;     //菜品原价
    private double price;             //价格
    private int productType;          //菜品类型 1套餐 2一品一菜 3一品多菜
    private boolean needWeigh;        //需要称重   1.是 0.
    private Long menuID;              //菜单ID
    private Long variantID;           // 变体id
    private String unit;              //单位
    private int optionIDSum;        //规格数量
    private String optionIDs;        //规格id列表


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

    public Long getVariantID() {
        return variantID;
    }

    public void setVariantID(Long variantID) {
        this.variantID = variantID;
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

    public int getProductType() {
        return productType;
    }

    public void setProductType(int productType) {
        this.productType = productType;
    }

    public int getOptionIDSum() {
        return optionIDSum;
    }

    public void setOptionIDSum(int optionIDSum) {
        this.optionIDSum = optionIDSum;
    }

    public String getOptionIDs() {
        return optionIDs;
    }

    public void setOptionIDs(String optionIDs) {
        this.optionIDs = optionIDs;
    }
}
