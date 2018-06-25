package cc.toprank.byd.web.service.discount;/**
 * Created by ZhouWei on 2017-5-19.
 */

import cc.toprank.byd.dao.M_ActivityInfoDao;
import cc.toprank.byd.entity.M_ActivityInfoEntity;
import cc.toprank.byd.web.vo.discount.ActivityInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @param
 * @author zhouwei
 * @version 2.0.0
 * @description 折扣服务类
 * @time 2017-05-19-14:20
 * @return
 */
@Service("activityInfoService")
public class ActivityInfoService {
    @Autowired
    private M_ActivityInfoDao m_activityInfoDao;

    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 根据金额、时间查询满足的促销活动
     * @time 2017-05-19-17:00
     * @return
     */
    public List<ActivityInfoVO> getActivityInfoList(Map map){
        return m_activityInfoDao.getActivityInfoList(map);
    }


}
