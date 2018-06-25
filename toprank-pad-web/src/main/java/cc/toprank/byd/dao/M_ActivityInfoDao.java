package cc.toprank.byd.dao;/**
 * Created by ZhouWei on 2017-5-19.
 */

import cc.toprank.byd.entity.M_ActivityInfoEntity;
import cc.toprank.byd.web.vo.discount.ActivityInfoVO;

import java.util.List;
import java.util.Map;

/**
 * @param
 * @author zhouwei
 * @version 2.0.0
 * @description 促销活动信息
 * @time 2017-05-19-17:00
 * @return
 */
public interface M_ActivityInfoDao {
    M_ActivityInfoEntity get(M_ActivityInfoEntity m_activityInfoEntity);

    List<M_ActivityInfoEntity> getAll();

    void update(M_ActivityInfoEntity m_activityInfoEntity);

    void delete(M_ActivityInfoEntity m_activityInfoEntity);

    void save(M_ActivityInfoEntity m_activityInfoEntity);

    int deleteByPrimaryKey(Long activityID);

    int insert(M_ActivityInfoEntity m_activityInfoEntity);

    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 根据金额、时间查询满足的促销活动
     * @time 2017-05-19-17:00
     * @return
     */
    public List<ActivityInfoVO> getActivityInfoList(Map map);

    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 插入订单折扣信息
     * @time 2017-05-19-17:00
     * @return
     */
    public List<M_ActivityInfoEntity> addActivityInfoMapping(Map map);


}
