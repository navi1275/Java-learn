package com.navi.proxy.multilevel.test;

import com.navi.proxy.multilevel.impl.Cicadas;
import com.navi.proxy.multilevel.service.BaseService;
import com.navi.proxy.multilevel.util.CicadasProxyFactory;

/**
 * Testcls Class
 *
 * @author Administrator
 * @date 2018-11-08
 * @since 1.0.0
 */
public class Testcls {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        BaseService instance = CicadasProxyFactory.getInstance(Cicadas.class);

        instance.eating();
    }
}
