package cc.toprank.byd.common.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class ReginUtils {

    // ʡ����Դ�ļ�����

    /** Field description */
    private static final String PROVINCE_RSC_NAME = "province";

    // ����Դ�ļ�����

    /** Field description */
    private static final String CITY_RSC_NAME = "city";

    // ʡ�� ����=����

    /** Field description */
    private static Map<String, String> provinceMap;

    // �� ����=����

    /** Field description */
    private static Map<String, String> cityMap;

    /**
     * Method description
     *
     *
     * @param map
     *
     * @return
     */
    private static Map<String, String> trimKeyAndValue(Map<String, String> map) {
        Map<String, String> finalMap = new HashMap<String, String>();

        if ((map == null) || (map.size() == 0)) {
            return finalMap;
        }

        Iterator<String> it = map.keySet().iterator();

        while (it.hasNext()) {
            String key   = it.next();
            String value = map.get(key);

            if (key != null) {
                key = key.trim();
            }

            if (value != null) {
                value = value.trim();
            }

            finalMap.put(key, value);
        }

        return finalMap;
    }

    /**
     * Method description
     *
     *
     * @param cityName
     *
     * @return
     */
    public static String getCityCodeByName(String cityName) {
        if ((cityName == null) || "".equals(cityName.trim())) {
            return "";
        }

        Map<String, String> map = getCityMap();
        Iterator<String>    it  = map.keySet().iterator();

        while (it.hasNext()) {
            String code = it.next();
            String name = map.get(code);

            if ((name != null) && name.trim().equalsIgnoreCase(cityName.trim())) {
                return code;
            }
        }

        return "";
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static Map<String, String> getCityMap() {
        if (cityMap == null) {
            ResourceUtils util = ResourceUtils.getResource(CITY_RSC_NAME);

            cityMap = util.getMap();
        }

        return trimKeyAndValue(cityMap);
    }

    /**
     * Method description
     *
     *
     * @param cityCode
     *
     * @return
     */
    public static String getCityNameByCode(String cityCode) {
        if ((cityCode == null) || "".equals(cityCode.trim())) {
            return "";
        }

        Map<String, String> map = getCityMap();

        return (map.get(cityCode.trim()) != null)
               ? map.get(cityCode.trim())
               : "";
    }

    /**
     * Method description
     *
     *
     * @param provinceName
     *
     * @return
     */
    public static String getProvinceCodeByName(String provinceName) {
        if ((provinceName == null) || "".equals(provinceName.trim())) {
            return "";
        }

        Map<String, String> map = getProvinceMap();
        Iterator<String>    it  = map.keySet().iterator();

        while (it.hasNext()) {
            String code = it.next();
            String name = map.get(code);

            if ((name != null) && name.trim().equalsIgnoreCase(provinceName.trim())) {
                return code;
            }
        }

        return "";
    }

    /**
     * Method description
     *
     *
     * @return
     */
    public static Map<String, String> getProvinceMap() {
        if (provinceMap == null) {
            ResourceUtils util = ResourceUtils.getResource(PROVINCE_RSC_NAME);

            provinceMap = util.getMap();
        }

        return trimKeyAndValue(provinceMap);
    }

    /**
     * Method description
     *
     *
     * @param provinceCode
     *
     * @return
     */
    public static String getProvinceNameByCode(String provinceCode) {
        if ((provinceCode == null) || "".equals(provinceCode.trim())) {
            return "";
        }

        Map<String, String> map = getProvinceMap();

        return (map.get(provinceCode.trim()) != null)
               ? map.get(provinceCode.trim())
               : "";
    }
}



