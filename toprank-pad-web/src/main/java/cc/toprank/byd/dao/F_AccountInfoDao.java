package cc.toprank.byd.dao;



import cc.toprank.byd.entity.F_AccountInfoEntity;
import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 * 
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * F_AccountInfo数据访问类
 * 
 ********************************************************************************************************************/

public interface F_AccountInfoDao {

    F_AccountInfoEntity get(F_AccountInfoEntity InfoEntity);

    List<F_AccountInfoEntity> getAll();

    int update(F_AccountInfoEntity InfoEntity);

    void delete(F_AccountInfoEntity InfoEntity);

    void save(F_AccountInfoEntity InfoEntity);
  /**
   * 根据客户ID查询账户信息
   * @author LeeJun
   * @param customerID
   * @return
   */
  F_AccountInfoEntity getAccountInfoByCustomerID(Map<String, Object> param) ;
    /**
     * 查看账户金额
     * @author HuangCY
     * @param entity
     */
    F_AccountInfoEntity checkingAccount (F_AccountInfoEntity entity);

    /**
     * @Description：根据CustomerID  取帐户信息
     * @Author：HuTao
     * @Time: 2017-4-21 13:56
     * @Version 2.0.0
     * @param param
     * @return
     */
    F_AccountInfoEntity getAccountViceFundInfoByCustomerID(Map<String, Object> param);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 更新商家或平台账户金额
     * @time 2017-5-6 16:17
     */
    void updateAccountFunds (F_AccountInfoEntity entity) throws Exception;
}
