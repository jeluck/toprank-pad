package cc.toprank.byd.vo.print.ticket;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.vo.print.PrinterVO;
import com.alibaba.fastjson.annotation.JSONField;

import java.time.LocalDateTime;

/**
 * 打印机
 *
 * @author LinYN
 * @date 2017-6-5
 */
public abstract class PrinterTicketVO {

    private String company; // 公司名

    private String title; // 标题

    private String subTitle; // 副标题

    private PrinterVO printer = new PrinterVO(); // 打印机

    public void setPrinter(PrinterVO printer) {
        this.printer = printer;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Long getTemplateID() {
        return printer.getTemplateID();
    }

    public void setTemplateID(Long templateID) {
        printer.setTemplateID(templateID);
    }

    public String getPrinterIP() {
        return printer.getPrinterIP();
    }

    public void setPrinterIP(String printerIP) {
        printer.setPrinterIP(printerIP);
    }

    public Integer getPrinterPort() {
        return printer.getPrinterPort();
    }

    public void setPrinterPort(Integer printerPort) {
        printer.setPrinterPort(printerPort);
    }

    public String getOperationCode() {
        return printer.getOperationCode();
    }

    public void setOperationCode(String operationCode) {
        printer.setOperationCode(operationCode);
    }

    public Integer getBillType() {
        return printer.getBillType();
    }

    public void setBillType(Integer billType) {
        printer.setBillType(billType);
    }

    public Integer getPrintCount() {
        return printer.getPrintCount();
    }

    public void setPrintCount(Integer printCount) {
        printer.setPrintCount(printCount);
    }

    @JSONField(format = DateUtils.DATE_FORMAT_DATETIME)
    public LocalDateTime getPrintTime() {
        return printer.getPrintTime();
    }

    public void setPrintTime(LocalDateTime printTime) {
        printer.setPrintTime(printTime);
    }

    public String getPrinterName() {
        return printer.getPrinterName();
    }

    public void setPrinterName(String printerName) {
        printer.setPrinterName(printerName);
    }

    public String getPrinterMAC() {
        return printer.getPrinterMAC();
    }

    public void setPrinterMAC(String printerMAC) {
        printer.setPrinterMAC(printerMAC);
    }
}
