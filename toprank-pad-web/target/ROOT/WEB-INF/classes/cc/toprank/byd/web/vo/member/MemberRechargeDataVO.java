package cc.toprank.byd.web.vo.member;

/**
 * Created by HuTao on 2017-5-31.
 */
public class MemberRechargeDataVO {
    private Long creatorID;             //     操作ID
    private Long depositID;
    private double beforeAmount;       //    充值前余额
    private int beforeFraction;        //    充值前积分
    private String paymentName;        //    充值方式

    private double deposit;        //   充值金额
    private double present;        //   充值赠送金额
    private int  fraction;       //   充值赠送积分

    private  double afterAmount;       //     充值后余额
    private  int afterFraction;     //     充值后积分

    public Long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Long creatorID) {
        this.creatorID = creatorID;
    }

    public Long getDepositID() {
        return depositID;
    }

    public void setDepositID(Long depositID) {
        this.depositID = depositID;
    }

    public double getBeforeAmount() {
        return beforeAmount;
    }

    public void setBeforeAmount(double beforeAmount) {
        this.beforeAmount = beforeAmount;
    }

    public int getBeforeFraction() {
        return beforeFraction;
    }

    public void setBeforeFraction(int beforeFraction) {
        this.beforeFraction = beforeFraction;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getPresent() {
        return present;
    }

    public void setPresent(double present) {
        this.present = present;
    }

    public int getFraction() {
        return fraction;
    }

    public void setFraction(int fraction) {
        this.fraction = fraction;
    }

    public double getAfterAmount() {
        return afterAmount;
    }

    public void setAfterAmount(double afterAmount) {
        this.afterAmount = afterAmount;
    }

    public int getAfterFraction() {
        return afterFraction;
    }

    public void setAfterFraction(int afterFraction) {
        this.afterFraction = afterFraction;
    }
}
