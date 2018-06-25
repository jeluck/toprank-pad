package cc.toprank.byd.common.utils.rsa;

import org.apache.log4j.Logger;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class DES {

    // public static final String DES_ALGORITHM = "DES/CBC/PKCS5Padding";
    // ������NoPaddingģʽ��data���ȱ�����8�ı���

    /** Field description */
    public static final String DES_ALGORITHM = "DES/CBC/NoPadding";

    /** Field description */
    private static Logger logger = Logger.getLogger(DES.class);

    /**
     * Method description
     *
     *
     * @param encryptData
     * @param keyData
     * @param ivData
     *
     * @return
     */
    public static final byte[] decryptCBC(byte[] encryptData, byte[] keyData, byte[] ivData) {
        byte[] plainData = null;

        try {
            Cipher                 cipher    = Cipher.getInstance(DES_ALGORITHM);
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(ivData);
            SecretKey              key       = new SecretKeySpec(keyData, "DES");    // key

            cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
            plainData = cipher.doFinal(encryptData);
        } catch (Exception e) {
            logger.error(e);
        }

        return plainData;
    }

    /**
     * Method description
     *
     *
     * @param plainData
     * @param keyData
     * @param ivData
     *
     * @return
     */
    public static final byte[] encryptCBC(byte[] plainData, byte[] keyData, byte[] ivData) {
        byte[] encryptData = null;

        try {
            Cipher                 cipher    = Cipher.getInstance(DES_ALGORITHM);
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(ivData);
            SecretKey              key       = new SecretKeySpec(keyData, "DES");    // key

            cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            encryptData = cipher.doFinal(plainData);
        } catch (Exception e) {
            logger.error(e);
        }

        return encryptData;
    }
}



