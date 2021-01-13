package com.navi.ibatis.sqlnode;

import com.navi.ibatis.utils.OgnlUtils;

/**
 * MixSqlNode Class
 *
 * @author ganxf
 * @date 2020/12/4
 */
public class IfSqlNode implements SqlNode {

    private final String test;
    private SqlNode sqlNode;

    public IfSqlNode(String test, SqlNode sqlNode) {
        this.test = test;
        this.sqlNode = sqlNode;
    }

    @Override
    public boolean apply(DynamicContext context) {
        if(OgnlUtils.evaluateBoolean(this.test, context.getBindings())){
            this.sqlNode.apply(context);
        }
        return true;
    }
}
