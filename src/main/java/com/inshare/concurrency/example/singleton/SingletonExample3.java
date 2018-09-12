package com.inshare.concurrency.example.singleton;

import com.inshare.concurrency.annoation.NotRecommend;
import com.inshare.concurrency.annoation.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 * @author Guichao
 * @since 2018/9/12
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    private SingletonExample3() {

    }

    private static SingletonExample3 instance = null;

    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
