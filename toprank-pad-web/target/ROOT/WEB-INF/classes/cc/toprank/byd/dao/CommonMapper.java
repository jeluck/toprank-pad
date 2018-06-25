package cc.toprank.byd.dao;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.MapHelper;
import cc.toprank.byd.dto.common.MerchantBusinessDTO;
import cc.toprank.byd.entity.B_DinningTableInfoEntity;
import cc.toprank.byd.entity.B_MealsInfoEntity;
import cc.toprank.byd.pad.util.MerchantCacheUtils;
import cc.toprank.byd.util.SpringContextHelper;
import org.apache.commons.collections.MapUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-3-16 15:54
 */
@Component
public class CommonMapper extends SqlSessionDaoSupport {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    private static CommonMapper instance;

    public static CommonMapper get() {
        if (instance == null) {
            instance = SpringContextHelper.getBean("commonMapper");
        }
        return instance;
    }

    public static SqlSession getSqlExcutor() {
        return get().getSqlSession();
    }

    public static List<Map<String, Object>> getList(Class clazz, String selectID, Map<String, Object> param) {
        return getSqlExcutor().selectList(clazz.getName() + "." + selectID, param);
    }

    public static <T> List<T> getList(Class clazz, String selectID, Map<String, Object> param, Class<T> tClass) {
        return (List<T>) getSqlExcutor().selectList(clazz.getName() + "." + selectID, param);
    }

    public static <T> T getOne(Class clazz, String selectID, Object param, Class<T> tClass) {
        return (T) getSqlExcutor().selectOne(clazz.getName() + "." + selectID, param);
    }

    public static Map<String, Object> getOne(Class clazz, String selectID, Object param) {
        return getSqlExcutor().selectOne(clazz.getName() + "." + selectID, param);
    }

    public static Map<String, Object> updateSql(Class clazz, String selectID, Object param) {
        int update = getSqlExcutor().update(clazz.getName() + "." + selectID, param);
        Map<String, Object> result = MapHelper.newMap();
        result.put("count", update);
        return result;
    }

    public static CommonDao getCommonDao() {
        return getSqlExcutor().getMapper(CommonDao.class);
    }


