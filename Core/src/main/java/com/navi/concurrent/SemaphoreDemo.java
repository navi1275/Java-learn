package com.navi.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * SemaphoreDemo Class
 *
 * @author navi
 * @date 2019-03-15
 * @since 1.0.0
 */
public class SemaphoreDemo {

    // 排队总人数（请求总数）
    public static int clientTotal = 50;

    // 可同时受理业务的窗口数量（同时并发执行的线程数）
    public static int threadTotal = 2;


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < 10; i++) {
            final int count = i;
            executorService.execute(() -> {

                try {
                    semaphore.acquire(1);
                    resolve(count);
                    semaphore.release(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        System.out.println("主线程即将被阻塞");
        countDownLatch.await();
        System.out.println("主线程被唤醒，继续执行");
        executorService.shutdown();
    }

    private static void resolve(int i) throws InterruptedException {
        System.out.println("服务号{}，受理业务中。。。 "+i);
        Thread.sleep(2000);
    }
}

