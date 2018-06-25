package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_MerchantMenuInfoEntity;
import cc.toprank.byd.pad.pojo.SpecificationDTO;
import cc.toprank.byd.web.vo.haltsales.ProductHaltsSalesInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface B_MerchantMenuInfoDao {
    int deleteByPrimaryKey(Long menuid);

    int insert(B_MerchantMenuInfoEntity record);

    int insertSelective(B_MerchantMenuInfoEntity record);

    B_MerchantMenuInfoEntity selectByPrimaryKey(Long menuid);

    int updateByPrimaryKeySelective(B_MerchantMenuInfoEntity record);

    int updateByPrimaryKey(B_MerchantMenuInfoEntity record);

    B_MerchantMenuInfoEntity get(B_MerchantMenuInfoEntity merchantMenuInfo);

    List<B_MerchantMenuInfoEntity> getAll();

    void update(B_MerchantMenuInfoEntity merchantMenuInfo);

    void delete(B_MerchantMenuInfoEntity merchantMenuInfo);

    void save(B_MerchantMenuInfoEntity merchantMenuInfo);

    /**
     * Description 获取同价菜单列表
     * Version 2.0.0
     * Time 2017-05-03
     * author zhouwei
     * param
     * return
     */
    public List<B_MerchantMenuInfoEntity> getSamePriceFoodList(Map map);

    /**
     * Description 获取同价菜单列表
     * Version 2.0.0
     * Time 2017-05-03
     * author zhouwei
     * param
     * return
     */
    public List<B_MerchantMenuInfoEntity> getNotSamePriceFoodList(Map map);

    /**
     * 通过menuID查询菜单菜品信息
     *
     * @author LeeJun
     * @time 2017-3-22 15:10
     * @version 2.0.0
     */
    B_MerchantMenuInfoEntity getByMenuID(@Param("menuID") Long menuID, @Param("isCombo") boolean isCombo);

    /**
     * 通过变体ID查询菜单菜品信息
     *
     * @param variantID
     * @return
     */
    B_MerchantMenuInfoEntity getByVariantID(Long variantID);

    /**
     * 通过商品ID查询菜单套餐信息
     *
     * @param productID
     * @return
     */
    B_MerchantMenuInfoEntity getCombosByProductID(Long productID);

    /**
     * 查询单个菜品规格信息
     *
     * @param variantID
     * @return
     * @author LeeJun
     */
    List<SpecificationDTO> getVariantSpecification(@Param("variantID") Long variantID, @Param("optionID") Long optionID);


    /**
     * 查询套餐规格信息
     *
     * @param productID
     * @return
     * @author LeeJun
     */
    List<SpecificationDTO> getCombosSpecification(@Param("productID") Long productID, @Param("optionID") Long optionID);

    /**
     * 时价维护 查询菜单信息
     *
     * @author ZhaoLC
     * @Time 2017-3-10 14:00
     */
    List<Map<String, Object>> queryMerchantMenuAndProductInfoByCondition(Map<String, Object> map);

    /**
     * 获取商品单位
     *
     * @author LeeJun
     * @time 2017-5-25 16:05
     * @version 2.0.0
     */
    String getProductUnitName(Long menuID);

    /**
     * 查询停售菜品列表
     *
     * @author chenkangyi
     * @time 2017-6-5 13:47
     * @version 2.0.0
     */
    List<ProductHaltsSalesInfoVO> getProductListFromHaltsSales(Map<String, Object> map);

    /**
     * 获取停售列表
     *
     * @author chenkangyi
     * @time 2017-6-5 16:05
     * @version 2.0.0
     */
    void getHaltsSalesList(Map<String, Object> map);

    /**
     * 更新菜单的停售状态
     *
     * @author chenkangyi
     * @time 2017-6-5 16:05
     * @version 2.0.0
     */
    int updateByProductIDAndVariantID(Map<String, Object> map);

}