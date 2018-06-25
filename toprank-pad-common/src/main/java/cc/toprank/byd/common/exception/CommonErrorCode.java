
package cc.toprank.byd.common.exception;


import org.apache.commons.lang3.StringUtils;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class CommonErrorCode {

    /** Field description */
    public static final int ERROR = -2;    // ����ʧ��ȫ�ֶ���

    /** Field description */
    public static final int SESSION_OUT_TIME = -1;    // �û���ʱ,���߳�

    /** Field description */
    public static final int QRCODE_TIME_OUT = -3;    // ��ά�볬ʱʧЧ

    /** Field description */
    public static final int QRCODE_WAITING = -4;    // ��ά��ȴ�

    /** Field description */
    public static final int MEMBER_AUTH = -5;    // �û���֤

    /** Field description */
    public static final int SUCCESSFUL = 10000000;    // �����ɹ�ȫ�ֶ���

    /** Field description */
    public static final int IS_NULL = 10000001;    // ����������ѯ���ն���,�����Ϊ�ն���

    /** Field description */
    public static final int PARAMS_ERROR = 10000002;    // ����Ĳ�������

    /** Field description */
    public static final int DB_INSERT_RESULT_0 = 10000003;    // ���ݿ����,insert����0

    /** Field description */
    public static final int DB_UPDATE_RESULT_0 = 10000004;    // ���ݿ����,update����0

    /** Field description */
    public static final int DB_SELECTONE_IS_NULL = 10000005;

    /** Field description */
    public static final int DB_LIST_IS_NULL = 10000006;

    /** Field description */
    public static final int TOKEN_IS_ILLICIT = 10000007;

    /** Field description */
    public static final int DB_DELETE_RESULT_0 = 10000008;

    /** Field description */
    public static final int SORT_VALID_MIN = 10000009;

    /** Field description */
    public static final int SORT_VALID_MAX = 10000010;

    /** Field description */
    public static final int BEAN_REQUIRED_IS_NULL = 10000011;

    /** Field description */
    public static final int FORM_VALIDATE_NOT_PASS = 10000012;

    /** Field description */
    public static final int FORM_VALIDATE_PASS = 10000013;

    /**
     * Method description
     *
     *
     * @param code
     *
     * @return
     */
    public static final String getErrorMsg(int code) {

        // ��ȡ������Ϣ
        String msg = System.getProperty(String.valueOf(code));

        if (StringUtils.isBlank(msg)) {
            return "���ݴ���Ĵ�����[" + code + "]û���ҵ���Ӧ�Ĵ�����Ϣ.";
        }

        return msg;
    }
}



