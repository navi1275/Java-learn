package com.navi.concurrent.countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatchExample Class
 *
 * @author ganxf
 * @date 2020/7/22
 */
@Slf4j
public class CountDownLatchExample {

    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        // 手动创建线程池，效果会更好哦。
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } finally {
                log.info("Thread-1 执行完毕");
                countDownLatch.countDown();
            }
        });

        executorService.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } finally {
                log.info("Thread-2 执行完毕");
                countDownLatch.countDown();
            }
        });

        log.info("主线程等待子线程执行完毕");
        log.info("计数器值为：" + countDownLatch.getCount());
        countDownLatch.await();
        log.info("计数器值为：" + countDownLatch.getCount());
        log.info("主线程执行完毕");
        executorService.shutdown();
    }
}
