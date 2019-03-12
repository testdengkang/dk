package com.nged.algorithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Administrator
 * @Date: 2019/3/12 15:56
 * @Description: 桶排序
 * 设定n个桶  每个桶的区间范围 p=（max-min+1）/n
 * 将数据装入桶 num= (value-min)/p
 * 对每个桶 插入排序
 * 将排序后值赋予待排序数组
 */
public class BucketSort {

    public static void main(String[] args){
        int[] array = {1,1,2,3,5,3,7,4,4,2,100,32,66,93};
        bucketSort(array);
        for(int a:array){
            System.out.print(a+" ");
        }
    }
    public static int max(int[] array){
        int max=Integer.MIN_VALUE;
        for(int v:array){
           if(v>max){
               max = v;
           }
        }
        return max;

    }
    public static int min(int[] array){
        int min=Integer.MAX_VALUE;
        for(int v:array){
            if(v<min){
                min = v;
            }
        }
        return min;

    }

    public static void bucketSort(int[] array){
        int bucketSize =10;
        List<List<Integer>> bucketList = new ArrayList<>(bucketSize);
        //初始化
        for(int i=0;i<bucketSize;i++){
            bucketList.add(new ArrayList<Integer>());
        }
        int max = max(array);
        int min = min(array);
        int p = (max-min)/bucketSize+1;
        for(int n=0;n<array.length;n++){
           int index = (array[n]-min)/p ;
           //将待排序数据装入桶
            bucketList.get(index).add(array[n]);
        }
        int count=0;
        List<Integer> bucket = null;
        //对每个桶进行插入排序
        for(int j=0;j<bucketSize;j++){
            bucket = bucketList.get(j);
            insertSort(bucket);
            for(int k:bucket){
                array[count++] = k;
            }
        }


    }

    public static void insertSort(List<Integer> list){

        int pLen =0;
        //从第二个开始
        int i=1;

        while(i<=list.size()-1){
            int j=0;
            while (j<=pLen){
                if(list.get(i)<list.get(j)){
                    int temp = list.get(j);
                    list.set(j,list.get(i));
                    list.set(i,temp);
                }
                j++;
            }

            pLen++;
            i++;
        }
    }
}
