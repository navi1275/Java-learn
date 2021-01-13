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
public class ConsumerRun {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        HelloService helloService = ac.getBean(HelloService.class);
        String dubbo = helloService.sayHello("dubbo");
        System.out.println(dubbo);

        System.in.read();
    }

}
