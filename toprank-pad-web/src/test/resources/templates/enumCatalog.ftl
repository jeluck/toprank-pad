package ${packageName}.enums;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/

public class ${model.className?cap_first}Enum {

<#list model.models as m>
	/**
	 * 
	 * ${m.catalogName}
	 */
	public enum ${m.catalogCode?cap_first}{
	  <#list m.dictionarys as dict>
	  /**
	   * ${dict.dictionaryName}
	   */
	  ${dict.dictionaryCode?upper_case}(${dict.dictionaryID}, "${dict.dictionaryName}")<#if !dict_has_next>;<#else>,</#if>
	  </#list>
  
	  private final long value;
	  private final String name;
	  
	  private ${m.catalogCode?cap_first}(long value,String name) {
	    this.value = value;
	    this.name = name;
	  }
	
	  public long getValue() {
	    return this.value;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
	}
	
</#list>
}