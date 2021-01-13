package com.navi.spi.service.impl;

import com.navi.spi.service.Say;

public class JavaSay implements Say {
    @Override
    public void sayHello() {
        System.out.println("Hello, My name is java");
    }
}
