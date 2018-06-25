package cc.toprank.byd.dao;


import cc.toprank.byd.entity.B_DictionaryCatalogInfoEntity;

import java.util.List;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *
 *   B_DictionaryCatalogInfo数据访问类
 * 
 * ********************************************************************************************************************/
public interface B_DictionaryCatalogInfoDao {

    B_DictionaryCatalogInfoEntity get(B_DictionaryCatalogInfoEntity entity);

    List<B_DictionaryCatalogInfoEntity> getAll();

    void update(B_DictionaryCatalogInfoEntity entity);

    void delete(B_DictionaryCatalogInfoEntity entity);

    void save(B_DictionaryCatalogInfoEntity entity);

    List<B_DictionaryCatalogInfoEntity> list();
}