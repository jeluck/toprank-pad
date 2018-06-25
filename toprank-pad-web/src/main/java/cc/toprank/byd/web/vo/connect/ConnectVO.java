package cc.toprank.byd.web.vo.connect;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 交接班 VO
 * Created by HuTao on 2017-5-9.
 */
public class ConnectVO {
    private LocalDate businessDate;   //  营业日期：2014-5-05
    private String cashRegister;     //  收银机：一楼收银
    private String mealsName;         //  餐次
    private LocalDateTime passworkTime;   //   交班时间：2015-04-15  11:00
    private String passworkName;          //   交班人
    private double consumptionAmount;  //  消费金额：10000.00
    private double donationAmount;     //  赠送金额：0.00
    private double discountAmount;     //  折扣金额：0.00
    private double deductionAmount;  //  减免金额：0.00
    private double serviceCharge;    //  服务费：80.00
    private double zero;              //  抹零：0.00
    private double receivableAmount; //  应收金额：10080.00
    //----------------------------------------------------------------------
    private double incomeAmount;    //   收入金额：10080.0
    private double invoiceAmount;   //  开票金额:10000.00
    private int orderNumber;         //  订单数：50
    private int peopleNumber;        //  人数：100

    private List<ReceivablesVO> receivablesVOList;          //  订单收款VO
    private List<MemberRechargeVO> memberRechargeVOList;   //  会员充值VO
    private List<AdvanceDepositVO> advanceDepositVOList;   //  预收订金VO
    private List<ClassificationVO> classificationVOList;    //  退订VO
    private List<RepaymentVO> repaymentVOList;              //  还款情况VO

    public LocalDate getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(LocalDate businessDate) {
        this.businessDate = businessDate;
    }

    public String getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(String cashRegister) {
        this.cashRegister = cashRegister;
    }

    public String getMealsName() {
        return mealsName;
    }

    public void setMealsName(String mealsName) {
        this.mealsName = mealsName;
    }

    public LocalDateTime getPassworkTime() {
        return passworkTime;
    }

    public void setPassworkTime(LocalDateTime passworkTime) {
        this.passworkTime = passworkTime;
    }

    public String getPassworkName() {
        return passworkName;
    }

    public void setPassworkName(String passworkName) {
        this.passworkName = passworkName;
    }

    public double getConsumptionAmount() {
        return consumptionAmount;
    }

    public void setConsumptionAmount(double consumptionAmount) {
        this.consumptionAmount = consumptionAmount;
    }

    public double getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(double donationAmount) {
        this.donationAmount = donationAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDeductionAmount() {
        return deductionAmount;
    }

    public void setDeductionAmount(double deductionAmount) {
        this.deductionAmount = deductionAmount;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getZero() {
        return zero;
    }

    public void setZero(double zero) {
        this.zero = zero;
    }

    public double getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(double receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(int peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public List<ReceivablesVO> getReceivablesVOList() {
        return receivablesVOList;
    }

    public void setReceivablesVOList(List<ReceivablesVO> receivablesVOList) {
        this.receivablesVOList = receivablesVOList;
    }

    public List<MemberRechargeVO> getMemberRechargeVOList() {
        return memberRechargeVOList;
    }

    public void setMemberRechargeVOList(List<MemberRechargeVO> memberRechargeVOList) {
        this.memberRechargeVOList = memberRechargeVOList;
    }

    public List<AdvanceDepositVO> getAdvanceDepositVOList() {
        return advanceDepositVOList;
    }

    public void setAdvanceDepositVOList(List<AdvanceDepositVO> advanceDepositVOList) {
        this.advanceDepositVOList = advanceDepositVOList;
    }

    public List<ClassificationVO> getClassificationVOList() {
        return classificationVOList;
    }

    public void setClassificationVOList(List<ClassificationVO> classificationVOList) {
        this.classificationVOList = classificationVOList;
    }

    public List<RepaymentVO> getRepaymentVOList() {
        return repaymentVOList;
    }

    public void setRepaymentVOList(List<RepaymentVO> repaymentVOList) {
        this.repaymentVOList = repaymentVOList;
    }
}
