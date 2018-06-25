package cc.toprank.byd.waiterApp.controller;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.MapHelper;
import cc.toprank.byd.waiterApp.constant.WaiterConstants;
import cc.toprank.byd.waiterApp.constant.WaiterErrorConstants;
import cc.toprank.byd.waiterApp.dto.WaiterLoginDTO;
import cc.toprank.byd.waiterApp.service.WaiterLoginService;
import cc.toprank.byd.waiterApp.utils.WaiterUtils;
import cc.toprank.byd.waiterApp.vo.WaiterLoginVO;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author LiSH
 * @version 2.0.0
 * @description 服务员APP登陆
 * @time 2017-6-14 9:57
 */
@RestController
@RequestMapping("/waiter")
@Api(value = "/waiter", description = "服务员APP登陆")
public class WaiterLoginController extends BaseWaiterController {

    private static final String TAG = "(服务员APP)";

    @Autowired
    WaiterLoginService waiterLoginService;

    @ApiOperation(value = TAG + "服务员APP登陆", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public ResultData login(@RequestBody WaiterLoginVO waiterLoginVo) throws Exception {
        WaiterLoginDTO login = waiterLoginService.login(waiterLoginVo);
        if (login == null) {
            BizException.error(WaiterErrorConstants.UserLoginError.code, WaiterErrorConstants.UserLoginError.msg);
        }
        Map<String, Object> tokenMap = MapHelper.newMap();
        tokenMap.put(WaiterConstants.SessionAttribute.LOGIN_INFO, login);
        String token = WaiterUtils.setToken(tokenMap);
        getSession().setAttribute(WaiterConstants.CommonAttribute.TOKEN,token);
        setSessionValue(WaiterConstants.SessionAttribute.LOGIN_INFO, login);

        Map<String, Object> resultMap = MapHelper.newMap();
        resultMap.put("loginInfo",login);
        resultMap.put("token",token);
        return ResultData.makeSuccessResult(resultMap);
    }
}
