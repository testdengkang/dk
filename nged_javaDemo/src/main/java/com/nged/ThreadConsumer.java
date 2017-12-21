package com.nged;

public class ThreadConsumer implements Runnable {

    private TestVolatile t2;


    public ThreadConsumer(TestVolatile t){
        this.t2 = t;
    }

    @Override
    public void run(){
        while(true){
            try {
                Thread.sleep(2000);
                if(t2.TEMP==0){
                    System.out.println(Thread.currentThread().getName()+"没得消费");

                }else{
                    System.out.println(Thread.currentThread().getName()+"去消费");
                    t2.TEMP=0;
                }
                t2.checkWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }

    }

}
