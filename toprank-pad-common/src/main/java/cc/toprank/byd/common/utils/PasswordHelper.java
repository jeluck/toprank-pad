
package cc.toprank.byd.common.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class PasswordHelper {

    /** Field description */
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    /** Field description */
    private String hashAlgorithmName = "md5";

    /** Field description */
    private int hashIterations = 1;

    /**
     * Method description
     *
     *
     * @return
     */
    public String createSalt() {
        return randomNumberGenerator.nextBytes().toHex();
    }

    /**
     * Method description
     *
     *
     * @param password
     * @param salt
     *
     * @return
     */
    public String encryptPassword(String password, String salt) {
        String newPassword = new SimpleHash(hashAlgorithmName,
                                            password,
                                            ByteSource.Util.bytes(salt),
                                            hashIterations).toHex();

        return newPassword;
    }

    /**
     * Method description
     *
     *
     * @param hashAlgorithmName
     */
    public void setHashAlgorithmName(String hashAlgorithmName) {
        this.hashAlgorithmName = hashAlgorithmName;
    }

    /**
     * Method description
     *
     *
     * @param hashIterations
     */
    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }

    /**
     * Method description
     *
     *
     * @param randomNumberGenerator
     */
    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }
}



