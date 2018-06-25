package cc.toprank.byd.web.controller.order;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.constant.ParamType;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.order.RefundService;
import cc.toprank.byd.web.vo.order.RefundQueryVO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author LiuHM
 * @version 2.0.0
 * @description 退订金记录-WEB入口
 */
@RestController
@RequestMapping("/reception/refund")
public class RefundController extends BaseController {

    private final static Logger log = Logger.getLogger(RefundController.class);

    @Autowired
    private RefundService refundService;

    @ApiOperation(value = "退订金", httpMethod = "GET", response = JSONPObject.class, notes = "退订金记录列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dateFlag", defaultValue = "0", value = "1-今天，2-昨天", dataType = "int", paramType = ParamType.QUERY, required = false),
            @ApiImplicitParam(name = "bookingCode", value = "预订编号", dataType = "string", paramType = ParamType.QUERY, required = false),
                @ApiImplicitParam(name = "dealUer", value = "操作人", dataType = "string", paramType = ParamType.QUERY, required = false),
            @ApiImplicitParam(name = "refundDateStart", value = "退款开始日期", paramType = ParamType.QUERY, required = false),
            @ApiImplicitParam(name = "refundDateEnd", value = "退款结束日期", paramType = ParamType.QUERY, required = false),
            @ApiImplicitParam(name = "pageSize", value = "每页显示记录数", defaultValue = "10", paramType = ParamType.QUERY, required = false),
            @ApiImplicitParam(name = "pageNum" , value = "页码", defaultValue = "1", paramType = ParamType.QUERY, required = false)
    })
    @ResponseBody
    @RequestMapping(value = "/getRefundList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JSONPObject getRefundList(@ApiIgnore @ModelAttribute("refundQueryVO")RefundQueryVO refundQueryVO) {
        if(log.isDebugEnabled()) {
            log.debug("订金退款记录查询请求入参：" + (refundQueryVO == null ? "" : refundQueryVO.toString()));
        }
        if(refundQueryVO == null) {
            refundQueryVO = new RefundQueryVO();
        }
        refundQueryVO.setArchiveID(super.getArchiveID());
        ResultData resultData = new ResultData();
        List<Map<String, Object>> dataList = refundService.getRefundList(refundQueryVO);
        if(dataList == null || dataList.isEmpty()) {
            resultData.setCode(CodeMsgConstants.NODATA);
        } else {
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(dataList);
        }
        return getResultJSONPObject(resultData);
    }

    @ResponseBody
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @ApiOperation(value = "退订金详情", httpMethod = "GET", response = JSONPObject.class, notes = "退订金记录详情")
    public JSONPObject getRefundInfo(@ApiParam(name = "bookingID", required = true, value = "预订ID") Long bookingID,
                                     @ApiParam(name="DealID", required = true, value = "退订金处理单号") Long DealID) {
        ResultData resultData = new ResultData();
        if(DealID == null || bookingID == null) {
            resultData.setCode(CodeMsgConstants.PARAM_ERROR);
        } else {
            Map<String, Object> data = refundService.getRefund(bookingID, DealID);
            if(data == null || data.isEmpty()) {
                resultData.setCode(CodeMsgConstants.NODATA);
            }else {
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setData(data);
            }
        }
        return getResultJSONPObject(resultData);
    }

}
