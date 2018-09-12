package com.inshare.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.inshare.concurrency.annoation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;


/**
 * @author Guichao
 * @since 2018/9/12
 */
@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    /**
     * guava包下ImmutableXXX类，表示对象不可修改
     */

    private final static ImmutableList list = ImmutableList.of(1,2,3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map =
            ImmutableMap.of(1, 2, 3, 4);

    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3, 4).put(5, 6).build();

    public static void main(String[] args) {
//        map.add(4);
//        map.add(4);
//        map.put(3, 5);
//        map.put(3, 5);
        log.info("{}", map2.get(3));
    }

}
