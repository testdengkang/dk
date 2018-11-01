package com.nged.sort;

import java.util.*;

/**
 * @Auther: Administrator
 * @Date: 2018/11/1 15:44
 * @Description:广度优先搜索 针对单向非加权图 计算两点间 1是否可达 2最短距离
 */
public class BreadthFirstSearch {


    public static void main(String[] args){
        HashMap<String,String[]> map = new HashMap<>();
        map.put("you",new String[]{"a","b"});
        map.put("a",new String[]{"c"});
        map.put("b",new String[]{"d","e"});
        map.put("c",new String[]{"e"});
        map.put("d",null);
        map.put("e",new String[]{"f"});
        map.put("f",null);
        HashMap<String,String> rollbackMap = new HashMap<>();

        List<ArrayDeque<String>> list = new ArrayList<>();

        ArrayDeque<String> deque = new ArrayDeque<>() ;
        deque.add("you");

        while (!deque.isEmpty()){
            String header = deque.pop();
            System.out.println(header);

            String[] array = map.get(header);
            if(array!=null&& array.length>0){
                for(String s :array){
                    deque.add(s);
                }
            }

            if(!check(header)){


            }else{
                System.out.println("find e!");

            }
        }

    }
    public static boolean check(String temp){
        return temp.equals("e");
    }
}
