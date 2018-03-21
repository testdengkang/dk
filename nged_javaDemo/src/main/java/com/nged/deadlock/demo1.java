package com.nged.deadlock;

public class demo1 {

    private static Object lock_1 = new int[1];
    private static Object lock_2 = new int[1];

    public class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("thread 1 start");
            synchronized (lock_1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread 1 get lock_1 need lock_2");
                synchronized (lock_2) {

                }
            }
            System.out.println("thread 1 end");
        }
    }

    public class Thread2 extends Thread{
        @Override
        public void run(){
            System.out.println("thread 2 start");
            synchronized (lock_2){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("thread 2 get lock_2 need lock_1");
                synchronized (lock_1){

                }
            }
            System.out.println("thread 2 end");
        }
    }
    public static void main(String[] args){

        new demo1().new Thread1().start();
        new demo1().new Thread2().start();

    }
}
