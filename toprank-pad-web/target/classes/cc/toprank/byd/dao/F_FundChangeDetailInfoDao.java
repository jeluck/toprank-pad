package cc.toprank.byd.dao;

import cc.toprank.byd.entity.F_FundChangeDetailInfoEntity;

import java.util.List;

/**
 * 资金变动明细
 * Created by HuangCY on 2017-4-11.
 */
public interface F_FundChangeDetailInfoDao {

    List<F_FundChangeDetailInfoEntity> getAll();

    void update(F_FundChangeDetailInfoEntity f_fundchangedetailinfo);

    void delete(F_FundChangeDetailInfoEntity f_fundchangedetailinfo);

    void save(F_FundChangeDetailInfoEntity f_fundchangedetailinfo);

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description
     * @time 2017-6-18 17:35
     */
    void saveFundChangeDetailInfo(F_FundChangeDetailInfoEntity f_fundchangedetailinfo);
}
