package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_MerchantInfoEntity;

import java.util.List;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   B_MerchantInfo数据访问类
 *
 * ********************************************************************************************************************/
public interface B_MerchantInfoDao {

    int deleteByPrimaryKey(Long archiveid);

    int insert(B_MerchantInfoEntity record);

    int insertSelective(B_MerchantInfoEntity record);

    B_MerchantInfoEntity selectByPrimaryKey(Long archiveid);

    int updateByPrimaryKeySelective(B_MerchantInfoEntity record);

    int updateByPrimaryKey(B_MerchantInfoEntity record);

    B_MerchantInfoEntity get(B_MerchantInfoEntity b_merchantinfo);

    List<B_MerchantInfoEntity> getAll();

    void update(B_MerchantInfoEntity b_merchantinfo);

    void delete(B_MerchantInfoEntity b_merchantinfo);

    void save(B_MerchantInfoEntity b_merchantinfo);

    /**
     * 根据机构编号查询商户档案信息
     *
     * @param entity
     * @return
     * @author HuangCY
     */
    B_MerchantInfoEntity queryByOrgID(B_MerchantInfoEntity entity);

    B_MerchantInfoEntity getMerchantInfoByArchiveID(Long archiveID);

    /**
     * 根据机构编号查询商户档案信息
     *
     * @param orgID
     * @return
     * @author LanZY
     */
    B_MerchantInfoEntity getMerchantInfoByOrgID(Long orgID);

    /**
     * 根据档案编号查询商户档案信息
     *
     * @return
     * @author LanZY
     */
    B_MerchantInfoEntity getMerchantInfoOrgByArchiveID(Long archiveID);

    /**
     * @description：查询数据库中唯一一条档案信息
     * @author：LiYC
     * @time: 2017-2-20 17:16
     * @version 2.0.0
     * @return
     */
    B_MerchantInfoEntity selectByListByOnly();
}