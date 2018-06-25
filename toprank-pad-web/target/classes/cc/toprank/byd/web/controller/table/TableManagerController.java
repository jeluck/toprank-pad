package cc.toprank.byd.web.controller.table;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.json.JSONUtils;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.entity.B_MealsInfoEntity;
import cc.toprank.byd.entity.B_ShopAreaInfoEntity;
import cc.toprank.byd.entity.B_TableManagerChangeInfoEntity;
import cc.toprank.byd.vo.ReasonVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.web.service.table.TableManagerService;
import cc.toprank.byd.web.vo.tablevo.*;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 收银机桌台负责人管理
 */

@Controller
@RequestMapping("/reception/tableManager")
public class TableManagerController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TableManagerService tableManagerService;

    @ApiOperation(value = "查询区域对应的餐次信息", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/getTableMealsInfo")
    public JSONPObject getTableMealsInfo(
            @ApiParam("区域编号") @RequestParam(value = "areaID", required = false) Long areaID) {
        ResultData resultData = new ResultData();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID, getArchiveID());
            map.put("areaID", areaID);
            List<B_MealsInfoEntity> mealsList = tableManagerService.getMealsInfoByAreaID(map);
            resultData = resultData.makeResult(mealsList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "移除桌台负责人", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/removeTableManagerInfo")
    public JSONPObject removeTableManagerInfo(@RequestParam(value = "tableManagerVO", required = true) String tableManagerVO) {
        ResultData resultData = new ResultData();
        TableManagerVO managerVO = JSONUtils.fromJson(tableManagerVO, TableManagerVO.class);
        try {
            if (managerVO != null) {
                managerVO.setArchiveID(getArchiveID());
            }
            tableManagerService.removeTableManagerInfo(managerVO, getLoginID());
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ResponseBody
    @GetMapping(value = "/addTableManagerInfo", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JSONPObject addTableManagerInfo(@RequestParam(value = "tableManagerVO", required = true) String tableManagerVO) {
        ResultData resultData = new ResultData();
        TableManagerVO managerVO = JSONUtils.fromJson(tableManagerVO, TableManagerVO.class);
        try {
            if (managerVO != null) {
                managerVO.setArchiveID(getArchiveID());
            }
            tableManagerService.addTableManager(managerVO, getLoginID());
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "查询区域分类信息", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/queryAreaInfo")
    public JSONPObject queryAreaInfo() {
        ResultData resultData = new ResultData();
        try {
            List<B_ShopAreaInfoEntity> areaInfoList = tableManagerService.queryAreaInfo(getArchiveID());
            resultData = resultData.makeResult(areaInfoList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "查询角色信息", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/queryRoleInfo")
    public JSONPObject queryRoleInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID, getArchiveID());
        ResultData resultData = new ResultData();
        try {
            List<OrgRoleVO> resultList = tableManagerService.queryRoleInfo(map);
            resultData = resultData.makeResult(resultList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "查询区域桌台信息(含桌台负责人列表)", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/queryAreaTableInfo")
    public JSONPObject queryAreaTableInfo(
            @ApiParam("区域编号") @RequestParam(value = "areaID", required = false) Long areaID,
            @ApiParam("餐次编号") @RequestParam(value = "mealsID", required = true) Long mealsID,
            @ApiParam("查询时间, 格式: yyyy-MM-dd") @RequestParam(value = "dutyDay", required = true) String dutyDay,
            @ApiParam("查询内容,桌台号") @RequestParam(value = "searchContent", required = false) String searchContent) {
        Map<String, Object> map = new HashMap<>();
        map.put(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID, getArchiveID());
        map.put("areaID", areaID);
        map.put("mealsID", mealsID);
        map.put("dutyDay", dutyDay);
        map.put("searchContent", searchContent);
        ResultData resultData = new ResultData();
        try {
            List<TableManagerVO> resultList = tableManagerService.queryAreaTableInfo(map);
            resultData = resultData.makeResult(resultList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "根据桌台管理状态查询桌台负责人信息", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/getTableManagerListByManagerStatus")
    public JSONPObject getTableManagerListByManagerStatus(
            @ApiParam("区域编号") @RequestParam(value = "areaID", required = false) Long areaID,
            @ApiParam("餐次编号") @RequestParam(value = "mealsID", required = true) Long mealsID,
            @ApiParam("查询时间, 格式: yyyy-MM-dd") @RequestParam(value = "dutyDay", required = true) String dutyDay,
            @ApiParam("管理状态") @RequestParam(value = "status", required = true) Long status) {
        Map<String, Object> map = new HashMap<>();
        map.put(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID, getArchiveID());
        map.put("areaID", areaID);
        map.put("mealsID", mealsID);
        map.put("dutyDay", dutyDay);
        map.put("status", status);
        ResultData resultData = new ResultData();
        try {
            TableManagerStatusVO resultList = tableManagerService.getTableManagerListByManagerStatus(map);
            resultData = resultData.makeResult(resultList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "查询所有的服务内容", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/queryAllServiceItem")
    public JSONPObject queryAllServiceItem() {
        ResultData resultData = new ResultData();
        try {
            List<ServiceAnswerTypeVO> serviceItems = tableManagerService.queryAllServiceItem();
            resultData = resultData.makeResult(serviceItems);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "查询商户所有的员工", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/queryAllUsers")
    public JSONPObject queryAllUsers(
            @ApiParam("角色编号") @RequestParam(value = "roleID", required = false) Long roleID,
            @ApiParam("员工名称或编号") @RequestParam(value = "searchContent", required = false) String searchContent) {
        Map<String, Object> map = new HashMap<>();
        map.put(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID, getArchiveID());
        map.put("roleID", roleID);
        map.put("searchContent", searchContent);
        ResultData resultData = new ResultData();
        try {
            List<OrgRoleUserInfoVO> resultList = tableManagerService.getU_LoginInfoByOrgRoleID(map);
            resultData = resultData.makeResult(resultList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "查询各种操作原因", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/queryConfigReason")
    public JSONPObject queryConfigReason(
            @ApiParam("操作类型 1-增加，2-修改，3-删除") @RequestParam(value = "operationType", required = true) Long operationType) {
        ResultData resultData = new ResultData();
        try {
            List<ReasonVO> resultList = tableManagerService.queryConfigReason(getArchiveID(), operationType);
            resultData = resultData.makeResult(resultList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
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
     *  调整桌台负责人的服务内容
     * @param tableManagerVO
     * @param adjustType 1-应用当前负责桌台 2-应用所有负责桌台。都是应用到当天的所有餐次
     * @return
     */
    @ApiOperation(value = "调整桌台负责人的服务内容", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/adjustServiceContent")
    public JSONPObject adjustServiceContent(@RequestParam(value = "tableManagerVO", required = true) String tableManagerVO, Long adjustType) {
        ResultData resultData = new ResultData();
        TableManagerVO managerVO = JSONUtils.fromJson(tableManagerVO, TableManagerVO.class);
        try {
            if (managerVO != null) {
                managerVO.setArchiveID(getArchiveID());
            }
            tableManagerService.adjustServiceContent(managerVO, getLoginID(), adjustType);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage(), e);
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    @ApiOperation(value = "查询调整历史记录", httpMethod = "GET", response = JSONPObject.class)
    @ResponseBody
    @GetMapping("/getTableChangeInfo")
    public JSONPObject getTableChangeInfo(
            @ApiParam("桌台编号") @RequestParam(value = "tableID", required = true) Long tableID,
            @ApiParam("值班时间，格式yyyy-MM-dd") @RequestParam(value = "dutyDay", required = true) String dutyDay) {
        Map<String, Object> map = new HashMap<>();
        map.put(ParamConstants.GlobalParam.PARAM_ARCHIVE_ID, getArchiveID());
        map.put("tableID", tableID);
        map.put("dutyDay", dutyDay);
        ResultData resultData = new ResultData();
        try {
            List<TableManagerChangeInfoVO> resultList = tableManagerService.getTableChangeInfo(map);
            resultData = resultData.makeResult(resultList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be) {
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e) {
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
    }

}
