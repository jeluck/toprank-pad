package cc.toprank.byd.dao;



import cc.toprank.byd.entity.F_DepositInfoEntity;

import java.util.List;

/**********************************************************************************************************************
 * 
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * F_DepositInfo数据访问类
 * 
 ********************************************************************************************************************/


public interface F_DepositInfoDao {

  F_DepositInfoEntity get(F_DepositInfoEntity InfoEntity);

  List<F_DepositInfoEntity> getAll();

  int update(F_DepositInfoEntity InfoEntity);

  void delete(F_DepositInfoEntity InfoEntity);

  void save(F_DepositInfoEntity InfoEntity);

  /**
   * 通过手机号码查询充值记录
   * @author LiJun
   * @param mobile
   * @param archiveID
   * @return
   */
//  public List<F_DepositInfoEntity> getDepositInfoList(String mobile, Long archiveID,Date startTime,Date endTime) {
//    Map<String, Object> param = new HashMap<String, Object>();
//    param.put("mobile", mobile);
//    param.put("archiveID", archiveID);
//    param.put("startTime", startTime);
//    param.put("endTime", endTime);
//    return super.getSession().selectList("GetF_DepositInfoCollectionByMobile", param);
//  }



}
