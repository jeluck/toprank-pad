package ${packageName}.common.constants;

/******************************************************************************************************
 * 
 *   版权所有：(c)2016， 深圳市拓润计算机软件开发有限公司
 *   
 *   该类为自动生成的字典枚举类，不能手动修改。
 * 
 * ****************************************************************************************************/
public enum ${model.className?cap_first}Enum {

	  <#list model.models as dict>
	  /**
	   * ${dict.dictionaryName}
	   */
	  ${dict.dictionaryCode?upper_case}(${dict.dictionaryID}L, "${dict.dictionaryName}")<#if !dict_has_next>;<#else>,</#if>
	  </#list>
  
	  private final Long value;
	  private final String name;
	  
	  private ${model.className?cap_first}Enum(Long value,String name) {
	    this.value = value;
	    this.name = name;
	  }
	
	  public Long getValue() {
	    return this.value;
	  }
	  
	  public String getName() {
	    return this.name;
	  }
}