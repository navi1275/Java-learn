package com.navi.ibatis.sqlsource;

import java.util.ArrayList;
import java.util.List;

/**
 * StaticSqlSource Class
 *
 * @author ganxf
 * @date 2020/12/7
 */
public class StaticSqlSource implements SqlSource {

    private String sql;
    private List<ParameterMapping> list = new ArrayList<>();

    public StaticSqlSource(String sql, List<ParameterMapping> list) {
        this.sql = sql;
        this.list = list;
    }

    @Override
    public Boundsql getBoundSql(Object param) {
        return new Boundsql(sql, list);
    }
}
