package cc.toprank.byd.dao;

import cc.toprank.byd.vo.ProductInfoVO;
import cc.toprank.byd.vo.print.ProductDetailVO;
import cc.toprank.byd.vo.print.TableInfoVO;

import java.util.List;
import java.util.Map;


/**
 * @Description： 菜品Dao
 * @Author：LanZY
 * @Time: 2017-3-7 16:09
 * @Version 2.0.0
 */
public interface ProductInfoDao {

	/**
	 * @Description： 根据餐厅编号区域编号餐次编号分类编号查询所有菜品
	 * @Author：LanZY
	 * @Time: 2017-3-7 16:06
	 * @Version 2.0.0
	 */
	List<ProductInfoVO> getProductListByCondition(Map<String, Object> map);


	/**
	 * @Description： 根据餐厅编号区域编号餐次编号分类编号查询所有菜品
	 * @Author：LanZY
	 * @Time: 2017-3-7 16:06
	 * @Version 2.0.0
	 */
	List<ProductInfoVO> getProductList(Map<String, Object> map);


	/**
	 * @Description： 查询桌台信息打印数据
	 * @Author：LanZY
	 * @Time: 2017-6-13 13:00
	 * @Version 2.0.0
	 * @param subOrderID
	 * @return
	 */
	TableInfoVO getPrintTableBasic(Long subOrderID);

	/**
	 * @Description： 查询订单明细打印数据
	 * @Author：LanZY
	 * @Time: 2017-6-13 11:55
	 * @Version 2.0.0
	 * @param detailIDs
	 * @return
	 */
	List<ProductDetailVO> getPrintProductDetailBasic(List<Long> detailIDs);


	/**
	 * @Description： 查询套餐明细打印数据
	 * @Author：LanZY
	 * @Time: 2017-6-13 11:55
	 * @Version 2.0.0
	 * @param detailIDs
	 * @return
	 */
	List<ProductDetailVO> getPrintComboProductDetailBasic(List<Long> detailIDs);
}
