package cc.toprank.byd.component;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import cc.toprank.byd.common.exception.BizException;
import cc.toprank.byd.constant.ParamConstants;
import cc.toprank.byd.dao.B_MerchantMenuInfoDao;
import cc.toprank.byd.dao.P_DesignerInfoDao;
import cc.toprank.byd.entity.B_MerchantMenuInfoEntity;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import cc.toprank.byd.web.vo.menu.DesignerInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LinYN
 * @date 2017-5-18
 */
@Component
public class DesignerComponent implements ParamConstants.ProductParam{

    @Autowired
    private P_DesignerInfoDao designerInfoDao;
    @Autowired
    private B_MerchantMenuInfoDao merchantMenuInfoDao;

    /**
     * @description 查询会做某道菜的厨师信息，厨师需要在登录状态
     *
     * @author LinYN
     * @version 1.0.0
     * @time 2017-5-18
     */
    public  List<DesignerInfoVO> getCurrentDesignerByProduct(Long menuID){
        if (menuID == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        B_MerchantMenuInfoEntity menuParam = new B_MerchantMenuInfoEntity();
        menuParam.setMenuID(menuID);
        B_MerchantMenuInfoEntity menuInfo = merchantMenuInfoDao.get(menuParam);
        if (menuInfo == null) {
            throw new BizException(CodeMsgConstants.NODATA, CodeMsgConstants.NODATA_MSG);
        }
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put(PARAM_ARCHIVE_ID, menuInfo.getArchiveID());
        queryParam.put(PARAM_PRODUCT_ID, menuInfo.getProductID());
        queryParam.put(PARAM_VARIANT_ID, menuInfo.getVariantID());
        return designerInfoDao.getCurrentDesignerByProduct(queryParam);
    }

}
