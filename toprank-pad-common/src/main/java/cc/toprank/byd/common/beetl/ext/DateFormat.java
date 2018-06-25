package cc.toprank.byd.common.beetl.ext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class DateFormat extends org.beetl.ext.format.DateFormat {

    /** Field description */
    private static final String DEFAULT_KEY = "default";

    /** Field description */
    private static Map<String, DateTimeFormatter> formatMap = new ConcurrentHashMap<>();

    static {
        formatMap.put(DEFAULT_KEY, DateTimeFormatter.ofPattern("", Locale.getDefault(Locale.Category.FORMAT)));
    }

    @Override
    public Object format(Object data, String pattern) {
        if (data == null) {
            return null;
        }

        Class<?> target = data.getClass();

        if (LocalTime.class.isAssignableFrom(target)) {
            return ((LocalTime) data).format(getFormatter(pattern));
        } else if (LocalDate.class.isAssignableFrom(target)) {
            return ((LocalDate) data).format(getFormatter(pattern));
        } else if (LocalDateTime.class.isAssignableFrom(target)) {
            return ((LocalDateTime) data).format(getFormatter(pattern));
        } else {    // Calendar,Date,Long
            if (Calendar.class.isAssignableFrom(target)) {
                data = ((Calendar) data).getTime();
            }

            return super.format(data, pattern);
        }
    }

    /**
     * Method description
     *
     *
     * @param pattern
     *
     * @return
     */
    protected DateTimeFormatter getFormatter(String pattern) {
        if (pattern == null) {
            pattern = DEFAULT_KEY;
        }

        DateTimeFormatter formatter = formatMap.get(pattern);

        if (formatter == null) {
            formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault(Locale.Category.FORMAT));
            formatMap.put(pattern, formatter);
        }

        return formatter;
    }
}



