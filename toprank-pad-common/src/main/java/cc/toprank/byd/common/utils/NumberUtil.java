package cc.toprank.byd.common.utils;

import org.apache.commons.lang3.math.NumberUtils;

import java.math.BigDecimal;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class NumberUtil {

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    public static BigDecimal toBigDecimal(Object obj) {
        if ((obj == null) ||!NumberUtils.isNumber(obj.toString())) {
            throw new NumberFormatException("数字转换异常");
        } else {
            return new BigDecimal(obj.toString());
        }
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    public static Double toDouble(Object obj) {
        if ((obj == null) ||!NumberUtils.isNumber(obj.toString())) {
            throw new NumberFormatException("数字转换异常");
        } else {
            return Double.valueOf(obj.toString());
        }
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    public static Integer toInteger(Object obj) {
        if ((obj == null) ||!NumberUtils.isDigits(obj.toString())) {
            throw new NumberFormatException("数字转换异常");
        } else {
            return Integer.valueOf(obj.toString());
        }
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    public static Long toLong(Object obj) {
        if ((obj == null) ||!NumberUtils.isDigits(obj.toString())) {
            throw new NumberFormatException("数字转换异常");
        } else {
            return Long.valueOf(obj.toString());
        }
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    public static boolean isDigits(Object obj) {
        if (obj == null) {
            return false;
        }

        return NumberUtils.isDigits(obj.toString());
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    public static boolean isNumber(Object obj) {
        if (obj == null) {
            return false;
        }

        return NumberUtils.isNumber(obj.toString());
    }

//  public static void main(String[] args) {
//          BigDecimal bdcm4 = toBigDecimal("9999");
//          System.out.println("bdcm4:" + bdcm4);
//  }
}



