package cc.toprank.byd.web.filter;

import cc.toprank.byd.web.constant.WebConstants;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @version Login Filter
 *
 * @author LinYN
 * @date 2017-6-7
 */
public class LoginFilter extends OncePerRequestFilter {

    private Set<String> excludeUrl = new HashSet<>();
    private Set<String> excludePath = new HashSet<>();

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
        excludeUrl.add("/");
        excludeUrl.add("/index.htm");
        excludeUrl.add("/index.html");
        excludeUrl.add("/reception/login");
        excludeUrl.add("/reception/login.action");
        excludeUrl.add("/favicon.ico");
        excludeUrl.add("/asset-manifest.json");
        // excludePath
        excludePath.add("/static/");
        excludePath.add("/statics/");
        excludePath.add("/pad/");
        excludePath.add("/kanban/");
        excludePath.add("/stall/");
        excludePath.add("/producePort/");
        excludePath.add("/swagger/");
        excludePath.add("/api-docs");

        excludePath.add("/waiter/");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        boolean hasLogin = request.getSession().getAttribute(WebConstants.SessionAttribute.USER_INFO) != null;
        if (hasLogin) {
            filterChain.doFilter(request, response);
            return;
        }
        String servletPath = request.getServletPath();
        boolean passPath = false;
        for (String path : excludePath) {
            if (servletPath != null && servletPath.startsWith(path)) {
                passPath = true;
                break;
            }
        }
        if (excludeUrl.contains(servletPath) || passPath) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(WebConstants.Location.LOGIN_URL);
        }
    }
}



