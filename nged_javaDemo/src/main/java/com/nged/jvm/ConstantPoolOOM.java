package com.nged.jvm;

import java.util.ArrayList;
import java.util.List;

//常量池溢出
//vm -XX:PermSize=10M -XX:MaxPermSize=10M ，
//1.7 中还存在方法区 但是常量池已经不存在方法区了 而在堆上 ,1.8中已经不存在方法区了 取代的为元空间
//验证1.7 java.lang.OutOfMemoryError: GC overhead limit exceeded
//-XX:+PrintStringTableStatistics 当程序终止会打印常量池使用情况
//-Xmx50m -Xms50m -Xmn4m -XX:PermSize=10M -XX:MaxPermSize=10M  -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintGCCause -Xloggc:E:/github/myGit/dk/nged_javaDemo/ConstantPool_gc.log
//[Full GC (Allocation Failure) [PSYoungGen: 962K->962K(3072K)] [ParOldGen: 46983K->46983K(47104K)] 47946K->47946K(50176K) [PSPermGen: 3065K->3065K(10240K)], 0.1911677 secs] [Times: user=0.50 sys=0.00, real=0.19 secs]
//从gc日志上可以看出，方法区只使用了30% ，但是老年区已经撑爆了，说明1.7的常量池分配已经不再方法区了
//结果：Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
/*
Heap
        PSYoungGen      total 3072K, used 1062K [0x00000000ffc00000, 0x0000000100000000, 0x0000000100000000)
        eden space 2048K, 51% used [0x00000000ffc00000,0x00000000ffd09b48,0x00000000ffe00000)
        from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
        to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
        ParOldGen       total 47104K, used 46983K [0x00000000fce00000, 0x00000000ffc00000, 0x00000000ffc00000)
        object space 47104K, 99% used [0x00000000fce00000,0x00000000ffbe1f58,0x00000000ffc00000)
        PSPermGen       total 10240K, used 3097K [0x00000000fc400000, 0x00000000fce00000, 0x00000000fce00000)
        object space 10240K, 30% used [0x00000000fc400000,0x00000000fc706510,0x00000000fce00000)
*/

//1.8
//
/*Heap
        PSYoungGen      total 3072K, used 1073K [0x00000000ffc00000, 0x0000000100000000, 0x0000000100000000)
        eden space 2048K, 52% used [0x00000000ffc00000,0x00000000ffd0c6c0,0x00000000ffe00000)
        from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
        to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
        ParOldGen       total 47104K, used 47069K [0x00000000fce00000, 0x00000000ffc00000, 0x00000000ffc00000)
        object space 47104K, 99% used [0x00000000fce00000,0x00000000ffbf7768,0x00000000ffc00000)
        Metaspace       used 3375K, capacity 4556K, committed 4864K, reserved 1056768K
class space    used 358K, capacity 392K, committed 512K, reserved 1048576K*/
//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
//Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0


public class ConstantPoolOOM {

    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        int i=0;
        while(true){
            System.out.println(i++);
            list.add(String.valueOf(i).intern());
        }
    }

}
