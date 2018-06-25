package cc.toprank.byd.web.controller.order;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.component.PrintComponent;
import cc.toprank.byd.entity.O_SubOrderInfoEntity;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.menu.O_SubOrderInfoService;
import cc.toprank.byd.web.service.print.TicketPrintService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LiuHM on 2017-6-8.
 */
@RestController
@RequestMapping("/reception/print")
public class TicketPrintInfoController extends BaseController {

    @Autowired
    private TicketPrintService ticketPrintService;

    @Autowired
    private PrintComponent printComponent;

    @Autowired
    private O_SubOrderInfoService o_SubOrderInfoService;

    @ApiOperation(value = "打印日志", httpMethod = "GET", response = JSONPObject.class, notes = "打印记录列表")
    @ResponseBody
    @RequestMapping(value = "/getPrintLogList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JSONPObject getPrintLogList(@ApiParam(name = "printDate", required = false, value = "打印日期") String printDate,
                                       @ApiParam(name = "ceriation", required = false, value = "内容/印机") String ceriation) {
        ResultData resultData = new ResultData();
        List<Map<String, Object>> dataList = ticketPrintService.getPrintLogList(printDate, ceriation);
        if (dataList == null || dataList.isEmpty()) {
            resultData.setCode(CodeMsgConstants.NODATA);
        } else {
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(dataList);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "重新打印订单", httpMethod = "GET", response = JSONPObject.class, notes = "重新打印订单")
    @ResponseBody
    @RequestMapping(value = "/reprint", method = RequestMethod.GET)
    public JSONPObject reprint(@ApiParam(required = true, name = "recordIDs", value = "打印记录ID") String recordIDs) {
        ResultData resultData = new ResultData();
        if (StringUtil.isEmpty(recordIDs)) {
            resultData.setCode(CodeMsgConstants.PARAM_ERROR);
        } else {
            String regp = "^\\d+([,，]\\d+)*$";
            Pattern p = Pattern.compile(regp);
            Matcher m = p.matcher(recordIDs);
            if (!m.matches()) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
            } else {
                String[] ids = recordIDs.split(",");
                for (String id : ids) {
                    try {
                        Long recordID = Long.parseLong(id);
                        printComponent.reprintTicket(recordID, getLoginID());
                    } catch (Exception e) {
                    }
                }
            }
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "重打小列表", httpMethod = "GET", response = JSONPObject.class, notes = "重打小列表")
    @ResponseBody
    @RequestMapping(value = "/getPrintListBySubOrder", method = RequestMethod.GET)
    public JSONPObject getPrintListBySubOrder(@ApiParam(name = "subOrderID", required = true, value = "subOrderID") Long subOrderID) {
        ResultData resultData = new ResultData();
        if (subOrderID == null) {
            resultData.setCode(CodeMsgConstants.PARAM_ERROR);
        } else {
            try {
                O_SubOrderInfoEntity subOrder = o_SubOrderInfoService.queryBySubOrderID(subOrderID);
                Map<String, Object> resultMap = new HashMap();
                resultMap.put("orderID", subOrder.getOrderID());
                resultMap.put("tableName", subOrder.getTableName());
                resultMap.put("openTime", subOrder.getCreateTime());
                List<Map<String, Object>> dataList = ticketPrintService.getRecordsBySubOrder(subOrderID);
                resultMap.put("dataList", dataList);
                resultData.setData(resultMap);
            } catch (Exception e) {
                resultData.setCode(CodeMsgConstants.ERROR);
                resultData.setMessage(e.getMessage());
            }
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "打印历史记录", httpMethod = "GET", response = JSONPObject.class, notes = "打印历史记录")
    @ResponseBody
    @RequestMapping(value = "/getPrintHistory", method = RequestMethod.GET)
    public JSONPObject getPrintHistory(@ApiParam(name = "recordID", required = true, value = "recordID") Long recordID) {
        ResultData resultData = new ResultData();
        if (recordID == null) {
            resultData.setCode(CodeMsgConstants.PARAM_ERROR);
        } else {
            Map<String, Object> data = ticketPrintService.getRecordInfoById(recordID);
            List<Map<String, Object>> dataList = ticketPrintService.getPrintHistoryByRedord(recordID);
            data.put("dataList", dataList);
            resultData.setData(data);
        }
        return getResultJSONPObject(resultData);
    }
}
