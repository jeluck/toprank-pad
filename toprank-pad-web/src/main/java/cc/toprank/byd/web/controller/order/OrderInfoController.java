package cc.toprank.byd.web.controller.order;

import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.web.service.member.MemberInfoService;
import cc.toprank.byd.web.service.order.OrderInfoEditService;
import cc.toprank.byd.web.vo.UserListVO;
import cc.toprank.byd.web.vo.order.OrderEditVO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description：订单信息编辑修改
 * @Author：HuTao
 * @Time: 2017-4-19 16:58
 * @Version 2.0.0
 * Created by HuTao on 2017-4-19.
 */
@Controller
@RequestMapping("/reception/order")
public class OrderInfoController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(OrderInfoController.class.getName());

    @Autowired
    private MemberInfoService memberInfoService;
    @Autowired
    @Qualifier("orderInfoEditService")
    private OrderInfoEditService orderInfoEditService;

    /**
     * @Description：获取订单编辑信息
     * @Author：HuTao
     * @Time: 2017-5-19 10:18
     * @Version 2.0.0
     * @param subOrderID
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/getEditOrderInfo",  produces = "application/json;charset=UTF-8" )
    public JSONPObject getEditOrderInfo(@ApiParam(required = true, name = "subOrderID", value = "当前子订单ID") Long subOrderID ) {
        ResultData resultData = new ResultData();
        try {
            if(null==subOrderID) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            OrderEditVO orderEditVO= orderInfoEditService.getEditOrderInfo(subOrderID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(orderEditVO);
        } catch(Exception e){
            logger.error("取订单编辑信息发生了错误：" +e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：修改订单编辑信息
     * @Author：HuTao
     * @Time: 2017-5-19 10:19
     * @Version 2.0.0
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/updateOrderInfo",  produces = "application/json;charset=UTF-8" )
    public JSONPObject updateOrderInfo(HttpServletRequest request) {
        ResultData resultData = new ResultData();
        try{
            Long subOrderID =Long.parseLong(request.getParameter("subOrderID").toString());
            Long tableID=Long.parseLong(request.getParameter("tableID").toString());
            Long waiterLoginID=Long.parseLong(request.getParameter("waiterLoginID").toString());
            int  peopleNum=Integer.parseInt(request.getParameter("peopleNum").toString());
            String memo = request.getParameter("memo").toString();
            OrderEditVO orderEditVO = new OrderEditVO();
            orderEditVO.setSubOrderID(subOrderID);    //  子订单ID
            orderEditVO.setTableID(tableID);       //   桌台ID
            orderEditVO.setPeopleNum(peopleNum);     //    人数
            orderEditVO.setWaiterLoginID(waiterLoginID); //    服务员登入ID
            orderEditVO.setMemo(memo);          //     备注
            orderInfoEditService.updateOrderInfo(orderEditVO);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        }catch (Exception e){
            logger.error("修改订单编辑信息发生了错误：" +e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ResponseBody
    @GetMapping(value = "/getServerlist",  produces = "application/json;charset=UTF-8" )
    public JSONPObject getServerlist(HttpServletRequest request) {
        ResultData resultData = new ResultData();
        try {
            String nameOrId = request.getParameter("nameOrId").toString();
            Long orgID = getOrgID();
            String title = "服务员";
            List<UserListVO> userList = memberInfoService.getServerNameList(orgID,title,nameOrId);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            resultData.setData(userList);
        } catch (Exception e) {
            logger.error("根据nameOrId 取服务员列表信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

}
