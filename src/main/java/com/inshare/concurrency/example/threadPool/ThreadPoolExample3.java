package com.inshare.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Guichao
 * @since 2018/9/18
 */
@Slf4j
public class ThreadPoolExample3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; ++i) {
            final int index = i;
            executorService.submit(() -> {
                log.info("task:{}",index);
            });
        }

        executorService.shutdown();
    }

}
