package cc.toprank.byd.common.utils.number;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.math.BigDecimal;

/**
 * 对包装类型数据进行运算的工具
 *
 * @author LinYN
 * @since 2017-3-21
 */
public abstract class NumberUtil {

    /**
     * 加法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 加数
     * @param b 被加数
     * @return 相加后的结果
     *
     * @author LinYN
     * @since 2017-3-21
     */
    public static BigDecimal add(BigDecimal a, BigDecimal b){
        if (a == null && b == null) return new BigDecimal(0);
        if (a == null) return b;
        if (b == null) return a;
        return a.add(b);
    }

    /**
     * 加法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 加数
     * @param b 被加数
     * @return 相加后的结果
     *
     * @author LinYN
     * @since 2017-3-21
     */
    public static Integer add(Integer a, Integer b){
        if (a == null && b == null) return 0;
        if (a == null) return b;
        if (b == null) return a;
        return a + b;
    }

    /**
     * 加法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 加数
     * @param b 被加数
     * @return 相加后的结果
     *
     * @author LinYN
     * @since 2017-3-21
     */
    public static Float add(Float a, Float b){
        if (a == null && b == null) return 0.0f;
        if (a == null) return b;
        if (b == null) return a;
        return a + b;
    }

    /**
     * 加法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 加数
     * @param b 被加数
     * @return 相加后的结果
     *
     * @author LinYN
     * @since 2017-3-21
     */
    public static Double add(Double a, Double b){
        if (a == null && b == null) return 0.0;
        if (a == null) return b;
        if (b == null) return a;
        return a + b;
    }

    /**
     * 加法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 加数
     * @param b 被加数
     * @return 相加后的结果
     *
     * @author LinYN
     * @since 2017-4-13
     */
    public static Long add(Long a, Long b){
        if (a == null && b == null) return 0L;
        if (a == null) return b;
        if (b == null) return a;
        return a + b;
    }

    /**
     * 减法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 减数
     * @param b 被减数
     * @return 相减后的结果
     *
     * @author LinYN
     * @since 2017-5-6
     */
    public static BigDecimal subtract(BigDecimal a, BigDecimal b){
        if (a == null && b == null) new BigDecimal(0);
        if (a == null) return b.negate();
        if (b == null) return a;
        return a.subtract(b);
    }

    /**
     * 减法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 减数
     * @param b 被减数
     * @return 相减后的结果
     *
     * @author LinYN
     * @since 2017-5-6
     */
    public static Integer subtract(Integer a, Integer b){
        if (a == null && b == null) return 0;
        if (a == null) return -b;
        if (b == null) return a;
        return a - b;
    }

    /**
     * 减法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 减数
     * @param b 被减数
     * @return 相减后的结果
     *
     * @author LinYN
     * @since 2017-5-6
     */
    public static Long subtract(Long a, Long b){
        if (a == null && b == null) return 0L;
        if (a == null) return -b;
        if (b == null) return a;
        return a - b;
    }


    /**
     * 减法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 减数
     * @param b 被减数
     * @return 相减后的结果
     *
     * @author LinYN
     * @since 2017-5-6
     */
    public static Float subtract(Float a, Float b){
        if (a == null && b == null) return 0.0f;
        if (a == null) return -b;
        if (b == null) return a;
        return a - b;
    }

    /**
     * 减法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 减数
     * @param b 被减数
     * @return 相减后的结果
     *
     * @author LinYN
     * @since 2017-5-6
     */
    public static Double subtract(Double a, Double b){
        if (a == null && b == null) return 0.0;
        if (a == null) return -b;
        if (b == null) return a;
        return a - b;
    }

    /**
     * 乘法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 乘数
     * @param b 被乘数
     * @return 相乘后的结果
     *
     * @author LinYN
     * @since 2017-5-6
     */
    public static BigDecimal multiply(BigDecimal a, BigDecimal b){
        if (a == null || b == null) return new BigDecimal(0);
        return a.multiply(b);
    }

