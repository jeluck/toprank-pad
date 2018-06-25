package cc.toprank.byd.dao;

import cc.toprank.byd.entity.F_DepositDealInfoEntity;

import java.util.List;

/**
 * Created by HuTao on 2017-5-11.
 */
public interface F_DepositDealInfoDao {

    F_DepositDealInfoEntity get(F_DepositDealInfoEntity InfoEntity);

    List<F_DepositDealInfoEntity> getAll();

    int update(F_DepositDealInfoEntity InfoEntity);

    void delete(F_DepositDealInfoEntity InfoEntity);

    void save(F_DepositDealInfoEntity InfoEntity);
}
