package com.navi.dubbo;

import com.navi.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * ConsumerRun Class
 *
 * @author navi
 * @date 2019-07-23
 * @since 1.0.0
 */

/*
[arthas@4139]$ jad org.apache.dubbo.common.bytecode.proxy0

ClassLoader:
+-sun.misc.Launcher$AppClassLoader@18b4aac2
  +-sun.misc.Launcher$ExtClassLoader@63590811

Location:
/Users/navi/store/foresee_workspace/mavenRepo/org/apache/dubbo/dubbo/2.7.2/dubbo
-2.7.2.jar

 * Decompiled with CFR.
 *
 * Could not load the following classes:
 *  com.navi.service.HelloService
package org.apache.dubbo.common.bytecode;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.navi.service.HelloService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.dubbo.common.bytecode.ClassGenerator;

public class proxy0
        implements ClassGenerator.DC,
        HelloService,
        EchoService {
    public static Method[] methods;
    private InvocationHandler handler;

    public String sayHello(String string) {
        Object[] objectArray = new Object[]{string};
        Object object = this.handler.invoke(this, methods[0], objectArray);
        return (String)object;
    }

    @Override
    public Object $echo(Object object) {
        Object[] objectArray = new Object[]{object};
        Object object2 = this.handler.invoke(this, methods[1], objectArray);
        return object2;
    }

    public proxy0() {
    }

    public proxy0(InvocationHandler invocationHandler) {
        this.handler = invocationHandler;
    }
}

    Affect(row-cnt:1) cost in 691 ms.
        [arthas@4139]$ session (398e7433-1edf-4506-92e8-a133a223a470) is closed because session is inactive for 30 min(s).
        Connection closed by foreign host.
 */
public class ConsumerRun {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        HelloService helloService = ac.getBean(HelloService.class);
        String dubbo = helloService.sayHello("dubbo");
        System.out.println(dubbo);

        System.in.read();
    }

}
