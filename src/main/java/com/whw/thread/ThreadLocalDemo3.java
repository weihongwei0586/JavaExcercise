package com.whw.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalDemo3 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
//            threadPool.submit(()->{
//                String date = new ThreadLocalDemo3().date(finalI);
//                System.out.println(date);
//            });
            new Thread(()->{
                String date = new ThreadLocalDemo3().date(finalI);
                System.out.println(date);
            }).start();
            Thread.sleep(100);
        }
    }

    public String date(int seconds){
        Date date = new Date(seconds * 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        return dateFormat.format(date);

    }
}
