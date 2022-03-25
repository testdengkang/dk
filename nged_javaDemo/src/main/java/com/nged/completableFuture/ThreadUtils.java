package com.nged.completableFuture;


public class ThreadUtils {

    public static void sleep(int millis)  {
        if(millis<=0){
            return;
        }
        try{
            Thread.sleep(millis);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void work(String name,int millis)  {
       System.out.println(name+" start");
       sleep(millis);
       System.out.println(name+" end");

    }
}
