package com.nged.threadpool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadABC2 {

    private static final Lock lock = new ReentrantLock();

    private static final int COUNT=2;//总输出几次

    private static int state = 0;//判断当前谁输出


    public static void main(String[] args){


        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<COUNT;){
                   // System.out.println("A start");
                    lock.lock();
                    if(state%3==0){
                        System.out.println("A");
                        state++;
                        i++;
                    }
                    lock.unlock();
                   // System.out.println("A end");
                }

            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<COUNT;){
                   // System.out.println("B start");
                    lock.lock();
                    if(state%3==1){
                        System.out.println("B");
                        state++;
                        i++;
                    }
                    lock.unlock();
                   // System.out.println("B end");
                }

            }
        });

        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<COUNT;){
                   // System.out.println("C start");
                    lock.lock();
                    if(state%3==2){
                        System.out.println("C");
                        state++;
                        i++;
                    }
                    lock.unlock();
                   // System.out.println("C end");
                }

            }
        });

        A.start();
        B.start();
        C.start();

       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }

}
