package cc.toprank.byd.web.intercept;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cc.toprank.byd.common.page.xss.IgnoreXssFilter;
import cc.toprank.byd.common.page.xss.XssHttpServletRequestWrapper;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class XssfFilter extends HandlerInterceptorAdapter {

    /** Field description */
    private static final Logger LOGGER = LoggerFactory.getLogger(XssfFilter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // handler ����Ϊ:HandlerMethod
        if (handler instanceof HandlerMethod) {
            HandlerMethod   handlerMehtod = ((HandlerMethod) handler);
            Method          method        = handlerMehtod.getMethod();
            IgnoreXssFilter ixf           = method.getAnnotation(IgnoreXssFilter.class);

            if (ixf != null) {
                LOGGER.info("handlerBean:{},method:{},�����к���xss���˵�ע��,����Ҫxss����",
                            handlerMehtod.getBean(),
                            method.getName());

                if (request instanceof XssHttpServletRequestWrapper) {
                    ((XssHttpServletRequestWrapper) request).setIgnoreXssFilter(ixf);
                }
            }
        }

        return super.preHandle(request, response, handler);
    }
}



