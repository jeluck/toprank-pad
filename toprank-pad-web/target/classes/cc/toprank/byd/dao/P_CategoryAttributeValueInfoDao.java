package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_CategoryAttributeValueInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by LanZY on 2017-4-20.
 */
public interface P_CategoryAttributeValueInfoDao {

    int deleteByPrimaryKey(Long valueid);

    int insert(P_CategoryAttributeValueInfoEntity record);

    int insertSelective(P_CategoryAttributeValueInfoEntity record);

    P_CategoryAttributeValueInfoEntity selectByPrimaryKey(Long valueid);

    int updateByPrimaryKeySelective(P_CategoryAttributeValueInfoEntity record);

    int updateByPrimaryKey(P_CategoryAttributeValueInfoEntity record);

    /**
     * 查询单品分类属性
     * @author LeeJun
     * @time 2017-3-25 13:57
     * @version 2.0.0
     */
    List<Map<String, Object>> getProductAttributeByVariantID(Long variantID);

    /**
     * 查询套餐分类属性
     * @author LeeJun
     * @time 2017-3-25 13:57
     * @version 2.0.0
     */
    List<Map<String, Object>> getProductAttributeByProductID(Long productID);

    List<Map<String, Object>> getCategoryAttributeByValueIDs(@Param("valueIDs") String valueIDs);

    List<P_CategoryAttributeValueInfoEntity> getCategoryAttributeValuesByIDs(String valueIDs);

    String getAttributeByValueIDs(@Param("valueIDs") String valueIDs);

    /**
     * 查询菜品的指定分组属性值
     * @author LeeJun
     * @time 2017-5-25 13:57
     * @version 2.0.0
     */
    List<String> getAttributeValueByVariantID(@Param("variantID") Long variantID, @Param("groupID") Long groupID);

    /**
     * 根据valueIDs查询属性加价
     * @author LeeJun
     * @time 2017-6-7 13:57
     * @version 2.0.0
     */
    double getAddedPriceByValueIDs(@Param("valueIDs") String valueIDs);
}

