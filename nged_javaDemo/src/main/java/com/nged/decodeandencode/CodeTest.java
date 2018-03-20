package com.nged.decodeandencode;

import java.io.*;

/**
 * 编码 解码
 * 首先搞清几个概念 位bit 字节byte 字符 char
 * bit是计算机中表示数据的最小单位
 * byte是计算机中存储信息的最小单位 1byte=1B=1Byte=8bit
 *
 * 1个字节有8bit 只能表示0-255个字符 无法满足人类文字的需要
 * 将人类语言（不同语种）转换成计算机识别的语言传输，再把数据解析人类的不同语言 就要通过--编码格式
 *
 *常见编码格式
 * ASCII 码总共有 128 个 美国标准解决英语系的表示。
 * ISO-8859-1是在ASCII 码基础上扩展添加西欧字符
 *汉字编码格式  双字节编码 GB2312 GBK
 *  UTF 必须要提到 Unicode（Universal Code 统一码），ISO 试图想创建一个全新的超语言字典，世界上所有的语言都可以通过这本字典来相互翻译。
 *  UTF-16 用两个字节来表示 Unicode 转化格式，这个是定长的表示方法，不论什么字符都可以用两个字节表示，两个字节是 16 个 bit，所以叫 UTF-16。（浪费存储空间，增大网络传输流量）
 *  UTF-8 采用了一种变长技术，每个编码区域有不同的字码长度。不同类型的字符可以是由 1~6 个字节组成
 *
 *  在字符转换为字节 或者 字节转换为字符 需要使用编码
 *
 */
public class CodeTest {

   public static void main (String[] agrs) throws IOException {
       String filePath ="F:/test.txt";
       String charset="UTF-8";
       //写入中文
       FileOutputStream fileOutputStream = new FileOutputStream(filePath);
       OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream,charset);
       try {
           writer.write("保存中文字符！");
       } catch (IOException e) {
           writer.close();
           e.printStackTrace();
       }finally {
           writer.close();
       }
       //读取中文
       FileInputStream inputStream = new FileInputStream(filePath);
       InputStreamReader reader = new InputStreamReader(inputStream,charset);
       StringBuffer buffer = new StringBuffer();
       char[] buf = new char[2];
       int count=0;
       try {
           while ((count = reader.read(buf)) != -1) {
               buffer.append(buf, 0, count);
               System.out.println("读到数据 "+buf.toString());
           }
       }finally {
           reader.close();
       }
   }
}
