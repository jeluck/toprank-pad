package cc.toprank.byd.web.controller.haltsales;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.haltsales.HaltSalesService;
import cc.toprank.byd.web.vo.haltsales.HaltsSalesHistoryInfoVO;
import cc.toprank.byd.web.vo.haltsales.ProductHaltsSalesInfoVO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 停售
 * Created by ChenKY on 2017-6-2.
 */
@Controller
@RequestMapping("/reception/haltsales")
public class HaltSalesController extends BaseController {
    //日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private HaltSalesService haltSalesService;

    @ApiOperation(value = "停售菜品列表", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/getProductListFromHaltsSales", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getProductListFromHaltsSales(
            @ApiParam("分类ID") @RequestParam(required = false, value = "categoryID",defaultValue = "0") Long categoryID,
            @ApiParam("菜品名称或首字母或编码") @RequestParam(required = false, value = "searchCode",defaultValue = "") String searchCode,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("categoryID", categoryID);
        map.put("searchCode", searchCode);
        map.put("archiveID", getArchiveID());
        ResultData resultData = new ResultData();
        try {
            List<ProductHaltsSalesInfoVO> productHaltsSalesInfoVOList = haltSalesService.getProductListFromHaltsSales(map);
            resultData = resultData.makeResult(productHaltsSalesInfoVOList);
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

    @ApiOperation(value = "添加停售", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/addHaltsSales", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject addHaltsSales(
            @ApiParam("菜单ID") @RequestParam(value = "menuID") Long menuID
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("menuID", menuID);
        map.put("loginID", getLoginID());
        ResultData resultData = new ResultData();
        try {
            haltSalesService.addHaltsSales(map);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        }catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "取消停售", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/cancleHaltsSales", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject cancleHaltsSales(
            @ApiParam("菜单ID") @RequestParam(value = "menuID") Long menuID
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", getLoginID());
        map.put("menuID", menuID);
        ResultData resultData = new ResultData();
        try {
            haltSalesService.cancleHaltsSales(map);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        }catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "停售操作列表", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/getHaltsSalesList", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getHaltsSalesList(
            @ApiParam("菜品名称或首字母或编码") @RequestParam(required = false, value = "searchCode",defaultValue = "") String searchCode,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("archiveID", getArchiveID());
        map.put("searchCode", searchCode);
        ResultData resultData = new ResultData();
        try {
            List<HaltsSalesHistoryInfoVO> haltsSalesList = haltSalesService.getHaltsSalesList(map);
            resultData = resultData.makeResult(haltsSalesList);
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

    @ApiOperation(value = "批量取消停售", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/batchCancleHaltsSales", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject batchCancleHaltsSales(
            @ApiParam("菜单ID") @RequestParam(value = "menuIDs") String menuIDs
    ){
        Map<String, Object> map = new HashMap<>();
        map.put("loginID", getLoginID());
        map.put("menuIDs", menuIDs);
        ResultData resultData = new ResultData();
        try {
            haltSalesService.batchCancleHaltsSales(map);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        }catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }
}
