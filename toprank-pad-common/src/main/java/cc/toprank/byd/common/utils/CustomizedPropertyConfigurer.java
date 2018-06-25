
package cc.toprank.byd.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Map;
import java.util.Properties;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class CustomizedPropertyConfigurer extends PropertyPlaceholderConfigurer {

    /** Field description */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {

        // load properties to ctxPropertiesMap
        for (Map.Entry<Object, Object> entry : props.entrySet()) {

            // System config contains this key, ignore
            if (System.getProperties().containsKey(entry.getKey())) {
                continue;
            }

            String keyStr = entry.getKey().toString();
            String value  = entry.getValue().toString();

            System.setProperty(keyStr, value);
            logger.debug("{}={}", keyStr, value);
        }

        super.processProperties(beanFactoryToProcess, props);
    }
}