    /**
     * 乘法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 乘数
     * @param b 被乘数
     * @return 相乘后的结果
     *
     * @author LinYN
     * @since 2017-5-6
     */
    public static Integer multiply(Integer a, Integer b){
        if (a == null || b == null) return 0;
        return a * b;
    }

    /**
     * 乘法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 乘数
     * @param b 被乘数
     * @return 相乘后的结果
     *
     * @author LinYN
     * @since 2017-5-6
     */
    public static Long multiply(Long a, Long b){
        if (a == null || b == null) return 0L;
        return a * b;
    }

    /**
     * 乘法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 乘数
     * @param b 被乘数
     * @return 相乘后的结果
     *
     * @author LinYN
     * @since 2017-5-6
     */
    public static Float multiply(Float a, Float b){
        if (a == null || b == null) return 0.0f;
        return a * b;
    }

    /**
     * 乘法运算，如果参数为<code>null</code>则作 0 处理
     *
     * @param a 乘数
     * @param b 被乘数
     * @return 相乘后的结果
     *
     * @author LinYN
     * @since 2017-5-6
     */
    public static Double multiply(Double a, Double b){
        if (a == null || b == null) return 0.0;
        return a * b;
    }

    /**
     * 获取Number对象的<code>int</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @param n Number对象
     * @return Number对象的<code>int</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @author LinYN
     * @since 2017-3-27
     */
    public static int intValue(Number n){
        return n == null ? 0 : n.intValue();
    }

    /**
     * 获取Number对象的<code>long</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @param n Number对象
     * @return Number对象的<code>int</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @author LinYN
     * @since 2017-3-27
     */
    public static long longValue(Number n){
        return n == null ? 0L : n.longValue();
    }

    /**
     * 获取Number对象的<code>float</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @param n Number对象
     * @return Number对象的<code>float</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @author LinYN
     * @since 2017-3-27
     */
    public static float floatValue(Number n){
        return n == null ? 0.0f : n.floatValue();
    }

    /**
     * 获取Number对象的<code>double</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @param n Number对象
     * @return Number对象的<code>double</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @author LinYN
     * @since 2017-3-27
     */
    public static double doubleValue(Number n){
        return n == null ? 0.0 : n.doubleValue();
    }


    /**
     * 获取Number对象的负值，如果参数为<code>null</code>则作 0 处理
     *
     * @param value Number对象
     * @return Number对象的<code>double</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @author LinYN
     * @since 2017-5-25
     */
    public static BigDecimal negate(BigDecimal value) {
        return value == null ? new BigDecimal(0) : value.negate();
    }

    /**
     * 获取Number对象的负值，如果参数为<code>null</code>则作 0 处理
     *
     * @param value Number对象
     * @return Number对象的<code>double</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @author LinYN
     * @since 2017-5-25
     */
    public static Integer negate(Integer value) {
        return  value == null ? 0 : -value;
    }

    /**
     * 获取Number对象的负值，如果参数为<code>null</code>则作 0 处理
     *
     * @param value Number对象
     * @return Number对象的<code>double</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @author LinYN
     * @since 2017-5-25
     */
    public static Long negate(Long value) {
        return  value == null ? 0L : -value;
    }

    /**
     * 获取Number对象的负值，如果参数为<code>null</code>则作 0 处理
     *
     * @param value Number对象
     * @return Number对象的<code>double</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @author LinYN
     * @since 2017-5-25
     */
    public static Float negate(Float value) {
        return  value == null ? 0.0f : -value;
    }

    /**
     * 获取Number对象的负值，如果参数为<code>null</code>则作 0 处理
     *
     * @param value Number对象
     * @return Number对象的<code>double</code>值，如果参数为<code>null</code>则作 0 处理
     *
     * @author LinYN
     * @since 2017-5-25
     */
    public static Double negate(Double value) {
        return  value == null ? 0.0 : -value;
    }
}
