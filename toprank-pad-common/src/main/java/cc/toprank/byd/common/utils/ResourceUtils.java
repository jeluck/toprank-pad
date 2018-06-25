package cc.toprank.byd.common.utils;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class ResourceUtils {

    /** Field description */
    private ResourceBundle resourceBundle;

    /**
     * Constructs ...
     *
     *
     * @param resource
     */
    private ResourceUtils(String resource) {
        resourceBundle = ResourceBundle.getBundle(resource);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<String, String>();

        for (String key : resourceBundle.keySet()) {
            map.put(key, resourceBundle.getString(key));
        }

        return map;
    }

    /**
     * Method description
     *
     *
     * @param resource
     *
     * @return
     */
    public static ResourceUtils getResource(String resource) {
        return new ResourceUtils(resource);
    }

    /**
     * Method description
     *
     *
     * @param key
     * @param args
     *
     * @return
     */
    public String getValue(String key, Object... args) {
        String temp = resourceBundle.getString(key);

        return MessageFormat.format(temp, args);
    }
}



