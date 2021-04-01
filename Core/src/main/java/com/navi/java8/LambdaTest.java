package com.navi.java8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Lambda Class
 *
 * @author ganxf
 * @date 2021/2/23
 */
@RunWith(JUnit4.class)
public class LambdaTest {

    @Test
    public void test1() {
        HelloService service = new HelloService() {
            @Override
            public void sayHello() {
                System.out.println("hello world");
            }
        };
        service.sayHello();
        service.sayBye();
    }

    @Test
    public void test2() {
        HelloService service = ()->{
            System.out.println("hello world");
        };
        service.sayHello();
    }

    @Test
    public void test3() {
        HelloService1 service = new HelloService1() {
            @Override
            public String sayHello() {
                return "hello world";
            }
        };
        System.out.println(service.sayHello());
    }

    @Test
    public void test4() {
        HelloService1 service = ()->{
            return "hello world";
        };
        System.out.println(service.sayHello());

    }

    @Test
    public void test5() {
        HelloService2 service = new HelloService2() {
            @Override
            public String sayHello(String name) {
                return "hello " + name;
            }
        };
        System.out.println(service.sayHello("zhangsan"));
    }

    @Test
    public void test6() {
        HelloService2 service = (name)->{
            return "hello " + name;
        };
        System.out.println(service.sayHello("zhangsan"));

    }

}

/**
 * 无参数无返回值
 */
@FunctionalInterface
interface HelloService{
    void sayHello();

    default void sayBye(){
        System.out.println("bye bye");
    }
}

/**
 * 无参数有返回值
 */
@FunctionalInterface
interface HelloService1{
    String sayHello();
}

/**
 * 有参数有返回值
 */
@FunctionalInterface
interface HelloService2{
    String sayHello(String name);
}
