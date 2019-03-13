package com.nged.algorithm.sort.leecode;

/**
 * @Auther: Administrator
 * @Date: 2019/2/23 10:10
 * @Description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 题目运行环境暗示 s=‘a’,输出a
 */
public class Symmetry {

    public static boolean checkSymmetry(String str){
        if(str==""){
            return false;
        }
        int len = str.length();

        if(len==1){
            return true;
        }
        int index = len/2;
        for(int i=0;i<index;i++){
            if(str.charAt(i)!=str.charAt(len-1-i)){
                return false;
            }
        }

        return true;

    }
    public static String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        int maxlen =0;
        String result ="";

        for(int j=1;j<=s.length();j++){

            for(int z=0;z<=s.length()-j;z++){

                String newStr = s.substring(z,z+j);
                if(checkSymmetry(newStr)){

                    if(newStr.length()>maxlen){
                        maxlen = newStr.length();
                        result = newStr;
                    }
                }
            }

        }
        return result;
    }
    public static void main(String[] args){
        String s ="bb";
        longestPalindrome(s);



    }
}
