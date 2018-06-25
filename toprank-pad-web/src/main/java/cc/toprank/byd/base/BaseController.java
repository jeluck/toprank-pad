package cc.toprank.byd.base;

import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.constant.MessageConstants;
import cc.toprank.byd.constant.PadConstants;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.constant.ResultData;
import cc.toprank.byd.web.constant.WebConstants;
import cc.toprank.byd.web.dto.UserInfoVo;
import cc.toprank.byd.web.util.AjaxUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
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

//import static cc.toprank.byd.pad.controller.AppController.getRequest;

/**
 * Class description
 *
 * @author David
 * @version 2.0.0, 2017-01-12
 */
public class BaseController {

    /**
     * Field description
     */
    public static final Logger log = LoggerFactory.getLogger(BaseController.class);


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
        log.error("{}请求出错", request.getRequestURL(), ex);
        if (AjaxUtils.isAjaxRequest(request)) {
            AjaxUtils.printTimeOutJson(response, CodeMsgConstants.ERROR_MSG);
            return new ModelAndView();
        }
        return new ModelAndView("/error/error.btl").addObject("ex", ex);
    }


    /**
     * 异常控制
     *
     * @param e RuntimeException
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public
    @ResponseBody
    JSONPObject runtimeExceptionHandler(RuntimeException e) {
        boolean flag = true;
        log.error("系统异常。", e);
        return getResultJSONPObject(ResultData.makeFailResult(e, flag, getParaMap()));
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
            log.error(e.getMessage(), e);
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

    /**
     * 获取ArchiveID
     *
     * @return
     */
    public Long getArchiveID() {
        UserInfoVo userInfo = getCurrentUser();
        return userInfo == null ? 0L : userInfo.getArchiveID();
    }

    /**
     * 获取LoginID
     *
     * @return
     */
    public Long getLoginID() {
        UserInfoVo userInfo = getCurrentUser();
        return userInfo == null ? 0L : userInfo.getLoginID();
    }

    public String getLoginName() {
        UserInfoVo userInfo = getCurrentUser();
        return userInfo == null ? "" : userInfo.getLoginName();
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得收银机ID
     * @time 2017-5-26 17:22
     */
    public Long getCasherID() {
        return 1L;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得收银机ID
     * @time 2017-5-26 17:22
     */
    public String getCasherName() {
        return "test收银机";
    }

    /**
     * @param obj
     * @return
     * @Description：JsonP的返回数据
     * @Author：HuTao
     * @Time: 2017-3-29 10:06
     * @Version 2.0.0
     */
    public JSONPObject getResultJSONPObject(Object obj) {
        String callback = this.getRequest().getParameter("callback");
        if (StringUtils.isEmpty(callback)) {
            callback = "?";
        }
        return new JSONPObject(callback, obj);
    }


    /**
     * 获取机构id
     *
     * @return
     */
    public Long getOrgID() {
        UserInfoVo userInfo = getCurrentUser();
        return userInfo == null ? 0L : userInfo.getOrgID();
    }

    protected UserInfoVo getCurrentUser() {
        return (UserInfoVo) getSessionValue(WebConstants.SessionAttribute.USER_INFO);
    }

    public String getString(String name) {
        return getString(name, "");
    }

    public String getString(String name, String defaultValue) {
        String s = getRequest().getParameter(name);
        return s == null ? defaultValue : s;
    }

    public Long getLong(String name) {
        return getLong(name, 0L);
    }

    public Long getLong(String name, Long defaultValue) {
        Long o = defaultValue;
        try {
            o = Long.valueOf(getString(name));
        } catch (Exception e) {
            // logger.info("baseController_getLong("+name+") is NULL",e);
        }
        return o;
    }

    public Integer getInt(String name) {
        return getInt(name, 0);
    }

    public Integer getInt(String name, int defaultValue) {
        Integer o = defaultValue;
        try {
            o = Integer.valueOf(getString(name));
        } catch (Exception e) {
            // logger.info("baseController_getInt("+name+") is NULL",e);
        }
        return o;
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
                log.error("getIPAddr error.", unknownhostexception);
            }
        }
        return ip;
    }


//    public Map<String, String> getParamMap() {
//        Enumeration names = getRequest().getParameterNames();
//        HashMap<String, String> map = new HashMap<>();
//        while (names.hasMoreElements()) {
//            String name = (String) names.nextElement();
//            map.put(name, getRequest().getParameter(name).toString());
//        }
//        return map;
//    }

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

    public Map<String, Object> getParaMapNotEmpty() {
        Enumeration names = getRequest().getParameterNames();
        HashMap<String, Object> map = new HashMap<>();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            String value = getRequest().getParameter(name);
            if (StringUtil.isNotBlank(value)) {
                map.put(name, getRequest().getParameter(name));
            }
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

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 初始化参数map基本信息
     * @time 2017-6-14 16:50
     */
    public void initSystemParam(Map map) {
        map.put(MessageConstants.SOURCE,MessageConstants.WEB_SOURCE);
//        map.put("archiveID", getArchiveID());
//        map.put("loginID", getLoginID());
//        map.put("loginName", getLoginName());
//        map.put("casherID", getCasherID());
//        map.put("casherCode", getCasherName());
//        map.put("source", "WEB");
    }
}



