package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_PadTableMappingEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface B_PadTableMappingDao {
    int deleteByPrimaryKey(Long mappingid);

    int insert(B_PadTableMappingEntity record);

    int insertSelective(B_PadTableMappingEntity record);

    B_PadTableMappingEntity selectByPrimaryKey(Long mappingid);

    int updateByPrimaryKeySelective(B_PadTableMappingEntity record);

    int updateByPrimaryKey(B_PadTableMappingEntity record);

    /**
     * @param b_padTableMapping
     * @return
     * @description：查看该水牌和桌台是否是第一次绑定
     * @author：LiYC
     * @time: 2017-2-20 17:25
     * @version 2.0.0
     */
    B_PadTableMappingEntity selectByOnly(@Param("padID") Long padID, @Param("tableID") Long tableID);

    /**
     * @param b_padTableMapping
     * @return
     * @description：查询该水牌目前状态为绑定中的桌台的关联关系
     * @author：LiYC
     * @time: 2017-2-20 17:23
     * @version 2.0.0
     */
    List<B_PadTableMappingEntity> selectByPadStatus(@Param("padID") Long padID, @Param("mappingStatus") Long mappingStatus);
}
