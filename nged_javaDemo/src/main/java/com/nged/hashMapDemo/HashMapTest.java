package com.nged.hashMapDemo;

import java.util.HashMap;
import java.util.LinkedList;

public class HashMapTest {
    public static void main(String[] args){
        HashMap<String,Integer> hashMap = new HashMap<>(32,0.75f);
        hashMap.put("1",1);
        hashMap.put("2",2);
        System.out.println(hashMap.size());

        System.out.println(4 & 31);
        getInitSize(9);
    }

    //获取 大于或等于 m 的 二的倍数值
    public static void getInitSize(int m){
        m = m-1;
        m = m | m>>>1;
        m = m | m>>>2;
        m = m | m>>>4;
        m = m | m>>>8;
        m |= m>>>16;
        m = m<0?1: m+1;
        System.out.println("m == " + m);
    }
}
