package com.nged.algorithm;

/**
 * @Auther: Administrator
 * @Date: 2018/11/15 14:26
 * @Description: 二分查找
 * 二分法针对有序数组
 */
public class DichotomySearch {

    public static void main(String[] args){
        int[] searchArray = new int[]{1,3,5,6,9};
        System.out.println(search(searchArray,0,searchArray.length-1,4));
        System.out.println(searchRecursive(searchArray,0,searchArray.length-1,5));
    }

    public static int search(int[] nums,int low,int high,int value){
        while (true){
            int mid = low+(high-low)/2;
             if(low<=high){
                 if(nums[mid]==value){
                     return mid;
                 }else if(nums[mid]<value){
                     low = mid+1;
                 }else{
                     high = mid-1;
                 }

            }else{
                 return -1;
             }
        }
    }

    public static int searchRecursive(int[] nums,int low,int high,int value){
        if(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==value){
                return mid;
            }else if(nums[mid]>value){
                return searchRecursive(nums,low,mid-1,value);
            }else{
                return searchRecursive(nums,mid+1,high,value);
            }
        }
        return -1;
    }

}
