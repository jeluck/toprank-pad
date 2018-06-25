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
public class DeviceMessageVO {

    private Long devId; // 设备ID

    private Integer devType; // 设备类型

    private String devName; // 设备名称

    private String devIP; // 设备IP

    private Integer devPort; // 设备端口

    private String devMAC; // 设备MAC地址

    private Long devState; // 设备状态

    public Long getDevId() {
        return devId;
    }

    public void setDevId(Long devId) {
        this.devId = devId;
    }

    public Integer getDevType() {
        return devType;
    }

    public void setDevType(Integer devType) {
        this.devType = devType;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevIP() {
        return devIP;
    }

    public void setDevIP(String devIP) {
        this.devIP = devIP;
    }

    public Integer getDevPort() {
        return devPort;
    }

    public void setDevPort(Integer devPort) {
        this.devPort = devPort;
    }

    public String getDevMAC() {
        return devMAC;
    }

    public void setDevMAC(String devMAC) {
        this.devMAC = devMAC;
    }

    public Long getDevState() {
        return devState;
    }

    public void setDevState(Long devState) {
        this.devState = devState;
    }
}
