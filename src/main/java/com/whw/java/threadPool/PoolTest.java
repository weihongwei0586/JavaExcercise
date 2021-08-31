package com.whw.java.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PoolTest {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//        TaskRunnable task = new TaskRunnable();
//
//        executorService.submit(task);
//        System.out.println("-----------");
//        executorService.submit(task);
//        executorService.shutdown();


        ExecutorService service = Executors.newFixedThreadPool(5);

        TaskCallable taskC = new TaskCallable();

        service.submit(taskC);
        service.submit(taskC);

        service.shutdown();


    }
}

class TaskRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("自定义线程正在执行" + i + Thread.currentThread().getName());
        }
    }
}

class TaskCallable implements Callable<Object>{

    @Override
    public Object call() throws Exception {

        for (int i = 0; i < 1000; i++) {
            System.out.println("自定义线程正在执行" + i + Thread.currentThread().getName());
        }
        return null;
    }
}