package cc.toprank.byd.common.utils.token;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class SignUtil {

    /** Field description */
    private String appKey = null;

    /** Field description */
    private String sign = null;

    /** Field description */
    private String parameterStr = null;

    /**
     * Method description
     *
     *
     * @param b
     *
     * @return
     */
    private static String byte2hex(byte[] b) {
        StringBuffer hs   = new StringBuffer();
        String       stmp = "";

        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));

            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }

        return hs.toString().toUpperCase();
    }

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        String s =
            " <p style=\"margin-top: 5px; margin-bottom: 5px; padding: 0px; line-height: 30px; text-indent: 15px; color: rgb(102, 102, 102); clear: both; font-family: sans-serif; font-size: 15.5555562973022px;\"><span style=\"margin: 0px; padding: 0px; font-family: ����;\">�����ƹ����йأ��ò�ľ�ҡ��������Ƶ���Ѽ�������׻����ƣ����������󣬿ɷ���ʳ�á�</span><img data-s=\"300,640\" data-type=\"jpeg\" src=\"https://mmbiz.qlogo.cn/mmbiz/XCsq5ofh5EKcVlNcf5m8KwPnMZ9qwMHX6GmRnnY4kw3X0m6jPNfkaJc8V9aYibJLcLF7CK8Dic2UWQNE1xnysMUg/0?wx_fmt=jpeg\" data-ratio=\"0.562624254473161\" data-w=\"\" _src=\"https://mmbiz.qlogo.cn/mmbiz/XCsq5ofh5EKcVlNcf5m8KwPnMZ9qwMHX6GmRnnY4kw3X0m6jPNfkaJc8V9aYibJLcLF7CK8Dic2UWQNE1xnysMUg/0?wx_fmt=jpeg\" alt=\"\" style=\"margin: 0px; padding: 0px; border: none; list-style-type: none; max-width: 100%; font-family: ����; height: auto !important;\" /></p>";

        s = getEncodeString(s);
        System.out.println(s);
    }

    /**
     * Method description
     *
     *
     * @param params
     * @param secret
     *
     * @return
     */
    public static String md5Signature(TreeMap<String, String> params, String secret) {
        String       result = null;
        StringBuffer orgin  = getParemeterString(params, secret);

        if (orgin == null) {
            return result;
        }

        orgin.append(secret);

        try {

            // String encodestr = getEncodeString(orgin.toString());
            MessageDigest md = MessageDigest.getInstance("MD5");

            System.out.println("md5..." + md.digest(orgin.toString().getBytes("utf-8")).toString());
            result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
        } catch (Exception e) {
            throw new java.lang.RuntimeException("sign error !");
        }

        return result;
    }

    /**
     * Method description
     *
     *
     * @param parameter
     * @param secret
     *
     * @return
     *
     * @throws Exception
     */
    public static String sign(String parameter, String secret) throws Exception {

        // �Բ���+��Կ��MD5����
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new Exception(e);
        }

        byte[] digest = md.digest((parameter).getBytes("utf-8"));
        String sign   = byte2hex(digest);

        System.out.println("client sign��" + sign);

        return sign;
    }

    /**
     * Method description
     *
     *
     * @param secret
     *
     * @return
     *
     * @throws Exception
     */
    public boolean validateSign(String secret) throws Exception {
        return (sign != null)
               && (parameterStr != null)
               && (secret != null)
               && sign.equals(sign(secret + parameterStr + secret, secret));
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getAppKey() {
        return appKey;
    }

    /**
     * Method description
     *
     *
     * @param str
     *
     * @return
     */
    public static String getEncodeString(String str) {
        String returnstr = "";

        try {
            if (null != str) {
                returnstr = URLEncoder.encode(str, "utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return returnstr;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getParameterStr() {
        return parameterStr;
    }

    /**
     * Method description
     *
     *
     * @param map
     * @param secret
     *
     * @return
     */
    public static StringBuffer getParemeterString(TreeMap<String, String> map, String secret) {
        StringBuffer orgin = new StringBuffer(secret);

        if (null == map) {
            return null;
        }

        List<String> arrays = new ArrayList<String>();

        for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry entry = (java.util.Map.Entry) iterator.next();
            String    key   = entry.getKey().toString();

            if (key.endsWith("sign")) {
                System.out.println("client sign:" + map.get(key));

                continue;
            }

            orgin.append(key).append(map.get(key));
        }

        return orgin;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getSign() {
        return sign;
    }
}



