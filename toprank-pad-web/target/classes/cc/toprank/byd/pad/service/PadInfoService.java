package cc.toprank.byd.pad.service;

import cc.toprank.byd.dao.*;
import cc.toprank.byd.entity.*;
import cc.toprank.byd.enums.CommonManageEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 2.0.0
 * @description：水牌信息服务
 * @author：LiYC
 * @time: 2017-2-21 9:55
 */
@Service
public class PadInfoService {

    @Autowired
    private B_PadInfoDao b_padInfoMapper;
    @Autowired
    private B_DinningTableInfoDao b_dinningTableInfoMapper;
    @Autowired
    private B_TableManagerInfoDao tableManagerDAO;

    /**
     * @param imei      水牌串号
     * @param archiveId 档案编号
     * @return
     * @description：查询水牌信息
     * @author：LiYC
     * @time: 2017-2-20 17:19
     * @version 2.0.0
     */
    public B_PadInfoEntity queryPadInfoByIMEI(String imei, Long archiveID) {
//        B_PadInfoEntity b_padInfo = new B_PadInfoEntity();
//        b_padInfo.setIMEICode(imei);
//        b_padInfo.setArchiveID(archiveId);
        return b_padInfoMapper.selectByImei(archiveID, imei);
    }

    /**
     * @param padId
     * @return
     * @description：根据水牌信息获取目前绑定的桌台信息(绑定中的桌台)
     * @author：LiYC
     * @time: 2017-2-20 17:19
     * @version 2.0.0
     */
    public B_DinningTableInfoEntity queryDinningTableInfoByPad(Long padID) {
        Long mappingStatus = CommonManageEnum.DrinkMappingStatus.INUNLEGAME.getValue();//查询绑定中的桌台
        return b_dinningTableInfoMapper.queryDinningTableInfoByPadID(padID, mappingStatus);
    }

    /**
     * @description 获得桌台负责人列表
     * @author LiSH
     * @time 2017-3-1 9:49
     * @version 2.0.0
     */
//    public List<B_TableManagerInfo> queryTableManagerByTableID(Long tableID) {
//        return tableManagerDAO.selectByTableID(tableID);
//    }
}
