package cc.toprank.byd.service;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.toprank.byd.dao.SystemMaxIDDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class SystemMaxIDService {

    @Autowired
    SystemMaxIDDao systemMaxIDDAO;

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Long getMaxID2(String tableName) {
        Long maxID = 0l;
        return systemMaxIDDAO.getMaxID2(tableName, maxID);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Long getMaxID(String tableName) {
        Map<String, Object> param = new HashMap<>();
        param.put("tableName", tableName);
        param.put("applier", "admin");
        param.put("maxID", null);
        systemMaxIDDAO.getMaxID(param);
        return MapUtils.getLong(param, "maxID");
    }
}
