package com.nged.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 */
public class SpinLock {

     AtomicReference<Thread> owner = new AtomicReference<>();

    public void lock(){
        Thread thread = Thread.currentThread();

        while(!owner.compareAndSet(null,thread)){

        }
    }

    public void unlock(){
        Thread thread = Thread.currentThread();
        owner.compareAndSet(thread,null);
    }

}
class Test implements Runnable{
    static int num;
    private SpinLock spinLock;

    public Test(SpinLock spinLock) {
        this.spinLock = spinLock;
    }

    @Override
    public void run() {
        try {

            spinLock.lock();
            num++;
        }catch (Exception e){

        }finally {
            spinLock.unlock();
        }


    }

    public static void main(String[] args){
        SpinLock lock = new SpinLock();
        for(int i=0;i<50;i++){

            Test t = new Test(lock);
            new Thread(t).start();
        }
        System.out.println();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Test.num);


    }
}

