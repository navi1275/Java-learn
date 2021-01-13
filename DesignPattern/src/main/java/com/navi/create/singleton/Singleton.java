package com.navi.create.singleton;

/**
 * Singleton Class
 *
 * @author ganxf
 * @date 2019-11-14
 */
public class Singleton {

    /**
     * 私有构造
     */
    private Singleton(){}

    // 懒汉式，lazy初始化，线程不安全
    private static Singleton instance;

    // 饿汉式，线程安全
    private static Singleton hungry = new Singleton();

    // 线程不安全
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    // 同步方法
    public static synchronized Singleton getSynchronizedInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }


    public static Singleton getInstance2(){
        //双层检测锁，DCL,double-checked locking
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder{
        private static Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance3(){
        return SingletonHolder.INSTANCE;
    }


    /**
     * 枚举
     */
    private enum SingletonEnum{
        INSTANCE;
    }


}
