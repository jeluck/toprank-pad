package cc.toprank.byd.waiterApp.controller;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.service.MessageService;
import cc.toprank.byd.waiterApp.constant.WaiterConstants;
import cc.toprank.byd.web.constant.ResultData;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * 服务员APP 消息中心
 *
 * @author LiSH
 * @version 2.0.0
 * @time 2017-5-17 17:07
 */
@RestController
@RequestMapping("/waiter/message")
@Api(value = "/waiter/message", description = "呼叫中心")
public class WaiterMessageController extends BaseWaiterController {

    private static final String test_tableID = "150262";
    private static final String test_subOrderID = "1380000000244";

    @Autowired
    private MessageService messageService;

    @Override
    public void initRequestParamChild(Map map){
        map.put("recipientID", getCurrentLoginInfo().getLoginID());
    }

//    @ModelAttribute
//    public void init() {
//        Object sessionValue = getSessionValue(WaiterConstants.SessionAttribute.LOGIN_INFO);
//        if (sessionValue == null) {
//            BizException.error("请登陆");
//        }
//    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得消息类型数量
     * @time 2017-6-5 15:41
     */
    @ApiOperation(value = "(服务员APP)获得消息类型数量", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getMessageCountList", produces = "application/json;charset=UTF-8")
    public ResultData getMessageCountList(
            @RequestParam String token
    ) throws Exception {
        return ResultData.makeResult(messageService.getMessageCountList(getParaMap()));
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息列表
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(服务员APP)获得消息列表", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getMessageList", produces = "application/json;charset=UTF-8")
    public ResultData getMessageList(
            @RequestParam(value = "pageNum", defaultValue = "1", required = true) int pageNum,
            @ApiParam(value = "消息类型ID")
            @RequestParam(required = false) Long settingID,
            @ApiParam(value = "0查询未处理,1查询已处理,2查询全部")
            @RequestParam(value = "showType", defaultValue = "2", required = true) Long showType
    ) throws Exception {
        return ResultData.makeResult(messageService.getMessageList(getParaMap()));
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息处理服务
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(服务员APP)消息处理服务", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/updateMessage", produces = "application/json;charset=UTF-8")
    public ResultData updateMessage(
            @RequestParam(value = "sMSID") Long sMSID,
            @ApiParam(value = "675处理中,677已完成") @RequestParam(defaultValue = "675") Long businessStatus
    ) throws Exception {
        return ResultData.makeSuccessResult(messageService.updateMessage(getParaMap()));
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息转发
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(服务员APP)消息转发", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/transferMessage", produces = "application/json;charset=UTF-8")
    public ResultData transferMessage(
            @RequestParam(value = "sMSID") Long sMSID,
            @RequestParam(value = "targetID") Long targetID
    ) throws Exception {
        return ResultData.makeSuccessResult(messageService.transferMessage(getParaMap()));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息转发人列表
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(服务员APP)消息转发人列表", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getTransferPersonList", produces = "application/json;charset=UTF-8")
    public ResultData getTransferPersonList(
    ) throws Exception {
        return ResultData.makeSuccessResult(messageService.getTransferPersonList(getParaMap()));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息转发人列表(根据RoleID)
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(服务员APP)消息转发人列表(根据RoleID)", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getTransferPersonListByRoleID", produces = "application/json;charset=UTF-8")
    public ResultData getTransferPersonListByRoleID(
            @RequestParam Long roleID
    ) throws Exception {
        return ResultData.makeSuccessResult(messageService.getTransferPersonListByRoleID(getParaMap()));
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 轮询 查找最新消息
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(服务员APP)轮询 查找最新消息", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getNewMessageList", produces = "application/json;charset=UTF-8")
    public ResultData getNewMessageList(
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime newTime
    ) throws Exception {
        return ResultData.makeSuccessResult(messageService.getNewMessageList(getParaMap()));
    }



    /**
     * @author LiSH
     * @version 2.0.0
     * @description 呼叫服务(点击版)
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(水牌专用)呼叫服务(点击版)", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/addMessageVClick", produces = "application/json;charset=UTF-8")
    public ResultData addMessageVClick(
            @RequestParam(required = true, defaultValue = test_tableID) Long tableID,
            @RequestParam(required = true) Long dictionaryID,
            @RequestParam(required = true) Long settingID,
            @RequestParam(required = true, defaultValue = test_subOrderID) Long subOrderID
    ) throws Exception {
        return ResultData.makeSuccessResult(messageService.addMessageVClick(getParaMap()));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得消息聊天内容框
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(水牌专用)获得消息聊天内容框", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getMessageContentList", produces = "application/json;charset=UTF-8")
    public ResultData getMessageContentList(
            @RequestParam(required = true, defaultValue = test_subOrderID) Long subOrderID
    ) throws Exception {
        return ResultData.makeResult(messageService.getMessageContentList(getParaMap()));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description
     * @time 2017-5-17 16:33
     */
    @ApiOperation(value = "(水牌专用)获取所有服务类型", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getBusinessList", produces = "application/json;charset=UTF-8")
    public ResultData getBusinessList() throws Exception {
        return ResultData.makeResult(messageService.getBusinessList(getParaMap()));
    }
//    ------------------------系统需要初始化的方法---------------------------

    /**
     * @author LiSH
     * @version 2.0.0
     * @description O_MessageSettingInfo系统初始化需要做的数据
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "服务类型初始化(仅用作创造测试数据,勿点)", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/initBusinessList", produces = "application/json;charset=UTF-8")
    public ResultData initBusinessList(
    ) throws Exception {
        return ResultData.makeSuccessResult(messageService.initBusinessList(getParaMap()));
    }
}
