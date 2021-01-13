package com.navi.service.impl;


import com.navi.service.Say;
import org.apache.dubbo.common.URL;

public class JavaSay implements Say {
    @Override
    public void sayHello(String url) {
        System.out.println(url);
        System.out.println("Hello, My name is java");
    }
    @Override
    public void sayUrl(URL url) {
        String name = url.getParameter("name");
        System.out.println("JavaSay sayUrl ::" + name);
    }
}
