package cc.toprank.byd.dao;

import cc.toprank.byd.entity.W_ProductMappingEntity;
import cc.toprank.byd.web.vo.curbsale.CrubSaleInfoAndBookingInfoVO;
import cc.toprank.byd.web.vo.curbsale.CurbSaleInfoVO;
import cc.toprank.byd.web.vo.curbsale.ProductCrubSaleInfoVO;
import cc.toprank.byd.web.vo.curbsale.CurbSaleOperationHistoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface W_ProductMappingDao {
    int deleteByPrimaryKey(Long mappingid);

    int insert(W_ProductMappingEntity record);

    int insertSelective(W_ProductMappingEntity record);

    W_ProductMappingEntity selectByPrimaryKey(Long mappingid);

    int updateByPrimaryKeySelective(W_ProductMappingEntity record);

    int updateByPrimaryKey(W_ProductMappingEntity record);

    int updateLockQuantity(@Param("productID") Long productID, @Param("variantID") Long variantID,@Param("optionID") Long optionID, @Param("lockQuantity") int num);

    /**
     * @Description： 根据分类ID档案ID菜品名称或首字母或编码查询所有菜品
     * @Author：chenkangyi
     * @Time: 2017-5-11 18:33
     * @Version 2.0.0
     */
    List<ProductCrubSaleInfoVO> getProductListByConditionFromCurbSale(Map<String, Object> map);

    /**
     * @Description： 根据菜单id查询沽清信息和预定信息
     * @Author：chenkangyi
     * @Time: 2017-5-11 20:33
     * @Version 2.0.0
     */
    List<CrubSaleInfoAndBookingInfoVO> getCurbSaleInfoAndBookingInfoVariant(Map<String, Object> map);

    /**
     * @Description： 根据菜单id查询沽清信息和预定信息
     * @Author：chenkangyi
     * @Time: 2017-5-12 17:33
     * @Version 2.0.0
     */
    List<CrubSaleInfoAndBookingInfoVO> getCurbSaleInfoAndBookingInfoProduct(Map<String, Object> map);

    /**
     * @Description： 根据菜单id查询沽清信息和预定信息(无规格菜品)
     * @Author：chenkangyi
     * @Time: 2017-5-16 15:33
     * @Version 2.0.0
     */
    List<CrubSaleInfoAndBookingInfoVO> getCurbSaleInfoAndBookingInfoNoOption(Map<String, Object> map);

    /**
     * @param map
     * @return
     * @Description： 根据变体id和optionid查询商品配置信息
     * @Author：chenkangyi
     * @Time: 2017-5-16 15:33
     */
    W_ProductMappingEntity getProductMappingByVariantIDAndOptionID(Map<String, Object> map);

    /**
     * @param map
     * @return
     * @Description： 根据ProductID和optionid查询商品配置信息
     * @Author：chenkangyi
     * @Time: 2017-5-16 15:33
     */
    W_ProductMappingEntity getProductMappingByProductIDAndOptionID(Map<String, Object> map);

    /**
     * 当天以前沽清操作记录查询
     *
     * @param map
     * @return
     */
    List<CurbSaleOperationHistoryVO> getCurbSaleOperationListForHistory(Map<String, Object> map);

    /**
     * 当天沽清操作记录查询
     *
     * @param map
     * @return
     */
    List<CurbSaleOperationHistoryVO> getCurbSaleOperationListForToday(Map<String, Object> map);

    /**
     * 查询沽清列表-当天的沽清列表详情
     *
     * @param map
     * @return
     */
    List<CurbSaleInfoVO> getCurbSaleDetailForToday(Map<String, Object> map);

    int updateForAddProductToShoppingCart(Map<String, Object> map);

    int updateForRemoveProductFromShoppingCart(Map<String, Object> map);

    List<Map<String, Object>> queryOperationTypeList();

    List<Map<String, Object>> queryChangeReason(Map<String, Object> map);

    List<Map<String, Object>> queryDefaultChangeReason(Map<String, Object> map);

    W_ProductMappingEntity getOneByParam(@Param("productID") Long productID, @Param("variantID") Long variantID, @Param("optionID") Long optionID);

    /**
     * 根据商品id、变体id,规格id查询菜品估清数量
     *
     * @author LeeJun
     * @time 2017-5-23 11:27
     * @version 2.0.0
     */
    Integer getAvailableQuantityByParam(@Param("productID") Long productID, @Param("variantID") Long variantID, @Param("optionID") Long optionID);

    /**
     * 根据商品id、变体id,规格id查询菜品估清称重数量
     *
     * @author LeeJun
     * @time 2017-5-23 11:27
     * @version 2.0.0
     */
    Float getAvailableFloatQuantityByParam(@Param("productID") Long productID, @Param("variantID") Long variantID, @Param("optionID") Long optionID);


}