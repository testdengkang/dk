package com.nged.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 该demo用来练习使用CompletableFuture 任务间的编排
 */
public class FutureDemo {


    private final static int SLEEP_A =3000;
    private final static int SLEEP_B = 2000;
    private final static int SLEEP_C = 1000;
    private final static int SLEEP_D = 1000;
    private final static int SLEEP_E = 1000;
    private final static int SLEEP_F = 1000;

    private static void taskA(){
        ThreadUtils.work("task A",SLEEP_A);
    }

    private static void taskC(){
        ThreadUtils.work("task C",SLEEP_C);
    }

    private static void taskB(){
        ThreadUtils.work("task B",SLEEP_B);
    }

    private static void taskD(){
        ThreadUtils.work("task D",SLEEP_D);
    }

    private static void taskE(){
        ThreadUtils.work("task E",SLEEP_E);
    }

    private static void taskF(){
        ThreadUtils.work("task F",SLEEP_F);
    }
    private static void taskG(){
        ThreadUtils.work("task G",1000);
    }

    private static void taskH(){
        ThreadUtils.work("task H",1000);
    }

    //执行A后并行执行B，C
    public static void demo1() throws ExecutionException, InterruptedException {

        CompletableFuture.runAsync(FutureDemo::taskA).get();

        CompletableFuture<Void> futureC = CompletableFuture.runAsync(FutureDemo::taskC);

        CompletableFuture<Void> futureB = CompletableFuture.runAsync(FutureDemo::taskB);

        CompletableFuture.allOf(futureC,futureB).get();

    }
    //ABC串行
    public static void demo2(){
        CompletableFuture.runAsync(FutureDemo::taskA).thenRunAsync(FutureDemo::taskB).thenRunAsync(FutureDemo::taskC);
    }

    //ABC 并行
    private static void demo3() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> futureA = CompletableFuture.runAsync(FutureDemo::taskA);

        CompletableFuture<Void> futureC = CompletableFuture.runAsync(FutureDemo::taskC);

        CompletableFuture<Void> futureB = CompletableFuture.runAsync(FutureDemo::taskB);

        CompletableFuture.allOf(futureA,futureC,futureB).get();
    }

    //AB并行，在执行C
    private static void demo4() throws ExecutionException, InterruptedException {

        CompletableFuture<Void> futureA = CompletableFuture.runAsync(FutureDemo::taskA);

        CompletableFuture<Void> futureB = CompletableFuture.runAsync(FutureDemo::taskB);

        CompletableFuture.allOf(futureA,futureB).get();

        CompletableFuture<Void> futureC = CompletableFuture.runAsync(FutureDemo::taskC);

        futureC.get();
    }


    //AB并行，任意一个执行完就执行C
    private static void demo5() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> futureA = CompletableFuture.runAsync(FutureDemo::taskA);

        CompletableFuture<Void> futureB = CompletableFuture.runAsync(FutureDemo::taskB);

        CompletableFuture.anyOf(futureA,futureB).get();

        CompletableFuture<Void> futureC = CompletableFuture.runAsync(FutureDemo::taskC);

        futureC.get();
    }

    //A执行 （B->C）(D->E)并行，执行F
    private static void demo6() throws ExecutionException, InterruptedException {
        CompletableFuture.runAsync(FutureDemo::taskA).get();

        CompletableFuture<Void> futureBC = CompletableFuture.runAsync(FutureDemo::taskB).thenRunAsync(FutureDemo::taskC);

        CompletableFuture<Void> futureDE = CompletableFuture.runAsync(FutureDemo::taskD).thenRunAsync(FutureDemo::taskE);

        CompletableFuture.allOf(futureBC,futureDE).get();

        CompletableFuture.runAsync(FutureDemo::taskF).get();
    }

    //任务一 执行A后 BC并行，执行F
    //任务二 D，E，G 串行
    //任务一和二 执行完执行H
    private static void demo7() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> taskOne = CompletableFuture.runAsync(FutureDemo::taskOne);
        CompletableFuture<Void> taskTwo = CompletableFuture.runAsync(FutureDemo::taskTwo);

        CompletableFuture.allOf(taskOne,taskTwo).get();

        CompletableFuture.runAsync(FutureDemo::taskH).get();


    }

    private static void taskOne()  {
        try{
            CompletableFuture.runAsync(FutureDemo::taskA).get();

            CompletableFuture<Void> futureB = CompletableFuture.runAsync(FutureDemo::taskB);

            CompletableFuture<Void> futureC = CompletableFuture.runAsync(FutureDemo::taskC);

            CompletableFuture.allOf(futureB,futureC).get();

            CompletableFuture.runAsync(FutureDemo::taskF).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static void taskTwo() {
        try{
            CompletableFuture.runAsync(FutureDemo::taskD)
                    .thenRunAsync(FutureDemo::taskE)
                    .thenRunAsync(FutureDemo::taskG).get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        demo7();
//      int JOIN_TIME = SLEEP_A+SLEEP_B+SLEEP_C+1000;
//      int JOIN_TIME = SLEEP_A+SLEEP_B+SLEEP_C+SLEEP_D+SLEEP_E+SLEEP_F+1000;
        int JOIN_TIME = SLEEP_A+SLEEP_B+SLEEP_C+SLEEP_D+SLEEP_E+SLEEP_F+3000;
        Thread.currentThread().join(JOIN_TIME);

    }

}
