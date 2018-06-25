package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_ChangeShiftsInfoEntity;

import java.util.List;

/**
 * Created by HuTao on 2017-5-16.
 */
public interface B_ChangeShiftsInfoDao {
    B_ChangeShiftsInfoEntity get(B_ChangeShiftsInfoEntity InfoEntity);

    List<B_ChangeShiftsInfoEntity> getAll();

    int update(B_ChangeShiftsInfoEntity InfoEntity);

    void delete(B_ChangeShiftsInfoEntity InfoEntity);

    void save(B_ChangeShiftsInfoEntity InfoEntity);

    List<B_ChangeShiftsInfoEntity> getHisChangeInfo(String tableCode);
}
