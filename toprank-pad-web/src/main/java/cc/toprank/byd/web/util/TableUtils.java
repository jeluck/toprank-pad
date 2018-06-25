package cc.toprank.byd.web.util;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 桌台工具类
 *
 * @author LinYN
 * @since 2017-3-22
 */
public class TableUtils {

    private static final int INITIAL_VALUE = 1;

    private static AtomicInteger sequence = new AtomicInteger(INITIAL_VALUE);

    private static volatile LocalDate today = LocalDate.now();

    /**
     * 获取当天联台的新序号，第二天序号会被重置
     *
     * @return 当天联台的新序号
     * @author LinYN
     */
    public static int getCombineTableSequence() {
        LocalDate currentDate = LocalDate.now();
        if (!currentDate.equals(today)) {
            synchronized (TableUtils.class) {
                if (!currentDate.equals(today)) {
                    today = currentDate;
                    sequence.set(INITIAL_VALUE);
                }
            }
        }
        return sequence.getAndIncrement();
    }

    private TableUtils() {}
}
