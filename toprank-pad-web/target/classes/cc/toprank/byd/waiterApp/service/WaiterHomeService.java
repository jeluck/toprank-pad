package cc.toprank.byd.waiterApp.service;

import cc.toprank.byd.common.utils.MapHelper;
import cc.toprank.byd.dao.CommonMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author LiSH
 * @version 2.0.0
 * @time 2017-6-14 10:17
 */
@Service
public class WaiterHomeService {

    /**
     * @author LiSH
     * @version 2.0.0
     * @description 根据loginID 获得所负责的桌台
     * @time 2017-6-14 14:07
     */
    public Map<String, Object> getManagerTableList(Map<String, Object> param) throws Exception {
        List<Map<String, Object>> managerTableList = CommonMapper.getManagerTableList(param);
        return MapHelper.put("managerTableList",managerTableList).toMap();
    }
}
