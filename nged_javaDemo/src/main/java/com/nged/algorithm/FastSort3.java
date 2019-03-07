package com.nged.algorithm;

/**
 * @author: Administrator
 * @Date: 2019/3/7 16:27
 * @Description: 挖坑法
 */
public class FastSort3 {

    public  static int count =1;

    /**
     * 打印每一步交换
     * @param array
     */
    public static void print(int[] array){
        System.out.print("第"+ count++ +"步 :");
        for(int v=0;v<array.length;v++){
            System.out.print(array[v]+" ");
        }
        System.out.println();
    }
    /**
     * 挖坑法 选取一端最右侧为基准值，从基准的另一侧左侧开始寻找（i）小大于基准值的 ，基准值的坑位K0，新腾出来的坑为k1，从右侧寻找（j）大于基准值的 放入k1 腾出k2
     * 直至 i和j相遇，然后将基准值放入i。再对i两侧 分别循环。
     * @param array
     * @param left
     * @param right
     */
    public static int sort(int[] array,int left,int right){
        //选取最右侧为基准
        int keyValue = array[right];
        //记录空出的坑位
        int keyIndex = right;
        int i = left;
        int j = right;
        while(i<j){
            while(i<j){
                if(array[i]>keyValue){
                    swap(array,i,keyIndex);
                    //array[keyIndex] = array[i];
                    keyIndex = i;
                    break;
                }
                i++;
            }
            while (i<j){
                if(array[j]<keyValue){
                    swap(array,j,keyIndex);
                    //array[keyIndex] = array[j];
                    keyIndex = j;
                    break;
                }
                j--;
            }
        }
        array[keyIndex] = keyValue;
        print(array);
        return i;
    }
    public static void swap(int[] array,int i ,int j){
        array[j] = array[i];
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
