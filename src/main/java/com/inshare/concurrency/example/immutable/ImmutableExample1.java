package com.inshare.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.inshare.concurrency.annoation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author Guichao
 * @since 2018/9/12
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
        /**
         * final修饰的变量：
         * 1、变量是基础数据类型，则不可修改其内容
         * 2、变量是引用类型，则不可指向其他对象，但可以修改指向对象的内容
         */
//        a = 2;
//        b = "3";
//        map = Maps.newHashMap();
        map.put(1,3);
        log.info("{}", map.get(1));
    }

    private void test(final int a) {
//        a = 1;    // 也是不能修改的
    }
}
