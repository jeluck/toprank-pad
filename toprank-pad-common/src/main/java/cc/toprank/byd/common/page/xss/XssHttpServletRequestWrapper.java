package cc.toprank.byd.common.page.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    /** Field description */
    private static final List<Pattern> PATTERNS = new CopyOnWriteArrayList<Pattern>();

    static {
        PATTERNS.add(Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE));
        PATTERNS.add(Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
                                     Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        PATTERNS.add(Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
                                     Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        PATTERNS.add(Pattern.compile("</script>", Pattern.CASE_INSENSITIVE));
        PATTERNS.add(Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        PATTERNS.add(Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        PATTERNS.add(Pattern.compile("e?xpression\\((.*?)\\)",
                                     Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
        PATTERNS.add(Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE));
        PATTERNS.add(Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE));
        PATTERNS.add(Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL));
    }

    /** Field description */
    private IgnoreXssFilter ignoreXssFilter;

    /**
     * Constructs ...
     *
     *
     * @param servletRequest
     */
    public XssHttpServletRequestWrapper(HttpServletRequest servletRequest) {
        super(servletRequest);
    }

    /**
     * Method description
     *
     *
     * @param value
     *
     * @return
     */
    private String cleanXSS(String value) {
        if (value != null) {
            for (Pattern pattern : PATTERNS) {
                value = pattern.matcher(value).replaceAll("");
            }

            value = value.trim();
        }

        return value;
    }

    /**
     * Method description
     *
     *
     * @param name
     *
     * @return
     */
    public String getHeader(String name) {
        String value = super.getHeader(name);

        if (value == null) {
            return null;
        }

        if (isXssAttr(name)) {
            return value;
        }

        return cleanXSS(value);
    }

    /**
     * Method description
     *
     *
     * @param ignoreXssFilter
     */
    public void setIgnoreXssFilter(IgnoreXssFilter ignoreXssFilter) {
        this.ignoreXssFilter = ignoreXssFilter;
    }

    /**
     * Method description
     *
     *
     * @param parameter
     *
     * @return
     */
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);

        if (value == null) {
            return null;
        }

        if (isXssAttr(parameter)) {
            return value;
        }

        return cleanXSS(value);
    }

    /**
     * Method description
     *
     *
     * @param parameter
     *
     * @return
     */
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);

        if (values == null) {
            return null;
        }

        if (isXssAttr(parameter)) {
            return values;
        }

        int      count         = values.length;
        String[] encodedValues = new String[count];

        for (int i = 0; i < count; i++) {
            encodedValues[i] = cleanXSS(values[i]);
        }

        return encodedValues;
    }

    /**
     * Method description
     *
     *
     * @param name
     *
     * @return
     */
    public boolean isXssAttr(String name) {
        boolean flag = false;

        if ((ignoreXssFilter != null) && (ignoreXssFilter.attrs() != null)) {
            for (String attr : ignoreXssFilter.attrs()) {
                if (attr.equalsIgnoreCase(name)) {
                    flag = true;

                    break;
                }
            }
        }

        return flag;
    }
}



