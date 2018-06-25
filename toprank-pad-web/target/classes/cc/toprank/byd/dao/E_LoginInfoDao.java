package cc.toprank.byd.dao;


import cc.toprank.byd.entity.E_LoginInfoEntity;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 * 
 * 版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 * E_LoginInfo数据访问类
 * 
 ********************************************************************************************************************/

public interface E_LoginInfoDao  {

	E_LoginInfoEntity get(E_LoginInfoEntity InfoEntity);

	E_LoginInfoEntity getLoginInfoByMobile(String mobile);

	List<E_LoginInfoEntity> getAll();

	void update(E_LoginInfoEntity InfoEntity);

	void delete(E_LoginInfoEntity InfoEntity);

	void save(E_LoginInfoEntity InfoEntity);


}