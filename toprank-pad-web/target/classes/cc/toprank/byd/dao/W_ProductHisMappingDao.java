package cc.toprank.byd.dao;

import cc.toprank.byd.entity.W_ProductHisMappingEntity;
import cc.toprank.byd.web.vo.curbsale.CurbSaleInfoVO;

import java.util.List;
import java.util.Map;

public interface W_ProductHisMappingDao {
    int deleteByPrimaryKey(Long hisID);

    int insert(W_ProductHisMappingEntity record);

    int insertSelective(W_ProductHisMappingEntity record);

    W_ProductHisMappingEntity selectByPrimaryKey(Long hisID);

    int updateByPrimaryKeySelective(W_ProductHisMappingEntity record);

    int updateByPrimaryKey(W_ProductHisMappingEntity record);

    /**
     * 查询历史沽清列表详情
     * @param map
     * @return
     */
    List<CurbSaleInfoVO> selectHisCurbSaleDetail(Map<String, Object> map);

    List<W_ProductHisMappingEntity> selectByMappingID(Long mappingID);
}