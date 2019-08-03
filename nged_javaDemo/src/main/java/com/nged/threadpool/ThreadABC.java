package com.nged.threadpool;

/**
 * 人为控制线程执行顺序 A,B,C
 */
public class ThreadABC {

    public static void main(String[] args) throws InterruptedException {
        class A implements Runnable{
            @Override
            public void run() {

                    System.out.println("A");


            }
        }
        class B implements Runnable{
            @Override
            public void run() {

                    System.out.println("B");


            }
        }
        class C implements Runnable{
            @Override
            public void run() {

                    System.out.println("C");


            }
        }






        for(int i=1;i<=6;i++){
            Thread threadA = new Thread(new A());
            threadA.start();
            threadA.join();
            Thread threadB = new Thread(new B());
            threadB.start();
            threadB.join();
            Thread threadC = new Thread(new C());
            threadC.start();
            threadC.join();
        }


    }
}
