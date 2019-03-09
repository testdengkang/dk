package com.nged.algorithm.selectSort;

/**
 * @author: Administrator
 * @Date: 2019/3/9 15:26
 * @Description: 堆排序
 */
public class HeapSort {
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        print(array);
    }
    public static void sort(int[] array){
        int heapLength = array.length;
        for(int i=0;i<array.length;i++){
            maxHeapSort(array,heapLength);
            //一次大/小顶堆形成后，交换堆顶和堆的最后一个元素
            swap(array,0,heapLength-1);

            heapLength--;
        }
    }


    public static void maxHeapSort(int[] array,int length){
        length -=1;
        boolean changed = false;
        //j 从最后一个有子节点的节点开始
        for(int j=length/2-1;j>=0;j--){
            int leftIndex = 2*j+1;
            int rightIndex = leftIndex+1;




            if(!(leftIndex<length && rightIndex<length )){
                return;
            }
            int index = rightIndex;
            if(array[leftIndex]>array[rightIndex]){
                index = leftIndex;
            }
            if(array[index]>array[j]){
                swap(array,index,j);
                changed = true;
            }


        }
        //如果发生交换，需要再循环，确保慢父节点 和左右子节点的大小关系，直至不在发生交换
        if(changed){
            maxHeapSort(array,length);
        }

    }

    public  static int count =1;
    public static void print(int[] array){
        System.out.print("第"+ count++ +"步 :");
        for(int v=0;v<array.length;v++){
            System.out.print(array[v]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] array =  {8,7,5,4,2,9,20,33};
        sort(array);

    }
}