    /**
     * @description 获得当前桌台信息
     * @author LiSH
     * @time 2017-3-17 13:54
     * @version 2.0.0
     */
    public static B_DinningTableInfoEntity getCurrentTable() {
        return getOne(B_DinningTableInfoDao.class, "selectByPrimaryKey", MerchantCacheUtils.getCurrentTableID(), B_DinningTableInfoEntity.class);
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得当前桌态信息
     * @time 2017-4-12 17:16
     */
    public static Map<String, Object> getTableDetail() {
        return getOne(B_DinningTableInfoDao.class, "getTableBaseDetailByTableID", MerchantCacheUtils.getCurrentTableID(), Map.class);
    }

    /**
     * 获取当前餐次信息
     *
     * @author LeeJun
     * @time 2017-6-6 17:23
     * @version 2.0.0
     */
    public static B_MealsInfoEntity getCurrentMealsInfo() {
        Map<String, Object> param = new HashMap<>();
        param.put("areaID", MerchantCacheUtils.getCurrentAreaID());
        param.put("archiveID", MerchantCacheUtils.getCurrentArchiveID());
        param.put("startTime", LocalDateTime.now());
        return getCurrentMealsInfo(param);
    }

    /**
     * 获取当前餐次信息
     *
     * @author LeeJun
     * @time 2017-6-7 15:46
     * @version 2.0.0
     */
    public static B_MealsInfoEntity getCurrentMealsInfo(Map<String, Object> param) {
        Assert.notNull(param.get("archiveID"), "archiveID is required");
        Assert.notNull(param.get("areaID"), "areaID is required");
        Assert.notNull(param.get("startTime"), "startTime is required");
        return getOne(B_MealsInfoDao.class, "getCurrentMealsInfo", param, B_MealsInfoEntity.class);
    }


    /**
     * 获取当前餐次ID
     *
     * @author LeeJun
     * @time 2017-6-6 17:23
     * @version 2.0.0
     */
    public static Long getCurrentMealsID() {
        B_MealsInfoEntity mealsInfo = getCurrentMealsInfo();
        if (mealsInfo == null) {
            return null;
        }
        return mealsInfo.getMealsID();
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 参数必须 areaID and archiveID or tableID
     * @time 2017-6-1 14:03
     */
    public static Long getCurrentMealsInfo_bak(Map<String, Object> param) {
        Map<String, Object> paramMap = MapHelper.newMap();
        paramMap.putAll(param);
        if (!paramMap.containsKey("mealsID")) {
            paramMap.put("mealsID", null);
        }
        Long areaID = MapUtils.getLong(paramMap, "areaID");
        Long archiveID = MapUtils.getLong(paramMap, "archiveID");
        Long tableID = MapUtils.getLong(paramMap, "tableID");
        if (areaID == null && archiveID == null && tableID == null) {
            BizException.error("(areaID && archiveID) or tableID is required!");
        } else if ((areaID == null || archiveID == null) && tableID != null) {
            B_DinningTableInfoEntity b_dinningTableInfoEntity = getSqlExcutor().getMapper(B_DinningTableInfoDao.class).selectByPrimaryKey(tableID);
            if (b_dinningTableInfoEntity == null) {
                BizException.error("tableID is error,can't find tableInfo");
            }
            paramMap.put("areaID", b_dinningTableInfoEntity.getAreaID());
            paramMap.put("archiveID", b_dinningTableInfoEntity.getArchiveID());
        }
        getSqlExcutor().getMapper(P_ProductInfoDao.class).getMealsInfoByAreaID(paramMap);
        Long mealsID = MapUtils.getLong(paramMap, "mealsID");
        if (mealsID == null) {
            BizException.error("无法获得当前餐次信息");
        }
        return mealsID;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 参数必须 areaID and mealsID and archiveID 获得 有菜的areaID
     * @time 2017-6-1 14:03
     */
    public static Long getAreaIDWithMenu(Map<String, Object> param) {
        getSqlExcutor().getMapper(P_ProductInfoDao.class).getAreaIDByAreaID(param);
        return MapUtils.getLong(param, "areaID");
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得桌台负责人(复杂参数型) 参数必须:tableID(必须) areaID(可选) mealsID(可选) dictionaryID(可选) 获得当前桌台负责人
     * @time 2017-6-5 11:22
     */
    public static Map<String, Object> getCurrentTableManager(Map<String, Object> param) throws Exception {
        Map<String, Object> paramMap = MapHelper.newMap();
        paramMap.putAll(param);
        paramMap.put("startTime", LocalDateTime.now());
        Long tableID = MapUtils.getLong(paramMap, "tableID");
        Long areaID = MapUtils.getLong(paramMap, "areaID");
        Long mealsID = MapUtils.getLong(paramMap, "mealsID");
        if (tableID == null) {
            BizException.error("tableID is required !");
        }
        if (areaID == null) {
            B_DinningTableInfoEntity tableInfo = getOne(B_DinningTableInfoDao.class, "selectByPrimaryKey", tableID, B_DinningTableInfoEntity.class);
            paramMap.put("areaID", tableInfo.getAreaID());
        }
        if (mealsID == null) {
            B_MealsInfoEntity currentMealsInfo = getCurrentMealsInfo(paramMap);
            if (currentMealsInfo == null) {
                BizException.error("无法确定当前餐次");
            }
            paramMap.put("mealsID", currentMealsInfo.getMealsID());
        }
//        1.tableID+mealsID+dictionaryID 查询是否存在对应桌台负责人
//        paramMap.put("tableOnly", true);
        Map<String, Object> currentTableManager = getCommonDao().getCurrentTableManager(paramMap);
//        2.areaID + mealsID + dictionaryID 查询是否存在区域桌台负责人
//        if (currentTableManager == null) {
//            paramMap.remove("tableOnly");
//            paramMap.put("areaOnly", true);
//            currentTableManager = getCommonDao().getCurrentTableManager(paramMap);
//        }
        return currentTableManager;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 根据loginID 获得所负责的所有桌台
     * @time 2017-6-14 14:02
     */
    public static List<Map<String, Object>> getManagerTableList(Map<String, Object> param) throws Exception {
        Assert.notNull(param.get("loginID"), "loginID is required");
        List<Map<String, Object>> managerTableList = getCommonDao().getManagerTableList(param);
        return managerTableList;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得餐厅的营业日信息
     * @time 2017-6-16 15:34
     */
    public static MerchantBusinessDTO getMerchantBusinessDate(Map param) {
        MerchantBusinessDTO merchantBusinessDTO = getCommonDao().getMerchantBusinessDate(param);
        return merchantBusinessDTO;
    }
}
