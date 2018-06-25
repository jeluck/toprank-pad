package cc.toprank.byd.stall.controller;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.NumberUtil;
import cc.toprank.byd.entity.B_ShopAreaInfoEntity;
import cc.toprank.byd.pad.controller.PadController;
import cc.toprank.byd.stall.service.ShopAreaInfoService;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 区域信息
 * Created by HuangCY on 2017-4-5.
 */
@RestController
@RequestMapping("/stall/area")
@Api(value = "/stall/area", description = "区域信息")
public class ShopAreaInfoController extends PadController {

    @Autowired
    private ShopAreaInfoService shopAreaInfoService;

    /**
     * 根据条件查询区域信息
     *
     * @param archiveID
     * @param areaID
     * @param request
     * @return
     * @author HuangCY
     */
    @ApiOperation(value = "查询区域信息", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/queryArea", produces = "application/json;charset=UTF-8")
    public ResultData queryAreaInfoByCondition(
            @ApiParam(value = "档案编号") @RequestParam(value = "archiveID") Long archiveID,
            @ApiParam(value = "区域编号") @RequestParam(required = false) Long areaID,
            HttpServletRequest request) {
        if(archiveID == null || archiveID <= 0){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        Map paramMap = new HashMap();
        paramMap.put("archiveID", archiveID);
        paramMap.put("areaID", areaID);

        //按条件查询桌台信息
        List<B_ShopAreaInfoEntity> resultList = shopAreaInfoService.queryAreaInfoByCondition(paramMap);

        return ResultData.makeSuccessResult(resultList);
    }
}
