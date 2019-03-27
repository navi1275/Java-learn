package com.navi.util;

import org.dom4j.DocumentException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * DefaultSqlSession Class
 *
 * @author ganxf
 * @date 2018/11/12
 */
public class DefaultSqlSession {


    public Object getMapper(Class clazz){

        MapperStatment mapperStatment = new MapperStatment(clazz);
        try {
            mapperStatment.init();
        } catch (DocumentException e) {
            e.printStackTrace();
        }


        InvocationHandler agent = new MapperProxy(mapperStatment);

        Class[] arr = {clazz};

        return Proxy.newProxyInstance(clazz.getClassLoader(), arr, agent);

    }
}
