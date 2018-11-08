package com.navi.util;

import com.navi.impl.Cicadas;
import com.navi.service.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 *
 * @author Administrator
 * @date 2018-11-08
 * @since 1.0.0
 */
public class CicadasProxyFactory {

    public static BaseService getInstance(Class<Cicadas> clazz) throws IllegalAccessException, InstantiationException {

//      创建蝉的实例对象
        Cicadas cicadas = clazz.newInstance();
//        创建代理类对象 螳螂
        InvocationHandler mantis = new Mantis(cicadas);
//      监控的方法
        Class[] arr = {BaseService.class};
//        生成蝉的代理对象，这个是真实运行的螳螂
        BaseService proxy = (BaseService)Proxy.newProxyInstance(clazz.getClassLoader(), arr, mantis);

//        创建代理类对象 黄雀， 需要监听的是 蝉的代理对象（螳螂），即是proxy
        InvocationHandler yellowBird = new YellowBird(proxy);

//        生成螳螂的代理对象，这个是真实运行的黄雀
        BaseService proxy1 = (BaseService)Proxy.newProxyInstance(clazz.getClassLoader(), arr, yellowBird);


        return (BaseService)proxy1;
    }
}
