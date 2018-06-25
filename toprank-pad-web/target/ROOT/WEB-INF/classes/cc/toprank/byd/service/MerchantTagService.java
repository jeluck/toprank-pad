package cc.toprank.byd.service;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.B_MerchantTagInfoDao;
import cc.toprank.byd.dao.B_MerchantTagMappingDao;
import cc.toprank.byd.dao.O_ComboDetailInfoDao;
import cc.toprank.byd.entity.B_MerchantTagInfoEntity;
import cc.toprank.byd.entity.B_MerchantTagMappingEntity;
import cc.toprank.byd.enums.CommonManageEnum;
import cc.toprank.byd.enums.SystemManageEnum;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.util.ResultHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 商户标签公用service
 *
 * @author LeeJun
 * @create 2017-05-23 9:51
 */
@Service
public class MerchantTagService {

    @Autowired
    private B_MerchantTagMappingDao merchantTagMappingDao;
    @Autowired
    private B_MerchantTagInfoDao merchantTagInfoDao;
    @Autowired
    private O_ComboDetailInfoDao comboDetailInfoDao;

    /**
     * 添加订单菜品明细标签
     *
     * @author LeeJun
     * @time 2017-5-22 18:38
     * @version 2.0.0
     */
    public boolean addOrderDetailTag(String orderDetailIDs, Long archiveID, String tagCode) {
        B_MerchantTagInfoEntity tagInfo = merchantTagInfoDao.getByTagCode(tagCode);
        if (tagInfo == null) {
            throw new BizException("未配置相应的标签: " + tagCode);
        }
        B_MerchantTagMappingEntity tagMapping = null;
        List<B_MerchantTagMappingEntity> tagMappingList = new ArrayList<>();
        List<String> detailIDs = Arrays.asList(orderDetailIDs.split(","));
        for (String detailID : detailIDs) {
            tagMapping = new B_MerchantTagMappingEntity();
            tagMapping.setMappingID(MaxIDUtils.getID(B_MerchantTagMappingEntity.class));
            tagMapping.setMappingStatus(SystemManageEnum.EntityStatus.NORMAL.getValue());
            tagMapping.setArchiveID(archiveID);
            tagMapping.setTagID(tagInfo.getTagID());
            tagMapping.setTargetType(CommonManageEnum.GoalsType.ORDER_DETAILS.getValue());
            tagMapping.setTargetID(Long.parseLong(detailID));
            tagMapping.setCreatorID(1L);
            tagMapping.setCreateTime(LocalDateTime.now());
            tagMappingList.add(tagMapping);
        }
        // 查询订单套餐菜品
        List<Long> comboRecordIDs = comboDetailInfoDao.getComboRecordIDByDetailIDs(detailIDs);
        for (Long recordID : comboRecordIDs) {
            tagMapping = new B_MerchantTagMappingEntity();
            tagMapping.setMappingID(MaxIDUtils.getID(B_MerchantTagMappingEntity.class));
            tagMapping.setMappingStatus(SystemManageEnum.EntityStatus.NORMAL.getValue());
            tagMapping.setArchiveID(archiveID);
            tagMapping.setTagID(tagInfo.getTagID());
            tagMapping.setTargetType(CommonManageEnum.GoalsType.PACKAGE_DETAILS.getValue());
            tagMapping.setTargetID(recordID);
            tagMapping.setCreatorID(1L);
            tagMapping.setCreateTime(LocalDateTime.now());
            tagMappingList.add(tagMapping);
        }
        return ResultHelper.retBool(merchantTagMappingDao.insertBatch(tagMappingList));
    }
}
