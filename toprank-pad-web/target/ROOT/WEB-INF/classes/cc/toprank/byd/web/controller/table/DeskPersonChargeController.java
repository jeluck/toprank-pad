package cc.toprank.byd.web.controller.table;

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.util.CollectionHelper;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.table.DeskPersonChargeService;
import cc.toprank.byd.web.vo.tablevo.*;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 桌台负责人调整控制类
 * Created by HuTao on 2017-5-16.
 */
@Controller
@RequestMapping("/reception/table")
public class DeskPersonChargeController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(DeskPersonChargeController.class.getName());

    @Autowired
    private DeskPersonChargeService deskPersonChargeService;

    /**
     * @Description：取岗位角色信息
     * @Author：HuTao
     * @Time: 2017-5-16 9:48
     * @Version 2.0.0
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/getRoleList", produces = "application/json;charset=UTF-8")
    public JSONPObject getRoleList(){
        ResultData resultData = new ResultData();
        try{
            List<DeskRoleVO> deskRoleList= deskPersonChargeService.getRoleList();
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(deskRoleList);
        } catch (Exception e) {
            logger.error("取岗位角色信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.MEMBER_SAVE_FAIL);
            resultData.setMessage(CodeMsgConstants.MEMBER_SAVE_FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：按当前日期，模糊查询桌台号，查询出桌台负责人
     * @Author：HuTao
     * @Time: 2017-5-16 11:24
     * @Version 2.0.0
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/quDeskPersonByDate", produces = "application/json;charset=UTF-8")
    public JSONPObject quDeskPersonByDate(HttpServletRequest request){
        //   @ApiParam(required = true, name = "tableCode", value = "桌台编号") String  tableCode
        //   @ApiParam(required = true, name = "areaID", value = "区域ID") Long areaID
        //   @ApiParam(required = true, name = "mealID", value = "餐次ID") Long mealID
        //   @ApiParam(required = true, name = "curDate", value = "查询日期") String curDate
        ResultData resultData = new ResultData();
        try{
            Long areaID =Long.valueOf(request.getParameter("areaID").toString());
            Long mealID=Long.valueOf(request.getParameter("mealID").toString());
            String curDate=request.getParameter("curDate").toString();
            String tableCode=request.getParameter("tableCode").toString();
            if ( null==mealID || null==curDate) {
                resultData.setCode(CodeMsgConstants.MEMBER_NOTPASSWORD);
                resultData.setMessage(CodeMsgConstants.MEMBER_NOTPASSWORD_MSG);
                return getResultJSONPObject(resultData);
            }
            Long archivelID=getArchiveID();
            List<DeskPersonInfoVO> deskRoleList= deskPersonChargeService.quDeskPersonByDate(archivelID,mealID,curDate,tableCode);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(deskRoleList);
        } catch (Exception e) {
            logger.error("取岗位角色信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.MEMBER_SAVE_FAIL);
            resultData.setMessage(CodeMsgConstants.MEMBER_SAVE_FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：按区域，餐次，日期取桌台的负责人列表信表
     * @Author：HuTao
     * @Time: 2017-5-16 10:03
     * @Version 2.0.0
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/getByAreaMealDate", produces = "application/json;charset=UTF-8")
    public JSONPObject getByAreaMealDate(HttpServletRequest request ){
        //   @ApiParam(required = true, name = "areaID", value = "区域ID") Long areaID
        //   @ApiParam(required = true, name = "mealID", value = "餐次ID") Long mealID
        //   @ApiParam(required = true, name = "curDate", value = "查询日期") String curDate
        ResultData resultData = new ResultData();
        try{
            Long areaID =Long.valueOf(request.getParameter("areaID").toString());
            Long mealID=Long.valueOf(request.getParameter("mealID").toString());
            String curDate=request.getParameter("curDate").toString();
            if (null ==areaID || null==mealID || null==curDate) {
                resultData.setCode(CodeMsgConstants.MEMBER_NOTPASSWORD);
                resultData.setMessage(CodeMsgConstants.MEMBER_NOTPASSWORD_MSG);
                return getResultJSONPObject(resultData);
            }
            Long archivelID=getArchiveID();
            List<DeskPersonInfoVO> deskRoleList= deskPersonChargeService.getByAreaMealDate(archivelID,areaID,mealID,curDate);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(deskRoleList);
        } catch (Exception e) {
            logger.error("取岗位角色信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.MEMBER_SAVE_FAIL);
            resultData.setMessage(CodeMsgConstants.MEMBER_SAVE_FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：根据桌台号，查出此桌台所有的调班记录
     * @Author：HuTao
     * @Time: 2017-5-17 10:59
     * @Version 2.0.0
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/getHisChangeInfo", produces = "application/json;charset=UTF-8")
    public JSONPObject getHisChangeInfo(HttpServletRequest request ) {
        //   @ApiParam(required = true, name = "tableCode", value = "查询日期") String tableCode
        ResultData resultData = new ResultData();
        try{
            String tableCode=request.getParameter("tableCode").toString();
            if (null==tableCode) {
                resultData.setCode(CodeMsgConstants.MEMBER_NOTPASSWORD);
                resultData.setMessage(CodeMsgConstants.MEMBER_NOTPASSWORD_MSG);
                return getResultJSONPObject(resultData);
            }
            Long archivelID=getArchiveID();
            List<DeskChangeVO> deskRoleList= deskPersonChargeService.getHisChangeInfo(tableCode);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(deskRoleList);
        } catch (Exception e) {
            logger.error("取岗位角色信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.MEMBER_SAVE_FAIL);
            resultData.setMessage(CodeMsgConstants.MEMBER_SAVE_FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：移除桌台负责人
     * @Author：HuTao
     * @Time: 2017-5-18 9:35
     * @Version 2.0.0
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/delDeskPerson", produces = "application/json;charset=UTF-8")
    public JSONPObject delDeskPerson(HttpServletRequest request ) {
        ResultData resultData = new ResultData();
        try{
            Long loginID=Long.valueOf(request.getParameter("loginID").toString());
            if (null==loginID) {
                resultData.setCode(CodeMsgConstants.MEMBER_NOTPASSWORD);
                resultData.setMessage(CodeMsgConstants.MEMBER_NOTPASSWORD_MSG);
                return getResultJSONPObject(resultData);
            }
            Long archivelID=getArchiveID();
            deskPersonChargeService.delDeskPerson(archivelID,loginID);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (Exception e) {
            logger.error("移除桌台负责人发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.MEMBER_SAVE_FAIL);
            resultData.setMessage(CodeMsgConstants.MEMBER_SAVE_FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：获取所有服务列表信息
     * @Author：HuTao
     * @Time: 2017-5-18 10:14
     * @Version 2.0.0
     * @param request
     * @return
     */

    @ResponseBody
    @GetMapping(value = "/getAllServerItem", produces = "application/json;charset=UTF-8")
    public JSONPObject getAllServerItem(HttpServletRequest request ){
        ResultData resultData = new ResultData();
        try{
            List<ServerItemVO> itemVOList= deskPersonChargeService.getAllServerItem();
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setData(itemVOList);
        } catch (Exception e) {
            logger.error("获取所有服务列表信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.MEMBER_SAVE_FAIL);
            resultData.setMessage(CodeMsgConstants.MEMBER_SAVE_FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @Description：保存桌台负责人信息
     * @Author：HuTao
     * @Time: 2017-5-18 10:32
     * @Version 2.0.0
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/saveDeskPerson", produces = "application/json;charset=UTF-8")
    public JSONPObject saveDeskPerson(HttpServletRequest request ){
        ResultData resultData = new ResultData();
        try{
            Long archivelID=getArchiveID();
            Long loginID=getLoginID();
            List<DeskPersonSaveVO> saveVOList = new ArrayList();
            deskPersonChargeService.saveDeskPerson(archivelID,loginID,saveVOList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (Exception e) {
            logger.error("保存桌台负责人信息发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.MEMBER_SAVE_FAIL);
            resultData.setMessage(CodeMsgConstants.MEMBER_SAVE_FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

}
