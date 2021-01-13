package com.navi.util;

import javafx.beans.InvalidationListener;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * MapperProxy Class
 *
 * @author navi
 * @date 2018/11/12
 */
public class MapperProxy implements InvocationHandler {


    private MapperStatment mapperStatment;

    public MapperProxy(MapperStatment mapperStatment) {
        this.mapperStatment = mapperStatment;
    }

    /**
     * 1.加载驱动类
     * 2.获得链接通道
     * 3.获得数据库操作对象
     * 4.数据库操作使用执行器输送sql并得到结果
     * 5.链接通道
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();

        String sql = (String) mapperStatment.getSqlMap().get(methodName);
        System.out.println("执行的sql语句：" + sql);

        Connection con = Configuration.getCon();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        ResultSetHandler resultSetHandler = new ResultSetHandler();

        String resultType = (String) mapperStatment.getRtMap().get(methodName);
        return resultSetHandler.handler(resultSet, resultType);

    }
}
