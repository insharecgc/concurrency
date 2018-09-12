package com.inshare.concurrency.example.singleton;

import com.inshare.concurrency.annoation.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * @author Guichao
 * @since 2018/9/12
 */
@NotThreadSafe
public class SingletonExample1 {
    private SingletonExample1() {

    }

    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
