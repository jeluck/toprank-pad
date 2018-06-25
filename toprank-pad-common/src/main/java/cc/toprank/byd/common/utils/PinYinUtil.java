package cc.toprank.byd.common.utils;

import cc.toprank.byd.common.utils.string.StringUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class PinYinUtil {

    /** Field description */
    private static final Logger LOGGER = LoggerFactory.getLogger(PinYinUtil.class);

    /**
     * Method description
     *
     *
     * @param chines
     *
     * @return
     */
    public static String converToPinYin(String chines) {
        if (StringUtil.isNotNull(chines)) {
            StringBuffer sb;

            try {
                sb = new StringBuffer();

                HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();

                defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
                defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

                for (int i = 0; i < chines.length(); i++) {
                    char c = chines.charAt(i);

                    if (c > 128) {

                        // ȡ�õ�ǰ���ֵ�ƴ��
                        String[] pinyins = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);

                        if (pinyins == null) {
                            continue;
                        }

                        // ������������ȡ��һ��
                        sb.append(pinyins[0]);
                    } else {
                        sb.append(c);
                    }
                }

                return sb.toString();
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                LOGGER.error("����ת��Ϊƴ������:{}", e.getMessage());

                return "";
            }
        } else {
            return "";
        }
    }

    /**
     * Method description
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(PinYinUtil.converToPinYin("��ԴABC"));
    }
}



