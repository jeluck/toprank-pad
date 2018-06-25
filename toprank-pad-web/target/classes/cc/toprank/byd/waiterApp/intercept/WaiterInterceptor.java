package cc.toprank.byd.waiterApp.intercept;

import cc.toprank.byd.common.utils.json.JSONUtils;
import cc.toprank.byd.pad.controller.SystemController;
import cc.toprank.byd.waiterApp.constant.WaiterConstants;
import cc.toprank.byd.waiterApp.constant.WaiterErrorConstants;
import cc.toprank.byd.waiterApp.utils.WaiterUtils;
import cc.toprank.byd.web.constant.ResultData;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LiSH
 * @version 2.0.0
 * @description login拦截器
 * @time 2017-6-16 11:26
 */
public class WaiterInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    SystemController systemController;
    /**
     * Field description
     */
    private static final Logger logger = LoggerFactory.getLogger(WaiterInterceptor.class);


    /**
     * @description
     * @author LiSH
     * @time 2017-2-20 17:05
     * @version 2.0.0
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getParameter(WaiterConstants.CommonAttribute.TOKEN);
        Object tokenMap = WaiterUtils.getToken(token);
        if (tokenMap == null) {
            ResultData resultData = ResultData.makeFailResult(WaiterErrorConstants.UserExistError.code,null);
            response.getWriter().print(JSONUtils.toJson(resultData));
            return false;
//            BizException.error(WaiterErrorConstants.UserExistError.code, WaiterErrorConstants.UserExistError.msg);
        }
        request.getSession().setAttribute(WaiterConstants.CommonAttribute.TOKEN, token);
        return super.preHandle(request, response, handler);
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}



