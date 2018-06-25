package cc.toprank.byd.common.utils;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class SpringMVCDateConverter implements WebBindingInitializer {

    /**
     * Method description
     *
     *
     * @param binder
     * @param request
     */
    public void initBinder(WebDataBinder binder, WebRequest request) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
    }
}



