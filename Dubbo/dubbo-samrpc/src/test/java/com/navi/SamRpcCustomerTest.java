package com.navi;

import com.navi.factory.ProxyFactory;
import com.navi.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SamRpcCustomerTest Class
 *
 * @author navi
 * @date 2019-03-22
 * @since 1.0.0
 */

// @RunWith(JUnit4.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SamRpcCustomerTest {

    @Autowired(required = false)
    private HelloService helloService;

    @Test
    public void test1(){
        helloService.sayHello("张三");
    }

    @Test
    public void test2(){
        ProxyFactory proxyFactory = new ProxyFactory(HelloService.class);
        HelloService helloService = proxyFactory.getProxyObject();
        helloService.sayHello("张三");
    }

}
