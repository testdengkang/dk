package com.nged.jvm;

/**
 * 关于新生代中晋升年龄的动态机制
 * -XX:+UseG1GC 默认15次
 * -XX:+UseConcMarkSweepGC 验证默认6次
 */
public class DynamicPromotionAge {

    public static void main(String[] args) throws InterruptedException {
        byte[] b6 = new byte[1024*1024];
        byte[] b5 = new byte[1024*1024];

        test();
        Thread.sleep(1000);

        test();
        Thread.sleep(1000);

        test();
        Thread.sleep(1000);

        test();
        Thread.sleep(1000);

        test();
        Thread.sleep(1000);
      byte[] b1 = new byte[1024*1024];
        byte[] b2= new byte[1024*1024];
        byte[] b3 = new byte[1024*1024];

        test();
        Thread.sleep(1000);

        test();
        Thread.sleep(1000);

        test();
        Thread.sleep(1000);

    }
    public static void test(){
        for(int i=0;i<40;i++){
            byte[] bt = new byte[1024*1024];
        }
    }

}
