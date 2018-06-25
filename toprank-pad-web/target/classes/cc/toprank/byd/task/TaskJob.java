package cc.toprank.byd.task;

import cc.toprank.byd.service.DailyTaskService;
import cc.toprank.byd.web.service.curbsale.CurbSaleService;
import cc.toprank.byd.web.service.table.TableManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * description 处理收银台任务.
 * Created with IntelliJ IDEA.
 * User: WeiDa
 * Date: 2017-5-26
 * Time: 17:03
 */
@Service
public class TaskJob {

    //日志打印
    private static final Logger logger = LoggerFactory.getLogger(TaskJob.class);

    @Autowired
    private DailyTaskService dailyTaskService;

    @Autowired
    private CurbSaleService curbSaleService;

    @Autowired
    private TableManagerService tableManagerService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Scheduled(cron = "0/40 * * * * ? ")
    public void job() {
        System.out.println("spring-task+注解方式定时任务进行中。。。");
    }

    /**
     * description 日结 每天晚上5点15执行一次 * 15 5 1/1 * ?
     * User: WeiDa
     * Date: 2017-5-27
     * Time: 15:22
     */
    @Scheduled(cron = "0 15 5 1/1 * ? ")
    public void day() {
        try {
            logger.info("System -> 调用日结任务...");
            dailyTaskService.executeDailyTask();
            logger.info("System -> 成功执行日结任务 END");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }

    /**
     * description
     * 1、将桌台负责人信息迁移到历史表
     * 2、根据餐厅排班表 生成桌台负责人信息 每天晚上5点16执行一次
     * User: LiuXJ
     * Date: 2017-5-27
     * Time: 16:30
     */
    @Scheduled(cron = "0 16 5 1/1 * ? ")
    public void paibanToTable() {
        try {
            logger.info("execute paibanToTable begin!!!");
            tableManagerService.executeTableManagerTask();
            logger.info("execute paibanToTable end!!!");
        } catch (Exception e) {
            logger.info("execute paibanToTable error!!!");
            e.printStackTrace();
        }
    }

    /**
     * description 每天晚上5点20执行一次
     * User: LiuXJ
     * Date: 2017-5-27
     * Time: 16:30
     */
    @Scheduled(cron = "0 20 5 1/1 * ? ")
    public void curbSaleTask() {
        try {
            logger.info("execute curb sale task beginning!!!");
            curbSaleService.executeCurbSaleTask();
            logger.info("execute curb sale task end!!!");
        } catch (Exception e) {
            logger.error("execute curb sale task error!!!");
            e.printStackTrace();
        }
    }
}
