package com.nged.algorithm;

/**
 * @author: Administrator
 * @Date: 2019/3/6 16:36
 * @Description:选择排序（未排序队列中最大/小的值放到已排序队列的末尾）
 */
public class SelectSort {
    /**
     * 升序排序
     * @param array
     */
    public static void sort(int[] array){
        for(int i=0;i<array.length;i++){

            int minIndex=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;

                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args){
        int[] array = {2,3,4,7,6,1,80,33};
        sort(array);
        for(int value:array){
            System.out.println(value);
        }
    }
}
