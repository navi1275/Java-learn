package com.navi;

import com.navi.config.RpcServer;

/**
 * RpcServerApplication Class
 *
 * @author ganxf
 * @date 2020/9/18
 */
public class RpcServerApplication {

    public static void main(String[] args) throws InterruptedException {
        new RpcServer().doPublish("com.navi.server.impl");
    }
}
