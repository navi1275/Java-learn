package com.navi.ibatis.sqlnode;

import cn.hutool.core.util.StrUtil;

/**
 * TextSqlNode Class
 *
 * @author ganxf
 * @date 2020/12/7
 */
public class TextSqlNode implements SqlNode {
    private String text;
    public TextSqlNode(String text) {
        this.text = text;
    }

    public boolean isDynamic(){
        return StrUtil.containsAny(text, "${");
    }

    @Override
    public boolean apply(DynamicContext context) {
        return false;
    }
}
