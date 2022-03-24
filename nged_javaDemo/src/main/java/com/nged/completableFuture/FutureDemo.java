package com.nged.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 该demo用来练习使用CompletableFuture 任务间的编排
 */
public class FutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        demo1();
        Thread.currentThread().join(20000);

    }

    //执行A后并行执行B，C
    public static void demo1() throws ExecutionException, InterruptedException {
        TaskContext context = new TaskContext();
        CountTask countTask = new CountTask();

        CompletableFuture.supplyAsync(
                ()-> {

                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("run A");

                    return "1111";
                }).get();

        CompletableFuture<Void> futureC = CompletableFuture.runAsync(
                ()-> {

                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("run C");
                });

        CompletableFuture<Void> futureB = CompletableFuture.runAsync(
                ()-> {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("run B");
                });
        CompletableFuture.allOf(futureC,futureB).get();




    }
}
