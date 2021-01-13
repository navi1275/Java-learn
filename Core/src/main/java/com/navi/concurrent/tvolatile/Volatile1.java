package com.navi.concurrent.tvolatile;

import java.util.concurrent.TimeUnit;

/**
 * Volatile1 Class
 *
 * @author navi
 * @date 2019-04-02
 * @since 1.0.0
 */
public class Volatile1 {

    private boolean flag = true;
    private void run(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    doSomeThing();
                }
            }
        });

        thread.start();
    }

    private void doSomeThing() {
        System.out.println("doSomeThing...");
    }

    private void stop(){
        flag = false ;
        System.out.println("停止线程");
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile1 volatile1 = new Volatile1();
        volatile1.run();

        TimeUnit.SECONDS.sleep(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                volatile1.stop();
            }
        }).start();
    }
}
