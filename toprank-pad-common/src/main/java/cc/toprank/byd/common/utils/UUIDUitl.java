package cc.toprank.byd.common.utils;

import java.util.Random;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class UUIDUitl {

    /** Field description */
    public static final String allCharStr =
        "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()_+";

    /** Field description */
    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /** Field description */
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /** Field description */
    public static final String numberChar = "0123456789";

    /** Field description */
    public static final String specialChar = "!@#$%^&*()_+";

    /**
     * Method description
     *
     *
     * @param length
     *
     * @return
     */
    public static String generateAllString(int length) {
        StringBuffer sb     = new StringBuffer();
        Random       random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(allCharStr.charAt(random.nextInt(allCharStr.length())));
        }

        return sb.toString();
    }

    /**
     * Method description
     *
     *
     * @param length
     *
     * @return
     */
    public static String generateLowerString(int length) {
        return generateMixString(length).toLowerCase();
    }

    /**
     * Method description
     *
     *
     * @param length
     *
     * @return
     */
    public static String generateMixString(int length) {
        StringBuffer sb     = new StringBuffer();
        Random       random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(letterChar.charAt(random.nextInt(letterChar.length())));
        }

        return sb.toString();
    }

    /**
     * Method description
     *
     *
     * @param length
     *
     * @return
     */
    public static String generateNum(int length) {
        StringBuffer sb     = new StringBuffer();
        Random       random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
        }

        return sb.toString();
    }

    /**
     * Method description
     *
     *
     * @param len
     *
     * @return
     */
    public static String generateNumAllLetter(int len) {
        if (len < 3) {
            throw new IllegalArgumentException("�ַ������Ȳ���С��3");
        }

        // ���飬���ڴ������ַ�
        char[] chArr = new char[len];

        // Ϊ�˱�֤����������֡���Сд��ĸ
        chArr[0] = (char) ('0' + StdRandom.uniform(0, 10));
        chArr[1] = (char) ('A' + StdRandom.uniform(0, 26));
        chArr[2] = (char) ('a' + StdRandom.uniform(0, 26));

        char[] codes = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
            'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };

        // charArr[3..len-1]�������codes�е��ַ�
        for (int i = 3; i < len; i++) {
            chArr[i] = codes[StdRandom.uniform(0, codes.length)];
        }

        // ������chArr�������
        for (int i = 0; i < len; i++) {
            int  r    = i + StdRandom.uniform(len - i);
            char temp = chArr[i];

            chArr[i] = chArr[r];
            chArr[r] = temp;
        }

        return new String(chArr);
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static String generatePwdStr() {
        StringBuffer sb     = new StringBuffer();
        Random       random = new Random();

        for (int i = 0; i < 3; i++) {
            sb.append(allChar.charAt(random.nextInt(letterChar.length())));
            sb.append(numberChar.charAt(random.nextInt(numberChar.length())));
        }

        for (int i = 0; i < 2; i++) {
            sb.append(specialChar.charAt(random.nextInt(specialChar.length())));
        }

        return sb.toString();
    }

    /**
     * Method description
     *
     *
     * @param length
     *
     * @return
     */
    public static String generateString(int length) {
        StringBuffer sb     = new StringBuffer();
        Random       random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(allChar.charAt(random.nextInt(allChar.length())));
        }

        return sb.toString();
    }

    /**
     * Method description
     *
     *
     * @param length
     *
     * @return
     */
    public static String generateUpperString(int length) {
        return generateMixString(length).toUpperCase();
    }

    /**
     * Method description
     *
     *
     * @param length
     *
     * @return
     */
    public static String generateZeroString(int length) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            sb.append('0');
        }

        return sb.toString();
    }

    /**
     * Method description
     *
     *
     * @param num
     * @param fixdlenth
     *
     * @return
     */
    public static String toFixdLengthString(int num, int fixdlenth) {
        StringBuffer sb     = new StringBuffer();
        String       strNum = String.valueOf(num);

        if (fixdlenth - strNum.length() >= 0) {
            sb.append(generateZeroString(fixdlenth - strNum.length()));
        } else {
            throw new RuntimeException("������" + num + "ת��Ϊ����Ϊ��" + fixdlenth + "���ַ��������쳣��");
        }

        sb.append(strNum);

        return sb.toString();
    }

    /**
     * Method description
     *
     *
     * @param num
     * @param fixdlenth
     *
     * @return
     */
    public static String toFixdLengthString(long num, int fixdlenth) {
        StringBuffer sb     = new StringBuffer();
        String       strNum = String.valueOf(num);

        if (fixdlenth - strNum.length() >= 0) {
            sb.append(generateZeroString(fixdlenth - strNum.length()));
        } else {
            throw new RuntimeException("�����֣�" + num + "ת��Ϊ����Ϊ" + fixdlenth + "���ַ��������쳣��");
        }

        sb.append(strNum);

        return sb.toString();
    }
}



