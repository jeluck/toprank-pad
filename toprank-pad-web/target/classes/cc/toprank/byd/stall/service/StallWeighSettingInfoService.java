package cc.toprank.byd.stall.service;

import cc.toprank.byd.dao.B_StallWeighSettingInfoDao;
import cc.toprank.byd.entity.B_StallWeighSettingInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 档口称重配置
 * Created by HuangCY on 2017-3-15.
 */
@Service
public class StallWeighSettingInfoService {
    @Autowired
    private B_StallWeighSettingInfoDao stallWeighSettingInfoMapper;

    /**
     * 根据档口ID查询档口称重配置信息
     * @Author HuangCY
     * @Time 2017-3-15
     * @param stallID
     * @return
     */
    public B_StallWeighSettingInfoEntity queryStallWeighSettingInfoByStallID (Long stallID) {
        return stallWeighSettingInfoMapper.selectByPrimaryKey(stallID);
    }
}
