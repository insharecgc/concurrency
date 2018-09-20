package com.inshare.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Guichao
 * @since 2018/9/18
 */
@Slf4j
public class ThreadPoolExample2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; ++i) {
            final int index = i;
            executorService.submit(() -> {
                log.info("task:{}",index);
            });
        }

        executorService.shutdown();
    }

}
