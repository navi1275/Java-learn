package com.navi.ibatis.sqlnode;

import java.util.ArrayList;
import java.util.List;

/**
 * MixSqlNode Class
 *
 * @author ganxf
 * @date 2020/12/4
 */
public class MixSqlNode implements SqlNode {

    private List<SqlNode> list = new ArrayList<>();

    public MixSqlNode(List<SqlNode> list) {
        this.list.addAll(list);
    }

    @Override
    public boolean apply(DynamicContext context) {
        for (SqlNode sqlNode : list){
            sqlNode.apply(context);
        }
        return true;
    }
}
