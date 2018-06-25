package cc.toprank.byd.common.utils.rsa;

import cc.toprank.byd.common.utils.string.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class MD5 {

    /** Field description */
    private static final Logger logger = LoggerFactory.getLogger(MD5.class);

    /**
     * Method description
     *
     *
     * @param args
     *
     * @return
     */
    public static String GetSaltMD5(String args) {
        return string2MD5(string2MD5(args).concat("toprank"));
    }

    /**
     * Method description
     *
     *
     * @param data
     *
     * @return
     */
    public static String hashMD5(String data) {
        byte[] bytes = null;

        try {
            bytes = data.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        MessageDigest digest = null;

        try {

//          MessageDigest digest = digests.get("MD5");
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            logger.error("MD5�ַ������ܳ���", e);
        }

        digest.update(bytes);

        StringBuilder buf = new StringBuilder(bytes.length * 2);
        int           i;

        for (i = 0; i < bytes.length; i++) {
            if (((int) bytes[i] & 0xff) < 0x10) {
                buf.append("0");
            }

            buf.append(Long.toString((int) bytes[i] & 0xff, 16));
        }

        return buf.toString();
    }

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(MD5.string2MD5(MD5.string2MD5("000000").concat("toprank")));
        System.out.println(MD5.string2MD5("chenjianhua"));
        System.out.println(MD5.hashMD5("chenjianhua"));
        System.out.println(DigestUtils.md5Hex("chenjianhua").toUpperCase());
        System.out.println(GetSaltMD5("123456"));
    }

    /**
     * Method description
     *
     *
     * @param inStr
     *
     * @return
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;

        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();

            return "";
        }

        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }

        byte[]       md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;

            if (val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }

    /**
     * Method description
     *
     *
     * @param data
     *
     * @return
     */
    public static byte[] getMD5(byte[] data) {
        byte[] md5 = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            md5 = md.digest(data);
        } catch (Exception e) {}

        return md5;
    }

    /*
     * MD5�ַ���
     */

    /**
     * Method description
     *
     *
     * @param data
     *
     * @return
     */
    public static String getMD5Str(byte[] data) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(data);
        } catch (NoSuchAlgorithmException e) {

            // LogUtil.e("NoSuchAlgorithmException = " + e.toString());
        }

        byte[]       byteArray  = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }

        return md5StrBuff.toString().toUpperCase();
    }

    /*
     * MD5�ַ���
     */

    /**
     * Method description
     *
     *
     * @param str
     *
     * @return
     */
    public static String getMD5Str(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();

            if (!StringUtil.isEmpty(str)) {
                messageDigest.update(str.getBytes("UTF-8"));
            }
        } catch (NoSuchAlgorithmException e) {
            logger.error("MD5�ַ������ܳ���", e);
        } catch (UnsupportedEncodingException e) {
            logger.error("MD5�ַ������ܳ���", e);
        }

        byte[]       byteArray  = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }

        return md5StrBuff.toString().toUpperCase();
    }
}



