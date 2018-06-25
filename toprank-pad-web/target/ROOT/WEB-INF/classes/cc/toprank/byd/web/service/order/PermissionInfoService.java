package cc.toprank.byd.web.service.order;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.dao.U_LoginInfoDao;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @Description：用户操作权限
 * @Author：HuTao
 * @Time: 2017-4-26 10:56
 * @Version 2.0.0
 * Created by HuTao on 2017-4-25.
 */
@Service
public class PermissionInfoService {

    @Autowired
    private U_LoginInfoDao loginInfoDao;

    /**
     * @Description：检查用户是否有操作的权限
     * @Author：HuTao
     * @Time: 2017-4-26 10:53
     * @Version 2.0.0
     * @param loginName
     * @param password
     * @param modelCode
     */
    public void checkPrivilege(String loginName,String password,String modelCode ){
        U_LoginInfoEntity loginInfo=loginInfoDao.getLoginInfoByLoginName(loginName);
        if(null==loginInfo){
            throw new BizException(CodeMsgConstants.USER_NAME_NOT_EXIST,"");
        }
        Map<String,Object> map = new HashMap();
        map.put("loginName",loginName);
        map.put("password",password);
        loginInfo = loginInfoDao.checkByLoginNameAndPasswor(map);
        if(null==loginInfo){
            throw new BizException(CodeMsgConstants.USER_PASSWORD_EXIST,"");
        }
        map.put("modelCode",modelCode);
        Map<String,Object> mapData = loginInfoDao.checkByLoginNameAndModelCode(map);
        if(null!=mapData || !mapData.isEmpty()){
            throw new BizException(CodeMsgConstants.USER_NOT_PRIVILEGE,"");
        } else {
            String privilege =mapData.get("Privilege").toString();
            if (null==privilege || ! privilege.equals("")){
                throw new BizException(CodeMsgConstants.USER_NOT_PRIVILEGE,"");
            }
        }
    }
}
