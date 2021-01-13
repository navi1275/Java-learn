package com.navi.ibatis.config;

import com.navi.ibatis.sqlsource.SqlSource;
import lombok.Data;

/**
 * MappedStatement Class
 *
 * @author ganxf
 * @date 2020/12/4
 */
@Data
public class MappedStatement {

    private String statementId;
    private Class resultClassType;
    private Class paramClassType;
    private SqlSource sqlSource;
    private String statementType;
}
