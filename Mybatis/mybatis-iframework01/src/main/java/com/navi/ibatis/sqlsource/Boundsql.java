package com.navi.ibatis.sqlsource;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Boundsql Class
 *
 * @author ganxf
 * @date 2020/12/4
 */
@Data
public class Boundsql {
    private String sql;
    private List<ParameterMapping> parameterMappings = new ArrayList<>();

    public Boundsql(String sql, List<ParameterMapping> parameterMappings) {
        this.sql = sql;
        this.parameterMappings = parameterMappings;
    }


}
