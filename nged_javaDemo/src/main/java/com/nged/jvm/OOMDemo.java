package com.nged.jvm;

import java.util.ArrayList;
import java.util.List;

//设置jvm 堆大小 已经堆溢出时dump出当前内存堆快照
//vm args: -Xms20m -Xmx20m -XX:+heapDumpOnOutOfMemoryError
public class OOMDemo {

    static class OomClass{

    }

    public static void main(String[] args){
        List<OomClass> list = new ArrayList<OomClass>();
        while (true){
            list.add(new OomClass());
        }

    }

}
