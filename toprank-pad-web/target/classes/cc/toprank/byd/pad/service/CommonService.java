/**
 * @Title: AppService.java
 * @Package cc.toprank.byd.pad.service
 * @Description: 公共的mapper封装业务service
 * @author Lish
 * @date 2017年1月19日 下午2:15:39
 * @version V1.0
 */
package cc.toprank.byd.pad.service;

import cc.toprank.byd.dao.B_DinningTableInfoDao;
import cc.toprank.byd.dao.B_MealsInfoDao;
import cc.toprank.byd.dao.CommonMapper;
import cc.toprank.byd.entity.B_DinningTableInfoEntity;
import cc.toprank.byd.entity.B_MealsInfoEntity;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiSH
 */
@Service
public class CommonService {
    @Autowired
    B_MealsInfoDao b_MealsInfoMapper;
    @Autowired
    private B_DinningTableInfoDao b_DinningTableInfoMapper;
    /**
     * @description 根据当前桌台ID和区域ID 获得 当前时间下所在 餐次
     * @author LiSH
     * @time 2017-3-16 11:11
     * @version 2.0.0
     */
    B_MealsInfoEntity getCurrentMealsInfo() {
        return CommonMapper.getCurrentMealsInfo();
    }
    /**
     * @description 获得当前桌台信息
     * @author LiSH
     * @time 2017-3-16 11:11
     * @version 2.0.0
     */
    B_DinningTableInfoEntity getCurrentTableInfo() {
        return b_DinningTableInfoMapper.selectByPrimaryKey(MerchantCacheUtils.getCurrentTableID());
    }
}
