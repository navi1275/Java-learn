package com.navi.spi.service;

import java.util.ServiceLoader;

public class SpiRun {

    public static void main(String[] args) {
        ServiceLoader<Say> load = ServiceLoader.load(Say.class);
        load.forEach(Say::sayHello);
    }
}
