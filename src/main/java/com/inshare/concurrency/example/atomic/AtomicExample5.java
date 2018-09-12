package com.inshare.concurrency.example.atomic;

import com.inshare.concurrency.annoation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author Guichao
 * @since 2018/9/10
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    private volatile int count = 100;

    public static void main(String[] arg) {

        AtomicExample5 example5 = new AtomicExample5();

       if (updater.compareAndSet(example5, 100, 120)) {
           log.info("updata success 1, {}", example5.getCount());
       }
       if (updater.compareAndSet(example5, 100, 130)) {
           log.info("updata success 2, {}", example5.getCount());
       } else {
           log.info("updata failed 2, {}", example5.getCount());
       }
    }
}
