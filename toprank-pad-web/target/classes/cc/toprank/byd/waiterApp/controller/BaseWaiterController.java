package cc.toprank.byd.waiterApp.controller;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.constant.MessageConstants;
import cc.toprank.byd.waiterApp.constant.WaiterConstants;
import cc.toprank.byd.waiterApp.constant.WaiterErrorConstants;
import cc.toprank.byd.waiterApp.dto.WaiterLoginDTO;
import cc.toprank.byd.waiterApp.utils.WaiterUtils;
import cc.toprank.byd.web.constant.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSH
 * @version 2.0.0
 * @description 服务员APP BaseController
 * @time 2017-6-14 14:15
 */
public class BaseWaiterController {

    /**
     * Field description
     */
    public static final Logger log = LoggerFactory.getLogger(BaseWaiterController.class);


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
        log.error("系统异常。", e);
        return ResultData.makeFailResult(e, flag, getParaMap());
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
     * @author LiSH @date 2017年1月19日
     * @Description: setSession里的值
     */
    public void setSessionValue(String name, Object obj) {
        if (WaiterUtils.isOpenToken()) {
            String token = (String) getSession().getAttribute(WaiterConstants.CommonAttribute.TOKEN);
            if (token == null) {
                BizException.error(WaiterErrorConstants.UserLoginError.code,WaiterErrorConstants.UserLoginError.msg);
            }
            WaiterUtils.getToken(token).put(name,obj);
        }
        getSession().setAttribute(name, obj);
    }

    /**
     * @author LiSH @date 2017年1月19日
     * @Description: 获得session里的值
     */
    public Object getSessionValue(String name) {
        if (WaiterUtils.isOpenToken()) {
            String token = (String) getSession().getAttribute(WaiterConstants.CommonAttribute.TOKEN);
            if (token == null) {
                BizException.error(WaiterErrorConstants.UserLoginError.code,WaiterErrorConstants.UserLoginError.msg);
            }
            return WaiterUtils.getToken(token).get(name);
        }
        return getSession().getAttribute(name);
    }

    public Map<String, Object> getParaMap() {
        Enumeration names = getRequest().getParameterNames();
        HashMap<String, Object> map = new HashMap<>();
        while (names.hasMoreElements()) {
            String name = (String) names.nextElement();
            map.put(name, getRequest().getParameter(name));
        }
        initRequestParam(map);
        return map;
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得当前登陆信息
     * @time 2017-6-14 11:38
     */
    public WaiterLoginDTO getCurrentLoginInfo() {
        return (WaiterLoginDTO) getSessionValue(WaiterConstants.SessionAttribute.LOGIN_INFO);
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 初始化Map
     * @time 2017-5-31 14:51
     */
    private void initRequestParam(Map map) {
        map.put(MessageConstants.SOURCE, MessageConstants.WAITER_SOURCE);
        map.put("loginID", getCurrentLoginInfo().getLoginID());
        map.put("archiveID", getCurrentLoginInfo().getArchiveID());
        map.put("pageSize",10);

        initRequestParamChild(map);
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 给子类覆盖
     * @time 2017-6-14 17:01
     */
    public void initRequestParamChild(Map map) {

    }
}



