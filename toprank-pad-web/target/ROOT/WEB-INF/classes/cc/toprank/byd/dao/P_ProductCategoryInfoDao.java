package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_ProductCategoryInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * @Description： 菜品分类dao
 * @Author：LanZY
 * @Time: 2017-3-8 16:20
 * @Version 2.0.0
 */
public interface P_ProductCategoryInfoDao {

    int deleteByPrimaryKey(Long categoryid);

    int insert(P_ProductCategoryInfoEntity record);

    int insertSelective(P_ProductCategoryInfoEntity record);

    P_ProductCategoryInfoEntity selectByPrimaryKey(Long categoryid);

    int updateByPrimaryKeySelective(P_ProductCategoryInfoEntity record);

    int updateByPrimaryKey(P_ProductCategoryInfoEntity record);

    //List<Map<String, Object>> getCategorysByArchiveID(Long archiveID);

    List<Map<String, Object>> getCategorysByCategoryID(Map<String, Object> map);

    P_ProductCategoryInfoEntity get(P_ProductCategoryInfoEntity productCategoryInfo);

    List<P_ProductCategoryInfoEntity> getAll();

    void update(P_ProductCategoryInfoEntity productCategoryInfo);

    void delete(P_ProductCategoryInfoEntity productCategoryInfo);

    void save(P_ProductCategoryInfoEntity productCategoryInfo);

    /**
     * @Description： 根据档案编号查询菜品分类信息
     * @Author：LanZY
     * @Time: 2017-3-8 16:20
     * @Version 2.0.0
     * @author LanZY
     * @param ArchiveID
     * @return
     */
    List<P_ProductCategoryInfoEntity> getProductCategoryListByArchiveID(Long ArchiveID);


    /**
     * @Description： 根据档案编号查询菜品分类信息
     * @Author：LanZY
     * @Time: 2017-3-29 10:47
     * @Version 2.0.0
     * @param archiveID  档案ID
     * @return
     */
    List<Map<String, Object>> getCategorysByArchiveID(Long archiveID);


    /**
     * @Description： 根据变体ID查询分类信息
     * @Author：LanZY
     * @Time: 2017-5-6 14:36
     * @Version 2.0.0
     * @param variantID 变体ID
     */
    P_ProductCategoryInfoEntity getCategoryByVariantID(Long variantID);

    /**
     * @Description： 根据分类ID集合查询分类
     * @Author：LanZY
     * @Time: 2017-6-14 13:57
     * @Version 2.0.0
     * @param categoryIDs
     * @return
     */
    List<Map<String, Object>>  getCategoryInfoListByCategoryIDs(List<Long> categoryIDs);
}
