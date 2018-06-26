package com.nged.ThreadLocal;

public class ThreadLocalDemo {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void put(String value){
        threadLocal.set(value);
    }

    public static String get(){
        return  threadLocal.get();
    }

    public static void clear(){
        threadLocal.remove();
    }
}
