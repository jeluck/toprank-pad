package cc.toprank.byd.constant;
/*********************************************************************************************.
 *
 *
 * <p>版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司</p>
 *
 *
 *********************************************************************************************/


import com.wordnik.swagger.annotations.ApiImplicitParam;

/**
 * The parameter type of the parameter.
 *
 * @author LinYN
 * @see ApiImplicitParam#paramType()
 * @since 2017-3-28
 */
public interface ParamType {

    String PATH = "path";

    String QUERY = "query";

    String BODY = "body";

    String HEADER = "header";

    String FORM = "form";
}
