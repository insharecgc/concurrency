package com.inshare.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Guichao
 * @since 2018/9/17
 */
@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws Exception{
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });

        new Thread(futureTask).start();
        log.info("do something in main");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("result: {}", result);
    }
}
