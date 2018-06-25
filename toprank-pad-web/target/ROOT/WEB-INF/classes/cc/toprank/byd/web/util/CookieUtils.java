package cc.toprank.byd.web.util;

import java.nio.charset.Charset;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class CookieUtils {

    /** Field description */
    private static final Logger LOGGER = LoggerFactory.getLogger(Logger.class);

    /** Field description */
    private static final String secret = "123456789";

    /** Field description */
    private static final String TERMINAL_COOKIE_NAME = "toprank_sessionId";

    /**
     * Method description
     *
     *
     * @param name
     * @param value
     * @param maxAge
     * @param request
     *
     * @return
     */
    public static Cookie createCookie(String name, String value, int maxAge, HttpServletRequest request) {
        return createCookie(name, value, maxAge, getPath(request));
    }

    /**
     * Method description
     *
     *
     * @param name
     * @param value
     * @param maxAge
     * @param path
     *
     * @return
     */
    public static Cookie createCookie(String name, String value, int maxAge, String path) {
        LOGGER.info("д��cookie��name:{}��value:{}", name, value);

        Cookie cookie = new Cookie(name, value);

        cookie.setPath(path);
        cookie.setMaxAge(maxAge);

        return cookie;
    }

    /**
     * Method description
     *
     *
     * @param name
     * @param value
     * @param maxAge
     * @param request
     *
     * @return
     */
    public static Cookie createEncodeCookie(String name, String value, int maxAge, HttpServletRequest request) {
        return createCookie(name, encodeHex(value), maxAge, request);
    }

    /**
     * Method description
     *
     *
     * @param uniqeCode
     * @param request
     *
     * @return
     */
    public static Cookie createTerminalCookie(String uniqeCode, HttpServletRequest request) {
        return createEncodeCookie(TERMINAL_COOKIE_NAME, uniqeCode, -1, request);
    }

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
    private static String decodeHex(String content) {
        String value = new String(Hex.decode(content.getBytes(Charset.defaultCharset())));

        return decodeString(value);
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
     * @param encodeValue
     *
     * @return
     */
    private static String encodeHex(String encodeValue) {
        String value = encodeString(encodeValue);

        return Hex.encodeToString(value.getBytes(Charset.defaultCharset()));
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
     * @param name
     * @param request
     *
     * @return
     */
    public static String readCookieDecodeValue(String name, HttpServletRequest request) {
        String cookieValue = readCookieValue(name, request);

        if (cookieValue != null) {
            return decodeHex(cookieValue);
        }

        return null;
    }

    /**
     * Method description
     *
     *
     * @param name
     * @param request
     *
     * @return
     */
    public static String readCookieValue(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if ((cookies != null) && StringUtil.isNotEmpty(name)) {
            String value = null;

            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    value = cookie.getValue();

                    break;
                }
            }

            LOGGER.info("ͨ��name:{}��ȡcookie��ֵvalue:{}", name, value);

            return value;
        }

        return null;
    }

    /**
     * Method description
     *
     *
     * @param request
     *
     * @return
     */
    public static String readTerminalCookie(HttpServletRequest request) {
        return readCookieDecodeValue(TERMINAL_COOKIE_NAME, request);
    }

    /**
     * Method description
     *
     *
     * @param response
     * @param cookie
     */
    public static void writeCookie(HttpServletResponse response, Cookie cookie) {
        response.addCookie(cookie);
    }

    /**
     * Method description
     *
     *
     * @param request
     *
     * @return
     */
    public static String getPath(HttpServletRequest request) {
        String path = System.getProperty("site.cookie.path");

        if (StringUtil.isBlank(path)) {
            path = StringUtils.clean(request.getContextPath());
        }

        if (path == null) {
            path = "/";
        }

        return path;
    }
}



