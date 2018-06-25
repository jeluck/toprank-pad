package cc.toprank.byd.dao;

import cc.toprank.byd.dto.common.MerchantBusinessDTO;
import cc.toprank.byd.entity.B_TableManagerInfoEntity;

import java.util.List;
import java.util.Map;

public interface CommonDao {
    Map<String,Object> getCurrentTableManager(Map<String, Object> param);

    List<Map<String,Object>> getManagerTableList(Map<String, Object> param);

    MerchantBusinessDTO getMerchantBusinessDate(Map param);
}