package com.nged.algorithm.sort.insertSort;

/**
 * @author: Administrator
 * @Date: 2019/3/8 10:26
 * @Description: 希尔排序 直接插入排序的升级版，希尔排序将数据量大的数组，按len=len/2拆分len个分组
 * 通过将数据按步长分组len=len/2，然后将每组按照直接插入排序，不断缩小步长 直到步长为1，最后完成排序;
 *
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
 * 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
 * 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位
 */
public class ShellSort {
    public static void main(String[] args){
        int[] array = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        sort(array);
    }

    public static void sort(int[] array){
        //步长
        int bc = array.length/2;
        int temp ;
        int j;
        while(bc>=1){
            //从bc开始即从每个(1..bc)分组的第二项开始 进行直接插入排序
            System.out.println("步长为"+bc);
            for(int i = bc;i<array.length;i++){
                temp = array[i];
                j = i-bc;
                while(j>=0 && array[j]>temp){
                    swap(array,j,j+bc);
                    j-=bc;
                }
                array[j+bc] = temp;
                print(array);
            }

            bc = bc /2;
        }

    }

    public static void swap(int[] array,int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        print(array);
    }

    public  static int count =1;
    public static void print(int[] array){
        System.out.print("第"+ count++ +"步 :");
        for(int v=0;v<array.length;v++){
            System.out.print(array[v]+" ");
        }
        System.out.println();
    }
}
