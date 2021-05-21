package com.navi.concurrent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockTest Class
 *
 * @author ganxf
 * @date 2021/5/10
 */
@RunWith(JUnit4.class)
public class ReentrantLockTest {

    @Test
    public void test(){
        // 无参构造，创建非公平锁
        ReentrantLock lock = new ReentrantLock();

        Thread threadA = new Thread(() -> {
            boolean b = lock.tryLock();
            if(b){
                System.out.println("线程A获取到锁");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }else{
                System.out.println("线程A没有获取到锁");
            }
        });

        Thread threadB = new Thread(() -> {

            while (!lock.tryLock()){
                try {
                    System.out.println("线程B没有获取到锁,自旋获取锁");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程B获取到锁");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();

        });

        threadA.start();
        threadB.start();

        try {
            lock.lock();
            System.out.println("主线程获取到锁");
            TimeUnit.SECONDS.sleep(2);
            lock.unlock();

            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(lock.isLocked()) {
                lock.unlock();
            }
        }

    }

}
