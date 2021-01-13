package com.navi.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * UserServiceProxy Class
 *
 * @author ganxf
 * @date 2020/12/8
 */
public class UserServiceProxyFactory {

    public static UserService getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if("sayHello".equals(method.getName())){
                    System.out.println("记录日志");
                }
                // 注意这里是使用methodProxy对象调用父类的方法
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println(result);

                return result;
            }
        });
        UserService userService = (UserService) enhancer.create();
        return userService;
    }

    public static void main(String[] args) {
        UserService userService = UserServiceProxyFactory.getProxy();
        userService.sayHello("小冉冉");
    }
}
