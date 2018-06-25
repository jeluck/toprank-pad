package cc.toprank.byd.web.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cc.toprank.byd.common.utils.string.StringUtil;
import cc.toprank.byd.web.annotation.PathFilterAnno;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class PathUrlUtils {

    /** Field description */
    private static final Logger LOGGER = LoggerFactory.getLogger(PathUrlUtils.class);

    /** Field description */
    public static final String urlPostfix = ".shtml";

    /** Field description */
    private static List<String> paths = new ArrayList<>();

    /** Field description */
    private static List<String> logins = new ArrayList<>();

    /** Field description */
    private static List<String> auths = new ArrayList<>();

    /** Field description */
    private List<String> mappings;

    /**
     * Method description
     *
     *
     * @throws ClassNotFoundException
     */
    private void init() throws ClassNotFoundException {
        LOGGER.info("===��ʼ ��ȡ����controller��·��===");

        if (CollectionUtils.isEmpty(mappings)) {
            throw new RuntimeException("��������Ŀcontroller����·��");
        }

        for (String mapping : mappings) {
            LOGGER.info("·�����õ�controller:{}", mapping);

            Class<?> clazz    = Class.forName(mapping);
            String   basePath = parseBasePath(clazz);

            for (Method method : clazz.getDeclaredMethods()) {
                String pathUrl = mergeUrl(basePath, parseUrl(method));

                if (StringUtil.isNotBlank(pathUrl) &&!paths.contains(pathUrl)) {
                    paths.add(pathUrl);
                }

                // �ж��Ƿ���Ҫ���ص�¼������֤
                if (isLogin(method) &&!logins.contains(pathUrl)) {
                    logins.add(pathUrl);
                }

                if (isAuth(method) &&!auths.contains(pathUrl)) {
                    auths.add(pathUrl);
                }
            }
        }

        LOGGER.info("===���� ��ȡ����controller��·��===");
    }

    /**
     * Method description
     *
     *
     * @param basePath
     * @param parseUrl
     *
     * @return
     */
    private String mergeUrl(String basePath, String parseUrl) {
        StringBuilder build = new StringBuilder();

        if (StringUtil.isNotBlank(basePath)) {
            build.append(basePath);
        }

        if (StringUtil.isNotBlank(parseUrl)) {
            build.append(parseUrl);

            if (!parseUrl.endsWith(urlPostfix)) {
                build.append(urlPostfix);
            }
        }

        return build.toString();
    }

    /**
     * Method description
     *
     *
     * @param clazz
     *
     * @return
     */
    private String parseBasePath(Class<?> clazz) {
        RequestMapping baseMapping = clazz.getAnnotation(RequestMapping.class);

        if (baseMapping != null) {
            return baseMapping.value()[0];
        }

        return null;
    }

    /**
     * Method description
     *
     *
     * @param method
     *
     * @return
     */
    private String parseUrl(Method method) {
        RequestMapping pathMapping = method.getAnnotation(RequestMapping.class);

        if (pathMapping != null) {
            return pathMapping.value()[0];
        }

        return null;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static List<String> getAllPath() {
        return paths;
    }

    /**
     * Method description
     *
     *
     * @param method
     *
     * @return
     */
    private boolean isAuth(Method method) {
        PathFilterAnno pathFiler = getPathFilterAnno(method);

        if (pathFiler != null) {
            return pathFiler.isAuth();
        }

        return false;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static List<String> getAuthPath() {
        return auths;
    }

    /**
     * Method description
     *
     *
     * @param method
     *
     * @return
     */
    private boolean isLogin(Method method) {
        PathFilterAnno pathFiler = getPathFilterAnno(method);

        if (pathFiler != null) {
            return pathFiler.isLogin();
        }

        return false;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static List<String> getLoginPath() {
        return logins;
    }

    /**
     * Method description
     *
     *
     * @param mappings
     */
    public void setMappings(List<String> mappings) {
        this.mappings = mappings;
    }

    /**
     * Method description
     *
     *
     * @param method
     *
     * @return
     */
    private PathFilterAnno getPathFilterAnno(Method method) {
        return method.getDeclaredAnnotation(PathFilterAnno.class);
    }
}



