package com.navi.java8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Predicate;

/**
 * PredicateTest Class
 *
 * @author ganxf
 * @date 2021/2/23
 */
@RunWith(JUnit4.class)
public class PredicateTest {

    @Test
    public void test1(){
        Predicate<Integer> predicate = (Integer age) ->{
            return age >= 12;
        };
        Predicate<Integer> predicate1 = (Integer age) ->{
            return age <= 18;
        };
        System.out.println(predicate.test(2));
        System.out.println(predicate.test(14));
        // 先执行test，后执行and
        System.out.println(predicate.and(predicate1).test(16));
        // 短路操作
        System.out.println(predicate.or(predicate1).test(16));
        // negate test判断取反
        System.out.println(predicate.negate().test(16));


        // 静态方法isequal
        System.out.println(Predicate.isEqual(2).test(2));
    }
}
