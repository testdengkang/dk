package com.nged.finalizeDemo;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TestDemo {

    public static TestDemo testDemo;

    @Override
    public void finalize(){
        try {
            super.finalize();
            testDemo = this;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public  static  void main(String[] args) throws InterruptedException {
        testDemo = new TestDemo();
        testDemo = null;
        System.gc();
        Thread.sleep(1000);
        if(null==testDemo){
            System.out.println("gc成功");
        }else{
            System.out.println("复活成功");
        }
        testDemo = null;
        System.gc();
        Thread.sleep(2000);
        if(null==testDemo){
            System.out.println("gc成功");
        }else{
            System.out.println("复活成功");
        }
    }
}
