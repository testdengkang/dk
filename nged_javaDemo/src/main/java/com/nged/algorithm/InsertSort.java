package com.nged.algorithm;

/**
 * @author: Administrator
 * @Date: 2019/3/7 17:50
 * @Description: 插入排序，依次从未排序队列中取出一个元素，在已排序队列中比较调换，直到放入合适的位置
 */
public class InsertSort {
    public  static int count =1;
    public static void print(int[] array){
        System.out.print("第"+ count++ +"步 :");
        for(int v=0;v<array.length;v++){
            System.out.print(array[v]+" ");
        }
        System.out.println();
    }

    public static void swap(int[] array,int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static void main(String[] args){
        int[] array = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        //已排序队列 最长下界 初始化 0
        int pLen =0;
        //从第二个开始
        int i=1;

       while(i<=array.length-1){
           int j=0;
            while (j<=pLen){
                if(array[i]<array[j]){
                    swap(array,i,j);
                }
                j++;
            }
            print(array);
            pLen++;
            i++;
        }
    }

}
