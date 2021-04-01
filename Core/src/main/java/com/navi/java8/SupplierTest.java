package com.navi.java8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * SupplierTest Class
 * 生产者
 * @author ganxf
 * @date 2021/2/23
 */
@RunWith(JUnit4.class)
public class SupplierTest {

    @Test
    public void test1(){
        Supplier<Integer> supplier = () ->{
            return 123;
        };
        System.out.println(supplier.get());


    }
}
