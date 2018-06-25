package cc.toprank.byd.common.utils;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class PropertyUtils {

    /** Field description */
    private static String GET = "get";

    /** Field description */
    private static String SET = "set";

    /** Field description */
    private static String IS = "is";

    /** Field description */
    private static Map descriptorsCache = new HashMap();

    /** Field description */
    private static Logger log = LoggerFactory.getLogger(PropertyUtils.class);

    /** Field description */
    private static Properties props;

    /**
     * Method description
     *
     *
     * @param prefix
     * @param propertyName
     *
     * @return
     */
    private static String createMethodName(String prefix, String propertyName) {
        return prefix + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
    }

    /**
     * Method description
     *
     *
     * @param obj
     * @param property
     *
     * @return
     */
    private static Object invokeProperty(Object obj, String property) {
        if ((property == null) || (property.length() == 0)) {
            return null;    // just in case something silly happens.
        }

        Class    cls     = obj.getClass();
        Object[] oParams = {};
        Class[]  cParams = {};

        try {

            // First try object.getProperty()
            Method method = cls.getMethod(createMethodName(GET, property), cParams);

            return method.invoke(obj, oParams);
        } catch (Exception e1) {
            try {

                // First try object.isProperty()
                Method method = cls.getMethod(createMethodName(IS, property), cParams);

                return method.invoke(obj, oParams);
            } catch (Exception e2) {
                try {

                    // Now try object.property()
                    Method method = cls.getMethod(property, cParams);

                    return method.invoke(obj, oParams);
                } catch (Exception e3) {
                    try {

                        // Now try object.property()
                        Field field = cls.getField(property);

                        return field.get(obj);
                    } catch (Exception e4) {

                        // oh well
                        return null;
                    }
                }
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param fileName
     */
    public static void loadProperties(String fileName) {
        try {
            props = new Properties();

            InputStream is = PropertyUtils.class.getResourceAsStream(fileName);

            props.load(is);
        } catch (IOException e) {
            log.error("load properties file error. ", e);
        }
    }

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {}

    /**
     * Method description
     *
     *
     * @param bean
     *
     * @return
     *
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public static Map<String, Object> toMap(Object bean)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Map<String, Object>  params            = new HashMap<String, Object>(0);
        PropertyUtilsBean    propertyUtilsBean = new PropertyUtilsBean();
        PropertyDescriptor[] descriptors       = propertyUtilsBean.getPropertyDescriptors(bean);

        for (int i = 0; i < descriptors.length; i++) {
            String name = descriptors[i].getName();

            if (!"class".equals(name)) {
                params.put(name, propertyUtilsBean.getNestedProperty(bean, name));
            }
        }

        return params;
    }

    /**
     * Method description
     *
     *
     * @param object
     * @param property
     *
     * @return
     */
    public static Object getProperty(Object object, String property) {
        return invokeProperty(object, property);
    }

    /**
     * Method description
     *
     *
     * @param object
     * @param property
     * @param value
     *
     * @return
     */
    public static boolean setProperty(Object object, String property, Object value) {
        if ((property == null) || (object == null)) {
            return false;
        }

        try {
            PropertyDescriptor pd = getPropertyDescriptor(object.getClass(), property);

            if (pd == null) {
                return false;
            }

            pd.getWriteMethod().invoke(object, new Object[] { value });

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method description
     *
     *
     * @param clz
     * @param name
     *
     * @return
     *
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     */
    public static PropertyDescriptor getPropertyDescriptor(Class clz, String name)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        if (name == null) {
            throw new IllegalArgumentException("No property name specified");
        }

        PropertyDescriptor descriptors[] = getPropertyDescriptors(clz);

        if (descriptors != null) {
            for (int i = 0; i < descriptors.length; i++) {
                if (name.equals(descriptors[i].getName())) {
                    return (descriptors[i]);
                }
            }
        }

        return null;
    }

    /**
     * Method description
     *
     *
     * @param beanClass
     *
     * @return
     */
    public static PropertyDescriptor[] getPropertyDescriptors(Class beanClass) {
        if (beanClass == null) {
            throw new IllegalArgumentException("No bean class specified");
        }

        // Look up any cached descriptors for this bean class
        PropertyDescriptor descriptors[] = null;

        descriptors = (PropertyDescriptor[]) descriptorsCache.get(beanClass);

        if (descriptors != null) {
            return (descriptors);
        }

        // Introspect the bean and cache the generated descriptors
        BeanInfo beanInfo = null;

        try {
            beanInfo = Introspector.getBeanInfo(beanClass);
        } catch (IntrospectionException e) {
            return (new PropertyDescriptor[0]);
        }

        descriptors = beanInfo.getPropertyDescriptors();

        if (descriptors == null) {
            descriptors = new PropertyDescriptor[0];
        }

        descriptorsCache.put(beanClass, descriptors);

        return (descriptors);
    }

    /**
     * Method description
     *
     *
     * @param clz
     * @param propertyName
     *
     * @return
     */
    public static Class[] getPropertyGenericActualTypes(Class clz, String propertyName) {
        PropertyDescriptor desc;

        try {
            desc = getPropertyDescriptor(clz, propertyName);
        } catch (Exception e) {
            return null;
        }

        Type type = desc.getReadMethod().getGenericReturnType();

        if (type == null) {
            return null;
        }

        if (type instanceof ParameterizedType) {
            ParameterizedType pt    = (ParameterizedType) type;
            Type[]            types = pt.getActualTypeArguments();

            if (types != null) {
                Class[] clzs = new Class[types.length];

                for (int i = 0; i < types.length; i++) {
                    clzs[i] = (Class) types[i];
                }

                return clzs;
            }
        }

        return null;
    }

    /**
     * Method description
     *
     *
     * @param clz
     *
     * @return
     */
    public static String[] getPropertyNames(Class clz) {
        try {
            PropertyDescriptor[] properties = getPropertyDescriptors(clz);
            String[]             result     = new String[properties.length];

            for (int i = 0; i < properties.length; i++) {
                result[i] = properties[i].getName();
            }

            return result;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Method description
     *
     *
     * @param clz
     * @param propertyName
     *
     * @return
     */
    public static Class getPropertyType(Class clz, String propertyName) {
        PropertyDescriptor desc;

        try {
            desc = getPropertyDescriptor(clz, propertyName);
        } catch (Exception e) {
            return null;
        }

        if (desc == null) {
            return null;
        } else {
            return desc.getPropertyType();
        }
    }

    /**
     * Method description
     *
     *
     * @param key
     *
     * @return
     */
    public static String getStringValue(String key) {
        return props.getProperty(key);
    }
}



