package cc.toprank.byd.web.vo.member;

import java.math.BigDecimal;

/**
 * Created by HuTao on 2017-5-26.
 */
public class MemberOpenTicketVO {
    private Long  cardID;      //   会员ID
    private Long  customerID;  //   客户ID
    private Long  depositID;   //   会员充值ID (堂食订单ID)
    private Long  loginID;      //
    private BigDecimal rechargeAmount;  //  充值金额(堂食订单金额)
    private String   ticketNo;     //  发票编号
    private String   ticketUnit;   //  开票单位
    private BigDecimal  ticketAmount;  //  发票金额
    private String   ticketMemo;   //  开票备注
    private Long orderType;       //   订单类别

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

    public Long getLoginID() {
        return loginID;
    }

    public void setLoginID(Long loginID) {
        this.loginID = loginID;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getTicketUnit() {
        return ticketUnit;
    }

    public void setTicketUnit(String ticketUnit) {
        this.ticketUnit = ticketUnit;
    }

    public BigDecimal getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(BigDecimal ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public String getTicketMemo() {
        return ticketMemo;
    }

    public void setTicketMemo(String ticketMemo) {
        this.ticketMemo = ticketMemo;
    }

    public Long getOrderType() {
        return orderType;
    }

    public void setOrderType(Long orderType) {
        this.orderType = orderType;
    }
}
