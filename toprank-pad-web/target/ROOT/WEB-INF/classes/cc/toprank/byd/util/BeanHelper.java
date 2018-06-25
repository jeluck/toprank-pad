package cc.toprank.byd.util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * Created by HuTao on 2017-5-26.
 */
public class BeanHelper {

    public static void mapToBean(Object bean, Map properties) throws  Exception {
        BeanUtils.populate(bean,properties);
    }

}
