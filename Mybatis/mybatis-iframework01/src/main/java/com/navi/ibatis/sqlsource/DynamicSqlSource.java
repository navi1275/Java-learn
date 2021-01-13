package com.navi.ibatis.sqlsource;

import com.navi.ibatis.sqlnode.DynamicContext;
import com.navi.ibatis.sqlnode.SqlNode;
import com.navi.ibatis.utils.GenericTokenParser;
import com.navi.ibatis.utils.ParameterMappingTokenHandler;

/**
 * DynamicSqlSource Class
 *
 * @author ganxf
 * @date 2020/12/4
 */
public class DynamicSqlSource implements SqlSource {

    private SqlNode sqlNode;

    public DynamicSqlSource(SqlNode sqlNode) {
        this.sqlNode = sqlNode;
    }

    @Override
    public Boundsql getBoundSql(Object param) {

        // #{}处理的时候，不需要入参对象的支持
        DynamicContext context = new DynamicContext(param);
        // 处理SqlNode
        sqlNode.apply(context);

        ParameterMappingTokenHandler handler = new ParameterMappingTokenHandler();
        // 将#{}解析为?并保存参数信息
        GenericTokenParser tokenParser = new GenericTokenParser("#{", "}", handler);
        // 获取真正可以执行的SQL语句
        String sql = tokenParser.parse(context.getSql());

        return new Boundsql(sql, handler.getParameterMappings());
    }
}
