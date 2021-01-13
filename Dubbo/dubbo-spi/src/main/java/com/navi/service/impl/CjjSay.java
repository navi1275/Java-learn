package com.navi.service.impl;

import com.navi.service.Say;
import org.apache.dubbo.common.URL;

/**
 * @Description CjjSay class
 * @auther Administrator
 * @date 2019-08-07 下午 3:05
 */
public class CjjSay  implements Say {

    @Override
    public void sayHello(String url) {
        System.out.println(url);
        System.out.println("Hello, My name is c++");
    }

    @Override
    public void sayUrl(URL url) {
        String name = url.getParameter("name");
        System.out.println("CjjSay sayUrl ::" + name);
    }


}
