package cc.toprank.byd.service;

import cc.toprank.byd.dao.DailyTaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 日结任务服务，不区分商家
 */
@Service
public class DailyTaskService {

    @Autowired
    private DailyTaskDao dailyTaskDao;

    /**
     * 执行日结任务：清台，完结订单
     *
     * @author LinYN
     * @since 2017-5-27
     */
    /* 不要加事务 */
    public void executeDailyTask(){
        dailyTaskDao.resetSubOrderInfo(); // 将子订单改成己完成
        dailyTaskDao.resetOrderInfo(); // 主订单改成己完成
        dailyTaskDao.resetTableInfo(); // 将桌台信息清理，状态设置为空台，消除关联属性
        dailyTaskDao.resetTableUseInfo(); // 将桌台使用信息清理，设置结束时间
        dailyTaskDao.resetMealTableMapping(); // 日结时重置餐次桌台信息
    }
}
