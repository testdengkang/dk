package com.nged.jvm;
//验证栈的溢出
//vm -Xss128k
public class StackOverFlowDemo {
    private int length=1;
    public void stackLeak(){
        length++;
        stackLeak();
    }

    public static void main(String[] args){
        StackOverFlowDemo demo = new StackOverFlowDemo();
        try{
            demo.stackLeak();
        }catch (Throwable e){//此处如果用Exception 则无法看到length的打印
            System.out.println(demo.length);
            throw e;
        }

    }
}
