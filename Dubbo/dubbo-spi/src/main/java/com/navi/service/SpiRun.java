package com.navi.service;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

public class SpiRun {

    public static void main(String[] args) {
        ExtensionLoader<Say> load = ExtensionLoader.getExtensionLoader(Say.class);
        // Say javasay = load.getExtension("javasay");
        // javasay.sayHello("java");
        // Say phpsay = load.getExtension("phpsay");
        // phpsay.sayHello("php");
        // Say cjjsay = load.getExtension("cjjsay");
        // cjjsay.sayHello("cjj");

        Say say = load.getAdaptiveExtension();
        URL url1 = URL.valueOf("http://localhost/aaa?name=java");
        URL url = URL.valueOf("http://localhost/aaa?t=javasay&name=java");
        say.sayUrl(url);
        say.sayUrl(url1);
    }
}
