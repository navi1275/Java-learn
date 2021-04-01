package com.navi.java8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * ConsumerTest Class
 * 消费者
 * @author ganxf
 * @date 2021/2/23
 */
@RunWith(JUnit4.class)
public class ConsumerTest {

    @Test
    public void test1(){
        Consumer<Integer> consumer = (Integer age) ->{
            System.out.println("111**" + age);
        };
        consumer.accept(2);

        Consumer<Integer> consumer1 = (Integer age) ->{
            System.out.println("222**" + age);
        };
        consumer.andThen(consumer1).accept(3);
    }
}
