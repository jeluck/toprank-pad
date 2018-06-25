package cc.toprank.byd.common.utils.rsa;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class QEncodeUtil {

    /**
     * Method description
     *
     *
     * @param encryptStr
     * @param decryptKey
     *
     * @return
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) {
        return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }

    /**
     * Method description
     *
     *
     * @param encryptBytes
     * @param decryptKey
     *
     * @return
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");

            kgen.init(128, new SecureRandom(decryptKey.getBytes()));

            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));

            byte[] decryptBytes = cipher.doFinal(encryptBytes);

            return new String(decryptBytes);
        } catch (Exception e) {}

        return null;
    }

    /**
     * Method description
     *
     *
     * @param content
     * @param encryptKey
     *
     * @return
     */
    public static String aesEncrypt(String content, String encryptKey) {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * Method description
     *
     *
     * @param content
     * @param encryptKey
     *
     * @return
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");

            kgen.init(128, new SecureRandom(encryptKey.getBytes()));

            Cipher cipher = Cipher.getInstance("AES");

            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));

            return cipher.doFinal(content.getBytes("utf-8"));
        } catch (Exception e) {}

        return null;
    }

    /**
     * Method description
     *
     *
     * @param base64Code
     *
     * @return
     */
    private static byte[] base64Decode(String base64Code) {
        return Base64.decode(base64Code);
    }

    /**
     * Method description
     *
     *
     * @param bytes
     *
     * @return
     */
    private static String base64Encode(byte[] bytes) {
        return Base64.encode(bytes);
    }

    /**
     * Method description
     *
     *
     * @param args
     *
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String content = "�Ұ���";

        System.out.println("����ǰ��" + content);

        String key = "123456";

        System.out.println("������Կ�ͽ�����Կ��" + key);

        String encrypt = aesEncrypt(content, key);

        System.out.println("���ܺ�" + encrypt);

        String decrypt = aesDecrypt(encrypt, key);

        System.out.println("���ܺ�" + decrypt);
    }

    /**
     * Method description
     *
     *
     * @param bytes
     *
     * @return
     *
     * @throws NoSuchAlgorithmException
     */
    public static byte[] md5(byte[] bytes) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");

        md.update(bytes);

        return md.digest();
    }

    /**
     * Method description
     *
     *
     * @param msg
     *
     * @return
     *
     * @throws NoSuchAlgorithmException
     */
    public static byte[] md5(String msg) throws NoSuchAlgorithmException {
        return md5(msg.getBytes());
    }

    /**
     * Method description
     *
     *
     * @param msg
     *
     * @return
     *
     * @throws NoSuchAlgorithmException
     */
    public static String md5Encrypt(String msg) throws NoSuchAlgorithmException {
        return base64Encode(md5(msg));
    }
}



