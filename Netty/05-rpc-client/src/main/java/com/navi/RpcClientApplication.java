package com.navi;

import com.navi.config.RpcClient;
import com.navi.server.HelloService;

/**
 * RpcClientApplication Class
 *
 * @author ganxf
 * @date 2020/9/18
 */
public class RpcClientApplication {

    public static void main(String[] args) {
        HelloService helloService = (HelloService)RpcClient.create(HelloService.class);
        String s = helloService.sayHello("hi, server");
        System.out.println("调用rpc方法返回：   " + s);
    }
}
