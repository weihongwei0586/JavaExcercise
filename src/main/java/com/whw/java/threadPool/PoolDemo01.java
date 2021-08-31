package com.whw.java.threadPool;

import java.util.concurrent.*;

/**
 * Java线程相关知识
 *  线程池的创建方式有两种
 *     Excecutor.创建；
 *     ThreadPoolExecutor
 *  线程池的几种工作队列
 *      LinkedBlockQueue
 *      ArrayBlockQueue
 *      SynchronousQueue
 *      PriorityBlockingQueue
 *
 *
 */
public class PoolDemo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        LinkedBlockingQueue<Runnable> ls = new LinkedBlockingQueue<>(9);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,5,1, TimeUnit.SECONDS,
//        ls,
//        Executors.defaultThreadFactory(),
//        new ThreadPoolExecutor.AbortPolicy());
//        ExecutorService executor = Executors.newFixedThreadPool(5);
//        ExecutorService executor = Executors.newCachedThreadPool()
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
//        Future<?> fuck_you_bitch = service.submit(() -> {
//            System.out.println("Fuck you bitch");
//            return 4;
//        });
//        System.out.println(fuck_you_bitch.get());
//        service.shutdown();

//        for (int i = 0; i < 10; i++) {
//            executor.execute(()->{
//                System.out.println(Thread.currentThread().getName() + ">>>");
//            });
//        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                1,
                5,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2),
                new ThreadPoolExecutor.CallerRunsPolicy()
                );
        try{
            for (int i = 0; i < 10; i++) {
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName() + " OK");
                    System.out.println(Thread.activeCount());
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            executor.shutdown();
        }





    }
}
