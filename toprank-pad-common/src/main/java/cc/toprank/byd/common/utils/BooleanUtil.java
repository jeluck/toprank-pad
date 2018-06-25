package cc.toprank.byd.common.utils;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


/**
 * Bean 对象的工具类, null当作false处理
 *
 * @author LinYN
 * @since 2017-3-27
 */
public abstract class BooleanUtil {

    public static boolean valueOf(Boolean bool){
        return bool == null ? false : bool.booleanValue();
    }

    public static boolean valueOf(String value){
        return "true".equals(value);
    }

    public static boolean isTrue(Boolean bool){
        return valueOf(bool);
    }

    public static boolean isFalse(Boolean bool){
        return !isTrue(bool);
    }

    public static boolean equals(Boolean bool1, Boolean bool2){
        return valueOf(bool1) == valueOf(bool2);
    }

    public static boolean notEquals(Boolean bool1, Boolean bool2){
        return valueOf(bool1) != valueOf(bool2);
    }
}
