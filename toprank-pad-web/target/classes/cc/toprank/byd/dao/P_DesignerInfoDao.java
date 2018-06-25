package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_DesignerInfoEntity;
import cc.toprank.byd.vo.DesignerVO;
import cc.toprank.byd.web.vo.menu.DesignerInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 厨师信息
 * Created by HuangCY on 2017-4-20.
 */
public interface P_DesignerInfoDao {
    int deleteByPrimaryKey(Long designerID);

    int insert(P_DesignerInfoEntity record);

    int insertSelective(P_DesignerInfoEntity record);

    P_DesignerInfoEntity selectByPrimaryKey(Long designerID);

    int updateByPrimaryKeySelective(P_DesignerInfoEntity record);

    int updateByPrimaryKey(P_DesignerInfoEntity record);

    P_DesignerInfoEntity get(P_DesignerInfoEntity designerInfo);

    List<P_DesignerInfoEntity> getAll();

    void update(P_DesignerInfoEntity designerInfo);

    void delete(P_DesignerInfoEntity designerInfo);

    void save(P_DesignerInfoEntity designerInfo);


    /**
     * @author HuangCY
     * @version 1.0.0
     * @description 查询会做某道菜的厨师信息
     * @time 2017-4-20 13:51
     */
    List<DesignerInfoVO> queryDesignerByCondition(Map map);

    /**
     * @description 查询会做某道菜的厨师信息，厨师需要在登录状态
     * @author LinYN
     * @version 1.0.0
     * @time 2017-5-18
     */
    List<DesignerInfoVO> getCurrentDesignerByProduct(Map map);

    /**
     * 根据商家id、商品id、变体id(可为空)获取厨师信息
     * @author LeeJun
     * @time 2017-5-23 14:27
     * @version 2.0.0
     */
    List<DesignerVO> getDesignerByParam(@Param("archiveID") Long archiveID, @Param("productID") Long productID, @Param("variantID") Long variantID);
}
