package com.nged.ThreadLocal;

public class Threadd implements Runnable {

    private String key;


    public Threadd(String key){
        this.key = key;
    }

    @Override
    public void run() {
        while (true){

            ThreadLocalDemo.put(ThreadLocalDemo.get()+this.key);
            System.out.println(Thread.currentThread().getName() +"--" +ThreadLocalDemo.get());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
