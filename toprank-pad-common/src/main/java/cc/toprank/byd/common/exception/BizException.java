package cc.toprank.byd.common.exception;

/**
 * Class description
 *
 * @author David
 * @version 2.0.0, 2017-01-12
 */
public class BizException extends RuntimeException {

    /**
     * Field description
     */
    private static final long serialVersionUID = -5875371379845226068L;

    /**
     * Field description
     */
    protected String msg;

    /**
     * Field description
     */
    protected int code = -1;

    /**
     * Constructs ...
     */
    public BizException() {
        super();
    }

    /**
     * Constructs ...
     *
     * @param message
     */
    public BizException(String message) {
        super(message);
        this.msg = message;
    }

    public BizException(String message, Object... objects) {
        super(message);
        this.msg = String.format(message, objects);
    }

    /**
     * Constructs ...
     *
     * @param cause
     */
    public BizException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs ...
     *
     * @param code
     * @param objects
     */
    public BizException(int code, Object... objects) {
        super(String.valueOf(code));
        this.code = code;

        String formatMsg = CommonErrorCode.getErrorMsg(code);

        this.msg = String.format(formatMsg, objects);
    }

    public static BizException error(int code, String msg) {
        throw new BizException(code, msg);
    }


    public static BizException error(String msg) {
        throw new BizException(-1, msg);
    }

    /**
     * Constructs ...
     *
     * @param message
     * @param cause
     */
    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs ...
     *
     * @param code
     * @param msg
     * @param objects
     */
    public BizException(int code, String msg, Object... objects) {
        super(String.format(msg, objects));
        this.code = code;
        this.msg = String.format(msg, objects);
    }

    /*
     *  (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "BizException [msg=" + msg + ", code=" + code + "]";
    }

    /**
     * Method description
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    @Override
    public String getLocalizedMessage() {
        return msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}



