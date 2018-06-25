package cc.toprank.byd.dao;


import cc.toprank.byd.entity.ReceptionTableEntity;
import cc.toprank.byd.entity.ReceptionTableInfoEntity;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   B_MealsInfo数据访问类
 * 
 * ********************************************************************************************************************/

public interface ReceptionTableDao {
  /**
   * 根据区域id 机构id查询桌台列表
   * @author XuJin
   * @param map
   * @return
   */
   List<ReceptionTableEntity> getTableCollectionByArchiveIDAndAreaID(Map<?, ?> map);
  
  /**
   * 根据区域id 机构id查询桌台列表(查出桌台中的桌子列表)
   * @author XuJin
   * @param map
   * @return
   */
   List<ReceptionTableEntity> getTableCollectionByArchiveIDAndAreaID(Map<?, ?> map,boolean isMeald);


  /**
   * 根据机构id,桌台状态查询桌台数量
   * @author XuJin
   * @param map
   * @return
   */
   int getTableCountByStatusAndArchiveID(Map<?, ?> map);
  
  /**
   * 根据机构id,餐桌名查询桌台信息
   * @author XuJin
   * @param map
   * @return
   */
   List<ReceptionTableEntity> getTableInfoByArchiveIDAndtableName(Map<?, ?> map);
    
  /**
   * 根据餐桌状态  机构id查询桌台列表
   * @author XuJin
   * @param map
   * @return
   */
   List<ReceptionTableEntity> getTableCollectionByArchiveIDAndStatus(Map<?, ?> map);

  /**
   * 根据餐桌id查询桌台列表
   * @author XuJin
   * @param map
   * @return
   */
   List<ReceptionTableInfoEntity> getTableInfoCollectionByTableId(Map<?, ?> map);


}