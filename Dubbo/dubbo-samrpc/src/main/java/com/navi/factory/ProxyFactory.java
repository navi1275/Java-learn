package com.navi.factory;

import com.navi.service.HelloServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyFactory Class
 *
 * @author navi
 * @date 2019-03-22
 * @since 1.0.0
 */

public class ProxyFactory implements InvocationHandler {

    private Class interfaceClass;

    public ProxyFactory(Class interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    /**
     * 返回代理对象
     * 此处用泛型为了调用时不用强转,用Object需要强转
     */

    public <T> T getProxyObject() {
        // 类加载器
        // 为哪些接口做代理(拦截哪些方法)
        // (把这些方法拦截到哪处理)
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{interfaceClass},
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(method.getDeclaringClass() == Object.class){
            return  method.invoke(this, args);
        }

        System.out.println(method);
        System.out.println("进行编码");
        System.out.println("发送网络请求");

        //这个对象由服务端提供
        HelloServiceImpl helloService = new HelloServiceImpl();

        Object result = method.invoke(helloService, args);
        System.out.println("将网络请求结果进行解码并返回" + result);
        return null;
    }
}
