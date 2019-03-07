package com.nged.algorithm;

/**
 * @Auther: Administrator
 * @Date: 2019/3/6 10:00
 * @Description:快速排序 左右指针法
 *
 *
 */
public class FastSort {
    public  static int count =1;
    public static void print(int[] array){
        System.out.print("第"+ count++ +"步 :");
        for(int v=0;v<array.length;v++){
            System.out.print(array[v]+" ");
        }
        System.out.println();
    }
    /**
     * 左右指针选取一个基准值，一轮排序下来队列一测都为小于基准 另一侧都为大于基准，将基准值调换到中间，然后对左右在循环
     * 每次只能确定基准值的位置
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static int sort(int[] array,int left,int right){
        int start = left;
        int end = right;
        //基准值下标 以最右侧为基准 指针需end先开始 反之 以最左侧为基准 指针start先开始
        int key = right;

        while(start<end){

            while (start<end && array[start]<=array[key]){
                start++;
            }
            while (start<end && array[end] >=array[key]){
                end--;
            }
            swap(array,start,end);
        }
        swap(array,start,key);

        return start;
    }

    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        print(array);
    }
    public static void quickSort(int[] array,int start,int end){
        //中止条件为 长度为1
        if(start>=end){
            return;
        }
        int mid = sort(array,start,end);
        quickSort(array,start,mid-1);
        quickSort(array,mid+1,end);
    }
    public static void main(String[] args){
        int[] array = {9,8,10,4,7,2,5};
        quickSort(array,0,array.length-1);

    }
}
