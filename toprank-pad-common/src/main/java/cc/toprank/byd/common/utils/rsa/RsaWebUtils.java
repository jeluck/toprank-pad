package cc.toprank.byd.common.utils.rsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class RsaWebUtils {

    /**
     * Method description
     *
     *
     * @param param
     * @param privateKey
     *
     * @return
     *
     * @throws Exception
     */
    public static String sign(Map<String, String> param, String privateKey) throws Exception {
        return RSAUtils.sign(toSignString(param).getBytes(), privateKey);
    }

    /**
     * Method description
     *
     *
     * @param params
     *
     * @return
     */
    public static String toSignString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());

        keys.addAll(params.keySet());
        Collections.sort(keys);

        StringBuilder sb = new StringBuilder();

        for (String key : keys) {
            if (sb.length() > 0) {
                sb.append('?');
            }

            sb.append(key).append("=").append(params.get(key));
        }

        return sb.toString();
    }

    /**
     * Method description
     *
     *
     * @param param
     * @param sign
     * @param publicKey
     *
     * @return
     *
     * @throws Exception
     */
    public static boolean verify(Map<String, String> param, String sign, String publicKey) throws Exception {
        return RSAUtils.verify(toSignString(param).getBytes(), publicKey, sign);
    }
}



