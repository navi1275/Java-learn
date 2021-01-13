package com.navi.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ProviderRun Class
 *
 * @author navi
 * @date 2019-07-23
 * @since 1.0.0
 */
public class ProviderRun {

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // start
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("dubbo-provider.xml");
        applicationContext.start();
        System.in.read();
    }
}
