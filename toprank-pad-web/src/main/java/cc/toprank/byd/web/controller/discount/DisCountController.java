package cc.toprank.byd.web.controller.discount;/**
 * Created by ZhouWei on 2017-5-19.
 */

import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.O_OrderDiscountMappingDao;
import cc.toprank.byd.entity.O_OrderActivityMappingEntity;
import cc.toprank.byd.entity.O_OrderDiscountMappingEntity;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.service.discount.ActivityInfoService;
import cc.toprank.byd.web.service.discount.OrderActivityMappingService;
import cc.toprank.byd.web.vo.discount.ActivityInfoVO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @param
 * @author zhouwei
 * @version 2.0.0
 * @description 折扣处理功能
 * @time 2017-05-19-13:21
 * @return
 */
@Controller
@RequestMapping("/reception/discount")
public class DisCountController extends BaseController{
    @Autowired
    private ActivityInfoService activityInfoService;
    @Autowired
    private OrderActivityMappingService orderActivityMappingService;

    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 获取当前时间、金额可以使用的折扣信息
     * @time 2017-05-19-13:21
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDisCountTypeMessage")
    public JSONPObject getDisCountTypeMessage(@ApiParam(value = "消费金额", required = false) @RequestParam(value = "currentAmount", required = false) BigDecimal currentAmount){
        ResultData resultData = new ResultData();
        try{
            Map map = new HashMap<>();
            map.put("currentAmount",currentAmount);
            map.put("archiveID",this.getArchiveID());
            List<ActivityInfoVO> activityInfoEntityList =  activityInfoService.getActivityInfoList(map);
            resultData.setData(activityInfoEntityList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        }catch (BizException ex){
            resultData.setCode(ex.getCode());
            resultData.setMessage(ex.getMessage());
        }catch (Exception e){
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return  getResultJSONPObject(resultData);
    }
    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 插入订单折扣信息
     * @time 2017-05-19-13:21
     * @return
     */
    @ResponseBody
    @RequestMapping("/addOrderActivityMapping")
    public JSONPObject addOrderActivityMapping(@ApiParam(value = "订单编号", required = true) @RequestParam("orderID") Long orderID,
                                               @ApiParam(value = "活动编号", required = true) @RequestParam("activityID") Long activityID,
                                               @ApiParam(value = "关联描述", required = false) @RequestParam("mappingDesc") String mappingDesc,
                                               @ApiParam(value = "备注", required = false) @RequestParam("memo") String memo){
        ResultData resultData = new ResultData();
        try{
            if (orderID == null || activityID == null){
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
            }
            O_OrderActivityMappingEntity orderActivityMappingEntity = new O_OrderActivityMappingEntity();
            orderActivityMappingEntity.setOrderID(orderID);
            orderActivityMappingEntity.setActivityID(activityID);
            orderActivityMappingEntity.setCreateTime(LocalDateTime.now());
            orderActivityMappingEntity.setIsManualProcess(false);
            orderActivityMappingEntity.setCreatorID(this.getLoginID());
            orderActivityMappingEntity.setMappingDesc(mappingDesc);
            orderActivityMappingEntity.setMemo(memo);
            orderActivityMappingEntity.setSortNo(0);
            int ret =  orderActivityMappingService.addActivityInfoMapping(orderActivityMappingEntity);
            if (ret > 0){
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            }
        }catch (BizException ex){
            resultData.setCode(ex.getCode());
            resultData.setMessage(ex.getMessage());
        }catch (Exception e){
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return getResultJSONPObject(resultData);
    }

    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 根据子订单ID获取活动名称
     * @time 2017-05-19-13:21
     * @return
     */
    @ResponseBody
    @RequestMapping("/getDisCountTypeName")
    public JSONPObject getDisCountName(@ApiParam(value = "子订单ID", required = false) @RequestParam("subOrderID") Long subOrderID){
        ResultData resultData = new ResultData();
        try{
            if (subOrderID == null || subOrderID.equals("")){
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            Map map = new HashMap<>();
            map.put("subOrderID",subOrderID);
            List<String> orderDisCountNameList =  orderActivityMappingService.getOrderDisCountMappingBySubOrderID(subOrderID);
            resultData.setData(orderDisCountNameList);
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        }catch (BizException ex){
            resultData.setCode(ex.getCode());
            resultData.setMessage(ex.getMessage());
        }catch (Exception e){
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return  getResultJSONPObject(resultData);
    }

    /**
     * @param
     * @author zhouwei
     * @version 2.0.0
     * @description 根据子订单ID获取活动名称
     * @time 2017-05-19-13:21
     * @return
     */
    @ResponseBody
    @RequestMapping("/insertDisCountMapping")
    public JSONPObject insertDisCountMapping(@ApiParam(value = "子订单ID", required = false) @RequestParam("subOrderID") Long subOrderID){
        ResultData resultData = new ResultData();
        try{
            if (subOrderID == null || subOrderID.equals("")){
                resultData.setCode(CodeMsgConstants.PARAM_ERROR);
                resultData.setMessage(CodeMsgConstants.PARAM_ERROR_MSG);
                return getResultJSONPObject(resultData);
            }
            Map map = new HashMap<>();
            map.put("subOrderID",subOrderID);
            int ret =  orderActivityMappingService.addOrderDisCountMapping(null,subOrderID,this.getArchiveID(),this.getLoginID());
            resultData.setCode(CodeMsgConstants.SUCCESS);
            resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
        }catch (BizException ex){
            resultData.setCode(ex.getCode());
            resultData.setMessage(ex.getMessage());
        }catch (Exception e){
            resultData.setCode(CodeMsgConstants.FAIL);
            resultData.setMessage(CodeMsgConstants.FAIL_MSG);
        }
        return  getResultJSONPObject(resultData);
    }
}
