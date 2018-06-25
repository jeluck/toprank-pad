package cc.toprank.byd.common.utils.rsa;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class AESCodec {

    /** Field description */
    private static final String KEY_ALGORITHM = "AES";

    // ���ܡ������㷨/����ģʽ/��䷽ʽ

    /** Field description */
    private static final String CIPHER_ALGORITHM = "AES/ECB/NoPadding";

    /** Field description */
    private static final int KEY_SIZE = 128;

    /** Field description */
    private static final String CHARSET = "UTF-8";

    // ����

    /**
     * Method description
     *
     *
     * @param data
     * @param key
     *
     * @return
     *
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, KEY_ALGORITHM);
        Cipher        cipher   = Cipher.getInstance(CIPHER_ALGORITHM);

        cipher.init(Cipher.DECRYPT_MODE, skeySpec);

        return trim(cipher.doFinal(data));
    }

    /**
     * Method description
     *
     *
     * @param data
     * @param key
     *
     * @return
     *
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String key) throws Exception {
        return decrypt(data, HexCodec.hexDecode(key));
    }

    /**
     * Method description
     *
     *
     * @param data
     * @param key
     *
     * @return
     *
     * @throws Exception
     */
    public static String decrypt(String data, String key) throws Exception {
        return new String(decrypt(HexCodec.hexDecode(data), key), CHARSET);
    }

    // ����

    /**
     * Method description
     *
     *
     * @param data
     * @param key
     *
     * @return
     *
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecretKeySpec skeySpec = new SecretKeySpec(key, KEY_ALGORITHM);
        Cipher        cipher   = Cipher.getInstance(CIPHER_ALGORITHM);

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        return cipher.doFinal(padding(data));
    }

    /**
     * Method description
     *
     *
     * @param data
     * @param key
     *
     * @return
     *
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String key) throws Exception {
        return encrypt(data, HexCodec.hexDecode(key));
    }

    /**
     * Method description
     *
     *
     * @param data
     * @param key
     *
     * @return
     *
     * @throws Exception
     */
    public static String encrypt(String data, String key) throws Exception {
        return HexCodec.hexEncode(encrypt(data.getBytes(CHARSET), key));
    }

    /**
     * Method description
     *
     *
     * @param data
     *
     * @return
     */
    private static byte[] encryptMD5(String data) {
        byte[] bytes = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            bytes = md.digest(data.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException gse) {

            // ignore, must not be here
        } catch (UnsupportedEncodingException uee) {

            // ignore, must not be here
        }

        return bytes;
    }

    // ����һ��AES��Կ

    /**
     * Method description
     *
     *
     * @return
     *
     * @throws Exception
     */
    public static byte[] genKey() throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);

        kg.init(KEY_SIZE);

        SecretKey secretKey = kg.generateKey();
        byte[]    key       = secretKey.getEncoded();

        return key;
    }

    /**
     * Method description
     *
     *
     * @param data
     *
     * @return
     */
    private static byte[] padding(byte[] data) {
        return padding(data, 16);
    }

    /**
     * Method description
     *
     *
     * @param data
     * @param len
     *
     * @return
     */
    private static byte[] padding(byte[] data, int len) {
        int length    = data.length;
        int remainder = length % len;

        if (remainder == 0) {
            return data;
        } else {
            byte[] newData = new byte[length + (len - remainder)];

            System.arraycopy(data, 0, newData, 0, length);

            return newData;
        }
    }

    /**
     * Method description
     *
     *
     * @param data
     *
     * @return
     */
    private static byte[] trim(byte[] data) {
        int length  = data.length;
        int counter = 0;

        for (int i = 1; i < 17; i++) {
            if (data[length - i] == (byte) 0x00) {
                counter++;
            }
        }

        return Arrays.copyOfRange(data, 0, (length - counter));
    }
}



