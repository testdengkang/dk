package com.nged.CallbackDemo;

import java.util.HashMap;
import java.util.concurrent.*;

public class JdkCallbackTest {
    public void testCallBack1(){
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return "call";
            }
        };

        FutureTask<String> futureTask = new FutureTask(callable);
        new Thread(futureTask).start();

//        do something other
        System.out.println("利用任务执行的时间干点其他事情");
        try {
            String result = futureTask.get();

            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void testCallBack2(){
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "call testCallBack2";
            }
        });
        //暂时做其他的事情
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        try {
           String result =  future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("end");

        HashMap<Integer,Integer> hp = new HashMap<>(3000000);




    }
    public static  void main(String[] args){

        JdkCallbackTest jdkCallbackTest = new JdkCallbackTest();
        jdkCallbackTest.testCallBack2();



    }
}
