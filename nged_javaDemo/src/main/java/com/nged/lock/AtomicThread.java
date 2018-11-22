package com.nged.lock;

/**
 * @Auther: Administrator
 * @Date: 2018/11/16 14:47
 * @Description:
 */
public class AtomicThread implements Runnable {
    public static int i;

    private AtomicLock lock;

    public AtomicThread(){}

    public AtomicThread(AtomicLock lock){
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName());
            lock.lock();
            i++;

        }finally {
            lock.unlock();
        }

    }
}
