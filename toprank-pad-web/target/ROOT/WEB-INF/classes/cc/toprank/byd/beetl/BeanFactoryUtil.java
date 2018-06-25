package cc.toprank.byd.beetl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;


public class BeanFactoryUtil implements BeanFactoryAware {

    protected static volatile BeanFactory _beanFactory;

    public static <T> T findBean(Class<T> clazz) {
        return _beanFactory.getBean(clazz);
    }

    public static Object findBean(String name) {
        return _beanFactory.getBean(name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        _beanFactory = beanFactory;
    }
}
