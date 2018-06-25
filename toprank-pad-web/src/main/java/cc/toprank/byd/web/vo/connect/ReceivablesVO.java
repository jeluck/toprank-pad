package cc.toprank.byd.web.vo.connect;

/**
 * 收款情况VO
 * Created by HuTao on 2017-5-9.
 */
public class ReceivablesVO {
    private String recMethodName;   //  收入方式名称
    private int  recQuantity;   //  数量
    private double recAmount;  //  金额

    public String getRecMethodName() {
        return recMethodName;
    }

    public void setRecMethodName(String recMethodName) {
        this.recMethodName = recMethodName;
    }

    public int getRecQuantity() {
        return recQuantity;
    }

    public void setRecQuantity(int recQuantity) {
        this.recQuantity = recQuantity;
    }

    public double getRecAmount() {
        return recAmount;
    }

    public void setRecAmount(double recAmount) {
        this.recAmount = recAmount;
    }
}
