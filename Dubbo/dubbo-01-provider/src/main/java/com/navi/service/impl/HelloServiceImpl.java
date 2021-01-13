package com.navi.service.impl;

import com.navi.service.HelloService;

/**
 * HelloServiceImpl Class
 *
 * @author navi
 * @date 2019-07-23
 * @since 1.0.0
 */
public class HelloServiceImpl implements HelloService {


    @Override
    public String sayHello(String name) {
        System.out.println("我是提供者， " + name);
        return "ni hao, " + name;
    }
}
