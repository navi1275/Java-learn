package com.navi.ibatis.sqlsource;

import lombok.Data;

/**
 * ParameterMapping Class
 *
 * @author ganxf
 * @date 2020/12/7
 */
@Data
public class ParameterMapping {

    private String name;
    private Class<?> classType;
    public ParameterMapping(String name) {

        this.name = name;

    }
}
