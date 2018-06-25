package cc.toprank.byd.web.service.login;

import cc.toprank.byd.dao.T_LoginUserStatInfoDao;
import cc.toprank.byd.dao.U_LoginInfoDao;
import cc.toprank.byd.entity.T_LoginUserStatInfoEntity;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.web.dto.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description：   用户登入
 * @Author：HuTao
 * @Time: 2017-3-2 11:57
 * @Version 2.0.0
 */

@Service
public class LoginService {

    @Autowired
    private U_LoginInfoDao loginInfoMapper;
    @Autowired
    private T_LoginUserStatInfoDao t_loginUserStatInfoDao;

    /**
     * @Description：   验证登入名，口令
     * @Author：HuTao
     * @Time: 2017-3-2 14:35
     * @Version 2.0.0
     * @param loginName
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public UserInfoVo getUserInfo(String loginName,String passWord ) {
        //  最后登入时间
        // loginInfoMapper.updateLastLoginTime(loginName);
        Map<String,Object> parm= new HashMap();
        parm.put("loginName",loginName);
        parm.put("passWord",passWord);
        UserInfoVo userInfo =loginInfoMapper.getUserInfoByLoginName(parm);
        return  userInfo;
    }


    /**
     *
     * @Description： 根据登入名  取操作权限
     * @Author：HuTao
     * @Time: 2017-3-3 9:58
     * @Version 2.0.0
     *
     * @param loginName
     * @return
     */

    public List<String> getPermissionsByLoginName(String loginName) {
        return   loginInfoMapper.getPermissionsByLoginName(loginName);
    }

    /**
     * @Description：根据登入名  取操作权限的角色
     * @Author：HuTao
     * @Time: 2017-3-3 10:02
     * @Version 2.0.0
     * @param loginName
     * @return
     */
    public List<String> getRolesByLoginName(String loginName){
        return  loginInfoMapper.getRolesByLoginName(loginName);
    }

    /**
     * @Description： 根据登入ID 取操作权限信息
     * @Author：HuTao
     * @Time: 2017-3-3 10:45
     * @Version 2.0.0
     * @param loginID
     * @return
     */
    public String getPrivilegeCodeByLoginID(String loginID){
        List<String> datalist= loginInfoMapper.getPrivilegeCodeByLoginID(Long.valueOf(loginID));
        StringBuilder sb = new StringBuilder();
        for (String varStr:datalist) {
            sb.append(varStr+",");
        }
        return sb.toString();
    }
    /**
     * @Description： 根据登入ID 取操作权限信息
     * @Author：HuTao
     * @Time: 2017-3-3 10:45
     * @Version 2.0.0
     * @param loginID
     * @return
     */
    public String getPrivilegeIDByLoginID(String loginID){
        List<Long>  dataList = loginInfoMapper.getPrivilegeIDByLoginID(Long.valueOf(loginID));
        StringBuilder sb = new StringBuilder();
        for (Long varStr:dataList) {
            sb.append(varStr+",");
        }
        return sb.toString();
    }

    /**
     * @Description：根据工号查询信息是否存在
     * @Author：zhouwei
     * @Time: 2017-6-5 15:36
     * @Version 2.0.0
     * @param employCode
     * @return
     */
    public U_LoginInfoEntity getLoginInfoByEmployCode(String employCode){
        return loginInfoMapper.getLoginInfoByEmployCode(employCode);
    }

    /**
     * @Description：根据工号签到签退
     * @Author：zhouwei
     * @Time: 2017-6-5 15:36
     * @Version 2.0.0
     * @param loginInfoEntity
     * @return
     */
    public int signInAndOut(U_LoginInfoEntity loginInfoEntity){
        return loginInfoMapper.signInAndOut(loginInfoEntity);
    }

    /**
     * @Description：插入登录统计信息
     * @Author：zhouwei
     * @Time: 2017-6-5 15:36
     * @Version 2.0.0
     * @param t_loginUserStatInfoEntity
     * @return
     */
    public int insertLoginUserStatInfo(T_LoginUserStatInfoEntity t_loginUserStatInfoEntity){
        return t_loginUserStatInfoDao.insertLoginUserStatInfo(t_loginUserStatInfoEntity);
    }

    /**
     * @Description：更新登录统计信息
     * @Author：zhouwei
     * @Time: 2017-6-5 15:36
     * @Version 2.0.0
     * @param t_loginUserStatInfoEntity
     * @return
     */
    public int updateLoginUserStatInfo(T_LoginUserStatInfoEntity t_loginUserStatInfoEntity){
        return t_loginUserStatInfoDao.updateLoginUserStatInfo(t_loginUserStatInfoEntity);
    }

    /**
     * @Description：查询是否可以签到
     * @Author：zhouwei
     * @Time: 2017-6-5 15:36
     * @Version 2.0.0
     * @param loginID,userID
     * @return
     */
    public T_LoginUserStatInfoEntity getCurrentDaySignInMsg(Long loginID,Long userID){
        Map<String,Long> map = new HashMap();
        map.put("loginID",loginID);
        map.put("userID",userID);
        return t_loginUserStatInfoDao.getCurrentDaySignInMsg(map);
    }

    /**
     * @Description：查询是否可以签退
     * @Author：zhouwei
     * @Time: 2017-6-5 15:36
     * @Version 2.0.0
     * @param loginID,userID
     * @return
     */
    public T_LoginUserStatInfoEntity getCurrentDaySignOutMsg(Long loginID,Long userID){
        Map<String,Long> map = new HashMap();
        map.put("loginID",loginID);
        map.put("userID",userID);
        return t_loginUserStatInfoDao.getCurrentDaySignOutMsg(map);
    }

}
