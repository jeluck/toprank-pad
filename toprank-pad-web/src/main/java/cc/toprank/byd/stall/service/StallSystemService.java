package cc.toprank.byd.stall.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.B_StallWeighSettingInfoDao;
import cc.toprank.byd.dao.U_ActiveUserInfoDao;
import cc.toprank.byd.dao.U_LoginInfoDao;
import cc.toprank.byd.entity.B_StallWeighSettingInfoEntity;
import cc.toprank.byd.entity.U_ActiveUserInfoEntity;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.enums.CommonManageEnum;
import cc.toprank.byd.util.MaxIDUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @version 2.0.0
 * @description：系统设置服务
 * @author：ZhaoLC
 * @time: 2017-3-14 15:00
 */
@Service
public class StallSystemService {
    @Autowired
    private U_LoginInfoDao u_loginInfoMapper;
    @Autowired
    private U_ActiveUserInfoDao u_activeUserInfoMapper;
    @Autowired
    private B_StallWeighSettingInfoDao stallWeighSettingInfoMapper;

    /**
     * @param map
     * @return
     * @description：登陆操作 验证账号；密码；档案；是否正确
     * 返回登录账号的信息
     * @author：ZhaoLC
     * @time: 2017-3-14 16:57
     * @version 2.0.0
     */
    public Map<String, Object> login(Map<String, String> map) {
        //账号密码的验证
        Map<String, Object> resultMap = new HashedMap();
        U_LoginInfoEntity u_loginInfo = u_loginInfoMapper.selectByLogin(MapUtils.getString(map, "employeecode"), MapUtils.getString(map, "loginpassword"));
        if (u_loginInfo != null) {//登陆成功
            /* ------------------------------ 插入在线信息 ------------------------------ */
            U_ActiveUserInfoEntity u_activeUserInfo = new U_ActiveUserInfoEntity();
            u_activeUserInfo.setLogID(u_loginInfo.getLoginID());
            u_activeUserInfo.setLoginName(u_loginInfo.getLoginName());
            u_activeUserInfo.setLoginChannel(CommonManageEnum.AccessChannel.PRIVATE.getValue());
            u_activeUserInfo.setMacAddress(map.get("ipAddress"));
            u_activeUserInfo.setLoginTime(LocalDateTime.now());
            u_activeUserInfo.setLogID(MaxIDUtils.getID(u_activeUserInfo));
            u_activeUserInfoMapper.insert(u_activeUserInfo);

            B_StallWeighSettingInfoEntity stallWeighSettingInfo = stallWeighSettingInfoMapper.selectByPrimaryKey(Long.valueOf(map.get("stallID")));
            u_loginInfo.setPasswordAnswer(null);
            resultMap.put("U_LoginInfo", u_loginInfo);//登录信息
            resultMap.put("B_StallWeighSettingInfo", stallWeighSettingInfo);//称重档口配置信息
            return resultMap;
        } else {
            throw new BizException("账号或密码错误");
        }
    }

    /**
     * @param loginID
     * @description：退出登录
     * @author：ZhaoLC
     * @time: 2017-3-15 10:57
     * @version 2.0.0
     */
    public boolean logout(Long loginID) {
        return u_activeUserInfoMapper.deleteByLoginID(loginID) > 0;
    }

}
