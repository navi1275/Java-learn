package com.navi.ibatis.sqlnode;

import java.util.ArrayList;
import java.util.List;

/**
 * MixSqlNode Class
 *
 * @author ganxf
 * @date 2020/12/4
 */
public class StaticTextSqlNode implements SqlNode {

    private final String sql;

    public StaticTextSqlNode(String sql) {
        this.sql = sql;
    }

    @Override
    public boolean apply(DynamicContext context) {
        context.putSql(sql);
        return true;
    }
}
