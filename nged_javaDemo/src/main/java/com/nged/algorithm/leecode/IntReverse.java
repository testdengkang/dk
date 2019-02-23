package com.nged.algorithm.leecode;

/**
 * @Auther: Administrator
 * @Date: 2019/2/23 11:25
 * @Description:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 */
public class IntReverse {
    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        int i = 11;

        String s = i+"";
        String newStr ="";
        if(s.contains("-")){
            for(int j=s.length()-1;j>0;j--){
                newStr+=s.charAt(j);
            }

            System.out.println(-Integer.parseInt(newStr));
        }else{
            for(int j=s.length()-1;j>=0;j--){
                newStr+=s.charAt(j);
            }
            System.out.println(Integer.parseInt(newStr));
        }



    }
}
