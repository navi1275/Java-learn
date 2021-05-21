package com.navi.concurrent.synchroniz;

/**
 * 错误加锁问题 Class
 *
 * @author ganxf
 * @date 2021/4/25
 */

public class 错误加锁问题 {
    static  BadLockOnInteger instance = new BadLockOnInteger();

    public static Integer lock = -128;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(lock);
    }
}

class BadLockOnInteger implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 128; i++) {
            // false, lock++ 语法糖实际等同于 Integer.valueOf(lock.intValue()+1);
            // Integer.valueOf 自动装箱问题 -128<=i<=127不会创建新的对象(用来当锁也是指向不同的对象)， 其他值时，均会创建新的对象
            // synchronized 只能使用object对象
            synchronized (错误加锁问题.lock){
            // true
            // synchronized (错误加锁问题.instance){
                错误加锁问题.lock++;
            }
        }
    }
}