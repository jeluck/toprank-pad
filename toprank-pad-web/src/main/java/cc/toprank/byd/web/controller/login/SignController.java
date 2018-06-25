package cc.toprank.byd.web.controller.login;/**
 * Created by ZhouWei on 2017-6-5.
 */

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.entity.T_LoginUserStatInfoEntity;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.login.LoginService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

/**
 * @param
 * @author zhouwei
 * @version 2.0.0
 * @description 签到签退
 * @time 2017-06-05-13:27
 * @return
 */
@Controller
@RequestMapping("/reception/sign")
public class SignController extends BaseController{
    @Autowired
    private LoginService loginService;
    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 签到
     * @time 2017-06-05-13:27
     * @return
     */
    @ResponseBody
    @RequestMapping("/signIn")
    public JSONPObject SignIn(@ApiParam(value = "工号",required = true) @RequestParam(value = "employeeCode") String employeeCode){
        ResultData resultData = new ResultData();
        try{
            if (employeeCode == null){
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            U_LoginInfoEntity u_loginInfoEntity = loginService.getLoginInfoByEmployCode(employeeCode);
            if (u_loginInfoEntity != null){
                T_LoginUserStatInfoEntity loginUserStatInfoEntity = loginService.getCurrentDaySignInMsg(u_loginInfoEntity.getLoginID(),u_loginInfoEntity.getUserID());
                if (loginUserStatInfoEntity != null){
                    resultData.setCode(CodeMsgConstants.EXIST_SIGNIN);
                    resultData.setMessage(CodeMsgConstants.EXIST_SIGNIN_MSG);
                    return getResultJSONPObject(resultData);
                }
                loginUserStatInfoEntity = new T_LoginUserStatInfoEntity();
                loginUserStatInfoEntity.setLoginID(u_loginInfoEntity.getLoginID());
                loginUserStatInfoEntity.setUserID(u_loginInfoEntity.getUserID());
                loginUserStatInfoEntity.setUserName(u_loginInfoEntity.getUserName());
                loginUserStatInfoEntity.setLoginTime(LocalDateTime.now());
                loginUserStatInfoEntity.setLogID(MaxIDUtils.getID(T_LoginUserStatInfoEntity.class));
                int resultRet = loginService.insertLoginUserStatInfo(loginUserStatInfoEntity);
                if (resultRet > 0){
                    u_loginInfoEntity.setLoginStatus(960L);
//                    u_loginInfoEntity.setLatestLoginTime(LocalDateTime.now());
                    int ret = loginService.signInAndOut(u_loginInfoEntity);
                    if (ret >0){
                        resultData.setCode(CodeMsgConstants.SUCCESS);
                        resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                    }
                }else {
                    resultData.setCode(CodeMsgConstants.FAIL);
                    resultData.setMessage(CodeMsgConstants.FAIL_MSG);
                    return getResultJSONPObject(resultData);
                }
            }else {
                resultData.setCode(CodeMsgConstants.MEMBER_NOTACCOUNT);
                resultData.setMessage(CodeMsgConstants.MEMBER_NOTACCOUNT_MSG);
            }
        }catch (BizException ex){
            resultData.setCode(ex.getCode());
            resultData.setMessage(ex.getMessage());
        }catch (Exception e){
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 签退
     * @time 2017-06-05-13:27
     * @return
     */
    @ResponseBody
    @RequestMapping("/signOut")
    public JSONPObject SignOut(@ApiParam(value = "工号",required = true) @RequestParam(value = "employeeCode") String employeeCode){
        ResultData resultData = new ResultData();
        try{
            if (employeeCode == null){
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
            }
            U_LoginInfoEntity u_loginInfoEntity = loginService.getLoginInfoByEmployCode(employeeCode);
            if (u_loginInfoEntity != null){
                T_LoginUserStatInfoEntity loginUserStatInfoEntity = loginService.getCurrentDaySignOutMsg(u_loginInfoEntity.getLoginID(),u_loginInfoEntity.getUserID());
                if (loginUserStatInfoEntity != null){
                    loginUserStatInfoEntity.setLogoutTime(LocalDateTime.now());
                    int resultRet = loginService.updateLoginUserStatInfo(loginUserStatInfoEntity);
                    if (resultRet > 0){
                        u_loginInfoEntity.setLoginStatus(961L);
                        u_loginInfoEntity.setLatestLoginTime(LocalDateTime.now());
                        int ret = loginService.signInAndOut(u_loginInfoEntity);
                        if (ret >0){
                            resultData.setCode(CodeMsgConstants.SUCCESS);
                            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
                        }
                    }
                }else {
                    resultData.setCode(CodeMsgConstants.EXIST_SIGNOUT);
                    resultData.setMessage(CodeMsgConstants.EXIST_SIGNOUT_MSG);
                    return getResultJSONPObject(resultData);
                }

            }else {
                resultData.setCode(CodeMsgConstants.MEMBER_NOTACCOUNT);
                resultData.setMessage(CodeMsgConstants.MEMBER_NOTACCOUNT_MSG);
            }
        }catch (BizException ex){
            resultData.setCode(ex.getCode());
            resultData.setMessage(ex.getMessage());
        }catch (Exception e){
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }
}
