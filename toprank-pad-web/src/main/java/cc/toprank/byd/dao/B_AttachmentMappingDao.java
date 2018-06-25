package cc.toprank.byd.dao;

import java.util.List;

import cc.toprank.byd.entity.B_AttachmentMappingEntity;
import org.apache.ibatis.annotations.Param;

public interface B_AttachmentMappingDao {
    int deleteByPrimaryKey(Long mappingId);

    int insert(B_AttachmentMappingEntity record);

    int insertSelective(B_AttachmentMappingEntity record);

    B_AttachmentMappingEntity selectByPrimaryKey(Long mappingid);

    int updateByPrimaryKeySelective(B_AttachmentMappingEntity record);

    int updateByPrimaryKey(B_AttachmentMappingEntity record);

    List<B_AttachmentMappingEntity> getAttachmentByType(Long attachmentType);

    /**
     * 查询菜品图片信息
     *
     * @param targetID       菜品id
     * @param targetType     目标类型
     * @param attachmentType 附件的类别
     * @author LeeJun
     * @time 2017-3-23 14:18
     * @version 2.0.0
     */
    List<B_AttachmentMappingEntity> getProductImgByParam(@Param("targetID") Long targetID, @Param("targetType") Long targetType, @Param("attachmentType") Long attachmentType);
}