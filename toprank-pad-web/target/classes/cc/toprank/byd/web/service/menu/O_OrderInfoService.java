package cc.toprank.byd.web.service.menu;

import cc.toprank.byd.dao.O_OrderInfoDao;
import cc.toprank.byd.entity.O_OrderInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**********************************************************************************************************************
 * 
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司 B_AttachmentInfoService 真实的业务实现类，允许修改
 * 
 ********************************************************************************************************************/
@Service("o_OrderInfoService")
public class O_OrderInfoService  {

	@Autowired
	private O_OrderInfoDao orderInfoDao;


	public O_OrderInfoEntity get(O_OrderInfoEntity orderInfo) throws Exception{
		return orderInfoDao.get(orderInfo);
	}
	public List<O_OrderInfoEntity> getAll() throws Exception{
		return orderInfoDao.getAll();
	}

	public int update(O_OrderInfoEntity orderInfo) throws Exception{
		return orderInfoDao.update(orderInfo);
	}

	public void delete(O_OrderInfoEntity orderInfo) throws Exception{
		orderInfoDao.delete(orderInfo);
	}

	public void save(O_OrderInfoEntity orderInfo) throws Exception{
		orderInfoDao.save(orderInfo);
	}

	/**
	 * 修改订单总额和实际金额
	 * @author LanZY
	 * @throws Exception
	 */
	public void updateOrderInfoByOrderID(O_OrderInfoEntity orderInfo) throws Exception {
		orderInfoDao.updateOrderInfoByOrderID(orderInfo);
	}


	/**
	 * 根据桌台id，餐次ID，查询，返回实体类
	 * @return
	 * @author xuexin
	 */
	public O_OrderInfoEntity getOrderInfoEntity(Map<String, Object> orderinfoMap) {
		return orderInfoDao.getOrderInfoEntity(orderinfoMap);
	}
	
	/**
	 * 根据订单开始时间，结束时间，桌台号，订单编码，餐次id，订单状态，档案id来查询相关订单
	 * @return
	 * @author xuexin
	 */
	public List<O_OrderInfoEntity> getOrderCenterInfoList(Map<String, Object> map) {
		return orderInfoDao.getOrderCenterInfoList(map);
	}
	
	/**
	 * 新增订单
	 * @return
	 * @author xuexin
	 */
	public Long saveOrderInfoEntity(O_OrderInfoEntity o_orderinfo) throws Exception {
		return orderInfoDao.saveOrderInfoEntity(o_orderinfo);
	}
	
	/**
	   * 根据订单编号查询订单信息
	   * @author HuangCY
	   * @param orderID
	   * @return
	   */
	public O_OrderInfoEntity  queryByOrderID (Long orderID) throws Exception{
	    O_OrderInfoEntity entity = new O_OrderInfoEntity();
	    //设置订单编号
	   entity.setOrderID(orderID);
	   return orderInfoDao.get(entity);
	}
	
	/**
	 * 根据订单编号改变订单状态
	 * @author HuangCY
	 * @param orderID
	 * @throws Exception
	 */
	public void updateOrderInfoStatus (Long orderID)  throws Exception{
	  O_OrderInfoEntity entity = new O_OrderInfoEntity();
	    //设置订单状态    68为已完成
	    entity.setOrderStatus(68L);
	    //设置支付状态    190为已支付
	    entity.setPayStatus(190L);
	    //设置订单编号
	    entity.setOrderID(orderID);
	    orderInfoDao.updateOrderInfoStatus(entity);
	}  
	
	/**
	 * 根据订单编号改变订单折扣金额和实际金额
	 * @author HuangCY
	 * @param orderID
	 * @param discountAmount
	 * @throws Exception
	 */
	public void updateAmountByOrderID (Long orderID , double discountAmount , double totalAmount) throws Exception {
	  O_OrderInfoEntity entity = new O_OrderInfoEntity();
	  //设置订单编号
	  entity.setOrderID(orderID);
	  
	  //根据订单编号查询
	  O_OrderInfoEntity entity2 = orderInfoDao.get(entity);
	  
	  BigDecimal discountAmount2 = null;
	  if(null != entity2.getDiscountAmount()){
        //计算后的折扣金额
        discountAmount2 = entity2.getDiscountAmount().add(BigDecimal.valueOf(discountAmount));
        //折扣金额
        entity.setDiscountAmount(discountAmount2);
       
        //如果总额减去折扣金额大于0才相减求出实际金额，否则直接置为0
        if(totalAmount - discountAmount2.doubleValue() > 0){
          //实际金额 = 总额 - 折扣金额
          entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(discountAmount2));
        }else{
          entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(BigDecimal.valueOf(totalAmount)));
        }
      }else{
        discountAmount2 = BigDecimal.valueOf(discountAmount);
        //折扣金额
        entity.setDiscountAmount(discountAmount2);
        
        //如果总额减去折扣金额大于0才相减求出实际金额，否则直接置为0
        if(totalAmount - discountAmount2.doubleValue() > 0){
          //实际金额 = 总额 - 折扣金额
          entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(discountAmount2));
        }else{
          entity.setActualAmount(BigDecimal.valueOf(totalAmount).subtract(BigDecimal.valueOf(totalAmount)));
        }
      }  
	  
	  orderInfoDao.updateAmountByOrderID(entity);
	}
	
	/**
	 * 根据订单,桌台号，订单编码，餐次id，订单状态，档案id来查询一条订单，进行中的订单
	 * @return
	 * @author xuexin
	 */
	public O_OrderInfoEntity getOrderInfoEntityByTableIDAndOrderStatus(Map<String, Object> map) {
		return orderInfoDao.getOrderInfoEntityByTableIDAndOrderStatus(map);
	}
	
	public O_OrderInfoEntity getById(Long orderID) throws Exception{
		O_OrderInfoEntity entity = new O_OrderInfoEntity();
		entity.setOrderID(orderID);
		return orderInfoDao.get(entity);
	}


	/**
	 * @author Zhaolingcen
	 * @version 2.0.0
	 * @description  查询用户消费记录
	 * @time 2017-05-20 11:00:00
	 */
	public List<Map<String, Object>> getConsumeRecordInfo(Map<String, Object> param){
		return orderInfoDao.getConsumeRecordInfo(param);
	}
}