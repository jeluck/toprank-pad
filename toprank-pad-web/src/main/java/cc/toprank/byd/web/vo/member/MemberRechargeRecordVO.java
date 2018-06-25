package cc.toprank.byd.web.vo.member;

/**
 *
 * Created by HuTao on 2017-5-25.
 */
public class MemberRechargeRecordVO {
    private Long   cardID;         //    会员ID
    private Long  customerID;  //   客户ID
    private Long   depositID;      //   会员充值ID
    private String  rechargeTime;      //  充值时间
    private String  paymentName   ;    //   充值方式
    private  double  rechargeValue;  //   充值金额
    private  double  largessValue;   //   赠送金额
    private  double  afterRechargeValue;   //   充值后余额
    private  String   loginName;     //   收银员
    private  double   openBill;       //   开票金额
    private  String   statusName;     //   状态

    public Long getCardID() {
        return cardID;
    }

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public Long getDepositID() {
        return depositID;
    }

    public void setDepositID(Long depositID) {
        this.depositID = depositID;
    }

    public String getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(String rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public double getRechargeValue() {
        return rechargeValue;
    }

    public void setRechargeValue(double rechargeValue) {
        this.rechargeValue = rechargeValue;
    }

    public double getLargessValue() {
        return largessValue;
    }

    public void setLargessValue(double largessValue) {
        this.largessValue = largessValue;
    }

    public double getAfterRechargeValue() {
        return afterRechargeValue;
    }

    public void setAfterRechargeValue(double afterRechargeValue) {
        this.afterRechargeValue = afterRechargeValue;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public double getOpenBill() {
        return openBill;
    }

    public void setOpenBill(double openBill) {
        this.openBill = openBill;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
