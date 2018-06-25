import cc.toprank.byd.common.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David
 */
public class Client {
    public static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
    public static void main(String[] args) {
        LOGGER.warn("---");
        DateUtils.getUTCLocalDateTime();
        String a= "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "ab" + "c";
        System.out.println(a==b);
        System.out.println(c==b);
        System.out.println(c==d);
        System.out.println(a==d);
    }

}




