package com.navi.ibatis.sqlnode;

/**
 * SqlNode Class
 *
 * @author ganxf
 * @date 2020/12/4
 */
public interface SqlNode {

    boolean apply(DynamicContext context);
}
