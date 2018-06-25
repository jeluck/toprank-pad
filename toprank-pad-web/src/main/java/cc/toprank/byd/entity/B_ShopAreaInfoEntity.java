package cc.toprank.byd.entity;

import cc.toprank.byd.entity.B_ShopAreaInfoEntityBase;

import java.util.ArrayList;
import java.util.List;

/**********************************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的实体类基类，不能手动修改。
 *   如有需要扩展的字段，请在B_ShopAreaInfo类中进行修改
 * 
 * ********************************************************************************************************************/
public class B_ShopAreaInfoEntity extends B_ShopAreaInfoEntityBase {
    private List<B_ShopAreaInfoEntity> childList = new ArrayList<>();

    public List<B_ShopAreaInfoEntity> getChildList() {
        return childList;
    }

    public void setChildList(List<B_ShopAreaInfoEntity> childList) {
        this.childList = childList;
    }
}