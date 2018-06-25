package cc.toprank.byd.service;
import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.B_StallProduceMappingDao;
import cc.toprank.byd.dao.B_StallWeighDealInfoDao;
import cc.toprank.byd.dao.B_StallWeighInfoDao;
import cc.toprank.byd.dao.B_StallWeighSettingInfoDao;
import cc.toprank.byd.entity.B_StallProduceMappingEntity;
import cc.toprank.byd.entity.B_StallWeighDealInfoEntity;
import cc.toprank.byd.entity.B_StallWeighInfoEntity;
import cc.toprank.byd.entity.B_StallWeighSettingInfoEntity;
import cc.toprank.byd.enums.OrderManagerEnum;
import cc.toprank.byd.enums.SystemManageEnum;
import cc.toprank.byd.util.MaxIDUtils;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LanZY on 2017-5-16.
 */
@Service("stallWeighService")
public class StallWeighService {
    @Autowired
    B_StallWeighInfoDao stallWeighInfoDao;
    @Autowired
    B_StallProduceMappingDao stallProduceMappingDao;
    @Autowired
    B_StallWeighSettingInfoDao stallWeighSettingInfoDao;
    @Autowired
    B_StallWeighDealInfoDao stallWeighDealInfoDao;

    /**
     * @Description： 新增称重档口信息
     * @Author：LanZY
     * @Time: 2017-5-16 14:54
     * @Version 2.0.0
     * @param orderDetailIDs
     */
    public void addStallWeighInfo(List<Long> orderDetailIDs) {
        //根据订单明细查询称重商品关联数据
        List<B_StallWeighInfoEntity> stallWeighInfoList = stallWeighInfoDao.getStallWeighInfoByDetailIDs(StringUtils.join(orderDetailIDs.toArray(), ","));
        List<B_StallWeighDealInfoEntity> stallWeighDealInfoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(stallWeighInfoList)) {
            handleStallWeigh(stallWeighInfoList,stallWeighDealInfoList);
            if(CollectionUtils.isNotEmpty(stallWeighDealInfoList)){
                stallWeighInfoDao.insertBatch(stallWeighInfoList);
                stallWeighDealInfoDao.insertBatch(stallWeighDealInfoList);
            }
        }
    }

    /**
     * @Description：称重档口处理
     * @Author：LanZY
     * @Time: 2017-5-16 14:54
     * @Version 2.0.0
     * @param stallWeighInfoList
     */
    protected void handleStallWeigh(List<B_StallWeighInfoEntity> stallWeighInfoList,List<B_StallWeighDealInfoEntity> stallWeighDealInfoList) {
        //根据档案ID查询称重档口配置信息
        B_StallWeighSettingInfoEntity stallWeighSettingInfo = new B_StallWeighSettingInfoEntity();
        stallWeighSettingInfo.setArchiveID(stallWeighInfoList.get(0).getArchiveID());
        stallWeighSettingInfo.setStallStatus(SystemManageEnum.EntityStatus.NORMAL.getValue());
        List<B_StallWeighSettingInfoEntity> stallSetList = stallWeighSettingInfoDao.getStallWeighSettingListByArchiveIDAndStallStatus(stallWeighSettingInfo);
        if (CollectionUtils.isNotEmpty(stallSetList)) {
            //基本信息赋值
            for (B_StallWeighInfoEntity stallWeighInfo : stallWeighInfoList) {
                B_StallProduceMappingEntity stallProduceMappingInfo = stallProduceMappingDao.getStallProduceMappingInfoByVariantID(stallWeighInfo.getVariantID());
                if(null != stallProduceMappingInfo){
                    stallWeighInfo.setWeighID(MaxIDUtils.getID(B_StallWeighInfoEntity.class));
                    stallWeighInfo.setStallID(stallProduceMappingInfo.getStallID());
                    stallWeighInfo.setNeedConfirm(stallProduceMappingInfo.getNeedConfirm());
                    stallWeighInfo.setCreateTime(LocalDateTime.now());
                    stallWeighInfo.setSubNumber(1);

                    //变动信息
                    B_StallWeighDealInfoEntity stallWeighDealInfo = new B_StallWeighDealInfoEntity();
                    stallWeighDealInfo.setDealID(MaxIDUtils.getID(B_StallWeighDealInfoEntity.class));
                    stallWeighDealInfo.setStallID(stallProduceMappingInfo.getStallID());
                    stallWeighDealInfo.setChangeDetail("新增");
                    stallWeighDealInfo.setDealDesc("新增");
                    stallWeighDealInfo.setCreatorID(stallWeighInfo.getCreatorID());
                    stallWeighDealInfo.setCerateTime(LocalDateTime.now());
                    stallWeighDealInfo.setAfterStatus(OrderManagerEnum.ProductionStatus.PENDINGWEIGH.getValue());
                    stallWeighDealInfoList.add(stallWeighDealInfo);
                }else{
                    throw new BizException(CodeMsgConstants.WEIGH_PRODUCT_NOT_EXIST,CodeMsgConstants.WEIGH_PRODUCT_NOT_EXIST_MSG,stallWeighInfo.getVariantID());
                }

            }
        }
    }


}
