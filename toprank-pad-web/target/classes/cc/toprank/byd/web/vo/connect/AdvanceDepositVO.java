package cc.toprank.byd.web.vo.connect;

/**
 * 预收订金VO
 * Created by HuTao on 2017-5-9.
 */
public class AdvanceDepositVO {
    private String advMethodName;   //  支付方式名称
    private int  advQuantity;   //  数量
    private double advAmount;  //  金额

    public String getAdvMethodName() {
        return advMethodName;
    }

    public void setAdvMethodName(String advMethodName) {
        this.advMethodName = advMethodName;
    }

    public int getAdvQuantity() {
        return advQuantity;
    }

    public void setAdvQuantity(int advQuantity) {
        this.advQuantity = advQuantity;
    }

    public double getAdvAmount() {
        return advAmount;
    }

    public void setAdvAmount(double advAmount) {
        this.advAmount = advAmount;
    }
}
