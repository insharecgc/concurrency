package com.inshare.concurrency.example.singleton;

import com.inshare.concurrency.annoation.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类加载时进行创建（导致类加载慢，可能资源浪费）
 * @author Guichao
 * @since 2018/9/12
 */
@ThreadSafe
public class SingletonExample2 {
    private SingletonExample2() {

    }

    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
        return instance;
    }
}
