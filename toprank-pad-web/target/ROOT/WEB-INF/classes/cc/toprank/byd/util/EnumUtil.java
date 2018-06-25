package cc.toprank.byd.util;

import cc.toprank.byd.enums.CommonManageEnum;
import org.apache.commons.lang3.EnumUtils;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author LeeJun
 * @create 2017-05-22 16:58
 */
public class EnumUtil {
    /**
     * @author Zhaolingcen
     * @version 2.0.0
     * @description 根据枚举值获取枚举name
     * @time 2017-05-31 11:00:00
     */
    public static String getEnumNmae(Class clazz, Long code) throws Exception {
        Method valuesMethod = clazz.getMethod("values");
        Object[] enumTypes = (Object[]) valuesMethod.invoke(clazz);
        for (Object enumType : enumTypes) {
            Long value = (Long) enumType.getClass().getMethod("getValue").invoke(enumType);
            if (code.equals(value)) {
                return (String) enumType.getClass().getMethod("getName").invoke(enumType);
            }
        }
        return null;
    }
}
