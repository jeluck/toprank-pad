package cc.toprank.byd.dao;


import cc.toprank.byd.entity.O_OrderDealInfoEntity;

import java.util.List;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   O_OrderDealInfo数据访问类
 * 
 * ********************************************************************************************************************/
public interface O_OrderDealInfoDao{
	int deleteByPrimaryKey(Long dealid);

	int insert(O_OrderDealInfoEntity record);

	int insertSelective(O_OrderDealInfoEntity record);

	O_OrderDealInfoEntity selectByPrimaryKey(Long dealid);

	int updateByPrimaryKeySelective(O_OrderDealInfoEntity record);

	int updateByPrimaryKey(O_OrderDealInfoEntity record);

	O_OrderDealInfoEntity get(O_OrderDealInfoEntity orderDealInfo);

	List<O_OrderDealInfoEntity> getAll();

	void update(O_OrderDealInfoEntity orderDealInfo);

	void delete(O_OrderDealInfoEntity orderDealInfo);

	void save(O_OrderDealInfoEntity orderDealInfo);
}