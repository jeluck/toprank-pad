package cc.toprank.byd.web.mvc;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import org.springframework.core.convert.TypeDescriptor;
import org.springframework.format.support.DefaultFormattingConversionService;

/**
 * @author LinYN
 * @date 2017-5-12
 */
public class CustomConversionService extends DefaultFormattingConversionService {

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if ("null".equals(source) || "undefined".equals(source)) {
            return null;
        }
        return super.convert(source, sourceType, targetType);
    }
}
