package cc.toprank.byd.web.service.permission;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.dao.U_LoginInfoDao;
import cc.toprank.byd.dao.U_RoleLoginInfoDao;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.entity.U_RoleLoginInfoEntity;
import cc.toprank.byd.util.Sha1Util;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.vo.permission.PermissionUserInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 验证权限
 * Created by ChenKY on 2017-5-26.
 */
@Service
public class PermissionValidateService {

    @Autowired
    private U_LoginInfoDao u_loginInfoDao;

    @Autowired
    private U_RoleLoginInfoDao u_roleLoginInfoDao;

    public PermissionUserInfoVO checkPermission(Map<String, Object> map) throws Exception {
        //ResultData resultData = new ResultData();
        String loginName = (String) map.get("loginName");
        String password = (String) map.get("password");
        String moduleCode = (String) map.get("moduleCode");
        String privilegeCode = (String) map.get("privilegeCode");
        if (StringUtils.isBlank(loginName) || StringUtils.isBlank(password) || StringUtils.isBlank(moduleCode) || StringUtils.isBlank(privilegeCode)) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        //验证用户是否存在
        U_LoginInfoEntity loginInfoByLoginName = u_loginInfoDao.selectLoginInfoByLoginName(loginName);
        if (loginInfoByLoginName == null) {
            throw new BizException(CodeMsgConstants.USERNAME_NOT_EXIST_CODE, CodeMsgConstants.USERNAME_NOT_EXIST_MSG);
        }
        String loginPassword = Sha1Util.SHA1(password);
        map.put("loginPassword", loginPassword);
        //验证用户账号密码是否正确
        U_LoginInfoEntity u_loginInfoByLoginNameAndLoginPassWord = u_loginInfoDao.selectLoginInfoByLoginNameAndLoginPassWord(map);
        if (u_loginInfoByLoginNameAndLoginPassWord == null) {
            throw new BizException(CodeMsgConstants.USERNAME_OR_PASSWORD_ERROR_CODE, CodeMsgConstants.USERNAME_OR_PASSWORD_ERROR_MSG);
        }
        Long loginID = u_loginInfoByLoginNameAndLoginPassWord.getLoginID();
        if (loginID == null) {
            throw new BizException(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        map.put("loginID", loginID);
        U_RoleLoginInfoEntity u_roleLoginInfo = u_roleLoginInfoDao.selectPrivilegeInfo(map);
        if (u_roleLoginInfo == null){
            throw new BizException(CodeMsgConstants.USER_NOT_HAS_PRIVILEGE_CODE, CodeMsgConstants.USER_NOT_HAS_PRIVILEGE_MSG);
        }
        PermissionUserInfoVO permissionUserInfoVO = new PermissionUserInfoVO();
        permissionUserInfoVO.setLoginID(loginID);
        permissionUserInfoVO.setLoginName(u_loginInfoByLoginNameAndLoginPassWord.getLoginName());
        permissionUserInfoVO.setPassword(loginPassword);
        return permissionUserInfoVO;

    }
}
