package cc.toprank.byd.common.utils;

import cc.toprank.byd.common.utils.string.StringUtil;
import org.apache.commons.beanutils.BeanPredicate;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.PredicateUtils;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class CheckUtils {

    /** Field description */
    public static final String COMMON_FIELD = "flowID,initiator,";

    /**
     * Method description
     *
     *
     * @param sb
     * @param obj
     * @param checkNames
     */
    private static void checkValueIsNull(StringBuffer sb, Object obj, String checkNames) {
        if (obj == null) {
            sb.append(checkNames + ",");

            return;
        }

        if (!(isPrimitive(obj) || (obj instanceof Date) || (obj instanceof String) || (obj instanceof BigDecimal))) {
            String chkname[] = checkNames.split(",");

            for (int j = 0; j < chkname.length; j++) {
                Predicate predicate = new BeanPredicate(chkname[j], PredicateUtils.nullPredicate());

                if (predicate.evaluate(obj)) {
                    sb.append(chkname[j] + ",");
                }
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param obj
     * @param message
     */
    @SuppressWarnings("rawtypes")
    public static void notEmpty(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message + " must be specified");
        }

        if ((obj instanceof String) && (obj.toString().trim().length() == 0)) {
            throw new IllegalArgumentException(message + " must be specified");
        }

        if (obj.getClass().isArray() && (Array.getLength(obj) == 0)) {
            throw new IllegalArgumentException(message + " must be specified");
        }

        if ((obj instanceof Collection) && ((Collection) obj).isEmpty()) {
            throw new IllegalArgumentException(message + " must be specified");
        }

        if ((obj instanceof Map) && ((Map) obj).isEmpty()) {
            throw new IllegalArgumentException(message + " must be specified");
        }
    }

    /**
     * Method description
     *
     *
     * @param obj
     * @param message
     */
    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message + " must be specified");
        }
    }

    /**
     * Method description
     *
     *
     * @param objs
     * @param messages
     */
    public static void notNull(Object[] objs, String... messages) {
        if (objs.length != messages.length) {
            throw new IllegalArgumentException("objs's length is not equlas message's length");
        }

        for (int i = 0; i < objs.length; i++) {
            if (objs[i] == null) {
                throw new IllegalArgumentException(messages[i] + " must be specified");
            }
        }
    }

    /**
     * Method description
     *
     *
     * @param regex
     * @param value
     *
     * @return
     */
    public static boolean regexMatcher(String regex, String value) {
        if (StringUtil.isBlank(value)) {
            return false;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        return matcher.matches();
    }

    /**
     * Method description
     *
     *
     * @param obj
     * @param message
     */
    public static void strNotNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message + " must be specified");
        }

        if ((obj instanceof String) && (obj.toString().length() == 0)) {
            throw new IllegalArgumentException(message + " must be specified");
        }
    }

    /**
     * Method description
     *
     *
     * @param str
     * @param checkName
     */
    public static void valueIsEmpty(String str, String checkName) {
        if (StringUtil.isEmpty(str)) {
            StringBuffer sb = new StringBuffer();

            sb.append(checkName).append(" must be specified");

            throw new IllegalArgumentException(sb.toString());
        }
    }

    /**
     * Method description
     *
     *
     * @param strs
     * @param checkNames
     */
    public static void valueIsEmpty(String[] strs, String... checkNames) {
        StringBuffer buffer = new StringBuffer();

        if (strs.length != checkNames.length) {
            throw new IllegalArgumentException("strs's length is not equlas checkNames's length");
        }

        for (int i = 0; i < strs.length; i++) {
            if (StringUtil.isBlank(strs[i])) {
                buffer.append(checkNames[i]).append(",");
            }
        }

        if (buffer.toString().endsWith(",")) {
            buffer.append(" must be specified");

            throw new IllegalArgumentException(buffer.toString());
        }
    }

    /**
     * Method description
     *
     *
     * @param obj
     * @param checkName
     */
    public static void valueIsNull(Object obj, String checkName) {
        StringBuffer sb = new StringBuffer();

        checkValueIsNull(sb, obj, checkName);

        if (sb.toString().endsWith(",")) {
            sb.append(" must be specified");

            throw new IllegalArgumentException(sb.toString());
        }
    }

    /**
     * Method description
     *
     *
     * @param objs
     * @param checkNames
     */
    public static void valueIsNull(Object[] objs, String[] checkNames) {
        if (objs.length != checkNames.length) {
            throw new IllegalArgumentException("objs's length is not equlas checkNames's length");
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < objs.length; i++) {
            checkValueIsNull(sb, objs[i], checkNames[i]);
        }

        if (sb.toString().endsWith(",")) {
            sb.append(" must be specified");

            throw new IllegalArgumentException(sb.toString());
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
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }

        if ((obj instanceof String) && (obj.toString().trim().length() == 0)) {
            return true;
        }

        if (obj.getClass().isArray() && (Array.getLength(obj) == 0)) {
            return true;
        }

        if ((obj instanceof Collection) && ((Collection) obj).isEmpty()) {
            return true;
        }

        if ((obj instanceof Map) && ((Map) obj).isEmpty()) {
            return true;
        }

        return false;
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        }

        return false;
    }

    /**
     * Method description
     *
     *
     * @param obj
     *
     * @return
     */
    public static boolean isPrimitive(Object obj) {
        if (obj.getClass().isPrimitive()) {
            return true;
        }

        if ((obj instanceof Long)
                || (obj instanceof Integer)
                || (obj instanceof Float)
                || (obj instanceof Boolean)
                || (obj instanceof Double)) {
            return true;
        }

        return false;
    }
}



