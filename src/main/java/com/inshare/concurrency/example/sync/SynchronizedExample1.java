package com.inshare.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * synchronized 作用于代码块和方法是一样的
 * @author Guichao
 * @since 2018/9/11
 */
@Slf4j
public class SynchronizedExample1 {

    // 修饰一个代码块，作用于调用的对象
    public void test1(int j) {
        synchronized (this) {
            for (int i=0; i< 10; i++) {
                log.info("test1 - {} - {}", j, i);
            }
        }
    }

    // 修饰一个方法，作用于调用的对象
    // 如果有子类继承，不会继承synchronized
    public synchronized void test2(int j) {
        for (int i=0; i< 10; i++) {
            log.info("test2 - {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test2(1);
        });
        executorService.execute(() -> {
            example2.test2(2);
        });
    }
}
