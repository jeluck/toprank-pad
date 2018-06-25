package cc.toprank.byd.common.view;

import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringView;

import java.util.Locale;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class RichBeetlSpringView extends BeetlSpringView {
    @Override
    public boolean checkResource(Locale locale) throws Exception {
        BeetlGroupUtilConfiguration config = getApplicationContext().getBean(BeetlGroupUtilConfiguration.class);

        return config.getGroupTemplate().getResourceLoader().exist(getUrl());
    }

    /**
     * Method description
     *
     *
     * @return
     */
    protected boolean isUrlRequired() {
        return false;
    }
}



