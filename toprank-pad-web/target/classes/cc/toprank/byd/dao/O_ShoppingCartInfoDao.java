package cc.toprank.byd.dao;

import cc.toprank.byd.entity.O_ShoppingCartInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface O_ShoppingCartInfoDao {
    int deleteByPrimaryKey(Long cartid);

    int insert(O_ShoppingCartInfoEntity record);

    int insertSelective(O_ShoppingCartInfoEntity record);

    O_ShoppingCartInfoEntity selectByPrimaryKey(Long cartid);

    int updateByPrimaryKeySelective(O_ShoppingCartInfoEntity record);

    int updateByPrimaryKey(O_ShoppingCartInfoEntity record);

    /**
     * 获取购物车ID、数量及总价
     * @author LeeJun
     * @time 2017-3-28 16:02
     * @version 2.0.0
     */
    Map<String, Object> getByTableID(Long tableID);

}