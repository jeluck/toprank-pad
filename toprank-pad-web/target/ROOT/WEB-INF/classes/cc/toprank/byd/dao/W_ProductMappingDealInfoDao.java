package cc.toprank.byd.dao;

import cc.toprank.byd.entity.W_ProductMappingDealInfoEntity;

public interface W_ProductMappingDealInfoDao {
    int deleteByPrimaryKey(Long dealid);

    int insert(W_ProductMappingDealInfoEntity record);

    int insertSelective(W_ProductMappingDealInfoEntity record);

    W_ProductMappingDealInfoEntity selectByPrimaryKey(Long dealid);

    int updateByPrimaryKeySelective(W_ProductMappingDealInfoEntity record);

    int updateByPrimaryKey(W_ProductMappingDealInfoEntity record);

    /**
     * 根据mappingid删除沽清历史记录
     * chenkangyi
     * 2017-5-27 19:30
     * @param mappingID
     * @return
     */
    int deleteByMappingID(Long mappingID);
}