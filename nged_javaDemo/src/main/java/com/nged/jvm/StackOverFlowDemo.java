package com.nged.jvm;
//验证栈的溢出
//vm -Xss128k
//-Xmx100m -Xms100m -Xmn10m -Xss128k  -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintGCCause -Xloggc:E:/github/myGit/dk/nged_javaDemo/StackOverFlowDemo_gc.log  -XX:+PrintCommandLineFlags
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
