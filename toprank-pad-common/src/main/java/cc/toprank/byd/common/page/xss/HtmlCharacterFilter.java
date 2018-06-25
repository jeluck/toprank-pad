package cc.toprank.byd.common.page.xss;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class HtmlCharacterFilter implements Filter {
    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest            request   = (HttpServletRequest) req;
        HttpServletResponse           response  = (HttpServletResponse) resp;
        HtmlHttpServletRequestWrapper myrequest = new HtmlHttpServletRequestWrapper(request);

        chain.doFilter(myrequest, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    /**
     * Class description
     *
     *
     * @version        2.0.0, 2017-01-12
     * @author         David  
     */
    static class HtmlHttpServletRequestWrapper extends HttpServletRequestWrapper {

        /** Field description */
        private HttpServletRequest request;

        /**
         * Constructs ...
         *
         *
         * @param request
         */
        public HtmlHttpServletRequestWrapper(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        /**
         * Method description
         *
         *
         * @param message
         *
         * @return
         */
        public String filter(String message) {
            if (message == null) {
                return null;
            }

            char content[] = new char[message.length()];

            message.getChars(0, message.length(), content, 0);

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < content.length; i++) {
                switch (content[i]) {
                case '<' :
                    result.append("&lt;");

                    break;

                case '>' :
                    result.append("&gt;");

                    break;

                case '&' :
                    result.append("&amp;");

                    break;

                case '"' :
                    result.append("&quot;");

                    break;

                default :
                    result.append(content[i]);
                }
            }

            return result.toString();
        }

        @Override
        public String getParameter(String name) {
            String value = this.request.getParameter(name);

            if (value == null) {
                return null;
            }

            return filter(value);
        }

        @Override
        public String[] getParameterValues(String name) {
            String[] values = super.getParameterValues(name);

            if (values != null) {
                String[] _values = new String[values.length];

                for (int i = 0; i < values.length; i++) {
                    _values[i] = filter(values[i]);
                }

                return _values;
            }

            return null;
        }
    }
}



