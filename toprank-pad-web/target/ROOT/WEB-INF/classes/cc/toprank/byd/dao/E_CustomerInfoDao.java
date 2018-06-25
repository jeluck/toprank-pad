package cc.toprank.byd.dao;


import cc.toprank.byd.entity.E_CustomerInfoEntity;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 *
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * E_CustomerInfo数据访问类
 *
 ********************************************************************************************************************/

public interface E_CustomerInfoDao {

    E_CustomerInfoEntity get(E_CustomerInfoEntity InfoEntity);

    List<E_CustomerInfoEntity> getAll();

    void update(E_CustomerInfoEntity InfoEntity);

    void delete(E_CustomerInfoEntity InfoEntity);

    void save(E_CustomerInfoEntity InfoEntity);

    E_CustomerInfoEntity getCustomerInfoByMobile(String mobile);

    /**
     * @param InfoEntity
     * @Description：客户会员信息修改
     * @Author：HuTao
     * @Time: 2017-4-5 16:52
     * @Version 2.0.0
     */

    void updateCustomerMember(E_CustomerInfoEntity InfoEntity);

    /**
     * @param map
     * @return
     * @Description：根据手机号码取客户信息
     * @Author：HuTao
     * @Time: 2017-4-7 16:22
     * @Version 2.0.0
     */
    List<E_CustomerInfoEntity> getMobileNoByCustomerInfo(Map<?, ?> map);

    /**
     * @param map
     * @return
     * @Description：根据手机号码取客户会员卡邦定信息
     * @Author：HuTao
     * @Time: 2017-4-7 20:47
     * @Version 2.0.0
     */
    List<Map<String, Object>> getMobileNoByMemberInfo(Map<?, ?> map);

    /**
     * @Description：根据customerID ,更新累积积分
     * @Author：HuTao
     * @Time: 2017-5-31 19:26
     * @Version 2.0.0
     * @param InfoEntity
     */


    void updateMemberBonus(E_CustomerInfoEntity InfoEntity);

}
