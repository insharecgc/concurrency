package com.inshare.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Guichao
 * @since 2018/9/18
 */
@Slf4j
public class ThreadPoolExample1 {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
                10,
                10, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());

        for ( int i = 0; i < 10; ++i) {
            final int index = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    log.info("task:{}",index);
                }
            });
        }
        executor.shutdown();
    }
}
