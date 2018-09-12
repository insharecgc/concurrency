package com.inshare.concurrency.example.singleton;

import com.inshare.concurrency.annoation.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类加载时进行创建（导致类加载慢，可能资源浪费）
 * @author Guichao
 * @since 2018/9/12
 */
@ThreadSafe
public class SingletonExample6 {
    private SingletonExample6() {

    }

    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
