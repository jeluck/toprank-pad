package cc.toprank.byd.web.vo.member;

/**
 * Created by HuTao on 2017-4-12.
 */
public class MemberTotalVO {
    private int count;  //   会员总数
    private double fundAmountCount ;  // 会员余额合计

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getFundAmountCount() {
        return fundAmountCount;
    }

    public void setFundAmountCount(double fundAmountCount) {
        this.fundAmountCount = fundAmountCount;
    }
}
