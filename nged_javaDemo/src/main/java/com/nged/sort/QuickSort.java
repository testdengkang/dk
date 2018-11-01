package com.nged.sort;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/1 10:41
 * @Description:快速排序
 */
public class QuickSort {

    public static String sort(String str){
        String[] arr = str.split(",");
        if(arr==null){
            return null;
        }
        if(arr.length<2){
            return str;
        }
        int tempIndex = arr.length/2-1;
        String temp = arr[tempIndex];
        String bigArray ="" ;
        String smallArray ="";
        for(int i=0;i<arr.length;i++){
            if(i!=tempIndex){
                if(Integer.parseInt(arr[i])> Integer.parseInt(temp)){
                    if(bigArray.equals("")){
                        bigArray += arr[i];
                    }else{
                        bigArray += ","+arr[i];
                    }


                }else if(Integer.parseInt(arr[i])<Integer.parseInt(temp)){
                    if(smallArray.equals("")){
                        smallArray += arr[i];
                    }else{
                        smallArray += ","+arr[i];
                    }
                }
            }

        }
        System.out.println(smallArray + "-"+temp+"-"+bigArray);
        return sort(smallArray)+","+temp+","+sort(bigArray);
    }

    public static void main(String[] args){
       String str = "4,6,3,5,2,1,9,11,22,32,322,2233";
       System.out.println(sort(str));

    }
}
