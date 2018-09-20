package com.inshare.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @author Guichao
 * @since 2018/9/18
 */
@Slf4j
public class ThreadPoolExample5 {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        log.info("ready schedule task");
        for (int i = 0; i < 2; ++i) {
            final int index = i;

            // 延迟 3 秒后执行
            executorService.schedule(() -> {
                log.info("schedule task:{}", index);
            }, 3, TimeUnit.SECONDS);

            // 延迟 1 秒执行，之后每隔3秒执行一次
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    log.info("scheduleAtFixedRate task:{}", index);
                }
            }, 1, 3, TimeUnit.SECONDS);
        }
//        executorService.shutdown();

        // 定时器，立即执行一次(new Date())，之后每隔5秒执行一次(5*1000)
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.warn("timer run");
            }
        }, new Date(), 5*1000);
    }

}
