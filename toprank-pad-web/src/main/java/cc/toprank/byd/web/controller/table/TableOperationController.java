package cc.toprank.byd.web.controller.table;


import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.constant.ParamType;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.web.dto.SubOrderInfoVo;
import cc.toprank.byd.web.vo.tablevo.TableRequestVo;
import cc.toprank.byd.web.service.table.TableOperationService;
import cc.toprank.byd.web.vo.tablevo.TableMessageVO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.*;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Description：操作桌台：联台、拼台、转台、拆台等
 * @Author：LinYN
 * @Time: 2017-3-24 13:31
 * @Version 2.0.0
 */

@Controller
@RequestMapping("/reception/table")
public  class TableOperationController extends BaseController {
  @Autowired
  @Qualifier("tableOperationService")
  private TableOperationService tableOperationService;
  //日志打印
  protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * 根据桌台编号和区域编号获取可以联合的桌台
     *
     * @param tableID     当前桌台ID
     * @throws Exception 如果当前桌台不存在则抛异常，如果所有目标桌台都不存在则抛异常
     * @author LinYN
     * @date 2017-3-17
     */
    @ApiOperation(value = "获取可以联合的桌台", httpMethod = "GET", response = ResultData.class, notes = "根据桌台编号获取可以联合的桌台，需要输入当前桌台ID。返回0表示操作成功，message保存错误信息")
    @ApiResponses({
            @ApiResponse(code=-1,message="系统异常"),
            @ApiResponse(code=0,message="处理成功"),
            @ApiResponse(code=3,message="参数错误"),
            @ApiResponse(code=4,message="未找到相关数据")
    })
    @ResponseBody
    @RequestMapping(value = "/getCanCombineTables", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JSONPObject getCanCombineTables(@ApiParam(value = "桌台编号", required = true) @RequestParam("tableID") Long tableID,
                                           @ApiParam(value = "callback", required = true) @RequestParam(value = "callback", defaultValue = "?") String callback){
        ResultData resultData = new ResultData();
        try {
            if (tableID == null)
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
            List<TableMessageVO> tables = tableOperationService.getCanCombineTables(tableID);
            if (CollectionUtils.isEmpty(tables)) {
                resultData.setCode(CodeMsgConstants.NODATA);
            } else {
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setData(tables);
            }
        } catch (BizException be){
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
     * 联台：当前桌台与目标桌台（排除其他关联属性的桌台）都必须在使用状态，即均有主订单、子订单、餐次信息
     *
     * @param requestVo#tableID     当前桌台ID
     * @param requestVo#targetTableIDs 目标桌台ID 列表，支持多选
     * @throws Exception 如果当前桌台不存在则抛异常，如果所有目标桌台都不存在则抛异常
     * @author LinYN
     * @date 2017-3-17
     */
    @ApiOperation(value = "联台", httpMethod = "GET", response = ResultData.class, notes = "用户联台操作，需要输入当前桌台ID和目标台ID（多选），桌台必须在使用状态。返回0表示操作成功，message保存错误信息")
    @ApiResponses({
            @ApiResponse(code=-1,message="系统异常"),
            @ApiResponse(code=0,message="处理成功"),
            @ApiResponse(code=3,message="参数错误"),
            @ApiResponse(code=4,message="未找到相关数据"),
            @ApiResponse(code=201,message="桌台不存在"),
            @ApiResponse(code=202,message="桌台不在使用中"),
            @ApiResponse(code=205,message="桌台是拼台"),
            @ApiResponse(code=207,message="桌台的订单不可用"),
            @ApiResponse(code=208,message="创建订单失败"),
            @ApiResponse(code=209,message="桌台的子订单不存在")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tableID", value = "当前桌台ID", dataType = "long", paramType = ParamType.QUERY, required = true),
            @ApiImplicitParam(name = "targetTableIDs", value = "目标桌台ID（多选）", dataType = "long", allowMultiple = true, paramType = ParamType.QUERY, required = true),
            @ApiImplicitParam(name = "callback", value = "callback", dataType = "string", paramType = ParamType.QUERY, required = true, defaultValue = "?")
    })
    @ResponseBody
    @RequestMapping(value = "/combineTables", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JSONPObject combineTables(@ApiIgnore @ModelAttribute("requestVo")TableRequestVo requestVo){
        ResultData resultData = new ResultData();
        try {
            Long srcTableID = requestVo.getTableID();
            List<Long> targetTableIDs = requestVo.getTargetTableIDs();
            if (srcTableID == null || CollectionUtils.isEmpty(targetTableIDs)) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
            } else {
                tableOperationService.combineTables(requestVo);
                resultData.setCode(CodeMsgConstants.SUCCESS);
            }
        } catch (BizException be){
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
     * 通过某个联台的ID 查询与之关联的桌台
     *
     * @param tableID     当前桌台ID
     * @throws Exception 如果当前桌台不存在则抛异常，如果所有目标桌台都不存在则抛异常
     * @author LinYN
     * @date 2017-3-17
     */
    @ApiOperation(value = "获取某个联台的关联桌台", httpMethod = "GET", response = ResultData.class, notes = "获取某个联台的关联桌台，需要输入当前桌台ID。返回0表示操作成功，message保存错误信息")
    @ApiResponses({
            @ApiResponse(code=-1,message="系统异常"),
            @ApiResponse(code=0,message="处理成功"),
            @ApiResponse(code=3,message="参数错误"),
            @ApiResponse(code=4,message="未找到相关数据")
    })
    @ResponseBody
    @RequestMapping(value = "/getCanSplitTables", method = RequestMethod.GET)
    public JSONPObject getCanSplitTables(@ApiParam(value = "桌台编号", required = true) @RequestParam(value = "tableID") Long tableID,
                                        @ApiParam(value = "callback", required = true) @RequestParam(value = "callback", defaultValue = "?") String callback){
        ResultData resultData = new ResultData();
        try {
            if (tableID == null) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
            } else {
                List<TableMessageVO> tables = tableOperationService.getCanSplitTables(tableID);
                if (CollectionUtils.isEmpty(tables)) {
                    resultData.setCode(CodeMsgConstants.NODATA);
                } else {
                    resultData.setCode(CodeMsgConstants.SUCCESS);
                    resultData.setData(tables);
                }
            }
        } catch (BizException be){
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
     * 拆台：当前桌台必须是联台，拆台后取消桌台之间的关联关系
     *
     * @param requestVo#targetTableIDs 目标桌台ID 列表，支持多选
     * @throws Exception 如果当前桌台不存在则抛异常，如果所有目标桌台都不存在则抛异常
     * @author LinYN
     * @date 2017-3-17
     */
    @ApiOperation(value = "拆台", httpMethod = "GET", response = ResultData.class, notes = "用户拆台操作，需要目标台ID（多选），桌台必须在使用状态。返回0表示操作成功，message保存错误信息")
    @ApiResponses({
            @ApiResponse(code=-1,message="系统异常"),
            @ApiResponse(code=0,message="处理成功"),
            @ApiResponse(code=3,message="参数错误"),
            @ApiResponse(code=4,message="未找到相关数据"),
            @ApiResponse(code=7,message="保存数据失败"),
            @ApiResponse(code=201,message="桌台不存在")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "targetTableIDs", value = "需要拆分的桌台ID（多选）", dataType = "long", allowMultiple = true, paramType = ParamType.QUERY, required = true),
            @ApiImplicitParam(name = "combine", value = "拆分后的桌台是否再联台", dataType = "boolean", paramType = ParamType.QUERY),
            @ApiImplicitParam(name = "callback", value = "callback", dataType = "string", paramType = ParamType.QUERY, required = true, defaultValue = "?")
    })
    @ResponseBody
    @RequestMapping(value = "/splitTables", method = RequestMethod.GET)
    public JSONPObject splitTables(@ApiIgnore @ModelAttribute("requestVo") TableRequestVo requestVo){
        ResultData resultData = new ResultData();
        try {
            List<Long> targetTableIDs = requestVo.getTargetTableIDs();
            if (CollectionUtils.isEmpty(targetTableIDs)) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
            } else {
                tableOperationService.splitTables(requestVo);
                resultData.setCode(CodeMsgConstants.SUCCESS);
            }
        } catch (BizException be){
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
     * 根据桌台编号和区域编号获取可以转台的桌台
     *
     * @param tableID     桌台编号
     * @throws Exception 如果当前桌台不存在则抛异常，如果所有目标桌台都不存在则抛异常
     * @author LinYN
     * @date 2017-3-17
     */
    @ApiOperation(value = "获取可以转的桌台", httpMethod = "GET", response = ResultData.class, notes = "根据桌台编号获取可以转的桌台，需要输入机构编号。返回0表示操作成功，message保存错误信息")
    @ApiResponses({
            @ApiResponse(code=-1,message="系统异常"),
            @ApiResponse(code=0,message="处理成功"),
            @ApiResponse(code=3,message="参数错误"),
            @ApiResponse(code=4,message="未找到相关数据"),
    })
    @ResponseBody
    @RequestMapping(value = "/getCanTransferTables", method = RequestMethod.GET)
    public JSONPObject getCanTransferTables(@ApiParam(value = "桌台编号", required = true) @RequestParam("tableID")Long tableID,
                                           @ApiParam(value = "callback", required = true) @RequestParam(value = "callback", defaultValue = "?") String callback){
        ResultData resultData = new ResultData();
        try {
            List<TableMessageVO> tables = null;
            if (tableID == null) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
            } else {
                tables = tableOperationService.getCanTransferTables(tableID);
            }
            if (CollectionUtils.isEmpty(tables)) {
                resultData.setCode(CodeMsgConstants.NODATA);
            } else {
                resultData.setData(tables);
                resultData.setCode(CodeMsgConstants.SUCCESS);
            }
        } catch (BizException be){
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
     * 根据桌台编号获取订单状态为进行中的子订单信息
     *
     * @param tableID 桌台编号
     * @return 订单状态为进行中的子订单信息
     *
     * @author LinYN
     * @date 2017-3-28
     */
    @ApiOperation(value = "获取桌台的子订单", httpMethod = "GET", response = ResultData.class, notes = "通过桌台编号获取正在使用中的子订单。返回0表示操作成功，message保存错误信息")
    @ApiResponses({
            @ApiResponse(code=-1,message="系统异常"),
            @ApiResponse(code=0,message="处理成功"),
            @ApiResponse(code=3,message="参数错误"),
            @ApiResponse(code=4,message="未找到相关数据")
    })
    @ResponseBody
    @RequestMapping(value = "/getSubOrders", method = RequestMethod.GET)
    public JSONPObject getSubOrders(@ApiParam(value = "桌台编号", required = true) @RequestParam("tableID")Long tableID,
                                   @ApiParam(value = "callback", required = true) @RequestParam(value = "callback", defaultValue = "?") String callback){
        ResultData resultData = new ResultData();
        try {
            List<SubOrderInfoVo> tables = null;
            if (tableID == null) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
            } else {
                tables = tableOperationService.getSubOrderByTableId(tableID);
            }
            if (CollectionUtils.isEmpty(tables)) {
                resultData.setCode(CodeMsgConstants.NODATA);
            } else {
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setData(tables);
            }
        } catch (BizException be){
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
     * 联台：当前桌台与目标桌台（排除其他关联属性的桌台）都必须在使用状态，即均有主订单、子订单、餐次信息
     *
     * @param requestVo#tableID     当前桌台ID
     * @param requestVo#targetTableIDs 目标桌台ID 列表，支持多选
     * @throws Exception 如果当前桌台不存在则抛异常，如果所有目标桌台都不存在则抛异常
     * @author LinYN
     * @date 2017-3-17
     */
    @ApiOperation(value = "转台", httpMethod = "GET", response = ResultData.class, notes = "用户转台操作，需要输入当前桌台ID、目标台ID（单选）和转台方式，桌台必须在使用状态。返回0表示操作成功，message保存错误信息")
    @ApiResponses({
            @ApiResponse(code=-1,message="系统异常"),
            @ApiResponse(code=0,message="处理成功"),
            @ApiResponse(code=1,message="处理失败"),
            @ApiResponse(code=3,message="参数错误"),
            @ApiResponse(code=4,message="未找到相关数据"),
            @ApiResponse(code=7,message="保存数据失败"),
            @ApiResponse(code=201,message="桌台不存在"),
            @ApiResponse(code=202,message="桌台不在使用中"),
            @ApiResponse(code=203,message="桌台是空台"),
            @ApiResponse(code=207,message="桌台的订单不可用"),
            @ApiResponse(code=208,message="创建订单失败"),
            @ApiResponse(code=209,message="桌台的子订单不存在"),
            @ApiResponse(code=215,message="未找到桌台的餐次数据")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tableID", value = "当前桌台ID", dataType = "long", paramType = ParamType.QUERY, required = true),
            @ApiImplicitParam(name = "targetTableID", value = "目标桌台ID", dataType = "long", paramType = ParamType.QUERY, required = true),
            @ApiImplicitParam(name = "transferType", value = "转台方式 1 : 空台, 2 : 拼台, 3 : 合台", dataType = "int", allowableValues = "1,2,3",paramType = ParamType.QUERY, required = true),
            @ApiImplicitParam(name = "subOrderID", value = "目标桌台的子订单编号（选择合台时使用）", dataType = "long", paramType = ParamType.QUERY),
            @ApiImplicitParam(name = "callback", value = "callback", dataType = "string", paramType = ParamType.QUERY, required = true, defaultValue = "?")
    })
    @ResponseBody
    @RequestMapping(value = "/transferTable", method = RequestMethod.GET)
    public JSONPObject transferTable(@ApiIgnore @ModelAttribute("requestVo") TableRequestVo requestVo){
        ResultData resultData = new ResultData();
        try {
            if (requestVo.getTableID() == null || requestVo.getTargetTableID() == null) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
            } else {
                tableOperationService.transferTable(requestVo);
                resultData.setCode(CodeMsgConstants.SUCCESS);
            }
        } catch (BizException be){
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
     * 拼台 选中一个桌台新增拼桌桌台，不限制人数
     * @param requestVo#tableID 新增拼桌桌台（ID）
     * @param requestVo#personCount 新增拼桌桌台（人数）
     * @param requestVo#memo 新增拼桌桌台（备注）
     *
     * @author LinYN
     * @date 2017-3-27
     **/
    @ApiOperation(value = "拼台", httpMethod = "GET", response = ResultData.class, notes = "用户拼台操作，需要输入当前桌台ID、人数、备注，桌台必须在使用状态并且不是联台。返回0表示操作成功，message保存错误信息")
    @ApiResponses({
            @ApiResponse(code=-1,message="系统异常"),
            @ApiResponse(code=0,message="处理成功"),
            @ApiResponse(code=3,message="参数错误"),
            @ApiResponse(code=4,message="未找到相关数据"),
            @ApiResponse(code=7,message="保存数据失败"),
            @ApiResponse(code=201,message="桌台不存在"),
            @ApiResponse(code=202,message="桌台不在使用中"),
            @ApiResponse(code=207,message="桌台的订单不可用"),
            @ApiResponse(code=208,message="创建订单失败"),
            @ApiResponse(code=209,message="桌台的子订单不存在"),
            @ApiResponse(code=210,message="桌台是联台"),
            @ApiResponse(code=212,message="桌台不允许拼台"),
            @ApiResponse(code=214,message="桌台存在异常的子订单数据"),
            @ApiResponse(code=215,message="未找到桌台的餐次数据")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tableID", value = "当前桌台ID", dataType = "long", paramType = ParamType.QUERY, required = true),
            @ApiImplicitParam(name = "customerNumber", value = "就餐人数", dataType = "int", paramType = ParamType.QUERY, required = true),
            @ApiImplicitParam(name = "loginID", value = "开台人ID", dataType = "long", paramType = ParamType.QUERY),
            @ApiImplicitParam(name = "memo", value = "备注", dataType = "string", paramType = ParamType.QUERY),
            @ApiImplicitParam(name = "callback", value = "callback", dataType = "string", paramType = ParamType.QUERY, required = true, defaultValue = "?")
    })
    @ResponseBody
    @RequestMapping(value = "/shareTable", method = RequestMethod.GET)
    public JSONPObject shareTable(@ApiIgnore @ModelAttribute("requestVo") TableRequestVo requestVo){
        ResultData resultData = new ResultData();
        try {
            Long srcTableID = requestVo.getTableID();
            if (srcTableID == null) {
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
            } else {
                if (requestVo.getLoginID() == null) {
                    requestVo.setLoginID(getLoginID());
                }
                tableOperationService.shareTable(requestVo);
                resultData.setCode(CodeMsgConstants.SUCCESS);
            }
        } catch (BizException be){
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
