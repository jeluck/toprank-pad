package cc.toprank.byd.web.vo.connect;

/**
 * 分类收入情况
 * Created by HuTao on 2017-5-9.
 */
public class ClassificationVO {
    private String menuTypeName;   //    菜品大类
    private int  menQuantity;    //  数量
    private double  salesAmount;          //    净售金额
    private double  afterFoldingAmount;  //    折后金额

    public String getMenuTypeName() {
        return menuTypeName;
    }

    public void setMenuTypeName(String menuTypeName) {
        this.menuTypeName = menuTypeName;
    }

    public int getMenQuantity() {
        return menQuantity;
    }

    public void setMenQuantity(int menQuantity) {
        this.menQuantity = menQuantity;
    }

    public double getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(double salesAmount) {
        this.salesAmount = salesAmount;
    }

    public double getAfterFoldingAmount() {
        return afterFoldingAmount;
    }

    public void setAfterFoldingAmount(double afterFoldingAmount) {
        this.afterFoldingAmount = afterFoldingAmount;
    }
}
