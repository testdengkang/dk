package com.nged;

public class T2 extends T1{
     int a =9;
     String s ="111111";
    {
        a = 11;
        System.out.println("子类 动态代码块");
        printT1();
    }
    public T2(){
        System.out.println("子类 构造器");
        printT1();
    }
    @Override
    public void printT1(){
        System.out.println("子类 方法");
        s = "2222";
        System.out.println("子类 "+a);
    }
    public static void main(String[] args)  {

        System.out.println(new T2().s);

    }
}
