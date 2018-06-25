package cc.toprank.byd.dao;

import org.apache.ibatis.annotations.Param;

import cc.toprank.byd.entity.SystemMaxIDEntity;

import java.util.Map;

public interface SystemMaxIDDao {
	int deleteByPrimaryKey(Integer serialno);

	int insert(SystemMaxIDEntity record);

	int insertSelective(SystemMaxIDEntity record);

	SystemMaxIDEntity selectByPrimaryKey(Integer serialno);

	int updateByPrimaryKeySelective(SystemMaxIDEntity record);

	int updateByPrimaryKey(SystemMaxIDEntity record);

	Long getMaxID2(@Param("tableName") String tableName, @Param("maxID") Long maxID);

	Long getMaxID(Map<String,Object> map);
}