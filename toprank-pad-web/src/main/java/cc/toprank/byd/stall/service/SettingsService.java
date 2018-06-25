package cc.toprank.byd.stall.service;

import cc.toprank.byd.dao.B_StallWeighContentInfoDao;
import cc.toprank.byd.dao.B_StallWeighSettingInfoDao;
import cc.toprank.byd.entity.B_StallWeighContentInfoEntity;
import cc.toprank.byd.entity.B_StallWeighSettingInfoEntity;
import cc.toprank.byd.stall.dto.StallWeighSettingInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础信息设置
 *
 * @author ZhaoLC
 * @Time 2017-3-13 14:00
 */
@Service
public class SettingsService {
    @Autowired
    private B_StallWeighSettingInfoDao stallWeighSettingInfoMapper;

    @Autowired
    private B_StallWeighContentInfoDao stallWeighContentInfoMapper;

    /**
     * 根据主键查询称重档口基础信息
     *
     * @author ZhaoLC
     * @Time 2017-3-13 14:00
     */
    public B_StallWeighSettingInfoEntity selectStallWeighSettingInfo(Long stallID) {
        return stallWeighSettingInfoMapper.selectByPrimaryKey(stallID);
    }

    /**
     * 根据档口ID 查询称重档口看板内容
     *
     * @author ZhaoLC
     * @Time 2017-3-13 14:00
     */
    public List<B_StallWeighContentInfoEntity> selectStallWeighContentInfoList(Long stallID) {
        return stallWeighContentInfoMapper.selectStallWeighContentInfoList(stallID);
    }

    /**
     * @description：g根据档口ID获取档口配置信息
     * @author：ZhaoLC
     * @time: 2017-3-16 11:00
     * @version 2.0.0
     */
    public B_StallWeighSettingInfoEntity getStallWeighSettingByID(Long stallID) {
        return stallWeighSettingInfoMapper.selectByPrimaryKey(stallID);
    }

    /**
     * @description：获取档口配置信息
     * @author：ZhaoLC
     * @time: 2017-3-16 11:00
     * @version 2.0.0
     */
    public List<B_StallWeighSettingInfoEntity> getStallWeighSettingInfoAll(Long archiveID) {
        return stallWeighSettingInfoMapper.selectStallWeighSettingInfoAll(archiveID);
    }

    /**
     * 更新称重档口基础信息
     *
     * @author ZhaoLC
     * @Time 2017-3-13 14:00
     */
    @Transactional
    public boolean updateStallWeighSettingInfo(StallWeighSettingInfoVO stallWeighSettingInfoVO) {
        B_StallWeighSettingInfoEntity stallWeighSettingInfo = new B_StallWeighSettingInfoEntity();
        BeanUtils.copyProperties(stallWeighSettingInfoVO, stallWeighSettingInfo);
        stallWeighSettingInfoMapper.updateByPrimaryKeySelective(stallWeighSettingInfo);//更新称重档口配置信息

        if (stallWeighSettingInfoVO.getStallWeighContentInfoList() == null || stallWeighSettingInfoVO.getStallWeighContentInfoList().size() == 0) {
            return true;
        }

        List<B_StallWeighContentInfoEntity> stallWeighContentInfoList = new ArrayList<>();
        BeanUtils.copyProperties(stallWeighSettingInfoVO.getStallWeighContentInfoList(), stallWeighContentInfoList);

        //批量更新称重档口 看板内容
        for (B_StallWeighContentInfoEntity stallWeighContentInfo : stallWeighContentInfoList) {
            stallWeighContentInfoMapper.updateByPrimaryKeySelective(stallWeighContentInfo);
        }
        return true;
    }
}
