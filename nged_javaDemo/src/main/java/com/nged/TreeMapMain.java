package com.nged;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapMain {

    public  static void main(String[] args){
        TreeMap<Integer,String> tm = new TreeMap<Integer, String>();
        tm.put(1,"1");
        tm.put(3,"3");
        tm.put(2,"2");
        for(Map.Entry<Integer,String> entry :tm.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap<String,String>();
    }

}
