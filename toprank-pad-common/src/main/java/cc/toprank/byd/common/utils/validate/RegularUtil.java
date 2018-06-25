package cc.toprank.byd.common.utils.validate;

import java.util.regex.Pattern;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class RegularUtil {

    /**
     * Method description
     *
     *
     * @param regular
     * @param input
     *
     * @return
     */
    public static Boolean validatePattern(String regular, String input) {
        Pattern p = Pattern.compile(regular);

        return p.matcher(input).matches();
    }
}



