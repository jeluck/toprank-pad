package cc.toprank.byd.pad.service;

import cc.toprank.byd.dao.B_MealsInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 餐次
 *
 * @author LeeJun
 * @version 2.0.0
 * @time 2017-2-24 17:21
 */
@Service
public class MealsService {

    @Autowired
    private B_MealsInfoDao mealsInfoMapper;

}
