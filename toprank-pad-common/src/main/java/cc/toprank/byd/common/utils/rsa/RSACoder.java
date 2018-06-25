package cc.toprank.byd.common.utils.rsa;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
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
public class RSACoder {

    /** Field description */
    public static final String KEY_ALGORITHM = "RSA";    // ���ܷ�ʽ

    // ����ǩ�� ǩ��/��֤�㷨

    /** Field description */
    private static final String SIGNATURE_ALGORRITHM = "SHA1withRSA";

    // ��Կ������

    /** Field description */
    private static final String PUBLIC_KEY = "RSAPublicKey";

    // ˽Կ������

    /** Field description */
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    // RSA��Կ����,Ĭ��Ϊ1024,��Կ���ȱ�����64�ı���,��Χ��512~65526λ֮��

    /** Field description */
    private static final int KEY_SIZE = 1024;

    // RSA���������Ĵ�С

    /** Field description */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    // RSA���������Ĵ�С

    /** Field description */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
     * Method description
     *
     *
     * @param data
     * @param key
     *
     * @return
     *
     * @throws BadPaddingException
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static String decryptByPrivateKey(String data, String key)
            throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
                   IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] keybyte = Base64.decode(key);

        // ȡ��˽Կ PKCS8EncodedKeySpec��װ˽Կ����
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keybyte);
        KeyFactory          keyFactory   = KeyFactory.getInstance(KEY_ALGORITHM);

        // ����˽Կ
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // �����ݽ���
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);

        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[]                databyte = Base64.decode(data);
        int                   inputLen = databyte.length;
        ByteArrayOutputStream out      = new ByteArrayOutputStream();
        int                   offSet   = 0;
        byte[]                cache;
        int                   i = 0;

        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(databyte, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(databyte, offSet, inputLen - offSet);
            }

            out.write(cache);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }

        byte[] decbyte = out.toByteArray();
        String dec     = new String(decbyte);

        out.close();

        return dec;
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
     * @throws BadPaddingException
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static String decryptByPublicKey(String data, String key)
            throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
                   IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] keybyte = Base64.decode(key);

        // ȡ�ù�Կ X509EncodedKeySpec��װ��Կ����
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keybyte);
        KeyFactory         keyFactory  = KeyFactory.getInstance(KEY_ALGORITHM);

        // ���ɹ�Կ
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);

        // �����ݽ���
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);

        cipher.init(Cipher.DECRYPT_MODE, publicKey);

        byte[]                databyte = Base64.decode(data);
        int                   inputLen = databyte.length;
        ByteArrayOutputStream out      = new ByteArrayOutputStream();
        int                   offSet   = 0;
        byte[]                cache;
        int                   i = 0;

        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(databyte, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(databyte, offSet, inputLen - offSet);
            }

            out.write(cache);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }

        byte[] decbyte = out.toByteArray();
        String dec     = new String(decbyte);

        out.close();

        return dec;
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
     * @throws BadPaddingException
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static String encryptByPrivateKey(String data, String key)
            throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
                   IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] keybyte = Base64.decode(key);

        // ȡ��˽Կ PKCS8EncodedKeySpec��װ˽Կ����
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keybyte);
        KeyFactory          keyFactory   = KeyFactory.getInstance(KEY_ALGORITHM);

        // ����˽Կ
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // �����ݼ���
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);

        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        byte[]                databyte = data.getBytes();
        int                   inputLen = databyte.length;
        ByteArrayOutputStream out      = new ByteArrayOutputStream();
        int                   offSet   = 0;
        byte[]                cache;
        int                   i = 0;

        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(databyte, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(databyte, offSet, inputLen - offSet);
            }

            out.write(cache);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }

        byte[] encbyte = out.toByteArray();
        String enc     = Base64.encode(encbyte);

        out.close();

        return enc;
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
     * @throws BadPaddingException
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static String encryptByPublicKey(String data, String key)
            throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
                   IllegalBlockSizeException, BadPaddingException, IOException {
        byte[] keybyte = Base64.decode(key);

        // ȡ�ù�Կ X509EncodedKeySpec��װ��Կ����
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keybyte);
        KeyFactory         keyFactory  = KeyFactory.getInstance(KEY_ALGORITHM);

        // ���ɹ�Կ
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);

        // �����ݼ���
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);

        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[]                databyte = data.getBytes();
        int                   inputLen = databyte.length;
        ByteArrayOutputStream out      = new ByteArrayOutputStream();
        int                   offSet   = 0;
        byte[]                cache;
        int                   i = 0;

        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(databyte, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(databyte, offSet, inputLen - offSet);
            }

            out.write(cache);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }

        byte[] encbyte = out.toByteArray();
        String enc     = Base64.encode(encbyte);

        out.close();

        return enc;
    }

    /**
     * Method description
     *
     *
     * @return
     *
     * @throws NoSuchAlgorithmException
     */
    public static Map<String, String> generateKey() throws NoSuchAlgorithmException {

        // ʵ����ʵԿ��������
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);

        // ��ʼ����Կ��������
        keyPairGen.initialize(KEY_SIZE, new SecureRandom());

        // ������Կ��
        KeyPair keyPair = keyPairGen.generateKeyPair();

        // ��Կ
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        // ˽Կ
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        // ��װ��Կ
        Map<String, String> keyMap = new HashMap<String, String>(2);

        keyMap.put(PUBLIC_KEY, Base64.encode(publicKey.getEncoded()));
        keyMap.put(PRIVATE_KEY, Base64.encode(privateKey.getEncoded()));

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
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws SignatureException
     */
    public static String sign(String data, String privateKey)
            throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        byte[] privateKeyByte = Base64.decode(privateKey);

        // ת��˽Կ����
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKeyByte);

        // ʵ������Կ����
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // ȡ˽Կ����
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // ʵ����Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORRITHM);

        // ��ʼ��Signature
        signature.initSign(priKey);

        // ����
        signature.update(Base64.decode(data));

        // ǩ��
        byte[] signbyte = signature.sign();
        String signstr  = Base64.encode(signbyte);

        return signstr;
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
     * @throws InvalidKeyException
     * @throws InvalidKeySpecException
     * @throws NoSuchAlgorithmException
     * @throws SignatureException
     */
    public static boolean verify(String data, String publicKey, String sign)
            throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
        byte[] publicKeyByte = Base64.decode(publicKey);

        // ת�ӹ�Կ����
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKeyByte);

        // ʵ������Կ����
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // ���ɹ�Կ
        PublicKey pubKey = keyFactory.generatePublic(x509KeySpec);

        // ʵ����Signature
        Signature signature = Signature.getInstance(SIGNATURE_ALGORRITHM);

        // ��ʼ��Signature
        signature.initVerify(pubKey);

        // ����
        signature.update(Base64.decode(data));

        // ��֤
        boolean isVerify = signature.verify(Base64.decode(sign));

        return isVerify;
    }
}



