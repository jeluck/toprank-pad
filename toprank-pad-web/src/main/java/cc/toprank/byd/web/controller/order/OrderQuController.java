package cc.toprank.byd.web.controller.order;

import cc.toprank.byd.enums.FinancialManageEnum;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.web.service.member.MemberInfoService;
import cc.toprank.byd.web.service.order.OrderQuService;
import cc.toprank.byd.web.vo.member.MemberOpenTicketVO;
import cc.toprank.byd.web.vo.order.OrderDetailVO;
import cc.toprank.byd.web.vo.order.OrderQuVO;
import cc.toprank.byd.web.vo.order.TableOrderInfoVO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by HuTao on 2017-5-2.
 */

@Controller
@RequestMapping("/reception/order")
public class OrderQuController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(OrderQuController.class.getName());

    @Autowired
    private OrderQuService  orderQuService;

    @Autowired
    private MemberInfoService memberInfoService;

    /**
     * @Description：堂食订单信息查询
     * @Author：HuTao
     * @Time: 2017-5-4 10:00
     * @Version 2.0.0
     * @param request
     * @param orderQuVO
     * @return
     *
     */
    @ResponseBody
    @RequestMapping("/quOrderInfo")
    public JSONPObject quOrderInfo(HttpServletRequest request,@ApiIgnore @ModelAttribute("orderQuVO") OrderQuVO orderQuVO){
        //  消费中654  已暂结651  已结帐875  反结帐   已取消876
        //  餐次  桌台  订单号
        //  当前班次  今天      昨天         历史日期
        //  收银员    收银机    开台日期    结束日期
        ResultData resultData = new ResultData();
        try {
            if(null==orderQuVO){
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setData(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            List<TableOrderInfoVO>  tableOrderList=orderQuService.quOrderInfo(orderQuVO);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(tableOrderList);
        } catch (Exception e) {
            logger.error("堂食订单查询发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：根据订单ID， 取订单的详细信息
     * @Author：HuTao
     * @Time: 2017-5-4 10:10
     * @Version 2.0.0
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getOrderInfo")
    public JSONPObject getOrderInfo(HttpServletRequest request){
        Long orderID=Long.valueOf(request.getParameter("orderID").toString());
        ResultData resultData = new ResultData();
        try {
            OrderDetailVO  orderDetailVO=orderQuService.getOrderInfo(getArchiveID(),orderID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(orderDetailVO);
        } catch (Exception e) {
            logger.error("根据订单ID， 取订单的详细信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：重打暂结单
     * @Author：HuTao
     * @Time: 2017-6-5 10:11
     * @Version 2.0.0
     * @param request
     * @return
     */

    @ResponseBody
    @RequestMapping("/repeatPrintTempBilling")
    public JSONPObject repeatPrintTempBilling(HttpServletRequest request,  @RequestParam(required = true, value = "subOrderID") Long subOrderID){
        //   Long orderID=Long.valueOf(request.getParameter("subOrderID").toString());
        ResultData resultData = new ResultData();
        try {
            orderQuService.repeatPrintTempBilling(subOrderID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (Exception e) {
            logger.error("重打暂结单发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：订单开发票
     * @Author：HuTao
     * @Time: 2017-6-5 10:11
     * @Version 2.0.0
     * @param request
     * @return
     */

    @ResponseBody
    @RequestMapping("/orderOpenInvoice")
    public JSONPObject orderOpenInvoice(HttpServletRequest request,@ApiIgnore @ModelAttribute("memberTicketVO")MemberOpenTicketVO memberTicketVO){
        ResultData resultData = new ResultData();
        try {
            memberTicketVO.setOrderType( OrderManagerEnum.OrderSource.ORDER.getValue());     //   堂食订单
            memberInfoService.memberOpenTicket(memberTicketVO);    //  开发票
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (Exception e) {
            logger.error("订单开发票发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }


}
