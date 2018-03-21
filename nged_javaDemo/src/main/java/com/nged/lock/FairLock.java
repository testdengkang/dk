package com.nged.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 通过reentrantlock实现公平锁
 */
public class FairLock implements Runnable {

    private ReentrantLock lock = new ReentrantLock(true);//true为公平锁

    @Override
    public void run() {
        while (true){

            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"活的锁 并执行");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args){
        FairLock lock = new FairLock();
        Thread t1 = new Thread(lock);
        t1.setName("T1");
        Thread t2 = new Thread(lock);
        t2.setName("T2");

        t1.start();
        t2.start();
    }

}
