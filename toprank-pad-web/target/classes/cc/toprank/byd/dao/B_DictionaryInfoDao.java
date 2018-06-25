package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_DictionaryInfoEntity;
import cc.toprank.byd.vo.ReasonVO;

import java.util.List;
import java.util.Map;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   B_DictionaryInfo数据访问类
 * 
 * ********************************************************************************************************************/
public interface B_DictionaryInfoDao {

    B_DictionaryInfoEntity get(B_DictionaryInfoEntity entity);

    List<B_DictionaryInfoEntity> getAll();

    void update(B_DictionaryInfoEntity entity);

    void delete(B_DictionaryInfoEntity entity);

    void save(B_DictionaryInfoEntity entity);

    List<B_DictionaryInfoEntity> list();

    List<B_DictionaryInfoEntity> getDictionaryByCatalogCode(Map<String, Object> param);

    List<ReasonVO> getReasonByCatalogCode(Map<String, Object> param);

}