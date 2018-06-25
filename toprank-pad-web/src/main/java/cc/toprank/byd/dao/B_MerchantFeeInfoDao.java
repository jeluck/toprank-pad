package cc.toprank.byd.dao;

import cc.toprank.byd.entity.B_MerchantFeeInfoEntity;

/**
 * 商户服务收费信息
 * Created by HuangCY on 2017-5-18.
 */
public interface B_MerchantFeeInfoDao {

    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 根据档案编号,区域ID,餐次ID获取商服务收费信息
     * @time 2017-5-18 11:32
     */
    B_MerchantFeeInfoEntity getMerchantFeeInfoByCondition(B_MerchantFeeInfoEntity merchantFeeInfoEntity);
}
