package cc.toprank.byd.web.service.menu;

import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.dao.B_MerchantInfoDao;
import cc.toprank.byd.entity.B_MerchantInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************************************************************************
 *
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   B_AttachmentInfoService 真实的业务实现类，允许修改
 *
 * ********************************************************************************************************************/
@Service("b_MerchantInfoService")
public class B_MerchantInfoService {
    @Autowired
    protected B_MerchantInfoDao merchantInfoDao;

    public B_MerchantInfoEntity get(B_MerchantInfoEntity b_merchantinfo) throws Exception{
        return merchantInfoDao.get(b_merchantinfo);
    }
    public List<B_MerchantInfoEntity> getAll() throws Exception{
        return merchantInfoDao.getAll();
    }

    public void update(B_MerchantInfoEntity b_merchantinfo) throws Exception{
        merchantInfoDao.update(b_merchantinfo);
    }

    public void delete(B_MerchantInfoEntity b_merchantinfo) throws Exception{
        merchantInfoDao.delete(b_merchantinfo);
    }

    public void save(B_MerchantInfoEntity b_merchantinfo) throws Exception{
        merchantInfoDao.save(b_merchantinfo);
    }
    /**
     * 根据机构编号查询商户档案信息
     *
     * @param orgID
     * @return
     * @author LanZY
     */
    public B_MerchantInfoEntity getMerchantInfoByOrgID(Long orgID) {
        return merchantInfoDao.getMerchantInfoByOrgID(orgID);
    }

    /**
     * 根据机构编号查询商户档案信息
     *
     * @param orgID
     * @return
     * @author HuangCY
     */
    public B_MerchantInfoEntity queryByOrgID(Long orgID) {
        B_MerchantInfoEntity entity = new B_MerchantInfoEntity();
        //设置机构编号
        entity.setOrgID(orgID);
        return merchantInfoDao.queryByOrgID(entity);
    }

    /**
     * 根据档案编号查询商户档案信息
     *
     * @return
     * @author LanZY
     */
    public B_MerchantInfoEntity getMerchantInfoOrgByArchiveID(Long archiveID){
        return merchantInfoDao.getMerchantInfoOrgByArchiveID(archiveID);
    }

    /**
     * 查询数据库唯一一条商户档案信息
     * @author LeeJun
     * @time 2017-6-12 17:37
     * @version 2.0.0
     */
    public B_MerchantInfoEntity getMerchantInfoByOnly() {
        B_MerchantInfoEntity merchantInfo = merchantInfoDao.selectByListByOnly();
        if(merchantInfo == null){
            throw new BizException("未找到商家信息！");
        }
        return merchantInfo;
    }
}