package cc.toprank.byd.common.utils.rsa;

import org.apache.log4j.Logger;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class RsaSign {

    /** Field description */
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /** Field description */
    private static Logger logger = Logger.getLogger(RsaSign.class);

    /**
     * Method description
     *
     *
     * @param content
     * @param sign
     * @param publicKey
     *
     * @return
     */
    public static boolean doCheck(String content, String sign, String publicKey) {
        try {
            KeyFactory              keyFactory = KeyFactory.getInstance("RSA");
            byte[]                  encodedKey = Base64.decode(publicKey);
            PublicKey               pubKey     = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            java.security.Signature signature  = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initVerify(pubKey);
            signature.update(content.getBytes("utf-8"));

            boolean bverify = signature.verify(Base64.decode(sign));

            return bverify;
        } catch (Exception e) {
            logger.error(e);
        }

        return false;
    }

    /**
     * Method description
     *
     *
     * @param content
     * @param privateKey
     *
     * @return
     */
    public static String sign(String content, String privateKey) {
        String charset = "utf-8";

        try {
            PKCS8EncodedKeySpec     priPKCS8  = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
            KeyFactory              keyf      = KeyFactory.getInstance("RSA");
            PrivateKey              priKey    = keyf.generatePrivate(priPKCS8);
            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(charset));

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        } catch (Exception e) {
            logger.error(e);
        }

        return null;
    }
}



