
package cc.toprank.byd.common.validator;

import cc.toprank.byd.common.entity.AjaxResponse;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class ResponseError extends AjaxResponse {

    /** Field description */
    private boolean successful;

    /**
     * Constructs ...
     *
     *
     * @param code
     * @param msg
     * @param successful
     */
    public ResponseError(int code, String msg, boolean successful) {
        super(code, msg, null);
        this.successful = successful;
    }

    /**
     * Method description
     *
     *
     * @param code
     */
    public void setCode(int code) {
        super.code = code;
    }

    /**
     * Method description
     *
     *
     * @param msg
     */
    public void setMsg(String msg) {
        super.msg = msg;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     * Method description
     *
     *
     * @param successful
     */
    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}



