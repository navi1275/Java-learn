package com.navi.java8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Function;

/**
 * FunctionTest Class
 * 输入一个对象，返回一个对象
 * @author ganxf
 * @date 2021/2/23
 */
@RunWith(JUnit4.class)
public class FunctionTest {

    @Test
    public void test1(){
        Function<String, Integer> fun = (String i) ->{
            return Integer.parseInt(i + 2);
        };
        Function<Integer, String> fun1 = (Integer i) ->{
            return String.valueOf(i * 10);
        };
        System.out.println(fun.apply("123"));

        // 先fun1 后fun
        System.out.println(fun.compose(fun1).apply(123));

        // 先fun 后fun1
        System.out.println(fun.andThen(fun1).apply("123"));

        //静态方法
        System.out.println(Function.identity().apply("1234"));
    }
}
