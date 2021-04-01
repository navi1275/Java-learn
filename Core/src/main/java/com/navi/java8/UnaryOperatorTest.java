package com.navi.java8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * UnaryOperatorTest Class
 * UnaryOperator 继承 Function
 * @author ganxf
 * @date 2021/2/23
 */
@RunWith(JUnit4.class)
public class UnaryOperatorTest {

    @Test
    public void test1(){
        UnaryOperator<String> fun = (String i) ->{
            return "${" + i + "}";
        };
        System.out.println(fun.apply("age"));
    }
}
