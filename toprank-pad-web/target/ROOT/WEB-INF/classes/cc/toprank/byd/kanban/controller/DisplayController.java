package cc.toprank.byd.kanban.controller;

import cc.toprank.byd.config.BaseConfig;
import cc.toprank.byd.entity.B_MerchantInfoEntity;
import cc.toprank.byd.entity.B_MonitorInfoEntity;
import cc.toprank.byd.kanban.service.DisplayService;
import cc.toprank.byd.pad.controller.PadController;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.menu.B_MerchantInfoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 看板接口
 *
 * @author LeeJun
 * @create 2017-03-07 13:14
 */
@RestController
@RequestMapping("kanban/display")
@Api(value = "kanban/display", description = "看板接口")
public class DisplayController extends PadController {

    @Autowired
    private DisplayService displayService;
    @Autowired
    private B_MerchantInfoService merchantInfoService;

    /**
     * @return
     * @description： 1.根据IP和端口连接到离线服务器，连接成功后返回该商家档案信息以及该商家在后台配置的所有看板的信息；
     * 2.将商家档案信息保存在session中方便后续接口调用；
     * 3.若连接不上离线服务器，APP则应当给予错误提示；
     * @author：LiYC
     * @time: 2017-3-7 15:03
     * @version 2.0.0
     */
    @PostMapping(value = "init", produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "看板初始化", httpMethod = "POST", response = ResultData.class)
    public ResultData init() {
        // 查询档案信息
        B_MerchantInfoEntity merchantInfo = merchantInfoService.getMerchantInfoByOnly();
        if (merchantInfo == null) {
            return ResultData.makeFailResult(CodeMsgConstants.MERCHANT_NON_EXIST);
        }
        // 查询看板信息集合
        List<B_MonitorInfoEntity> b_monitorInfoList = displayService.getKanBanInfoList(merchantInfo.getArchiveID());

        // 档案信息存入session
        super.getSession().setAttribute("B_MerchantInfo", merchantInfo);

        //返回档案信息和看板列表
        Map<String, Object> initMap = new HashedMap();
        initMap.put("B_MerchantInfo", merchantInfo);
        initMap.put("B_MonitorInfoList", b_monitorInfoList);
        return ResultData.makeSuccessResult(initMap);
    }

    /**
     * @return
     * @description： 根据选中的看板的编号返回看板详细信息
     * @author：LiYC
     * @time: 2017-3-7 15:03
     * @version 2.0.0
     */
    @ApiOperation(value = "获取看板配置信息", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "monitor/{monitorID}", produces = "application/json;charset=UTF-8")
    public ResultData getMonitorInfo(@ApiParam(value = "看板编号") @PathVariable(value = "monitorID") Long monitorID) {
        //查询看板配置信息
        B_MonitorInfoEntity b_monitorInfo = displayService.getMerchantInfoByID(monitorID);

        super.getSession().setAttribute("B_MonitorInfo", b_monitorInfo);
        //返回看板配置信息
        return ResultData.makeResult(b_monitorInfo);
    }

    /**
     * @return
     * @description： 根据档案编号获取看板列表
     * @author：LiYC
     * @time: 2017-3-7 15:03
     * @version 2.0.0
     */
    @ApiOperation(value = "获取看板信息列表", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "monitors", produces = "application/json;charset=UTF-8")
    public ResultData getMonitorLIst() {
        Object obj = super.getSessionValue("B_MerchantInfo");
        if (obj != null && obj instanceof B_MerchantInfoEntity) {
            Long archiveID = ((B_MerchantInfoEntity) obj).getArchiveID();
            //查询看板列表
            List<B_MonitorInfoEntity> b_monitorList = displayService.getKanBanInfoList(archiveID);
            return ResultData.makeResult(b_monitorList);
        } else {
            return ResultData.makeFailResult(CodeMsgConstants.NOTINIT);
        }
    }

    @ApiOperation(value = "获取待制作菜品列表", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "waitProduct/{monitorID}", produces = "application/json;charset=UTF-8")
    public ResultData waitProduct(@ApiParam(value = "看板ID") @PathVariable(value = "monitorID") Long monitorID) throws ParseException {
        return ResultData.makeResult(displayService.getWaitMakeProduct(monitorID));
    }

    @ApiOperation(value = "获取看板显示字段信息", httpMethod = "GET", response = ResultData.class)
    @GetMapping(value = "showContent/{monitorID}", produces = "application/json;charset=UTF-8")
    public ResultData getShowContent(@ApiParam(value = "看板ID") @PathVariable(value = "monitorID") Long monitorID){
        return ResultData.makeResult(displayService.getShowContent(monitorID));
    }
}
