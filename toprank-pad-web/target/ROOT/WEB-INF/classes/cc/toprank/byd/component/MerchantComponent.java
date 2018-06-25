package cc.toprank.byd.component;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.dao.B_MerchantInfoDao;
import cc.toprank.byd.dao.U_OrganizationInfoDao;
import cc.toprank.byd.entity.B_MerchantInfoEntity;
import cc.toprank.byd.entity.U_OrganizationInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author LinYN
 * @date 2017-6-13
 */
@Component
public class MerchantComponent {

    @Autowired
    private B_MerchantInfoDao merchantInfoDao;

    @Autowired
    private U_OrganizationInfoDao organizationInfoDao;

    /**
     * 查询当前商家档案信息
     *
     * @return B_MerchantInfoEntity
     *
     * @author LinYN
     * @date 2017-6-13
     */
    public B_MerchantInfoEntity getCurrentMerchantInfo() {
        B_MerchantInfoEntity merchantInfo = merchantInfoDao.selectByListByOnly();
        if (merchantInfo == null) {
            throw new RuntimeException("找不到当前商家档案信息！！！");
        }
        return merchantInfo;
    }

    /**
     * 查询当前商家机构信息
     *
     * @return B_MerchantInfoEntity
     *
     * @author LinYN
     * @date 2017-6-14
     */
    public U_OrganizationInfoEntity getCurrentOrganizationInfo() {
        U_OrganizationInfoEntity orgInfo = organizationInfoDao.getCurrentOrganizationInfo();
        if (orgInfo == null) {
            throw new RuntimeException("找不到当前商家机构信息！！！");
        }
        return orgInfo;
    }
}
