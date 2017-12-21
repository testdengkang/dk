package com.nged.exceptionDemo;

public class ExceptionDemo {

    public int test1(){

       try{
           if(test2()==3){
               System.out.println("test1");

           }
       }catch (Exception e){
//           e.printStackTrace();
//           return  2;
           throw e;
       }finally {
           System.out.println("test1 finally 执行");
           return 5;
       }
    }

    public int test2(){
        try{
            int a = 1/0;
            return a;
        }catch (ArithmeticException e){
            System.out.println("捕获到算数异常");
            return 1;
//            throw e;
        }finally {
            System.out.println("test2 finally 执行");
            //return 3;
        }
    }
    public static void main(String[] args){
        ExceptionDemo ed = new ExceptionDemo();
        System.out.println(ed.test1());



    }
}
