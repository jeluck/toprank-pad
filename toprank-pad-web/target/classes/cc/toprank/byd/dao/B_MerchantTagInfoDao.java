package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_MerchantTagInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface B_MerchantTagInfoDao {
    int deleteByPrimaryKey(Long tagID);

    int insert(B_MerchantTagInfoEntity record);

    int insertSelective(B_MerchantTagInfoEntity record);

    B_MerchantTagInfoEntity selectByPrimaryKey(Long tagID);

    int updateByPrimaryKeySelective(B_MerchantTagInfoEntity record);

    int updateByPrimaryKey(B_MerchantTagInfoEntity record);

    B_MerchantTagInfoEntity getByTagCode(String tagCode);

    Map<String, Object> getTagNamesByTagIDs(String tagIDs);

    List<String> getTagNameByTargetID(@Param("targetID") Long targetID, @Param("targetType") Long targetType);

    List<B_MerchantTagInfoEntity> getByTagByTagIDs(@Param("set") Set<Long> tagIDs);
}