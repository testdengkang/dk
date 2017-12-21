package com.nged;

public class TestVolatile extends Thread {
        private int a  = 1;
        public volatile int TEMP = 1;

        private T1 t1  = new T1();
        private int b=2;
        public TestVolatile(){

        }
        public TestVolatile(T1 t){
            this.t1 =t ;
        }

        public  void checkWait()   {
            try {
                synchronized(t1){
                   // System.out.println(Thread.currentThread().getName()+"线程进入阻塞");
                    t1.wait();
                }

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        public  void checkNotify(){
            synchronized(t1){
                //System.out.println(Thread.currentThread().getName()+"唤醒一个等待线程");
                t1.notify();
            }


        }
        public void println(){
            System.out.println(a+b+TEMP);
        }
        public static void main(String[] args){
            T2 t = new T2();
            TestVolatile testVolatile = new TestVolatile();

           Thread p =  new Thread(new ThreadConsumer(testVolatile));
                   p.setName("consumer");
            p.start();
            Thread c = new Thread(new ThreadProducer(testVolatile));
            c.setName("producer");
            c.start();
           // (new Thread(new ThreadProducer(testVolatile))).start();

        }
}
