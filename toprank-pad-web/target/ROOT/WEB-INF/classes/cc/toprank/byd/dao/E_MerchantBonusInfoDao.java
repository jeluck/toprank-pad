package cc.toprank.byd.dao;


import cc.toprank.byd.entity.E_MerchantBonusInfoEntity;

import java.util.List;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   E_MerchantBonusInfo数据访问类
 * 
 * ********************************************************************************************************************/

public interface E_MerchantBonusInfoDao {

  E_MerchantBonusInfoEntity get(E_MerchantBonusInfoEntity InfoEntity);

  List<E_MerchantBonusInfoEntity> getAll();

  int update(E_MerchantBonusInfoEntity InfoEntity);

  void delete(E_MerchantBonusInfoEntity InfoEntity);

  void save(E_MerchantBonusInfoEntity InfoEntity);

  E_MerchantBonusInfoEntity getEntity(E_MerchantBonusInfoEntity bonusInfo);

  int updateMemberBonus(E_MerchantBonusInfoEntity bonusInfo);

  E_MerchantBonusInfoEntity getBonusInfoByCardID(Long cardID);
}