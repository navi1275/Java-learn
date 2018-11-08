package com.navi.test;

import com.navi.impl.Cicadas;
import com.navi.service.BaseService;
import com.navi.util.CicadasProxyFactory;

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
