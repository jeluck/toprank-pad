package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_SpecificationAttributeOptionInfoEntity;
import cc.toprank.byd.web.vo.product.ProductSpecificationVo;

import java.util.List;

/**
 * Created by LanZY on 2017-4-10.
 */
public interface P_SpecificationAttributeOptionInfoDao {

    P_SpecificationAttributeOptionInfoEntity get(P_SpecificationAttributeOptionInfoEntity specificationAttributeOptionInfo);

    List<P_SpecificationAttributeOptionInfoEntity> getAll();

    void update(P_SpecificationAttributeOptionInfoEntity specificationAttributeOptionInfo);

    void delete(P_SpecificationAttributeOptionInfoEntity specificationAttributeOptionInfo);

    void save(P_SpecificationAttributeOptionInfoEntity specificationAttributeOptionInfo);
    /**
     * @Description： 查询单个菜品规格信息
     * @Author：LanZY
     * @Time: 2017-4-10 14:52
     * @Version 2.0.0
     * @param variantID  变体ID
     * @return
     */
    List<ProductSpecificationVo> getVariantSpecification(Long variantID);

    /**
     * @Description： 查询套餐规格信息
     * @Author：LanZY
     * @Time: 2017-4-10 14:52
     * @Version 2.0.0
     * @param productID     套餐ID
     * @return
     */
    List<ProductSpecificationVo> getCombosSpecification(Long productID);

    P_SpecificationAttributeOptionInfoEntity selectByPrimaryKey(Long optionid);
}
