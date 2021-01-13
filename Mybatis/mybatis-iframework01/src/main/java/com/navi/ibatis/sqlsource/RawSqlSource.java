package com.navi.ibatis.sqlsource;

import com.navi.ibatis.sqlnode.DynamicContext;
import com.navi.ibatis.sqlnode.MixSqlNode;
import com.navi.ibatis.utils.GenericTokenParser;
import com.navi.ibatis.utils.ParameterMappingTokenHandler;

/**
 * DynamicSqlSource Class
 *
 * @author ganxf
 * @date 2020/12/4
 */
public class RawSqlSource implements SqlSource {


    private final StaticSqlSource staticSqlSource;

    public RawSqlSource(MixSqlNode mixSqlNode) {
        // #{}处理的时候，不需要入参对象的支持
        DynamicContext context = new DynamicContext(null);
        // 处理SqlNode
        mixSqlNode.apply(context);

        ParameterMappingTokenHandler handler = new ParameterMappingTokenHandler();
        // 将#{}解析为?并保存参数信息
        GenericTokenParser tokenParser = new GenericTokenParser("#{", "}", handler);
        // 获取真正可以执行的SQL语句
        String sql = tokenParser.parse(context.getSql());

        // 该SqlSource就是封装已经解析完成的Sql语句
        staticSqlSource = new StaticSqlSource(sql, handler.getParameterMappings());
    }

    @Override
    public Boundsql getBoundSql(Object param) {
        return staticSqlSource.getBoundSql(param);
    }
}
