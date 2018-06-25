package cc.toprank.byd.vo;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import java.util.ArrayList;
import java.util.List;

/**
 * @author LinYN
 * @date 2017-4-28
 */
public class TreeNodeVO<T extends TreeNodeVO> implements Cloneable {

    List<T> childs = new ArrayList<T>();

    public List<T> getChilds() {
        return childs;
    }

    public void setChilds(List<T> childs) {
        this.childs = childs;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
