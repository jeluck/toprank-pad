package cc.toprank.byd.web.service.payment;

import cc.toprank.byd.dao.F_FundChangeInfoDao;
import cc.toprank.byd.entity.F_FundChangeInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 资金变动信息
 * Created by HuangCY on 2017-5-2.
 */
@Service("fundChangeInfoService")
public class FundChangeInfoService {

    //资金变动信息
    @Autowired
    private F_FundChangeInfoDao f_FundChangeInfoDao;

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 新增资金变动信息并返回主键
     * @time 2017-4-11 11:18
     */
    @Transactional
    long addFundChangeInfo(F_FundChangeInfoEntity entity) throws Exception {
        f_FundChangeInfoDao.saveFundChangeInfo(entity);

        return entity.getChangeID();
    }
}
