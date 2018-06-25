package cc.toprank.byd.pad.controller;

import cc.toprank.byd.constant.MessageConstants;
import cc.toprank.byd.constant.PadConstants;
import cc.toprank.byd.pad.pojo.MerchantPadCacheVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.util.AjaxUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Class description
 *
 * @author Lish
 * @version 2.0.0, 2017-01-12
 */
public class PadController {

    public static final Logger LOGGER = LoggerFactory.getLogger(PadController.class);

    /**
     * 异常控制
     *
     * @param e RuntimeException
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public
    @ResponseBody
    ResultData runtimeExceptionHandler(RuntimeException e) {
        boolean flag = true;
        LOGGER.error("系统异常。", e);
        return ResultData.makeFailResult(e, flag, getParaMap());
    }

    /**
     * Method description
     *
     * @param request
     * @param response
     * @param ex
     * @return
     */
    //    @ExceptionHandler
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        LOGGER.error("{}请求出错", request.getRequestURL(), ex);
        if (AjaxUtils.isAjaxRequest(request)) {
            AjaxUtils.printTimeOutJson(response, CodeMsgConstants.ERROR_MSG);
            return new ModelAndView();
        }
        return new ModelAndView("/error/error.btl").addObject("ex", ex);
    }


    /**
     * @return
     * @Description：获取服务器IP地址
     * @Author：LiYC
     * @Time: 2017-2-20 16:59
     * @Version 2.0.0
     */
    public static String getServerIp() {
        Enumeration<NetworkInterface> enumeration;
        try {
            enumeration = NetworkInterface.getNetworkInterfaces();
            while (enumeration.hasMoreElements()) {
                NetworkInterface networkInterface = enumeration.nextElement();
                if (networkInterface.isUp()) {
                    Enumeration<InetAddress> addressEnumeration = networkInterface
                            .getInetAddresses();
                    while (addressEnumeration.hasMoreElements()) {
                        String ip = addressEnumeration.nextElement()
                                .getHostAddress();
                        final String REGX_IP = "((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
                        if (ip.matches(REGX_IP) && !ip.equals("127.0.0.1")) {
                            return ip;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return "127.0.0.1";
    }

    /**
     * @author LiSH @date 2017年1月19日
     * @Description: 获得当前session
     */
    protected HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * @author LiSH @date 2017年1月19日
     * @Description: 获得当前request
     */
    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }


    public String getString(String name) {
        return getString(name, "");
    }

    public String getString(String name, String defaultValue) {
        String s = getRequest().getParameter(name);
        return s == null ? defaultValue : s;
    }

    /**
     * @return
     * @Description： 项目路径拼接
     * @Author：LanZY
     * @Time: 2017-3-27 14:21
     * @Version 2.0.0
     */
    public String getContext() {
        HttpServletRequest request = getRequest();
        return request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort() + "" + request.getContextPath();

    }


    /**
     * @author LiSH @date 2017年1月19日
     * @Description: 获得session里的值
     */
    public Object getSessionValue(String name) {
        return getSession().getAttribute(name);
    }

    /**
     * @author LiSH  @date 2017年1月19日
     * @Description: 获得当前档案ID
     */
    public Long getCurrentArchiveID() {
        MerchantPadCacheVO merchatCache = getCurrentMerchant();
        if (merchatCache != null) {
            return merchatCache.getArchiveID();
        }
        return null;
    }

    public MerchantPadCacheVO getCurrentMerchant() {
        Object merchatCache = getSessionValue(PadConstants.MERCHANT_PAD_CACHE_KEY);
        if (merchatCache != null && merchatCache instanceof MerchantPadCacheVO) {
            return (MerchantPadCacheVO) getSessionValue(PadConstants.MERCHANT_PAD_CACHE_KEY);
        } else {
            return null;
        }
    }


    /**
     * @author LiSH @date 2017年1月19日
     * @Description: setSession里的值
     */
    public void setSessionValue(String name, Object obj) {
        getSession().setAttribute(name, obj);
    }

    /**
     * @param request
     * @return
     * @Description：获取请求来源的真实IP
     * @Author：LiYC
     * @Time: 2017-2-20 16:59
     * @Version 2.0.0
     */
    public String getIPAddr(HttpServletRequest request) {
        if (request == null) {
            return null;
        }

        String ip = request.getHeader("X-Forwarded-For");

        if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if ((ip == null) || (ip.length() == 0) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException unknownhostexception) {
                LOGGER.error("getIPAddr error.", unknownhostexception);
            }
        }
        return ip;
    }

    public Map<String, Object> getParaMap() {
        Enumeration names = getRequest().getParameterNames();
        HashMap<String, Object> map = new HashMap<>();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            map.put(name, getRequest().getParameter(name));
        }
        initSystemParam(map);
        return map;
    }


    public Map<String, Object> getPageMap() {
        Enumeration names = getRequest().getParameterNames();
        HashMap<String, Object> map = new HashMap<>();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            map.put(name, getRequest().getParameter(name));
        }
        map.put("pageSize", PadConstants.PAGE_SIZE);
        initSystemParam(map);
        return map;
    }

    private void initSystemParam(Map map) {
        map.put(MessageConstants.SOURCE, MessageConstants.PAD_SOURCE);
        map.put("archiveID", getCurrentMerchant() == null ? null : getCurrentMerchant().getArchiveID());
        map.put("areaID", getCurrentMerchant() == null ? null : getCurrentMerchant().getAreaID());
        map.put("tableID", getCurrentMerchant() == null ? null : getCurrentMerchant().getTableID());
    }

}
