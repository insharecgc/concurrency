package com.inshare.concurrency.example.syncContainer;

import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * @author Guichao
 * @since 2018/9/12
 */
@Slf4j
public class VectorExample2 {

    public static void test1(Vector<Integer> v1) {  //foreach
        for (Integer i : v1) {
            if (i.equals(3)){
                v1.remove(i);
            }
        }
    }

    public static void test2(Vector<Integer> v1) {  //iterator
        Iterator<Integer> it = v1.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (i.equals(3)){
                v1.remove(i);
            }
        }
    }

    // success
    public static void test3(Vector<Integer> v1) {  //for
        for (int i=0; i<v1.size(); ++i) {
            if (v1.get(i).equals(3)){
                v1.remove(v1.get(i));
            }
        }
    }

    public static void main(String[] arg) throws Exception{
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test3(vector);
    }
}
