package cc.toprank.byd.vo.print;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.time.LocalDateTime;

/**
 * @author LinYN
 * @date 2017-6-2
 */
public class PrinterVO {

    private Long archiveID; // 档案编号
    private Long mappingID; // 单据与打印机之间的关联编号
    private Long printerID; // 打印机ID
    private Long templateID; // 模板编号
    private String printerName; // 打印机名称
    private Long printerStatus; // 打印机状态  0:在线, 1:离线, 2:故障
    private String printerIP; // 打印机IP
    private Integer printerPort; // 打印机端口
    private String printerMAC;  // 打印机MAC
    private String operationCode; // 操作码
    private Integer billType; // 单据类型
    private Integer printCount; // 打印份数
    private LocalDateTime printTime; // 打印时间

    private PortPrinterVO port;

    public Long getArchiveID() {
        return archiveID;
    }

    public void setArchiveID(Long archiveID) {
        this.archiveID = archiveID;
    }

    public Long getMappingID() {
        return mappingID;
    }

    public void setMappingID(Long mappingID) {
        this.mappingID = mappingID;
    }

    public Long getPrinterID() {
        return printerID;
    }

    public void setPrinterID(Long printerID) {
        this.printerID = printerID;
    }

    public Long getTemplateID() {
        return templateID;
    }

    public void setTemplateID(Long templateID) {
        this.templateID = templateID;
    }

    public String getPrinterIP() {
        return printerIP;
    }

    public void setPrinterIP(String printerIP) {
        this.printerIP = printerIP;
    }

    public Integer getPrinterPort() {
        return printerPort;
    }

    public void setPrinterPort(Integer printerPort) {
        this.printerPort = printerPort;
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getPrintCount() {
        return printCount;
    }

    public void setPrintCount(Integer printCount) {
        this.printCount = printCount;
    }

    public LocalDateTime getPrintTime() {
        return printTime;
    }

    public void setPrintTime(LocalDateTime printTime) {
        this.printTime = printTime;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public Long getPrinterStatus() {
        return printerStatus;
    }

    public void setPrinterStatus(Long printerStatus) {
        this.printerStatus = printerStatus;
    }

    public String getPrinterMAC() {
        return printerMAC;
    }

    public void setPrinterMAC(String printerMAC) {
        this.printerMAC = printerMAC;
    }

    public PortPrinterVO getPort() {
        return port;
    }

    public void setPort(PortPrinterVO port) {
        this.port = port;
    }
}
