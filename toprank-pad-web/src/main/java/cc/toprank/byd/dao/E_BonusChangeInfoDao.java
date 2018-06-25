package cc.toprank.byd.dao;

import cc.toprank.byd.entity.E_BonusChangeInfoEntity;

import java.util.List;

/**
 * Created by HuTao on 2017-5-31.
 */
public interface E_BonusChangeInfoDao {
    E_BonusChangeInfoEntity get(E_BonusChangeInfoEntity InfoEntity);

    E_BonusChangeInfoEntity getBonusChangeInfoByBusinessID(Long businessID);

    List<E_BonusChangeInfoEntity> getAll();

    int update(E_BonusChangeInfoEntity InfoEntity);

    void delete(E_BonusChangeInfoEntity InfoEntity);

    void save(E_BonusChangeInfoEntity InfoEntity);

}
