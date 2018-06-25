package cc.toprank.byd.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;

import cc.toprank.byd.common.utils.GenerateUniqueId;
import cc.toprank.byd.common.utils.rsa.QEncodeUtil;
import cc.toprank.byd.common.utils.string.StringUtil;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class SimpleCookieUtils {

    /** Field description */
    private static final String TERMINAL_COOKIE_NAME = "JessionId";

    /** Field description */
    private static final String secret = "123456789";

    /**
     * Method description
     *
     *
     * @return
     */
    public static String createUniqeCode() {
        return GenerateUniqueId.getInstance().getUniqIDHashString();
    }

    /**
     * Method description
     *
     *
     * @param content
     *
     * @return
     */
    private static String decodeString(String content) {
        return QEncodeUtil.aesDecrypt(content, secret);
    }

    /**
     * Method description
     *
     *
     * @param content
     *
     * @return
     */
    private static String encodeString(String content) {
        return QEncodeUtil.aesEncrypt(content, secret);
    }

    /**
     * Method description
     *
     *
     * @param request
     * @param response
     *
     * @return
     */
    public static String readCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookie();

        return cookie.readValue(request, response);
    }

    /**
     * Method description
     *
     *
     * @param name
     * @param request
     * @param response
     *
     * @return
     */
    public static String readCookie(String name, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookie(name);

        return cookie.readValue(request, response);
    }

    /**
     * Method description
     *
     *
     * @param name
     * @param request
     * @param response
     *
     * @return
     */
    public static String readDecodeCookie(String name, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookie(name);
        String value  = cookie.readValue(request, response);

        if (value != null) {
            return decodeString(value);
        }

        return null;
    }

    /**
     * Method description
     *
     *
     * @param value
     * @param request
     * @param response
     */
    public static void writerCookie(String value, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookie();

        cookie.setValue(value);
        cookie.saveTo(request, response);
    }

    /**
     * Method description
     *
     *
     * @param name
     * @param value
     * @param maxAge
     * @param request
     * @param response
     */
    public static void writerCookie(String name, String value, int maxAge, HttpServletRequest request,
                                    HttpServletResponse response) {
        Cookie cookie = getCookie(name);

        cookie.setValue(value);
        cookie.setMaxAge(maxAge);
        cookie.saveTo(request, response);
    }

    /**
     * Method description
     *
     *
     * @param name
     * @param value
     * @param maxAge
     * @param request
     * @param response
     */
    public static void writerEncodeCookie(String name, String value, int maxAge, HttpServletRequest request,
                                          HttpServletResponse response) {
        Cookie cookie = getCookie(name);

        cookie.setValue(encodeString(value));
        cookie.setMaxAge(maxAge);
        cookie.saveTo(request, response);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static Cookie getCookie() {
        return getCookie(TERMINAL_COOKIE_NAME);
    }

    /**
     * Method description
     *
     *
     * @param name
     *
     * @return
     */
    public static Cookie getCookie(String name) {
        Cookie cookie = new SimpleCookie(name);
        String path   = System.getProperty("site.cookie.path");

        if (StringUtil.isNotBlank(path)) {
            cookie.setPath(path);
        }

        cookie.setHttpOnly(true);
        cookie.setMaxAge(SimpleCookie.DEFAULT_MAX_AGE);
        cookie.setVersion(SimpleCookie.DEFAULT_VERSION);

        return cookie;
    }
}



