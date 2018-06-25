
package cc.toprank.byd.common.sqlbase;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.*;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
@Intercepts({ @Signature(
    type   = StatementHandler.class,
    method = "prepare",
    args   = { Connection.class, Integer.class }
) })
public class TableRouterPlugin implements Interceptor {

    /** Field description */
    private static Logger logger = LoggerFactory.getLogger(TableRouterPlugin.class);

    /**
     * Method description
     *
     *
     * @param sql
     * @param suffix
     * @param router
     *
     * @return
     */
    private String buildRouterSql(String sql, String suffix, TableRouter router) {
        return SqlRewriter.rewriteSqlTable(sql, router.table(), router.table() + router.decollator() + suffix);
    }

    /**
     * Method description
     *
     *
     * @param count
     * @param suffix
     *
     * @return
     */
    public String findRealSuffix(int count, String suffix) {
        if (count > 0) {
            List<Object> shards = new ArrayList<Object>();

            for (int i = 0; i < count; i++) {
                shards.add(i);
            }

            TableRouterUtils tableRouterUtil = new TableRouterUtils(shards);

            return tableRouterUtil.getShardInfo(suffix).toString();
        }

        return suffix;
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        // StatementHandler��ʵ������RoutingStatementHandler����
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();

        // ��RoutingStatementHandler������а�װ,����ͨ�������ȡ��˽������
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,
                                                               SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                                                               SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                                                               new DefaultReflectorFactory());

        // RoutingStatementHandler������ʵ�Ƕ�BaseStatementHandler��������һ������
        MappedStatement mapper = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");

        // MappedStatement��mapperӳ�����,namespace���Ե���ɰ���dao��ʵ�������Լ�id
        String mapperId = mapper.getId();

        if (logger.isDebugEnabled()) {
            logger.debug("TableRouterPlugin�����ʼ����MappedStatement��id:{}", mapperId);
        }

        // ͨ��mapperId��ȡdao������
        String mapperName = mapper.getId().substring(0, mapperId.lastIndexOf("."));

        if (logger.isDebugEnabled()) {
            logger.debug("TableRouterPlugin�����ȡ��dao����:{}", mapperName);
        }

        // dao������
        Class<?>    clazz  = Class.forName(mapperName);
        TableRouter router = clazz.getAnnotation(TableRouter.class);

        if (router != null) {
            logger.info("TableRouterPlugin�ֱ�ʼ,dao:{}", mapperName);

            BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");

            // sql����
            Object                 parameterObject = boundSql.getParameterObject();
            List<ParameterMapping> mappings        = boundSql.getParameterMappings();
            String                 sql             = boundSql.getSql();

            if (logger.isDebugEnabled()) {
                logger.debug("TableRouterPlugin�����ʼ�ֱ�֮ǰ��sql:{}", sql);
                logger.debug("TableRouterPlugin�����ʼ�ֱ�֮ǰ��parameterObject:{}", parameterObject);
                logger.debug("TableRouterPlugin�����ʼ�ֱ�֮ǰ��mappings:{}", mappings);
                logger.debug("TableRouterPlugin�����ʼ�ֱ��router:{}", router);
            }

            // �Ӳ����л�ȡ�ֱ�ĺ�׺ֵ
            String suffix = obtainParam(parameterObject, router);

            if (suffix == null) {
                throw new RuntimeException("TableRouterPlugin����ֱ�·�ɻ�ȡ�ֱ��׺Ϊ���쳣");
            }

            if (logger.isDebugEnabled()) {
                logger.debug("TableRouterPlugin·�ɷֱ�ĺ�׺suffix:{}", suffix);
            }

            // �ж��Ƿ�̬�ֱ�
            if (router.isAuto()) {
                suffix = findRealSuffix(router.count(), suffix);
            }

            // �����µ�sql
            String newSQL = buildRouterSql(sql, suffix, router);

            if (logger.isDebugEnabled()) {
                logger.debug("TableRouterPlugin·�ɷֱ�֮���newSql:{}", newSQL);
            }

            metaStatementHandler.setValue("delegate.boundSql.sql", newSQL);
        }

        return invocation.proceed();
    }

    /**
     * Method description
     *
     *
     * @param params
     * @param router
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    private String obtainParam(Object params, TableRouter router) {
        Object paramVal = null;

        if (logger.isDebugEnabled()) {
            logger.debug("TableRouterPlugin�ֱ��������class:{},toString:{}", params.getClass(), params);
        }

        if ((params instanceof String)
                || (params instanceof Integer)
                || (params instanceof Byte)
                || (params instanceof Date)) {
            paramVal = params;
        } else if (params instanceof Map) {
            paramVal = ((Map<String, Object>) params).get(router.paramKey());
        } else {
            MetaObject paramMeta = MetaObject.forObject(params,
                                                        SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                                                        SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                                                        new DefaultReflectorFactory());

            paramVal = paramMeta.getValue(router.paramKey());
        }

        return (paramVal == null)
               ? null
               : paramVal.toString();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {}
}



