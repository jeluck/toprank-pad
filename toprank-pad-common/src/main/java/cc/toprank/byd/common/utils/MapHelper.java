package cc.toprank.byd.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-3-9 16:52
 */
public class MapHelper {

    public static ThreadLocal<Map<String,Object>> myMap = new ThreadLocal<>();

    private MapHelper(){};

    private static class MapHelperInner{
        private static final MapHelper mapHelper = new MapHelper();
    }
    public static MapHelper getInstance() {
        return MapHelperInner.mapHelper;
    }

    public static MapHelper put(String s,Object o){
        MapHelper instance = getInstance();
        Map<String, Object> map = instance.myMap.get();
        if (map == null) {
            map= new HashMap<>();
        }
        map.put(s,o);
        instance.myMap.set(map);
        return instance;
    }

    public static Map<String,Object> toMap(){
        Map<String, Object> map = myMap.get();
        myMap.set(newMap());
        return map;
    }


    public static Map<String,Object> newMap(){
        return new HashMap<>();
    }

    public static void main(String[] args) {
        Map map = MapHelper.put("1", 1).put("2", 2).toMap();
        Map map1 = MapHelper.toMap();
        System.out.println(map);
    }
}
