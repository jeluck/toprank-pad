package cc.toprank.byd.pad.controller;

import cc.toprank.byd.service.MessageService;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 呼叫中心
 *
 * @author LiSH
 * @version 2.0.0
 * @time 2017-5-17 17:07
 */
@RestController
@RequestMapping("/pad/message")
@Api(value = "/pad/message", description = "呼叫中心")
public class PadMessageController extends PadController {

    private static final String test_tableID = "150068";
    private static final String test_subOrderID = "1380000000244";

    @Autowired
    private MessageService messageService;


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 呼叫服务(点击版)
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(水牌专用)呼叫服务(点击版)", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/addMessageVClick", produces = "application/json;charset=UTF-8")
    public ResultData addMessageVClick(
            @RequestParam(required = true) Long dictionaryID,
            @RequestParam(required = true) Long settingID,
            @RequestParam(required = true, defaultValue = test_subOrderID) Long subOrderID
    ) throws Exception {
        return ResultData.makeSuccessResult(messageService.addMessageVClick(getParaMap()));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 呼叫服务(信息版)
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "(水牌专用)呼叫服务(聊天版)", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/addMessageVMsg", produces = "application/json;charset=UTF-8")
    public ResultData addMessageVMsg(
            @RequestParam(required = true) String sMSContent,
            @RequestParam(required = true, defaultValue = test_subOrderID) Long subOrderID
    ) throws Exception {
        return ResultData.makeSuccessResult(messageService.addMessageVMsg(getParaMap()));
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
        return ResultData.makeResult(messageService.getBusinessList(getParaMap()).get("businessList"));
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
        return ResultData.makeResult(messageService.getMessageContentList(getParaMap()).get("messageContentList"));
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息处理服务
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "消息处理服务", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/updateMessage", produces = "application/json;charset=UTF-8")
    public ResultData updateMessage(
            @RequestParam(value = "sMSID") Long sMSID,
            @ApiParam(value = "675处理中,677已完成") @RequestParam(defaultValue = "675") Long businessStatus,
            @RequestParam(value = "loginID") Long loginID
    ) throws Exception {
        return ResultData.makeSuccessResult(messageService.updateMessage(getParaMap()));
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息转发
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "消息转发", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/transferMessage", produces = "application/json;charset=UTF-8")
    public ResultData transferMessage(
            @RequestParam(value = "sMSID") Long sMSID,
            @RequestParam(name = "当前人ID") Long loginID,
            @RequestParam(name = "转发对象ID") Long targetID
    ) throws Exception {
        return ResultData.makeSuccessResult(messageService.transferMessage(getParaMap()));
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得消息类型数量
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "获得消息类型数量", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getMessageCountList", produces = "application/json;charset=UTF-8")
    public ResultData getMessageCountList(
    ) throws Exception {
        return ResultData.makeResult(messageService.getMessageCountList(getPageMap()));
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 消息列表
     * @time 2017-5-17 16:07
     */
    @ApiOperation(value = "获得消息列表", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "/getMessageList", produces = "application/json;charset=UTF-8")
    public ResultData getMessageList(
            @RequestParam(value = "pageNum", defaultValue = "1", required = true) int pageNum,
            @ApiParam(value = "消息类型ID")
            @RequestParam(required = false) Long settingID,
            @ApiParam(value = "0查询未处理,1查询已处理,2查询全部")
            @RequestParam(value = "showType", defaultValue = "0", required = true) Long showType
    ) throws Exception {
        return ResultData.makeResult(messageService.getMessageList(getPageMap()));
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
