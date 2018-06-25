package cc.toprank.byd.web.vo.member;

/**
 * Created by HuTao on 2017-4-24.
 */
public class DepositTypeVO {
    private Long depositType;      //    充值方式
    private double typeDeposit;   //    方式金额

    public Long getDepositType() {
        return depositType;
    }

    public void setDepositType(Long depositType) {
        this.depositType = depositType;
    }

    public double getTypeDeposit() {
        return typeDeposit;
    }

    public void setTypeDeposit(double typeDeposit) {
        this.typeDeposit = typeDeposit;
    }
}
