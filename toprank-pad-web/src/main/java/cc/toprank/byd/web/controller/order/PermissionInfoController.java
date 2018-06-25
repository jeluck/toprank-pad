package cc.toprank.byd.web.controller.order;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.base.BaseController;
import cc.toprank.byd.web.service.order.PermissionInfoService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 *  授权处理
 * Created by HuTao on 2017-4-25.
 */

@Controller
@RequestMapping("/reception/permission")
public class PermissionInfoController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(PermissionInfoController.class.getName());

    @Autowired
    private PermissionInfoService permissionInfoService;

    /**
     *@Description：
     * @Author：HuTao
     * @Time: 2017-4-25 17:26
     * @Version 2.0.0
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/checkPrivilege",  produces = "application/json;charset=UTF-8" )
   public JSONPObject checkPrivilege(HttpServletRequest request){
        ResultData resultData = new ResultData();
        try{
            String loginName = request.getParameter("loginName").toString();
            String password= request.getParameter("password").toString();
            String modelCode= request.getParameter("modelCode").toString();
            permissionInfoService.checkPrivilege(loginName,password,modelCode);
            resultData.setCode(CodeMsgConstants.SUCCESS);
        } catch (BizException be) {
            logger.error(be.getMessage(), be);
            resultData.setCode(be.getCode());
            resultData.setMessage(be.getMessage());
        } catch (Exception e ) {
            logger.error("根据登入名，检查二次授权发生了错误：" + e.getLocalizedMessage(), e);
            e.printStackTrace();
            resultData.setCode(CodeMsgConstants.ERROR);
            resultData.setMessage(CodeMsgConstants.ERROR_MSG);
        }
        return getResultJSONPObject(resultData);
   }
}
