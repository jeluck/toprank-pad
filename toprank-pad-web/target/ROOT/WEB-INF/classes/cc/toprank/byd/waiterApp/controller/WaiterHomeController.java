package cc.toprank.byd.waiterApp.controller;

import cc.toprank.byd.waiterApp.service.WaiterHomeService;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiSH
 * @version 2.0.0
 * @description 服务员APP登陆
 * @time 2017-6-14 9:57
 */
@RestController
@RequestMapping("/waiter/home")
@Api(value = "/waiter/home", description = "服务员APP登陆")
public class WaiterHomeController extends BaseWaiterController {

    private static final String TAG = "(服务员APP)";

    @Autowired
    WaiterHomeService waiterHomeService;

    @ApiOperation(value = TAG + "服务员APP登陆", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getManagerTableList", produces = "application/json;charset=UTF-8")
    public ResultData getManagerTableList() throws Exception {
        return ResultData.makeSuccessResult(waiterHomeService.getManagerTableList(getParaMap()));
    }
}
