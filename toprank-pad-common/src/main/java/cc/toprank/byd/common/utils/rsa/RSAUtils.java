package cc.toprank.byd.common.utils.rsa;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class RSAUtils {

    /** Field description */
    public static final String ENCODING = "UTF-8";

    /** Field description */
    public static final String ANDROID = "android";

    /** Field description */
    public static final String KEY_ALGORITHM = "RSA";

    /** Field description */
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /** Field description */
    public static final String PUBLIC_KEY_VALUE = "publicEncoded";

    /** Field description */
    public static final String PRIVATE_KEY_VALUE = "privateEncoded";

    /** Field description */
    private static final String PUBLIC_KEY = "RSAPublicKey";

    /** Field description */
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /** Field description */
    private static final int MAX_ENCRYPT_BLOCK = 116;

    /** Field description */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * Method description
     *
     *
     * @param encryptedData
     * @param privateKey
     *
     * @return
     *
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws Exception {
        byte[]              keyBytes     = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory          keyFactory   = KeyFactory.getInstance(KEY_ALGORITHM);
        Key                 privateK     = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher              cipher       = Cipher.getInstance(keyFactory.getAlgorithm());

        cipher.init(Cipher.DECRYPT_MODE, privateK);

        int                   inputLen = encryptedData.length;
        ByteArrayOutputStream out      = new ByteArrayOutputStream();
        int                   offSet   = 0;
        byte[]                cache;
        int                   i = 0;

        // �����ݷֶν���
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }

        byte[] decryptedData = out.toByteArray();

        out.close();

        return decryptedData;
    }

    /**
     * Method description
     *
     *
     * @param encryptedData
     * @param publicKey
     *
     * @return
     *
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] encryptedData, String publicKey) throws Exception {
        byte[]             keyBytes    = Base64.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory         keyFactory  = KeyFactory.getInstance(KEY_ALGORITHM);
        Key                publicK     = keyFactory.generatePublic(x509KeySpec);
        Cipher             cipher      = Cipher.getInstance(keyFactory.getAlgorithm());

        cipher.init(Cipher.DECRYPT_MODE, publicK);

        int                   inputLen = encryptedData.length;
        ByteArrayOutputStream out      = new ByteArrayOutputStream();
        int                   offSet   = 0;
        byte[]                cache;
        int                   i = 0;

        // �����ݷֶν���
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }

        byte[] decryptedData = out.toByteArray();

        out.close();

        return decryptedData;
    }

    /**
     * Method description
     *
     *
     * @param data
     * @param privateKey
     *
     * @return
     *
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws Exception {
        byte[]              keyBytes     = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory          keyFactory   = KeyFactory.getInstance(KEY_ALGORITHM);
        Key                 privateK     = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher              cipher       = Cipher.getInstance(keyFactory.getAlgorithm());

        cipher.init(Cipher.ENCRYPT_MODE, privateK);

        int                   inputLen = data.length;
        ByteArrayOutputStream out      = new ByteArrayOutputStream();
        int                   offSet   = 0;
        byte[]                cache;
        int                   i = 0;

        // �����ݷֶμ���
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }

        byte[] encryptedData = out.toByteArray();

        out.close();

        return encryptedData;
    }

    /**
     * Method description
     *
     *
     * @param data
     * @param publicKey
     * @param deviceType
     *
     * @return
     *
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey, String deviceType) throws Exception {
        byte[]             keyBytes    = Base64.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory         keyFactory  = KeyFactory.getInstance(KEY_ALGORITHM);
        Key                publicK     = keyFactory.generatePublic(x509KeySpec);

        // �����ݼ���
        Cipher cipher = null;

        if (deviceType.toLowerCase().equals(ANDROID)) {

            // ����ǰ�׿��
            cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        } else {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        }

        cipher.init(Cipher.ENCRYPT_MODE, publicK);

        int                   inputLen = data.length;
        ByteArrayOutputStream out      = new ByteArrayOutputStream();
        int                   offSet   = 0;
        byte[]                cache;
        int                   i = 0;

        // �����ݷֶμ���
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }

            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }

        byte[] encryptedData = out.toByteArray();

        out.close();

        return encryptedData;
    }

    /**
     * Method description
     *
     *
     * @return
     *
     * @throws Exception
     */
    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);

        keyPairGen.initialize(1024);

        KeyPair             keyPair    = keyPairGen.generateKeyPair();
        RSAPublicKey        publicKey  = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey       privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap     = new HashMap<String, Object>(2);

        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        keyMap.put(PUBLIC_KEY_VALUE, Base64.encode(publicKey.getEncoded()));
        keyMap.put(PRIVATE_KEY_VALUE, Base64.encode(privateKey.getEncoded()));

        return keyMap;
    }

    /**
     * Method description
     *
     *
     * @param data
     * @param privateKey
     *
     * @return
     *
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        byte[]              keyBytes     = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory          keyFactory   = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey          privateK     = keyFactory.generatePrivate(pkcs8KeySpec);
        Signature           signature    = Signature.getInstance(SIGNATURE_ALGORITHM);

        signature.initSign(privateK);
        signature.update(data);

        return Base64.encode(signature.sign());
    }

    /**
     * Method description
     *
     *
     * @param data
     * @param publicKey
     * @param sign
     *
     * @return
     *
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {
        byte[]             keyBytes   = Base64.decode(publicKey);
        X509EncodedKeySpec keySpec    = new X509EncodedKeySpec(keyBytes);
        KeyFactory         keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey          publicK    = keyFactory.generatePublic(keySpec);
        Signature          signature  = Signature.getInstance(SIGNATURE_ALGORITHM);

        signature.initVerify(publicK);
        signature.update(data);

        return signature.verify(Base64.decode(sign));
    }

    /**
     * Method description
     *
     *
     * @param keyMap
     *
     * @return
     *
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);

        return Base64.encode(key.getEncoded());
    }

    /**
     * Method description
     *
     *
     * @param keyMap
     *
     * @return
     *
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap) throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);

        return Base64.encode(key.getEncoded());
    }
}



