package com.navi;

/**
 * 双亲委派机制 Class
 *
 * @author ganxf
 * @date 2021/5/28
 */
public class 双亲委派机制 {

    public static void main(String[] args) {
        //AppClassLoader
        ClassLoader classLoader = 双亲委派机制.class.getClassLoader();
        System.out.println(classLoader);
        //ExtClassLoader
        System.out.println(classLoader.getParent());
        //null ExtClassLoader的parent为null，不能够获取到BootstrapClassLoader的引用
        System.out.println(classLoader.getParent().getParent());

        System.out.println(ClassLoader.getSystemClassLoader());

        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
