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
import cc.toprank.byd.dao.B_DictionaryInfoDao;
import cc.toprank.byd.entity.B_DictionaryInfoEntity;
import cc.toprank.byd.enums.DictionaryCatalogEnum;
import cc.toprank.byd.vo.ReasonVO;
import cc.toprank.byd.web.constant.CodeMsgConstants;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商户字典表组件
 *
 * @author LinYN
 * @date 2017-5-25
 */
@Component
public class DictionaryComponent implements ParamConstants.DictionaryParam{

    @Autowired
    private B_DictionaryInfoDao dictionaryInfoDao;

    /**
     * 根据字典类型编码查询商户字典表
     *
     * @param dictionaryCatalog 字典类型编码
     * @param archiveID 机构编号，可以为null
     * @return
     *
     * @author LinYN
     * @date 2017-5-25
     */
    public List<B_DictionaryInfoEntity> getMerchantDictionaryByCatalogCode(DictionaryCatalogEnum dictionaryCatalog, Long archiveID) {
        if (dictionaryCatalog == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put(PARAM_CATALOG_CODE, dictionaryCatalog.getCode());
        queryParam.put(PARAM_ARCHIVE_ID, archiveID);
        return dictionaryInfoDao.getDictionaryByCatalogCode(queryParam);
    }

    /**
     * 根据字典类型编码查询操作原因
     *
     * @param dictionaryCatalog 字典类型编码
     * @param archiveID 机构编号，可以为null
     * @return
     *
     * @author LinYN
     * @date 2017-5-25
     */
    public List<ReasonVO> getReasonByCatalogCode(DictionaryCatalogEnum dictionaryCatalog, Long archiveID) {
        if (dictionaryCatalog == null) {
            throw new BizException(CodeMsgConstants.PARAM_ERROR, CodeMsgConstants.PARAM_ERROR_MSG);
        }
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put(PARAM_CATALOG_CODE, dictionaryCatalog.getCode());
        queryParam.put(PARAM_ARCHIVE_ID, archiveID);
        List<ReasonVO> reasons = dictionaryInfoDao.getReasonByCatalogCode(queryParam);
        if (archiveID != null && CollectionUtils.isEmpty(reasons)) {
            queryParam.put(PARAM_ARCHIVE_ID, null);
            reasons = dictionaryInfoDao.getReasonByCatalogCode(queryParam);
        }
        return reasons;
    }
}
