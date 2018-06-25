package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_CategoryAttributeInfoEntity;
import cc.toprank.byd.web.vo.product.ProductAttributeVo;

import java.util.List;
import java.util.Map;

/**
 * Created by LanZY on 2017-4-10.
 */
public interface P_CategoryAttributeInfoDao {

    int deleteByPrimaryKey(Long attributeid);

    int insert(P_CategoryAttributeInfoEntity record);

    int insertSelective(P_CategoryAttributeInfoEntity record);

    P_CategoryAttributeInfoEntity selectByPrimaryKey(Long attributeid);

    int updateByPrimaryKeySelective(P_CategoryAttributeInfoEntity record);

    int updateByPrimaryKey(P_CategoryAttributeInfoEntity record);

    List<P_CategoryAttributeInfoEntity> getAll();

    void update(P_CategoryAttributeInfoEntity categoryAttributeInfo);

    void delete(P_CategoryAttributeInfoEntity categoryAttributeInfo);

    void save(P_CategoryAttributeInfoEntity categoryAttributeInfo);

    /**
     * @Description： 查询单品分类属性
     * @Author：LanZY
     * @Time: 2017-4-10 14:38
     * @Version 2.0.0
     * @param variantID   菜品变体ID
     * @return
     */
    List<ProductAttributeVo> getProductAttributeByVariantID(Long variantID);

    /**
     * @Description： 查询套餐分类属性
     * @Author：LanZY
     * @Time: 2017-4-10 14:38
     * @Version 2.0.0
     * @param productID   套餐ID
     * @return
     */
    List<ProductAttributeVo> getProductAttributeByProductID(Long productID);

    /**
     * @Description： 根据口味做法ids和分组id查询记录
     * @Author：LanZY
     * @Time: 2017-5-15 18:19
     * @Version 2.0.0
     * @param map
     * @return
     */
    ProductAttributeVo getAttributeByValuesAndGroupID(Map<String,Object> map);
}