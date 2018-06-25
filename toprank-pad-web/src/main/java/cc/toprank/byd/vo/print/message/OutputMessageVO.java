package cc.toprank.byd.vo.print.message;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.util.List;

/**
 * @author LinYN
 * @date 2017-6-13
 */
public class OutputMessageVO extends PrintMessageVO {

    private List<DeviceMessageVO> msgValue; // 消息内容

    public List<DeviceMessageVO> getMsgValue() {
        return msgValue;
    }

    public void setMsgValue(List<DeviceMessageVO> msgValue) {
        this.msgValue = msgValue;
    }
}
