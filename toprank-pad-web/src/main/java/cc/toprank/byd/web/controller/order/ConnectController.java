package cc.toprank.byd.web.controller.order;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.MapHelper;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.order.ConnectService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Map;

/**
 * @author LiSH
 * @version 2.0.0
 * @description 交接班-WEB入口
 * @time 2017-5-27 14:15
 */
@RestController
@RequestMapping("/reception/connect")
public class ConnectController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(ConnectController.class.getName());

    @Autowired
    private ConnectService connectService;

    public void initSystemParam(Map map) {
        map.put("archiveID", getArchiveID());
        map.put("loginID", getLoginID());
        map.put("loginName", getLoginName());
        map.put("casherID", getCasherID());
        map.put("casherCode", getCasherName());
        map.put("source", "WEB");
    }

    @GetMapping("startWorking")
    @ApiOperation(value = "(交接班接口)交接班-开班")
    public JSONPObject startWorking(@RequestParam Double moneyAmount) {
        Map param = MapHelper
                .put("moneyAmount", moneyAmount)
                .put("archiveID", getArchiveID())
                .put("loginID", getLoginID())
                .put("loginName", getLoginName())
                .put("casherID", getCasherID())
                .put("casherCode", getCasherName()).toMap();
        Map<String, Object> result = connectService.startWorking(param);
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }

    @GetMapping("isInWorking")
    @ApiOperation(value = "(交接班接口) 当前时间是否处于开班状态")
    public JSONPObject isInWorking() {
        Map param = MapHelper
                .put("archiveID", getArchiveID())
                .put("loginID", getLoginID())
                .put("casherID", getCasherID())
                .toMap();
        Map<String, Object> result = connectService.isInWorking(param);
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }

    @GetMapping("getConnectData")
    @ApiOperation(value = "(交接班接口)交接班-获得详细数据")
    public JSONPObject getConnectData() throws Exception {
        Map param = MapHelper.put("archiveID", getArchiveID()).
                put("loginID", getLoginID()).put("casherID", getCasherID()).toMap();
        Map<String, Object> result = connectService.getConnectData(param);
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }


    @GetMapping("saveWorking")
    @ApiOperation(value = "(交接班接口)交接班-交班")
    public JSONPObject saveWorking() throws Exception {
        Map param = MapHelper.put("archiveID", getArchiveID()).
                put("loginID", getLoginID()).put("casherID", getCasherID()).toMap();
        Map<String, Object> result = connectService.saveWorking(param);
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }

    @GetMapping("getWorkingList")
    @ApiOperation(value = "(交接班接口)交接班-获得交接班列表数据")
    public JSONPObject getWorkingList(@RequestParam(required = false) String searchContent,
                                      @RequestParam(defaultValue = "2017-06-12") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startTime,
                                      @RequestParam(defaultValue = "2017-06-12") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endTime) {
        Map<String, Object> pageMap = getPageMap();
        pageMap.put("startTime", DateUtils.getDayStart(startTime));
        pageMap.put("endTime", DateUtils.getDayEnd(endTime));
        Map<String, Object> result = connectService.getWorkingList(pageMap);
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }

    @GetMapping("getConnectDataByWorkingID")
    @ApiOperation(value = "(交接班接口)交接班-获得交接班单条明细")
    public JSONPObject getConnectDataByWorkingID(@RequestParam Long workingID) throws Exception {
        Map param = MapHelper.put("workingID", workingID).toMap();
        Map<String, Object> result = connectService.getConnectDataByWorkingID(param);
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }

    @GetMapping("prePrint")
    @ApiOperation(value = "(交接班接口)交接班-预打印")
    public JSONPObject prePrint(@RequestParam Long workingID) throws Exception {
        Map param = MapHelper.put("workingID", workingID).toMap();
        Map<String, Object> result = connectService.prePrint(param);
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }


    @GetMapping("addDailyWorking")
    @ApiOperation(value = "(日结接口)添加日结信息")
    public JSONPObject addDailyWorking() throws Exception {
        Map<String, Object> result = connectService.addDailyWorking(getParaMap());
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }


    @GetMapping("getDailyWorkingList")
    @ApiOperation(value = "(日结接口)获得日结列表")
    public JSONPObject getDailyWorkingList(
                                           @RequestParam(required = false) String searchContent,
                                           @RequestParam(defaultValue = "2017-06-12") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startTime,
                                           @RequestParam(defaultValue = "2017-06-12") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endTime) {
        Map<String, Object> param = getParaMap();
        param.put("startTime", DateUtils.getDayStart(startTime));
        param.put("endTime",DateUtils.getDayEnd(endTime));
        Map<String, Object> result = connectService.getDailyWorkingList(param);
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }

    @GetMapping("getDailyWorkingDetail")
    @ApiOperation(value = "(日结接口)查看日结详细")
    public JSONPObject getDailyWorkingDetail(@RequestParam(required = false) Long workingID) throws Exception {
        Map<String, Object> result = connectService.getDailyWorkingDetail(getParaMap());
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }


    @GetMapping("checkBeforeDailyWorking")
    @ApiOperation(value = "(日结接口)检查上一个营业日是否日结")
    public JSONPObject checkBeforeDailyWorking() {
        Map<String, Object> result = connectService.checkBeforeDailyWorking(getParaMap());
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }


    @GetMapping("prePrintDailyWorking")
    @ApiOperation(value = "(日结接口)日结预打印")
    public JSONPObject prePrintDailyWorking(@RequestParam(required = false) Long workingID) throws Exception {
        Map<String, Object> result = connectService.prePrintDailyWorking(getParaMap());
        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }
}
