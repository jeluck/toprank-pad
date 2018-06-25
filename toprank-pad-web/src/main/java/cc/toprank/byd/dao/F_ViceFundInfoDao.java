package cc.toprank.byd.dao;



import cc.toprank.byd.entity.F_ViceFundInfoEntity;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   F_ViceFundInfo数据访问类
 * 
 * ********************************************************************************************************************/

public interface F_ViceFundInfoDao {

  F_ViceFundInfoEntity get(F_ViceFundInfoEntity InfoEntity);

  List<F_ViceFundInfoEntity> getAll();

  int update(F_ViceFundInfoEntity InfoEntity);

  void delete(F_ViceFundInfoEntity InfoEntity);

  void save(F_ViceFundInfoEntity InfoEntity);
  
  /**
   * 根据客户ID、商家ID、账户类型查询账户信息
   * @author LeeJun
   * @param customerID
   * @param archiveID
   * @param accountType
   * @return
   */
   F_ViceFundInfoEntity getViceFundInfoByCustomerIdAccountType(Map<String, Object> param);

   void updateRealAmount(F_ViceFundInfoEntity infoEntity);


}