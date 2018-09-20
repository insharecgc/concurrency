package com.inshare.concurrency.example.lock;

import com.inshare.concurrency.annoation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Guichao
 * @since 2018/9/10
 */
@Slf4j
@ThreadSafe
public class LockExample5 {

    public static void main(String[] arg) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
            reentrantLock.lock();
            log.info("wait signal");    //1
            try {
                condition.await();  // 此处会释放锁，同时加入等待队列，等待被唤醒同时获得锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("get signal");     //4
            reentrantLock.unlock();
        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            log.info("get lock");       //2
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            log.info("send signal ~~"); //3
            reentrantLock.unlock();
        }).start();
    }
}
