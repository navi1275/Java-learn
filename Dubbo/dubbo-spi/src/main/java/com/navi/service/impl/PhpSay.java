package com.navi.service.impl;

import com.navi.service.Say;
import org.apache.dubbo.common.URL;

/**
 *
 */
public class PhpSay implements Say {
    @Override
    public void sayHello(String url) {
        System.out.println(url);
        System.out.println("Hello, My name is php");
    }
    @Override
    public void sayUrl(URL url) {
        String name = url.getParameter("name");
        System.out.println("PhpSay sayUrl ::" + name);
    }
}
