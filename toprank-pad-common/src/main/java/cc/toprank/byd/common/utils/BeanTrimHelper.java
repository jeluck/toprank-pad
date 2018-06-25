package cc.toprank.byd.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class BeanTrimHelper {

    /**
     * Constructs ...
     *
     */
    private BeanTrimHelper() {}

    /**
     * Method description
     *
     *
     * @param bean
     *
     * @throws Exception
     */
    public static void trimAttrValue(Object bean) throws Exception {
        if (null == bean) {
            throw new IllegalArgumentException("bean is not null.");
        }

        // ��ȡ���е��ֶΰ���public,private,protected
        Field[] fields = bean.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];

            if (f.getType().getName().equals("java.lang.String")) {
                String key   = f.getName();    // ��ȡ�ֶ���
                Object value = getFieldValue(bean, key);

                if (value == null) {
                    continue;
                }

                setFieldValue(bean, key, value.toString().trim());
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param bean
     * @param fieldName
     *
     * @return
     *
     * @throws Exception
     */
    private static Object getFieldValue(Object bean, String fieldName) throws Exception {
        StringBuilder result     = new StringBuilder();
        String        methodName = result.append("get")
                                         .append(fieldName.substring(0, 1).toUpperCase())
                                         .append(fieldName.substring(1))
                                         .toString();
        Object  rObject  = null;
        Method  method   = null;
        @SuppressWarnings("rawtypes")
        Class[] classArr = new Class[0];

        method  = bean.getClass().getMethod(methodName, classArr);
        rObject = method.invoke(bean, new Object[0]);

        return rObject;
    }

    /**
     * Method description
     *
     *
     * @param bean
     * @param fieldName
     * @param value
     *
     * @throws Exception
     */
    private static void setFieldValue(Object bean, String fieldName, Object value) throws Exception {
        StringBuilder result     = new StringBuilder();
        String        methodName = result.append("set")
                                         .append(fieldName.substring(0, 1).toUpperCase())
                                         .append(fieldName.substring(1))
                                         .toString();
        @SuppressWarnings("rawtypes")
        Class[] classArr = new Class[1];

        classArr[0] = "java.lang.String".getClass();

        Method method = bean.getClass().getMethod(methodName, classArr);

        method.invoke(bean, value);
    }
}



