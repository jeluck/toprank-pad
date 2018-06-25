package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_DutyInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by HuTao on 2017-5-16.
 */
public interface B_DutyInfoDao {
    B_DutyInfoEntity get(B_DutyInfoEntity InfoEntity);

    List<B_DutyInfoEntity> getAll();

    int update(B_DutyInfoEntity InfoEntity);

    void delete(B_DutyInfoEntity InfoEntity);

    void save(B_DutyInfoEntity InfoEntity);

    List<Map<String,Object>> getDeskRole();

}
