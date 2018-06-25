package cc.toprank.byd.web.constant;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.MapHelper;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.pagehelper.Page;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * app接口返回数据对象
 *
 * @author 李俊
 * @version 1.0
 * @Time 2016年6月13日 下午5:52:56
 * @Description ResultData
 */
@JsonInclude(Include.NON_NULL)
public class ResultData implements Serializable {

    private static final long serialVersionUID = 4489750999183582487L;
    private static Logger logger = LoggerFactory.getLogger(ResultData.class);

    /**
     * 执行出错描述
     */
    private String msg;

    /**
     * 执行结果 ID Code
     */
    private int code;

    /**
     * 执行返回数据
     */
    private Object data;

    /**
     * 时间戳
     */
    private Long timestamp = System.currentTimeMillis();

    /**
     * 数据总页数
     */
    private Integer pages = null;

    /**
     * 数据总条数
     */
    private Long total = null;

    public static ResultData makeResult(boolean isOk) {
        if (isOk) {
            return makeSuccessResult();
        } else {
            return makeFailResult();
        }
    }

    public static ResultData makeResult(Object data) {
        if (data instanceof Page) {
            Page page = null;
            try {
                page = (Page) data;
            } catch (Exception e) {
                logger.warn("list cast page error.", e);
                return makeSuccessResult(data);
            }
            if (!page.isEmpty()) {
                return makeSuccessResult(data, page.getTotal(), page.getPages());
            } else {
                return makeFailResult(CodeMsgConstants.NODATA);
            }
        } else if (data instanceof List) {
            if (!((List) data).isEmpty()) {
                return makeSuccessResult(data);
            } else {
                return makeFailResult(CodeMsgConstants.NODATA);
            }
        } else if (data instanceof Map) {
            if (MapUtils.isNotEmpty((Map) data)) {
                return makeSuccessResult(data);
            } else {
                return makeFailResult(CodeMsgConstants.NODATA);
            }
        } else {
            if (data != null) {
                return makeSuccessResult(data);
            } else {
                return makeFailResult(CodeMsgConstants.NODATA);
            }
        }

    }

    public static ResultData makeFailResult() {
        ResultData resultData = new ResultData(CodeMsgConstants.FAIL);
        return resultData;
    }

    public static ResultData makeFailResult(String message) {
        ResultData resultData = new ResultData(CodeMsgConstants.FAIL, message);
        return resultData;
    }

    public static ResultData makeFailResult(int code, String message) {
        ResultData resultData = new ResultData(code, message);
        return resultData;
    }

    public static ResultData makeFailResult(int code) {
        ResultData resultData = new ResultData(code);
        return resultData;
    }

    public static ResultData makeFailResult(Throwable e, boolean flag) {
        ResultData resultData = new ResultData();
        resultData.setCode(-1);
        resultData.setMessage(e.getMessage());
        if (flag) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.toString());
            for (StackTraceElement s : e.getStackTrace()) {
                sb.append(s);
            }
            JSONObject error = new JSONObject();
            error.put("error", sb.toString());
            resultData.setData(error);
        }
        return resultData;
    }

    public static ResultData makeFailResult(Throwable e, boolean flag, Object param) {
        ResultData resultData = new ResultData();
        int code = -1;
        String msg;
        if (e instanceof BizException) {
            code = ((BizException) e).getCode();
            msg = e.getMessage();
        } else {
            msg = "哎呀，系统君开小差了~";
        }
        resultData.setCode(code);
        resultData.setMessage(msg);
        if (flag) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.toString());
            for (StackTraceElement s : e.getStackTrace()) {
                sb.append(s);
            }
            JSONObject error = new JSONObject();
            error.put("param", param);
            error.put("error", sb.toString());
            Map<String, Object> errorMap = MapHelper.put("param", param).put("error", sb).toMap();
            resultData.setData(error);
        }
        return resultData;
    }

    public static ResultData makeSuccessResult(Object data) {
        ResultData resultData = new ResultData(CodeMsgConstants.SUCCESS, data);
        return resultData;
    }

    public static ResultData makeSuccessResult(Object data, long total, int pages) {
        ResultData resultData = new ResultData(CodeMsgConstants.SUCCESS, data);
        resultData.setTotal(total);
        resultData.setPages(pages);
        return resultData;
    }

    public static ResultData makeSuccessResult() {
        ResultData resultData = new ResultData(CodeMsgConstants.SUCCESS, "true");
        return resultData;
    }

    public static ResultData makeSuccessResult(String message) {
        ResultData resultData = new ResultData(CodeMsgConstants.SUCCESS, message, "true");
        return resultData;
    }

    public void setCode(int code) {
        this.code = code;
        this.msg = getErrorMsg(code);
    }

    /**
     * 通过code值反射出msg的值
     *
     * @param val
     * @return
     * @Time 2016年6月20日 下午5:09:18
     * @author 李俊
     */
    public static String getErrorMsg(int val) {
        String errorInfo = "";
        Class cls = null;
        try {
            cls = Class.forName(CodeMsgConstants.class.getName());
            Object obj = cls.newInstance();
            Field fields[] = cls.getFields();
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].get(obj).equals(val)) {
                    String fieldName = fields[i].getName();
                    errorInfo = cls.getField(fieldName + "_MSG").get(obj).toString();
                    break;
                }
            }
        } catch (Exception e) {
            errorInfo = "";
            logger.error("通过code反射出msg的值出错.code:" + val, e);
        }
        return errorInfo;
    }

    public ResultData() {
        super();
    }

    public ResultData(int code) {
        this.setCode(code);
    }

    public ResultData(int code, Object data) {
        this.setCode(code);
        this.data = data;
    }

    public ResultData(int code, String message) {
        this.code = code;
        this.data = message;
    }

    public ResultData(int code, String message, Object data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

    public int getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        StringBuilder resultSB = new StringBuilder();
        resultSB.append("success data => " + data + "\t");
        resultSB.append("error message => " + msg + "\t");
        resultSB.append("return code  => " + code + "\t");
        resultSB.append("pages  => " + pages);
        resultSB.append("timestamp  => " + timestamp);
        return resultSB.toString();
    }

}
