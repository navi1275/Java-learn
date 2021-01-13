package com.navi.service;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("cjjsay")
public interface Say {

    void sayHello(String url);

    @Adaptive({"t"})
    void sayUrl(URL url);

}
