package com.inshare.concurrency.example.threadLocal;

import com.inshare.concurrency.annoation.ThreadSafe;

/**
 * @author Guichao
 * @since 2018/9/12
 */
@ThreadSafe
public class RequestHolder {

    // ThreadLocal则用于线程间的数据隔离（线程封闭）
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id) {
        requestHolder.set(id);
    }

    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }
}
