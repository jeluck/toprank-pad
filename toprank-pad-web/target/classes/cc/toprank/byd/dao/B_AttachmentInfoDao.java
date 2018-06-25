package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_AttachmentInfoEntity;

public interface B_AttachmentInfoDao {
    int deleteByPrimaryKey(Long attachmentid);

    int insert(B_AttachmentInfoEntity record);

    int insertSelective(B_AttachmentInfoEntity record);

    B_AttachmentInfoEntity selectByPrimaryKey(Long attachmentid);

    int updateByPrimaryKeySelective(B_AttachmentInfoEntity record);

    int updateByPrimaryKey(B_AttachmentInfoEntity record);
}