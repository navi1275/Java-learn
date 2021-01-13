package com.navi.ibatis.config;

import lombok.Data;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Configuration Class
 *
 * @author ganxf
 * @date 2020/12/4
 */
@Data
public class Configuration {

    private DataSource dataSource;
    private Map<String, MappedStatement> mappedStatementMap = new HashMap<>();

    public void addMappedStatement(MappedStatement mappedStatement) {
        mappedStatementMap.putIfAbsent(mappedStatement.getStatementId(), mappedStatement);
    }
}
