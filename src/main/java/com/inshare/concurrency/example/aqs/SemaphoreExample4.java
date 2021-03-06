package com.inshare.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Guichao
 * @since 2018/9/13
 */
@Slf4j
public class SemaphoreExample4 {

    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        // 并发数量
        final Semaphore semaphore = new Semaphore(3);

        for (int i=0; i<threadCount; i++) {
            final int threadNum = i; // 线程调用的方法，传参只能是final的
            // 线程执行lamda写法，相当于是重写Runable的run方法
            exec.execute(() -> {
                try {
                    // 尝试等待获取一个许可，时间按需求设置
                    if ( semaphore.tryAcquire(4000, TimeUnit.MILLISECONDS)) {
                        test(threadNum);
                        semaphore.release();    // 释放一个许可
                    }
                } catch (InterruptedException e) {
                    log.error("exception {}",e.getMessage());
                }
            });
        }
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}",threadNum);
        Thread.sleep(1000);
    }
}
