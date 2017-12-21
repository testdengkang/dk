package com.nged;

public class T1 {
    private static int t1 =1;

    static{
        System.out.println("父类 静态代码块");
    }


    //int a =8;
    {
       // a = 1;
        System.out.println("父类 动态代码块");
        printT1();
    }
    public T1(){
        System.out.println("父类 构造器");
        printT1();
//        printT1();
    }

    public void printT1(){
        System.out.println("父类 方法");
        //System.out.println("父类"+a);
    }

}
