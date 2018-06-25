package cc.toprank.byd.pad.util;

import cc.toprank.byd.config.BaseConfig;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-5-12 17:08
 */
public class ImgPathUtils {
    public static List<Map<String, Object>> addImgHead(List<Map<String, Object>> imgList, String methodKey) {
        for (Map<String, Object> imgMap : imgList) {
            imgMap.put(methodKey, BaseConfig.getImagePath() + imgMap.get(methodKey));
        }
        return imgList;
    }


    public static <T> List<T> addImgHead2Object(List<T> imgList, String methodKey) throws NoSuchMethodException {
        for (T t: imgList) {
            fillField(t,methodKey,BaseConfig.getImagePath());
        }
        return imgList;
    }

    public static <T> T addImgHead2Object(T t, String methodKey) throws NoSuchMethodException {
        fillField(t,methodKey,BaseConfig.getImagePath());
        return t;
    }


    public static Map<String, Object> addImgHead(Map<String, Object> imgMap, String methodKey) {
        imgMap.put(methodKey, BaseConfig.getImagePath() + imgMap.get(methodKey));
        return imgMap;
    }

    /**
     * @param
     * @author LiSH
     * @version 2.0.0
     * @description 补全添加缺失的字段
     * @time 2017-4-5 14:20
     */
    private static <T> void  fillField(T obj, String field, Object defaultValue) {
        try {
            String first = field.substring(0, 1);
            String body = field.substring(1, field.length());
            field = first.toUpperCase() + body;
            Method getMethod = obj.getClass().getMethod("get" + field);
            Object value = getMethod.invoke(obj);
            if (value == null) {
                Method setMethod = obj.getClass().getMethod("set" + field, defaultValue.getClass());
                setMethod.invoke(obj, defaultValue);
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
