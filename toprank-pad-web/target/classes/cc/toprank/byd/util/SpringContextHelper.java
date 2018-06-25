/**    
* @Title: SpringUtils.java  
* @Package cc.toprank.byd.pad.utils  
* @Description: TODO(用一句话描述该文件做什么)  
* @author Lish
* @date 2017年1月18日 下午3:38:19  
* @version V1.0    
*/
package cc.toprank.byd.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author LiSH
 *
 */
@Component
public class SpringContextHelper implements ApplicationContextAware {
	 private static ApplicationContext applicationContext; // Spring应用上下文环境

     /*
      * 实现了ApplicationContextAware 接口，必须实现该方法；
      *通过传递applicationContext参数初始化成员变量applicationContext
      */
     @Override
     public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    	 this.applicationContext = applicationContext;
     }

     public static ApplicationContext getApplicationContext() {
            return applicationContext;
     }

      public static <T> T getBean(String name) throws BeansException {
                 return (T) applicationContext.getBean(name);
       }
}
