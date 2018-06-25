package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_MealTableMappingEntity;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * B_MealTableMapping数据访问类
 *
 ********************************************************************************************************************/
public interface B_MealTableMappingDao {

    int deleteByPrimaryKey(Long segmentID);

    int insert(B_MealTableMappingEntity record);

    int insertSelective(B_MealTableMappingEntity record);

    B_MealTableMappingEntity selectByPrimaryKey(Long segmentID);

    int updateByPrimaryKeySelective(B_MealTableMappingEntity record);

    int updateByPrimaryKey(B_MealTableMappingEntity record);

    int updateStatusBatchByID(@Param("tableStatus") Long tableStatus, @Param("segmentIDs") String segmentIDs);

    B_MealTableMappingEntity get(B_MealTableMappingEntity mealTableMapping);

    List<B_MealTableMappingEntity> getAll();

    void update(B_MealTableMappingEntity mealTableMapping);

    void delete(B_MealTableMappingEntity mealTableMapping);

    void save(B_MealTableMappingEntity mealTableMapping);


    /**
     * 根据实体类参数修改。目前支持：桌台状态，是否拼桌、拼桌数量、是否合台、合台数量、合台名称、消费人数
     *
     * @param mealTable 实体类
     * @return int
     * @author xuexin
     */
    int updateMealTableMappingEntityTableStatus(B_MealTableMappingEntity mealTable);

    /**
     * 根据桌台id，餐次ID，查询，返回实体类
     *
     * @return
     * @author xuexin
     */
    List<B_MealTableMappingEntity> getMealTableMappingEntity(Map<String, Object> mealTableMap);


    /**
     * 根据桌台id 查询，返回实体类
     *
     * @return
     * @author zhaolingchen
     */
    List<B_MealTableMappingEntity> getMealTableMappingEntityByTableIDAndTableStatus(Map<String, Object> mealTableMap);

    /**
     * 根据桌台编号改变当前使用中的桌台餐次信息中的桌台状态
     *
     * @param entity
     * @author LinYN
     */
    void updateTableStatusByTableID(B_MealTableMappingEntity entity);

    /**
     * 根据桌台编号改变当前使用中的桌台餐次信息中的桌台状态和预订状态
     *
     * @param entity
     * @author LinYN
     */
    void updateTableStatusAndBookingByTableID(B_MealTableMappingEntity entity);

    /**
     * 根据桌台编号改变当前使用中的桌台餐次信息中的联合属性
     *
     * @param map#tableIDs       桌台编号
     * @param map#isCombine      是否联台
     * @param map#combineName    联台名称
     * @param map#combineNumber  联台数量
     * @param map#customerNumber 联台人数
     * @author LinYN
     */
    void updateCombineInfoByTableIDs(Map map);

    /**
     * 根据桌台编号,餐次,区域,档案    获取 (当前时间  至 当前时间  + 最短时长*2 ） or nowDate + 餐次最短时长
     *
     * @param b_MealTableMappingEntity B_MealTableMappingEntity
     * @return List<B_MealTableMappingEntity>
     * @date 2016-12-30
     * @author LiuWH
     */
    List<B_MealTableMappingEntity> GetB_MealTableMappingCollectionByTableID(B_MealTableMappingEntity b_MealTableMappingEntity);

    /**
     * 根据桌台编号   获取 下一个时间段的
     *
     * @param b_MealTableMappingEntity B_MealTableMappingEntity
     * @return B_MealTableMappingEntity
     * @date 2016-12-30
     * @author LiuWH
     */
    B_MealTableMappingEntity GetB_MealTableMappingCollectionByTableIDForOne(B_MealTableMappingEntity b_MealTableMappingEntity);

    /**
     * @param b_MealTableMappingEntity
     * @return
     * @Description： 根据档案ID, 区域ID, 桌台ID，查询开台或者在用状态的餐次桌台信息
     * @Author：LanZY
     * @Time: 2017-4-5 18:59
     * @Version 2.0.0
     */
    B_MealTableMappingEntity getMealTableMappingInfoByCondition(B_MealTableMappingEntity b_MealTableMappingEntity);

    /**
     * 根据桌台编号，餐次，区域，档案，传入时间    获取   桌台状态：在用
     *
     * @param b_MealTableMappingEntity B_MealTableMappingEntity
     * @return B_MealTableMappingEntity
     * @date 2017-01-5
     * @author LiuWH
     */
    B_MealTableMappingEntity GetB_MealTableMappingEntityByTableIDAndGtDate(B_MealTableMappingEntity b_MealTableMappingEntity);

    /**
     * 根据 餐次、区域、档案、桌台  并且不包含segmentID  修改多个 桌台状态
     *
     * @param b_MealTableMappingEntity B_MealTableMappingEntity
     * @date 2017-01-05
     * @author LiuWH
     */
    int UpdateB_MealTableMappingEntityByStatusAndNotEqSegmentID(B_MealTableMappingEntity b_MealTableMappingEntity);


    /**
     * 根据桌台id，餐次ID，查询，返回实体类
     *
     * @param mealTableMap
     * @return
     * @author zhouwei
     */
    List<B_MealTableMappingEntity> getMealTableMappingByTableIDAndStatus(Map<String, Object> mealTableMap);

    /**
     * 清理餐次信息609到607
     *
     * @param mealTableMap 实体类
     * @return int
     * @author zhouwei
     */
    int updateMealTableMappingByTableIDAndTableStatus(Map<String, Object> mealTableMap);

    /**
     * @author LiSH  @date 2017年1月17日
     * @Description: 根据tableID, mealsID餐次ID 和 时间取下一个最近的餐次
     */
    B_MealTableMappingEntity getMealTableInfoByMealsIDAndCurrentDate(@Param("tableID") Long tableID, @Param("mealsID") Long mealsid, @Param("date") LocalDateTime now);

    /**
     * @author LiSH  @date 2017年1月17日
     * @Description:根据tableID,mealsID餐次ID 和 时间段 获取在其中的所有餐次
     */
    List<B_MealTableMappingEntity> getMealTableInfoByMealsIDAndStartDateAndEndDate(@Param("tableID") Long tableID, @Param("mealsID") Long mealsid, @Param("startDate") LocalDateTime now, @Param("endDate") LocalDateTime endTime);

    List<B_MealTableMappingEntity> getListByParam(HashMap<String, Object> params);

    B_MealTableMappingEntity getByParam(Map<String, Object> param);

    List<B_MealTableMappingEntity> getMealTableInfoByTableIDAndMealsID(Long tableID, Long mealsid);

    /**
     * @author 赵凌晨
     * @version 2.0.0
     * @description 查询餐段信息
     * @time 2017-04-28 14:00:00
     */
    public List<B_MealTableMappingEntity> getMealTableMappingByCollention(Map<String, Object> param);

    /**
     * @param b_MealTableMappingEntity
     * @return
     * @Description： 根据桌台ID, 开始时间, 附加时长查询桌台餐次关联信息
     * @Author：LanZY
     * @Time: 2017-6-7 19:15
     * @Version 2.0.0
     */
    List<B_MealTableMappingEntity> getBetweenMealsTableMapping(@Param("tableID") Long tableID, @Param("startTime") LocalDateTime startTime, @Param("minute") int minute);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据桌台ID查询餐次桌台信息
     * @time 2017-6-16 15:29
     */
    List<B_MealTableMappingEntity> queryMealTableMappingByTableID(Long tableID);
}