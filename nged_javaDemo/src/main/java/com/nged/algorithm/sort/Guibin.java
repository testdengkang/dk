package com.nged.algorithm.sort;

import java.util.HashMap;

/**
 * @Auther: Administrator
 * @Date: 2018/11/15 15:18
 * @Description: 归并算法
 */
public class Guibin {

    public static void main(String[] args){
       /* int[] array = new int[]{10,5,3};
        int length = array.length;
        int mid = length/2-1;
        int[] temp = new int[length];
        mergeSort(array,0,array.length-1,temp);
        for(int i:array){
            System.out.println(i);
        }*/
        HashMap<String,String> map = new HashMap<>(2);
        map.put("1","1");
        map.put("2","2");

    }

    /**
     * 将数组分解到只有一个的时候 可视为有序数组 在合并
     * @param nums
     * @param first
     * @param last
     * @param temp
     */
    public static void mergeSort(int[] nums,int first,int last,int[] temp){
        if(first<last){
            int mid = (first+last)/2;
            mergeSort(nums,first,mid,temp);
            mergeSort(nums,mid+1,last,temp);
            merge(nums,first,mid,last,temp);
        }

    }

    /**
     * 对两个有序数组 合并，并且合并后有序
     * @param nums
     * @param first
     * @param mid
     * @param last
     * @param temp
     */
    public static void merge(int[] nums,int first,int mid,int last,int[] temp){
        int i= first,j=mid;//左侧部分数组下标
        int m=mid+1,n=last;//右侧部分数组下标
        int k=0;
        while(i<=j && m<=n){
            if(nums[i]<nums[m]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[m++];
            }
        }
        while(i<=j){
            temp[k++] = nums[i++];
        }
        while(m<=n){
            temp[k++] = nums[m++];
        }

        for(int z=0;z<k;z++){
            nums[first+z] = temp[z];
        }
    }

}
