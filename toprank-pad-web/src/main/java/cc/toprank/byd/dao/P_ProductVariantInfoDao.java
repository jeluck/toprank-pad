package cc.toprank.byd.dao;


import cc.toprank.byd.entity.P_ProductVariantInfoEntity;
import cc.toprank.byd.web.vo.product.ProductVariantVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   P_ProductVariantInfo数据访问类
 *
 * ********************************************************************************************************************/
public interface P_ProductVariantInfoDao {

    P_ProductVariantInfoEntity get(P_ProductVariantInfoEntity productVariantInfo);

    List<P_ProductVariantInfoEntity> getAll();

    void update(P_ProductVariantInfoEntity productVariantInfo);


    void delete(P_ProductVariantInfoEntity productVariantInfo);

    void save(P_ProductVariantInfoEntity productVariantInfo);


    /**
     * 根据菜品编号查询套餐变体信息
     *
     * @param productID
     * @return
     * @author LanZY
     */
    List<P_ProductVariantInfoEntity> getProductComboListByProductID(Long productID);


    List<P_ProductVariantInfoEntity> getVariantListByParam(Map map);

    /**
     * 根据变体编号查询变体信息
     *
     * @param variantID 变体编号
     * @return ProductVariantVo 变体信息
     * @author LinYN
     */
    ProductVariantVo getProductVariantInfoByID(Long variantID);

    /**
     * @param variantID
     * @return
     * @Description： 按变体编号查询信息
     * @Author：LanZY
     * @Time: 2017-5-8 9:28
     * @Version 2.0.0
     */
    P_ProductVariantInfoEntity getVariantInfo(Long variantID);
}