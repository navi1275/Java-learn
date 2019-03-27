package com.navi.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 双线程交替打印奇偶数 Class
 *
 * @author ganxiongfeng@foresee.com.cn
 * @date 2019-03-14
 * @since 1.0.0
 */
public class 双线程交替打印奇偶数 {

    static class Task1 implements Runnable {
        private static final Object LOCK = new Object();
        /**
         * 当前即将打印的数字
         */
        private static int current = 0;
        /**
         * 当前线程编号，从0开始
         */
        private int threadNo;
        /**
         * 线程数量
         */
        private int threadCount;
        /**
         * 打印的最大数值
         */
        private int maxInt;

        public Task1(int threadNo, int threadCount, int maxInt) {
            this.threadNo = threadNo;
            this.threadCount = threadCount;
            this.maxInt = maxInt;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (LOCK) {
                    // 最大值跳出循环
                    if (current > maxInt) {
                        break;
                    }
                    // 判断是否轮到当前线程执行
                    while (current % threadCount != threadNo) {
                        try {
                            // 如果不是，则当前线程进入wait
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("thread" + threadNo + " : " + current);
                    current++;
                    // 唤醒其他wait线程
                    LOCK.notifyAll();
                }
            }
        }

    }

    static class Task implements Runnable {

        static int value = 0;

        @Override
        public void run() {
            while (value < 100) {
                synchronized (Task.class) {
                    System.out.println(Thread.currentThread().getName() + "：" + value++);
                    Task.class.notify();
                    try {
                        Task.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
            }
        }
    }

    static int result = 0;
    static int N = 3;
    static final Semaphore[] syncObjects = new Semaphore[N];

    public static void main(String[] args) throws InterruptedException {
        /*new Thread(new Task(), "偶数线程").start();
        new Thread(new Task(), "奇数线程").start();

        int threadCount = 3;
        int max = 100;
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Task1(i, threadCount, max)).start();
        }*/

        for (int i = 0; i < N; i++) {
            syncObjects[i] = new Semaphore(1);
            if (i != N - 1) {
                syncObjects[i].acquire();
            }
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < N; i++) {
            final Semaphore lastSemphore = i == 0 ? syncObjects[N - 1] : syncObjects[i - 1];
            final Semaphore curSemphore = syncObjects[i];
            final int index = i;
            executorService.execute(() -> {
                try {
                    while (true) {
                        lastSemphore.acquire();
                        System.out.println("thread" + index + ": " + result++);
                        if (result > 100) {
                            System.exit(0);
                        }
                        curSemphore.release();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
