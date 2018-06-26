package com.nged.ThreadLocal;

public class TestDemo {


    public static void main(String[] args){
      //  Thread[] threads = new Thread[10];
        for(int i=0;i<3;i++){
            Threadd t =  new Threadd(i+"key");
            new Thread(t).start();
        }


    }
}
