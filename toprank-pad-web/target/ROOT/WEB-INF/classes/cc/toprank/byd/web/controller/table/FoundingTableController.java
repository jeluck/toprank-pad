package cc.toprank.byd.web.controller.table;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.entity.B_MealsInfoEntity;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.table.FoundingTableService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/reception/table")
public class FoundingTableController extends BaseController {

    @Autowired
    private FoundingTableService foundingTableService;

    //日志打印
    protected final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /**
     * @param tableIDs        桌台ID集合
     * @param customerNumbers 总人数集合
     * @return BusinessResponse对象
     * @Description： 开台
     * @Author：LanZY
     * @Time: 2017-3-21 14:10
     * @Version 2.0.0
     */
    @ApiOperation(value = "开台", httpMethod = "GET", response = JSONPObject.class, notes = "输入空闲桌ID进行开台可进行批量开台,输入桌台ID,人数。返回0表示操作成功，message保存错误信息")
    @RequestMapping(value = "/openTable", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject openTable(
            @ApiParam("桌台ID") @RequestParam(value = "tableIDs[]") List<Long> tableIDs,
            @ApiParam("人数") @RequestParam(value = "customerNumbers[]") List<Integer> customerNumbers,
            @ApiParam("开台人ID") @RequestParam(required = false, value = "loginID",defaultValue = "0") Long loginID,
            @ApiParam("餐次ID") @RequestParam(required = false, value = "mealsID",defaultValue = "0") Long mealsID,
            @ApiParam("callback") @RequestParam(value = "callback" ,defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {

            foundingTableService.addGeneralTable(tableIDs, customerNumbers, getArchiveID(), loginID==0?getLoginID():loginID,mealsID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback,resultData);
    }




    /***
     * @Description： 加台
     * @Author：LanZY
     * @Time: 2017-3-21 14:04
     * @Version 2.0.0
     * @param mainTableID       主桌台ID
     * @param customerNumbers   人数集合
     * @param viceTableIDs      副桌台ID集合
     * @return BusinessResponse对象
     */
    @ApiOperation(value = "加台", httpMethod = "GET", response = JSONPObject.class, notes = "输入主桌台ID(主桌台为开了台的桌台),副桌台ID,人数,总人数,进行加台操作。返回0表示操作成功，message保存错误信息")
    @RequestMapping(value = "/addTable", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject addTable(@ApiParam("主桌台ID") @RequestParam(value = "mainTableID") Long mainTableID,
                                @ApiParam("人数") @RequestParam(value = "customerNumbers[]") List<Integer> customerNumbers,
                                @ApiParam("副桌台ID") @RequestParam(value = "viceTableIDs[]") List<Long> viceTableIDs,
                                @ApiParam("开台人ID") @RequestParam(required = false, value = "loginID",defaultValue = "0") Long loginID,
                                @ApiParam("餐次ID") @RequestParam(required = false, value = "mealsID",defaultValue = "0") Long mealsID,
                                @ApiParam("callback") @RequestParam(value = "callback" ,defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            foundingTableService.addTable(mainTableID,viceTableIDs,customerNumbers,mealsID,loginID==0?getLoginID():loginID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
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


    /**
     * @param nameOrID 名称或者员工编号
     * @param job      岗位
     * @return 开台人列表
     * @Description： 根据名称或编号和岗位查询开台人列表
     * @Author：LanZY
     * @Time: 2017-3-23 15:56
     * @Version 2.0.0
     */
    @ApiOperation(value = "开台人列表", httpMethod = "GET", response = ResultData.class)
    @RequestMapping(value = "/getOriginalList", method = RequestMethod.GET)
    @ResponseBody
    public JSONPObject getOriginalList(@ApiParam("名称或者员工编号") @RequestParam(required = false, value = "nameOrID") String nameOrID,
                                       @ApiParam("岗位") @RequestParam(required = false, value = "job") String job,
                                       @ApiParam("callback") @RequestParam(value = "callback" ,defaultValue = "?") String callback) {
        Map<String, Object> map = new HashedMap();
        map.put("nameOrId", nameOrID);
        map.put("job", job);
        map.put("orgId", getOrgID());
        return new JSONPObject(callback, ResultData.makeResult(foundingTableService.getOriginalList(map)));
    }

    /**
     * @Description： 餐次列表
     * @Author：LanZY
     * @Time: 2017-5-20 18:57
     * @Version 2.0.0
     * @param archiveID
     * @param callback
     * @return
     */
    @ApiOperation(value = "餐次列表", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/getMealsInfoList", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject getMealsInfoList(
            @ApiParam("档案ID") @RequestParam(required = false, value = "archiveID",defaultValue = "0") Long archiveID,
            @ApiParam("区域ID") @RequestParam(value = "areaID") Long areaID,
            @ApiParam("callback") @RequestParam(value = "callback", defaultValue = "?") String callback) {
        B_MealsInfoEntity mealsInfo = new B_MealsInfoEntity();
        mealsInfo.setArchiveID(archiveID == 0 ? getArchiveID() : archiveID);
        mealsInfo.setMealStatus(MerchantManageEnum.MealStatus.PREDETERMINE.getValue());
        mealsInfo.setAreaID(areaID);
        return new JSONPObject(callback,ResultData.makeResult(foundingTableService.getMealsBetween(mealsInfo)));
    }


    /**
     * @Description： 预定开台
     * @Author：LanZY
     * @Time: 2017-5-20 18:57
     * @Version 2.0.0
     * @return
     */
    @ApiOperation(value = "预定开台", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/bookingOpenTable", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject bookingOpenTable(
            @ApiParam("预定ID") @RequestParam(value = "bookingID") Long bookingID,
            @ApiParam("桌台ID") @RequestParam(value = "tableIDs[]") List<Long> tableIDs,
            @ApiParam("人数") @RequestParam(value = "customerNumbers[]") List<Integer> customerNumbers,
            @ApiParam("开台人ID") @RequestParam(required = false, value = "loginID",defaultValue = "0") Long loginID,
            @ApiParam("callback") @RequestParam(value = "callback" ,defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            foundingTableService.bookingOpenTable(bookingID,tableIDs, customerNumbers, loginID==0?getLoginID():loginID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback,resultData);
    }


    /**
     * @Description： 查询占用桌台的菜品数量
     * @Author：LanZY
     * @Time: 2017-5-20 18:57
     * @Version 2.0.0
     * @return
     */
    @ApiOperation(value = "查询占用桌台的菜品数量", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/turnTableProductList", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject turnTableProductList(
            @ApiParam("预定ID") @RequestParam(value = "bookingID") Long bookingID,
            @ApiParam("桌台ID") @RequestParam(value = "tableIDs[]") List<Long> tableIDs,
            @ApiParam("callback") @RequestParam(value = "callback" ,defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            resultData.setData(foundingTableService.turnTableProductList(bookingID,tableIDs));
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback,resultData);
    }


    /**
     * @Description： 转台
     * @Author：LanZY
     * @Time: 2017-5-20 18:57
     * @Version 2.0.0
     * @return
     */
    @ApiOperation(value = "转台", httpMethod = "GET", response = JSONPObject.class)
    @RequestMapping(value = "/turnTable", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
    @ResponseBody
    public JSONPObject turnTable(
            @ApiParam("预定ID") @RequestParam(value = "bookingID") Long bookingID,
            @ApiParam("主桌台ID") @RequestParam(value = "mainTableIDs[]") List<Long> mainTableIDs,
            @ApiParam("副桌台ID") @RequestParam(value = "viceTableIDs[]") List<Long> viceTableIDs,
            @ApiParam("callback") @RequestParam(value = "callback" ,defaultValue = "?") String callback) {
        ResultData resultData = new ResultData();
        try {
            foundingTableService.turnTable(bookingID,mainTableIDs, viceTableIDs,getLoginID());
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return new JSONPObject(callback,resultData);
    }
}
