package cc.toprank.byd.dao;

import cc.toprank.byd.entity.C_DictionaryInfoEntity;

import java.util.List;
import java.util.Map;

public interface C_DictionaryInfoDao {
    int deleteByPrimaryKey(Long dictionaryid);

    int insert(C_DictionaryInfoEntity record);

    int insertSelective(C_DictionaryInfoEntity record);

    C_DictionaryInfoEntity selectByPrimaryKey(Long dictionaryid);

    int updateByPrimaryKeySelective(C_DictionaryInfoEntity record);

    int updateByPrimaryKey(C_DictionaryInfoEntity record);

    /**
     * 通过字典名称或字典code查询字典值
     * @param c_DictionaryInfo
     * @return List<C_DictionaryInfoEntity>
     */
    public List<Map> getByDictionaryBycatalogNameOrCode(C_DictionaryInfoEntity c_DictionaryInfo);
}