package cc.toprank.byd.web.controller.counter;

import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.web.service.counter.C_PaymentMethodInfoService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HouXH
 * @version 1.0.0
 * @description 支付方式获取
 * @time 2017/4/7 18:21
 */
@RestController
@RequestMapping("/paymentMethod")
public class PaymentMethodController extends BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private C_PaymentMethodInfoService paymentMethodInfoService;

    /**
     * @author HouXH
     * @version 1.0.0
     * @description 查询支付方式
     * @time 2017/4/7 18:50
     * @return
     */
    @ResponseBody
    @ApiOperation(value = "查询支付方式信息", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getPaymentMethod", produces = "application/json;charset=UTF-8")
    public JSONPObject getPaymentMethod() {
        ResultData resultData = new ResultData();
        try {
            resultData = paymentMethodInfoService.getPaymentMethod();
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
            e.printStackTrace();
        }
        return getResultJSONPObject(resultData);
    }
}
