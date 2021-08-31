package com.whw.multithread;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadTest {
    /**
     * 循环10次：
     *      线程AA -> 5次
     *      线程BB -> 6次
     *      线程CC -> 7次
     */
    @Test
    public void test(){

    }
    /**
     * 线程池的相关知识点
     * 1. 使用类Excutors中的工厂方法来快速创建线程池
     */
    @Test
    public void test2(){
        /**
         * 创建固定大小的线程池，大小为2
         * 弊端：等待队列的长度是Integer.MaxValue。
         * 这样可能导致队列上堆积大量的请求，最终OOM
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        /**
         *
         * 创建大小为1的单线程线程池
         * 弊端，等待队列长度是Integer.MAXVALUE
         * 这样可能会导致队列上堆积大量请求，最终OOM
         */
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        /**
         * 创建容量可以*自行调整线程数*的线程池(如何做到自行调整的？因为newCachedThreadPool使用是同步阻塞队列，这个同步队列始终是空的。
         * 这个同步阻塞队列每次插入操作都必须等到另外一个线程调用移除操作)
         * 适合处理大量的短命异步任务
         * 弊端，允许创建的最大线程数是Integer.MAXVALUE
         * 这样可能导致创建大量的线程，最终OOM
         */
        ExecutorService executorService2 = Executors.newCachedThreadPool();



        executorService.shutdown();
    }

    /**
     * 线程池相关知识点
     * 2.使用ThreadPoolExecutor类来创建。
     *
     */
    @Test
    public void test3() throws InterruptedException {
        /**
         * 线程池ThreadPoolExecutor的7大参数
         * 1.corePoolSize 核心线程数
         * 2.maximumPoolSize 最大线程数
         * 3.KeepAliveTime 非核心线程的最大存活时间
         * 4.TimeUnit 时间的单位
         * 5.workQueue 等待队列 有4种阻塞队列 ArrayBlockingQueue LinkedBlockQueue SynchronizedQueue PriorityBlockingQueue
         * 6.<ThreadFactory> threadFactory
         * 7.<RejectedExecutionHandler>  handler 有4种拒绝策略：抛出异常，丢弃队列中最老的任务，使用调用者线程处理这个任务，直接丢弃新任务
         */

        /**
         * 等待队列
         */
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>(3);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,15,30, TimeUnit.SECONDS,queue,new ThreadPoolExecutor.AbortPolicy());


        /**
         * 默认情况下，线程池中是没有线程的。要等待任务到来的时候才创建线程。
         * 预先创建线程，避免第一次调用运行缓慢。
         *
         */
        System.out.println(threadPoolExecutor.getCorePoolSize());
        System.out.println(threadPoolExecutor.getActiveCount());
        int i = threadPoolExecutor.prestartAllCoreThreads();
        /**
         * 即使是空闲状态，核心线程一般也不会被销毁.
         * 可以设置核心线程超时销毁，超时时间就是keepAliveTime
         */
        threadPoolExecutor.allowCoreThreadTimeOut(true);


        boolean b = threadPoolExecutor.prestartCoreThread();
        System.out.println(i);
        System.out.println(threadPoolExecutor.getActiveCount());
        /**
         * 当线程池已经达到最大线程数，并且阻塞队列已经满了。
         * 必须采取一种策略处理提交的新任务。
         * 1. 直接抛出异常
         * 2. 使用调用者所在的线程处理任务
         * 3. 丢弃等待队列中的最老的任务
         * 4. 直接丢弃这个新任务
         */
        ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        ThreadPoolExecutor.DiscardPolicy discardPolicy = new ThreadPoolExecutor.DiscardPolicy();

        /**
         *
         */
        threadPoolExecutor.shutdown();
    }

    /**
     * AQS:AbstractQueuedSynchronizer抽象的队列同步器
     */
    @Test
    public void test4(){
        ReentrantLock reentrantLock = new ReentrantLock();
        int i = 10;
        CountDownLatch countDownLatch = new CountDownLatch(i);

    }

    @Test
    public void test5(){
        /**
         * 1.创建资源类，定义资源类的属性和操作方法
         * 2.创建多个线程，调用方法
         *
         */

        Tickets tickets = new Tickets();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 120; i++) {
                    tickets.sale();
                }
            }
        },"Thread-1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 120; i++) {
                    tickets.sale();
                }
            }
        },"Thread-2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 120; i++) {
                    tickets.sale();
                }
            }
        },"Thread-3").start();

    }


}



class Tickets{

    private int nums = 100;

    public void sale(){
        if(nums > 0){
            nums--;
            System.out.println("当前线程是:"+Thread.currentThread().getName()+"还剩下"+nums+"张票");
        }
    }
}
