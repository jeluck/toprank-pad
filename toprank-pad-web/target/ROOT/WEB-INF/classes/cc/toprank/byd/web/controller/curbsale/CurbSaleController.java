package cc.toprank.byd.web.controller.curbsale;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.constant.ParamConstants.CurbSaleParam;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.curbsale.CurbSaleService;
import cc.toprank.byd.web.vo.curbsale.CurbSaleInfoVO;
import cc.toprank.byd.web.vo.curbsale.ProductCrubSaleInfoVO;
import cc.toprank.byd.web.vo.curbsale.CurbSaleOperationHistoryVO;
import cc.toprank.byd.web.vo.curbsale.*;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 沽清
 */
@Controller
@RequestMapping("/reception/curbsale")
public class CurbSaleController extends BaseController {

    @Autowired
    private CurbSaleService curbSaleService;
    //日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @ApiOperation(value = "沽清菜品列表", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/getProductList", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getProductListFromCurbSale(
            @ApiParam("分类ID") @RequestParam(required = false, value = "categoryID", defaultValue = "0") Long categoryID,
            @ApiParam("菜品名称或首字母或编码") @RequestParam(required = false, value = "searchCode", defaultValue = "") String searchCode,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("categoryID", categoryID);
        map.put("searchCode", searchCode);
        map.put("archiveID", getArchiveID());
        //map.put("pageNum", pageNum);
        ResultData resultData = new ResultData();
        try {
            List<ProductCrubSaleInfoVO> productInfoList = curbSaleService.getProductListByConditionFromCurbSale(map);
            resultData = resultData.makeResult(productInfoList);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback, resultData);
    }

    @ApiOperation(value = "查询沽清菜品信息和预定信息", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/getProductInfoAndBookingInfo", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getProductInfoAndBookingInfo(
            @ApiParam("菜单ID") @RequestParam(value = "menuID") Long menuID,
//            @ApiParam("菜品类型") @RequestParam(value = "productType") Integer productType,
//            @ApiParam("是否需要称重") @RequestParam(required = false, value = "needWeigh", defaultValue = "false") boolean needWeigh,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("menuID", menuID);
        map.put("archiveID", getArchiveID());
//        map.put("productType", productType);
//        map.put("needWeigh", needWeigh);
        ResultData resultData = new ResultData();
        try {
            CrubSaleInfoAndBookingInfoObjVO crubSaleInfoAndBookingInfoObjVO = curbSaleService.getCurbSaleInfoAndBookingInfo(map);
            resultData = resultData.makeResult(crubSaleInfoAndBookingInfoObjVO);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback, resultData);
    }

    @ApiOperation(value = "沽清历史操作列表", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/getCurbSaleHistoryList")
    public JSONPObject getCurbSaleHistoryList(
            @ApiParam("沽清日期") @RequestParam(value = "storeDay") String storeDay,
            @ApiParam("操作类型") @RequestParam(value = "changeType", required = false) Long changeType,
            @ApiParam("商品分类") @RequestParam(value = "categoryID", required = false) Long categoryID,
            @ApiParam("搜索内容(商品/拼音/原因)") @RequestParam(value = "searchContent", required = false) String searchContent) {
        Map<String, Object> map = new HashMap<>();
        map.put(CurbSaleParam.STOREDAY, storeDay);
        map.put(CurbSaleParam.CHANGETYPE, changeType);
        map.put(CurbSaleParam.CATEGORYID, categoryID);
        map.put("searchContent", searchContent);
        map.put(CurbSaleParam.PARAM_ARCHIVE_ID, getArchiveID());
        ResultData resultData = new ResultData();
        try {
            List<CurbSaleOperationHistoryVO> historyVoList = curbSaleService.getCurbSaleOperationListByCondition(map);
            resultData = resultData.makeResult(historyVoList);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData = ResultData.makeFailResult(CodeMsgConstants.ERROR, CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "新增或修改菜品沽清", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/addOrUpdateCrubSale", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject addOrUpdateCrubSale(
            @ApiParam("菜单ID") @RequestParam(value = "menuID") Long menuID,
            @ApiParam("沽清列表") @RequestParam(value = "curbSaleList") String curbSaleList,
            @ApiParam("是否按规格沽清") @RequestParam(value = "isAccOptionCureSale") Boolean isAccOptionCureSale
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", getLoginID());
        map.put("archiveID", getArchiveID());
        map.put("menuID", menuID);
        map.put("isAccOptionCureSale", isAccOptionCureSale);
        ResultData resultData = new ResultData();
        //CrubSaleInfoAndBookingInfoObjVO crubSaleInfoAndBookingInfoObjVO = JSONObject.parseObject(curbSaleList, CrubSaleInfoAndBookingInfoObjVO.class);
        //List<CrubSaleInfoAndBookingInfoVO> crubSaleInfoAndBookingInfoVOList = JSONArray.parseArray(curbSaleList, CrubSaleInfoAndBookingInfoVO.class);
        List<OptionIDAndQuantityVO> optionIDAndQuantityVOList = JSONArray.parseArray(curbSaleList, OptionIDAndQuantityVO.class);
        try {
            curbSaleService.addCrubSale(optionIDAndQuantityVOList, map);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "沽清相关操作(增加、减少、报损、沽清、删除)", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/curbSaleOperation")
    public JSONPObject curbSaleOperation(
            @ApiParam(value = "关联编号", required = true) @RequestParam(value = "mappingID") Long mappingID,
            @ApiParam(value = "商品编码", required = true) @RequestParam(value = "menuID") Long menuID,
            @ApiParam("数量") @RequestParam(value = "quantity", required = false) String quantity,
            @ApiParam("是否需要称重") @RequestParam(required = false, value = "needWeigh", defaultValue = "false") boolean needWeigh,
            @ApiParam(value = "变动类别", required = true) @RequestParam(value = "changeType") Long changeType,
            @ApiParam(value = "变动原因", required = true) @RequestParam(value = "changeReason") String changeReason,
            @ApiParam("授权人ID") @RequestParam(value = "authorizerID", required = false) Long authorizerID
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("mappingID", mappingID);
        map.put("menuID", menuID);
        map.put("quantity", quantity);
        map.put(CurbSaleParam.NEEDWEIGH, needWeigh);
        map.put(CurbSaleParam.CHANGETYPE, changeType);
        map.put("changeReason", changeReason);
        map.put("authorizerID", authorizerID);
        map.put(CurbSaleParam.PARAM_ARCHIVE_ID, getArchiveID());

        ResultData resultData = new ResultData();
        try {
            resultData = curbSaleService.curbSaleOperation(map);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "查询沽清列表", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/getCurbSaleList")
    public JSONPObject getCurbSaleList(
            @ApiParam(value = "按日沽清日期(格式: yyyy-MM-dd)", required = true) @RequestParam(value = "storeDay")
                    String storeDay,
            @ApiParam("商品分类") @RequestParam(value = "categoryID", required = false) Long categoryID,
            @ApiParam("搜索条件") @RequestParam(value = "searchContent", required = false) String searchContent
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put(CurbSaleParam.STOREDAY, storeDay);
        map.put(CurbSaleParam.CATEGORYID, categoryID);
        map.put("searchContent", searchContent);
        map.put(CurbSaleParam.PARAM_ARCHIVE_ID, getArchiveID());

        ResultData resultData = new ResultData();
        try {
            List<CurbSaleInfoVO> infoVOList = curbSaleService.getCurbSaleList(map);
            resultData = resultData.makeResult(infoVOList);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "导入指定日期沽清列表", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/importCurbSaleList")
    public JSONPObject importCurbSaleList(
            @ApiParam(value = "沽清日期(格式: yyyy-MM-dd)", required = true) @RequestParam(value = "storeDay") String storeDay,
            @ApiParam(value = "导入类型", required = true) @RequestParam(value = "importType") Long importType
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put(CurbSaleParam.STOREDAY, storeDay);
        map.put("importType", importType);
        map.put(CurbSaleParam.PARAM_ARCHIVE_ID, getArchiveID());
        map.put(CurbSaleParam.LOGINID, getLoginID());

        ResultData resultData = new ResultData();
        try {
            resultData = curbSaleService.importCurbSaleList(map);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "启动前删除沽清操作", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/curbSaleOperationBeforeStartUp", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject curbSaleOperationBeforeStartUp(
            @ApiParam("关联编号") @RequestParam(value = "mappingID") Long mappingID
//            @ApiParam("变动类别") @RequestParam(value = "changeType") Long changeType,
//            @ApiParam("沽清数量") @RequestParam(required = false, value = "quantity", defaultValue = "0") String quantity,
//            @ApiParam("预定数量") @RequestParam(required = false, value = "bookingSum", defaultValue = "0") int bookingSum,
//            @ApiParam("是否需要称重") @RequestParam(required = false, value = "needWeigh",defaultValue = "false") boolean needWeigh
    ) {
        Map<String, Object> map = new HashMap<>();
//        map.put("loginID", getLoginID());
        map.put("mappingID", mappingID);
//        map.put("changeType", changeType);
//        map.put("quantity", quantity);
//        map.put("bookingSum", bookingSum);
//        map.put("needWeigh", needWeigh);
        ResultData resultData = new ResultData();
        try {
            resultData = curbSaleService.curbSaleOperationBeforeStartUp(map);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "商品添加/移除购物车操作", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/operationForShoppingCart", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject operationForShoppingCart(
            @ApiParam(value = "商品编号", required = true) @RequestParam(value = "productID") Long productID,
            @ApiParam(value = "变体编号", required = true) @RequestParam(value = "variantID") Long variantID,
            @ApiParam(value = "规格编号", required = false) @RequestParam(value = "optionID", required = false) Long optionID,
            @ApiParam(value = "是否称重", required = false) @RequestParam(value = "needWeigh", required = false, defaultValue = "false") Long needWeigh,
            @ApiParam(value = "数量", required = true) @RequestParam(value = "quantity") String quantity,
            @ApiParam(value = "操作类型", required = true) @RequestParam(value = "operationType") Long operationType) {
        Map<String, Object> map = new HashMap<>();
        map.put("productID", productID);
        map.put("variantID", variantID);
        map.put("optionID", optionID);
        map.put("needWeigh", needWeigh);
        map.put("quantity", quantity);
        map.put("operationType", operationType);
        map.put(CurbSaleParam.PARAM_ARCHIVE_ID, getArchiveID());

        ResultData resultData = new ResultData();
        try {
            resultData = curbSaleService.shoppingCartOperation(map);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "是否到了营业时间", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/isReachBusinessHours", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject isReachBusinessHours() {
        ResultData resultData = new ResultData();
        try {
            boolean merchantOpenTime = curbSaleService.getMerchantOpenTime(getArchiveID());
            Map<String, Boolean> map = new HashMap<>();
            map.put("isReachBusinessHours", merchantOpenTime);
            resultData = resultData.makeResult(map);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }

        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "查询操作类型列表", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/queryOperationTypeList")
    public JSONPObject queryOperationTypeList() {
        ResultData resultData = new ResultData();
        try {
            List<Map<String, Object>> operationTypeList = curbSaleService.queryOperationTypeList();
            resultData = resultData.makeResult(operationTypeList);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "查询操作原因列表", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/queryChangeReasonList")
    public JSONPObject queryChangeReason(@ApiParam(value = "操作类型", required = true) @RequestParam(value = "operationType") Long operationType) {
        ResultData resultData = new ResultData();
        Map<String, Object> map = new HashMap<>();
        map.put("operationType", operationType);
        map.put(CurbSaleParam.PARAM_ARCHIVE_ID, getArchiveID());
        try {
            List<Map<String, Object>> operationTypeList = curbSaleService.queryChangeReason(map);
            resultData = resultData.makeResult(operationTypeList);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description： 获取通用分类列表
     * @Author：chenkangyi
     * @Time: 2017-6-2 13:52
     * @Version 1.0.0
     */
    @ApiOperation(value = "通用菜品分类列表", httpMethod = "GET", response = JSONPObject.class, notes = "通用菜品分类列表")
    @RequestMapping(value = "/getCategoryListForCommon", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getCategoryListForCommon(
            @ApiParam("档案ID") @RequestParam(required = false, value = "archiveID", defaultValue = "0") Long archiveID,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        return new JSONPObject(callback, ResultData.makeResult(curbSaleService.getCategoryListForCommon(archiveID == 0 ? getArchiveID() : archiveID)));
    }

}
