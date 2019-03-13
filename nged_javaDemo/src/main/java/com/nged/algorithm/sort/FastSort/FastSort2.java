package com.nged.algorithm.sort.FastSort;

/**
 * @author: Administrator
 * @Date: 2019/3/7 15:06
 * @Description: 前后指针快速排序
 */
public class FastSort2 {
    public  static int count =1;
    public static void print(int[] array){
        System.out.print("第"+ count++ +"步 :");
        for(int v=0;v<array.length;v++){
            System.out.print(array[v]+" ");
        }
        System.out.println();
    }
    /**
     * 前后指针，遍历指针，已排序指针，基准值（最后一个值）。遍历指针寻找小于基准的值，找到跟已排序指针位置交换（已排序+1），当遍历指针到达基准前一个位置，本轮结束
     * 基准值跟已排序指针位置交换。
     * @param array
     * @param left
     * @param right
     */
    public static int sort(int[] array,int left,int right){

        //选取最左作为基准
        int key =left ;
        //基准的下一项作为已排序
        int pre = key+1;
        int cur = pre;
        while(cur<=right){
            if(array[cur]<array[key] ){
               swap(array,pre,cur);
                ++pre;
            }
            ++cur;
        }
        swap(array,key,--pre);
        return pre ;
    }
    public static void swap(int[] array,int i ,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        print(array);
    }

    public static void QuitSort(int[] array,int start,int end){
        if(start>=end){
            return;
        }
        int mid = sort(array,start,end);
        QuitSort(array,start,mid-1);
        QuitSort(array,mid+1,end);
    }
    public static void main(String[] args){
        int[] array = {9,8,10,4,7,2,5};
        QuitSort(array,0,array.length-1);
    }
}
