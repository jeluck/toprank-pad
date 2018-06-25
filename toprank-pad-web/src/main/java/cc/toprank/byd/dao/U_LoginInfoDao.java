package cc.toprank.byd.dao;

import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.waiterApp.dto.WaiterLoginDTO;
import cc.toprank.byd.web.dto.UserInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface U_LoginInfoDao {

    int deleteByPrimaryKey(Long loginID);

    int insert(U_LoginInfoEntity record);

    int insertSelective(U_LoginInfoEntity record);

    U_LoginInfoEntity selectByPrimaryKey(Long loginID);

    int updateByPrimaryKeySelective(U_LoginInfoEntity record);

    int updateByPrimaryKey(U_LoginInfoEntity record);



    U_LoginInfoEntity getByID(Long loginID);

    U_LoginInfoEntity get(U_LoginInfoEntity InfoEntity);

    List<U_LoginInfoEntity> getAll();

    void update(U_LoginInfoEntity InfoEntity);


    void delete(U_LoginInfoEntity InfoEntity);

    void save(U_LoginInfoEntity InfoEntity);
    // 操作者登陆，验证用户名和密码

     List<U_LoginInfoEntity> login(U_LoginInfoEntity u);

    // 操作者注册,验证注册名
     List<U_LoginInfoEntity> register(U_LoginInfoEntity u);

    /**
     * @Description： 根据名称或编号和岗位查询开台人列表
     * @Author：LanZY
     * @Time: 2017-3-23 15:27
     * @Version 2.0.0
     * @param map nameOrId  名称或者编号 job 岗位
     * @return  开台人列表
     */
    List<Map<String,Object>> getOriginalList(Map<String,Object> map);

    /**
     * @Description：根据岗位, 名称或编号的模糊查询 用户信息列表
     * @Author：HuTao
     * @Time: 2017-4-19 11:32
     * @Version 2.0.0
     * @param map
     * @return
     */
    List<Map<String,Object>> getServerNameList(Map<String,Object> map);

    /**
     * @Description：根据登入名称，取登入者信息
     * @Author：HuTao
     * @Time: 2017-4-26 9:41
     * @Version 2.0.0
     * @param loginName
     * @return
     */
    U_LoginInfoEntity getLoginInfoByLoginName(String loginName);

    /**
     * @Description：根据登入ID,口令 取登入者信息
     * @Author：HuTao
     * @Time: 2017-4-28 9:38
     * @Version 2.0.0
     * @param map
     * @return
     */
    U_LoginInfoEntity checkByLoginNameAndPasswor(Map<String,Object> map);

    /**
     * @Description：根据登入ID,模块编码 ，取模块的权限信息
     * @Author：HuTao
     * @Time: 2017-4-28 9:41
     * @Version 2.0.0
     * @param map
     * @return
     */
    Map<String,Object> checkByLoginNameAndModelCode(Map<String,Object> map);

    /**
     * @description：验证工号和密码的准确性，返回登录信息
     * @author：LiYC
     * @time: 2017-2-20 17:17
     * @version 2.0.0
     * @param map
     * @return
     */

    U_LoginInfoEntity selectByLogin(@Param("employeeCode") String employeeCode, @Param("loginPassword") String loginPassword);
    /**
     * @Description：根据 登入名取用户的Vo信息
     * @Author：HuTao
     * @Time: 2017-3-2 16:05
     * @Version 2.0.0
     * @param loginName
     * @return
     */
    UserInfoVo getUserInfoByLoginName(Map<String,Object> parm);

    List<String> getPermissionsByLoginName(String loginName);

    List<String> getRolesByLoginName(String loginName);

    List<String> getPrivilegeCodeByLoginID(Long loginID);

    List<Long> getPrivilegeIDByLoginID(Long loginID);

    int updateLastLoginTime(String loginName);


    Map xx(String s);

    /**
     * @Description：根据登录名取用户登录信息
     * @Author：chenkangyi
     * @Time: 2017-5-26 15:30
     * @Version 2.0.0
     * @param loginName
     * @return
     */
    U_LoginInfoEntity selectLoginInfoByLoginName(String loginName);

    /**
     * @Description：根据登录名和登录密码取用户登录信息
     * @Author：chenkangyi
     * @Time: 2017-5-26 15:36
     * @Version 2.0.0
     * @param map
     * @return
     */
    U_LoginInfoEntity selectLoginInfoByLoginNameAndLoginPassWord(Map<String,Object> map);

    /**
     * @Description：根据工号查询信息是否存在
     * @Author：zhouwei
     * @Time: 2017-6-5 15:36
     * @Version 2.0.0
     * @param employCode
     * @return
     */
    U_LoginInfoEntity getLoginInfoByEmployCode(String employCode);

    /**
     * @Description：根据工号签到签退
     * @Author：zhouwei
     * @Time: 2017-6-5 15:36
     * @Version 2.0.0
     * @param loginInfoEntity
     * @return
     */
    int signInAndOut(U_LoginInfoEntity loginInfoEntity);

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 服务员APP登陆
     * @time 2017-6-14 10:37
     */
    WaiterLoginDTO loginWaiterApp(@Param("loginName") String loginName, @Param("loginPassword") String password);
}