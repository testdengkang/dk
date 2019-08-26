package com.nged.algorithm;

/**
 * 一到n，求出 1 到n 中 连续相加之和等于n的所有组合，考虑时间复杂度
 * 例如：n=10 4+5+6  1+2+3+4+5
 * 一道 vivo面试算法
 */
public class Mst1 {

    public static void main(String[] args){
        int n=30;
        int len = n/2;
        for(int i=2;i<len;i++){
            //下面条件的来源 ： 平均值 = n/i；  连续数左右半径= (i-1)/2； (n/i)>( (i-1)/2 ),否者左边越界了
            if(i*i-i>=2*n){
                System.out.println("连续"+i+"不可能再有了");
                break;
            }else{
                //System.out.println("i="+i);
                int midIndex = n/i;
                int halfSize =(i-1)/2;
                if((i-1)%2==0){
                    int  count = i*midIndex;
                    if(count==n){
                        System.out.println("找到了"+midIndex +"向左向右各"+halfSize);
                        continue;
                    }else if(count>n){
                        if(i*(midIndex-1)==n){
                            System.out.println("找到了"+midIndex +"向左向右各"+halfSize);
                            continue;
                        }
                    }else{
                        if(i*(midIndex+1)==n){
                            System.out.println("找到了"+midIndex +"向左向右各"+halfSize);
                            continue;
                        }
                    }


                }else{
                    int leftsize = (i-2)/2;
                    int count = i*midIndex-(leftsize+1);
                    if(count==n){
                        System.out.println("找到了"+midIndex +"左："+(leftsize+1)+" 右"+leftsize);
                        continue;
                    }else if(count<n){
                        count = i*(midIndex+1)+leftsize+1;
                         if(count==n){
                             System.out.println("找到了"+(midIndex+1) +"左："+(leftsize+1)+" 右"+leftsize);
                             continue;
                         }

                    }else{
                        count = i*(midIndex-1)+leftsize+1;
                        if(count==n){
                            System.out.println("找到了"+(midIndex-1) +"左："+(leftsize+1)+" 右"+leftsize);
                            continue;
                        }
                    }
                    count = i*midIndex+leftsize+1;
                    if(count==n){
                        System.out.println("找到了"+midIndex +"左："+leftsize+" 右"+(leftsize+1));
                        continue;
                    }else if(count<n){
                        count = i*(midIndex+1)+leftsize+1;
                        if(count==n){
                            System.out.println("找到了"+(midIndex+1) +"左："+leftsize+" 右"+(leftsize+1));
                            continue;
                        }

                    }else{
                        count = i*(midIndex-1)+leftsize+1;
                        if(count==n){
                            System.out.println("找到了"+(midIndex-1) +"左："+leftsize+" 右"+(leftsize+1));
                            continue;
                        }
                    }
                }


            }


        }

    }

}
