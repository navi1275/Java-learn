package com.navi.ibatis.sqlsource;

/**
 * SqlSource Class
 *
 * @author ganxf
 * @date 2020/12/4
 */
public interface SqlSource {

    Boundsql getBoundSql(Object param);
}
