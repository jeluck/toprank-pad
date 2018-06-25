package cc.toprank.byd.stall.service;

import cc.toprank.byd.dao.B_DinningTableInfoDao;
import cc.toprank.byd.entity.B_DinningTableInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 桌台信息
 * Created by HuangCY on 2017-3-14.
 */
@Service
public class DinningTableInfoService {
    @Autowired
    private B_DinningTableInfoDao dinningTableInfoMapper;

    /**
     * 按条件查询桌台信息
     * @author HuangCY
     * @Time 2017-3-14
     * @param map
     * @return
     */
    public List<B_DinningTableInfoEntity> queryDinningTableInfoByCondition (Map map){
        return dinningTableInfoMapper.queryDinningTableInfoByCondition(map);
    }
}
