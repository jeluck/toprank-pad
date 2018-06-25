package cc.toprank.byd.web.controller.table;


import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.entity.B_DinningTableInfoEntity;
import cc.toprank.byd.entity.B_MealsInfoEntity;
import cc.toprank.byd.entity.O_BookingInfoEntity;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.web.service.booking.O_BookingInfoService;
import cc.toprank.byd.web.vo.TableBookVO;
import cc.toprank.byd.web.service.table.TableInfoService;
import cc.toprank.byd.web.vo.tablevo.AreaMessageVO;
import cc.toprank.byd.web.vo.tablevo.TableMessageVO;
import cc.toprank.byd.web.vo.tablevo.TableStatusCategoryMessageVO;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @Description：桌态图展示
 * @Author：HuTao
 * @Time: 2017-3-13 9:31
 * @Version 2.0.0
 */

@Controller
@RequestMapping("/reception/table")
public class TableInfoController extends BaseController {
    @Autowired
    @Qualifier("tableInfoService")
    private TableInfoService tableInfoService;

    @Autowired
    private O_BookingInfoService bookingInfoService;
    //日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * @param areaID
     * @return
     * @Description：取当前餐次名称
     * @Author：HuTao
     * @Time: 2017-5-12 15:51
     * @Version 2.0.0
     */
    @ResponseBody
    @GetMapping(value = "/getMealName", produces = "application/json;charset=UTF-8")
    public JSONPObject getMealName(@ApiParam(required = true, name = "areaID", value = "当前区域ID") Long areaID) {
        ResultData resultData = new ResultData();
        try {
            Long archiveID = getArchiveID();
            Map<String, Object> dataMap = tableInfoService.getMealName(archiveID, areaID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(dataMap);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @return
     * @Description： 登入后显示首页 区域信息
     * @Author：HuTao
     * @Time: 2017-3-28 10:20
     * @Version 2.0.0
     */
    @ApiOperation(value = "根据档案id,取区域信息", httpMethod = "GET", response = ResultData.class, notes = "返回区域信息, 0表示操作成功，-1表示操作失败")
    @ResponseBody
    @GetMapping(value = "/home", produces = "application/json;charset=UTF-8")
    public JSONPObject home() {
        ResultData resultData = new ResultData();
        try {
            Long archiveID = getArchiveID();
            List<AreaMessageVO> areaList = tableInfoService.getAraeListByArchiveID(archiveID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(areaList);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param status
     * @return
     * @Description：首页根据桌台状态获取桌台列表
     * @Author：HuTao
     * @Time: 2017-3-28 10:14
     * @Version 2.0.0
     */

    @ApiOperation(value = "根据桌态取餐桌列表信息", httpMethod = "GET", response = ResultData.class, notes = "返回餐桌信息, 0表示操作成功,-1表示操作失败 ")
    @ResponseBody
    @GetMapping(value = "/getTableListByStatus", produces = "application/json;charset=UTF-8")
    public JSONPObject getTableListByStatus(@ApiParam(required = true, name = "status", value = "当前桌态Id") Long status,
                                            @ApiParam(required = true, name = "areaID", value = "当前区域Id") Long areaID) {
        //  桌台状态         预订(0) 在用(14) 待清(0) 空台(13) 维修(0) 暂结(0)
        //                   预订606  空闲607   未下单652    已下单827   脏台609    暂结728   维修610
        ResultData resultData = new ResultData();
        try {
            String tableName = "";
            Long archiveID = getArchiveID();
            List<TableMessageVO> reply = tableInfoService.getTableListByArchiveIDAndStatus(archiveID, areaID, status, tableName);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(reply);
        } catch (Exception e) {
            logger.error("根据桌态取餐桌列表信息发生了错误" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }


    /**
     * @param tableName
     * @return
     * @Description：首页面搜索桌台信息
     * @Author：HuTao
     * @Time: 2017-3-28 10:14
     * @Version 2.0.0
     */

    @ApiOperation(value = "根据入桌台名称，搜索桌台信息", httpMethod = "GET", response = ResultData.class, notes = "返回搜索到的餐桌信息, 0表示操作成功,-1表示操作失败 ")
    @ResponseBody
    @GetMapping(value = "/searchTable", produces = "application/json;charset=UTF-8")
    public JSONPObject searchTableInfoByTableName(@ApiParam(required = true, name = "tableName", value = "桌台名称") String tableName) {
        ResultData resultData = new ResultData();
        try {
            Long archiveID = getArchiveID();
            List<TableMessageVO> reply = tableInfoService.getTableInfoByTableName(archiveID, tableName);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(reply);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @return
     * @Description：取餐桌状态信息
     * @Author：HuTao
     * @Time: 2017-3-28 10:12
     * @Version 2.0.0
     */
    @ApiOperation(value = "返回各餐桌状态信息", httpMethod = "GET", response = ResultData.class, notes = "返回搜索到的餐桌信息, 0表示操作成功,-1表示操作失败 ")
    @ResponseBody
    @GetMapping(value = "/getTableStatus", produces = "application/json;charset=UTF-8")
    public JSONPObject getTableStatus(@ApiParam(required = true, name = "areaID", value = "当前区域Id") Long areaID) {
        ResultData resultData = new ResultData();
        try {
            Long archiveID = getArchiveID();
            List<TableStatusCategoryMessageVO> reply = tableInfoService.getTableStatusCategory(archiveID, areaID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(reply);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @return
     * @Description： 查询预订单的桌台
     * @Author：Zhaolingchen
     * @Time: 2017-6-14 14:20
     * @Version 2.0.0
     */
    @ApiOperation(value = "查询预订的桌台", httpMethod = "GET")
    @GetMapping(value = "/queryBookingTableList", produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject queryBookingTableList(@ApiParam(value = "预订单ID") @RequestParam(value = "bookingID", required = false) Long bookingID, @ApiParam(value = "桌台Id") @RequestParam(value = "tableID", required = false) Long tableID) {
        List<B_DinningTableInfoEntity> dinningTableInfoList = null;
        O_BookingInfoEntity bookingInfoEntity = null;
        if (bookingID != null && bookingID > 0) {
            bookingInfoEntity = bookingInfoService.getByID(bookingID);
            dinningTableInfoList = tableInfoService.queryBookingTableListByBookingID(bookingID);
        } else if (tableID != null && tableID > 0) {
            bookingInfoEntity = bookingInfoService.getBookingInfoByTableID(tableID, LocalDateTime.now());
            if(bookingInfoEntity != null ){
                dinningTableInfoList = tableInfoService.queryBookingTableListByBookingID(bookingInfoEntity.getBookingID());
            }
        } else {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        if(dinningTableInfoList == null || dinningTableInfoList.size() == 0){
            return getResultJSONPObject(ResultData.makeFailResult());
        }

        dinningTableInfoList = setTableStatus(dinningTableInfoList, bookingInfoEntity.getBookingID());
        Integer duration = bookingInfoEntity.getDuration();
        if (bookingInfoEntity.getExtraMinute() != null && bookingInfoEntity.getDuration() > 0) {
            duration += bookingInfoEntity.getExtraMinute();
        }
        JSONObject result = new JSONObject();
        result.put("bookingID", bookingInfoEntity.getBookingID());
        result.put("duration", duration);
        result.put("tableList", dinningTableInfoList);

        return getResultJSONPObject(ResultData.makeSuccessResult(result));
    }

    /**
     * @return
     * @Description： 设置桌台状态
     * @Author：Zhaolingchen
     * @Time: 2017-6-14 14:20
     * @Version 2.0.0
     */
    private List<B_DinningTableInfoEntity> setTableStatus(List<B_DinningTableInfoEntity> dinningTableInfoList, Long bookingID) {
        for (B_DinningTableInfoEntity dinningTableInfoEntity : dinningTableInfoList) {
            dinningTableInfoEntity.setBookingID(bookingID);
            if (dinningTableInfoEntity.getTableStatus() == MerchantManageEnum.TableStatus.EMPTYTABLE.getValue()) {
                dinningTableInfoEntity.setTableStatus(MerchantManageEnum.TableStatus.PREDETERMINE.getValue());
            }
        }
        return dinningTableInfoList;
    }
}
