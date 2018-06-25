package cc.toprank.byd.web.vo.paymentvo;

/**
 * 发票信息VO
 * Created by HuangCY on 2017-5-26.
 */
public class InvoiceInfoVO {
    //发票编码
    private String invoiceCode;
    //开票单位
    private String departName;
    //发票金额
    private double invoiceAmount;
    //开票备注
    private String memo;

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
