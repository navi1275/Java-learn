package com.navi.server.impl;

import com.navi.server.HelloService;
import lombok.extern.slf4j.Slf4j;

/**
 * HelloServiceImpl Class
 *
 * @author ganxf
 * @date 2020/9/17
 */
@Slf4j
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String s) {
        log.info("接收到客户端传入参数：{}", s);
        return "hello client";
    }
}
