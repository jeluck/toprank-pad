package cc.toprank.byd.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.common.utils.DateUtils;
import cc.toprank.byd.common.utils.MapHelper;
import cc.toprank.byd.constant.MessageConstants;
import cc.toprank.byd.dao.CommonMapper;
import cc.toprank.byd.dao.O_MessageDealInfoDao;
import cc.toprank.byd.dao.O_MessageInfoDao;
import cc.toprank.byd.dto.message.MessageCountDTO;
import cc.toprank.byd.dto.message.MessageDTO;
import cc.toprank.byd.entity.O_MessageDealInfoEntity;
import cc.toprank.byd.entity.O_MessageInfoEntity;
import cc.toprank.byd.enums.MerchantManageEnum;
import cc.toprank.byd.util.DateHelper;
import cc.toprank.byd.util.MaxIDUtils;
import com.github.pagehelper.PageHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * 消息Service
 * 消息中心
 * 呼叫服务
 *
 * @author LiSH
 * @create 2017-05-17 19:55
 */
@Service
public class MessageService {
    @Autowired
    private O_MessageInfoDao o_messageInfoDao;
    @Autowired
    private O_MessageDealInfoDao o_messageDealInfoDao;


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得各类未读消息数量列表
     * @time 2017-5-17 17:57
     */
    public Map<String, Object> getMessageCountList(Map<String, Object> param) {
//        1.补全查询时间 传入时间的开始和结束
        fillDayStartAndDayEnd(param, LocalDate.now());
//        2.查询各类消息数量列表
        List<MessageCountDTO> messageCountList = o_messageInfoDao.getMessageCountList(param);
//        3.汇总所有消息数量
        double sum = messageCountList.stream().mapToDouble(map -> map.getNum().longValue()).sum();
        MessageCountDTO messageTotalDTO = new MessageCountDTO(0L, "全部消息", new BigDecimal(sum));
        messageCountList.add(0, messageTotalDTO);

        return MapHelper.put("messageCountList", messageCountList).toMap();
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得消息列表
     * @time 2017-5-17 15:19
     */
    public Map<String, Object> getMessageList(Map<String, Object> param) throws Exception {
        Assert.notNull(param.get("showType"), "showType is required");

        Map<String, Object> resultMap = MapHelper.newMap();
        String source = MapUtils.getString(param, "source");
//        1.查询所有消息
        List<MessageDTO> messageList = o_messageInfoDao.getMessageList(param);
//        收银机需要实时查询消息数量
        if (MessageConstants.WEB_SOURCE.equals(source)) {
            Map<String, Object> messageCountList = getMessageCountList(param);
            resultMap.put("messageCountList", messageCountList);
        }
//        服务员APP需要实时查询已处理和未处理消息数量
        if (MessageConstants.WAITER_SOURCE.equals(source)) {
            Map<String, Object> showTypeCount = o_messageInfoDao.getMessageCountByShowType(param);
            resultMap.put("showTypeCount", showTypeCount);
        }
        resultMap.put("messageList", messageList);

        return resultMap;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得呼叫服务类型列表 (加水 加凳子 ...)
     * @time 2017-5-17 16:38
     */
    public Map<String, Object> getBusinessList(Map<String, Object> paraMap) {
        List<Map<String, Object>> businessList = o_messageInfoDao.getBusinessList(paraMap);
        return MapHelper.put("businessList", businessList).toMap();
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 添加消息
     * @time 2017-5-17 16:01
     */
    @Transactional
    public Map<String, Object> addMessageVClick(Map<String, Object> param) throws Exception {
        //检查settingID 和 dictionaryID 有效性
        if (!checkMessageType(param)) {
            BizException.error(3, "请检查settingID和dictionaryID是否有效");
        }
        //来自点击服务
        Map<String, Object> tableInfoMap = CommonMapper.getCurrentTableManager(param);

        O_MessageInfoEntity entity = new O_MessageInfoEntity();
        if (null == tableInfoMap) {
            BizException.error(2, "无法找到对应的桌台负责人");
        } else {
            BeanUtils.copyProperties(entity, param);
            entity.setRecipientID(MapUtils.getLong(tableInfoMap, "loginID"));
            entity.setRecipientType(44L);
            entity.setTableName(MapUtils.getString(tableInfoMap, "tableName", ""));
            entity.setBusinessID(MapUtils.getLong(param, "dictionaryID"));
            entity.setBusinessStatus(MerchantManageEnum.ServiceResponse.UNTREATED.getValue());
            entity.setSMSContent(MapUtils.getString(tableInfoMap, "dictionaryName"));
            entity.setCreateTime(LocalDateTime.now());
            entity.setSMSID(MaxIDUtils.getID(entity));

            o_messageInfoDao.insertSelective(entity);
        }
        return MapHelper.put("entity", entity).toMap();
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 根据subOrderID 获得聊天内容
     * @time 2017-5-18 11:08
     */
    public Map<String, Object> getMessageContentList(Map<String, Object> paraMap) {
        paraMap.put("settingID", 1);
        List<Map<String, Object>> messageContentList = o_messageInfoDao.getMessageContentList(paraMap);
        return MapHelper.put("messageContentList", messageContentList).toMap();
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 处理消息状态 处理后状态 + 处理人的改变
     * @time 2017-5-18 13:12
     */
    @Transactional
    public Map<String, Object> updateMessage(Map<String, Object> paraMap) {
        Long sMSID = MapUtils.getLong(paraMap, "sMSID");
        long businessStatus = MapUtils.getLongValue(paraMap, "businessStatus");
        Long loginID = MapUtils.getLong(paraMap, "loginID");
        updateOneMessage(sMSID, businessStatus, loginID);
        return null;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 转发消息
     * @time 2017-5-18 15:06
     */
    @Transactional
    public Map<String, Object> transferMessage(Map<String, Object> paraMap) {
        Long sMSID = MapUtils.getLong(paraMap, "sMSID");
        Long loginID = MapUtils.getLong(paraMap, "loginID");
        Long targetID = MapUtils.getLong(paraMap, "targetID");
        transferOneMessage(sMSID, loginID, targetID);
        return null;
    }


    /*内部重构调用方法*/

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 添加消息V(消息聊天版)
     * @time 2017-5-31 12:02
     */
    @Transactional
    public Map<String, Object> addMessageVMsg(Map<String, Object> param) throws Exception {
        O_MessageInfoEntity entity = new O_MessageInfoEntity();
        BeanUtils.copyProperties(entity, param);
        String sMSContent = MapUtils.getString(param, "sMSContent");
        if (sMSContent == null) {
            BizException.error("请输入聊天信息");
        }
        entity.setSMSContent(sMSContent);
        //聊天信息
        Map<String, Object> currentTableManager = CommonMapper.getCurrentTableManager(param);
        String onlyCode = UUID.randomUUID().toString();//生成一条消息批次ID
        entity.setSMSID(MaxIDUtils.getID(entity));
        entity.setSMSCode(onlyCode);
        entity.setSettingID(o_messageInfoDao.getSettingID(2L));//呼叫服务类消息
        entity.setRecipientID(MapUtils.getLong(currentTableManager, "managerID"));
        entity.setBusinessID(0L); // 0标识聊天信息
        entity.setRecipientType(44L);
        entity.setTableName(MapUtils.getString(currentTableManager, "tableName", ""));
        entity.setBusinessStatus(MerchantManageEnum.ServiceResponse.UNTREATED.getValue());
        entity.setCreateTime(LocalDateTime.now());

        o_messageInfoDao.insertSelective(entity);
//        }
        return MapHelper.put("entity", entity).toMap();
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 获得岗位和岗位下的员工
     * @time 2017-6-14 15:56
     */
    public Map<String, Object> getTransferPersonList(Map<String, Object> paraMap) {
        List<Map<String, Object>> roleList = o_messageInfoDao.getRoleListByArchiveID(paraMap);
        Map<String, Object> totalRole = MapHelper.put("roleName", "全部岗位").put("roleID", 0).toMap();
        roleList.add(0, totalRole);
        List<Map<String, Object>> personList = o_messageInfoDao.getTransferPersonList(paraMap);
        return MapHelper.put("personList", personList).put("roleList", roleList).toMap();
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 根据roleID 获得岗位下的员工
     * @time 2017-6-14 15:56
     */
    public Map<String, Object> getTransferPersonListByRoleID(Map<String, Object> paraMap) {
        List<Map<String, Object>> personList = o_messageInfoDao.getTransferPersonList(paraMap);
        return MapHelper.put("personList", personList).toMap();
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description for轮询 获取最新消息
     * @time 2017-6-16 16:55
     */
    public Map<String, Object> getNewMessageList(Map<String, Object> paraMap) throws ParseException {
        Map<String, Object> resultMap = MapHelper.newMap();
        String source = MapUtils.getString(paraMap, MessageConstants.SOURCE);

        LocalDateTime newTime = DateUtils.parseLocalDateTime(paraMap.get("newTime").toString());
        paraMap.put("newTime",newTime);
        PageHelper.startPage(1, 50);
        List<Map<String, Object>> messageList = o_messageInfoDao.getMessageListByLastTime(paraMap);

        if(MessageConstants.WAITER_SOURCE.equals(source)){
            resultMap.put("hasNewMessage",messageList.size()>0);
            resultMap.put("newTime",newTime);
            return resultMap;
        }

        if (messageList.size() > 0) {
            Map<String, Object> item = messageList.get(0);
            newTime = (LocalDateTime) item.get("createTime");
        }
        resultMap.put("newTime", newTime);
        resultMap.put("messageList", messageList);

        if (MessageConstants.WEB_SOURCE.equals(source)) {
            Map<String, Object> messageCountByShowType = o_messageInfoDao.getMessageCountByShowType(paraMap);
            resultMap.put("count", messageCountByShowType.get("noHandlerNum"));
        }

        return resultMap;
    }


    /*=============================业务内部方法=================================*/

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 处理消息->受理->完成
     * @time 2017-5-18 14:20
     */
    private void updateOneMessage(Long sMSID, Long businessStatus, Long loginID) {
        Assert.notNull(sMSID, "sMSID is required");
        Assert.notNull(businessStatus, "businessStatus is required");
        Assert.notNull(loginID, "loginID is required");
        //消息检验有效性
        O_MessageInfoEntity o_messageInfoEntity = o_messageInfoDao.selectByPrimaryKey(sMSID);
        if (o_messageInfoEntity == null) {
            BizException.error(3, "找不到该消息");
        }
        Long recipientID = o_messageInfoEntity.getRecipientID();
        Long beforeBusinessStatus = o_messageInfoEntity.getBusinessStatus();
        if (beforeBusinessStatus.longValue() == MerchantManageEnum.ServiceResponse.PROCESSED.getValue()) {
            BizException.error("消息已被处理");
        } else if (businessStatus.longValue() == MerchantManageEnum.ServiceResponse.PROCESSING.getValue()
                && beforeBusinessStatus.longValue() == MerchantManageEnum.ServiceResponse.PROCESSING.getValue()) {
            BizException.error("消息已被受理");
        } else if (businessStatus.longValue() == MerchantManageEnum.ServiceResponse.PROCESSED.getValue()
                && beforeBusinessStatus.longValue() == MerchantManageEnum.ServiceResponse.UNTREATED.getValue()) {
            BizException.error("请先受理消息");
        }
        //更改消息处理人
        o_messageInfoEntity.setBusinessStatus(businessStatus);
        o_messageInfoEntity.setRecipientID(loginID);
        o_messageInfoDao.updateByPrimaryKeySelective(o_messageInfoEntity);
        //添加消息处理明细
        try {
            addMessageDealInfo(sMSID, loginID, recipientID, businessStatus, beforeBusinessStatus);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 添加消息处理信息(正常处理消息流程)
     * @time 2017-6-14 14:32
     */
    private void addMessageDealInfo(Long sMSID, Long loginID, Long recipientID, Long businessStatus, Long beforeBusinessStatus) {
        O_MessageDealInfoEntity o_messageDealInfoEntity = new O_MessageDealInfoEntity();
        o_messageDealInfoEntity.setDealID(MaxIDUtils.getID(o_messageDealInfoEntity));
        o_messageDealInfoEntity.setSMSID(sMSID);
        o_messageDealInfoEntity.setBeforeStatus(beforeBusinessStatus);
        o_messageDealInfoEntity.setAfterStatus(businessStatus);
        o_messageDealInfoEntity.setTransferID(recipientID);
        o_messageDealInfoEntity.setRecipientID(loginID);
        if (loginID.longValue() == recipientID.longValue()) {
            o_messageDealInfoEntity.setChangeReason("正常处理消息");
        } else {
            o_messageDealInfoEntity.setChangeReason("其他人处理初始消息");
        }
        Map<String, Object> userInfoMap = o_messageInfoDao.getUserInfo(loginID);
        String employeeCode = MapUtils.getString(userInfoMap, "employeeCode");
        if (employeeCode == null) {
            employeeCode = "未设置";
        }
        StringBuilder dealDesc = new StringBuilder("");
        dealDesc.append("工号(").append(employeeCode).append(")");
        if (businessStatus.longValue() == MerchantManageEnum.ServiceResponse.PROCESSING.getValue()) {
            dealDesc.append(MessageConstants.PAD_PROCESSING_MSG);
        } else if (businessStatus.longValue() == MerchantManageEnum.ServiceResponse.PROCESSED.getValue()) {
            dealDesc.append(MessageConstants.PAD_PROCESSED_MSG);
        } else {
            dealDesc.append("参数有误 错误的businessType");
        }
        o_messageDealInfoEntity.setDealDesc(dealDesc.toString());
        o_messageDealInfoEntity.setIsSync(false);
        o_messageDealInfoEntity.setCreatorID(loginID);
        o_messageDealInfoEntity.setCreateTime(LocalDateTime.now());

        o_messageDealInfoDao.insertSelective(o_messageDealInfoEntity);
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description 转发消息
     * @time 2017-5-18 15:06
     */
    private void transferOneMessage(Long sMSID, Long loginID, Long targetID) {
        Assert.notNull(sMSID, "sMSID is required");
        Assert.notNull(loginID, "loginID is required");
        Assert.notNull(targetID, "targetID is required");
        O_MessageInfoEntity o_messageInfoEntity = o_messageInfoDao.selectByPrimaryKey(sMSID);
        if (o_messageInfoEntity == null) {
            BizException.error(3, "消息不存在");
        }
        if (o_messageInfoEntity.getBusinessStatus().longValue() == MerchantManageEnum.ServiceResponse.PROCESSED.getValue()) {
            BizException.error("消息已处理");
        }
        o_messageInfoEntity.setRecipientID(targetID);
        o_messageInfoDao.updateByPrimaryKeySelective(o_messageInfoEntity);
        //添加消息处理记录
        O_MessageDealInfoEntity o_messageDealInfoEntity = new O_MessageDealInfoEntity();
        o_messageDealInfoEntity.setDealID(MaxIDUtils.getID(o_messageDealInfoEntity));
        o_messageDealInfoEntity.setSMSID(sMSID);
        o_messageDealInfoEntity.setBeforeStatus(o_messageInfoEntity.getBusinessStatus());
        o_messageDealInfoEntity.setAfterStatus(o_messageInfoEntity.getBusinessStatus());
        o_messageDealInfoEntity.setTransferID(loginID);
        o_messageDealInfoEntity.setRecipientID(targetID);
        Map<String, Object> userInfoMap = o_messageInfoDao.getUserInfo(loginID);
        Map<String, Object> targetInfoMap = o_messageInfoDao.getUserInfo(targetID);

        String userName = MapUtils.getString(userInfoMap, "nickName");
        String targetName = MapUtils.getString(targetInfoMap, "nickName");
        String desc = userName + "  转发消息给 (" + targetName + ")";
        o_messageDealInfoEntity.setChangeReason(desc);
        o_messageDealInfoEntity.setDealDesc(desc);
        o_messageDealInfoEntity.setIsSync(false);
        o_messageDealInfoEntity.setCreatorID(loginID);
        o_messageDealInfoEntity.setCreateTime(LocalDateTime.now());
        o_messageDealInfoDao.insertSelective(o_messageDealInfoEntity);
    }


    /**
     * @author LiSH
     * @version 2.0.0
     * @description settingID and dictionaryID 检查两者查询出的消息类型数据是否有效
     * @time 2017-6-5 13:59
     */
    private boolean checkMessageType(Map<String, Object> param) {
        Long i = o_messageInfoDao.checkMessageType(param);
        return i > 0;
    }

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 补全当天开始时间+当天结束时间
     * @time 2017-6-14 16:14
     */
    private void fillDayStartAndDayEnd(Map<String, Object> param, LocalDate date) {
        param.put("startTime", DateUtils.getDayStart(date));
        param.put("endTime", DateUtils.getDayEnd(date));
    }
/*==============================================初始化方法===========================*/

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 初始化服务类型方法
     * @time 2017-5-31 10:34
     */
    @Transactional
    public Map<String, Object> initBusinessList(Map<String, Object> paramMap) {
        List<Map<String, Object>> catalogList = o_messageInfoDao.getBusinessListDictionaryCatalog();
        int i = 0;
        for (Map<String, Object> map : catalogList) {
            Long settingID = MaxIDUtils.getID("O_MessageSettingInfo");
            map.put("settingID", settingID);
            map.put("sortNo", i++);
        }
        paramMap.put("list", catalogList);
        List<Map<String, Object>> initBusinessList = o_messageInfoDao.initBusinessList(paramMap);
        return MapHelper.put("initBusinessList", initBusinessList).toMap();
    }

/*=============================定时任务接口=================================*/

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 暴露对定时任务的接口 是否向上转发该消息
     * @time 2017-5-22 9:48
     */
    @Transactional
    public Map<String, Object> transferMessageUp(Map<String, Object> paraMap) {
        Long sMSID = MapUtils.getLong(paraMap, "sMSID");
        O_MessageInfoEntity o_messageInfoEntity = o_messageInfoDao.selectByPrimaryKey(sMSID);
        Long recipientID = o_messageInfoEntity.getRecipientID();
        List<Map<String, Object>> upLevelPersonList = o_messageInfoDao.getUpLevelPersonList(recipientID);
        for (Map<String, Object> upLevelPerson : upLevelPersonList) {
            try {
                transferOneMessage(sMSID, recipientID, MapUtils.getLong(upLevelPerson, "loginID"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public Map<String, Object> getOrderStatusBySubOrderID(Map<String, Object> paraMap) {
        return o_messageInfoDao.getOrderStatusBySubOrderID(paraMap);
    }
}
