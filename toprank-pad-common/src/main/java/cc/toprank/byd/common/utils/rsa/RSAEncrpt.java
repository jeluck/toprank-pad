package cc.toprank.byd.common.utils.rsa;

import org.apache.log4j.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class RSAEncrpt {

    /** Field description */
    private static final char[] HEX_CHAR = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    /** Field description */
    private static Logger logger = Logger.getLogger(RSAEncrpt.class);

    /** Field description */
    private RSAPrivateKey privateKey;

    /** Field description */
    private RSAPublicKey publicKey;

    /**
     * Method description
     *
     *
     * @param data
     *
     * @return
     */
    public static String byteArrayToString(byte[] data) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < data.length; i++) {

            // ȡ���ֽڵĸ���λ ��Ϊ�����õ���Ӧ��ʮ�����Ʊ�ʶ�� ע���޷�������
            stringBuilder.append(HEX_CHAR[(data[i] & 0xf0) >>> 4]);

            // ȡ���ֽڵĵ���λ ��Ϊ�����õ���Ӧ��ʮ�����Ʊ�ʶ��
            stringBuilder.append(HEX_CHAR[(data[i] & 0x0f)]);

            if (i < data.length - 1) {
                stringBuilder.append(' ');
            }
        }

        return stringBuilder.toString();
    }

    /**
     * Method description
     *
     *
     * @param privateKey
     * @param cipherData
     *
     * @return
     *
     * @throws Exception
     */
    public byte[] deEncryptBigData(RSAPrivateKey privateKey, byte[] cipherData) throws Exception {
        byte[][] splitedData    = ByteManager.spliteByteArray(cipherData);
        byte[][] encryptSplited = new byte[splitedData.length][];

        for (int i = 0; i < splitedData.length; i++) {
            encryptSplited[i] = decrypt(privateKey, splitedData[i]);
        }

        byte[] plainData = ByteManager.getIntegrationBytes(encryptSplited);

        return plainData;
    }

    /**
     * Method description
     *
     *
     * @param privateKey
     * @param cipherData
     *
     * @return
     *
     * @throws Exception
     */
    public byte[] decrypt(RSAPrivateKey privateKey, byte[] cipherData) throws Exception {
        if (privateKey == null) {
            throw new Exception("����˽ԿΪ��, ������");
        }

        Cipher cipher = null;

        try {
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] output = cipher.doFinal(cipherData);

            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("�޴˽����㷨");
        } catch (NoSuchPaddingException e) {
            logger.error(e);

            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("����˽Կ�Ƿ�,����");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("���ĳ��ȷǷ�");
        } catch (BadPaddingException e) {
            throw new Exception("������������");
        }
    }

    /**
     * Method description
     *
     *
     * @param publicKey
     * @param plainTextData
     *
     * @return
     *
     * @throws Exception
     */
    public byte[] encrypt(RSAPublicKey publicKey, byte[] plainTextData) throws Exception {
        Cipher cipher = null;

        if (publicKey == null) {
            throw new Exception("���ܹ�ԿΪ��, ������");
        }

        try {
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] output = cipher.doFinal(plainTextData);

            return output;
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("�޴˼����㷨");
        } catch (NoSuchPaddingException e) {
            logger.error(e);

            return null;
        } catch (InvalidKeyException e) {
            throw new Exception("���ܹ�Կ�Ƿ�,����");
        } catch (IllegalBlockSizeException e) {
            throw new Exception("���ĳ��ȷǷ�");
        } catch (BadPaddingException e) {
            throw new Exception("������������");
        }
    }

    /**
     * Method description
     *
     *
     * @param publicKey
     * @param plainTextData
     *
     * @return
     *
     * @throws Exception
     */
    public byte[] encryptBigData(RSAPublicKey publicKey, byte[] plainTextData) throws Exception {
        byte[][] splitedData    = ByteManager.spliteByteArray(plainTextData);
        byte[][] encryptSplited = new byte[splitedData.length][];

        for (int i = 0; i < splitedData.length; i++) {
            encryptSplited[i] = encrypt(publicKey, splitedData[i]);
        }

        byte[] encryptData = ByteManager.getIntegrationBytes(encryptSplited);

        return encryptData;
    }

    /**
     * Method description
     *
     */
    public void genKeyPair() {
        KeyPairGenerator keyPairGen = null;

        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            logger.error(e);
        }

        keyPairGen.initialize(1024, new SecureRandom());

        KeyPair keyPair = keyPairGen.generateKeyPair();

        this.privateKey = (RSAPrivateKey) keyPair.getPrivate();
        this.publicKey  = (RSAPublicKey) keyPair.getPublic();
    }

    /**
     * Method description
     *
     *
     * @param in
     *
     * @throws Exception
     */
    public void loadPrivateKey(InputStream in) throws Exception {
        try {
            BufferedReader br       = new BufferedReader(new InputStreamReader(in));
            String         readLine = null;
            StringBuilder  sb       = new StringBuilder();

            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }

            loadPrivateKey(sb.toString());
        } catch (IOException e) {
            throw new Exception("˽Կ���ݶ�ȡ����");
        } catch (NullPointerException e) {
            throw new Exception("˽Կ������Ϊ��");
        }
    }

    /**
     * Method description
     *
     *
     * @param privateKeyStr
     *
     * @throws Exception
     */
    public void loadPrivateKey(String privateKeyStr) throws Exception {
        try {
            byte[]              buffer     = Base64.decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec    = new PKCS8EncodedKeySpec(buffer);
            KeyFactory          keyFactory = KeyFactory.getInstance("RSA");

            this.privateKey = (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("�޴��㷨");
        } catch (InvalidKeySpecException e) {
            throw new Exception("˽Կ�Ƿ�");
        } catch (NullPointerException e) {
            throw new Exception("˽Կ����Ϊ��");
        }
    }

    /**
     * Method description
     *
     *
     * @param in
     *
     * @throws Exception
     */
    public void loadPublicKey(InputStream in) throws Exception {
        try {
            BufferedReader br       = new BufferedReader(new InputStreamReader(in));
            String         readLine = null;
            StringBuilder  sb       = new StringBuilder();

            while ((readLine = br.readLine()) != null) {
                if (readLine.charAt(0) == '-') {
                    continue;
                } else {
                    sb.append(readLine);
                    sb.append('\r');
                }
            }

            loadPublicKey(sb.toString());
        } catch (IOException e) {
            throw new Exception("��Կ��������ȡ����");
        } catch (NullPointerException e) {
            throw new Exception("��Կ������Ϊ��");
        }
    }

    /**
     * Method description
     *
     *
     * @param publicKeyStr
     *
     * @throws Exception
     */
    public void loadPublicKey(String publicKeyStr) throws Exception {
        try {
            byte[]             buffer     = Base64.decode(publicKeyStr);
            KeyFactory         keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec    = new X509EncodedKeySpec(buffer);

            this.publicKey = (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("�޴��㷨");
        } catch (InvalidKeySpecException e) {
            throw new Exception("��Կ�Ƿ�");
        } catch (NullPointerException e) {
            throw new Exception("��Կ����Ϊ��");
        }
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public RSAPrivateKey getPrivateKey() {
        return privateKey;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public RSAPublicKey getPublicKey() {
        return publicKey;
    }
}



