package cc.toprank.byd.web.controller.order;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.order.DiscountService;
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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 折扣处理控制类
 * Created by ChenKY on 2017-5-19.
 */
@Controller
@RequestMapping("/reception/discount")
public class DiscountController extends BaseController {

    //日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    @Autowired
    private DiscountService discountService;

    @ApiOperation(value = "权限折扣", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/authorityDiscount", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject authorityDiscount(
            @ApiParam("登录ID") @RequestParam(required = false, value = "loginID", defaultValue = "0") Long loginID,
            @ApiParam("子订单ID") @RequestParam(value = "subOrderIDs") String subOrderIDs,
            @ApiParam("折扣比率") @RequestParam(value = "discountPercentage") Float discountPercentage,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", (loginID == 0 ? getLoginID() : loginID));
        map.put("archiveID", getArchiveID());
        map.put("orgID", getOrgID());
        map.put("subOrderIDs", subOrderIDs);
        map.put("discountPercentage", discountPercentage);
        ResultData resultData = new ResultData();
        try {
            resultData = discountService.authorityDiscount(map);
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

    @ApiOperation(value = "全单折扣", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/orderDiscount", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject orderDiscount(
            @ApiParam("登录ID") @RequestParam(required = false, value = "loginID", defaultValue = "0") Long loginID,
            @ApiParam("子订单ID") @RequestParam(value = "subOrderIDs") String subOrderIDs,
            @ApiParam("折扣比率") @RequestParam(value = "discountPercentage") Float discountPercentage,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", (loginID == 0 ? getLoginID() : loginID));
        map.put("archiveID", getArchiveID());
        map.put("orgID", getOrgID());
        map.put("subOrderIDs", subOrderIDs);
        map.put("discountPercentage", discountPercentage);
        ResultData resultData = new ResultData();
        try {
            resultData = discountService.orderDiscount(map);
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

    @ApiOperation(value = "会员折扣", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/memberDiscount", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject memberDiscount(
            @ApiParam("登录ID") @RequestParam(required = false, value = "loginID", defaultValue = "0") Long loginID,
            @ApiParam("子订单ID") @RequestParam(value = "subOrderIDs") String subOrderIDs,
            @ApiParam("会员验证码类型") @RequestParam(value = "memberCodeType") Integer memberCodeType,
            @ApiParam("会员码") @RequestParam(value = "memberCode") String memberCode,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", (loginID == 0 ? getLoginID() : loginID));
        map.put("archiveID", getArchiveID());
        map.put("orgID", getOrgID());
        map.put("subOrderIDs", subOrderIDs);
        map.put("memberCodeType", memberCodeType);
        map.put("memberCode", memberCode);
        ResultData resultData = new ResultData();
        try {
            resultData = discountService.memberDiscount(map);
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

    @ApiOperation(value = "免服务费", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/freeServiceCharge", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject freeServiceCharge(
            @ApiParam("登录ID") @RequestParam(required = false, value = "loginID", defaultValue = "0") Long loginID,
            @ApiParam("子订单ID") @RequestParam(value = "subOrderIDs") String subOrderIDs,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", (loginID == 0 ? getLoginID() : loginID));
        map.put("archiveID", getArchiveID());
        map.put("orgID", getOrgID());
        map.put("subOrderIDs", subOrderIDs);
        ResultData resultData = new ResultData();
        try {
            resultData = discountService.freeServiceCharge(map);
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

    @ApiOperation(value = "收服务费", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/serviceCharge", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject serviceCharge(
            @ApiParam("登录ID") @RequestParam(required = false, value = "loginID", defaultValue = "0") Long loginID,
            @ApiParam("子订单ID") @RequestParam(value = "subOrderIDs") String subOrderIDs,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", (loginID == 0 ? getLoginID() : loginID));
        map.put("archiveID", getArchiveID());
        map.put("orgID", getOrgID());
        map.put("subOrderIDs", subOrderIDs);
        ResultData resultData = new ResultData();
        try {
            resultData = discountService.serviceCharge(map);
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

    @ApiOperation(value = "减免", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/reduceAmount", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject reduceAmount(
            @ApiParam("登录ID") @RequestParam(required = false, value = "loginID", defaultValue = "0") Long loginID,
            @ApiParam("子订单ID") @RequestParam(value = "subOrderIDs") String subOrderIDs,
            @ApiParam("减免金额") @RequestParam(value = "discountAmount") BigDecimal discountAmount,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", (loginID == 0 ? getLoginID() : loginID));
        map.put("archiveID", getArchiveID());
        map.put("subOrderIDs", subOrderIDs);
        map.put("discountAmount", discountAmount);
        map.put("orgID", getOrgID());
        ResultData resultData = new ResultData();
        try {
            resultData = discountService.reduceAmount(map);
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

    @ApiOperation(value = "员工本次可减免金额", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/employeeCanReduceAmount", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject employeeCanReduceAmount(
            @ApiParam("登录ID") @RequestParam(required = false, value = "loginID", defaultValue = "0") Long loginID,
            @ApiParam("子订单ID") @RequestParam(value = "subOrderIDs") String subOrderIDs,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", (loginID == 0 ? getLoginID() : loginID));
        map.put("archiveID", getArchiveID());
        map.put("orgID", getOrgID());
        map.put("subOrderIDs", subOrderIDs);
        ResultData resultData = new ResultData();
        try {
            BigDecimal bigDecimal = discountService.employeeCanReduceAmount(map);
            Map<String, BigDecimal> resultMap = new HashMap<>();
            resultMap.put("bigDecimal", bigDecimal);
            resultData = resultData.makeResult(resultMap);
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

    @ApiOperation(value = "免单", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/orderFree", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject orderFree(
            @ApiParam("登录ID") @RequestParam(required = false, value = "loginID", defaultValue = "0") Long loginID,
            @ApiParam("子订单ID") @RequestParam(value = "subOrderIDs") String subOrderIDs,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", (loginID == 0 ? getLoginID() : loginID));
        map.put("archiveID", getArchiveID());
        map.put("subOrderIDs", subOrderIDs);
        map.put("orgID", getOrgID());
        ResultData resultData = new ResultData();
        try {
            resultData = discountService.orderFree(map);
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

    @ApiOperation(value = "取消折扣", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/cancleDiscount", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject cancleDiscount(
            @ApiParam("登录ID") @RequestParam(required = false, value = "loginID", defaultValue = "0") Long loginID,
            @ApiParam("子订单ID") @RequestParam(value = "subOrderIDs") String subOrderIDs,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", (loginID == 0 ? getLoginID() : loginID));
        map.put("archiveID", getArchiveID());
        map.put("subOrderIDs", subOrderIDs);
        map.put("orgID", getOrgID());
        ResultData resultData = new ResultData();
        try {
            resultData = discountService.cancleDiscount(map);
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

    @ApiOperation(value = "更新折扣信息", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/updateDiscountInfo", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject updateDiscountInfo(
            @ApiParam("登录ID") @RequestParam(required = false, value = "loginID", defaultValue = "0") Long loginID,
            @ApiParam("子订单ID") @RequestParam(value = "subOrderIDs") String subOrderIDs,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", (loginID == 0 ? getLoginID() : loginID));
        map.put("archiveID", getArchiveID());
        map.put("subOrderIDs", subOrderIDs);
        ResultData resultData = new ResultData();
        try {
            resultData = discountService.updateDiscountInfo(map);
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
