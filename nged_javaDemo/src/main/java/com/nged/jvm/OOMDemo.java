package com.nged.jvm;

import java.util.ArrayList;
import java.util.List;

//设置jvm 堆大小 已经堆溢出时dump出当前内存堆快照
//验证 java.lang.OutOfMemoryError: Java heap space
//vm args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
//-Xms20m -Xmx20m -Xmn2m  -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintGCCause -Xloggc:E:/github/myGit/dk/nged_javaDemo/OOMDemo_gc.log
public class OOMDemo {

    static class OomClass{
        private ArrayList al = new ArrayList(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        List<OomClass> list = new ArrayList<OomClass>();
        while (true){
            Thread.sleep(200);
            list.add(new OomClass());
        }

    }

}
