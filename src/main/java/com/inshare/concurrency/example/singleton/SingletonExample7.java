package com.inshare.concurrency.example.singleton;

import com.inshare.concurrency.annoation.Recommend;
import com.inshare.concurrency.annoation.ThreadSafe;

/**
 * 枚举模式：最安全的
 * @author Guichao
 * @since 2018/9/12
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    /**
     * 枚举类的构造器【只能使用 private 访问修饰符】
     * 构造器只在构造枚举值时被调用
     */
    private enum Singleton {
        INSTANCE;   // 枚举值(枚举的实例)

        private SingletonExample7 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getInstance() {
            return singleton;
        }
    }
}
