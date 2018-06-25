package cc.toprank.byd.web.controller.task;


import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.service.DailyTaskService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wordnik.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @Description：操作桌台：联台、拼台、转台、拆台等
 * @Author：LinYN
 * @Time: 2017-3-24 13:31
 * @Version 2.0.0
 */

@Controller
@RequestMapping("/reception/task")
public  class TaskController extends BaseController {

  @Autowired
  private  DailyTaskService dailyTaskService;
  //日志打印
  private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    /**
     * 手工执行日结
     *
     * @throws Exception 如果当前桌台不存在则抛异常，如果所有目标桌台都不存在则抛异常
     * @author LinYN
     * @date 2017-5-27
     */
    @ResponseBody
    @RequestMapping(value = "/day", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JSONPObject dayTask(@ApiParam(value = "callback", required = true) @RequestParam(value = "callback", defaultValue = "?") String callback){
        ResultData resultData = new ResultData();
        try {
            HttpServletRequest request = getRequest();
            String admin = request.getParameter("admin");
            if ("1".equals(admin)) {
                String remoteIP = request.getRemoteAddr();
                logger.info(remoteIP + " -> 调用日结任务...");
                dailyTaskService.executeDailyTask();
                logger.info(remoteIP + " -> 成功执行日结任务 END");
                resultData.setCode(CodeMsgConstants.SUCCESS);
                resultData.setMessage(CodeMsgConstants.SUCCESS_MSG);
            } else {
                resultData.setCode(CodeMsgConstants.FAIL);
                resultData.setMessage(CodeMsgConstants.FAIL_MSG);
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
