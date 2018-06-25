package cc.toprank.byd.web.vo.member;

import java.time.LocalDateTime;

/**
 * Created by HuTao on 2017-5-27.
 */
public class MemberRechargePrintVO {
    private String billName;    //  单据名称
    private String archiveName;     //    充值机构
    private String shopDate;    //  营业日期
    private String countermanName;    //  营销员
    private String cashierName;       //  收银员
    private String cashRegister;      //  收银机
    private String cardSerialNo;          //  卡号（序列号）
    private String cardLevelName;    //   等级
    private Long cardID;           //   会员编号
    private String memberName;    //    会员名称
    private double beforeAmount;    //    充值前余额
    private int    beforeFraction;     //    充值前积分
    private String  paymentName;        //     充值方式
    private double deposit;      //   充值金额
    private double present;      //   充值赠送金额
    private int  fraction;       //   充值赠送积分
    private double  afterAmount;       //     充值后余额
    private int afterFraction;         //     充值后积分
    private LocalDateTime printTime;    //     打印时间

    public String getArchiveName() {
        return archiveName;
    }

    public void setArchiveName(String archiveName) {
        this.archiveName = archiveName;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getShopDate() {
        return shopDate;
    }

    public void setShopDate(String shopDate) {
        this.shopDate = shopDate;
    }

    public String getCountermanName() {
        return countermanName;
    }

    public void setCountermanName(String countermanName) {
        this.countermanName = countermanName;
    }

    public String getCashierName() {
        return cashierName;
    }

    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }

    public String getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(String cashRegister) {
        this.cashRegister = cashRegister;
    }

    public String getCardSerialNo() {
        return cardSerialNo;
    }

    public void setCardSerialNo(String cardSerialNo) {
        this.cardSerialNo = cardSerialNo;
    }

    public String getCardLevelName() {
        return cardLevelName;
    }

    public void setCardLevelName(String cardLevelName) {
        this.cardLevelName = cardLevelName;
    }

    public Long getCardID() {
        return cardID;
    }

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
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

    public LocalDateTime getPrintTime() {
        return printTime;
    }

    public void setPrintTime(LocalDateTime printTime) {
        this.printTime = printTime;
    }
}
