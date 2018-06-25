/**
 * @Title: MaxIDUtils.java
 * @Package cc.toprank.byd.pad.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author Lish
 * @date 2017年1月18日 下午3:05:59
 * @version V1.0
 */
package cc.toprank.byd.util;

import cc.toprank.byd.util.SpringContextHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import cc.toprank.byd.service.SystemMaxIDService;

/**
 * @author LiSH
 */
public class MaxIDUtils {

    @Autowired
    SqlSessionFactory sqlSessionFactory;





    @Lazy
    private static SystemMaxIDService maxIDService = SpringContextHelper.getBean("systemMaxIDService");

    public static Long getID(Class clazz) {
        String name = clazz.getName();
        String[] split = name.split("\\.");
        name = split[split.length - 1].replace("Entity", "");
        return maxIDService.getMaxID(name);
    }

    public static Long getID(Object o) {
        return getID(o.getClass());
    }

    public static Long getID(String tableName) {
        return maxIDService.getMaxID(tableName);
    }

}
