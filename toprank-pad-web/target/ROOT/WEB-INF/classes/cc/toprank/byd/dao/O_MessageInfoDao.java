package cc.toprank.byd.dao;

import cc.toprank.byd.dto.message.MessageCountDTO;
import cc.toprank.byd.dto.message.MessageDTO;
import cc.toprank.byd.entity.O_MessageInfoEntity;

import java.util.List;
import java.util.Map;

public interface O_MessageInfoDao {
    int deleteByPrimaryKey(Long SMSID);

    int insert(O_MessageInfoEntity record);

    int insertSelective(O_MessageInfoEntity record);

    O_MessageInfoEntity selectByPrimaryKey(Long SMSID);

    int updateByPrimaryKeySelective(O_MessageInfoEntity record);

    int updateByPrimaryKey(O_MessageInfoEntity record);

    /*===========业务方法=================*/
    List<MessageDTO> getMessageList(Map<String, Object> param);

    List<Map<String, Object>> getBusinessList(Map<String, Object> paraMap);

    List<MessageCountDTO> getMessageCountList(Map<String, Object> param);

    List<Map<String, Object>> getMessageContentList(Map<String, Object> paraMap);

    Map<String, Object> getUserInfo(Long loginID);

    List<Map<String, Object>> getUpLevelPersonList(Long recipientID);

    List<Map<String, Object>> initBusinessList(Map<String, Object> paramMap);

    List<Map<String, Object>> getBusinessListDictionaryCatalog();

    Long getSettingID(Long catalogID);

    List<Map<String, Object>> getTransferPersonList(Map<String, Object> paraMap);

    List<Map<String, Object>> getMessageListByLastTime(Map<String, Object> paraMap);

    Long checkMessageType(Map<String, Object> param);

    Map<String, Object> getMessageCountByShowType(Map<String, Object> param);

    List<Map<String, Object>> getRoleListByArchiveID(Map<String, Object> paraMap);

    Map<String,Object> getOrderStatusBySubOrderID(Map<String, Object> paraMap);
}