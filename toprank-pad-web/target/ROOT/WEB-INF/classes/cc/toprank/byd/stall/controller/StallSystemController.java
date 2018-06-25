package cc.toprank.byd.stall.controller;

import cc.toprank.byd.constant.StallConstants;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.pad.controller.PadController;
import cc.toprank.byd.util.Sha1Util;
import cc.toprank.byd.stall.service.StallSystemService;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @version 2.0.0
 * @description：系统设置控制器
 * @author：ZhaoLc
 * @time: 2017-3-14 15:00
 */
@RestController
@RequestMapping("/stall/system")
@Api(value = "/stall/system", description = "系统设置")
public class StallSystemController extends PadController {
    @Autowired
    private StallSystemService systemService;

    /**
     * @description： 用户登陆操作
     * 1：用户需要传入工号，密码，档案编号进行登陆权限验证
     * 2：根据登陆情况返回对应信息
     * 3：若登陆成功后，将登陆的信息保存在session中
     * @author：ZhaoLC
     * @time: 2017-3-14 15:00
     * @version 2.0.0
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "系统登陆", httpMethod = "POST", response = ResultData.class)
    public ResultData login(
            @ApiParam(required = true, name = "userName", value = "工号") @RequestParam(value = "userName") String userName,
            @ApiParam(required = true, name = "userPwd", value = "密码") @RequestParam(value = "userPwd") String userPwd,
            @ApiParam(required = true, name = "stallID", value = "档口ID") @RequestParam(value = "stallID") String stallID,
            HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashedMap();
        map.put("employeecode", userName);//用户名
        map.put("loginpassword", Sha1Util.SHA1(userPwd));//密码
        map.put("stallID", stallID);//档口id

        //进行登录
        Map<String, Object> loginData = systemService.login(map);
        if (loginData == null) {
            return ResultData.makeResult(false);
        } else {
            super.getSession().setAttribute(StallConstants.STALLID_CACHE_KEY, loginData.get("U_LoginInfo"));
            super.getSession().setAttribute(StallConstants.STALL_CACHE_KEY, loginData.get("B_StallWeighSettingInfo"));
            return ResultData.makeSuccessResult(loginData);
        }
    }

    /**
     * @description： 用户注销登录
     * 1：用户需要传入工号，密码，档案编号进行登陆权限验证
     * 2：根据登陆情况返回对应信息
     * 3：若登陆成功后，将登陆的信息保存在session中
     * @author：ZhaoLC
     * @time: 2017-3-14 15:00
     * @version 2.0.0
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "注销登录", httpMethod = "POST", response = ResultData.class)
    public ResultData logout(HttpServletRequest request) throws Exception {
        U_LoginInfoEntity loginInfo = (U_LoginInfoEntity) super.getSession().getAttribute(StallConstants.STALLID_CACHE_KEY);
        if (loginInfo == null) {
            return ResultData.makeSuccessResult();
        }
        systemService.logout(loginInfo.getLoginID());
        request.getSession().invalidate();
        return ResultData.makeSuccessResult();
    }

}
