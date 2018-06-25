package cc.toprank.byd.waiterApp.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-6-16 11:11
 */
public class WaiterUtils {
    private static Map<String, Map<String,Object>> tokenMap = new HashMap<>();

    private static boolean isOpenToken = true;

    public static boolean isOpenToken() {
        return isOpenToken;
    }

    public static String buildTokenID() {
        return UUID.randomUUID().toString();
    }

    public static String setToken(Map<String,Object> t) {
        String tokenID = buildTokenID();
        tokenMap.put(tokenID, t);
        return tokenID;
    }

    public static Map<String,Object> getToken(String tokenID) {
        return tokenMap.get(tokenID);
    }
}
