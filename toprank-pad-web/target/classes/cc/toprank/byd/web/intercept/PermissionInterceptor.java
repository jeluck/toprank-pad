package cc.toprank.byd.web.intercept;

import cc.toprank.byd.constant.PadConstants;
import cc.toprank.byd.pad.controller.SystemController;
import cc.toprank.byd.pad.pojo.MerchantPadCacheVO;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import cc.toprank.byd.web.constant.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class description
 *
 * @author Lish
 * @version 2.0.0, 2017-01-12
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    SystemController systemController;
    /**
     * Field description
     */
    private static final Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);


    /**
     * @description
     * @author LiSH
     * @time 2017-2-20 17:05
     * @version 2.0.0
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        MerchantPadCacheVO merchantPadCacheVO = (MerchantPadCacheVO) request.getSession().getAttribute(PadConstants.MERCHANT_PAD_CACHE_KEY);
        if (null == merchantPadCacheVO) {
            //test
//            if("localhost".equals(request.getServerName())){
//                systemController.testInit("12");
//                MerchantCacheUtils.getSession().put(PadConstants.MERCHANT_PAD_CACHE_KEY, merchantPadCacheVO);
//                return super.preHandle(request, response, handler);
//            }

            ResultData resultData = ResultData.makeFailResult();
            resultData.setMessage("尚未初始化,请先调用 system/init");
            response.getWriter().print(resultData);
            return false;
        }
        MerchantCacheUtils.getSession().put(PadConstants.MERCHANT_PAD_CACHE_KEY, merchantPadCacheVO);
        return super.preHandle(request, response, handler);
    }
}



