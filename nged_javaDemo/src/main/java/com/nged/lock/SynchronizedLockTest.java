package com.nged.lock;

public class SynchronizedLockTest {
    public static void main(String[] args){

        SynchronizedLock lock1 = new SynchronizedLock();
        SynchronizedLock.value = "1";

        SynchronizedLock lock2 = new SynchronizedLock();
        System.out.println(lock2.value);



    }
}
