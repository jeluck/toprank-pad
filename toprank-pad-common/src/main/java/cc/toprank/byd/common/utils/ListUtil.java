package cc.toprank.byd.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class ListUtil {

    /**
     * Method description
     *
     *
     * @param list
     * @param skip
     * @param limit
     * @param <T>
     *
     * @return
     */
    public static <T> ArrayList<T> subList(List<T> list, int skip, int limit) {
        int start = skip;
        int size  = list.size();

        if (start > size) {
            return new ArrayList<>();
        }

        int end = skip + limit;

        if (end > size) {
            end = size;
        }

        ArrayList<T> retList = new ArrayList<>();

        retList.addAll(list.subList(start, end));

        return retList;
    }
}



