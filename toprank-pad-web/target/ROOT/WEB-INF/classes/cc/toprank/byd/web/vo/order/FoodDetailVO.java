package cc.toprank.byd.web.vo.order;

import java.util.List;

/**
 *  菜品详情VO
 * Created by HuTao on 2017-5-4.
 */
public class FoodDetailVO {
    private Long    orderID;           //  订单ID
    private  Long   subOrderID;       //  子订单ID
    private String orderCode;         //  订单编号
    private String tableName;    //   桌台名
    private Long variantID;      //   变体ID
    private String productName;  //   菜名
    private  int quantity;       //   数量
    private  double price;       //   单价
    private  String memo;         //    备注
    private Long  aLaCarteMethod;               //  点菜方式ID
    private  String aLaCarteMethodName;        //   点菜方式名称
    private List<OptionInfoVO>    optionlist ;  //  规格 明细

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getSubOrderID() {
        return subOrderID;
    }

    public void setSubOrderID(Long subOrderID) {
        this.subOrderID = subOrderID;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Long getaLaCarteMethod() {
        return aLaCarteMethod;
    }

    public void setaLaCarteMethod(Long aLaCarteMethod) {
        this.aLaCarteMethod = aLaCarteMethod;
    }

    public String getaLaCarteMethodName() {
        return aLaCarteMethodName;
    }

    public void setaLaCarteMethodName(String aLaCarteMethodName) {
        this.aLaCarteMethodName = aLaCarteMethodName;
    }

    public List<OptionInfoVO> getOptionlist() {
        return optionlist;
    }

    public void setOptionlist(List<OptionInfoVO> optionlist) {
        this.optionlist = optionlist;
    }
}
