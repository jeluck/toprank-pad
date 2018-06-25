
package cc.toprank.byd.common.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class SpringMultiResolverView implements ViewResolver {

    /** Field description */
    private static final Logger logger = LoggerFactory.getLogger(SpringMultiResolverView.class);

    /** Field description */
    Map<String, ViewResolver> viewResolverMap = new HashMap<String, ViewResolver>();

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        ViewResolver view = null;

        if (logger.isDebugEnabled()) {
            logger.debug("SpringMultiResolverView resolver viewName:{}", viewName);
        }

        int n = viewName.lastIndexOf(".");

        if (n != -1) {
            String suffix = viewName.substring(viewName.lastIndexOf(".") + 1);

            if (logger.isDebugEnabled()) {
                logger.debug("SpringMultiResolverView resolver viewName:{} obtain suffix:{}", viewName, suffix);
            }

            ViewResolver resolver = viewResolverMap.get(suffix);

            if (resolver != null) {
                return resolver.resolveViewName(viewName, locale);
            }
        } else {
            for (String key : viewResolverMap.keySet()) {
                if (viewName.endsWith(key)) {
                    view = viewResolverMap.get(key);

                    break;
                }
            }
        }

        if (view != null) {
            return view.resolveViewName(viewName, locale);
        }

        return null;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Map<String, ViewResolver> getViewResolverMap() {
        return viewResolverMap;
    }

    /**
     * Method description
     *
     *
     * @param viewResolverMap
     */
    public void setViewResolverMap(Map<String, ViewResolver> viewResolverMap) {
        this.viewResolverMap = viewResolverMap;
    }
}



