package cc.toprank.byd.common.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class NumberFormatUtils {

    /** Field description */
    private static final Map<String, NumberFormat> fmtMap = new HashMap<String, NumberFormat>();

    /**
     * Method description
     *
     *
     * @param number
     * @param ex
     *
     * @return
     */
    public static String format(double number, String ex) {
        return getFormat(ex).format(number);
    }

    /**
     * Method description
     *
     *
     * @param number
     * @param ex
     *
     * @return
     */
    public static String format(long number, String ex) {
        return getFormat(ex).format(number);
    }

    /**
     * Method description
     *
     *
     * @param obj
     * @param ex
     *
     * @return
     */
    public static String format(Object obj, String ex) {
        return getFormat(ex).format(obj);
    }

    /**
     * Method description
     *
     *
     * @param source
     * @param ex
     *
     * @return
     *
     * @throws ParseException
     */
    public static Number parse(String source, String ex) throws ParseException {
        return getFormat(ex).parse(source);
    }

    /**
     * Method description
     *
     *
     * @param ex
     *
     * @return
     */
    private static NumberFormat getFormat(String ex) {
        NumberFormat fmt = fmtMap.get(ex);

        if (fmt == null) {
            fmt = new DecimalFormat(ex);
            fmtMap.put(ex, fmt);
        }

        return fmt;
    }
}



