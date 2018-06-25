package cc.toprank.byd.web.service.order;

import cc.toprank.byd.dao.C_DictionaryInfoDao;
import cc.toprank.byd.entity.C_DictionaryInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by HuTao on 2017-5-10.
 */
@Service
public class DictionaryInfoService {

    @Autowired
    private C_DictionaryInfoDao dictionaryInfoDao;

    /**
     * 通过字典名称或字典code查询字典值
     * @param catalogCode
     * @return List<C_DictionaryInfoEntity>
     */
    public List<Map> getByDictionaryBycatalogNameOrCode(String catalogCode){
        C_DictionaryInfoEntity c_DictionaryInfo = new C_DictionaryInfoEntity();
        c_DictionaryInfo.setCatalogCode(catalogCode);
        return dictionaryInfoDao.getByDictionaryBycatalogNameOrCode(c_DictionaryInfo);
    }

    /**
     * 通过字典名称或字典code查询字典值
     * @param catalogCode
     * @return List<C_DictionaryInfoEntity>
     */
    public List<Map> getByDictionaryBycatalogNameOrCode(String catalogCode,Long filterID){
        C_DictionaryInfoEntity c_DictionaryInfo = new C_DictionaryInfoEntity();
        c_DictionaryInfo.setCatalogCode(catalogCode);
        c_DictionaryInfo.setFilterID(filterID);
        return dictionaryInfoDao.getByDictionaryBycatalogNameOrCode(c_DictionaryInfo);
    }

}
