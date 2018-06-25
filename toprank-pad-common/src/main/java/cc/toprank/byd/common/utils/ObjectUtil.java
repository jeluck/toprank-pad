package cc.toprank.byd.common.utils;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;

/**
 * 对象工具类, 提供了几个常用的类型转换方法
 *
 * @author LinYN
 * @date 2017-4-11
 */
public class ObjectUtil {

    private ObjectUtil(){}

    /**
     * 对象类型转换成任意类型
     *
     * @param value 需要转换的数据对象
     * @param targetType 需要转换的目标类型
     * @return 转换后的数据对象
     *
     * @ConversionException 转换过程出错，需要转换的数据对象为null也会抛此异常
     */
    public static <T> T convertObject(Object value, Class<T> targetType){
        if (value == null) {
            throw new ConversionException("The input value is null when convert it.", new NullPointerException());
        }
        return (T)ConvertUtils.convert(value, targetType);
    }

    /**
     * 对象类型转换成任意类型
     *
     * @param value 需要转换的数据对象
     * @param targetType 需要转换的目标类型
     * @param defaultValue 转换过程出错则返回此默认值
     * @return 转换后的数据对象
     *
     */
    public static <T> T convertObject(Object value, Class<T> targetType, T defaultValue){
        try {
            return convertObject(value, targetType);
        } catch (ConversionException ce) {
            return defaultValue;
        }
    }

    /**
     * 对象类型转换成Integer类型对象
     *
     * @param value 需要转换的数据对象
     * @return 转换后的数据对象
     *
     * @ConversionException 转换过程出错
     */
    public static Integer objectToInteger(Object value){
        return convertObject(value, Integer.class);
    }

    /**
     * 对象类型转换成Integer类型对象
     *
     * @param value 需要转换的数据对象
     * @param defaultValue 转换过程出错则返回此默认值
     * @return 转换后的数据对象
     *
     */
    public static Integer objectToInteger(Object value, Integer defaultValue){
        return convertObject(value, Integer.class, defaultValue);
    }

    /**
     * 对象类型转换成Long类型对象
     *
     * @param value 需要转换的数据对象
     * @return 转换后的数据对象
     *
     * @ConversionException 转换过程出错
     */
    public static Long objectToLong(Object value){
        return convertObject(value, Long.class);
    }

    /**
     * 对象类型转换成Long类型对象
     *
     * @param value 需要转换的数据对象
     * @param defaultValue 转换过程出错则返回此默认值
     * @return 转换后的数据对象
     *
     */
    public static Long objectToLong(Object value, Long defaultValue){
        return convertObject(value, Long.class, defaultValue);
    }

    /**
     * 对象类型转换成Double类型对象
     *
     * @param value 需要转换的数据对象
     * @return 转换后的数据对象
     *
     * @ConversionException 转换过程出错
     */
    public static Double objectToDouble(Object value){
        return convertObject(value, Double.class);
    }

    /**
     * 对象类型转换成Double类型对象
     *
     * @param value 需要转换的数据对象
     * @param defaultValue 转换过程出错则返回此默认值
     * @return 转换后的数据对象
     *
     */
    public static Double objectToDouble(Object value, Double defaultValue){
        return convertObject(value, Double.class, defaultValue);
    }

    /**
     * 对象类型转换成String类型对象
     *
     * @param value 需要转换的数据对象
     * @return 转换后的数据对象
     *
     * @ConversionException 转换过程出错
     */
    public static String objectToString(Object value){
        return convertObject(value, String.class);
    }

    /**
     * 对象类型转换成String类型对象
     *
     * @param value 需要转换的数据对象
     * @param defaultValue 转换过程出错则返回此默认值
     * @return 转换后的数据对象
     *
     */
    public static String objectToString(Object value, String defaultValue){
        return convertObject(value, String.class, defaultValue);
    }

    /**
     * 判断两个对象是否相等
     *
     * @param value1 对象一
     * @param value2 对象二
     * @return 是否相等
     *
     * @author LinYN
     * @date 2017-5-2
     */
    public static boolean equals(Object value1, Object value2){
        return value1 != null ? value1.equals(value2) : value2 == null;
    }
}
