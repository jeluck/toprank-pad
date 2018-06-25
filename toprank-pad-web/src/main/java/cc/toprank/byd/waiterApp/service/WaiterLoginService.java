package cc.toprank.byd.waiterApp.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.U_LoginInfoDao;
import cc.toprank.byd.util.Sha1Util;
import cc.toprank.byd.waiterApp.dto.WaiterLoginDTO;
import cc.toprank.byd.waiterApp.vo.WaiterLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.DigestException;
import java.util.Map;

import static cc.toprank.byd.web.constant.CodeMsgConstants.USER_NAMEORPASS_ERROR;
import static cc.toprank.byd.web.constant.CodeMsgConstants.USER_NAMEORPASS_ERROR_MSG;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-6-14 10:17
 */
@Service
public class WaiterLoginService {

    @Autowired
    private U_LoginInfoDao loginInfoMapper;

    public WaiterLoginDTO login(WaiterLoginVO waiterLoginVo) throws DigestException {
        WaiterLoginDTO loginDTO = loginInfoMapper.loginWaiterApp(waiterLoginVo.getLoginName(), Sha1Util.SHA1(waiterLoginVo.getPassword()));
        if (loginDTO == null) {
            BizException.error(USER_NAMEORPASS_ERROR, USER_NAMEORPASS_ERROR_MSG);
        }
        return loginDTO;
    }
}
