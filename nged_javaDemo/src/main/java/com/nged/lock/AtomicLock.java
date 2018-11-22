package com.nged.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: Administrator
 * @Date: 2018/11/16 14:36
 * @Description:
 *  自旋锁
 */
public class AtomicLock {

    private AtomicReference<Thread> sign = new AtomicReference<>();
    public void lock(){
        Thread current = Thread.currentThread();
        while (!sign.compareAndSet(null,current)){}
    }

    public void unlock(){
        Thread current = Thread.currentThread();
        sign.compareAndSet(current,null);
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicLock lock = new AtomicLock();
        AtomicThread t1 = new AtomicThread(lock);

       Thread d1 =  new Thread(t1);
        d1.start();
        Thread d2 = new Thread(t1);
        d2.start();
        d1.join();
        d2.join();
        System.out.println(t1.i);
    }
}
