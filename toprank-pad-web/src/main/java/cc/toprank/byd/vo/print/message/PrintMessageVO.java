package cc.toprank.byd.vo.print.message;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


/**
 * @author LinYN
 * @date 2017-6-13
 */
public class PrintMessageVO {

    private Integer devType; // 设备类型

    private Integer msgType; // 消息类型

    private Long sn; // 序列

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
}
