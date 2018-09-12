package com.inshare.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.inshare.concurrency.annoation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @author Guichao
 * @since 2018/9/12
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        // Collections.unmodifiableXXX调用过的对象【不允许被修改】
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {

        map.put(1,3);
        log.info("{}", map.get(1));
    }

}
