package cc.toprank.byd.web.controller.permission;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.constant.WebConstants;
import cc.toprank.byd.web.service.permission.PermissionValidateService;
import cc.toprank.byd.web.vo.permission.PermissionUserInfoVO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证权限
 * Created by ChenKY on 2017-5-26.
 */
@Controller
@RequestMapping("/reception/permission")
public class PermissionValidateController extends BaseController {
    //日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private PermissionValidateService permissionValidateService;

    @ApiOperation(value = "权限验证", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/checkPermission", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject checkPermission(
            @ApiParam("账号") @RequestParam(value = "loginName") String loginName,
            @ApiParam("登录密码") @RequestParam(value = "password") String password,
            @ApiParam("模块代码") @RequestParam(value = "moduleCode") String moduleCode,
            @ApiParam("权限编码") @RequestParam(value = "privilegeCode") String privilegeCode,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("loginName", loginName);
        map.put("password", password);
        map.put("moduleCode", moduleCode);
        map.put("privilegeCode", privilegeCode);
        ResultData resultData = new ResultData();
        try {
            PermissionUserInfoVO permissionUserInfoVO = permissionValidateService.checkPermission(map);
            if (permissionUserInfoVO == null){
                resultData.setCode(CodeMsgConstants.CHECK_PERMISSION_FAIL_CODE);
                resultData.setMessage(CodeMsgConstants.CHECK_PERMISSION_FAIL_MSG);
                return getResultJSONPObject(resultData);
            }
            getRequest().getSession().setAttribute(WebConstants.SessionAttribute.PERMISSION_USER_INFO,permissionUserInfoVO);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(permissionUserInfoVO);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }
}
