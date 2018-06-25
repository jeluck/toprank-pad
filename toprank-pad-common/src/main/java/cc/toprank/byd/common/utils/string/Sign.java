package cc.toprank.byd.common.utils.string;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class Sign {

    // �ַ������ʽ Ŀǰ֧�� gbk �� utf-8

    /** Field description */
    public static String input_charset = "utf-8";

    // ǩ����ʽ

    /** Field description */
    public static String sign_type = "MD5";

    /**
     * Method description
     *
     *
     * @param sPara
     * @param key
     *
     * @return
     */
    public static String buildRequestMysign(Map<String, String> sPara, String key) {
        String prestr = Sign.createLinkString(sPara);    // ����������Ԫ�أ����ա�����=����ֵ����ģʽ�á�&���ַ�ƴ�ӳ��ַ���
        String mysign = "";

        if (Sign.sign_type.equals("MD5")) {
            mysign = Sign.sign(prestr, key, Sign.input_charset);
        }

        return mysign;
    }

    /**
     * Method description
     *
     *
     * @param sParaTemp
     * @param key
     *
     * @return
     */
    public static String buildRequestPara(Map<String, String> sParaTemp, String key) {

        // ��ȥ�����еĿ�ֵ��ǩ������
        Map<String, String> sPara = Sign.paraFilter(sParaTemp);

        // ����ǩ�����
        String mysign = buildRequestMysign(sPara, key);

        return mysign;
    }

    /**
     * Method description
     *
     *
     * @param params
     *
     * @return
     */
    public static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());

        Collections.sort(keys);

        StringBuffer prestr = new StringBuffer("");

        for (int i = 0; i < keys.size(); i++) {
            String key   = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {    // ƴ��ʱ�����������һ��&�ַ�
                prestr.append(key)         //
                      .append("=")         //
                      .append(value);
            } else {
                prestr.append(key)         //
                      .append("=")         //
                      .append(value)       //
                      .append("&");
            }
        }

        return prestr.toString();
    }

    /**
     * Method description
     *
     *
     * @param sArray
     *
     * @return
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {
        Map<String, String> result = new LinkedHashMap<String, String>();

        if ((sArray == null) || (sArray.size() <= 0)) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);

            if ((value == null) || "".equals(value)) {
                continue;
            }

            result.put(key, value);
        }

        return result;
    }

    /**
     * Method description
     *
     *
     * @param text
     * @param key
     * @param input_charset
     *
     * @return
     */
    public static String sign(String text, String key, String input_charset) {
        text = text + key;

        return DigestUtils.md5Hex(getContentBytes(text, input_charset));
    }

    /**
     * Method description
     *
     *
     * @param content
     * @param charset
     *
     * @return
     */
    private static byte[] getContentBytes(String content, String charset) {
        if ((charset == null) || "".equals(charset)) {
            return content.getBytes();
        }

        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5ǩ�������г��ִ���,ָ���ı��뼯����,��Ŀǰָ���ı��뼯��:" + charset);
        }
    }
}



