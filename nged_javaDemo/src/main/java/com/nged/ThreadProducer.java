package com.nged;

public class ThreadProducer implements Runnable {

    private TestVolatile t1;


    public ThreadProducer(TestVolatile t){
        this.t1 =t ;
    }

    @Override
    public void run (){
            while(true){
                try {
                    Thread.sleep(2000);
                    if(t1.TEMP==1){
                        System.out.println(Thread.currentThread().getName()+"不需要生产");
                    }else{
                        t1.TEMP=1;

                        System.out.println(Thread.currentThread().getName()+"生产完成");
                    }
                    t1.checkNotify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

    }
}
