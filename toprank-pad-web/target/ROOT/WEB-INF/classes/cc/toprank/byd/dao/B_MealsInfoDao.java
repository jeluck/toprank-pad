package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_MealsInfoEntity;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   B_MealsInfo数据访问类
 *
 * ********************************************************************************************************************/

public interface B_MealsInfoDao {
    int deleteByPrimaryKey(Long mealsid);

    int insert(B_MealsInfoEntity record);

    int insertSelective(B_MealsInfoEntity record);

    B_MealsInfoEntity selectByPrimaryKey(Long mealsid);

    int updateByPrimaryKeySelective(B_MealsInfoEntity record);

    int updateByPrimaryKey(B_MealsInfoEntity record);

    B_MealsInfoEntity get(B_MealsInfoEntity InfoEntity);

    List<B_MealsInfoEntity> getAll();

    void update(B_MealsInfoEntity InfoEntity);

    void delete(B_MealsInfoEntity InfoEntity);

    void save(B_MealsInfoEntity InfoEntity);


    /**
     * 根据时间判断是否是当前餐次，并返回该时间的餐次信息
     * @param
     * @return  B_MealsInfoEntity
     * @author ZhouFY
     */
     List<B_MealsInfoEntity> getMealsInfoByStartTimeForBooking(Map<?, ?> map);



    /**
     * 根据  档案编号  获取餐次
     * @date 2016-12-29
     * @param mealsInfo			B_MealsInfoEntity
     * @return					List<B_MealsInfoEntity>
     * @author LiuWH
     */
     List<B_MealsInfoEntity> GetB_MealsInfoCollectionByArchiveID(B_MealsInfoEntity mealsInfo);

    /**
     * 根据orgID,areaID,mealName获取残次
     * @author ZhangBo
     * @since 2017-1-3
     */
     B_MealsInfoEntity getB_MealsInfoByMultiCondition(Map map);

    /**
     * @Description：获取当前时间下的餐次信息（time,archived）
     * @Author：HuTao
     * @Time: 2017-5-12 15:36
     * @Version 2.0.0
     * @param map
     * @return
     */
     B_MealsInfoEntity get_ReceptionB_MealsInfoByTimeAndArchiveID(Map map);

    /**
     * 获取可预订的餐次
     * @date 2017-5-17
     * @return					List<B_MealsInfoEntity>
     * @author Zhaolingchen
     */
    List<B_MealsInfoEntity> getMealsInfoEntityListByBooking(Map param);

    /**
     * @author Zhaolingchen
     * @version 2.0.0
     * @description 获得指定时间餐次数据
     * @time 2017-5-17 17:22
     */
    public B_MealsInfoEntity getCurrentMeals(Map<String, Object> param);

    /**
     * 根据区域编号获取餐次信息
     * @author LiuXJ
     * @param map 区域编号，档案编号
     * @return
     */
    List<B_MealsInfoEntity> getMealsInfoByAreaID(Map<String, Object> map);


    /**
     * 查询当前餐次
     * @param queryParam
     * @return
     */
    B_MealsInfoEntity getCurrentMealsInfo(B_MealsInfoEntity queryParam);


    /**
     * @Description： 按档案ID和状态查询当前餐厅所有的餐次信息
     * @Author：LanZY
     * @Time: 2017-5-31 10:49
     * @Version 2.0.0
     * @param meals
     * @return
     */
    List<B_MealsInfoEntity> getMealsInfoListByArchiveIDAndStatus(B_MealsInfoEntity meals);

    /**
     * @Description： 根据档案ID和区域ID查询当前时间区间的餐次列表
     * @Author：LanZY
     * @Time: 2017-5-31 10:49
     * @Version 2.0.0
     * @param meals
     * @return
     */
    List<B_MealsInfoEntity> getMealsBetween(B_MealsInfoEntity meals);
}