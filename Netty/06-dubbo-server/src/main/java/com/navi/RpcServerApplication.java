package com.navi;

import com.navi.config.RpcServer;

/**
 * RpcServerApplication Class
 * dubbo://10.10.24.154:20880/com.navi.service.HelloService?anyhost=true&application=dubbo-01-provider&bean.name=com.navi.service.HelloService&deprecated=false&dubbo=2.0.2&dynamic=true&generic=false&interface=com.navi.service.HelloService&methods=sayHello&pid=5011&register=true&release=2.7.2&side=provider&timestamp=1611545927162
 *
 * 使用zookeeper存储服务信息，服务启动的时候把服务信息注册到zookeeper上， /cdubbo/serverName/providers/host:ip
 *
 * @author ganxf
 * @date 2020/9/18
 */
public class RpcServerApplication {

    public static void main(String[] args) throws InterruptedException {
        new RpcServer().doPublish("com.navi.server.impl");
    }
}
