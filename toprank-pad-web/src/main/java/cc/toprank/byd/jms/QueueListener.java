package cc.toprank.byd.jms;

import cc.toprank.byd.common.utils.number.NumberUtil;
import cc.toprank.byd.component.MerchantComponent;
import cc.toprank.byd.constant.PrintConstants;
import cc.toprank.byd.dao.B_MerchantInfoDao;
import cc.toprank.byd.dao.O_TicketPrintInfoDao;
import cc.toprank.byd.entity.B_MerchantInfoEntity;
import cc.toprank.byd.vo.print.PrinterVO;
import cc.toprank.byd.vo.print.message.DeviceMessageVO;
import cc.toprank.byd.vo.print.message.InputMessageVO;
import cc.toprank.byd.vo.print.message.OutputMessageVO;
import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;
import java.util.List;

/**
 * description 接收离线数据并注入sql
 * User: WeiDa
 * Date: 2017-5-7
 * Time: 16:57
 */
public class QueueListener {

    private static Logger logger = Logger.getLogger(QueueListener.class);

    @Autowired
    private MerchantComponent merchantComponent;


    @Autowired
    private O_TicketPrintInfoDao ticketPrintInfoDao;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * description 此方法要捕获异常
     *
     * User: WeiDa
     * Date: 2017-6-12
     * Time: 18:19
     */
    public void displayMsgInfo(String msgInfo) throws Exception {
        if (StringUtils.isEmpty(msgInfo)) return;
        try {
            InputMessageVO message = JSON.parseObject(msgInfo, InputMessageVO.class);
            int devType = NumberUtil.intValue(message.getDevType());
            switch (devType) {
                case PrintConstants.DeviceType.CLIENT : processClientMessage(message); break;
                case PrintConstants.DeviceType.PRINTER_DEV : processPrinterMessage(message); break;
                default : break;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void processClientMessage(InputMessageVO message) {
        if (NumberUtil.intValue(message.getMsgType()) == PrintConstants.MessageType.CLIENT_MSG_DEVLIST) {
            // 请求获取设备列表
            sendPrinterList();
        }
    }



    /*
     * 请求获取设备列表
     * @author LinYN
     * @date 2017-6-13
     */
    private void sendPrinterList() {
        B_MerchantInfoEntity merchantInfo = merchantComponent.getCurrentMerchantInfo();
        List<DeviceMessageVO> printers = ticketPrintInfoDao.getPrinterListByArchiveID(merchantInfo.getArchiveID());
        if (CollectionUtils.isEmpty(printers)) {
            throw new RuntimeException(MessageFormat.format("找不到该商家{0}的打印机配置！", merchantInfo.getMerchantName()));
        }
        OutputMessageVO outputMessage = new OutputMessageVO();
        outputMessage.setDevType(PrintConstants.DeviceType.CLIENT);
        outputMessage.setMsgType(PrintConstants.MessageType.CLIENT_MSG_DEVLIST);
        outputMessage.setMsgValue(printers);
        String outputContent = JSON.toJSONString(outputMessage);
        // send
        rabbitTemplate.setQueue(PrintConstants.PrintConfig.PRINT_DOWN_QUEUE);
        rabbitTemplate.convertAndSend(PrintConstants.PrintConfig.PRINT_DOWN_QUEUE, outputContent);
    }

    private void processPrinterMessage(InputMessageVO message) {
        if (NumberUtil.intValue(message.getMsgType()) == PrintConstants.MessageType.PRINTER_MSG_STATS) {
            // 推送打印机状态消息
            updatePrinterStatus(message);
        }
    }

    /*
     * 推送打印机状态消息
     * @author LinYN
     * @date 2017-6-13
     */
    private void updatePrinterStatus(InputMessageVO message) {
        DeviceMessageVO device = message.getMsgValue();
        if (device.getDevId() == null) {
            return;
        }
        B_MerchantInfoEntity merchantInfo = merchantComponent.getCurrentMerchantInfo();
        PrinterVO printerParam = new PrinterVO();
        printerParam.setPrinterID(device.getDevId());
        printerParam.setArchiveID(merchantInfo.getArchiveID());
        printerParam.setPrinterStatus(device.getDevState());
        ticketPrintInfoDao.updatePrinterStatusByID(printerParam);
    }

}
