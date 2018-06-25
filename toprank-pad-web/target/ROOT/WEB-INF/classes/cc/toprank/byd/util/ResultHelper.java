package cc.toprank.byd.util;

/**
 * ${DESCRIPTION}
 *
 * @author LeeJun
 * @create 2017-05-23 9:45
 */
public class ResultHelper {

    /**
     * 判断数据库操作是否成功
     *
     * @author LeeJun
     * @time 2017-5-23 9:45
     * @version 2.0.0
     */
    public static boolean retBool(Integer result) {
        return null != result && result >= 0;
    }
}
