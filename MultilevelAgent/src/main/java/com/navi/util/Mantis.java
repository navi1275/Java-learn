package com.navi.util;

import com.navi.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 螳螂 Class
 * 蝉 eating行为的代理实现类
 *
 * @author Administrator
 * @date 2018-11-08
 * @since 1.0.0
 */
public class Mantis implements InvocationHandler {

    private BaseService proxyObj;

    public Mantis(BaseService proxyObj) {
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

    /**
     * 次要业务
     */
    private void secondaryBusiness(){
        System.out.println("我是螳螂，发现小蝉在吃树叶，吃了它");
    }
}
