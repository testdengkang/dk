package com.nged.threadpool;

import java.util.concurrent.*;

/**
 * 测试 jdk自带不同类型线程池
 */
public class ThreadPoolDemo implements Runnable{
    private int name =0;
    public ThreadPoolDemo(int name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId()+"  name:"+name);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //拒接策略
     static class rj implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(executor.getActiveCount()+ "在工作 "+((ThreadPoolDemo)r).name+" 被抛弃");
        }
    }

    public static void main(String[] args){
        //等待队列 SynchronousQueue<Runnable>() 直接提交
        //有界队列 ArrayBlockingQueue
        //无界队列  LinkedBlockingQueue<Runnable>() 可以设置大小
        //只有一个线程处理任务   存储队列最大可达Integer.MAX_VALUE
        //Executors.newSingleThreadExecutor(); new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>())
        //最多可建Integer.MAX_VALUE 个线程 没有等待队列
        //Executors.newCachedThreadPool(); new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,  new SynchronousQueue<Runnable>())
        //固定大小
        //Executors.newFixedThreadPool(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,2,5, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(),new rj()){
            //
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行："+((ThreadPoolDemo)r).name);
            }
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成："+((ThreadPoolDemo)r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程退出");
            }
        };
        for(int i=1;i<Integer.MAX_VALUE;i++){
            executor.execute(new ThreadPoolDemo(i));
        }

    }
}
