package cc.toprank.byd.dao;

import cc.toprank.byd.entity.O_ShoppingCartDetailInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface O_ShoppingCartDetailInfoDao {
    int deleteByPrimaryKey(Long detailid);

    int insert(O_ShoppingCartDetailInfoEntity record);

    int insertSelective(O_ShoppingCartDetailInfoEntity record);

    O_ShoppingCartDetailInfoEntity selectByPrimaryKey(Long detailid);

    int updateByPrimaryKeySelective(O_ShoppingCartDetailInfoEntity record);

    int updateByPrimaryKey(O_ShoppingCartDetailInfoEntity record);

    /**
     * 根据cartID清空购物车详细信息
     *
     * @param CartID
     * @return
     */
    int deleteByCartID(Long CartID);

    /**
     * 查询购物车列表信息
     *
     * @author LeeJun
     * @time 2017-3-28 16:02
     * @version 2.0.0
     */
    List<Map<String, Object>> getShoppingCartsByTableID(Long tableID);

    O_ShoppingCartDetailInfoEntity getByParam(Map<String, Object> param);

    int deleteByParam(Map<String, Object> param);
}