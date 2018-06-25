package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_MealsInfoEntity;
import cc.toprank.byd.entity.P_ProductInfoEntity;
import cc.toprank.byd.pad.pojo.CommendProductDTO;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   P_ProductInfo数据访问类
 *
 * ********************************************************************************************************************/
public interface P_ProductInfoDao {

    int deleteByPrimaryKey(Long productid);

    int insert(P_ProductInfoEntity record);

    int insertSelective(P_ProductInfoEntity record);

    P_ProductInfoEntity selectByPrimaryKey(Long productid);

    int updateByPrimaryKeySelective(P_ProductInfoEntity record);

    int updateByPrimaryKey(P_ProductInfoEntity record);

    List<Map<String, Object>> getProductsByParam(Map map);

    List<Map<String, String>> getTagListByArchiveID(Long currentArchiveID);

    Map<String, Object> getVariantDetails(@Param("menuID") Long menuID, @Param("tableID") Long tableID);

    Map<String, Object> getProductDetails(@Param("menuID") Long menuID, @Param("tableID") Long tableID);

    List<Map<String, Object>> getProductsByCondition(Map<String, Object> map);

    P_ProductInfoEntity get(P_ProductInfoEntity p_productinfo);

    List<P_ProductInfoEntity> getAll();

    void update(P_ProductInfoEntity p_productinfo);

    void delete(P_ProductInfoEntity p_productinfo);

    void save(P_ProductInfoEntity p_productinfo);

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 终极版 查询所有分类ID 根据mealsID +areaID +archiveID
     * @time 2017-6-1 14:07
     */
    List<Map<String, Object>> getCategoryList(Map<String, Object> param);

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 终极版 调用存储过程 根据当前areaID + archiveID 获得mealsID
     * @time 2017-6-1 14:02
     */
    @Select("call p_getMeals(#{areaID},#{archiveID},#{mealsID,jdbcType=BIGINT,mode=OUT})")
    @Options(statementType = StatementType.CALLABLE)
    B_MealsInfoEntity getMealsInfoByAreaID(Map<String, Object> param);

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 终极版 调用存储过程 根据areaID + mealsID + archiveID 获得有菜的areaID
     * @time 2017-6-1 14:04
     */
    @Select("call p_getArea(#{areaID},#{archiveID},#{mealsID},#{areaID,jdbcType=BIGINT,mode=OUT})")
    @Options(statementType = StatementType.CALLABLE)
    Long getAreaIDByAreaID(Map<String, Object> param);

    /**
     * 通用菜品分类
     * chenkangyi
     * 2017-6-2 13:45
     *
     * @param param
     * @return
     */
    List<Map<String, Object>> getCategoryListForCommon(Map<String, Object> param);

    /**
     * 获取推荐菜品
     * @author LeeJun
     * @time 2017-6-15 16:37
     * @version 2.0.0
     */
    List<CommendProductDTO> getCommendProducts(@Param("archiveID") Long archiveID, @Param("areaID") Long areaID, @Param("mealsID") Long mealsID);
}