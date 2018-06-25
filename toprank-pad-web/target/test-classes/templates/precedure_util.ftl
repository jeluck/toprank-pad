<#assign selector><#list model.cols as col> ${col.colName} <#if col_has_next>,</#if></#list></#assign>
<#assign pkCondition><#list model.pks as pk><#list model.cols as col><#if col.colName = pk>IN p_${col.colName} ${col.dbTypeName}<#if col.colLength != 0 && (col.dbTypeName == "VARCHAR" || col.dbTypeName == "CHAR")>(${col.colLength})</#if><#if pk_has_next>,</#if></#if></#list></#list></#assign>
<#assign pkWhere> where <#list model.pks as pk><#list model.cols as col><#if col.colName = pk>${col.colName} =  p_${col.colName}<#if pk_has_next> and </#if></#if></#list></#list></#assign>
<#assign allCondition><#list model.cols as col><#if !col.isPk>IN p_${col.colName} ${col.dbTypeName}<#if col.colLength != 0 && (col.dbTypeName == "VARCHAR" || col.dbTypeName == "CHAR")>(${col.colLength})</#if><#if col_has_next>,</#if></#if></#list></#assign>
<#assign allConditionHavePk><#list model.cols as col>IN p_${col.colName} ${col.dbTypeName}<#if col.colLength != 0 && (col.dbTypeName == "VARCHAR" || col.dbTypeName == "CHAR")>(${col.colLength})</#if><#if col_has_next>,</#if></#list></#assign>
<#assign allWhereWithoutPk>
	where 
	<#list model.cols as col>
		<#if !col.isPk>
			(${col.colName} = p_${col.colName} or p_${col.colName} is null or p_${col.colName} = '') <#if col_has_next> and </#if>
		</#if>
	</#list>
</#assign>
<#assign fieldsWithoutPk><#list model.cols as col> <#if !col.isPk>${col.colName} <#if col_has_next>,</#if></#if></#list></#assign>
<#assign paramsWithoutPk><#list model.cols as col> <#if !col.isPk>p_${col.colName} <#if col_has_next>,</#if></#if></#list></#assign>
<#assign fieldsHavePk><#list model.cols as col> ${col.colName} <#if col_has_next>,</#if></#list></#assign>
<#assign paramsHavePk><#list model.cols as col> p_${col.colName} <#if col_has_next>,</#if></#list></#assign>
<#assign pkParamIn><#list model.pks as pk><#list model.cols as col><#if col.colName = pk>${r'#{'}${col.fieldName?uncap_first}${r'}'}<#if pk_has_next>,</#if></#if></#list></#list></#assign>
<#assign paramInWithoutPk><#list model.cols as col><#if !col.isPk>${r'#{'}${col.fieldName?uncap_first}${r'}'}<#if col_has_next>,</#if></#if></#list></#assign>
<#assign paramInALL><#list model.cols as col>${r'#{'}${col.fieldName?uncap_first}${r'}'}<#if col_has_next>,</#if></#list></#assign>
<#assign paramInALLSave><#list model.cols as col>${r'#{'}${col.fieldName?uncap_first}<#if col.isPk>,jdbcType=INTEGER,mode=OUT</#if>${r'}'}<#if col_has_next>,</#if></#list></#assign>

