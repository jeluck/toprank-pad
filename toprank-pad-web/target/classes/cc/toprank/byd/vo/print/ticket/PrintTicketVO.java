package cc.toprank.byd.vo.print.ticket;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.util.List;

/**
 * 打印票据
 *
 * @author LinYN
 * @date 2017-6-6
 */
public class PrintTicketVO {

    private Integer devType; // PrintConstants#DeviceType

    private Integer msgType; // PrintConstants#MessageType

    private Long sn;

    private List<? extends PrinterTicketVO> msgValue; // json data string

    public Integer getDevType() {
        return devType;
    }

    public void setDevType(Integer devType) {
        this.devType = devType;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Long getSn() {
        return sn;
    }

    public void setSn(Long sn) {
        this.sn = sn;
    }

    public List<? extends PrinterTicketVO> getMsgValue() {
        return msgValue;
    }

    public void setMsgValue(List<? extends PrinterTicketVO> msgValue) {
        this.msgValue = msgValue;
    }
}
