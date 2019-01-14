package com.navi.proxy.multilevel.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 黄雀 Class
 *
 * @author Administrator
 * @date 2018-11-08
 * @since 1.0.0
 */
public class YellowBird implements InvocationHandler {

    /**
     * 代理对象
     */
    private Object proxyObj;

    public YellowBird(Object proxyObj) {
        this.proxyObj = proxyObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();

        if("eating".equals(name)) {
            method.invoke(proxyObj, args);
            secondaryBusiness();
        }

        return null;
    }

    private void secondaryBusiness(){
        System.out.println("我是黄雀，发现螳螂吃了蝉，去吃了螳螂");
    }
}
