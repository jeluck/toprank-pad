package cc.toprank.byd.stall.controller;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.constant.PadConstants;
import cc.toprank.byd.entity.B_StallWeighInfoEntity;
import cc.toprank.byd.entity.U_LoginInfoEntity;
import cc.toprank.byd.pad.controller.PadController;
import cc.toprank.byd.stall.service.ProductWeighingService;
import cc.toprank.byd.stall.service.StallWeighDealInfoService;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.dto.UserInfoVo;
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
 * 商品称重
 * Created by HuangCY on 2017-3-13.
 */
@RestController
@RequestMapping("/stall/weigh")
@Api(value = "/stall/weigh", description = "商品称重")
public class ProductWeighingController extends BaseController {
    @Autowired
    //称重商品信息
    private ProductWeighingService productWeighingService;

    @Autowired
    //改重处理信息
    private StallWeighDealInfoService stallWeighDealInfoService;

    /**
     * 根据条件查询称重商品列表
     * @param sortType
     * @param weighType
     * @param archiveID
     * @param stallID
     * @author HuangCY
     * @Time 2017-3-13
     * @return
     */
    @ApiOperation(value = "称重商品列表", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/queryProductWeighing", produces = "application/json;charset=UTF-8")
    public ResultData queryProductWeighingByCondition (
            @ApiParam(value = "排序类型") @RequestParam Integer sortType,
            @ApiParam(value = "称重类型") @RequestParam Long weighType,
            @ApiParam(value = "档案编号") @RequestParam Long archiveID,
            @ApiParam(value = "档口编号") @RequestParam Long stallID,
            @ApiParam(value = "桌台名称") @RequestParam(required = false) String tableName,
            HttpServletRequest request) {

        if(sortType == null ||weighType == null  || stallID == null || archiveID == null){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }

        Map paramsMap = new HashMap();

        paramsMap.put("sortType",sortType);
        paramsMap.put("weightStatus",weighType);
        paramsMap.put("archiveID",archiveID);
        paramsMap.put("stallID",stallID);
        paramsMap.put("tableName",tableName);

        //按条件查询
        List<B_StallWeighInfoEntity> resultList = productWeighingService.queryProductWeighingByCondition(paramsMap);
        return ResultData.makeResult(resultList);
    }

    /**
     * 改重录入
     * @param archiveID
     * @param weight
     * @param request
     * @author HuangCY
     * @Time 2017-3-16
     * @return
     */
    @ApiOperation(value = "改重录入", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/input", produces = "application/json;charset=UTF-8")
    public ResultData productWeighingInput (
            @ApiParam( value = "称重编号") @RequestParam(value = "weighID") Long weighID,
            @ApiParam(value = "档案编号") @RequestParam(value = "archiveID") Long archiveID,
            @ApiParam(value = "重量") @RequestParam(value = "weight") Float weight,
            @ApiParam(value = "档口编号") @RequestParam(value = "stallID") Long stallID,
            @ApiParam(value = "确认人类别") @RequestParam(required = false) Long confirmorType,
            HttpServletRequest request) {
        UserInfoVo loginInfo= this.getCurrentUser();
        if (loginInfo == null) {
            throw new BizException(CodeMsgConstants.USER_TOKEN_ERROR, CodeMsgConstants.USER_TOKEN_ERROR_MSG);
        }

        if(weighID == null  || weight == null  || archiveID == null ){
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }

        Map paramsMap = new HashMap();
        paramsMap.put("weighID",weighID);
        paramsMap.put("archiveID",archiveID);
        paramsMap.put("weight",weight);
        paramsMap.put("stallID",stallID);
        paramsMap.put("loginInfo",loginInfo);
        paramsMap.put("confirmorType",confirmorType);

        //改重录入
        productWeighingService.updateProductWeighingInput(paramsMap);
        return ResultData.makeSuccessResult(true);
    }

    /**
     * 根据条件查询改重记录
     * @param startTime
     * @param endTime
     * @param orderID
     * @param productName
     * @param tableCode
     * @author HuangCY
     * @Time 2017-3-16
     * @return
     */
    @ApiOperation(value = "查询改重记录", httpMethod = "POST", response = ResultData.class)
    @PostMapping(value = "/queryWeighingRecord", produces = "application/json;charset=UTF-8")
    public ResultData queryWeighingRecordByCondition (
            @ApiParam(value = "开始时间") @RequestParam(required = false) String startTime,
            @ApiParam(value = "结束时间") @RequestParam(required = false) String endTime,
            @ApiParam(value = "订单编号") @RequestParam(required = false) Long orderID,
            @ApiParam(value = "订单号") @RequestParam(required = false) Long orderCode,
            @ApiParam(value = "商品名称/编码/拼音码") @RequestParam(required = false) String productName,
            @ApiParam(value = "桌台编码") @RequestParam(required = false) String tableCode
            ) {

        Map paramsMap = new HashMap();
        paramsMap.put("startTime",startTime);
        paramsMap.put("endTime",endTime);
        paramsMap.put("orderID",orderID);
        paramsMap.put("orderCode",orderCode);
        paramsMap.put("productName",productName);
        paramsMap.put("tableCode",tableCode);
        paramsMap.put("archiveID",this.getArchiveID());

        //按条件查询改重记录
        List<B_StallWeighInfoEntity> resultList = productWeighingService.queryWeighingRecordByCondition(paramsMap);

        return ResultData.makeResult(resultList);
    }
}
