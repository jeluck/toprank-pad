package cc.toprank.byd.stall.controller;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.NumberUtil;
import cc.toprank.byd.entity.B_StallWeighContentInfoEntity;
import cc.toprank.byd.entity.B_StallWeighSettingInfoEntity;
import cc.toprank.byd.pad.controller.PadController;
import cc.toprank.byd.stall.dto.StallWeighSettingInfoVO;
import cc.toprank.byd.stall.service.SettingsService;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 沉重档口 基础信息设置
 *
 * @author ZhaoLC
 * @Time 2017-3-13 14:00
 */
@RestController
@RequestMapping("/stall/settings")
@Api(value = "/stall/settings", description = "基础信息设置")
public class SettingsController extends PadController {
    @Autowired
    private SettingsService settingsService;

    /**
     * 查询称重档口 看板信息
     *
     * @return
     * @author ZhaoLC
     * @Time 2017-3-13 14:00
     */
    @ApiOperation(value = "查询称重档口看板信息", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/queryStallWeighContentInfoList", produces = "application/json;charset=UTF-8")
    public ResultData queryStallWeighContentInfoList(@ApiParam(required = true, name = "stallID", value = "档口编号") @RequestParam(value = "stallID") Long stallID,
                                                     HttpServletRequest request) {
        if(stallID == null){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<B_StallWeighContentInfoEntity> stallWeighContentInfoList = settingsService.selectStallWeighContentInfoList(stallID);
        return ResultData.makeSuccessResult(stallWeighContentInfoList);
    }

    /**
     * @description： 获取档口配置信息
     * @author：ZhaoLC
     * @time: 2017-3-16 11:00
     * @version 2.0.0
     */
    @ApiOperation(value = "获取档口配置信息", httpMethod = "POST", response = ResultData.class)
    @RequestMapping(value = "/getStallWeighSetting", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultData getStallWeighSetting(@ApiParam(value = "档口ID") @RequestParam Long stallID,
                                           HttpServletRequest request) throws Exception {
        if(stallID == null){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        B_StallWeighSettingInfoEntity stallWeighSettingInfo = settingsService.getStallWeighSettingByID(stallID);
        return ResultData.makeResult(stallWeighSettingInfo);
    }

    /**
     * @description： 查询所有档口信息
     * @author：ZhaoLC
     * @time: 2017-3-16 11:00
     * @version 2.0.0
     */
    @ApiOperation(value = "查询所有档口信息", httpMethod = "POST", response = ResultData.class)
    @RequestMapping(value = "/getAllStallWeighSetting", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public ResultData getAllStallWeighSetting(HttpServletRequest request, @RequestParam(required = false) Long archiveID) throws Exception {
        if(archiveID == null){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        List<B_StallWeighSettingInfoEntity> stallWeighSettingInfoList = settingsService.getStallWeighSettingInfoAll(archiveID);
        return ResultData.makeResult(stallWeighSettingInfoList);
    }

}
