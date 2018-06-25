package cc.toprank.byd.dao;

import cc.toprank.byd.entity.P_CategoryAttributeValueInfoEntity;
import cc.toprank.byd.entity.P_ProductDesignerMappingEntity;

import java.util.List;

/**
 * 商品厨师关联信息
 * Created by HuangCY on 2017-4-20.
 */
public interface P_ProductDesignerMappingDao {
    List<P_ProductDesignerMappingEntity> getAll();

    P_CategoryAttributeValueInfoEntity get(P_ProductDesignerMappingEntity productDesignerMapping);

    void update(P_ProductDesignerMappingEntity productDesignerMapping);

    void delete(P_ProductDesignerMappingEntity productDesignerMapping);

    void save(P_ProductDesignerMappingEntity productDesignerMapping);

    /**
     * @Description：根据变体ID和厨师ID查询关联信息
     * @Author：LanZY
     * @Time: 2017-4-20 16:25
     * @Version 2.0.0
     */
    P_ProductDesignerMappingEntity getDesignerInfoByVariantIDAndDesignerID(P_ProductDesignerMappingEntity productDesignerMapping);

}
