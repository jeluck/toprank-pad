package cc.toprank.byd.constant;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


/**
 * 桌台操作常量
 *
 * @author LinYN
 * @since 2017-3-16
 */
public interface TableOperation {

    /**
     * 转台方式
     */
    interface Transfer {

        int EMPTY_WAY = 1; // 空台

        int SHARE_WAY = 2; // 拼台

        int COMBINE_WAY = 3; // 联台
    }

}
