
package cc.toprank.byd.common.validator;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.exception.CommonErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.*;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
@Service("beanValidator")
public class BeanValidator {

    /** Field description */
    private final String[] EXCLUDE = {
        "message", "groups", "payload", "hashCode", "annotaionType", "equals", "toString"
    };

    /** Field description */
    private final List<String> EXCLUDE_LIST = new ArrayList<>();

    /** Field description */
    private Logger logger = LoggerFactory.getLogger(BeanValidator.class);

    /** Field description */
    @Autowired(required = false)
    LocalValidatorFactoryBean validator;

    {
        Collections.addAll(EXCLUDE_LIST, EXCLUDE);
    }

    /**
     * Method description
     *
     *
     * @param fmtStr
     * @param map
     *
     * @return
     *
     * @throws Exception
     */
    private String format(String fmtStr, Map<String, Object> map) throws Exception {
        if ((map == null) || (map.size() <= 0)) {
            return fmtStr;
        }

        StringBuilder sb     = new StringBuilder(fmtStr);
        String        key    = "";    // Ҫ�滻��key
        Object[]      values = new Object[map.size()];
        int           index  = 0;     // �ҵ�����

        for (String e : map.keySet()) {
            key = "{" + e + "}";

            int startIndexOf = sb.indexOf(key);                 // �ҵ���ǰkey���ַ����е�����,Ҳ��Ϊ�滻��ʼ�ı�ʶ

            if (startIndexOf < 0) {                             // ���û���ҵ���Ӧkey,���¸�
                continue;
            }

            int    endIndexOf = startIndexOf + key.length();    // ������ʶ
            String fromatKey  = "{" + index + "}";

            sb            = sb.replace(startIndexOf, endIndexOf, fromatKey);
            values[index] = map.get(e);

            // �������к�
            index++;
        }

        return MessageFormat.format(sb.toString(), values);
    }

    /**
     * Method description
     *
     *
     * @param parameter
     *
     * @return
     */
    private String removeCurlyBraces(String parameter) {
        return parameter.substring(1, parameter.length());
    }

    /**
     * Method description
     *
     *
     * @param t
     * @param validationHints
     * @param <T>
     *
     * @return
     *
     * @throws BizException
     */
    public <T> ResponseError validator(T t, Object... validationHints) throws BizException {
        Errors errors = new BindException(t, t.getClass().getName());

        validator.validate(t, errors, validationHints);

        int                 value         = CommonErrorCode.ERROR;
        String              defMesg       = "";
        Map<String, Object> fromatMap     = new Hashtable<>();    // ��Ҫ��ʽ��������
        ResponseError       reqsonseError = new ResponseError(CommonErrorCode.SUCCESSFUL,
                                                              getErrorMsg(CommonErrorCode.SUCCESSFUL),
                                                              true);

        // �ж��Ƿ�У��ͨ��
        if (errors.hasErrors()) {

            // ��ȡ��һ��������Ϣ
            FieldError error = errors.getFieldErrors().get(0);

            defMesg = error.getDefaultMessage();

            try {
                Object mvalue = defMesg;

                if (mvalue != null) {
                    if (mvalue.toString().startsWith("#")) {
                        String code = removeCurlyBraces(mvalue.toString());

                        if (code != null) {

                            // ��ȡ����������Ϣ�������
                            value   = Integer.parseInt(code);
                            defMesg = getErrorMsg(value);

                            // ��ʽ���ַ���
                            Annotation[] annotations = t.getClass().getDeclaredField(error.getField()).getAnnotations();

                            fromatMap = getFromatMap(annotations, error.getCode());

                            // ��ʼ��ʽ��
                            defMesg = format(defMesg, fromatMap);
                        }
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                reqsonseError.setMsg(e.getMessage());
                reqsonseError.setCode(value);
                reqsonseError.setSuccessful(false);

                return reqsonseError;
            }

            String msg = "����У��ʧ��:" + value + "," + t.getClass().getName() + " " + error.getField() + ","
                         + error.getCode() + "," + defMesg;

            logger.error(msg);
            reqsonseError.setMsg(defMesg);
            reqsonseError.setCode(value);
            reqsonseError.setSuccessful(false);
        }

        return reqsonseError;
    }

    /**
     * Method description
     *
     *
     * @param code
     *
     * @return
     */
    private String getErrorMsg(int code) {
        return CommonErrorCode.getErrorMsg(code);
    }

    /**
     * Method description
     *
     *
     * @param annotations
     * @param codes
     *
     * @return
     *
     * @throws Exception
     */
    private Map<String, Object> getFromatMap(Annotation[] annotations, String codes) throws Exception {
        Map<String, Object> fromatMap = new Hashtable<>();    // ������÷�����ֵ

        for (Annotation a : annotations) {

            // ��ȡע������ֲ��ж��ǲ��Ƿ��ش�����Ϣ�����ע��
            String simpleName = a.annotationType().getSimpleName();

            if (simpleName.equals(codes)) {
                Method[] methods = a.annotationType().getMethods();

                for (Method m : methods) {
                    String mname = m.getName();    // �õ�������

                    if (!EXCLUDE_LIST.contains(m.getName())) {
                        Object invokeValue = m.invoke(a);

                        fromatMap.put(mname, invokeValue);
                    }
                }
            }
        }

        return fromatMap;
    }
}



