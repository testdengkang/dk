package com.nged.algorithm;

/**
 * @author: Administrator
 * @Date: 2019/3/12 11:09
 * @Description:归并算法
 */
public class MergeSort {

    public static void main(String[] args){
        int[] array =  {2,3,4,7,6,1,80,33};
        mSort(array,0,array.length-1);
        for(int v=0;v<array.length;v++){
            System.out.print(array[v]+" ");
        }

    }

    /**
     * 递归拆分
     * @param array
     * @param left
     * @param right
     */
    public static void mSort(int[] array,int left,int right){
        if(left>=right){
            return;
        }
        int mid = (right+left)/2;
        mSort(array,left,mid);
        mSort(array,mid+1,right);
        merge(array,left,mid,right);
    }

    /**
     * 归并
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] array,int left ,int mid,int right){
        //临时空间
        int[] tempArray = new int[right-left+1];
        //临时数组的下标
        int k=0;
        //归并的两个数组的a,b 下标开始指针
        int i=left,j=mid+1;

        while(i<=mid&&j<=right){
            if(array[i]<array[j]){
                tempArray[k++] = array[i++];
            }else{
                tempArray[k++] = array[j++];
            }
        }
        //处理a或b多出的部分
        while(i<=mid){
            tempArray[k++] = array[i++];
        }

        while(j<=right){
            tempArray[k++] = array[j++];
        }

        for(int p=0;p<tempArray.length;p++){
            array[left+p] = tempArray[p];
        }

    }
}
