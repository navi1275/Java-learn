package com.navi.ibatis.sqlnode;

import java.util.HashMap;
import java.util.Map;

/**
 * DynamicContext Class
 *
 * @author ganxf
 * @date 2020/12/4
 */
public class DynamicContext {

    private StringBuilder sqlBuilder = new StringBuilder();
    private Map<String, Object> bindings = new HashMap<>();

    public DynamicContext(Object param) {
        bindings.put("_parameter", param);
    }

    public void putSql(String sql){
        sqlBuilder.append(sql);
        sqlBuilder.append(" ");
    }
    public String getSql(){
        return sqlBuilder.toString().trim();
    }

    public Map<String, Object> getBindings() {
        return bindings;
    }

    public void setBindings(String name, Object param) {
        this.bindings .put(name, param);
    }
}
