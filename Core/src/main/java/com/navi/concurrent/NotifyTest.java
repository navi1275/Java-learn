package com.navi.concurrent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * NotifyTest Class
 *
 * @author ganxf
 * @date 2021/4/21
 */
@RunWith(JUnit4.class)
public class NotifyTest {

    @Test
    public void test1() {
        Object o = new Object();
        Thread t1 = new Thread(){

            @Override
            public void run() {
                synchronized (o) {
                    for (int i = 1; i < 11; i++) {
                        System.out.println(i);
                        if (i == 5) {
                            try {
                                //必须在synchronized内才生效，释放synchronized监控资源，等待其他线程唤醒
                                o.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Thread t2  = new Thread(){
            @Override
            public void run() {
                synchronized (o) {
                    System.out.println("helloworld");
                    //唤醒等待的线程，去争夺synchronized的监控资源
                    //t2执行完后，释放资源，t1继续执行
                    o.notify();
                }
            }
        };

        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
