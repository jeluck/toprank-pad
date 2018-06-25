package cc.toprank.byd.web.controller.login;


import cc.toprank.byd.util.Sha1Util;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.web.constant.WebConstants;
import cc.toprank.byd.web.service.login.LoginService;
import cc.toprank.byd.web.dto.UserInfoVo;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description： 用户登入
 * @Author：HuTao
 * @Time: 2017-3-1 16:33
 * @Version 2.0.0
 */

@Controller
@RequestMapping("/reception")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;


    /**
     * @param request
     * @param response
     * @return
     * @Description： 用户登入验证
     * @Author：HuTao
     * @Time: 2017-3-2 13:14
     * @Version 2.0.0
     */
    @ResponseBody
    @GetMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "loginName", value = "loginName", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "query", name = "password", value = "password", dataType = "String", required = false),
    })
    public JSONPObject login(HttpServletRequest request, HttpServletResponse response) {
        ResultData resultData = new ResultData();
        try {
            String loginName = request.getParameter(WebConstants.RequestParameter.LOGIN_NAME).toString();
            String passWord = Sha1Util.SHA1(request.getParameter(WebConstants.RequestParameter.PASSWORD));
            UserInfoVo userInfo = loginService.getUserInfo(loginName,passWord);

            if(null==userInfo) {
                resultData.setCode(CodeMsgConstants.USER_NAMEORPASS_ERROR) ;
                resultData.setMessage(CodeMsgConstants.USER_NAMEORPASS_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }

            //TODO 补全逻辑
            userInfo.setCasherID(1L);
            userInfo.setCasherName("test收银机");
            // 增加

            request.getSession().setAttribute(WebConstants.SessionAttribute.USER_INFO, userInfo);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(userInfo);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @Description： 操作员注销
     * @Author：HuTao
     * @Time: 2017-3-3 15:04
     * @Version 2.0.0
     */
    @ApiOperation(value = "操作用户注销", httpMethod = "GET", notes = "返回信息:1 注销成功 0注销失败")
    @ResponseBody
    @GetMapping("/logout")
    public JSONPObject logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultData resultData = new ResultData();
        String result = "0";
        try {
            request.getSession().invalidate();
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (Exception e) {
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }


}
