package cc.toprank.byd.common.utils.number;

import java.math.BigDecimal;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public abstract class AmountUtil {

    /**
     * Constructs ...
     *
     */
    private AmountUtil() {}

    /**
     * Method description
     *
     *
     * @param v1
     * @param v2
     *
     * @return
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.add(b2).doubleValue();
    }

    /**
     * Method description
     *
     *
     * @param a
     * @param b
     *
     * @return
     */
    public static boolean bigger(double a, double b) {
        BigDecimal v1 = BigDecimal.valueOf(a);
        BigDecimal v2 = BigDecimal.valueOf(b);

        if (v1.compareTo(v2) == 1) {
            return true;
        }

        return false;
    }

    /**
     * Method description
     *
     *
     * @param v1
     * @param v2
     *
     * @return
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, 2);
    }

    /**
     * Method description
     *
     *
     * @param v1
     * @param v2
     * @param scale
     *
     * @return
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }

        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Method description
     *
     *
     * @param a
     * @param b
     *
     * @return
     */
    public static boolean equal(double a, double b) {
        BigDecimal v1 = BigDecimal.valueOf(a);
        BigDecimal v2 = BigDecimal.valueOf(b);

        if (v1.compareTo(v2) == 0) {
            return true;
        }

        return false;
    }

    /**
     * Method description
     *
     *
     * @param a
     * @param b
     *
     * @return
     */
    public static boolean greaterThanOrEqualTo(double a, double b) {
        BigDecimal v1 = BigDecimal.valueOf(a);
        BigDecimal v2 = BigDecimal.valueOf(b);

        if (v1.compareTo(v2) >= 0) {
            return true;
        }

        return false;
    }

    /**
     * Method description
     *
     *
     * @param a
     * @param b
     *
     * @return
     */
    public static boolean lessThan(double a, double b) {
        BigDecimal v1 = BigDecimal.valueOf(a);
        BigDecimal v2 = BigDecimal.valueOf(b);

        if (v1.compareTo(v2) == -1) {
            return true;
        }

        return false;
    }

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Double a = 101.005D;
        Double b = 0.0D;
        Double s = AmountUtil.sub(a, b);

        System.out.println(AmountUtil.roundDown(s));
        System.out.println(AmountUtil.div(101.1D, 1D, 2));
    }

    /**
     * Method description
     *
     *
     * @param v1
     * @param v2
     *
     * @return
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.multiply(b2).doubleValue();
    }

    /**
     * Method description
     *
     *
     * @param v
     * @param scale
     *
     * @return
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }

        BigDecimal b   = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");

        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Method description
     *
     *
     * @param num
     *
     * @return
     */
    public static double roundDown(double num) {
        return Double.valueOf(String.format("%.2f", num));

        // return new BigDecimal(num).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * Method description
     *
     *
     * @param v1
     * @param v2
     *
     * @return
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));

        return b1.subtract(b2).doubleValue();
    }
}



