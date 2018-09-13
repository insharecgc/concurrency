package com.inshare.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Guichao
 * @since 2018/9/13
 */
@Slf4j
public class CountDownLatchExample2 {

    private static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i=0; i<threadCount; i++) {
            final int threadNum = i; // 线程调用的方法，传参只能是final的

            // 线程执行lamda写法，相当于是重写Runable的run方法
            exec.execute(() -> {
                try {
                    test(threadNum);
                } catch (InterruptedException e) {
                    log.error("exception {}",e.getMessage());
                }
                finally {
                    countDownLatch.countDown();
                }
            });
        }
        // 指定等待时间后(此处是10毫秒)，就不再等待了
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        log.info("############### finish");
        exec.shutdown();    //等待线程池里的线程执行完后再关闭销毁
    }

    private static void test(int threadNum) throws InterruptedException {
        Thread.sleep(2);
        log.info("{}",threadNum);
//        Thread.sleep(100);
    }
}
