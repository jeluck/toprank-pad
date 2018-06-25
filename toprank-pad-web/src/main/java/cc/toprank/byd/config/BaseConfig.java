package cc.toprank.byd.config;

import cc.toprank.byd.common.exception.BizException;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.Properties;

@Component
public class BaseConfig {

    private static final Logger logger = LoggerFactory.getLogger(BaseConfig.class);
    private static Properties prop;
    private static final String IMAGESERVER = "image.server";


    @PostConstruct
    public void init() {

        prop = new Properties();
        InputStream configProps = null;
        try {
            configProps = BaseConfig.class.getClassLoader().getResourceAsStream("config.properties");
            prop.load(configProps);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(configProps);
        }
    }

    public static Object get(String key) {
        return prop.get(key);
    }

    public static String getString(String key) {
        return String.valueOf(get(key));
    }

    public static Long getLong(String key) {
        try {
            return Long.valueOf(getString(key));
        } catch (NumberFormatException ex) {
            logger.warn("商家档案id未配置。", ex);
            BizException.error("后台请设置 archiveID ");
            return null;
        }
    }

    public static String getImagePath() {
        return prop.getProperty(IMAGESERVER);
    }

}
