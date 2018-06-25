/**
 * @Title: AppService.java
 * @Package cc.toprank.byd.pad.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Lish
 * @date 2017年1月19日 下午2:15:39
 * @version V1.0
 */
package cc.toprank.byd.pad.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author LiSH
 *
 */
public class AppService {
    public Object getSessionValue(String name) {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attrs.getRequest();
        return request.getSession().getAttribute(name);
    }

    public Long getCurrentLoginID() {
        return (Long) getSessionValue("loginID");
    }

    public Long getCurrentArchiveID() {
        return (Long) getSessionValue("archiveID");
    }
}
