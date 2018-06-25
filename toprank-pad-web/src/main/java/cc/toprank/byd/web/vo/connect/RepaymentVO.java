package cc.toprank.byd.web.vo.connect;

/**
 * 还款情况VO
 * Created by HuTao on 2017-5-9.
 */
public class RepaymentVO {
    private String repMethodName;   //  收入方式名称
    private int  repQuantity;   //  数量
    private double repAmount;  //  金额

    public String getRepMethodName() {
        return repMethodName;
    }

    public void setRepMethodName(String repMethodName) {
        this.repMethodName = repMethodName;
    }

    public int getRepQuantity() {
        return repQuantity;
    }

    public void setRepQuantity(int repQuantity) {
        this.repQuantity = repQuantity;
    }

    public double getRepAmount() {
        return repAmount;
    }

    public void setRepAmount(double repAmount) {
        this.repAmount = repAmount;
    }
}
