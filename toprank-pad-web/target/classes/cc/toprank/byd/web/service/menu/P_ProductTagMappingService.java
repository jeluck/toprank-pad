package cc.toprank.byd.web.service.menu;

import cc.toprank.byd.dao.P_ProductTagMappingDao;
import cc.toprank.byd.entity.P_ProductTagMappingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品标签关联
 * Created by HuangCY on 2017-5-16.
 */
@Service("p_ProductTagMappingService")
public class P_ProductTagMappingService {

    //商品标签关联信息
    @Autowired
    private P_ProductTagMappingDao P_ProductTagMappingDao;

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 新增商品标签关联信息
     * @time 2017-5-16 14:26
     */
    @Transactional
    public void insertProductTagMappingInfo(P_ProductTagMappingEntity entity) throws Exception{
        P_ProductTagMappingDao.insert(entity);
    }
}
