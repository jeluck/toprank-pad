
package cc.toprank.byd.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class CommonBizException extends BizException {

    /** Field description */
    private static final long serialVersionUID = 1L;

    /** Field description */
    private static final Logger log = LoggerFactory.getLogger(CommonBizException.class);

    /**
     * Constructs ...
     *
     */
    public CommonBizException() {}

    /**
     * Constructs ...
     *
     *
     * @param code
     * @param objects
     */
    public CommonBizException(int code, Object... objects) {
        super(code, objects);
    }

    /**
     * Constructs ...
     *
     *
     * @param code
     * @param msg
     * @param objects
     */
    public CommonBizException(int code, String msg, Object... objects) {
        super(code, msg, objects);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public CommonBizException print() {
        log.info("==>CommonBizException, code:" + this.code + ", msg:" + this.msg);

        return new CommonBizException(this.code, this.msg);
    }
}



