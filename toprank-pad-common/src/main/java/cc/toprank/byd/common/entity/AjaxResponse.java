package cc.toprank.byd.common.entity;

import cc.toprank.byd.common.exception.CommonErrorCode;

import java.io.Serializable;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class AjaxResponse implements Serializable {

    /** Field description */
    private static final long serialVersionUID = -2792556188993845048L;

    /** Field description */
    protected int code;

    /** Field description */
    protected String msg;

    /** Field description */
    private Object data;

    /**
     * Constructs
     *
     * @param code
     * @param msg
     * @param data
     */
    protected AjaxResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg  = msg;
        this.data = data;
    }

    /**
     * Method description
     *
     *
     * @param msg
     *
     * @return
     */
    public static AjaxResponse error(String msg) {
        return error(CommonErrorCode.ERROR, msg);
    }

    /**
     * Method description
     *
     *
     * @param code
     * @param msg
     *
     * @return
     */
    public static AjaxResponse error(int code, String msg) {
        return get(code, msg, null);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static AjaxResponse success() {
        return success("");
    }

    /**
     * Method description
     *
     *
     * @param data
     *
     * @return
     */
    public static AjaxResponse success(Object data) {
        return success(null, data);
    }

    /**
     * Method description
     *
     *
     * @param msg
     *
     * @return
     */
    public static AjaxResponse success(String msg) {
        return success(msg, null);
    }

    /**
     * Method description
     *
     *
     * @param msg
     * @param data
     *
     * @return
     */
    public static AjaxResponse success(String msg, Object data) {
        return get(CommonErrorCode.SUCCESSFUL, msg, data);
    }

    @Override
    public String toString() {
        return "AjaxResponse [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public Object getData() {
        return data;
    }

    /**
     * Method description
     *
     *
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Method description
     *
     *
     * @param code
     * @param msg
     * @param data
     *
     * @return
     */
    public static AjaxResponse get(int code, String msg, Object data) {
        return new AjaxResponse(code, msg, data);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }
}



