package cc.toprank.byd.web.listener;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * 系统启动时调用
 *
 * @author LinYN
 * @since 2017-3-29
 */
public class SystemConfigListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        registerConverters();

    }

    // 注册转换器
    private void registerConverters() {
        ConvertUtils.register(new BigDecimalConverter(new BigDecimal(0)), BigDecimal.class);
        ConvertUtils.register(new BigIntegerConverter(0), BigInteger.class);
        ConvertUtils.register(new LongConverter(null), Long.class);
        ConvertUtils.register(new DateConverter(null), java.util.Date.class);
        ConvertUtils.register(new SqlDateConverter(null), java.sql.Date.class);
        ConvertUtils.register(new SqlTimeConverter(null), java.sql.Time.class);
        ConvertUtils.register(new SqlTimestampConverter(null), Timestamp.class);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
