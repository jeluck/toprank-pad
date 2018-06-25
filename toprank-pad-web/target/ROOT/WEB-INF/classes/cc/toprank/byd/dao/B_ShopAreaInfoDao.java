package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_ShopAreaInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by HuTao on 2017-3-8.
 */
public interface B_ShopAreaInfoDao {

    B_ShopAreaInfoEntity get(B_ShopAreaInfoEntity InfoEntity);

    List<B_ShopAreaInfoEntity> getAll();

    void update(B_ShopAreaInfoEntity InfoEntity);

    void delete(B_ShopAreaInfoEntity InfoEntity);

    void save(B_ShopAreaInfoEntity InfoEntity);

    /**
     * 根据档案archiveID获取区域列表信息
     *
     * @param
     * @return
     * @author XuJin
     */
    List<B_ShopAreaInfoEntity> getShopAreaInfoCollectionByArchiveID(Long archiveID);

    /**
     * 根据OrgID获取 一级区域
     *
     * @param shopAreaInfo B_ShopAreaInfoEntity
     * @return List<B_ShopAreaInfoEntity>
     * @author LiuWH
     */
    List<B_ShopAreaInfoEntity> getB_ShopAreaInfoCollectionByOrgIDTop(B_ShopAreaInfoEntity shopAreaInfo);

    int deleteByPrimaryKey(Long areaid);

    int insert(B_ShopAreaInfoEntity record);

    int insertSelective(B_ShopAreaInfoEntity record);

    B_ShopAreaInfoEntity selectByPrimaryKey(Long areaid);

    int updateByPrimaryKeySelective(B_ShopAreaInfoEntity record);

    int updateByPrimaryKey(B_ShopAreaInfoEntity record);

    List<B_ShopAreaInfoEntity> getListByArchiveID(Long archiveID);

    B_ShopAreaInfoEntity getAreaInfoByTableID(long tableId);

    /**
     * 查询区域信息
     *
     * @param map
     * @return
     */
    List<B_ShopAreaInfoEntity> queryAreaInfoByCondition(Map map);

    /**
     * 根据档案ID查询所有区域
     * @param archiveID
     * @return
     */
    List<B_ShopAreaInfoEntity> getShopAreaInfoListByArchiveID(Long archiveID);

}
