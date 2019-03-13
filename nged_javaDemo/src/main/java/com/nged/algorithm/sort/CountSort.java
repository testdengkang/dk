package com.nged.algorithm.sort;



import java.util.Arrays;

/**
 * @author: Administrator
 * @Date: 2019/3/12 12:10
 * @Description: 计数排序 计数数组的长度为待排序数组的中的最大值，计数数组下标+1 = 待排序数组的value
 * 计数数组的值 为 待排序数组的value的计数。
 */
public class CountSort {
    public static void main(String[] args){
        int[] array = {1,1,2,3,5,3,7,4,4,2,100,32,66,93};
        int len = max(array);
        //分配计数数组
        int[] temp = new int[len];
        Arrays.fill(temp,0);
        //遍历统计计数
        for(int v:array){
            temp[v-1]++;
        }
        //按照规则给待排序数组 赋值排序后的值
        int k=0;
        for(int i=0;i<temp.length;i++){
            for(int j =0 ;j<temp[i];j++){
                array[k++] = i+1;

            }
        }
        for(int z:array){
            System.out.print(z+" ");
        }
    }
    public static int max(int[] array){
        if(array==null||array.length==0){
            return 0;
        }
        int max =0;
        for(int v :array){
            if(v>max){
                max = v;
            }
        }

        return max;
    }
}
