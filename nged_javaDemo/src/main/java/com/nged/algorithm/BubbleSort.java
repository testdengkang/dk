package com.nged.algorithm;

/**
 * @author: Administrator
 * @Date: 2019/3/6 17:10
 * @Description:冒泡排序
 * array[n] 最多进行n-1趟 ；
 * 第x趟的时候 未排序长度为n-x 已排序长度x；
 * 相邻间按照顺序进行调换
 * 中止条件为 上一趟没有发生交换说明已经全部有序
 */
public class BubbleSort {
    public static void sort(int[] array){
        int len = array.length;
        boolean flag ;
        do{
            flag = false;
            //控制趟数
            len -=1;
            for(int i=0;i<len;i++){
                if(array[i]>array[i+1]){
                    int temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                    //当一趟下来没有发生交换 说明已经是有序
                    flag = true;
                }
            }


        }while (flag);

    }
    public static void main(String[] args){
        int[] array = {2,3,4,7,6,1,80,33};
        sort(array);
        for(int value:array){
            System.out.println(value);
        }
    }
}
