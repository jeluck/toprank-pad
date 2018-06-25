package cc.toprank.byd.web.service.menu;

import cc.toprank.byd.dao.P_ProductInfoDao;
import cc.toprank.byd.entity.P_ProductInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   B_AttachmentInfoService 真实的业务实现类，允许修改
 *   
 * ********************************************************************************************************************/
@Service("p_ProductInfoService") public class P_ProductInfoService {

	@Autowired
	private P_ProductInfoDao productInfoDao;

	public P_ProductInfoEntity get(P_ProductInfoEntity productInfo) throws Exception{
		return productInfoDao.get(productInfo);
	}
	public List<P_ProductInfoEntity> getAll() throws Exception{
		return productInfoDao.getAll();
	}

	public void update(P_ProductInfoEntity productInfo) throws Exception{
		productInfoDao.update(productInfo);
	}

	public void delete(P_ProductInfoEntity productInfo) throws Exception{
		productInfoDao.delete(productInfo);
	}

	public void save(P_ProductInfoEntity productInfo) throws Exception{
		productInfoDao.save(productInfo);
	}

	public P_ProductInfoEntity getP_ProductInfoEntityById(long productID) throws Exception{
		P_ProductInfoEntity p_productinfo = new P_ProductInfoEntity();
		p_productinfo.setProductID(productID);
		return productInfoDao.get(p_productinfo);
	}
}