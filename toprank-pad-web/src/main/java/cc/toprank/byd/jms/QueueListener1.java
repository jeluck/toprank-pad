package cc.toprank.byd.jms;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * description 接收离线数据并注入sql
 * User: WeiDa
 * Date: 2017-5-7
 * Time: 16:57
 */
public class QueueListener1 {



    private Logger logger = Logger.getLogger(QueueListener1.class);

    /**
     * description 此方法要捕获异常
     *
     * User: WeiDa
     * Date: 2017-6-12
     * Time: 18:19
     */
    public void displayMsgInfo(String msgInfo) throws Exception {
        if (StringUtils.isEmpty(msgInfo)) return;


    }


}
