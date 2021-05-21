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
public class VolatileTest {

    private static volatile int k = 0;
    private static volatile boolean ready;
    private static int num;

    @Test
    public void test1() {
        Object o = new Object();
        Thread[] arr = new Thread[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Thread(){

                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        k++;
                    }
                }
            };
            arr[i].start();
        }
        for (int i = 0; i < 10; i++) {
            try {
                arr[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //输出k小于 100w， volatile不具备原子性
        System.out.println(k);

    }

    @Test
    public void test2() {
        new Thread(){
            @Override
            public void run() {
                while (!ready){
                    
                }
                System.out.println(num);
            }
        }.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 40;
        ready = true;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
