package cc.toprank.byd.dao;/**
 * Created by ZhouWei on 2017-6-5.
 */

import cc.toprank.byd.entity.T_LoginUserStatInfoEntity;

import java.util.Map;

/**
 * @param
 * @author zhouwei
 * @version 2.0.0
 * @description 登录用户统计信息
 * @time 2017-06-05-15:00
 * @return
 */
public interface T_LoginUserStatInfoDao {
    int insertLoginUserStatInfo(T_LoginUserStatInfoEntity t_loginUserStatInfoEntity);

    T_LoginUserStatInfoEntity getCurrentDaySignInMsg (Map map);

    T_LoginUserStatInfoEntity getCurrentDaySignOutMsg (Map map);

    int updateLoginUserStatInfo(T_LoginUserStatInfoEntity t_loginUserStatInfoEntity);

}
