package cc.toprank.byd.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class CommonUtils {

    /** Field description */
    public static final String SYSPROP_RUNMODE = "runMode";

    /** Field description */
    public static final String SYSPROP_RUNMODE_TEST = "test";

    /** Field description */
    public static final String SYSPROP_TESTMODE = "testMode";

    /** Field description */
    public static final String SYSPROP_TESTMODE_ON = "on";
    /**
     * Method description
     *
     *
     * @param uri
     *
     * @return
     */
    public static List<Entry<String, String>> loadList(String uri) {
        OrderedProperties           props = new OrderedProperties();
        List<Entry<String, String>> list  = new ArrayList<Entry<String, String>>();
        InputStream                 is    = Thread.currentThread().getContextClassLoader().getResourceAsStream(uri);

        try {
            props.loadList(is, list);
        } catch (Exception e) {
            throw new RuntimeException("load resource fail, uri:" + uri + " errorMsg:" + e.getMessage(), e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {}
            }
        }

        return list;
    }

    /**
     * Method description
     *
     *
     * @param uri
     *
     * @return
     */
    public static Map<String, String> loadProps(String uri) {
        OrderedProperties props  = new OrderedProperties();
        Map               result = new LinkedHashMap();
        InputStream       is     = Thread.currentThread().getContextClassLoader().getResourceAsStream(uri);

        try {
            props.loadMap(is, result);
        } catch (Exception e) {
            throw new RuntimeException("load resource fail, uri:" + uri + " errorMsg:" + e.getMessage(), e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {}
            }
        }

        return result;
    }

    /**
     * Method description
     *
     *
     * @param uri
     * @param map
     */
    @SuppressWarnings("unchecked")
    public static void loadProps(String uri, Map map) {
        CheckUtils.notNull(map, "map");
        map.putAll(loadProps(uri));
    }

    /**
     * Method description
     *
     *
     * @param className
     *
     * @return
     */
    public static Object newInstance(String className) {
        try {
            return Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new RuntimeException("new instance fail : " + e.getMessage(), e);
        }
    }

    /**
     * Method description
     *
     *
     * @param clazz
     * @param index
     * @param <T>
     *
     * @return
     */
    public static <T> T getEnum(Class<T> clazz, int index) {
        T[] c = clazz.getEnumConstants();

        return c[index];
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean isTestMode() {
        return SYSPROP_RUNMODE_TEST.equals(System.getProperty(SYSPROP_RUNMODE));
    }

    /**
     * Method description
     *
     *
     * @param funcName
     *
     * @return
     */
    public boolean isTestMode(String funcName) {
        if (isTestMode()) {
            return true;
        }

        return SYSPROP_TESTMODE_ON.equals(System.getProperty(SYSPROP_TESTMODE + "." + funcName));
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    public static <T> String getNameByValue(Class<T> clazz, Long value){
        String result ="";
        if(value==null){
            return result;
        }
        try {
            Method method = clazz.getMethod("values");
            T[] tList= (T[]) method.invoke(null, null);
            for(T t:tList){
                Method tValueMethod = t.getClass().getMethod("getValue");
                Long tValue= (Long) tValueMethod.invoke(t, null);
                if(value.toString().equals(tValue.toString())){
                    result=(String) t.getClass().getMethod("getName").invoke(t);
                    break;
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }finally {
            return result;
        }
    }

}



