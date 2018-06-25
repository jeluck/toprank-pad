package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_PadInfoEntity;
import org.apache.ibatis.annotations.Param;

public interface B_PadInfoDao {
    int deleteByPrimaryKey(Long padID);

    int insert(B_PadInfoEntity record);

    int insertSelective(B_PadInfoEntity record);

    B_PadInfoEntity selectByPrimaryKey(Long padID);

    int updateByPrimaryKeySelective(B_PadInfoEntity record);

    int updateByPrimaryKey(B_PadInfoEntity record);

    /**
     * @return
     * @description：根据水牌串号查询水牌信息
     * @author：LiYC
     * @time: 2017-2-20 17:19
     * @version 2.0.0
     */
    B_PadInfoEntity selectByImei(@Param("archiveID") Long archiveID, @Param("imeiCode") String imeiCode);
}