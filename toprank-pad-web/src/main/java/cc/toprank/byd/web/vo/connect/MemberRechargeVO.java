package cc.toprank.byd.web.vo.connect;

/**
 * 会员充值VO
 * Created by HuTao on 2017-5-9.
 */
public class MemberRechargeVO {
    private String memMethodName;   //  收入方式名称
    private int  memQuantity;   //  数量
    private double memAmount;  //  金额

    public String getMemMethodName() {
        return memMethodName;
    }

    public void setMemMethodName(String memMethodName) {
        this.memMethodName = memMethodName;
    }

    public int getMemQuantity() {
        return memQuantity;
    }

    public void setMemQuantity(int memQuantity) {
        this.memQuantity = memQuantity;
    }

    public double getMemAmount() {
        return memAmount;
    }

    public void setMemAmount(double memAmount) {
        this.memAmount = memAmount;
    }
}
