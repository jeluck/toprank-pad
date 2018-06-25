package cc.toprank.byd.dao;

import cc.toprank.byd.vo.ProductInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * @Description： 日结Dao
 * @Author：LinYN
 * @Time: 2017-5-27
 * @Version 2.0.0
 */
public interface DailyTaskDao {

	/**
	 * @Description：日结时将桌台使用信息清理，设置结束时间
	 * @Author：LinYN
	 * @Time: 2017-5-27
	 */
	void resetTableUseInfo();

	/**
	 * @Description：日结时将桌台信息清理，状态设置为空台，消除关联属性
	 * @Author：LinYN
	 * @Time: 2017-5-27
	 */
	void resetTableInfo();

	/**
	 * @Description：日结时将子订单改成己完成
	 * @Author：LinYN
	 * @Time: 2017-5-27
	 */
	void resetSubOrderInfo();

	/**
	 * @Description：日结时将主订单改成己完成
	 * @Author：LinYN
	 * @Time: 2017-5-27
	 */
	void resetOrderInfo();

	/**
	 * @Description：日结时重置餐次桌台信息
	 * @Author：LinYN
	 * @Time: 2017-5-27
	 */
	void resetMealTableMapping();

}
