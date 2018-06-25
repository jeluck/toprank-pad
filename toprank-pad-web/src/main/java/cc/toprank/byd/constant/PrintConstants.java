package cc.toprank.byd.constant;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


/**
 * @author LinYN
 * @date 2017-6-6
 */
public interface PrintConstants {

    interface PrintConfig {

        String PRINT_UP_QUEUE = "queue_uplink";

        String PRINT_DOWN_QUEUE = "queue_downlink";

        int DEFAULT_PRINT_COUNT = 1;
    }

    interface DeviceType {
        int CLIENT = 0;			//客户端软件（下位机）
        int PRINTER_DEV = 1;	//打印机
    }

    interface MessageType {
        int CLIENT_MSG_DEVLIST = 0;			// 设备列表
        int PRINTER_MSG_PRINT = 100;	//打印机打印消息
        int PRINTER_MSG_STATS = 101;	//打印机状态消息
    }
}
