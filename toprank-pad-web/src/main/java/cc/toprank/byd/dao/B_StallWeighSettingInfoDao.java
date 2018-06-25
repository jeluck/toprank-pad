package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_StallWeighSettingInfoEntity;

import java.util.List;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   B_StallWeighSettingInfo数据访问类
 *
 * ********************************************************************************************************************/
public interface B_StallWeighSettingInfoDao {


    B_StallWeighSettingInfoEntity get(B_StallWeighSettingInfoEntity stallWeighSettingInfo);

    List<B_StallWeighSettingInfoEntity> getAll();

    void update(B_StallWeighSettingInfoEntity stallWeighSettingInfo);

    void delete(B_StallWeighSettingInfoEntity stallWeighSettingInfo);

    void save(B_StallWeighSettingInfoEntity stallWeighSettingInfo);

    /**
     * @param stallWeighSettingInfo
     * @return
     * @Description： 根据档案ID和状态查询称重档口配置信息
     * @Author：LanZY
     * @Time: 2017-5-3 10:44
     * @Version 2.0.0
     */
    List<B_StallWeighSettingInfoEntity> getStallWeighSettingListByArchiveIDAndStallStatus(B_StallWeighSettingInfoEntity stallWeighSettingInfo);

    int deleteByPrimaryKey(Long stallid);

    int insert(B_StallWeighSettingInfoEntity record);

    int insertSelective(B_StallWeighSettingInfoEntity record);

    B_StallWeighSettingInfoEntity selectByPrimaryKey(Long stallid);

    int updateByPrimaryKeySelective(B_StallWeighSettingInfoEntity record);

    int updateByPrimaryKey(B_StallWeighSettingInfoEntity record);

    List<B_StallWeighSettingInfoEntity> selectStallWeighSettingInfoAll(Long archiveID);
}