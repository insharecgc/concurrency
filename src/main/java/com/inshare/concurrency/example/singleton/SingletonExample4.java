package com.inshare.concurrency.example.singleton;

import com.inshare.concurrency.annoation.NotThreadSafe;

/**
 * 懒汉模式 -- 双重检测机制
 * 单例实例在第一次使用时进行创建
 * @author Guichao
 * @since 2018/9/12
 */
@NotThreadSafe
public class SingletonExample4 {
    private SingletonExample4() {

    }

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // JVM和cpu优化，可能发生指令重排序

    // 1、memory = allocate() 分配对象的内存空间
    // 3、instance = memory 设置instance指向刚分配的内存
    // 2、ctorInstance() 初始化对象

    private static SingletonExample4 instance = null;

    public static SingletonExample4 getInstance() {
        if (instance == null) { //双重检测机制           // B
            synchronized (SingletonExample4.class) {    //同步锁
                if (instance == null) {
                    instance = new SingletonExample4(); // A - 3
                }
            }
        }
        return instance;
    }
}
