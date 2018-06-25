package cc.toprank.byd.web.controller.menu;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.web.service.menu.*;
import cc.toprank.byd.util.CollectionHelper;
import cc.toprank.byd.web.vo.product.*;
import cc.toprank.byd.web.vo.tablevo.TableMessageVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description： 点菜页面 - 商品信息

 * @author LinYN
 * @date 2017-4-19
 */
@Controller
@RequestMapping(value = "/reception/product")
public class ProductMessageController extends BaseController{

    @Autowired
    private ProductMessageService productMessageService;

    //日志打印
    private static final Logger logger = LoggerFactory.getLogger(ProductMessageController.class.getName());

    /**
     * 获取商品配置信息，包括规格、称重、口味做法、厨师、厨房状态等
     *
     * @param menuID 菜单编号
     * @return 商品配置信息
     *
     * @author LinYN
     * @date 2017-4-19
     */
    @ApiOperation(value = "获取商品配置信息", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/getProductMessage", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getProductMessage(
            @ApiParam("菜单编号") @RequestParam(value = "menuID") Long menuID,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            ProductMessageVo productMessage = productMessageService.getProductMessage(menuID);
            resultData.setData(productMessage);
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


    /**
     * 批量更新商品称重信息
     *
     * @param productWeightsData 商品称重重量信息
     *
     * @author LinYN
     * @date 2017-5-3
     */
    @ApiOperation(value = "更新商品称重信息", httpMethod = "GET", response = ResultData.class, notes = "更新商品称重信息。返回0表示操作成功，message保存错误信息")
    @ApiResponses({
            @ApiResponse(code=-1,message="系统异常"),
            @ApiResponse(code=0,message="处理成功"),
            @ApiResponse(code=3,message="参数错误"),
            @ApiResponse(code=4,message="未找到相关数据")
    })
    @ResponseBody
    @RequestMapping(value = "/updateProductWeight", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JSONPObject updateProductWeight(@ApiParam("商品称重信息") @RequestParam(value = "productWeightsData") String productWeightsData,
                                           @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback){
        ResultData resultData = new ResultData();
        try {
            ProductWeightRequestVo requestVo = new ProductWeightRequestVo();
            List<ProductWeightVo> productWeights = JSONArray.parseArray(productWeightsData, ProductWeightVo.class);
            requestVo.setProductWeights(productWeights);
            requestVo.setArchiveID(getArchiveID());
            productMessageService.updateProductWeight(requestVo);
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

    /**
     * 复制菜：查询当前桌台可以复制的菜品
     *
     * @param subOrderID 子订单编号
     *
     * @author LinYN
     * @date 2017-6-15
     */
    @ApiOperation(value = "可以复制的菜品", httpMethod = "GET", response = ResultData.class, notes = "复制菜：查询当前桌台可以复制的菜品。返回0表示操作成功，message保存错误信息")
    @ApiResponses({
            @ApiResponse(code=-1,message="系统异常"),
            @ApiResponse(code=0,message="处理成功"),
            @ApiResponse(code=3,message="参数错误"),
            @ApiResponse(code=4,message="未找到相关数据")
    })
    @ResponseBody
    @RequestMapping(value = "/getCanCopyProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JSONPObject getCanCopyProducts(@ApiParam("子订单编号") @RequestParam(value = "subOrderID") Long subOrderID,
                                    @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback){
        ResultData resultData = new ResultData();
        try {
            ProductCopyRequestVo requestVo = new ProductCopyRequestVo();
            requestVo.setSubOrderID(subOrderID);
            requestVo.setArchiveID(getArchiveID());
            resultData.setData(productMessageService.getCanCopyProducts(requestVo));
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

    /**
     * 复制菜：将在当前桌台选择的菜品复制到另一个目标桌台中
     *
     * @param productsData 选择的需要复制的商品信息
     *
     * @author LinYN
     * @date 2017-5-13
     */
    @ApiOperation(value = "复制菜", httpMethod = "GET", response = ResultData.class, notes = "复制菜：将在当前桌台选择的菜品复制到另一个目标桌台中。返回0表示操作成功，message保存错误信息")
    @ApiResponses({
            @ApiResponse(code=-1,message="系统异常"),
            @ApiResponse(code=0,message="处理成功"),
            @ApiResponse(code=3,message="参数错误"),
            @ApiResponse(code=4,message="未找到相关数据")
    })
    @ResponseBody
    @RequestMapping(value = "/copyProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JSONPObject copyProducts(@ApiParam("复制的商品信息") @RequestParam(value = "productsData") String productsData,
                                           @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback){
        ResultData resultData = new ResultData();
        try {
            ProductCopyRequestVo requestVo = JSON.parseObject(productsData, ProductCopyRequestVo.class);
            requestVo.setArchiveID(getArchiveID());
            productMessageService.copyProducts(requestVo);
        } catch (JSONException je) {
            logger.error(je.getMessage(), je);
            resultData.setCode(CodeMsgConstants.PARAM_ERROR);
            resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
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

    /**
     * 根据桌台名称和机构编号获取正在使用中的桌台
     *
     * @param tableName 桌台名称
     * @return 正在使用中的桌台
     *
     * @author LinYN
     * @date 2017-4-21
     */
    @ApiOperation(value = "获取使用中的桌台信息", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/searchTables", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject searchTables(
            @ApiParam("桌台名称") @RequestParam(value = "tableName", required = false) String tableName,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            List<TableMessageVO> tables = productMessageService.getUsingTableInfos(tableName, getArchiveID());
            resultData.setData(CollectionHelper.group(tables, (table) -> table.getAreaName()));
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
}
