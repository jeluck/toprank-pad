package cc.toprank.byd.web.controller.counter;

import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.web.service.counter.SettleService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author HouXH
 * @version 1.0.0
 * @description 结账处理
 * @time 2017/4/7 15:20
 */
@RestController
@RequestMapping("/settle")
public class SettleController extends BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private SettleService settleService;


    /**
     * @author HouXH
     * @version 1.0.0
     * @description 查询支付方式
     * @time 2017/4/7 18:50
     * @param subOrderId 子订单号
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "查询结账信息", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getSettleOrderInfo", produces = "application/json;charset=UTF-8")
    public JSONPObject getSettleOrderInfo(@ApiParam(value = "子订单单号" ,name="subOrderId",required = true)
                                              @RequestParam("subOrderId") String subOrderId) {
        ResultData resultData = new ResultData();
        try {
            resultData = settleService.getSettleOrderInfo(subOrderId);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
            e.printStackTrace();
        }
        return getResultJSONPObject(resultData);
    }
}
