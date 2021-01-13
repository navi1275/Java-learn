package com.navi.service;

/**
 * HelloServiceImpl Class
 *
 * @author navi
 * @date 2019-03-22
 * @since 1.0.0
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {

        System.out.println("假装我是服务端的");
        System.out.println("你好，" + name);
        return "我是老王";
    }
}
