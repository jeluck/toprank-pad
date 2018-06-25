package cc.toprank.byd.web.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.toprank.byd.common.exception.CommonErrorCode;
import cc.toprank.byd.common.utils.json.JSONUtils;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class AjaxUtils {

    /** Field description */
    private static final Logger LOGGER = LoggerFactory.getLogger(AjaxUtils.class);

    /**
     * Method description
     *
     *
     * @param response
     * @param message
     */
    public static void printTimeOutJson(ServletResponse response, String message) {
        printTimeOutJson(response, CommonErrorCode.SESSION_OUT_TIME, message);
    }

    /**
     * Method description
     *
     *
     * @param response
     * @param code
     * @param message
     */
    public static void printTimeOutJson(ServletResponse response, int code, String message) {
        HttpServletResponse resp = (HttpServletResponse) response;

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");

        Map<String, Object> map = new HashMap<>();
        PrintWriter         out = null;

        try {
            map.put("msg", message);
            map.put("code", code);
            out = response.getWriter();
            out.print(JSONUtils.toJson(map));
        } catch (IOException e) {
            LOGGER.error("��ӡ�������{}", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param request
     * @param response
     * @param url
     *
     * @throws IOException
     */
    public static void redirect(HttpServletRequest request, HttpServletResponse response, String url)
            throws IOException {
        StringBuilder targetUrl = new StringBuilder();

        if (url.startsWith("/")) {
            targetUrl.append(request.getContextPath());
        }

        targetUrl.append(url);
        response.sendRedirect(response.encodeRedirectURL(targetUrl.toString()));
    }

    /**
     * Method description
     *
     *
     * @param request
     *
     * @return
     */
    public static boolean isAjaxRequest(ServletRequest request) {
        HttpServletRequest req         = (HttpServletRequest) request;
        String             requestType = req.getHeader("X-Requested-With");

        // �ж��ϴ�
        String contentType = req.getContentType();
        String accept      = req.getHeader("Accept");

        if ((requestType != null) && "XMLHttpRequest".equals(requestType)) {
            return true;
        }

        // ���ڻ��������첽�ϴ�,����Ĭ���ϴ������첽���
        if ((contentType != null) && contentType.startsWith("multipart/form-data")) {
            return true;
        }

        if ((accept != null) && accept.startsWith("application/json")) {
            return true;
        }

        return false;
    }
}



