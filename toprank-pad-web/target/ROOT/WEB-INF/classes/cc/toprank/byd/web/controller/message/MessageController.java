package cc.toprank.byd.web.controller.message;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.service.MessageService;
import cc.toprank.byd.web.constant.ResultData;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-5-31 9:59
 */
@RestController
@RequestMapping("/reception/message")
@Api(value = "/reception/message", description = "呼叫中心")
public class MessageController extends BaseController {

    private static final String test_tableID = "150132";
    private static final String test_subOrderID = "1380000000244";
    @Autowired
    private MessageService messageService;


    @Override
    public void initSystemParam(Map map) {
        map.put("archiveID", getArchiveID());
        map.put("loginID", getLoginID());
        map.put("source", "WEB");
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息列表
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(收银机)获得消息列表", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getMessageList", produces = "application/json;charset=UTF-8")
    public JSONPObject getMessageList(
            @ApiParam(value = "0为全部") @RequestParam(defaultValue = "0", required = false) Long settingID,
            @ApiParam(value = "0查询未处理,1查询已处理,2查询全部")
            @RequestParam(value = "showType", defaultValue = "0", required = true) Long showType
    ) throws Exception {
        return getResultJSONPObject(ResultData.makeSuccessResult(messageService.getMessageList(getParaMap())));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 呼叫服务(点击版)
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "呼叫服务(点击版)", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/addMessageVClick", produces = "application/json;charset=UTF-8")
    public JSONPObject addMessageVClick(
            @RequestParam(required = true, defaultValue = test_tableID) Long tableID,
            @RequestParam(required = true) Long dictionaryID,
            @RequestParam(required = true) Long settingID,
            @RequestParam(required = true, defaultValue = test_subOrderID) Long subOrderID
    ) throws Exception {
        return getResultJSONPObject(ResultData.makeSuccessResult(messageService.addMessageVClick(getParaMap())));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description
     * @time 2017-5-17 16:33
     */
    @ApiOperation(value = "获取所有服务类型", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getBusinessList", produces = "application/json;charset=UTF-8")
    public JSONPObject getBusinessList() throws Exception {
        return getResultJSONPObject(ResultData.makeSuccessResult(messageService.getBusinessList(getParaMap())));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息处理服务
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(收银机)消息处理服务", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/updateMessage", produces = "application/json;charset=UTF-8")
    public JSONPObject updateMessage(
            @RequestParam(value = "sMSID") Long sMSID,
            @ApiParam(value = "675处理中,677已完成") @RequestParam(defaultValue = "675") Long businessStatus
    ) throws Exception {
        return getResultJSONPObject(ResultData.makeSuccessResult(messageService.updateMessage(getParaMap())));
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息转发
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(收银机)消息转发", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/transferMessage", produces = "application/json;charset=UTF-8")
    public JSONPObject transferMessage(
            @RequestParam(value = "sMSID") Long sMSID,
            @ApiParam(value = "转发对象ID") @RequestParam Long targetID
    ) throws Exception {
        return getResultJSONPObject(ResultData.makeSuccessResult(messageService.transferMessage(getParaMap())));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息转发人列表
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(收银机)消息转发人列表", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getTransferPersonList", produces = "application/json;charset=UTF-8")
    public JSONPObject getTransferPersonList(
    ) throws Exception {
        return getResultJSONPObject(ResultData.makeSuccessResult(messageService.getTransferPersonList(getParaMap())));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息转发人列表(根据RoleID)
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(收银机)消息转发人列表(根据RoleID)", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getTransferPersonListByRoleID", produces = "application/json;charset=UTF-8")
    public JSONPObject getTransferPersonListByRoleID(
            @RequestParam Long roleID,
            @RequestParam(required = false) String searchContent
    ) throws Exception {
        return getResultJSONPObject(ResultData.makeSuccessResult(messageService.getTransferPersonListByRoleID(getParaMap())));
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 轮询 查找最新消息
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(收银机)轮询 查找最新消息", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getNewMessageList", produces = "application/json;charset=UTF-8")
    public JSONPObject getNewMessageList(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime newTime
    ) throws Exception {
        return getResultJSONPObject(ResultData.makeSuccessResult(messageService.getNewMessageList(getParaMap())));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息跳转根据子订单ID获得桌台状态
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(收银机 特殊业务接口)消息跳转根据子订单ID获得桌台状态", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getOrderStatus", produces = "application/json;charset=UTF-8")
    public JSONPObject getOrderStatus(@RequestParam Long subOrderID
    ) throws Exception {
        return getResultJSONPObject(ResultData.makeSuccessResult(messageService.getOrderStatusBySubOrderID(getParaMap())));
    }
}
