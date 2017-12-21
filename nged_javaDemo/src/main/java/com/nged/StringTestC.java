package com.nged;

public class StringTestC {
    public static void main(String[] args){
       //Sting 方式拼接
       /* String a ="1"+"b";
        System.out.println("Sting 方式拼接"+a);*/
        //StringBuilder方式拼接
/*        String a = new StringBuilder("1").append("b").toString();
        System.out.println("StringBuilder方式拼接"+a);*/
        //StringBuffer方式拼接
        /*StringBuffer a = new StringBuffer("1").append("b");
        System.out.println("StringBuffer方式拼接"+a);*/
        String a ="1";
        String c="1";
        System.out.println(a.equals(c));
        System.out.println(a);
        String b = "2";
        a = b;
        System.out.println(a);
    }
}
