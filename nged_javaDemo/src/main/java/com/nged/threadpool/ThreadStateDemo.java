package com.nged.threadpool;

/**
 * @Auther: dk
 * @Date: 2018/11/9 15:02
 * @Description:
 * 测试内容
 * 1 通过自设条件停止线程 tabkeOff开关
 * 2 通过thread.interrupt()设置中断状态中断线程，通过检查isInterrupted()检查中断状态 中断线程
 * 3 Thread.interrupted() 对当前线程中断状态的清除
 */
public class ThreadStateDemo implements Runnable {

    private boolean takeOff = false;
    @Override
    public void run() {
      /*  while (!takeOff){
          //System.out.println(System.currentTimeMillis());

        }*/

        while (true){
            if(Thread.currentThread().isInterrupted()){
                System.out.println("收到中断");
                break;
            }else{
                System.out.println("未收到中断"+System.currentTimeMillis());
            }

        }





    }


    public static void main(String[] argsg){

        ThreadStateDemo t = new ThreadStateDemo();

        Thread thread = new Thread(t);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
      /* 1 for(int i=0;i<1000;i++){

            if(i==999){
                t.setTakeOff(true);
            }
            System.out.println(thread.isInterrupted());
        }*/


     /* 2  if(thread.isInterrupted()){
            System.out.println("11已中止");
        }
        thread.interrupt();
        if(thread.isInterrupted()){
            System.out.println("22已中止");
        }*/

        /*System.out.println("当前线程1"+Thread.currentThread().isInterrupted());
        System.out.println("当前线程2"+Thread.currentThread().isInterrupted());*/
    }
}
