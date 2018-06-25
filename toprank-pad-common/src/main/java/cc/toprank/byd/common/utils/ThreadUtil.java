package cc.toprank.byd.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class ThreadUtil {

    /** Field description */
    @SuppressWarnings("rawtypes")
    private static final ThreadLocal ctx = new ThreadLocal();

    /**
     * Method description
     *
     *
     * @param key
     * @param value
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void put(Object key, Object value) {
        Map m = (Map) ctx.get();

        if (m == null) {
            m = new HashMap();
        }

        m.put(key, value);
        ctx.set(m);
    }

    /**
     * Method description
     *
     *
     * @param key
     *
     * @return
     */
    public static Object get(Object key) {
        @SuppressWarnings("rawtypes")
        Map m = (Map) ctx.get();

        if (m != null) {
            return m.get(key);
        }

        return null;
    }
}



